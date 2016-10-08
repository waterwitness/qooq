package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.ChatBackgroundMarketActivity;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatBackgroundJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "chatBg";
  private static final String TAG = "ChatBackgroundJsPlugin";
  private BrowserAppInterface browserApp;
  private Bundle mReqBundle;
  
  public ChatBackgroundJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "chatBg";
  }
  
  private void custom(String paramString)
  {
    Object localObject = this.mRuntime.a().getIntent();
    String str = AppConstants.bj + this.browserApp.getAccount() + "/" + "custom_background/";
    str = str + System.currentTimeMillis() + ".jpg";
    Rect localRect = new Rect();
    this.mRuntime.a().getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    ((Intent)localObject).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    ((Intent)localObject).putExtra("isFromPhoto", true);
    PhotoUtils.a((Intent)localObject, this.mRuntime.a(), ChatBackgroundMarketActivity.class.getName(), localRect.width() / 5 * 4, localRect.height() / 5 * 4, localRect.width(), localRect.height(), str);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("result", 0);
      super.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      callJsOnError(paramString, localJSONException.getMessage());
    }
  }
  
  protected long getPluginBusiness()
  {
    return 2181038080L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    String str = null;
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackgroundJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"chatBg".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    int i = paramString1.indexOf("=");
    if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
      return false;
    }
    paramString1 = paramString1.substring(i + 1);
    if (paramString1 == null) {
      return false;
    }
    try
    {
      paramJsBridgeListener = URLDecoder.decode(paramString1, "UTF-8");
      if (paramJsBridgeListener == null) {
        return false;
      }
    }
    catch (UnsupportedEncodingException paramJsBridgeListener)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatBackgroundJsPlugin", 2, "Failed to decode json str, josn=" + paramString1);
        }
        paramJsBridgeListener = null;
      }
      try
      {
        paramVarArgs = new JSONObject(paramJsBridgeListener);
        if (paramVarArgs == null) {
          return false;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ChatBackgroundJsPlugin", 2, "Failed to parse json str,json=");
          }
          paramVarArgs = null;
        }
        try
        {
          paramString2 = paramVarArgs.getString("callback");
          if (paramString2 == null) {
            return false;
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
            paramString2 = null;
          }
          paramJsBridgeListener = "";
          if (!"getCurrentChatBgId".equals(paramString3)) {
            break label311;
          }
        }
        paramString1 = this.mRuntime.a().getIntent().getStringExtra("chatbg_intent_frinedUin");
        paramJsBridgeListener = paramString1;
        if (paramString1 == null) {
          paramJsBridgeListener = "none";
        }
        this.mReqBundle.clear();
        this.mReqBundle.putString("friendUin", paramJsBridgeListener);
        paramJsBridgeListener = "chatbackground_getCurrentId";
      }
    }
    label311:
    Object localObject;
    for (;;)
    {
      super.sendRemoteReq(DataFactory.a(paramJsBridgeListener, paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return true;
      if ("startDownload".equals(paramString3))
      {
        paramString1 = paramJsBridgeListener;
        try
        {
          paramString3 = paramVarArgs.getString("id");
          paramString1 = paramJsBridgeListener;
          str = paramVarArgs.getString("url");
          paramString1 = paramJsBridgeListener;
          localObject = paramVarArgs.getString("name");
          paramString1 = paramJsBridgeListener;
          paramVarArgs = paramVarArgs.getString("thumbUrl");
          paramJsBridgeListener = "chatbackground_startDownload";
          paramString1 = paramJsBridgeListener;
          this.mReqBundle.clear();
          paramString1 = paramJsBridgeListener;
          this.mReqBundle.putString("id", paramString3);
          paramString1 = paramJsBridgeListener;
          this.mReqBundle.putString("url", str);
          paramString1 = paramJsBridgeListener;
          this.mReqBundle.putString("name", (String)localObject);
          paramString1 = paramJsBridgeListener;
          this.mReqBundle.putString("thumbUrl", paramVarArgs);
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          paramJsBridgeListener = paramString1;
        }
      }
      else if ("stopDownload".equals(paramString3))
      {
        paramString1 = paramJsBridgeListener;
        try
        {
          paramString3 = paramVarArgs.getString("id");
          paramString1 = paramJsBridgeListener;
          paramVarArgs = paramVarArgs.getString("url");
          paramJsBridgeListener = "chatbackground_stopdownload";
          paramString1 = paramJsBridgeListener;
          this.mReqBundle.clear();
          paramString1 = paramJsBridgeListener;
          this.mReqBundle.putString("id", paramString3);
          paramString1 = paramJsBridgeListener;
          this.mReqBundle.putString("url", paramVarArgs);
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          paramJsBridgeListener = paramString1;
        }
      }
      else
      {
        if (!"queryInfo".equals(paramString3)) {
          break;
        }
        paramString1 = paramJsBridgeListener;
        try
        {
          paramString3 = paramVarArgs.getString("id");
          paramString1 = paramJsBridgeListener;
          paramVarArgs = paramVarArgs.getString("url");
          paramJsBridgeListener = "chatbackground_querinfo";
          paramString1 = paramJsBridgeListener;
          this.mReqBundle.clear();
          paramString1 = paramJsBridgeListener;
          this.mReqBundle.putString("id", paramString3);
          paramString1 = paramJsBridgeListener;
          this.mReqBundle.putString("url", paramVarArgs);
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          paramJsBridgeListener = paramString1;
        }
      }
    }
    if ("setChatBg".equals(paramString3)) {
      paramString3 = "chatbackground_setbg";
    }
    label781:
    label810:
    label1058:
    for (;;)
    {
      try
      {
        paramJsBridgeListener = paramVarArgs.getString("id");
        if (!paramJsBridgeListener.startsWith("theme")) {
          break label781;
        }
        paramString1 = "null";
        localObject = this.mRuntime.a().getIntent();
        if (!paramVarArgs.has("friendUin")) {
          break label810;
        }
        paramJsBridgeListener = paramVarArgs.getString("friendUin");
        if (!"none".equals(paramJsBridgeListener)) {
          break label1058;
        }
        paramJsBridgeListener = str;
        this.mReqBundle.clear();
        this.mReqBundle.putString("path", paramString1);
        this.mReqBundle.putString("friendUin", paramJsBridgeListener);
        this.mReqBundle.putString("from", "chatbgJs");
        this.mReqBundle.putParcelable("intent", (Parcelable)localObject);
        paramJsBridgeListener = paramString3;
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        paramJsBridgeListener = paramString3;
      }
      break;
      paramString1 = AppConstants.cs + paramJsBridgeListener + ".jpg";
      continue;
      paramJsBridgeListener = "none";
      continue;
      if ("custom".equals(paramString3))
      {
        custom(paramString2);
        return true;
      }
      if (!"openPage".equals(paramString3)) {
        break;
      }
      try
      {
        paramJsBridgeListener = new Intent(this.mRuntime.a(), ChatBackgroundMarketActivity.class);
        paramJsBridgeListener.putExtra("bg_replace_entrance", 8);
        paramJsBridgeListener.putExtra("selfSet_leftViewText", this.mRuntime.a().getString(2131367975));
        paramJsBridgeListener.putExtra("hide_left_button", false);
        paramString1 = String.valueOf(33554432L);
        if (WebViewPluginFactory.a.containsKey(paramString1)) {
          paramJsBridgeListener.putExtra("insertPluginsArray", new String[] { paramString1 });
        }
        paramJsBridgeListener.putExtra("business", 33554432L);
        paramJsBridgeListener.putExtra("show_right_close_button", false);
        paramJsBridgeListener.putExtra("url", IndividuationUrlHelper.a(this.mRuntime.a(), "background", ""));
        paramJsBridgeListener.putExtra("startOpenPageTime", System.currentTimeMillis());
        this.mRuntime.a().startActivity(paramJsBridgeListener);
        paramJsBridgeListener = new JSONObject();
        paramJsBridgeListener.put("result", 0);
        super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
      }
      catch (Exception paramJsBridgeListener)
      {
        for (;;)
        {
          paramJsBridgeListener.printStackTrace();
          super.callJs(paramString2, new String[] { paramJsBridgeListener.getMessage() });
        }
      }
      return true;
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.mReqBundle = new Bundle();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("ChatBackgroundJsPlugin", 2, "ERROR!!! chatbg market is not running in web process!");
  }
  
  void onPushMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatBackgroundJsPlugin", 2, "onPushMsg=" + paramBundle);
    }
    int i = paramBundle.getInt("id");
    int j = paramBundle.getInt("result");
    paramBundle = paramBundle.getString("callbackId");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", i);
      localJSONObject.put("result", j);
      super.callJs(paramBundle, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str1;
    String str2;
    JSONObject localJSONObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key);
        str1 = paramBundle.getString("cmd");
        try
        {
          str2 = paramBundle.getString("callbackid");
          paramBundle = paramBundle.getBundle("response");
          localJSONObject = new JSONObject();
          if (!"chatbackground_getCurrentId".equals(str1)) {
            break;
          }
          localJSONObject.put("id", paramBundle.getString("id"));
          localJSONObject.put("result", paramBundle.getInt("result"));
          localJSONObject.put("friendUin", paramBundle.getString("friendUin"));
          localJSONObject.put("themeId", paramBundle.getString("themeId"));
          localJSONObject.put("url", paramBundle.getString("url"));
          localJSONObject.put("isDIYTheme", paramBundle.getString("isDIYTheme"));
          super.callJs(str2, new String[] { localJSONObject.toString() });
          return;
        }
        catch (Exception paramBundle) {}
      } while (!QLog.isColorLevel());
      QLog.e("ChatBackgroundJsPlugin", 2, "Failed to handle cmd " + str1 + ", exception: " + paramBundle.getMessage());
      return;
      if ("chatbackground_setbg".equals(str1))
      {
        localJSONObject.put("result", paramBundle.getInt("result"));
        super.callJs(str2, new String[] { localJSONObject.toString() });
        return;
      }
      if ("chatbackground_querinfo".equals(str1))
      {
        localJSONObject.put("status", paramBundle.getInt("status"));
        localJSONObject.put("id", paramBundle.getString("id"));
        localJSONObject.put("message", paramBundle.getString("message"));
        localJSONObject.put("result", paramBundle.getInt("result"));
        localJSONObject.put("progress", paramBundle.getInt("progress"));
        super.callJs(str2, new String[] { localJSONObject.toString() });
        return;
      }
    } while (!"chatbackground_stopdownload".equals(str1));
    localJSONObject.put("id", paramBundle.getString("id"));
    localJSONObject.put("result", 0);
    super.callJs(str2, new String[] { localJSONObject.toString() });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ChatBackgroundJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */