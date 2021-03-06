package com.tencent.protofile.coupon;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CouponProto$GetCouponsDetailResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "coupons" }, new Object[] { Integer.valueOf(0), null }, GetCouponsDetailResp.class);
  public final PBRepeatMessageField coupons = PBField.initRepeatMessage(CouponProto.Coupon.class);
  public final PBUInt32Field retcode = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\protofile\coupon\CouponProto$GetCouponsDetailResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */