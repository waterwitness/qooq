package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class nearfield_discuss$GPS
  extends MessageMicro
{
  public static final int ETYPE_FIELD_NUMBER = 4;
  public static final int INT32_ALT_FIELD_NUMBER = 3;
  public static final int INT32_LAT_FIELD_NUMBER = 1;
  public static final int INT32_LON_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int32_lat", "int32_lon", "int32_alt", "eType" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), Integer.valueOf(-10000000), Integer.valueOf(0) }, GPS.class);
  public final PBEnumField eType = PBField.initEnum(0);
  public final PBInt32Field int32_alt = PBField.initInt32(-10000000);
  public final PBInt32Field int32_lat = PBField.initInt32(900000000);
  public final PBInt32Field int32_lon = PBField.initInt32(900000000);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\nearfield_discuss\nearfield_discuss$GPS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */