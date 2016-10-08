import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class nla
  implements ActionSheet.OnButtonClickListener
{
  nla(nkz paramnkz, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_Nkz.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000);
    try
    {
      long l = Long.valueOf(this.jdField_a_of_type_Nkz.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
      paramView = (BizTroopHandler)this.jdField_a_of_type_Nkz.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
      if (paramView != null) {
        paramView.b(l);
      }
      ReportController.b(this.jdField_a_of_type_Nkz.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_discuss", "", "grey", "Clk", 0, 0, "", String.valueOf(this.jdField_a_of_type_Nkz.jdField_a_of_type_Int), "", "");
      return;
    }
    catch (NumberFormatException paramView) {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nla.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */