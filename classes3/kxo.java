import android.os.Handler;
import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.List;

public class kxo
  implements ActionSheet.OnButtonClickListener
{
  public kxo(ChatHistoryForC2C paramChatHistoryForC2C, MessageRecord paramMessageRecord, ActionSheet paramActionSheet)
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
      if (ChatHistoryForC2C.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C) == null) {
        ChatHistoryForC2C.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C, new ArrayList());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.b = true;
      ChatHistoryForC2C.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C).add(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      paramView = ChatHistoryForC2C.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C).obtainMessage(1);
      ChatHistoryForC2C.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C).sendMessageDelayed(paramView, 800L);
      Utils.executeAsyncTaskOnThreadPool(new kxp(this), new MessageRecord[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord });
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app, "chat_history", "ChatHistory", "Clk_deleteOne", 1, 0, new String[0]);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */