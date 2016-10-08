package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FrdSysMsg$FriendHelloInfo
  extends MessageMicro
{
  public static final int STR_SOURCE_NAME_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_source_name" }, new Object[] { "" }, FriendHelloInfo.class);
  public final PBStringField str_source_name = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\frdsysmsg\FrdSysMsg$FriendHelloInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */