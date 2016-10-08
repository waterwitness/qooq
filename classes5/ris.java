import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class ris
  extends WtloginObserver
{
  ris(rhz paramrhz, Bundle paramBundle1, Bundle paramBundle2, MessengerService paramMessengerService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    boolean bool2 = true;
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      paramWUserSigInfo = this.jdField_a_of_type_AndroidOsBundle;
      if (paramDevlockInfo.AllowSet != 1) {
        break label85;
      }
      bool1 = true;
      paramWUserSigInfo.putBoolean("hasSecurityPhoneNumber", bool1);
      paramWUserSigInfo = this.jdField_a_of_type_AndroidOsBundle;
      if (paramDevlockInfo.DevSetup != 1) {
        break label91;
      }
    }
    label85:
    label91:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramWUserSigInfo.putBoolean("devlockIsOpen", bool1);
      this.b.putBundle("response", this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.b);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ris.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */