package com.tencent.mobileqq.troop.data;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.CursorOpt;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class TroopTopicDetailInfoManager
{
  public static final String a;
  private EntityManager a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = TroopTopicDetailInfoManager.class.getSimpleName();
  }
  
  public TroopTopicDetailInfoManager(EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
  }
  
  public TroopTopicDetailInfo a(String paramString, long paramLong, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
        localObject3 = TableBuilder.a(TroopTopicDetailInfo.class);
        if (paramBoolean)
        {
          localObject1 = TroopTopicDetailInfo.QUERY_TABLE_ALL_FIELDS;
          paramString = ((EntityManager)localObject2).a(true, (String)localObject3, (String[])localObject1, "troopUin=? and  msgSeq=?", new String[] { paramString, "" + paramLong }, null, null, null, null);
          localObject1 = null;
          if (paramString == null) {
            continue;
          }
          localObject3 = new CursorOpt(paramString);
          paramString = (String)localObject1;
          if (localObject3 != null) {
            paramString = (String)localObject1;
          }
        }
      }
      catch (InstantiationException paramString)
      {
        Object localObject3;
        Object localObject1;
        int i;
        TroopTopicDetailInfo localTroopTopicDetailInfo;
        QLog.d(jdField_a_of_type_JavaLangString + ".troop.troop_topic", 2, "findTroopTopicUpdateSeqFromDb exception", paramString);
        return null;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString + ".troop.troop_topic", 2, "findTroopTopicUpdateSeqFromDb: list result is null;");
        }
        return null;
      }
      catch (IllegalAccessException paramString)
      {
        QLog.d(jdField_a_of_type_JavaLangString + ".troop.troop_topic", 2, "findTroopTopicUpdateSeqFromDb exception", paramString);
        continue;
        continue;
        Object localObject2 = null;
        continue;
      }
      try
      {
        if (((Cursor)localObject3).moveToFirst())
        {
          i = ((Cursor)localObject3).getCount();
          paramString = null;
          localObject2 = paramString;
        }
      }
      catch (Exception localException3)
      {
        paramString = null;
        continue;
      }
      try
      {
        localTroopTopicDetailInfo = (TroopTopicDetailInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopTopicDetailInfo.class, TableBuilder.a(TroopTopicDetailInfo.class), (Cursor)localObject3, null);
        localObject1 = paramString;
        if (localTroopTopicDetailInfo != null)
        {
          localObject1 = paramString;
          if (paramString == null)
          {
            localObject2 = paramString;
            localObject1 = new ArrayList(i);
          }
          localObject2 = localObject1;
          ((List)localObject1).add(localTroopTopicDetailInfo);
        }
        paramString = (String)localObject1;
      }
      catch (Exception localException1)
      {
        paramString = (String)localObject2;
        continue;
      }
      try
      {
        paramBoolean = ((Cursor)localObject3).moveToNext();
        if (paramBoolean) {
          continue;
        }
        localObject2 = paramString;
        if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString + ".troop.troop_topic", 2, "findTroopTopicUpdateSeqFromDb: result list size:" + ((List)localObject2).size());
        }
        return (TroopTopicDetailInfo)((List)localObject2).get(0);
      }
      catch (Exception localException2)
      {
        continue;
      }
      localObject1 = TroopTopicDetailInfo.QUERY_TABLE_BASIC_FIELDS;
      continue;
      localObject2 = paramString;
      if (QLog.isColorLevel())
      {
        QLog.e(jdField_a_of_type_JavaLangString + ".troop.troop_topic", 2, MsfSdkUtils.getStackTraceString((Throwable)localObject1));
        localObject2 = paramString;
      }
    }
  }
  
  public List a(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopTopicDetailInfo.class, true, "troopUin = ? and msgSeq = ?", new String[] { paramString1, paramString2 }, null, null, "msgSeq desc", null);
  }
  
  public boolean a(TroopTopicDetailInfo paramTroopTopicDetailInfo)
  {
    boolean bool = true;
    if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {}
    do
    {
      return false;
      if (paramTroopTopicDetailInfo.getStatus() == 1000)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "saveTroopTopic persistOrReplace: info.getStatus=" + paramTroopTopicDetailInfo.getStatus());
        }
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramTroopTopicDetailInfo);
        if (paramTroopTopicDetailInfo.getStatus() == 1001) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
    } while ((paramTroopTopicDetailInfo.getStatus() != 1001) && (paramTroopTopicDetailInfo.getStatus() != 1002));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString + ".troop.troop_topic", 2, "saveTroopTopic update: info.getStatus=" + paramTroopTopicDetailInfo.getStatus());
    }
    return a(paramTroopTopicDetailInfo, true);
  }
  
  public boolean a(TroopTopicDetailInfo paramTroopTopicDetailInfo, boolean paramBoolean)
  {
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) && (paramTroopTopicDetailInfo != null)) {
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("pVersion", Long.valueOf(paramTroopTopicDetailInfo.pVersion));
        String str;
        String[] arrayOfString;
        if (paramBoolean)
        {
          str = "troopUin=? and msgSeq=?";
          arrayOfString = new String[2];
          arrayOfString[0] = paramTroopTopicDetailInfo.troopUin;
          arrayOfString[1] = ("" + paramTroopTopicDetailInfo.msgSeq);
        }
        for (;;)
        {
          boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TableBuilder.a(TroopTopicDetailInfo.class), localContentValues, str, arrayOfString);
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString + ".troop.troop_topic", 2, "updateTroopTopic updateTroopTopic. result:" + bool2 + " troopUin:" + paramTroopTopicDetailInfo.troopUin + " msgSeq:" + paramTroopTopicDetailInfo.msgSeq + " pVersion:" + paramTroopTopicDetailInfo.pVersion + " bid:" + paramTroopTopicDetailInfo.bid + " pid:" + paramTroopTopicDetailInfo.pid + " isUseMsgSeqIndex:" + paramBoolean);
          return bool2;
          str = "bid=? and pid=?";
          arrayOfString = new String[2];
          arrayOfString[0] = ("" + paramTroopTopicDetailInfo.bid);
          arrayOfString[1] = ("" + paramTroopTopicDetailInfo.pid);
        }
        bool1 = false;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString + ".troop.troop_topic", 2, "updateTroopTopic updateTroopTopic failed. troopUin:" + paramTroopTopicDetailInfo.troopUin + " msgSeq:" + paramTroopTopicDetailInfo.msgSeq + " pVersion:" + paramTroopTopicDetailInfo.pVersion + " bid:" + paramTroopTopicDetailInfo.bid + " pid:" + paramTroopTopicDetailInfo.pid + " isUseMsgSeqIndex:" + paramBoolean, localException);
        }
      }
    }
    return bool1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopTopicDetailInfoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */