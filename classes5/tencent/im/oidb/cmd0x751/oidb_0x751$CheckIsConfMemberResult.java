package tencent.im.oidb.cmd0x751;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x751$CheckIsConfMemberResult
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_conf_uin", "uint32_is_conf_member" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, CheckIsConfMemberResult.class);
  public final PBUInt32Field uint32_is_conf_member = PBField.initUInt32(0);
  public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x751\oidb_0x751$CheckIsConfMemberResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */