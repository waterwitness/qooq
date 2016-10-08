package com.tencent.pb.unifiedebug;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class RemoteDebugReportMsg$RemoteLogReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_seq", "str_data" }, new Object[] { "", "" }, RemoteLogReq.class);
  public final PBStringField str_data = PBField.initString("");
  public final PBStringField str_seq = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\unifiedebug\RemoteDebugReportMsg$RemoteLogReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */