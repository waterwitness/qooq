package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MessageForTroopNotification
  extends MessageForStructing
{
  public int appId;
  public int ctl_flag;
  public int feedType;
  public String feedsId;
  public long troopUin;
  
  public MessageForTroopNotification()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForTroopNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */