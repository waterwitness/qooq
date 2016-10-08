package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneAlbumJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String a = "Qzone";
  private static String b = QzoneAlbumJsPlugin.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    Activity localActivity = this.a.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    do
    {
      String str;
      do
      {
        return;
        try
        {
          paramArrayOfString = new JSONObject(paramArrayOfString[0]);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_item_id", paramArrayOfString.optInt("item_id"));
          ((Intent)localObject2).putExtra("key_thumb_url", paramArrayOfString.optString("thumb"));
          ((Intent)localObject2).putExtra("key_item_type", paramArrayOfString.optInt("item_type"));
          ((Intent)localObject2).setAction("action_album_skin_js_to_qzone");
          str = paramArrayOfString.optString("callback");
          localObject1 = paramArrayOfString.optString("entry");
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            this.a.callJs(str, new String[] { "{\"result\":\"false\"}" });
            return;
          }
        }
        catch (JSONException paramPluginRuntime)
        {
          paramPluginRuntime.printStackTrace();
          return;
        }
      } while ((!"createAlbum".equals(localObject1)) && (!"editAlbum".equals(localObject1)) && (!"personal".equals(localObject1)) && (!"photolist".equals(localObject1)));
      if (paramPluginRuntime.a() != null) {
        paramPluginRuntime.a().sendBroadcast((Intent)localObject2);
      }
      this.a.callJs(str, new String[] { "{\"result\":\"true\"}" });
      paramPluginRuntime = this.a.mRuntime.a();
    } while ((!"personal".equals(localObject1)) || (paramPluginRuntime == null));
    Object localObject1 = QZoneHelper.UserInfo.a();
    ((QZoneHelper.UserInfo)localObject1).jdField_a_of_type_JavaLangString = paramPluginRuntime.a();
    Object localObject2 = new BaseBusinessAlbumInfo();
    ((BaseBusinessAlbumInfo)localObject2).jdField_a_of_type_JavaLangString = paramArrayOfString.optString("albumid");
    ((BaseBusinessAlbumInfo)localObject2).jdField_a_of_type_Long = paramPluginRuntime.getLongAccountUin();
    ((BaseBusinessAlbumInfo)localObject2).c = 0;
    ((BaseBusinessAlbumInfo)localObject2).b = true;
    QZoneHelper.a(localActivity, (QZoneHelper.UserInfo)localObject1, (BaseBusinessAlbumInfo)localObject2, -1);
  }
  
  private void b(WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    try
    {
      Object localObject = this.a.mRuntime.a();
      if ((localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        paramArrayOfString = new JSONObject(paramArrayOfString[0]);
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_album_comment_list_count", paramArrayOfString.optInt("count"));
        ((Intent)localObject).setAction("broadcastActionUpdateAlbumCommentList");
        if (paramPluginRuntime.a() != null) {
          paramPluginRuntime.a().sendBroadcast((Intent)localObject);
        }
      }
      return;
    }
    catch (Exception paramPluginRuntime)
    {
      paramPluginRuntime.printStackTrace();
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.a == null) || (this.a.mRuntime == null)) {
      return false;
    }
    if ((paramString3.equalsIgnoreCase("SetAlbumSkin")) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      a(this.a.mRuntime, paramVarArgs);
      return true;
    }
    if ((paramString3.equalsIgnoreCase("UpdateAlbumCommentList")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      b(this.a.mRuntime, paramVarArgs);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QzoneAlbumJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */