package tencent.im.oidb.cmd0x5ba;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x5ba$Reward
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_myreward_totalincome", "uint32_myreward_totalcount", "uint32_is_end", "rpt_rewards" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, Reward.class);
  public final PBRepeatMessageField rpt_rewards = PBField.initRepeatMessage(oidb_0x5ba.RewardItem.class);
  public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
  public final PBUInt32Field uint32_myreward_totalcount = PBField.initUInt32(0);
  public final PBUInt32Field uint32_myreward_totalincome = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x5ba\oidb_0x5ba$Reward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */