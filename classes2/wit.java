import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.QLog;

public class wit
  implements Runnable
{
  public wit(SwiftBrowserStatistics paramSwiftBrowserStatistics)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QLog.doReportLogSelf(AppSetting.a, "FeedbackReport", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */