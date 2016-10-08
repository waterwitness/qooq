package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qqcard.QQCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

public class QQCardJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "qqcard";
  private static final String TAG = "QQCardJsPlugin";
  
  public QQCardJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "qqcard";
  }
  
  private boolean openQQCard()
  {
    Object localObject = this.mRuntime.a();
    if (localObject != null)
    {
      localObject = new Intent((Context)localObject, QQCardActivity.class);
      ((Intent)localObject).addFlags(67108864);
      this.mRuntime.a().startActivity((Intent)localObject);
    }
    return true;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {}
    do
    {
      do
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("QQCardJsPlugin", 2, "handleJsRequest pkgName=" + paramString2 + " method=" + paramString3);
        }
        if ("qqcard".equals(paramString2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("QQCardJsPlugin", 2, "can not handle objectname:" + paramString2);
      return false;
    } while (!"openQQCard".equals(paramString3));
    return openQQCard();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\QQCardJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */