package com.tencent.mobileqq.data.fts;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.fts.FTSOptSync;

public class FTSTroopSync
  extends FTSOptSync
{
  public static final int OPT_CHECK_TIME_STAMP = 5;
  public static final int OPT_GET_MEMBER_LIST = 1;
  public static final int OPT_KICK_OUT_MEMBER = 2;
  public static final int OPT_MODIFY_MEMBER_CARD = 3;
  public static final int OPT_QUIT_TROOP = 4;
  public long mMemberUin;
  public long mTroopUin;
  
  public FTSTroopSync()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FTSTroopSync(int paramInt, long paramLong)
  {
    this.mOpt = paramInt;
    this.mTroopUin = paramLong;
  }
  
  public FTSTroopSync(int paramInt, long paramLong1, long paramLong2)
  {
    this.mOpt = paramInt;
    this.mTroopUin = paramLong1;
    this.mMemberUin = paramLong2;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("mOpt=");
    localStringBuffer.append(this.mOpt);
    localStringBuffer.append(" mTroopUin=");
    localStringBuffer.append(this.mTroopUin);
    localStringBuffer.append(" mMemberUin=");
    localStringBuffer.append(this.mMemberUin);
    return localStringBuffer.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\fts\FTSTroopSync.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */