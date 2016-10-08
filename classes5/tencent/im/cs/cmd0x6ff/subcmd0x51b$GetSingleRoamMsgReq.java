package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class subcmd0x51b$GetSingleRoamMsgReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 17 }, new String[] { "uint64_puin", "fixed64_last_msg_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, GetSingleRoamMsgReq.class);
  public final PBFixed64Field fixed64_last_msg_id = PBField.initFixed64(0L);
  public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x6ff\subcmd0x51b$GetSingleRoamMsgReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */