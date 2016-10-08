package tencent.im.oidb.cmd0x8a1;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x8a1$GroupGeoInfo
  extends MessageMicro
{
  public static final int STRING_GEO_CONTENT_FIELD_NUMBER = 4;
  public static final int UINT32_CITY_ID_FIELD_NUMBER = 1;
  public static final int UINT64_LATITUDE_FIELD_NUMBER = 3;
  public static final int UINT64_LONGTITUDE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField string_geo_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_city_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_latitude = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_longtitude = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_city_id", "uint64_longtitude", "uint64_latitude", "string_geo_content" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, GroupGeoInfo.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8a1\cmd0x8a1$GroupGeoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */