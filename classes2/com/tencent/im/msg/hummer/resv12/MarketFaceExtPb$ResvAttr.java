package com.tencent.im.msg.hummer.resv12;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class MarketFaceExtPb$ResvAttr
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_support_size" }, new Object[] { null }, ResvAttr.class);
  public final PBRepeatMessageField rpt_support_size = PBField.initRepeatMessage(MarketFaceExtPb.SupportSize.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\im\msg\hummer\resv12\MarketFaceExtPb$ResvAttr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */