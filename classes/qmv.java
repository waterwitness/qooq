import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class qmv
  extends SendMessageHandler.SendMessageRunnable
{
  public qmv(UncommonMessageProcessor paramUncommonMessageProcessor, ToServiceMsg paramToServiceMsg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.setTimeout(this.c);
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.putInt("retryIndex", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.putLong("timeOut", this.c);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageUncommonMessageProcessor.a.c(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qmv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */