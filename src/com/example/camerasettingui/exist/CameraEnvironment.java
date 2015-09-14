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

import java.util.TreeMap;


import android.hardware.Camera.Parameters;
import android.media.CamcorderProfile;
import android.util.Log;

/**********************************************************************
 *
 * Naming Description for A3
 * final   ->  c
 * static  ->  s
 * member  ->  m_
 * int     ->  i
 * long    ->  l
 * bool    ->  b
 * string  ->  str
 * char    ->  ch
 * float   ->  f
 * double  ->  d
 * Object  ->  o

 function: v + N
 */

/**********************************************************************
 * This class is used to provide some basic information.
 *
 * @author Augustin Lu
 * @date 20091006
 */
public class CameraEnvironment {

    /*
     * public static final String PARM_FOCUS = "focus-mode"; public static final
     * String PARM_REAR_FOCUS = "rear-focus-mode"; public static final String
     * PARM_FRONT_FOCUS = "front-focus-mode";
     */

    public static final String PARM_WHITE_BALANCE = "white-balance";

    public static final String PARM_REAR_WHITE_BALANCE = "rear-white-balance";

    public static final String PARM_FRONT_WHITE_BALANCE = "front-white-balance";

    // MTK Camera
    public static final String PARM_SCENE_MODE = "scene-mode";

    public static final String PARM_REAR_SCENE_MODE = "rear-scene-mode";

    public static final String PARM_FRONT_SCENE_MODE = "front-scene-mode";

    public static final String PARM_CAMCORDER_SCENE_MODE = "camcorder-scene-mode";

    public static final String FOCUSMODE_AUTO = "auto";

    public static final String FOCUSMODE_NORMAL = "normal";

    public static final String FOCUSMODE_FD = "facedetection";

    public static final String FOCUSMODE_MARCO = "macro";

    public static final String PARM_CAPTURE_MODE = "capture-mode";

    public static final String PARM_FRONT_CAPTURE_MODE = "front-capture-mode";

//    public static final String PARM_REAR_CAPTURE_MODE = "rear-capture-mode";

    public static final String PARM_VIDEO_EIS = "video-eis";

    public static final String PARM_VIDEO_FRONT_EIS = "video-front-eis";

    public static final String PARM_VIDEO_REAR_EIS = "video-rear-eis";

    public static final String PARM_VIDEO_HDR = "video-hdr";

    public static final String PARM_RECORD_MODE = "record-mode";

  //voice control, these param refer Setting
    public static final String ACER_HANDFREE_STT_AVAILABLE = "acer_handfree_stt_available";
    public static final String ACER_HANDFREE_FUNCTION_AVAILABLE = "yes";
    public static final String ACER_HANDFREE_FUNCTION_UNAVAILABLE = "no";

    public static final String ACER_HANDFREE_SETTINGS_ONOFF = "acer_handfree_settings_onoff";
    public static final String ACER_HANDFREE_SETTINGS_ON = "enable";
    public static final String ACER_HANDFREE_SETTINGS_OFF = "disable";

    public static final String ACER_HANDFREE_CAMERA_CONTROL_ONOFF = "acer_handfree_camera_control_onoff";
    public static final String ACER_HANDFREE_CAMERA_CONTROL_ON = "enable";
    public static final String ACER_HANDFREE_CAMERA_CONTROL_OFF = "disable";

    // Capure
    public static final String CAPTUREMODE_NORMAL = "normal";
    public static final String CAPTUREMODE_MANUAL = "manual";
    public static final String CAPTUREMODE_HDR = "hdr";
    public static final String CAPTUREMODE_TIMELAPSE = "time-lapse";
    public static final String CAPTUREMODE_PANORAMA = "autorama";

    public static final String CAPTUREMODE_BEAUTIFICATION = "face_beauty";

    public static final String CAPTUREMODE_BEST = "best_shot";

    public static final String CAPTUREMODE_BRIGHT_MAGIC = "bright_magic";

    public static final String CAPTUREMODE_BURST = "continuousshot";

    public static final String CAPTUREMODE_SMILE = "smileshot";

    public static final String CAPTUREMODE_EV_BRACKET = "evbracketshot";

    public static final String CAPTUREMODE_PICTURE_WITH_SOUND = "photo_sound";

    public static final String CAPTUREMODE_FREE_FOCUS = "free_focus";

    public static final String CAPTUREMODE_MAV = "mav";

    public static final String CAPTUREMODE_PRESENTATION = "presentation";

    public static final String CAPTUREMODE_MOTION_TRACK = "motiontrack";

    public static final String CAPTUREMODE_LIVE_PHOTO = "live_photo";

    public static final String CAPTUREMODE_GOURMET = "gourment";

    public static final String CAPTUREMODE_SURROUND_LIGHT = "SurroundLight";

    public static final String CAPTUREMODE_SPORT = "sport";

    public static final String CAPTUREMODE_PIP = "pip_mode";
    // Scene
    public static final String SCENE_OFF = Parameters.SCENE_MODE_AUTO;

    public static final String SCENE_AUTO = "acer_auto";

    public static final String SCENE_ASD = "asd";

    public static final String SCENE_LANDSCAPE = Parameters.SCENE_MODE_LANDSCAPE;

    public static final String SCENE_NIGHT = Parameters.SCENE_MODE_NIGHT;

    public static final String SCENE_NIGHT_PORTRAIT = Parameters.SCENE_MODE_NIGHT_PORTRAIT;

    public static final String SCENE_BACKLIGHT = "acer_backlight";

    public static final String SCENE_BACKLIGHT_PORTRAIT = "acer_backlight_portrait";

    public static final String SCENE_PORTRAIT =  Parameters.SCENE_MODE_PORTRAIT;

    // Effect
    public static final String EFFECT_NONE = Parameters.EFFECT_NONE;

    public static final String EFFECT_MONO = Parameters.EFFECT_MONO;

    public static final String EFFECT_SEPIA = Parameters.EFFECT_SEPIA;

    public static final String EFFECT_NEGATIVE = Parameters.EFFECT_NEGATIVE;

    public static final String EFFECT_AUQA = Parameters.EFFECT_AQUA;

    // Record
    public static final String RECORD_MODE_NORMAL = "normal";

    public static final String RECORD_MODE_FAST_FHD = "fast-full-hd";

    public static final String RECORD_MODE_SLOW_MOTION = "slow-motion";

    public static final String RECORD_MODE_SLOW_MOTION_2X = "slow-motion-2x";

    public static final String RECORD_MODE_SLOW_MOTION_4X = "slow-motion-4x";

    public static final String RECORD_MODE_TIMELAPSE = "time-lapse";

    public static final String RECORD_MODE_TIMELAPSE_1S = "time-lapse-1s";

    public static final String RECORD_MODE_TIMELAPSE_2S = "time-lapse-2s";

    public static final String RECORD_MODE_TIMELAPSE_5S = "time-lapse-5s";

    public static final String RECORD_MODE_TIMELAPSE_10S = "time-lapse-10s";

    // WB
    public static final String WB_AUTO = Parameters.WHITE_BALANCE_AUTO;

    public static final String WB_DAYLIGHT = Parameters.WHITE_BALANCE_DAYLIGHT;

    public static final String WB_CLOUDY = Parameters.WHITE_BALANCE_CLOUDY_DAYLIGHT;

    public static final String WB_FLAMP = Parameters.WHITE_BALANCE_FLUORESCENT;

    public static final String WB_INCANDESCENT = Parameters.WHITE_BALANCE_INCANDESCENT;

    // TIMER
    public static final String TIMER_OFF = "0";

    public static final String TIMER_5S = "5";

    public static final String TIMER_10S = "10";

    public static final String TIMER_15S = "15";

    // EXPOSURE_METERING_MODE
    public static final String EXPOSURE_METERINGMODE_AUTO = "auto";
    public static final String EXPOSURE_METERING_MODE_CENTER  = "center";
    public static final String EXPOSURE_METERING_MODE_SPOT = "spot";
    public static final String EXPOSURE_METERING_MODE_AVERAGE = "average";


    public static final String PARM_FAVORITE_SHOT = "favorite-shot";

    public static final String PARM_CONTINOUS_SHUTTER = "continuous-shutter";

    public static final String PARM_OBJECT_TRACKING = "object-tracking";

    public static final String PARM_TOUCH_TO_CAPTURE = "touch-to-capture";

    public static final String PARM_POSTURE_DETECTION = "posture-detection";

    public static final String PARM_NOISE_REDUCTION = "noise-reduction";

    public static final String PARM_CAMERA_FLASH = "flash-mode";

    public static final String PARM_REAR_CAMERA_FLASH = "rear-flash-mode";

    public static final String PARM_FRONT_CAMERA_FLASH = "front-flash-mode"; // A5
                                                                             // front
                                                                             // camera
                                                                             // not
                                                                             // support
                                                                             // flashlight

    public static final String FLASH_OFF = "off";

    public static final String FLASH_ON = "on";

    public static final String FLASH_VIDEO_ON = "torch";

    public static final String FLASH_AUTO = "auto";

    // public static final String FLASH_REDEYE = "red-eye";

    public static final String PARM_FACE_BEAUTY_SETTINGS = "face-beauty-settings";

    public static final String PARM_FACE_BEAUTY_SMOOTH = "fb-smooth-level"; // -4,
                                                                            // 0,
                                                                            // 4

    public static final String PARM_FACE_BEAUTY_SKIN = "fb-skin-color"; // -4,
                                                                        // 2, 4

    public static final String PARM_FACE_BEAUTY_SHARP = "fb-sharp"; // -4, 0, 4

    public static final String PARM_FACE_BEAUTY_SLIM = "fb-slim-face"; // 4,
                                                                        // -12, 12

    public static final String PARM_FACE_BEAUTY_BIG_EYES = "fb-enlarge-eye";  // 2
                                                                              // -4, 4

    public static final String PARM_PHOTO_4X3_LEVEL = "photo-4x3-level";

    public static final String PARM_PHOTO_16X9_LEVEL = "photo-16x9-level";

//    public static final String PARM_FRONT_PHOTO_4X3_LEVEL = "front-photo-4x3-level";
//
//    public static final String PARM_FRONT_PHOTO_16X9_LEVEL = "front-photo-16x9-level";

//    public static final String PHOTO_LEVEL = "photo_level";

    public static final String PARM_REAR_PICTURE_LEVEL = "rear-picture-level";

    public static final String PARM_FRONT_PICTURE_LEVEL = "front-picture-level";

    public static final String PARM_METERING_MODE = "metering-mode";

    public static final String PARM_Ratio = "ratio";

    // public static final String PARM_REAR_Ratio = "rear-ratio";
    // public static final String PARM_FRONT_Ratio = "front-ratio";

    public static final String PICTURE_LEVEL_1 = "0";

    public static final String PICTURE_LEVEL_2 = "1";

    public static final String PICTURE_LEVEL_3 = "level_3";

    public static final String PICTURE_LEVEL_4 = "level_4";

    public static final String PICTURE_LEVEL_5 = "level_5";

    public static final String RATIO_4X3 = "4x3";

    public static final String RATIO_16X9 = "16x9";

    public static final String RATIO_1X1 = "1x1";

    public static final String PARM_BRIGHTNESS = "parm_brightness";

    public static final String PARM_FRONT_BRIGHTNESS = "front-parm_brightness";

    // public static final String PARM_REAR_BRIGHTNESS = "rear-luma-adaptation";

    public static final String PARM_CONTRAST = "parm_contrast";

    public static final String PARM_FRONT_CONTRAST = "front-parm_contrast";

    // public static final String PARM_REAR_CONTRAST = "rear-luma-adaptation";

    public static final String PARM_SATURATION = "parm_saturation";

    public static final String PARM_FRONT_SATURATION = "front-parm_saturation";

    // public static final String PARM_REAR_SATURATION = "rear-luma-adaptation";

    public static final String PARM_SHARPNESS = "parm_sharpness";

    public static final String PARM_FRONT_SHARPNESS = "front-parm_sharpness";

    // public static final String PARM_REAR_SHARPNESS = "rear-luma-adaptation";

    public static final String PARM_AUTOEXPOSURE = "luma-adaptation";

    public static final String PARM_FRONT_AUTOEXPOSURE = "front-luma-adaptation";

    public static final String PARM_REAR_AUTOEXPOSURE = "rear-luma-adaptation";

//    public static final String PARM_FRIST_ENTER = "frist_enter";

    public static final String PARM_HDR = "hdr";

    public static final String PARM_FRONT_HDR = "front-hdr";

    public static final String PARM_REAR_HDR = "rear-hdr";

    public static final String PARM_ASD = "asd";

    public static final String PARM_FRONT_ASD = "front-asd";

    public static final String PARM_REAR_ASD = "rear-asd";

    public static final String HDR_OFF = "off";

    public static final String HDR_ON = "on";

    public static final String ASD_OFF = "off";

    public static final String ASD_ON = "on";

    public static final String PARM_PHOTO_FEATURES = "photo-features";

//    public static final String PARM_EFFECT = "effect";

//    public static final String PARM_FRONT_EFFECT = "front-effect";
//
//    public static final String PARM_REAR_EFFECT = "rear-effect";

    public static final String PARM_CAMCORDER_EFFECT = "camcorder-effect";

    public static final String PARM_GRID = "grid";

    public static final String PARM_REAR_GRID = "rear-grid";

    public static final String PARM_FRONT_GRID = "front-grid";

    public static final String GRID_OFF = "off";

    public static final String GRID_ON = "on";

    // GPS SharedPreference uses
    public static final String PARM_STORE_LOCATION = "store-location";

    public static final String PARM_REAR_STORE_LOCATION = "store-location";

    public static final String PARM_FRONT_STORE_LOCATION = "store-location";

    public static final String PARM_SELF_TIMER = "self-timer";

    public static final String PARM_REAR_SELF_TIMER = "rear-self-timer";

    public static final String PARM_FRONT_SELF_TIMER = "front-self-timer";

    public static final String PARM_STORAGE_SOURCE = "store-source";

//    public static final String PARM_TIMESTAMP = "photo-timestamp";

//    public static final String PARM_FRONT_TIMESTAMP = "front-photo-timestamp";

//    public static final String PARM_REAR_TIMESTAMP = "rear-photo-timestamp";

    // //MTK
    // public static final String PARM_CAMCORDER_SCENE_MODE = "scene-mode";
    // public static final String PARM_CAMCORDER_REAR_SCENE_MODE=
    // "rear-scene-mode";
    // public static final String PARM_CAMCORDER_FRONT_SCENE_MODE=
    // "front-scene-mode";

    public static final String PARM_CAMCORDER_SELF_TIMERPARM_CAMCORDER_SELF_TIMER = "self-timer";

    public static final String PARM_CAMCORDER_REAR_SELF_TIMER = "rear-self-timer";

    public static final String PARM_CAMCORDER_FRONT_SELF_TIMER = "front-self-timer";

    public static final String PARM_VIDEO_TIME_LAPSE = "time-lapse";

    public static final String PARM_CAMCORDER_STORE_LOCATION = "store-location";

    public static final String PARM_CAMCORDER_REAR_STORE_LOCATION = "store-location";

    public static final String PARM_CAMCORDER_FRONT_STORE_LOCATION = "store-location";

    public static final String PARM_CAMCORDER_FLASH = "cam-flash-mode";

    public static final String PARM_REAR_CAMCORDER_FLASH = "rear-cam-flash-mode";

    public static final String PARM_FRONT_CAMCORDER_FLASH = "front-cam-flash-mode";

    public static final String PARM_MICROPHONE = "microphone-mode";

    public static final String PARM_REAR_MICROPHONE = "rear-microphone-mode";

    public static final String PARM_FRONT_MICROPHONE = "front-microphone-mode";

    public static final String SOUND_UNMUTE = "on";

    public static final String SOUND_MUTE = "off";

    public static final String PARM_RECORD_FOR_YOUTUBE = "record-for-youtube";

    public static final String PARM_FRONT_RECORD_FOR_YOUTUBE = "front-record-for-youtube";

    public static final String PARM_REAR_RECORD_FOR_YOUTUBE = "rear-record-for-youtube";

    public static final String PARM_LIVE_EFFECT = "live-effect";

    public static final String PARM_FRONT_LIVE_EFFECT = "front-live-effect";

    public static final String PARM_REAR_LIVE_EFFECT = "rear-live-effect";

    public static final String YOUTUBE_OFF = "false";

    public static final String YOUTUBE_ON = "true";

    public static final String PARM_CAMCORDER_RECORD_MODE = "Camcorder-record-mode";

    public static final String PARM_VIDEO_SIZE = "video-size";

    public static final String PARM_TEMP_VIDEO_SIZE = "temp-video-size";

//    public static final String PARM_FRONT_VIDEO_SIZE = "front-video-size";

    public static final String PARM_REAR_VIDEO_SIZE = "rear-video-size";

    public static final String PARM_AUDIO_MODE = "audio-mode";

    public static final String PARM_AUDIO_MODE_STOP = "audio-stop";

    public static final String PARM_AUDIO_MODE_MUTE = "audio-mute";

    public static final String PARM_AUDIO_MODE_NORMAL = "audio-normal";

    public static final String PARM_AUDIO_MODE_SCENE = "audio-scene";

    public static final String PARM_AUDIO_MODE_NARRATOR = "audio-narrator";

    public static final String PARM_AUDIO_MODE_INTERVIEW = "audio-interview";

    // MTK c8 add feature start
    public static final String PARM_ISO = "iso-value";

//    public static final String PARM_FRONT_EXPOSURE_VALUE = "front-exposure-value";

//    public static final String PARM_EXPOSURE_VALUE = "exposure-value";

    public static final String AE_METER = "ae_meter";

    public static final String PARM_HUE_VALUE = "hue_value";

    public static final String PARM_CAMCODER_EXPOSURE = "camcoder-exposure";

    public static final String PARM_CAMCODER_FOCUSMODE = "camcoder-focusmode";

    public static final String PARM_CAMCODER_SCENEMODE = "camcoder-scenemode";

    public static final String PARM_CAMCODER_MUTE = "camcoder-mute";

    // value
    public static final String EXPOSURE_DEFAULT_VALUE = "0";

    public static final String AE_METER_DEFAULT_VALUE = "center";

    public static final String HUE_DEFAULT_VALUE = "50";

    public static final String CAMCODE_FOCUSMODE_DEFAULT_VALUE = "continuous-video";

    public static final String CAMCODE_SCENEMODE_DEFAULT_VALUE = "auto";

    // c8 add feature end
    // public static final String CAPTUREMODE_BURST = "burst";
    public static final String SPLIT_LINE = "split-line";

    public static final String CAPTUREMODE_BURST_COUNT = "capturemode_burst_count";

    public static final String ZSD_MODE = "zsd_mode";

    public static final String VOICE_CONTROL = "voicecontrol";

    public static final String PRIVATE_ALBUM = "private_album";

    public static final String CAPTUREMODE_BURST_COUNT_DEFAULT_VALUE = "8";

    public static final String ZSD_MODE_OFF = "off";

    public static final String ZSD_MODE_ON = "on";

    public static final String VOICE_CONTROL_DEFAULT_DEFAULT_VALUE = "off";

    // [A3 Handler Message Defined]
    // Camera
    public static final int FIRST_TIME_INIT = 1;

    public static final int RESTART_PREVIEW = 2;

    public static final int CLEAR_SCREEN_DELAY = 3;

    public static final int RESET_REMAINPICNUM = 4;

    public static final int RESET_PICTURESIZE = 5;

    public static final int FINISH_CAMERA = 6;

    public static final int RECHECK_STORAGE = 7;

    public static final int CANCEL_WAITHINT = 8;

    // public static final int BACK_TO_SETTING = 9;
    public static final int FIRST_FRAME_INIT_RESOURCE = 9;

    public static final int ACTION_FOCUS_CLICK = 10;

    public static final int SET_FD_MODE = 11;

    public static final int FD_DO_FOCUS_SHOT = 12;

    public static final int SET_FRAMELAYOUT_SIZE = 13;

    public static final int DO_IMAGE_CAPTURE_SNAP = 14;

    public static final int CAMERA_GPS_ON = 15;// A5

    public static final int CAMERA_GPS_OFF = 16;// A5

    public static final int CAMERA_MENU_SETTING_CHANGED = 17;// A5 Capture mode,
                                                             // Effect, ISO,
                                                             // Auto-Exposure,
                                                             // Time stamp,
                                                             // Review duration,
                                                             // JPEG quality,
                                                             // Anti-banding and
                                                             // Reset to
                                                             // default.

    public static final int DO_PANORAMA = 18;

    public static final int FRONT_ACTIONBUTTON_CLICK = 19;

    public static final int REAR_ACTIONBUTTON_CLICK = 20;

    public static final int STORAGE_CHANGE = 21;

    public static final int SHOW_RESET_MSG = 22;

    // Video
    public static final int VIDEO_INIT_RECORDER = 1;

    public static final int VIDEO_CLEAR_SCREEN_DELAY = 2;

    public static final int VIDEO_UPDATE_RECORD_TIME = 3;

    public static final int VIDEO_RESTART_PREVIEW = 4;

    public static final int VIDEO_RELEASE_RECORDER = 5;

    public static final int VIDEO_RESTART_WHITEBALANCE = 6;

    public static final int VIDEO_BLINK_RECORD_INDICATOR = 7;

    public static final int VIDEO_SET_ZOOMCONTROL_VISIBLE = 8;

    public static final int VIDEO_CAMERA_SET_PARAMETERS = 9;

    public static final int VIDEO_SET_FLASH = 10;

    public static final int VIDEO_MENU_SETTING_CHANGED = 11;// A5 Video format,
                                                            // Record video for
                                                            // Youtube and Reset
                                                            // to default.

    public static final int VIDEO_FINISH_CAMCORDER = 12;

    public static final int VIDEO_RESTART_ANTIBANDING = 13;// A5 Anti-banding,

    public static final int VIDEO_STORAGE_CHANGE = 14;

    public static final int VIDEO_FIRST_FRAME_INIT_RESOURCE = 15;

    public static final int VIDEO_SHOW_RESET_MSG = 16;

    // Menu Quick Setting Panel
    public static final int MAX_CAMERA_QUICK_SETTING_LY = 4;

    public static final int MAX_VIDEO_QUICK_SETTING_LY = 2;

    public static final int QUICK_SETTING_PHOTOQUALITY = 0;

    public static final int QUICK_SETTING_WHITE_BALANCE = 1;

    public static final int QUICK_SETTING_BRIGHTNESS = 2;

    public static final int QUICK_SETTING_TIMER = 3;

    // AcerCameraDialog CallBack Button Style
    public static final int DIALOG_CALLBACKBTN_DEFAULT = 0; // Ok & Cancel

    public static final int DIALOG_CALLBACKBTN_DONE = 1; // Done

    // Mode
    public static final int MODE_CAMERA = 1;

    public static final int MODE_CAMCORDER = 2;

    // A5 Switch Camera Id
    public static final int SWITCH_REAR_CAMERA_ID = 0;

    public static final int SWITCH_FRONT_CAMERA_ID = 1;

    // Fd Init State
    public static final int FD_UNINIT = 1;

    public static final int FD_UNSUPPORT = 2;

    public static final int FD_INITED = 3;

    public static final String MPEG4_DEFAULT_SIZE = "1280x720";

    public static final String H263_DEFAULT_SIZE = "720x480";

    public static final String PRIVATE_MPEG4_DEFAULT_SIZE = "720p";

    public static final String PRIVATE_H263_DEFAULT_SIZE = "480p";

    public static final String DEFAULT_VIDEO_FORMAT = "m4v";

    public static final String IMAGE_FOCUS = "auto";

    public static final String PHOTO_FILE_NAME = "photo.name";

    public static final String Video_1080p = CamcorderProfile.QUALITY_1080P + "";

    public static final String Video_720p = CamcorderProfile.QUALITY_720P + "";

    public static final String Video_480p = CamcorderProfile.QUALITY_480P + "";

    public static final String Video_VGA = CamcorderProfile.QUALITY_480P + "";

    public static final String Video_QVGA = CamcorderProfile.QUALITY_QVGA + "";

    public static final String Video_CIF = CamcorderProfile.QUALITY_CIF + "";

    public static final String Video_QCIF = CamcorderProfile.QUALITY_QCIF + "";

    public static final String Video_FRONT = CamcorderProfile.QUALITY_HIGH + "";

    public static final String ISO_AUTO = "AcerParameters.ACER_ISO_AUTO";

    public static final String ISO_100 = "AcerParameters.ACER_ISO_100";

    public static final String ISO_200 = "AcerParameters.ACER_ISO_200";

    public static final String ISO_400 = "AcerParameters.ACER_ISO_400";

    public static final String ISO_800 = "AcerParameters.ACER_ISO_800";

    public static final String ISO_1600 = "AcerParameters.ACER_ISO_1600";

    public static final String ISO_DEFAULT_VALUE = ISO_AUTO;

    // MTK A10 16:9 Picture size
    public static final String WIDE_10M = "4096x2304";

    public static final String WIDE_6M = "3328x1872";

    public static final String WIDE_4M = "2560x1440";

    public static final String WIDE_2M = "1792x1008";

    public static final String WIDE_1M = "1280x720";


    // public static final String WIDE_4M = "2560x1440";
    // public static final String WIDE_2M = "2048x1152";
    // public static final String WIDE_1M = "1600x900";
    // MTK A10 4:3 Picture size

    public static final String REGULAR_13M = "4160x3120";

    public static final String REGULAR_8M = "3264x2448";

    public static final String REGULAR_5M = "2560x1920";

    public static final String REGULAR_3M = "2048x1536";

    public static final String REGULAR_2M = "1600x1200";



    // public static final String REGULAR_5M = "2560x1920";
    // public static final String REGULAR_3M = "2048x1536";
    // public static final String REGULAR_2M = "1600x1200";
    // public static final String REGULAR_1M = "1200x900";

    public static final String SQUARE_4M = "2000x2000";

    public static final String SQUARE_2M = "1400x1400";

    public static final String SQUARE_1M = "1000x1000";

    public static final String METERING_SPOT = "spot";

    public static final String METERING_CENTER = "center";

    public static final String METERING_MATRIX = "matrix";

    public static final String METERING_AREA_EXPOSURE = "area_exposure";

    // "spot","center","matrix","area_exposure"
    private static CameraEnvironment mEnv = new CameraEnvironment();

    // defaults of sharedPreference
    private TreeMap<String, String> mSettingDefaults = new TreeMap<String, String>();

    public static String getPicSize(String PreviewRatio, String pictureLevel, boolean isRearLen) {
        String result = CameraEnvironment.REGULAR_8M; // the default value
        Log.d("CameraSettings", "getPicSize -  PreviewRatio:" + PreviewRatio);
        Log.d("CameraSettings", "getPicSize -  pictureLevel:" + pictureLevel);

        if (isRearLen) {
            if (PreviewRatio.equals(CameraEnvironment.RATIO_4X3)) {
                if (pictureLevel.equals(PICTURE_LEVEL_1)) {
                    result = CameraEnvironment.REGULAR_13M;
                } else if (pictureLevel.equals(PICTURE_LEVEL_2)) {
                    result = CameraEnvironment.REGULAR_8M;
                } else if (pictureLevel.equals(PICTURE_LEVEL_3)) {
                    result = CameraEnvironment.REGULAR_5M;
                } else if (pictureLevel.equals(PICTURE_LEVEL_4)) {
                    result = CameraEnvironment.REGULAR_3M;
                } else if (pictureLevel.equals(PICTURE_LEVEL_5)) {
                    result = CameraEnvironment.REGULAR_2M;
                }
            } else if (PreviewRatio.equals(CameraEnvironment.RATIO_16X9)) {
                if (pictureLevel.equals(PICTURE_LEVEL_1)) {
                    result = CameraEnvironment.WIDE_10M;
                } else if (pictureLevel.equals(PICTURE_LEVEL_2)) {
                    result = CameraEnvironment.WIDE_6M;
                } else if (pictureLevel.equals(PICTURE_LEVEL_3)) {
                    result = CameraEnvironment.WIDE_4M;
                } else if (pictureLevel.equals(PICTURE_LEVEL_4)) {
                    result = CameraEnvironment.WIDE_2M;
                } else if (pictureLevel.equals(PICTURE_LEVEL_5)) {
                    result = CameraEnvironment.WIDE_1M;
                }
            } else if (PreviewRatio.equals(CameraEnvironment.RATIO_1X1)) {
                if (pictureLevel.equals(PICTURE_LEVEL_1)) {
                    result = CameraEnvironment.SQUARE_4M;
                } else if (pictureLevel.equals(PICTURE_LEVEL_2)) {
                    result = CameraEnvironment.SQUARE_2M;
                } else if (pictureLevel.equals(PICTURE_LEVEL_3)
                        || pictureLevel.equals(PICTURE_LEVEL_4)) {
                    result = CameraEnvironment.SQUARE_1M;
                }
            }
        } else {
            if (PreviewRatio.equals(CameraEnvironment.RATIO_4X3)) {
                result = CameraEnvironment.REGULAR_2M;
            } else if (PreviewRatio.equals(CameraEnvironment.RATIO_16X9)) {
                result = CameraEnvironment.WIDE_1M;
            } else if (PreviewRatio.equals(CameraEnvironment.RATIO_1X1)) {
                result = CameraEnvironment.SQUARE_2M;
            }
        }
        Log.d("CameraSettings", "getPicSize -  result:" + result);
        return result;
    }

    // defaults of antibanding based on MCC
    // Only A1D
    // private TreeMap<String,String> mAntiBandingTable = new
    // TreeMap<String,String>();

    private CameraEnvironment() {
        this.mSettingDefaults.put(PARM_CAPTURE_MODE, CAPTUREMODE_NORMAL);
        this.mSettingDefaults.put(PARM_SCENE_MODE, SCENE_OFF);
//        this.mSettingDefaults.put(PARM_EFFECT, EFFECT_NONE);
        this.mSettingDefaults.put(PARM_RECORD_MODE, RECORD_MODE_NORMAL);
        this.mSettingDefaults.put(PARM_CAMCORDER_SCENE_MODE, SCENE_OFF);
        this.mSettingDefaults.put(PARM_CAMCORDER_EFFECT, EFFECT_NONE);
        this.mSettingDefaults.put(PARM_WHITE_BALANCE, WB_AUTO);
        this.mSettingDefaults.put(PARM_SELF_TIMER, TIMER_OFF);
        this.mSettingDefaults.put(PARM_METERING_MODE, EXPOSURE_METERING_MODE_AVERAGE);
        this.mSettingDefaults.put(PARM_REAR_WHITE_BALANCE, "auto");
        this.mSettingDefaults.put(PARM_FRONT_WHITE_BALANCE, "auto");
        this.mSettingDefaults.put(PARM_PHOTO_4X3_LEVEL, "0");
        this.mSettingDefaults.put(PARM_PHOTO_16X9_LEVEL, "0");
//        this.mSettingDefaults.put(PARM_FRONT_PHOTO_4X3_LEVEL, "0");
//        this.mSettingDefaults.put(PARM_FRONT_PHOTO_16X9_LEVEL, "0");
        //this.mSettingDefaults.put(PARM_BRIGHTNESS, "50");
        this.mSettingDefaults.put(PARM_FRONT_BRIGHTNESS, "50");
        //this.mSettingDefaults.put(PARM_CONTRAST, "50");
        this.mSettingDefaults.put(PARM_FRONT_CONTRAST, "50");
        //this.mSettingDefaults.put(PARM_SATURATION, "50");
        this.mSettingDefaults.put(PARM_FRONT_SATURATION, "50");
        //this.mSettingDefaults.put(PARM_SHARPNESS, "50");
        this.mSettingDefaults.put(PARM_FRONT_SHARPNESS, "50");

        this.mSettingDefaults.put(PARM_Ratio, "16x9");

        this.mSettingDefaults.put(PARM_REAR_SCENE_MODE, "auto");
        this.mSettingDefaults.put(PARM_FRONT_SCENE_MODE, "auto");

        this.mSettingDefaults.put(PARM_CAMERA_FLASH, "auto");
        this.mSettingDefaults.put(PARM_FRONT_CAMERA_FLASH, "off");
        this.mSettingDefaults.put(PARM_REAR_CAMERA_FLASH, "off");

        this.mSettingDefaults.put(PARM_REAR_AUTOEXPOSURE, "0");
        this.mSettingDefaults.put(PARM_FRONT_AUTOEXPOSURE, "0");

        this.mSettingDefaults.put(PARM_ASD, "off");
        this.mSettingDefaults.put(PARM_FRONT_ASD, "off");
        this.mSettingDefaults.put(PARM_REAR_ASD, "off");

        this.mSettingDefaults.put(PARM_PHOTO_FEATURES, Parameters.EFFECT_NONE);
        this.mSettingDefaults.put(PARM_GRID, "off");
        this.mSettingDefaults.put(PARM_REAR_GRID, "off");
        this.mSettingDefaults.put(PARM_FRONT_GRID, "off");

        this.mSettingDefaults.put(PARM_STORE_LOCATION, "off");
        this.mSettingDefaults.put(PARM_REAR_STORE_LOCATION, "off");
        this.mSettingDefaults.put(PARM_FRONT_STORE_LOCATION, "off");

        this.mSettingDefaults.put(PARM_REAR_SELF_TIMER, "0");
        this.mSettingDefaults.put(PARM_FRONT_SELF_TIMER, "0");

        this.mSettingDefaults.put(PARM_STORAGE_SOURCE, "internal");

//        this.mSettingDefaults.put(PARM_TIMESTAMP, "disable");
//        this.mSettingDefaults.put(PARM_REAR_TIMESTAMP, "disable");
//        this.mSettingDefaults.put(PARM_FRONT_TIMESTAMP, "disable");

        this.mSettingDefaults.put(PARM_VIDEO_EIS, "off");
        this.mSettingDefaults.put(PARM_VIDEO_FRONT_EIS, "off");
        this.mSettingDefaults.put(PARM_VIDEO_REAR_EIS, "off");

        this.mSettingDefaults.put(PARM_VIDEO_HDR, "off");
        this.mSettingDefaults.put(PARM_CAMCORDER_RECORD_MODE, "normal");

        this.mSettingDefaults.put(PARM_CAMCORDER_FLASH, "off");
        this.mSettingDefaults.put(PARM_REAR_CAMCORDER_FLASH, "off");
        this.mSettingDefaults.put(PARM_FRONT_CAMCORDER_FLASH, "off");

        this.mSettingDefaults.put(PARM_MICROPHONE, "on");
        this.mSettingDefaults.put(PARM_REAR_MICROPHONE, "on");
        this.mSettingDefaults.put(PARM_FRONT_MICROPHONE, "on");

        this.mSettingDefaults.put(PARM_RECORD_FOR_YOUTUBE, "false");
        this.mSettingDefaults.put(PARM_REAR_RECORD_FOR_YOUTUBE, "false");
        this.mSettingDefaults.put(PARM_FRONT_RECORD_FOR_YOUTUBE, "false");

        this.mSettingDefaults.put(PARM_LIVE_EFFECT, "none");
        this.mSettingDefaults.put(PARM_REAR_LIVE_EFFECT, "none");
        this.mSettingDefaults.put(PARM_FRONT_LIVE_EFFECT, "none");
        this.mSettingDefaults.put(PARM_VIDEO_SIZE, "0");

        this.mSettingDefaults.put(PARM_REAR_VIDEO_SIZE, "0");
//        this.mSettingDefaults.put(PARM_FRONT_VIDEO_SIZE, "0");
        this.mSettingDefaults.put(PARM_STORE_LOCATION, "false");
        this.mSettingDefaults.put(PARM_SELF_TIMER, "0");
        this.mSettingDefaults.put(PARM_REAR_SELF_TIMER, "0");
        this.mSettingDefaults.put(PARM_FRONT_SELF_TIMER, "0");

//        this.mSettingDefaults.put(PARM_FRIST_ENTER, "true");
//        this.mSettingDefaults.put(PARM_REAR_CAPTURE_MODE, "normal");
        this.mSettingDefaults.put(PARM_FRONT_CAPTURE_MODE, "normal");

        this.mSettingDefaults.put(PARM_CAMCORDER_FLASH, "off");
        this.mSettingDefaults.put(PARM_FRONT_CAMCORDER_FLASH, "off");
        this.mSettingDefaults.put(PARM_REAR_CAMCORDER_FLASH, "off");

        // add 07_04
        this.mSettingDefaults.put(PARM_ISO, ISO_DEFAULT_VALUE);
//        this.mSettingDefaults.put(PARM_EXPOSURE_VALUE, EXPOSURE_DEFAULT_VALUE);
//        this.mSettingDefaults.put(PARM_FRONT_EXPOSURE_VALUE, EXPOSURE_DEFAULT_VALUE);
        this.mSettingDefaults.put(AE_METER, AE_METER_DEFAULT_VALUE);
        this.mSettingDefaults.put(PARM_CAMCODER_FOCUSMODE, CAMCODE_FOCUSMODE_DEFAULT_VALUE);
        this.mSettingDefaults.put(PARM_AUDIO_MODE, CameraEnvironment.PARM_AUDIO_MODE_NORMAL);
        this.mSettingDefaults.put(PARM_CAMCODER_SCENEMODE, CAMCODE_SCENEMODE_DEFAULT_VALUE);
        //
        this.mSettingDefaults.put(SPLIT_LINE, "false");
        this.mSettingDefaults.put(CAPTUREMODE_BURST_COUNT, CAPTUREMODE_BURST_COUNT_DEFAULT_VALUE);
        this.mSettingDefaults.put(VOICE_CONTROL, VOICE_CONTROL_DEFAULT_DEFAULT_VALUE);
        this.mSettingDefaults.put(PRIVATE_ALBUM, "off");

        this.mSettingDefaults.put(PARM_FACE_BEAUTY_SMOOTH, "0");
        // seekbar 50 = device value 2,skin color medium value is 2
        this.mSettingDefaults.put(PARM_FACE_BEAUTY_SKIN, "50");
        this.mSettingDefaults.put(PARM_FACE_BEAUTY_SHARP, "0");
        this.mSettingDefaults.put(PARM_FACE_BEAUTY_SLIM, "off");
        this.mSettingDefaults.put(PARM_FACE_BEAUTY_BIG_EYES, "off");

        this.mSettingDefaults.put(PARM_CAMCODER_MUTE, "off");
        this.mSettingDefaults.put(PARM_VIDEO_TIME_LAPSE, "1000");

        this.mSettingDefaults.put(PARM_FAVORITE_SHOT, CAPTUREMODE_BRIGHT_MAGIC);
        this.mSettingDefaults.put(PARM_CONTINOUS_SHUTTER, "on");
        this.mSettingDefaults.put(PARM_OBJECT_TRACKING, "off");
        this.mSettingDefaults.put(PARM_TOUCH_TO_CAPTURE, "off");
        this.mSettingDefaults.put(PARM_POSTURE_DETECTION, "off");
        this.mSettingDefaults.put(PARM_NOISE_REDUCTION, "off");
        this.mSettingDefaults.put(PARM_AUDIO_MODE, CameraEnvironment.PARM_AUDIO_MODE_NORMAL);
        this.mSettingDefaults.put(PARM_Ratio, CameraEnvironment.RATIO_16X9);
    }

    public static CameraEnvironment getInstance() {
        return mEnv;
    }

    public String getDefaults(String cameraKey) {
        return this.mSettingDefaults.get(cameraKey);
    }

    public TreeMap<String, String> getDefaults() {
        return this.mSettingDefaults;
    }
}
