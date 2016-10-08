import android.widget.ToggleButton;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.view.ProfileLabelCallBack;
import com.tencent.mobileqq.profile.view.ProfileLabelPanel.LabelStatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

public class may
  implements ProfileLabelCallBack
{
  public may(ProfileLabelEditorActivity paramProfileLabelEditorActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ProfileLabelInfo paramProfileLabelInfo, ToggleButton paramToggleButton, Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      if ((this.a.a(paramProfileLabelInfo.labelId, this.a.jdField_a_of_type_JavaUtilList)) || (this.a.a(this.a.jdField_a_of_type_JavaUtilList)))
      {
        if (this.a.a(this.a.jdField_a_of_type_JavaUtilList)) {
          this.a.b(2131370035);
        }
        return;
      }
      ReportController.b(this.a.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "1", "", "", "");
      this.a.jdField_a_of_type_JavaUtilList.add(paramProfileLabelInfo);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager.c(paramProfileLabelInfo, paramToggleButton);
      this.a.a(this.a.jdField_a_of_type_JavaUtilList.size());
      if (this.a.jdField_a_of_type_Mbc == null) {
        break;
      }
      this.a.jdField_a_of_type_Mbc.notifyDataSetChanged();
      return;
      if (!this.a.a(paramProfileLabelInfo.labelId, this.a.jdField_a_of_type_JavaUtilList)) {
        break;
      }
      this.a.a(paramProfileLabelInfo, this.a.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\may.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */