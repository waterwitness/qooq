import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jumplightalk.CLJumpLightalkConfig;
import com.tencent.mobileqq.jumplightalk.JumpLightalkUtil;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class tzx
  implements ActionSheet.OnButtonClickListener
{
  public tzx(QCallDetailActivity paramQCallDetailActivity, Context paramContext, String paramString, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity) == null) || (paramInt >= QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).length)) {
      return;
    }
    switch (QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity)[paramInt])
    {
    default: 
      return;
    case 1: 
      if (JumpLightalkUtil.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getActivity()))
      {
        JumpLightalkUtil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, "10001", "com.tencent.mobileqq", "", "0", "0");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, "CliOper", "", "", "0X8005AF8", "0X8005AF8", 0, 1, "", "", "", "");
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, "CliOper", "", "", "0X8005AF8", "0X8005AF8", 0, 0, "", "", "", "");
        return;
        JumpLightalkUtil.a(this.jdField_a_of_type_AndroidContentContext, QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).h);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, "CliOper", "", "", "0X8005AF8", "0X8005AF8", 0, 2, "", "", "", "");
      }
    }
    if (QCallDetailActivity.c(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity) == 0)
    {
      long l = MessageCache.a();
      paramView = new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.startActivity(paramView);
      QCallFacade localQCallFacade = QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity);
      if (QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity) == 56938)
      {
        paramView = this.jdField_a_of_type_JavaLangString;
        localQCallFacade.a(paramView, QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity), QCallDetailActivity.d(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity), l, this.jdField_a_of_type_JavaLangString);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, "CliOper", "", "", "0X8005AF9", "0X8005AF9", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity);
      break;
      if ((QCallDetailActivity.c(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity) == 1) || (QCallDetailActivity.c(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity) == 2))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.a, 2);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, "CliOper", "", "", "0X8006406", "0X8006406", 4, 0, "", "", "", "");
      }
      else if (QCallDetailActivity.c(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity) == 5)
      {
        PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, this.jdField_a_of_type_AndroidContentContext, 1, 5);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */