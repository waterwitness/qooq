package tencent.im.oidb.cmd0x8f6;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x8f6$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0x8f6.DecreaseUnreadMailCountRsp msg_dec_umc = new oidb_cmd0x8f6.DecreaseUnreadMailCountRsp();
  public oidb_cmd0x8f6.GetUnreadMailCountRsp msg_get_umc = new oidb_cmd0x8f6.GetUnreadMailCountRsp();
  public oidb_cmd0x8f6.IncUnreadMailCountRsp msg_inc_umc = new oidb_cmd0x8f6.IncUnreadMailCountRsp();
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint32_result", "bytes_error_msg", "msg_get_umc", "msg_dec_umc", "msg_inc_umc" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, null }, RspBody.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8f6\oidb_cmd0x8f6$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */