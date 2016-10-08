package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ReportWatchVideoEntry
  extends Entity
{
  public long createTime;
  public boolean isLiveVideo;
  @unique
  public String vid;
  public long videoUid;
  
  public ReportWatchVideoEntry()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\database\ReportWatchVideoEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */