package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FriendsDao
  extends OGAbstractDao
{
  private OGEntityInfo a;
  
  public FriendsDao()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 37;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool = true;
    paramBoolean = true;
    paramEntity = (Friends)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
      paramEntity.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
      paramEntity.sqqtype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqtype")));
      paramEntity.cSpecialFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSpecialFlag")));
      paramEntity.groupid = paramCursor.getInt(paramCursor.getColumnIndex("groupid"));
      paramEntity.memberLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("memberLevel")));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isMqqOnLine"))) {}
      for (;;)
      {
        paramEntity.isMqqOnLine = paramBoolean;
        paramEntity.sqqOnLineState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqOnLineState")));
        paramEntity.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
        paramEntity.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
        paramEntity.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
        paramEntity.gathtertype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gathtertype")));
        paramEntity.smartRemark = paramCursor.getString(paramCursor.getColumnIndex("smartRemark"));
        paramEntity.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
        paramEntity.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
        paramEntity.recommReason = paramCursor.getString(paramCursor.getColumnIndex("recommReason"));
        paramEntity.signature = paramCursor.getString(paramCursor.getColumnIndex("signature"));
        paramEntity.isIphoneOnline = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isIphoneOnline")));
        paramEntity.isRemark = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isRemark")));
        paramEntity.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
        paramEntity.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
        paramEntity.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
        paramEntity.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
        paramEntity.hollywoodVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("hollywoodVipInfo"));
        paramEntity.lastLoginType = paramCursor.getLong(paramCursor.getColumnIndex("lastLoginType"));
        paramEntity.showLoginClient = paramCursor.getLong(paramCursor.getColumnIndex("showLoginClient"));
        paramEntity.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
        paramEntity.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
        paramEntity.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramEntity.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramEntity.cNetwork = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cNetwork")));
        paramEntity.eNetwork = paramCursor.getInt(paramCursor.getColumnIndex("eNetwork"));
        paramEntity.multiFlags = paramCursor.getInt(paramCursor.getColumnIndex("multiFlags"));
        paramEntity.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
        return paramEntity;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label2007;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("remark", String.class));
      label772:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label2022;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("name", String.class));
      label806:
      i = paramCursor.getColumnIndex("faceid");
      if (i != -1) {
        break label2037;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceid", Short.TYPE));
      label841:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label2052;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("status", Byte.TYPE));
      label876:
      i = paramCursor.getColumnIndex("sqqtype");
      if (i != -1) {
        break label2068;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("sqqtype", Byte.TYPE));
      label911:
      i = paramCursor.getColumnIndex("cSpecialFlag");
      if (i != -1) {
        break label2084;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cSpecialFlag", Byte.TYPE));
      label946:
      i = paramCursor.getColumnIndex("groupid");
      if (i != -1) {
        break label2100;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("groupid", Integer.TYPE));
      label981:
      i = paramCursor.getColumnIndex("memberLevel");
      if (i != -1) {
        break label2115;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("memberLevel", Byte.TYPE));
      label1016:
      i = paramCursor.getColumnIndex("isMqqOnLine");
      if (i != -1) {
        break label2131;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isMqqOnLine", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sqqOnLineState");
      if (i != -1) {
        break label2159;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("sqqOnLineState", Byte.TYPE));
      label1086:
      i = paramCursor.getColumnIndex("detalStatusFlag");
      if (i != -1) {
        break label2175;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("detalStatusFlag", Byte.TYPE));
      label1121:
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label2191;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("datetime", Long.TYPE));
      label1156:
      i = paramCursor.getColumnIndex("alias");
      if (i != -1) {
        break label2206;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("alias", String.class));
      label1190:
      i = paramCursor.getColumnIndex("gathtertype");
      if (i != -1) {
        break label2221;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("gathtertype", Byte.TYPE));
      label1225:
      i = paramCursor.getColumnIndex("smartRemark");
      if (i != -1) {
        break label2237;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("smartRemark", String.class));
      label1259:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label2252;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("age", Integer.TYPE));
      label1294:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label2267;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("gender", Byte.TYPE));
      label1329:
      i = paramCursor.getColumnIndex("recommReason");
      if (i != -1) {
        break label2283;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("recommReason", String.class));
      label1363:
      i = paramCursor.getColumnIndex("signature");
      if (i != -1) {
        break label2298;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("signature", String.class));
      label1397:
      i = paramCursor.getColumnIndex("isIphoneOnline");
      if (i != -1) {
        break label2313;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isIphoneOnline", Byte.TYPE));
      label1432:
      i = paramCursor.getColumnIndex("isRemark");
      if (i != -1) {
        break label2329;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isRemark", Byte.TYPE));
      label1467:
      i = paramCursor.getColumnIndex("iTermType");
      if (i != -1) {
        break label2345;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iTermType", Integer.TYPE));
      label1502:
      i = paramCursor.getColumnIndex("qqVipInfo");
      if (i != -1) {
        break label2360;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qqVipInfo", Integer.TYPE));
      label1537:
      i = paramCursor.getColumnIndex("superQqInfo");
      if (i != -1) {
        break label2375;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("superQqInfo", Integer.TYPE));
      label1572:
      i = paramCursor.getColumnIndex("superVipInfo");
      if (i != -1) {
        break label2390;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("superVipInfo", Integer.TYPE));
      label1607:
      i = paramCursor.getColumnIndex("hollywoodVipInfo");
      if (i != -1) {
        break label2405;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hollywoodVipInfo", Integer.TYPE));
      label1642:
      i = paramCursor.getColumnIndex("lastLoginType");
      if (i != -1) {
        break label2420;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastLoginType", Long.TYPE));
      label1677:
      i = paramCursor.getColumnIndex("showLoginClient");
      if (i != -1) {
        break label2435;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("showLoginClient", Long.TYPE));
      label1712:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label2450;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("richTime", Long.TYPE));
      label1747:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label2465;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("richBuffer", byte[].class));
      label1781:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label2480;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label1816:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label2495;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mCompareSpell", String.class));
      label1850:
      i = paramCursor.getColumnIndex("cNetwork");
      if (i != -1) {
        break label2510;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cNetwork", Byte.TYPE));
      label1885:
      i = paramCursor.getColumnIndex("eNetwork");
      if (i != -1) {
        break label2526;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("eNetwork", Integer.TYPE));
      label1920:
      i = paramCursor.getColumnIndex("multiFlags");
      if (i != -1) {
        break label2541;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("multiFlags", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("abilityBits");
      if (i != -1) {
        break label2556;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("abilityBits", Long.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label2007:
      paramEntity.remark = paramCursor.getString(i);
      break label772;
      label2022:
      paramEntity.name = paramCursor.getString(i);
      break label806;
      label2037:
      paramEntity.faceid = paramCursor.getShort(i);
      break label841;
      label2052:
      paramEntity.status = ((byte)paramCursor.getShort(i));
      break label876;
      label2068:
      paramEntity.sqqtype = ((byte)paramCursor.getShort(i));
      break label911;
      label2084:
      paramEntity.cSpecialFlag = ((byte)paramCursor.getShort(i));
      break label946;
      label2100:
      paramEntity.groupid = paramCursor.getInt(i);
      break label981;
      label2115:
      paramEntity.memberLevel = ((byte)paramCursor.getShort(i));
      break label1016;
      label2131:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramEntity.isMqqOnLine = paramBoolean;
        break;
      }
      label2159:
      paramEntity.sqqOnLineState = ((byte)paramCursor.getShort(i));
      break label1086;
      label2175:
      paramEntity.detalStatusFlag = ((byte)paramCursor.getShort(i));
      break label1121;
      label2191:
      paramEntity.datetime = paramCursor.getLong(i);
      break label1156;
      label2206:
      paramEntity.alias = paramCursor.getString(i);
      break label1190;
      label2221:
      paramEntity.gathtertype = ((byte)paramCursor.getShort(i));
      break label1225;
      label2237:
      paramEntity.smartRemark = paramCursor.getString(i);
      break label1259;
      label2252:
      paramEntity.age = paramCursor.getInt(i);
      break label1294;
      label2267:
      paramEntity.gender = ((byte)paramCursor.getShort(i));
      break label1329;
      label2283:
      paramEntity.recommReason = paramCursor.getString(i);
      break label1363;
      label2298:
      paramEntity.signature = paramCursor.getString(i);
      break label1397;
      label2313:
      paramEntity.isIphoneOnline = ((byte)paramCursor.getShort(i));
      break label1432;
      label2329:
      paramEntity.isRemark = ((byte)paramCursor.getShort(i));
      break label1467;
      label2345:
      paramEntity.iTermType = paramCursor.getInt(i);
      break label1502;
      label2360:
      paramEntity.qqVipInfo = paramCursor.getInt(i);
      break label1537;
      label2375:
      paramEntity.superQqInfo = paramCursor.getInt(i);
      break label1572;
      label2390:
      paramEntity.superVipInfo = paramCursor.getInt(i);
      break label1607;
      label2405:
      paramEntity.hollywoodVipInfo = paramCursor.getInt(i);
      break label1642;
      label2420:
      paramEntity.lastLoginType = paramCursor.getLong(i);
      break label1677;
      label2435:
      paramEntity.showLoginClient = paramCursor.getLong(i);
      break label1712;
      label2450:
      paramEntity.richTime = paramCursor.getLong(i);
      break label1747;
      label2465:
      paramEntity.richBuffer = paramCursor.getBlob(i);
      break label1781;
      label2480:
      paramEntity.mComparePartInt = paramCursor.getInt(i);
      break label1816;
      label2495:
      paramEntity.mCompareSpell = paramCursor.getString(i);
      break label1850;
      label2510:
      paramEntity.cNetwork = ((byte)paramCursor.getShort(i));
      break label1885;
      label2526:
      paramEntity.eNetwork = paramCursor.getInt(i);
      break label1920;
      label2541:
      paramEntity.multiFlags = paramCursor.getInt(i);
    }
    label2556:
    paramEntity.abilityBits = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,remark TEXT ,name TEXT ,faceid INTEGER ,status INTEGER ,sqqtype INTEGER ,cSpecialFlag INTEGER ,groupid INTEGER ,memberLevel INTEGER ,isMqqOnLine INTEGER ,sqqOnLineState INTEGER ,detalStatusFlag INTEGER ,datetime INTEGER ,alias TEXT ,gathtertype INTEGER ,smartRemark TEXT ,age INTEGER ,gender INTEGER ,recommReason TEXT ,signature TEXT ,isIphoneOnline INTEGER ,isRemark INTEGER ,iTermType INTEGER ,qqVipInfo INTEGER ,superQqInfo INTEGER ,superVipInfo INTEGER ,hollywoodVipInfo INTEGER ,lastLoginType INTEGER ,showLoginClient INTEGER ,richTime INTEGER ,richBuffer BLOB ,mComparePartInt INTEGER ,mCompareSpell TEXT ,cNetwork INTEGER ,eNetwork INTEGER ,multiFlags INTEGER ,abilityBits INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (Friends)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("remark", paramEntity.remark);
    paramContentValues.put("name", paramEntity.name);
    paramContentValues.put("faceid", Short.valueOf(paramEntity.faceid));
    paramContentValues.put("status", Byte.valueOf(paramEntity.status));
    paramContentValues.put("sqqtype", Byte.valueOf(paramEntity.sqqtype));
    paramContentValues.put("cSpecialFlag", Byte.valueOf(paramEntity.cSpecialFlag));
    paramContentValues.put("groupid", Integer.valueOf(paramEntity.groupid));
    paramContentValues.put("memberLevel", Byte.valueOf(paramEntity.memberLevel));
    paramContentValues.put("isMqqOnLine", Boolean.valueOf(paramEntity.isMqqOnLine));
    paramContentValues.put("sqqOnLineState", Byte.valueOf(paramEntity.sqqOnLineState));
    paramContentValues.put("detalStatusFlag", Byte.valueOf(paramEntity.detalStatusFlag));
    paramContentValues.put("datetime", Long.valueOf(paramEntity.datetime));
    paramContentValues.put("alias", paramEntity.alias);
    paramContentValues.put("gathtertype", Byte.valueOf(paramEntity.gathtertype));
    paramContentValues.put("smartRemark", paramEntity.smartRemark);
    paramContentValues.put("age", Integer.valueOf(paramEntity.age));
    paramContentValues.put("gender", Byte.valueOf(paramEntity.gender));
    paramContentValues.put("recommReason", paramEntity.recommReason);
    paramContentValues.put("signature", paramEntity.signature);
    paramContentValues.put("isIphoneOnline", Byte.valueOf(paramEntity.isIphoneOnline));
    paramContentValues.put("isRemark", Byte.valueOf(paramEntity.isRemark));
    paramContentValues.put("iTermType", Integer.valueOf(paramEntity.iTermType));
    paramContentValues.put("qqVipInfo", Integer.valueOf(paramEntity.qqVipInfo));
    paramContentValues.put("superQqInfo", Integer.valueOf(paramEntity.superQqInfo));
    paramContentValues.put("superVipInfo", Integer.valueOf(paramEntity.superVipInfo));
    paramContentValues.put("hollywoodVipInfo", Integer.valueOf(paramEntity.hollywoodVipInfo));
    paramContentValues.put("lastLoginType", Long.valueOf(paramEntity.lastLoginType));
    paramContentValues.put("showLoginClient", Long.valueOf(paramEntity.showLoginClient));
    paramContentValues.put("richTime", Long.valueOf(paramEntity.richTime));
    paramContentValues.put("richBuffer", paramEntity.richBuffer);
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramEntity.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramEntity.mCompareSpell);
    paramContentValues.put("cNetwork", Byte.valueOf(paramEntity.cNetwork));
    paramContentValues.put("eNetwork", Integer.valueOf(paramEntity.eNetwork));
    paramContentValues.put("multiFlags", Integer.valueOf(paramEntity.multiFlags));
    paramContentValues.put("abilityBits", Long.valueOf(paramEntity.abilityBits));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\FriendsDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */