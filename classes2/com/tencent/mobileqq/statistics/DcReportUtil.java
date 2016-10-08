package com.tencent.mobileqq.statistics;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.NewIntent;
import uug;

public class DcReportUtil
{
  public static final String a = "DcReportUtil";
  private static AtomicLong a = new AtomicLong(0L);
  public static final String b = "${report_seq_prefix}";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramString2 != null)
    {
      ReportController localReportController = paramQQAppInterface.a();
      if (localReportController != null)
      {
        String str = paramString2;
        if (paramString2.contains("${uin_unknown}")) {
          str = paramString2.replace("${uin_unknown}", paramQQAppInterface.a());
        }
        localReportController.a(paramString1, str, paramInt);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    String str = "${count_unknown}|" + paramString2;
    paramString2 = str;
    if (!paramBoolean)
    {
      long l = a.incrementAndGet();
      paramString2 = "${report_seq_prefix}" + l + "|" + str;
    }
    if (paramQQAppInterface == null)
    {
      ThreadManager.a(new uug(paramString1, paramString2), 5, null, true);
      return;
    }
    a(paramQQAppInterface, paramString1, paramString2, 1);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    Object localObject = paramString2;
    if (paramString2.contains("${uin_unknown}")) {
      localObject = paramString2.replace("${uin_unknown}", paramQQAppInterface.a());
    }
    localObject = ((String)localObject).replace("${count_unknown}", Integer.toString(paramInt));
    paramString2 = (String)localObject;
    if (((String)localObject).startsWith("${report_seq_prefix}")) {
      paramString2 = ((String)localObject).substring(((String)localObject).indexOf("|") + 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("DcReportUtil", 2, "ReportRuntime: " + paramString1 + ", " + paramString2);
    }
    localObject = new NewIntent(paramQQAppInterface.getApplication(), ReportServlet.class);
    ((NewIntent)localObject).putExtra("sendType", 2);
    ((NewIntent)localObject).putExtra("tag", paramString1);
    ((NewIntent)localObject).putExtra("content", paramString2);
    ((NewIntent)localObject).setWithouLogin(true);
    paramQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    String str = "${count_unknown}|" + paramString2;
    paramString2 = str;
    if (!paramBoolean)
    {
      long l = a.incrementAndGet();
      paramString2 = "${report_seq_prefix}" + l + "|" + str;
    }
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setClassName(BaseApplicationImpl.a, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramQQAppInterface.putExtra("reporting_tag", paramString1);
      paramQQAppInterface.putExtra("reporting_detail", paramString2);
      paramQQAppInterface.putExtra("reporting_count", 1);
      paramQQAppInterface.putExtra("is_runtime", 1);
      BaseApplicationImpl.a().sendBroadcast(paramQQAppInterface);
      return;
    }
    b(paramQQAppInterface, paramString1, paramString2, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\statistics\DcReportUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */