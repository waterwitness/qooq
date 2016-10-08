package com.tencent.biz;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SoftKeyboardObserver
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private static final int jdField_a_of_type_Int = 100;
  private View jdField_a_of_type_AndroidViewView;
  private SoftKeyboardObserver.OnSoftKeyboardToggledListener jdField_a_of_type_ComTencentBizSoftKeyboardObserver$OnSoftKeyboardToggledListener;
  private boolean jdField_a_of_type_Boolean;
  
  public SoftKeyboardObserver(View paramView, SoftKeyboardObserver.OnSoftKeyboardToggledListener paramOnSoftKeyboardToggledListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver$OnSoftKeyboardToggledListener = paramOnSoftKeyboardToggledListener;
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver$OnSoftKeyboardToggledListener = null;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    int i = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight();
    int j = localRect.bottom;
    int k = localRect.top;
    if (this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver$OnSoftKeyboardToggledListener != null) {
      if (i - (j - k) < 100) {
        break label94;
      }
    }
    label94:
    for (boolean bool = true;; bool = false)
    {
      if (bool != this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = bool;
        this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver$OnSoftKeyboardToggledListener.a(bool, localRect.right, localRect.bottom);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\SoftKeyboardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */