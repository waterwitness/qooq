package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FrdSysMsg$FriendMiscInfo
  extends MessageMicro
{
  public static final int STR_FROMUIN_NICK_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_fromuin_nick" }, new Object[] { "" }, FriendMiscInfo.class);
  public final PBStringField str_fromuin_nick = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\frdsysmsg\FrdSysMsg$FriendMiscInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */