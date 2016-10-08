package com.tencent.mobileqq.app.proxy.fts;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.FTSConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.fts.FTSTroopSync;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class FTSTroopUpgrader
  implements FTSConstants, FTSUpgrader
{
  protected int a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FTSSyncHandler jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler;
  FTSTroopOperator jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSTroopOperator;
  
  FTSTroopUpgrader(QQAppInterface paramQQAppInterface, FTSTroopOperator paramFTSTroopOperator)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSTroopOperator = paramFTSTroopOperator;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler = this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSTroopOperator.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putBoolean("fts_troop_upgrade_flag" + paramQQAppInterface.a(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getBoolean("fts_troop_upgrade_flag" + paramQQAppInterface.a(), false);
  }
  
  public void a() {}
  
  public boolean a()
  {
    return !a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public boolean b()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    ((EntityManager)localObject1).b("delete from " + FTSTroopSync.class.getSimpleName());
    ((EntityManager)localObject1).a();
    Object localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a();
    localObject1 = new ArrayList(((ArrayList)localObject2).size());
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      TroopInfo localTroopInfo = (TroopInfo)((Iterator)localObject2).next();
      try
      {
        ((ArrayList)localObject1).add(new FTSTroopSync(5, Long.parseLong(localTroopInfo.troopuin)));
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.e("FTSTroopUpgrader", 2, "startUpgrade exception : " + localException.toString());
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSTroopOperator.a((ArrayList)localObject1))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\proxy\fts\FTSTroopUpgrader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */