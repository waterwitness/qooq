import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.MessageSubtitleView;

public class voe
  implements View.OnClickListener
{
  public voe(VideoPlayLogic paramVideoPlayLogic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.a()) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView.setVisibility(0);
        this.a.l = false;
        if (this.a.i) {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Grp_AIO", "", "video", "close_barrage", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "1", "", "");
        }
      }
    }
    while (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView == null) {
      return;
    }
    if (this.a.i) {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Grp_AIO", "", "video", "close_barrage", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "0", "", "");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView.setVisibility(8);
    this.a.l = true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\voe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */