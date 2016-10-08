import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;

public class qmw
  extends SendMessageHandler.SendMessageRunnable
{
  public qmw(UncommonMessageProcessor paramUncommonMessageProcessor, MessageRecord paramMessageRecord, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    UncommonMessageProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageUncommonMessageProcessor, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Long, this.c, this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qmw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */