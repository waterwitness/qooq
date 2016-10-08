package tencent.im.oidb.cmd0x74b;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x74b$HeadInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 34, 40, 48, 88 }, new String[] { "uint32_id", "rpt_videoheadlist", "str_photohead", "uint32_timestamp", "uint32_type", "uint32_invalid" }, new Object[] { Integer.valueOf(0), null, "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, HeadInfo.class);
  public final PBRepeatMessageField rpt_videoheadlist = PBField.initRepeatMessage(oidb_0x74b.VideoHeadInfo.class);
  public final PBStringField str_photohead = PBField.initString("");
  public final PBUInt32Field uint32_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_invalid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x74b\oidb_0x74b$HeadInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */