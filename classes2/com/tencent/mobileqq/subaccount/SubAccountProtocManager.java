package com.tencent.mobileqq.subaccount;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindHandler;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import uxm;
import uxn;

public class SubAccountProtocManager
  implements Manager
{
  private static final long jdField_a_of_type_Long = 86400000L;
  private static final String jdField_a_of_type_JavaLangString = "Q.subaccount.SubAccountProtocManager";
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  private static byte[] jdField_c_of_type_ArrayOfByte = new byte[0];
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new uxm(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new uxn(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SubAccountProtocManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountProtocManager", 2, "SubAccountProtocManager: manager init");
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    synchronized (jdField_c_of_type_ArrayOfByte)
    {
      if (this.jdField_c_of_type_Boolean) {
        return;
      }
    }
    this.jdField_c_of_type_Boolean = true;
    ((SubAccountBindHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).a();
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    synchronized (jdField_b_of_type_ArrayOfByte)
    {
      if (this.jdField_b_of_type_Boolean) {
        return;
      }
    }
    this.jdField_b_of_type_Boolean = true;
    ((SubAccountBindHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).a(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    ((SubAccountBindHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).a(paramString1, paramString2, paramString3);
  }
  
  public boolean a()
  {
    synchronized (jdField_c_of_type_ArrayOfByte)
    {
      boolean bool = this.d;
      return bool;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    if (ThreadManager.b() != null) {
      ThreadManager.b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\subaccount\SubAccountProtocManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */