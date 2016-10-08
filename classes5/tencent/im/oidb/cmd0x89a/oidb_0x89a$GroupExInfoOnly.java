package tencent.im.oidb.cmd0x89a;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x89a$GroupExInfoOnly
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_tribe_id", "uint32_money_for_add_group" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GroupExInfoOnly.class);
  public final PBUInt32Field uint32_money_for_add_group = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tribe_id = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x89a\oidb_0x89a$GroupExInfoOnly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */