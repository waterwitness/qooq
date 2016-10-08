import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.report.ReportCenter;

public class wsb
  extends Handler
{
  public wsb(ReportCenter paramReportCenter, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      ReportCenter localReportCenter = this.a;
      if (paramMessage.obj == null) {}
      for (String str = null;; str = (String)paramMessage.obj)
      {
        localReportCenter.a(str);
        break;
      }
      this.a.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wsb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */