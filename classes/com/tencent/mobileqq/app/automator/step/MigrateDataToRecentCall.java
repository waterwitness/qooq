package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.qphone.base.util.QLog;

public class MigrateDataToRecentCall
  extends AsyncStep
{
  public MigrateDataToRecentCall()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    boolean bool = false;
    EntityManagerFactory localEntityManagerFactory = this.a.b.a();
    if ((localEntityManagerFactory instanceof QQEntityManagerFactory))
    {
      bool = ((QQEntityManagerFactory)localEntityManagerFactory).isUpdateFromLowV74();
      ((QQEntityManagerFactory)localEntityManagerFactory).resetUpdateFromLowV74();
    }
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQInitHandler", 2, "DB updated from low than v74,migrate recent call data..");
      }
      ((QCallFacade)this.a.b.getManager(37)).a();
    }
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\MigrateDataToRecentCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */