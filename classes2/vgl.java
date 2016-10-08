import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter;
import com.tencent.widget.Gallery;

class vgl
  implements Runnable
{
  vgl(vgk paramvgk, Setting paramSetting)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.isFinishing()) {
      return;
    }
    this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.n);
    this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.m, this.jdField_a_of_type_ComTencentMobileqqDataSetting);
    TroopAvatarBigPhotoAdapter localTroopAvatarBigPhotoAdapter = this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter;
    if (!this.jdField_a_of_type_Vgk.jdField_a_of_type_AndroidOsBundle.getBoolean("from_photo_wall", false)) {}
    for (boolean bool = true;; bool = false)
    {
      localTroopAvatarBigPhotoAdapter.a(bool);
      this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.b(this.jdField_a_of_type_Vgk.jdField_a_of_type_AndroidOsBundle.getBoolean("is_use_path", false));
      this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_Int = this.jdField_a_of_type_Vgk.jdField_a_of_type_AndroidOsBundle.getInt("index", -1);
      this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter);
      this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getResources().getDimensionPixelSize(2131492970));
      this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_Int);
      this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new vgm(this));
      this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new vgn(this));
      this.jdField_a_of_type_Vgk.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new vgo(this));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vgl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */