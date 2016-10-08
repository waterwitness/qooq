package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import wol;
import wom;

public class SlideDetectListView
  extends XListView
  implements MotionViewSetter
{
  public static final float a = 1.73F;
  public int a;
  protected GestureDetector.SimpleOnGestureListener a;
  protected GestureDetector a;
  public View a;
  private SlideDetectListView.OnScrollGroupFloatingListener jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnScrollGroupFloatingListener;
  private SlideDetectListView.OnScrollToTopListener jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnScrollToTopListener;
  private SlideDetectListView.OnSlideListener jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener;
  public boolean a;
  float jdField_b_of_type_Float;
  public int b;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  public boolean b;
  public int c;
  protected boolean c;
  protected int d;
  protected int e;
  public int f;
  
  public SlideDetectListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.e = -1;
    this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = new wol(this);
    this.jdField_b_of_type_Float = 0.0F;
    super.setOnScrollListener(new wom(this));
    this.f = (ViewConfiguration.getTouchSlop() + 2);
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    int k = -1;
    int m = getChildCount();
    int i = k;
    View localView;
    if (m > 0)
    {
      if (!m()) {
        j = 0;
      }
    }
    else {
      for (;;)
      {
        i = k;
        if (j < m)
        {
          localView = getChildAt(j);
          if (paramInt > localView.getBottom()) {
            break label95;
          }
          if (!this.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(localView.hashCode()))) {
            break label74;
          }
          i = k;
        }
        label74:
        do
        {
          return i;
          paramInt = s() + j;
          i = paramInt;
        } while (!c());
        return paramInt - 1;
        label95:
        j += 1;
      }
    }
    int j = m - 1;
    for (;;)
    {
      i = k;
      if (j < 0) {
        break;
      }
      localView = getChildAt(j);
      if (paramInt >= localView.getTop())
      {
        i = k;
        if (this.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(localView.hashCode()))) {
          break;
        }
        paramInt = s() + j;
        i = paramInt;
        if (!c()) {
          break;
        }
        return paramInt - 1;
      }
      j -= 1;
    }
  }
  
  public View a(int paramInt)
  {
    if (paramInt != -1) {
      try
      {
        View localView = getChildAt(paramInt - s());
        return localView;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return null;
  }
  
  public void a(View paramView, Object paramObject, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(paramView.hashCode()));
    super.a(paramView, paramObject, paramBoolean);
  }
  
  public boolean a(View paramView)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(Integer.valueOf(paramView.hashCode()));
    return super.a(paramView);
  }
  
  public void b(View paramView, Object paramObject, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(paramView.hashCode()));
    super.b(paramView, paramObject, paramBoolean);
  }
  
  public boolean b(View paramView)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(Integer.valueOf(paramView.hashCode()));
    return super.b(paramView);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean == true)
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setPressed(false);
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener.b(this, this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_Int - m());
        }
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131296816);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    d();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector == null)
    {
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener, new Handler(Looper.getMainLooper()));
      this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
      for (;;)
      {
        if (this.jdField_c_of_type_Boolean == true)
        {
          label88:
          return false;
          this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
          this.jdField_c_of_type_Boolean = false;
          i = a(this.jdField_a_of_type_Int);
          if ((this.jdField_a_of_type_AndroidViewView != null) && (a(i) == this.jdField_a_of_type_AndroidViewView))
          {
            if (paramMotionEvent.getX() < this.jdField_a_of_type_AndroidViewView.getWidth() - this.d) {
              continue;
            }
            if ((this.e <= 0) || (this.jdField_a_of_type_AndroidViewView.getHeight() <= 0)) {
              break label343;
            }
            i = this.jdField_a_of_type_AndroidViewView.getTop() + this.jdField_a_of_type_AndroidViewView.getHeight() / 2;
            int j = this.e / 2;
            int k = this.e / 2;
            if ((this.jdField_a_of_type_Int <= j + i) && (this.jdField_a_of_type_Int >= i - k)) {
              break label343;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SlideDetectListView", 2, "accurate in delete:ycenter:" + i + ",motionheight:" + this.jdField_a_of_type_AndroidViewView.getHeight() + "deleareaHeight:" + this.e);
            }
          }
        }
      }
    }
    label343:
    for (int i = 0; i != 0; i = 1)
    {
      this.jdField_c_of_type_Boolean = true;
      return false;
      if (this.jdField_a_of_type_Boolean != true) {
        break;
      }
      return true;
      this.jdField_b_of_type_Boolean = false;
      break;
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Boolean == true)) {
        return true;
      }
      if (this.jdField_b_of_type_Boolean) {
        break label88;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Boolean == true))
    {
      setPressed(false);
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setPressed(false);
      }
      return true;
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      if (this.jdField_a_of_type_Boolean == true)
      {
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidViewView.setPressed(false);
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener.b(this, this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_Int - m());
          }
        }
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidViewView = null;
        return false;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setDeleteAreaDim(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void setDeleteAreaWidth(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setMotionView(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_b_of_type_Int = (m() + paramInt);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void setOnScrollGroupFloatingListener(SlideDetectListView.OnScrollGroupFloatingListener paramOnScrollGroupFloatingListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnScrollGroupFloatingListener = paramOnScrollGroupFloatingListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener) {}
  
  public void setOnScrollToTopListener(SlideDetectListView.OnScrollToTopListener paramOnScrollToTopListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnScrollToTopListener = paramOnScrollToTopListener;
  }
  
  public void setOnSlideListener(SlideDetectListView.OnSlideListener paramOnSlideListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener = paramOnSlideListener;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\SlideDetectListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */