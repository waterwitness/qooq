package tencent.im.cs.huangye.citypages;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class citypages$ReqGetCityPagesByBusinessId
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "city_id", "shop_id" }, new Object[] { Integer.valueOf(0), "" }, ReqGetCityPagesByBusinessId.class);
  public final PBUInt32Field city_id = PBField.initUInt32(0);
  public final PBStringField shop_id = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\huangye\citypages\citypages$ReqGetCityPagesByBusinessId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */