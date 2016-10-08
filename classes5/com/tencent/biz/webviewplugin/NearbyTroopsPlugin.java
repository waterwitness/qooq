package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class NearbyTroopsPlugin
  extends WebViewPlugin
{
  public static final String a = "NearbyTroopsPlugin";
  public static final String b = "NearbyTroopsPlugin";
  protected static final String c = "setSelectTypeResult";
  
  public NearbyTroopsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "NearbyTroopsPlugin";
  }
  
  protected void a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyTroopsPlugin", 2, "setSelectTypeResult:" + paramString);
        }
        localActivity = this.mRuntime.a();
        localIntent = new Intent();
        try
        {
          paramString = new JSONObject(paramString).getJSONObject("data");
          if (paramString == null) {
            continue;
          }
          localIntent.putExtra("data", paramString.toString());
          localActivity.setResult(-1, localIntent);
          localActivity.finish();
          return;
        }
        catch (Exception paramString)
        {
          if (!QLog.isColorLevel()) {
            break label170;
          }
        }
        QLog.d("NearbyTroopsPlugin", 2, "setSelectTypeResult:" + paramString.toString());
      }
      catch (Exception paramString)
      {
        Activity localActivity;
        Intent localIntent;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearbyTroopsPlugin", 2, "setSelectTypeResult:" + paramString.toString());
        return;
      }
      localActivity.setResult(0, localIntent);
      continue;
      label170:
      paramString = null;
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ("NearbyTroopsPlugin".equals(paramString2))
    {
      bool1 = bool2;
      if ("setSelectTypeResult".equals(paramString3))
      {
        bool1 = bool2;
        if (paramVarArgs.length > 0)
        {
          a(paramVarArgs[0]);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\NearbyTroopsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */