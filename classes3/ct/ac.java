package ct;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

public final class ac
  extends DefaultConnectionKeepAliveStrategy
{
  public final long getKeepAliveDuration(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    long l2 = super.getKeepAliveDuration(paramHttpResponse, paramHttpContext);
    long l1 = l2;
    if (l2 == -1L) {
      l1 = 9000L;
    }
    return l1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */