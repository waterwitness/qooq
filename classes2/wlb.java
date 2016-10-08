import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CircleProgressView;

public class wlb
  implements Runnable
{
  private wlb(CircleProgressView paramCircleProgressView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (CircleProgressView.a(this.a)) {
      CircleProgressView.a(this.a, 3);
    }
    for (;;)
    {
      CircleProgressView.b(this.a, 360);
      CircleProgressView.a(this.a).postDelayed(this, 16L);
      this.a.invalidate();
      return;
      CircleProgressView.a(this.a, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wlb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */