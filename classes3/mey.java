import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.qphone.base.util.QLog;

public class mey
  implements Runnable
{
  public mey(QQSettingMe paramQQSettingMe, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, (byte)3);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFaceDrawable, 1, this.jdField_a_of_type_JavaLangString, 100, true, true, 6);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.w();
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSettingRedesign", 4, "updateFace, " + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */