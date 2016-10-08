package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class MyStoryEntry
  extends Entity
{
  public String createTime;
  public long duration;
  public int state;
  @unique
  public int uid;
  
  public MyStoryEntry()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\database\MyStoryEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */