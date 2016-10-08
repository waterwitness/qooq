import android.widget.ImageButton;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class gzd
  implements ActionSheet.OnDismissListener
{
  public gzd(VideoInviteActivity paramVideoInviteActivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {}
      for (str = "0X80043A4";; str = "0X80043B6")
      {
        ReportController.b(null, "CliOper", "", "", str, str, 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.d), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.i), "", "");
        if ((this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a != null) && (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetImageButton != null))
        {
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a.setEnabled(true);
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(true);
        }
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {}
    for (String str = "0X80043AA";; str = "0X80043B0") {
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */