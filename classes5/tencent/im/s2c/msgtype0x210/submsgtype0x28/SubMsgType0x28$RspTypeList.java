package tencent.im.s2c.msgtype0x210.submsgtype0x28;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SubMsgType0x28$RspTypeList
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_typelist" }, new Object[] { null }, RspTypeList.class);
  public final PBRepeatMessageField rpt_msg_typelist = PBField.initRepeatMessage(SubMsgType0x28.TypeList.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x28\SubMsgType0x28$RspTypeList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */