import com.tencent.mobileqq.app.message.BaseMessageManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;

public class qkr
  implements Runnable
{
  public qkr(BaseMessageManager paramBaseMessageManager, MixedMsgManager paramMixedMsgManager, MessageRecord paramMessageRecord)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qkr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */