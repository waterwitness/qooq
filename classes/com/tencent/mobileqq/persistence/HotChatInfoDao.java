package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class HotChatInfoDao
  extends OGAbstractDao
{
  private OGEntityInfo a;
  
  public HotChatInfoDao()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 33;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (HotChatInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.troopCode = paramCursor.getString(paramCursor.getColumnIndex("troopCode"));
      paramEntity.signature = paramCursor.getString(paramCursor.getColumnIndex("signature"));
      paramEntity.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramEntity.faceId = paramCursor.getInt(paramCursor.getColumnIndex("faceId"));
      paramEntity.memberCount = paramCursor.getInt(paramCursor.getColumnIndex("memberCount"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasJoined")))
      {
        paramBoolean = true;
        paramEntity.hasJoined = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isWifiHotChat"))) {
          break label660;
        }
        paramBoolean = true;
        label169:
        paramEntity.isWifiHotChat = paramBoolean;
        paramEntity.uuid = paramCursor.getString(paramCursor.getColumnIndex("uuid"));
        paramEntity.iconUrl = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
        paramEntity.hotThemeGroupFlag = paramCursor.getInt(paramCursor.getColumnIndex("hotThemeGroupFlag"));
        paramEntity.detail = paramCursor.getString(paramCursor.getColumnIndex("detail"));
        paramEntity.state = paramCursor.getInt(paramCursor.getColumnIndex("state"));
        paramEntity.leftTime = paramCursor.getLong(paramCursor.getColumnIndex("leftTime"));
        paramEntity.ruState = paramCursor.getInt(paramCursor.getColumnIndex("ruState"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("supportFlashPic"))) {
          break label665;
        }
        paramBoolean = true;
        label320:
        paramEntity.supportFlashPic = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("supportDemo"))) {
          break label670;
        }
        paramBoolean = true;
        label345:
        paramEntity.supportDemo = paramBoolean;
        paramEntity.adminLevel = paramCursor.getInt(paramCursor.getColumnIndex("adminLevel"));
        paramEntity.joinUrl = paramCursor.getString(paramCursor.getColumnIndex("joinUrl"));
        paramEntity.hotChatType = paramCursor.getInt(paramCursor.getColumnIndex("hotChatType"));
        paramEntity.memo = paramCursor.getString(paramCursor.getColumnIndex("memo"));
        paramEntity.memoUrl = paramCursor.getString(paramCursor.getColumnIndex("memoUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("memoShowed"))) {
          break label675;
        }
        paramBoolean = true;
        label460:
        paramEntity.memoShowed = paramBoolean;
        paramEntity.userCreate = paramCursor.getInt(paramCursor.getColumnIndex("userCreate"));
        paramEntity.strAdminUins = paramCursor.getString(paramCursor.getColumnIndex("strAdminUins"));
        paramEntity.ownerUin = paramCursor.getString(paramCursor.getColumnIndex("ownerUin"));
        paramEntity.pkFlag = paramCursor.getInt(paramCursor.getColumnIndex("pkFlag"));
        paramEntity.subType = paramCursor.getInt(paramCursor.getColumnIndex("subType"));
        paramEntity.lLastMsgSeq = paramCursor.getLong(paramCursor.getColumnIndex("lLastMsgSeq"));
        paramEntity.extra1 = paramCursor.getString(paramCursor.getColumnIndex("extra1"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isFavorite"))) {
          break label680;
        }
      }
      label660:
      label665:
      label670:
      label675:
      label680:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.isFavorite = paramBoolean;
        paramEntity.mFissionRoomNum = paramCursor.getInt(paramCursor.getColumnIndex("mFissionRoomNum"));
        paramEntity.praiseCount = paramCursor.getLong(paramCursor.getColumnIndex("praiseCount"));
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label169;
        paramBoolean = false;
        break label320;
        paramBoolean = false;
        break label345;
        paramBoolean = false;
        break label460;
      }
    }
    int i = paramCursor.getColumnIndex("name");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("name", String.class));
      i = paramCursor.getColumnIndex("troopCode");
      if (i != -1) {
        break label1844;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopCode", String.class));
      label753:
      i = paramCursor.getColumnIndex("signature");
      if (i != -1) {
        break label1859;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("signature", String.class));
      label787:
      i = paramCursor.getColumnIndex("troopUin");
      if (i != -1) {
        break label1874;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopUin", String.class));
      label821:
      i = paramCursor.getColumnIndex("faceId");
      if (i != -1) {
        break label1889;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceId", Integer.TYPE));
      label856:
      i = paramCursor.getColumnIndex("memberCount");
      if (i != -1) {
        break label1904;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("memberCount", Integer.TYPE));
      label891:
      i = paramCursor.getColumnIndex("hasJoined");
      if (i != -1) {
        break label1919;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasJoined", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isWifiHotChat");
      if (i != -1) {
        break label1946;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isWifiHotChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("uuid");
      if (i != -1) {
        break label1973;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uuid", String.class));
      label995:
      i = paramCursor.getColumnIndex("iconUrl");
      if (i != -1) {
        break label1988;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iconUrl", String.class));
      label1029:
      i = paramCursor.getColumnIndex("hotThemeGroupFlag");
      if (i != -1) {
        break label2003;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hotThemeGroupFlag", Integer.TYPE));
      label1064:
      i = paramCursor.getColumnIndex("detail");
      if (i != -1) {
        break label2018;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("detail", String.class));
      label1098:
      i = paramCursor.getColumnIndex("state");
      if (i != -1) {
        break label2033;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("state", Integer.TYPE));
      label1133:
      i = paramCursor.getColumnIndex("leftTime");
      if (i != -1) {
        break label2048;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("leftTime", Long.TYPE));
      label1168:
      i = paramCursor.getColumnIndex("ruState");
      if (i != -1) {
        break label2063;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ruState", Integer.TYPE));
      label1203:
      i = paramCursor.getColumnIndex("supportFlashPic");
      if (i != -1) {
        break label2078;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("supportFlashPic", Boolean.TYPE));
      i = paramCursor.getColumnIndex("supportDemo");
      if (i != -1) {
        break label2105;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("supportDemo", Boolean.TYPE));
      i = paramCursor.getColumnIndex("adminLevel");
      if (i != -1) {
        break label2132;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("adminLevel", Integer.TYPE));
      label1308:
      i = paramCursor.getColumnIndex("joinUrl");
      if (i != -1) {
        break label2147;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("joinUrl", String.class));
      label1342:
      i = paramCursor.getColumnIndex("hotChatType");
      if (i != -1) {
        break label2162;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hotChatType", Integer.TYPE));
      label1377:
      i = paramCursor.getColumnIndex("memo");
      if (i != -1) {
        break label2177;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("memo", String.class));
      label1411:
      i = paramCursor.getColumnIndex("memoUrl");
      if (i != -1) {
        break label2192;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("memoUrl", String.class));
      label1445:
      i = paramCursor.getColumnIndex("memoShowed");
      if (i != -1) {
        break label2207;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("memoShowed", Boolean.TYPE));
      i = paramCursor.getColumnIndex("userCreate");
      if (i != -1) {
        break label2234;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("userCreate", Integer.TYPE));
      label1515:
      i = paramCursor.getColumnIndex("strAdminUins");
      if (i != -1) {
        break label2249;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strAdminUins", String.class));
      label1549:
      i = paramCursor.getColumnIndex("ownerUin");
      if (i != -1) {
        break label2264;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ownerUin", String.class));
      label1583:
      i = paramCursor.getColumnIndex("pkFlag");
      if (i != -1) {
        break label2279;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pkFlag", Integer.TYPE));
      label1618:
      i = paramCursor.getColumnIndex("subType");
      if (i != -1) {
        break label2294;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("subType", Integer.TYPE));
      label1653:
      i = paramCursor.getColumnIndex("lLastMsgSeq");
      if (i != -1) {
        break label2309;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lLastMsgSeq", Long.TYPE));
      label1688:
      i = paramCursor.getColumnIndex("extra1");
      if (i != -1) {
        break label2324;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("extra1", String.class));
      label1722:
      i = paramCursor.getColumnIndex("isFavorite");
      if (i != -1) {
        break label2339;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isFavorite", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mFissionRoomNum");
      if (i != -1) {
        break label2367;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mFissionRoomNum", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("praiseCount");
      if (i != -1) {
        break label2382;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("praiseCount", Long.TYPE));
      return paramEntity;
      paramEntity.name = paramCursor.getString(i);
      break;
      label1844:
      paramEntity.troopCode = paramCursor.getString(i);
      break label753;
      label1859:
      paramEntity.signature = paramCursor.getString(i);
      break label787;
      label1874:
      paramEntity.troopUin = paramCursor.getString(i);
      break label821;
      label1889:
      paramEntity.faceId = paramCursor.getInt(i);
      break label856;
      label1904:
      paramEntity.memberCount = paramCursor.getInt(i);
      break label891;
      label1919:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasJoined = paramBoolean;
        break;
      }
      label1946:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isWifiHotChat = paramBoolean;
        break;
      }
      label1973:
      paramEntity.uuid = paramCursor.getString(i);
      break label995;
      label1988:
      paramEntity.iconUrl = paramCursor.getString(i);
      break label1029;
      label2003:
      paramEntity.hotThemeGroupFlag = paramCursor.getInt(i);
      break label1064;
      label2018:
      paramEntity.detail = paramCursor.getString(i);
      break label1098;
      label2033:
      paramEntity.state = paramCursor.getInt(i);
      break label1133;
      label2048:
      paramEntity.leftTime = paramCursor.getLong(i);
      break label1168;
      label2063:
      paramEntity.ruState = paramCursor.getInt(i);
      break label1203;
      label2078:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.supportFlashPic = paramBoolean;
        break;
      }
      label2105:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.supportDemo = paramBoolean;
        break;
      }
      label2132:
      paramEntity.adminLevel = paramCursor.getInt(i);
      break label1308;
      label2147:
      paramEntity.joinUrl = paramCursor.getString(i);
      break label1342;
      label2162:
      paramEntity.hotChatType = paramCursor.getInt(i);
      break label1377;
      label2177:
      paramEntity.memo = paramCursor.getString(i);
      break label1411;
      label2192:
      paramEntity.memoUrl = paramCursor.getString(i);
      break label1445;
      label2207:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.memoShowed = paramBoolean;
        break;
      }
      label2234:
      paramEntity.userCreate = paramCursor.getInt(i);
      break label1515;
      label2249:
      paramEntity.strAdminUins = paramCursor.getString(i);
      break label1549;
      label2264:
      paramEntity.ownerUin = paramCursor.getString(i);
      break label1583;
      label2279:
      paramEntity.pkFlag = paramCursor.getInt(i);
      break label1618;
      label2294:
      paramEntity.subType = paramCursor.getInt(i);
      break label1653;
      label2309:
      paramEntity.lLastMsgSeq = paramCursor.getLong(i);
      break label1688;
      label2324:
      paramEntity.extra1 = paramCursor.getString(i);
      break label1722;
      label2339:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.isFavorite = paramBoolean;
        break;
      }
      label2367:
      paramEntity.mFissionRoomNum = paramCursor.getInt(i);
    }
    label2382:
    paramEntity.praiseCount = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,name TEXT ,troopCode TEXT ,signature TEXT ,troopUin TEXT UNIQUE ,faceId INTEGER ,memberCount INTEGER ,hasJoined INTEGER ,isWifiHotChat INTEGER ,uuid TEXT ,iconUrl TEXT ,hotThemeGroupFlag INTEGER ,detail TEXT ,state INTEGER ,leftTime INTEGER ,ruState INTEGER ,supportFlashPic INTEGER ,supportDemo INTEGER ,adminLevel INTEGER ,joinUrl TEXT ,hotChatType INTEGER ,memo TEXT ,memoUrl TEXT ,memoShowed INTEGER ,userCreate INTEGER ,strAdminUins TEXT ,ownerUin TEXT ,pkFlag INTEGER ,subType INTEGER ,lLastMsgSeq INTEGER ,extra1 TEXT ,isFavorite INTEGER ,mFissionRoomNum INTEGER ,praiseCount INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (HotChatInfo)paramEntity;
    paramContentValues.put("name", paramEntity.name);
    paramContentValues.put("troopCode", paramEntity.troopCode);
    paramContentValues.put("signature", paramEntity.signature);
    paramContentValues.put("troopUin", paramEntity.troopUin);
    paramContentValues.put("faceId", Integer.valueOf(paramEntity.faceId));
    paramContentValues.put("memberCount", Integer.valueOf(paramEntity.memberCount));
    paramContentValues.put("hasJoined", Boolean.valueOf(paramEntity.hasJoined));
    paramContentValues.put("isWifiHotChat", Boolean.valueOf(paramEntity.isWifiHotChat));
    paramContentValues.put("uuid", paramEntity.uuid);
    paramContentValues.put("iconUrl", paramEntity.iconUrl);
    paramContentValues.put("hotThemeGroupFlag", Integer.valueOf(paramEntity.hotThemeGroupFlag));
    paramContentValues.put("detail", paramEntity.detail);
    paramContentValues.put("state", Integer.valueOf(paramEntity.state));
    paramContentValues.put("leftTime", Long.valueOf(paramEntity.leftTime));
    paramContentValues.put("ruState", Integer.valueOf(paramEntity.ruState));
    paramContentValues.put("supportFlashPic", Boolean.valueOf(paramEntity.supportFlashPic));
    paramContentValues.put("supportDemo", Boolean.valueOf(paramEntity.supportDemo));
    paramContentValues.put("adminLevel", Integer.valueOf(paramEntity.adminLevel));
    paramContentValues.put("joinUrl", paramEntity.joinUrl);
    paramContentValues.put("hotChatType", Integer.valueOf(paramEntity.hotChatType));
    paramContentValues.put("memo", paramEntity.memo);
    paramContentValues.put("memoUrl", paramEntity.memoUrl);
    paramContentValues.put("memoShowed", Boolean.valueOf(paramEntity.memoShowed));
    paramContentValues.put("userCreate", Integer.valueOf(paramEntity.userCreate));
    paramContentValues.put("strAdminUins", paramEntity.strAdminUins);
    paramContentValues.put("ownerUin", paramEntity.ownerUin);
    paramContentValues.put("pkFlag", Integer.valueOf(paramEntity.pkFlag));
    paramContentValues.put("subType", Integer.valueOf(paramEntity.subType));
    paramContentValues.put("lLastMsgSeq", Long.valueOf(paramEntity.lLastMsgSeq));
    paramContentValues.put("extra1", paramEntity.extra1);
    paramContentValues.put("isFavorite", Boolean.valueOf(paramEntity.isFavorite));
    paramContentValues.put("mFissionRoomNum", Integer.valueOf(paramEntity.mFissionRoomNum));
    paramContentValues.put("praiseCount", Long.valueOf(paramEntity.praiseCount));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\HotChatInfoDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */