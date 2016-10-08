package com.tencent.pb.getpreload;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PreloadInfoCheckUpdate$ControlReqHead
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 58 }, new String[] { "protocol_ver", "client_plat_id", "client_ver", "os_ver", "uin", "mem", "ext1" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Long.valueOf(0L), Integer.valueOf(0), "" }, ControlReqHead.class);
  public final PBInt32Field client_plat_id = PBField.initInt32(0);
  public final PBStringField client_ver = PBField.initString("");
  public final PBStringField ext1 = PBField.initString("");
  public final PBUInt32Field mem = PBField.initUInt32(0);
  public final PBStringField os_ver = PBField.initString("");
  public final PBInt32Field protocol_ver = PBField.initInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\getpreload\PreloadInfoCheckUpdate$ControlReqHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */