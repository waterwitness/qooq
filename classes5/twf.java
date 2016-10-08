import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.profile.view.PhotoViewForShopping;

public class twf
  implements Runnable
{
  public twf(PhotoViewForShopping paramPhotoViewForShopping, ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a != null))
    {
      ProfileShoppingPhotoInfo localProfileShoppingPhotoInfo = ProfileShoppingPhotoInfo.getPhotoInfo(this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping.a, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
      if ((localProfileShoppingPhotoInfo != null) && (PhotoViewForShopping.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping) != null))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 200;
        localMessage.obj = localProfileShoppingPhotoInfo;
        PhotoViewForShopping.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping).sendMessage(localMessage);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\twf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */