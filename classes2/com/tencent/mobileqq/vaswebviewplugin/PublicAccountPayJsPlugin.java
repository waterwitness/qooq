package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.open.OpenPayActivity;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountPayJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String PLUGIN_NAMESPACE = "wallet";
  private static final byte REQUET_CODE_PUBLICPAY = 100;
  private static final String TAG = "PublicAccountPayJsPlugin";
  private final String QWALLET_PUBLICPAY;
  private String mPayCallbackSn;
  public long mReportSeq;
  
  public PublicAccountPayJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.QWALLET_PUBLICPAY = "wallet_publicPay";
    this.mPluginNameSpace = "wallet";
  }
  
  private void doPayCallback(String paramString1, int paramInt, String paramString2, Bundle paramBundle)
  {
    paramBundle = new StringBuilder(256);
    paramBundle.append("{ \"retCode\":" + paramInt + ", \"retMsg\":\"" + paramString2 + "\"}");
    if (QLog.isDevelopLevel()) {
      QLog.i("PublicAccountPayJsPlugin", 2, paramBundle.toString());
    }
    callJs(paramString1, new String[] { paramBundle.toString() });
  }
  
  private void doPublicPay(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("extra.key.pay.type", 1);
    localBundle.putInt("extra.key.pay.from", 1);
    localBundle.putInt("extra.key.pay.platform", 2);
    localBundle.putString("appId", PublicAccountH5AbilityPlugin.A);
    String str1 = paramJSONObject.optString("timeStamp");
    String str2 = paramJSONObject.optString("nonceStr");
    String str3 = paramJSONObject.optString("package");
    String str4 = paramJSONObject.optString("signType");
    paramJSONObject = paramJSONObject.optString("paySign");
    String str5 = this.mRuntime.a().getUrl();
    String str6 = DeviceInfoUtil.a(this.mRuntime.a());
    Object localObject = new StringBuilder(128);
    ((StringBuilder)localObject).append("ai=" + PublicAccountH5AbilityPlugin.A);
    ((StringBuilder)localObject).append("&ts=" + str1);
    ((StringBuilder)localObject).append("&ns=" + str2);
    try
    {
      if (!TextUtils.isEmpty(str3)) {
        ((StringBuilder)localObject).append("&pv=" + URLEncoder.encode(str3, "utf-8"));
      }
      if (!TextUtils.isEmpty(str5)) {
        ((StringBuilder)localObject).append("&url=" + URLEncoder.encode(str5, "utf-8"));
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            localException.printStackTrace();
          }
        }
        doPayCallback(this.mPayCallbackSn, -1, "", null);
        VACDReportUtil.a(this.mReportSeq, "parseurl", (String)localObject, 668801, "params error");
      } while (!QLog.isColorLevel());
      QLog.e("Q.qwallet.pay", 2, "PubAccPayJsPlugin.doPublicPay parameters error");
    }
    ((StringBuilder)localObject).append("&st=" + str4);
    ((StringBuilder)localObject).append("&ps=" + paramJSONObject);
    localObject = ((StringBuilder)localObject).toString();
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(paramJSONObject)) && (!TextUtils.isEmpty(str5)) && (!TextUtils.isEmpty(this.mPayCallbackSn)) && (!TextUtils.isEmpty(str6)))
    {
      localBundle.putString("timeStampStr", str1);
      localBundle.putString("nonce", str2);
      localBundle.putString("packageValue", str3);
      localBundle.putString("sigType", str4);
      localBundle.putString("sig", paramJSONObject);
      localBundle.putString("url", str5);
      localBundle.putString("callbackSn", this.mPayCallbackSn);
      localBundle.putString("qVersion", str6);
      localBundle.putLong("vacreport_key_seq", this.mReportSeq);
      VACDReportUtil.a(this.mReportSeq, str3, "parseurl", (String)localObject, 0, null);
      paramJSONObject = new Intent(this.mRuntime.a(), OpenPayActivity.class);
      paramJSONObject.putExtras(localBundle);
      paramJSONObject.addFlags(67108864);
      startActivityForResult(paramJSONObject, (byte)100);
      return;
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return false;
    }
    paramString1 = paramString2 + "_" + paramString3;
    paramJsBridgeListener = paramVarArgs[0];
    if ((paramJsBridgeListener != null) && ("wallet_publicPay".equals(paramString1)))
    {
      this.mReportSeq = VACDReportUtil.a(null, "qqwallet", "pay-public", "payinvoke", null, 0, null);
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " PubAccPayJsPlugin.handleJsRequest params:" + paramJsBridgeListener);
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramJsBridgeListener);
        this.mPayCallbackSn = paramString1.optString("callback");
        paramString2 = AuthorizeConfig.a();
        if ((this.mRuntime != null) && (paramString2.a(this.mRuntime.a().getUrl(), "wallet.publicPay")))
        {
          doPublicPay(paramString1);
          return true;
        }
        try
        {
          paramString1 = URLEncoder.encode(paramJsBridgeListener, "UTF-8");
          VACDReportUtil.a(this.mReportSeq, "parseurl", "p=" + paramString1, 668801, "hasn't right");
          return false;
        }
        catch (Exception paramString1)
        {
          paramString1 = paramJsBridgeListener;
          continue;
        }
        try
        {
          paramString1 = URLEncoder.encode(paramJsBridgeListener, "UTF-8");
          paramJsBridgeListener = paramString1;
        }
        catch (Exception paramString1)
        {
          for (;;) {}
        }
      }
      catch (JSONException paramString1) {}
      VACDReportUtil.a(this.mReportSeq, "parseurl", "p=" + paramJsBridgeListener, 668801, "json exception");
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay", 2, "PubAccPayJsPlugin.handleJsRequest JSONException");
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 100) {
      if (paramIntent == null)
      {
        doPayCallback(this.mPayCallbackSn, -1, "", null);
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.pay", 2, "PubAccPayJsPlugin.onActivityResult intent == null");
        }
      }
    }
    while (!QLog.isDevelopLevel())
    {
      do
      {
        do
        {
          do
          {
            return;
            paramIntent = paramIntent.getExtras();
            if (paramIntent != null) {
              break;
            }
            doPayCallback(this.mPayCallbackSn, -1, "", null);
          } while (!QLog.isColorLevel());
          QLog.e("Q.qwallet.pay", 2, "PubAccPayJsPlugin.onActivityResult data == null");
          return;
          paramInt = paramIntent.getInt("retCode");
          String str1 = paramIntent.getString("retMsg");
          String str2 = paramIntent.getString("callbackSn");
          if (TextUtils.isEmpty(str2)) {
            break;
          }
          doPayCallback(str2, paramInt, str1, paramIntent);
        } while (!QLog.isColorLevel());
        QLog.i("Q.qwallet.pay", 2, "PubAccPayJsPlugin.onActivityResult doCallback");
        return;
      } while (!QLog.isColorLevel());
      QLog.e("Q.qwallet.pay", 2, "PubAccPayJsPlugin.onActivityResult callbackSn is empty");
      return;
    }
    QLog.e("Q.qwallet.pay", 2, "onActivityResult " + paramByte);
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\PublicAccountPayJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */