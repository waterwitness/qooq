package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneAlbumSelectJSPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String a = "Qzone";
  private static final String b = QzoneBlogJsPlugin.class.getSimpleName();
  private static String c = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      c = paramArrayOfString.getString("callback");
      paramPluginRuntime = new Bundle();
      paramPluginRuntime.putInt("key_personal_album_enter_model", 0);
      paramPluginRuntime.putBoolean("key_pass_result_by_bundle", true);
      paramPluginRuntime.putString("key_accept_album_anonymity", paramArrayOfString.optString("acceptType"));
      paramPluginRuntime.putString("key_deny_delect_tips", paramArrayOfString.optString("denyTips"));
      paramPluginRuntime.putBoolean("key_can_new_album", false);
      paramArrayOfString = QZoneHelper.UserInfo.a();
      paramArrayOfString.a = this.a.mRuntime.a().a();
      QZoneHelper.a(this.a.mRuntime.a(), paramArrayOfString, paramPluginRuntime, QZoneHelper.a(this.a, this.a.mRuntime, 7));
      return;
    }
    catch (Exception paramPluginRuntime)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w(b, 2, "handlePickQzoneAlbum,decode param error");
    }
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    switch (paramByte)
    {
    }
    do
    {
      return;
    } while ((TextUtils.isEmpty(c)) || (paramIntent == null));
    String str1 = paramIntent.getStringExtra("key_selected_albuminfo.id");
    String str2 = paramIntent.getStringExtra("key_selected_albuminfo.name");
    paramIntent.getStringExtra("key_selected_albuminfo.cover");
    paramIntent.getIntExtra("key_selected_albuminfo.permission", 0);
    paramByte = paramIntent.getIntExtra("key_selected_albuminfo.type", 0);
    paramInt = paramIntent.getIntExtra("key_selected_albuminfo.anonymity", 0);
    paramIntent = new JSONObject();
    try
    {
      paramIntent.put("albumid", str1);
      paramIntent.put("albumtype", paramByte);
      paramIntent.put("albumname", str2);
      paramIntent.put("albumanonymity", paramInt);
      if (QLog.isDevelopLevel()) {
        QLog.d(b, 4, paramIntent.toString());
      }
      this.a.callJs(c, new String[] { paramIntent.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.a == null) || (this.a.mRuntime == null)) {}
    while (!paramString3.equalsIgnoreCase("PickQzoneAlbum")) {
      return false;
    }
    a(this.a.mRuntime, paramVarArgs);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QzoneAlbumSelectJSPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */