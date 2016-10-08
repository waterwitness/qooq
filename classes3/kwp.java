import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class kwp
  implements Runnable
{
  public kwp(ChatHistoryFileActivity paramChatHistoryFileActivity, String paramString1, String paramString2, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Iterator localIterator = MultiMsgManager.a().a.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if ((localChatMessage instanceof MessageForStructing)) {
        ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.app, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int, ((MessageForStructing)localChatMessage).structingMsg, null);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kwp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */