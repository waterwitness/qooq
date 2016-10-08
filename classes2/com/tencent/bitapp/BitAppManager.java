package com.tencent.bitapp;

import android.content.ContentValues;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.rn.RNAppManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class BitAppManager
  extends RNAppManager
{
  private static final int a = 1;
  public static final String a = "BitAppManager";
  public BitAppHandlerThread a;
  public QQAppInterface a;
  
  public BitAppManager(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (QLog.isColorLevel()) {
      QLog.d("BitAppManager", 4, "BitAppManager ...");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, BitAppPackageFactory.class);
    this.jdField_a_of_type_ComTencentBitappBitAppHandlerThread = new BitAppHandlerThread(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppManager", 4, "scheduleDownloadBitMsg");
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    for (;;)
    {
      MessageForBitAppTmp localMessageForBitAppTmp;
      try
      {
        Object localObject1 = localEntityManager.a(MessageForBitAppTmp.class);
        if (localObject1 == null)
        {
          QLog.d("BitAppManager", 4, "scheduleDownloadBitMsg msgs == null");
          return;
        }
        long l = NetConnInfoCenter.getServerTime();
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localMessageForBitAppTmp = (MessageForBitAppTmp)((Iterator)localObject1).next();
        if (localMessageForBitAppTmp.time <= l - 604800L)
        {
          b(localMessageForBitAppTmp);
          continue;
        }
        if (!localMessageForBitAppTmp.isCanRetry) {
          continue;
        }
      }
      finally
      {
        localEntityManager.a();
      }
      localMessageForBitAppTmp.parse();
      localMessageForBitAppTmp.saveExtInfoToExtStr("tryCounts", "0");
      localMessageForBitAppTmp.tryCounts = 0;
      a(localMessageForBitAppTmp, "extStr", localMessageForBitAppTmp.extStr);
      this.jdField_a_of_type_ComTencentBitappBitAppHandlerThread.a(localMessageForBitAppTmp);
    }
    localEntityManager.a();
  }
  
  public void a(MessageForBitAppTmp paramMessageForBitAppTmp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppManager", 4, "addBitMsgSync" + paramMessageForBitAppTmp);
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      localEntityManager.a(paramMessageForBitAppTmp);
      return;
    }
    finally
    {
      localEntityManager.a();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString1, String paramString2)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put(paramString1, paramString2);
      localEntityManager.a(MessageForBitAppTmp.getTableName_v(), localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) });
      return;
    }
    finally
    {
      localEntityManager.a();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString, byte[] paramArrayOfByte)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put(paramString, paramArrayOfByte);
      localEntityManager.a(MessageForBitAppTmp.getTableName_v(), localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) });
      return;
    }
    finally
    {
      localEntityManager.a();
    }
  }
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppManager", 2, "filter ... uin = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    this.jdField_a_of_type_ComTencentBitappBitAppHandlerThread.a(paramList);
  }
  
  public void b(MessageForBitAppTmp paramMessageForBitAppTmp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppManager", 4, "removeBitMsgSync" + paramMessageForBitAppTmp);
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      localEntityManager.b(paramMessageForBitAppTmp);
      return;
    }
    finally
    {
      localEntityManager.a();
    }
  }
  
  public void c(MessageForBitAppTmp paramMessageForBitAppTmp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppManager", 4, "updateBitMsgTryCountSync" + paramMessageForBitAppTmp);
    }
    if (paramMessageForBitAppTmp.tryCounts < 1) {}
    for (paramMessageForBitAppTmp.isCanRetry = false;; paramMessageForBitAppTmp.isCanRetry = true)
    {
      a(paramMessageForBitAppTmp, "extStr", paramMessageForBitAppTmp.extStr);
      if (paramMessageForBitAppTmp.tryCounts < 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BitAppManager", 4, "updateBitMsgTryCountSync TRY AGAIN");
        }
        this.jdField_a_of_type_ComTencentBitappBitAppHandlerThread.a(paramMessageForBitAppTmp);
      }
      return;
    }
  }
  
  public void d(MessageForBitAppTmp paramMessageForBitAppTmp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppManager", 4, "downloadMsg" + paramMessageForBitAppTmp);
    }
    this.jdField_a_of_type_ComTencentBitappBitAppHandlerThread.a(paramMessageForBitAppTmp);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("BitAppManager", 4, "onDestroyd ...");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */