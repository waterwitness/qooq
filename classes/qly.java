import IMMsgBodyPack.MsgType0x210;
import com.tencent.av.service.QavWrapper;
import com.tencent.av.service.QavWrapper.OnReadyListener;
import com.tencent.mobileqq.app.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qly
  implements QavWrapper.OnReadyListener
{
  public qly(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(QavWrapper paramQavWrapper)
  {
    paramQavWrapper.c(this.jdField_a_of_type_IMMsgBodyPackMsgType0x210.vProtobuf);
    paramQavWrapper.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */