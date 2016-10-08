package appoint.define;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$HotEntry
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_open_flag", "uint32_rest_time", "str_foreword", "str_background_src" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "" }, HotEntry.class);
  public final PBStringField str_background_src = PBField.initString("");
  public final PBStringField str_foreword = PBField.initString("");
  public final PBUInt32Field uint32_open_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rest_time = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\appoint\define\appoint_define$HotEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */