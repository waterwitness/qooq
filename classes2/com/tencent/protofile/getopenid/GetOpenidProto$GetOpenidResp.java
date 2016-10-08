package com.tencent.protofile.getopenid;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GetOpenidProto$GetOpenidResp
  extends MessageMicro
{
  public static final int LIST_FIELD_NUMBER = 2;
  public static final int RETCODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "list" }, new Object[] { Integer.valueOf(0), null }, GetOpenidResp.class);
  public final PBRepeatMessageField list = PBField.initRepeatMessage(GetOpenidProto.GetOpenidEntry.class);
  public final PBUInt32Field retcode = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\protofile\getopenid\GetOpenidProto$GetOpenidResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */