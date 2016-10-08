import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kvf
  implements Runnable
{
  public kvf(ChatHistory paramChatHistory, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ChatHistory localChatHistory1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory;
    ChatHistory localChatHistory2 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory;
    if (this.jdField_a_of_type_Boolean == true) {}
    for (int i = 2131367983;; i = 2131367984)
    {
      localChatHistory1.b(localChatHistory2.getString(i));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kvf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */