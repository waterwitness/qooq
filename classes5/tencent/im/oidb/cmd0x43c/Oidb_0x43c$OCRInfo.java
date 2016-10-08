package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x43c$OCRInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 37, 45, 53 }, new String[] { "name", "uins", "mobiles", "name_dependLevel", "uins_dependLevel", "mobiles_dependLevel" }, new Object[] { "", Long.valueOf(0L), "", Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F) }, OCRInfo.class);
  public final PBRepeatField mobiles = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBFloatField mobiles_dependLevel = PBField.initFloat(0.0F);
  public final PBStringField name = PBField.initString("");
  public final PBFloatField name_dependLevel = PBField.initFloat(0.0F);
  public final PBRepeatField uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBFloatField uins_dependLevel = PBField.initFloat(0.0F);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x43c\Oidb_0x43c$OCRInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */