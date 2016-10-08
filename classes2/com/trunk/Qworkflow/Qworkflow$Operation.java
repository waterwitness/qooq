package com.trunk.Qworkflow;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class Qworkflow$Operation
  extends MessageMicro
{
  public static final int LOCAL = 1;
  public static final int URL_BACKGROUND = 3;
  public static final int URL_IN_NEW_WINDOW = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_command = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_operation_act = PBField.initEnum(1);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 26 }, new String[] { "enum_operation_act", "bytes_command" }, new Object[] { Integer.valueOf(1), localByteStringMicro }, Operation.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\trunk\Qworkflow\Qworkflow$Operation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */