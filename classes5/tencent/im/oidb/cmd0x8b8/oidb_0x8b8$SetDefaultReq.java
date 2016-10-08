package tencent.im.oidb.cmd0x8b8;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8b8$SetDefaultReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_default_id" }, new Object[] { Integer.valueOf(0) }, SetDefaultReq.class);
  public final PBUInt32Field uint32_default_id = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8b8\oidb_0x8b8$SetDefaultReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */