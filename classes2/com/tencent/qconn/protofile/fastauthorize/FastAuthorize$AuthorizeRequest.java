package com.tencent.qconn.protofile.fastauthorize;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FastAuthorize$AuthorizeRequest
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 42, 50, 58, 66, 74, 80, 90, 98, 106 }, new String[] { "uin", "client_id", "pf", "qqv", "sdkp", "skey", "vkey", "version", "flags", "os", "sid", "apk_sign" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", "", "", "", "", "1.0", Integer.valueOf(0), "", "", "" }, AuthorizeRequest.class);
  public final PBStringField apk_sign = PBField.initString("");
  public final PBInt64Field client_id = PBField.initInt64(0L);
  public final PBInt32Field flags = PBField.initInt32(0);
  public final PBStringField os = PBField.initString("");
  public final PBStringField pf = PBField.initString("");
  public final PBStringField qqv = PBField.initString("");
  public final PBStringField sdkp = PBField.initString("");
  public final PBStringField sid = PBField.initString("");
  public final PBStringField skey = PBField.initString("");
  public final PBInt64Field uin = PBField.initInt64(0L);
  public final PBStringField version = PBField.initString("1.0");
  public final PBStringField vkey = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qconn\protofile\fastauthorize\FastAuthorize$AuthorizeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */