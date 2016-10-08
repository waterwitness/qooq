package tencent.im.oidb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7cb$TopicConfig
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint32_topic_id", "str_topic_name", "uint32_deadline", "str_err_deadline" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "" }, TopicConfig.class);
  public final PBStringField str_err_deadline = PBField.initString("");
  public final PBStringField str_topic_name = PBField.initString("");
  public final PBUInt32Field uint32_deadline = PBField.initUInt32(0);
  public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x7cb$TopicConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */