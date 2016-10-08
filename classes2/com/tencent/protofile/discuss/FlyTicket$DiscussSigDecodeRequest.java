package com.tencent.protofile.discuss;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FlyTicket$DiscussSigDecodeRequest
  extends MessageMicro
{
  public static final int SIG_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "sig" }, new Object[] { "" }, DiscussSigDecodeRequest.class);
  public final PBStringField sig = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\protofile\discuss\FlyTicket$DiscussSigDecodeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */