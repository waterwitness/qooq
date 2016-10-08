import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.MultiVideoPlayActivity;
import com.tencent.biz.pubaccount.VideoAudioManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class hoq
  implements View.OnClickListener
{
  public hoq(MultiVideoPlayActivity paramMultiVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131296592) || (paramView.getId() == 2131298801))
    {
      if (!VideoVolumeControl.a().a()) {
        break label95;
      }
      this.a.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager.b();
      this.a.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager.a("user_click");
      if (!VideoVolumeControl.a().a()) {
        break label135;
      }
    }
    label95:
    label135:
    for (paramView = "0";; paramView = "1")
    {
      ReportController.b(null, "CliOper", "", "", "0X8006DED", "0X8006DED", 0, 0, paramView, "", "", this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
      return;
      this.a.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager.a();
      paramView = VideoVolumeControl.a();
      if (!VideoVolumeControl.a().a()) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.a(bool, "user_click");
        break;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hoq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */