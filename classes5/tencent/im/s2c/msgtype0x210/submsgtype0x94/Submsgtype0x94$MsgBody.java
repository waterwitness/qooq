package tencent.im.s2c.msgtype0x210.submsgtype0x94;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Submsgtype0x94$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64, 72, 80, 88, 96, 104, 112 }, new String[] { "uint32_task_id", "uint32_folder_reddot_flag", "uint32_discover_reddot_flag", "uint32_start_ts", "uint32_end_ts", "uint32_period_of_validity", "str_folder_msg", "uint32_discount_reddot_flag", "uint32_nearby_reddot_flag", "uint32_mine_reddot_flag", "uint32_only_discover_reddot_flag", "uint32_only_discount_reddot_flag", "uint32_only_nearby_reddot_flag", "uint32_only_mine_reddot_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MsgBody.class);
  public final PBStringField str_folder_msg = PBField.initString("");
  public final PBUInt32Field uint32_discount_reddot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_discover_reddot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_end_ts = PBField.initUInt32(0);
  public final PBUInt32Field uint32_folder_reddot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mine_reddot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_nearby_reddot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_only_discount_reddot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_only_discover_reddot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_only_mine_reddot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_only_nearby_reddot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_period_of_validity = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start_ts = PBField.initUInt32(0);
  public final PBUInt32Field uint32_task_id = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x94\Submsgtype0x94$MsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */