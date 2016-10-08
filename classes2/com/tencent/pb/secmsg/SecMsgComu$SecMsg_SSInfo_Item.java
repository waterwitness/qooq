package com.tencent.pb.secmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SecMsgComu$SecMsg_SSInfo_Item
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58, 66 }, new String[] { "ssid", "my_suid", "owner_suid", "create_ts", "active_ts", "paper_id", "title", "idmap" }, new Object[] { "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", null }, SecMsg_SSInfo_Item.class);
  public final PBInt64Field active_ts = PBField.initInt64(0L);
  public final PBInt64Field create_ts = PBField.initInt64(0L);
  public final PBRepeatMessageField idmap = PBField.initRepeatMessage(SecMsgComu.SecMsg_IDMap.class);
  public final PBInt64Field my_suid = PBField.initInt64(0L);
  public final PBInt64Field owner_suid = PBField.initInt64(0L);
  public final PBInt64Field paper_id = PBField.initInt64(0L);
  public final PBStringField ssid = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\secmsg\SecMsgComu$SecMsg_SSInfo_Item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */