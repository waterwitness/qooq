package com.tencent.component.network.utils.a.a;

import android.text.TextUtils;
import com.tencent.component.network.downloader.common.a;
import java.io.IOException;
import java.net.URI;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.client.DefaultRequestDirector;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.client.RoutedRequest;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;

public final class b
  extends DefaultRequestDirector
{
  private String a = null;
  private boolean b = false;
  
  public b(HttpRequestExecutor paramHttpRequestExecutor, ClientConnectionManager paramClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy, HttpRoutePlanner paramHttpRoutePlanner, HttpProcessor paramHttpProcessor, HttpRequestRetryHandler paramHttpRequestRetryHandler, RedirectHandler paramRedirectHandler, AuthenticationHandler paramAuthenticationHandler1, AuthenticationHandler paramAuthenticationHandler2, UserTokenHandler paramUserTokenHandler, HttpParams paramHttpParams)
  {
    super(paramHttpRequestExecutor, paramClientConnectionManager, paramConnectionReuseStrategy, paramConnectionKeepAliveStrategy, paramHttpRoutePlanner, paramHttpProcessor, paramHttpRequestRetryHandler, paramRedirectHandler, paramAuthenticationHandler1, paramAuthenticationHandler2, paramUserTokenHandler, paramHttpParams);
  }
  
  protected final RoutedRequest handleResponse(RoutedRequest paramRoutedRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
    throws HttpException, IOException
  {
    paramRoutedRequest = super.handleResponse(paramRoutedRequest, paramHttpResponse, paramHttpContext);
    if ((paramRoutedRequest != null) && (HttpClientParams.isRedirecting(this.params))) {
      try
      {
        this.b = true;
        paramHttpResponse = paramRoutedRequest.getRequest();
        if (paramHttpResponse != null)
        {
          if (paramHttpResponse.getURI() == null) {
            return paramRoutedRequest;
          }
          paramHttpContext = paramHttpResponse.getURI().getAuthority();
          this.a = paramHttpContext;
          Header[] arrayOfHeader = paramHttpResponse.getAllHeaders();
          if (arrayOfHeader != null)
          {
            int j = arrayOfHeader.length;
            int i = 0;
            while (i < j)
            {
              if ("Host".equals(arrayOfHeader[i].getName()))
              {
                paramHttpResponse.removeHeader(arrayOfHeader[i]);
                if (!TextUtils.isEmpty(paramHttpContext)) {
                  paramHttpResponse.addHeader("Host", paramHttpContext);
                }
                if (a.b()) {
                  a.b("http", "download redirect orig host:" + arrayOfHeader[i].getValue() + " new host:" + paramHttpContext);
                }
              }
              if ("x-online-host".equals(arrayOfHeader[i].getName()))
              {
                paramHttpResponse.removeHeader(arrayOfHeader[i]);
                if (!TextUtils.isEmpty(paramHttpContext)) {
                  paramHttpResponse.addHeader("x-online-host", paramHttpContext);
                }
                if (a.b()) {
                  a.b("http", "download redirect orig x-online-host:" + arrayOfHeader[i].getValue() + " new x-online-host:" + paramHttpContext);
                }
              }
              i += 1;
            }
          }
        }
        return paramRoutedRequest;
      }
      catch (Throwable paramHttpResponse)
      {
        a.b("http", "handleResponse error", paramHttpResponse);
      }
    }
  }
  
  protected final void rewriteRequestURI(RequestWrapper paramRequestWrapper, HttpRoute paramHttpRoute)
    throws ProtocolException
  {
    super.rewriteRequestURI(paramRequestWrapper, paramHttpRoute);
    if ((!this.b) || (paramRequestWrapper == null)) {}
    do
    {
      return;
      paramRequestWrapper.removeHeaders("Host");
      paramRequestWrapper.removeHeaders("x-online-host");
    } while (TextUtils.isEmpty(this.a));
    paramRequestWrapper.addHeader("Host", this.a);
    paramRequestWrapper.addHeader("x-online-host", this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */