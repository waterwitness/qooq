package com.tencent.mobileqq.config;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ResourcePluginListener$CallbackRunner
  implements Runnable
{
  private byte jdField_a_of_type_Byte;
  private int jdField_a_of_type_Int;
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener;
  
  public ResourcePluginListener$CallbackRunner(ResourcePluginListener paramResourcePluginListener, byte paramByte, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = paramResourcePluginListener;
    this.jdField_a_of_type_Byte = paramByte;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener != null)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label27;
      }
      this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener.b(this.jdField_a_of_type_Byte);
    }
    label27:
    while (this.jdField_a_of_type_Int != 1) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener.a(this.jdField_a_of_type_Byte);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\config\ResourcePluginListener$CallbackRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */