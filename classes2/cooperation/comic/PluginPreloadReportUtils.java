package cooperation.comic;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.security.SecureRandom;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class PluginPreloadReportUtils
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "PluginPreloadReportUtils";
  private static final ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 5;
  public static final int e = 6;
  public static final int f = 9999;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 2;
  private static final int n;
  private static final int o = 1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    n = new SecureRandom().nextInt(1000) + 1;
    a = new ConcurrentHashMap();
  }
  
  public static PluginPreloadReportUtils.HitRateHelper a(int paramInt)
  {
    return (PluginPreloadReportUtils.HitRateHelper)a.get(Integer.valueOf(paramInt));
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, String... paramVarArgs)
  {
    int i1 = 0;
    if ((paramInt1 != 0) && (n > 1)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1 + "|");
    localStringBuilder.append(paramInt2 + "|");
    localStringBuilder.append(paramInt3 + "|");
    localStringBuilder.append(paramInt4 + "|");
    localStringBuilder.append(paramString + "|");
    localStringBuilder.append(paramInt5);
    paramString = new String[6];
    System.arraycopy(paramVarArgs, 0, paramString, 0, Math.min(6, paramVarArgs.length));
    paramInt1 = i1;
    if (paramInt1 < paramString.length)
    {
      if (paramString[paramInt1] == null) {
        localStringBuilder.append("|");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        localStringBuilder.append("|" + paramString[paramInt1]);
      }
    }
    if ((paramAppRuntime instanceof QQAppInterface)) {}
    for (paramAppRuntime = (QQAppInterface)paramAppRuntime;; paramAppRuntime = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloadReportUtils", 2, "preload: " + localStringBuilder.toString());
      }
      DcReportUtil.a(paramAppRuntime, "sendtdbank|b_sng_qqvip_qqcomic|preload", localStringBuilder.toString(), true);
      return;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, String... paramVarArgs)
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1 + "|");
    localStringBuilder.append(paramInt2 + "|");
    localStringBuilder.append(paramInt3 + "|");
    localStringBuilder.append(paramInt4 + "|");
    localStringBuilder.append(paramString);
    paramString = new String[6];
    System.arraycopy(paramVarArgs, 0, paramString, 0, Math.min(6, paramVarArgs.length));
    paramInt1 = i1;
    if (paramInt1 < paramString.length)
    {
      if (paramString[paramInt1] == null) {
        localStringBuilder.append("|");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        localStringBuilder.append("|" + paramString[paramInt1]);
      }
    }
    if ((paramAppRuntime instanceof QQAppInterface)) {}
    for (paramAppRuntime = (QQAppInterface)paramAppRuntime;; paramAppRuntime = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloadReportUtils", 2, "hitrate: " + localStringBuilder.toString());
      }
      DcReportUtil.a(paramAppRuntime, "sendtdbank|b_sng_qqvip_qqcomic|preloadhitrate", localStringBuilder.toString(), true);
      return;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, long paramLong, String... paramVarArgs)
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1 + "|");
    localStringBuilder.append(paramInt2 + "|");
    localStringBuilder.append(paramInt3 + "|");
    localStringBuilder.append(paramLong);
    String[] arrayOfString = new String[6];
    System.arraycopy(paramVarArgs, 0, arrayOfString, 0, Math.min(6, paramVarArgs.length));
    paramInt1 = i1;
    if (paramInt1 < arrayOfString.length)
    {
      if (arrayOfString[paramInt1] == null) {
        localStringBuilder.append("|");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        localStringBuilder.append("|" + arrayOfString[paramInt1]);
      }
    }
    if ((paramAppRuntime instanceof QQAppInterface)) {}
    for (paramAppRuntime = (QQAppInterface)paramAppRuntime;; paramAppRuntime = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloadReportUtils", 2, "procbekilled: " + localStringBuilder.toString());
      }
      DcReportUtil.a(paramAppRuntime, "sendtdbank|b_sng_qqvip_qqcomic|procbekilled", localStringBuilder.toString(), true);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\comic\PluginPreloadReportUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */