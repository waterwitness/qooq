import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.net.URI;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class gre
  implements Runnable
{
  public gre(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConferenceFlyTicketActivity", 2, "getRedirectInfo.run url = " + this.jdField_a_of_type_JavaLangString);
    }
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    BasicHttpContext localBasicHttpContext = new BasicHttpContext();
    HttpGet localHttpGet = new HttpGet(this.jdField_a_of_type_JavaLangString);
    String str3 = null;
    String str1 = str3;
    try
    {
      localDefaultHttpClient.execute(localHttpGet, localBasicHttpContext);
      str1 = str3;
      str3 = ((HttpUriRequest)localBasicHttpContext.getAttribute("http.request")).getURI().toString();
      str1 = str3;
      if (QLog.isColorLevel())
      {
        str1 = str3;
        QLog.d("ConferenceFlyTicketActivity", 2, "getRedirectInfo.run redirectUrl = " + str3);
      }
      localDefaultHttpClient.getConnectionManager().shutdown();
      str1 = str3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ConferenceFlyTicketActivity", 2, "getRedirectInfo.run e = " + localException);
        }
        localDefaultHttpClient.getConnectionManager().shutdown();
      }
    }
    finally
    {
      localDefaultHttpClient.getConnectionManager().shutdown();
    }
    if ((str1 != null) && (str1.startsWith("/cgi-bin/dc/ft?k=")))
    {
      str1 = str1.substring("/cgi-bin/dc/ft?k=".length());
      if (QLog.isColorLevel()) {
        QLog.d("ConferenceFlyTicketActivity", 2, "getRedirectInfo.run sig = " + str1);
      }
      this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.a.a(str1, 0);
      return;
    }
    if ((localObject != null) && (((String)localObject).startsWith("http://qm.qq.com/cgi-bin/dc/ft?k=")))
    {
      String str2 = ((String)localObject).substring("http://qm.qq.com/cgi-bin/dc/ft?k=".length());
      if (QLog.isColorLevel()) {
        QLog.d("ConferenceFlyTicketActivity", 2, "getRedirectInfo.run sig = " + str2);
      }
      this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.a.a(str2, 0);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.a(0, 65375);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */