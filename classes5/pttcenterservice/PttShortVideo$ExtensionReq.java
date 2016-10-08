package pttcenterservice;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PttShortVideo$ExtensionReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_sub_busi_type", "uint32_user_cnt" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ExtensionReq.class);
  public final PBUInt32Field uint32_sub_busi_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_cnt = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\pttcenterservice\PttShortVideo$ExtensionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */