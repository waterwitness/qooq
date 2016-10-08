import android.os.Handler;
import com.dataline.util.widget.WaitTextView;
import com.dataline.util.widget.WaitTextView.RefreshListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ee
  implements Runnable
{
  public ee(WaitTextView paramWaitTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    WaitTextView.a(this.a);
    if (WaitTextView.a(this.a) != null) {
      WaitTextView.a(this.a).a();
    }
    WaitTextView.a(this.a).postDelayed(this, 500L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */