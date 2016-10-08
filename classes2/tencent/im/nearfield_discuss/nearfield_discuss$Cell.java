package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class nearfield_discuss$Cell
  extends MessageMicro
{
  public static final int INT32_CELLID_FIELD_NUMBER = 4;
  public static final int INT32_LAC_FIELD_NUMBER = 3;
  public static final int INT32_MCC_FIELD_NUMBER = 1;
  public static final int INT32_MNC_FIELD_NUMBER = 2;
  public static final int INT32_RSSI_FIELD_NUMBER = 5;
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\nearfield_discuss\nearfield_discuss$Cell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */