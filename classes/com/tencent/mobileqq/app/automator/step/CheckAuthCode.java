package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import qiq;

public class CheckAuthCode
  extends AsyncStep
{
  private ConfigObserver a;
  
  public CheckAuthCode()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new qiq(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.c(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    }
    if (((ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(4)).a()) {
      return 2;
    }
    return 7;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.b(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\CheckAuthCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */