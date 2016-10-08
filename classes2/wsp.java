import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.AppViewBaseActivity;
import com.tencent.open.appcommon.Common;
import com.tencent.open.appcommon.js.OpenJsBridge;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.img.ImageCache;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class wsp
  extends WebViewClient
{
  AppViewBaseActivity a;
  
  public wsp(AppViewBaseActivity paramAppViewBaseActivity1, AppViewBaseActivity paramAppViewBaseActivity2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = null;
    this.a = paramAppViewBaseActivity2;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    try
    {
      this.a.d = System.currentTimeMillis();
      LogUtility.b("LaunchTime", "APP_" + this.a.l + "_onPageFinished：" + this.a.d);
      LogUtility.b("LaunchTime", "App_" + this.a.l + "_interval_(onPageFinished-onPageStarted):" + (this.a.d - this.b.c));
      if (paramWebView != null)
      {
        super.onPageFinished(paramWebView, paramString);
        if ((this.a != null) && (!this.a.isFinishing())) {
          this.a.b(paramWebView, paramString);
        }
      }
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if (this.a != null)
    {
      this.a.c = System.currentTimeMillis();
      LogUtility.b("LaunchTime", "APP_" + this.a.l + "_onPageStarted：" + this.a.c);
      LogUtility.b("LaunchTime", "App_" + this.a.l + "_interval_(onPageStarted-onCreate):" + (this.a.c - this.a.b));
      paramBitmap = "javascript:window.agentData = {};agentData.currentVersion='" + CommonDataAdapter.a().b() + "';" + "agentData.platform='" + CommonDataAdapter.a().g() + "';" + "agentData.uin='" + CommonDataAdapter.a().a() + "';" + "agentData.agentVersion='" + CommonDataAdapter.a().d() + "';" + "agentData.display='" + MobileInfoUtil.e() + "';" + "agentData.mobileInfo='" + MobileInfoUtil.i() + "';" + "agentData.pageParams='" + this.a.b() + "';" + "agentData.imgRoot='" + Common.f() + ImageCache.b + "';" + "agentData.isFirstEnter='" + this.b.h + "';" + "void(0);";
      LogUtility.b("opensdk", "agentData_js=" + paramBitmap);
      paramWebView.loadUrl(paramBitmap);
    }
    try
    {
      if ((this.a != null) && (!this.a.isFinishing())) {
        this.a.a(paramWebView, paramString);
      }
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    try
    {
      if ((this.a != null) && (!this.a.isFinishing())) {
        this.a.a(paramWebView, paramInt, paramString1, paramString2);
      }
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null)) {
      return shouldInterceptRequest(paramWebView, paramWebResourceRequest.getUrl().toString());
    }
    return super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    Object localObject2 = paramString;
    for (;;)
    {
      try
      {
        bool = paramString.startsWith("http://sng.qq.com/open/mobile/appstore_qq/");
        if (!bool) {
          continue;
        }
        localObject3 = paramString;
        localObject2 = paramString;
      }
      catch (Exception paramString)
      {
        boolean bool;
        Object localObject3;
        int i;
        String str;
        File localFile;
        LogUtility.c("AppViewBaseActivity", "ShouldIntercept Exception", paramString);
        Object localObject1 = localObject2;
        continue;
        localObject1 = paramString;
        localObject2 = paramString;
        if (!paramString.startsWith("http://sng.qq.com/call?callbatch=")) {
          continue;
        }
        localObject2 = paramString;
        localObject1 = paramString.replace("http://sng.qq.com/call?callbatch=", "");
        localObject2 = paramString;
        paramString = new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(Common.a(paramWebView, this.b.a.a(), (String)localObject1).getBytes()));
        return paramString;
      }
      try
      {
        i = paramString.lastIndexOf('?');
        localObject1 = paramString;
        if (i > 0)
        {
          localObject3 = paramString;
          localObject2 = paramString;
          localObject1 = paramString.substring(0, i);
        }
        localObject3 = localObject1;
        localObject2 = localObject1;
        i = ((String)localObject1).lastIndexOf('/');
        if (i <= 0) {
          break label673;
        }
        localObject3 = localObject1;
        localObject2 = localObject1;
        if (i >= ((String)localObject1).length() - 1) {
          break label673;
        }
        localObject3 = localObject1;
        localObject2 = localObject1;
        str = ((String)localObject1).substring(i + 1);
        localObject3 = localObject1;
        localObject2 = localObject1;
        if (str.contains(".js"))
        {
          paramString = "text/javascript";
          localObject3 = localObject1;
          localObject2 = localObject1;
          if (this.b.h)
          {
            localObject3 = localObject1;
            localObject2 = localObject1;
            str = "Page/system" + File.separator + str;
            localObject3 = localObject1;
            localObject2 = localObject1;
            return new WebResourceResponse(paramString, "utf-8", this.b.getResources().getAssets().open(str));
          }
        }
        else
        {
          localObject3 = localObject1;
          localObject2 = localObject1;
          if (str.contains(".css"))
          {
            paramString = "text/css";
            continue;
          }
          localObject3 = localObject1;
          localObject2 = localObject1;
          if (str.contains(".htm"))
          {
            paramString = "text/html";
            continue;
          }
          localObject3 = localObject1;
          localObject2 = localObject1;
          if (str.contains(".png"))
          {
            paramString = "image/png";
            continue;
          }
          localObject3 = localObject1;
          localObject2 = localObject1;
          if (str.contains(".jpg"))
          {
            paramString = "image/jpeg";
            continue;
          }
          localObject3 = localObject1;
          localObject2 = localObject1;
          if (!str.contains(".gif")) {
            break label675;
          }
          paramString = "image/gif";
          continue;
        }
        localObject3 = localObject1;
        localObject2 = localObject1;
        localFile = new File(Common.i() + File.separator + str);
        localObject3 = localObject1;
        localObject2 = localObject1;
        if (!Common.a()) {
          continue;
        }
        localObject3 = localObject1;
        localObject2 = localObject1;
        bool = localFile.exists();
        if (!bool) {
          continue;
        }
        localObject2 = localObject1;
        try
        {
          paramString = new WebResourceResponse(paramString, "utf-8", new FileInputStream(localFile));
          return paramString;
        }
        catch (IOException paramString)
        {
          localObject3 = localObject1;
          localObject2 = localObject1;
          LogUtility.b("IOException", "shouldInterceptRequest IOException: " + paramString.getMessage());
        }
      }
      catch (IOException paramString)
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject2 = localObject3;
        LogUtility.b("IOException", "shouldInterceptRequest IOException: " + paramString.getMessage());
        localObject1 = localObject3;
        continue;
      }
      return super.shouldInterceptRequest(paramWebView, (String)localObject1);
      localObject3 = localObject1;
      localObject2 = localObject1;
      str = "Page/system" + File.separator + str;
      localObject3 = localObject1;
      localObject2 = localObject1;
      paramString = new WebResourceResponse(paramString, "utf-8", this.b.getResources().getAssets().open(str));
      return paramString;
      label673:
      return null;
      label675:
      paramString = "text/html";
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    LogUtility.b("opensdk", ">>should url:" + paramString);
    try
    {
      if ((this.a == null) || (this.a.isFinishing())) {
        break label64;
      }
      boolean bool = this.a.a.a(paramWebView, paramString);
      if (!bool) {
        break label64;
      }
    }
    catch (Exception localException)
    {
      label64:
      do
      {
        do
        {
          do
          {
            while ((paramString.equals("about:blank;")) || (paramString.equals("about:blank")))
            {
              if (QLog.isColorLevel()) {
                LogUtility.b("AppViewBaseActivity", "shouldOverrideUrlLoading about:blank; " + paramString);
              }
              if (Build.VERSION.SDK_INT >= 11) {
                return false;
              }
            }
            if (!paramString.startsWith("tmast")) {
              break;
            }
            if (QLog.isColorLevel()) {
              LogUtility.b("AppViewBaseActivity", "shouldOverrideUrlLoading tmast; " + paramString);
            }
            try
            {
              paramWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
              this.b.startActivity(paramWebView);
              return true;
            }
            catch (Exception paramWebView) {}
          } while (!QLog.isColorLevel());
          LogUtility.b("AppViewBaseActivity", "shouldOverrideUrlLoading tmast;error: " + paramWebView.getMessage());
          return true;
          if (!paramString.startsWith("mqqapi")) {
            break;
          }
          if (QLog.isColorLevel()) {
            LogUtility.b("AppViewBaseActivity", "shouldOverrideUrlLoading tmast; " + paramString);
          }
          try
          {
            paramWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
            this.b.startActivity(paramWebView);
            return true;
          }
          catch (Exception paramWebView) {}
        } while (!QLog.isColorLevel());
        LogUtility.b("AppViewBaseActivity", "shouldOverrideUrlLoading tmast;error: " + paramWebView.getMessage());
        return true;
      } while (this.a.a(paramWebView, paramString));
    }
    return true;
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */