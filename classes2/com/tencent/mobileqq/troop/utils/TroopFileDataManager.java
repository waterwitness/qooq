package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

public class TroopFileDataManager
{
  public static final String a = "TroopFileDataManager";
  public static Map a;
  public long a;
  public Map b = new HashMap();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public TroopFileDataManager(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static TroopFileDataManager a(long paramLong)
  {
    try
    {
      TroopFileDataManager localTroopFileDataManager2 = (TroopFileDataManager)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      TroopFileDataManager localTroopFileDataManager1 = localTroopFileDataManager2;
      if (localTroopFileDataManager2 == null)
      {
        localTroopFileDataManager1 = new TroopFileDataManager(paramLong);
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localTroopFileDataManager1);
      }
      return localTroopFileDataManager1;
    }
    finally {}
  }
  
  public TroopFileData a(QQAppInterface paramQQAppInterface, String paramString)
  {
    TroopFileData localTroopFileData1 = null;
    try
    {
      if (this.b != null) {
        localTroopFileData1 = (TroopFileData)this.b.get(paramString);
      }
      TroopFileData localTroopFileData2 = localTroopFileData1;
      if (localTroopFileData1 == null)
      {
        paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
        localTroopFileData2 = (TroopFileData)paramQQAppInterface.a(TroopFileData.class, paramString);
        paramQQAppInterface.a();
      }
      return localTroopFileData2;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, TroopFileData paramTroopFileData)
  {
    try
    {
      if (this.b != null) {
        this.b.put(paramTroopFileData.fileUrl, paramTroopFileData);
      }
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      paramQQAppInterface.a(paramTroopFileData);
      paramQQAppInterface.a();
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopFileDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */