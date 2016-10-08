import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.FreshNewsNotifyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sqr
  implements Runnable
{
  public sqr(FreshNewsNotifyFragment paramFreshNewsNotifyFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FreshNewsNotifyFragment.a(this.a, FreshNewsNotifyFragment.a(this.a).a(FreshNewsNotifyFragment.a(this.a), 100));
    FreshNewsNotifyFragment.a(this.a, false);
    FreshNewsNotifyFragment.a(this.a).obtainMessage(12).sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */