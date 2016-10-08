package tencent.im.oidb.cmd0x6b6;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6b6$ThrowFlowerReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int32_count", "uint32_play_rule", "uint32_product_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ThrowFlowerReq.class);
  public final PBInt32Field int32_count = PBField.initInt32(0);
  public final PBUInt32Field uint32_play_rule = PBField.initUInt32(0);
  public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x6b6\oidb_0x6b6$ThrowFlowerReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */