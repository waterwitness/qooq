import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqreader.ReaderPluginReport;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public class yje
  implements Runnable
{
  public yje(ReaderPluginReport paramReaderPluginReport)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Object localObject = ReaderPluginReport.a() + 103;
      String str1 = ReaderPluginReport.b() + System.currentTimeMillis();
      String str2 = ReaderPluginReport.c() + ReaderPluginReport.a(this.a);
      String str3 = ReaderPluginReport.d() + "6.5.5.2880";
      localObject = new HttpGet(ReaderPluginReport.e() + (String)localObject + str1 + str2 + str3);
      int i = new DefaultHttpClient().execute((HttpUriRequest)localObject).getStatusLine().getStatusCode();
      if (i == 200) {}
      return;
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      QLog.e(ReaderPluginReport.f(), 0, "reportDownLoadStart ClientProtocolException:", localClientProtocolException);
      return;
    }
    catch (IOException localIOException)
    {
      QLog.e(ReaderPluginReport.f(), 0, "reportDownLoadStart error:", localIOException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yje.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */