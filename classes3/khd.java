import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class khd
  implements Runnable
{
  public khd(AccountManageActivity paramAccountManageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = this.a.app.a();
    this.a.runOnUiThread(new khe(this, l));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\khd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */