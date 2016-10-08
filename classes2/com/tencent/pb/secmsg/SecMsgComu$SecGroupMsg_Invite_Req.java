package com.tencent.pb.secmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SecMsgComu$SecGroupMsg_Invite_Req
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "ssid", "topic", "uinlist" }, new Object[] { "", "", Long.valueOf(0L) }, SecGroupMsg_Invite_Req.class);
  public final PBStringField ssid = PBField.initString("");
  public final PBStringField topic = PBField.initString("");
  public final PBRepeatField uinlist = PBField.initRepeat(PBInt64Field.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\secmsg\SecMsgComu$SecGroupMsg_Invite_Req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */