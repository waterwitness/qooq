import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.CheckMsgCount;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qit
  implements Runnable
{
  public qit(CheckMsgCount paramCheckMsgCount)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    CheckMsgCount.a(this.a).b.a().c();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */