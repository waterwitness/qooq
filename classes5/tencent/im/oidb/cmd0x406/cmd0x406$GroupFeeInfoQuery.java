package tencent.im.oidb.cmd0x406;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x406$GroupFeeInfoQuery
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "string_project_id", "uint32_group_fee_type", "msg_group_fee_opt" }, new Object[] { "", Integer.valueOf(0), null }, GroupFeeInfoQuery.class);
  public cmd0x406.GroupFee msg_group_fee_opt = new cmd0x406.GroupFee();
  public final PBStringField string_project_id = PBField.initString("");
  public final PBUInt32Field uint32_group_fee_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x406\cmd0x406$GroupFeeInfoQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */