package com.tencent.mobileqq.surfaceviewaction.action;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class OpacityAction
  extends Action
{
  private int p;
  private int q;
  
  public OpacityAction(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, 4, 0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.p = paramInt2;
    this.q = paramInt3;
  }
  
  public OpacityAction(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, 4, paramInt4);
    this.p = paramInt2;
    this.q = paramInt3;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    this.k = ((int)(this.p + (this.q - this.p) * paramFloat));
    if (this.q - this.p > 0) {
      if (this.k >= this.q) {
        this.k = this.q;
      }
    }
    for (;;)
    {
      super.a(paramInt, paramFloat);
      return;
      if (this.k <= this.q) {
        this.k = this.q;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\action\OpacityAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */