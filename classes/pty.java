import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pty
  implements Runnable
{
  public pty(BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (BaseActivity.access$300() == null)
    {
      puc localpuc = new puc();
      SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
      localSensorManager.registerListener(localpuc, localSensorManager.getDefaultSensor(1), 0);
      BaseActivity.access$302(localpuc);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */