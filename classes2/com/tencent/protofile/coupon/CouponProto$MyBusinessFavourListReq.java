package com.tencent.protofile.coupon;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CouponProto$MyBusinessFavourListReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ts", "stype" }, new Object[] { Long.valueOf(0L), "" }, MyBusinessFavourListReq.class);
  public final PBStringField stype = PBField.initString("");
  public final PBUInt64Field ts = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\protofile\coupon\CouponProto$MyBusinessFavourListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */