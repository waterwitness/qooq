package com.tencent.mobileqq.utils.kapalaiadapter;

import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.kapalaiadapter.sdcardmountinforutil.SDCardMountInforUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import wea;

public class KapalaiAdapterUtil
{
  public int a;
  private DualSimManager a;
  
  private KapalaiAdapterUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager = DualSimManager.a();
  }
  
  public static KapalaiAdapterUtil a()
  {
    return wea.a;
  }
  
  private Camera b()
  {
    Object localObject2 = null;
    try
    {
      localObject1 = Camera.open();
      Camera.Parameters localParameters;
      if ((localObject1 != null) && (localObject1 == null)) {
        break label57;
      }
      ((Camera)localObject1).release();
    }
    catch (Exception localException1)
    {
      try
      {
        localParameters = ((Camera)localObject1).getParameters();
        if (localParameters != null)
        {
          localParameters.set("video_input", "secondary");
          ((Camera)localObject1).setParameters(localParameters);
        }
        return (Camera)localObject1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject1;
        }
      }
      localException1 = localException1;
      localObject1 = null;
    }
    localObject1 = localObject2;
    localException1.printStackTrace();
    return (Camera)localObject1;
  }
  
  private Camera c()
  {
    Object localObject2 = null;
    try
    {
      localObject1 = Camera.open();
      Camera.Parameters localParameters;
      if ((localObject1 != null) && (localObject1 == null)) {
        break label57;
      }
      ((Camera)localObject1).release();
    }
    catch (Exception localException1)
    {
      try
      {
        localParameters = ((Camera)localObject1).getParameters();
        if (localParameters != null)
        {
          localParameters.set("device", "/dev/video1");
          ((Camera)localObject1).setParameters(localParameters);
        }
        return (Camera)localObject1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject1;
        }
      }
      localException1 = localException1;
      localObject1 = null;
    }
    localObject1 = localObject2;
    localException1.printStackTrace();
    return (Camera)localObject1;
  }
  
  private Camera d()
  {
    Object localObject2 = null;
    try
    {
      localObject1 = Camera.open();
      Method localMethod;
      if ((localObject1 != null) && (localObject1 == null)) {
        break label76;
      }
      ((Camera)localObject1).release();
    }
    catch (Exception localException1)
    {
      try
      {
        localMethod = localObject1.getClass().getMethod("setSensorID", new Class[] { Integer.TYPE });
        if (localMethod != null) {
          localMethod.invoke(localObject1, new Object[] { Integer.valueOf(1) });
        }
        return (Camera)localObject1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject1;
        }
      }
      localException1 = localException1;
      localObject1 = null;
    }
    localObject1 = localObject2;
    localException1.printStackTrace();
    return (Camera)localObject1;
  }
  
  private Camera e()
  {
    Camera localCamera = null;
    try
    {
      Class localClass = Class.forName("android.hardware.Camera");
      Method localMethod = localClass.getMethod("setCurrentCamera", new Class[] { Integer.TYPE });
      if (localMethod != null)
      {
        localMethod.invoke(localClass, new Object[] { Integer.valueOf(1) });
        localCamera = Camera.open();
      }
      return localCamera;
    }
    catch (Exception localException)
    {
      if (0 != 0) {
        throw new NullPointerException();
      }
      localException.printStackTrace();
    }
    return null;
  }
  
  private Camera f()
  {
    Camera localCamera = null;
    try
    {
      if (VersionUtils.c()) {
        localCamera = Camera.open();
      }
      return localCamera;
    }
    catch (Exception localException)
    {
      if (0 != 0) {
        throw new NullPointerException();
      }
      localException.printStackTrace();
    }
    return null;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Notification a(Context paramContext, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 11)
        {
          paramContext = new Notification(paramInt, null, System.currentTimeMillis());
          localObject = paramContext;
          if (paramContext == null) {
            localObject = new Notification(paramInt, null, System.currentTimeMillis());
          }
          return (Notification)localObject;
        }
        paramContext = new Notification.Builder(paramContext);
        Object localObject = Class.forName("android.app.Notification$Builder").getDeclaredMethod("setInternalApp", new Class[] { Integer.TYPE });
        if (localObject != null)
        {
          ((Method)localObject).invoke(paramContext, new Object[] { Integer.valueOf(1) });
          if (Build.VERSION.SDK_INT >= 16)
          {
            paramContext = paramContext.build();
            continue;
          }
          if ((Build.VERSION.SDK_INT < 16) && (Build.VERSION.SDK_INT >= 11))
          {
            paramContext = paramContext.getNotification();
            continue;
            return null;
          }
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e("newNotificationForMeizu", 2, paramContext.getMessage());
        }
        if (0 == 0) {
          return new Notification(paramInt, null, System.currentTimeMillis());
        }
      }
      finally
      {
        if (0 == 0) {
          new Notification(paramInt, null, System.currentTimeMillis());
        }
      }
      paramContext = null;
    }
  }
  
  /* Error */
  public Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, boolean paramBoolean, com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload 7
    //   2: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:b	()Z
    //   5: istore 12
    //   7: invokestatic 182	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: iconst_0
    //   11: aload_1
    //   12: ldc -73
    //   14: invokestatic 189	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   17: astore 8
    //   19: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +29 -> 51
    //   25: ldc -65
    //   27: iconst_2
    //   28: new 193	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   35: ldc -60
    //   37: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload 8
    //   42: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 209	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: ldc -46
    //   53: istore 11
    //   55: aload_1
    //   56: ldc -44
    //   58: iconst_m1
    //   59: invokevirtual 218	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   62: sipush 1008
    //   65: if_icmpne +151 -> 216
    //   68: getstatic 224	com/tencent/mobileqq/app/AppConstants:ae	Ljava/lang/String;
    //   71: aload_1
    //   72: ldc -30
    //   74: invokevirtual 230	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifeq +128 -> 208
    //   83: iload 11
    //   85: istore 10
    //   87: aload_1
    //   88: ldc -18
    //   90: iconst_0
    //   91: invokevirtual 242	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   94: ifeq +7 -> 101
    //   97: ldc -13
    //   99: istore 10
    //   101: getstatic 127	android/os/Build$VERSION:SDK_INT	I
    //   104: bipush 11
    //   106: if_icmpge +196 -> 302
    //   109: new 129	android/app/Notification
    //   112: dup
    //   113: iload 10
    //   115: aload_3
    //   116: invokestatic 135	java/lang/System:currentTimeMillis	()J
    //   119: invokespecial 138	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   122: astore_1
    //   123: aload_1
    //   124: aload 8
    //   126: putfield 247	android/app/Notification:contentIntent	Landroid/app/PendingIntent;
    //   129: iload 12
    //   131: ifeq +24 -> 155
    //   134: aload_1
    //   135: aload_1
    //   136: getfield 250	android/app/Notification:flags	I
    //   139: bipush 32
    //   141: ior
    //   142: putfield 250	android/app/Notification:flags	I
    //   145: aload_1
    //   146: aload_1
    //   147: getfield 250	android/app/Notification:flags	I
    //   150: iconst_2
    //   151: ior
    //   152: putfield 250	android/app/Notification:flags	I
    //   155: invokestatic 182	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   158: aload 7
    //   160: invokestatic 255	com/tencent/mobileqq/util/NotifyLightUtil:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   163: ifeq +43 -> 206
    //   166: invokestatic 261	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   169: bipush 11
    //   171: invokevirtual 265	java/util/Calendar:get	(I)I
    //   174: pop
    //   175: aload_1
    //   176: aload_1
    //   177: getfield 250	android/app/Notification:flags	I
    //   180: iconst_1
    //   181: ior
    //   182: putfield 250	android/app/Notification:flags	I
    //   185: aload_1
    //   186: ldc_w 266
    //   189: putfield 269	android/app/Notification:ledARGB	I
    //   192: aload_1
    //   193: sipush 2000
    //   196: putfield 272	android/app/Notification:ledOffMS	I
    //   199: aload_1
    //   200: sipush 2000
    //   203: putfield 275	android/app/Notification:ledOnMS	I
    //   206: aload_1
    //   207: areturn
    //   208: ldc_w 276
    //   211: istore 10
    //   213: goto -126 -> 87
    //   216: aload_1
    //   217: ldc -44
    //   219: iconst_m1
    //   220: invokevirtual 218	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   223: sipush 1010
    //   226: if_icmpne +29 -> 255
    //   229: getstatic 279	com/tencent/mobileqq/app/AppConstants:aH	Ljava/lang/String;
    //   232: invokestatic 282	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   235: aload_1
    //   236: ldc -30
    //   238: invokevirtual 230	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   241: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   244: ifeq +11 -> 255
    //   247: ldc_w 283
    //   250: istore 10
    //   252: goto -165 -> 87
    //   255: iload 11
    //   257: istore 10
    //   259: aload_1
    //   260: ldc -44
    //   262: iconst_m1
    //   263: invokevirtual 218	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   266: sipush 1001
    //   269: if_icmpne -182 -> 87
    //   272: iload 11
    //   274: istore 10
    //   276: getstatic 286	com/tencent/mobileqq/app/AppConstants:ar	Ljava/lang/String;
    //   279: invokestatic 282	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   282: aload_1
    //   283: ldc -30
    //   285: invokevirtual 230	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   288: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   291: ifeq -204 -> 87
    //   294: ldc_w 287
    //   297: istore 10
    //   299: goto -212 -> 87
    //   302: new 140	android/app/Notification$Builder
    //   305: dup
    //   306: invokestatic 182	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   309: invokespecial 143	android/app/Notification$Builder:<init>	(Landroid/content/Context;)V
    //   312: iload 10
    //   314: invokevirtual 291	android/app/Notification$Builder:setSmallIcon	(I)Landroid/app/Notification$Builder;
    //   317: iconst_1
    //   318: invokevirtual 295	android/app/Notification$Builder:setAutoCancel	(Z)Landroid/app/Notification$Builder;
    //   321: invokestatic 135	java/lang/System:currentTimeMillis	()J
    //   324: invokevirtual 299	android/app/Notification$Builder:setWhen	(J)Landroid/app/Notification$Builder;
    //   327: aload_3
    //   328: invokevirtual 303	android/app/Notification$Builder:setTicker	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   331: astore_1
    //   332: iload 12
    //   334: ifeq +9 -> 343
    //   337: aload_1
    //   338: iconst_1
    //   339: invokevirtual 306	android/app/Notification$Builder:setOngoing	(Z)Landroid/app/Notification$Builder;
    //   342: pop
    //   343: ldc -111
    //   345: invokestatic 107	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   348: ldc -109
    //   350: iconst_1
    //   351: anewarray 80	java/lang/Class
    //   354: dup
    //   355: iconst_0
    //   356: getstatic 86	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   359: aastore
    //   360: invokevirtual 150	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   363: astore 9
    //   365: aload 9
    //   367: ifnull +21 -> 388
    //   370: aload 9
    //   372: aload_1
    //   373: iconst_1
    //   374: anewarray 4	java/lang/Object
    //   377: dup
    //   378: iconst_0
    //   379: iconst_1
    //   380: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   383: aastore
    //   384: invokevirtual 100	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   387: pop
    //   388: invokestatic 182	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   391: aload 7
    //   393: invokestatic 255	com/tencent/mobileqq/util/NotifyLightUtil:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   396: ifeq +26 -> 422
    //   399: invokestatic 261	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   402: bipush 11
    //   404: invokevirtual 265	java/util/Calendar:get	(I)I
    //   407: pop
    //   408: aload_1
    //   409: ldc_w 266
    //   412: sipush 2000
    //   415: sipush 2000
    //   418: invokevirtual 310	android/app/Notification$Builder:setLights	(III)Landroid/app/Notification$Builder;
    //   421: pop
    //   422: iload 6
    //   424: ifeq +55 -> 479
    //   427: aload_2
    //   428: ifnull +9 -> 437
    //   431: aload_1
    //   432: aload_2
    //   433: invokevirtual 314	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   436: pop
    //   437: aload_1
    //   438: aload 4
    //   440: invokevirtual 317	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   443: aload 5
    //   445: invokevirtual 320	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   448: aload 8
    //   450: invokevirtual 324	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   453: pop
    //   454: getstatic 127	android/os/Build$VERSION:SDK_INT	I
    //   457: bipush 16
    //   459: if_icmplt +50 -> 509
    //   462: aload_1
    //   463: invokevirtual 154	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   466: astore_1
    //   467: aload_1
    //   468: areturn
    //   469: astore 9
    //   471: aload 9
    //   473: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   476: goto -88 -> 388
    //   479: aload_1
    //   480: aload 4
    //   482: invokevirtual 317	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   485: aload 5
    //   487: invokevirtual 320	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   490: aload 8
    //   492: invokevirtual 324	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   495: pop
    //   496: aload_2
    //   497: ifnull -43 -> 454
    //   500: aload_1
    //   501: aload_2
    //   502: invokevirtual 314	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   505: pop
    //   506: goto -52 -> 454
    //   509: getstatic 127	android/os/Build$VERSION:SDK_INT	I
    //   512: bipush 16
    //   514: if_icmpge +16 -> 530
    //   517: getstatic 127	android/os/Build$VERSION:SDK_INT	I
    //   520: bipush 11
    //   522: if_icmplt +8 -> 530
    //   525: aload_1
    //   526: invokevirtual 157	android/app/Notification$Builder:getNotification	()Landroid/app/Notification;
    //   529: areturn
    //   530: new 129	android/app/Notification
    //   533: dup
    //   534: iload 10
    //   536: aload_3
    //   537: invokestatic 135	java/lang/System:currentTimeMillis	()J
    //   540: invokespecial 138	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   543: astore_1
    //   544: aload_1
    //   545: areturn
    //   546: astore_1
    //   547: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq +14 -> 564
    //   553: ldc_w 326
    //   556: iconst_2
    //   557: aload_1
    //   558: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   561: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: new 129	android/app/Notification
    //   567: dup
    //   568: iload 10
    //   570: aload_3
    //   571: invokestatic 135	java/lang/System:currentTimeMillis	()J
    //   574: invokespecial 138	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   577: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	578	0	this	KapalaiAdapterUtil
    //   0	578	1	paramIntent	Intent
    //   0	578	2	paramBitmap	Bitmap
    //   0	578	3	paramString1	String
    //   0	578	4	paramString2	String
    //   0	578	5	paramString3	String
    //   0	578	6	paramBoolean	boolean
    //   0	578	7	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   17	474	8	localPendingIntent	android.app.PendingIntent
    //   363	8	9	localMethod	Method
    //   469	3	9	localException	Exception
    //   85	484	10	i	int
    //   53	220	11	j	int
    //   5	328	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   343	365	469	java/lang/Exception
    //   370	388	469	java/lang/Exception
    //   454	467	546	java/lang/Exception
    //   509	530	546	java/lang/Exception
    //   530	544	546	java/lang/Exception
  }
  
  public Intent a(Intent paramIntent)
  {
    paramIntent.putExtra(a(), Integer.parseInt(c()));
    return null;
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap != null) {
      return Bitmap.createScaledBitmap(paramBitmap, paramInt, paramInt, true);
    }
    return null;
  }
  
  public Camera a()
  {
    Camera localCamera = null;
    if (Build.MANUFACTURER.equalsIgnoreCase("HTC")) {
      localCamera = b();
    }
    do
    {
      return localCamera;
      if (Build.MANUFACTURER.equalsIgnoreCase("YuLong")) {
        return c();
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("HISENSE")) {
        return d();
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
        return e();
      }
    } while (!Build.MANUFACTURER.equalsIgnoreCase("LENOVO"));
    return f();
  }
  
  public String a()
  {
    return DualSimManager.a;
  }
  
  public String a(Camera.Parameters paramParameters)
  {
    String str = "off";
    List localList = paramParameters.getSupportedFlashModes();
    if (localList.contains("torch")) {
      paramParameters = "torch";
    }
    do
    {
      return paramParameters;
      if (localList.contains("on")) {
        return "on";
      }
      paramParameters = str;
    } while (!localList.contains("auto"));
    return "auto";
  }
  
  public ArrayList a(Context paramContext)
  {
    ArrayList localArrayList1 = b(paramContext);
    if ((localArrayList1 == null) || (localArrayList1.size() < 1)) {
      return null;
    }
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < localArrayList1.size())
    {
      String str = (String)localArrayList1.get(i);
      if (SDCardMountInforUtil.a(paramContext).a(str)) {
        localArrayList2.add(str);
      }
      i += 1;
    }
    return localArrayList2;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Intent paramIntent)
  {
    paramIntent.setFlags(337641472);
  }
  
  public void a(Window paramWindow)
  {
    paramWindow.setType(2004);
  }
  
  public void a(WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.screenBrightness = 0.035F;
  }
  
  public void a(EditText paramEditText)
  {
    if (paramEditText != null) {
      paramEditText.setSelection(this.jdField_a_of_type_Int);
    }
  }
  
  public boolean a()
  {
    return (!this.jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager.a(0)) && (this.jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager.a(1));
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    return DualSimManager.a().a(paramInt, paramString1, paramString2, paramArrayList1, paramArrayList2, paramArrayList3);
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    return SDCardMountInforUtil.a(paramContext).a(paramString);
  }
  
  public boolean a(Camera.Parameters paramParameters, Context paramContext)
  {
    return (paramParameters.getSupportedFlashModes() != null) && (paramContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash")) && (paramParameters.getSupportedFlashModes().size() > 1);
  }
  
  public int b()
  {
    return 1;
  }
  
  public String b()
  {
    return DualSimManager.b;
  }
  
  public ArrayList b(Context paramContext)
  {
    return SDCardMountInforUtil.a(paramContext).a();
  }
  
  public void b(Window paramWindow)
  {
    paramWindow.setType(2);
  }
  
  public String c()
  {
    return DualSimManager.c;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\kapalaiadapter\KapalaiAdapterUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */