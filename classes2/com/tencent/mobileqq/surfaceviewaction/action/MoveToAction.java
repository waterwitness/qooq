package com.tencent.mobileqq.surfaceviewaction.action;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MoveToAction
  extends Action
{
  private int p;
  private int q;
  private int r;
  private int s;
  
  public MoveToAction(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramInt1, 1, 0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.p = paramInt2;
    this.q = paramInt3;
    this.r = paramInt4;
    this.s = paramInt5;
  }
  
  public MoveToAction(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, 1, paramInt6);
    this.p = paramInt2;
    this.q = paramInt3;
    this.r = paramInt4;
    this.s = paramInt5;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    this.i = ((int)(this.p + (this.r - this.p) * paramFloat));
    this.j = ((int)(this.q + (this.s - this.q) * paramFloat));
    if (this.r - this.p > 0)
    {
      if (this.i >= this.r) {
        this.i = this.r;
      }
      if (this.s - this.q <= 0) {
        break label161;
      }
      if (this.j >= this.s) {
        this.j = this.s;
      }
    }
    for (;;)
    {
      if (paramInt >= this.m)
      {
        this.i = this.r;
        this.j = this.s;
      }
      super.a(paramInt, paramFloat);
      return;
      if (this.i > this.r) {
        break;
      }
      this.i = this.r;
      break;
      label161:
      if (this.j <= this.s) {
        this.j = this.s;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\action\MoveToAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */