import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.GAudioMemberListCtrl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class gtq
  implements View.OnClickListener
{
  public gtq(GAudioMemberListCtrl paramGAudioMemberListCtrl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    paramView = (gtr)paramView.getTag();
    if (paramView.c) {
      if (this.a.jdField_a_of_type_Int == 1) {
        ReportController.b(null, "CliOper", "", "", "0X8005C2A", "0X8005C2A", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvVideoController;
      long l = paramView.a;
      if (!paramView.c) {
        bool = true;
      }
      if (localVideoController.a(l, bool)) {}
      return;
      if (this.a.jdField_a_of_type_Int == 2)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005C25", "0X8005C25", 0, 0, "", "", "", "");
        continue;
        if (this.a.jdField_a_of_type_Int == 1) {
          ReportController.b(null, "CliOper", "", "", "0X8005C29", "0X8005C29", 0, 0, "", "", "", "");
        } else if (this.a.jdField_a_of_type_Int == 2) {
          ReportController.b(null, "CliOper", "", "", "0X8005C24", "0X8005C24", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gtq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */