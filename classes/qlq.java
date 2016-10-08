import com.tencent.mobileqq.app.message.DiscMessageProcessor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;

public class qlq
  extends TimerTask
{
  private qlq(DiscMessageProcessor paramDiscMessageProcessor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.cancel();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qlq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */