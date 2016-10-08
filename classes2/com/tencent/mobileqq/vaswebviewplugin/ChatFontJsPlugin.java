package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatFontJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "font";
  private static final String TAG = "ChatFontJsPlugin";
  private BrowserAppInterface browserApp;
  private boolean isUseFont;
  private HashMap mFontSize;
  private Bundle mReqBundle;
  
  public ChatFontJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "font";
  }
  
  private void setFontSwitch(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatFontJsPlugin", 2, "setFontSwitch:" + paramJSONObject);
    }
    try
    {
      int i = paramJSONObject.getInt("action");
      this.mReqBundle.clear();
      this.mReqBundle.putInt("action", i);
      super.sendRemoteReq(DataFactory.a("setFontSwtich", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      super.callJs(paramString, new String[] { paramJSONObject.getMessage() });
    }
  }
  
  protected long getPluginBusiness()
  {
    return 2147487744L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatFontJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"font".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    i = paramString1.indexOf("=");
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
          QLog.i("ChatFontJsPlugin", 2, "Failed to decode json str, josn=" + paramString1);
        }
        paramJsBridgeListener = null;
      }
      try
      {
        paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
        if (QLog.isColorLevel()) {
          QLog.d("ChatFontJsPlugin", 2, "handleJsRequest, pkgName=" + paramString2 + ", methodName=" + paramString3 + ",json = " + paramJsBridgeListener.toString());
        }
        if (paramJsBridgeListener == null) {
          return false;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ChatFontJsPlugin", 2, "Failed to parse json str,json=");
          }
          paramJsBridgeListener = null;
        }
      }
    }
    for (;;)
    {
      try
      {
        j = paramJsBridgeListener.optInt("id");
        if (!QLog.isColorLevel()) {
          break label319;
        }
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          try
          {
            i = paramJsBridgeListener.optInt("type");
          }
          catch (JSONException paramString1)
          {
            int j;
            i = 0;
            continue;
          }
          try
          {
            paramString1 = paramJsBridgeListener.getString("callback");
            if (paramString1 != null) {
              continue;
            }
            return false;
          }
          catch (JSONException paramString1) {}
        }
        paramString1 = paramString1;
        i = 0;
        j = 0;
      }
      QLog.i("ChatFontJsPlugin", 2, "Failed to parse callbackid,json=" + paramJsBridgeListener);
      label319:
      paramString1 = null;
    }
    if ("queryLocal".equals(paramString3))
    {
      queryLocal(paramJsBridgeListener, paramString1);
      return true;
    }
    if ("setSize".equals(paramString3))
    {
      setSize(paramJsBridgeListener, paramString1);
      return true;
    }
    if ((!"queryInfo".equals(paramString3)) || (j == 0)) {}
    try
    {
      paramJsBridgeListener = new JSONObject();
      paramString2 = new JSONObject();
      paramString2.put("status", 3);
      paramString2.put("progress", 100);
      paramJsBridgeListener.put("result", 0);
      paramJsBridgeListener.put("message", "本地已存在");
      super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
      paramJsBridgeListener = "queryFontInfo";
      for (;;)
      {
        this.mReqBundle.clear();
        this.mReqBundle.putInt("id", j);
        this.mReqBundle.putInt("type", i);
        super.sendRemoteReq(DataFactory.a(paramJsBridgeListener, paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        return true;
        if ("setup".equals(paramString3))
        {
          paramJsBridgeListener = "setupChatFont";
        }
        else if ("startDownload".equals(paramString3))
        {
          paramJsBridgeListener = "font_startDownLoad";
        }
        else
        {
          if (!"stopDownload".equals(paramString3)) {
            break;
          }
          paramJsBridgeListener = "font_StopDownLoad";
        }
      }
      if ("showBlackMsgBox".equals(paramString3))
      {
        paramString2 = new JSONObject();
        try
        {
          paramJsBridgeListener = paramJsBridgeListener.getString("msg");
          paramString3 = this.mRuntime.a(this.mRuntime.a());
          if ((paramString3 != null) && ((paramString3 instanceof WebUiUtils.WebTitleBarInterface))) {
            QQToast.a(this.mRuntime.a(), paramJsBridgeListener, 0).b(((WebUiUtils.WebTitleBarInterface)paramString3).getTitleBarHeight());
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatFontJsPlugin", 2, "showBlackMsgBox failed: " + paramJsBridgeListener.getMessage());
            }
          }
        }
        super.callJs(paramString1, new String[] { paramString2.toString() });
        return true;
      }
      if ("isUseFont".equals(paramString3))
      {
        isUseFont(paramString1);
        return true;
      }
      if ("setFontSwitch".equals(paramString3))
      {
        setFontSwitch(paramJsBridgeListener, paramString1);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.w("ChatFontJsPlugin", 2, "NOT support method " + paramString3 + " yet!!");
      }
      return false;
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;) {}
    }
  }
  
  public void isUseFont(String paramString)
  {
    boolean bool1 = this.mRuntime.a().getSharedPreferences("font_open_switch", 4).getBoolean("isUserOpenFontSwitch_" + this.mRuntime.a().getAccount(), false);
    boolean bool2 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.chat_font.name());
    if ((bool1) || (bool2)) {}
    JSONObject localJSONObject;
    for (bool1 = true;; bool1 = false)
    {
      this.isUseFont = bool1;
      localJSONObject = new JSONObject();
      if (this.isUseFont) {
        break;
      }
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this.mRuntime.a(), 230).setTitle(this.mRuntime.a().getString(2131367535)).setMessage(this.mRuntime.a().getString(2131367871)).setPositiveButton(this.mRuntime.a().getString(2131367872), new ChatFontJsPlugin.3(this, localJSONObject, paramString)).setNegativeButton(this.mRuntime.a().getString(2131367873), new ChatFontJsPlugin.2(this, localJSONObject, paramString));
      localQQCustomDialog.show();
      localQQCustomDialog.setOnCancelListener(new ChatFontJsPlugin.4(this, localJSONObject, paramString));
      return;
    }
    try
    {
      localJSONObject.put("isUse", 1);
      callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      callJs(paramString, new String[] { localJSONException.getMessage() });
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
    }
    for (;;)
    {
      this.mReqBundle = new Bundle();
      this.mFontSize = new HashMap(4);
      this.mFontSize.put("small", Integer.valueOf(0));
      this.mFontSize.put("middle", Integer.valueOf(1));
      this.mFontSize.put("big", Integer.valueOf(2));
      this.mFontSize.put("bigger", Integer.valueOf(3));
      return;
      if (QLog.isColorLevel()) {
        QLog.e("ChatFontJsPlugin", 2, "ERROR!!! ChatFont market is not running in web process!");
      }
    }
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatFontJsPlugin", 2, "onPushMsg=" + paramBundle);
    }
    int i = paramBundle.getInt("srcType");
    int j;
    JSONObject localJSONObject;
    if ((i != 0) && (i == 2))
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
    label4:
    String str1;
    JSONObject localJSONObject;
    label204:
    do
    {
      String str2;
      do
      {
        do
        {
          do
          {
            do
            {
              break label4;
              break label4;
              break label4;
              for (;;)
              {
                return;
                if (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key)
                {
                  str1 = paramBundle.getString("cmd");
                  try
                  {
                    str2 = paramBundle.getString("callbackid");
                    paramBundle = paramBundle.getBundle("response");
                    localJSONObject = new JSONObject();
                    if (!"setupChatFont".equals(str1)) {
                      break label204;
                    }
                    localJSONObject.put("result", paramBundle.getInt("result"));
                    localJSONObject.put("message", paramBundle.getString("message"));
                    super.callJs(str2, new String[] { localJSONObject.toString() });
                    if (QLog.isColorLevel())
                    {
                      QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " Result = " + localJSONObject.toString());
                      return;
                    }
                  }
                  catch (Exception paramBundle) {}
                }
              }
            } while (!QLog.isColorLevel());
            QLog.e("ChatFontJsPlugin", 2, "Failed to handle cmd " + str1 + ", exception: " + paramBundle.getMessage());
            return;
            if (!"queryFontInfo".equals(str1)) {
              break;
            }
            super.callJs(str2, new String[] { paramBundle.getString("result") });
          } while (!QLog.isColorLevel());
          QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " Result = " + localJSONObject.toString());
          return;
          if (!"font_StopDownLoad".equals(str1)) {
            break;
          }
          localJSONObject.put("result", 0);
          super.callJs(str2, new String[] { localJSONObject.toString() });
        } while (!QLog.isColorLevel());
        QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " Result = " + localJSONObject.toString());
        return;
      } while (!"setFontSwtich".equals(str1));
      localJSONObject.put("result", 0);
      super.callJs(str2, new String[] { localJSONObject.toString() });
    } while (!QLog.isColorLevel());
    QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " Result = " + localJSONObject.toString());
  }
  
  public void queryLocal(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatFontJsPlugin", 2, "queryLocal:" + paramJSONObject);
    }
    JSONObject localJSONObject;
    Object localObject;
    int i;
    try
    {
      localJSONObject = new JSONObject();
      paramJSONObject = this.browserApp.a(null).createEntityManager();
      localObject = (ExtensionInfo)paramJSONObject.a(ExtensionInfo.class, this.browserApp.getAccount());
      paramJSONObject.a();
      localJSONObject.put("result", 0);
      if (localObject == null) {
        localJSONObject.put("currentId", 0L);
      }
      for (;;)
      {
        i = MobileQQ.getContext().getSharedPreferences("setting_text_size", 4).getInt("chat_text_size_type", 0);
        paramJSONObject = "small";
        Iterator localIterator = this.mFontSize.keySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (String)localIterator.next();
        if (((Integer)this.mFontSize.get(localObject)).intValue() != i) {
          break label459;
        }
        paramJSONObject = (JSONObject)localObject;
        break label459;
        localJSONObject.put("currentId", ((ExtensionInfo)localObject).uVipFont);
      }
      localJSONObject.put("currentSize", paramJSONObject);
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ChatFontJsPlugin", 2, "getFontId failed: " + paramJSONObject.getMessage());
      }
      super.callJs(paramString, new String[] { paramJSONObject.getMessage() });
      return;
    }
    boolean bool1 = this.mRuntime.a().getSharedPreferences("font_open_switch", 4).getBoolean("isUserOpenFontSwitch_" + this.mRuntime.a().getAccount(), false);
    boolean bool2 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.chat_font.name());
    if (!bool1) {
      if (!bool2) {
        break label468;
      }
    }
    for (;;)
    {
      if (i != 0) {
        localJSONObject.put("isOpen", 1);
      }
      for (;;)
      {
        paramJSONObject = new File(FontManager.b);
        localObject = new JSONArray();
        if ((paramJSONObject.exists()) && (paramJSONObject.isDirectory())) {
          paramJSONObject.listFiles(new ChatFontJsPlugin.1(this, (JSONArray)localObject));
        }
        localJSONObject.put("downloadedList", localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ChatFontJsPlugin", 2, localJSONObject.toString());
        }
        super.callJs(paramString, new String[] { localJSONObject.toString() });
        return;
        localJSONObject.put("isOpen", 0);
      }
      label459:
      break;
      i = 1;
      continue;
      label468:
      i = 0;
    }
  }
  
  public void setSize(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatFontJsPlugin", 2, "setSize:" + paramJSONObject);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      paramJSONObject = paramJSONObject.getString("size");
      ReportController.a(null, "CliOper", "", "", "Font_Mall", "change_" + paramJSONObject, 0, 0, "", "", "", "");
      int i;
      if (this.mFontSize.containsKey(paramJSONObject))
      {
        i = ((Integer)this.mFontSize.get(paramJSONObject)).intValue();
        localJSONObject.put("result", 0);
      }
      for (;;)
      {
        paramJSONObject = MobileQQ.getContext().getSharedPreferences("setting_text_size", 4).edit();
        paramJSONObject.putInt("chat_text_size_type", i);
        paramJSONObject.commit();
        localJSONObject.put("message", "success");
        super.callJs(paramString, new String[] { localJSONObject.toString() });
        return;
        localJSONObject.put("result", -1);
        localJSONObject.put("message", "size illege");
        super.callJs(paramString, new String[] { localJSONObject.toString() });
        i = 0;
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ChatFontJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */