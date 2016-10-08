import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import msf.msgcomm.msg_comm.Msg;

public final class upf
  implements Runnable
{
  public upf(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a(8)).a(this.jdField_a_of_type_MsfMsgcommMsg_comm$Msg);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\upf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */