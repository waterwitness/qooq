package com.tencent.biz.pubaccount.readinjoy;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class ReadInJoyBaseViewController
{
  protected Activity a;
  
  protected ReadInJoyBaseViewController()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected ReadInJoyBaseViewController(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public long a()
  {
    return 0L;
  }
  
  public Activity a()
  {
    return this.a;
  }
  
  public ViewGroup a()
  {
    return null;
  }
  
  public VideoPlayManager a()
  {
    return null;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(ViewGroup paramViewGroup) {}
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\ReadInJoyBaseViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */