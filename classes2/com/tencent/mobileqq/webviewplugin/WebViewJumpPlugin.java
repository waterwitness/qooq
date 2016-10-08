package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.util.URLUtil;
import cooperation.qzone.QZoneHelper.QZoneFamousSpaceHomeConstants;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.HashMap;
import java.util.Map;
import wkh;
import wki;
import wkj;

public class WebViewJumpPlugin
  extends WebViewPlugin
{
  public static final String a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = WebViewJumpPlugin.class.getSimpleName();
  }
  
  public WebViewJumpPlugin()
  {
    this.mPluginNameSpace = jdField_a_of_type_JavaLangString;
  }
  
  private void a(Intent paramIntent)
  {
    if (this.mRuntime == null) {}
    do
    {
      return;
      if (this.mRuntime.a() != null)
      {
        this.mRuntime.a().startActivity(paramIntent);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebViewJumpPlugin", 2, "Activity is null");
  }
  
  private void b(String paramString)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {}
    do
    {
      return;
      ((Activity)localObject).finish();
      if (QRUtils.c(paramString))
      {
        localObject = new Intent((Context)localObject, JoinDiscussionActivity.class);
        ((Intent)localObject).putExtra("innerSig", paramString);
        a((Intent)localObject);
        return;
      }
      paramString = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)localObject, paramString);
    } while (paramString == null);
    paramString.b();
  }
  
  public void a(String paramString)
  {
    paramString = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString);
    if (paramString != null) {
      paramString.b();
    }
  }
  
  protected boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      paramBoolean = false;
      return paramBoolean;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("KEY_PID", String.valueOf(50079));
    localHashMap.put("KEY_EUSESTAT", String.valueOf(5));
    paramString = MttLoader.getValidQBUrl(this.mRuntime.a(), paramString);
    int i = MttLoader.loadUrl(this.mRuntime.a(), paramString, localHashMap, null);
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentSmttSdkWebView == null) && (QLog.isColorLevel()))
      {
        QLog.d("WebViewJumpPlugin", 2, "webview is null");
        return true;
      }
      if (4 != i) {
        break label124;
      }
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079");
    }
    for (;;)
    {
      paramBoolean = bool;
      if (i == 0) {
        break;
      }
      return false;
      label124:
      if (5 == i) {
        this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079");
      } else if (i != 0) {
        this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079");
      }
    }
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 2L) {
      this.c = true;
    }
    for (;;)
    {
      return false;
      if (paramLong == 8589934597L) {
        this.c = false;
      } else if (paramLong == 8589934601L)
      {
        if ((!TextUtils.isEmpty(paramString)) && ((paramString.contains("chatplay/hall")) || (paramString.contains("avwithstranger/avchathall")) || (paramString.contains("chatplay/avchathall"))) && (paramString.endsWith("#child")))
        {
          if ((paramString.contains("adtag=client.tab")) && (this.mRuntime != null) && (this.mRuntime.a() != null) && ((this.mRuntime.a() instanceof IphoneTitleBarActivity))) {
            ((IphoneTitleBarActivity)this.mRuntime.a()).setLeftViewName(2131367567);
          }
          if ((this.mRuntime != null) && (this.mRuntime.a() != null) && (this.mRuntime.a().canGoBack()))
          {
            this.mRuntime.a().goBack();
            return true;
          }
        }
      }
      else if ((paramLong == 8589934594L) && (!TextUtils.isEmpty(paramString)) && ((paramString.contains("chatplay/hall")) || (paramString.contains("avwithstranger/avchathall")) || (paramString.contains("chatplay/avchathall"))) && (paramString.endsWith("#child")) && (paramString.contains("adtag=client.tab")) && (this.mRuntime != null) && (this.mRuntime.a() != null) && ((this.mRuntime.a() instanceof IphoneTitleBarActivity))) {
        ((IphoneTitleBarActivity)this.mRuntime.a()).setLeftViewName(2131367975);
      }
    }
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "handleSchemaRequest-->url:" + paramString1 + ",scheme:" + paramString2 + "mActive=" + this.c);
    }
    boolean bool1;
    if (!this.c) {
      bool1 = false;
    }
    int i;
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return bool1;
                        if (paramString1.startsWith("tel:"))
                        {
                          paramString1 = new Intent("android.intent.action.DIAL", Uri.parse(paramString1));
                          if ((!MobileIssueSettings.jdField_a_of_type_Boolean) && (KapalaiAdapterUtil.a().a())) {
                            KapalaiAdapterUtil.a().a(paramString1);
                          }
                          a(paramString1);
                          return true;
                        }
                        if (paramString1.startsWith("sms:"))
                        {
                          paramString2 = new Intent("android.intent.action.VIEW");
                          int j = paramString1.indexOf("?");
                          i = j;
                          if (j == -1) {
                            i = paramString1.length();
                          }
                          paramString2.putExtra("address", paramString1.substring(paramString1.indexOf(":") + 1, i));
                          j = paramString1.indexOf("=");
                          i = j;
                          if (j == -1) {
                            i = paramString1.length() - 1;
                          }
                          paramString2.putExtra("sms_body", paramString1.substring(i + 1, paramString1.length()));
                          paramString2.setType("vnd.android-dir/mms-sms");
                          a(paramString2);
                          return true;
                        }
                        if (!paramString1.startsWith("mqqapi://tenpay/pay?")) {
                          break;
                        }
                        i = getRequestCode((byte)3);
                        bool1 = bool2;
                      } while (i == -1);
                      bool1 = bool2;
                    } while (this.b);
                    this.b = true;
                    paramString1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString1);
                    bool1 = bool2;
                  } while (paramString1 == null);
                  paramString1.a("webview");
                  paramString1.a("k_requestcode", String.valueOf(i));
                  paramString1.a("url_app_info", QWalletPayJsPlugin.getPayAppInfo());
                  paramString1.b();
                  this.jdField_a_of_type_Boolean = true;
                  this.b = false;
                  return true;
                  if ((!QRUtils.a(paramString1)) && (!paramString1.startsWith("mqqopensdkapi:"))) {
                    break;
                  }
                  paramString2 = this.mRuntime.a();
                  bool1 = bool2;
                } while (paramString2 == null);
                paramString2 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1);
                if (paramString2 != null)
                {
                  paramString2.a("webview");
                  paramString2.b();
                }
                bool1 = bool2;
              } while (!paramString1.startsWith("http:"));
              new Handler().postDelayed(new wkh(this), 2000L);
              return true;
              if (!paramString1.startsWith("http://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard")) {
                break;
              }
              paramString1 = Uri.parse(paramString1).getQueryParameter("xq_uin");
              if (TextUtils.isEmpty(paramString1)) {
                return false;
              }
              paramString1 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1;
              paramString2 = this.mRuntime.a();
              bool1 = bool2;
            } while (paramString2 == null);
            paramString1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1);
            if (paramString1 != null)
            {
              paramString1.a("webview");
              paramString1.b();
            }
            new Handler().postDelayed(new wki(this), 2000L);
            return true;
            if (paramString1.startsWith("http://clientui.3g.qq.com/mqqapi/"))
            {
              if ((this.jdField_a_of_type_ComTencentSmttSdkWebView == null) && (QLog.isColorLevel()))
              {
                QLog.d("WebViewJumpPlugin", 2, "webview is null");
                return true;
              }
              localObject = this.jdField_a_of_type_ComTencentSmttSdkWebView.getUrl();
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                paramString2 = Util.b(paramString1, new String[0]);
                paramString1 = paramString2;
                if (paramString2.length() > 512) {
                  paramString1 = paramString2.substring(0, 512);
                }
                ReportController.b(null, "P_CliOper", "BizTechReport", "", "webview_jump", "http_jumpaction", 0, 1, 0, Util.b((String)localObject, new String[0]), paramString1, "", "");
              }
              return false;
            }
            if (!paramString1.startsWith("mqqapi://readinjoy")) {
              break;
            }
            paramString1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString1);
            bool1 = bool2;
          } while (paramString1 == null);
          paramString1.a("webview");
          paramString1.b();
          return true;
          if ((paramString1.startsWith("mqqapi://")) || (paramString1.startsWith("qqfav://operation/")))
          {
            paramString2 = new Intent(this.mRuntime.a(), JumpActivity.class);
            paramString2.setData(Uri.parse(paramString1));
            paramString2.putExtra("from", "webview");
            a(paramString2);
            return true;
          }
          if (!paramString1.startsWith("qb")) {
            break;
          }
          bool1 = bool2;
        } while (a(paramString1, false));
        bool1 = bool2;
      } while (this.mRuntime == null);
      bool1 = bool2;
    } while (this.mRuntime.a() == null);
    paramString1 = MttLoader.getValidQBUrl(this.mRuntime.a(), paramString1);
    if ((this.jdField_a_of_type_ComTencentSmttSdkWebView == null) && (QLog.isColorLevel()))
    {
      QLog.d("WebViewJumpPlugin", 2, "webview is null");
      return true;
    }
    this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramString1);
    return true;
    if ((paramString1.startsWith("mqqflyticket://")) || (QRUtils.b(paramString1)))
    {
      b(paramString1);
      return true;
    }
    if (paramString1.startsWith("mqqwpa://im"))
    {
      paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
      paramString1.addFlags(268435456);
      paramString1.putExtra("from", "webview");
      a(paramString1);
      return true;
    }
    if (paramString1.startsWith("mqqapi://pay_for_emosm_success"))
    {
      paramString1 = this.mRuntime.a();
      if (paramString1 != null)
      {
        paramString1.setResult(8213);
        paramString1.finish();
      }
    }
    for (;;)
    {
      return false;
      if (paramString1.startsWith("mqqapi://od"))
      {
        a(paramString1);
      }
      else
      {
        if (paramString1.startsWith("http://mp.qzone.qq.com/u/"))
        {
          paramString2 = URLUtil.a(paramString1);
          if (paramString2.containsKey("uin")) {
            paramString1 = (String)paramString2.get("uin");
          }
          for (;;)
          {
            try
            {
              long l = Long.parseLong(paramString1);
              paramString1 = QZoneHelper.QZoneFamousSpaceHomeConstants.a();
              if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "handleJumpToFamousSpace-->famous uin:" + l + ",actionUrl:" + paramString1);
              }
              paramString2 = this.mRuntime.a();
              localObject = new Intent();
              ((Intent)localObject).putExtra("qqid", l);
              ((Intent)localObject).putExtra("refer", "famous");
              ((Intent)localObject).putExtra("famous_space_webview_url", paramString1);
              QzonePluginProxyActivity.a((Intent)localObject, "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity");
              QzonePluginProxyActivity.a(paramString2, this.mRuntime.a().getAccount(), (Intent)localObject, 0);
              new Handler().postDelayed(new wkj(this), 2000L);
              return true;
            }
            catch (NumberFormatException paramString1)
            {
              paramString1.printStackTrace();
            }
            break;
            i = paramString1.lastIndexOf('?');
            if (i != -1) {
              paramString1 = paramString1.substring("http://mp.qzone.qq.com/u/".length(), i);
            } else {
              paramString1 = paramString1.substring("http://mp.qzone.qq.com/u/".length());
            }
          }
        }
        if ((!paramString1.startsWith("mqqconferenceflyticket://")) || (this.mRuntime.a() == null)) {}
      }
    }
  }
  
  public void onActivityReady()
  {
    if ((this.mRuntime.a() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.mRuntime.a());
    }
    this.jdField_a_of_type_ComTencentSmttSdkWebView = this.mRuntime.a();
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramByte == 3)
    {
      if (paramInt != -1) {
        break label129;
      }
      if ((this.jdField_a_of_type_Boolean) && (paramIntent != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
      {
        str = paramIntent.getStringExtra("callback_type");
        if (!"javascript".equals(str)) {
          break label79;
        }
        callJs(paramIntent.getStringExtra("callback_name"), new String[] { paramIntent.getStringExtra("callback_data") });
      }
    }
    label79:
    label129:
    while (paramInt != 0)
    {
      String str;
      for (;;)
      {
        this.jdField_a_of_type_Boolean = false;
        return;
        if ("url".equals(str))
        {
          if ((this.jdField_a_of_type_ComTencentSmttSdkWebView == null) && (QLog.isColorLevel()))
          {
            QLog.d("WebViewJumpPlugin", 2, "webview is null");
            return;
          }
          this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramIntent.getStringExtra("callback_url"));
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void onCreate() {}
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramCustomWebView;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webviewplugin\WebViewJumpPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */