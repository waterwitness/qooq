import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForHotChat;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class kza
  implements ActionSheet.OnButtonClickListener
{
  public kza(ChatSettingForHotChat paramChatSettingForHotChat, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_ComTencentMobileqqAppHotChatHandler.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.app, "CliOper", "", "", "0X8005D53", "0X8005D53", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2130904920);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在解散");
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat, 2130838442, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.getString(2131368805), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.getTitleBarHeight());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */