package tencent.im.lbs;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class member_lbs$NeighbourNumber
  extends MessageMicro
{
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
  public static final int UINT64_LOCATED_NUMBER_FIELD_NUMBER = 3;
  public static final int UINT64_NEIGHBOUR_NUMBER_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_group_code", "uint64_neighbour_number", "uint64_located_number" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, NeighbourNumber.class);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_located_number = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_neighbour_number = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\lbs\member_lbs$NeighbourNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */