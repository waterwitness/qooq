package com.tencent.mobileqq.activity;

import android.app.NotificationManager;
import android.os.Bundle;
import android.os.Handler.Callback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PayLSUnlockActivity
  extends QQLSUnlockActivity
  implements Handler.Callback
{
  BaseApplicationImpl a;
  public QQAppInterface a;
  
  public PayLSUnlockActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = (NotificationManager)getSystemService("notification");
    if (paramBundle != null) {
      paramBundle.cancel(128);
    }
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = BaseApplicationImpl.a();
    paramBundle = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a();
    if ((paramBundle instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBundle);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      QWalletPushManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\PayLSUnlockActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */