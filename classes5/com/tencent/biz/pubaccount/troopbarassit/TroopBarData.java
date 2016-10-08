package com.tencent.biz.pubaccount.troopbarassit;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;

public class TroopBarData
  extends Entity
{
  public boolean mIsSticky;
  public long mLastDraftTime;
  public long mLastMsgTime;
  public long mLastStickyTime;
  @notColumn
  public MessageRecord mLatestMessage;
  @unique
  public String mUin;
  
  public TroopBarData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getTableName()
  {
    return super.getTableName();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\troopbarassit\TroopBarData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */