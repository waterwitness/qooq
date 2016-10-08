import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;

public class tlu
  implements ConditionSearchManager.IConfigListener
{
  public tlu(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramInt == 2))
    {
      if ((NearbyPeopleProfileActivity.a(this.a) == null) || (this.a.D != 1)) {
        break label41;
      }
      NearbyPeopleProfileActivity.a(this.a).f();
    }
    label41:
    while (NearbyPeopleProfileActivity.a(this.a) == null) {
      return;
    }
    NearbyPeopleProfileActivity.a(this.a).a(false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tlu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */