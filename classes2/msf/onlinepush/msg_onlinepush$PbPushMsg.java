package msf.onlinepush;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import msf.msgcomm.msg_comm.Msg;

public final class msg_onlinepush$PbPushMsg
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg", "svrip" }, new Object[] { null, Integer.valueOf(0) }, PbPushMsg.class);
  public msg_comm.Msg msg = new msg_comm.Msg();
  public final PBInt32Field svrip = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\onlinepush\msg_onlinepush$PbPushMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */