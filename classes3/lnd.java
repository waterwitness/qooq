import com.tencent.mobileqq.activity.FriendProfileImageAvatar;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class lnd
  implements Runnable
{
  public lnd(FriendProfileImageAvatar paramFriendProfileImageAvatar, FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    localEntityManager = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.a.a().createEntityManager();
    if (localEntityManager != null) {}
    try
    {
      Setting localSetting = (Setting)localEntityManager.a(Setting.class, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.e);
      if ((localSetting != null) && ((localSetting.headImgTimestamp != 0L) || (localSetting.updateTimestamp != 0L)))
      {
        localSetting.headImgTimestamp = 0L;
        localSetting.updateTimestamp = 0L;
        localEntityManager.a(localSetting);
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.a.a(localSetting);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localEntityManager.a();
      }
    }
    finally
    {
      localEntityManager.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.a.d(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.b);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */