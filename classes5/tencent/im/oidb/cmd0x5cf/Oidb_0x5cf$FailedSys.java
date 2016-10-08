package tencent.im.oidb.cmd0x5cf;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Oidb_0x5cf$FailedSys
  extends MessageMicro
{
  public static final int STR_MSG_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_msg" }, new Object[] { "" }, FailedSys.class);
  public final PBStringField str_msg = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x5cf\Oidb_0x5cf$FailedSys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */