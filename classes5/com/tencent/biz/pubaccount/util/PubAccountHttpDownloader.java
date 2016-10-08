package com.tencent.biz.pubaccount.util;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import iez;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AccountNotMatchException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class PubAccountHttpDownloader
  extends HttpDownloader
{
  public static final int a = 0;
  public static final String a = "PubAccountHttpDownloader";
  public static final int b = 1;
  public static final String b = "pubaccountimage";
  public static final int c = 2;
  public static final int d = 3;
  private BaseApplicationImpl a;
  
  public PubAccountHttpDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramBaseApplicationImpl;
  }
  
  public static URL a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, null);
  }
  
  public static URL a(String paramString, int paramInt, Object paramObject)
  {
    String str;
    for (;;)
    {
      try
      {
        if ((!paramString.startsWith("http")) && (!paramString.startsWith("https"))) {
          return new URL(paramString);
        }
        paramString = paramString + "?busiType=" + paramInt;
        if (paramObject != null) {
          continue;
        }
      }
      catch (MalformedURLException paramObject)
      {
        paramString = null;
        continue;
        continue;
      }
      paramString = new URL("pubaccountimage", null, paramString);
      str = paramString;
      try
      {
        if (!QLog.isColorLevel()) {
          return str;
        }
        QLog.d("PubAccountHttpDownloader", 2, "<--generateURL urlString =" + paramString.toString());
        return paramString;
      }
      catch (MalformedURLException paramObject) {}
      str = paramString;
      if (!QLog.isColorLevel()) {
        return str;
      }
      QLog.e("PubAccountHttpDownloader", 2, "<--generateURL urlString", (Throwable)paramObject);
      return paramString;
      if (!(paramObject instanceof String)) {
        continue;
      }
      paramString = paramString + "&puin=" + paramObject;
    }
    return str;
  }
  
  private void a(String paramString, long paramLong)
  {
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
    for (String[] arrayOfString = { "param_WIFIPublicPlatDownloadFlow", "param_WIFIFlow", "param_Flow" };; arrayOfString = new String[] { "param_XGPublicPlatDownloadFlow", "param_XGFlow", "param_Flow" }) {
      try
      {
        ((QQAppInterface)this.a.getAppRuntime(paramString)).a(paramString, arrayOfString, paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountHttpDownloader", 2, "param_PublicPlatDownloadFlow fileSize: " + paramLong);
        }
        return;
      }
      catch (AccountNotMatchException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject3 = null;
    int k = 0;
    Object localObject1 = paramDownloadParams.urlStr;
    if (!paramDownloadParams.urlStr.startsWith("http")) {
      localObject1 = paramDownloadParams.url.getFile();
    }
    int i = ((String)localObject1).lastIndexOf("?busiType");
    Object localObject2 = new HashMap();
    Object localObject4;
    int j;
    Object localObject5;
    if (i != -1)
    {
      localObject4 = ((String)localObject1).substring(i + 1);
      localObject1 = ((String)localObject1).substring(0, i);
      localObject4 = ((String)localObject4).split("&");
      j = localObject4.length;
      i = 0;
      while (i < j)
      {
        localObject5 = localObject4[i];
        int m = ((String)localObject5).indexOf('=');
        ((Map)localObject2).put(((String)localObject5).substring(0, m), ((String)localObject5).substring(m + 1));
        i += 1;
      }
      localObject4 = (String)((Map)localObject2).get("busiType");
      if (localObject4 != null) {
        i = Integer.parseInt((String)localObject4);
      }
    }
    for (;;)
    {
      paramDownloadParams.url = new URL((String)localObject1);
      paramDownloadParams.urlStr = ((String)localObject1);
      localObject4 = new PubAccountHttpDownloader.PubAccoutImageReporter(this.a, i);
      ((PubAccountHttpDownloader.PubAccoutImageReporter)localObject4).a(paramDownloadParams, (Map)localObject2);
      if (paramDownloadParams.headers != null)
      {
        localObject5 = paramDownloadParams.headers;
        j = localObject5.length;
        i = 0;
        localObject1 = null;
        for (;;)
        {
          localObject2 = localObject1;
          if (i >= j) {
            break;
          }
          localObject2 = localObject5[i];
          if ("my_uin".equals(((Header)localObject2).getName())) {
            localObject1 = ((Header)localObject2).getValue();
          }
          i += 1;
        }
      }
      localObject2 = null;
      localObject5 = new iez(this, paramOutputStream);
      j = 3;
      i = k;
      paramOutputStream = (OutputStream)localObject3;
      for (;;)
      {
        k = j - 1;
        if (j <= 0) {
          break label553;
        }
        j = i + 1;
        try
        {
          ((PubAccountHttpDownloader.PubAccoutImageReporter)localObject4).a();
          localObject1 = super.a((OutputStream)localObject5, paramDownloadParams, ((PubAccountHttpDownloader.PubAccoutImageReporter)localObject4).a(paramURLDrawableHandler));
          paramOutputStream = (OutputStream)localObject1;
          i = k;
          if (paramOutputStream == null) {
            i = -1;
          }
          if ((i == -1) || (i == 0)) {
            ((PubAccountHttpDownloader.PubAccoutImageReporter)localObject4).a(j, paramDownloadParams);
          }
          for (;;)
          {
            k = i;
            i = j;
            j = k;
            break;
            try
            {
              Thread.sleep(5L);
            }
            catch (InterruptedException localInterruptedException1)
            {
              localInterruptedException1.printStackTrace();
            }
          }
          label439:
          if (k != 0) {
            break label536;
          }
        }
        catch (IOException localIOException)
        {
          if (!localIOException.getMessage().contains(" response error! response code: ")) {
            break label469;
          }
          if (k != 0) {
            break label483;
          }
          throw localIOException;
        }
        finally
        {
          if (k == -1) {}
        }
      }
      ((PubAccountHttpDownloader.PubAccoutImageReporter)localObject4).a(j, paramDownloadParams);
      for (;;)
      {
        throw paramOutputStream;
        label469:
        ((PubAccountHttpDownloader.PubAccoutImageReporter)localObject4).a(-1, localIOException.getMessage());
        break label439;
        label483:
        if ((k == -1) || (k == 0))
        {
          ((PubAccountHttpDownloader.PubAccoutImageReporter)localObject4).a(j, paramDownloadParams);
          i = k;
          break;
        }
        try
        {
          Thread.sleep(5L);
          i = k;
        }
        catch (InterruptedException localInterruptedException2)
        {
          localInterruptedException2.printStackTrace();
          i = k;
        }
        break;
        try
        {
          label536:
          Thread.sleep(5L);
        }
        catch (InterruptedException paramDownloadParams)
        {
          paramDownloadParams.printStackTrace();
        }
      }
      label553:
      if (localObject2 != null) {
        a((String)localObject2, ((iez)localObject5).a);
      }
      return paramOutputStream;
      i = -1;
      continue;
      i = -1;
    }
  }
  
  public void a(HttpResponse paramHttpResponse, String paramString, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramURLDrawableHandler instanceof PubAccountHttpDownloader.PubAccoutImageReporter.WrapURLDrawableHandler))
    {
      paramURLDrawableHandler = ((PubAccountHttpDownloader.PubAccoutImageReporter.WrapURLDrawableHandler)paramURLDrawableHandler).a();
      if (paramURLDrawableHandler != null) {
        paramURLDrawableHandler.a(paramHttpResponse, paramString);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\util\PubAccountHttpDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */