package com.tencent.mobileqq.camera.utils;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.camera.CameraHolder;
import com.tencent.mobileqq.camera.CameraManager.CameraOpenErrorCallback;
import com.tencent.mobileqq.camera.CameraManager.CameraProxy;
import com.tencent.mobileqq.camera.adapter.CameraWrapper;
import com.tencent.mobileqq.camera.adapter.DeviceInstance;
import com.tencent.mobileqq.camera.ex.CameraDisabledException;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.InflaterInputStream;
import mqq.app.AppRuntime;
import qyu;

public class CameraUtils
{
  private static final float jdField_a_of_type_Float = 1.33F;
  private static final int jdField_a_of_type_Int = 400000;
  public static final String a = "Q.camera.CameraUtils";
  private static final float jdField_b_of_type_Float = 1.77F;
  private static final int jdField_b_of_type_Int = 30000;
  
  public CameraUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public static int a(Activity paramActivity)
  {
    switch (paramActivity.getWindowManager().getDefaultDisplay().getRotation())
    {
    default: 
      return -1;
    case 0: 
      return 0;
    case 1: 
      return 90;
    case 2: 
      return 180;
    }
    return 270;
  }
  
  public static int a(Activity paramActivity, CameraManager.CameraProxy paramCameraProxy)
  {
    paramActivity = paramCameraProxy.a().getSupportedPictureFormats().iterator();
    while (paramActivity.hasNext()) {
      if (((Integer)paramActivity.next()).intValue() == 256) {
        return 256;
      }
    }
    return 0;
  }
  
  public static int a(Activity paramActivity, List paramList, double paramDouble, int paramInt)
  {
    if (Math.abs(paramDouble - 1.3300000429153442D) < Math.abs(paramDouble - 1.7699999809265137D)) {}
    for (double d = 1.3300000429153442D; (paramList == null) || (paramList.size() == 0); d = 1.7699999809265137D)
    {
      paramInt = -1;
      return paramInt;
    }
    int j = -1;
    paramDouble = Double.MAX_VALUE;
    paramActivity = a(paramActivity, new Point());
    int k = Math.min(paramActivity.x * paramInt, paramActivity.y * paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraUtils", 2, "screen size: " + paramActivity + " targetHeight = " + k);
    }
    int i = paramList.size() - 1;
    paramInt = j;
    label145:
    if (i >= 0)
    {
      paramActivity = (Camera.Size)paramList.get(i);
      if (Math.abs(paramActivity.width / paramActivity.height - d) <= 0.02D) {}
    }
    for (;;)
    {
      i -= 1;
      break label145;
      if (Math.abs(paramActivity.height - k) < paramDouble)
      {
        paramDouble = Math.abs(paramActivity.height - k);
        paramInt = i;
        continue;
        if (paramInt == -1)
        {
          QLog.w("Q.camera.CameraUtils", 2, "No size match the aspect ratio");
          paramDouble = Double.MAX_VALUE;
          i = paramList.size();
          i -= 1;
          label262:
          j = paramInt;
          if (i < 0) {
            break label328;
          }
          paramActivity = (Camera.Size)paramList.get(i);
          if (Math.abs(paramActivity.height - k) >= paramDouble) {
            break label367;
          }
          paramDouble = Math.abs(paramActivity.height - k);
          paramInt = i;
        }
        label328:
        label367:
        for (;;)
        {
          i -= 1;
          break label262;
          j = paramInt;
          paramInt = j;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.camera.CameraUtils", 2, "[getOptimalSize] + END, optimalSizeIndex = " + j);
          return j;
        }
      }
    }
  }
  
  public static int a(Context paramContext)
  {
    return a(paramContext).getInt("qcamera_conf_version", 0);
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static int a(CameraHolder paramCameraHolder, int paramInt)
  {
    paramCameraHolder = paramCameraHolder.a()[paramInt];
    if (paramCameraHolder != null) {
      return paramCameraHolder.orientation;
    }
    return -1;
  }
  
  public static int a(CameraHolder paramCameraHolder, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 == -1) {
      i = 0;
    }
    Camera.CameraInfo localCameraInfo = paramCameraHolder.a()[paramInt1];
    if (localCameraInfo.facing == 1) {
      return (paramCameraHolder.a().a(paramInt1, localCameraInfo.orientation) - i + 360) % 360;
    }
    return (paramCameraHolder.a().a(paramInt1, localCameraInfo.orientation) + i) % 360;
  }
  
  public static int a(CameraWrapper paramCameraWrapper, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraUtils", 2, "[getDisplayOrientation] device display nature orientation = " + paramInt1);
    }
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt2, localCameraInfo);
    if (localCameraInfo.facing == 1) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraUtils", 2, "[getDisplayOrientation] is FRONT camera, hardware orientation = " + localCameraInfo.orientation);
      }
    }
    for (paramInt1 = (360 - (paramCameraWrapper.a(paramInt2, paramInt1) + paramInt1) % 360) % 360;; paramInt1 = (paramCameraWrapper.a(paramInt2, paramInt1) - paramInt1 + 360) % 360)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraUtils", 2, "[getDisplayOrientation] preview need rotate degrees = " + paramInt1);
      }
      return paramInt1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraUtils", 2, "[getDisplayOrientation] is BACK camera, hardware orientation = " + localCameraInfo.orientation);
      }
    }
  }
  
  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("qcamera_pref", 4);
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    int i = 0;
    if (paramBitmap == null)
    {
      paramBitmap = null;
      return paramBitmap;
    }
    int j = paramBitmap.getHeight();
    int k = paramBitmap.getWidth();
    if (k * paramInt2 > j * paramInt1)
    {
      paramInt2 = j * paramInt1 / paramInt2;
      k = (k - paramInt2) / 2;
      paramInt1 = j;
    }
    for (j = k;; j = 0)
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, j, i, paramInt2, paramInt1);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.camera.CameraUtils", 4, "[getMidBitmap] is bitmap mutable: " + localBitmap.isMutable());
      }
      paramBitmap = localBitmap;
      if (localBitmap.isMutable()) {
        break;
      }
      paramBitmap = Bitmap.createScaledBitmap(localBitmap, localBitmap.getWidth() / 2, localBitmap.getHeight() / 2, true);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
      return paramBitmap;
      paramInt1 = k * paramInt2 / paramInt1;
      i = (j - paramInt1) / 2;
      paramInt2 = k;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    System.currentTimeMillis();
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      if ((paramInt == 0) || (paramInt == 360)) {
        return paramBitmap;
      }
      Object localObject1 = new Matrix();
      ((Matrix)localObject1).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
      try
      {
        localObject1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject1, true);
        if ((paramBoolean) && (paramBitmap != localObject1)) {}
        localOutOfMemoryError1.printStackTrace();
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          a(paramBitmap);
          return (Bitmap)localObject1;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          for (;;)
          {
            paramBitmap = localOutOfMemoryError1;
            Object localObject2 = localOutOfMemoryError2;
          }
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        paramBitmap = null;
      }
      QLog.w("Q.camera.CameraUtils", 2, "OutOfMemoryError. ", localOutOfMemoryError1);
      return paramBitmap;
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, boolean paramBoolean)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      localObject = paramBitmap;
      if (paramBoolean)
      {
        localObject = new Matrix();
        ((Matrix)localObject).postScale(-1.0F, 1.0F);
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, false);
        a(paramBitmap);
      }
    }
    return (Bitmap)localObject;
  }
  
  public static Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
      ((BitmapFactory.Options)localObject).inSampleSize = paramInt2;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      localObject = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
      paramArrayOfByte = (byte[])localObject;
      if (paramInt1 != 0) {}
      paramArrayOfByte.printStackTrace();
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      try
      {
        paramArrayOfByte = a((Bitmap)localObject, paramInt1, true);
        localObject = paramArrayOfByte;
        if (paramArrayOfByte != null)
        {
          localObject = paramArrayOfByte;
          if (paramBoolean)
          {
            localObject = new Matrix();
            ((Matrix)localObject).postScale(-1.0F, 1.0F);
            localObject = Bitmap.createBitmap(paramArrayOfByte, 0, 0, paramArrayOfByte.getWidth(), paramArrayOfByte.getHeight(), (Matrix)localObject, false);
            a(paramArrayOfByte);
          }
        }
        return (Bitmap)localObject;
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        Object localObject;
        for (;;) {}
      }
      paramArrayOfByte = paramArrayOfByte;
      localObject = null;
    }
    return (Bitmap)localObject;
  }
  
  /* Error */
  public static Bitmap a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: iconst_0
    //   4: aload_0
    //   5: arraylength
    //   6: invokestatic 333	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   9: astore_0
    //   10: aload_0
    //   11: astore_3
    //   12: aload_3
    //   13: astore_0
    //   14: iload_1
    //   15: ifeq +10 -> 25
    //   18: aload_3
    //   19: iload_1
    //   20: iconst_1
    //   21: invokestatic 329	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Landroid/graphics/Bitmap;IZ)Landroid/graphics/Bitmap;
    //   24: astore_0
    //   25: aload_0
    //   26: astore_3
    //   27: aload_0
    //   28: ifnull +48 -> 76
    //   31: aload_0
    //   32: astore_3
    //   33: iload_2
    //   34: ifeq +42 -> 76
    //   37: new 286	android/graphics/Matrix
    //   40: dup
    //   41: invokespecial 287	android/graphics/Matrix:<init>	()V
    //   44: astore_3
    //   45: aload_3
    //   46: ldc_w 307
    //   49: fconst_1
    //   50: invokevirtual 311	android/graphics/Matrix:postScale	(FF)Z
    //   53: pop
    //   54: aload_0
    //   55: iconst_0
    //   56: iconst_0
    //   57: aload_0
    //   58: invokevirtual 250	android/graphics/Bitmap:getWidth	()I
    //   61: aload_0
    //   62: invokevirtual 247	android/graphics/Bitmap:getHeight	()I
    //   65: aload_3
    //   66: iconst_0
    //   67: invokestatic 294	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   70: astore_3
    //   71: aload_0
    //   72: invokestatic 297	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Landroid/graphics/Bitmap;)Z
    //   75: pop
    //   76: aload_3
    //   77: areturn
    //   78: astore 4
    //   80: aload_3
    //   81: astore_0
    //   82: aload 4
    //   84: astore_3
    //   85: aload_3
    //   86: invokevirtual 300	java/lang/OutOfMemoryError:printStackTrace	()V
    //   89: goto -64 -> 25
    //   92: astore 4
    //   94: aload_3
    //   95: astore_0
    //   96: aload 4
    //   98: astore_3
    //   99: goto -14 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramArrayOfByte	byte[]
    //   0	102	1	paramInt	int
    //   0	102	2	paramBoolean	boolean
    //   1	98	3	localObject	Object
    //   78	5	4	localOutOfMemoryError1	OutOfMemoryError
    //   92	5	4	localOutOfMemoryError2	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   2	10	78	java/lang/OutOfMemoryError
    //   18	25	92	java/lang/OutOfMemoryError
  }
  
  public static Point a(Activity paramActivity, Point paramPoint)
  {
    paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
    if (ApiHelper.d())
    {
      paramActivity.getSize(paramPoint);
      return paramPoint;
    }
    paramPoint.set(paramActivity.getWidth(), paramActivity.getHeight());
    return paramPoint;
  }
  
  public static Rect a(RectF paramRectF)
  {
    Rect localRect = new Rect();
    a(paramRectF, localRect);
    return localRect;
  }
  
  public static RectF a(Rect paramRect)
  {
    return new RectF(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public static Camera.Size a(Activity paramActivity, CameraManager.CameraProxy paramCameraProxy)
  {
    Point localPoint = a(paramActivity, new Point());
    int i = Math.min(localPoint.x, localPoint.y);
    int j = Math.max(localPoint.x, localPoint.y);
    float f = j / i;
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraUtils", 2, "targetHeight = " + i + ", targetWidght = " + j + ", screenRatio = " + f);
    }
    if ((paramCameraProxy != null) && (paramCameraProxy.a() != null))
    {
      paramCameraProxy = paramCameraProxy.a().getSupportedPictureSizes();
      if ((paramCameraProxy != null) && (paramCameraProxy.size() > 0))
      {
        i = a(paramActivity, paramCameraProxy, f, 2);
        if (i != -1) {
          return (Camera.Size)paramCameraProxy.get(i);
        }
      }
    }
    return null;
  }
  
  public static CameraManager.CameraProxy a(CameraHolder paramCameraHolder, Activity paramActivity, int paramInt, Handler paramHandler, CameraManager.CameraOpenErrorCallback paramCameraOpenErrorCallback)
  {
    try
    {
      a(paramActivity);
      paramCameraHolder = paramCameraHolder.a(paramHandler, paramInt, paramCameraOpenErrorCallback);
      return paramCameraHolder;
    }
    catch (CameraDisabledException paramCameraHolder)
    {
      paramHandler.post(new qyu(paramCameraOpenErrorCallback, paramInt));
    }
    return null;
  }
  
  public static String a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a().getAppRuntime("peak");
    if ((localAppRuntime != null) && ((localAppRuntime instanceof PeakAppInterface))) {
      return ((PeakAppInterface)localAppRuntime).a();
    }
    return "";
  }
  
  private static void a(Activity paramActivity)
  {
    if ((ApiHelper.h) && (((DevicePolicyManager)paramActivity.getSystemService("device_policy")).getCameraDisabled(null))) {
      throw new CameraDisabledException();
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    a(paramContext).edit().putInt("qcamera_conf_version", paramInt).commit();
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    a(paramContext).edit().putBoolean("disableCameraSDK", paramBoolean);
  }
  
  public static void a(Matrix paramMatrix, boolean paramBoolean, int paramInt, Rect paramRect)
  {
    if (paramBoolean) {}
    for (float f = -1.0F;; f = 1.0F)
    {
      paramMatrix.setScale(f, 1.0F);
      paramMatrix.postRotate(paramInt);
      Matrix localMatrix = new Matrix();
      localMatrix.setRectToRect(new RectF(-1000.0F, -1000.0F, 1000.0F, 1000.0F), a(paramRect), Matrix.ScaleToFit.FILL);
      paramMatrix.setConcat(localMatrix, paramMatrix);
      return;
    }
  }
  
  public static void a(RectF paramRectF, Rect paramRect)
  {
    paramRect.left = Math.round(paramRectF.left);
    paramRect.top = Math.round(paramRectF.top);
    paramRect.right = Math.round(paramRectF.right);
    paramRect.bottom = Math.round(paramRectF.bottom);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new AssertionError();
    }
  }
  
  public static boolean a()
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] + ENTER");
    }
    Object localObject = DeviceInstance.a().a();
    String str = DeviceInstance.a().b();
    QLog.i("Q.camera.CameraUtils", 1, "My Phone: " + (String)localObject + ",  Model: " + str);
    boolean bool1 = CameraWrapper.a().e();
    boolean bool2 = b();
    if ((bool1) || (!bool2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] enter system camera 0, qcameraDisabled=" + bool1 + " sysVerSupported=" + bool2);
      }
      if (bool1) {
        i = 1;
      }
      bool1 = false;
    }
    for (;;)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "qcamera_choice_type", false, 0L, 0L, (HashMap)localObject, "");
      QLog.i("Q.camera.CameraUtils", 1, "[isChoiceQCamera] choice self qcamera: " + bool1 + " choiceResult: " + i);
      return bool1;
      if (CameraWrapper.a().a())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] enter system camera 1");
        }
        bool1 = false;
        i = 3;
      }
      else if (d())
      {
        bool1 = true;
        i = 10;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] enter system camera 3");
        }
        bool1 = false;
        i = 4;
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return a(paramContext).getBoolean("disableCameraSDK", true);
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    a(a(paramContext), paramString, paramInt);
    CameraWrapper.a().a();
    return true;
  }
  
  /* Error */
  private static boolean a(SharedPreferences paramSharedPreferences, String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 12
    //   2: iconst_4
    //   3: ldc_w 605
    //   6: invokestatic 517	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_1
    //   10: invokestatic 611	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +14 -> 27
    //   16: ldc 12
    //   18: iconst_4
    //   19: ldc_w 613
    //   22: invokestatic 615	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: iconst_0
    //   26: ireturn
    //   27: iconst_0
    //   28: invokestatic 620	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   31: astore 4
    //   33: aload 4
    //   35: astore_3
    //   36: invokestatic 626	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   39: invokevirtual 630	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   42: astore 5
    //   44: aload 4
    //   46: astore_3
    //   47: aload 5
    //   49: new 632	java/io/StringReader
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 635	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   57: invokeinterface 641 2 0
    //   62: aload 4
    //   64: astore_3
    //   65: aload 5
    //   67: invokeinterface 644 1 0
    //   72: istore 9
    //   74: aload 4
    //   76: astore_3
    //   77: aload_0
    //   78: invokeinterface 453 1 0
    //   83: astore 6
    //   85: aload 4
    //   87: astore_3
    //   88: aload 6
    //   90: invokeinterface 647 1 0
    //   95: pop
    //   96: aload 4
    //   98: astore_3
    //   99: aload 6
    //   101: ldc -84
    //   103: iload_2
    //   104: invokeinterface 459 3 0
    //   109: pop
    //   110: aload 4
    //   112: astore_3
    //   113: invokestatic 522	com/tencent/mobileqq/camera/adapter/DeviceInstance:a	()Lcom/tencent/mobileqq/camera/adapter/DeviceInstance;
    //   116: invokevirtual 523	com/tencent/mobileqq/camera/adapter/DeviceInstance:a	()Ljava/lang/String;
    //   119: astore 7
    //   121: aload 4
    //   123: astore_3
    //   124: new 119	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   131: aload 7
    //   133: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc_w 649
    //   139: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: getstatic 654	android/os/Build:DISPLAY	Ljava/lang/String;
    //   145: ldc_w 656
    //   148: ldc_w 649
    //   151: invokevirtual 660	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   154: invokevirtual 663	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   157: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore 8
    //   165: aload 4
    //   167: astore_3
    //   168: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +758 -> 929
    //   174: aload 4
    //   176: astore_3
    //   177: ldc 12
    //   179: iconst_4
    //   180: new 119	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   187: ldc_w 665
    //   190: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload 7
    //   195: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc_w 667
    //   201: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 8
    //   206: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 517	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: goto +714 -> 929
    //   218: aload_0
    //   219: astore_3
    //   220: aload 5
    //   222: invokeinterface 669 1 0
    //   227: istore_2
    //   228: goto +710 -> 938
    //   231: goto -13 -> 218
    //   234: aload 5
    //   236: invokeinterface 672 1 0
    //   241: astore_1
    //   242: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +29 -> 274
    //   248: ldc 12
    //   250: iconst_4
    //   251: new 119	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   258: ldc_w 674
    //   261: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_1
    //   265: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_1
    //   275: aload 7
    //   277: invokevirtual 678	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   280: ifeq +338 -> 618
    //   283: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq +51 -> 337
    //   289: ldc 12
    //   291: iconst_4
    //   292: new 119	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 674
    //   302: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_1
    //   306: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc_w 680
    //   312: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 7
    //   317: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: ldc_w 667
    //   323: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload 8
    //   328: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: aload 5
    //   339: invokeinterface 683 1 0
    //   344: istore 9
    //   346: iconst_0
    //   347: istore_2
    //   348: iload_2
    //   349: iload 9
    //   351: if_icmpge +257 -> 608
    //   354: aload 5
    //   356: iload_2
    //   357: invokeinterface 686 2 0
    //   362: astore_1
    //   363: aload 5
    //   365: iload_2
    //   366: invokeinterface 689 2 0
    //   371: astore_3
    //   372: aload_1
    //   373: ldc_w 465
    //   376: invokevirtual 678	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   379: ifeq +72 -> 451
    //   382: aload_3
    //   383: invokestatic 692	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   386: invokestatic 620	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   389: invokevirtual 695	java/lang/Boolean:booleanValue	()Z
    //   392: istore 10
    //   394: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +582 -> 979
    //   400: ldc 12
    //   402: iconst_4
    //   403: new 119	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   410: ldc_w 697
    //   413: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: iload_2
    //   417: iconst_1
    //   418: iadd
    //   419: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   422: ldc_w 699
    //   425: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: aload_1
    //   429: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: ldc_w 701
    //   435: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_3
    //   439: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokestatic 517	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   448: goto +531 -> 979
    //   451: aload_1
    //   452: ldc_w 703
    //   455: invokevirtual 706	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   458: ifeq +39 -> 497
    //   461: aload 6
    //   463: aload_1
    //   464: aload_3
    //   465: invokestatic 710	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   468: invokestatic 713	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   471: invokevirtual 80	java/lang/Integer:intValue	()I
    //   474: invokeinterface 459 3 0
    //   479: pop
    //   480: goto -86 -> 394
    //   483: astore_0
    //   484: ldc 12
    //   486: iconst_1
    //   487: aload_0
    //   488: iconst_0
    //   489: anewarray 4	java/lang/Object
    //   492: invokestatic 716	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   495: aload_0
    //   496: athrow
    //   497: aload_1
    //   498: ldc_w 718
    //   501: invokevirtual 706	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   504: ifeq +33 -> 537
    //   507: aload 6
    //   509: aload_1
    //   510: aload_3
    //   511: invokestatic 721	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   514: invokeinterface 725 3 0
    //   519: pop
    //   520: goto -126 -> 394
    //   523: astore_0
    //   524: ldc 12
    //   526: iconst_1
    //   527: aload_0
    //   528: iconst_0
    //   529: anewarray 4	java/lang/Object
    //   532: invokestatic 716	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   535: aload_0
    //   536: athrow
    //   537: aload 6
    //   539: aload_1
    //   540: aload_3
    //   541: invokestatic 692	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   544: invokestatic 620	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   547: invokevirtual 695	java/lang/Boolean:booleanValue	()Z
    //   550: invokeinterface 469 3 0
    //   555: pop
    //   556: goto -162 -> 394
    //   559: astore_1
    //   560: ldc 12
    //   562: iconst_1
    //   563: aload_1
    //   564: iconst_0
    //   565: anewarray 4	java/lang/Object
    //   568: invokestatic 716	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   571: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   574: ifeq +29 -> 603
    //   577: ldc 12
    //   579: iconst_4
    //   580: new 119	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   587: ldc_w 727
    //   590: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload_0
    //   594: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 517	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   603: aload_0
    //   604: invokevirtual 695	java/lang/Boolean:booleanValue	()Z
    //   607: ireturn
    //   608: iconst_1
    //   609: invokestatic 620	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   612: astore_1
    //   613: aload_1
    //   614: astore_0
    //   615: goto -397 -> 218
    //   618: ldc_w 729
    //   621: aload_1
    //   622: invokevirtual 678	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   625: ifeq +351 -> 976
    //   628: aload 5
    //   630: invokeinterface 683 1 0
    //   635: istore 9
    //   637: iconst_0
    //   638: istore_2
    //   639: iload_2
    //   640: iload 9
    //   642: if_icmpge +351 -> 993
    //   645: aload 5
    //   647: iload_2
    //   648: invokeinterface 686 2 0
    //   653: astore_1
    //   654: aload 5
    //   656: iload_2
    //   657: invokeinterface 689 2 0
    //   662: astore_3
    //   663: aload_1
    //   664: ldc_w 465
    //   667: invokevirtual 678	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   670: ifeq +72 -> 742
    //   673: aload_3
    //   674: invokestatic 692	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   677: invokestatic 620	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   680: invokevirtual 695	java/lang/Boolean:booleanValue	()Z
    //   683: istore 10
    //   685: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   688: ifeq +298 -> 986
    //   691: ldc 12
    //   693: iconst_4
    //   694: new 119	java/lang/StringBuilder
    //   697: dup
    //   698: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   701: ldc_w 731
    //   704: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: iload_2
    //   708: iconst_1
    //   709: iadd
    //   710: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   713: ldc_w 699
    //   716: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: aload_1
    //   720: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: ldc_w 701
    //   726: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: aload_3
    //   730: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   736: invokestatic 517	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   739: goto +247 -> 986
    //   742: aload_1
    //   743: ldc_w 703
    //   746: invokevirtual 706	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   749: ifeq +25 -> 774
    //   752: aload 6
    //   754: aload_1
    //   755: aload_3
    //   756: invokestatic 710	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   759: invokestatic 713	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   762: invokevirtual 80	java/lang/Integer:intValue	()I
    //   765: invokeinterface 459 3 0
    //   770: pop
    //   771: goto -86 -> 685
    //   774: aload_1
    //   775: ldc_w 718
    //   778: invokevirtual 706	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   781: ifeq +19 -> 800
    //   784: aload 6
    //   786: aload_1
    //   787: aload_3
    //   788: invokestatic 721	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   791: invokeinterface 725 3 0
    //   796: pop
    //   797: goto -112 -> 685
    //   800: aload 6
    //   802: aload_1
    //   803: aload_3
    //   804: invokestatic 692	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   807: invokestatic 620	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   810: invokevirtual 695	java/lang/Boolean:booleanValue	()Z
    //   813: invokeinterface 469 3 0
    //   818: pop
    //   819: goto -134 -> 685
    //   822: aload_0
    //   823: invokevirtual 695	java/lang/Boolean:booleanValue	()Z
    //   826: ifeq +54 -> 880
    //   829: aload 6
    //   831: ldc_w 465
    //   834: iload 10
    //   836: invokeinterface 469 3 0
    //   841: pop
    //   842: ldc 12
    //   844: iconst_1
    //   845: new 119	java/lang/StringBuilder
    //   848: dup
    //   849: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   852: ldc_w 733
    //   855: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: iload 10
    //   860: invokevirtual 265	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   863: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   866: invokestatic 517	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   869: aload 6
    //   871: invokeinterface 462 1 0
    //   876: pop
    //   877: goto -306 -> 571
    //   880: aload 6
    //   882: ldc_w 465
    //   885: iload 10
    //   887: invokeinterface 469 3 0
    //   892: pop
    //   893: ldc 12
    //   895: iconst_1
    //   896: new 119	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   903: ldc_w 735
    //   906: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: iload 10
    //   911: invokevirtual 265	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   914: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   917: invokestatic 517	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   920: goto -51 -> 869
    //   923: astore_1
    //   924: aload_3
    //   925: astore_0
    //   926: goto -366 -> 560
    //   929: aload 4
    //   931: astore_0
    //   932: iconst_0
    //   933: istore 10
    //   935: iload 9
    //   937: istore_2
    //   938: iload_2
    //   939: iconst_1
    //   940: if_icmpeq -118 -> 822
    //   943: iload_2
    //   944: tableswitch	default:+32->976, 0:+-713->231, 1:+32->976, 2:+-710->234, 3:+52->996
    //   976: goto -758 -> 218
    //   979: iload_2
    //   980: iconst_1
    //   981: iadd
    //   982: istore_2
    //   983: goto -635 -> 348
    //   986: iload_2
    //   987: iconst_1
    //   988: iadd
    //   989: istore_2
    //   990: goto -351 -> 639
    //   993: goto -775 -> 218
    //   996: goto -778 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	999	0	paramSharedPreferences	SharedPreferences
    //   0	999	1	paramString	String
    //   0	999	2	paramInt	int
    //   35	890	3	localObject	Object
    //   31	899	4	localBoolean	Boolean
    //   42	613	5	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   83	798	6	localEditor	SharedPreferences.Editor
    //   119	197	7	str1	String
    //   163	164	8	str2	String
    //   72	864	9	i	int
    //   392	542	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   36	44	483	org/xmlpull/v1/XmlPullParserException
    //   47	62	483	org/xmlpull/v1/XmlPullParserException
    //   65	74	483	org/xmlpull/v1/XmlPullParserException
    //   77	85	483	org/xmlpull/v1/XmlPullParserException
    //   88	96	483	org/xmlpull/v1/XmlPullParserException
    //   99	110	483	org/xmlpull/v1/XmlPullParserException
    //   113	121	483	org/xmlpull/v1/XmlPullParserException
    //   124	165	483	org/xmlpull/v1/XmlPullParserException
    //   168	174	483	org/xmlpull/v1/XmlPullParserException
    //   177	215	483	org/xmlpull/v1/XmlPullParserException
    //   220	228	483	org/xmlpull/v1/XmlPullParserException
    //   234	274	483	org/xmlpull/v1/XmlPullParserException
    //   274	337	483	org/xmlpull/v1/XmlPullParserException
    //   337	346	483	org/xmlpull/v1/XmlPullParserException
    //   354	394	483	org/xmlpull/v1/XmlPullParserException
    //   394	448	483	org/xmlpull/v1/XmlPullParserException
    //   451	480	483	org/xmlpull/v1/XmlPullParserException
    //   497	520	483	org/xmlpull/v1/XmlPullParserException
    //   537	556	483	org/xmlpull/v1/XmlPullParserException
    //   608	613	483	org/xmlpull/v1/XmlPullParserException
    //   618	637	483	org/xmlpull/v1/XmlPullParserException
    //   645	685	483	org/xmlpull/v1/XmlPullParserException
    //   685	739	483	org/xmlpull/v1/XmlPullParserException
    //   742	771	483	org/xmlpull/v1/XmlPullParserException
    //   774	797	483	org/xmlpull/v1/XmlPullParserException
    //   800	819	483	org/xmlpull/v1/XmlPullParserException
    //   822	869	483	org/xmlpull/v1/XmlPullParserException
    //   869	877	483	org/xmlpull/v1/XmlPullParserException
    //   880	920	483	org/xmlpull/v1/XmlPullParserException
    //   36	44	523	java/io/IOException
    //   47	62	523	java/io/IOException
    //   65	74	523	java/io/IOException
    //   77	85	523	java/io/IOException
    //   88	96	523	java/io/IOException
    //   99	110	523	java/io/IOException
    //   113	121	523	java/io/IOException
    //   124	165	523	java/io/IOException
    //   168	174	523	java/io/IOException
    //   177	215	523	java/io/IOException
    //   220	228	523	java/io/IOException
    //   234	274	523	java/io/IOException
    //   274	337	523	java/io/IOException
    //   337	346	523	java/io/IOException
    //   354	394	523	java/io/IOException
    //   394	448	523	java/io/IOException
    //   451	480	523	java/io/IOException
    //   497	520	523	java/io/IOException
    //   537	556	523	java/io/IOException
    //   608	613	523	java/io/IOException
    //   618	637	523	java/io/IOException
    //   645	685	523	java/io/IOException
    //   685	739	523	java/io/IOException
    //   742	771	523	java/io/IOException
    //   774	797	523	java/io/IOException
    //   800	819	523	java/io/IOException
    //   822	869	523	java/io/IOException
    //   869	877	523	java/io/IOException
    //   880	920	523	java/io/IOException
    //   234	274	559	java/lang/Exception
    //   274	337	559	java/lang/Exception
    //   337	346	559	java/lang/Exception
    //   354	394	559	java/lang/Exception
    //   394	448	559	java/lang/Exception
    //   451	480	559	java/lang/Exception
    //   497	520	559	java/lang/Exception
    //   537	556	559	java/lang/Exception
    //   608	613	559	java/lang/Exception
    //   618	637	559	java/lang/Exception
    //   645	685	559	java/lang/Exception
    //   685	739	559	java/lang/Exception
    //   742	771	559	java/lang/Exception
    //   774	797	559	java/lang/Exception
    //   800	819	559	java/lang/Exception
    //   822	869	559	java/lang/Exception
    //   869	877	559	java/lang/Exception
    //   880	920	559	java/lang/Exception
    //   36	44	923	java/lang/Exception
    //   47	62	923	java/lang/Exception
    //   65	74	923	java/lang/Exception
    //   77	85	923	java/lang/Exception
    //   88	96	923	java/lang/Exception
    //   99	110	923	java/lang/Exception
    //   113	121	923	java/lang/Exception
    //   124	165	923	java/lang/Exception
    //   168	174	923	java/lang/Exception
    //   177	215	923	java/lang/Exception
    //   220	228	923	java/lang/Exception
  }
  
  public static boolean a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.recycle();
      return true;
    }
    return false;
  }
  
  public static boolean a(Camera.Parameters paramParameters)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (ApiHelper.i)
    {
      bool1 = bool2;
      if (paramParameters.getMaxNumFocusAreas() > 0)
      {
        bool1 = bool2;
        if (a("auto", paramParameters.getSupportedFocusModes())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString, List paramList)
  {
    if (paramList == null) {}
    while (paramList.indexOf(paramString) < 0) {
      return false;
    }
    return true;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraUtils", 4, "[decodeXML] + BEGIN");
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte['Ā'];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("OlympicUtil", 2, "inflateConfigString");
        paramArrayOfByte.printStackTrace();
      }
      return null;
    }
    return paramArrayOfByte;
  }
  
  public static int[] a(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    return new int[] { paramContext.widthPixels, paramContext.heightPixels };
  }
  
  public static int[] a(Camera.Parameters paramParameters)
  {
    return a(paramParameters.getSupportedPreviewFpsRange());
  }
  
  public static int[] a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("Q.camera.CameraUtils", 2, "No suppoted frame rates returned!");
      return null;
    }
    Object localObject = paramList.iterator();
    int i = 400000;
    int j;
    if (((Iterator)localObject).hasNext())
    {
      int[] arrayOfInt = (int[])((Iterator)localObject).next();
      j = arrayOfInt[0];
      if ((arrayOfInt[1] < 30000) || (j > 30000) || (j >= i)) {
        break label211;
      }
      i = j;
    }
    label211:
    for (;;)
    {
      break;
      j = 0;
      int n = 0;
      int m;
      for (int k = -1; j < paramList.size(); k = m)
      {
        localObject = (int[])paramList.get(j);
        int i3 = localObject[0];
        int i2 = localObject[1];
        int i1 = n;
        m = k;
        if (i3 == i)
        {
          i1 = n;
          m = k;
          if (n < i2)
          {
            i1 = i2;
            m = j;
          }
        }
        j += 1;
        n = i1;
      }
      if (k >= 0) {
        return (int[])paramList.get(k);
      }
      QLog.e("Q.camera.CameraUtils", 2, "Can't find an appropiate frame rate range!");
      return null;
    }
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static Camera.Size b(Activity paramActivity, CameraManager.CameraProxy paramCameraProxy)
  {
    Point localPoint = a(paramActivity, new Point());
    int i = Math.min(localPoint.x, localPoint.y);
    int j = Math.max(localPoint.x, localPoint.y);
    float f = j / i;
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraUtils", 2, "targetHeight = " + i + ", targetWidght = " + j + ", screenRatio = " + f);
    }
    paramCameraProxy = paramCameraProxy.a().getSupportedPreviewSizes();
    if ((paramCameraProxy != null) && (paramCameraProxy.size() > 0))
    {
      i = a(paramActivity, paramCameraProxy, f, 1);
      if (i != -1) {
        return (Camera.Size)paramCameraProxy.get(i);
      }
    }
    return null;
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= CameraWrapper.a().a();
  }
  
  public static boolean b(Camera.Parameters paramParameters)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (ApiHelper.j)
    {
      bool1 = bool2;
      if (paramParameters.getMaxNumMeteringAreas() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean b(String paramString, List paramList)
  {
    if (paramList == null) {}
    while (paramList.indexOf(paramString) < 0) {
      return false;
    }
    return true;
  }
  
  public static int[] b(Camera.Parameters paramParameters)
  {
    paramParameters = paramParameters.getSupportedPreviewFpsRange();
    if ((paramParameters != null) && (paramParameters.size() > 0)) {
      return (int[])paramParameters.get(paramParameters.size() - 1);
    }
    return new int[0];
  }
  
  public static boolean c()
  {
    int i = BaseApplicationImpl.getContext().getPackageManager().checkPermission("android.permission.CAMERA", BaseApplicationImpl.getContext().getPackageName());
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 2, "[isCameraReady] camera has not permission " + i);
      }
      return false;
    }
    return true;
  }
  
  public static boolean d()
  {
    boolean bool = c();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("[isCameraReady] check camera permission: ");
      if (!bool) {
        break label55;
      }
    }
    label55:
    for (Object localObject = "OK";; localObject = "FAILED")
    {
      QLog.i("Q.camera.CameraUtils", 2, (String)localObject);
      if (bool) {
        break;
      }
      return false;
    }
    int j = CameraWrapper.a().b();
    if (j < 1) {
      return false;
    }
    localObject = new Camera.CameraInfo();
    int i = 0;
    if (i < j)
    {
      Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
      if (((Camera.CameraInfo)localObject).facing != 0) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.camera.CameraUtils", 2, "[isCameraReady] check back camera exist: failed");
        }
        return false;
        i += 1;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 2, "[isCameraReady] check back camera exist: OK");
      }
      return true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\utils\CameraUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */