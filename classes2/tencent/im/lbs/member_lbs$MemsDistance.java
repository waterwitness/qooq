package tencent.im.lbs;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class member_lbs$MemsDistance
  extends MessageMicro
{
  public static final int INT64_DISTANCE_FIELD_NUMBER = 2;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "int64_distance" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, MemsDistance.class);
  public final PBInt64Field int64_distance = PBField.initInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\lbs\member_lbs$MemsDistance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */