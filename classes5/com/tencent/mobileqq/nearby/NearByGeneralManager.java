package com.tencent.mobileqq.nearby;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.manager.Manager;

public class NearByGeneralManager
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = "NearByGeneralManager";
  private static final String b = "NearbyGeneralConfig";
  private static final String c = "Notify_on_like";
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean;
  
  public NearByGeneralManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = BaseApplicationImpl.getContext().getSharedPreferences("NearbyGeneralConfig", 0);
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Boolean = paramQQAppInterface.getBoolean("Notify_on_like", true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("NearbyGeneralConfig", 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("Notify_on_like", paramBoolean).commit();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearByGeneralManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */