package tencent.mobileim.structmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class youtu$NameCardOcrRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field errorcode = PBField.initInt32(0);
  public final PBStringField errormsg = PBField.initString("");
  public final PBBytesField image = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField name = PBField.initString("");
  public final PBFloatField name_confidence = PBField.initFloat(0.0F);
  public final PBStringField phone = PBField.initString("");
  public final PBFloatField phone_confidence = PBField.initFloat(0.0F);
  public final PBStringField session_id = PBField.initString("");
  public final PBStringField uin = PBField.initString("");
  public final PBFloatField uin_confidence = PBField.initFloat(0.0F);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 37, 42, 53, 58, 69, 74, 82 }, new String[] { "errorcode", "errormsg", "uin", "uin_confidence", "phone", "phone_confidence", "name", "name_confidence", "image", "session_id" }, new Object[] { Integer.valueOf(0), "", "", Float.valueOf(0.0F), "", Float.valueOf(0.0F), "", Float.valueOf(0.0F), localByteStringMicro, "" }, NameCardOcrRsp.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\mobileim\structmsg\youtu$NameCardOcrRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */