package hw.sso;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class hw_sso$HwSSOReq
  extends MessageMicro
{
  public static final int BODY_FIELD_NUMBER = 2;
  public static final int CMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField cmd = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "cmd", "body" }, new Object[] { "", localByteStringMicro }, HwSSOReq.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\hw\sso\hw_sso$HwSSOReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */