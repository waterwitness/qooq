package cooperation.qzone.webviewplugin.personalize;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class QZonePersonalizeJsHandleLogic
{
  public static final String a = QZonePersonalizeJsHandleLogic.class.getSimpleName() + QZonePersonalizePlugin.a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return;
    }
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      int i = paramVarArgs.optInt("facade", -1);
      int j = paramVarArgs.optInt("feedskin", -1);
      int k = paramVarArgs.optInt("avatar", -1);
      int m = paramVarArgs.optInt("float", -1);
      int n = paramVarArgs.optInt("customvip", -1);
      paramVarArgs = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "SetPersonalizeFinished");
      localBundle.putInt("facade", i);
      localBundle.putInt("feedskin", j);
      localBundle.putInt("avatar", k);
      localBundle.putInt("floatObject", m);
      localBundle.putInt("customvip", n);
      paramVarArgs.putExtras(localBundle);
      QZoneHelper.a(paramPluginRuntime.a(), QZoneHelper.UserInfo.a(), paramVarArgs);
      return;
    }
    catch (JSONException paramPluginRuntime) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\personalize\QZonePersonalizeJsHandleLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */