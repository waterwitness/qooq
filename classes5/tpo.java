import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.rn.NearbyReactBaseActivity;

public class tpo
  implements Runnable
{
  public tpo(NearbyReactBaseActivity paramNearbyReactBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a())
    {
      this.a.a = new tpx(this.a);
      if (this.a.b) {
        this.a.runOnUiThread(this.a.a);
      }
      return;
    }
    this.a.b(6);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tpo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */