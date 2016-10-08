package com.facebook.react.views.view;

import android.graphics.Rect;

public abstract interface ReactClippingViewGroup
{
  public abstract void getClippingRect(Rect paramRect);
  
  public abstract boolean getRemoveClippedSubviews();
  
  public abstract void setRemoveClippedSubviews(boolean paramBoolean);
  
  public abstract void updateClippingRect();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\view\ReactClippingViewGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */