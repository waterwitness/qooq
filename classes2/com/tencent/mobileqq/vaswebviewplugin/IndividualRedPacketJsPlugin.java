package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class IndividualRedPacketJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "individualRedPacket";
  private static final String TAG = "IndividualRedPacketJsPlugin";
  private BrowserAppInterface browserApp;
  private Bundle mReqBundle;
  
  public IndividualRedPacketJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "individualRedPacket";
  }
  
  protected long getPluginBusiness()
  {
    return 2281701376L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IndividualRedPacketJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"individualRedPacket".equals(paramString2)) || (paramString3 == null)) {
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
          QLog.i("IndividualRedPacketJsPlugin", 2, "Failed to decode json str, josn=" + paramString1);
        }
        paramJsBridgeListener = null;
      }
      try
      {
        paramString2 = new JSONObject(paramJsBridgeListener);
        if (paramString2 == null) {
          return false;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("IndividualRedPacketJsPlugin", 2, "Failed to parse json str,json=");
          }
          paramString2 = null;
        }
        try
        {
          paramString1 = paramString2.getString("callback");
          if (paramString1 == null) {
            return false;
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
            paramString1 = null;
          }
          paramJsBridgeListener = "";
          if (!"getBitmap".equals(paramString3)) {
            break label347;
          }
        }
        paramString3 = "rpWebGetBitmap";
        this.mReqBundle.clear();
      }
    }
    label347:
    do
    {
      for (;;)
      {
        try
        {
          this.mReqBundle.putString("templateId", paramString2.getString("templateId"));
          this.mReqBundle.putString("content", paramString2.getString("content"));
          paramJsBridgeListener = paramString3;
        }
        catch (JSONException paramString2)
        {
          paramJsBridgeListener = paramString3;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("IndividualRedPacketJsPlugin", 2, "Failed to getBitmap:" + paramString2.getMessage());
          paramJsBridgeListener = paramString3;
          continue;
        }
        super.sendRemoteReq(DataFactory.a(paramJsBridgeListener, paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        return true;
        if ("setFlag".equals(paramString3))
        {
          paramString3 = "rpWebSetFlags";
          this.mReqBundle.clear();
          try
          {
            if (paramString2.has("switchFlag")) {
              this.mReqBundle.putInt("iRedDisable", paramString2.getInt("switchFlag"));
            }
            if (paramString2.has("vipRedpacketFlag")) {
              this.mReqBundle.putInt("iCanUseRed", paramString2.getInt("vipRedpacketFlag"));
            }
            paramJsBridgeListener = new JSONObject();
            paramJsBridgeListener.put("result", 0);
            super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
            paramJsBridgeListener = paramString3;
          }
          catch (JSONException paramString2)
          {
            paramJsBridgeListener = paramString3;
          }
          if (QLog.isColorLevel())
          {
            QLog.e("IndividualRedPacketJsPlugin", 2, "Failed to setFlag:" + paramString2.getMessage());
            paramJsBridgeListener = paramString3;
          }
        }
        else
        {
          if (!"setRedPacketInfo".equals(paramString3)) {
            break;
          }
          paramJsBridgeListener = "rpWebSetRedpacketInfo";
          this.mReqBundle.clear();
          try
          {
            i = paramString2.optInt("redPacketId", -1);
            paramString2 = paramString2.optString("redPacketText", null);
            this.mReqBundle.putInt("iRedPacketId", i);
            this.mReqBundle.putString("sRedPackRemard", paramString2);
            if (QLog.isColorLevel()) {
              QLog.d("IndividualRedPacketJsPlugin", 2, "setRedPacketInfo iRedPacketId = " + i + ";sRedPackRemard = " + paramString2);
            }
            paramString2 = new JSONObject();
            paramString2.put("result", 0);
            super.callJs(paramString1, new String[] { paramString2.toString() });
          }
          catch (Exception paramString2)
          {
            QLog.e("IndividualRedPacketJsPlugin", 2, "Failed to setRedPacketInfo:" + paramString2.getMessage());
          }
        }
      }
    } while (!"initTemplate".equals(paramString3));
    paramString3 = "rpWebInitTemplate";
    this.mReqBundle.clear();
    for (;;)
    {
      try
      {
        paramVarArgs = this.mReqBundle;
        if (!paramString2.has("templateId")) {
          break label765;
        }
        paramJsBridgeListener = paramString2.getString("templateId");
        paramVarArgs.putString("templateId", paramJsBridgeListener);
        paramJsBridgeListener = paramString3;
      }
      catch (Exception paramString2)
      {
        paramJsBridgeListener = paramString3;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("IndividualRedPacketJsPlugin", 2, "Failed to initTemplate:" + paramString2.getMessage());
      paramJsBridgeListener = paramString3;
      break;
      label765:
      paramJsBridgeListener = "";
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
    QLog.e("IndividualRedPacketJsPlugin", 2, "ERROR!!! IndividualRedPacket market is not running in web process!");
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str1;
    String str2;
    JSONObject localJSONObject1;
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
          localJSONObject1 = new JSONObject();
          if (!"rpWebGetBitmap".equals(str1)) {
            break;
          }
          localJSONObject1.put("code", paramBundle.getInt("result"));
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("templateId", paramBundle.getString("templateId"));
          localJSONObject2.put("content", paramBundle.getString("content"));
          localJSONObject2.put("bitmap", paramBundle.getString("bitmap"));
          localJSONObject1.put("data", localJSONObject2);
          super.callJs(str2, new String[] { localJSONObject1.toString() });
          return;
        }
        catch (Exception paramBundle) {}
      } while (!QLog.isColorLevel());
      QLog.e("IndividualRedPacketJsPlugin", 2, "Failed to handle cmd " + str1 + ", exception: " + paramBundle.getMessage());
      return;
    } while (!"rpWebInitTemplate".equals(str1));
    localJSONObject1.put("code", paramBundle.getInt("result"));
    super.callJs(str2, new String[] { localJSONObject1.toString() });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\IndividualRedPacketJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */