package tencent.im.new_year_2014;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PackServer$QueryPackListResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "from_index", "total_count", "count", "data" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, QueryPackListResp.class);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBRepeatMessageField data = PBField.initRepeatMessage(PackData.Pack.class);
  public final PBUInt32Field from_index = PBField.initUInt32(0);
  public final PBUInt32Field total_count = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\new_year_2014\PackServer$QueryPackListResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */