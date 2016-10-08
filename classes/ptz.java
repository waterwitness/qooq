import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ptz
  implements Runnable
{
  public ptz(BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (BaseActivity.access$300() != null)
    {
      ((SensorManager)this.a.getSystemService("sensor")).unregisterListener(BaseActivity.access$300());
      BaseActivity.access$302(null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ptz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */