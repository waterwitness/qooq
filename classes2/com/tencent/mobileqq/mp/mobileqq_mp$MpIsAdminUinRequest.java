package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$MpIsAdminUinRequest
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "versionInfo", "cuin" }, new Object[] { "", Long.valueOf(0L) }, MpIsAdminUinRequest.class);
  public final PBUInt64Field cuin = PBField.initUInt64(0L);
  public final PBStringField versionInfo = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\mp\mobileqq_mp$MpIsAdminUinRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */