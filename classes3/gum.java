import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.HYControlUI;
import com.tencent.biz.pubaccount.CustomWebViewClient;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class gum
  extends CustomWebViewClient
{
  public gum(HYControlUI paramHYControlUI, WebViewPluginEngine paramWebViewPluginEngine)
  {
    super(paramWebViewPluginEngine);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.a.b())))
    {
      this.a.jdField_a_of_type_Long = (System.currentTimeMillis() - this.a.jdField_a_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.d("HYControlUI", 2, "onPageFinished url = " + paramString + " , cost time = " + this.a.jdField_a_of_type_Long);
      }
    }
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (this.a.d != null) {
      this.a.d.setVisibility(8);
    }
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool = false;
    if (!paramString.contains("mqqc2b://callcenter")) {
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    Object localObject = new HashMap();
    try
    {
      i = paramString.indexOf('?');
      if (i != -1)
      {
        j = i + 1;
        k = paramString.indexOf('=', j);
        if (k != -1) {
          break label225;
        }
      }
      str1 = URLDecoder.decode(paramString, "UTF-8");
      paramString = str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        int i;
        int j;
        int k;
        String str1;
        localUnsupportedEncodingException.printStackTrace();
        continue;
        if (paramString.contains("mqqc2b://callcenter/doClientReport"))
        {
          if (((Map)localObject).containsKey("webJsonString")) {
            this.a.i((String)((Map)localObject).get("webJsonString"));
          }
        }
        else
        {
          if (!paramString.startsWith("mqqc2b://callcenter/getCallTime")) {
            break;
          }
          paramWebView = (String)((Map)localObject).get("callback");
          if (!TextUtils.isEmpty(paramWebView)) {
            this.a.f(paramWebView);
          }
        }
      }
      if (!paramString.startsWith("mqqc2b://callcenter/clientLog")) {
        break label455;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("HYControlUI", 4, "shouldOverrideUrlLoading: " + paramString);
    }
    label225:
    String str3;
    if (paramString.contains("mqqc2b://callcenter/onWebReady"))
    {
      this.a.b = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("HYControlUI", 2, "onWebReady");
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().u = true;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().x = null;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().l != null) {
        this.a.g(this.a.jdField_a_of_type_ComTencentAvVideoController.a().l);
      }
      this.a.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), ".qq.com");
      return true;
      i = paramString.indexOf('&', k + 1);
      str3 = paramString.substring(j, k);
      if (i == -1) {}
      for (str1 = paramString.substring(k + 1);; str1 = paramString.substring(k + 1, i))
      {
        ((Map)localObject).put(URLDecoder.decode(str3, "UTF-8"), URLDecoder.decode(str1, "UTF-8"));
        break;
      }
    }
    paramWebView = (String)((Map)localObject).get("level");
    if (TextUtils.isEmpty(paramWebView)) {
      paramWebView = "0";
    }
    for (;;)
    {
      paramString = (String)((Map)localObject).get("logText");
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      this.a.e(paramWebView, paramString);
      break;
      label455:
      if (paramString.startsWith("mqqc2b://callcenter/clientShowPage"))
      {
        paramWebView = (String)((Map)localObject).get("pageUrl");
        if (TextUtils.isEmpty(paramWebView)) {
          break;
        }
        this.a.b(paramWebView, (String)((Map)localObject).get("backDtmf"));
        break;
      }
      if (paramString.startsWith("mqqc2b://callcenter/clientShowAudioWave"))
      {
        bool = "1".equals((String)((Map)localObject).get("show"));
        this.a.k(bool);
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().v = bool;
        break;
      }
      if (paramString.startsWith("mqqc2b://callcenter/clientSendDtmf"))
      {
        paramWebView = (String)((Map)localObject).get("dtmf");
        paramString = (String)((Map)localObject).get("callback");
        this.a.c(paramWebView, paramString);
        break;
      }
      if (paramString.startsWith("mqqc2b://callcenter/clientShowLoadingPage"))
      {
        paramWebView = (String)((Map)localObject).get("show");
        if (TextUtils.isEmpty(paramWebView)) {
          break;
        }
        if ("1".equals(paramWebView))
        {
          this.a.d.setVisibility(0);
          break;
        }
        if (!"0".equals(paramWebView)) {
          break;
        }
        this.a.d.setVisibility(8);
        break;
      }
      if (paramString.startsWith("mqqc2b://callcenter/getEnvInfo"))
      {
        paramWebView = (String)((Map)localObject).get("callback");
        if (TextUtils.isEmpty(paramWebView)) {
          break;
        }
        this.a.h(paramWebView);
        break;
      }
      if (paramString.startsWith("mqqc2b://callcenter/getAuthorisation"))
      {
        QLog.d("HYControlUI", 4, "AUTHORISATION Enter");
        paramWebView = (String)((Map)localObject).get("bind");
        if (!TextUtils.isEmpty(paramWebView)) {
          bool = paramWebView.equals("1");
        }
        paramWebView = (String)((Map)localObject).get("callback");
        if (TextUtils.isEmpty(paramWebView)) {
          break;
        }
        paramString = (String)((Map)localObject).get("appId");
        String str2 = (String)((Map)localObject).get("pkg");
        str3 = (String)((Map)localObject).get("sign");
        localObject = (String)((Map)localObject).get("scope");
        this.a.a(bool, paramString, str2, str3, (String)localObject, paramWebView);
        break;
      }
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */