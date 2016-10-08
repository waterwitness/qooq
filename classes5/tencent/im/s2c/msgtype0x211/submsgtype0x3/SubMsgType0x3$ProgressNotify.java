package tencent.im.s2c.msgtype0x211.submsgtype0x3;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x3$ProgressNotify
  extends MessageMicro
{
  public static final int BYTES_UUID_FIELD_NUMBER = 2;
  public static final int UINT32_AVERAGE_SPEED_FIELD_NUMBER = 4;
  public static final int UINT32_PROGRESS_FIELD_NUMBER = 3;
  public static final int UINT32_SESSIONID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_average_speed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_progress = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sessionid = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_sessionid", "bytes_uuid", "uint32_progress", "uint32_average_speed" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, ProgressNotify.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x211\submsgtype0x3\SubMsgType0x3$ProgressNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */