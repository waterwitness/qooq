package tencent.im.s2c.msgtype0x210.submsgtype0x87;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x87$MsgNotify
  extends MessageMicro
{
  public static final int UINT32_MAX_COUNT_FIELD_NUMBER = 5;
  public static final int UINT32_REQSUBTYPE_FIELD_NUMBER = 4;
  public static final int UINT32_TIME_FIELD_NUMBER = 3;
  public static final int UINT64_FUIN_FIELD_NUMBER = 2;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_uin", "uint64_fuin", "uint32_time", "uint32_reqsubtype", "uint32_max_count" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MsgNotify.class);
  public final PBUInt32Field uint32_max_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reqsubtype = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_fuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x87\SubMsgType0x87$MsgNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */