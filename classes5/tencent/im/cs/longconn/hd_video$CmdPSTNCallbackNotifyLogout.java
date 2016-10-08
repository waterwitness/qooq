package tencent.im.cs.longconn;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video$CmdPSTNCallbackNotifyLogout
  extends MessageMicro
{
  public static final int STATUS_DST_NO_ANSWER = 3;
  public static final int STATUS_DST_NO_CONNECT = 5;
  public static final int STATUS_NORMAL = 1;
  public static final int STATUS_SRC_NO_ANSWER = 2;
  public static final int STATUS_SRC_NO_CONNECT = 4;
  public static final int STATUS_UNKNOWN = 0;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_call_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_call_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_call_time = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_call_id", "uint32_call_time", "uint32_call_status" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, CmdPSTNCallbackNotifyLogout.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\longconn\hd_video$CmdPSTNCallbackNotifyLogout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */