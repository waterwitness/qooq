package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class StoryEntry
  extends Entity
{
  public String coverUrl;
  public long dbTime;
  public String extra1;
  public String extra2;
  public String extra3;
  public int hasUnWatchVideo;
  @unique
  public String key;
  public long totalTime;
  public int type;
  public long uid;
  public long updateTime;
  public int videoCount;
  
  public StoryEntry()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.dbTime = System.currentTimeMillis();
  }
  
  public static String getTypeSelection(int paramInt)
  {
    return "type=" + paramInt + "";
  }
  
  public static String getUidSelectionNoArg()
  {
    return "uid=? AND type=?";
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\database\StoryEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */