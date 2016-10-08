package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DatalineMessagePcManager
  extends DatalineMessageManager
{
  public DatalineMessagePcManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = AppConstants.aj;
    this.jdField_a_of_type_Int = 6000;
  }
  
  protected DataLineMsgProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
  }
  
  protected void a()
  {
    ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\DatalineMessagePcManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */