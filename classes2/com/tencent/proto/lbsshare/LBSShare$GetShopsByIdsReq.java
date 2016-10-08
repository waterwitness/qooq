package com.tencent.proto.lbsshare;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class LBSShare$GetShopsByIdsReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ids" }, new Object[] { "" }, GetShopsByIdsReq.class);
  public final PBRepeatField ids = PBField.initRepeat(PBStringField.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\proto\lbsshare\LBSShare$GetShopsByIdsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */