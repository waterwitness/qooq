package tencent.im.oidb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7cb$CommentConfig
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_appoint_subject", "rpt_msg_configs" }, new Object[] { Integer.valueOf(0), null }, CommentConfig.class);
  public final PBRepeatMessageField rpt_msg_configs = PBField.initRepeatMessage(cmd0x7cb.ConfigItem.class);
  public final PBUInt32Field uint32_appoint_subject = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x7cb$CommentConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */