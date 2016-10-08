package msf.registerproxy;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class register_proxy$SvcPbResponsePullDisMsgProxy
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field member_seq = PBField.initUInt64(0L);
  public final PBBytesField msg_content = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "member_seq", "msg_content" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, SvcPbResponsePullDisMsgProxy.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\registerproxy\register_proxy$SvcPbResponsePullDisMsgProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */