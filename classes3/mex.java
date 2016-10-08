import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.apollo.view.FrameGifView.AnimationListener;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class mex
  implements FrameGifView.AnimationListener
{
  public mex(QQSettingMe paramQQSettingMe, SharedPreferences paramSharedPreferences, int paramInt, Long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.d.setVisibility(0);
    if ((FontSettingManager.a() >= 17.0F) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_AndroidViewViewGroup != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302395).setVisibility(8);
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putLong("apollo_drawer_gif_ts" + this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), System.currentTimeMillis());
    localEditor.putInt("apollo_drawer_gif_times" + this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_Int + 1);
    localEditor.commit();
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "play apollo gif ts =" + this.jdField_a_of_type_JavaLangLong + " and times=" + this.jdField_a_of_type_Int);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */