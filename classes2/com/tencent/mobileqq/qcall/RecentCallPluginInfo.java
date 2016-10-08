package com.tencent.mobileqq.qcall;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentT9SearchActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

public class RecentCallPluginInfo
  extends WebViewPlugin
{
  public static final String a = "RecentCall";
  public static final String b = "recent_t9_search";
  public static final String c = "recent_selectmember";
  private static final String d = "RecentCallPluginInfo";
  
  public RecentCallPluginInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "RecentCall";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentCallPluginInfo", 2, "RecentCallPluginInfo  handleJsRequest url : " + paramString1 + ",pkgName: " + paramString2 + ",method: " + paramString3);
    }
    if (TextUtils.isEmpty(paramString3)) {
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
    }
    if ("recent_t9_search".equals(paramString3))
    {
      paramJsBridgeListener = new Intent(this.mRuntime.a(), RecentT9SearchActivity.class);
      paramJsBridgeListener.putExtra("key_is_from_web", true);
      this.mRuntime.a().startActivity(paramJsBridgeListener);
      return true;
    }
    if ("recent_selectmember".equals(paramString3))
    {
      paramJsBridgeListener = this.mRuntime.a();
      paramString1 = new Intent(paramJsBridgeListener, QCallStartBrigeActivity.class);
      paramString1.putExtra("param_from_type", 1);
      paramJsBridgeListener.startActivity(paramString1);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\RecentCallPluginInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */