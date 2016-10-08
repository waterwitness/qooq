package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$MpIsAdminUinResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "ret_info", "is_mp_admin", "puin" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L) }, MpIsAdminUinResponse.class);
  public final PBInt32Field is_mp_admin = PBField.initInt32(0);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\mp\mobileqq_mp$MpIsAdminUinResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */