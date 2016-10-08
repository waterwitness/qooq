package com.tencent.mobileqq.surfaceviewaction.action;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.PrintStream;

public class RotateAction
  extends Action
{
  private int p;
  private int q;
  
  public RotateAction(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, 8, 0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.p = paramInt2;
    this.q = paramInt3;
  }
  
  public RotateAction(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, 8, paramInt4);
    this.p = paramInt2;
    this.q = paramInt3;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    System.out.println("time = " + paramInt + ", percent = " + paramFloat);
    this.l = ((int)(this.p + (this.q - this.p) * paramFloat));
    if (this.q - this.p > 0) {
      if (this.l >= this.q) {
        this.l = this.q;
      }
    }
    for (;;)
    {
      super.a(paramInt, paramFloat);
      return;
      if (this.l <= this.q) {
        this.l = this.q;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\action\RotateAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */