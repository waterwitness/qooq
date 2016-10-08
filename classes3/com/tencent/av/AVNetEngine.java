package com.tencent.av;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.OldHttpEngine;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorFlowCount;
import geh;

public class AVNetEngine
{
  private static INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private static IHttpCommunicatorFlowCount jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount = new geh();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static INetEngine a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null)
      {
        HttpCommunicator localHttpCommunicator = new HttpCommunicator(jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount, 128);
        localHttpCommunicator.a();
        jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = new OldHttpEngine(localHttpCommunicator, true);
      }
      return jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\AVNetEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */