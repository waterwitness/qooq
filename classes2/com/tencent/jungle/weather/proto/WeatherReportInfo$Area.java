package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WeatherReportInfo$Area
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "area_id", "area_name", "en_name", "city", "province", "country" }, new Object[] { Integer.valueOf(0), "", "", "", "", "" }, Area.class);
  public final PBUInt32Field area_id = PBField.initUInt32(0);
  public final PBStringField area_name = PBField.initString("");
  public final PBStringField city = PBField.initString("");
  public final PBStringField country = PBField.initString("");
  public final PBStringField en_name = PBField.initString("");
  public final PBStringField province = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\jungle\weather\proto\WeatherReportInfo$Area.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */