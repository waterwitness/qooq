import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class kpj
  implements ActionSheet.OnButtonClickListener
{
  public kpj(BaseChatPie paramBaseChatPie, ChatMessage paramChatMessage, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop != 3000) {
        break label41;
      }
      FileManagerReporter.a("0X8005E4F");
    }
    for (;;)
    {
      BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      label41:
      FileManagerReporter.a("0X8005E4D");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kpj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */