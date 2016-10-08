package tencent.im.oidb.olympic;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class torch_transfer$TorchbearerInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66 }, new String[] { "uint64_uin", "uint64_bearer_id", "uint32_transfer_num", "msg_pic_info", "msg_light_city_info", "msg_limit_info", "msg_business_entry_info", "msg_torcher_rank_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, null, null, null, null }, TorchbearerInfo.class);
  public torch_transfer.BusinessEntryInfo msg_business_entry_info = new torch_transfer.BusinessEntryInfo();
  public torch_transfer.LightCityInfo msg_light_city_info = new torch_transfer.LightCityInfo();
  public torch_transfer.TorchLimitInfo msg_limit_info = new torch_transfer.TorchLimitInfo();
  public torch_transfer.TorchPicInfo msg_pic_info = new torch_transfer.TorchPicInfo();
  public torch_transfer.TorcherRankInfo msg_torcher_rank_info = new torch_transfer.TorcherRankInfo();
  public final PBUInt32Field uint32_transfer_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_bearer_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\olympic\torch_transfer$TorchbearerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */