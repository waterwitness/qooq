package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DeviceProfileManager$StringToIntParser
  implements DeviceProfileManager.StringParser
{
  public DeviceProfileManager$StringToIntParser()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Integer a(String paramString)
  {
    return Integer.decode(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\DeviceProfileManager$StringToIntParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */