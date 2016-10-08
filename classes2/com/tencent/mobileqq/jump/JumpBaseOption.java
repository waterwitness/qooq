package com.tencent.mobileqq.jump;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class JumpBaseOption
{
  protected Activity a;
  protected Intent a;
  protected Bundle a;
  protected QQAppInterface a;
  
  public JumpBaseOption(Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramIntent;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected abstract boolean c();
  
  public final boolean d()
  {
    if (b()) {}
    while (a()) {
      return true;
    }
    return c();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\jump\JumpBaseOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */