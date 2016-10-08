package com.tencent.mobileqq.data;

import android.database.Cursor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;

public class DiscussionInfo
  extends Entity
{
  public static final long UIControlFlag_Hidden_RecentUser = 1L;
  public static final long UIControlFlag_default = 0L;
  public long DiscussionFlag;
  public int createFrom;
  public long createTime;
  public String discussionName;
  public String faceUinSet;
  public long groupCode;
  public long groupUin;
  public boolean hasCollect;
  public long infoSeq;
  public String inheritOwnerUin;
  @notColumn
  public long lastMsgTime;
  public int mComparePartInt;
  public String mCompareSpell;
  public String ownerUin;
  public long timeSec;
  public long uiControlFlag;
  @unique
  public String uin;
  
  public DiscussionInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.DiscussionFlag = 536870912L;
    this.createFrom = 0;
    this.uiControlFlag = 0L;
  }
  
  public static boolean isValidDisUin(String paramString)
  {
    boolean bool = false;
    try
    {
      long l = Long.valueOf(Long.parseLong(paramString)).longValue();
      if (l >= 1000000L) {
        bool = true;
      }
      return bool;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    this.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
    this.infoSeq = paramCursor.getLong(paramCursor.getColumnIndex("infoSeq"));
    this.ownerUin = paramCursor.getString(paramCursor.getColumnIndex("ownerUin"));
    this.discussionName = paramCursor.getString(paramCursor.getColumnIndex("discussionName"));
    this.createTime = paramCursor.getLong(paramCursor.getColumnIndex("createTime"));
    this.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
    this.faceUinSet = paramCursor.getString(paramCursor.getColumnIndex("faceUinSet"));
    this.DiscussionFlag = paramCursor.getLong(paramCursor.getColumnIndex("DiscussionFlag"));
    this.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
    this.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
    this.groupCode = paramCursor.getLong(paramCursor.getColumnIndex("groupCode"));
    this.groupUin = paramCursor.getLong(paramCursor.getColumnIndex("groupUin"));
    if (paramCursor.getInt(paramCursor.getColumnIndex("hasCollect")) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.hasCollect = bool;
      this.inheritOwnerUin = paramCursor.getString(paramCursor.getColumnIndex("inheritOwnerUin"));
      this.createFrom = paramCursor.getInt(paramCursor.getColumnIndex("createFrom"));
      this.uiControlFlag = paramCursor.getLong(paramCursor.getColumnIndex("uiControlFlag"));
      return true;
    }
  }
  
  public boolean hasRenamed()
  {
    return (this.DiscussionFlag & 0x40) >>> 6 == 0L;
  }
  
  public boolean isUIControlFlag_Hidden_RecentUser()
  {
    return (this.uiControlFlag & 1L) == 1L;
  }
  
  public void removeUIControlFlag_Hidden_RecentUser()
  {
    this.uiControlFlag &= 0xFFFFFFFFFFFFFFFE;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\data\DiscussionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */