package com.tencent.protofile.coupon;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CouponProto$MyCouponFavourListResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "retcode", "coupons", "ts" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, MyCouponFavourListResp.class);
  public final PBRepeatMessageField coupons = PBField.initRepeatMessage(CouponProto.Coupon.class);
  public final PBUInt32Field retcode = PBField.initUInt32(0);
  public final PBUInt64Field ts = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\protofile\coupon\CouponProto$MyCouponFavourListResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */