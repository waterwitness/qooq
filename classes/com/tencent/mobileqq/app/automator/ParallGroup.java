package com.tencent.mobileqq.app.automator;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ParallGroup
  extends StepGroup
  implements IResultListener
{
  private int k;
  
  public ParallGroup()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    this.k = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    for (;;)
    {
      AsyncStep localAsyncStep = a();
      if ((localAsyncStep == null) || (this.g == 8)) {
        break;
      }
      localAsyncStep.a = this;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b(localAsyncStep);
    }
    return 2;
  }
  
  public void a(AsyncStep paramAsyncStep, int paramInt)
  {
    try
    {
      paramInt = this.k - 1;
      this.k = paramInt;
      if (paramInt == 0)
      {
        a(7);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep);
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\ParallGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */