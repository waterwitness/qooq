package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TroopTips0x857$AIOTopTipsInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField opt_bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField opt_bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField opt_bytes_data_a = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField opt_bytes_data_i = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField opt_bytes_data_p = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField opt_bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField opt_enum_action = PBField.initEnum(1);
  public final PBUInt32Field opt_uint32_icon = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 66 }, new String[] { "opt_bytes_content", "opt_uint32_icon", "opt_enum_action", "opt_bytes_url", "opt_bytes_data", "opt_bytes_data_i", "opt_bytes_data_a", "opt_bytes_data_p" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(1), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, AIOTopTipsInfo.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x857\TroopTips0x857$AIOTopTipsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */