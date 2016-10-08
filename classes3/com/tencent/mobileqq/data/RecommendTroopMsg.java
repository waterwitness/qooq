package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RecommendTroopMsg
{
  public boolean isRead;
  public int msgtype;
  public RecTroopBusinessItem rtbItem;
  public long timeStamp;
  public RecommendTroopInfo troop;
  public long uniseq;
  
  public RecommendTroopMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean isBusiness()
  {
    return (this.msgtype == 64496) && (this.rtbItem != null);
  }
  
  public boolean isTroop()
  {
    return (this.msgtype == 64497) && (this.troop != null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\RecommendTroopMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */