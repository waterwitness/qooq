package com.tencent.open.model;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.OpenConst;
import com.tencent.open.data.SharedPrefs;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;

public class AccountManage
  implements OpenConst
{
  private static AccountManage jdField_a_of_type_ComTencentOpenModelAccountManage;
  private Context jdField_a_of_type_AndroidContentContext;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private WtloginManager jdField_a_of_type_MqqManagerWtloginManager;
  
  private AccountManage()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.a();
    this.jdField_a_of_type_MqqAppAppRuntime = BaseApplicationImpl.a().a();
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(1));
  }
  
  public static AccountManage a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenModelAccountManage == null) {
        jdField_a_of_type_ComTencentOpenModelAccountManage = new AccountManage();
      }
      AccountManage localAccountManage = jdField_a_of_type_ComTencentOpenModelAccountManage;
      return localAccountManage;
    }
    finally {}
  }
  
  public void a()
  {
    Object localObject = SharedPrefs.a();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(str, 16)) {
          SharedPrefs.b(str);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\model\AccountManage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */