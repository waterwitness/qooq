import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qwallet.plugin.QWalletLockScreenActivity;

public class yjn
  extends Handler
{
  public yjn(QWalletLockScreenActivity paramQWalletLockScreenActivity, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 9: 
      QWalletLockScreenActivity.a(this.a);
      return;
    }
    this.a.moveTaskToBack(true);
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yjn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */