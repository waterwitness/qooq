package tencent.im.oidb.cmd0x686;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x686$NearbyRankConfig
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_rank_sw", "rpt_msg_title_configs" }, new Object[] { Integer.valueOf(0), null }, NearbyRankConfig.class);
  public final PBRepeatMessageField rpt_msg_title_configs = PBField.initRepeatMessage(Oidb_0x686.RankTitleConfig.class);
  public final PBUInt32Field uint32_rank_sw = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x686\Oidb_0x686$NearbyRankConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */