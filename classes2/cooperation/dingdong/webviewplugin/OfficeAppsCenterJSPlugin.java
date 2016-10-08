package cooperation.dingdong.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.dingdong.data.OfficeCenterSharedPref;
import org.json.JSONObject;

public class OfficeAppsCenterJSPlugin
  extends WebViewPlugin
{
  public static final String a = "officeAppsCenter";
  public static final String b = "OfficeAppsCenterJSPlugin";
  private static final String c = "callback";
  private OfficeAppsCenterJSPlugin.OfficeAppsCenterBCReceiver a;
  
  public OfficeAppsCenterJSPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "officeAppsCenter";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfficeAppsCenterJSPlugin", 1, "handleJsRequest");
    }
    if ((paramString1 == null) || (!"officeAppsCenter".equals(paramString2)) || (paramString3 == null)) {
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
    }
    String str;
    try
    {
      Object localObject = new JSONObject(paramVarArgs[0]);
      if (((JSONObject)localObject).has("callback")) {}
      for (localObject = ((JSONObject)localObject).getString("callback"); (localObject == null) || (((String)localObject).length() == 0); localObject = "")
      {
        QLog.i("OfficeAppsCenterJSPlugin", 1, "no callback id, args: " + paramVarArgs.toString());
        return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        str = "";
      }
    }
    if (paramString3.equals("addApp"))
    {
      paramJsBridgeListener = "";
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        if (!paramString1.has("id")) {
          break label254;
        }
        paramString1 = paramString1.getString("id");
        paramJsBridgeListener = paramString1;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          QLog.e("OfficeAppsCenterJSPlugin", 1, "failed to parse addApp id param.");
        }
      }
      paramString1 = new Bundle();
      paramString1.putLong("appId", Long.valueOf(paramJsBridgeListener).longValue());
      paramString1.putString("callback", str);
      paramJsBridgeListener = new Intent();
      paramJsBridgeListener.putExtra("reqCode", 1);
      paramJsBridgeListener.putExtra("reqData", paramString1);
      DingdongPluginHelper.a(2, paramJsBridgeListener);
    }
    for (;;)
    {
      return true;
      label254:
      paramJsBridgeListener = "";
      break;
      if (paramString3.equals("openApp")) {
        for (paramJsBridgeListener = "";; paramJsBridgeListener = "")
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            if (!paramString1.has("id")) {
              continue;
            }
            paramString1 = paramString1.getString("id");
            paramJsBridgeListener = paramString1;
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              paramString1.printStackTrace();
            }
          }
          paramString1 = new Bundle();
          paramString1.putLong("appId", Long.valueOf(paramJsBridgeListener).longValue());
          paramString1.putString("callback", str);
          paramJsBridgeListener = new Intent();
          paramJsBridgeListener.putExtra("reqCode", 2);
          paramJsBridgeListener.putExtra("reqData", paramString1);
          DingdongPluginHelper.a(2, paramJsBridgeListener);
          break;
        }
      }
      if (paramString3.equals("getInstalledApps"))
      {
        paramJsBridgeListener = OfficeCenterSharedPref.a().a("officecenter_user_apps_list_txt_" + this.mRuntime.a().getLongAccountUin(), "");
        QLog.i("OfficeAppsCenterJSPlugin", 1, "getInstalledApps, " + paramJsBridgeListener);
        callJs(str, new String[] { "{\"installedAppidList\":[" + paramJsBridgeListener + "]}" });
      }
      else if (paramString3.equals("getSystemSupportedApps"))
      {
        paramJsBridgeListener = OfficeCenterSharedPref.a().a("officecenter_sys_supported_apps_list_txt", "");
        QLog.i("OfficeAppsCenterJSPlugin", 1, "getSystemSupportedApps, " + paramJsBridgeListener);
        callJs(str, new String[] { "{\"systemSupportedAppidList\":[" + paramJsBridgeListener + "]}" });
      }
      else if (paramString3.equals("reportData"))
      {
        QLog.i("OfficeAppsCenterJSPlugin", 1, "reportData, args: " + paramVarArgs.toString());
        for (paramJsBridgeListener = "";; paramJsBridgeListener = "")
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            if (!paramString1.has("id")) {
              continue;
            }
            paramString1 = paramString1.getString("id");
            paramJsBridgeListener = paramString1;
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              paramString1.printStackTrace();
            }
          }
          if (paramJsBridgeListener.length() <= 0) {
            break label720;
          }
          DingdongPluginHelper.a(paramJsBridgeListener);
          if ((str == null) || (str.length() <= 0)) {
            break;
          }
          callJs(str, new String[] { "true" });
          break;
        }
        label720:
        if ((str != null) && (str.length() > 0)) {
          callJs(str, new String[] { "false" });
        }
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.a = new OfficeAppsCenterJSPlugin.OfficeAppsCenterBCReceiver(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    this.mRuntime.a().registerReceiver(this.a, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
  }
  
  protected void onDestroy()
  {
    this.mRuntime.a().unregisterReceiver(this.a);
    super.onDestroy();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\dingdong\webviewplugin\OfficeAppsCenterJSPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */