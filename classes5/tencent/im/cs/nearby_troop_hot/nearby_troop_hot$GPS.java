package tencent.im.cs.nearby_troop_hot;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearby_troop_hot$GPS
  extends MessageMicro
{
  public static final int LATITUDE_FIELD_NUMBER = 2;
  public static final int LONGTITUDE_FIELD_NUMBER = 1;
  public static final int RANGE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "longtitude", "latitude", "range" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, GPS.class);
  public final PBUInt64Field latitude = PBField.initUInt64(0L);
  public final PBUInt64Field longtitude = PBField.initUInt64(0L);
  public final PBUInt64Field range = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\nearby_troop_hot\nearby_troop_hot$GPS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */