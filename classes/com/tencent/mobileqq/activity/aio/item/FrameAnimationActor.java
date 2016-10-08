package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import njv;

public class FrameAnimationActor
{
  public int a;
  public View a;
  public FrameAnimationActor.Listener a;
  private Runnable a;
  public int[] a;
  public int b;
  public int c;
  
  public FrameAnimationActor(View paramView, int[] paramArrayOfInt, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = 0;
    this.c = 0;
    this.jdField_a_of_type_JavaLangRunnable = new njv(this);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.c = paramInt;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Int = ((int)(paramLong / this.c));
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfInt.length)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int]);
      this.jdField_a_of_type_AndroidViewView.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_ArrayOfInt[this.b]);
  }
  
  public void a(FrameAnimationActor.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener = paramListener;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\FrameAnimationActor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */