package cooperation.qzone.report;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.myapp.net.Http;
import com.tencent.mobileqq.myapp.net.HttpResponseException;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.message.BasicHeader;

public class QZoneMonitorH5ReportServlet$ReportRunnable
  implements Runnable
{
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public QZoneMonitorH5ReportServlet$ReportRunnable(QZoneMonitorH5ReportServlet paramQZoneMonitorH5ReportServlet, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void run()
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneMonitorH5ReportServlet", 4, "QZoneMonitorH5, report:" + this.jdField_a_of_type_JavaLangString);
      }
      BasicHeader localBasicHeader = new BasicHeader("cookie", QZoneMonitorH5ReportServlet.a(this.b));
      Http.a(this.jdField_a_of_type_JavaLangString, null, "GET", new BasicHeader[] { localBasicHeader });
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneMonitorH5ReportServlet", 4, "report success");
      }
      return;
    }
    catch (HttpResponseException localHttpResponseException)
    {
      QLog.w("QZoneMonitorH5ReportServlet", 2, "QZoneMonitorH5Report failed, code=" + localHttpResponseException.getStateCode());
      return;
    }
    catch (Exception localException)
    {
      QLog.w("QZoneMonitorH5ReportServlet", 2, "", localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\report\QZoneMonitorH5ReportServlet$ReportRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */