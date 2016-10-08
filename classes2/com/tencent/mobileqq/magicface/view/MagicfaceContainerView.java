package com.tencent.mobileqq.magicface.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import tbg;

public class MagicfaceContainerView
  extends RelativeLayout
{
  public static final int a = 150;
  private GestureDetector.SimpleOnGestureListener jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private MagicfaceContainerView.MagicfaceGestureListener jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView$MagicfaceGestureListener;
  boolean jdField_a_of_type_Boolean;
  
  public MagicfaceContainerView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = new tbg(this);
  }
  
  public MagicfaceContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = new tbg(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setMagicfaceGestureListener(MagicfaceContainerView.MagicfaceGestureListener paramMagicfaceGestureListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView$MagicfaceGestureListener = paramMagicfaceGestureListener;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\magicface\view\MagicfaceContainerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */