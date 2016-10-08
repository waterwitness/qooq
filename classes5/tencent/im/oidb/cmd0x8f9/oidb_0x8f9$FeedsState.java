package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8f9$FeedsState
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_concern_flag", "uint32_readed_flag", "uint32_ignored_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FeedsState.class);
  public final PBUInt32Field uint32_concern_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ignored_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_readed_flag = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8f9\oidb_0x8f9$FeedsState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */