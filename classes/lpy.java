import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class lpy
  extends WtloginObserver
{
  public lpy(JumpActivity paramJumpActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (paramDevlockInfo != null) {
      DevlockPhoneStatus.a().a(paramDevlockInfo.TransferInfo);
    }
    paramWUserSigInfo = this.a;
    if (paramInt == 0) {}
    for (;;)
    {
      paramWUserSigInfo.a(paramDevlockInfo);
      return;
      paramDevlockInfo = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\lpy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */