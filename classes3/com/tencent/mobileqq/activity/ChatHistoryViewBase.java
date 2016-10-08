package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import kya;

public abstract class ChatHistoryViewBase
{
  public ChatHistoryFileActivity a;
  public boolean f;
  
  public ChatHistoryViewBase()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.f = true;
  }
  
  public abstract View a();
  
  public abstract void a();
  
  public void a(int paramInt) {}
  
  public abstract void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext);
  
  public abstract boolean a();
  
  public abstract void b();
  
  protected boolean b()
  {
    return this.f;
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  protected void k()
  {
    this.f = false;
    new Handler().postDelayed(new kya(this), 1500L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ChatHistoryViewBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */