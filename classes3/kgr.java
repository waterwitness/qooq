import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.qphone.base.remote.SimpleAccount;

class kgr
  implements Runnable
{
  kgr(kgq paramkgq, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_Kgq.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app, this.jdField_a_of_type_Kgq.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), (byte)3);
    if (localFaceDrawable != null) {
      this.jdField_a_of_type_Kgq.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localFaceDrawable);
    }
    this.jdField_a_of_type_Kgq.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Kgq.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Kgq.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.b(this.jdField_a_of_type_Kgq.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin()));
    if (AppSetting.j)
    {
      if (this.jdField_a_of_type_Kgq.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.b) {
        this.jdField_a_of_type_Kgq.jdField_a_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_Kgq.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.jdField_a_of_type_Kgq.jdField_a_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangString + "已登录");
      return;
    }
    this.jdField_a_of_type_Kgq.jdField_a_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangString + "未登录");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */