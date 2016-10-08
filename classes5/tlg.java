import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;

public class tlg
  implements Runnable
{
  public tlg(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.a.a != null) && (this.a.a.a.equals(this.a.app.a()))) {
      ((LocalRedTouchManager)this.a.app.getManager(159)).a(false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tlg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */