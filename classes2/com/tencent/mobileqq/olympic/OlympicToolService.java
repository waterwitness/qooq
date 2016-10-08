package com.tencent.mobileqq.olympic;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class OlympicToolService
  extends MobileQQServiceBase
{
  public static final String a;
  OlympicToolAppInterface jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface;
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = OlympicToolService.class.getSimpleName();
  }
  
  OlympicToolService(OlympicToolAppInterface paramOlympicToolAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "new OlympicToolService");
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface = paramOlympicToolAppInterface;
    c = Math.abs(this.jdField_a_of_type_JavaUtilRandom.nextInt());
  }
  
  public AppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface;
  }
  
  protected void a()
  {
    try
    {
      super.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    super.b(paramToServiceMsg, null, OlympicToolServlet.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\olympic\OlympicToolService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */