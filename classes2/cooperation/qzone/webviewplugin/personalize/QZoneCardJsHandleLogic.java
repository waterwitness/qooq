package cooperation.qzone.webviewplugin.personalize;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneCardJsHandleLogic
{
  public static final String a = QZoneCardJsHandleLogic.class.getSimpleName() + QZonePersonalizePlugin.a;
  public static final String b = "QZoneCardLogic";
  public static final String c = "key_personalize_prefix";
  public static final String d = "key_personalize_prefix_18";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    str2 = "";
    String str1 = "";
    Object localObject1 = str1;
    localObject2 = str2;
    if (paramVarArgs != null)
    {
      localObject1 = str1;
      localObject2 = str2;
      if (paramVarArgs.length > 0) {
        localObject1 = str1;
      }
    }
    try
    {
      localObject2 = new JSONObject(paramVarArgs[0]);
      localObject1 = str1;
      paramVarArgs = ((JSONObject)localObject2).getString("cardid");
      localObject1 = paramVarArgs;
      localObject2 = ((JSONObject)localObject2).getString("cardurl");
      localObject1 = paramVarArgs;
    }
    catch (JSONException paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
        localObject2 = str2;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneCardLogic." + a, 4, "handleDownCardMethod js give download cardurl is: " + (String)localObject2 + "\t cardid:" + (String)localObject1);
    }
    paramVarArgs = new Intent("action_personalize_js2qzone");
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("cmd", "downloadcard");
    ((Bundle)localObject1).putString("cardDownloadUrl", (String)localObject2);
    paramVarArgs.putExtras((Bundle)localObject1);
    QZoneHelper.a(paramPluginRuntime.a(), QZoneHelper.UserInfo.a(), paramVarArgs);
  }
  
  public static void a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    String str11 = "";
    String str9 = "";
    String str10 = "";
    long l2 = 0L;
    String str7 = "";
    int m = 0;
    int i2 = 0;
    String str8 = "";
    int n = 0;
    int i3 = 0;
    String str6 = "";
    i1 = 0;
    i = i1;
    String str1 = str6;
    int j = i3;
    String str3 = str8;
    int k = i2;
    String str5 = str7;
    long l1 = l2;
    String str4 = str10;
    String str2 = str9;
    paramWebViewPlugin = str11;
    if (paramVarArgs != null)
    {
      i = i1;
      str1 = str6;
      j = i3;
      str3 = str8;
      k = i2;
      str5 = str7;
      l1 = l2;
      str4 = str10;
      str2 = str9;
      paramWebViewPlugin = str11;
      if (paramVarArgs.length > 0)
      {
        str1 = str6;
        j = n;
        str3 = str8;
        k = m;
        str5 = str7;
        l1 = l2;
        str4 = str10;
        str2 = str9;
      }
    }
    for (paramWebViewPlugin = str11;; paramWebViewPlugin = paramVarArgs)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramVarArgs[0]);
        str1 = str6;
        j = n;
        str3 = str8;
        k = m;
        str5 = str7;
        l1 = l2;
        str4 = str10;
        str2 = str9;
        paramWebViewPlugin = str11;
        paramVarArgs = localJSONObject.getString("result");
        str1 = str6;
        j = n;
        str3 = str8;
        k = m;
        str5 = str7;
        l1 = l2;
        str4 = str10;
        str2 = str9;
        paramWebViewPlugin = paramVarArgs;
        str10 = localJSONObject.getString("sPicUrl");
        str1 = str6;
        j = n;
        str3 = str8;
        k = m;
        str5 = str7;
        l1 = l2;
        str4 = str10;
        str2 = str9;
        paramWebViewPlugin = paramVarArgs;
        str9 = localJSONObject.getString("sSkinId");
        str1 = str6;
        j = n;
        str3 = str8;
        k = m;
        str5 = str7;
        l1 = l2;
        str4 = str10;
        str2 = str9;
        paramWebViewPlugin = paramVarArgs;
        str8 = localJSONObject.getString("strTraceInfo");
        str1 = str6;
        j = n;
        str3 = str8;
        k = m;
        str5 = str7;
        l1 = l2;
        str4 = str10;
        str2 = str9;
        paramWebViewPlugin = paramVarArgs;
        str7 = localJSONObject.getString("title");
        str1 = str6;
        j = n;
        str3 = str8;
        k = m;
        str5 = str7;
        l1 = l2;
        str4 = str10;
        str2 = str9;
        paramWebViewPlugin = paramVarArgs;
        l2 = localJSONObject.getLong("uiSettleTime");
        str1 = str6;
        j = n;
        str3 = str8;
        k = m;
        str5 = str7;
        l1 = l2;
        str4 = str10;
        str2 = str9;
        paramWebViewPlugin = paramVarArgs;
        m = localJSONObject.getInt("vip_property");
        str1 = str6;
        j = n;
        str3 = str8;
        k = m;
        str5 = str7;
        l1 = l2;
        str4 = str10;
        str2 = str9;
        paramWebViewPlugin = paramVarArgs;
        n = localJSONObject.optInt("type");
        str1 = str6;
        j = n;
        str3 = str8;
        k = m;
        str5 = str7;
        l1 = l2;
        str4 = str10;
        str2 = str9;
        paramWebViewPlugin = paramVarArgs;
        str6 = localJSONObject.optString("musicurl");
        str1 = str6;
        j = n;
        str3 = str8;
        k = m;
        str5 = str7;
        l1 = l2;
        str4 = str10;
        str2 = str9;
        paramWebViewPlugin = paramVarArgs;
        i = localJSONObject.optInt("need_jump");
        if (i != 1) {
          break label969;
        }
        i = 1;
        paramWebViewPlugin = paramVarArgs;
        str2 = str9;
        str4 = str10;
        l1 = l2;
        str5 = str7;
        k = m;
        str3 = str8;
        j = n;
        str1 = str6;
      }
      catch (JSONException paramVarArgs)
      {
        for (;;)
        {
          label969:
          paramVarArgs.printStackTrace();
          i = i1;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneCardLogic." + a, 4, "handleSetSkinFinish result:" + paramWebViewPlugin + "js give cardurl is: " + str4 + "\t cardid:" + str2);
      }
      if (paramWebViewPlugin.equals("success"))
      {
        paramWebViewPlugin = new Intent("action_personalize_js2qzone");
        paramVarArgs = new Bundle();
        paramVarArgs.putString("sSkinId", str2);
        paramVarArgs.putLong("lUin", 0L);
        paramVarArgs.putString("sPicUrl", str4);
        paramVarArgs.putLong("lTime", l1);
        paramVarArgs.putString("desc", "");
        paramVarArgs.putString("title", str5);
        paramVarArgs.putInt("vip_property", k);
        paramVarArgs.putString("strTraceInfo", str3);
        paramVarArgs.putInt("type", j);
        paramVarArgs.putString("musicurl", str1);
        paramVarArgs.putString("cmd", "setcardfinish");
        paramWebViewPlugin.putExtras(paramVarArgs);
        if (QLog.isDevelopLevel()) {
          QLog.d("QZoneCardLogic." + a, 4, "handleSetSkinFinish broadcast actionString: " + paramWebViewPlugin.getAction() + "to qzone process" + ",card lTime:" + l1 + ",type:" + j + ",musicurl:" + str1);
        }
        QZoneHelper.a(paramPluginRuntime.a(), QZoneHelper.UserInfo.a(), paramWebViewPlugin);
        LocalMultiProcConfig.a("key_personalize_prefix_18", 0, Long.valueOf(paramPluginRuntime.a().a()).longValue());
        if (i != 0) {
          QZoneHelper.a(paramPluginRuntime.a(), QZoneHelper.UserInfo.a(), paramPluginRuntime.a().getAccount(), 0, 0, 256);
        }
      }
      return;
      i = 0;
      str1 = str6;
      j = n;
      str3 = str8;
      k = m;
      str5 = str7;
      l1 = l2;
      str4 = str10;
      str2 = str9;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\personalize\QZoneCardJsHandleLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */