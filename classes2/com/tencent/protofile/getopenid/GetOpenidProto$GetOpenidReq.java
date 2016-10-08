package com.tencent.protofile.getopenid;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetOpenidProto$GetOpenidReq
  extends MessageMicro
{
  public static final int APPID_FIELD_NUMBER = 1;
  public static final int LIST_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "appid", "list" }, new Object[] { Long.valueOf(0L), null }, GetOpenidReq.class);
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBRepeatMessageField list = PBField.initRepeatMessage(GetOpenidProto.GetOpenidEntry.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\protofile\getopenid\GetOpenidProto$GetOpenidReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */