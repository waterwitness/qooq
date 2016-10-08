package com.tencent.mobileqq.dating;

import android.database.Cursor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class GodListConfig
  extends Entity
{
  public static final int TYPE_CITY_MAN = 0;
  public static final int TYPE_CITY_WOMAN = 1;
  public static final int TYPE_NEW_MAN = 2;
  public static final int TYPE_NEW_WOMAN = 3;
  public int fetchAccount;
  public boolean hasMore;
  public boolean insideRank;
  public int lastTime;
  public long lastTinyId;
  public long lastUpdateTime;
  @unique
  public int listType;
  public int visiblePos;
  
  public GodListConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.fetchAccount = 20;
  }
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    boolean bool2 = false;
    this.listType = paramCursor.getInt(paramCursor.getColumnIndex("listType"));
    this.lastTime = paramCursor.getInt(paramCursor.getColumnIndex("lastTime"));
    this.lastTinyId = paramCursor.getLong(paramCursor.getColumnIndex("lastTinyId"));
    this.fetchAccount = paramCursor.getInt(paramCursor.getColumnIndex("fetchAccount"));
    this.lastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("lastUpdateTime"));
    if (paramCursor.getInt(paramCursor.getColumnIndex("hasMore")) != 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.hasMore = bool1;
      bool1 = bool2;
      if (paramCursor.getInt(paramCursor.getColumnIndex("insideRank")) != 0) {
        bool1 = true;
      }
      this.insideRank = bool1;
      return true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\GodListConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */