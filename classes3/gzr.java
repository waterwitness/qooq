import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.av.ui.VideoInviteFull;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;

public class gzr
  implements Runnable
{
  public gzr(VideoInviteFull paramVideoInviteFull)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a == null) {}
    do
    {
      do
      {
        return;
        this.a.a.setVisibility(8);
        this.a.c.setVisibility(8);
        if ((NetworkUtil.i(VideoInviteFull.a(this.a))) || (NetworkUtil.g(VideoInviteFull.b(this.a)))) {
          break;
        }
        if (NetworkUtil.c(VideoInviteFull.c(this.a)))
        {
          this.a.c.setVisibility(0);
          this.a.c.setText(2131363552);
        }
      } while (!NetworkUtil.d(VideoInviteFull.d(this.a)));
      this.a.c.setVisibility(0);
      this.a.c.setText(2131363551);
      return;
    } while (!this.a.b);
    this.a.c.setVisibility(0);
    this.a.c.setText("");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */