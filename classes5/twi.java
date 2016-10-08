import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;

public class twi
  implements Runnable
{
  public twi(ProfileHeaderView paramProfileHeaderView, ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
    localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_AndroidOsHandler.obtainMessage(ProfileHeaderView.g, localObject);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\twi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */