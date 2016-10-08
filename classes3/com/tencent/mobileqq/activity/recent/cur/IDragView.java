package com.tencent.mobileqq.activity.recent.cur;

public abstract interface IDragView
{
  public static final int a = -1;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  
  public abstract IDragView.OnChangeModeListener a();
  
  public abstract void setOnModeChangeListener(IDragView.OnChangeModeListener paramOnChangeModeListener);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\cur\IDragView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */