import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;

public class tlw
  implements Runnable
{
  public tlw(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity) != null)
    {
      NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    QLog.i("Q.nearby_people_card.", 1, "mDynamicAvatarDownloadManager is NULL!!!");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tlw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */