package appoint.define;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$RankEvent
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint32_listtype", "uint32_notifytype", "uint32_eventtime", "uint32_seq", "str_notify_tips" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, RankEvent.class);
  public final PBStringField str_notify_tips = PBField.initString("");
  public final PBUInt32Field uint32_eventtime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_listtype = PBField.initUInt32(0);
  public final PBUInt32Field uint32_notifytype = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\appoint\define\appoint_define$RankEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */