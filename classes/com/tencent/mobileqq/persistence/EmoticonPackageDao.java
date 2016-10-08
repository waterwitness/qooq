package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class EmoticonPackageDao
  extends OGAbstractDao
{
  private OGEntityInfo a;
  
  public EmoticonPackageDao()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 30;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (EmoticonPackage)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      paramEntity.wordingId = paramCursor.getLong(paramCursor.getColumnIndex("wordingId"));
      paramEntity.childEpId = paramCursor.getString(paramCursor.getColumnIndex("childEpId"));
      paramEntity.minQQVersion = paramCursor.getString(paramCursor.getColumnIndex("minQQVersion"));
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.mark = paramCursor.getString(paramCursor.getColumnIndex("mark"));
      paramEntity.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramEntity.author = paramCursor.getString(paramCursor.getColumnIndex("author"));
      paramEntity.expiretime = paramCursor.getLong(paramCursor.getColumnIndex("expiretime"));
      paramEntity.status = paramCursor.getInt(paramCursor.getColumnIndex("status"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasSound")))
      {
        paramBoolean = true;
        paramEntity.hasSound = paramBoolean;
        paramEntity.jobType = paramCursor.getInt(paramCursor.getColumnIndex("jobType"));
        paramEntity.kinId = paramCursor.getString(paramCursor.getColumnIndex("kinId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("valid"))) {
          break label599;
        }
        paramBoolean = true;
        label277:
        paramEntity.valid = paramBoolean;
        paramEntity.downloadCount = paramCursor.getInt(paramCursor.getColumnIndex("downloadCount"));
        paramEntity.mobileFeetype = paramCursor.getInt(paramCursor.getColumnIndex("mobileFeetype"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRecommendation"))) {
          break label604;
        }
        paramBoolean = true;
        label338:
        paramEntity.isRecommendation = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isMagicFaceDownloading"))) {
          break label609;
        }
        paramBoolean = true;
        label363:
        paramEntity.isMagicFaceDownloading = paramBoolean;
        paramEntity.firstEmotionId = paramCursor.getString(paramCursor.getColumnIndex("firstEmotionId"));
        paramEntity.upperLeftLable = paramCursor.getInt(paramCursor.getColumnIndex("upperLeftLable"));
        paramEntity.localVersion = paramCursor.getInt(paramCursor.getColumnIndex("localVersion"));
        paramEntity.latestVersion = paramCursor.getInt(paramCursor.getColumnIndex("latestVersion"));
        paramEntity.jsonVersion = paramCursor.getInt(paramCursor.getColumnIndex("jsonVersion"));
        paramEntity.updateFlag = paramCursor.getInt(paramCursor.getColumnIndex("updateFlag"));
        paramEntity.updateTip = paramCursor.getString(paramCursor.getColumnIndex("updateTip"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasReadUpdatePage"))) {
          break label614;
        }
      }
      label599:
      label604:
      label609:
      label614:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.hasReadUpdatePage = paramBoolean;
        paramEntity.rscType = paramCursor.getInt(paramCursor.getColumnIndex("rscType"));
        paramEntity.supportSize = paramCursor.getString(paramCursor.getColumnIndex("supportSize"));
        paramEntity.businessExtra = paramCursor.getString(paramCursor.getColumnIndex("businessExtra"));
        paramEntity.subType = paramCursor.getInt(paramCursor.getColumnIndex("subType"));
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label277;
        paramBoolean = false;
        break label338;
        paramBoolean = false;
        break label363;
      }
    }
    int i = paramCursor.getColumnIndex("epId");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("epId", String.class));
      i = paramCursor.getColumnIndex("wordingId");
      if (i != -1) {
        break label1675;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("wordingId", Long.TYPE));
      label688:
      i = paramCursor.getColumnIndex("childEpId");
      if (i != -1) {
        break label1690;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("childEpId", String.class));
      label722:
      i = paramCursor.getColumnIndex("minQQVersion");
      if (i != -1) {
        break label1705;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("minQQVersion", String.class));
      label756:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label1720;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("name", String.class));
      label790:
      i = paramCursor.getColumnIndex("mark");
      if (i != -1) {
        break label1735;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mark", String.class));
      label824:
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label1750;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("type", Integer.TYPE));
      label859:
      i = paramCursor.getColumnIndex("author");
      if (i != -1) {
        break label1765;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("author", String.class));
      label893:
      i = paramCursor.getColumnIndex("expiretime");
      if (i != -1) {
        break label1780;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("expiretime", Long.TYPE));
      label928:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label1795;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("status", Integer.TYPE));
      label963:
      i = paramCursor.getColumnIndex("hasSound");
      if (i != -1) {
        break label1810;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("jobType");
      if (i != -1) {
        break label1837;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("jobType", Integer.TYPE));
      label1033:
      i = paramCursor.getColumnIndex("kinId");
      if (i != -1) {
        break label1852;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("kinId", String.class));
      label1067:
      i = paramCursor.getColumnIndex("valid");
      if (i != -1) {
        break label1867;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("valid", Boolean.TYPE));
      i = paramCursor.getColumnIndex("downloadCount");
      if (i != -1) {
        break label1894;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("downloadCount", Integer.TYPE));
      label1137:
      i = paramCursor.getColumnIndex("mobileFeetype");
      if (i != -1) {
        break label1909;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mobileFeetype", Integer.TYPE));
      label1172:
      i = paramCursor.getColumnIndex("isRecommendation");
      if (i != -1) {
        break label1924;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isRecommendation", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isMagicFaceDownloading");
      if (i != -1) {
        break label1951;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isMagicFaceDownloading", Boolean.TYPE));
      i = paramCursor.getColumnIndex("firstEmotionId");
      if (i != -1) {
        break label1978;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("firstEmotionId", String.class));
      label1276:
      i = paramCursor.getColumnIndex("upperLeftLable");
      if (i != -1) {
        break label1993;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("upperLeftLable", Integer.TYPE));
      label1311:
      i = paramCursor.getColumnIndex("localVersion");
      if (i != -1) {
        break label2008;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("localVersion", Integer.TYPE));
      label1346:
      i = paramCursor.getColumnIndex("latestVersion");
      if (i != -1) {
        break label2023;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("latestVersion", Integer.TYPE));
      label1381:
      i = paramCursor.getColumnIndex("jsonVersion");
      if (i != -1) {
        break label2038;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("jsonVersion", Integer.TYPE));
      label1416:
      i = paramCursor.getColumnIndex("updateFlag");
      if (i != -1) {
        break label2053;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("updateFlag", Integer.TYPE));
      label1451:
      i = paramCursor.getColumnIndex("updateTip");
      if (i != -1) {
        break label2068;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("updateTip", String.class));
      label1485:
      i = paramCursor.getColumnIndex("hasReadUpdatePage");
      if (i != -1) {
        break label2083;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasReadUpdatePage", Boolean.TYPE));
      i = paramCursor.getColumnIndex("rscType");
      if (i != -1) {
        break label2111;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("rscType", Integer.TYPE));
      label1555:
      i = paramCursor.getColumnIndex("supportSize");
      if (i != -1) {
        break label2126;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("supportSize", String.class));
      label1589:
      i = paramCursor.getColumnIndex("businessExtra");
      if (i != -1) {
        break label2141;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("businessExtra", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("subType");
      if (i != -1) {
        break label2156;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("subType", Integer.TYPE));
      return paramEntity;
      paramEntity.epId = paramCursor.getString(i);
      break;
      label1675:
      paramEntity.wordingId = paramCursor.getLong(i);
      break label688;
      label1690:
      paramEntity.childEpId = paramCursor.getString(i);
      break label722;
      label1705:
      paramEntity.minQQVersion = paramCursor.getString(i);
      break label756;
      label1720:
      paramEntity.name = paramCursor.getString(i);
      break label790;
      label1735:
      paramEntity.mark = paramCursor.getString(i);
      break label824;
      label1750:
      paramEntity.type = paramCursor.getInt(i);
      break label859;
      label1765:
      paramEntity.author = paramCursor.getString(i);
      break label893;
      label1780:
      paramEntity.expiretime = paramCursor.getLong(i);
      break label928;
      label1795:
      paramEntity.status = paramCursor.getInt(i);
      break label963;
      label1810:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasSound = paramBoolean;
        break;
      }
      label1837:
      paramEntity.jobType = paramCursor.getInt(i);
      break label1033;
      label1852:
      paramEntity.kinId = paramCursor.getString(i);
      break label1067;
      label1867:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.valid = paramBoolean;
        break;
      }
      label1894:
      paramEntity.downloadCount = paramCursor.getInt(i);
      break label1137;
      label1909:
      paramEntity.mobileFeetype = paramCursor.getInt(i);
      break label1172;
      label1924:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isRecommendation = paramBoolean;
        break;
      }
      label1951:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isMagicFaceDownloading = paramBoolean;
        break;
      }
      label1978:
      paramEntity.firstEmotionId = paramCursor.getString(i);
      break label1276;
      label1993:
      paramEntity.upperLeftLable = paramCursor.getInt(i);
      break label1311;
      label2008:
      paramEntity.localVersion = paramCursor.getInt(i);
      break label1346;
      label2023:
      paramEntity.latestVersion = paramCursor.getInt(i);
      break label1381;
      label2038:
      paramEntity.jsonVersion = paramCursor.getInt(i);
      break label1416;
      label2053:
      paramEntity.updateFlag = paramCursor.getInt(i);
      break label1451;
      label2068:
      paramEntity.updateTip = paramCursor.getString(i);
      break label1485;
      label2083:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.hasReadUpdatePage = paramBoolean;
        break;
      }
      label2111:
      paramEntity.rscType = paramCursor.getInt(i);
      break label1555;
      label2126:
      paramEntity.supportSize = paramCursor.getString(i);
      break label1589;
      label2141:
      paramEntity.businessExtra = paramCursor.getString(i);
    }
    label2156:
    paramEntity.subType = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,epId TEXT UNIQUE ,wordingId INTEGER ,childEpId TEXT ,minQQVersion TEXT ,name TEXT ,mark TEXT ,type INTEGER ,author TEXT ,expiretime INTEGER ,status INTEGER ,hasSound INTEGER ,jobType INTEGER ,kinId TEXT ,valid INTEGER ,downloadCount INTEGER ,mobileFeetype INTEGER ,isRecommendation INTEGER ,isMagicFaceDownloading INTEGER ,firstEmotionId TEXT ,upperLeftLable INTEGER ,localVersion INTEGER ,latestVersion INTEGER ,jsonVersion INTEGER default 0 ,updateFlag INTEGER ,updateTip TEXT ,hasReadUpdatePage INTEGER ,rscType INTEGER ,supportSize TEXT ,businessExtra TEXT ,subType INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (EmoticonPackage)paramEntity;
    paramContentValues.put("epId", paramEntity.epId);
    paramContentValues.put("wordingId", Long.valueOf(paramEntity.wordingId));
    paramContentValues.put("childEpId", paramEntity.childEpId);
    paramContentValues.put("minQQVersion", paramEntity.minQQVersion);
    paramContentValues.put("name", paramEntity.name);
    paramContentValues.put("mark", paramEntity.mark);
    paramContentValues.put("type", Integer.valueOf(paramEntity.type));
    paramContentValues.put("author", paramEntity.author);
    paramContentValues.put("expiretime", Long.valueOf(paramEntity.expiretime));
    paramContentValues.put("status", Integer.valueOf(paramEntity.status));
    paramContentValues.put("hasSound", Boolean.valueOf(paramEntity.hasSound));
    paramContentValues.put("jobType", Integer.valueOf(paramEntity.jobType));
    paramContentValues.put("kinId", paramEntity.kinId);
    paramContentValues.put("valid", Boolean.valueOf(paramEntity.valid));
    paramContentValues.put("downloadCount", Integer.valueOf(paramEntity.downloadCount));
    paramContentValues.put("mobileFeetype", Integer.valueOf(paramEntity.mobileFeetype));
    paramContentValues.put("isRecommendation", Boolean.valueOf(paramEntity.isRecommendation));
    paramContentValues.put("isMagicFaceDownloading", Boolean.valueOf(paramEntity.isMagicFaceDownloading));
    paramContentValues.put("firstEmotionId", paramEntity.firstEmotionId);
    paramContentValues.put("upperLeftLable", Integer.valueOf(paramEntity.upperLeftLable));
    paramContentValues.put("localVersion", Integer.valueOf(paramEntity.localVersion));
    paramContentValues.put("latestVersion", Integer.valueOf(paramEntity.latestVersion));
    paramContentValues.put("jsonVersion", Integer.valueOf(paramEntity.jsonVersion));
    paramContentValues.put("updateFlag", Integer.valueOf(paramEntity.updateFlag));
    paramContentValues.put("updateTip", paramEntity.updateTip);
    paramContentValues.put("hasReadUpdatePage", Boolean.valueOf(paramEntity.hasReadUpdatePage));
    paramContentValues.put("rscType", Integer.valueOf(paramEntity.rscType));
    paramContentValues.put("supportSize", paramEntity.supportSize);
    paramContentValues.put("businessExtra", paramEntity.businessExtra);
    paramContentValues.put("subType", Integer.valueOf(paramEntity.subType));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\EmoticonPackageDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */