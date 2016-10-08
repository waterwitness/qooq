package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import vqm;

public class TroopFileUploadingManager
{
  public static TroopFileUploadingManager a;
  public static final String a = "TroopFileUploadingManager";
  public BizTroopObserver a;
  public QQAppInterface a;
  
  public TroopFileUploadingManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new vqm(this);
  }
  
  public static TroopFileUploadingManager a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager == null) {
      b(paramQQAppInterface);
    }
    for (;;)
    {
      return jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager;
      if (jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
      {
        jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
        jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager = null;
        b(paramQQAppInterface);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager != null) && (jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface))
    {
      paramQQAppInterface.b(jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager = null;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager = new TroopFileUploadingManager();
    jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.a(jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopFileUploadingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */