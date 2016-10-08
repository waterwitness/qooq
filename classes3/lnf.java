import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileImageAvatar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.ProfileCardUtil;
import mqq.os.MqqHandler;

public class lnf
  implements Runnable
{
  public lnf(FriendProfileImageAvatar paramFriendProfileImageAvatar, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (FileUtil.a(ProfileCardUtil.a(String.valueOf(this.jdField_a_of_type_JavaLangString)))) {
      if (NearbyUtils.a()) {
        NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar hd avatar file exist 1", new Object[0]);
      }
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.c) {
        break;
      }
    } while (!NearbyUtils.a());
    NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar makingHDUrl return 2", new Object[0]);
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.c = true;
    Setting localSetting = (Setting)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(Setting.class, this.jdField_a_of_type_JavaLangString);
    if ((localSetting != null) && (!TextUtils.isEmpty(localSetting.url)))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 5;
      localMessage.obj = localSetting;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.c = false;
      if (!NearbyUtils.a()) {
        break;
      }
      NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar end of makingHDUrl", new Object[0]);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lnf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */