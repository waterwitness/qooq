import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pue
  implements Runnable
{
  public pue(BaseActivity2 paramBaseActivity2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    pug localpug = new pug(null);
    SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
    localSensorManager.registerListener(localpug, localSensorManager.getDefaultSensor(1), 0);
    BaseActivity2.a(localpug);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */