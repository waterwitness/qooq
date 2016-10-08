package tencent.im.oidb.cmd0x58b;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x58b$GetConfInfoReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint64_conf_uin", "msg_conf_base_info", "msg_conf_mem_info", "uint32_interemark_timestamp" }, new Object[] { Long.valueOf(0L), null, null, Integer.valueOf(0) }, GetConfInfoReq.class);
  public cmd0x58b.ConfBaseInfo msg_conf_base_info = new cmd0x58b.ConfBaseInfo();
  public cmd0x58b.ConfMemberInfo msg_conf_mem_info = new cmd0x58b.ConfMemberInfo();
  public final PBUInt32Field uint32_interemark_timestamp = PBField.initUInt32(0);
  public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x58b\cmd0x58b$GetConfInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */