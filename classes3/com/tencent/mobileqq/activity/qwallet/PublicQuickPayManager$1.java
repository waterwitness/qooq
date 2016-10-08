package com.tencent.mobileqq.activity.qwallet;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class PublicQuickPayManager$1
  extends ResultReceiver
{
  PublicQuickPayManager$1(PublicQuickPayManager paramPublicQuickPayManager, Handler paramHandler, String paramString, PublicQuickPayManager.QQWalletPayCompletionImp paramQQWalletPayCompletionImp)
  {
    super(paramHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    paramInt = paramBundle.getInt("retCode");
    if ((paramInt == -3) || (paramInt == -4) || (paramInt == -6)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPublicQuickPayManager.a();
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("retCode", paramInt);
    localBundle.putString("retmsg", paramBundle.getString("retmsg"));
    localBundle.putString("payTime", paramBundle.getString("payTime"));
    localBundle.putString("payChannelType", paramBundle.getString("payChannelType"));
    localBundle.putString("orderId", this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPublicQuickPayManager$QQWalletPayCompletionImp != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPublicQuickPayManager$QQWalletPayCompletionImp.a(paramBundle);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\PublicQuickPayManager$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */