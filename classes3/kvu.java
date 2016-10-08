import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class kvu
  implements Runnable
{
  public kvu(ChatHistory paramChatHistory, boolean paramBoolean, int paramInt)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    StringBuilder localStringBuilder = null;
    if (this.jdField_a_of_type_Boolean) {
      localStringBuilder = new StringBuilder();
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.d, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Int, localStringBuilder);
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(this.jdField_a_of_type_Int);
    if ((localStringBuilder != null) && (localStringBuilder.length() > 0)) {
      localMessage.obj = localStringBuilder.toString();
    }
    localMessage.arg1 = i;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kvu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */