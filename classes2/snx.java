import android.os.Handler;
import android.view.LayoutInflater;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class snx
  implements Runnable
{
  public snx(NearbyFragment paramNearbyFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      NearbyFragment.a(this.a, LayoutInflater.from(this.a.getActivity()));
      this.a.a.sendEmptyMessage(10);
      return;
    }
    catch (Exception localException)
    {
      this.a.a.sendEmptyMessage(11);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\snx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */