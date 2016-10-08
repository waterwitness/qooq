package tencent.im.cs.smart_device_proxy;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class smart_device_proxy$RspBody
  extends MessageMicro
{
  public static final int BYTES_INFO_FIELD_NUMBER = 3;
  public static final int INT32_CMD_FIELD_NUMBER = 1;
  public static final int INT32_ERRORCODE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_cmd = PBField.initInt32(0);
  public final PBInt32Field int32_errorCode = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "int32_cmd", "int32_errorCode", "bytes_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, RspBody.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\smart_device_proxy\smart_device_proxy$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */