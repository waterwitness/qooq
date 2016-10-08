package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PhoneContactDao
  extends OGAbstractDao
{
  private OGEntityInfo a;
  
  public PhoneContactDao()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 32;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (PhoneContact)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.mobileNo = paramCursor.getString(paramCursor.getColumnIndex("mobileNo"));
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.bindingDate = paramCursor.getLong(paramCursor.getColumnIndex("bindingDate"));
      paramEntity.isRecommend = paramCursor.getInt(paramCursor.getColumnIndex("isRecommend"));
      paramEntity.nationCode = paramCursor.getString(paramCursor.getColumnIndex("nationCode"));
      paramEntity.mobileCode = paramCursor.getString(paramCursor.getColumnIndex("mobileCode"));
      paramEntity.unifiedCode = paramCursor.getString(paramCursor.getColumnIndex("unifiedCode"));
      paramEntity.nickName = paramCursor.getString(paramCursor.getColumnIndex("nickName"));
      paramEntity.originBinder = paramCursor.getLong(paramCursor.getColumnIndex("originBinder"));
      paramEntity.ability = paramCursor.getInt(paramCursor.getColumnIndex("ability"));
      paramEntity.contactID = paramCursor.getInt(paramCursor.getColumnIndex("contactID"));
      paramEntity.faceUrl = paramCursor.getString(paramCursor.getColumnIndex("faceUrl"));
      paramEntity.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramEntity.pinyinAll = paramCursor.getString(paramCursor.getColumnIndex("pinyinAll"));
      paramEntity.pinyinInitial = paramCursor.getString(paramCursor.getColumnIndex("pinyinInitial"));
      paramEntity.lastScanTime = paramCursor.getLong(paramCursor.getColumnIndex("lastScanTime"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isUploaded")))
      {
        paramBoolean = true;
        paramEntity.isUploaded = paramBoolean;
        paramEntity.sortWeight = paramCursor.getInt(paramCursor.getColumnIndex("sortWeight"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSendAddReq"))) {
          break label629;
        }
        paramBoolean = true;
        label385:
        paramEntity.hasSendAddReq = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isNewRecommend"))) {
          break label634;
        }
        paramBoolean = true;
        label410:
        paramEntity.isNewRecommend = paramBoolean;
        paramEntity.highLightTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("highLightTimeStamp"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isHiden"))) {
          break label639;
        }
      }
      label629:
      label634:
      label639:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.isHiden = paramBoolean;
        paramEntity.md5 = paramCursor.getString(paramCursor.getColumnIndex("md5"));
        paramEntity.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
        paramEntity.label = paramCursor.getString(paramCursor.getColumnIndex("label"));
        paramEntity.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
        paramEntity.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
        paramEntity.eNetworkType = paramCursor.getInt(paramCursor.getColumnIndex("eNetworkType"));
        paramEntity.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
        paramEntity.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
        paramEntity.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label385;
        paramBoolean = false;
        break label410;
      }
    }
    int i = paramCursor.getColumnIndex("mobileNo");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("mobileNo", String.class));
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label1767;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      label712:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label1782;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("name", String.class));
      label746:
      i = paramCursor.getColumnIndex("bindingDate");
      if (i != -1) {
        break label1797;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bindingDate", Long.TYPE));
      label781:
      i = paramCursor.getColumnIndex("isRecommend");
      if (i != -1) {
        break label1812;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isRecommend", Integer.TYPE));
      label816:
      i = paramCursor.getColumnIndex("nationCode");
      if (i != -1) {
        break label1827;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nationCode", String.class));
      label850:
      i = paramCursor.getColumnIndex("mobileCode");
      if (i != -1) {
        break label1842;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mobileCode", String.class));
      label884:
      i = paramCursor.getColumnIndex("unifiedCode");
      if (i != -1) {
        break label1857;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("unifiedCode", String.class));
      label918:
      i = paramCursor.getColumnIndex("nickName");
      if (i != -1) {
        break label1872;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nickName", String.class));
      label952:
      i = paramCursor.getColumnIndex("originBinder");
      if (i != -1) {
        break label1887;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("originBinder", Long.TYPE));
      label987:
      i = paramCursor.getColumnIndex("ability");
      if (i != -1) {
        break label1902;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ability", Integer.TYPE));
      label1022:
      i = paramCursor.getColumnIndex("contactID");
      if (i != -1) {
        break label1917;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("contactID", Integer.TYPE));
      label1057:
      i = paramCursor.getColumnIndex("faceUrl");
      if (i != -1) {
        break label1932;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceUrl", String.class));
      label1091:
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label1947;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("remark", String.class));
      label1125:
      i = paramCursor.getColumnIndex("pinyinAll");
      if (i != -1) {
        break label1962;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pinyinAll", String.class));
      label1159:
      i = paramCursor.getColumnIndex("pinyinInitial");
      if (i != -1) {
        break label1977;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pinyinInitial", String.class));
      label1193:
      i = paramCursor.getColumnIndex("lastScanTime");
      if (i != -1) {
        break label1992;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastScanTime", Long.TYPE));
      label1228:
      i = paramCursor.getColumnIndex("isUploaded");
      if (i != -1) {
        break label2007;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isUploaded", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sortWeight");
      if (i != -1) {
        break label2034;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("sortWeight", Integer.TYPE));
      label1298:
      i = paramCursor.getColumnIndex("hasSendAddReq");
      if (i != -1) {
        break label2049;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasSendAddReq", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isNewRecommend");
      if (i != -1) {
        break label2076;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isNewRecommend", Boolean.TYPE));
      i = paramCursor.getColumnIndex("highLightTimeStamp");
      if (i != -1) {
        break label2103;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("highLightTimeStamp", Long.TYPE));
      label1403:
      i = paramCursor.getColumnIndex("isHiden");
      if (i != -1) {
        break label2118;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isHiden", Boolean.TYPE));
      i = paramCursor.getColumnIndex("md5");
      if (i != -1) {
        break label2146;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("md5", String.class));
      label1472:
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label2161;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("type", Integer.TYPE));
      label1507:
      i = paramCursor.getColumnIndex("label");
      if (i != -1) {
        break label2176;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("label", String.class));
      label1541:
      i = paramCursor.getColumnIndex("detalStatusFlag");
      if (i != -1) {
        break label2191;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("detalStatusFlag", Byte.TYPE));
      label1576:
      i = paramCursor.getColumnIndex("iTermType");
      if (i != -1) {
        break label2207;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iTermType", Integer.TYPE));
      label1611:
      i = paramCursor.getColumnIndex("eNetworkType");
      if (i != -1) {
        break label2222;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("eNetworkType", Integer.TYPE));
      label1646:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label2237;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("richTime", Long.TYPE));
      label1681:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label2252;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("richBuffer", byte[].class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("abilityBits");
      if (i != -1) {
        break label2267;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("abilityBits", Long.TYPE));
      return paramEntity;
      paramEntity.mobileNo = paramCursor.getString(i);
      break;
      label1767:
      paramEntity.uin = paramCursor.getString(i);
      break label712;
      label1782:
      paramEntity.name = paramCursor.getString(i);
      break label746;
      label1797:
      paramEntity.bindingDate = paramCursor.getLong(i);
      break label781;
      label1812:
      paramEntity.isRecommend = paramCursor.getInt(i);
      break label816;
      label1827:
      paramEntity.nationCode = paramCursor.getString(i);
      break label850;
      label1842:
      paramEntity.mobileCode = paramCursor.getString(i);
      break label884;
      label1857:
      paramEntity.unifiedCode = paramCursor.getString(i);
      break label918;
      label1872:
      paramEntity.nickName = paramCursor.getString(i);
      break label952;
      label1887:
      paramEntity.originBinder = paramCursor.getLong(i);
      break label987;
      label1902:
      paramEntity.ability = paramCursor.getInt(i);
      break label1022;
      label1917:
      paramEntity.contactID = paramCursor.getInt(i);
      break label1057;
      label1932:
      paramEntity.faceUrl = paramCursor.getString(i);
      break label1091;
      label1947:
      paramEntity.remark = paramCursor.getString(i);
      break label1125;
      label1962:
      paramEntity.pinyinAll = paramCursor.getString(i);
      break label1159;
      label1977:
      paramEntity.pinyinInitial = paramCursor.getString(i);
      break label1193;
      label1992:
      paramEntity.lastScanTime = paramCursor.getLong(i);
      break label1228;
      label2007:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isUploaded = paramBoolean;
        break;
      }
      label2034:
      paramEntity.sortWeight = paramCursor.getInt(i);
      break label1298;
      label2049:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasSendAddReq = paramBoolean;
        break;
      }
      label2076:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isNewRecommend = paramBoolean;
        break;
      }
      label2103:
      paramEntity.highLightTimeStamp = paramCursor.getLong(i);
      break label1403;
      label2118:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.isHiden = paramBoolean;
        break;
      }
      label2146:
      paramEntity.md5 = paramCursor.getString(i);
      break label1472;
      label2161:
      paramEntity.type = paramCursor.getInt(i);
      break label1507;
      label2176:
      paramEntity.label = paramCursor.getString(i);
      break label1541;
      label2191:
      paramEntity.detalStatusFlag = ((byte)paramCursor.getShort(i));
      break label1576;
      label2207:
      paramEntity.iTermType = paramCursor.getInt(i);
      break label1611;
      label2222:
      paramEntity.eNetworkType = paramCursor.getInt(i);
      break label1646;
      label2237:
      paramEntity.richTime = paramCursor.getLong(i);
      break label1681;
      label2252:
      paramEntity.richBuffer = paramCursor.getBlob(i);
    }
    label2267:
    paramEntity.abilityBits = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mobileNo TEXT UNIQUE ,uin TEXT ,name TEXT ,bindingDate INTEGER ,isRecommend INTEGER ,nationCode TEXT ,mobileCode TEXT ,unifiedCode TEXT ,nickName TEXT ,originBinder INTEGER ,ability INTEGER ,contactID INTEGER ,faceUrl TEXT ,remark TEXT ,pinyinAll TEXT ,pinyinInitial TEXT ,lastScanTime INTEGER ,isUploaded INTEGER ,sortWeight INTEGER ,hasSendAddReq INTEGER ,isNewRecommend INTEGER ,highLightTimeStamp INTEGER ,isHiden INTEGER ,md5 TEXT ,type INTEGER ,label TEXT ,detalStatusFlag INTEGER ,iTermType INTEGER ,eNetworkType INTEGER ,richTime INTEGER ,richBuffer BLOB ,abilityBits INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (PhoneContact)paramEntity;
    paramContentValues.put("mobileNo", paramEntity.mobileNo);
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("name", paramEntity.name);
    paramContentValues.put("bindingDate", Long.valueOf(paramEntity.bindingDate));
    paramContentValues.put("isRecommend", Integer.valueOf(paramEntity.isRecommend));
    paramContentValues.put("nationCode", paramEntity.nationCode);
    paramContentValues.put("mobileCode", paramEntity.mobileCode);
    paramContentValues.put("unifiedCode", paramEntity.unifiedCode);
    paramContentValues.put("nickName", paramEntity.nickName);
    paramContentValues.put("originBinder", Long.valueOf(paramEntity.originBinder));
    paramContentValues.put("ability", Integer.valueOf(paramEntity.ability));
    paramContentValues.put("contactID", Integer.valueOf(paramEntity.contactID));
    paramContentValues.put("faceUrl", paramEntity.faceUrl);
    paramContentValues.put("remark", paramEntity.remark);
    paramContentValues.put("pinyinAll", paramEntity.pinyinAll);
    paramContentValues.put("pinyinInitial", paramEntity.pinyinInitial);
    paramContentValues.put("lastScanTime", Long.valueOf(paramEntity.lastScanTime));
    paramContentValues.put("isUploaded", Boolean.valueOf(paramEntity.isUploaded));
    paramContentValues.put("sortWeight", Integer.valueOf(paramEntity.sortWeight));
    paramContentValues.put("hasSendAddReq", Boolean.valueOf(paramEntity.hasSendAddReq));
    paramContentValues.put("isNewRecommend", Boolean.valueOf(paramEntity.isNewRecommend));
    paramContentValues.put("highLightTimeStamp", Long.valueOf(paramEntity.highLightTimeStamp));
    paramContentValues.put("isHiden", Boolean.valueOf(paramEntity.isHiden));
    paramContentValues.put("md5", paramEntity.md5);
    paramContentValues.put("type", Integer.valueOf(paramEntity.type));
    paramContentValues.put("label", paramEntity.label);
    paramContentValues.put("detalStatusFlag", Byte.valueOf(paramEntity.detalStatusFlag));
    paramContentValues.put("iTermType", Integer.valueOf(paramEntity.iTermType));
    paramContentValues.put("eNetworkType", Integer.valueOf(paramEntity.eNetworkType));
    paramContentValues.put("richTime", Long.valueOf(paramEntity.richTime));
    paramContentValues.put("richBuffer", paramEntity.richBuffer);
    paramContentValues.put("abilityBits", Long.valueOf(paramEntity.abilityBits));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\PhoneContactDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */