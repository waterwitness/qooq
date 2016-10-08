package com.tencent.biz.troop;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopMemberApiPlugin
  extends WebViewPlugin
  implements TroopMemberApiClient.Callback
{
  public static final String a = "changeAnonymousNick";
  public static final String b = "getUploadInfo";
  public static final String c = "cleanDynamicRedPoint";
  public static final String d = "TroopMemberApiPlugin";
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  protected String e;
  protected String f;
  
  public TroopMemberApiPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
    this.mPluginNameSpace = "TroopMemberApiPlugin";
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject = new JSONObject(paramString);
          paramString = ((JSONObject)localObject).optString("gcode");
          localObject = ((JSONObject)localObject).optString("id");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString)))
          {
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(paramString, (String)localObject);
            return;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i(this.TAG, 2, "anonymousReport exception" + paramString.getMessage());
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str;
    do
    {
      return;
      if ("changeAnonymousNick".equals(paramBundle.getString("method")))
      {
        boolean bool = paramBundle.getBoolean("result");
        callJs(this.e, new String[] { "{result : " + bool + "}" });
        return;
      }
      str = paramBundle.getString("callback");
    } while (TextUtils.isEmpty(str));
    callJs(str, new String[] { paramBundle.getString("data") });
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("anonymousReport".equals(paramString3))
    {
      a(paramVarArgs[0]);
      return true;
    }
    if ("anonymousNickChanged".equals(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = paramJsBridgeListener.optString("troopUin");
        long l = paramJsBridgeListener.optLong("bubbleId");
        int i = paramJsBridgeListener.optInt("headId");
        paramString2 = paramJsBridgeListener.optString("nickName");
        int j = paramJsBridgeListener.optInt("expireTime");
        this.e = paramJsBridgeListener.optString("callback");
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "TroopMemberApiPlugin, anonymousNickChanged, json : " + paramJsBridgeListener);
        }
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramString1, l, i, paramString2, j, this);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "TroopMemberApiPlugin, anonymousNickChanged, JSONException :" + paramJsBridgeListener);
        }
      }
    }
    do
    {
      return false;
      if ("getUploadInfo".equals(paramString3)) {
        try
        {
          callJs(new JSONObject(paramVarArgs[0]).optString("callback"), new String[] { "{stateus:0}" });
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
    } while (!"cleanDynamicRedPoint".equals(paramString3));
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.c(paramJsBridgeListener, this);
      return true;
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        paramJsBridgeListener.printStackTrace();
      }
    }
  }
  
  protected void onCreate()
  {
    AppInterface localAppInterface = this.mRuntime.a();
    Activity localActivity = this.mRuntime.a();
    if ((localAppInterface == null) || (localActivity == null)) {
      return;
    }
    a();
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troop\TroopMemberApiPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */