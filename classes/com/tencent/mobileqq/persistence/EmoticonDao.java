package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class EmoticonDao
  extends OGAbstractDao
{
  private OGEntityInfo a;
  
  public EmoticonDao()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 16;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (Emoticon)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.eId = paramCursor.getString(paramCursor.getColumnIndex("eId"));
      paramEntity.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.encryptKey = paramCursor.getString(paramCursor.getColumnIndex("encryptKey"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isSound")))
      {
        paramBoolean = true;
        paramEntity.isSound = paramBoolean;
        paramEntity.width = paramCursor.getInt(paramCursor.getColumnIndex("width"));
        paramEntity.height = paramCursor.getInt(paramCursor.getColumnIndex("height"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("value"))) {
          break label326;
        }
      }
      label326:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.value = paramBoolean;
        paramEntity.magicValue = paramCursor.getString(paramCursor.getColumnIndex("magicValue"));
        paramEntity.jobType = paramCursor.getInt(paramCursor.getColumnIndex("jobType"));
        paramEntity.keyword = paramCursor.getString(paramCursor.getColumnIndex("keyword"));
        paramEntity.keywords = paramCursor.getString(paramCursor.getColumnIndex("keywords"));
        paramEntity.character = paramCursor.getString(paramCursor.getColumnIndex("character"));
        paramEntity.extensionWidth = paramCursor.getInt(paramCursor.getColumnIndex("extensionWidth"));
        paramEntity.extensionHeight = paramCursor.getInt(paramCursor.getColumnIndex("extensionHeight"));
        paramEntity.businessExtra = paramCursor.getString(paramCursor.getColumnIndex("businessExtra"));
        return paramEntity;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("eId");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("eId", String.class));
      i = paramCursor.getColumnIndex("epId");
      if (i != -1) {
        break label899;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("epId", String.class));
      label399:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label914;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("name", String.class));
      label433:
      i = paramCursor.getColumnIndex("encryptKey");
      if (i != -1) {
        break label929;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("encryptKey", String.class));
      label467:
      i = paramCursor.getColumnIndex("isSound");
      if (i != -1) {
        break label944;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("width");
      if (i != -1) {
        break label971;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("width", Integer.TYPE));
      label537:
      i = paramCursor.getColumnIndex("height");
      if (i != -1) {
        break label986;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("height", Integer.TYPE));
      label572:
      i = paramCursor.getColumnIndex("value");
      if (i != -1) {
        break label1001;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("value", Boolean.TYPE));
      i = paramCursor.getColumnIndex("magicValue");
      if (i != -1) {
        break label1029;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("magicValue", String.class));
      label641:
      i = paramCursor.getColumnIndex("jobType");
      if (i != -1) {
        break label1044;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("jobType", Integer.TYPE));
      label676:
      i = paramCursor.getColumnIndex("keyword");
      if (i != -1) {
        break label1059;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("keyword", String.class));
      label710:
      i = paramCursor.getColumnIndex("keywords");
      if (i != -1) {
        break label1074;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("keywords", String.class));
      label744:
      i = paramCursor.getColumnIndex("character");
      if (i != -1) {
        break label1089;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("character", String.class));
      label778:
      i = paramCursor.getColumnIndex("extensionWidth");
      if (i != -1) {
        break label1104;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("extensionWidth", Integer.TYPE));
      label813:
      i = paramCursor.getColumnIndex("extensionHeight");
      if (i != -1) {
        break label1119;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("extensionHeight", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("businessExtra");
      if (i != -1) {
        break label1134;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("businessExtra", String.class));
      return paramEntity;
      paramEntity.eId = paramCursor.getString(i);
      break;
      label899:
      paramEntity.epId = paramCursor.getString(i);
      break label399;
      label914:
      paramEntity.name = paramCursor.getString(i);
      break label433;
      label929:
      paramEntity.encryptKey = paramCursor.getString(i);
      break label467;
      label944:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSound = paramBoolean;
        break;
      }
      label971:
      paramEntity.width = paramCursor.getInt(i);
      break label537;
      label986:
      paramEntity.height = paramCursor.getInt(i);
      break label572;
      label1001:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.value = paramBoolean;
        break;
      }
      label1029:
      paramEntity.magicValue = paramCursor.getString(i);
      break label641;
      label1044:
      paramEntity.jobType = paramCursor.getInt(i);
      break label676;
      label1059:
      paramEntity.keyword = paramCursor.getString(i);
      break label710;
      label1074:
      paramEntity.keywords = paramCursor.getString(i);
      break label744;
      label1089:
      paramEntity.character = paramCursor.getString(i);
      break label778;
      label1104:
      paramEntity.extensionWidth = paramCursor.getInt(i);
      break label813;
      label1119:
      paramEntity.extensionHeight = paramCursor.getInt(i);
    }
    label1134:
    paramEntity.businessExtra = paramCursor.getString(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,eId TEXT ,epId TEXT ,name TEXT ,encryptKey TEXT ,isSound INTEGER ,width INTEGER ,height INTEGER ,value INTEGER ,magicValue TEXT ,jobType INTEGER ,keyword TEXT ,keywords TEXT ,character TEXT ,extensionWidth INTEGER ,extensionHeight INTEGER ,businessExtra TEXT,UNIQUE(eId,epId) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (Emoticon)paramEntity;
    paramContentValues.put("eId", paramEntity.eId);
    paramContentValues.put("epId", paramEntity.epId);
    paramContentValues.put("name", paramEntity.name);
    paramContentValues.put("encryptKey", paramEntity.encryptKey);
    paramContentValues.put("isSound", Boolean.valueOf(paramEntity.isSound));
    paramContentValues.put("width", Integer.valueOf(paramEntity.width));
    paramContentValues.put("height", Integer.valueOf(paramEntity.height));
    paramContentValues.put("value", Boolean.valueOf(paramEntity.value));
    paramContentValues.put("magicValue", paramEntity.magicValue);
    paramContentValues.put("jobType", Integer.valueOf(paramEntity.jobType));
    paramContentValues.put("keyword", paramEntity.keyword);
    paramContentValues.put("keywords", paramEntity.keywords);
    paramContentValues.put("character", paramEntity.character);
    paramContentValues.put("extensionWidth", Integer.valueOf(paramEntity.extensionWidth));
    paramContentValues.put("extensionHeight", Integer.valueOf(paramEntity.extensionHeight));
    paramContentValues.put("businessExtra", paramEntity.businessExtra);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\EmoticonDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */