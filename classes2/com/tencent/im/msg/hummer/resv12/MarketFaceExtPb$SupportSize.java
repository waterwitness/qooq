package com.tencent.im.msg.hummer.resv12;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MarketFaceExtPb$SupportSize
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_width", "uint32_height" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, SupportSize.class);
  public final PBUInt32Field uint32_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_width = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\im\msg\hummer\resv12\MarketFaceExtPb$SupportSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */