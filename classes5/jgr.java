import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftWebViewHttpBridge;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.smtt.sdk.WebViewClient;
import java.util.HashMap;
import java.util.Map;

public class jgr
  extends WebViewClient
{
  private ArrayMap a;
  
  private jgr(AbsBaseWebViewActivity paramAbsBaseWebViewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected WebResourceResponse a(WebView paramWebView, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramString.startsWith("mqqpa://resourceid/")) {
      paramWebView = PublicAccountH5AbilityPlugin.a(paramString);
    }
    WebViewPluginEngine localWebViewPluginEngine;
    do
    {
      return paramWebView;
      localWebViewPluginEngine = ((CustomWebView)paramWebView).a();
      paramWebView = (WebView)localObject1;
    } while (localWebViewPluginEngine == null);
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBase", 2, "doInterceptRequest url = " + paramString);
    }
    localObject1 = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("https://jsbridge/")) {
        break label228;
      }
      paramWebView = paramString.replace("https://jsbridge/", "jsbridge://");
    }
    for (;;)
    {
      localObject1 = paramWebView;
      if (QLog.isColorLevel())
      {
        QLog.d("WebViewBase", 2, "doInterceptRequest  https://jsbridge/ temp url = " + paramWebView);
        localObject1 = paramWebView;
      }
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).startsWith("jsbridge")) || (this.b.b == null)) {
        break;
      }
      this.b.b.post(new jgs(this, (String)localObject1, localWebViewPluginEngine));
      localObject1 = new WebResourceResponse("text/html", "utf-8", null);
      paramString = ((WebResourceResponse)localObject1).getResponseHeaders();
      paramWebView = paramString;
      if (paramString == null) {
        paramWebView = new HashMap();
      }
      paramWebView.put("cache-control", "must-revalidate，no-store");
      ((WebResourceResponse)localObject1).setResponseHeaders(paramWebView);
      return (WebResourceResponse)localObject1;
      label228:
      paramWebView = paramString;
      if (paramString.startsWith("http://jsbridge/")) {
        paramWebView = paramString.replace("http://jsbridge/", "jsbridge://");
      }
    }
    paramWebView = (WebView)localObject2;
    try
    {
      if (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftWebViewHttpBridge != null) {
        paramWebView = this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftWebViewHttpBridge.a((String)localObject1);
      }
      paramString = paramWebView;
      if (paramWebView == null) {}
      try
      {
        paramString = localWebViewPluginEngine.a((String)localObject1, 8L);
        if (!(paramString instanceof WebResourceResponse)) {
          break label354;
        }
        paramString = (WebResourceResponse)paramString;
        paramWebView = paramString;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramString = paramWebView;
          if (QLog.isColorLevel())
          {
            QLog.e("WebViewBase", 2, "shouldInterceptRequest got exception!", localException);
            paramString = paramWebView;
          }
        }
      }
      paramString = paramWebView;
      return paramString;
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("WebViewBase", 2, "shouldInterceptRequest got exception!", paramWebView);
        }
        paramWebView = null;
      }
    }
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowser_report", 2, "onDetectedBlankScreen, status: " + paramInt + ", url:" + paramString);
    }
    this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a(paramString, paramInt);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if ((!this.b.i) && (!this.b.isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebViewBase", 2, "onPageFinished:" + paramString);
      }
      super.onPageFinished(paramWebView, paramString);
      this.b.b(paramWebView, paramString);
      AbsBaseWebViewActivity.a(this.b, paramString, 8589934594L);
      WebViewPluginEngine localWebViewPluginEngine = ((CustomWebView)paramWebView).a();
      if (localWebViewPluginEngine != null) {
        localWebViewPluginEngine.a(paramString, 8589934594L, null);
      }
      if ((Build.VERSION.SDK_INT >= 19) && (!this.b.i) && (AbsBaseWebViewActivity.a(this.b) != null))
      {
        paramString = paramWebView.getTitle();
        AbsBaseWebViewActivity.a(this.b).onReceivedTitle(paramWebView, paramString);
      }
      AIOOpenWebMonitor.b(this.b.getIntent());
      return;
    }
    QLog.e("WebViewBase", 1, "call onPageFinished after destroy.");
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((!this.b.i) && (!this.b.isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebViewBase", 2, "onPageStarted:" + paramString);
      }
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      this.b.a(paramWebView, paramString, paramBitmap);
      AbsBaseWebViewActivity.a(this.b, paramString, 8589934593L);
      WebViewPluginEngine localWebViewPluginEngine = ((CustomWebView)paramWebView).a();
      if (localWebViewPluginEngine != null) {
        localWebViewPluginEngine.a(paramString, 8589934593L, null);
      }
      this.b.b(paramWebView, paramString, paramBitmap);
      return;
    }
    QLog.e("WebViewBase", 1, "call onPageStarted after destroy.");
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((!this.b.i) && (!this.b.isFinishing()))
    {
      QLog.e("WebViewBase", 1, "onReceivedError:" + paramInt + ", desc=" + paramString1 + ", url=" + paramString2);
      this.b.a(paramWebView, paramInt, paramString1, paramString2);
      paramWebView = ((CustomWebView)paramWebView).a();
      if (paramWebView != null) {
        paramWebView.a(paramString2, 8589934595L, paramInt);
      }
      return;
    }
    QLog.e("WebViewBase", 1, "call onReceivedError after destroy.");
  }
  
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    if ((!this.b.i) && (!this.b.isFinishing()))
    {
      if ((paramWebView != null) && (paramWebResourceRequest != null) && (paramWebResourceResponse != null))
      {
        QLog.e("WebViewBase", 1, "Request " + paramWebResourceRequest.getUrl() + "Occur error, resp code=" + paramWebResourceResponse.getStatusCode());
        String str = paramWebView.getUrl();
        if ((str != null) && (AuthorizeConfig.a().a(str)))
        {
          paramWebView = ((CustomWebView)paramWebView).a();
          if (paramWebView != null)
          {
            if (this.a == null) {
              this.a = new ArrayMap(4);
            }
            this.a.put("requestData", paramWebResourceRequest);
            this.a.put("responseData", paramWebResourceResponse);
            this.a.put("errorCode", Integer.valueOf(paramWebResourceResponse.getStatusCode()));
            paramWebView.a(str, 64L, this.a);
          }
        }
      }
      return;
    }
    QLog.e("WebViewBase", 1, "call onReceivedHttpError after destroy.");
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if ((!this.b.i) && (!this.b.isFinishing()))
    {
      SslCertificate localSslCertificate = paramSslError.getCertificate();
      String str = paramWebView.getUrl();
      paramSslError = new StringBuilder().append("onReceivedSslError:").append(paramSslError.getPrimaryError()).append(", cert=");
      if (localSslCertificate == null) {}
      for (paramWebView = "null";; paramWebView = localSslCertificate.toString())
      {
        QLog.e("WebViewBase", 1, paramWebView + ", pageUrl=" + Util.b(str, new String[0]));
        paramSslErrorHandler.cancel();
        return;
      }
    }
    QLog.e("WebViewBase", 1, "call onReceivedSslError after destroy.");
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((this.b.i) || (this.b.isFinishing()))
    {
      QLog.e("WebViewBase", 1, "call shouldOverrideUrlLoading after destroy.");
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBase", 2, "shouldOverrideUrlLoading " + Util.b(paramString, new String[0]));
    }
    Object localObject2 = paramString;
    Object localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("https://jsbridge/")) {
        break label248;
      }
      localObject1 = paramString.replace("https://jsbridge/", "jsbridge://");
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("WebViewBase", 2, "shouldOverrideUrlLoading  https://jsbridge/ temp url = " + (String)localObject1);
        localObject2 = localObject1;
      }
      Util.a("urlInterceptManager");
      if (!(this.b.getActivity() instanceof QQBrowserActivity)) {
        break label286;
      }
      paramString = (QQBrowserActivity)this.b.getActivity();
      if ((paramString.a == null) || (paramString.a.a == null)) {
        break;
      }
      paramString = paramString.a.a.a((String)localObject2);
      if (paramString == null) {
        break label286;
      }
      paramWebView = new Intent(this.b.getActivity(), JumpActivity.class);
      paramWebView.setData(Uri.parse(paramString));
      paramWebView.putExtra("from", "webview");
      this.b.startActivity(paramWebView);
      return true;
      label248:
      localObject1 = paramString;
      if (paramString.startsWith("http://jsbridge/")) {
        localObject1 = paramString.replace("http://jsbridge/", "jsbridge://");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("WebViewBase", 2, "URLInterceptManager = null");
    }
    label286:
    Util.b("urlInterceptManager");
    AIOOpenWebMonitor.b(this.b.getIntent(), (String)localObject2);
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || ("about:blank;".equals(localObject2)) || ("about:blank".equals(localObject2))) {
      return true;
    }
    paramString = SwiftWebViewUtils.a((String)localObject2);
    if ((("http".equals(paramString)) || ("data".equals(paramString))) && (!((String)localObject2).contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
      CustomWebView.b(Util.b((String)localObject2, new String[0]));
    }
    try
    {
      if (("http".equals(paramString)) || ("https".equals(paramString)))
      {
        localObject1 = paramWebView.getHitTestResult();
        if ((localObject1 != null) && (((WebView.HitTestResult)localObject1).getType() == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.i("WebViewBase", 2, "shouldOverrideUrlLoading detect 302 url: " + (String)localObject2);
          }
          this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.q = System.currentTimeMillis();
          this.b.G = ((String)localObject2);
          SwiftBrowserCookieMonster.b();
        }
      }
      if (AbsBaseWebViewActivity.a(this.b, (String)localObject2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebViewBase", 2, "url has intercept by systemComponent");
        }
      }
      else
      {
        localObject1 = ((CustomWebView)paramWebView).a();
        if ((localObject1 != null) && (((WebViewPluginEngine)localObject1).a((String)localObject2))) {
          return true;
        }
        if (this.b.a(paramWebView, (String)localObject2)) {
          return true;
        }
        if (("http".equals(paramString)) || ("https".equals(paramString)) || ("data".equals(paramString)) || ("file".equals(paramString)))
        {
          if ((localObject1 == null) || (!((WebViewPluginEngine)localObject1).a((String)localObject2, 16L, null))) {
            break label780;
          }
          return true;
        }
        paramString = Uri.parse((String)localObject2);
        localObject1 = paramString.getScheme();
        if ((this.b.isResume()) && ((System.currentTimeMillis() - this.b.f < 1000L) || (this.b.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramWebView.getUrl(), (String)localObject1).booleanValue())))
        {
          paramWebView = new Intent("android.intent.action.VIEW", paramString);
          paramWebView.addFlags(268435456);
        }
      }
      return true;
    }
    catch (RuntimeException paramWebView)
    {
      try
      {
        this.b.startActivity(paramWebView);
        return true;
        paramWebView = paramWebView;
        paramString = QLog.getStackTraceString(paramWebView);
        if (paramString.length() > 255) {}
        for (paramWebView = paramString.substring(0, 255);; paramWebView = paramString)
        {
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "webview", "exception", 0, 1, 0, paramWebView, "", "", "");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("WebViewBase", 2, paramString);
          break;
        }
      }
      catch (ActivityNotFoundException paramWebView)
      {
        for (;;) {}
      }
    }
    label780:
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */