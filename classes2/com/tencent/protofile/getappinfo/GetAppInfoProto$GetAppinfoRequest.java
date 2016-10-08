package com.tencent.protofile.getappinfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetAppInfoProto$GetAppinfoRequest
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58 }, new String[] { "client_id", "sdkp", "icons", "qqv", "os", "md5time", "signature" }, new Object[] { Long.valueOf(0L), "", "", "", "", Long.valueOf(0L), "" }, GetAppinfoRequest.class);
  public final PBInt64Field client_id = PBField.initInt64(0L);
  public final PBRepeatField icons = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt64Field md5time = PBField.initInt64(0L);
  public final PBStringField os = PBField.initString("");
  public final PBStringField qqv = PBField.initString("");
  public final PBStringField sdkp = PBField.initString("");
  public final PBStringField signature = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\protofile\getappinfo\GetAppInfoProto$GetAppinfoRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */