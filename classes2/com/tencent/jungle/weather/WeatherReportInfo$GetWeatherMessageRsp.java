package com.tencent.jungle.weather;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WeatherReportInfo$GetWeatherMessageRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "pbRspMsgHead", "cmd", "string_msg", "extra" }, new Object[] { null, Integer.valueOf(0), "", "" }, GetWeatherMessageRsp.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBStringField extra = PBField.initString("");
  public WeatherReportInfo.PbRspMsgHead pbRspMsgHead = new WeatherReportInfo.PbRspMsgHead();
  public final PBStringField string_msg = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\jungle\weather\WeatherReportInfo$GetWeatherMessageRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */