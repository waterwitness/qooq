import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Comparator;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;

public class qmj
  implements Comparator
{
  public qmj(SubAccountMessageProcessor paramSubAccountMessageProcessor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(msg_comm.Msg paramMsg1, msg_comm.Msg paramMsg2)
  {
    return ((msg_comm.MsgHead)paramMsg1.msg_head.get()).msg_time.get() - ((msg_comm.MsgHead)paramMsg2.msg_head.get()).msg_time.get();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qmj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */