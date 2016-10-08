import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;

public class tlt
  implements ConditionSearchManager.IConfigListener
{
  public tlt(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.a.a();
    if (!paramBoolean) {
      this.a.b(this.a.getString(2131371451));
    }
    while ((this.a.D != 1) || (paramInt != 2)) {
      return;
    }
    NearbyPeopleProfileActivity.a(this.a).h();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tlt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */