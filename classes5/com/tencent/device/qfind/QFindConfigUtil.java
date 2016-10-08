package com.tencent.device.qfind;

import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.OS;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class QFindConfigUtil
{
  private static final String a = "priority";
  private static final String b = "assist_active";
  private static final String c = "assist_params";
  private static final String d = "scan_interval";
  private static final String e = "scan_duration";
  private static final String f = "owner_params";
  
  public QFindConfigUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public static QFindConfig a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +243 -> 247
    //   7: new 45	com/tencent/device/qfind/QFindConfig
    //   10: dup
    //   11: invokespecial 46	com/tencent/device/qfind/QFindConfig:<init>	()V
    //   14: astore_1
    //   15: new 48	org/json/JSONObject
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 51	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   23: astore_0
    //   24: aload_0
    //   25: ldc 8
    //   27: invokevirtual 55	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   30: ifeq +170 -> 200
    //   33: aload_0
    //   34: ldc 8
    //   36: invokevirtual 59	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   39: istore_3
    //   40: aload_1
    //   41: iload_3
    //   42: putfield 62	com/tencent/device/qfind/QFindConfig:a	I
    //   45: aload_0
    //   46: ldc 11
    //   48: invokevirtual 55	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   51: ifeq +154 -> 205
    //   54: aload_0
    //   55: ldc 11
    //   57: invokevirtual 59	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   60: istore_3
    //   61: aload_1
    //   62: iload_3
    //   63: putfield 64	com/tencent/device/qfind/QFindConfig:b	I
    //   66: aload_0
    //   67: ldc 14
    //   69: invokevirtual 55	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   72: ifeq +60 -> 132
    //   75: aload_0
    //   76: ldc 14
    //   78: invokevirtual 68	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   81: astore_2
    //   82: aload_2
    //   83: ldc 20
    //   85: invokevirtual 55	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   88: ifeq +122 -> 210
    //   91: aload_2
    //   92: ldc 20
    //   94: invokevirtual 59	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   97: sipush 1000
    //   100: imul
    //   101: istore_3
    //   102: aload_1
    //   103: iload_3
    //   104: putfield 70	com/tencent/device/qfind/QFindConfig:d	I
    //   107: aload_2
    //   108: ldc 17
    //   110: invokevirtual 55	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   113: ifeq +102 -> 215
    //   116: aload_2
    //   117: ldc 17
    //   119: invokevirtual 59	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   122: sipush 1000
    //   125: imul
    //   126: istore_3
    //   127: aload_1
    //   128: iload_3
    //   129: putfield 72	com/tencent/device/qfind/QFindConfig:c	I
    //   132: aload_0
    //   133: ldc 23
    //   135: invokevirtual 55	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   138: ifeq +60 -> 198
    //   141: aload_0
    //   142: ldc 23
    //   144: invokevirtual 68	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   147: astore_0
    //   148: aload_0
    //   149: ldc 20
    //   151: invokevirtual 55	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   154: ifeq +66 -> 220
    //   157: aload_0
    //   158: ldc 20
    //   160: invokevirtual 59	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   163: sipush 1000
    //   166: imul
    //   167: istore_3
    //   168: aload_1
    //   169: iload_3
    //   170: putfield 74	com/tencent/device/qfind/QFindConfig:f	I
    //   173: aload_0
    //   174: ldc 17
    //   176: invokevirtual 55	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   179: ifeq +46 -> 225
    //   182: aload_0
    //   183: ldc 17
    //   185: invokevirtual 59	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   188: sipush 1000
    //   191: imul
    //   192: istore_3
    //   193: aload_1
    //   194: iload_3
    //   195: putfield 76	com/tencent/device/qfind/QFindConfig:e	I
    //   198: aload_1
    //   199: areturn
    //   200: iconst_0
    //   201: istore_3
    //   202: goto -162 -> 40
    //   205: iconst_0
    //   206: istore_3
    //   207: goto -146 -> 61
    //   210: iconst_0
    //   211: istore_3
    //   212: goto -110 -> 102
    //   215: iconst_0
    //   216: istore_3
    //   217: goto -90 -> 127
    //   220: iconst_0
    //   221: istore_3
    //   222: goto -54 -> 168
    //   225: iconst_0
    //   226: istore_3
    //   227: goto -34 -> 193
    //   230: astore_1
    //   231: aconst_null
    //   232: astore_0
    //   233: aload_1
    //   234: invokevirtual 79	java/lang/Throwable:printStackTrace	()V
    //   237: aload_0
    //   238: areturn
    //   239: astore_2
    //   240: aload_1
    //   241: astore_0
    //   242: aload_2
    //   243: astore_1
    //   244: goto -11 -> 233
    //   247: aconst_null
    //   248: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramString	String
    //   14	185	1	localQFindConfig	QFindConfig
    //   230	11	1	localThrowable1	Throwable
    //   243	1	1	localObject	Object
    //   81	36	2	localJSONObject	org.json.JSONObject
    //   239	4	2	localThrowable2	Throwable
    //   39	188	3	i	int
    // Exception table:
    //   from	to	target	type
    //   7	15	230	java/lang/Throwable
    //   15	40	239	java/lang/Throwable
    //   40	61	239	java/lang/Throwable
    //   61	102	239	java/lang/Throwable
    //   102	127	239	java/lang/Throwable
    //   127	132	239	java/lang/Throwable
    //   132	168	239	java/lang/Throwable
    //   168	193	239	java/lang/Throwable
    //   193	198	239	java/lang/Throwable
  }
  
  public static void a(AppInterface paramAppInterface, ConfigurationService.ReqGetConfig paramReqGetConfig)
  {
    paramAppInterface = new ConfigurationService.OS();
    paramAppInterface.setHasFlag(true);
    paramAppInterface.type.set(2);
    paramAppInterface.kernel.set(DeviceInfoUtil.m());
    paramAppInterface.sdk.set(String.valueOf(DeviceInfoUtil.a()));
    paramAppInterface.version.set(DeviceInfoUtil.e());
    paramAppInterface.rom.set(DeviceInfoUtil.j());
    ConfigurationService.DeviceInfo localDeviceInfo = new ConfigurationService.DeviceInfo();
    localDeviceInfo.setHasFlag(true);
    localDeviceInfo.brand.set(DeviceInfoUtil.h());
    localDeviceInfo.model.set(DeviceInfoUtil.d());
    localDeviceInfo.os = paramAppInterface;
    paramReqGetConfig.device_info = localDeviceInfo;
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      bool = BaseApplication.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\qfind\QFindConfigUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */