package com.tencent.mobileqq.util;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import vyh;

public class FetchBuddyAndTroopNameHelper
{
  private static final String jdField_a_of_type_JavaLangString = FetchBuddyAndTroopNameHelper.class.getSimpleName();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FetchInfoListManager jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FetchBuddyAndTroopNameHelper(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private FetchInfoListManager a()
  {
    return new FetchInfoListManager(new vyh(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager.a();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager = a();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager.a(2, paramString, null, null, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager = a();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager.a(3, paramString1, paramString2, paramString3, paramBundle);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager = a();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager.a(1, paramString, null, null, null);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager = a();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager.a(4, paramString, null, null, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\FetchBuddyAndTroopNameHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */