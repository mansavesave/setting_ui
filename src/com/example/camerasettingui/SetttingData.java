package com.example.camerasettingui;

import java.util.ArrayList;

import com.example.camerasettingui.exist.CameraEnvironment;

import android.app.Activity;

public class SetttingData {
	public enum SettingList {
		CATEGORY_PHOTO, RESOLUTION, ISO, FAVORITE_SHOT, CONITNUOUS_SHUTTER, TOUCH_TO_CAPTURE, GRID, CATEGORY_VIDEO, VIDEO_STABILIZER, VIDEO_RESOLUTION, AUDIO_MODE, NOISE_REDUCTION, CATEGORY_OTHER, LOCATION, VOICE_CONTROL, STORAGE, RESET_TO_DEFAULT
	}

	public enum ItemType {
		CATEGORY, NORMAL, TAB_NORMAL, SWITCH, NORMAL_SWITCH
	}

	public class BaseItemInfo {
		private String mTabKey1 = "";
		private String mTabKey2 = "";
		private String mKey = "";
		private int mType;
		private int mListID = -1;
		private int mMainTextResID = -1;
		private String mSubText = "unknown";

		public BaseItemInfo(int id, int type, int resid, String key) {
			setID(id);
			setType(type);
			setMainTextResID(resid);
			setkey(key);
		}

		public BaseItemInfo(int id, int type, int resid, String key, String tabkey1, String tabkey2) {
			setID(id);
			setType(type);
			setMainTextResID(resid);
			setkey(key);
			setTabkey1(tabkey1);
			setTabkey2(tabkey2);
		}

		public void setID(int id) {
			mListID = id;
		}

		public int getID() {
			return mListID;
		}

		public void setType(int type) {
			mType = type;
		}

		public int getType() {
			return mType;
		}

		public void setMainTextResID(int resid) {
			mMainTextResID = resid;
		}

		public int getMainTextResID() {
			return mMainTextResID;
		}

		public void setkey(String key) {
			mKey = key;
		}

		public String getkey() {
			return mKey;
		}

		public void setTabkey1(String value1) {
			mTabKey1 = value1;
		}

		public String getTabkey1() {
			return mTabKey1;
		}

		public void setTabkey2(String value2) {
			mTabKey2 = value2;
		}

		public String getTabkey2() {
			return mTabKey2;
		}

		public String getSubText() {
			return mSubText;
		}

		public void setSubText(String subText) {
			mSubText = subText;
		}
	}

	// properties
	public static String TAG = "wellsTest";
	private Activity mActivity;

	public SetttingData(Activity activity) {
		mActivity = activity;
	}

	public ArrayList<BaseItemInfo> getCameraDataList(int camera_id) {
		ArrayList<BaseItemInfo> list = new ArrayList<BaseItemInfo>();
		for (BaseItemInfo item : SettingCameraPageDataList) {
			list.add(item);
		}
		return list;
	}

	public ArrayList<BaseItemInfo> getCamcorderDataList(int camera_id) {
		ArrayList<BaseItemInfo> list = new ArrayList<BaseItemInfo>();
		for (BaseItemInfo item : SettingCamcorderPageDataList) {
			list.add(item);
		}
		return list;
	}

	public ArrayList<BaseItemInfo> getOtherDataList(int camera_id) {
		ArrayList<BaseItemInfo> list = new ArrayList<BaseItemInfo>();
		for (BaseItemInfo item : SettingOtherPageDataList) {
			list.add(item);
		}
		return list;
	}

	public ArrayList<BaseItemInfo> getDataList(int camera_id) {
		ArrayList<BaseItemInfo> list = new ArrayList<BaseItemInfo>();
		for (BaseItemInfo item : TotalSettingDataList) {
			// if (item.getID() == SettingList.STORAGE.ordinal() &&
			// !Storage.checkExternalStorageAvailable()) {
			// continue;
			// }
			list.add(item);
			// if (camera_id == CameraHolder.instance().getFrontCameraId()) {
			// if (isZ100) {
			// if (item.getID() != SettingList.FAVORITE_SHOT.ordinal()
			// && item.getID() != SettingList.CONITNUOUS_SHUTTER.ordinal()) {
			// list.add(item);
			// }
			// } else if (isZ320) {
			// if (item.getID() != SettingList.FAVORITE_SHOT.ordinal()
			// && item.getID() != SettingList.CONITNUOUS_SHUTTER.ordinal()
			// && item.getID() != SettingList.NOISE_REDUCTION.ordinal()) {
			// list.add(item);
			// }
			// } else if (item.getID() != SettingList.FAVORITE_SHOT.ordinal()) {
			// list.add(item);
			// }
			// } else {
			// if (isZ100) {
			// if (item.getID() != SettingList.FAVORITE_SHOT.ordinal()) {
			// list.add(item);
			// }
			// } else if (isZ320) {
			// if (item.getID() != SettingList.NOISE_REDUCTION.ordinal()) {
			// list.add(item);
			// }
			// } else {
			// list.add(item);
			// }
			// }
		}
		return list;
	}

	public BaseItemInfo SettingCameraPageDataList[] = { new BaseItemInfo(SettingList.RESOLUTION.ordinal(),
			ItemType.TAB_NORMAL.ordinal(), R.string.pref_camera_resolution, CameraEnvironment.PARM_Ratio,
			CameraEnvironment.PARM_PHOTO_4X3_LEVEL, CameraEnvironment.PARM_PHOTO_16X9_LEVEL),

			new BaseItemInfo(SettingList.CONITNUOUS_SHUTTER.ordinal(), ItemType.NORMAL_SWITCH.ordinal(),
					R.string.continuous_shot, CameraEnvironment.PARM_CONTINOUS_SHUTTER),
			// new BaseItemInfo(SettingList.OBJECT_TRACKING.ordinal(), SWITCH,
			// R.string.object_tracking,
			// CameraEnvironment.PARM_OBJECT_TRACKING),
			new BaseItemInfo(SettingList.TOUCH_TO_CAPTURE.ordinal(), ItemType.SWITCH.ordinal(),
					R.string.touch_to_capture, CameraEnvironment.PARM_TOUCH_TO_CAPTURE),
			// new BaseItemInfo(SettingList.POSTURE_DETECTION.ordinal(), SWITCH,
			// R.string.posture_detection,
			// CameraEnvironment.PARM_POSTURE_DETECTION),
			new BaseItemInfo(SettingList.GRID.ordinal(), ItemType.SWITCH.ordinal(), R.string.pref_grid,
					CameraEnvironment.PARM_GRID) };

	public BaseItemInfo SettingCamcorderPageDataList[] = {
			new BaseItemInfo(SettingList.VIDEO_RESOLUTION.ordinal(), ItemType.TAB_NORMAL.ordinal(),
					R.string.pref_camcoder_resolution, CameraEnvironment.PARM_VIDEO_SIZE),
			new BaseItemInfo(SettingList.AUDIO_MODE.ordinal(), ItemType.TAB_NORMAL.ordinal(),
					R.string.pref_audiomode_title, CameraEnvironment.PARM_AUDIO_MODE),
			new BaseItemInfo(SettingList.VIDEO_STABILIZER.ordinal(), ItemType.SWITCH.ordinal(),
					R.string.pref_camcoder_eis, CameraEnvironment.PARM_VIDEO_EIS),

			new BaseItemInfo(SettingList.NOISE_REDUCTION.ordinal(), ItemType.SWITCH.ordinal(), R.string.noise_reduction,
					CameraEnvironment.PARM_NOISE_REDUCTION), };

	public BaseItemInfo SettingOtherPageDataList[] = {
			new BaseItemInfo(SettingList.STORAGE.ordinal(), ItemType.TAB_NORMAL.ordinal(), R.string.pref_camera_storage,
					CameraEnvironment.PARM_STORAGE_SOURCE),
			new BaseItemInfo(SettingList.LOCATION.ordinal(), ItemType.SWITCH.ordinal(), R.string.pref_camera_location,
					CameraEnvironment.PARM_STORE_LOCATION),
			new BaseItemInfo(SettingList.RESET_TO_DEFAULT.ordinal(), ItemType.NORMAL.ordinal(),
					R.string.acerdialog_tilte, null) };

	public BaseItemInfo getBaseItemInfo(int index) {
		for (BaseItemInfo each : SettingCameraPageDataList) {
			if (each.getID() == index) {
				return each;
			}

		}

		for (BaseItemInfo each : SettingCamcorderPageDataList) {
			if (each.getID() == index) {
				return each;
			}

		}

		for (BaseItemInfo each : SettingOtherPageDataList) {
			if (each.getID() == index) {
				return each;
			}

		}
		return null;
	}

	public BaseItemInfo TotalSettingDataList[] = {
			new BaseItemInfo(SettingList.CATEGORY_PHOTO.ordinal(), ItemType.CATEGORY.ordinal(), R.string.category_photo,
					null),
			new BaseItemInfo(SettingList.RESOLUTION.ordinal(), ItemType.TAB_NORMAL.ordinal(),
					R.string.pref_camera_resolution, CameraEnvironment.PARM_Ratio,
					CameraEnvironment.PARM_PHOTO_4X3_LEVEL, CameraEnvironment.PARM_PHOTO_16X9_LEVEL),
			new BaseItemInfo(SettingList.ISO.ordinal(), ItemType.NORMAL.ordinal(), R.string.pref_camera_iso,
					CameraEnvironment.PARM_ISO),
			new BaseItemInfo(SettingList.FAVORITE_SHOT.ordinal(), ItemType.NORMAL.ordinal(), R.string.favorite_shot,
					CameraEnvironment.PARM_FAVORITE_SHOT),
			new BaseItemInfo(SettingList.CONITNUOUS_SHUTTER.ordinal(), ItemType.NORMAL_SWITCH.ordinal(),
					R.string.continuous_shot, CameraEnvironment.PARM_CONTINOUS_SHUTTER),
			// new BaseItemInfo(SettingList.OBJECT_TRACKING.ordinal(), SWITCH,
			// R.string.object_tracking,
			// CameraEnvironment.PARM_OBJECT_TRACKING),
			new BaseItemInfo(SettingList.TOUCH_TO_CAPTURE.ordinal(), ItemType.SWITCH.ordinal(),
					R.string.touch_to_capture, CameraEnvironment.PARM_TOUCH_TO_CAPTURE),
			// new BaseItemInfo(SettingList.POSTURE_DETECTION.ordinal(), SWITCH,
			// R.string.posture_detection,
			// CameraEnvironment.PARM_POSTURE_DETECTION),
			new BaseItemInfo(SettingList.GRID.ordinal(), ItemType.SWITCH.ordinal(), R.string.pref_grid,
					CameraEnvironment.PARM_GRID),
			new BaseItemInfo(SettingList.CATEGORY_VIDEO.ordinal(), ItemType.CATEGORY.ordinal(), R.string.category_video,
					null),
			new BaseItemInfo(SettingList.VIDEO_STABILIZER.ordinal(), ItemType.SWITCH.ordinal(),
					R.string.pref_camcoder_eis, CameraEnvironment.PARM_VIDEO_EIS),
			new BaseItemInfo(SettingList.VIDEO_RESOLUTION.ordinal(), ItemType.NORMAL.ordinal(),
					R.string.pref_camcoder_resolution, CameraEnvironment.PARM_VIDEO_SIZE),
			new BaseItemInfo(SettingList.AUDIO_MODE.ordinal(), ItemType.NORMAL.ordinal(), R.string.pref_audiomode_title,
					CameraEnvironment.PARM_AUDIO_MODE),
			new BaseItemInfo(SettingList.NOISE_REDUCTION.ordinal(), ItemType.SWITCH.ordinal(), R.string.noise_reduction,
					CameraEnvironment.PARM_NOISE_REDUCTION),
			new BaseItemInfo(SettingList.CATEGORY_OTHER.ordinal(), ItemType.CATEGORY.ordinal(), R.string.category_other,
					null),
			new BaseItemInfo(SettingList.LOCATION.ordinal(), ItemType.SWITCH.ordinal(), R.string.pref_camera_location,
					CameraEnvironment.PARM_STORE_LOCATION),
			new BaseItemInfo(SettingList.VOICE_CONTROL.ordinal(), ItemType.NORMAL.ordinal(), R.string.voice_control,
					CameraEnvironment.VOICE_CONTROL),
			new BaseItemInfo(SettingList.STORAGE.ordinal(), ItemType.NORMAL.ordinal(), R.string.pref_camera_storage,
					CameraEnvironment.PARM_STORAGE_SOURCE),
			new BaseItemInfo(SettingList.RESET_TO_DEFAULT.ordinal(), ItemType.NORMAL.ordinal(),
					R.string.acerdialog_tilte, null) };
}
