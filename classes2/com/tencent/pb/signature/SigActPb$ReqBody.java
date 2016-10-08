package com.tencent.pb.signature;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SigActPb$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "cmd", "seq", "plf", "req", "auth_req" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, null }, ReqBody.class);
  public SigActPb.SigauthReq auth_req = new SigActPb.SigauthReq();
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public SigActPb.Platform plf = new SigActPb.Platform();
  public SigActPb.SigactReq req = new SigActPb.SigactReq();
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\signature\SigActPb$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */