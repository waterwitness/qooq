import com.tencent.mobileqq.freshnews.FreshNewsHandler;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.MyFreshNewsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;

public class srb
  implements Runnable
{
  public srb(MyFreshNewsActivity paramMyFreshNewsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FreshNewsManager localFreshNewsManager = (FreshNewsManager)this.a.a.getManager(211);
    localFreshNewsManager.b(localFreshNewsManager.e);
    this.a.a.a().a("100510.100519");
    localFreshNewsManager.d();
    ((FreshNewsHandler)this.a.a.a(1)).a(localFreshNewsManager.e, localFreshNewsManager.f, 0, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\srb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */