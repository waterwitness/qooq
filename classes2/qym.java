import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.camera.QQCameraActivity;
import com.tencent.mobileqq.camera.ui.PreviewSurfaceView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class qym
  implements Animation.AnimationListener
{
  qym(qyk paramqyk)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 4, "[onAnimationEnd] ENTER");
    }
    QQCameraActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).set(4);
    QQCameraActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity, false);
    QQCameraActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 4, "[onAnimationEnd] END");
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 4, "[onAnimationStart] ENTER");
    }
    QQCameraActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).setVisibility(4);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 4, "[onAnimationStart] END");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qym.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */