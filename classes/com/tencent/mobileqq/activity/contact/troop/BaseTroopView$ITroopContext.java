package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.util.MqqWeakReferenceHandler;

public abstract interface BaseTroopView$ITroopContext
{
  public static final int a = 0;
  public static final int b = 1;
  
  public abstract Activity a();
  
  public abstract View a();
  
  public abstract QQAppInterface a();
  
  public abstract ForwardBaseOption a();
  
  public abstract MqqWeakReferenceHandler a();
  
  public abstract void a(int paramInt, View.OnClickListener paramOnClickListener);
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(Runnable paramRunnable);
  
  public abstract void a(String paramString);
  
  public abstract boolean a();
  
  public abstract View b();
  
  public abstract View c();
  
  public abstract View d();
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\troop\BaseTroopView$ITroopContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */