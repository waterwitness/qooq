package com.tencent.mobileqq.camera;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.MotionEvent;

public abstract interface CameraModule
{
  public abstract void a();
  
  public abstract void a(Context paramContext);
  
  public abstract void a(Configuration paramConfiguration);
  
  public abstract boolean a();
  
  public abstract boolean a(int paramInt, KeyEvent paramKeyEvent);
  
  public abstract boolean a(MotionEvent paramMotionEvent);
  
  public abstract void b();
  
  public abstract boolean b();
  
  public abstract boolean b(int paramInt, KeyEvent paramKeyEvent);
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\CameraModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */