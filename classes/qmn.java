import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.message.BaseMessageProcessor.RequestBuilder;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgRead;

public class qmn
  implements BaseMessageProcessor.RequestBuilder
{
  public qmn(SystemMessageProcessor paramSystemMessageProcessor, long paramLong1, long paramLong2, structmsg.ReqSystemMsgRead paramReqSystemMsgRead)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageSystemMessageProcessor.a.a("ProfileService.Pb.ReqSystemMsgRead");
    localToServiceMsg.extraData.putLong("latestFriendSeq", this.jdField_a_of_type_Long);
    localToServiceMsg.extraData.putLong("latestGroupSeq", this.b);
    localToServiceMsg.putWupBuffer(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$ReqSystemMsgRead.toByteArray());
    localToServiceMsg.setEnableFastResend(true);
    return localToServiceMsg;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qmn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */