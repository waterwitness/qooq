import android.view.View;
import android.widget.Toast;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;
import com.tencent.mobileqq.activity.ChatHistory.PlayingPttHistoryInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class kvz
  implements Runnable
{
  kvz(kvy paramkvy, Object paramObject, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_Kvy.jdField_a_of_type_Int == 0) && ((this.jdField_a_of_type_Kvy.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a == null) || (!this.jdField_a_of_type_Kvy.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.a(0, this.jdField_a_of_type_JavaLangObject))))
    {
      Toast.makeText(this.jdField_a_of_type_Kvy.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Kvy.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131368686), 0).show();
      return;
    }
    if (this.jdField_a_of_type_Kvy.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a == null) {
      this.jdField_a_of_type_Kvy.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a = new ChatHistory.PlayingPttHistoryInfo(this.jdField_a_of_type_Kvy.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_ComTencentMobileqqActivityChatHistory);
    }
    this.jdField_a_of_type_Kvy.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.a(0, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Kvy.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kvz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */