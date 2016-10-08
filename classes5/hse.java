import android.os.Handler;
import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;

public class hse
  extends TimerTask
{
  public hse(VideoPlayMgr paramVideoPlayMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.sendEmptyMessage(1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */