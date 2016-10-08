package tencent.im.oidb.qfind;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QFind$ReqReportDevs
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "dev_infos", "dev_loc" }, new Object[] { null, null }, ReqReportDevs.class);
  public final PBRepeatMessageField dev_infos = PBField.initRepeatMessage(QFind.DeviceInfo.class);
  public QFind.DeviceLoc dev_loc = new QFind.DeviceLoc();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\qfind\QFind$ReqReportDevs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */