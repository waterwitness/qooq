package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8f9$GetFeedsByTopReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_req_start", "uint32_req_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetFeedsByTopReq.class);
  public final PBInt32Field int32_req_start = PBField.initInt32(0);
  public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8f9\oidb_0x8f9$GetFeedsByTopReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */