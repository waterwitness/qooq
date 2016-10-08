package tencent.im.troop.activity;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class troopactivity$GroupInfoCardResp
  extends MessageMicro
{
  public static final int ACTIVITYS_FIELD_NUMBER = 1;
  public static final int BEING_ACT_NUM_FIELD_NUMBER = 2;
  public static final int GROUP_ACT_URL_FIELD_NUMBER = 4;
  public static final int HISTORY_ACT_NUM_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "activitys", "being_act_num", "history_act_num", "group_act_url" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "" }, GroupInfoCardResp.class);
  public final PBRepeatMessageField activitys = PBField.initRepeatMessage(troopactivity.Activity.class);
  public final PBUInt32Field being_act_num = PBField.initUInt32(0);
  public final PBStringField group_act_url = PBField.initString("");
  public final PBUInt32Field history_act_num = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\troop\activity\troopactivity$GroupInfoCardResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */