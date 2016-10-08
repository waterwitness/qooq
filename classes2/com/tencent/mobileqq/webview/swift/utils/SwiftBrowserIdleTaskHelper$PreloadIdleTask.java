package com.tencent.mobileqq.webview.swift.utils;

import android.content.MutableContextWrapper;
import com.tencent.biz.ui.WebViewPoolTouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebviewPoolUtils;
import com.tencent.qphone.base.util.QLog;

public class SwiftBrowserIdleTaskHelper$PreloadIdleTask
  extends SwiftBrowserIdleTaskHelper.IdleTask
{
  public SwiftBrowserIdleTaskHelper$PreloadIdleTask(int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    if (WebAccelerateHelper.getInstance().preloadBrowserView == null)
    {
      WebAccelerateHelper.getInstance().preInflaterBrowserView();
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserIdleTaskHelper", 2, "preloadBrowserView on idle.");
      }
      return 2;
    }
    if (WebviewPoolUtils.b == 0)
    {
      WebviewPoolUtils.a(new WebViewPoolTouchWebView(new MutableContextWrapper(BaseApplicationImpl.a)), false);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserIdleTaskHelper", 2, "preload Webview on idle.");
      }
      return 1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\utils\SwiftBrowserIdleTaskHelper$PreloadIdleTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */