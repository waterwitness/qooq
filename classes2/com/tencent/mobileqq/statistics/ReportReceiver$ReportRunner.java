package com.tencent.mobileqq.statistics;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ReportReceiver$ReportRunner
  implements Runnable
{
  private Intent a;
  
  public ReportReceiver$ReportRunner(Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramIntent;
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
    if (localQQAppInterface == null) {}
    do
    {
      return;
      try
      {
        Intent localIntent = this.a;
        str1 = localIntent.getStringExtra("reporting_tag");
        str2 = localIntent.getStringExtra("reporting_detail");
        i = localIntent.getIntExtra("reporting_count", 1);
        j = localIntent.getIntExtra("is_runtime", -1);
        if (j != 0) {}
      }
      catch (Exception localException)
      {
        String str1;
        String str2;
        int i;
        int j;
        return;
      }
      try
      {
        ReportController.b(localQQAppInterface, str1, str2, i);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError) {}
    } while (j != 1);
    ReportController.a(localQQAppInterface, str1, str2, i);
    return;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\statistics\ReportReceiver$ReportRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */