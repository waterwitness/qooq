package com.tencent.mobileqq.pb;

public abstract class PBPrimitiveField<T>
  extends PBField<T>
{
  private boolean hasFlag = false;
  
  public final boolean has()
  {
    return this.hasFlag;
  }
  
  public final void setHasFlag(boolean paramBoolean)
  {
    this.hasFlag = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pb\PBPrimitiveField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */