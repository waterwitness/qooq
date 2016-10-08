import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;
import mqq.os.MqqHandler;

public class koz
  implements Runnable
{
  public koz(BaseChatPie paramBaseChatPie, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i));
      i -= 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(17, 300L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\koz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */