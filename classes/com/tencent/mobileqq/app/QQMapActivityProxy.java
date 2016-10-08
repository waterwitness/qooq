package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;
import qfe;
import qff;

public class QQMapActivityProxy
{
  public static final String a = "QQMapActivityProxy";
  public static final String b = "com.tencent.mobileqq.getLbsShareSearch";
  public static final String c = "com.tencent.mobileqq.getLbsShareShop";
  public static final String d = "com.tencent.mobileqq.getShareShopDetail";
  public static final String e = "com.tencent.mobileqq.onGetLbsShareSearch";
  public static final String f = "com.tencent.mobileqq.onGetLbsShareShop";
  public static final String g = "com.tencent.mobileqq.onGetShareShopDetail";
  public static final String h = "is_need_destroy_broadcast";
  private static final String i = "com.tencent.mobileqq.addLbsObserver";
  private static final String j = "com.tencent.mobileqq.removeLbsObserver";
  private static final String k = "com.tencent.mobileqq.getStreetViewUrl";
  private static final String l = "com.tencent.mobileqq.unregisterReceiver";
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public QQMapActivityProxy(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new qfe(this);
    this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new qff(this);
    try
    {
      this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)((BaseApplicationImpl)this.jdField_a_of_type_AndroidContentContext).getAppRuntime(paramString));
      paramString = new IntentFilter();
      paramString.addAction("com.tencent.mobileqq.addLbsObserver");
      paramString.addAction("com.tencent.mobileqq.removeLbsObserver");
      paramString.addAction("com.tencent.mobileqq.getStreetViewUrl");
      paramString.addAction("com.tencent.mobileqq.unregisterReceiver");
      paramString.addAction("com.tencent.mobileqq.getLbsShareSearch");
      paramString.addAction("com.tencent.mobileqq.getLbsShareShop");
      paramString.addAction("com.tencent.mobileqq.getShareShopDetail");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("QQMapActivityProxy", 2, "QQMapActivityProxy-create, registerReceiver:" + hashCode() + ", " + this.jdField_a_of_type_AndroidContentBroadcastReceiver.hashCode());
      }
      return;
    }
    catch (AccountNotMatchException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQMapActivityProxy", 2, "AccountNotMatchException " + paramString.toString());
        }
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQMapActivityProxy", 2, "onDestory,  hashCode=" + hashCode());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    }
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("QQMapActivityProxy", 2, "onDestory, mBroadcastReceiver throw an exception when receive UNREGISTER_RECEIVER : " + localException.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\QQMapActivityProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */