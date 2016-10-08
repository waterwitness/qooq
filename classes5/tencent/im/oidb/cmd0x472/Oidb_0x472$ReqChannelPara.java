package tencent.im.oidb.cmd0x472;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x472$ReqChannelPara
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_channel_id", "uint32_req_channel_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqChannelPara.class);
  public final PBUInt32Field uint32_req_channel_list = PBField.initUInt32(0);
  public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x472\Oidb_0x472$ReqChannelPara.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */