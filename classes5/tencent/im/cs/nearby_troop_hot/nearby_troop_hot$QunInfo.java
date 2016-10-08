package tencent.im.cs.nearby_troop_hot;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearby_troop_hot$QunInfo
  extends MessageMicro
{
  public static final int CNT_FIELD_NUMBER = 3;
  public static final int DESC_FIELD_NUMBER = 2;
  public static final int TITLE_FIELD_NUMBER = 1;
  public static final int URL_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "title", "desc", "cnt", "url" }, new Object[] { "", "", Integer.valueOf(0), "" }, QunInfo.class);
  public final PBUInt32Field cnt = PBField.initUInt32(0);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBStringField url = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\nearby_troop_hot\nearby_troop_hot$QunInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */