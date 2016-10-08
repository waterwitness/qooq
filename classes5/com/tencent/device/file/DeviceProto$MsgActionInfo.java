package com.tencent.device.file;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class DeviceProto$MsgActionInfo
  extends MessageMicro
{
  public static final int BYTES_BUFF_WITH_FILE_FIELD_NUMBER = 2;
  public static final int STR_BUSSINESS_NAME_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_buff_with_file = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_bussiness_name = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_bussiness_name", "bytes_buff_with_file" }, new Object[] { "", localByteStringMicro }, MsgActionInfo.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\file\DeviceProto$MsgActionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */