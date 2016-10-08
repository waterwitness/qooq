package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class RoamSetting
  extends Entity
{
  public static final String SETTING_REVISION = "setting_revision";
  @unique
  public String path;
  public String value;
  
  public RoamSetting()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RoamSetting(String paramString1, String paramString2)
  {
    this.path = paramString1;
    this.value = paramString2;
  }
  
  public static int getIntValue(RoamSetting paramRoamSetting, int paramInt)
  {
    if (paramRoamSetting == null) {}
    while ((paramRoamSetting.value == null) || (paramRoamSetting.value.length() == 0)) {
      return paramInt;
    }
    try
    {
      int i = Integer.parseInt(paramRoamSetting.value);
      return i;
    }
    catch (Exception paramRoamSetting)
    {
      paramRoamSetting.printStackTrace();
    }
    return paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\RoamSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */