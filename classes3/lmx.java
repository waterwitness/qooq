import android.os.AsyncTask;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.FriendProfileImageModel;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import com.tencent.mobileqq.adapter.FriendProfileImageAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.Gallery;

public class lmx
  extends AsyncTask
{
  public lmx(FriendProfileImageActivity paramFriendProfileImageActivity, FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Void a(Void... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b());
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.notifyDataSetChanged();
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new lmy(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lmx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */