package tencent.im.oidb.cmd0x66b;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x66b$RspPansocialInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 482408, 482416, 482424, 482432 }, new String[] { "uint32_charm", "uint32_charmlevel", "uint32_charmlevelvalue", "uint32_nextcharmlevelvalue" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspPansocialInfo.class);
  public final PBUInt32Field uint32_charm = PBField.initUInt32(0);
  public final PBUInt32Field uint32_charmlevel = PBField.initUInt32(0);
  public final PBUInt32Field uint32_charmlevelvalue = PBField.initUInt32(0);
  public final PBUInt32Field uint32_nextcharmlevelvalue = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x66b\Oidb_0x66b$RspPansocialInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */