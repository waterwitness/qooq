package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class StoryVideoListEntry
  extends Entity
{
  public static final int LIST_TYPE_HOT_TOPIC = 2;
  public static final int LIST_TYPE_LABEL = 1;
  public static final int LIST_TYPE_LABEL_CONFIG = 4;
  public static final int LIST_TYPE_RECENT = 3;
  public static final int LIST_TYPE_USER = 0;
  public String label;
  public int listType;
  public long uid;
  public String vid;
  
  public StoryVideoListEntry()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String getLabelSelectionNoArg()
  {
    return "listType=? AND label=?";
  }
  
  public static String getRecentUidSelection(long paramLong)
  {
    return "listType=3 AND uid='" + paramLong + "'";
  }
  
  public static String getTopicIdSelection(long paramLong)
  {
    return "listType=2 AND uid='" + paramLong + "'";
  }
  
  public static String getUserUidSelection(long paramLong)
  {
    return "listType=0 AND uid='" + paramLong + "'";
  }
  
  public static String getVidSelectionNoArg()
  {
    return "vid=?";
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\database\StoryVideoListEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */