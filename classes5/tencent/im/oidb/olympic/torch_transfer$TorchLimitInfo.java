package tencent.im.oidb.olympic;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class torch_transfer$TorchLimitInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_timestamp", "bool_limit" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false) }, TorchLimitInfo.class);
  public final PBBoolField bool_limit = PBField.initBool(false);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\olympic\torch_transfer$TorchLimitInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */