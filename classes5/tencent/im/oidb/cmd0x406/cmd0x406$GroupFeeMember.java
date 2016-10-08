package tencent.im.oidb.cmd0x406;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x406$GroupFeeMember
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_uin", "uint64_paid_time", "string_nick_name" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "" }, GroupFeeMember.class);
  public final PBStringField string_nick_name = PBField.initString("");
  public final PBUInt64Field uint64_paid_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x406\cmd0x406$GroupFeeMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */