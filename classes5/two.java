import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class two
  implements Runnable
{
  public two(ProfileHeaderView paramProfileHeaderView, ProfileActivity.AllInOne paramAllInOne, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
    if ((localImageView instanceof DynamicAvatarView)) {
      ((DynamicAvatarView)localImageView).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 200, true, true, 3);
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, false);
    } while (!QLog.isColorLevel());
    QLog.d(ProfileHeaderView.jdField_a_of_type_JavaLangString, 2, "face is not DynamicAvatarView!");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\two.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */