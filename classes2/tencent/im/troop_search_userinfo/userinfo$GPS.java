package tencent.im.troop_search_userinfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class userinfo$GPS
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_lat", "uint32_lon", "int32_alt", "type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GPS.class);
  public final PBInt32Field int32_alt = PBField.initInt32(0);
  public final PBEnumField type = PBField.initEnum(0);
  public final PBUInt32Field uint32_lat = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lon = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\troop_search_userinfo\userinfo$GPS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */