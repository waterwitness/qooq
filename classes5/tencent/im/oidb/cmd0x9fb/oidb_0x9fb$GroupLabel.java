package tencent.im.oidb.cmd0x9fb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x9fb$GroupLabel
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "uin_info", "uint32_number_label", "uint32_label_style" }, new Object[] { null, Integer.valueOf(5), Integer.valueOf(0) }, GroupLabel.class);
  public oidb_0x9fb.UinInfo uin_info = new oidb_0x9fb.UinInfo();
  public final PBUInt32Field uint32_label_style = PBField.initUInt32(0);
  public final PBUInt32Field uint32_number_label = PBField.initUInt32(5);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x9fb\oidb_0x9fb$GroupLabel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */