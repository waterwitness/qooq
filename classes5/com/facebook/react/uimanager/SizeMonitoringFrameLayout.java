package com.facebook.react.uimanager;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import javax.annotation.Nullable;

public class SizeMonitoringFrameLayout
  extends FrameLayout
{
  private OnFactSizeChangedListener mOnFactSizeChangedListener = null;
  @Nullable
  private OnSizeChangedListener mOnSizeChangedListener;
  
  public SizeMonitoringFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public SizeMonitoringFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SizeMonitoringFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mOnSizeChangedListener != null) {
      this.mOnSizeChangedListener.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void saveFactSize(int paramInt)
  {
    if (this.mOnFactSizeChangedListener != null) {
      this.mOnFactSizeChangedListener.onFactSizeChanged(paramInt);
    }
  }
  
  public void setOnFactSizeChangedListener(OnFactSizeChangedListener paramOnFactSizeChangedListener)
  {
    this.mOnFactSizeChangedListener = paramOnFactSizeChangedListener;
  }
  
  public void setOnSizeChangedListener(OnSizeChangedListener paramOnSizeChangedListener)
  {
    this.mOnSizeChangedListener = paramOnSizeChangedListener;
  }
  
  public static abstract interface OnSizeChangedListener
  {
    public abstract void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\SizeMonitoringFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */