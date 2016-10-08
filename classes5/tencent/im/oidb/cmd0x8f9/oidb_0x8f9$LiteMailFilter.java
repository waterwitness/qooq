package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8f9$LiteMailFilter
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_filter_type" }, new Object[] { Integer.valueOf(0) }, LiteMailFilter.class);
  public final PBUInt32Field uint32_filter_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8f9\oidb_0x8f9$LiteMailFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */