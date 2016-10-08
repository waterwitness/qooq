package com.tencent.protofile.discuss;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FlyTicket$DiscussSigDecodeResponse
  extends MessageMicro
{
  public static final int RET_INFO_FIELD_NUMBER = 1;
  public static final int SIG_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ret_info", "sig" }, new Object[] { null, "" }, DiscussSigDecodeResponse.class);
  public FlyTicket.RetInfo ret_info = new FlyTicket.RetInfo();
  public final PBStringField sig = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\protofile\discuss\FlyTicket$DiscussSigDecodeResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */