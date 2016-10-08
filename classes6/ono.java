import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class ono
  implements Runnable
{
  ono(onn paramonn, Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = true;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_Onn.a.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("AvatarPendantActivity decode Avatar, bitmap is null:");
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          break label114;
        }
      }
    }
    for (;;)
    {
      QLog.d("Q.dynamicAvatar", 2, bool);
      return;
      this.jdField_a_of_type_Onn.a.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setFaceDrawable(this.jdField_a_of_type_Onn.a.app, 1, this.jdField_a_of_type_Onn.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, 200, true, true, 7);
      break;
      label114:
      bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ono.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */