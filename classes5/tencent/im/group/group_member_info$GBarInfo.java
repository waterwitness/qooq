package tencent.im.group;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_member_info$GBarInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_gbar_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_head_portrait = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_gbar_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin_lev = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_gbar_id", "uint32_uin_lev", "str_head_portrait", "bytes_gbar_name" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, GBarInfo.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\group\group_member_info$GBarInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */