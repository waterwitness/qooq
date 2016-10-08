package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CircleBuddyDao
  extends OGAbstractDao
{
  private OGEntityInfo a;
  
  public CircleBuddyDao()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 8;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (CircleBuddy)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.nickName = paramCursor.getString(paramCursor.getColumnIndex("nickName"));
      paramEntity.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramEntity.closeness = paramCursor.getInt(paramCursor.getColumnIndex("closeness"));
      paramEntity.groupId = paramCursor.getInt(paramCursor.getColumnIndex("groupId"));
      paramEntity.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
      paramEntity.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
      paramEntity.checkUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("checkUpdateTime"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("nickName");
      if (i != -1) {
        break label449;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nickName", String.class));
      label224:
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label464;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("remark", String.class));
      label258:
      i = paramCursor.getColumnIndex("closeness");
      if (i != -1) {
        break label479;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("closeness", Integer.TYPE));
      label293:
      i = paramCursor.getColumnIndex("groupId");
      if (i != -1) {
        break label494;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("groupId", Integer.TYPE));
      label328:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label509;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("richBuffer", byte[].class));
      label362:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label524;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("richTime", Long.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("checkUpdateTime");
      if (i != -1) {
        break label539;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("checkUpdateTime", Long.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label449:
      paramEntity.nickName = paramCursor.getString(i);
      break label224;
      label464:
      paramEntity.remark = paramCursor.getString(i);
      break label258;
      label479:
      paramEntity.closeness = paramCursor.getInt(i);
      break label293;
      label494:
      paramEntity.groupId = paramCursor.getInt(i);
      break label328;
      label509:
      paramEntity.richBuffer = paramCursor.getBlob(i);
      break label362;
      label524:
      paramEntity.richTime = paramCursor.getLong(i);
    }
    label539:
    paramEntity.checkUpdateTime = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,nickName TEXT ,remark TEXT ,closeness INTEGER ,groupId INTEGER ,richBuffer BLOB ,richTime INTEGER ,checkUpdateTime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (CircleBuddy)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("nickName", paramEntity.nickName);
    paramContentValues.put("remark", paramEntity.remark);
    paramContentValues.put("closeness", Integer.valueOf(paramEntity.closeness));
    paramContentValues.put("groupId", Integer.valueOf(paramEntity.groupId));
    paramContentValues.put("richBuffer", paramEntity.richBuffer);
    paramContentValues.put("richTime", Long.valueOf(paramEntity.richTime));
    paramContentValues.put("checkUpdateTime", Long.valueOf(paramEntity.checkUpdateTime));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\CircleBuddyDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */