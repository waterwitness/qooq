package com.tencent.mobileqq.app.automator.step;

import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.remote.ToServiceMsg;
import cooperation.qlink.QlinkReliableReport;
import qjo;

public class GetSig
  extends AsyncStep
{
  private MessageObserver a;
  
  public GetSig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void c()
  {
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a("TransService.ReqGetSign");
    localToServiceMsg.extraData.putInt("ssover", 1);
    localToServiceMsg.extraData.putInt("app_id", AppSetting.a);
    localToServiceMsg.extraData.putByte("a2type", (byte)4);
    localToServiceMsg.extraData.putByteArray("enkey", this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getUinSign());
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(localToServiceMsg);
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new qjo(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
    c();
    return 2;
  }
  
  public void a()
  {
    ((ShieldListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(18)).a();
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b, true);
    QlinkReliableReport.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetSig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */