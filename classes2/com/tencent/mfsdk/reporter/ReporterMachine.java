package com.tencent.mfsdk.reporter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kgf;
import mqq.os.MqqHandler;

public class ReporterMachine
{
  public static final int a = 1;
  public static RecyclablePool a;
  public static ResultObject a;
  public static final IReporter a;
  private static ReporterMachine jdField_a_of_type_ComTencentMfsdkReporterReporterMachine;
  public static final String a = "fileObj";
  public static ResultObject b;
  public static final String b = "clientinfo";
  public static final String c = "http://zhizi.qq.com/chunkupload.php";
  public static final String d = "http://zhizi.qq.com/json.php";
  public static final String e = "com.tencent.magnifiersdk.reporter.addResultObj";
  private static final String f = "ReporterMachine";
  private static String g;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(ResultObject.class, 100);
    g = "";
    jdField_a_of_type_ComTencentMfsdkReporterIReporter = new YunYingReporter();
  }
  
  private ReporterMachine(int paramInt)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
      this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.b();
    }
    g = b();
  }
  
  public static ReporterMachine a(int paramInt)
  {
    if (jdField_a_of_type_ComTencentMfsdkReporterReporterMachine == null) {}
    try
    {
      jdField_a_of_type_ComTencentMfsdkReporterReporterMachine = new ReporterMachine(paramInt);
      return jdField_a_of_type_ComTencentMfsdkReporterReporterMachine;
    }
    finally {}
  }
  
  public static void a(Context paramContext, ResultObject paramResultObject)
  {
    if (true == paramResultObject.isRealTime)
    {
      ((HashMap)paramResultObject.params.get("clientinfo")).put("p_id", "1");
      ((HashMap)paramResultObject.params.get("clientinfo")).put("versionname", MagnifierSDK.a);
      ((HashMap)paramResultObject.params.get("clientinfo")).put("uin", String.valueOf(paramResultObject.uin));
      ((HashMap)paramResultObject.params.get("clientinfo")).put("model", Build.MODEL);
      ((HashMap)paramResultObject.params.get("clientinfo")).put("os", Build.VERSION.RELEASE);
      ((HashMap)paramResultObject.params.get("clientinfo")).put("rdmuuid", g);
      jdField_a_of_type_ComTencentMfsdkReporterIReporter.a(paramResultObject);
      return;
    }
    if (paramContext == null)
    {
      a(paramResultObject);
      return;
    }
    Intent localIntent = new Intent(paramContext, ROReceiver.class);
    localIntent.putExtra("resultObj", paramResultObject);
    paramContext.sendBroadcast(localIntent);
  }
  
  /* Error */
  public static void a(ResultObject paramResultObject)
  {
    // Byte code:
    //   0: getstatic 49	com/tencent/mfsdk/reporter/ReporterMachine:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   3: ldc 43
    //   5: invokevirtual 166	com/tencent/commonsdk/pool/RecyclablePool:obtain	(Ljava/lang/Class;)Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   8: checkcast 43	com/tencent/mfsdk/collector/ResultObject
    //   11: astore_1
    //   12: aload_1
    //   13: aload_0
    //   14: getfield 169	com/tencent/mfsdk/collector/ResultObject:reportType	I
    //   17: putfield 169	com/tencent/mfsdk/collector/ResultObject:reportType	I
    //   20: aload_1
    //   21: aload_0
    //   22: getfield 172	com/tencent/mfsdk/collector/ResultObject:eventName	Ljava/lang/String;
    //   25: putfield 172	com/tencent/mfsdk/collector/ResultObject:eventName	Ljava/lang/String;
    //   28: aload_1
    //   29: aload_0
    //   30: getfield 175	com/tencent/mfsdk/collector/ResultObject:isSucceed	Z
    //   33: putfield 175	com/tencent/mfsdk/collector/ResultObject:isSucceed	Z
    //   36: aload_1
    //   37: aload_0
    //   38: getfield 178	com/tencent/mfsdk/collector/ResultObject:elapse	J
    //   41: putfield 178	com/tencent/mfsdk/collector/ResultObject:elapse	J
    //   44: aload_1
    //   45: aload_0
    //   46: getfield 181	com/tencent/mfsdk/collector/ResultObject:size	J
    //   49: putfield 181	com/tencent/mfsdk/collector/ResultObject:size	J
    //   52: aload_1
    //   53: aload_0
    //   54: getfield 86	com/tencent/mfsdk/collector/ResultObject:params	Ljava/util/concurrent/ConcurrentHashMap;
    //   57: putfield 86	com/tencent/mfsdk/collector/ResultObject:params	Ljava/util/concurrent/ConcurrentHashMap;
    //   60: aload_1
    //   61: aload_0
    //   62: getfield 82	com/tencent/mfsdk/collector/ResultObject:isRealTime	Z
    //   65: putfield 82	com/tencent/mfsdk/collector/ResultObject:isRealTime	Z
    //   68: aload_1
    //   69: aload_0
    //   70: getfield 184	com/tencent/mfsdk/collector/ResultObject:isMerge	Z
    //   73: putfield 184	com/tencent/mfsdk/collector/ResultObject:isMerge	Z
    //   76: aload_1
    //   77: aload_0
    //   78: getfield 113	com/tencent/mfsdk/collector/ResultObject:uin	J
    //   81: putfield 113	com/tencent/mfsdk/collector/ResultObject:uin	J
    //   84: ldc 2
    //   86: monitorenter
    //   87: getstatic 186	com/tencent/mfsdk/reporter/ReporterMachine:jdField_a_of_type_ComTencentMfsdkCollectorResultObject	Lcom/tencent/mfsdk/collector/ResultObject;
    //   90: ifnonnull +15 -> 105
    //   93: aload_1
    //   94: putstatic 186	com/tencent/mfsdk/reporter/ReporterMachine:jdField_a_of_type_ComTencentMfsdkCollectorResultObject	Lcom/tencent/mfsdk/collector/ResultObject;
    //   97: aload_1
    //   98: putstatic 188	com/tencent/mfsdk/reporter/ReporterMachine:b	Lcom/tencent/mfsdk/collector/ResultObject;
    //   101: ldc 2
    //   103: monitorexit
    //   104: return
    //   105: getstatic 188	com/tencent/mfsdk/reporter/ReporterMachine:b	Lcom/tencent/mfsdk/collector/ResultObject;
    //   108: aload_1
    //   109: iconst_1
    //   110: invokevirtual 192	com/tencent/mfsdk/collector/ResultObject:changeNext	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;Z)V
    //   113: aload_1
    //   114: putstatic 188	com/tencent/mfsdk/reporter/ReporterMachine:b	Lcom/tencent/mfsdk/collector/ResultObject;
    //   117: goto -16 -> 101
    //   120: astore_0
    //   121: ldc 2
    //   123: monitorexit
    //   124: aload_0
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramResultObject	ResultObject
    //   11	103	1	localResultObject	ResultObject
    // Exception table:
    //   from	to	target	type
    //   87	101	120	finally
    //   101	104	120	finally
    //   105	117	120	finally
    //   121	124	120	finally
  }
  
  private String b()
  {
    try
    {
      String str = BaseApplicationImpl.a.getPackageManager().getApplicationInfo(BaseApplicationImpl.a.getPackageName(), 128).metaData.get("com.tencent.rdm.uuid").toString();
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return "";
  }
  
  public void a()
  {
    kgf localkgf = new kgf(this, null);
    this.jdField_a_of_type_MqqOsMqqHandler.post(localkgf);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mfsdk\reporter\ReporterMachine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */