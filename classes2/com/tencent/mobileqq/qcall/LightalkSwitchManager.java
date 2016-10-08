package com.tencent.mobileqq.qcall;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.manager.Manager;

public class LightalkSwitchManager
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = "user_lightalk_switch";
  private static final String b = "server_lightalk_switch";
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LightalkSwitchHanlder jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchHanlder;
  private boolean jdField_a_of_type_Boolean;
  
  public LightalkSwitchManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchHanlder = ((LightalkSwitchHanlder)paramQQAppInterface.a(52));
    this.jdField_a_of_type_Boolean = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getBoolean("server_lightalk_switch", true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putBoolean("server_lightalk_switch", paramBoolean).commit();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putBoolean("user_lightalk_switch", paramBoolean).commit();
      return;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == 0) {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getBoolean("user_lightalk_switch", true)) {
        break label68;
      }
    }
    label68:
    for (int i = 3;; i = 4)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchHanlder.a();
      if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 3)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\LightalkSwitchManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */