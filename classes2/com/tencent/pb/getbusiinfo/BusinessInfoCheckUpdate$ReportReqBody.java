package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfoCheckUpdate$ReportReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58, 66, 72, 80 }, new String[] { "uin", "platid", "clientver", "platver", "appid", "missionid", "buffer", "reportdata", "msgids", "cmd" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", null, Long.valueOf(0L), Integer.valueOf(0) }, ReportReqBody.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBStringField buffer = PBField.initString("");
  public final PBStringField clientver = PBField.initString("");
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBRepeatField missionid = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField msgids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field platid = PBField.initUInt32(0);
  public final PBStringField platver = PBField.initString("");
  public final PBRepeatMessageField reportdata = PBField.initRepeatMessage(BusinessInfoCheckUpdate.ReportStaticsData.class);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\getbusiinfo\BusinessInfoCheckUpdate$ReportReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */