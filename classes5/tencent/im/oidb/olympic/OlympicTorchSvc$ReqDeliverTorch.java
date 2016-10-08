package tencent.im.oidb.olympic;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class OlympicTorchSvc$ReqDeliverTorch
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public MqqLbs.LBSInfo msg_lbs_info = new MqqLbs.LBSInfo();
  public final PBUInt32Field uint32_user_share = PBField.initUInt32(0);
  public final PBUInt64Field uint64_torch_id = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 82 }, new String[] { "uint64_torch_id", "msg_lbs_info", "uint32_user_share", "bytes_sig" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), localByteStringMicro }, ReqDeliverTorch.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\olympic\OlympicTorchSvc$ReqDeliverTorch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */