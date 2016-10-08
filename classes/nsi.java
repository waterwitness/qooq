import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.VideoItemBuilder;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;

public class nsi
  implements View.OnClickListener
{
  public nsi(VideoItemBuilder paramVideoItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!VideoItemBuilder.a(this.a)) {}
    do
    {
      do
      {
        return;
        AIOUtils.l = true;
      } while ((!VcSystemInfo.e()) || (!VcSystemInfo.f()));
      paramView = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    } while (paramView == null);
    paramView = (MessageForVideo)paramView.a;
    int i = paramView.istroop;
    boolean bool2;
    boolean bool1;
    if (paramView.type == 13)
    {
      bool2 = true;
      if (i == 3000)
      {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_disobj", 0, 0, "", "", "", "");
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if ((paramView.type == 2) || (paramView.type == 24)) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "1", "", "", "");
      }
      if (paramView.type == 0) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "1", "", "", "");
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (paramView.extInt != 10))
      {
        VideoItemBuilder.a(this.a, true, paramView);
        return;
        bool1 = bool2;
        if (i == 1)
        {
          Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
          if (paramView.extInt == 10)
          {
            ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005924", "0X8005924", 0, 0, "", "", "", "");
            bool1 = bool2;
          }
          else
          {
            ReportController.b(null, "dc00899", "Grp_video", "", "notice", "video", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + TroopUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "0", "");
            bool1 = bool2;
          }
        }
      }
      else
      {
        VideoItemBuilder.a(this.a, paramView, bool1, i);
        return;
        bool1 = false;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nsi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */