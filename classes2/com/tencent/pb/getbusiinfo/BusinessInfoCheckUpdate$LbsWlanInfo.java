package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class BusinessInfoCheckUpdate$LbsWlanInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "mac", "ssid", "rssi" }, new Object[] { "", "", Integer.valueOf(0) }, LbsWlanInfo.class);
  public final PBStringField mac = PBField.initString("");
  public final PBInt32Field rssi = PBField.initInt32(0);
  public final PBStringField ssid = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\getbusiinfo\BusinessInfoCheckUpdate$LbsWlanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */