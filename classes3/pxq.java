import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pxq
  implements Runnable
{
  public pxq(FrameHelperActivity paramFrameHelperActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.getActivity() == null) || (this.a.getActivity().app == null)) {}
    do
    {
      return;
      this.a.k();
    } while (this.a.a == null);
    this.a.a.sendEmptyMessage(9);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pxq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */