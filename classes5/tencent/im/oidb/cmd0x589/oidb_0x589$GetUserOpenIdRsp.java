package tencent.im.oidb.cmd0x589;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x589$GetUserOpenIdRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_discuss_open_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_open_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_open_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_token = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x589.GetUserOpenIdReq msg_req_id = new oidb_0x589.GetUserOpenIdReq();
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50 }, new String[] { "msg_req_id", "uint32_result", "bytes_open_id", "bytes_group_open_id", "bytes_discuss_open_id", "bytes_token" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, GetUserOpenIdRsp.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x589\oidb_0x589$GetUserOpenIdRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */