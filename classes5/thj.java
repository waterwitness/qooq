import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

public class thj
  implements Runnable
{
  public thj(NearbyAppInterface paramNearbyAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (this.a.a)
    {
      if (!this.a.d)
      {
        DeviceProfileManager.a(this.a, 214).a(this.a);
        this.a.d = true;
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\thj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */