package tencent.im.oidb.cmd0xa88;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.hotchat.Common.SeatsInfo;

public final class oidb_0xa88$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg_error_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_poid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField rpt_msg_seats_info = PBField.initRepeatMessage(Common.SeatsInfo.class);
  public final PBUInt64Field uint64_groupcode = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_guest_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40 }, new String[] { "bytes_poid", "uint64_guest_uin", "bytes_msg_error_info", "rpt_msg_seats_info", "uint64_groupcode" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, null, Long.valueOf(0L) }, RspBody.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0xa88\oidb_0xa88$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */