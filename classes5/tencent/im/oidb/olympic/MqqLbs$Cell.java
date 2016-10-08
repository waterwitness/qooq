package tencent.im.oidb.olympic;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class MqqLbs$Cell
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "int32_mcc", "int32_mnc", "int32_lac", "int32_cellid", "int32_rssi" }, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(0) }, Cell.class);
  public final PBInt32Field int32_cellid = PBField.initInt32(-1);
  public final PBInt32Field int32_lac = PBField.initInt32(-1);
  public final PBInt32Field int32_mcc = PBField.initInt32(-1);
  public final PBInt32Field int32_mnc = PBField.initInt32(-1);
  public final PBInt32Field int32_rssi = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\olympic\MqqLbs$Cell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */