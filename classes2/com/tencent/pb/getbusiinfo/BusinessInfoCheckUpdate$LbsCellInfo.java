package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class BusinessInfoCheckUpdate$LbsCellInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "mcc", "mnc", "lac", "cellid", "rssi", "stationLat", "stationLng" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, LbsCellInfo.class);
  public final PBInt32Field cellid = PBField.initInt32(0);
  public final PBInt32Field lac = PBField.initInt32(0);
  public final PBInt32Field mcc = PBField.initInt32(0);
  public final PBInt32Field mnc = PBField.initInt32(0);
  public final PBInt32Field rssi = PBField.initInt32(0);
  public final PBInt32Field stationLat = PBField.initInt32(0);
  public final PBInt32Field stationLng = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\getbusiinfo\BusinessInfoCheckUpdate$LbsCellInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */