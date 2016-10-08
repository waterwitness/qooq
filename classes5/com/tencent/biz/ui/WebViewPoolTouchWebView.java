package com.tencent.biz.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebviewPoolUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;

public class WebViewPoolTouchWebView
  extends TouchWebView
{
  public static final String i = WebViewPoolTouchWebView.class.getSimpleName();
  public boolean h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public WebViewPoolTouchWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WebViewPoolTouchWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean canGoBack()
  {
    if (this.h)
    {
      Object localObject = copyBackForwardList();
      if ((localObject != null) && (((WebBackForwardList)localObject).getSize() > 0))
      {
        localObject = ((WebBackForwardList)localObject).getItemAtIndex(0);
        if ((localObject != null) && ("about:blank".equals(((WebHistoryItem)localObject).getUrl()))) {
          return super.canGoBackOrForward(-2);
        }
      }
      return super.canGoBack();
    }
    return super.canGoBack();
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(i, 2, "WebViewPoolTouchWebView destroy");
    }
    if (!WebviewPoolUtils.a(this, true))
    {
      super.destroy();
      return;
    }
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\ui\WebViewPoolTouchWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */