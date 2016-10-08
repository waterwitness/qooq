package tencent.im.oidb.cmd0x8f6;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x8f6$DecreaseUnreadMailCountReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint32_type", "uint32_amount", "rpt_msg_indexes", "msg_recalled_index", "uint32_data_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0) }, DecreaseUnreadMailCountReq.class);
  public oidb_cmd0x8f6.LiteMailIndex msg_recalled_index = new oidb_cmd0x8f6.LiteMailIndex();
  public final PBRepeatMessageField rpt_msg_indexes = PBField.initRepeatMessage(oidb_cmd0x8f6.LiteMailIndex.class);
  public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
  public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8f6\oidb_cmd0x8f6$DecreaseUnreadMailCountReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */