package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x68b$RspTopicList
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90 }, new String[] { "uint32_position", "uint32_fix_position", "rpt_topic_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, RspTopicList.class);
  public final PBRepeatMessageField rpt_topic_list = PBField.initRepeatMessage(oidb_cmd0x68b.TopicInfo.class);
  public final PBUInt32Field uint32_fix_position = PBField.initUInt32(0);
  public final PBUInt32Field uint32_position = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x68b\oidb_cmd0x68b$RspTopicList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */