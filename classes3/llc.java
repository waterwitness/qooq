import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.util.WeakReferenceHandler;

public class llc
  implements Runnable
{
  public llc(FriendProfileCardActivity paramFriendProfileCardActivity, Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = Bitmap.createScaledBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * 0.125F), (int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * 0.125F), true);
    StackBlur.a((Bitmap)localObject, 2);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b.obtainMessage(12, localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileShoppingPhotoInfo = ProfileShoppingPhotoInfo.getPhotoInfo(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b.sendMessage((Message)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\llc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */