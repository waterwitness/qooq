package cooperation.qzone.webviewplugin.ugcsetting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin;
import org.json.JSONObject;

public class QzoneUgcSettingJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String a = "Qzone";
  private String b;
  
  public QzoneUgcSettingJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = QzoneUgcSettingJsPlugin.class.getSimpleName();
  }
  
  private void a(String paramString)
  {
    Object localObject = this.a.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing()) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return;
        localObject = ((Activity)localObject).getIntent();
      } while (localObject == null);
      localObject = ((Intent)localObject).getExtras();
    } while (localObject == null);
    localObject = UgcSettingUtil.a((Bundle)localObject);
    this.a.callJs(paramString, new String[] { localObject });
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject = this.a.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent();
      localIntent.putExtras(UgcSettingUtil.b(localIntent.getExtras(), paramString1));
      ((Activity)localObject).setResult(-1, localIntent);
    } while (TextUtils.isEmpty(paramString2));
    localObject = localIntent.getStringExtra("key_parse_json_status");
    paramString1 = "{\"ret\":0, \"msg\":\"sucess\"}";
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString1 = "{\"ret\":-1, \"msg\":\"" + (String)localObject + "\"}";
    }
    this.a.callJs(paramString2, new String[] { paramString1 });
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str1 = paramString.getString("type");
      String str2 = paramString.getString("value");
      long l = paramString.getLong("uin");
      paramString.getString("callback");
      RemoteHandleManager.a().a().a(str1, str2, l);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e(this.b, 1, "error process friend setting json string.", paramString);
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    paramString1 = this.a.mRuntime.a();
    if ((paramString1 == null) || (paramString1.isFinishing()) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      do
      {
        return;
        paramString1 = paramString1.getIntent();
      } while (paramString1 == null);
      paramString1 = paramString1.getExtras();
    } while (paramString1 == null);
    paramString1 = UgcSettingUtil.b(paramString1);
    this.a.callJs(paramString2, new String[] { paramString1 });
  }
  
  private void c(String paramString1, String paramString2)
  {
    Object localObject = this.a.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent();
      localIntent.putExtras(UgcSettingUtil.a(localIntent.getExtras(), paramString1));
      ((Activity)localObject).setResult(-1, localIntent);
    } while (TextUtils.isEmpty(paramString2));
    localObject = localIntent.getStringExtra("key_parse_json_status");
    paramString1 = "{\"ret\":0, \"msg\":\"sucess\"}";
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString1 = "{\"ret\":-1, \"msg\":\"" + (String)localObject + "\"}";
    }
    this.a.callJs(paramString2, new String[] { paramString1 });
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.a == null) || (this.a.mRuntime == null)) {
      return false;
    }
    if ((paramString3.equals("getUgcSetting")) && (paramVarArgs != null) && (paramVarArgs.length >= 1)) {
      try
      {
        a(new JSONObject(paramVarArgs[0]).optString("callback"));
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
    }
    if ((paramString3.equals("setUgcSetting")) && (paramVarArgs != null) && (paramVarArgs.length >= 1)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        c(paramVarArgs[0], paramJsBridgeListener.optString("callback"));
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
    }
    if ((paramString3.equals("getLiveUgcSetting")) && (paramVarArgs != null) && (paramVarArgs.length >= 1)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        b(paramVarArgs[0], paramJsBridgeListener.optString("callback"));
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
    }
    if ((paramString3.equals("setLiveUgcSetting")) && (paramVarArgs != null) && (paramVarArgs.length >= 1)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        a(paramVarArgs[0], paramJsBridgeListener.optString("callback"));
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
    }
    if ((paramString3.equals("UpdateFriendSetting")) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      b(paramVarArgs[0]);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\ugcsetting\QzoneUgcSettingJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */