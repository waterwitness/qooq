package appoint.define;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$InterestTag
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_tag_type", "rpt_msg_tag_list" }, new Object[] { Integer.valueOf(0), null }, InterestTag.class);
  public final PBRepeatMessageField rpt_msg_tag_list = PBField.initRepeatMessage(appoint_define.InterestItem.class);
  public final PBUInt32Field uint32_tag_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\appoint\define\appoint_define$InterestTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */