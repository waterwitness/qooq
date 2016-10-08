package tencent.im.cs.nearby_troop_hot;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearby_troop_hot$QunItem
  extends MessageMicro
{
  public static final int DESC_FIELD_NUMBER = 3;
  public static final int GPS_FIELD_NUMBER = 4;
  public static final int TITLE_FIELD_NUMBER = 2;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uin", "title", "desc", "gps" }, new Object[] { Long.valueOf(0L), "", "", null }, QunItem.class);
  public final PBStringField desc = PBField.initString("");
  public nearby_troop_hot.GPS gps = new nearby_troop_hot.GPS();
  public final PBStringField title = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\nearby_troop_hot\nearby_troop_hot$QunItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */