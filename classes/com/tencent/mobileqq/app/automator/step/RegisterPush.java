package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.observer.AccountObserver;
import qka;

public class RegisterPush
  extends AsyncStep
{
  private AccountObserver a;
  
  public RegisterPush()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().e();
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.m();
    return 2;
  }
  
  public void a()
  {
    if (this.h == 13) {}
    for (this.i = 0;; this.i = 10)
    {
      this.jdField_a_of_type_MqqObserverAccountObserver = new qka(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqObserverAccountObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
      this.jdField_a_of_type_MqqObserverAccountObserver = null;
    }
    if ((this.h == 12) && (this.g == 6)) {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.g();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\RegisterPush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */