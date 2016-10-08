package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FrdSysMsg$TongXunLuNickInfo
  extends MessageMicro
{
  public static final int STR_TONGXUNLU_NICKNAME_FIELD_NUMBER = 3;
  public static final int UINT64_FROMUIN_FIELD_NUMBER = 1;
  public static final int UINT64_TOUIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_fromuin", "uint64_touin", "str_tongxunlu_nickname" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "" }, TongXunLuNickInfo.class);
  public final PBStringField str_tongxunlu_nickname = PBField.initString("");
  public final PBUInt64Field uint64_fromuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_touin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\frdsysmsg\FrdSysMsg$TongXunLuNickInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */