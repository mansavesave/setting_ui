package com.example.camerasettingui;

import java.util.ArrayList;
import java.util.List;

import com.example.camerasettingui.SetttingData.BaseItemInfo;
import com.example.camerasettingui.SetttingData.ItemType;
import com.example.camerasettingui.SetttingData.SettingList;
import com.example.camerasettingui.exist.AcerLog;
import com.example.camerasettingui.exist.CameraEnvironment;
import com.example.camerasettingui.exist.Util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.AdapterView;

public class SettingPage implements AdapterView.OnItemClickListener {
	public static String TAG = "wellsTest-SettingPage";
	static final int SETTING_TAB_HEIGHT_DP = 100;
	static final int SETTING_ITEM_HEIGHT_DP = 68;
	static final int SETTING_ITEM_FIRST_CATOGORY_HEIGHT_DP = 35;
	Activity mActivity;
	String mTabName;
	int mIcon;
	View mTabView;
	ListView mContentView;
	private ArrayList<BaseItemInfo> mItemList;

	public SettingPage(Activity activity, String tabName, int icon, ArrayList<BaseItemInfo> itemList) {
		mActivity = activity;
		setTabName(tabName);
		setIcon(icon);
		setBaseItemInfo(itemList);
	}

	public void setTabName(String name) {
		mTabName = name;
	}

	public String getTabName() {
		return mTabName;
	}

	public void setIcon(int icon) {
		mIcon = icon;
	}

	public int getIcon() {
		return mIcon;
	}

	public void setBaseItemInfo(ArrayList<BaseItemInfo> info) {
		mItemList = info;
	}

	public ArrayList<BaseItemInfo> getBaseItemInfo() {
		return mItemList;
	}

	public View getTabView() {
		if (mTabView == null) {
			View tab = LayoutInflater.from(mActivity).inflate(R.layout.camera_quickmenu_tabwidge_content, null);
			ImageView img = (ImageView) tab.findViewById(R.id.quick_menu_tab_img);
			img.setImageResource(getIcon());

			// highlight bar
			ImageView bar = (ImageView) tab.findViewById(R.id.quick_menu_tab_highlight);
			StateListDrawable barStatus = new StateListDrawable();
			barStatus.addState(new int[] { android.R.attr.state_selected },
					mActivity.getResources().getDrawable(R.drawable.img_menu_tab_selected));
			bar.setBackgroundDrawable(barStatus);

			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
					Util.dpToPixel(SETTING_TAB_HEIGHT_DP));
			params.weight = 1;
			tab.setLayoutParams(params);
			mTabView = tab;

			// ImageView tabView = new ImageView(mActivity);
			// tabView.setImageResource(getIcon());
			// mTabView = tabView;
		}
		return mTabView;
	}

	public View getContentView() {
		Log.d(TAG, "getContentView:" + mContentView);
		if (mContentView == null) {
			int cameraID = 0;
			String captureMode = CameraEnvironment.CAPTUREMODE_NORMAL;
			ListView listView = new ListView(mActivity);

			listView.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			listView.setAdapter(new SettingsAdapter(mActivity, mItemList, cameraID, captureMode));

			listView.setOnItemClickListener(this);
			mContentView = listView;
		}
		return mContentView;
	}

	private static class SettingsAdapter extends ArrayAdapter<BaseItemInfo> {
		private List<BaseItemInfo> mSettingItemMap = new ArrayList<BaseItemInfo>();

		private LayoutInflater mInflater;
		private Context mContext;
		private int mCameraID = 0;
		private String mCaptureMode = CameraEnvironment.CAPTUREMODE_NORMAL;
		private boolean mIsObjectTrackingOn = false;
		private boolean mIsNoiseReductionOn = false;
		// private int mIsCaptureIntent = 0;

		private static class ViewHolder {
			TextView title = null;
			TextView summary = null;
			TextView category = null;
			Switch switch_ = null;
		}

		public SettingsAdapter(Context context, List<BaseItemInfo> objects, int camera_id, String capture_mode) {
			super(context, 0, objects);
			mContext = context;
			mSettingItemMap = objects;
			mCameraID = camera_id;
			mCaptureMode = capture_mode;
			// mIsCaptureIntent = isCaptureIntent;
			// //Check model name is s3
			// if (Util.isS56S57() && mCameraID !=
			// CameraHolder.instance().getFrontCameraId()) {
			// setVideoNoiseReducation(((SwitchItem)
			// mSettingItemList.get(SettingList.NOISE_REDUCTION.ordinal()))
			// .getValue().equals("on"));
			// }
			mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		public void resetCaptureMode() {
			mCaptureMode = CameraEnvironment.CAPTUREMODE_NORMAL;
		}

		public void setObjectTracking(boolean object_track) {
			if (mCaptureMode.equals(CameraEnvironment.CAPTUREMODE_NORMAL)) {
				mIsObjectTrackingOn = object_track;
			} else {
				mIsObjectTrackingOn = false;
			}
			Log.d(TAG, " setObjectTracking = " + mIsObjectTrackingOn);
		}

		public void setVideoNoiseReducation(boolean value) {
			mIsNoiseReductionOn = value;
			Log.d(TAG, " setVideoNoiseReducation = " + mIsNoiseReductionOn);
		}

		public boolean checkItemIsEnable(int position) {

			// BaseItem item = getSettingItem(position);
			// int ID = item.getID();
			// if (ID == SettingList.CATEGORY_PHOTO.ordinal() || ID ==
			// SettingList.CATEGORY_VIDEO.ordinal()
			// || ID == SettingList.CATEGORY_OTHER.ordinal()) {
			// return false;
			// }
			// if (mIsCaptureIntent > 0) {
			// if (mIsCaptureIntent == 1) { // ImageCapture
			// if (ID == SettingList.FAVORITE_SHOT.ordinal() || ID ==
			// SettingList.VIDEO_RESOLUTION.ordinal()
			// || ID == SettingList.AUDIO_MODE.ordinal()) {
			// return false;
			// }
			// } else if (mIsCaptureIntent == 2) { // VideoCapture
			// if (ID == SettingList.RESOLUTION.ordinal() || ID ==
			// SettingList.ISO.ordinal()
			// || ID == SettingList.VIDEO_RESOLUTION.ordinal()
			// || ID == SettingList.FAVORITE_SHOT.ordinal()) {
			// return false;
			// }
			// }
			// }
			// if (mCameraID == CameraHolder.instance().getFrontCameraId()) {
			// if (ID == SettingList.FAVORITE_SHOT.ordinal() || ID ==
			// SettingList.CONITNUOUS_SHUTTER.ordinal()
			// || ID == SettingList.TOUCH_TO_CAPTURE.ordinal() || ID ==
			// SettingList.VIDEO_STABILIZER.ordinal()
			// || ID == SettingList.NOISE_REDUCTION.ordinal()) {
			// return false;
			// }
			// } else {
			// if ((ID == SettingList.VIDEO_RESOLUTION.ordinal() &&
			// mIsNoiseReductionOn)) {
			// return false;
			// }
			// if (ID == SettingList.RESOLUTION.ordinal()
			// && (mCaptureMode.equals(CameraEnvironment.CAPTUREMODE_PANORAMA)
			// || mCaptureMode.equals(CameraEnvironment.CAPTUREMODE_MAV))) {
			// return false;
			// }
			// }
			return true;
		}

		@SuppressWarnings("unused")
		private boolean checkSwitchIsEnable(int position) {
			// BaseItem item = getSettingItem(position);
			// int ID = item.getID();
			// if (mIsCaptureIntent > 0) {
			// if (mIsCaptureIntent == 1) { // ImageCapture
			// if (ID == SettingList.CONITNUOUS_SHUTTER.ordinal() || ID ==
			// SettingList.VIDEO_STABILIZER.ordinal()
			// || ID == SettingList.NOISE_REDUCTION.ordinal()) {
			// return false;
			// }
			// } else if (mIsCaptureIntent == 2) { // VideoCapture
			// if (ID == SettingList.CONITNUOUS_SHUTTER.ordinal() || ID ==
			// SettingList.TOUCH_TO_CAPTURE.ordinal()
			// || ID == SettingList.GRID.ordinal()) {
			// return false;
			// }
			// }
			// }
			//
			// if (mCameraID == CameraHolder.instance().getFrontCameraId()) {
			// if (ID == SettingList.TOUCH_TO_CAPTURE.ordinal() || ID ==
			// SettingList.GRID.ordinal()
			// || ID == SettingList.VIDEO_STABILIZER.ordinal() || ID ==
			// SettingList.LOCATION.ordinal()
			// || ID == SettingList.CONITNUOUS_SHUTTER.ordinal()) {
			// return true;
			// }
			// } else {
			// if ((ID == SettingList.CONITNUOUS_SHUTTER.ordinal()
			// && mCaptureMode.equals(CameraEnvironment.CAPTUREMODE_NORMAL))
			// || (ID == SettingList.TOUCH_TO_CAPTURE.ordinal() &&
			// mIsObjectTrackingOn == false)
			// || ID == SettingList.GRID.ordinal() || ID ==
			// SettingList.VIDEO_STABILIZER.ordinal()
			// || ID == SettingList.NOISE_REDUCTION.ordinal() || ID ==
			// SettingList.LOCATION.ordinal()) {
			// return true;
			// }
			// }
			return true;
		}

		// @Override
		// public boolean isEnabled(int position) {
		// return checkItemIsEnable(position);
		// }

		@Override
		public int getCount() {
			return mSettingItemMap.size();
		}

		@Override
		public BaseItemInfo getItem(int arg0) {
			return mSettingItemMap.get(arg0);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder;
			View view = null;
			BaseItemInfo item = mSettingItemMap.get(position);
			boolean isEnable = checkItemIsEnable(position);
			if (item == null) {
				return null;
			}
			if (convertView == null) {
				holder = new ViewHolder();

				view = mInflater.inflate(R.layout.setting_list_item_multiline_switch, parent, false);
				holder.title = (TextView) view.findViewById(R.id.multiline_switch_title);
				holder.summary = (TextView) view.findViewById(R.id.multiline_switch_summary);
				holder.category = (TextView) view.findViewById(R.id.multiline_switch_category);
				holder.switch_ = (Switch) view.findViewById(R.id.multiline_switch_switcher);

				view.setTag(holder);
			} else {
				view = convertView;
				holder = (ViewHolder) view.getTag();
			}

			ViewGroup.LayoutParams lp = view.getLayoutParams();
			lp.height = Util.dpToPixel(SETTING_ITEM_HEIGHT_DP);
			String mainText = mContext.getResources().getString(item.getMainTextResID());
			ItemType itemType = ItemType.values()[item.getType()];
			switch (itemType) {
			case CATEGORY:
				view.setEnabled(false);
				holder.category.setVisibility(View.VISIBLE);
				holder.category.setText(mainText);
				holder.category.setTextSize(15);
				holder.category.setTextColor(0xffacff00);
				holder.title.setVisibility(View.GONE);
				holder.summary.setVisibility(View.GONE);
				holder.switch_.setVisibility(View.GONE);
				if (position == SettingList.CATEGORY_PHOTO.ordinal())
					lp.height = Util.dpToPixel(SETTING_ITEM_FIRST_CATOGORY_HEIGHT_DP);
				break;
			case NORMAL:
				holder.category.setVisibility(View.VISIBLE);
				holder.category.setText(mainText);
				holder.category.setTextSize(15);
				// holder.category.setTextColor(0xffacff00);
				holder.title.setVisibility(View.GONE);
				holder.summary.setVisibility(View.GONE);
				holder.switch_.setVisibility(View.GONE);
				break;
			case SWITCH:
				// SwitchItem sitem = (SwitchItem) item;
				boolean isSwitchEnable = checkSwitchIsEnable(position);
				if (holder.title != null) {
					holder.title.setVisibility(View.VISIBLE);
					holder.title.setText(mainText);
					if (isSwitchEnable) {
						holder.title.setTextColor(Color.BLACK);
					} else {
						holder.title.setTextColor(Color.GRAY);
					}
				}
				if (holder.switch_ != null) {
					holder.switch_.setVisibility(View.VISIBLE);
					// sitem.setSwitch(holder.switch_);
					// if (sitem.getValue().equals("on")) {
					// holder.switch_.setChecked(true);
					// } else {
					// holder.switch_.setChecked(false);
					// }
					holder.switch_.setEnabled(isSwitchEnable);
				}
				if (holder.summary != null)
					holder.summary.setVisibility(View.GONE);
				if (holder.category != null)
					holder.category.setVisibility(View.GONE);
				break;
			case TAB_NORMAL:
				view.setEnabled(isEnable);
				if (holder.title != null) {
					holder.title.setVisibility(View.VISIBLE);
					mainText = mContext.getResources().getString(item.getMainTextResID());
					AcerLog.d("wellsTest", "mainText:" + mainText);
					holder.title.setText(mainText);
					if (isEnable) {
					} else {
						holder.title.setTextColor(Color.BLACK);
						holder.title.setTextColor(Color.GRAY);
					}
				}
				if (holder.switch_ != null)
					holder.switch_.setVisibility(View.GONE);
				if (holder.category != null)
					holder.category.setVisibility(View.GONE);
				if (holder.summary != null) {
					holder.summary.setVisibility(View.VISIBLE);
					holder.summary.setText(item.getSubText());
					lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
					// if (item.getSubText().equals("")) {
					// holder.summary.setText(item.getSubText());
					// AcerLog.d("wellsTest",
					// "item.getSubText():"+item.getSubText());
					// } else {
					// holder.summary.setVisibility(View.GONE);
					// }
				}
				break;
			case NORMAL_SWITCH:
				// SwitchItem mitem = (SwitchItem) item;
				boolean isNormalSwitchEnable = checkSwitchIsEnable(position);
				if (holder.title != null) {
					holder.title.setVisibility(View.VISIBLE);
					holder.title.setText(mainText);
					if (isNormalSwitchEnable) {
						holder.title.setTextColor(Color.BLACK);
					} else {
						holder.title.setTextColor(Color.GRAY);
					}
				}
				if (holder.switch_ != null) {
					holder.switch_.setVisibility(View.VISIBLE);
					// mitem.setSwitch(holder.switch_);
					// if (mitem.getValue().equals("on")) {
					// holder.switch_.setChecked(true);
					// } else {
					// holder.switch_.setChecked(false);
					// }
					holder.switch_.setEnabled(isNormalSwitchEnable);
				}
				if (holder.summary != null) {
					holder.summary.setVisibility(View.VISIBLE);
					holder.summary.setText(item.getSubText());
					lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
				}
				if (holder.category != null)
					holder.category.setVisibility(View.GONE);
				break;
			}
			view.setLayoutParams(lp);
			view.setTag(holder);
			return view;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}

}
