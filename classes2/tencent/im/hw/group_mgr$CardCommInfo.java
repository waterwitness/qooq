package tencent.im.hw;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_mgr$CardCommInfo
  extends MessageMicro
{
  public static final int CARD_NAME_FIELD_NUMBER = 3;
  public static final int LEVEL_FIELD_NUMBER = 4;
  public static final int NICK_NAME_FIELD_NUMBER = 2;
  public static final int POINT_FIELD_NUMBER = 5;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "uin", "nick_name", "card_name", "level", "point" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0) }, CardCommInfo.class);
  public final PBStringField card_name = PBField.initString("");
  public final PBUInt32Field level = PBField.initUInt32(0);
  public final PBStringField nick_name = PBField.initString("");
  public final PBUInt32Field point = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\hw\group_mgr$CardCommInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */