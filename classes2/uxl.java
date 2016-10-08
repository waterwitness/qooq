import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.qphone.base.util.QLog;

public class uxl
  implements Runnable
{
  public uxl(SubAccountControll paramSubAccountControll)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("launchTimedMsgTask() run. startAllSubMessageAccountMsg(false) app.isRunning=");
      if (this.a.a != null) {
        break label82;
      }
    }
    label82:
    for (Object localObject = "null";; localObject = Boolean.valueOf(this.a.a.isRunning()))
    {
      QLog.d("SUB_ACCOUNT", 2, localObject);
      if ((this.a.a != null) && (this.a.a.isRunning())) {
        this.a.a.f(false);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uxl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */