import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.atomic.AtomicBoolean;
import msf.msgcomm.msg_comm.Msg;

public class qfa
{
  public long a;
  public AtomicBoolean a;
  public msg_comm.Msg a;
  public long b;
  
  public qfa(msg_comm.Msg paramMsg, long paramLong1, long paramLong2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_MsfMsgcommMsg_comm$Msg = paramMsg;
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */