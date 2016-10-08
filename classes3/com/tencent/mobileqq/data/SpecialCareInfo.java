package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

public class SpecialCareInfo
  extends Entity
  implements Cloneable
{
  public long dateTime;
  public int friendRingId;
  public int globalSwitch;
  public int groupFriendSwitch;
  public int qzoneSwitch;
  public int specialRingSwitch;
  @unique
  public String uin;
  public byte[] zoneInfo;
  
  public SpecialCareInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Object clone()
  {
    try
    {
      localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      do
      {
        Object localObject = this;
      } while (!QLog.isColorLevel());
      QLog.d("Q.contacttab.", 2, "SpecialCareInfo clone failed." + localCloneNotSupportedException.toString());
    }
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n SpecialCareInfo");
    localStringBuilder.append("\n |-").append("uin:").append(this.uin);
    localStringBuilder.append("\n |-").append("status:").append(getStatus());
    localStringBuilder.append("\n |-").append("dateTime:").append(this.dateTime);
    localStringBuilder.append("\n |-").append("globalSwitch:").append(this.globalSwitch);
    localStringBuilder.append("\n |-").append("specialRingSwitch:").append(this.specialRingSwitch);
    localStringBuilder.append("\n |-").append("friendRingId:").append(this.friendRingId);
    localStringBuilder.append("\n |-").append("qzoneSwitch:").append(this.qzoneSwitch);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\SpecialCareInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */