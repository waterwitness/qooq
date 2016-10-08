package tencent.im.oidb.inner.cmdGroupAdGetAdInfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GetTroopAioTopAD$AdInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58 }, new String[] { "uint32_ad_id", "str_background_url", "str_more_url", "str_pic_url", "uint32_valid_interval", "ad_show_type", "msg_ext_adinfo" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), null }, AdInfo.class);
  public final PBEnumField ad_show_type = PBField.initEnum(0);
  public GetTroopAioTopAD.ExtAdInfo msg_ext_adinfo = new GetTroopAioTopAD.ExtAdInfo();
  public final PBStringField str_background_url = PBField.initString("");
  public final PBStringField str_more_url = PBField.initString("");
  public final PBStringField str_pic_url = PBField.initString("");
  public final PBUInt32Field uint32_ad_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_valid_interval = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\inner\cmdGroupAdGetAdInfo\GetTroopAioTopAD$AdInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */