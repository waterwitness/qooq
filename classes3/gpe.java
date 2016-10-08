import android.widget.RelativeLayout;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.HYControlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vipav.VipFullScreenVideoView;

public class gpe
  implements Runnable
{
  public gpe(AVActivity paramAVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.isPlaying()) {
        this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.stopPlayback();
      }
      if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) && (!(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof HYControlUI))) {
        ((DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(false);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.setVisibility(8);
      RelativeLayout localRelativeLayout = (RelativeLayout)this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.getParent();
      if (localRelativeLayout != null) {
        localRelativeLayout.setVisibility(8);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gpe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */