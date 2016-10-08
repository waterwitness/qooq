package tencent.im.cs.huangye.citypages;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class citypages$ReqGetNeighborBusiness
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 56 }, new String[] { "city_id", "sub_cat_id", "geo", "keyword", "offset", "count", "sub_cat_ids" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqGetNeighborBusiness.class);
  public final PBUInt32Field city_id = PBField.initUInt32(0);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public citypages.GeoInfo geo = new citypages.GeoInfo();
  public final PBStringField keyword = PBField.initString("");
  public final PBUInt32Field offset = PBField.initUInt32(0);
  public final PBUInt32Field sub_cat_id = PBField.initUInt32(0);
  public final PBRepeatField sub_cat_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\huangye\citypages\citypages$ReqGetNeighborBusiness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */