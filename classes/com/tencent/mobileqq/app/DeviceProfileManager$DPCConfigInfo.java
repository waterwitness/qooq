package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class DeviceProfileManager$DPCConfigInfo
  implements Serializable, Cloneable
{
  public static final String DPCINFO_FEATUREVALUE_DEFAULTVAL = "";
  public String featureValue;
  
  public DeviceProfileManager$DPCConfigInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.featureValue = "";
  }
  
  public Object clone()
  {
    try
    {
      DPCConfigInfo localDPCConfigInfo = (DPCConfigInfo)super.clone();
      if (localDPCConfigInfo == null) {
        return this;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      Object localObject;
      for (;;)
      {
        localCloneNotSupportedException.printStackTrace();
        localObject = null;
      }
      ((DPCConfigInfo)localObject).featureValue = this.featureValue;
      return localObject;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("DPCConfigInfo: featureValue=");
    localStringBuilder.append(this.featureValue);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\DeviceProfileManager$DPCConfigInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */