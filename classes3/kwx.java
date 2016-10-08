import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class kwx
  implements ActionSheet.OnButtonClickListener
{
  public kwx(ChatHistoryForC2C paramChatHistoryForC2C, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C, 230);
    localQQCustomDialog.setTitle("温馨提示");
    if (paramInt == 1) {}
    for (paramView = "删除本地的聊天记录和对应的云端聊天记录，无法恢复";; paramView = "删除本地聊天记录，再次进入聊天记录可从云端重新获取聊天记录")
    {
      localQQCustomDialog.setMessage(paramView);
      localQQCustomDialog.setNegativeButton(2131367262, new kwy(this));
      localQQCustomDialog.setPositiveButton(2131367263, new kwz(this, paramInt));
      localQQCustomDialog.show();
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kwx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */