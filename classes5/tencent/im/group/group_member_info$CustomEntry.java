package tencent.im.group;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_member_info$CustomEntry
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_clicked = PBField.initBool(false);
  public final PBBytesField str_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_value = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_report_id = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "str_name", "str_value", "bool_clicked", "str_url", "uint64_report_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Boolean.valueOf(false), localByteStringMicro3, Long.valueOf(0L) }, CustomEntry.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\group\group_member_info$CustomEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */