package tencent.im.cs.smart_device_proxy;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class smart_device_proxy$CgiRsp
  extends MessageMicro
{
  public static final int BYTES_RSP_FIELD_NUMBER = 3;
  public static final int INT32_ERRORCODE_FIELD_NUMBER = 1;
  public static final int STR_ERRORMSG_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rsp = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_errorCode = PBField.initInt32(0);
  public final PBStringField str_errorMsg = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_errorCode", "str_errorMsg", "bytes_rsp" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro }, CgiRsp.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\smart_device_proxy\smart_device_proxy$CgiRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */