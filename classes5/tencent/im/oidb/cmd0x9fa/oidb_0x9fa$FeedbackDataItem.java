package tencent.im.oidb.cmd0x9fa;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x9fa$FeedbackDataItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_group_code", "uint64_feedback_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, FeedbackDataItem.class);
  public final PBUInt64Field uint64_feedback_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x9fa\oidb_0x9fa$FeedbackDataItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */