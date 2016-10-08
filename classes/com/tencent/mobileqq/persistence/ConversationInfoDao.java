package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ConversationInfoDao
  extends OGAbstractDao
{
  private OGEntityInfo a;
  
  public ConversationInfoDao()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 11;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (ConversationInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramEntity.lastread = paramCursor.getLong(paramCursor.getColumnIndex("lastread"));
      paramEntity.unreadCount = paramCursor.getInt(paramCursor.getColumnIndex("unreadCount"));
      paramEntity.unreadMark = paramCursor.getInt(paramCursor.getColumnIndex("unreadMark"));
      paramEntity.unreadGiftCount = paramCursor.getInt(paramCursor.getColumnIndex("unreadGiftCount"));
      paramEntity.extInt1 = paramCursor.getInt(paramCursor.getColumnIndex("extInt1"));
      paramEntity.extInt2 = paramCursor.getInt(paramCursor.getColumnIndex("extInt2"));
      paramEntity.extInt3 = paramCursor.getInt(paramCursor.getColumnIndex("extInt3"));
      paramEntity.extString = paramCursor.getString(paramCursor.getColumnIndex("extString"));
      paramEntity.extData = paramCursor.getBlob(paramCursor.getColumnIndex("extData"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label609;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("type", Integer.TYPE));
      label279:
      i = paramCursor.getColumnIndex("lastread");
      if (i != -1) {
        break label624;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastread", Long.TYPE));
      label314:
      i = paramCursor.getColumnIndex("unreadCount");
      if (i != -1) {
        break label639;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("unreadCount", Integer.TYPE));
      label349:
      i = paramCursor.getColumnIndex("unreadMark");
      if (i != -1) {
        break label654;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("unreadMark", Integer.TYPE));
      label384:
      i = paramCursor.getColumnIndex("unreadGiftCount");
      if (i != -1) {
        break label669;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("unreadGiftCount", Integer.TYPE));
      label419:
      i = paramCursor.getColumnIndex("extInt1");
      if (i != -1) {
        break label684;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("extInt1", Integer.TYPE));
      label454:
      i = paramCursor.getColumnIndex("extInt2");
      if (i != -1) {
        break label699;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("extInt2", Integer.TYPE));
      label489:
      i = paramCursor.getColumnIndex("extInt3");
      if (i != -1) {
        break label714;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("extInt3", Integer.TYPE));
      label524:
      i = paramCursor.getColumnIndex("extString");
      if (i != -1) {
        break label729;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("extString", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("extData");
      if (i != -1) {
        break label744;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("extData", byte[].class));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label609:
      paramEntity.type = paramCursor.getInt(i);
      break label279;
      label624:
      paramEntity.lastread = paramCursor.getLong(i);
      break label314;
      label639:
      paramEntity.unreadCount = paramCursor.getInt(i);
      break label349;
      label654:
      paramEntity.unreadMark = paramCursor.getInt(i);
      break label384;
      label669:
      paramEntity.unreadGiftCount = paramCursor.getInt(i);
      break label419;
      label684:
      paramEntity.extInt1 = paramCursor.getInt(i);
      break label454;
      label699:
      paramEntity.extInt2 = paramCursor.getInt(i);
      break label489;
      label714:
      paramEntity.extInt3 = paramCursor.getInt(i);
      break label524;
      label729:
      paramEntity.extString = paramCursor.getString(i);
    }
    label744:
    paramEntity.extData = paramCursor.getBlob(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,type INTEGER ,lastread INTEGER ,unreadCount INTEGER ,unreadMark INTEGER ,unreadGiftCount INTEGER ,extInt1 INTEGER ,extInt2 INTEGER ,extInt3 INTEGER ,extString TEXT ,extData BLOB,UNIQUE(uin,type) ON CONFLICT FAIL)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (ConversationInfo)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("type", Integer.valueOf(paramEntity.type));
    paramContentValues.put("lastread", Long.valueOf(paramEntity.lastread));
    paramContentValues.put("unreadCount", Integer.valueOf(paramEntity.unreadCount));
    paramContentValues.put("unreadMark", Integer.valueOf(paramEntity.unreadMark));
    paramContentValues.put("unreadGiftCount", Integer.valueOf(paramEntity.unreadGiftCount));
    paramContentValues.put("extInt1", Integer.valueOf(paramEntity.extInt1));
    paramContentValues.put("extInt2", Integer.valueOf(paramEntity.extInt2));
    paramContentValues.put("extInt3", Integer.valueOf(paramEntity.extInt3));
    paramContentValues.put("extString", paramEntity.extString);
    paramContentValues.put("extData", paramEntity.extData);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\ConversationInfoDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */