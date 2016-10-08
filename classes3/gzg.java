import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gzg
  implements QavInOutAnimation.QavOutAnimationListener
{
  public gzg(VideoInviteActivity paramVideoInviteActivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(20, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(18, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(19, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(21, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(22, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(23, false);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (!VideoInviteActivity.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity).getBooleanExtra("isDoubleVideoMeeting", false)) {
        break label114;
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.d, 1, true);
      long l = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.d);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvVideoController.b(3, l);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.g = true;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvVideoController.a(l, 1);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.e = true;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.finish();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.overridePendingTransition(0, 2130968713);
      return;
      label114:
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.d, 1, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.d, 0);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.d, 1);
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */