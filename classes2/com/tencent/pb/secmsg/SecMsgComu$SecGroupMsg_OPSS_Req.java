package com.tencent.pb.secmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class SecMsgComu$SecGroupMsg_OPSS_Req
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "cmd", "groupinfo", "invitelist" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L) }, SecGroupMsg_OPSS_Req.class);
  public final PBInt64Field cmd = PBField.initInt64(0L);
  public SecMsgComu.SecGroupGroupInfo groupinfo = new SecMsgComu.SecGroupGroupInfo();
  public final PBRepeatField invitelist = PBField.initRepeat(PBInt64Field.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\secmsg\SecMsgComu$SecGroupMsg_OPSS_Req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */