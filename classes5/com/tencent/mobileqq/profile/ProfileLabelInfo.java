package com.tencent.mobileqq.profile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class ProfileLabelInfo
  implements Serializable, Cloneable
{
  public static int STATUS_CHECKED = 1;
  public static int STATUS_NORMAL;
  public Long labelId;
  public String labelName;
  public int labelStatus = STATUS_NORMAL;
  public Long likeNum;
  public String typeId;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProfileLabelInfo() {}
  
  public ProfileLabelInfo(Long paramLong1, Long paramLong2, String paramString)
  {
    this.labelId = paramLong1;
    this.labelName = paramString;
    this.likeNum = paramLong2;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return this;
  }
  
  public void toggleStatus()
  {
    if (this.labelStatus == STATUS_NORMAL) {
      this.labelStatus = STATUS_CHECKED;
    }
    while (this.labelStatus != STATUS_CHECKED) {
      return;
    }
    this.labelStatus = STATUS_NORMAL;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\ProfileLabelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */