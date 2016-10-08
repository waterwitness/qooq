package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class EmoticonTabDao
  extends OGAbstractDao
{
  private OGEntityInfo a;
  
  public EmoticonTabDao()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 1;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (EmoticonTab)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("epId");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("epId", String.class));
      return paramEntity;
    }
    paramEntity.epId = paramCursor.getString(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,epId TEXT UNIQUE)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramContentValues.put("epId", ((EmoticonTab)paramEntity).epId);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\EmoticonTabDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */