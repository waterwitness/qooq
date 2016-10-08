package cooperation.qzone.video;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.myapp.net.Http;
import com.tencent.mobileqq.myapp.net.HttpResponseException;
import com.tencent.qphone.base.util.QLog;

public class TcSdkDownloadReportServlet$ReportRunnable
  implements Runnable
{
  private String jdField_a_of_type_JavaLangString;
  
  public TcSdkDownloadReportServlet$ReportRunnable(TcSdkDownloadReportServlet paramTcSdkDownloadReportServlet, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(TcSdkDownloadReportServlet.TAG, 4, "tcSdkReport, report:" + this.jdField_a_of_type_JavaLangString);
      }
      Http.a(this.jdField_a_of_type_JavaLangString, null, "GET", null);
      if (QLog.isDevelopLevel()) {
        QLog.d(TcSdkDownloadReportServlet.TAG, 4, "report success");
      }
      return;
    }
    catch (HttpResponseException localHttpResponseException)
    {
      QLog.w(TcSdkDownloadReportServlet.TAG, 2, "TcSdkDownloadReport failed, code=" + localHttpResponseException.getStateCode());
      return;
    }
    catch (Exception localException)
    {
      QLog.w(TcSdkDownloadReportServlet.TAG, 2, "", localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\video\TcSdkDownloadReportServlet$ReportRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */