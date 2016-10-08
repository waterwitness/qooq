package com.tencent.pb.secmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SecMsgComu$SecMsg_GetBaseInfo_Rsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112 }, new String[] { "f_forbid", "f_whiteuser", "f_disable", "dss", "newest_seq", "nowts", "appstate", "groupstate", "f_group_whiteuser", "f_group_forbid", "max_invitation_seq_insvr", "latest_group_active_uts", "f_receive_invite", "min_invitation_seq_insvr" }, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L) }, SecMsg_GetBaseInfo_Rsp.class);
  public final PBInt64Field appstate = PBField.initInt64(0L);
  public final PBRepeatField dss = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBBoolField f_disable = PBField.initBool(false);
  public final PBBoolField f_forbid = PBField.initBool(false);
  public final PBBoolField f_group_forbid = PBField.initBool(false);
  public final PBBoolField f_group_whiteuser = PBField.initBool(false);
  public final PBBoolField f_receive_invite = PBField.initBool(false);
  public final PBBoolField f_whiteuser = PBField.initBool(false);
  public final PBInt64Field groupstate = PBField.initInt64(0L);
  public final PBInt64Field latest_group_active_uts = PBField.initInt64(0L);
  public final PBInt64Field max_invitation_seq_insvr = PBField.initInt64(0L);
  public final PBInt64Field min_invitation_seq_insvr = PBField.initInt64(0L);
  public final PBInt64Field newest_seq = PBField.initInt64(0L);
  public final PBInt64Field nowts = PBField.initInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\secmsg\SecMsgComu$SecMsg_GetBaseInfo_Rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */