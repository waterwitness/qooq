import android.view.View;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class lks
  implements ActionSheet.OnButtonClickListener
{
  lks(lkq paramlkq, VideoActionSheet paramVideoActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUtilsVideoActionSheet.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      FriendProfileCardActivity.a(this.jdField_a_of_type_Lkq.a.app, this.jdField_a_of_type_Lkq.a, this.jdField_a_of_type_Lkq.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
      return;
      if ((this.jdField_a_of_type_Lkq.a.l == 1) || (this.jdField_a_of_type_Lkq.a.l == 2))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_Lkq.a.app, this.jdField_a_of_type_Lkq.a, this.jdField_a_of_type_Lkq.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, 1);
        ReportController.b(this.jdField_a_of_type_Lkq.a.app, "CliOper", "", "", "0X8006406", "0X8006406", 9, 0, "", "", "", "");
        return;
      }
    } while (this.jdField_a_of_type_Lkq.a.l != 5);
    PstnUtils.a(this.jdField_a_of_type_Lkq.a.app, this.jdField_a_of_type_Lkq.a, 1, 7);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */