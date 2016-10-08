package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import qkh;

public class UpdateTroop
  extends AsyncStep
{
  private TroopObserver a;
  
  public UpdateTroop()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new qkh(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(20)).a();
  }
  
  protected int a()
  {
    if (this.h == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getBoolean("isTrooplistok", false);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a();
      if (((localObject instanceof QQEntityManagerFactory)) && (((QQEntityManagerFactory)localObject).isUpdated())) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c = false;
      }
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getManager(51);
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "onCheckTroopList:Done");
        }
        TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(20);
        ((TroopManager)localObject).a();
        localTroopHandler.a(1, true, null);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(3, true, Integer.valueOf(2));
        return 7;
      }
      ((TroopManager)localObject).a();
      c();
    }
    for (;;)
    {
      return 2;
      c();
    }
  }
  
  public void a()
  {
    this.i = 2;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\UpdateTroop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */