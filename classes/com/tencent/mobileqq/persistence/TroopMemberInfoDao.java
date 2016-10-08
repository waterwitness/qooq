package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TroopMemberInfoDao
  extends OGAbstractDao
{
  private OGEntityInfo a;
  
  public TroopMemberInfoDao()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 38;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (TroopMemberInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      paramEntity.memberuin = paramCursor.getString(paramCursor.getColumnIndex("memberuin"));
      paramEntity.friendnick = paramCursor.getString(paramCursor.getColumnIndex("friendnick"));
      paramEntity.pyAll_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_friendnick"));
      paramEntity.pyFirst_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_friendnick"));
      paramEntity.troopnick = paramCursor.getString(paramCursor.getColumnIndex("troopnick"));
      paramEntity.pyAll_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_troopnick"));
      paramEntity.pyFirst_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_troopnick"));
      paramEntity.autoremark = paramCursor.getString(paramCursor.getColumnIndex("autoremark"));
      paramEntity.pyAll_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyAll_autoremark"));
      paramEntity.pyFirst_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_autoremark"));
      paramEntity.troopremark = paramCursor.getString(paramCursor.getColumnIndex("troopremark"));
      paramEntity.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
      paramEntity.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
      paramEntity.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
      paramEntity.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramEntity.sex = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sex")));
      paramEntity.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
      paramEntity.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
      paramEntity.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
      paramEntity.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
      paramEntity.level = paramCursor.getInt(paramCursor.getColumnIndex("level"));
      paramEntity.mGlamourLevel = paramCursor.getInt(paramCursor.getColumnIndex("mGlamourLevel"));
      paramEntity.join_time = paramCursor.getLong(paramCursor.getColumnIndex("join_time"));
      paramEntity.last_active_time = paramCursor.getLong(paramCursor.getColumnIndex("last_active_time"));
      paramEntity.active_point = paramCursor.getLong(paramCursor.getColumnIndex("active_point"));
      paramEntity.credit_level = paramCursor.getLong(paramCursor.getColumnIndex("credit_level"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isTroopFollowed")))
      {
        paramBoolean = true;
        paramEntity.isTroopFollowed = paramBoolean;
        paramEntity.distance = paramCursor.getInt(paramCursor.getColumnIndex("distance"));
        paramEntity.msgseq = paramCursor.getLong(paramCursor.getColumnIndex("msgseq"));
        paramEntity.gagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("gagTimeStamp"));
        paramEntity.distanceToSelf = paramCursor.getDouble(paramCursor.getColumnIndex("distanceToSelf"));
        paramEntity.distanceToSelfUpdateTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsShielded"))) {
          break label725;
        }
      }
      label725:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.mIsShielded = paramBoolean;
        paramEntity.mUniqueTitle = paramCursor.getString(paramCursor.getColumnIndex("mUniqueTitle"));
        paramEntity.mUniqueTitleExpire = paramCursor.getInt(paramCursor.getColumnIndex("mUniqueTitleExpire"));
        paramEntity.tribeLevel = paramCursor.getInt(paramCursor.getColumnIndex("tribeLevel"));
        paramEntity.tribePoint = paramCursor.getInt(paramCursor.getColumnIndex("tribePoint"));
        return paramEntity;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("troopuin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("troopuin", String.class));
      i = paramCursor.getColumnIndex("memberuin");
      if (i != -1) {
        break label2063;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("memberuin", String.class));
      label798:
      i = paramCursor.getColumnIndex("friendnick");
      if (i != -1) {
        break label2078;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("friendnick", String.class));
      label832:
      i = paramCursor.getColumnIndex("pyAll_friendnick");
      if (i != -1) {
        break label2093;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyAll_friendnick", String.class));
      label866:
      i = paramCursor.getColumnIndex("pyFirst_friendnick");
      if (i != -1) {
        break label2108;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyFirst_friendnick", String.class));
      label900:
      i = paramCursor.getColumnIndex("troopnick");
      if (i != -1) {
        break label2123;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopnick", String.class));
      label934:
      i = paramCursor.getColumnIndex("pyAll_troopnick");
      if (i != -1) {
        break label2138;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyAll_troopnick", String.class));
      label968:
      i = paramCursor.getColumnIndex("pyFirst_troopnick");
      if (i != -1) {
        break label2153;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyFirst_troopnick", String.class));
      label1002:
      i = paramCursor.getColumnIndex("autoremark");
      if (i != -1) {
        break label2168;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("autoremark", String.class));
      label1036:
      i = paramCursor.getColumnIndex("pyAll_autoremark");
      if (i != -1) {
        break label2183;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyAll_autoremark", String.class));
      label1070:
      i = paramCursor.getColumnIndex("pyFirst_autoremark");
      if (i != -1) {
        break label2198;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyFirst_autoremark", String.class));
      label1104:
      i = paramCursor.getColumnIndex("troopremark");
      if (i != -1) {
        break label2213;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopremark", String.class));
      label1138:
      i = paramCursor.getColumnIndex("alias");
      if (i != -1) {
        break label2228;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("alias", String.class));
      label1172:
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label2243;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("datetime", Long.TYPE));
      label1207:
      i = paramCursor.getColumnIndex("faceid");
      if (i != -1) {
        break label2258;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceid", Short.TYPE));
      label1242:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label2273;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("age", Byte.TYPE));
      label1277:
      i = paramCursor.getColumnIndex("sex");
      if (i != -1) {
        break label2289;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("sex", Byte.TYPE));
      label1312:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label2305;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("status", Byte.TYPE));
      label1347:
      i = paramCursor.getColumnIndex("qqVipInfo");
      if (i != -1) {
        break label2321;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qqVipInfo", Integer.TYPE));
      label1382:
      i = paramCursor.getColumnIndex("superQqInfo");
      if (i != -1) {
        break label2336;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("superQqInfo", Integer.TYPE));
      label1417:
      i = paramCursor.getColumnIndex("superVipInfo");
      if (i != -1) {
        break label2351;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("superVipInfo", Integer.TYPE));
      label1452:
      i = paramCursor.getColumnIndex("level");
      if (i != -1) {
        break label2366;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("level", Integer.TYPE));
      label1487:
      i = paramCursor.getColumnIndex("mGlamourLevel");
      if (i != -1) {
        break label2381;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mGlamourLevel", Integer.TYPE));
      label1522:
      i = paramCursor.getColumnIndex("join_time");
      if (i != -1) {
        break label2396;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("join_time", Long.TYPE));
      label1557:
      i = paramCursor.getColumnIndex("last_active_time");
      if (i != -1) {
        break label2411;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("last_active_time", Long.TYPE));
      label1592:
      i = paramCursor.getColumnIndex("active_point");
      if (i != -1) {
        break label2426;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("active_point", Long.TYPE));
      label1627:
      i = paramCursor.getColumnIndex("credit_level");
      if (i != -1) {
        break label2441;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("credit_level", Long.TYPE));
      label1662:
      i = paramCursor.getColumnIndex("isTroopFollowed");
      if (i != -1) {
        break label2456;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isTroopFollowed", Boolean.TYPE));
      i = paramCursor.getColumnIndex("distance");
      if (i != -1) {
        break label2483;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("distance", Integer.TYPE));
      label1732:
      i = paramCursor.getColumnIndex("msgseq");
      if (i != -1) {
        break label2498;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("msgseq", Long.TYPE));
      label1767:
      i = paramCursor.getColumnIndex("gagTimeStamp");
      if (i != -1) {
        break label2513;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("gagTimeStamp", Long.TYPE));
      label1802:
      i = paramCursor.getColumnIndex("distanceToSelf");
      if (i != -1) {
        break label2528;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("distanceToSelf", Double.TYPE));
      label1837:
      i = paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp");
      if (i != -1) {
        break label2543;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("distanceToSelfUpdateTimeStamp", Long.TYPE));
      label1872:
      i = paramCursor.getColumnIndex("mIsShielded");
      if (i != -1) {
        break label2558;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mIsShielded", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mUniqueTitle");
      if (i != -1) {
        break label2586;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mUniqueTitle", String.class));
      label1941:
      i = paramCursor.getColumnIndex("mUniqueTitleExpire");
      if (i != -1) {
        break label2601;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mUniqueTitleExpire", Integer.TYPE));
      label1976:
      i = paramCursor.getColumnIndex("tribeLevel");
      if (i != -1) {
        break label2616;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tribeLevel", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("tribePoint");
      if (i != -1) {
        break label2631;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tribePoint", Integer.TYPE));
      return paramEntity;
      paramEntity.troopuin = paramCursor.getString(i);
      break;
      label2063:
      paramEntity.memberuin = paramCursor.getString(i);
      break label798;
      label2078:
      paramEntity.friendnick = paramCursor.getString(i);
      break label832;
      label2093:
      paramEntity.pyAll_friendnick = paramCursor.getString(i);
      break label866;
      label2108:
      paramEntity.pyFirst_friendnick = paramCursor.getString(i);
      break label900;
      label2123:
      paramEntity.troopnick = paramCursor.getString(i);
      break label934;
      label2138:
      paramEntity.pyAll_troopnick = paramCursor.getString(i);
      break label968;
      label2153:
      paramEntity.pyFirst_troopnick = paramCursor.getString(i);
      break label1002;
      label2168:
      paramEntity.autoremark = paramCursor.getString(i);
      break label1036;
      label2183:
      paramEntity.pyAll_autoremark = paramCursor.getString(i);
      break label1070;
      label2198:
      paramEntity.pyFirst_autoremark = paramCursor.getString(i);
      break label1104;
      label2213:
      paramEntity.troopremark = paramCursor.getString(i);
      break label1138;
      label2228:
      paramEntity.alias = paramCursor.getString(i);
      break label1172;
      label2243:
      paramEntity.datetime = paramCursor.getLong(i);
      break label1207;
      label2258:
      paramEntity.faceid = paramCursor.getShort(i);
      break label1242;
      label2273:
      paramEntity.age = ((byte)paramCursor.getShort(i));
      break label1277;
      label2289:
      paramEntity.sex = ((byte)paramCursor.getShort(i));
      break label1312;
      label2305:
      paramEntity.status = ((byte)paramCursor.getShort(i));
      break label1347;
      label2321:
      paramEntity.qqVipInfo = paramCursor.getInt(i);
      break label1382;
      label2336:
      paramEntity.superQqInfo = paramCursor.getInt(i);
      break label1417;
      label2351:
      paramEntity.superVipInfo = paramCursor.getInt(i);
      break label1452;
      label2366:
      paramEntity.level = paramCursor.getInt(i);
      break label1487;
      label2381:
      paramEntity.mGlamourLevel = paramCursor.getInt(i);
      break label1522;
      label2396:
      paramEntity.join_time = paramCursor.getLong(i);
      break label1557;
      label2411:
      paramEntity.last_active_time = paramCursor.getLong(i);
      break label1592;
      label2426:
      paramEntity.active_point = paramCursor.getLong(i);
      break label1627;
      label2441:
      paramEntity.credit_level = paramCursor.getLong(i);
      break label1662;
      label2456:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isTroopFollowed = paramBoolean;
        break;
      }
      label2483:
      paramEntity.distance = paramCursor.getInt(i);
      break label1732;
      label2498:
      paramEntity.msgseq = paramCursor.getLong(i);
      break label1767;
      label2513:
      paramEntity.gagTimeStamp = paramCursor.getLong(i);
      break label1802;
      label2528:
      paramEntity.distanceToSelf = paramCursor.getDouble(i);
      break label1837;
      label2543:
      paramEntity.distanceToSelfUpdateTimeStamp = paramCursor.getLong(i);
      break label1872;
      label2558:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.mIsShielded = paramBoolean;
        break;
      }
      label2586:
      paramEntity.mUniqueTitle = paramCursor.getString(i);
      break label1941;
      label2601:
      paramEntity.mUniqueTitleExpire = paramCursor.getInt(i);
      break label1976;
      label2616:
      paramEntity.tribeLevel = paramCursor.getInt(i);
    }
    label2631:
    paramEntity.tribePoint = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopuin TEXT ,memberuin TEXT ,friendnick TEXT ,pyAll_friendnick TEXT ,pyFirst_friendnick TEXT ,troopnick TEXT ,pyAll_troopnick TEXT ,pyFirst_troopnick TEXT ,autoremark TEXT ,pyAll_autoremark TEXT ,pyFirst_autoremark TEXT ,troopremark TEXT ,alias TEXT ,datetime INTEGER ,faceid INTEGER ,age INTEGER ,sex INTEGER ,status INTEGER ,qqVipInfo INTEGER ,superQqInfo INTEGER ,superVipInfo INTEGER ,level INTEGER ,mGlamourLevel INTEGER ,join_time INTEGER ,last_active_time INTEGER ,active_point INTEGER ,credit_level INTEGER ,isTroopFollowed INTEGER ,distance INTEGER ,msgseq INTEGER ,gagTimeStamp INTEGER ,distanceToSelf REAL ,distanceToSelfUpdateTimeStamp INTEGER ,mIsShielded INTEGER ,mUniqueTitle TEXT ,mUniqueTitleExpire INTEGER ,tribeLevel INTEGER ,tribePoint INTEGER,UNIQUE(troopuin,memberuin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (TroopMemberInfo)paramEntity;
    paramContentValues.put("troopuin", paramEntity.troopuin);
    paramContentValues.put("memberuin", paramEntity.memberuin);
    paramContentValues.put("friendnick", paramEntity.friendnick);
    paramContentValues.put("pyAll_friendnick", paramEntity.pyAll_friendnick);
    paramContentValues.put("pyFirst_friendnick", paramEntity.pyFirst_friendnick);
    paramContentValues.put("troopnick", paramEntity.troopnick);
    paramContentValues.put("pyAll_troopnick", paramEntity.pyAll_troopnick);
    paramContentValues.put("pyFirst_troopnick", paramEntity.pyFirst_troopnick);
    paramContentValues.put("autoremark", paramEntity.autoremark);
    paramContentValues.put("pyAll_autoremark", paramEntity.pyAll_autoremark);
    paramContentValues.put("pyFirst_autoremark", paramEntity.pyFirst_autoremark);
    paramContentValues.put("troopremark", paramEntity.troopremark);
    paramContentValues.put("alias", paramEntity.alias);
    paramContentValues.put("datetime", Long.valueOf(paramEntity.datetime));
    paramContentValues.put("faceid", Short.valueOf(paramEntity.faceid));
    paramContentValues.put("age", Byte.valueOf(paramEntity.age));
    paramContentValues.put("sex", Byte.valueOf(paramEntity.sex));
    paramContentValues.put("status", Byte.valueOf(paramEntity.status));
    paramContentValues.put("qqVipInfo", Integer.valueOf(paramEntity.qqVipInfo));
    paramContentValues.put("superQqInfo", Integer.valueOf(paramEntity.superQqInfo));
    paramContentValues.put("superVipInfo", Integer.valueOf(paramEntity.superVipInfo));
    paramContentValues.put("level", Integer.valueOf(paramEntity.level));
    paramContentValues.put("mGlamourLevel", Integer.valueOf(paramEntity.mGlamourLevel));
    paramContentValues.put("join_time", Long.valueOf(paramEntity.join_time));
    paramContentValues.put("last_active_time", Long.valueOf(paramEntity.last_active_time));
    paramContentValues.put("active_point", Long.valueOf(paramEntity.active_point));
    paramContentValues.put("credit_level", Long.valueOf(paramEntity.credit_level));
    paramContentValues.put("isTroopFollowed", Boolean.valueOf(paramEntity.isTroopFollowed));
    paramContentValues.put("distance", Integer.valueOf(paramEntity.distance));
    paramContentValues.put("msgseq", Long.valueOf(paramEntity.msgseq));
    paramContentValues.put("gagTimeStamp", Long.valueOf(paramEntity.gagTimeStamp));
    paramContentValues.put("distanceToSelf", Double.valueOf(paramEntity.distanceToSelf));
    paramContentValues.put("distanceToSelfUpdateTimeStamp", Long.valueOf(paramEntity.distanceToSelfUpdateTimeStamp));
    paramContentValues.put("mIsShielded", Boolean.valueOf(paramEntity.mIsShielded));
    paramContentValues.put("mUniqueTitle", paramEntity.mUniqueTitle);
    paramContentValues.put("mUniqueTitleExpire", Integer.valueOf(paramEntity.mUniqueTitleExpire));
    paramContentValues.put("tribeLevel", Integer.valueOf(paramEntity.tribeLevel));
    paramContentValues.put("tribePoint", Integer.valueOf(paramEntity.tribePoint));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\TroopMemberInfoDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */