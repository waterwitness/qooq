package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.JsWebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.net.URLEncoder;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class PayJsPlugin
  extends JsWebViewPlugin
{
  public static final String a = "JsBridge.JsHandle.PayJsHandler";
  public static final String b = "pay";
  protected long a;
  Activity jdField_a_of_type_AndroidAppActivity;
  protected Bundle a;
  protected PayJsPlugin.MyResultRecevicer a;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private boolean jdField_a_of_type_Boolean;
  public long b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  private final String j;
  private final String k;
  private final String l;
  private final String m;
  
  public PayJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = "pay";
    this.d = "openTenpayView";
    this.e = "openService";
    this.f = "buyGoods";
    this.g = "rechargeGameCurrency";
    this.h = "rechargeQb";
    this.i = "preparePay";
    this.j = "subscribeMonthCardPay";
    this.k = "getQBRecord";
    this.l = "closeFullWindow";
    this.m = "launchWechatPaySign";
  }
  
  private void a(String paramString)
  {
    Intent localIntent = new Intent("cn.abel.action.broadcast");
    BaseApplicationImpl.a.sendBroadcast(localIntent);
    try
    {
      paramString = new JSONObject(paramString).optString("url");
      if (!TextUtils.isEmpty(paramString))
      {
        localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", paramString);
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      }
      ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "index.layila.intopage", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  private void b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("PayInvokerId", 16);
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(str);; localObject = "")
    {
      localBundle.putString("uin", str);
      localBundle.putString("skey", (String)localObject);
      localBundle.putString("reqData", paramString);
      if (this.jdField_a_of_type_ComTencentBizWebviewpluginPayJsPlugin$MyResultRecevicer != null)
      {
        paramString = Parcel.obtain();
        this.jdField_a_of_type_ComTencentBizWebviewpluginPayJsPlugin$MyResultRecevicer.writeToParcel(paramString, 0);
        paramString.setDataPosition(0);
        localObject = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString);
        paramString.recycle();
        localBundle.putParcelable("_qwallet_payresult_receiver", (Parcelable)localObject);
      }
      QWalletPayBridge.a(BaseApplicationImpl.a, this.jdField_a_of_type_ComTencentCommonAppAppInterface, localBundle);
      return;
    }
  }
  
  protected String a()
  {
    return "pay";
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "pay requet preparePay");
    }
    if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {}
    while (QWalletHelper.a(this.mRuntime.a())) {
      return;
    }
    Intent localIntent = new Intent("cooperation.qwallet.QWALLET_PRELOAD");
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "qwallet_plugin.apk";
    localPluginParams.d = "Wallet";
    localPluginParams.e = "com.qwallet.receiver.QWallPreloadReceiver";
    localPluginParams.a = localIntent;
    IPluginManager.a(this.mRuntime.a(), localPluginParams);
  }
  
  protected void a(int paramInt, String paramString, JsBridgeListener paramJsBridgeListener)
  {
    paramJsBridgeListener = String.valueOf(paramJsBridgeListener.a());
    Bundle localBundle = new Bundle();
    localBundle.putString("payparmas_callback_sn", paramJsBridgeListener);
    localBundle.putString("payparmas_json", paramString);
    localBundle.putInt("payparmas_paytype", 1);
    localBundle.putLong("payparmas_h5_start", this.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidOsBundle = PayBridgeActivity.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizWebviewpluginPayJsPlugin$MyResultRecevicer, paramInt, localBundle);
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("retCode", -1) != 0)
    {
      paramString = this.jdField_a_of_type_AndroidOsBundle.getString("retJson");
      if (paramString != null) {
        callJs(paramJsBridgeListener, new String[] { paramString });
      }
    }
  }
  
  protected void a(String paramString, JsBridgeListener paramJsBridgeListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "openTenpayView requet params json=" + paramString);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramString);
    localBundle.putString("callbackSn", String.valueOf(paramJsBridgeListener.a()));
    localBundle.putInt("payparmas_paytype", 1);
    localBundle.putLong("payparmas_h5_start", this.jdField_a_of_type_Long);
    PayBridgeActivity.a(this.jdField_a_of_type_AndroidAppActivity, 5, localBundle);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.callJs("javascript:window.JsBridge&&JsBridge.callback('" + paramString1 + "',{'r':0,'result':" + paramString2 + "});");
  }
  
  protected void b(String paramString, JsBridgeListener paramJsBridgeListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "pay requet params json=" + paramString);
    }
    Object localObject4;
    Object localObject1;
    Object localObject2;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      localObject4 = this.mRuntime.a();
      localObject1 = "";
      if (localObject4 != null) {
        localObject1 = ((CustomWebView)localObject4).getUrl();
      }
      localObject2 = localObject1;
    }
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = URLEncoder.encode((String)localObject1, "utf-8");
      }
      Object localObject3 = "";
      localObject1 = localObject3;
      if (localObject4 != null)
      {
        localObject4 = ((CustomWebView)localObject4).copyBackForwardList();
        localObject1 = localObject3;
        if (((WebBackForwardList)localObject4).getSize() >= 1)
        {
          localObject4 = ((WebBackForwardList)localObject4).getItemAtIndex(0).getOriginalUrl();
          localObject1 = localObject3;
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            int i2 = ((String)localObject4).indexOf("qqwallet_appinfo=");
            localObject1 = localObject3;
            if (i2 != -1)
            {
              int i1 = ((String)localObject4).indexOf('&', "qqwallet_appinfo=".length() + i2);
              int n = i1;
              if (i1 == -1) {
                n = ((String)localObject4).length();
              }
              localObject1 = ((String)localObject4).substring(i2 + "qqwallet_appinfo=".length(), n);
            }
          }
        }
      }
      paramJsBridgeListener = String.valueOf(paramJsBridgeListener.a());
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("payparmas_callback_sn", paramJsBridgeListener);
      ((Bundle)localObject3).putString("payparmas_json", paramString);
      ((Bundle)localObject3).putInt("payparmas_paytype", 1);
      ((Bundle)localObject3).putLong("payparmas_h5_start", this.jdField_a_of_type_Long);
      ((Bundle)localObject3).putString("payparmas_url_appinfo", (String)localObject1);
      ((Bundle)localObject3).putLong("vacreport_key_seq", this.b);
      ((Bundle)localObject3).putString("payparmas_h5_url", (String)localObject2);
      this.jdField_a_of_type_AndroidOsBundle = PayBridgeActivity.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizWebviewpluginPayJsPlugin$MyResultRecevicer, 9, (Bundle)localObject3);
      if (this.jdField_a_of_type_AndroidOsBundle.getInt("retCode", -1) != 0)
      {
        paramString = this.jdField_a_of_type_AndroidOsBundle.getString("retJson");
        if (paramString != null) {
          callJs(paramJsBridgeListener, new String[] { paramString });
        }
        VACDReportUtil.a(this.b, "parseurl", null, 668801, paramString);
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject2 = localObject1;
        if (QLog.isDevelopLevel())
        {
          localException.printStackTrace();
          localObject2 = localObject1;
        }
      }
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!a().equals(paramString2)) {
      return false;
    }
    if ("pay".equals(paramString3)) {
      this.b = VACDReportUtil.a(null, "qqwallet", "pay-h5", "payinvoke", null, 0, null);
    }
    paramString2 = "";
    paramString1 = paramString2;
    if (paramVarArgs != null)
    {
      paramString1 = paramString2;
      if (paramVarArgs.length > 0)
      {
        paramString1 = paramString2;
        if (!TextUtils.isEmpty(paramVarArgs[0])) {
          paramString1 = paramVarArgs[0];
        }
      }
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + this.jdField_a_of_type_Long + " PayJsPlugin.handleJsRequest params:" + paramString1);
    }
    if ((paramString1 != null) && ("pay".equals(paramString3))) {
      b(paramString1, paramJsBridgeListener);
    }
    for (;;)
    {
      return true;
      if ((paramString1 != null) && ("openTenpayView".equals(paramString3)))
      {
        a(paramString1, paramJsBridgeListener);
      }
      else if ((paramString1 != null) && ("openService".equals(paramString3)))
      {
        a(4, paramString1, paramJsBridgeListener);
      }
      else if ((paramString1 != null) && ("buyGoods".equals(paramString3)))
      {
        a(7, paramString1, paramJsBridgeListener);
      }
      else if ((paramString1 != null) && ("rechargeGameCurrency".equals(paramString3)))
      {
        a(6, paramString1, paramJsBridgeListener);
      }
      else if ((paramString1 != null) && ("rechargeQb".equals(paramString3)))
      {
        a(8, paramString1, paramJsBridgeListener);
      }
      else if ((paramString1 != null) && ("subscribeMonthCardPay".equals(paramString3)))
      {
        a(14, paramString1, paramJsBridgeListener);
      }
      else if ((paramString1 != null) && ("launchWechatPaySign".equals(paramString3)))
      {
        a(17, paramString1, paramJsBridgeListener);
      }
      else if ("preparePay".equals(paramString3))
      {
        a();
      }
      else if ((paramString1 != null) && ("getQBRecord".equals(paramString3)))
      {
        b(paramString1);
      }
      else
      {
        if (!"closeFullWindow".equals(paramString3)) {
          break;
        }
        a(paramString1);
      }
    }
  }
  
  public void onCreate()
  {
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
    this.jdField_a_of_type_ComTencentBizWebviewpluginPayJsPlugin$MyResultRecevicer = new PayJsPlugin.MyResultRecevicer(this, new Handler());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\PayJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */