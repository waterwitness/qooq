import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class tmc
  implements Runnable
{
  public tmc(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (NearbyCardManager)this.a.app.getManager(105);
    this.a.j = ((NearbyCardManager)localObject).a(NearbyPeopleProfileActivity.a(this.a));
    if (!this.a.j) {}
    long l;
    do
    {
      do
      {
        return;
      } while ((!NetworkUtil.e(BaseApplication.getContext())) && (this.a.j));
      localObject = NearbyPeopleProfileActivity.a(this.a).vSeed;
      l = NearbyPeopleProfileActivity.a(this.a).feedPreviewTime;
      if (this.a.b > 0L)
      {
        NearbyProfileUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler, this.a.app, this.a.b, null, this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g, (byte[])localObject, l, true, this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Long);
        return;
      }
    } while (StringUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
    NearbyProfileUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler, this.a.app, 0L, this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g, (byte[])localObject, l, true, this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Long);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tmc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */