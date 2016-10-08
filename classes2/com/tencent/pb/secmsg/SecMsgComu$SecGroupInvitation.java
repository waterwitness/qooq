package com.tencent.pb.secmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class SecMsgComu$SecGroupInvitation
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "seq", "ssid", "topic", "membercount" }, new Object[] { Long.valueOf(0L), "", "", Long.valueOf(0L) }, SecGroupInvitation.class);
  public final PBInt64Field membercount = PBField.initInt64(0L);
  public final PBInt64Field seq = PBField.initInt64(0L);
  public final PBStringField ssid = PBField.initString("");
  public final PBStringField topic = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\secmsg\SecMsgComu$SecGroupInvitation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */