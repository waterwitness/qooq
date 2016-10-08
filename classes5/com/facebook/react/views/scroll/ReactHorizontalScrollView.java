package com.facebook.react.views.scroll;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.HorizontalScrollView;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.react.views.view.ReactClippingViewGroup;
import com.facebook.react.views.view.ReactClippingViewGroupHelper;
import javax.annotation.Nullable;

public class ReactHorizontalScrollView
  extends HorizontalScrollView
  implements ReactClippingViewGroup
{
  @Nullable
  private Rect mClippingRect;
  private boolean mDoneFlinging;
  private boolean mDragging;
  private boolean mFlinging;
  private final OnScrollDispatchHelper mOnScrollDispatchHelper = new OnScrollDispatchHelper();
  private boolean mRemoveClippedSubviews;
  private boolean mScrollEnabled = true;
  private boolean mSendMomentumEvents;
  
  public ReactHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void fling(int paramInt)
  {
    super.fling(paramInt);
    if (this.mSendMomentumEvents)
    {
      this.mFlinging = true;
      ReactScrollViewHelper.emitScrollMomentumBeginEvent(this);
      postOnAnimationDelayed(new Runnable()
      {
        public void run()
        {
          if (ReactHorizontalScrollView.this.mDoneFlinging)
          {
            ReactHorizontalScrollView.access$102(ReactHorizontalScrollView.this, false);
            ReactScrollViewHelper.emitScrollMomentumEndEvent(ReactHorizontalScrollView.this);
            return;
          }
          ReactHorizontalScrollView.access$002(ReactHorizontalScrollView.this, true);
          ReactHorizontalScrollView.this.postOnAnimationDelayed(this, 20L);
        }
      }, 20L);
    }
  }
  
  public void getClippingRect(Rect paramRect)
  {
    paramRect.set((Rect)Assertions.assertNotNull(this.mClippingRect));
  }
  
  public boolean getRemoveClippedSubviews()
  {
    return this.mRemoveClippedSubviews;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mRemoveClippedSubviews) {
      updateClippingRect();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mScrollEnabled) {}
    while (!super.onInterceptTouchEvent(paramMotionEvent)) {
      return false;
    }
    NativeGestureUtil.notifyNativeGestureStarted(this, paramMotionEvent);
    ReactScrollViewHelper.emitScrollBeginDragEvent(this);
    this.mDragging = true;
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    scrollTo(getScrollX(), getScrollY());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    MeasureSpecAssertions.assertExplicitMeasureSpec(paramInt1, paramInt2);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mOnScrollDispatchHelper.onScrollChanged(paramInt1, paramInt2))
    {
      if (this.mRemoveClippedSubviews) {
        updateClippingRect();
      }
      if (this.mFlinging) {
        this.mDoneFlinging = false;
      }
      ReactScrollViewHelper.emitScrollEvent(this);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mRemoveClippedSubviews) {
      updateClippingRect();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mScrollEnabled) {
      return false;
    }
    if (((paramMotionEvent.getAction() & 0xFF) == 1) && (this.mDragging))
    {
      ReactScrollViewHelper.emitScrollEndDragEvent(this);
      this.mDragging = false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setRemoveClippedSubviews(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mClippingRect == null)) {
      this.mClippingRect = new Rect();
    }
    this.mRemoveClippedSubviews = paramBoolean;
    updateClippingRect();
  }
  
  public void setScrollEnabled(boolean paramBoolean)
  {
    this.mScrollEnabled = paramBoolean;
  }
  
  public void setSendMomentumEvents(boolean paramBoolean)
  {
    this.mSendMomentumEvents = paramBoolean;
  }
  
  public void updateClippingRect()
  {
    if (!this.mRemoveClippedSubviews) {}
    View localView;
    do
    {
      return;
      Assertions.assertNotNull(this.mClippingRect);
      ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
      localView = getChildAt(0);
    } while (!(localView instanceof ReactClippingViewGroup));
    ((ReactClippingViewGroup)localView).updateClippingRect();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\scroll\ReactHorizontalScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */