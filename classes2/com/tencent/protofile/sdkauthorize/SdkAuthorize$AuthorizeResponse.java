package com.tencent.protofile.sdkauthorize;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SdkAuthorize$AuthorizeResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 74, 82, 90, 96, 106, 114, 122, 130 }, new String[] { "ret", "msg", "access_token", "expires_in", "openid", "pay_token", "encrytoken", "pf", "pfkey", "encrykey", "md5key", "sendinstall", "installwording", "passDataResp", "signQQkey", "md5QQkey" }, new Object[] { Integer.valueOf(0), "", "", Long.valueOf(0L), "", "", "", "", "", "", "", Integer.valueOf(0), "", null, "", "" }, AuthorizeResponse.class);
  public final PBStringField access_token = PBField.initString("");
  public final PBStringField encrykey = PBField.initString("");
  public final PBStringField encrytoken = PBField.initString("");
  public final PBInt64Field expires_in = PBField.initInt64(0L);
  public final PBStringField installwording = PBField.initString("");
  public final PBStringField md5QQkey = PBField.initString("");
  public final PBStringField md5key = PBField.initString("");
  public final PBStringField msg = PBField.initString("");
  public final PBStringField openid = PBField.initString("");
  public final PBRepeatMessageField passDataResp = PBField.initRepeatMessage(SdkAuthorize.PassData.class);
  public final PBStringField pay_token = PBField.initString("");
  public final PBStringField pf = PBField.initString("");
  public final PBStringField pfkey = PBField.initString("");
  public final PBUInt32Field ret = PBField.initUInt32(0);
  public final PBUInt32Field sendinstall = PBField.initUInt32(0);
  public final PBStringField signQQkey = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\protofile\sdkauthorize\SdkAuthorize$AuthorizeResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */