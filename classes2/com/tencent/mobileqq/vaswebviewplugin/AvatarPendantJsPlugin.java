package com.tencent.mobileqq.vaswebviewplugin;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AvatarPendantJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "faceAddon";
  private static final String JS_REQUEST_SCHEME = "jsbridge";
  static final String LOG_TAG = "AvatarPendantJsPlugin";
  public static final int MENU_ITEM_SELECT_PHOTO = 1;
  public static final int MENU_ITEM_TAKE_PHOTO = 0;
  private BrowserAppInterface browserApp;
  
  public AvatarPendantJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "faceAddon";
  }
  
  private Bitmap getRoundFaceBitmap(String paramString)
  {
    if (new File(paramString).exists())
    {
      Object localObject = ImageUtil.a(new BitmapFactory.Options(), paramString, 200);
      try
      {
        paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        int i = paramString.getWidth();
        int j = paramString.getHeight();
        localObject = ImageUtil.a(paramString, i, i, j);
        paramString = (String)localObject;
        if (localObject != null)
        {
          paramString = (String)localObject;
          if (((Bitmap)localObject).getWidth() > 200) {
            paramString = ImageUtil.b((Bitmap)localObject, 200);
          }
        }
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        return null;
      }
    }
    return ImageUtil.a();
  }
  
  public void changeFace(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "changeFace: " + paramJSONObject);
    }
    paramJSONObject = (ActionSheet)ActionSheetHelper.a(this.mRuntime.a(), null);
    paramJSONObject.c("拍照");
    paramJSONObject.c("从相册选择");
    paramJSONObject.d("取消");
    paramJSONObject.a(new AvatarPendantJsPlugin.5(this, paramString, paramJSONObject));
    paramJSONObject.a(new AvatarPendantJsPlugin.6(this, paramString));
    paramJSONObject.show();
  }
  
  public void getFaceAddon(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "getFaceAddon: " + paramJSONObject);
    }
    ThreadManager.a(new AvatarPendantJsPlugin.1(this, paramString), 8, null, false);
  }
  
  public int getIPCResponseKey()
  {
    return this.mOnRemoteResp.key;
  }
  
  protected long getPluginBusiness()
  {
    return 2147484160L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"faceAddon".equals(paramString2)) || (paramString3 == null)) {}
    label283:
    do
    {
      for (;;)
      {
        return false;
        int i = paramString1.indexOf("=");
        if ((i != -1) && (i + 1 <= paramString1.length() - 1))
        {
          paramJsBridgeListener = paramString1.substring(i + 1);
          if (paramJsBridgeListener != null) {
            try
            {
              paramJsBridgeListener = URLDecoder.decode(paramJsBridgeListener, "UTF-8");
              if (paramJsBridgeListener == null) {}
            }
            catch (UnsupportedEncodingException paramJsBridgeListener)
            {
              try
              {
                paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
                if (paramJsBridgeListener == null) {}
              }
              catch (JSONException paramJsBridgeListener)
              {
                try
                {
                  for (;;)
                  {
                    paramString1 = paramJsBridgeListener.getString("callback");
                    if (paramString1 == null) {
                      break;
                    }
                    if (!"getFaceAddon".equals(paramString3)) {
                      break label283;
                    }
                    getFaceAddon(paramJsBridgeListener, paramString1);
                    return true;
                    paramJsBridgeListener = paramJsBridgeListener;
                    if (QLog.isColorLevel()) {
                      QLog.i("AvatarPendantJsPlugin", 2, "Failed to decode json str, " + paramJsBridgeListener.getMessage());
                    }
                    paramJsBridgeListener = null;
                  }
                  paramJsBridgeListener = paramJsBridgeListener;
                  if (QLog.isColorLevel()) {
                    QLog.i("AvatarPendantJsPlugin", 2, "Failed to parse json str, " + paramJsBridgeListener.getMessage());
                  }
                  paramJsBridgeListener = null;
                }
                catch (JSONException paramString1)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.i("AvatarPendantJsPlugin", 2, "Failed to parse callbackid, " + paramString1.getMessage());
                    }
                    paramString1 = null;
                  }
                  if ("updateFaceAddon".equals(paramString3))
                  {
                    updateFaceAddon(paramJsBridgeListener, paramString1);
                    return true;
                  }
                  if ("showMsgBox".equals(paramString3))
                  {
                    showMsgBox(paramJsBridgeListener, paramString1);
                    return true;
                  }
                  if ("changeFace".equals(paramString3))
                  {
                    changeFace(paramJsBridgeListener, paramString1);
                    return true;
                  }
                }
              }
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("AvatarPendantJsPlugin", 2, "NOT support method " + paramString3 + " yet!!");
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("AvatarPendantJsPlugin", 2, "ERROR!!! Pendant market is not running in web process!");
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {
      break label4;
    }
    label4:
    while (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key) {
      return;
    }
    String str1 = paramBundle.getString("cmd");
    for (;;)
    {
      try
      {
        String str2 = paramBundle.getString("callbackid");
        localObject1 = paramBundle.getBundle("request");
        localObject2 = paramBundle.getBundle("response");
        paramBundle = new JSONObject();
        if (!"changeAvatar".equals(str1)) {
          break label364;
        }
        if (!((Bundle)localObject2).getBoolean("updateResult")) {
          break label293;
        }
        localObject1 = getRoundFaceBitmap(((Bundle)localObject1).getString("path"));
        if (localObject1 != null) {
          break label201;
        }
        paramBundle.put("result", 1002);
        super.callJs(str2 + "(" + paramBundle.toString() + ");");
        return;
      }
      catch (Exception paramBundle) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("AvatarPendantJsPlugin", 2, "Failed to handle cmd " + str1 + ", exception: " + paramBundle.getMessage());
      return;
      label201:
      Object localObject2 = new ByteArrayOutputStream();
      ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
      String str3 = Base64Util.encodeToString(((ByteArrayOutputStream)localObject2).toByteArray(), 2);
      paramBundle.put("result", 1);
      paramBundle.put("file", "data:image/png;base64," + str3);
      paramBundle.put("size", ((Bitmap)localObject1).getWidth());
      ((ByteArrayOutputStream)localObject2).close();
      continue;
      label293:
      Object localObject1 = this.mRuntime.a(this.mRuntime.a());
      if ((localObject1 != null) && ((localObject1 instanceof WebUiUtils.WebTitleBarInterface))) {
        QQToast.a(this.mRuntime.a(), 2131370143, 0).b(((WebUiUtils.WebTitleBarInterface)localObject1).getTitleBarHeight());
      }
      paramBundle.put("result", 1001);
      continue;
      label364:
      boolean bool = "updatePendantId".equals(str1);
      if (!bool) {}
    }
  }
  
  public void showMsgBox(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "showMsgBox: " + paramJSONObject);
    }
    try
    {
      String str1 = paramJSONObject.getString("msg");
      String str2 = paramJSONObject.getString("title");
      paramJSONObject = paramJSONObject.getJSONArray("button");
      if (paramJSONObject.length() >= 1)
      {
        QQCustomDialogThreeBtns localQQCustomDialogThreeBtns = DialogUtil.a(this.mRuntime.a(), 230);
        localQQCustomDialogThreeBtns.a(str2);
        localQQCustomDialogThreeBtns.b(str1);
        localQQCustomDialogThreeBtns.a(paramJSONObject.getString(0), new AvatarPendantJsPlugin.2(this, paramString));
        if (paramJSONObject.length() >= 2) {
          localQQCustomDialogThreeBtns.b(paramJSONObject.getString(1), new AvatarPendantJsPlugin.3(this, paramString));
        }
        if (paramJSONObject.length() >= 3) {
          localQQCustomDialogThreeBtns.c(paramJSONObject.getString(2), new AvatarPendantJsPlugin.4(this, paramString));
        }
        localQQCustomDialogThreeBtns.show();
        paramJSONObject = new JSONObject();
        super.callJs(paramString + "(" + paramJSONObject.toString() + ");");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("AvatarPendantJsPlugin", 2, "no button message");
      }
      throw new Exception("no button message");
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvatarPendantJsPlugin", 2, "showMsgBox failed: " + paramJSONObject.getMessage());
      }
      super.callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  public void updateFaceAddon(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "updateFaceAddon: " + paramJSONObject);
    }
    try
    {
      long l = paramJSONObject.getLong("id");
      paramJSONObject = new Bundle();
      paramJSONObject.putString("uin", this.browserApp.getAccount());
      paramJSONObject.putLong("pendantId", l);
      super.sendRemoteReq(DataFactory.a("updatePendantId", paramString, this.mOnRemoteResp.key, paramJSONObject), false, false);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvatarPendantJsPlugin", 2, "updateFaceAddon failed: " + paramJSONObject.getMessage());
      }
      super.callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\AvatarPendantJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */