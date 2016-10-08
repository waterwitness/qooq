package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneFeedActionJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String a = "TopicComment";
  public static final String b = "QZoneFeedActionJsPlugin";
  public static final String c = "H5PayCallBack";
  public static final String d = "FeedAction#isActive";
  public static final String e = "openVipInfo";
  public static String f = "";
  private boolean a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(String paramString)
  {
    Object localObject1 = new Intent("action_js2qzone");
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("cmd", "H5PayCallSucess");
    ((Intent)localObject1).putExtras((Bundle)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneFeedActionJsPlugin", 2, "handleWriteBlog actionString: " + ((Intent)localObject1).getAction());
    }
    QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), QZoneHelper.UserInfo.a(), (Intent)localObject1);
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localObject1 = new JSONObject();
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("vipType", paramString);
      ((JSONObject)localObject1).put("type", "YellowInfo");
      ((JSONObject)localObject1).put("data", localObject2);
      localObject2 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put("*.qzone.qq.com");
      ((JSONObject)localObject2).put("echo", true);
      ((JSONObject)localObject2).put("broadcast", true);
      ((JSONObject)localObject2).put("domains", localJSONArray);
      a("openVipInfo", (JSONObject)localObject1, (JSONObject)localObject2);
      if (("normalVip".equals(paramString)) || ("highVip".equals(paramString)))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
        if (paramString != null) {
          paramString.finish();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneFeedActionJsPlugin", 2, "handleJsRequest: ", localException);
        }
      }
    }
  }
  
  private void a(String... paramVarArgs)
  {
    if (LocalMultiProcConfig.a("FeedAction#isActive", false)) {
      return;
    }
    LocalMultiProcConfig.b("FeedAction#isActive", true);
    String str2 = "";
    String str3 = "";
    int i15 = 0;
    i2 = 0;
    int i14 = 0;
    i3 = 0;
    int i13 = 0;
    i4 = 0;
    int i12 = 0;
    i5 = 0;
    int i11 = 0;
    i6 = 0;
    String str1 = "";
    int i10 = 0;
    i7 = 0;
    i9 = 0;
    localObject6 = str2;
    localObject5 = str3;
    i1 = i6;
    n = i3;
    m = i2;
    k = i4;
    j = i5;
    localObject4 = str1;
    i = i7;
    i8 = i9;
    if (paramVarArgs != null)
    {
      localObject6 = str2;
      localObject5 = str3;
      i1 = i6;
      n = i3;
      m = i2;
      k = i4;
      j = i5;
      localObject4 = str1;
      i = i7;
      i8 = i9;
      if (paramVarArgs.length > 0)
      {
        localObject1 = str2;
        localObject2 = str3;
        i2 = i11;
        i3 = i14;
        i4 = i15;
        i5 = i13;
        i6 = i12;
        localObject3 = str1;
        i7 = i10;
      }
    }
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      localObject1 = str2;
      localObject2 = str3;
      i2 = i11;
      i3 = i14;
      i4 = i15;
      i5 = i13;
      i6 = i12;
      localObject3 = str1;
      i7 = i10;
      localObject5 = paramVarArgs.optString("content");
      localObject1 = str2;
      localObject2 = localObject5;
      i2 = i11;
      i3 = i14;
      i4 = i15;
      i5 = i13;
      i6 = i12;
      localObject3 = str1;
      i7 = i10;
      localObject6 = paramVarArgs.optString("placeholder");
      localObject1 = localObject6;
      localObject2 = localObject5;
      i2 = i11;
      i3 = i14;
      i4 = i15;
      i5 = i13;
      i6 = i12;
      localObject3 = str1;
      i7 = i10;
      m = paramVarArgs.optInt("needEmoticonBtn");
      localObject1 = localObject6;
      localObject2 = localObject5;
      i2 = i11;
      i3 = i14;
      i4 = m;
      i5 = i13;
      i6 = i12;
      localObject3 = str1;
      i7 = i10;
      n = paramVarArgs.optInt("needAtBtn");
      localObject1 = localObject6;
      localObject2 = localObject5;
      i2 = i11;
      i3 = n;
      i4 = m;
      i5 = i13;
      i6 = i12;
      localObject3 = str1;
      i7 = i10;
      k = paramVarArgs.optInt("needPrivateBtn");
      localObject1 = localObject6;
      localObject2 = localObject5;
      i2 = i11;
      i3 = n;
      i4 = m;
      i5 = k;
      i6 = i12;
      localObject3 = str1;
      i7 = i10;
      j = paramVarArgs.optInt("isReply");
      localObject1 = localObject6;
      localObject2 = localObject5;
      i2 = i11;
      i3 = n;
      i4 = m;
      i5 = k;
      i6 = j;
      localObject3 = str1;
      i7 = i10;
      i1 = paramVarArgs.optInt("privateCommentStatus");
      localObject1 = localObject6;
      localObject2 = localObject5;
      i2 = i1;
      i3 = n;
      i4 = m;
      i5 = k;
      i6 = j;
      localObject3 = str1;
      i7 = i10;
      f = paramVarArgs.optString("callback");
      localObject1 = localObject6;
      localObject2 = localObject5;
      i2 = i1;
      i3 = n;
      i4 = m;
      i5 = k;
      i6 = j;
      localObject3 = str1;
      i7 = i10;
      this.jdField_a_of_type_Boolean = paramVarArgs.optBoolean("acceptEncoded");
      localObject1 = localObject6;
      localObject2 = localObject5;
      i2 = i1;
      i3 = n;
      i4 = m;
      i5 = k;
      i6 = j;
      localObject3 = str1;
      i7 = i10;
      localObject4 = paramVarArgs.optString("btntext");
      localObject1 = localObject6;
      localObject2 = localObject5;
      i2 = i1;
      i3 = n;
      i4 = m;
      i5 = k;
      i6 = j;
      localObject3 = localObject4;
      i7 = i10;
      i = paramVarArgs.optInt("maxTextLength");
      localObject1 = localObject6;
      localObject2 = localObject5;
      i2 = i1;
      i3 = n;
      i4 = m;
      i5 = k;
      i6 = j;
      localObject3 = localObject4;
      i7 = i;
      i8 = paramVarArgs.optInt("groupdId");
    }
    catch (JSONException paramVarArgs)
    {
      for (;;)
      {
        localObject6 = localObject1;
        localObject5 = localObject2;
        i1 = i2;
        n = i3;
        m = i4;
        k = i5;
        j = i6;
        localObject4 = localObject3;
        i = i7;
        i8 = i9;
        if (QLog.isColorLevel())
        {
          QLog.d("QZoneFeedActionJsPlugin", 2, "handleFeedActionPanel: ", paramVarArgs);
          localObject6 = localObject1;
          localObject5 = localObject2;
          i1 = i2;
          n = i3;
          m = i4;
          k = i5;
          j = i6;
          localObject4 = localObject3;
          i = i7;
          i8 = i9;
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneFeedActionJsPlugin", 4, new Object[] { "handleFeedActionPanel hint is: " + (String)localObject6 + "\t autofill:" + (String)localObject5 + ",needEmoticonBtn: " + m + ",needAtBtn: " + n + ",needPrivateBtn: " + k + ",isReply: " + j + ",privateCommentStatus: " + i1 + ",maxLen: " + i + ",troopid: " + i8, "acceptEncoded:" + this.jdField_a_of_type_Boolean });
    }
    i2 = QZoneWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, 2);
    QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), QZoneHelper.UserInfo.a(), i2, (String)localObject6, (String)localObject5, "", "", i1, n, m, 0, k, j, (String)localObject4, i, i8, false);
  }
  
  public void a()
  {
    LocalMultiProcConfig.b("FeedAction#isActive", false);
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    switch (paramByte)
    {
    default: 
      break;
    }
    do
    {
      return;
    } while (paramInt != -1);
    paramByte = paramIntent.getIntExtra("extraprivateiconstate", -1);
    String str = paramIntent.getStringExtra("contentIntentKey");
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label239;
        }
        paramIntent = URLEncoder.encode(str, "utf-8");
        paramIntent = paramIntent.replace("\\", "\\\\").replace("\"", "\\\"");
        paramIntent = "{content:\"" + paramIntent + "\",privateComment:\"" + paramByte + "\"}";
        paramIntent = "window." + f + "(" + paramIntent + ");";
        if (QLog.isColorLevel()) {
          QLog.d("QZoneFeedActionJsPlugin", 2, "invoke callback js:" + paramIntent);
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().c(paramIntent);
        return;
      }
      catch (Throwable paramIntent) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QZoneFeedActionJsPlugin", 2, "content:" + str, paramIntent);
      return;
      label239:
      paramIntent = str;
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneFeedActionJsPlugin", 2, "handleJsRequest \n url: " + paramString1 + "\n pkgName:" + paramString2 + "\n method:" + paramString3);
    }
    if ("TopicComment".equalsIgnoreCase(paramString3))
    {
      a(paramVarArgs);
      return true;
    }
    if ("H5PayCallBack".equalsIgnoreCase(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        if ((paramJsBridgeListener.has("status")) && ("success".equalsIgnoreCase(paramJsBridgeListener.getString("status"))))
        {
          a(paramJsBridgeListener.optString("vipType", null));
          return true;
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneFeedActionJsPlugin", 2, "handleJsRequest: ", paramJsBridgeListener);
        }
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QZoneFeedActionJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */