package com.tencent.protofile.getopenid;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetOpenidProto$GetOpenidEntry
  extends MessageMicro
{
  public static final int ID_FIELD_NUMBER = 2;
  public static final int OPENID_FIELD_NUMBER = 3;
  public static final int TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "type", "id", "openid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "" }, GetOpenidEntry.class);
  public final PBUInt64Field id = PBField.initUInt64(0L);
  public final PBStringField openid = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\protofile\getopenid\GetOpenidProto$GetOpenidEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */