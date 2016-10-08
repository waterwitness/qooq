package com.tencent.pb.unifiedebug;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class RemoteDebugReportMsg$RemoteLogRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "i32_ret" }, new Object[] { Integer.valueOf(0) }, RemoteLogRsp.class);
  public final PBInt32Field i32_ret = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\unifiedebug\RemoteDebugReportMsg$RemoteLogRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */