package com.tencent.mobileqq.webprocess;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.tencent.biz.ui.WebViewPoolTouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class WebviewPoolUtils
{
  public static final int a = 4;
  public static final String a;
  public static final WebViewPoolTouchWebView[] a;
  public static int b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = WebviewPoolUtils.class.getSimpleName();
    jdField_a_of_type_ArrayOfComTencentBizUiWebViewPoolTouchWebView = new WebViewPoolTouchWebView[4];
  }
  
  public static WebViewPoolTouchWebView a()
  {
    WebViewPoolTouchWebView localWebViewPoolTouchWebView2;
    WebViewPoolTouchWebView localWebViewPoolTouchWebView1;
    if ((b > 0) && (jdField_a_of_type_ArrayOfComTencentBizUiWebViewPoolTouchWebView != null))
    {
      int i = b - 1;
      localWebViewPoolTouchWebView2 = jdField_a_of_type_ArrayOfComTencentBizUiWebViewPoolTouchWebView[i];
      jdField_a_of_type_ArrayOfComTencentBizUiWebViewPoolTouchWebView[i] = null;
      b -= 1;
      localWebViewPoolTouchWebView1 = localWebViewPoolTouchWebView2;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "acquire1 :webpool size = " + b);
        localWebViewPoolTouchWebView1 = localWebViewPoolTouchWebView2;
      }
    }
    do
    {
      return localWebViewPoolTouchWebView1;
      localWebViewPoolTouchWebView2 = new WebViewPoolTouchWebView(new MutableContextWrapper(BaseApplicationImpl.a));
      localWebViewPoolTouchWebView1 = localWebViewPoolTouchWebView2;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "acquire2 :webpool size = " + b);
    return localWebViewPoolTouchWebView2;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "webviewpool init");
    }
    if (b != 0) {}
    do
    {
      return;
      b = 1;
      System.currentTimeMillis();
      MutableContextWrapper localMutableContextWrapper = new MutableContextWrapper(BaseApplicationImpl.a);
      jdField_a_of_type_ArrayOfComTencentBizUiWebViewPoolTouchWebView[0] = new WebViewPoolTouchWebView(localMutableContextWrapper);
      System.currentTimeMillis();
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "webviewpool init poolSize = " + b);
  }
  
  private static boolean a(WebViewPoolTouchWebView paramWebViewPoolTouchWebView)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < b)
      {
        if (jdField_a_of_type_ArrayOfComTencentBizUiWebViewPoolTouchWebView[i] == paramWebViewPoolTouchWebView) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean a(WebViewPoolTouchWebView paramWebViewPoolTouchWebView, boolean paramBoolean)
  {
    if (!a(paramWebViewPoolTouchWebView))
    {
      paramWebViewPoolTouchWebView.clearHistory();
      Context localContext = paramWebViewPoolTouchWebView.getContext();
      if ((localContext instanceof MutableContextWrapper))
      {
        ((MutableContextWrapper)localContext).setBaseContext(BaseApplicationImpl.a);
        if (b < jdField_a_of_type_ArrayOfComTencentBizUiWebViewPoolTouchWebView.length)
        {
          paramWebViewPoolTouchWebView.h = paramBoolean;
          jdField_a_of_type_ArrayOfComTencentBizUiWebViewPoolTouchWebView[b] = paramWebViewPoolTouchWebView;
          b += 1;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "release1 :webpool size = " + b);
          }
          return true;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "release2 :webpool size = " + b);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webprocess\WebviewPoolUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */