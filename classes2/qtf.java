import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class qtf
  implements Runnable
{
  public qtf(SelectCoverActivity paramSelectCoverActivity, Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
        } while (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_b_of_type_Boolean);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_b_of_type_JavaLangString))
        {
          SelectCoverActivity.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity, 2, "处理失败，请重试", 0);
          return;
        }
        SelectCoverActivity.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity, 0, "正在上传", 0);
        if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.m != 1) {
          break;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a == null) || (!new File(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a).exists()) || (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.jdField_b_of_type_JavaLangString == null) || (!new File(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.jdField_b_of_type_JavaLangString).exists()));
      SelectCoverActivity.b(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.m != 2);
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.getIntent();
    localIntent.putExtra("key_photo_file_path", this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("key_video_duration", this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.o);
    localIntent.putExtra("key_video_has_voice", this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.c);
    localIntent.putExtra("key_camera_id", this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.d);
    localIntent.putExtra("key_photo_selected_by_user", this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qtf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */