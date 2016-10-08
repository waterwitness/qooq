import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gzh
  implements QavInOutAnimation.QavOutAnimationListener
{
  public gzh(VideoInviteActivity paramVideoInviteActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(20, false);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(18, false);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(19, false);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(21, false);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(22, false);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(23, false);
    }
  }
  
  public void b()
  {
    this.a.jdField_d_of_type_Boolean = false;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (!this.a.getIntent().getBooleanExtra("isDoubleVideoMeeting", false)) {
        break label113;
      }
      long l = CharacterUtil.a(this.a.jdField_d_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComTencentAvVideoController.b(3, l);
      if (!this.a.g)
      {
        this.a.g = true;
        this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, 2);
      }
      this.a.e = true;
      this.a.finish();
    }
    for (;;)
    {
      this.a.overridePendingTransition(0, 2130968713);
      return;
      label113:
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_d_of_type_JavaLangString, 0);
      this.a.jdField_a_of_type_ComTencentAvVideoController.c(this.a.jdField_d_of_type_JavaLangString, 0);
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */