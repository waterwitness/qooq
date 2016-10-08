package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.WebView;
import mqq.manager.TicketManager;

public class QQStoryWebView
  extends WebView
{
  private int a;
  
  public QQStoryWebView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QQStoryWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private String a(QQAppInterface paramQQAppInterface)
  {
    return ((TicketManager)paramQQAppInterface.getManager(2)).getSkey(paramQQAppInterface.getAccount());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getMeasuredHeight() < this.a) {
      setMeasuredDimension(getMeasuredWidth(), this.a);
    }
  }
  
  public void setCookies(QQAppInterface paramQQAppInterface, String paramString, CookieManager paramCookieManager)
  {
    if (paramString == null) {
      return;
    }
    String str = paramQQAppInterface.a();
    StringBuilder localStringBuilder;
    if (str.length() < 10)
    {
      localStringBuilder = new StringBuilder("o");
      int i = str.length();
      while (i < 10)
      {
        localStringBuilder.append("0");
        i += 1;
      }
    }
    for (str = str;; str = "o" + str)
    {
      paramCookieManager.setCookie(paramString, String.format("uin=%1$s; domain=.qq.com; path=/", new Object[] { str }));
      paramCookieManager.setCookie(paramString, String.format("skey=%1$s; domain=.qq.com; path=/", new Object[] { a(paramQQAppInterface) }));
      return;
    }
  }
  
  public void setMinHeight(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\view\widget\QQStoryWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */