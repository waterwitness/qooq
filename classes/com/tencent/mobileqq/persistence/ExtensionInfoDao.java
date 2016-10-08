package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ExtensionInfoDao
  extends OGAbstractDao
{
  private OGEntityInfo a;
  
  public ExtensionInfoDao()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 32;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (ExtensionInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.pendantId = paramCursor.getLong(paramCursor.getColumnIndex("pendantId"));
      paramEntity.uVipFont = paramCursor.getLong(paramCursor.getColumnIndex("uVipFont"));
      paramEntity.vipFontType = paramCursor.getInt(paramCursor.getColumnIndex("vipFontType"));
      paramEntity.colorRingId = paramCursor.getLong(paramCursor.getColumnIndex("colorRingId"));
      paramEntity.commingRingId = paramCursor.getLong(paramCursor.getColumnIndex("commingRingId"));
      paramEntity.timestamp = paramCursor.getLong(paramCursor.getColumnIndex("timestamp"));
      paramEntity.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
      paramEntity.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
      paramEntity.feedTime = paramCursor.getLong(paramCursor.getColumnIndex("feedTime"));
      paramEntity.feedContent = paramCursor.getString(paramCursor.getColumnIndex("feedContent"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("feedHasPhoto")))
      {
        paramBoolean = true;
        paramEntity.feedHasPhoto = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isAdded2C2C"))) {
          break label614;
        }
      }
      label614:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.isAdded2C2C = paramBoolean;
        paramEntity.chatInputType = paramCursor.getInt(paramCursor.getColumnIndex("chatInputType"));
        paramEntity.showC2CPanel = paramCursor.getInt(paramCursor.getColumnIndex("showC2CPanel"));
        paramEntity.pttChangeVoiceType = paramCursor.getInt(paramCursor.getColumnIndex("pttChangeVoiceType"));
        paramEntity.audioPanelType = paramCursor.getInt(paramCursor.getColumnIndex("audioPanelType"));
        paramEntity.chatHotLevel = paramCursor.getInt(paramCursor.getColumnIndex("chatHotLevel"));
        paramEntity.chatDays = paramCursor.getInt(paramCursor.getColumnIndex("chatDays"));
        paramEntity.praiseHotLevel = paramCursor.getInt(paramCursor.getColumnIndex("praiseHotLevel"));
        paramEntity.praiseDays = paramCursor.getInt(paramCursor.getColumnIndex("praiseDays"));
        paramEntity.bestIntimacyType = paramCursor.getInt(paramCursor.getColumnIndex("bestIntimacyType"));
        paramEntity.bestIntimacyDays = paramCursor.getInt(paramCursor.getColumnIndex("bestIntimacyDays"));
        paramEntity.apolloVipFlag = paramCursor.getInt(paramCursor.getColumnIndex("apolloVipFlag"));
        paramEntity.apolloVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("apolloVipLevel"));
        paramEntity.apolloStatus = paramCursor.getInt(paramCursor.getColumnIndex("apolloStatus"));
        paramEntity.apolloLocalTS = paramCursor.getLong(paramCursor.getColumnIndex("apolloLocalTS"));
        paramEntity.apolloServerTS = paramCursor.getLong(paramCursor.getColumnIndex("apolloServerTS"));
        paramEntity.apolloUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("apolloUpdateTime"));
        paramEntity.apolloDataBuffer = paramCursor.getString(paramCursor.getColumnIndex("apolloDataBuffer"));
        paramEntity.uinType = paramCursor.getInt(paramCursor.getColumnIndex("uinType"));
        paramEntity.apolloHistoryDress = paramCursor.getString(paramCursor.getColumnIndex("apolloHistoryDress"));
        return paramEntity;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("pendantId");
      if (i != -1) {
        break label1751;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pendantId", Long.TYPE));
      label688:
      i = paramCursor.getColumnIndex("uVipFont");
      if (i != -1) {
        break label1766;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uVipFont", Long.TYPE));
      label723:
      i = paramCursor.getColumnIndex("vipFontType");
      if (i != -1) {
        break label1781;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vipFontType", Integer.TYPE));
      label758:
      i = paramCursor.getColumnIndex("colorRingId");
      if (i != -1) {
        break label1796;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("colorRingId", Long.TYPE));
      label793:
      i = paramCursor.getColumnIndex("commingRingId");
      if (i != -1) {
        break label1811;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("commingRingId", Long.TYPE));
      label828:
      i = paramCursor.getColumnIndex("timestamp");
      if (i != -1) {
        break label1826;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("timestamp", Long.TYPE));
      label863:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label1841;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("richTime", Long.TYPE));
      label898:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label1856;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("richBuffer", byte[].class));
      label932:
      i = paramCursor.getColumnIndex("feedTime");
      if (i != -1) {
        break label1871;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("feedTime", Long.TYPE));
      label967:
      i = paramCursor.getColumnIndex("feedContent");
      if (i != -1) {
        break label1886;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("feedContent", String.class));
      label1001:
      i = paramCursor.getColumnIndex("feedHasPhoto");
      if (i != -1) {
        break label1901;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("feedHasPhoto", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isAdded2C2C");
      if (i != -1) {
        break label1928;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isAdded2C2C", Boolean.TYPE));
      i = paramCursor.getColumnIndex("chatInputType");
      if (i != -1) {
        break label1956;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("chatInputType", Integer.TYPE));
      label1106:
      i = paramCursor.getColumnIndex("showC2CPanel");
      if (i != -1) {
        break label1971;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("showC2CPanel", Integer.TYPE));
      label1141:
      i = paramCursor.getColumnIndex("pttChangeVoiceType");
      if (i != -1) {
        break label1986;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pttChangeVoiceType", Integer.TYPE));
      label1176:
      i = paramCursor.getColumnIndex("audioPanelType");
      if (i != -1) {
        break label2001;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("audioPanelType", Integer.TYPE));
      label1211:
      i = paramCursor.getColumnIndex("chatHotLevel");
      if (i != -1) {
        break label2016;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("chatHotLevel", Integer.TYPE));
      label1246:
      i = paramCursor.getColumnIndex("chatDays");
      if (i != -1) {
        break label2031;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("chatDays", Integer.TYPE));
      label1281:
      i = paramCursor.getColumnIndex("praiseHotLevel");
      if (i != -1) {
        break label2046;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("praiseHotLevel", Integer.TYPE));
      label1316:
      i = paramCursor.getColumnIndex("praiseDays");
      if (i != -1) {
        break label2061;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("praiseDays", Integer.TYPE));
      label1351:
      i = paramCursor.getColumnIndex("bestIntimacyType");
      if (i != -1) {
        break label2076;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bestIntimacyType", Integer.TYPE));
      label1386:
      i = paramCursor.getColumnIndex("bestIntimacyDays");
      if (i != -1) {
        break label2091;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bestIntimacyDays", Integer.TYPE));
      label1421:
      i = paramCursor.getColumnIndex("apolloVipFlag");
      if (i != -1) {
        break label2106;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloVipFlag", Integer.TYPE));
      label1456:
      i = paramCursor.getColumnIndex("apolloVipLevel");
      if (i != -1) {
        break label2121;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloVipLevel", Integer.TYPE));
      label1491:
      i = paramCursor.getColumnIndex("apolloStatus");
      if (i != -1) {
        break label2136;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloStatus", Integer.TYPE));
      label1526:
      i = paramCursor.getColumnIndex("apolloLocalTS");
      if (i != -1) {
        break label2151;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloLocalTS", Long.TYPE));
      label1561:
      i = paramCursor.getColumnIndex("apolloServerTS");
      if (i != -1) {
        break label2166;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloServerTS", Long.TYPE));
      label1596:
      i = paramCursor.getColumnIndex("apolloUpdateTime");
      if (i != -1) {
        break label2181;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloUpdateTime", Long.TYPE));
      label1631:
      i = paramCursor.getColumnIndex("apolloDataBuffer");
      if (i != -1) {
        break label2196;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloDataBuffer", String.class));
      label1665:
      i = paramCursor.getColumnIndex("uinType");
      if (i != -1) {
        break label2211;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uinType", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("apolloHistoryDress");
      if (i != -1) {
        break label2226;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloHistoryDress", String.class));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label1751:
      paramEntity.pendantId = paramCursor.getLong(i);
      break label688;
      label1766:
      paramEntity.uVipFont = paramCursor.getLong(i);
      break label723;
      label1781:
      paramEntity.vipFontType = paramCursor.getInt(i);
      break label758;
      label1796:
      paramEntity.colorRingId = paramCursor.getLong(i);
      break label793;
      label1811:
      paramEntity.commingRingId = paramCursor.getLong(i);
      break label828;
      label1826:
      paramEntity.timestamp = paramCursor.getLong(i);
      break label863;
      label1841:
      paramEntity.richTime = paramCursor.getLong(i);
      break label898;
      label1856:
      paramEntity.richBuffer = paramCursor.getBlob(i);
      break label932;
      label1871:
      paramEntity.feedTime = paramCursor.getLong(i);
      break label967;
      label1886:
      paramEntity.feedContent = paramCursor.getString(i);
      break label1001;
      label1901:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.feedHasPhoto = paramBoolean;
        break;
      }
      label1928:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.isAdded2C2C = paramBoolean;
        break;
      }
      label1956:
      paramEntity.chatInputType = paramCursor.getInt(i);
      break label1106;
      label1971:
      paramEntity.showC2CPanel = paramCursor.getInt(i);
      break label1141;
      label1986:
      paramEntity.pttChangeVoiceType = paramCursor.getInt(i);
      break label1176;
      label2001:
      paramEntity.audioPanelType = paramCursor.getInt(i);
      break label1211;
      label2016:
      paramEntity.chatHotLevel = paramCursor.getInt(i);
      break label1246;
      label2031:
      paramEntity.chatDays = paramCursor.getInt(i);
      break label1281;
      label2046:
      paramEntity.praiseHotLevel = paramCursor.getInt(i);
      break label1316;
      label2061:
      paramEntity.praiseDays = paramCursor.getInt(i);
      break label1351;
      label2076:
      paramEntity.bestIntimacyType = paramCursor.getInt(i);
      break label1386;
      label2091:
      paramEntity.bestIntimacyDays = paramCursor.getInt(i);
      break label1421;
      label2106:
      paramEntity.apolloVipFlag = paramCursor.getInt(i);
      break label1456;
      label2121:
      paramEntity.apolloVipLevel = paramCursor.getInt(i);
      break label1491;
      label2136:
      paramEntity.apolloStatus = paramCursor.getInt(i);
      break label1526;
      label2151:
      paramEntity.apolloLocalTS = paramCursor.getLong(i);
      break label1561;
      label2166:
      paramEntity.apolloServerTS = paramCursor.getLong(i);
      break label1596;
      label2181:
      paramEntity.apolloUpdateTime = paramCursor.getLong(i);
      break label1631;
      label2196:
      paramEntity.apolloDataBuffer = paramCursor.getString(i);
      break label1665;
      label2211:
      paramEntity.uinType = paramCursor.getInt(i);
    }
    label2226:
    paramEntity.apolloHistoryDress = paramCursor.getString(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,pendantId INTEGER ,uVipFont INTEGER ,vipFontType INTEGER ,colorRingId INTEGER ,commingRingId INTEGER ,timestamp INTEGER ,richTime INTEGER ,richBuffer BLOB ,feedTime INTEGER ,feedContent TEXT ,feedHasPhoto INTEGER ,isAdded2C2C INTEGER ,chatInputType INTEGER ,showC2CPanel INTEGER ,pttChangeVoiceType INTEGER ,audioPanelType INTEGER ,chatHotLevel INTEGER ,chatDays INTEGER ,praiseHotLevel INTEGER ,praiseDays INTEGER ,bestIntimacyType INTEGER ,bestIntimacyDays INTEGER ,apolloVipFlag INTEGER ,apolloVipLevel INTEGER ,apolloStatus INTEGER ,apolloLocalTS INTEGER ,apolloServerTS INTEGER ,apolloUpdateTime INTEGER ,apolloDataBuffer TEXT ,uinType INTEGER ,apolloHistoryDress TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (ExtensionInfo)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("pendantId", Long.valueOf(paramEntity.pendantId));
    paramContentValues.put("uVipFont", Long.valueOf(paramEntity.uVipFont));
    paramContentValues.put("vipFontType", Integer.valueOf(paramEntity.vipFontType));
    paramContentValues.put("colorRingId", Long.valueOf(paramEntity.colorRingId));
    paramContentValues.put("commingRingId", Long.valueOf(paramEntity.commingRingId));
    paramContentValues.put("timestamp", Long.valueOf(paramEntity.timestamp));
    paramContentValues.put("richTime", Long.valueOf(paramEntity.richTime));
    paramContentValues.put("richBuffer", paramEntity.richBuffer);
    paramContentValues.put("feedTime", Long.valueOf(paramEntity.feedTime));
    paramContentValues.put("feedContent", paramEntity.feedContent);
    paramContentValues.put("feedHasPhoto", Boolean.valueOf(paramEntity.feedHasPhoto));
    paramContentValues.put("isAdded2C2C", Boolean.valueOf(paramEntity.isAdded2C2C));
    paramContentValues.put("chatInputType", Integer.valueOf(paramEntity.chatInputType));
    paramContentValues.put("showC2CPanel", Integer.valueOf(paramEntity.showC2CPanel));
    paramContentValues.put("pttChangeVoiceType", Integer.valueOf(paramEntity.pttChangeVoiceType));
    paramContentValues.put("audioPanelType", Integer.valueOf(paramEntity.audioPanelType));
    paramContentValues.put("chatHotLevel", Integer.valueOf(paramEntity.chatHotLevel));
    paramContentValues.put("chatDays", Integer.valueOf(paramEntity.chatDays));
    paramContentValues.put("praiseHotLevel", Integer.valueOf(paramEntity.praiseHotLevel));
    paramContentValues.put("praiseDays", Integer.valueOf(paramEntity.praiseDays));
    paramContentValues.put("bestIntimacyType", Integer.valueOf(paramEntity.bestIntimacyType));
    paramContentValues.put("bestIntimacyDays", Integer.valueOf(paramEntity.bestIntimacyDays));
    paramContentValues.put("apolloVipFlag", Integer.valueOf(paramEntity.apolloVipFlag));
    paramContentValues.put("apolloVipLevel", Integer.valueOf(paramEntity.apolloVipLevel));
    paramContentValues.put("apolloStatus", Integer.valueOf(paramEntity.apolloStatus));
    paramContentValues.put("apolloLocalTS", Long.valueOf(paramEntity.apolloLocalTS));
    paramContentValues.put("apolloServerTS", Long.valueOf(paramEntity.apolloServerTS));
    paramContentValues.put("apolloUpdateTime", Long.valueOf(paramEntity.apolloUpdateTime));
    paramContentValues.put("apolloDataBuffer", paramEntity.apolloDataBuffer);
    paramContentValues.put("uinType", Integer.valueOf(paramEntity.uinType));
    paramContentValues.put("apolloHistoryDress", paramEntity.apolloHistoryDress);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\ExtensionInfoDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */