import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.ui.QavInOutAnimation;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.ui.VideoInviteFull;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gzm
  extends GAudioUIObserver
{
  public gzm(VideoInviteActivity paramVideoInviteActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "VideoInviteActivity onDestroyInviteUI, relationId:" + paramLong);
    }
    boolean bool = VideoInviteActivity.b(this.a).getBooleanExtra("isDoubleVideoMeeting", false);
    if ((bool) && (this.a.d != null) && (this.a.d.equals(String.valueOf(paramLong))))
    {
      super.c(paramLong);
      TraeHelper.b(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      TraeHelper.a().a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((bool) && (this.a.d.length() > 2) && (paramLong != 0L))
      {
        paramLong = Long.valueOf(this.a.d).longValue();
        if (!this.a.g)
        {
          this.a.g = true;
          if (paramInt != 1) {
            break label228;
          }
          this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 7);
        }
      }
    }
    for (;;)
    {
      this.a.e = true;
      if ((this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation == null) || (!(this.a instanceof VideoInviteFull))) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new gzn(this));
      return;
      label228:
      if (paramInt == 2) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 2);
      }
    }
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */