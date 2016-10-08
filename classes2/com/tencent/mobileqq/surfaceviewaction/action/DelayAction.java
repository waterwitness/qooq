package com.tencent.mobileqq.surfaceviewaction.action;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DelayAction
  extends Action
{
  public DelayAction(int paramInt)
  {
    super(paramInt, 0, 0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    super.a(paramInt, paramFloat);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\action\DelayAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */