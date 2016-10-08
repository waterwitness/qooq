package tencent.im.msgrevoke;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msgrevoke_userdef$MsgInfoUserDef$MsgInfoDef
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_msg_seq", "long_msg_id", "long_msg_num", "long_msg_index" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MsgInfoDef.class);
  public final PBUInt32Field long_msg_id = PBField.initUInt32(0);
  public final PBUInt32Field long_msg_index = PBField.initUInt32(0);
  public final PBUInt32Field long_msg_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\msgrevoke\msgrevoke_userdef$MsgInfoUserDef$MsgInfoDef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */