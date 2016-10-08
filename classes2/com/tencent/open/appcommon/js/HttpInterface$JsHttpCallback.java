package com.tencent.open.appcommon.js;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;
import wtm;

public class HttpInterface$JsHttpCallback
  implements HttpCgiAsyncTask.Callback
{
  protected final WebView a;
  protected final String a;
  protected final boolean a;
  protected final String b;
  protected final String c;
  
  public HttpInterface$JsHttpCallback(HttpInterface paramHttpInterface, WebView paramWebView, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.b = paramString3;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.c = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(Exception paramException)
  {
    if ((!this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.hasRight()) || (this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.mHandler == null)) {
      return;
    }
    LogUtility.c("HttpInterface", "onException >>> ");
    paramException = this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.mHandler.obtainMessage(0);
    wtm localwtm = new wtm();
    localwtm.jdField_a_of_type_ComTencentSmttSdkWebView = this.jdField_a_of_type_ComTencentSmttSdkWebView;
    paramException.obj = localwtm;
    paramException.arg1 = 0;
    if (TextUtils.isEmpty(this.b)) {}
    for (localwtm.jdField_a_of_type_JavaLangString = ("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpError',{\"guid\":\"" + this.c + "\"});}void(0);");; localwtm.jdField_a_of_type_JavaLangString = ("javascript:" + this.b + "({\"guid\":\"" + this.c + "\",\"err\":\"" + "\"});void(0);"))
    {
      this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.mHandler.sendMessage(paramException);
      return;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((!this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.hasRight()) || (this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.mHandler == null)) {
      return;
    }
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    Message localMessage = this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.mHandler.obtainMessage(0);
    localwtm = new wtm();
    localwtm.jdField_a_of_type_ComTencentSmttSdkWebView = this.jdField_a_of_type_ComTencentSmttSdkWebView;
    localMessage.obj = localwtm;
    localMessage.arg1 = 0;
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        localJSONObject.put("guid", this.c);
        paramJSONObject = localJSONObject.toString();
        LogUtility.a("HttpInterface", "onResult >>> " + paramJSONObject);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          continue;
        }
        localwtm.jdField_a_of_type_JavaLangString = ("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpSuccess'," + paramJSONObject + ");}void(0);");
      }
      catch (JSONException paramJSONObject)
      {
        if (!TextUtils.isEmpty(this.b)) {
          continue;
        }
        localwtm.jdField_a_of_type_JavaLangString = ("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpError',{\"guid\":\"" + this.c + "\"});}void(0);");
        continue;
        localwtm.jdField_a_of_type_JavaLangString = ("javascript:" + this.b + "({\"guid\":\"" + this.c + "\",\"err\":\"json format error\"});void(0);");
        continue;
      }
      this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.mHandler.sendMessage(localMessage);
      return;
      paramJSONObject = new JSONObject();
      paramJSONObject.put("guid", this.c);
      paramJSONObject.put("content", localJSONObject.toString());
      paramJSONObject = paramJSONObject.toString();
      continue;
      localwtm.jdField_a_of_type_JavaLangString = ("javascript:" + this.jdField_a_of_type_JavaLangString + "(" + paramJSONObject + ");void(0);");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\appcommon\js\HttpInterface$JsHttpCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */