package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class FriendAnniver
  extends Entity
{
  public String info;
  public boolean isReed;
  public long timestamp;
  public String uin;
  public String url;
  public int year;
  
  public FriendAnniver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\FriendAnniver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */