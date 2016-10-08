package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;

public class PayJsPlugin$MyResultRecevicer
  extends ResultReceiver
{
  protected PayJsPlugin a;
  
  public PayJsPlugin$MyResultRecevicer(PayJsPlugin paramPayJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramPayJsPlugin;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if ((this.a == null) || (paramBundle == null)) {}
    String str1;
    do
    {
      boolean bool;
      do
      {
        do
        {
          return;
          switch (paramInt)
          {
          case 5: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 15: 
          default: 
            return;
          case 4: 
          case 6: 
          case 7: 
          case 8: 
          case 14: 
          case 17: 
            str1 = paramBundle.getString("callbackSn");
            paramBundle = paramBundle.getString("result");
          }
        } while ((this.a.mRuntime == null) || (this.a.mRuntime.a() == null) || (str1 == null) || (paramBundle == null));
        this.a.mRuntime.a().loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + str1 + "',{'r':0,'result':" + paramBundle + "});");
        return;
        str1 = paramBundle.getString("callbackSn");
        String str2 = paramBundle.getString("result");
        String str3 = paramBundle.getString("upload_data");
        bool = paramBundle.getBoolean("isChoosePubAcc", false);
        paramBundle = paramBundle.getString("pubAcc");
        if ((this.a.mRuntime != null) && (this.a.mRuntime.a() != null) && (str1 != null) && (str2 != null)) {
          this.a.mRuntime.a().loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + str1 + "',{'r':0,'result':" + str2 + "});");
        }
        if ((str3 != null) && (str3.length() > 0)) {
          PayBridgeActivity.a(this.a.a, str3);
        }
      } while ((!bool) || (this.a.a == null) || (TextUtils.isEmpty(paramBundle)));
      PublicAccountUtil.a(this.a.a, this.a.a.a(), paramBundle, null, false);
      return;
      str1 = paramBundle.getString("callback");
      paramBundle = paramBundle.getString("retData");
    } while ((this.a.mRuntime == null) || (this.a.mRuntime.a() == null) || (str1 == null) || (paramBundle == null));
    this.a.a(str1, paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\PayJsPlugin$MyResultRecevicer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */