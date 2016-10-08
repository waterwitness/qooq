package com.tencent.component.network.downloader.strategy;

import org.apache.http.HeaderIterator;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.protocol.HttpContext;

public class DownloadConnectionReuseStrategy
  extends DefaultConnectionReuseStrategy
{
  public boolean keepAlive(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    Object localObject;
    if (paramHttpContext != null)
    {
      localObject = (HttpRequest)paramHttpContext.getAttribute("http.request");
      if (localObject != null)
      {
        localObject = ((HttpRequest)localObject).headerIterator("Connection");
        if (!((HeaderIterator)localObject).hasNext()) {}
      }
    }
    label64:
    do
    {
      try
      {
        localObject = createTokenIterator((HeaderIterator)localObject);
        bool = ((TokenIterator)localObject).hasNext();
        if (bool) {
          break label64;
        }
      }
      catch (ParseException localParseException)
      {
        boolean bool;
        for (;;) {}
      }
      return super.keepAlive(paramHttpResponse, paramHttpContext);
      bool = "Close".equalsIgnoreCase(((TokenIterator)localObject).nextToken());
    } while (!bool);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\strategy\DownloadConnectionReuseStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */