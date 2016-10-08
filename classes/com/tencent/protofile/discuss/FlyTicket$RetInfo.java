package com.tencent.protofile.discuss;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FlyTicket$RetInfo
  extends MessageMicro
{
  public static final int ERR_INFO_FIELD_NUMBER = 2;
  public static final int RET_CODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "err_info" }, new Object[] { Integer.valueOf(0), "" }, RetInfo.class);
  public final PBStringField err_info = PBField.initString("");
  public final PBUInt32Field ret_code = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\protofile\discuss\FlyTicket$RetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */