package cooperation.qzone.webviewplugin.famous;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.qzone.QzonePluginProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneFamousUserHomeJsPlugin
  extends WebViewPlugin
{
  public static String a = "QZFamousUserHome";
  public static String b = "usermoodlist";
  public static String c = "useralbum";
  public static String d = "userhome";
  public static String e = "famous";
  public static String f = "key_uin";
  public static String g = "key_nickname";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QZoneFamousUserHomeJsPlugin()
  {
    this.mPluginNameSpace = a;
  }
  
  private void a(String... paramVarArgs)
  {
    for (;;)
    {
      Intent localIntent;
      Activity localActivity;
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        long l = paramVarArgs.getLong("uin");
        if (!paramVarArgs.has("actiontype")) {
          break label217;
        }
        i = paramVarArgs.getInt("actiontype");
        if (!paramVarArgs.has("actionurl")) {
          break label223;
        }
        paramVarArgs = paramVarArgs.optString("actionurl");
        localIntent = new Intent();
        localActivity = this.mRuntime.a();
        if ((35 == i) && (paramVarArgs != null) && (paramVarArgs.length() > 0))
        {
          if ((localActivity != null) && ((localActivity instanceof QZoneFamousUserHomeJsPlugin.FamousSpaceActivityInterface)) && (((QZoneFamousUserHomeJsPlugin.FamousSpaceActivityInterface)localActivity).n())) {
            return;
          }
          String str = "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity";
          localIntent.putExtra("famous_space_webview_url", paramVarArgs);
          paramVarArgs = str;
          QzonePluginProxyActivity.a(localIntent, paramVarArgs);
          localIntent.putExtra("qqid", l);
          localIntent.putExtra("refer", e);
          if ((localActivity == null) || ((!(localActivity instanceof QZoneFamousUserHomeJsPlugin.FamousSpaceActivityInterface)) && (!(localActivity instanceof BasePluginActivity)))) {
            break label199;
          }
          localIntent.setClassName(localActivity, paramVarArgs);
          localActivity.startActivity(localIntent);
          return;
        }
      }
      catch (JSONException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return;
      }
      paramVarArgs = "com.qzone.homepage.ui.activity.QZoneUserHomeActivity";
      continue;
      label199:
      QzonePluginProxyActivity.a(localActivity, this.mRuntime.a().getAccount(), localIntent, 0);
      return;
      label217:
      int i = 0;
      continue;
      label223:
      paramVarArgs = "";
    }
  }
  
  private void b(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      long l = paramVarArgs.getLong("uin");
      paramVarArgs = paramVarArgs.getString("nick");
      Intent localIntent = new Intent();
      QzonePluginProxyActivity.a(localIntent, "com.qzone.homepage.ui.activity.QzoneMoodListActivity");
      localIntent.putExtra(f, l);
      if (!TextUtils.isEmpty(paramVarArgs)) {
        localIntent.putExtra(g, paramVarArgs);
      }
      localIntent.putExtra("refer", e);
      QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), localIntent, 0);
      return;
    }
    catch (JSONException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
  }
  
  private void c(String... paramVarArgs)
  {
    try
    {
      long l = new JSONObject(paramVarArgs[0]).getLong("uin");
      paramVarArgs = new Intent();
      QzonePluginProxyActivity.a(paramVarArgs, "com.qzone.album.ui.activity.QZonePersonalAlbumActivity");
      paramVarArgs.putExtra("key_left_tab_title", this.mRuntime.a().getString(2131366974));
      paramVarArgs.putExtra("key_right_tab_title", this.mRuntime.a().getString(2131366975));
      paramVarArgs.putExtra("key_album_owner_uin", l);
      paramVarArgs.putExtra("key_selected_tab", 0);
      paramVarArgs.putExtra("refer", e);
      QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramVarArgs, 0);
      return;
    }
    catch (JSONException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!a.equals(paramString2)) {}
    do
    {
      return false;
      if (paramString3.equals(b))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          b(paramVarArgs);
        }
        return true;
      }
      if (paramString3.equals(c))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          c(paramVarArgs);
        }
        return true;
      }
    } while (!paramString3.equals(d));
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      a(paramVarArgs);
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\famous\QZoneFamousUserHomeJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */