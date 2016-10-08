package com.tencent.pb.secmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class SecMsgComu$SecMsg_EnableSS_Req
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "ssid", "state" }, new Object[] { "", Long.valueOf(0L) }, SecMsg_EnableSS_Req.class);
  public final PBStringField ssid = PBField.initString("");
  public final PBInt64Field state = PBField.initInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\secmsg\SecMsgComu$SecMsg_EnableSS_Req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */