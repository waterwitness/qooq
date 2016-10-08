import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlAndQQInterface.WorkState;
import java.util.TimerTask;

public class yer
  extends TimerTask
{
  public yer(QQProxyForQlink paramQQProxyForQlink)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQProxyForQlink.a(this.a);
    if (QQProxyForQlink.b(this.a) > 1)
    {
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ qlink pulgin is dead:");
      QQProxyForQlink.a(this.a, new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false));
      QQProxyForQlink.a(this.a);
      return;
    }
    this.a.f();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\yer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */