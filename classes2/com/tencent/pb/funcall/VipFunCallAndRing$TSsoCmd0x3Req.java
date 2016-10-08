package com.tencent.pb.funcall;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class VipFunCallAndRing$TSsoCmd0x3Req
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "i32_funcall_id", "i32_ring_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, TSsoCmd0x3Req.class);
  public final PBInt32Field i32_funcall_id = PBField.initInt32(0);
  public final PBInt32Field i32_ring_id = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\funcall\VipFunCallAndRing$TSsoCmd0x3Req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */