import com.tencent.mobileqq.activity.aio.tips.FraudTipsBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;
import mqq.os.MqqHandler;

public class oek
  extends TimerTask
{
  public oek(FraudTipsBar paramFraudTipsBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FraudTipsBar.a(this.a).post(new oel(this));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */