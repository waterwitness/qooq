package com.tencent.av.gaudio;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class AVPhoneUserInfo
  implements Serializable
{
  public long account;
  public int accountType;
  public AVPhoneUserInfo.TelInfo telInfo;
  
  public AVPhoneUserInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.telInfo = new AVPhoneUserInfo.TelInfo(this);
  }
  
  public String toString()
  {
    return "AVUserInfo-->Account = " + this.account + " , AccountType = " + this.accountType + " , TelInfo = " + this.telInfo + " .";
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\av\gaudio\AVPhoneUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */