package com.tencent.av.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.QLog;
import ggk;
import ggl;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class AndroidCamera
{
  public static int a = 0;
  static ggl jdField_a_of_type_Ggl = new ggl();
  static final String jdField_a_of_type_JavaLangString = "AndroidCamera";
  public static boolean a = false;
  static final int jdField_b_of_type_Int = 1;
  static boolean jdField_b_of_type_Boolean = false;
  static final int jdField_c_of_type_Int = 2;
  public static int l = 640;
  public static int m = 480;
  public static int n = 17;
  public Context a;
  private Camera.PreviewCallback jdField_a_of_type_AndroidHardwareCamera$PreviewCallback = new ggk(this);
  Camera jdField_a_of_type_AndroidHardwareCamera = null;
  public Display a;
  public AndroidCamera.CameraPreviewCallback a;
  String jdField_b_of_type_JavaLangString;
  String jdField_c_of_type_JavaLangString;
  public boolean c;
  public int d;
  public boolean d;
  int e;
  public boolean e;
  int f;
  int g;
  public int h = 0;
  int i = 0;
  public int j = 0;
  public int k = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AndroidCamera(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvCameraAndroidCamera$CameraPreviewCallback = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay();
    this.jdField_c_of_type_Boolean = PhoneStatusTools.g(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_d_of_type_Boolean = PhoneStatusTools.c();
    this.f = a();
    this.jdField_b_of_type_JavaLangString = Build.MODEL;
    this.jdField_c_of_type_JavaLangString = Build.MANUFACTURER;
    jdField_a_of_type_Ggl.b = -1;
    jdField_a_of_type_Ggl.c = -1;
    if (QLog.isColorLevel()) {
      QLog.d("AndroidCamera", 2, "Device_Tag = " + this.jdField_c_of_type_JavaLangString + ": " + this.jdField_b_of_type_JavaLangString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AndroidCamera", 2, "Rom_Tag = " + Build.VERSION.INCREMENTAL);
    }
  }
  
  public static int a()
  {
    return Build.VERSION.SDK_INT;
  }
  
  protected static ArrayList a(String paramString)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ",");
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      paramString = localArrayList;
      if (!localStringTokenizer.hasMoreElements()) {
        break;
      }
      localArrayList.add(Integer.valueOf(Integer.parseInt(localStringTokenizer.nextToken())));
    }
  }
  
  private void a()
  {
    this.g = 0;
    for (;;)
    {
      try
      {
        Class localClass1 = Class.forName("android.hardware.Camera");
        if (this.jdField_e_of_type_Int == 0) {
          this.jdField_e_of_type_Int = d();
        }
        if (this.jdField_e_of_type_Int > 0)
        {
          Class localClass2 = Class.forName("android.hardware.Camera$CameraInfo");
          if (localClass2 == null) {
            break label360;
          }
          Object localObject1 = localClass2.newInstance();
          if (localObject1 == null) {
            break label355;
          }
          localField = localObject1.getClass().getField("facing");
          Method localMethod = localClass1.getMethod("getCameraInfo", new Class[] { Integer.TYPE, localClass2 });
          if ((localMethod != null) && (localClass2 != null) && (localField != null))
          {
            int i1 = 0;
            if (i1 < this.jdField_e_of_type_Int)
            {
              localMethod.invoke(null, new Object[] { Integer.valueOf(i1), localObject1 });
              int i2 = localField.getInt(localObject1);
              if (i2 == 0) {}
              try
              {
                if (localClass1.getMethod("open", new Class[] { Integer.TYPE }) != null) {
                  this.g = i1;
                }
                i1 += 1;
              }
              catch (RuntimeException localRuntimeException)
              {
                this.g = 0;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("AndroidCamera", 2, "openFrontFacingCamera", localRuntimeException);
                continue;
              }
            }
          }
        }
        Field localField = null;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AndroidCamera", 2, "findBackCameraId ClassNotFoundException", localClassNotFoundException);
        }
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AndroidCamera", 2, "findBackCameraId NoSuchMethodException", localNoSuchMethodException);
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AndroidCamera", 2, "findBackCameraId NoSuchFieldException", localNoSuchFieldException);
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AndroidCamera", 2, "findBackCameraId IllegalAccessException", localIllegalAccessException);
        return;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AndroidCamera", 2, "findBackCameraId InvocationTargetException", localInvocationTargetException);
        return;
      }
      catch (InstantiationException localInstantiationException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AndroidCamera", 2, "findBackCameraId InstantiationException", localInstantiationException);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AndroidCamera", 2, "findBackCameraId SecurityException", localSecurityException);
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AndroidCamera", 2, "findBackCameraId", localException);
        return;
      }
      label355:
      continue;
      label360:
      Object localObject2 = null;
    }
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    byte b1;
    switch (paramInt)
    {
    default: 
      b1 = 0;
    }
    while (paramBoolean)
    {
      return ConfigSystemImpl.a(this.jdField_a_of_type_AndroidContentContext, true, false, b1, false) * 90;
      b1 = 0;
      continue;
      b1 = 1;
      continue;
      b1 = 2;
      continue;
      b1 = 3;
    }
    return ConfigSystemImpl.b(this.jdField_a_of_type_AndroidContentContext, true, false, b1, false) * 90;
  }
  
  int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 360 - ConfigSystemImpl.a(this.jdField_a_of_type_AndroidContentContext, true, true, (byte)0, false) * 90;
    }
    return 360 - ConfigSystemImpl.b(this.jdField_a_of_type_AndroidContentContext, true, true, (byte)0, false) * 90;
  }
  
  protected Camera.Size a(List paramList, int paramInt1, int paramInt2)
  {
    double d2 = paramInt1 / paramInt2;
    Object localObject2;
    if (paramList == null)
    {
      localObject2 = null;
      return (Camera.Size)localObject2;
    }
    Object localObject1 = null;
    double d1 = Double.MAX_VALUE;
    Iterator localIterator = paramList.iterator();
    label33:
    while (localIterator.hasNext())
    {
      localObject2 = (Camera.Size)localIterator.next();
      if (Math.abs(((Camera.Size)localObject2).width / ((Camera.Size)localObject2).height - d2) <= 0.05D)
      {
        if (Math.abs(((Camera.Size)localObject2).height - paramInt2) >= d1) {
          break label205;
        }
        d1 = Math.abs(((Camera.Size)localObject2).height - paramInt2);
        localObject1 = localObject2;
      }
    }
    label205:
    for (;;)
    {
      break label33;
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      localIterator = paramList.iterator();
      d1 = Double.MAX_VALUE;
      localObject2 = localObject1;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (Camera.Size)localIterator.next();
      if (Math.abs(paramList.height - paramInt2) < d1) {
        d1 = Math.abs(paramList.height - paramInt2);
      }
      for (;;)
      {
        localObject1 = paramList;
        break;
        paramList = (List)localObject1;
      }
    }
  }
  
  protected Camera a()
  {
    Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localCamera != null) {}
    try
    {
      localCamera.release();
      localCamera = Camera.open();
      if (localCamera == null) {
        return null;
      }
      Camera.Parameters localParameters = localCamera.getParameters();
      localParameters.set("camera-id", 2);
      localCamera.setParameters(localParameters);
      this.jdField_a_of_type_AndroidHardwareCamera = localCamera;
      return localCamera;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AndroidCamera", 2, "trySamsungFrontCamera", localException);
      }
    }
    return null;
  }
  
  protected ggl a(int paramInt, Camera paramCamera)
  {
    paramCamera = new ggl();
    try
    {
      Object localObject2 = Class.forName("android.hardware.Camera");
      Class localClass = Class.forName("android.hardware.Camera$CameraInfo");
      if (localClass == null)
      {
        paramCamera.c = -1;
        paramCamera.b = -1;
        return paramCamera;
      }
      Object localObject1 = localClass.newInstance();
      if (localObject1 == null)
      {
        paramCamera.c = -1;
        paramCamera.b = -1;
        return paramCamera;
      }
      Field localField1 = localObject1.getClass().getField("facing");
      Field localField2 = localObject1.getClass().getField("orientation");
      if ((localField1 == null) || (localField2 == null))
      {
        paramCamera.c = -1;
        paramCamera.b = -1;
        return paramCamera;
      }
      localObject2 = ((Class)localObject2).getMethod("getCameraInfo", new Class[] { Integer.TYPE, localClass });
      if (localObject2 == null)
      {
        paramCamera.c = -1;
        paramCamera.b = -1;
        return paramCamera;
      }
      ((Method)localObject2).invoke(null, new Object[] { Integer.valueOf(paramInt), localObject1 });
      paramCamera.jdField_a_of_type_Int = localField1.getInt(localObject1);
      paramCamera.b = localField2.getInt(localObject1);
      if (this.jdField_a_of_type_AndroidViewDisplay == null)
      {
        paramCamera.c = -1;
        return paramCamera;
      }
      localObject1 = this.jdField_a_of_type_AndroidViewDisplay.getClass().getMethod("getRotation", new Class[0]);
      if (localObject1 == null)
      {
        paramCamera.c = -1;
        return paramCamera;
      }
      switch (Integer.parseInt(((Method)localObject1).invoke(this.jdField_a_of_type_AndroidViewDisplay, (Object[])null).toString()))
      {
      case 0: 
        paramCamera.c = 0;
      }
    }
    catch (Exception localException)
    {
      paramCamera.c = 0;
      return paramCamera;
    }
    paramCamera.c = 90;
    return paramCamera;
    paramCamera.c = 180;
    return paramCamera;
    paramCamera.c = 270;
    return paramCamera;
  }
  
  public void a(int paramInt)
  {
    jdField_a_of_type_Ggl.c = ((this.i + paramInt) % 360);
  }
  
  /* Error */
  protected void a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: getstatic 46	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_Ggl	Lggl;
    //   11: astore_3
    //   12: aload_3
    //   13: monitorenter
    //   14: aload_0
    //   15: invokevirtual 371	com/tencent/av/camera/AndroidCamera:a	()Z
    //   18: ifeq +126 -> 144
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 213	com/tencent/av/camera/AndroidCamera:g	I
    //   26: aload_0
    //   27: getfield 57	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   30: invokevirtual 374	com/tencent/av/camera/AndroidCamera:a	(ILandroid/hardware/Camera;)Z
    //   33: pop
    //   34: aload_3
    //   35: monitorexit
    //   36: aload_0
    //   37: getfield 57	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   40: invokevirtual 341	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull -38 -> 7
    //   48: aload_3
    //   49: invokevirtual 233	java/lang/Object:getClass	()Ljava/lang/Class;
    //   52: ldc_w 376
    //   55: iconst_0
    //   56: anewarray 217	java/lang/Class
    //   59: invokevirtual 249	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   62: aload_3
    //   63: aconst_null
    //   64: checkcast 366	[Ljava/lang/Object;
    //   67: invokevirtual 255	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   70: checkcast 298	java/util/List
    //   73: astore 4
    //   75: aload 4
    //   77: ifnull +1154 -> 1231
    //   80: iconst_0
    //   81: istore 7
    //   83: iload 7
    //   85: aload 4
    //   87: invokeinterface 379 1 0
    //   92: if_icmpge +92 -> 184
    //   95: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +37 -> 135
    //   101: ldc 11
    //   103: iconst_2
    //   104: new 136	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 381
    //   114: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload 4
    //   119: iload 7
    //   121: invokeinterface 385 2 0
    //   126: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: iload 7
    //   137: iconst_1
    //   138: iadd
    //   139: istore 7
    //   141: goto -58 -> 83
    //   144: aload_0
    //   145: aload_0
    //   146: getfield 57	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   149: invokevirtual 391	com/tencent/av/camera/AndroidCamera:a	(Landroid/hardware/Camera;)V
    //   152: goto -118 -> 34
    //   155: astore 4
    //   157: aload_3
    //   158: monitorexit
    //   159: aload 4
    //   161: athrow
    //   162: astore_3
    //   163: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +13 -> 179
    //   169: ldc 11
    //   171: iconst_2
    //   172: ldc_w 393
    //   175: aload_3
    //   176: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   179: aconst_null
    //   180: astore_3
    //   181: goto -137 -> 44
    //   184: aload 4
    //   186: bipush 17
    //   188: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   191: invokeinterface 396 2 0
    //   196: istore 8
    //   198: iload 8
    //   200: ifeq +583 -> 783
    //   203: bipush 17
    //   205: istore 7
    //   207: aload_3
    //   208: invokevirtual 233	java/lang/Object:getClass	()Ljava/lang/Class;
    //   211: ldc_w 398
    //   214: iconst_0
    //   215: anewarray 217	java/lang/Class
    //   218: invokevirtual 249	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   221: astore 4
    //   223: aload 4
    //   225: ifnull +54 -> 279
    //   228: aload 4
    //   230: aload_3
    //   231: aconst_null
    //   232: checkcast 366	[Ljava/lang/Object;
    //   235: invokevirtual 255	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   238: checkcast 298	java/util/List
    //   241: astore 4
    //   243: aload 4
    //   245: ifnull +34 -> 279
    //   248: aload_0
    //   249: aload 4
    //   251: iload_1
    //   252: iload_2
    //   253: invokevirtual 400	com/tencent/av/camera/AndroidCamera:b	(Ljava/util/List;II)Landroid/hardware/Camera$Size;
    //   256: astore 4
    //   258: aload 4
    //   260: ifnull +19 -> 279
    //   263: aload 4
    //   265: getfield 315	android/hardware/Camera$Size:width	I
    //   268: putstatic 48	com/tencent/av/camera/AndroidCamera:l	I
    //   271: aload 4
    //   273: getfield 318	android/hardware/Camera$Size:height	I
    //   276: putstatic 50	com/tencent/av/camera/AndroidCamera:m	I
    //   279: iconst_0
    //   280: putstatic 401	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_Int	I
    //   283: aload_3
    //   284: invokevirtual 233	java/lang/Object:getClass	()Ljava/lang/Class;
    //   287: ldc_w 403
    //   290: iconst_0
    //   291: anewarray 217	java/lang/Class
    //   294: invokevirtual 249	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   297: astore 4
    //   299: aload 4
    //   301: ifnull +154 -> 455
    //   304: aload 4
    //   306: aload_3
    //   307: aconst_null
    //   308: checkcast 366	[Ljava/lang/Object;
    //   311: invokevirtual 255	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   314: checkcast 298	java/util/List
    //   317: astore 4
    //   319: aload 4
    //   321: ifnull +134 -> 455
    //   324: aload 4
    //   326: invokeinterface 379 1 0
    //   331: ifle +124 -> 455
    //   334: aload 4
    //   336: invokeinterface 302 1 0
    //   341: astore 5
    //   343: aload 5
    //   345: invokeinterface 307 1 0
    //   350: ifeq +747 -> 1097
    //   353: aload 5
    //   355: invokeinterface 310 1 0
    //   360: checkcast 181	java/lang/Integer
    //   363: astore 6
    //   365: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   368: ifeq +30 -> 398
    //   371: ldc 11
    //   373: iconst_2
    //   374: new 136	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   381: ldc_w 405
    //   384: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: aload 6
    //   389: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: aload 6
    //   400: invokevirtual 408	java/lang/Integer:intValue	()I
    //   403: bipush 15
    //   405: if_icmplt -62 -> 343
    //   408: getstatic 401	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_Int	I
    //   411: ifeq +14 -> 425
    //   414: aload 6
    //   416: invokevirtual 408	java/lang/Integer:intValue	()I
    //   419: getstatic 401	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_Int	I
    //   422: if_icmpge -79 -> 343
    //   425: aload 6
    //   427: invokevirtual 408	java/lang/Integer:intValue	()I
    //   430: putstatic 401	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_Int	I
    //   433: goto -90 -> 343
    //   436: astore 4
    //   438: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   441: ifeq +14 -> 455
    //   444: ldc 11
    //   446: iconst_2
    //   447: ldc_w 410
    //   450: aload 4
    //   452: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   455: getstatic 401	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_Int	I
    //   458: ifle +11 -> 469
    //   461: getstatic 401	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_Int	I
    //   464: bipush 20
    //   466: if_icmple +8 -> 474
    //   469: bipush 15
    //   471: putstatic 401	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_Int	I
    //   474: aload_0
    //   475: getfield 125	com/tencent/av/camera/AndroidCamera:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   478: ldc_w 412
    //   481: invokevirtual 418	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   484: ifeq +16 -> 500
    //   487: aload_0
    //   488: getfield 120	com/tencent/av/camera/AndroidCamera:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   491: ldc_w 420
    //   494: invokevirtual 418	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   497: ifne +55 -> 552
    //   500: aload_0
    //   501: getfield 125	com/tencent/av/camera/AndroidCamera:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   504: ldc_w 412
    //   507: invokevirtual 418	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   510: ifeq +16 -> 526
    //   513: aload_0
    //   514: getfield 120	com/tencent/av/camera/AndroidCamera:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   517: ldc_w 422
    //   520: invokevirtual 418	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   523: ifne +29 -> 552
    //   526: aload_0
    //   527: getfield 125	com/tencent/av/camera/AndroidCamera:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   530: ldc_w 412
    //   533: invokevirtual 418	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   536: ifeq +28 -> 564
    //   539: aload_0
    //   540: getfield 120	com/tencent/av/camera/AndroidCamera:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   543: ldc_w 424
    //   546: invokevirtual 418	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   549: ifeq +15 -> 564
    //   552: sipush 320
    //   555: putstatic 48	com/tencent/av/camera/AndroidCamera:l	I
    //   558: sipush 240
    //   561: putstatic 50	com/tencent/av/camera/AndroidCamera:m	I
    //   564: aload_3
    //   565: getstatic 48	com/tencent/av/camera/AndroidCamera:l	I
    //   568: getstatic 50	com/tencent/av/camera/AndroidCamera:m	I
    //   571: invokevirtual 427	android/hardware/Camera$Parameters:setPreviewSize	(II)V
    //   574: iload 7
    //   576: ifeq +589 -> 1165
    //   579: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   582: ifeq +30 -> 612
    //   585: ldc 11
    //   587: iconst_2
    //   588: new 136	java/lang/StringBuilder
    //   591: dup
    //   592: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   595: ldc_w 429
    //   598: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: iload 7
    //   603: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   606: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   612: aload_3
    //   613: iload 7
    //   615: invokevirtual 435	android/hardware/Camera$Parameters:setPreviewFormat	(I)V
    //   618: aload_3
    //   619: getstatic 401	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_Int	I
    //   622: invokevirtual 438	android/hardware/Camera$Parameters:setPreviewFrameRate	(I)V
    //   625: aload_3
    //   626: ldc_w 440
    //   629: sipush 180
    //   632: invokevirtual 349	android/hardware/Camera$Parameters:set	(Ljava/lang/String;I)V
    //   635: aload_0
    //   636: getfield 57	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   639: aload_3
    //   640: invokevirtual 353	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   643: aload_3
    //   644: invokevirtual 444	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   647: astore 4
    //   649: aload_3
    //   650: invokevirtual 447	android/hardware/Camera$Parameters:getPreviewFormat	()I
    //   653: istore_1
    //   654: aload 4
    //   656: getfield 315	android/hardware/Camera$Size:width	I
    //   659: putstatic 48	com/tencent/av/camera/AndroidCamera:l	I
    //   662: aload 4
    //   664: getfield 318	android/hardware/Camera$Size:height	I
    //   667: putstatic 50	com/tencent/av/camera/AndroidCamera:m	I
    //   670: iload_1
    //   671: putstatic 52	com/tencent/av/camera/AndroidCamera:n	I
    //   674: aload_3
    //   675: invokevirtual 450	android/hardware/Camera$Parameters:getPreviewFrameRate	()I
    //   678: putstatic 401	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_Int	I
    //   681: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   684: ifeq +67 -> 751
    //   687: ldc 11
    //   689: iconst_2
    //   690: new 136	java/lang/StringBuilder
    //   693: dup
    //   694: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   697: ldc_w 452
    //   700: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: getstatic 48	com/tencent/av/camera/AndroidCamera:l	I
    //   706: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   709: ldc_w 454
    //   712: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: getstatic 50	com/tencent/av/camera/AndroidCamera:m	I
    //   718: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   721: ldc_w 456
    //   724: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: getstatic 401	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_Int	I
    //   730: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   733: ldc_w 458
    //   736: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: getstatic 52	com/tencent/av/camera/AndroidCamera:n	I
    //   742: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   745: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   751: aload_0
    //   752: getfield 125	com/tencent/av/camera/AndroidCamera:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   755: ldc_w 460
    //   758: invokevirtual 418	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   761: ifeq +428 -> 1189
    //   764: aload_0
    //   765: getfield 120	com/tencent/av/camera/AndroidCamera:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   768: ldc_w 462
    //   771: invokevirtual 418	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   774: ifeq +415 -> 1189
    //   777: bipush 18
    //   779: putstatic 52	com/tencent/av/camera/AndroidCamera:n	I
    //   782: return
    //   783: aload 4
    //   785: bipush 16
    //   787: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   790: invokeinterface 396 2 0
    //   795: ifeq +10 -> 805
    //   798: bipush 16
    //   800: istore 7
    //   802: goto -595 -> 207
    //   805: aload 4
    //   807: bipush 20
    //   809: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   812: invokeinterface 396 2 0
    //   817: ifeq +10 -> 827
    //   820: bipush 20
    //   822: istore 7
    //   824: goto -617 -> 207
    //   827: aload 4
    //   829: ldc_w 463
    //   832: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   835: invokeinterface 396 2 0
    //   840: ifeq +11 -> 851
    //   843: ldc_w 463
    //   846: istore 7
    //   848: goto -641 -> 207
    //   851: aload 4
    //   853: iconst_4
    //   854: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   857: invokeinterface 396 2 0
    //   862: ifeq +9 -> 871
    //   865: iconst_4
    //   866: istore 7
    //   868: goto -661 -> 207
    //   871: aload 4
    //   873: bipush 17
    //   875: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   878: invokeinterface 396 2 0
    //   883: ifeq +10 -> 893
    //   886: bipush 17
    //   888: istore 7
    //   890: goto -683 -> 207
    //   893: aload 4
    //   895: bipush 16
    //   897: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   900: invokeinterface 396 2 0
    //   905: ifeq +10 -> 915
    //   908: bipush 16
    //   910: istore 7
    //   912: goto -705 -> 207
    //   915: aload 4
    //   917: iconst_3
    //   918: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   921: invokeinterface 396 2 0
    //   926: ifeq +9 -> 935
    //   929: iconst_3
    //   930: istore 7
    //   932: goto -725 -> 207
    //   935: aload 4
    //   937: iconst_2
    //   938: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   941: invokeinterface 396 2 0
    //   946: ifeq +9 -> 955
    //   949: iconst_2
    //   950: istore 7
    //   952: goto -745 -> 207
    //   955: aload 4
    //   957: iconst_4
    //   958: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   961: invokeinterface 396 2 0
    //   966: ifeq +9 -> 975
    //   969: iconst_4
    //   970: istore 7
    //   972: goto -765 -> 207
    //   975: aload 4
    //   977: bipush 100
    //   979: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   982: invokeinterface 396 2 0
    //   987: ifeq +10 -> 997
    //   990: bipush 100
    //   992: istore 7
    //   994: goto -787 -> 207
    //   997: aload 4
    //   999: bipush 101
    //   1001: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1004: invokeinterface 396 2 0
    //   1009: ifeq +10 -> 1019
    //   1012: bipush 101
    //   1014: istore 7
    //   1016: goto -809 -> 207
    //   1019: aload 4
    //   1021: bipush 102
    //   1023: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1026: invokeinterface 396 2 0
    //   1031: ifeq +10 -> 1041
    //   1034: bipush 102
    //   1036: istore 7
    //   1038: goto -831 -> 207
    //   1041: aload 4
    //   1043: bipush 103
    //   1045: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1048: invokeinterface 396 2 0
    //   1053: ifeq +10 -> 1063
    //   1056: bipush 103
    //   1058: istore 7
    //   1060: goto -853 -> 207
    //   1063: aload 4
    //   1065: bipush 104
    //   1067: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1070: invokeinterface 396 2 0
    //   1075: istore 8
    //   1077: iload 8
    //   1079: ifeq +152 -> 1231
    //   1082: bipush 104
    //   1084: istore 7
    //   1086: goto -879 -> 207
    //   1089: astore 4
    //   1091: iconst_0
    //   1092: istore 7
    //   1094: goto -887 -> 207
    //   1097: getstatic 401	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_Int	I
    //   1100: ifne -645 -> 455
    //   1103: aload 4
    //   1105: invokeinterface 302 1 0
    //   1110: astore 4
    //   1112: aload 4
    //   1114: invokeinterface 307 1 0
    //   1119: ifeq -664 -> 455
    //   1122: aload 4
    //   1124: invokeinterface 310 1 0
    //   1129: checkcast 181	java/lang/Integer
    //   1132: astore 5
    //   1134: aload 5
    //   1136: invokevirtual 408	java/lang/Integer:intValue	()I
    //   1139: getstatic 401	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_Int	I
    //   1142: if_icmple +16 -> 1158
    //   1145: aload 5
    //   1147: invokevirtual 408	java/lang/Integer:intValue	()I
    //   1150: istore_1
    //   1151: iload_1
    //   1152: putstatic 401	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_Int	I
    //   1155: goto -43 -> 1112
    //   1158: getstatic 401	com/tencent/av/camera/AndroidCamera:jdField_a_of_type_Int	I
    //   1161: istore_1
    //   1162: goto -11 -> 1151
    //   1165: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1168: ifeq +12 -> 1180
    //   1171: ldc 11
    //   1173: iconst_2
    //   1174: ldc_w 465
    //   1177: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1180: aload_3
    //   1181: bipush 17
    //   1183: invokevirtual 435	android/hardware/Camera$Parameters:setPreviewFormat	(I)V
    //   1186: goto -568 -> 618
    //   1189: aload_0
    //   1190: getfield 125	com/tencent/av/camera/AndroidCamera:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1193: ldc_w 467
    //   1196: invokevirtual 418	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1199: ifeq -1192 -> 7
    //   1202: aload_0
    //   1203: getfield 120	com/tencent/av/camera/AndroidCamera:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1206: ldc_w 469
    //   1209: invokevirtual 418	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1212: ifeq -1205 -> 7
    //   1215: bipush 100
    //   1217: putstatic 52	com/tencent/av/camera/AndroidCamera:n	I
    //   1220: return
    //   1221: astore 4
    //   1223: goto -580 -> 643
    //   1226: astore 4
    //   1228: goto -949 -> 279
    //   1231: iconst_0
    //   1232: istore 7
    //   1234: goto -1027 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1237	0	this	AndroidCamera
    //   0	1237	1	paramInt1	int
    //   0	1237	2	paramInt2	int
    //   11	147	3	localObject1	Object
    //   162	14	3	localException1	Exception
    //   180	1001	3	localObject2	Object
    //   73	45	4	localList	List
    //   155	30	4	localObject3	Object
    //   221	114	4	localObject4	Object
    //   436	15	4	localException2	Exception
    //   647	417	4	localSize	Camera.Size
    //   1089	15	4	localException3	Exception
    //   1110	13	4	localIterator	Iterator
    //   1221	1	4	localException4	Exception
    //   1226	1	4	localException5	Exception
    //   341	805	5	localObject5	Object
    //   363	63	6	localInteger	Integer
    //   81	1152	7	i1	int
    //   196	882	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   14	34	155	finally
    //   34	36	155	finally
    //   144	152	155	finally
    //   157	159	155	finally
    //   36	44	162	java/lang/Exception
    //   283	299	436	java/lang/Exception
    //   304	319	436	java/lang/Exception
    //   324	343	436	java/lang/Exception
    //   343	398	436	java/lang/Exception
    //   398	425	436	java/lang/Exception
    //   425	433	436	java/lang/Exception
    //   1097	1112	436	java/lang/Exception
    //   1112	1151	436	java/lang/Exception
    //   1151	1155	436	java/lang/Exception
    //   1158	1162	436	java/lang/Exception
    //   48	75	1089	java/lang/Exception
    //   83	135	1089	java/lang/Exception
    //   184	198	1089	java/lang/Exception
    //   783	798	1089	java/lang/Exception
    //   805	820	1089	java/lang/Exception
    //   827	843	1089	java/lang/Exception
    //   851	865	1089	java/lang/Exception
    //   871	886	1089	java/lang/Exception
    //   893	908	1089	java/lang/Exception
    //   915	929	1089	java/lang/Exception
    //   935	949	1089	java/lang/Exception
    //   955	969	1089	java/lang/Exception
    //   975	990	1089	java/lang/Exception
    //   997	1012	1089	java/lang/Exception
    //   1019	1034	1089	java/lang/Exception
    //   1041	1056	1089	java/lang/Exception
    //   1063	1077	1089	java/lang/Exception
    //   635	643	1221	java/lang/Exception
    //   207	223	1226	java/lang/Exception
    //   228	243	1226	java/lang/Exception
    //   248	258	1226	java/lang/Exception
    //   263	279	1226	java/lang/Exception
  }
  
  protected void a(Camera paramCamera)
  {
    try
    {
      Method localMethod = paramCamera.getClass().getMethod("setDisplayOrientation", new Class[] { Integer.TYPE });
      if (this.jdField_d_of_type_Int == 1) {}
      for (int i1 = a(this.jdField_e_of_type_Boolean) % 360;; i1 = b(this.jdField_e_of_type_Boolean) % 360)
      {
        localMethod.invoke(paramCamera, new Object[] { Integer.valueOf(i1) });
        return;
      }
      return;
    }
    catch (Exception paramCamera)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AndroidCamera", 2, "adjustDirection", paramCamera);
      }
    }
  }
  
  protected void a(Camera paramCamera, int paramInt)
  {
    try
    {
      paramCamera.getClass().getMethod("setDisplayOrientation", new Class[] { Integer.TYPE }).invoke(paramCamera, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramCamera)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AndroidCamera", 2, "setDisplayOrientation", paramCamera);
    }
  }
  
  public void a(AndroidCamera.CameraPreviewCallback paramCameraPreviewCallback)
  {
    this.jdField_a_of_type_ComTencentAvCameraAndroidCamera$CameraPreviewCallback = paramCameraPreviewCallback;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      this.j = (paramInt % 360);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AndroidCamera", 2, "mFrontCameraAngle: " + this.j + ", mBackCameraAngle: " + this.k);
      }
      return;
      this.k = (paramInt % 360);
    }
  }
  
  public boolean a()
  {
    return this.f >= 10;
  }
  
  protected boolean a(int paramInt, Camera paramCamera)
  {
    ggl localggl = a(paramInt, paramCamera);
    if (QLog.isColorLevel()) {
      QLog.d("AndroidCamera", 2, "getCameraDisplayOrientation orientation:" + localggl.b + ",rotation:" + localggl.c);
    }
    this.i = e();
    this.h = f();
    if (localggl.jdField_a_of_type_Int == 1)
    {
      paramInt = (360 - (g() + h()) % 360) % 360;
      if (localggl.jdField_a_of_type_Int != 1) {
        break label173;
      }
    }
    label173:
    for (paramInt = (paramInt + a(this.jdField_e_of_type_Boolean)) % 360;; paramInt = (paramInt + b(this.jdField_e_of_type_Boolean)) % 360)
    {
      a(paramCamera, paramInt);
      jdField_a_of_type_Ggl.jdField_a_of_type_Int = localggl.jdField_a_of_type_Int;
      jdField_a_of_type_Ggl.b = localggl.b;
      return true;
      paramInt = (g() - h() + 360) % 360;
      break;
    }
  }
  
  public boolean a(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("AndroidCamera", 2, "openCamera begin.");
        }
        if (jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          jdField_a_of_type_Boolean = bool1;
          if (QLog.isColorLevel()) {
            QLog.d("AndroidCamera", 2, "openCamera end.");
          }
          QavCameraUsage.a(BaseApplicationImpl.getContext(), bool1);
          return bool1;
        }
        if (this.jdField_a_of_type_AndroidContentContext == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AndroidCamera", 2, "openCamera context == null");
          }
        }
        else if (this.jdField_d_of_type_Int == 0)
        {
          if ((!b()) && (!c()))
          {
            if (!QLog.isColorLevel()) {
              break label303;
            }
            QLog.d("AndroidCamera", 2, "openCamera failed");
            break label303;
          }
          if (this.jdField_a_of_type_AndroidHardwareCamera == null)
          {
            if (!QLog.isColorLevel()) {
              break label308;
            }
            QLog.d("AndroidCamera", 2, "openCamera camera == null");
            break label308;
          }
          a(l, m);
          bool1 = true;
          if (bool1) {
            continue;
          }
          this.jdField_d_of_type_Int = 0;
        }
        switch (this.jdField_d_of_type_Int)
        {
        case 1: 
          if (!b()) {
            break label313;
          }
          a(l, m);
          bool1 = true;
          break;
        case 2: 
          if (!c()) {
            break label313;
          }
          a(l, m);
          bool1 = true;
          continue;
          try
          {
            this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback);
            this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(paramSurfaceTexture);
            this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
            bool1 = bool2;
          }
          catch (Exception paramSurfaceTexture)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AndroidCamera", 2, "setPreviewDisplay error", paramSurfaceTexture);
            }
            bool1 = false;
          }
          continue;
          bool1 = false;
        }
      }
      finally {}
      continue;
      label303:
      boolean bool1 = false;
      continue;
      label308:
      bool1 = false;
      continue;
      label313:
      bool1 = false;
    }
  }
  
  public boolean a(SurfaceHolder paramSurfaceHolder)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("AndroidCamera", 2, "openCamera begin.");
        }
        if (jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          jdField_a_of_type_Boolean = bool1;
          if (QLog.isColorLevel()) {
            QLog.d("AndroidCamera", 2, "openCamera end.");
          }
          QavCameraUsage.a(BaseApplicationImpl.getContext(), bool1);
          return bool1;
        }
        if (this.jdField_a_of_type_AndroidContentContext == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AndroidCamera", 2, "openCamera context == null");
          }
        }
        else if (this.jdField_d_of_type_Int == 0)
        {
          if ((!b()) && (!c()))
          {
            if (!QLog.isColorLevel()) {
              break label303;
            }
            QLog.d("AndroidCamera", 2, "openCamera failed");
            break label303;
          }
          if (this.jdField_a_of_type_AndroidHardwareCamera == null)
          {
            if (!QLog.isColorLevel()) {
              break label308;
            }
            QLog.d("AndroidCamera", 2, "openCamera camera == null");
            break label308;
          }
          a(l, m);
          bool1 = true;
          if (bool1) {
            continue;
          }
          this.jdField_d_of_type_Int = 0;
        }
        switch (this.jdField_d_of_type_Int)
        {
        case 1: 
          if (!b()) {
            break label313;
          }
          a(l, m);
          bool1 = true;
          break;
        case 2: 
          if (!c()) {
            break label313;
          }
          a(l, m);
          bool1 = true;
          continue;
          try
          {
            this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback);
            this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(paramSurfaceHolder);
            this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
            bool1 = bool2;
          }
          catch (Exception paramSurfaceHolder)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AndroidCamera", 2, "setPreviewDisplay error", paramSurfaceHolder);
            }
            bool1 = false;
          }
          continue;
          bool1 = false;
        }
      }
      finally {}
      continue;
      label303:
      boolean bool1 = false;
      continue;
      label308:
      bool1 = false;
      continue;
      label313:
      bool1 = false;
    }
  }
  
  public int b()
  {
    return this.i;
  }
  
  public int b(int paramInt, boolean paramBoolean)
  {
    byte b1;
    switch (paramInt)
    {
    default: 
      b1 = 0;
    }
    while (paramBoolean)
    {
      return ConfigSystemImpl.a(this.jdField_a_of_type_AndroidContentContext, false, false, b1, false) * 90;
      b1 = 0;
      continue;
      b1 = 1;
      continue;
      b1 = 2;
      continue;
      b1 = 3;
    }
    return ConfigSystemImpl.b(this.jdField_a_of_type_AndroidContentContext, false, false, b1, false) * 90;
  }
  
  int b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return ConfigSystemImpl.a(this.jdField_a_of_type_AndroidContentContext, false, true, (byte)0, false) * 90;
    }
    return ConfigSystemImpl.b(this.jdField_a_of_type_AndroidContentContext, false, true, (byte)0, false) * 90;
  }
  
  protected Camera.Size b(List paramList, int paramInt1, int paramInt2)
  {
    Iterator localIterator = paramList.iterator();
    Camera.Size localSize;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localSize = (Camera.Size)localIterator.next();
        if ((localSize.width == paramInt1) && (localSize.height == paramInt2))
        {
          paramList = localSize;
          if (QLog.isColorLevel())
          {
            QLog.d("AndroidCamera", 2, "previewsize, w= " + paramInt1 + ",h=" + paramInt2);
            paramList = localSize;
          }
        }
      }
    }
    do
    {
      return paramList;
      if ((paramInt1 != 320) || (paramInt2 != 240)) {
        break;
      }
      localIterator = paramList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localSize = (Camera.Size)localIterator.next();
      } while ((localSize.width != 640) || (localSize.height != 480));
      paramList = localSize;
    } while (!QLog.isColorLevel());
    QLog.d("AndroidCamera", 2, "previewsize ,w= " + 640 + ",h=" + 480);
    return localSize;
    if (0 == 0) {
      return a(paramList, l, m);
    }
    return null;
  }
  
  protected Camera b()
  {
    Camera localCamera2 = this.jdField_a_of_type_AndroidHardwareCamera;
    Camera localCamera1;
    if (localCamera2 != null) {
      localCamera1 = localCamera2;
    }
    try
    {
      localCamera2.release();
      localCamera1 = localCamera2;
      localCamera2 = Camera.open();
      if (localCamera2 == null) {
        return null;
      }
      localCamera1 = localCamera2;
      Camera.Parameters localParameters = (Camera.Parameters)localCamera2.getClass().getMethod("getCustomParameters", new Class[0]).invoke(localCamera2, new Object[0]);
      localCamera1 = localCamera2;
      ArrayList localArrayList = a(localParameters.get("camera-sensor-values"));
      localCamera1 = localCamera2;
      Method localMethod = localCamera2.getClass().getMethod("setCustomParameters", new Class[] { localParameters.getClass() });
      if (localArrayList != null)
      {
        localCamera1 = localCamera2;
        if (localArrayList.indexOf(Integer.valueOf(1)) != -1)
        {
          localCamera1 = localCamera2;
          localParameters.set("camera-sensor", "1");
          localCamera1 = localCamera2;
          localMethod.invoke(localCamera2, new Object[] { localParameters });
          return localCamera2;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AndroidCamera", 2, "tryMotoFrontCamera", localException);
      }
      if (localCamera1 != null) {
        localCamera1.release();
      }
      return null;
    }
    return localException;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 2)
    {
      this.jdField_d_of_type_Int = i1;
      return;
    }
  }
  
  protected boolean b()
  {
    jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidHardwareCamera = c();
    if (this.jdField_a_of_type_AndroidHardwareCamera == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AndroidCamera", 2, "openFrontCamera camera == null");
      }
      jdField_a_of_type_Boolean = false;
      jdField_b_of_type_Boolean = false;
      return false;
    }
    if (this.jdField_e_of_type_Int == 0) {
      this.jdField_e_of_type_Int = 2;
    }
    this.jdField_d_of_type_Int = 1;
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("AndroidCamera", 2, "openFrontCamera success");
    }
    return true;
  }
  
  public boolean b(SurfaceTexture paramSurfaceTexture)
  {
    label241:
    for (;;)
    {
      try
      {
        if (this.jdField_e_of_type_Int >= 1) {
          if (this.jdField_a_of_type_AndroidHardwareCamera == null)
          {
            break label241;
            QavCameraUsage.a(BaseApplicationImpl.getContext(), bool1);
            return bool1;
          }
          else
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder().append("switchCamera: ");
              if (this.jdField_d_of_type_Int == 1)
              {
                str = "FRONT_CAMERA";
                QLog.d("AndroidCamera", 2, str);
              }
            }
            else
            {
              d();
              int i1 = this.jdField_d_of_type_Int;
              switch (i1)
              {
              default: 
                bool2 = false;
                bool1 = bool2;
                if (!bool2) {
                  continue;
                }
              }
            }
            try
            {
              this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback);
              this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(paramSurfaceTexture);
              this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
              bool1 = true;
            }
            catch (Exception paramSurfaceTexture)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("AndroidCamera", 2, "switchCamera error", paramSurfaceTexture);
              bool1 = false;
            }
            String str = "BACK_CAMERA";
            continue;
            if (!c()) {
              continue;
            }
            a(l, m);
            boolean bool2 = true;
            continue;
            if (!b()) {
              continue;
            }
            a(l, m);
            bool2 = true;
            continue;
            continue;
          }
        }
        boolean bool1 = false;
      }
      finally {}
    }
  }
  
  public boolean b(SurfaceHolder paramSurfaceHolder)
  {
    label241:
    for (;;)
    {
      try
      {
        if (this.jdField_e_of_type_Int >= 1) {
          if (this.jdField_a_of_type_AndroidHardwareCamera == null)
          {
            break label241;
            QavCameraUsage.a(BaseApplicationImpl.getContext(), bool1);
            return bool1;
          }
          else
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder().append("switchCamera: ");
              if (this.jdField_d_of_type_Int == 1)
              {
                str = "FRONT_CAMERA";
                QLog.d("AndroidCamera", 2, str);
              }
            }
            else
            {
              d();
              int i1 = this.jdField_d_of_type_Int;
              switch (i1)
              {
              default: 
                bool2 = false;
                bool1 = bool2;
                if (!bool2) {
                  continue;
                }
              }
            }
            try
            {
              this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback);
              this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(paramSurfaceHolder);
              this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
              bool1 = true;
            }
            catch (Exception paramSurfaceHolder)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("AndroidCamera", 2, "switchCamera error", paramSurfaceHolder);
              bool1 = false;
            }
            String str = "BACK_CAMERA";
            continue;
            if (!c()) {
              continue;
            }
            a(l, m);
            boolean bool2 = true;
            continue;
            if (!b()) {
              continue;
            }
            a(l, m);
            bool2 = true;
            continue;
            continue;
          }
        }
        boolean bool1 = false;
      }
      finally {}
    }
  }
  
  public int c()
  {
    return this.h;
  }
  
  public int c(boolean paramBoolean)
  {
    if (paramBoolean == true) {
      return this.j;
    }
    return this.k;
  }
  
  protected Camera c()
  {
    if (a()) {
      return d();
    }
    if (this.jdField_c_of_type_JavaLangString.equalsIgnoreCase("motorola")) {
      return b();
    }
    if (this.jdField_c_of_type_JavaLangString.equalsIgnoreCase("samsung")) {
      return a();
    }
    return null;
  }
  
  protected boolean c()
  {
    try
    {
      jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidHardwareCamera = Camera.open();
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        this.jdField_d_of_type_Int = 2;
        jdField_a_of_type_Boolean = true;
        jdField_b_of_type_Boolean = false;
        a();
        if (QLog.isColorLevel()) {
          QLog.d("AndroidCamera", 2, "openBackCamera success");
        }
        return true;
      }
    }
    catch (Exception localException)
    {
      jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        this.jdField_a_of_type_AndroidHardwareCamera.release();
        this.jdField_a_of_type_AndroidHardwareCamera = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AndroidCamera", 2, "openBackCamera exception");
      }
      return false;
    }
    jdField_b_of_type_Boolean = false;
    return false;
  }
  
  public boolean c(SurfaceTexture paramSurfaceTexture)
  {
    label249:
    for (;;)
    {
      try
      {
        if (this.jdField_e_of_type_Int >= 1) {
          if (this.jdField_a_of_type_AndroidHardwareCamera == null)
          {
            break label249;
            QavCameraUsage.a(BaseApplicationImpl.getContext(), bool1);
            return bool1;
          }
          else
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder().append("reopenCamera: ");
              if (this.jdField_d_of_type_Int == 1)
              {
                str = "FRONT_CAMERA";
                QLog.d("AndroidCamera", 2, str);
              }
            }
            else
            {
              d();
              int i1 = this.jdField_d_of_type_Int;
              switch (i1)
              {
              default: 
                bool2 = false;
                bool1 = bool2;
                if (!bool2) {
                  continue;
                }
              }
            }
            try
            {
              this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback);
              if (Build.VERSION.SDK_INT >= 11) {
                this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(paramSurfaceTexture);
              }
              this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
              bool1 = true;
            }
            catch (Exception paramSurfaceTexture)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("AndroidCamera", 2, "reopenCamera error", paramSurfaceTexture);
              bool1 = false;
            }
            String str = "BACK_CAMERA";
            continue;
            if (!c()) {
              continue;
            }
            a(l, m);
            boolean bool2 = true;
            continue;
            if (!b()) {
              continue;
            }
            a(l, m);
            bool2 = true;
            continue;
            continue;
          }
        }
        boolean bool1 = false;
      }
      finally {}
    }
  }
  
  public boolean c(SurfaceHolder paramSurfaceHolder)
  {
    label241:
    for (;;)
    {
      try
      {
        if (this.jdField_e_of_type_Int >= 1) {
          if (this.jdField_a_of_type_AndroidHardwareCamera == null)
          {
            break label241;
            QavCameraUsage.a(BaseApplicationImpl.getContext(), bool1);
            return bool1;
          }
          else
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder().append("reopenCamera: ");
              if (this.jdField_d_of_type_Int == 1)
              {
                str = "FRONT_CAMERA";
                QLog.d("AndroidCamera", 2, str);
              }
            }
            else
            {
              d();
              int i1 = this.jdField_d_of_type_Int;
              switch (i1)
              {
              default: 
                bool2 = false;
                bool1 = bool2;
                if (!bool2) {
                  continue;
                }
              }
            }
            try
            {
              this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback);
              this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(paramSurfaceHolder);
              this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
              bool1 = true;
            }
            catch (Exception paramSurfaceHolder)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("AndroidCamera", 2, "reopenCamera error", paramSurfaceHolder);
              bool1 = false;
            }
            String str = "BACK_CAMERA";
            continue;
            if (!c()) {
              continue;
            }
            a(l, m);
            boolean bool2 = true;
            continue;
            if (!b()) {
              continue;
            }
            a(l, m);
            bool2 = true;
            continue;
            continue;
          }
        }
        boolean bool1 = false;
      }
      finally {}
    }
  }
  
  protected int d()
  {
    if (!MobileIssueSettings.h) {
      return KapalaiAdapterUtil.a().b();
    }
    try
    {
      int i1 = Integer.parseInt(Class.forName("android.hardware.Camera").getMethod("getNumberOfCameras", new Class[0]).invoke(null, (Object[])null).toString());
      return i1;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AndroidCamera", 2, "GetNumberOfCamera", localException);
      }
    }
    return 1;
  }
  
  /* Error */
  protected Camera d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 8
    //   11: aconst_null
    //   12: astore 9
    //   14: aconst_null
    //   15: astore 10
    //   17: aconst_null
    //   18: astore 11
    //   20: aconst_null
    //   21: astore 12
    //   23: aconst_null
    //   24: astore 5
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield 213	com/tencent/av/camera/AndroidCamera:g	I
    //   31: ldc -41
    //   33: invokestatic 221	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   36: astore 13
    //   38: aload_0
    //   39: getfield 63	com/tencent/av/camera/AndroidCamera:jdField_e_of_type_Int	I
    //   42: ifne +11 -> 53
    //   45: aload_0
    //   46: aload_0
    //   47: invokevirtual 223	com/tencent/av/camera/AndroidCamera:d	()I
    //   50: putfield 63	com/tencent/av/camera/AndroidCamera:jdField_e_of_type_Int	I
    //   53: aload_2
    //   54: astore_1
    //   55: aload_0
    //   56: getfield 63	com/tencent/av/camera/AndroidCamera:jdField_e_of_type_Int	I
    //   59: ifle +244 -> 303
    //   62: ldc -31
    //   64: invokestatic 221	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   67: astore 15
    //   69: aload 15
    //   71: ifnull +495 -> 566
    //   74: aload 15
    //   76: invokevirtual 229	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   79: astore_3
    //   80: aload_3
    //   81: ifnull +479 -> 560
    //   84: aload_3
    //   85: invokevirtual 233	java/lang/Object:getClass	()Ljava/lang/Class;
    //   88: ldc -21
    //   90: invokevirtual 239	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   93: astore 4
    //   95: aload 13
    //   97: ldc -15
    //   99: iconst_2
    //   100: anewarray 217	java/lang/Class
    //   103: dup
    //   104: iconst_0
    //   105: getstatic 245	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: aload 15
    //   113: aastore
    //   114: invokevirtual 249	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   117: astore 14
    //   119: aload_2
    //   120: astore_1
    //   121: aload 14
    //   123: ifnull +180 -> 303
    //   126: aload_2
    //   127: astore_1
    //   128: aload 15
    //   130: ifnull +173 -> 303
    //   133: aload_2
    //   134: astore_1
    //   135: aload 4
    //   137: ifnull +166 -> 303
    //   140: iconst_0
    //   141: istore 16
    //   143: aconst_null
    //   144: astore_1
    //   145: iload 16
    //   147: aload_0
    //   148: getfield 63	com/tencent/av/camera/AndroidCamera:jdField_e_of_type_Int	I
    //   151: if_icmpge +407 -> 558
    //   154: aload 14
    //   156: aconst_null
    //   157: iconst_2
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: iload 16
    //   165: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: aastore
    //   169: dup
    //   170: iconst_1
    //   171: aload_3
    //   172: aastore
    //   173: invokevirtual 255	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   176: pop
    //   177: aload 4
    //   179: aload_3
    //   180: invokevirtual 261	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   183: istore 17
    //   185: iload 17
    //   187: iconst_1
    //   188: if_icmpne +365 -> 553
    //   191: aload 13
    //   193: ldc_w 263
    //   196: iconst_1
    //   197: anewarray 217	java/lang/Class
    //   200: dup
    //   201: iconst_0
    //   202: getstatic 245	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   205: aastore
    //   206: invokevirtual 249	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   209: astore_2
    //   210: aload_2
    //   211: ifnull +342 -> 553
    //   214: aload_2
    //   215: aconst_null
    //   216: iconst_1
    //   217: anewarray 4	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: iload 16
    //   224: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   227: aastore
    //   228: invokevirtual 255	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   231: checkcast 332	android/hardware/Camera
    //   234: astore_2
    //   235: aload_0
    //   236: iload 16
    //   238: putfield 213	com/tencent/av/camera/AndroidCamera:g	I
    //   241: iload 16
    //   243: iconst_1
    //   244: iadd
    //   245: istore 16
    //   247: aload_2
    //   248: astore_1
    //   249: goto -104 -> 145
    //   252: astore_1
    //   253: aload_0
    //   254: iconst_0
    //   255: putfield 213	com/tencent/av/camera/AndroidCamera:g	I
    //   258: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +13 -> 274
    //   264: ldc 11
    //   266: iconst_2
    //   267: ldc_w 265
    //   270: aload_1
    //   271: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   274: aconst_null
    //   275: astore_2
    //   276: goto -35 -> 241
    //   279: astore_3
    //   280: aload 5
    //   282: astore_2
    //   283: aload_2
    //   284: astore_1
    //   285: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +15 -> 303
    //   291: ldc 11
    //   293: iconst_2
    //   294: ldc_w 633
    //   297: aload_3
    //   298: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   301: aload_2
    //   302: astore_1
    //   303: aload_1
    //   304: areturn
    //   305: astore_3
    //   306: aload 6
    //   308: astore_2
    //   309: aload_2
    //   310: astore_1
    //   311: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   314: ifeq -11 -> 303
    //   317: ldc 11
    //   319: iconst_2
    //   320: ldc_w 635
    //   323: aload_3
    //   324: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   327: aload_2
    //   328: areturn
    //   329: astore_3
    //   330: aload 7
    //   332: astore_2
    //   333: aload_2
    //   334: astore_1
    //   335: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   338: ifeq -35 -> 303
    //   341: ldc 11
    //   343: iconst_2
    //   344: ldc_w 637
    //   347: aload_3
    //   348: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   351: aload_2
    //   352: areturn
    //   353: astore_3
    //   354: aload 8
    //   356: astore_2
    //   357: aload_2
    //   358: astore_1
    //   359: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq -59 -> 303
    //   365: ldc 11
    //   367: iconst_2
    //   368: ldc_w 639
    //   371: aload_3
    //   372: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   375: aload_2
    //   376: areturn
    //   377: astore_3
    //   378: aload 9
    //   380: astore_2
    //   381: aload_2
    //   382: astore_1
    //   383: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq -83 -> 303
    //   389: ldc 11
    //   391: iconst_2
    //   392: ldc_w 641
    //   395: aload_3
    //   396: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   399: aload_2
    //   400: areturn
    //   401: astore_3
    //   402: aload 10
    //   404: astore_2
    //   405: aload_2
    //   406: astore_1
    //   407: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq -107 -> 303
    //   413: ldc 11
    //   415: iconst_2
    //   416: ldc_w 643
    //   419: aload_3
    //   420: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   423: aload_2
    //   424: areturn
    //   425: astore_3
    //   426: aload 11
    //   428: astore_2
    //   429: aload_2
    //   430: astore_1
    //   431: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq -131 -> 303
    //   437: ldc 11
    //   439: iconst_2
    //   440: ldc_w 645
    //   443: aload_3
    //   444: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   447: aload_2
    //   448: areturn
    //   449: astore_3
    //   450: aload 12
    //   452: astore_2
    //   453: aload_2
    //   454: astore_1
    //   455: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   458: ifeq -155 -> 303
    //   461: ldc 11
    //   463: iconst_2
    //   464: ldc_w 265
    //   467: aload_3
    //   468: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   471: aload_2
    //   472: areturn
    //   473: astore_3
    //   474: aload_1
    //   475: astore_2
    //   476: goto -23 -> 453
    //   479: astore_3
    //   480: goto -27 -> 453
    //   483: astore_3
    //   484: aload_1
    //   485: astore_2
    //   486: goto -57 -> 429
    //   489: astore_3
    //   490: goto -61 -> 429
    //   493: astore_3
    //   494: aload_1
    //   495: astore_2
    //   496: goto -91 -> 405
    //   499: astore_3
    //   500: goto -95 -> 405
    //   503: astore_3
    //   504: aload_1
    //   505: astore_2
    //   506: goto -125 -> 381
    //   509: astore_3
    //   510: goto -129 -> 381
    //   513: astore_3
    //   514: aload_1
    //   515: astore_2
    //   516: goto -159 -> 357
    //   519: astore_3
    //   520: goto -163 -> 357
    //   523: astore_3
    //   524: aload_1
    //   525: astore_2
    //   526: goto -193 -> 333
    //   529: astore_3
    //   530: goto -197 -> 333
    //   533: astore_3
    //   534: aload_1
    //   535: astore_2
    //   536: goto -227 -> 309
    //   539: astore_3
    //   540: goto -231 -> 309
    //   543: astore_3
    //   544: aload_1
    //   545: astore_2
    //   546: goto -263 -> 283
    //   549: astore_3
    //   550: goto -267 -> 283
    //   553: aload_1
    //   554: astore_2
    //   555: goto -314 -> 241
    //   558: aload_1
    //   559: areturn
    //   560: aconst_null
    //   561: astore 4
    //   563: goto -468 -> 95
    //   566: aconst_null
    //   567: astore_3
    //   568: goto -488 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	571	0	this	AndroidCamera
    //   54	195	1	localObject1	Object
    //   252	19	1	localRuntimeException	RuntimeException
    //   284	275	1	localObject2	Object
    //   1	554	2	localObject3	Object
    //   79	101	3	localObject4	Object
    //   279	19	3	localClassNotFoundException1	ClassNotFoundException
    //   305	19	3	localNoSuchMethodException1	NoSuchMethodException
    //   329	19	3	localNoSuchFieldException1	NoSuchFieldException
    //   353	19	3	localIllegalAccessException1	IllegalAccessException
    //   377	19	3	localInvocationTargetException1	InvocationTargetException
    //   401	19	3	localInstantiationException1	InstantiationException
    //   425	19	3	localSecurityException1	SecurityException
    //   449	19	3	localException1	Exception
    //   473	1	3	localException2	Exception
    //   479	1	3	localException3	Exception
    //   483	1	3	localSecurityException2	SecurityException
    //   489	1	3	localSecurityException3	SecurityException
    //   493	1	3	localInstantiationException2	InstantiationException
    //   499	1	3	localInstantiationException3	InstantiationException
    //   503	1	3	localInvocationTargetException2	InvocationTargetException
    //   509	1	3	localInvocationTargetException3	InvocationTargetException
    //   513	1	3	localIllegalAccessException2	IllegalAccessException
    //   519	1	3	localIllegalAccessException3	IllegalAccessException
    //   523	1	3	localNoSuchFieldException2	NoSuchFieldException
    //   529	1	3	localNoSuchFieldException3	NoSuchFieldException
    //   533	1	3	localNoSuchMethodException2	NoSuchMethodException
    //   539	1	3	localNoSuchMethodException3	NoSuchMethodException
    //   543	1	3	localClassNotFoundException2	ClassNotFoundException
    //   549	1	3	localClassNotFoundException3	ClassNotFoundException
    //   567	1	3	localObject5	Object
    //   93	469	4	localField	Field
    //   24	257	5	localObject6	Object
    //   3	304	6	localObject7	Object
    //   6	325	7	localObject8	Object
    //   9	346	8	localObject9	Object
    //   12	367	9	localObject10	Object
    //   15	388	10	localObject11	Object
    //   18	409	11	localObject12	Object
    //   21	430	12	localObject13	Object
    //   36	156	13	localClass1	Class
    //   117	38	14	localMethod	Method
    //   67	62	15	localClass2	Class
    //   141	105	16	i1	int
    //   183	6	17	i2	int
    // Exception table:
    //   from	to	target	type
    //   191	210	252	java/lang/RuntimeException
    //   214	235	252	java/lang/RuntimeException
    //   235	241	252	java/lang/RuntimeException
    //   31	53	279	java/lang/ClassNotFoundException
    //   55	69	279	java/lang/ClassNotFoundException
    //   74	80	279	java/lang/ClassNotFoundException
    //   84	95	279	java/lang/ClassNotFoundException
    //   95	119	279	java/lang/ClassNotFoundException
    //   253	274	279	java/lang/ClassNotFoundException
    //   31	53	305	java/lang/NoSuchMethodException
    //   55	69	305	java/lang/NoSuchMethodException
    //   74	80	305	java/lang/NoSuchMethodException
    //   84	95	305	java/lang/NoSuchMethodException
    //   95	119	305	java/lang/NoSuchMethodException
    //   253	274	305	java/lang/NoSuchMethodException
    //   31	53	329	java/lang/NoSuchFieldException
    //   55	69	329	java/lang/NoSuchFieldException
    //   74	80	329	java/lang/NoSuchFieldException
    //   84	95	329	java/lang/NoSuchFieldException
    //   95	119	329	java/lang/NoSuchFieldException
    //   253	274	329	java/lang/NoSuchFieldException
    //   31	53	353	java/lang/IllegalAccessException
    //   55	69	353	java/lang/IllegalAccessException
    //   74	80	353	java/lang/IllegalAccessException
    //   84	95	353	java/lang/IllegalAccessException
    //   95	119	353	java/lang/IllegalAccessException
    //   253	274	353	java/lang/IllegalAccessException
    //   31	53	377	java/lang/reflect/InvocationTargetException
    //   55	69	377	java/lang/reflect/InvocationTargetException
    //   74	80	377	java/lang/reflect/InvocationTargetException
    //   84	95	377	java/lang/reflect/InvocationTargetException
    //   95	119	377	java/lang/reflect/InvocationTargetException
    //   253	274	377	java/lang/reflect/InvocationTargetException
    //   31	53	401	java/lang/InstantiationException
    //   55	69	401	java/lang/InstantiationException
    //   74	80	401	java/lang/InstantiationException
    //   84	95	401	java/lang/InstantiationException
    //   95	119	401	java/lang/InstantiationException
    //   253	274	401	java/lang/InstantiationException
    //   31	53	425	java/lang/SecurityException
    //   55	69	425	java/lang/SecurityException
    //   74	80	425	java/lang/SecurityException
    //   84	95	425	java/lang/SecurityException
    //   95	119	425	java/lang/SecurityException
    //   253	274	425	java/lang/SecurityException
    //   31	53	449	java/lang/Exception
    //   55	69	449	java/lang/Exception
    //   74	80	449	java/lang/Exception
    //   84	95	449	java/lang/Exception
    //   95	119	449	java/lang/Exception
    //   253	274	449	java/lang/Exception
    //   145	185	473	java/lang/Exception
    //   191	210	473	java/lang/Exception
    //   214	235	473	java/lang/Exception
    //   235	241	479	java/lang/Exception
    //   145	185	483	java/lang/SecurityException
    //   191	210	483	java/lang/SecurityException
    //   214	235	483	java/lang/SecurityException
    //   235	241	489	java/lang/SecurityException
    //   145	185	493	java/lang/InstantiationException
    //   191	210	493	java/lang/InstantiationException
    //   214	235	493	java/lang/InstantiationException
    //   235	241	499	java/lang/InstantiationException
    //   145	185	503	java/lang/reflect/InvocationTargetException
    //   191	210	503	java/lang/reflect/InvocationTargetException
    //   214	235	503	java/lang/reflect/InvocationTargetException
    //   235	241	509	java/lang/reflect/InvocationTargetException
    //   145	185	513	java/lang/IllegalAccessException
    //   191	210	513	java/lang/IllegalAccessException
    //   214	235	513	java/lang/IllegalAccessException
    //   235	241	519	java/lang/IllegalAccessException
    //   145	185	523	java/lang/NoSuchFieldException
    //   191	210	523	java/lang/NoSuchFieldException
    //   214	235	523	java/lang/NoSuchFieldException
    //   235	241	529	java/lang/NoSuchFieldException
    //   145	185	533	java/lang/NoSuchMethodException
    //   191	210	533	java/lang/NoSuchMethodException
    //   214	235	533	java/lang/NoSuchMethodException
    //   235	241	539	java/lang/NoSuchMethodException
    //   145	185	543	java/lang/ClassNotFoundException
    //   191	210	543	java/lang/ClassNotFoundException
    //   214	235	543	java/lang/ClassNotFoundException
    //   235	241	549	java/lang/ClassNotFoundException
  }
  
  public boolean d()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AndroidCamera", 2, "closeCamera begin.");
      }
      if ((this.jdField_a_of_type_AndroidHardwareCamera == null) && (!jdField_a_of_type_Boolean) && (QLog.isColorLevel())) {
        QLog.d("AndroidCamera", 2, "Camera not open.");
      }
      try
      {
        if (this.jdField_a_of_type_AndroidHardwareCamera != null)
        {
          if (jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(null);
            this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
            this.jdField_a_of_type_AndroidHardwareCamera.release();
          }
          this.jdField_a_of_type_AndroidHardwareCamera = null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AndroidCamera", 2, "closeCamera Exception", localException);
          }
        }
      }
      jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("AndroidCamera", 2, "closeCamera end.");
      }
      QavCameraUsage.a(BaseApplicationImpl.getContext(), false);
      return true;
    }
    finally {}
  }
  
  protected int e()
  {
    return 0;
  }
  
  public Camera e()
  {
    return this.jdField_a_of_type_AndroidHardwareCamera;
  }
  
  public boolean e()
  {
    if (this.jdField_d_of_type_Int == 0) {}
    while (this.jdField_d_of_type_Int == 1) {
      return true;
    }
    return false;
  }
  
  protected int f()
  {
    return 0;
  }
  
  public boolean f()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public int g()
  {
    if (jdField_a_of_type_Ggl.b == -1)
    {
      if (this.jdField_d_of_type_Int == 1) {
        return 270;
      }
      if (this.jdField_d_of_type_Int == 2) {
        return 90;
      }
    }
    return jdField_a_of_type_Ggl.b;
  }
  
  public boolean g()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public int h()
  {
    if (jdField_a_of_type_Ggl.c == -1) {
      return 0;
    }
    return jdField_a_of_type_Ggl.c;
  }
  
  public int i()
  {
    return d();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\camera\AndroidCamera.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */