package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x43c$MobileInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42 }, new String[] { "mobile", "isFriend", "bind_uin", "nick_name", "format_mobile" }, new Object[] { "", Boolean.valueOf(false), Long.valueOf(0L), "", "" }, MobileInfo.class);
  public final PBUInt64Field bind_uin = PBField.initUInt64(0L);
  public final PBStringField format_mobile = PBField.initString("");
  public final PBBoolField isFriend = PBField.initBool(false);
  public final PBStringField mobile = PBField.initString("");
  public final PBStringField nick_name = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x43c\Oidb_0x43c$MobileInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */