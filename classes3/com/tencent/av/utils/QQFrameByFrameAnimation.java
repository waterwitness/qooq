package com.tencent.av.utils;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import hbn;

public class QQFrameByFrameAnimation
{
  public int a;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  public QQAnimationListener a;
  Runnable jdField_a_of_type_JavaLangRunnable;
  public int[] a;
  public int b;
  public int c;
  public int d;
  
  public QQFrameByFrameAnimation()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener = null;
    this.jdField_a_of_type_Int = 300;
    this.b = 0;
    this.c = 0;
    this.d = 0;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRunnable = new hbn(this);
  }
  
  public void a()
  {
    this.c += 1;
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0)) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_ArrayOfInt[(this.c % this.jdField_a_of_type_ArrayOfInt.length)]);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(QQAnimationListener paramQQAnimationListener)
  {
    this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener = paramQQAnimationListener;
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0))
    {
      this.c = 0;
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_ArrayOfInt[0]);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener.d();
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener != null) {
      this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener.a();
    }
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\QQFrameByFrameAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */