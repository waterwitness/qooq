import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;

public class tns
  implements Runnable
{
  public tns(NearbyProfileEditPanel paramNearbyProfileEditPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a == null) {}
    for (QQAppInterface localQQAppInterface = null;; localQQAppInterface = this.a.a.app)
    {
      if (localQQAppInterface != null)
      {
        NearbySPUtil.a(localQQAppInterface.a(), "temp_school_name", "");
        NearbySPUtil.a(localQQAppInterface.a(), "temp_validate", Boolean.valueOf(true));
      }
      if (NearbyUtils.b()) {
        NearbyUtils.a("Q.nearby_people_card.", new Object[] { "editschoolfromH5 clear cache", localQQAppInterface });
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */