package tencent.im.oidb.cmd0x751;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x751$RspCheckIsConfMember
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_check_is_conf_member_result" }, new Object[] { null }, RspCheckIsConfMember.class);
  public final PBRepeatMessageField msg_check_is_conf_member_result = PBField.initRepeatMessage(oidb_0x751.CheckIsConfMemberResult.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x751\oidb_0x751$RspCheckIsConfMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */