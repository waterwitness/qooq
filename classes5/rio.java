import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class rio
  extends BroadcastReceiver
{
  rio(rhz paramrhz, MessengerService paramMessengerService, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((TextUtils.isEmpty(paramContext)) || (!TextUtils.equals(paramContext, "mqq.intent.action.DEVLOCK_ROAM"))) {
      return;
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.getApplicationContext();
    if (paramContext != null) {
      paramContext.unregisterReceiver(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.web.MessengerService", 2, "openDevLock unregisterReceiver context: " + paramContext);
    }
    paramContext = new Bundle(paramIntent.getExtras());
    this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramContext);
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */