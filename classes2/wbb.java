import QQWalletPay.RespCheckChangePwdAuth;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletAuthObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;

public class wbb
  extends Handler
{
  private wbb(JumpAction paramJumpAction)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    if (JumpAction.a(this.a) != null)
    {
      JumpAction.a(this.a).a();
      JumpAction.a(this.a).b(JumpAction.a(this.a));
    }
    if (paramMessage.arg1 != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "msf return error ");
      }
      JumpAction.a(this.a, 1);
      return;
    }
    if ((paramMessage.obj instanceof RespCheckChangePwdAuth))
    {
      paramMessage = (RespCheckChangePwdAuth)paramMessage.obj;
      if (paramMessage.retCode == 0)
      {
        JumpAction.b(this.a);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "server return error, errorCode: " + paramMessage.retCode + " errorMsg: " + paramMessage.retMsg);
      }
    }
    JumpAction.a(this.a, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wbb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */