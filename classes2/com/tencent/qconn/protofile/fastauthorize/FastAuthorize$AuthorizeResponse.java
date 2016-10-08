package com.tencent.qconn.protofile.fastauthorize;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FastAuthorize$AuthorizeResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "ret", "msg", "access_token", "expires_in", "openid", "pay_token", "encrytoken", "pf", "pfkey", "encrykey", "md5key", "apk_name" }, new Object[] { "", "", "", Long.valueOf(0L), "", "", "", "", "", "", "", "" }, AuthorizeResponse.class);
  public final PBStringField access_token = PBField.initString("");
  public final PBStringField apk_name = PBField.initString("");
  public final PBStringField encrykey = PBField.initString("");
  public final PBStringField encrytoken = PBField.initString("");
  public final PBInt64Field expires_in = PBField.initInt64(0L);
  public final PBStringField md5key = PBField.initString("");
  public final PBStringField msg = PBField.initString("");
  public final PBStringField openid = PBField.initString("");
  public final PBStringField pay_token = PBField.initString("");
  public final PBStringField pf = PBField.initString("");
  public final PBStringField pfkey = PBField.initString("");
  public final PBStringField ret = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qconn\protofile\fastauthorize\FastAuthorize$AuthorizeResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */