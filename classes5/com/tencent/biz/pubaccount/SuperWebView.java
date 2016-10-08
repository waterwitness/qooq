package com.tencent.biz.pubaccount;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.smtt.sdk.WebView;

public abstract class SuperWebView
  extends WebView
{
  protected Intent a;
  
  public SuperWebView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SuperWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SuperWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void loadUrl(String paramString)
  {
    AIOOpenWebMonitor.a(this.a, paramString);
    super.loadUrl(paramString);
  }
  
  public void setIntent(Intent paramIntent)
  {
    this.a = paramIntent;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\SuperWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */