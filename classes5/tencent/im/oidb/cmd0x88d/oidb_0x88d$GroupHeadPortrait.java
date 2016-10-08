package tencent.im.oidb.cmd0x88d;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x88d$GroupHeadPortrait
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "uint32_pic_cnt", "rpt_msg_info", "uint32_default_id", "uint32_verifying_pic_cnt", "rpt_msg_verifyingpic_info" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), null }, GroupHeadPortrait.class);
  public final PBRepeatMessageField rpt_msg_info = PBField.initRepeatMessage(oidb_0x88d.GroupHeadPortraitInfo.class);
  public final PBRepeatMessageField rpt_msg_verifyingpic_info = PBField.initRepeatMessage(oidb_0x88d.GroupHeadPortraitInfo.class);
  public final PBUInt32Field uint32_default_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_cnt = PBField.initUInt32(0);
  public final PBUInt32Field uint32_verifying_pic_cnt = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x88d\oidb_0x88d$GroupHeadPortrait.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */