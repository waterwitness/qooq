package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearfield_discuss$NotifyList
  extends MessageMicro
{
  public static final int NOTIFY_TYPE_FIELD_NUMBER = 1;
  public static final int RPT_MSG_UPDATE_LIST_FIELD_NUMBER = 2;
  public static final int UINT32_SESSION_ID_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "notify_type", "rpt_msg_update_list", "uint32_session_id" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, NotifyList.class);
  public final PBEnumField notify_type = PBField.initEnum(0);
  public final PBRepeatMessageField rpt_msg_update_list = PBField.initRepeatMessage(nearfield_discuss.UpdateInfo.class);
  public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\nearfield_discuss\nearfield_discuss$NotifyList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */