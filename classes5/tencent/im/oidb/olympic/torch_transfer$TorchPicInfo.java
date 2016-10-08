package tencent.im.oidb.olympic;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class torch_transfer$TorchPicInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_business_type", "str_torch_pic_url", "str_torch_pic_md5", "rpt_city_pic_list" }, new Object[] { Integer.valueOf(0), "", "", null }, TorchPicInfo.class);
  public final PBRepeatMessageField rpt_city_pic_list = PBField.initRepeatMessage(torch_transfer.CityBackPicInfo.class);
  public final PBStringField str_torch_pic_md5 = PBField.initString("");
  public final PBStringField str_torch_pic_url = PBField.initString("");
  public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\olympic\torch_transfer$TorchPicInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */