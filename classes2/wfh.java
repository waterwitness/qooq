import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.mobileqq.vashealth.StepAlarmReceiver;
import com.tencent.qphone.base.util.QLog;

public class wfh
  implements Runnable
{
  public wfh(StepAlarmReceiver paramStepAlarmReceiver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!SSOHttpUtils.a(2)) {
      return;
    }
    QLog.i("StepAlarmReceiver", 1, "receiver do timmer report.");
    SSOHttpUtils.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wfh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */