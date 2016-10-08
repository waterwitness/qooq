package tencent.im.troop_search_userinfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class userinfo$Cell
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint32_mcc", "uint32_mnc", "uint32_lac", "uint32_cellid", "int32_rssi" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Cell.class);
  public final PBInt32Field int32_rssi = PBField.initInt32(0);
  public final PBUInt32Field uint32_cellid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lac = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mcc = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mnc = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\troop_search_userinfo\userinfo$Cell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */