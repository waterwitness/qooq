package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ReportControllerImpl$ReportProxyAdapter
  extends BaseProxy
{
  public ReportControllerImpl$ReportProxyAdapter(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    ReportController localReportController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((localReportController != null) && ((localReportController instanceof ReportControllerImpl))) {
      ((ReportControllerImpl)localReportController).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager);
    }
  }
  
  protected void b()
  {
    ReportController localReportController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((localReportController != null) && ((localReportController instanceof ReportControllerImpl))) {
      ((ReportControllerImpl)localReportController).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\statistics\ReportControllerImpl$ReportProxyAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */