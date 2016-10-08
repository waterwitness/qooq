package tencent.im.oidb.cmd0x614;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x614$ReNameDeviceNameReqBody
  extends MessageMicro
{
  public static final int BYTES_APPNAME_FIELD_NUMBER = 4;
  public static final int BYTES_DEVICE_DES_FIELD_NUMBER = 5;
  public static final int BYTES_GUID_FIELD_NUMBER = 1;
  public static final int BYTES_RENAME_DEVICE_NAME_FIELD_NUMBER = 6;
  public static final int UINT32_APPID_FIELD_NUMBER = 2;
  public static final int UINT32_SUBAPPID_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_appname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_device_des = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rename_device_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subappid = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50 }, new String[] { "bytes_guid", "uint32_appid", "uint32_subappid", "bytes_appname", "bytes_device_des", "bytes_rename_device_name" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, ReNameDeviceNameReqBody.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x614\Oidb_0x614$ReNameDeviceNameReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */