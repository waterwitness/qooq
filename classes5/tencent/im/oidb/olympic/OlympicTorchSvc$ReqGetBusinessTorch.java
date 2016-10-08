package tencent.im.oidb.olympic;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class OlympicTorchSvc$ReqGetBusinessTorch
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_torch_id", "msg_lbs_info", "rpt_city_pic_id_list" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L) }, ReqGetBusinessTorch.class);
  public MqqLbs.LBSInfo msg_lbs_info = new MqqLbs.LBSInfo();
  public final PBRepeatField rpt_city_pic_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uint64_torch_id = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\olympic\OlympicTorchSvc$ReqGetBusinessTorch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */