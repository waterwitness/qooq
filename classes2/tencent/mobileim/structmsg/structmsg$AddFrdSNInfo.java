package tencent.mobileim.structmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class structmsg$AddFrdSNInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_not_see_dynamic", "uint32_set_sn" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, AddFrdSNInfo.class);
  public final PBUInt32Field uint32_not_see_dynamic = PBField.initUInt32(0);
  public final PBUInt32Field uint32_set_sn = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\mobileim\structmsg\structmsg$AddFrdSNInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */