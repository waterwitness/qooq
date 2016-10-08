package com.tencent.mobileqq.surfaceviewaction.action;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FlowerAction
  extends Action
{
  private float b;
  private int p;
  private int q;
  private int r;
  private int s;
  
  public FlowerAction(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat)
  {
    super(paramInt1, 11, 0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.p = paramInt2;
    this.q = paramInt3;
    this.r = paramInt4;
    this.s = paramInt5;
    this.b = paramFloat;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    this.a = (paramInt * 0.8F / this.m);
    if (this.a > 0.8F) {
      this.a = 0.8F;
    }
    this.l = ((int)(360.0F * paramInt * paramInt / (this.m * this.m)));
    this.i = (this.p + (this.r - this.p) * paramInt / this.m);
    this.j = ((int)(this.q + this.s * Math.sin(this.b * this.i)));
    super.a(paramInt, paramFloat);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\action\FlowerAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */