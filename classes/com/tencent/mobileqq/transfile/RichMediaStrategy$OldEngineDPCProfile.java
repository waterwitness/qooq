package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import vbl;

public class RichMediaStrategy$OldEngineDPCProfile
{
  public static boolean a;
  private RichMediaStrategy.OldEngineDPCProfile.TimeoutParam a;
  
  public RichMediaStrategy$OldEngineDPCProfile()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam = new RichMediaStrategy.OldEngineDPCProfile.TimeoutParam();
    a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.HttpTimeoutParam.name()));
    a();
  }
  
  private void a()
  {
    DeviceProfileManager.a(new vbl(this));
  }
  
  public RichMediaStrategy.OldEngineDPCProfile.TimeoutParam a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam.a();
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RichMediaStrategy", 2, "OldEngine Timeout Params : " + paramString);
      }
      paramString = paramString.split("\\|");
    } while ((paramString == null) || (paramString.length != 6));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam.e = (Integer.valueOf(paramString[0]).intValue() * 1000);
      this.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam.f = (Integer.valueOf(paramString[1]).intValue() * 1000);
      this.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam.g = (Integer.valueOf(paramString[2]).intValue() * 1000);
      this.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam.b = (Integer.valueOf(paramString[3]).intValue() * 1000);
      this.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam.c = (Integer.valueOf(paramString[4]).intValue() * 1000);
      this.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam.d = (Integer.valueOf(paramString[5]).intValue() * 1000);
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\transfile\RichMediaStrategy$OldEngineDPCProfile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */