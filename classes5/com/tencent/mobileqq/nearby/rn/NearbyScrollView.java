package com.tencent.mobileqq.nearby.rn;

import android.content.Context;
import android.view.MotionEvent;
import com.facebook.react.views.scroll.ReactScrollView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ScrollListener;

public class NearbyScrollView
  extends ReactScrollView
{
  ScrollListener a;
  
  public NearbyScrollView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 1) || (i == 3)) {
      if (this.a != null) {
        this.a.a(this, paramMotionEvent.getX(), paramMotionEvent.getY());
      }
    }
    while ((i != 0) || (this.a == null)) {
      return bool;
    }
    this.a.b(this, paramMotionEvent.getX(), paramMotionEvent.getY());
    return bool;
  }
  
  public void fling(int paramInt)
  {
    super.fling(paramInt);
    if (this.a != null) {
      this.a.a(this, paramInt);
    }
  }
  
  protected float getTopFadingEdgeStrength()
  {
    return 0.0F;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null) {
      this.a.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setScrollListener(ScrollListener paramScrollListener)
  {
    this.a = paramScrollListener;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\rn\NearbyScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */