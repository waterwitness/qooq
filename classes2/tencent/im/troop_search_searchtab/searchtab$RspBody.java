package tencent.im.troop_search_searchtab;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class searchtab$RspBody
  extends MessageMicro
{
  public static final int RPT_CARD_FIELD_NUMBER = 1;
  public static final int STR_CITY_ID_FIELD_NUMBER = 4;
  public static final int UINT32_LATITUDE_FIELD_NUMBER = 2;
  public static final int UINT32_LONGITUDE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "rpt_card", "uint32_latitude", "uint32_longitude", "str_city_id" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "" }, RspBody.class);
  public final PBRepeatMessageField rpt_card = PBField.initRepeatMessage(searchtab.Card.class);
  public final PBStringField str_city_id = PBField.initString("");
  public final PBUInt32Field uint32_latitude = PBField.initUInt32(0);
  public final PBUInt32Field uint32_longitude = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\troop_search_searchtab\searchtab$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */