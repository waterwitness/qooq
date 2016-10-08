import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

public class tsa
  extends QQBroadcastReceiver
{
  public tsa(ScanTorchActivity paramScanTorchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramAppRuntime = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.d("Olympic.ScanTorchActivity", 2, new Object[] { "onReceive, action=", paramAppRuntime });
      }
    } while (!"com.tencent.mobileqq__alive".equals(paramAppRuntime));
    ScanTorchActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tsa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */