package com.tencent.mobileqq.intervideo.od;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class ODAppJSPlugin
  extends WebViewPlugin
  implements TroopMemberApiClient.Callback
{
  public static final String a = "odapp";
  private TroopMemberApiClient a;
  private String b;
  
  public ODAppJSPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "odapp";
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    while ((!"onOpenRoomResult".equals(paramBundle.getString("method"))) || (this.b == null)) {
      return;
    }
    int i = paramBundle.getInt("code", 0);
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("code", i);
      callJs(this.b, new String[] { paramBundle.toString() });
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
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"odapp".equals(paramString2)) {}
    for (;;)
    {
      return false;
      paramJsBridgeListener = "";
      paramString1 = "";
      String str1 = null;
      try
      {
        paramString2 = new JSONObject(paramVarArgs[0]);
        str1 = paramString2;
      }
      catch (JSONException paramString2)
      {
        for (;;)
        {
          int k;
          continue;
          int i = 0;
          int j = 0;
        }
      }
      if (str1 != null) {
        try
        {
          str2 = str1.getString("callback");
          i = str1.getInt("roomid");
          localJsBridgeListener = paramJsBridgeListener;
          paramString2 = paramString1;
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            try
            {
              paramJsBridgeListener = str1.getString("vasname");
              localJsBridgeListener = paramJsBridgeListener;
              paramString2 = paramString1;
              paramString1 = str1.getString("userdata");
              localJsBridgeListener = paramJsBridgeListener;
              paramString2 = paramString1;
              j = str1.getInt("fromid");
            }
            catch (JSONException localJSONException2)
            {
              String str2;
              JsBridgeListener localJsBridgeListener;
              j = 0;
              k = i;
              paramJsBridgeListener = localJsBridgeListener;
              paramString1 = paramString2;
              i = j;
              continue;
            }
            try
            {
              this.b = str2;
              k = i;
              i = j;
              j = k;
              if ((!"odOpenRoom".equals(paramString3)) || (paramVarArgs.length != 1)) {
                break;
              }
              this.a.a(0, j, paramJsBridgeListener, paramString1, i);
              return true;
            }
            catch (JSONException localJSONException3)
            {
              k = i;
              i = j;
              continue;
            }
            localJSONException1 = localJSONException1;
            i = 0;
            k = 0;
            localJSONException1.printStackTrace();
            j = k;
          }
        }
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.a = TroopMemberApiClient.a();
    this.a.a();
  }
  
  protected void onDestroy()
  {
    if (this.a != null) {
      this.a.b();
    }
    super.onDestroy();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\intervideo\od\ODAppJSPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */