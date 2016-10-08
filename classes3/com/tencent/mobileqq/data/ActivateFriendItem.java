package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ActivateFriendItem
{
  public long birthSendTime;
  public String birthdayDesc;
  public String nickName;
  public int type;
  public long uin;
  
  public ActivateFriendItem(int paramInt, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.type = paramInt;
    this.uin = paramLong;
  }
  
  public ActivateFriendItem(int paramInt, long paramLong, String paramString)
  {
    this.type = paramInt;
    this.uin = paramLong;
    this.nickName = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\ActivateFriendItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */