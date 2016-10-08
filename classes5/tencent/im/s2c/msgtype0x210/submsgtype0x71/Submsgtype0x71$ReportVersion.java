package tencent.im.s2c.msgtype0x210.submsgtype0x71;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Submsgtype0x71$ReportVersion
  extends MessageMicro
{
  public static final int BOOL_ALLVER_FIELD_NUMBER = 2;
  public static final int INT32_PLANT_ID_FIELD_NUMBER = 1;
  public static final int RPT_STR_VERSION_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "int32_plant_id", "bool_allver", "rpt_str_version" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), "" }, ReportVersion.class);
  public final PBBoolField bool_allver = PBField.initBool(false);
  public final PBInt32Field int32_plant_id = PBField.initInt32(0);
  public final PBRepeatField rpt_str_version = PBField.initRepeat(PBStringField.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x71\Submsgtype0x71$ReportVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */