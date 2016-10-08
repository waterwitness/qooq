import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

public class orh
  extends Handler
{
  public orh(PhotoCropForPortraitActivity paramPhotoCropForPortraitActivity, int paramInt1, int paramInt2, ExtensionInfo paramExtensionInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (-1 != paramMessage.what) {
      return;
    }
    paramMessage = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Int * 1.257D), (int)(this.b * 1.481D));
    paramMessage.addRule(14);
    paramMessage.topMargin = ((int)(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_AndroidViewViewGroup.getHeight() * 0.5F - this.b * 0.5F * 1.705D));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentImageURLImageView, paramMessage);
    ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.app.getManager(45)).a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId).a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentImageURLImageView, 6, PendantInfo.k);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\orh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */