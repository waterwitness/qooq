package tencent.im.cs.smart_device_proxy;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class smart_device_proxy$CgiReq
  extends MessageMicro
{
  public static final int BYTES_COOKIE_FIELD_NUMBER = 3;
  public static final int BYTES_PARAM_FIELD_NUMBER = 2;
  public static final int STR_CGINAME_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_param = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_cgiName = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_cgiName", "bytes_param", "bytes_cookie" }, new Object[] { "", localByteStringMicro1, localByteStringMicro2 }, CgiReq.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\smart_device_proxy\smart_device_proxy$CgiReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */