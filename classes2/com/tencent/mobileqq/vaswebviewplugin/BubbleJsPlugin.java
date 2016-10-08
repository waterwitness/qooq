package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.secmsg.SecMsgHelper;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class BubbleJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "bubble";
  private static final String OBJECT_NAME = "bubble";
  public static final String TAG = "BubbleJsPlugin";
  private Bundle mReqBundle;
  
  public BubbleJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "bubble";
  }
  
  public void checkSecGroup(String paramString)
  {
    this.mReqBundle.clear();
    super.sendRemoteReq(DataFactory.a("check_sec_group", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  public void diySetup(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.getInt("id");
    int j = paramJSONObject.getInt("textId");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "diySetup " + paramJSONObject.toString());
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("id", i);
    this.mReqBundle.putInt("textId", j);
    super.sendRemoteReq(DataFactory.a("diy_setup", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
    startDownload(paramJSONObject, "");
    if (QLog.isColorLevel()) {
      QLog.d("BubbleJsPlugin", 2, paramJSONObject.toString());
    }
  }
  
  protected long getPluginBusiness()
  {
    return 2147483712L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"bubble".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        i = paramString1.indexOf("=");
        if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
          throw new Exception("illegal json");
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BubbleJsPlugin", 2, paramJsBridgeListener.getMessage());
        }
        return true;
      }
      paramJsBridgeListener = new JSONObject(URLDecoder.decode(paramString1.substring(i + 1), "UTF-8"));
      paramString1 = paramJsBridgeListener.getString("callback");
      if (paramString1 == null) {
        throw new Exception("need callbackId");
      }
      if ("queryInfo".equals(paramString3))
      {
        queryInfo(paramJsBridgeListener, paramString1);
      }
      else if ("queryLocal".equals(paramString3))
      {
        queryLocal(paramJsBridgeListener, paramString1);
      }
      else if ("setup".equals(paramString3))
      {
        setup(paramJsBridgeListener, paramString1);
      }
      else if ("startDownload".equals(paramString3))
      {
        startDownload(paramJsBridgeListener, paramString1);
      }
      else if ("stopDownload".equals(paramString3))
      {
        stopDownload(paramJsBridgeListener, paramString1);
      }
      else if ("openSecMsg".equalsIgnoreCase(paramString3))
      {
        openSecMsg(paramString1);
      }
      else if ("isSecGroupAvailable".equalsIgnoreCase(paramString3))
      {
        checkSecGroup(paramString1);
      }
      else if ("openSecGroup".equalsIgnoreCase(paramString3))
      {
        openSecGroup(paramString1);
      }
      else
      {
        if (!"diySetup".equalsIgnoreCase(paramString3)) {
          break;
        }
        diySetup(paramJsBridgeListener, paramString1);
      }
    }
    throw new Exception(" unsupport method name " + paramString3);
  }
  
  protected void onCreate()
  {
    this.mReqBundle = new Bundle();
    super.onCreate();
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "onPushMsg=" + paramBundle);
    }
    int i = paramBundle.getInt("srcType");
    int j;
    JSONObject localJSONObject;
    if ((i != 0) && (i == 3))
    {
      i = paramBundle.getInt("id");
      j = paramBundle.getInt("result");
      paramBundle = paramBundle.getString("callbackId");
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("id", i);
      localJSONObject.put("result", j);
      super.callJs(paramBundle + "(" + localJSONObject.toString() + ");");
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject2 = paramBundle.getString("cmd");
      localObject1 = paramBundle.getString("callbackid");
      localObject3 = paramBundle.getBundle("response");
      if (localObject3 != null) {
        ((Bundle)localObject3).setClassLoader(this.mRuntime.a().getClassLoader());
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleJsPlugin", 2, "response:" + (String)localObject2);
      }
      if ((localObject2 != null) && (!"setup".equals(localObject2))) {
        break label171;
      }
    }
    for (;;)
    {
      label171:
      int i;
      try
      {
        paramBundle = new JSONObject();
        paramBundle.put("result", 0);
        paramBundle.put("message", "ok");
        super.callJs((String)localObject1 + "(" + paramBundle.toString() + ");");
        return;
      }
      catch (JSONException paramBundle) {}
      if ("diy_setup".equals(localObject2)) {
        try
        {
          paramBundle = new JSONObject();
          paramBundle.put("result", 0);
          paramBundle.put("msg", "ok");
          super.callJs((String)localObject1 + "(" + paramBundle.toString() + ");");
          return;
        }
        catch (JSONException paramBundle)
        {
          return;
        }
      }
      if ("queryLocal".equals(localObject2))
      {
        if (localObject3 == null) {
          continue;
        }
        i = ((Bundle)localObject3).getInt("id");
        paramBundle = ((Bundle)localObject3).getString("diyText");
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("message", "ok");
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("currentId", i);
          ((JSONObject)localObject3).put("diyText", paramBundle);
          ((JSONObject)localObject2).put("data", localObject3);
          ((JSONObject)localObject2).put("result", 0);
          super.callJs((String)localObject1 + "(" + ((JSONObject)localObject2).toString() + ");");
          return;
        }
        catch (JSONException paramBundle)
        {
          return;
        }
      }
      if ("queryBubbleInfo".equals(localObject2))
      {
        if (localObject3 == null) {
          continue;
        }
        paramBundle = ((Bundle)localObject3).getString("result");
        if (TextUtils.isEmpty(paramBundle)) {
          continue;
        }
        try
        {
          paramBundle = new JSONObject(paramBundle);
          super.callJs((String)localObject1 + "(" + paramBundle.toString() + ");");
          return;
        }
        catch (JSONException paramBundle)
        {
          return;
        }
      }
      if ("bubble_StopDownLoad".equals(localObject2))
      {
        if (localObject3 == null) {
          continue;
        }
        paramBundle = ((Bundle)localObject3).getString("result");
        if (TextUtils.isEmpty(paramBundle)) {
          continue;
        }
        try
        {
          paramBundle = new JSONObject(paramBundle);
          super.callJs((String)localObject1 + "(" + paramBundle.toString() + ");");
          return;
        }
        catch (JSONException paramBundle)
        {
          return;
        }
      }
      if ("open_secmsg".equals(localObject2))
      {
        if ((localObject3 != null) && (((Bundle)localObject3).containsKey("secmsg_receiver")))
        {
          paramBundle = (ResultReceiver)((Bundle)localObject3).getParcelable("secmsg_receiver");
          if (paramBundle != null)
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("extra_tab_mode", 1);
            SecMsgHelper.a(this.mRuntime.a(), paramBundle, this.mRuntime.a().a(), (Intent)localObject1);
          }
        }
      }
      else if ("open_sec_group".equals(localObject2))
      {
        if ((localObject3 != null) && (((Bundle)localObject3).containsKey("secmsg_receiver")))
        {
          paramBundle = (ResultReceiver)((Bundle)localObject3).getParcelable("secmsg_receiver");
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("extra_tab_mode", 0);
          if (paramBundle != null) {
            SecMsgHelper.a(this.mRuntime.a(), paramBundle, this.mRuntime.a().a(), (Intent)localObject1);
          }
        }
      }
      else if ("check_sec_group".equals(localObject2))
      {
        if ((localObject3 != null) && (((Bundle)localObject3).containsKey("sec_group_available")))
        {
          if (((Bundle)localObject3).getBoolean("sec_group_available")) {}
          for (i = 1;; i = 0)
          {
            callJs((String)localObject1, new String[] { "{result: " + i + "}" });
            return;
          }
        }
      }
      else
      {
        super.onResponse(paramBundle);
        return;
      }
    }
  }
  
  public void openSecGroup(String paramString)
  {
    this.mReqBundle.clear();
    super.sendRemoteReq(DataFactory.a("open_sec_group", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  public void openSecMsg(String paramString)
  {
    this.mReqBundle.clear();
    super.sendRemoteReq(DataFactory.a("open_secmsg", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  public void queryInfo(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "queryInfo " + paramJSONObject.toString());
    }
    int i = paramJSONObject.getInt("id");
    if (i == 0)
    {
      paramJSONObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("status", 3);
      localJSONObject.put("progress", 100);
      paramJSONObject.put("result", 0);
      paramJSONObject.put("message", "本地已存在");
      super.callJs(paramString + "(" + paramJSONObject.toString() + ");");
      return;
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("id", i);
    super.sendRemoteReq(DataFactory.a("queryBubbleInfo", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  public void queryLocal(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "queryLocal " + paramJSONObject.toString());
    }
    paramString = DataFactory.a("queryLocal", paramString, this.mOnRemoteResp.key, new Bundle());
    if (paramJSONObject != null) {}
    try
    {
      if (paramJSONObject.has("type")) {
        paramString.putString("type", paramJSONObject.getString("type"));
      }
      super.sendRemoteReq(paramString, false, false);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BubbleJsPlugin", 2, paramJSONObject.getMessage());
        }
      }
    }
  }
  
  public void setup(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.getInt("id");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "setup " + paramJSONObject.toString());
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("id", i);
    super.sendRemoteReq(DataFactory.a("setup", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  public void startDownload(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.getInt("id");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "startDownload " + paramJSONObject.toString());
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("id", i);
    super.sendRemoteReq(DataFactory.a("bubble_startDownLoad", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  public void stopDownload(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.getInt("id");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "stopDownload " + paramJSONObject.toString());
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("id", i);
    super.sendRemoteReq(DataFactory.a("bubble_StopDownLoad", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\BubbleJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */