import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

public class lwc
  implements Runnable
{
  public lwc(NearbyActivity paramNearbyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a[2] != 0) {
      this.a.b.a("CliOper", "0X8006150");
    }
    if (this.a.a[1] != 0) {
      this.a.b.a("CliOper", "0X8006151");
    }
    if (this.a.a[0] != 0) {
      this.a.b.a("CliOper", "0X8006278");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lwc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */