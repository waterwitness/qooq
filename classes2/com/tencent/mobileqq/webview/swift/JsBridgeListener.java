package com.tencent.mobileqq.webview.swift;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;

@Deprecated
public class JsBridgeListener
{
  public long a;
  WeakReference a;
  public boolean a;
  
  public JsBridgeListener(WebView paramWebView, long paramLong, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebView);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public JsBridgeListener(WebView paramWebView, long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebView);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static String a(int paramInt, Object paramObject, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return String.format("{'r':%d,'result':'%s'}", new Object[] { Integer.valueOf(paramInt), paramString });
    }
    if (paramObject == null) {
      return String.format("{'r':%d,'result':'%s'}", new Object[] { Integer.valueOf(paramInt), paramString });
    }
    if (((paramObject instanceof Number)) || ((paramObject instanceof Boolean))) {}
    for (paramObject = paramObject.toString();; paramObject = "'" + paramObject.toString().replace("\\", "\\\\").replace("'", "\\'") + "'") {
      return String.format("{'r':0,'result':%s}", new Object[] { paramObject });
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("JB", 4, "onPermissionDenied");
    }
    if (this.jdField_a_of_type_Long == -1L) {}
    WebView localWebView;
    do
    {
      return;
      localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localWebView == null);
    localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.jdField_a_of_type_Long + ",{'r':2,'result':'Permission denied'})");
  }
  
  @Deprecated
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_Long == -1L) {}
    WebView localWebView;
    do
    {
      return;
      localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localWebView == null);
    if (paramObject == null)
    {
      localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.jdField_a_of_type_Long + ",{'r':0});");
      return;
    }
    if (((paramObject instanceof Number)) || ((paramObject instanceof Boolean))) {}
    for (paramObject = paramObject.toString();; paramObject = "'" + paramObject.toString().replace("\\", "\\\\").replace("'", "\\'") + "'")
    {
      localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.jdField_a_of_type_Long + ",{'r':0,'result':" + (String)paramObject + "});");
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("JB", 4, "onNoMatchMethod");
    }
    if (this.jdField_a_of_type_Long == -1L) {}
    WebView localWebView;
    do
    {
      return;
      localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localWebView == null);
    localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.jdField_a_of_type_Long + ",{'r':1,'result':'" + paramString + "'})");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\JsBridgeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */