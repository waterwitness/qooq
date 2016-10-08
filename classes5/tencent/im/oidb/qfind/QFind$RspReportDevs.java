package tencent.im.oidb.qfind;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QFind$RspReportDevs
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 90 }, new String[] { "result", "report_same_dev_interval", "report_any_devs_interval", "report_often_period", "report_often_frequence", "freq_limit_report_any_devs_interval", "force_report_lbs", "force_report_lbs_period", "report_same_lost_devs_interval", "report_max_dev_num", "lost_devs" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, RspReportDevs.class);
  public final PBUInt32Field force_report_lbs = PBField.initUInt32(0);
  public final PBUInt32Field force_report_lbs_period = PBField.initUInt32(0);
  public final PBUInt32Field freq_limit_report_any_devs_interval = PBField.initUInt32(0);
  public final PBRepeatMessageField lost_devs = PBField.initRepeatMessage(QFind.DeviceInfo.class);
  public final PBUInt32Field report_any_devs_interval = PBField.initUInt32(0);
  public final PBUInt32Field report_max_dev_num = PBField.initUInt32(0);
  public final PBUInt32Field report_often_frequence = PBField.initUInt32(0);
  public final PBUInt32Field report_often_period = PBField.initUInt32(0);
  public final PBUInt32Field report_same_dev_interval = PBField.initUInt32(0);
  public final PBUInt32Field report_same_lost_devs_interval = PBField.initUInt32(0);
  public final PBInt32Field result = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\qfind\QFind$RspReportDevs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */