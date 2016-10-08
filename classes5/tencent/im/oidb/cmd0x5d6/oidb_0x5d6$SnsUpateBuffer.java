package tencent.im.oidb.cmd0x5d6;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5d6$SnsUpateBuffer
  extends MessageMicro
{
  public static final int RPT_MSG_SNS_UPDATE_ITEM_FIELD_NUMBER = 400;
  public static final int RPT_UIN32_IDLIST_FIELD_NUMBER = 401;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 3202, 3208 }, new String[] { "uint64_uin", "rpt_msg_sns_update_item", "rpt_uin32_idlist" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, SnsUpateBuffer.class);
  public final PBRepeatMessageField rpt_msg_sns_update_item = PBField.initRepeatMessage(oidb_0x5d6.SnsUpdateItem.class);
  public final PBRepeatField rpt_uin32_idlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x5d6\oidb_0x5d6$SnsUpateBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */