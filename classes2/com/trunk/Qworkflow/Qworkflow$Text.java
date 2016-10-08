package com.trunk.Qworkflow;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class Qworkflow$Text
  extends MessageMicro
{
  public static final int CONTENT_SUMMARY = 3;
  public static final int CONTENT_TYPE_LINK = 1;
  public static final int CONTENT_TYPE_NUMBER = 2;
  public static final int CONTENT_TYPE_TEXT = 0;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_type = PBField.initEnum(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "enum_type", "bytes_content", "bytes_userdef" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, Text.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\trunk\Qworkflow\Qworkflow$Text.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */