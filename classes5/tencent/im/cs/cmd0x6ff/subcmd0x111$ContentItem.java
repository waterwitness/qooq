package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x111$ContentItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_filed", "msg_general_buffer" }, new Object[] { Integer.valueOf(0), null }, ContentItem.class);
  public subcmd0x111.GeneralBuffer msg_general_buffer = new subcmd0x111.GeneralBuffer();
  public final PBUInt32Field uint32_filed = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x6ff\subcmd0x111$ContentItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */