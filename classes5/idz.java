import com.tencent.biz.pubaccount.subscript.SubscriptFeedsNewActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class idz
  implements Runnable
{
  private WeakReference a;
  
  public idz(SubscriptFeedsNewActivity paramSubscriptFeedsNewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramSubscriptFeedsNewActivity);
  }
  
  public void run()
  {
    if ((this.a != null) && (this.a.get() != null))
    {
      WebProcessManager localWebProcessManager = (WebProcessManager)((SubscriptFeedsNewActivity)this.a.get()).app.getManager(12);
      if (localWebProcessManager != null) {
        localWebProcessManager.a(1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "enter folder preload web process");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\idz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */