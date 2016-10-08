import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessagePBElemDecoder;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;

public class upc
  implements Runnable
{
  public upc(MessagePBElemDecoder paramMessagePBElemDecoder, msg_comm.Msg paramMsg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ((PublicAccountHandler)MessagePBElemDecoder.a(this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessagePBElemDecoder).b.a(11)).a(String.valueOf(this.jdField_a_of_type_MsfMsgcommMsg_comm$Msg.msg_head.from_uin.get()), 0L, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\upc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */