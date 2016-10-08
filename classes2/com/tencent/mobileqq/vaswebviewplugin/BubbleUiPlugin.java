package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.os.Handler;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class BubbleUiPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "BubbleUiPlugin";
  Client.onRemoteRespObserver mOnRemoteResp;
  
  public BubbleUiPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mOnRemoteResp = new BubbleUiPlugin.2(this);
  }
  
  private void reportBubbleSetting()
  {
    new Handler().postDelayed(new BubbleUiPlugin.1(this), 1000L);
  }
  
  void OnActivityDestroy()
  {
    super.OnActivityDestroy();
    WebIPCOperator.a().b(this.mOnRemoteResp);
  }
  
  void OnActivityResume()
  {
    super.OnActivityResume();
    WebIPCOperator.a().a(this.mOnRemoteResp);
    if (WebIPCOperator.a().a())
    {
      reportBubbleSetting();
      if (QLog.isColorLevel()) {
        QLog.i("BubbleUiPlugin", 2, "OnActivityResume -> loading url");
      }
    }
    do
    {
      return;
      this.isHomePageWatingBind = true;
    } while (!QLog.isColorLevel());
    QLog.i("BubbleUiPlugin", 2, "OnActivityResume -> loadurl waiting binding");
  }
  
  protected long getPluginBusiness()
  {
    return 64L;
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleUiPlugin", 2, "BaseWebActivity onActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return false;
    }
    try
    {
      String str = paramIntent.getStringExtra("callbackSn");
      paramIntent = paramIntent.getStringExtra("result");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("responseId", str);
      localJSONObject.put("responseData", new JSONObject(paramIntent));
      if (QLog.isColorLevel()) {
        QLog.i("BubbleUiPlugin", 2, "BaseWebActivity loadUrl setMessage =" + localJSONObject.toString());
      }
      this.mRuntime.a().loadUrl("javascript:window.qqJSBridge&&qqJSBridge.setMessage('" + localJSONObject.toString() + "');");
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\BubbleUiPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */