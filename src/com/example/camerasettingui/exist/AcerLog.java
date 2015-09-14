/*****************************************************************************
 * Copyright (C) 2011 Acer, Inc. All Rights Reserved.
 *
 * This program is an unpublished copyrighted work which is proprietary
 * to Acer, Inc. and contains confidential information that is not to
 * be reproduced or disclosed to any other person or entity without
 * prior written consent from Acer, Inc. in each and every instance.
 *
 * WARNING:  Unauthorized reproduction of this program as well as
 * unauthorized preparation of derivative works based upon the
 * program or distribution of copies by sale, rental, lease or
 * lending are violations of federal copyright laws and state trade
 * secret laws, punishable by civil and criminal penalties.
 *
 *****************************************************************************/
package com.example.camerasettingui.exist;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;

public class AcerLog {
    private static final boolean IS_ENABLE = true;

    private final static String TAG_TIME = "TestAverageTime";

    public static final String SHARE_PREFERENCE_KEY = "PreferenceForAcerCamera";
    public static final String CAM_LAUNCH_CAMERA_AVERAGE_TIME = "CamLaunchCameraAvgTime";
    public static final String CAM_START_PREVIEW_AVERAGE_TIME = "CamStartPreviewAvgTime";
    public static final String CAM_AUTO_FOCUS_AVERAGE_TIME = "CamAutoFocusAvgTime";
    public static final String CAM_TAKING_PICTURES_AVERAGE_TIME = "CamTakingPicturesAvgTime";
    public static final String CAM_SWITCH_LENS_AVERAGE_TIME = "CamSwitchLensAvgTime";

    public static final String VDO_LAUNCH_CAMCORDER_AVERAGE_TIME = "VdoLaunchCamcorderAvgTime";
    public static final String VDO_START_PREVIEW_AVERAGE_TIME = "VdoStartPreviewAvgTime";
    public static final String VDO_AUTO_FOCUS_AVERAGE_TIME = "VdoAutoFocusAvgTime";
    public static final String VDO_START_RECORDING_AVERAGE_TIME = "VdoStartRecordingAvgTime";
    public static final String VDO_SAVE_AND_REVIEW_VIDEO_AVERAGE_TIME = "VdoSaveAndReviewVideoAvgTime";
    public static final String VDO_SWITCH_LENS_AVERAGE_TIME = "VdoSwitchLensAvgTime";

    public static final int TYPE_CAMERA = 1001;
    public static final int TYPE_VIDEO = 1002;

    public static final int ACTION_LAUNCH = 10001;
    // From onCreate beginning to onResume ending.

    public static final int ACTION_PREVIEW = 10002;
    // From initializing camera preview to receive first preview frame buffer call back

    public static final int ACTION_CAPTURE = 10003;
    // From starting taking pictures to review the image(for camera), or from initializing video recording to start recording video(for camcorder).

    public static final int ACTION_FOCUS = 10004;
    // From starting doing focus to receive focus call back

    public static final int ACTION_REVIEW = 10005;
    // From StopVideoRecording to initialize Reviewing video

    public static final int ACTION_SWITCH_LENS = 10006;

    private static long launchTime;
    private static long launchAvgTime;
    private static long launchStartTime;
    private static long startPreviewTime;
    private static long startPreviewAvgTime;
    private static long startPreviewStartTime = -1;
    private static long captureTime;
    private static long captureAvgTime;
    private static long captureStartTime;
    private static long focusTime;
    private static long focusAvgTime;
    private static long focusStartTime;
    private static long switchLensTime;
    private static long switchLensAvgTime;
    private static long switchLensStartTime;

    private static long reviewTime;
    private static long reviewAvgTime;
    private static long reviewStartTime;

    private static TextView infoView;
    private static TextView framerateView;
    private static long framerateStartTime;
    private static int currentType;

    public static void setInfoView(TextView view){
        infoView = view;
        showInfoLog();
    }

    public static void setFramerateView(TextView view){
        framerateView = view;
    }

    public static void loadPerformanceData(Context context, int type){
        if(IS_ENABLE){
            currentType = type;
            final SharedPreferences sharePreference = context.getSharedPreferences(SHARE_PREFERENCE_KEY, Context.MODE_WORLD_WRITEABLE);
            if(sharePreference != null){
                if(type == TYPE_CAMERA){
                    launchAvgTime = sharePreference.getLong(CAM_LAUNCH_CAMERA_AVERAGE_TIME, 0);
                    startPreviewAvgTime = sharePreference.getLong(CAM_START_PREVIEW_AVERAGE_TIME, 0);
                    focusAvgTime = sharePreference.getLong(CAM_AUTO_FOCUS_AVERAGE_TIME, 0);
                    captureAvgTime = sharePreference.getLong(CAM_TAKING_PICTURES_AVERAGE_TIME, 0);
                    switchLensAvgTime = sharePreference.getLong(CAM_SWITCH_LENS_AVERAGE_TIME, 0);
                }else if(type == TYPE_VIDEO){
                    launchAvgTime = sharePreference.getLong(VDO_LAUNCH_CAMCORDER_AVERAGE_TIME, 0);
                    focusAvgTime = sharePreference.getLong(VDO_AUTO_FOCUS_AVERAGE_TIME, 0);
                    captureAvgTime = sharePreference.getLong(VDO_START_RECORDING_AVERAGE_TIME, 0);
                    reviewAvgTime = sharePreference.getLong(VDO_SAVE_AND_REVIEW_VIDEO_AVERAGE_TIME, 0);
                    switchLensAvgTime = sharePreference.getLong(VDO_SWITCH_LENS_AVERAGE_TIME, 0);
                }
            }
        }
    }

    public static void savePerformanceData(Context context, int type){
        if(IS_ENABLE){
            final SharedPreferences sharePreference = context.getSharedPreferences(SHARE_PREFERENCE_KEY, Context.MODE_WORLD_WRITEABLE);
            if(sharePreference != null){
                SharedPreferences.Editor editor = sharePreference.edit();
                if(editor != null){
                    if(type == TYPE_CAMERA){
                        editor.putLong(CAM_LAUNCH_CAMERA_AVERAGE_TIME, launchAvgTime).commit();
                        editor.putLong(CAM_START_PREVIEW_AVERAGE_TIME, startPreviewAvgTime).commit();
                        editor.putLong(CAM_AUTO_FOCUS_AVERAGE_TIME, focusAvgTime).commit();
                        editor.putLong(CAM_TAKING_PICTURES_AVERAGE_TIME, captureAvgTime).commit();
                        editor.putLong(CAM_SWITCH_LENS_AVERAGE_TIME, switchLensAvgTime).commit();
                    }else if(type == TYPE_VIDEO){
                        editor.putLong(VDO_LAUNCH_CAMCORDER_AVERAGE_TIME, launchAvgTime).commit();
                        editor.putLong(VDO_AUTO_FOCUS_AVERAGE_TIME, focusAvgTime).commit();
                        editor.putLong(VDO_START_RECORDING_AVERAGE_TIME, captureAvgTime).commit();
                        editor.putLong(VDO_SAVE_AND_REVIEW_VIDEO_AVERAGE_TIME, reviewAvgTime).commit();
                        editor.putLong(VDO_SWITCH_LENS_AVERAGE_TIME, switchLensAvgTime).commit();
                    }
                }
            }
        }
    }

    private static int mFrameCount = 0;
    public static void showFramerateLog(long time){
        if(framerateView != null){
            if(framerateStartTime == 0){
                framerateStartTime = time;
            }
            if((time - 1000) > framerateStartTime){
                framerateView.setText("frame rate: " + mFrameCount);
                framerateStartTime = 0;
                mFrameCount = 0;
                //Log.i(TAG_TIME, "Frame rate: " + (time - framerateTime));
            }else{
                mFrameCount++;
            }
        }
    }

    private static void showInfoLog(){
        if(infoView != null){
            if(currentType == TYPE_CAMERA){
                infoView.setText("launch time: " + launchTime + "\n"
                        + "launch average time: " + launchAvgTime + "\n"
                        + "start preview time: " + startPreviewTime + "\n"
                        + "start preview average time: " + startPreviewAvgTime + "\n"
                        + "focus time: " + focusTime + "\n"
                        + "focus average time: " + focusAvgTime + "\n"
                        + "taking time: " + captureTime + "\n"
                        + "taking average time: " + captureAvgTime + "\n"
                        + "switch lens time: " + switchLensTime + "\n"
                        + "switch lens average time: " + switchLensAvgTime + "\n");
            }else{
                infoView.setText("launch time: " + launchTime + "\n"
                        + "launch average time: " + launchAvgTime + "\n"
                        + "focus time: " + focusTime + "\n"
                        + "focus average time: " + focusAvgTime + "\n"
                        + "start recording time: " + captureTime + "\n"
                        + "start recording  average time: " + captureAvgTime + "\n"
                        + "review time: " + reviewTime + "\n"
                        + "review average time: " + reviewAvgTime + "\n"
                        + "switch lens time: " + switchLensTime + "\n"
                        + "switch lens average time: " + switchLensAvgTime + "\n");
            }
        }
    }

    public static void setCurrentTimeToStart(int action){
        if(IS_ENABLE){
            switch(action){
            case ACTION_LAUNCH:
                launchStartTime = System.currentTimeMillis();
                break;
            case ACTION_PREVIEW:
                if(startPreviewStartTime < 0)
                    startPreviewStartTime = System.currentTimeMillis();
                break;
            case ACTION_CAPTURE:
                captureStartTime = System.currentTimeMillis();
                break;
            case ACTION_FOCUS:
                focusStartTime = System.currentTimeMillis();
                break;
            case ACTION_REVIEW:
                reviewStartTime = System.currentTimeMillis();
                break;
            case ACTION_SWITCH_LENS:
                switchLensStartTime = System.currentTimeMillis();
                break;
            }
        }
    }

    public static void setCurrentTimeToStop(int action){
        if(IS_ENABLE){
            switch(action){
            case ACTION_LAUNCH:
                if(launchStartTime > 0){
                    launchTime = (System.currentTimeMillis() - launchStartTime);
                    if(launchAvgTime == 0){
                        launchAvgTime = launchTime;
                    }else{
                        launchAvgTime = (launchAvgTime + launchTime)/2;
                    }
                    launchStartTime = 0;
                    Log.i(TAG_TIME, "Launch time = " + launchTime + ", average time = " + launchAvgTime);
                }
                break;
            case ACTION_PREVIEW:
                if(startPreviewStartTime > 0){
                    startPreviewTime = System.currentTimeMillis() - startPreviewStartTime;
                    if(startPreviewAvgTime == 0){
                        startPreviewAvgTime = startPreviewTime;
                    }else{
                        startPreviewAvgTime = (startPreviewAvgTime + startPreviewTime)/2;
                    }
                    AcerLog.i(TAG_TIME, "Start preview time: " + startPreviewTime + ", average time = " + startPreviewAvgTime);
                    startPreviewStartTime = -1;
                }
                break;
            case ACTION_CAPTURE:
                if(captureStartTime > 0){
                    captureTime = System.currentTimeMillis() - captureStartTime;
                    if(captureAvgTime == 0){
                        captureAvgTime = captureTime;
                    }else{
                        captureAvgTime = (captureAvgTime + captureTime)/2;
                    }
                    captureStartTime = 0;
                    AcerLog.i(TAG_TIME, "Capturing max resolution pictures or videos time: " + captureTime + ", average time = " + captureAvgTime);
                }
                break;
            case ACTION_FOCUS:
                if(focusStartTime > 0){
                    focusTime = System.currentTimeMillis() - focusStartTime;
                    if(focusTime < 100){
                        focusTime = 0;
                        focusStartTime = 0;
                        return;
                    }
                    if(focusAvgTime == 0){
                        focusAvgTime = focusTime;
                    }else{
                        focusAvgTime = (focusAvgTime + focusTime)/2;
                    }
                    focusStartTime = 0;
                    AcerLog.i(TAG_TIME, "Auto focus time: " + focusTime + ", average time = " + focusAvgTime);
                }
                break;
            case ACTION_REVIEW:
                if(reviewStartTime > 0){
                    reviewTime = System.currentTimeMillis() - reviewStartTime;
                    if(reviewAvgTime == 0){
                        reviewAvgTime = reviewTime;
                    }else{
                        reviewAvgTime = (reviewAvgTime + reviewTime)/2;
                    }
                    reviewStartTime = 0;
                    AcerLog.i(TAG_TIME, "Review time: " + reviewTime + ", average time = " + reviewAvgTime);
                }
                break;
            case ACTION_SWITCH_LENS:
                if(switchLensStartTime > 0){
                    switchLensTime = System.currentTimeMillis() - switchLensStartTime;
                    if(switchLensAvgTime == 0){
                        switchLensAvgTime = switchLensTime;
                    }else{
                        switchLensAvgTime = (switchLensAvgTime + switchLensTime)/2;
                    }
                    switchLensStartTime = 0;
                    AcerLog.i(TAG_TIME, "Review time: " + switchLensTime + ", average time = " + switchLensAvgTime);
                }
                break;
            }
            showInfoLog();
        }
    }

    public static void i(String tag, String message) {
        if (IS_ENABLE)
            Log.i(tag, message);
    }

    public static void i(String tag, String message, Exception exception) {
        if (IS_ENABLE)
            Log.i(tag, message, exception);
    }

    public static void d(String tag, String message, Throwable tr) {
        if(IS_ENABLE)
            Log.d(tag, message, tr);
    }

    public static void d(String tag, String message){
        if(IS_ENABLE)
            Log.d(tag, message);
    }

    public static void dForBatt(String tag, String message){
            Log.d(tag, message);
    }

    public static void e(String tag, String message, Exception exception) {
        Log.e(tag, message, exception);
    }

    public static void e(String tag, String message) {
        Log.e(tag, message);
    }

    public static void e(String tag, String message, Throwable tr) {
        String strEx = Log.getStackTraceString(tr);
        Log.e(tag, strEx);

    }

    public static void v(String tag, String message) {
        if (IS_ENABLE)
            Log.v(tag, message);
    }

    public static void w(String tag, String message) {
        if (IS_ENABLE)
            Log.w(tag, message);
    }

    public static void w(String tag, Exception exception) {
        if (IS_ENABLE)
            Log.w(tag, exception);
    }

    public static void w(String tag, String message, Throwable exception) {
        if (IS_ENABLE)
            Log.w(tag, message, exception);
    }

    public static boolean isLoggable(String tag, int level) {
        return Log.isLoggable(tag, level);
    }

    public static final int VERBOSE = Log.VERBOSE;
}
