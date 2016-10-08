package tencent.im.oidb.cmd0x48a;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x48a$ChkBlockRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_block_account_data", "uint32_result" }, new Object[] { null, Integer.valueOf(0) }, ChkBlockRsp.class);
  public oidb_0x48a.OneBlockAccountData msg_block_account_data = new oidb_0x48a.OneBlockAccountData();
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x48a\oidb_0x48a$ChkBlockRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */