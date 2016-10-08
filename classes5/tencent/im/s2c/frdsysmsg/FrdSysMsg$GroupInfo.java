package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FrdSysMsg$GroupInfo
  extends MessageMicro
{
  public static final int STR_GROUP_NAME_FIELD_NUMBER = 2;
  public static final int STR_GROUP_NICK_FIELD_NUMBER = 3;
  public static final int UINT64_GROUP_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_group_uin", "str_group_name", "str_group_nick" }, new Object[] { Long.valueOf(0L), "", "" }, GroupInfo.class);
  public final PBStringField str_group_name = PBField.initString("");
  public final PBStringField str_group_nick = PBField.initString("");
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\frdsysmsg\FrdSysMsg$GroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */