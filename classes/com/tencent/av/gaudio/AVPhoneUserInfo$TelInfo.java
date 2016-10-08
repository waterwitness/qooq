package com.tencent.av.gaudio;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class AVPhoneUserInfo$TelInfo
  implements Serializable
{
  public String mobile;
  public String nation;
  public int nationState;
  public String prefix;
  
  public AVPhoneUserInfo$TelInfo(AVPhoneUserInfo paramAVPhoneUserInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    return "TelInfo--> Nation = " + this.nation + ", Prefix = " + this.prefix + ", Mobile = " + this.mobile + ", nationState = " + this.nationState;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\av\gaudio\AVPhoneUserInfo$TelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */