import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class puc
  extends ShakeListener
{
  public puc()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = 250;
  }
  
  public void a()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {}
    while (!localBaseActivity.mCurrentActivityShakeFlag) {
      return;
    }
    ThreadManager.b().post(new pud(this, localBaseActivity));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\puc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */