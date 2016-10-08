package tencent.im.oidb.cmd0x5d6;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x5d6$SnsUpdateItem
  extends MessageMicro
{
  public static final int BYTES_VALUE_FIELD_NUMBER = 2;
  public static final int UINT32_UPDATE_SNS_TYPE_FIELD_NUMBER = 1;
  public static final int UINT32_VALUE_OFFSET_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_update_sns_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_value_offset = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_update_sns_type", "bytes_value", "uint32_value_offset" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, SnsUpdateItem.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x5d6\oidb_0x5d6$SnsUpdateItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */