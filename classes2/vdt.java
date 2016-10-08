import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyMemberActivity;
import com.tencent.mobileqq.troop.utils.NearbyTroopMemMgr;

public class vdt
  implements Runnable
{
  public vdt(NearbyMemberActivity paramNearbyMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    NearbyTroopMemMgr.a(this.a.a.a).a(this.a.a.a, this.a.app, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vdt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */