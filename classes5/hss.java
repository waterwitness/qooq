import android.os.Handler;
import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;

public class hss
  extends TimerTask
{
  public hss(VideoUIController paramVideoUIController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.sendEmptyMessage(1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */