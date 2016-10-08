package com.tencent.protofile.sdkauthorize;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SdkAuthorize$AuthorizeRequest
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 50, 58, 66, 72, 82, 90, 98, 106, 114, 122 }, new String[] { "response_type", "client_id", "openapi", "pf", "need_pay", "sign", "sdkv", "sdkp", "time", "qqv", "os", "passData", "skey", "vkey", "sid" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), "", "", "", Long.valueOf(0L), "", "", "", "", "", "" }, AuthorizeRequest.class);
  public final PBInt64Field client_id = PBField.initInt64(0L);
  public final PBSInt32Field need_pay = PBField.initSInt32(0);
  public final PBRepeatField openapi = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBStringField os = PBField.initString("");
  public final PBStringField passData = PBField.initString("");
  public final PBStringField pf = PBField.initString("");
  public final PBStringField qqv = PBField.initString("");
  public final PBStringField response_type = PBField.initString("");
  public final PBStringField sdkp = PBField.initString("");
  public final PBStringField sdkv = PBField.initString("");
  public final PBStringField sid = PBField.initString("");
  public final PBStringField sign = PBField.initString("");
  public final PBStringField skey = PBField.initString("");
  public final PBInt64Field time = PBField.initInt64(0L);
  public final PBStringField vkey = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\protofile\sdkauthorize\SdkAuthorize$AuthorizeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */