package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class HotTopicEntry
  extends Entity
{
  public long databaseTime;
  public int topicColor;
  public String topicCover;
  @unique
  public long topicId;
  public String topicLogo;
  public String topicName;
  
  public HotTopicEntry()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.databaseTime = System.currentTimeMillis();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\database\HotTopicEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */