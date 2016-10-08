package msf.registerproxy;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class register_proxy$SvcRegisterProxyMsgResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField c2c_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField discuss_list = PBField.initRepeatMessage(register_proxy.DiscussList.class);
  public final PBRepeatMessageField discuss_msg = PBField.initRepeatMessage(register_proxy.SvcPbResponsePullDisMsgProxy.class);
  public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field flag = PBField.initUInt32(0);
  public final PBRepeatMessageField gourp_msg = PBField.initRepeatMessage(register_proxy.SvcResponsePbPullGroupMsgProxy.class);
  public final PBRepeatMessageField group_list = PBField.initRepeatMessage(register_proxy.GroupList.class);
  public register_proxy.SvcResponseMsgInfo msg_info = new register_proxy.SvcResponseMsgInfo();
  public final PBBytesField pub_account_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 58, 66, 74, 82, 90 }, new String[] { "result", "err_msg", "flag", "seq", "msg_info", "group_list", "discuss_list", "gourp_msg", "discuss_msg", "c2c_msg", "pub_account_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, localByteStringMicro2, localByteStringMicro3 }, SvcRegisterProxyMsgResp.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\registerproxy\register_proxy$SvcRegisterProxyMsgResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */