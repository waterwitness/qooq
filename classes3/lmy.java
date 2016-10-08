import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.FriendProfileImageModel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.Gallery;

class lmy
  implements Runnable
{
  lmy(lmx paramlmx)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_Int != this.a.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b()) {
      this.a.a.jdField_a_of_type_Int = this.a.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b();
    }
    View localView;
    do
    {
      return;
      localView = this.a.a.jdField_a_of_type_ComTencentWidgetGallery.a();
    } while (localView == null);
    this.a.a.jdField_a_of_type_AndroidViewView = localView;
    this.a.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b());
    this.a.a.a(this.a.a.jdField_a_of_type_ComTencentWidgetGallery, this.a.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lmy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */