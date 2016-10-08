package tencent.im.oidb.cmd0x406;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x406$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint32_ret", "string_msg", "msg_group_fee_info", "msg_group_fee_list", "msg_member_list" }, new Object[] { Integer.valueOf(0), "", null, null, null }, RspBody.class);
  public cmd0x406.GroupFeeInfoResult msg_group_fee_info = new cmd0x406.GroupFeeInfoResult();
  public cmd0x406.GroupFeeListResult msg_group_fee_list = new cmd0x406.GroupFeeListResult();
  public cmd0x406.GroupFeeMemberListResult msg_member_list = new cmd0x406.GroupFeeMemberListResult();
  public final PBStringField string_msg = PBField.initString("");
  public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x406\cmd0x406$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */