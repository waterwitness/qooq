import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import com.tencent.mobileqq.troop.widget.MediaControllerX;

public class vnw
  implements View.OnClickListener
{
  public vnw(VideoPlayLogic paramVideoPlayLogic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.c();
    }
    if (this.a.i)
    {
      if (this.a.c()) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Grp_AIO", "", "video", "jump", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "1", "", "");
      }
      while (this.a.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare != null)
      {
        new StructMsgForGeneralShare.GeneralClickHandler(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidViewView, this.a.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare).a(this.a.b);
        return;
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Grp_AIO", "", "video", "jump", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "0", "", "");
      }
      this.a.a(this.a.b);
      return;
    }
    this.a.a(this.a.b);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vnw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */