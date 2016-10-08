package com.tencent.mobileqq.data.fts;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class FTSTroopTime
  extends Entity
{
  public long mTimeStamp;
  public String mTroopUin;
  public long mUin;
  
  public FTSTroopTime()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void prewrite()
  {
    super.prewrite();
    this.mUin = Long.parseLong(this.mTroopUin);
  }
  
  public String toString()
  {
    return "TroopUin=" + this.mTroopUin + " timeStamp=" + this.mTimeStamp;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\fts\FTSTroopTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */