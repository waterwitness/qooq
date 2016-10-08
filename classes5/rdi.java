import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import java.util.List;

public class rdi
  implements Runnable
{
  public rdi(DatingDestinationActivity paramDatingDestinationActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    List localList = ((DatingManager)this.a.a.getManager(212)).a();
    this.a.runOnUiThread(new rdj(this, localList));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rdi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */