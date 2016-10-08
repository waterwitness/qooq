package com.tencent.pb.secmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class SecMsgComu$SecMsg_Msg_Item
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50 }, new String[] { "seq", "type", "from_suid", "ssid", "ts", "content" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", Long.valueOf(0L), "" }, SecMsg_Msg_Item.class);
  public final PBStringField content = PBField.initString("");
  public final PBInt64Field from_suid = PBField.initInt64(0L);
  public final PBInt64Field seq = PBField.initInt64(0L);
  public final PBStringField ssid = PBField.initString("");
  public final PBInt64Field ts = PBField.initInt64(0L);
  public final PBInt64Field type = PBField.initInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\secmsg\SecMsgComu$SecMsg_Msg_Item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */