/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.camerasettingui.exist;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.admin.DevicePolicyManager;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Size;
import android.location.Location;
import android.media.CamcorderProfile;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import com.example.camerasettingui.R;




/**
 * Collection of utility functions used in this package.
 */
public class Util {
    private static final String TAG = "AcerUtil";
    private static final int DIRECTION_LEFT = 0;
    private static final int DIRECTION_RIGHT = 1;
    private static final int DIRECTION_UP = 2;
    private static final int DIRECTION_DOWN = 3;

    private static final float DEFAULT_CAMERA_BRIGHTNESS = 0.8f;

    // Orientation hysteresis amount used in rounding, in degrees
    public static final int ORIENTATION_HYSTERESIS = 5;

    public static final String REVIEW_ACTION = "com.android.camera.action.REVIEW";

    // Private intent extras. Test only.
    private static final String EXTRAS_CAMERA_FACING =
            "android.intent.extras.CAMERA_FACING";
    private static final String EXTRAS_PICTURE_RATIO =
            "android.intent.extras.picture.ratio";
    private static final String EXTRAS_ImmediateNote =
            "android.intent.extras.immediate.note";
    private static boolean sIsTabletUI;
    private static float sPixelDensity = 1;
    private static ImageFileNamer sImageFileNamer;

    public static HashMap<String, Integer> jpegFileSizeMap = new HashMap<String, Integer>();
    private static String mModelName = null;

    private Util() {
    }

    public static void initialize(Context context) {
        sIsTabletUI = (context.getResources().getConfiguration().screenWidthDp >= 1024);

        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager)
                context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        sPixelDensity = metrics.density;
        sImageFileNamer = new ImageFileNamer(
                context.getString(R.string.image_file_name_format));
        jpegFileSizeMap.put("2560x1440", 2560*1440);
        jpegFileSizeMap.put("2048x1152", 2048*1152);
        jpegFileSizeMap.put("1600x900", 1600*900);
        jpegFileSizeMap.put("2560x1920", 2560*1920);
        jpegFileSizeMap.put("2048x1536", 2048*1536);
        jpegFileSizeMap.put("1600x1200", 1600*1200);
        jpegFileSizeMap.put("1200x900", 1200*900);
        jpegFileSizeMap.put("2000x2000", 2000*2000);
        jpegFileSizeMap.put("1400x1400", 1400*1400);
        jpegFileSizeMap.put("1000x1000", 1000*1000);

        jpegFileSizeMap.put("4208x3120", 4208*3120);
        jpegFileSizeMap.put("4000x3000", 4000*3000);
        jpegFileSizeMap.put("3200x2400", 3200*2400);
        jpegFileSizeMap.put("2592x1944", 2592*1944);
        jpegFileSizeMap.put("2592x1936", 2592*1936);

        jpegFileSizeMap.put("2560x1920", 2560*1920);
        jpegFileSizeMap.put("2048x1536", 2048*1536);
        jpegFileSizeMap.put("1920x1080", 1920*1080);
        jpegFileSizeMap.put("1600x1200", 1600*1200);
        jpegFileSizeMap.put("1280x960", 1280*960);

        jpegFileSizeMap.put("1280x768", 1280*768);
        jpegFileSizeMap.put("1280x720", 1280*720);
        jpegFileSizeMap.put("1024x768", 1024*768);
        jpegFileSizeMap.put("800x600", 800*600);
        jpegFileSizeMap.put("800x480", 800*480);

        jpegFileSizeMap.put("640x480", 640*480);
        jpegFileSizeMap.put("352x288", 352*288);
        jpegFileSizeMap.put("320x240", 320*240);
        jpegFileSizeMap.put("176x144", 176*144);

        //MTK S3
        jpegFileSizeMap.put(CameraEnvironment.REGULAR_13M, 4160*3120);
        jpegFileSizeMap.put(CameraEnvironment.REGULAR_8M, 3264*2448);
        jpegFileSizeMap.put(CameraEnvironment.REGULAR_5M, 2560*1920);
        jpegFileSizeMap.put(CameraEnvironment.REGULAR_3M, 2048*1536);
        jpegFileSizeMap.put(CameraEnvironment.REGULAR_2M, 1600*1200);
        jpegFileSizeMap.put(CameraEnvironment.WIDE_10M, 4096*2304);
        jpegFileSizeMap.put(CameraEnvironment.WIDE_6M, 3328*1872);
        jpegFileSizeMap.put(CameraEnvironment.WIDE_4M, 2560*1440);
        jpegFileSizeMap.put(CameraEnvironment.WIDE_2M, 1792*1008);
        jpegFileSizeMap.put(CameraEnvironment.WIDE_1M, 1280*720);

    }

    public static boolean isTabletUI() {
        return sIsTabletUI;
    }

    public static int dpToPixel(int dp) {
        return Math.round(sPixelDensity * dp);
    }

    public static int dpToPixel(float dp) {
        return Math.round(sPixelDensity * dp);
    }

    // Rotates the bitmap by the specified degree.
    // If a new bitmap is created, the original bitmap is recycled.
    public static Bitmap rotate(Bitmap b, int degrees) {
        return rotateAndMirror(b, degrees, false);
    }

    public static Bitmap rotateWithNewOne(Bitmap b, int degrees) {
        Bitmap b2 = null;
        if ((degrees != 0) && b != null) {
            Matrix m = new Matrix();

            if (degrees != 0) {
                // clockwise
                m.postRotate(degrees,
                        (float) b.getWidth() / 2, (float) b.getHeight() / 2);
            }

            try {
                b2 = Bitmap.createBitmap(
                        b, 0, 0, b.getWidth(), b.getHeight(), m, true);

            } catch (OutOfMemoryError ex) {
                // We have no memory to rotate. Return the original bitmap.
            }
        }
        return b2;
    }

    // Rotates and/or mirrors the bitmap. If a new bitmap is created, the
    // original bitmap is recycled.
    public static Bitmap rotateAndMirror(Bitmap b, int degrees, boolean mirror) {
        if ((degrees != 0 || mirror) && b != null) {
            Matrix m = new Matrix();
            // Mirror first.
            // horizontal flip + rotation = -rotation + horizontal flip
            if (mirror) {
                m.postScale(-1, 1);
                degrees = (degrees + 360) % 360;
                if (degrees == 0 || degrees == 180) {
                    m.postTranslate((float) b.getWidth(), 0);
                } else if (degrees == 90 || degrees == 270) {
                    m.postTranslate((float) b.getHeight(), 0);
                } else {
                    throw new IllegalArgumentException("Invalid degrees=" + degrees);
                }
            }
            if (degrees != 0) {
                // clockwise
                m.postRotate(degrees,
                        (float) b.getWidth() / 2, (float) b.getHeight() / 2);
            }

            try {
                Bitmap b2 = Bitmap.createBitmap(
                        b, 0, 0, b.getWidth(), b.getHeight(), m, true);
                if (b != b2) {
                    b.recycle();
                    b = b2;
                }
            } catch (OutOfMemoryError ex) {
                // We have no memory to rotate. Return the original bitmap.
            }
        }
        return b;
    }

    /*
     * Compute the sample size as a function of minSideLength
     * and maxNumOfPixels.
     * minSideLength is used to specify that minimal width or height of a
     * bitmap.
     * maxNumOfPixels is used to specify the maximal size in pixels that is
     * tolerable in terms of memory usage.
     *
     * The function returns a sample size based on the constraints.
     * Both size and minSideLength can be passed in as -1
     * which indicates no care of the corresponding constraint.
     * The functions prefers returning a sample size that
     * generates a smaller bitmap, unless minSideLength = -1.
     *
     * Also, the function rounds up the sample size to a power of 2 or multiple
     * of 8 because BitmapFactory only honors sample size this way.
     * For example, BitmapFactory downsamples an image by 2 even though the
     * request is 3. So we round up the sample size to avoid OOM.
     */
    public static int computeSampleSize(BitmapFactory.Options options,
            int minSideLength, int maxNumOfPixels) {
        int initialSize = computeInitialSampleSize(options, minSideLength,
                maxNumOfPixels);

        int roundedSize;
        if (initialSize <= 8) {
            roundedSize = 1;
            while (roundedSize < initialSize) {
                roundedSize <<= 1;
            }
        } else {
            roundedSize = (initialSize + 7) / 8 * 8;
        }

        return roundedSize;
    }

    private static int computeInitialSampleSize(BitmapFactory.Options options,
            int minSideLength, int maxNumOfPixels) {
        double w = options.outWidth;
        double h = options.outHeight;

        int lowerBound = (maxNumOfPixels < 0) ? 1 :
                (int) Math.ceil(Math.sqrt(w * h / maxNumOfPixels));
        int upperBound = (minSideLength < 0) ? 128 :
                (int) Math.min(Math.floor(w / minSideLength),
                Math.floor(h / minSideLength));

        if (upperBound < lowerBound) {
            // return the larger one when there is no overlapping zone.
            return lowerBound;
        }

        if (maxNumOfPixels < 0 && minSideLength < 0) {
            return 1;
        } else if (minSideLength < 0) {
            return lowerBound;
        } else {
            return upperBound;
        }
    }

    public static Bitmap makeBitmap(byte[] jpegData, int maxNumOfPixels) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(jpegData, 0, jpegData.length,
                    options);
            if (options.mCancel || options.outWidth == -1
                    || options.outHeight == -1) {
                return null;
            }
            options.inSampleSize = computeSampleSize(
                    options, -1, maxNumOfPixels);
            options.inJustDecodeBounds = false;

            options.inDither = false;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return BitmapFactory.decodeByteArray(jpegData, 0, jpegData.length,
                    options);
        } catch (OutOfMemoryError ex) {
            AcerLog.e(TAG, "Got oom exception ", ex);
            return null;
        }
    }

    public static void closeSilently(Closeable c) {
        if (c == null) return;
        try {
            c.close();
        } catch (Throwable t) {
            // do nothing
        }
    }

    public static void Assert(boolean cond) {
        if (!cond) {
            throw new AssertionError();
        }
    }

    public static void assertError(boolean cond) {
        if (!cond) {
            throw new AssertionError();
        }
    }

    public static String getModelName() {
//        if(mModelName == null)
//            mModelName = SystemProperties.get("ro.product.model").toLowerCase();
//        AcerLog.d(TAG, "getModelName : " + mModelName);
        return mModelName;
    }

    public static boolean isS53() {
        //AcerLog.d(TAG, "SystemProperties.get : " + SystemProperties.get("ro.product.model").toLowerCase());
        if (getModelName().contains("s53")){
            AcerLog.d("test", "SystemProperties.contains e39");
            return true;
        }
        return false;
    }

    public static boolean isS56S57() {
        //AcerLog.d(TAG, "SystemProperties.get : " + SystemProperties.get("ro.product.model").toLowerCase());
        if (getModelName().contains("s56") || getModelName().contains("s57")){
            AcerLog.d("test", "SystemProperties.contains s56/s57");
            return true;
        }
        return false;
    }

    public static boolean isS59() {
        //AcerLog.d(TAG, "SystemProperties.get : " + SystemProperties.get("ro.product.model").toLowerCase());
        if (getModelName().contains("s59") ){
            AcerLog.d("test", "SystemProperties.contains s59(E800)");
            return true;
        }
        return false;
    }

    public static boolean isZ630Z530() {
        //AcerLog.d(TAG, "SystemProperties.get : " + SystemProperties.get("ro.product.model").toLowerCase());
        if (getModelName().contains("t03") || getModelName().contains("t02") || getModelName().contains("z630") || getModelName().contains("z530")){
            AcerLog.d("test", "SystemProperties.contains z630 / z530");
            return true;
        }
        return false;
    }

    public static boolean isZ520() {
        //AcerLog.d(TAG, "SystemProperties.get : " + SystemProperties.get("ro.product.model").toLowerCase());
        if (getModelName().contains("e39") || getModelName().contains("z520")){
            AcerLog.d("test", "SystemProperties.contains z520");
            return true;
        }
        return false;
    }

    public static boolean isZ100() {
       // AcerLog.d(TAG, "SystemProperties.get : " + SystemProperties.get("ro.product.model").toLowerCase());
        if (getModelName().contains("z100") || getModelName().contains("z220")){
            AcerLog.d("test", "SystemProperties.contains z220");
            return true;
        }
        return false;
    }

    public static boolean isZ320Z330() {
        //AcerLog.d(TAG, "SystemProperties.get : " + SystemProperties.get("ro.product.model").toLowerCase());
        if (getModelName().contains("t01") || getModelName().contains("t012") || getModelName().contains("ql861") || getModelName().contains("z320") || getModelName().contains("z330")){
            AcerLog.d("test", "SystemProperties.contains z320 / z330");
            return true;
        }
        return false;
    }


    public static boolean isSupportPrivateAlbum() {
        if(Util.isS59()) {
            return true;
        }
        return false;
    }

//    public static com.acer.camerasdk.AcerCamera openCamera(Activity activity, int cameraId)
//            throws CameraHardwareException, CameraDisabledException {
//        // Check if device policy has disabled the camera.
//        DevicePolicyManager dpm = (DevicePolicyManager) activity.getSystemService(
//                Context.DEVICE_POLICY_SERVICE);
//        if (dpm.getCameraDisabled(null)) {
//            throw new CameraDisabledException();
//        }
//
//        try {
//            return CameraHolder.instance().open(cameraId);
//        } catch (CameraHardwareException e) {
//            // In eng build, we throw the exception so that test tool
//            // can detect it and report it
//            if ("eng".equals(Build.TYPE)) {
//                throw new RuntimeException("openCamera failed", e);
//            } else {
//                throw e;
//            }
//        }
//    }

//    public static void showErrorAndFinish(final Activity activity, int msgId) {
//        DialogInterface.OnClickListener buttonListener =
//                new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//                activity.finish();
//            }
//        };
//        new AlertDialog.Builder(activity)
//                .setCancelable(false)
//                .setIconAttribute(android.R.attr.alertDialogIcon)
//                .setTitle(R.string.camera_error_title)
//                .setMessage(msgId)
//                .setPositiveButton(R.string.dialog_ok, buttonListener)
//                .show();
//    }

    public static <T> T checkNotNull(T object) {
        if (object == null) throw new NullPointerException();
        return object;
    }

    public static boolean equals(Object a, Object b) {
        return (a == b) || (a == null ? false : a.equals(b));
    }

    public static int nextPowerOf2(int n) {
        n -= 1;
        n |= n >>> 16;
        n |= n >>> 8;
        n |= n >>> 4;
        n |= n >>> 2;
        n |= n >>> 1;
        return n + 1;
    }

    public static float distance(float x, float y, float sx, float sy) {
        float dx = x - sx;
        float dy = y - sy;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public static int clamp(int x, int min, int max) {
        if (x > max) return max;
        if (x < min) return min;
        return x;
    }

    public static int getDisplayRotation(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay()
                .getRotation();
        switch (rotation) {
            case Surface.ROTATION_0: return 0;
            case Surface.ROTATION_90: return 90;
            case Surface.ROTATION_180: return 180;
            case Surface.ROTATION_270: return 270;
        }
        return 0;
    }

    public static int getDisplayOrientation(int degrees, int cameraId) {
        // See android.hardware.Camera.setDisplayOrientation for
        // documentation.
        Camera.CameraInfo info = new Camera.CameraInfo();
        Camera.getCameraInfo(cameraId, info);
        int result;
        if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
            result = (info.orientation + degrees) % 360;
            result = (360 - result) % 360;  // compensate the mirror
        } else {  // back-facing
            result = (info.orientation - degrees + 360) % 360;
        }
        return result;
    }

    public static int roundOrientation(int orientation, int orientationHistory) {
        boolean changeOrientation = false;
        if (orientationHistory == OrientationEventListener.ORIENTATION_UNKNOWN) {
            changeOrientation = true;
        } else {
            int dist = Math.abs(orientation - orientationHistory);
            dist = Math.min( dist, 360 - dist );
            changeOrientation = ( dist >= 45 + ORIENTATION_HYSTERESIS );
        }
        if (changeOrientation) {
            return ((orientation + 45) / 90 * 90) % 360;
        }
        return orientationHistory;
    }

    public static Size getOptimalVideoSnapshotPictureSizeForMMS(
            List<Size> sizes, double targetRatio) {
        if (sizes == null) return null;
        Size optimalSize = null;
        for (Size size : sizes) {
            if (size.width == 176 && size.height==144) {
                optimalSize = size;
            }
        }
        return optimalSize;
    }
    // Returns the largest picture size which matches the given aspect ratio.
    public static Size getOptimalVideoSnapshotPictureSize(
            List<Size> sizes, double targetRatio) {
        AcerLog.w(TAG, "targetRatio : " + targetRatio);
        // Use a very small tolerance because we want an exact match.
        final double ASPECT_TOLERANCE = 0.001;
        if (sizes == null) return null;

        Size optimalSize = null;

        // Try to find a size matches aspect ratio and has the largest width
        for (Size size : sizes) {
            double ratio = (double) size.width / size.height;
            if (Math.abs(ratio - targetRatio) > ASPECT_TOLERANCE) continue;
            if (optimalSize == null || size.width > optimalSize.width) {
                optimalSize = size;
            }
        }

        // Cannot find one that matches the aspect ratio. This should not happen.
        // Ignore the requirement.
        if (optimalSize == null) {
            AcerLog.w(TAG, "No picture size match the aspect ratio");
            for (Size size : sizes) {
                if (optimalSize == null || size.width > optimalSize.width) {
                    optimalSize = size;
                }
            }
        }
        return optimalSize;
    }

//    public static void dumpParameters(AcerParameters parameters) {
//        String flattened = parameters.flatten();
//        StringTokenizer tokenizer = new StringTokenizer(flattened, ";");
//        AcerLog.d(TAG, "Dump all camera parameters:");
//        while (tokenizer.hasMoreElements()) {
//            AcerLog.d(TAG, tokenizer.nextToken());
//        }
//    }

    /**
     * Returns whether the device is voice-capable (meaning, it can do MMS).
     */
    public static boolean isMmsCapable(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager)
                context.getSystemService(Context.TELEPHONY_SERVICE);
        if (telephonyManager == null) {
            return false;
        }

        try {
            Class partypes[] = new Class[0];
            Method sIsVoiceCapable = TelephonyManager.class.getMethod(
                    "isVoiceCapable", partypes);

            Object arglist[] = new Object[0];
            Object retobj = sIsVoiceCapable.invoke(telephonyManager, arglist);
            return (Boolean) retobj;
        } catch (java.lang.reflect.InvocationTargetException ite) {
            // Failure, must be another device.
            // Assume that it is voice capable.
        } catch (IllegalAccessException iae) {
            // Failure, must be an other device.
            // Assume that it is voice capable.
        } catch (NoSuchMethodException nsme) {
        }
        return true;
    }

//    public static int getVideoQualityExtras(AcerCamera mCamera) {
//        int extraVideoQuality = -1;
//        Intent intent = mCamera.getIntent();
//        if (intent.hasExtra(MediaStore.EXTRA_VIDEO_QUALITY)) {
//            extraVideoQuality = mCamera.getIntent().getIntExtra(MediaStore.EXTRA_VIDEO_QUALITY, -1);
//            if (extraVideoQuality != CamcorderProfile.QUALITY_QCIF // acer MMS will send EXTRA_VIDEO_QUALITY as 2
//                    && extraVideoQuality != CamcorderProfile.QUALITY_1080P
//                    && extraVideoQuality != CamcorderProfile.QUALITY_720P
//                    && extraVideoQuality != CamcorderProfile.QUALITY_480P
//                    && extraVideoQuality != CamcorderProfile.QUALITY_HIGH) {
//                extraVideoQuality = CamcorderProfile.QUALITY_QCIF;
//            }
//        }
//        return extraVideoQuality;
//    }
//    public static boolean isFromImmediateNote(AcerCamera currentActivity) {
//        Bundle extras = currentActivity.getIntent().getExtras();
//        if (extras !=null) {
//            AcerLog.i(TAG, "isFromImmediateNote 1");
//            return extras.getBoolean("android.intent.extras.immediate.note");
//        } else {
//            AcerLog.i(TAG, "isFromImmediateNote 2");
//            return false;
//        }
//    }
//
//    public static String getPictureRatioIntentExtras(AcerCamera currentActivity) {
//        return currentActivity.getIntent().getStringExtra(Util.EXTRAS_PICTURE_RATIO);
//    }

    // This is for test only. Allow the camera to launch the specific camera.
//    public static int getCameraFacingIntentExtras(Activity currentActivity) {
//        int cameraId = -1;
//
//        int intentCameraId =
//                currentActivity.getIntent().getIntExtra(Util.EXTRAS_CAMERA_FACING, -1);
//
//        if (isFrontCameraIntent(intentCameraId)) {
//            // Check if the front camera exist
//            int frontCameraId = CameraHolder.instance().getFrontCameraId();
//            if (frontCameraId != -1) {
//                cameraId = frontCameraId;
//            }
//        } else if (isBackCameraIntent(intentCameraId)) {
//            // Check if the back camera exist
//            int backCameraId = CameraHolder.instance().getBackCameraId();
//            if (backCameraId != -1) {
//                cameraId = backCameraId;
//            }
//        }
//        return cameraId;
//    }

    private static boolean isFrontCameraIntent(int intentCameraId) {
        return (intentCameraId == android.hardware.Camera.CameraInfo.CAMERA_FACING_FRONT);
    }

    private static boolean isBackCameraIntent(int intentCameraId) {
        return (intentCameraId == android.hardware.Camera.CameraInfo.CAMERA_FACING_BACK);
    }

    private static int mLocation[] = new int[2];

    // This method is not thread-safe.
    public static boolean pointInView(float x, float y, View v) {
        v.getLocationInWindow(mLocation);
        return x >= mLocation[0] && x < (mLocation[0] + v.getWidth())
                && y >= mLocation[1] && y < (mLocation[1] + v.getHeight());
    }

    public static boolean isUriValid(Uri uri, ContentResolver resolver) {
        if (uri == null) return false;

        try {
            ParcelFileDescriptor pfd = resolver.openFileDescriptor(uri, "r");
            if (pfd == null) {
                AcerLog.e(TAG, "Fail to open URI. URI=" + uri);
                return false;
            }
            pfd.close();
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    public static void viewUri(Uri uri, Context context) {
        if (!isUriValid(uri, context.getContentResolver())) {
            AcerLog.e(TAG, "Uri invalid. uri=" + uri);
            return;
        }

        try {
            context.startActivity(new Intent(Util.REVIEW_ACTION, uri));
        } catch (ActivityNotFoundException ex) {
            try {
                context.startActivity(new Intent(Intent.ACTION_VIEW, uri));
            } catch (ActivityNotFoundException e) {
                AcerLog.e(TAG, "review image fail. uri=" + uri, e);
            }
        }
    }

    public static void dumpRect(RectF rect, String msg) {
        AcerLog.v(TAG, msg + "=(" + rect.left + "," + rect.top
                + "," + rect.right + "," + rect.bottom + ")");
    }

    public static void rectFToRect(RectF rectF, Rect rect) {
        rect.left = Math.round(rectF.left);
        rect.top = Math.round(rectF.top);
        rect.right = Math.round(rectF.right);
        rect.bottom = Math.round(rectF.bottom);
    }

    public static void prepareMatrix(Matrix matrix, boolean mirror, int displayOrientation,
            int viewWidth, int viewHeight) {
        // Need mirror for front camera.
        matrix.setScale(mirror ? -1 : 1, 1);
        // This is the value for android.hardware.Camera.setDisplayOrientation.
        matrix.postRotate(displayOrientation);
        // Camera driver coordinates range from (-1000, -1000) to (1000, 1000).
        // UI coordinates range from (0, 0) to (width, height).
        matrix.postScale(viewWidth / 2000f, viewHeight / 2000f);
        matrix.postTranslate(viewWidth / 2f, viewHeight / 2f);
    }

    public static String createJpegName(long dateTaken) {
        synchronized (sImageFileNamer) {
            return sImageFileNamer.generateName(dateTaken);
        }
    }

    public static void broadcastNewPicture(Context context, Uri uri) {
        context.sendBroadcast(new Intent(android.hardware.Camera.ACTION_NEW_PICTURE, uri));
        // Keep compatibility
        context.sendBroadcast(new Intent("com.android.camera.NEW_PICTURE", uri));
    }

    public static void fadeIn(View view) {
        if (view.getVisibility() == View.VISIBLE) return;

        view.setVisibility(View.VISIBLE);
        Animation animation = new AlphaAnimation(0F, 1F);
        animation.setDuration(400);
        view.startAnimation(animation);
    }

    public static void fadeOut(View view) {
        if (view.getVisibility() != View.VISIBLE) return;

        Animation animation = new AlphaAnimation(1F, 0F);
        animation.setDuration(400);
        view.startAnimation(animation);
        view.setVisibility(View.GONE);
    }

//    public static void setRotationParameter(AcerParameters parameters, int cameraId, int orientation) {
//        // See android.hardware.Camera.Parameters.setRotation for
//        // documentation.
//        int rotation = 0;
//        if (orientation != OrientationEventListener.ORIENTATION_UNKNOWN) {
//            CameraInfo info = CameraHolder.instance().getCameraInfo()[cameraId];
//            if (info.facing == CameraInfo.CAMERA_FACING_FRONT) {
//                rotation = (info.orientation - orientation + 360) % 360;
//            } else {  // back-facing camera
//                rotation = (info.orientation + orientation) % 360;
//            }
//        }else {
//            //Get the right original orientation
//            CameraInfo info = CameraHolder.instance().getCameraInfo()[cameraId];
//            rotation = info.orientation;
//        }
//        AcerLog.i(TAG, "parameters.setRotation rotatio = " + rotation);
//        if(parameters != null) parameters.setRotation(rotation);// null pointer exception.
//    }

//    public static void setGpsParameters(AcerParameters parameters, Location loc) {
//        // Clear previous GPS location from the parameters.
//        parameters.removeGpsData();
//
//        // We always encode GpsTimeStamp
//        parameters.setGpsTimestamp(System.currentTimeMillis() / 1000);
//
//        // Set GPS location.
//        if (loc != null) {
//            double lat = loc.getLatitude();
//            double lon = loc.getLongitude();
//            boolean hasLatLon = (lat != 0.0d) || (lon != 0.0d);
//
//            if (hasLatLon) {
//                AcerLog.d(TAG, "Set gps location");
//                parameters.setGpsLatitude(lat);
//                parameters.setGpsLongitude(lon);
//                parameters.setGpsProcessingMethod(loc.getProvider().toUpperCase());
//                if (loc.hasAltitude()) {
//                    parameters.setGpsAltitude(loc.getAltitude());
//                } else {
//                    // for NETWORK_PROVIDER location provider, we may have
//                    // no altitude information, but the driver needs it, so
//                    // we fake one.
//                    parameters.setGpsAltitude(0);
//                }
//                if (loc.getTime() != 0) {
//                    // Location.getTime() is UTC in milliseconds.
//                    // gps-timestamp is UTC in seconds.
//                    long utcTimeSeconds = loc.getTime() / 1000;
//                    parameters.setGpsTimestamp(utcTimeSeconds);
//                }
//            } else {
//                loc = null;
//            }
//        }
//    }

    public static void enterLightsOutMode(Window window) {
        WindowManager.LayoutParams params = window.getAttributes();
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_LOW_PROFILE;
        window.setAttributes(params);
    }

    public static void setScreenBrightness(Window win, ContentResolver resolver,float value) {
        WindowManager.LayoutParams winParams = win.getAttributes();
        winParams.screenBrightness = value;
        win.setAttributes(winParams);
    }

    public static void initializeScreenBrightness(Window win, ContentResolver resolver) {
        // Overright the brightness settings if it is automatic
//        int mode = Settings.System.getInt(resolver, Settings.System.SCREEN_BRIGHTNESS_MODE,
//                Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
//        if (mode == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC) {
        WindowManager.LayoutParams winParams = win.getAttributes();
        winParams.screenBrightness = DEFAULT_CAMERA_BRIGHTNESS;
        win.setAttributes(winParams);
//        }
    }

    private static class ImageFileNamer {
        private SimpleDateFormat mFormat;

        // The date (in milliseconds) used to generate the last name.
        private long mLastDate;

        // Number of names generated for the same second.
        private int mSameSecondCount;

        public ImageFileNamer(String format) {
            mFormat = new SimpleDateFormat(format);
        }

        public String generateName(long dateTaken) {
            Date date = new Date(dateTaken);
            String result = mFormat.format(date);

            // If the last name was generated for the same second,
            // we append _1, _2, etc to the name.
            if (dateTaken / 1000 == mLastDate / 1000) {
                mSameSecondCount++;
                result += "_" + mSameSecondCount;
            } else {
                mLastDate = dateTaken;
                mSameSecondCount = 0;
            }

            return result;
        }
    }

    public static Size getOptimalPreviewSize(Activity currentActivity,
            List<Size> sizes, double targetRatio) {
        // Use a very small tolerance because we want an exact match.
        final double ASPECT_TOLERANCE = 0.001;
        if (sizes == null) {
            return null;
        }

        Size optimalSize = null;
        double minDiff = Double.MAX_VALUE;

        // Because of bugs of overlay and layout, we sometimes will try to
        // layout the viewfinder in the portrait orientation and thus get the
        // wrong size of preview surface. When we change the preview size, the
        // new overlay will be created before the old one closed, which causes
        // an exception. For now, just get the screen size.
        Display display = currentActivity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int targetHeight = Math.min(point.x, point.y);

        // Try to find an size match aspect ratio and size
        for (Size size : sizes) {
            double ratio = (double) size.width / size.height;
            if (Math.abs(ratio - targetRatio) > ASPECT_TOLERANCE) {
                continue;
            }
            if (Math.abs(size.height - targetHeight) < minDiff) {
                optimalSize = size;
                minDiff = Math.abs(size.height - targetHeight);
            }
        }

        // Cannot find the one match the aspect ratio. This should not happen.
        // Ignore the requirement.
        /// M: This will happen when native return video size and wallpaper want to get specified ratio.
        if (optimalSize == null) {
            AcerLog.w(TAG, "No preview size match the aspect ratio" + targetRatio);
            minDiff = Double.MAX_VALUE;
            for (Size size : sizes) {
                if (Math.abs(size.height - targetHeight) < minDiff) {
                    optimalSize = size;
                    minDiff = Math.abs(size.height - targetHeight);
                }
            }
        }
        return optimalSize;
    }
    /// @}
    public static void setViewRotation(View view, int degree) {
        if (view==null) return;

        if (degree%180==0) {
            view.setRotation(degree);
        } else {
            view.setRotation((degree+180)%360);
        }
    }
//    public static Size getMAXPreviewSize(AcerCamera mAcerCamera, List<Size> sizes) {
//        if (sizes == null) {
//            return null;
//        }
//        Size optimalSize = null;
//        for (Size size : sizes) {
//            if (optimalSize ==null)
//                optimalSize = size;
//            else if (size.height*size.width > optimalSize.height*optimalSize.width)
//                optimalSize = size;
//        }
//        return optimalSize;
//    }

    public static int px2dip(Context context, float pxValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5f);
    }
}

//DefaultHashMap is a HashMap which returns a default value if the specified
//key is not found.
//
@SuppressWarnings("serial")
class DefaultHashMap<K, V> extends HashMap<K, V> {
   private V mDefaultValue;

   public void putDefault(V defaultValue) {
       mDefaultValue = defaultValue;
   }

   @Override
   public V get(Object key) {
       V value = super.get(key);
       return (value == null) ? mDefaultValue : value;
   }
}