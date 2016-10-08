package com.tencent.open.appcommon.js;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsbridge.JsBridge.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import wtk;
import wtl;

public class OpenJsBridge$OpenJsBridgeListener
  extends JsBridge.JsBridgeListener
{
  public long b;
  String jdField_b_of_type_JavaLangString;
  WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  
  public OpenJsBridge$OpenJsBridgeListener(WebView paramWebView, long paramLong, String paramString)
  {
    super(paramWebView, paramLong, paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramWebView);
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, Object paramObject)
  {
    WebView localWebView = (WebView)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if ((localWebView == null) || (paramObject == null)) {
      return;
    }
    String str = "'undefined'";
    if ((paramObject instanceof String))
    {
      paramObject = ((String)paramObject).replace("\\", "\\\\").replace("'", "\\'");
      str = "'" + paramObject + "'";
    }
    for (;;)
    {
      new Handler(Looper.getMainLooper()).post(new wtk(this, paramString, str, localWebView));
      return;
      if (((paramObject instanceof Number)) || ((paramObject instanceof Long)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Double)) || ((paramObject instanceof Float))) {
        str = paramObject.toString();
      } else if ((paramObject instanceof Boolean)) {
        str = paramObject.toString();
      }
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("JB", 4, "onNoMatchMethod");
    }
    WebView localWebView = (WebView)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localWebView == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new wtl(this, paramString, localWebView));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\appcommon\js\OpenJsBridge$OpenJsBridgeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */