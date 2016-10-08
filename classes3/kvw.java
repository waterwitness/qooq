import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;

public class kvw
  implements Runnable
{
  public kvw(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, int paramInt, String paramString, TextView paramTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app, ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a), MsgUtils.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.runOnUiThread(new kvx(this, str));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kvw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */