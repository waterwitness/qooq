package tencent.im.cs.nearby_troop_post;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearby_troop_post$ReqNearbyPostInfo
  extends MessageMicro
{
  public static final int UINT64_LATITUDE_FIELD_NUMBER = 2;
  public static final int UINT64_LONGTITUDE_FIELD_NUMBER = 1;
  public static final int UINT64_RANGE_FIELD_NUMBER = 3;
  public static final int UINT64_UIN_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_longtitude", "uint64_latitude", "uint64_range", "uint64_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqNearbyPostInfo.class);
  public final PBUInt32Field uint64_latitude = PBField.initUInt32(0);
  public final PBUInt32Field uint64_longtitude = PBField.initUInt32(0);
  public final PBUInt32Field uint64_range = PBField.initUInt32(0);
  public final PBUInt32Field uint64_uin = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\nearby_troop_post\nearby_troop_post$ReqNearbyPostInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */