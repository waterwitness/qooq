import com.tencent.mobileqq.app.message.BaseMessageManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;

public class qkq
  implements Runnable
{
  public qkq(BaseMessageManager paramBaseMessageManager, LongTextMsgManager paramLongTextMsgManager, MessageRecord paramMessageRecord)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgLongTextMsgManager.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qkq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */