package tencent.im.oidb.qfind;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QFind$DeviceLoc
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "timestamp", "lat", "lon", "gps_type", "uint32_precision" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, DeviceLoc.class);
  public final PBUInt32Field gps_type = PBField.initUInt32(0);
  public final PBUInt32Field lat = PBField.initUInt32(0);
  public final PBUInt32Field lon = PBField.initUInt32(0);
  public final PBUInt32Field timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_precision = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\qfind\QFind$DeviceLoc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */