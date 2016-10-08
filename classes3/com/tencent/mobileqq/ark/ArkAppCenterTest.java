package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import qqs;

public class ArkAppCenterTest
{
  private static int jdField_a_of_type_Int = 0;
  private static final String jdField_a_of_type_JavaLangString = "ArkApp.ArkAppCenterTest";
  
  public ArkAppCenterTest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ((ArkAppCenter)paramQQAppInterface.getManager(120)).a().a("ArkAppSvc.AppMsg", "hello this is misora", 0, 101, new qqs());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\ark\ArkAppCenterTest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */