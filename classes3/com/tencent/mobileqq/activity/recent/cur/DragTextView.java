package com.tencent.mobileqq.activity.recent.cur;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import oyt;

public class DragTextView
  extends TextView
  implements IDragView
{
  private static int g;
  private static int h;
  private static int i;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private View jdField_a_of_type_AndroidViewView;
  private IDragView.OnChangeModeListener jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener;
  private boolean jdField_a_of_type_Boolean;
  private int j;
  
  public DragTextView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.j = -1;
    a(paramContext);
  }
  
  public DragTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.j = -1;
    a(paramContext);
  }
  
  public DragTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.j = -1;
    a(paramContext);
  }
  
  private static void a(Context paramContext)
  {
    if (g == 0)
    {
      float f = 16.0F * paramContext.getResources().getDisplayMetrics().density;
      g = (int)f;
      h = (int)(1.5F * f);
      i = (int)(f * 0.5F);
    }
  }
  
  private void a(View paramView, Rect paramRect)
  {
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    super.getGlobalVisibleRect(paramRect);
    if (this.j == 2)
    {
      paramRect.top = (paramRect.top - localRect.top - g);
      paramRect.left = (paramRect.left - localRect.left - i);
      paramRect.bottom = (paramRect.bottom - localRect.top + i);
      paramRect.right = (paramRect.right - localRect.left + g);
      return;
    }
    paramRect.top = (paramRect.top - localRect.top - h);
    paramRect.left = (paramRect.left - localRect.left - h);
    paramRect.bottom = (paramRect.bottom - localRect.top + g);
    paramRect.right = (paramRect.right - localRect.left + g);
  }
  
  public int a()
  {
    return this.j;
  }
  
  public IDragView.OnChangeModeListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && (paramBoolean)) {
      a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidGraphicsRect);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.j != -1) && (!this.jdField_a_of_type_Boolean) && (paramMotionEvent.getAction() == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener != null)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener.a(this, this.j);
        return true;
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setDragViewType(int paramInt)
  {
    setDragViewType(paramInt, null);
  }
  
  public void setDragViewType(int paramInt, View paramView)
  {
    this.j = paramInt;
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = ((ViewGroup)getParent());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener != null) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidGraphicsRect == null))
    {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      this.jdField_a_of_type_AndroidViewView.setTouchDelegate(new oyt(this, this.jdField_a_of_type_AndroidGraphicsRect, this));
    }
  }
  
  public void setOnModeChangeListener(IDragView.OnChangeModeListener paramOnChangeModeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener = paramOnChangeModeListener;
    if (QLog.isColorLevel()) {
      QLog.d("Drag", 2, "setOnModeChangeListener:" + paramOnChangeModeListener);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener != null) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidGraphicsRect == null))
    {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      this.jdField_a_of_type_AndroidViewView.setTouchDelegate(new oyt(this, this.jdField_a_of_type_AndroidGraphicsRect, this));
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0)) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\cur\DragTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */