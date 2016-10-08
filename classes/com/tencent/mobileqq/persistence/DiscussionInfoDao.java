package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DiscussionInfoDao
  extends OGAbstractDao
{
  private OGEntityInfo a;
  
  public DiscussionInfoDao()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 16;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool = true;
    paramBoolean = true;
    paramEntity = (DiscussionInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.infoSeq = paramCursor.getLong(paramCursor.getColumnIndex("infoSeq"));
      paramEntity.ownerUin = paramCursor.getString(paramCursor.getColumnIndex("ownerUin"));
      paramEntity.inheritOwnerUin = paramCursor.getString(paramCursor.getColumnIndex("inheritOwnerUin"));
      paramEntity.discussionName = paramCursor.getString(paramCursor.getColumnIndex("discussionName"));
      paramEntity.createTime = paramCursor.getLong(paramCursor.getColumnIndex("createTime"));
      paramEntity.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      paramEntity.faceUinSet = paramCursor.getString(paramCursor.getColumnIndex("faceUinSet"));
      paramEntity.DiscussionFlag = paramCursor.getLong(paramCursor.getColumnIndex("DiscussionFlag"));
      paramEntity.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
      paramEntity.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
      paramEntity.groupCode = paramCursor.getLong(paramCursor.getColumnIndex("groupCode"));
      paramEntity.groupUin = paramCursor.getLong(paramCursor.getColumnIndex("groupUin"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasCollect"))) {}
      for (;;)
      {
        paramEntity.hasCollect = paramBoolean;
        paramEntity.createFrom = paramCursor.getInt(paramCursor.getColumnIndex("createFrom"));
        paramEntity.uiControlFlag = paramCursor.getLong(paramCursor.getColumnIndex("uiControlFlag"));
        return paramEntity;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("infoSeq");
      if (i != -1) {
        break label886;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("infoSeq", Long.TYPE));
      label384:
      i = paramCursor.getColumnIndex("ownerUin");
      if (i != -1) {
        break label901;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ownerUin", String.class));
      label418:
      i = paramCursor.getColumnIndex("inheritOwnerUin");
      if (i != -1) {
        break label916;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("inheritOwnerUin", String.class));
      label452:
      i = paramCursor.getColumnIndex("discussionName");
      if (i != -1) {
        break label931;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("discussionName", String.class));
      label486:
      i = paramCursor.getColumnIndex("createTime");
      if (i != -1) {
        break label946;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("createTime", Long.TYPE));
      label521:
      i = paramCursor.getColumnIndex("timeSec");
      if (i != -1) {
        break label961;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("timeSec", Long.TYPE));
      label556:
      i = paramCursor.getColumnIndex("faceUinSet");
      if (i != -1) {
        break label976;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceUinSet", String.class));
      label590:
      i = paramCursor.getColumnIndex("DiscussionFlag");
      if (i != -1) {
        break label991;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("DiscussionFlag", Long.TYPE));
      label625:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label1006;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label660:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label1021;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mCompareSpell", String.class));
      label694:
      i = paramCursor.getColumnIndex("groupCode");
      if (i != -1) {
        break label1036;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("groupCode", Long.TYPE));
      label729:
      i = paramCursor.getColumnIndex("groupUin");
      if (i != -1) {
        break label1051;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("groupUin", Long.TYPE));
      label764:
      i = paramCursor.getColumnIndex("hasCollect");
      if (i != -1) {
        break label1066;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasCollect", Boolean.TYPE));
      i = paramCursor.getColumnIndex("createFrom");
      if (i != -1) {
        break label1094;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("createFrom", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("uiControlFlag");
      if (i != -1) {
        break label1109;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uiControlFlag", Long.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label886:
      paramEntity.infoSeq = paramCursor.getLong(i);
      break label384;
      label901:
      paramEntity.ownerUin = paramCursor.getString(i);
      break label418;
      label916:
      paramEntity.inheritOwnerUin = paramCursor.getString(i);
      break label452;
      label931:
      paramEntity.discussionName = paramCursor.getString(i);
      break label486;
      label946:
      paramEntity.createTime = paramCursor.getLong(i);
      break label521;
      label961:
      paramEntity.timeSec = paramCursor.getLong(i);
      break label556;
      label976:
      paramEntity.faceUinSet = paramCursor.getString(i);
      break label590;
      label991:
      paramEntity.DiscussionFlag = paramCursor.getLong(i);
      break label625;
      label1006:
      paramEntity.mComparePartInt = paramCursor.getInt(i);
      break label660;
      label1021:
      paramEntity.mCompareSpell = paramCursor.getString(i);
      break label694;
      label1036:
      paramEntity.groupCode = paramCursor.getLong(i);
      break label729;
      label1051:
      paramEntity.groupUin = paramCursor.getLong(i);
      break label764;
      label1066:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramEntity.hasCollect = paramBoolean;
        break;
      }
      label1094:
      paramEntity.createFrom = paramCursor.getInt(i);
    }
    label1109:
    paramEntity.uiControlFlag = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,infoSeq INTEGER ,ownerUin TEXT ,inheritOwnerUin TEXT ,discussionName TEXT ,createTime INTEGER ,timeSec INTEGER ,faceUinSet TEXT ,DiscussionFlag INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,groupCode INTEGER ,groupUin INTEGER ,hasCollect INTEGER ,createFrom INTEGER ,uiControlFlag INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (DiscussionInfo)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("infoSeq", Long.valueOf(paramEntity.infoSeq));
    paramContentValues.put("ownerUin", paramEntity.ownerUin);
    paramContentValues.put("inheritOwnerUin", paramEntity.inheritOwnerUin);
    paramContentValues.put("discussionName", paramEntity.discussionName);
    paramContentValues.put("createTime", Long.valueOf(paramEntity.createTime));
    paramContentValues.put("timeSec", Long.valueOf(paramEntity.timeSec));
    paramContentValues.put("faceUinSet", paramEntity.faceUinSet);
    paramContentValues.put("DiscussionFlag", Long.valueOf(paramEntity.DiscussionFlag));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramEntity.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramEntity.mCompareSpell);
    paramContentValues.put("groupCode", Long.valueOf(paramEntity.groupCode));
    paramContentValues.put("groupUin", Long.valueOf(paramEntity.groupUin));
    paramContentValues.put("hasCollect", Boolean.valueOf(paramEntity.hasCollect));
    paramContentValues.put("createFrom", Integer.valueOf(paramEntity.createFrom));
    paramContentValues.put("uiControlFlag", Long.valueOf(paramEntity.uiControlFlag));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\DiscussionInfoDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */