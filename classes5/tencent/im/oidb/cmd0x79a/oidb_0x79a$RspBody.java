package tencent.im.oidb.cmd0x79a;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public final class oidb_0x79a$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 32, 40, 48, 58 }, new String[] { "info", "uint32_tribe_status", "uint64_tribe_id", "uint32_modify_countdown", "str_tribe_name" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "" }, RspBody.class);
  public oidb_0x88d.GroupInfo info = new oidb_0x88d.GroupInfo();
  public final PBStringField str_tribe_name = PBField.initString("");
  public final PBUInt32Field uint32_modify_countdown = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tribe_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_tribe_id = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x79a\oidb_0x79a$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */