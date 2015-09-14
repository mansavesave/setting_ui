package com.example.camerasettingui;

import java.util.ArrayList;
import java.util.List;

import com.example.camerasettingui.exist.AcerLog;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toolbar.LayoutParams;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;

public class MainSetting {
	public static String TAG = "wellsTest-MainSetting";
	private Activity mActivity;
	private SetttingData mSetttingData;
	private ViewPager mViewPager;
	private ArrayList<SettingPage> mPageList;
	private SettingPagerAdapter mSettingPagerAdapter;
	private TabHost mTabHost;
	private SettingTabAdapter mSettingTabAdapter;

	public MainSetting(Activity activity) {
		Log.d(TAG, "+MainSetting");
		mActivity = activity;
		initData();
		initView();
	}

	public void initData() {
		Log.d(TAG, "+initData");
		mSetttingData = new SetttingData(mActivity);
		mPageList = new ArrayList<SettingPage>();

		SettingPage cameraSettingPage = new SettingPage(mActivity, mActivity.getString(R.string.camera_label),
				R.drawable.tab_page_camera, mSetttingData.getCameraDataList(0));
		SettingPage camcorderSettingPage = new SettingPage(mActivity, mActivity.getString(R.string.video_camera_label),
				R.drawable.tab_page_camcorder, mSetttingData.getCamcorderDataList(0));
		SettingPage otherSettingPage = new SettingPage(mActivity, mActivity.getString(R.string.category_other),
				R.drawable.tab_page_other, mSetttingData.getOtherDataList(0));
		mPageList.add(cameraSettingPage);
		mPageList.add(camcorderSettingPage);
		mPageList.add(otherSettingPage);

		mSettingPagerAdapter = new SettingPagerAdapter(this);

	}

	public void initView() {
		Log.d(TAG, "+initView");
		mSettingTabAdapter = new SettingTabAdapter(mActivity);

		mViewPager = (ViewPager) mActivity.findViewById(R.id.main_setting_pager);
		mViewPager.setAdapter(mSettingPagerAdapter);
		mViewPager.addOnPageChangeListener(mSettingPagerAdapter);

		mTabHost = (TabHost) mActivity.findViewById(android.R.id.tabhost);
		mTabHost.setup();

		for (SettingPage each : mPageList) {
			String tag = each.getTabName();
			View tabView = each.getTabView();
			mTabHost.addTab(mTabHost.newTabSpec(tag).setIndicator(tabView).setContent(mSettingTabAdapter));
		}
		mTabHost.setOnTabChangedListener(mSettingTabAdapter);
	};

	public ArrayList<SettingPage> getPageList() {
		return mPageList;
	}

	public void isInited() {
	};

	public void show() {
	};

	public void hide() {
	};

	public boolean isShow() {
		return false;
	};

	public void refresh() {
	};

	public void set() {
	};

	class SettingPagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
		MainSetting mMainSetting;

		public SettingPagerAdapter(MainSetting mainSetting) {
			mMainSetting = mainSetting;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			View view = mMainSetting.getPageList().get(position).getContentView();
			container.removeView(view);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			//AcerLog.d(TAG, "+instantiateItem:" + position);
			View view = mMainSetting.getPageList().get(position).getContentView();
			// container.addView(view, 0);
			container.addView(view);
			return view;
		}

		@Override
		public int getCount() {
			//AcerLog.d(TAG, "+getCount:" + mMainSetting.getPageList().size());
			return mMainSetting.getPageList().size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			//Log.d(TAG, "+isViewFromObject:" + arg1);
			return arg0 == arg1;
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			mTabHost.setCurrentTab(arg0);
		}

	}

	class SettingTabAdapter implements TabHost.TabContentFactory, TabHost.OnTabChangeListener {
		Context mContext;

		SettingTabAdapter(Context context) {
			mContext = context;
		}

		@Override
		public View createTabContent(String arg0) {
			AcerLog.d(TAG, "+createTabContent:" + arg0);
			TextView fakeView = new TextView(mContext);
			fakeView.setText("Content for tab with tag " + arg0);
			fakeView.setVisibility(View.INVISIBLE);
			return fakeView;
		}

		@Override
		public void onTabChanged(String tabId) {
			// TODO Auto-generated method stub
			Log.d(TAG, "+onTabChanged:" + tabId);
			for (int i = 0; i < mPageList.size(); i++) {
				SettingPage page = mPageList.get(i);
				if (page.getTabName().equals(tabId)) {
					mViewPager.setCurrentItem(i, true);
					break;
				}
			}
		}

	}

}
