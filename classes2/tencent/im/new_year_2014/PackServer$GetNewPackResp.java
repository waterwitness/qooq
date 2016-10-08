package tencent.im.new_year_2014;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PackServer$GetNewPackResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "promotion_id", "seq", "data", "empty_url", "follow" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, "", Boolean.valueOf(false) }, GetNewPackResp.class);
  public PackData.Pack data = new PackData.Pack();
  public final PBStringField empty_url = PBField.initString("");
  public final PBBoolField follow = PBField.initBool(false);
  public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\new_year_2014\PackServer$GetNewPackResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */