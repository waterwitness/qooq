import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;

class tls
  implements Runnable
{
  tls(tlr paramtlr, String paramString, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Tlr.a.D == 1)
    {
      NearbyPeopleProfileActivity.a(this.jdField_a_of_type_Tlr.a).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
      return;
    }
    NearbyPeopleProfileActivity.a(this.jdField_a_of_type_Tlr.a).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */