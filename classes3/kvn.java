import android.os.Handler;
import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class kvn
  implements ActionSheet.OnButtonClickListener
{
  public kvn(ChatHistory paramChatHistory, MessageRecord paramMessageRecord, ActionSheet paramActionSheet)
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
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory).obtainMessage(1);
      ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory).sendMessageDelayed(paramView, 800L);
      Utils.executeAsyncTaskOnThreadPool(new kvo(this), new MessageRecord[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kvn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */