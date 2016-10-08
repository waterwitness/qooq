package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import vnf;

public class TroopFilePreviewController
  extends FilePreViewControllerBase
{
  long jdField_a_of_type_Long;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
  public QQAppInterface a;
  TroopFileStatusInfo jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo;
  
  public TroopFilePreviewController(QQAppInterface paramQQAppInterface, long paramLong, TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo = paramTroopFileStatusInfo;
    this.jdField_a_of_type_Long = paramLong;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new vnf(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
  }
  
  public int a()
  {
    return 3;
  }
  
  public boolean a()
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (localTroopFileTransferManager == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.a != null) {
      localTroopFileTransferManager.d(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.a);
    }
    for (;;)
    {
      return true;
      localTroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_e_of_type_Int);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopFilePreviewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */