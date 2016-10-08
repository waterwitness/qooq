package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x5e0$UpdateProfileList
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 80 }, new String[] { "uint32_update_profile_id", "uint32_get_content_timestamp", "uint32_friendlist_type", "uint32_need_content", "rpt_uint32_profile_field_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UpdateProfileList.class);
  public final PBRepeatField rpt_uint32_profile_field_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_friendlist_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_get_content_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_content = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_profile_id = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x5e0\Oidb_0x5e0$UpdateProfileList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */