package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneSettingJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final int a = 0;
  public static final String a;
  public static final int b = 1;
  public static final String b = "Qzone";
  public static final int c = 2;
  public static final int d = 3;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = QzoneSettingJsPlugin.class.getSimpleName();
  }
  
  private boolean a(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    Activity localActivity;
    do
    {
      return false;
      localActivity = paramWebViewPlugin.mRuntime.a();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    long l = paramWebViewPlugin.mRuntime.a().getLongAccountUin();
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        continue;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 4, "---handleShowQzoneRemindfeedSetting-:" + bool);
      LocalMultiProcConfig.a(localActivity.getString(2131368470) + l, bool);
      return true;
      bool = true;
    }
  }
  
  private boolean b(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    Activity localActivity;
    do
    {
      return false;
      localActivity = paramWebViewPlugin.mRuntime.a();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    long l = paramWebViewPlugin.mRuntime.a().getLongAccountUin();
    paramWebViewPlugin = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      paramWebViewPlugin = paramArrayOfString;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        boolean bool;
        paramArrayOfString.printStackTrace();
      }
    }
    bool = LocalMultiProcConfig.a(localActivity.getString(2131368470) + l, false);
    if (bool) {
      i = 1;
    }
    paramWebViewPlugin = "window." + paramWebViewPlugin + "({new_value:" + i + "})";
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramWebViewPlugin);
    QLog.i(jdField_a_of_type_JavaLangString, 4, "---handleShowQzoneRemindfeedGet-:" + bool);
    return true;
  }
  
  private boolean c(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        bool = true;
        continue;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 4, "---handleVideoPlayModeSetting-:" + bool);
      LocalMultiProcConfig.b("QZ_setting", "Qzone_setVideoplay", bool);
      paramWebViewPlugin.sendBroadcast(new Intent("com.tencent.qq.VideoPlaySetting"));
      return true;
      bool = true;
    }
  }
  
  private boolean d(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.a();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.a("QZ_setting", "Qzone_setVideoplay", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i(jdField_a_of_type_JavaLangString, 4, "---handleVideoPlayModeGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean e(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    try
    {
      int j = new JSONObject(paramArrayOfString[0]).getInt("new_value");
      i = j;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
      }
    }
    paramWebViewPlugin.sendBroadcast(new Intent("com.tencent.qq.syncNoPhotoSetting"));
    QLog.i(jdField_a_of_type_JavaLangString, 4, "---handlePictureModeSetting-:" + i);
    LocalMultiProcConfig.a(paramWebViewPlugin.getResources().getString(2131368473), i);
    return true;
  }
  
  private boolean f(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return false;
    }
    Activity localActivity = paramWebViewPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return false;
    }
    String str = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      int i = LocalMultiProcConfig.a(localActivity.getResources().getString(2131368473), 0);
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i(jdField_a_of_type_JavaLangString, 4, "---handlePictureModeGet-:" + i);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = str;
      }
    }
  }
  
  private boolean g(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        bool = true;
        continue;
      }
      LocalMultiProcConfig.b("qzone_font_enabled", bool);
      RemoteHandleManager.a().a().a();
      QLog.i(jdField_a_of_type_JavaLangString, 4, "---handleShowFontSetting-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean h(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.a();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.a("qzone_font_enabled", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i(jdField_a_of_type_JavaLangString, 4, "---handleShowFontGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if (paramString3.equalsIgnoreCase("setShowRemindfeed"))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setVideoPlayMode"))
    {
      c(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setPictureMode"))
    {
      e(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setShowFont"))
    {
      g(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getPictureMode"))
    {
      f(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getShowRemindfeed"))
    {
      b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getVideoPlayMode"))
    {
      d(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getShowFont"))
    {
      h(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QzoneSettingJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */