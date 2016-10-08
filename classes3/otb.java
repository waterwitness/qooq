import com.tencent.mobileqq.activity.qwallet.PasswdRedBagDBManager;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class otb
  implements Runnable
{
  public otb(PasswdRedBagManager paramPasswdRedBagManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PasswdRedBagManager.a(this.a).b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\otb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */