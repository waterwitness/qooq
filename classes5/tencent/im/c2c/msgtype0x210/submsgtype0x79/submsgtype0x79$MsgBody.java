package tencent.im.c2c.msgtype0x210.submsgtype0x79;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x79$MsgBody
  extends MessageMicro
{
  public static final int UINT32_SRC_APP_ID_FIELD_NUMBER = 1;
  public static final int UINT32_UNDEAL_COUNT_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_src_app_id", "uint32_undeal_count" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, MsgBody.class);
  public final PBUInt32Field uint32_src_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_undeal_count = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\c2c\msgtype0x210\submsgtype0x79\submsgtype0x79$MsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */