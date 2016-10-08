import com.tencent.mobileqq.app.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;

public class qma
  extends TimerTask
{
  private qma(OnLinePushMessageProcessor paramOnLinePushMessageProcessor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.cancel();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */