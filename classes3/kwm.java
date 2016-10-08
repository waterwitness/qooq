import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;
import mqq.os.MqqHandler;

public class kwm
  implements Runnable
{
  public kwm(ChatHistoryFileActivity paramChatHistoryFileActivity, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.app.a().a((MessageRecord)this.jdField_a_of_type_JavaUtilList.get(0), false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a.sendEmptyMessage(2);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.app.a().a(this.jdField_a_of_type_JavaUtilList, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kwm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */