package tencent.im.oidb.olympic;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class torch_transfer$CityBackPicInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 58 }, new String[] { "uint32_city_id", "str_city_name", "uint64_city_pic_id", "str_city_pic_url", "str_city_pic_md5", "str_cons_pic_url", "str_cons_pic_md5" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), "", "", "", "" }, CityBackPicInfo.class);
  public final PBStringField str_city_name = PBField.initString("");
  public final PBStringField str_city_pic_md5 = PBField.initString("");
  public final PBStringField str_city_pic_url = PBField.initString("");
  public final PBStringField str_cons_pic_md5 = PBField.initString("");
  public final PBStringField str_cons_pic_url = PBField.initString("");
  public final PBUInt32Field uint32_city_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_city_pic_id = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\olympic\torch_transfer$CityBackPicInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */