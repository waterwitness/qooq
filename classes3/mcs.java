import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class mcs
  implements Runnable
{
  public mcs(QQLSActivity paramQQLSActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      PowerManager localPowerManager = (PowerManager)this.a.getSystemService("power");
      this.a.a = localPowerManager.newWakeLock(268435462, "QQLSActivity");
      this.a.a.acquire(10000L);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQLSActivity", 2, "acquireBrightWakeLock:" + localException.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */