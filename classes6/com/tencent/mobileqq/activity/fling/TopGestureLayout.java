package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatFragment.InterceptTouchEventListener;
import com.tencent.mobileqq.activity.ChatFragment.MyDispatchDrawListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;

public class TopGestureLayout
  extends RelativeLayout
{
  public static final int FLAG_GESTURE_END = -1;
  public static final int FLAG_GESTURE_FLING_LR = 1;
  public static final int FLAG_GESTURE_IDLE = 0;
  public static final String TAG = "TopGestureLayout";
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  public WeakReference mInterceptTouchEventListener;
  public ChatFragment.MyDispatchDrawListener mMyDispatchDrawListener;
  public TopGestureLayout.OnGestureListener mOnFlingGesture;
  public GestureDetector mTopGestureDetector;
  
  public TopGestureLayout(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    a(paramContext);
  }
  
  public TopGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    a(paramContext);
  }
  
  public TopGestureLayout(Context paramContext, ChatFragment.MyDispatchDrawListener paramMyDispatchDrawListener, ChatFragment.InterceptTouchEventListener paramInterceptTouchEventListener)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    a(paramContext);
    this.mMyDispatchDrawListener = paramMyDispatchDrawListener;
    this.mInterceptTouchEventListener = new WeakReference(paramInterceptTouchEventListener);
  }
  
  public void a(Context paramContext)
  {
    this.mTopGestureDetector = new GestureDetector(paramContext, new TopGestureLayout.TopGestureDetector(this, paramContext));
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    if (paramCanvas == null) {}
    for (;;)
    {
      return;
      try
      {
        super.dispatchDraw(paramCanvas);
        if (this.mMyDispatchDrawListener == null) {
          continue;
        }
        this.mMyDispatchDrawListener.a();
        return;
      }
      catch (Throwable paramCanvas)
      {
        for (;;)
        {
          paramCanvas.printStackTrace();
        }
      }
    }
  }
  
  public int getPaddingTop()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ImmersiveUtils.a(getContext());
    }
    return super.getPaddingTop();
  }
  
  public boolean hasGestureFlag(int paramInt)
  {
    return (!isGestureEnd()) && ((this.jdField_a_of_type_Int & paramInt) == paramInt);
  }
  
  public boolean isGestureEnd()
  {
    return this.jdField_a_of_type_Int == -1;
  }
  
  public boolean isGestureIdle()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if ((this.mInterceptTouchEventListener != null) && (this.mInterceptTouchEventListener.get() != null) && (!((ChatFragment.InterceptTouchEventListener)this.mInterceptTouchEventListener.get()).a(paramMotionEvent))) {
      return false;
    }
    return this.mTopGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.mTopGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public void setGestureFlag(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    this.jdField_a_of_type_Int = (this.jdField_a_of_type_Int & (paramInt ^ 0xFFFFFFFF) | paramInt);
  }
  
  public void setInterceptTouchFlag(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnFlingGesture(TopGestureLayout.OnGestureListener paramOnGestureListener)
  {
    this.mOnFlingGesture = paramOnGestureListener;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      super.setPadding(paramInt1, ImmersiveUtils.a(getContext()), paramInt3, paramInt4);
      return;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\fling\TopGestureLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */