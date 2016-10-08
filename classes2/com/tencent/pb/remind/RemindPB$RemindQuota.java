package com.tencent.pb.remind;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class RemindPB$RemindQuota
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_comm_quota", "uint32_svip_quota", "uint32_user_quota", "uint32_used" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RemindQuota.class);
  public final PBUInt32Field uint32_comm_quota = PBField.initUInt32(0);
  public final PBUInt32Field uint32_svip_quota = PBField.initUInt32(0);
  public final PBUInt32Field uint32_used = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_quota = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\remind\RemindPB$RemindQuota.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */