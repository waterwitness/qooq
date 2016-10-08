import com.tencent.mobileqq.activity.qwallet.QWalletPushManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class otp
  implements Runnable
{
  public otp(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QWalletPushManager.a(this.a)) {
      QWalletPushManager.a(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\otp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */