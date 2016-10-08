import com.rookery.asyncHttpClient.AsyncHttpClient;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

public class gbv
  implements HttpRequestInterceptor
{
  public gbv(AsyncHttpClient paramAsyncHttpClient)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (!paramHttpRequest.containsHeader("Accept-Encoding")) {
      paramHttpRequest.addHeader("Accept-Encoding", "gzip");
    }
    paramHttpContext = AsyncHttpClient.a(this.a).keySet().iterator();
    while (paramHttpContext.hasNext())
    {
      String str = (String)paramHttpContext.next();
      paramHttpRequest.addHeader(str, (String)AsyncHttpClient.a(this.a).get(str));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\gbv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */