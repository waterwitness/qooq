package com.tencent.pb.secmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SecMsgComu$SecGroupMsg_GetMsg_Rsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50 }, new String[] { "memberid", "lasttsinrsp_uts", "lasttsinsvr_uts", "msglist", "membercount", "ssid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(0L), "" }, SecGroupMsg_GetMsg_Rsp.class);
  public final PBInt64Field lasttsinrsp_uts = PBField.initInt64(0L);
  public final PBInt64Field lasttsinsvr_uts = PBField.initInt64(0L);
  public final PBInt64Field membercount = PBField.initInt64(0L);
  public final PBInt64Field memberid = PBField.initInt64(0L);
  public final PBRepeatMessageField msglist = PBField.initRepeatMessage(SecMsgComu.SecGroupMsgItemInfo.class);
  public final PBStringField ssid = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\secmsg\SecMsgComu$SecGroupMsg_GetMsg_Rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */