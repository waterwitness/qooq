package tencent.im.cs.huangye.citypages;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class citypages$CityPagesInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 88, 98 }, new String[] { "id", "name", "tels", "site", "addr", "geo", "slogan", "logo", "background", "distance", "sub_cat_id", "topic" }, new Object[] { "", "", null, "", "", null, "", "", "", "", Integer.valueOf(0), "" }, CityPagesInfo.class);
  public final PBStringField addr = PBField.initString("");
  public final PBStringField background = PBField.initString("");
  public final PBStringField distance = PBField.initString("");
  public citypages.GeoInfo geo = new citypages.GeoInfo();
  public final PBStringField id = PBField.initString("");
  public final PBStringField logo = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField site = PBField.initString("");
  public final PBStringField slogan = PBField.initString("");
  public final PBUInt32Field sub_cat_id = PBField.initUInt32(0);
  public final PBRepeatMessageField tels = PBField.initRepeatMessage(citypages.TelInfo.class);
  public final PBStringField topic = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\huangye\citypages\citypages$CityPagesInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */