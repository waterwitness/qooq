package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import tencent.im.oidb.inner.cmdGroupAdGetAdInfo.GetTroopAioTopAD.AppInfo;
import tencent.im.oidb.inner.cmdGroupAdGetAdInfo.GetTroopAioTopAD.ReqBody;
import vpb;

public class TroopAioADManager
  extends Observable
  implements Manager
{
  public static final int a = 123321;
  private static final String a = "TroopAioADManager";
  private static final String b = "TROOP_AIO_AD_MANAGER_CONFIG";
  private static final String c = "GroupAd.GetAdInfo";
  public QQAppInterface a;
  public EntityManager a;
  public ConcurrentHashMap a;
  
  public TroopAioADManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
        }
        return;
      }
      finally {}
    }
  }
  
  private void c(String paramString)
  {
    GetTroopAioTopAD.AppInfo localAppInfo = new GetTroopAioTopAD.AppInfo();
    localAppInfo.plat_type.set(2);
    localAppInfo.str_app_version.set("6.5.5");
    GetTroopAioTopAD.ReqBody localReqBody = new GetTroopAioTopAD.ReqBody();
    try
    {
      localReqBody.uint64_groupcode.set(Long.parseLong(paramString));
      localReqBody.msg_app_info.set(localAppInfo);
      ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new vpb(this, paramString), localReqBody.toByteArray(), "GroupAd.GetAdInfo");
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopAioADManager", 2, "troopUin(" + paramString + ") cannot parse to long");
    }
  }
  
  public TroopAioTopADInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (TroopAioTopADInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a()
  {
    setChanged();
    notifyObservers(Integer.valueOf(123321));
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopAioADManager", 4, "notify TroopChatPie");
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      paramString = (TroopAioTopADInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopAioTopADInfo.class, paramString);
    } while (paramString == null);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramString);
  }
  
  public void b(String paramString)
  {
    for (;;)
    {
      TroopAioTopADInfo localTroopAioTopADInfo1;
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("TROOP_AIO_AD_MANAGER_CONFIG" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getLong(paramString, 0L);
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopAioADManager", 4, "requestValidTime is " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE).format(new Date(l * 1000L)));
        }
        TroopAioTopADInfo localTroopAioTopADInfo2 = (TroopAioTopADInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopAioADManager", 4, "adInfo in cache: " + localTroopAioTopADInfo2);
        }
        localTroopAioTopADInfo1 = localTroopAioTopADInfo2;
        if (localTroopAioTopADInfo2 == null)
        {
          localTroopAioTopADInfo2 = (TroopAioTopADInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopAioTopADInfo.class, paramString);
          if (QLog.isDevelopLevel()) {
            QLog.d("TroopAioADManager", 4, "adInfo in db: " + localTroopAioTopADInfo2);
          }
          localTroopAioTopADInfo1 = localTroopAioTopADInfo2;
          if (localTroopAioTopADInfo2 != null)
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localTroopAioTopADInfo2);
            localTroopAioTopADInfo1 = localTroopAioTopADInfo2;
          }
        }
        if (System.currentTimeMillis() > l * 1000L)
        {
          c(paramString);
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.d("TroopAioADManager", 4, "requestTopAd");
          continue;
        }
        if (localTroopAioTopADInfo1 == null) {
          break label322;
        }
      }
      finally {}
      if ((System.currentTimeMillis() < localTroopAioTopADInfo1.validTime * 1000L) && (HttpUtil.a(localTroopAioTopADInfo1.picUrl)))
      {
        a();
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopAioADManager", 4, "show local ad");
        }
      }
      else
      {
        label322:
        a(paramString);
      }
    }
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopAioADManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */