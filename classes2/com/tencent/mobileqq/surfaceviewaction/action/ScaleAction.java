package com.tencent.mobileqq.surfaceviewaction.action;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ScaleAction
  extends Action
{
  private float b;
  private float c;
  
  public ScaleAction(int paramInt, float paramFloat1, float paramFloat2)
  {
    super(paramInt, 2, 0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = paramFloat1;
    this.c = paramFloat2;
  }
  
  public ScaleAction(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    super(paramInt1, 2, paramInt2);
    this.b = paramFloat1;
    this.c = paramFloat2;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    this.a = (this.b + (this.c - this.b) * paramFloat);
    if (this.c - this.b > 0.0F) {
      if (this.a >= this.c) {
        this.a = this.c;
      }
    }
    for (;;)
    {
      if (paramInt >= this.m) {
        this.a = this.c;
      }
      super.a(paramInt, paramFloat);
      return;
      if (this.a <= this.c) {
        this.a = this.c;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\action\ScaleAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */