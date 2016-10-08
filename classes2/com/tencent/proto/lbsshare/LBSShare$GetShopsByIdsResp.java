package com.tencent.proto.lbsshare;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LBSShare$GetShopsByIdsResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ec", "shops" }, new Object[] { Integer.valueOf(0), null }, GetShopsByIdsResp.class);
  public final PBUInt32Field ec = PBField.initUInt32(0);
  public final PBRepeatMessageField shops = PBField.initRepeatMessage(LBSShare.DPBiz.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\proto\lbsshare\LBSShare$GetShopsByIdsResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */