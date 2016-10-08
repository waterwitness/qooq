package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.CircleGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CircleGroupDao
  extends OGAbstractDao
{
  private OGEntityInfo a;
  
  public CircleGroupDao()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 4;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (CircleGroup)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.groupId = paramCursor.getInt(paramCursor.getColumnIndex("groupId"));
      paramEntity.groupName = paramCursor.getString(paramCursor.getColumnIndex("groupName"));
      paramEntity.buddyCount = paramCursor.getInt(paramCursor.getColumnIndex("buddyCount"));
      paramEntity.showIndex = paramCursor.getInt(paramCursor.getColumnIndex("showIndex"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("groupId");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("groupId", Integer.TYPE));
      i = paramCursor.getColumnIndex("groupName");
      if (i != -1) {
        break label240;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("groupName", String.class));
      label153:
      i = paramCursor.getColumnIndex("buddyCount");
      if (i != -1) {
        break label255;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("buddyCount", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("showIndex");
      if (i != -1) {
        break label270;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("showIndex", Integer.TYPE));
      return paramEntity;
      paramEntity.groupId = paramCursor.getInt(i);
      break;
      label240:
      paramEntity.groupName = paramCursor.getString(i);
      break label153;
      label255:
      paramEntity.buddyCount = paramCursor.getInt(i);
    }
    label270:
    paramEntity.showIndex = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,groupId INTEGER UNIQUE ,groupName TEXT ,buddyCount INTEGER ,showIndex INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (CircleGroup)paramEntity;
    paramContentValues.put("groupId", Integer.valueOf(paramEntity.groupId));
    paramContentValues.put("groupName", paramEntity.groupName);
    paramContentValues.put("buddyCount", Integer.valueOf(paramEntity.buddyCount));
    paramContentValues.put("showIndex", Integer.valueOf(paramEntity.showIndex));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\CircleGroupDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */