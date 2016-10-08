package com.tencent.mobileqq.activity.aio.anim;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ListView;

public abstract class AIOAnimationConatiner$AIOAnimator
{
  protected int a;
  public AIOAnimationConatiner a;
  public ListView a;
  
  public AIOAnimationConatiner$AIOAnimator(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
  }
  
  protected void a() {}
  
  protected void a(int paramInt) {}
  
  protected boolean a(int paramInt)
  {
    return false;
  }
  
  protected abstract boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  protected abstract boolean a(Object... paramVarArgs);
  
  protected void b() {}
  
  protected abstract void c();
  
  public void d()
  {
    AIOAnimationConatiner.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\anim\AIOAnimationConatiner$AIOAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */