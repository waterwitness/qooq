import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoAudioManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class iah
  implements View.OnClickListener
{
  public iah(VideoPlayManager paramVideoPlayManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131296592)
    {
      if (!VideoVolumeControl.a().a()) {
        break label84;
      }
      VideoPlayManager.a(this.a).b();
      VideoPlayManager.a(this.a).a("user_click");
      if (!VideoVolumeControl.a().a()) {
        break label124;
      }
    }
    label84:
    label124:
    for (paramView = "0";; paramView = "1")
    {
      ReportController.b(null, "CliOper", "", "", "0X8006DED", "0X8006DED", 0, 0, paramView, "", "", VideoPlayManager.a(this.a).a);
      return;
      VideoPlayManager.a(this.a).a();
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


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */