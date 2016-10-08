package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yqy;
import yqz;

public class QZoneWebViewJsHandleLogic
{
  public static final String a = "QZoneWebViewJsHandleLogic";
  
  public QZoneWebViewJsHandleLogic()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static int a(Context paramContext, String paramString, int paramInt, WebViewPlugin.PluginRuntime paramPluginRuntime)
  {
    int i = 2;
    if (paramContext == null) {
      return 5;
    }
    if (a(paramString)) {
      if (a(paramContext, paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneWebViewPlugin", 2, "simpleSchemeJump");
        }
        a(paramContext, Uri.parse(paramString));
        paramInt = 1;
      }
    }
    for (;;)
    {
      return paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewPlugin", 2, "showQzoneAppDownloadDialog");
      }
      a(paramContext, paramPluginRuntime);
      paramInt = i;
      continue;
      if (URLUtil.isNetworkUrl(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneWebViewPlugin", 2, "isNetworkUrl do nothing");
        }
        paramInt = 5;
      }
      else
      {
        paramInt = 5;
      }
    }
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        String str = Uri.parse(paramString).getQueryParameter("_wv");
        if (str == null) {
          return a(paramString, "_wv", String.valueOf(paramInt));
        }
        if (paramBoolean)
        {
          str = a(paramString, "_wv", String.valueOf(Integer.valueOf(str).intValue() | paramInt));
          return str;
        }
      }
      catch (Exception localException) {}
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    String str = paramString2 + '=';
    int i = paramString1.indexOf(str);
    int j;
    if (i != -1)
    {
      if (i == 0) {}
      do
      {
        i = paramString1.indexOf(str, str.length() + i);
        break;
        j = paramString1.charAt(i - 1);
      } while ((j != 63) && (j != 35) && (j != 38));
    }
    int k;
    if (i > -1)
    {
      k = i + str.length();
      j = k;
      if (j < paramString1.length())
      {
        int m = paramString1.charAt(j);
        if ((m != 38) && (m != 35)) {}
      }
      else
      {
        if ((!paramString2.equals("_wv")) || (i <= paramString1.indexOf('#'))) {
          break label192;
        }
        paramString1 = Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, paramString3).toString();
      }
    }
    for (;;)
    {
      return paramString1;
      j += 1;
      break;
      label192:
      paramString1 = paramString1.substring(0, k) + paramString3 + paramString1.substring(j);
      continue;
      paramString1 = Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, paramString3).toString();
    }
  }
  
  static void a(Context paramContext, Uri paramUri)
  {
    Intent localIntent = new Intent();
    localIntent.setData(paramUri);
    localIntent.setPackage("com.qzone");
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, WebViewPlugin.PluginRuntime paramPluginRuntime)
  {
    paramPluginRuntime = DialogUtil.a(paramContext, 0);
    paramPluginRuntime.setMessage(paramContext.getString(2131368799));
    paramPluginRuntime.setPositiveButton(paramContext.getString(2131368801), new yqy(paramContext));
    paramPluginRuntime.setNegativeButton(paramContext.getString(2131370108), new yqz(paramPluginRuntime));
    try
    {
      if (!paramPluginRuntime.isShowing()) {
        paramPluginRuntime.show();
      }
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("showQzoneAppDownloadDialog", 2, "mDialog.show() exception", paramContext);
    }
  }
  
  private static void a(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    int i = 0;
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = new JSONObject(paramVarArgs[0]);
        if (((JSONObject)localObject).getInt("success") == 1)
        {
          paramVarArgs = ((JSONObject)localObject).getJSONArray("uins");
          if ((paramVarArgs != null) && (paramVarArgs.length() > 0))
          {
            if ((((JSONObject)localObject).has("toast")) && (((JSONObject)localObject).getBoolean("toast"))) {
              QQToast.a(paramPluginRuntime.a(), 2, 2131371406, 0).a();
            }
            localObject = new long[paramVarArgs.length()];
            while (i < paramVarArgs.length())
            {
              localObject[i] = paramVarArgs.getLong(i);
              i += 1;
            }
            paramVarArgs = new Intent();
            paramVarArgs.putExtra("key_msg_type", 2);
            paramVarArgs.putExtra("key_friend_list", (long[])localObject);
            paramPluginRuntime.a().setResult(-1, paramVarArgs);
            paramPluginRuntime.a().finish();
            return;
          }
        }
      }
      catch (JSONException paramPluginRuntime)
      {
        paramPluginRuntime.printStackTrace();
      }
    }
  }
  
  private static void a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    Object localObject3 = null;
    int i = 3;
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject1).getString("schema");
        localObject1 = ((JSONObject)localObject1).optJSONObject("dealparam");
        if (localObject1 == null) {
          break label670;
        }
        localObject1 = ((JSONObject)localObject1).optString("url");
        if ((TextUtils.isEmpty(paramVarArgs)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label667;
        }
        paramVarArgs = paramVarArgs + "&url=" + (String)localObject1;
        if (QLog.isColorLevel()) {
          QLog.d("QZoneWebViewPlugin", 2, " handleSchema scheme:" + paramVarArgs);
        }
        if (paramPluginRuntime != null) {
          localObject3 = paramPluginRuntime.a();
        }
        localObject2 = localObject3;
        if (localObject3 != null)
        {
          localObject2 = localObject3;
          if ((localObject3 instanceof BasePluginActivity)) {
            localObject2 = ((BasePluginActivity)localObject3).getOutActivity();
          }
        }
        localObject3 = localObject2;
        if (localObject2 != null)
        {
          localObject3 = localObject2;
          if ((localObject2 instanceof BasePluginActivity)) {
            localObject3 = ((BasePluginActivity)localObject2).getOutActivity();
          }
        }
        boolean bool = paramVarArgs.startsWith("mqzone://arouse/userhome");
        if (bool)
        {
          if (localObject3 == null) {
            break;
          }
          try
          {
            if (paramVarArgs.indexOf("uin=") == -1) {
              break;
            }
            paramWebViewPlugin = paramVarArgs.substring(paramVarArgs.indexOf("uin=") + 4, paramVarArgs.length());
            QZoneHelper.a((Activity)localObject3, QZoneHelper.UserInfo.a(), paramWebViewPlugin, 0, 0, 0);
            return;
          }
          catch (Exception paramWebViewPlugin)
          {
            paramWebViewPlugin.printStackTrace();
            return;
          }
        }
        if (!paramVarArgs.startsWith("mqzone://arouse/webtofeeddetail")) {
          break label320;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        return;
      }
      if (localObject3 == null) {
        break;
      }
      if ((localObject3 instanceof WebViewPluginContainer)) {
        i = ((WebViewPluginContainer)localObject3).switchRequestCode(paramWebViewPlugin, (byte)3);
      }
      QZoneHelper.a((Activity)localObject3, QZoneHelper.UserInfo.a(), (String)localObject1, i);
      return;
      label320:
      if (paramVarArgs.startsWith("mqzone://arouse/detail"))
      {
        if (localObject3 == null) {
          break;
        }
        Object localObject4 = Uri.parse(paramVarArgs);
        paramVarArgs = ((Uri)localObject4).getQueryParameter("uin");
        localObject1 = ((Uri)localObject4).getQueryParameter("appid");
        localObject2 = ((Uri)localObject4).getQueryParameter("cellid");
        localObject4 = ((Uri)localObject4).getQueryParameter("subid");
        if ((localObject3 instanceof WebViewPluginContainer)) {
          i = ((WebViewPluginContainer)localObject3).switchRequestCode(paramWebViewPlugin, (byte)3);
        }
        paramWebViewPlugin = QZoneHelper.UserInfo.a();
        paramWebViewPlugin.a = paramPluginRuntime.a().getAccount();
        QZoneHelper.a((Activity)localObject3, paramWebViewPlugin, paramVarArgs, (String)localObject1, (String)localObject2, (String)localObject4, i);
        return;
      }
      if ("mqzone://arouse/dynamicnickname".equalsIgnoreCase(paramVarArgs))
      {
        if ((paramPluginRuntime == null) || (paramPluginRuntime.a() == null) || (paramPluginRuntime.a() == null)) {
          break;
        }
        QZoneHelper.a(paramPluginRuntime.a(), paramPluginRuntime.a().getAccount());
        return;
      }
      if (paramVarArgs.startsWith("mqzone://arouse/uploadphoto"))
      {
        QZoneHelper.a(paramWebViewPlugin, paramPluginRuntime, paramPluginRuntime.a(), paramPluginRuntime.a().getAccount(), paramVarArgs);
        return;
      }
      if ((paramVarArgs.startsWith("mqzone://arouse/facade")) || (paramVarArgs.startsWith("mqzonev2://arouse/facade")))
      {
        a(paramPluginRuntime.a(), paramVarArgs, 81, paramPluginRuntime);
        return;
      }
      Object localObject1 = new Intent("action_js2qzone");
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("cmd", "Schema");
      ((Bundle)localObject2).putString("schema", paramVarArgs);
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewPlugin", 2, "handleSchema actionString: " + ((Intent)localObject1).getAction() + "scheme:" + paramVarArgs);
      }
      if (paramVarArgs.startsWith("mqzone://arouse/openvideolayer"))
      {
        i = QZoneWebViewPlugin.a(paramWebViewPlugin, paramPluginRuntime, 4);
        QZoneHelper.a((Activity)localObject3, QZoneHelper.UserInfo.a(), (Intent)localObject1, i);
        return;
      }
      QZoneHelper.a((Activity)localObject3, QZoneHelper.UserInfo.a(), (Intent)localObject1);
      return;
      label667:
      continue;
      label670:
      localObject1 = null;
    }
  }
  
  public static void a(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("handleUrl", 2, "browse url fail:" + paramString);
      }
    }
    do
    {
      return;
      paramString = a(paramString, 7, false);
      Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("fromQZone", true);
      localIntent.putExtra("injectrecommend", true);
      localIntent.setData(Uri.parse(paramString));
      localIntent.addFlags(268435456);
      localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131367184));
      paramContext.startActivity(localIntent);
    } while (!QLog.isColorLevel());
    QLog.d("handleurl", 2, "jump to browser: " + paramString);
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    boolean bool2 = false;
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.qzone", 0);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.versionCode >= paramInt) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
  }
  
  public static boolean a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String paramString, String... paramVarArgs)
  {
    if ("SendGiftFinished".equalsIgnoreCase(paramString)) {
      a(paramPluginRuntime, paramVarArgs);
    }
    do
    {
      return true;
      if ("openAppDetail".equalsIgnoreCase(paramString))
      {
        b(paramPluginRuntime, paramVarArgs);
        return true;
      }
      if ("Schema".equalsIgnoreCase(paramString))
      {
        a(paramWebViewPlugin, paramPluginRuntime, paramVarArgs);
        return true;
      }
      if (!"refreshFeeds".equals(paramString)) {
        break;
      }
      paramWebViewPlugin = new Intent();
      paramWebViewPlugin.setAction("SignInSbumited");
    } while (paramPluginRuntime.a() == null);
    paramPluginRuntime.a().sendBroadcast(paramWebViewPlugin);
    return true;
    if ("UpdateFamousSpaceVpageOptions".equalsIgnoreCase(paramString))
    {
      QzoneFamousSpaceWebViewLogic.a().a(paramVarArgs);
      return true;
    }
    return false;
  }
  
  private static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString).getScheme();
      if (("mqzone".equals(paramString)) || ("mqzonev2".equals(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  private static void b(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject2).getString("packName");
        Object localObject1 = ((JSONObject)localObject2).getString("taskAppId");
        String str1 = ((JSONObject)localObject2).getString("appId");
        String str2 = ((JSONObject)localObject2).getString("taskApkId");
        String str3 = ((JSONObject)localObject2).getString("via");
        String str4 = ((JSONObject)localObject2).getString("versionCode");
        String str5 = ((JSONObject)localObject2).getString("channel");
        localObject2 = ((JSONObject)localObject2).getString("from");
        int j = 3;
        int i = j;
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            i = Integer.parseInt((String)localObject2);
          }
          localObject2 = new StringBuilder();
          if (!TextUtils.isEmpty(str1)) {
            ((StringBuilder)localObject2).append(DownloadConstants.a).append("=").append(str1);
          }
          if (!TextUtils.isEmpty(paramVarArgs)) {
            ((StringBuilder)localObject2).append("&").append(DownloadConstants.e).append("=").append(paramVarArgs);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ((StringBuilder)localObject2).append("&").append(DownloadConstants.b).append("=").append((String)localObject1);
          }
          if (!TextUtils.isEmpty(str2)) {
            ((StringBuilder)localObject2).append("&").append(DownloadConstants.c).append("=").append(str2);
          }
          if (!TextUtils.isEmpty(str3)) {
            ((StringBuilder)localObject2).append("&").append(DownloadConstants.h).append("=").append(str3);
          }
          if (!TextUtils.isEmpty(str4)) {
            ((StringBuilder)localObject2).append("&").append(DownloadConstants.d).append("=").append(str4);
          }
          if (!TextUtils.isEmpty(str5)) {
            ((StringBuilder)localObject2).append("&").append(DownloadConstants.A).append("=").append(str5);
          }
          paramVarArgs = ((StringBuilder)localObject2).toString();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("from", i);
          ((Bundle)localObject1).putString("schemaUrl", paramVarArgs);
          AppClient.a(paramPluginRuntime.a(), (Bundle)localObject1);
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.e("QZoneWebViewJsHandleLogic", 2, "from 错误", localNumberFormatException);
              i = j;
            }
          }
        }
        return;
      }
      catch (JSONException paramPluginRuntime)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZoneWebViewJsHandleLogic", 2, "json 解析异常", paramPluginRuntime);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QZoneWebViewJsHandleLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */