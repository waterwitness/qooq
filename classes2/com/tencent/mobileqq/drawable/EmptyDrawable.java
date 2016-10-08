package com.tencent.mobileqq.drawable;

import android.graphics.drawable.ColorDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class EmptyDrawable
  extends ColorDrawable
{
  private int a;
  private int b;
  
  public EmptyDrawable(int paramInt1, int paramInt2)
  {
    super(0);
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public EmptyDrawable(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramInt2;
    this.b = paramInt3;
  }
  
  public int getIntrinsicHeight()
  {
    return this.b;
  }
  
  public int getIntrinsicWidth()
  {
    return this.a;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\drawable\EmptyDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */