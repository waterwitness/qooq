package com.tencent.tmdownloader.internal.a;

import android.text.TextUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectTimeoutException;

public class g
{
  protected boolean a = false;
  HttpClient b = null;
  HttpGet c = null;
  protected d d = null;
  protected final byte[] e = new byte['က'];
  com.tencent.tmdownloader.internal.d.b f;
  protected final int g = com.tencent.tmassistantbase.a.f.i();
  
  public g(d paramd)
  {
    this.d = paramd;
  }
  
  private void a(Throwable paramThrowable)
  {
    if (paramThrowable != null) {
      paramThrowable.printStackTrace();
    }
  }
  
  private void a(HttpResponse paramHttpResponse)
  {
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    com.tencent.tmassistantbase.a.m.c("_DownloadTask", "httpResponseCode = " + i + " " + Thread.currentThread().getName());
    Object localObject;
    switch (i)
    {
    default: 
      throw new m(i, "HTTP response code error, code = " + i);
    case 200: 
      localObject = paramHttpResponse.getHeaders("Content-Type");
      if ((localObject != null) && (localObject.length > 0))
      {
        if (!this.d.a.equals("resource/tm.android.unknown")) {
          break label218;
        }
        localObject = c.f(this.d.l);
        this.d.l = ((String)localObject);
      }
      for (;;)
      {
        b(paramHttpResponse);
        return;
        localObject = localObject[0].getValue();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("text"))) {
          throw new m(708, "Return contenttype = text " + Thread.currentThread().getName());
        }
        c(paramHttpResponse);
      }
    case 206: 
      if (this.d.a.equals("resource/tm.android.unknown"))
      {
        localObject = c.f(this.d.l);
        this.d.l = ((String)localObject);
      }
      for (;;)
      {
        b(paramHttpResponse);
        return;
        c(paramHttpResponse);
      }
    case 301: 
    case 302: 
    case 303: 
    case 307: 
      if (this.d.e > 5) {
        throw new m(709, "Redirect cnt many times.");
      }
      paramHttpResponse = paramHttpResponse.getFirstHeader("location");
      if (paramHttpResponse != null)
      {
        paramHttpResponse = paramHttpResponse.getValue();
        if (c.g(paramHttpResponse))
        {
          this.d.c = c.a(paramHttpResponse);
          paramHttpResponse = this.d;
          paramHttpResponse.e += 1;
          return;
        }
        throw new m(700, "Jump url is not valid. httpResponseCode = " + i + " url: " + paramHttpResponse);
      }
      throw new m(702, "location header is null. httpResponseCode = " + i);
    case 416: 
      throw new m(i, "HTTP response code error, code = " + i);
    case 503: 
      label218:
      throw new m(i, "HTTP response code error, code = " + i);
    }
    throw new m(i, "HTTP response code error, code = " + i);
  }
  
  private void a(HttpGet paramHttpGet)
  {
    String str = c.b();
    this.d.p = str;
    if ((!TextUtils.isEmpty(str)) && ((str.contains("wap")) || ((str.contains("net")) && (this.d.d > 0)))) {
      try
      {
        int i = f.a(str);
        long l3 = this.d.j;
        if (this.d.k > 0L)
        {
          l1 = this.d.j;
          long l2 = i + l1 - 1L;
          l1 = l2;
          if (l2 < this.d.k) {}
        }
        for (long l1 = this.d.k - 1L;; l1 = i - 1)
        {
          str = "bytes=" + l3 + "-" + l1;
          paramHttpGet.addHeader("range", str);
          com.tencent.tmassistantbase.a.m.b("_DownloadTask", "set range header: " + str);
          return;
        }
        str = "bytes=" + this.d.j + "-";
      }
      catch (UnsupportedOperationException paramHttpGet)
      {
        paramHttpGet.printStackTrace();
        return;
      }
    }
    paramHttpGet.addHeader("range", str);
    com.tencent.tmassistantbase.a.m.b("_DownloadTask", "set range header: " + str);
  }
  
  private void a(HttpGet paramHttpGet, Map<String, String> paramMap)
  {
    if ((paramHttpGet != null) && (paramMap != null) && (paramMap.size() > 0))
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        paramHttpGet.addHeader((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  private void b(HttpResponse paramHttpResponse)
  {
    Object localObject1 = paramHttpResponse.getEntity();
    if (this.d.k == 0L) {
      if (paramHttpResponse.getStatusLine().getStatusCode() == 200)
      {
        this.d.a(((HttpEntity)localObject1).getContentLength());
        com.tencent.tmassistantbase.a.m.c("_DownloadTask", "HTTPCode 200, totalBytes:" + this.d.k);
        com.tencent.tmassistantbase.a.m.d("_DownloadTask", "first start downloadinfoTotalSize = " + this.d.k);
        label111:
        if (this.f == null) {
          this.f = new com.tencent.tmdownloader.internal.d.b(this.d.m, this.d.l);
        }
      }
    }
    int i;
    long l1;
    for (;;)
    {
      int k;
      try
      {
        paramHttpResponse = ((HttpEntity)localObject1).getContent();
        localObject1 = ((HttpEntity)localObject1).getContentEncoding();
        if ((localObject1 != null) && (((Header)localObject1).getValue().toLowerCase().contains("gzip"))) {
          this.f.g = true;
        }
        if ((!this.f.g) || (this.d.k > 0L)) {
          break label1052;
        }
        paramHttpResponse = new GZIPInputStream(paramHttpResponse);
        i = 0;
        l1 = 0L;
        Object localObject2;
        com.tencent.tmdownloader.internal.d.b localb;
        try
        {
          int j = paramHttpResponse.read(this.e);
          if (j == -1) {
            continue;
          }
          i = 1;
          k = i;
          i = j;
        }
        catch (EOFException localEOFException)
        {
          k = 0;
          continue;
          localb = this.f;
          localObject2 = this.e;
          l2 = this.d.j;
          if (k != 0) {
            break label835;
          }
        }
        if (this.a)
        {
          paramHttpResponse.close();
          return;
          if (paramHttpResponse.getStatusLine().getStatusCode() == 206)
          {
            paramHttpResponse = paramHttpResponse.getFirstHeader("content-range");
            this.d.a(b.b(paramHttpResponse.getValue()));
            com.tencent.tmassistantbase.a.m.c("_DownloadTask", "HTTPCode 206, totalBytes:" + this.d.k);
            break;
          }
          com.tencent.tmassistantbase.a.m.d("_DownloadTask", "statusCode=" + paramHttpResponse.getStatusLine().getStatusCode() + " onReceivedResponseData error.");
          break;
          if (paramHttpResponse.getStatusLine().getStatusCode() != 206) {
            break label111;
          }
          try
          {
            paramHttpResponse = paramHttpResponse.getFirstHeader("content-range");
            localObject2 = b.a(paramHttpResponse.getValue());
            l1 = b.b(paramHttpResponse.getValue());
            com.tencent.tmassistantbase.a.m.d("_DownloadTask", "totalSize = " + l1 + "  downloadinfoTotalSize = " + this.d.k);
            if (((b)localObject2).b() != this.d.j) {
              throw new m(706, "The received size is not equal with ByteRange.");
            }
          }
          catch (Throwable paramHttpResponse)
          {
            throw new m(704, paramHttpResponse);
          }
          finally {}
          if (l1 != this.d.k) {
            throw new m(705, "The total size is not equal with ByteRange.");
          }
          com.tencent.tmassistantbase.a.m.b("_DownloadTask", "response ByteRange: " + paramHttpResponse);
          if (this.f == null) {
            break label111;
          }
          this.f.e();
          this.f = null;
          break label111;
          i = 0;
          continue;
        }
        bool = true;
        if (localb.a((byte[])localObject2, 0, i, l2, bool)) {
          break label1017;
        }
        if (!c.a(com.tencent.tmdownloader.internal.d.b.f(), this.d.k)) {
          break label929;
        }
        if (!com.tencent.tmdownloader.internal.d.b.h()) {
          break label841;
        }
        paramHttpResponse = "write file failed, fileName: " + this.d.l + " receivedSize: " + this.d.j + " readedSize: " + i + " totalSize: " + this.d.k;
        com.tencent.tmassistantbase.a.m.d("_DownloadTask", paramHttpResponse);
        throw new m(703, paramHttpResponse);
      }
      catch (SocketException paramHttpResponse)
      {
        paramHttpResponse.printStackTrace();
        throw new m(605, paramHttpResponse);
      }
      finally
      {
        if (this.f != null)
        {
          this.f.e();
          this.f = null;
        }
      }
      label835:
      bool = false;
      continue;
      label841:
      paramHttpResponse = "write file failed, no sdCard! fileName: " + this.d.l + " receivedSize: " + this.d.j + " readedSize: " + i + " totalSize: " + this.d.k;
      com.tencent.tmassistantbase.a.m.d("_DownloadTask", paramHttpResponse);
      throw new m(711, paramHttpResponse);
      label929:
      paramHttpResponse = "write file failed, no enough space! fileName: " + this.d.l + " receivedSize: " + this.d.j + " readedSize: " + i + " totalSize: " + this.d.k;
      com.tencent.tmassistantbase.a.m.d("_DownloadTask", paramHttpResponse);
      throw new m(710, paramHttpResponse);
      label1017:
      this.d.b(i);
      l1 = i + l1;
      this.d.a(l1);
      if (k != 0)
      {
        continue;
        label1052:
        com.tencent.tmassistantbase.a.m.c("_DownloadTask", "start write file, fileName: " + this.d.l);
        l1 = 0L;
        i = paramHttpResponse.read(this.e);
        if (i > 0)
        {
          if (!this.a) {
            break label1115;
          }
          paramHttpResponse.close();
        }
      }
    }
    label1115:
    long l2 = this.d.j + i;
    if (l2 <= this.d.k) {
      if (l2 != this.d.k) {
        break label1590;
      }
    }
    label1590:
    for (boolean bool = true;; bool = false)
    {
      if (!this.f.a(this.e, 0, i, this.d.j, bool))
      {
        if (c.a(com.tencent.tmdownloader.internal.d.b.f(), this.d.k))
        {
          if (com.tencent.tmdownloader.internal.d.b.h())
          {
            paramHttpResponse = "write file failed, fileName: " + this.d.l + " receivedSize: " + this.d.j + " readedSize: " + i + " totalSize: " + this.d.k;
            com.tencent.tmassistantbase.a.m.d("_DownloadTask", paramHttpResponse);
            throw new m(703, paramHttpResponse);
          }
          paramHttpResponse = "write file failed, no sdCard! fileName: " + this.d.l + " receivedSize: " + this.d.j + " readedSize: " + i + " totalSize: " + this.d.k;
          com.tencent.tmassistantbase.a.m.d("_DownloadTask", paramHttpResponse);
          throw new m(711, paramHttpResponse);
        }
        paramHttpResponse = "write file failed, no enough space! fileName: " + this.d.l + " receivedSize: " + this.d.j + " readedSize: " + i + " totalSize: " + this.d.k;
        com.tencent.tmassistantbase.a.m.d("_DownloadTask", paramHttpResponse);
        throw new m(710, paramHttpResponse);
      }
      this.d.b(i);
      l1 = i + l1;
      break;
      com.tencent.tmassistantbase.a.m.d("_DownloadTask", "write file size too long.\r\nreadedLen: " + i + "\r\n" + "receivedSize: " + this.d.j + "\r\n" + "totalSize: " + this.d.k + "\r\n" + "isTheEndData: " + false);
      throw new m(703, "write file size too long.");
    }
  }
  
  private void c(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null) {}
    for (;;)
    {
      return;
      if (this.d.a.equals("application/vnd.android.package-archive"))
      {
        Object localObject = null;
        paramHttpResponse = paramHttpResponse.getHeaders("Content-Disposition");
        if ((paramHttpResponse != null) && (paramHttpResponse.length > 0))
        {
          paramHttpResponse = paramHttpResponse[0].getValue();
          if ((!TextUtils.isEmpty(paramHttpResponse)) && (paramHttpResponse.contains("filename=\"")))
          {
            String str = paramHttpResponse.substring(paramHttpResponse.indexOf("filename=\"") + "filename=\"".length());
            paramHttpResponse = (HttpResponse)localObject;
            if (!TextUtils.isEmpty(str))
            {
              paramHttpResponse = str.substring(0, str.indexOf("\""));
              com.tencent.tmassistantbase.a.m.c("_DownloadTask", "header file Name =" + paramHttpResponse);
            }
          }
        }
        while (!TextUtils.isEmpty(paramHttpResponse))
        {
          paramHttpResponse = c.e(c.d(paramHttpResponse));
          this.d.l = paramHttpResponse;
          return;
          paramHttpResponse = c.b(this.d.c);
          continue;
          paramHttpResponse = c.b(this.d.c);
        }
      }
    }
  }
  
  public int a()
  {
    return this.g;
  }
  
  public void a(String paramString)
  {
    this.d.g = true;
    this.d.a(2);
    paramString = null;
    int i = 1;
    if ((i == 0) || (this.a)) {
      if (!this.a)
      {
        if (!this.d.a()) {
          break label1384;
        }
        this.d.a(4);
      }
    }
    for (;;)
    {
      com.tencent.tmassistantbase.a.m.c("_DownloadTask", "download finished, finalstatus: " + this.d.i + " errCode: " + this.d.o);
      this.d.g = false;
      return;
      try
      {
        this.b = k.a();
        k.a(this.b);
        this.c = new HttpGet();
        this.c.setURI(new URI(this.d.c));
        a(this.c, this.d.r);
        if (this.d.r != null)
        {
          Object localObject1 = (String)this.d.r.get("Accept-Encoding");
          if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase("gzip"))) {
            a(this.c);
          }
          com.tencent.tmassistantbase.a.m.c("_DownloadTask", "start httpGet " + Thread.currentThread().getName());
          localObject1 = this.b.execute(this.c);
          if (localObject1 != null) {
            break label574;
          }
          throw new m(701, "response is null! " + Thread.currentThread().getName());
        }
      }
      catch (ConnectTimeoutException localConnectTimeoutException)
      {
        for (;;)
        {
          localConnectTimeoutException.printStackTrace();
          if (!this.d.b()) {
            break label696;
          }
          Object localObject2 = this.d;
          ((d)localObject2).d += 1;
          try
          {
            Thread.sleep(5000L);
            j = 1;
            localObject2 = paramString;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              d locald;
              String str;
              boolean bool;
              this.d.o = 600;
              j = 0;
            }
          }
          if (this.c != null)
          {
            if (!this.c.isAborted()) {
              this.c.abort();
            }
            this.c = null;
          }
          if (this.b != null)
          {
            this.b.getConnectionManager().shutdown();
            this.b = null;
          }
          paramString = (String)localObject2;
          i = j;
          if (this.f != null)
          {
            this.f.e();
            i = j;
            paramString = (String)localObject2;
            this.f = null;
          }
          break;
          a(this.c);
        }
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        localSocketTimeoutException.printStackTrace();
        if (this.d.b())
        {
          locald = this.d;
          locald.d += 1;
        }
        for (;;)
        {
          try
          {
            Thread.sleep(5000L);
            j = 1;
            str = paramString;
          }
          catch (InterruptedException paramString)
          {
            this.d.o = 600;
            j = 0;
            continue;
          }
          if (this.c != null)
          {
            if (!this.c.isAborted()) {
              this.c.abort();
            }
            this.c = null;
          }
          if (this.b != null)
          {
            this.b.getConnectionManager().shutdown();
            this.b = null;
          }
          paramString = str;
          i = j;
          if (this.f == null) {
            break label435;
          }
          this.f.e();
          paramString = str;
          i = j;
          break label430;
          a(str);
          bool = this.d.a();
          if (!bool)
          {
            i = 1;
            if (this.c != null)
            {
              if (!this.c.isAborted()) {
                this.c.abort();
              }
              this.c = null;
            }
            if (this.b != null)
            {
              this.b.getConnectionManager().shutdown();
              this.b = null;
            }
            if (this.f != null)
            {
              this.f.e();
              this.f = null;
            }
            break label435;
          }
          i = 0;
          continue;
          this.d.o = 601;
          j = 0;
          break;
          this.d.o = 602;
          j = 0;
        }
      }
      catch (UnknownHostException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          this.d.o = 603;
          if (this.c != null)
          {
            if (!this.c.isAborted()) {
              this.c.abort();
            }
            this.c = null;
          }
          if (this.b != null)
          {
            this.b.getConnectionManager().shutdown();
            this.b = null;
          }
          if (this.f != null)
          {
            this.f.e();
            this.f = null;
          }
          i = 0;
        }
      }
      catch (InterruptedException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          this.d.o = 600;
          if (this.c != null)
          {
            if (!this.c.isAborted()) {
              this.c.abort();
            }
            this.c = null;
          }
          if (this.b != null)
          {
            this.b.getConnectionManager().shutdown();
            this.b = null;
          }
          if (this.f != null)
          {
            this.f.e();
            this.f = null;
          }
          i = 0;
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          this.d.o = 606;
          if (this.c != null)
          {
            if (!this.c.isAborted()) {
              this.c.abort();
            }
            this.c = null;
          }
          if (this.b != null)
          {
            this.b.getConnectionManager().shutdown();
            this.b = null;
          }
          if (this.f != null)
          {
            this.f.e();
            this.f = null;
          }
          i = 0;
        }
      }
      catch (m localm)
      {
        int j;
        localm.printStackTrace();
        this.d.o = localm.a;
        if (704 == localm.a)
        {
          this.d.a(0L);
          new com.tencent.tmdownloader.internal.d.b(this.d.m, this.d.l).b();
          if (this.d.b())
          {
            paramString = this.d;
            paramString.d += 1;
            j = 1;
          }
        }
        for (;;)
        {
          if (this.c != null)
          {
            if (!this.c.isAborted()) {
              this.c.abort();
            }
            this.c = null;
          }
          if (this.b != null)
          {
            this.b.getConnectionManager().shutdown();
            this.b = null;
          }
          paramString = localm;
          i = j;
          if (this.f == null) {
            break label435;
          }
          this.f.e();
          paramString = localm;
          i = j;
          break;
          j = 0;
          continue;
          j = 0;
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          label430:
          label435:
          label574:
          label696:
          paramString.printStackTrace();
          this.d.o = 604;
          if (this.c != null)
          {
            if (!this.c.isAborted()) {
              this.c.abort();
            }
            this.c = null;
          }
          if (this.b != null)
          {
            this.b.getConnectionManager().shutdown();
            this.b = null;
          }
          if (this.f != null)
          {
            this.f.e();
            this.f = null;
          }
          i = 0;
        }
      }
      finally
      {
        if (this.c != null)
        {
          if (!this.c.isAborted()) {
            this.c.abort();
          }
          this.c = null;
        }
        if (this.b != null)
        {
          this.b.getConnectionManager().shutdown();
          this.b = null;
        }
        if (this.f != null)
        {
          this.f.e();
          this.f = null;
        }
      }
      label1384:
      this.d.a(5);
      a(paramString);
    }
  }
  
  public void b()
  {
    com.tencent.tmassistantbase.a.m.c("_DownloadTask", "url: " + this.d.b);
    this.a = true;
    if ((this.c != null) && (!this.c.isAborted())) {
      this.c.abort();
    }
  }
  
  public String c()
  {
    return this.d.b;
  }
  
  public int d()
  {
    return this.d.n;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */