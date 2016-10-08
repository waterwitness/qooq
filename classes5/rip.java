import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class rip
  extends WtloginObserver
{
  rip(rhz paramrhz, Bundle paramBundle, MessengerService paramMessengerService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    boolean bool2 = true;
    paramWUserSigInfo = new Bundle();
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      if (paramDevlockInfo.DevSetup != 1) {
        break label90;
      }
      bool1 = true;
      paramWUserSigInfo.putBoolean("auth_dev_open", bool1);
      if (paramDevlockInfo.AllowSet != 1) {
        break label96;
      }
    }
    label90:
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramWUserSigInfo.putBoolean("allow_set", bool1);
      paramWUserSigInfo.putString("phone_num", paramDevlockInfo.Mobile);
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramWUserSigInfo);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */