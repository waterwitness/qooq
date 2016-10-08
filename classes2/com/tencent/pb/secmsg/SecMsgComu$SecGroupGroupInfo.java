package com.tencent.pb.secmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SecMsgComu$SecGroupGroupInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48, 58, 66, 72, 80, 88, 96, 106, 112, 120 }, new String[] { "ssid", "memberid", "nick", "myhead", "founderid", "create_ts", "topic", "background", "receivepush", "membercount", "last_active_uts", "source", "head", "state", "mapsid" }, new Object[] { "", Long.valueOf(0L), "", "", Long.valueOf(0L), Long.valueOf(0L), "", "", Boolean.valueOf(false), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", Long.valueOf(0L), Long.valueOf(0L) }, SecGroupGroupInfo.class);
  public final PBStringField background = PBField.initString("");
  public final PBInt64Field create_ts = PBField.initInt64(0L);
  public final PBInt64Field founderid = PBField.initInt64(0L);
  public final PBStringField head = PBField.initString("");
  public final PBInt64Field last_active_uts = PBField.initInt64(0L);
  public final PBUInt64Field mapsid = PBField.initUInt64(0L);
  public final PBInt64Field membercount = PBField.initInt64(0L);
  public final PBInt64Field memberid = PBField.initInt64(0L);
  public final PBStringField myhead = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBBoolField receivepush = PBField.initBool(false);
  public final PBInt64Field source = PBField.initInt64(0L);
  public final PBStringField ssid = PBField.initString("");
  public final PBInt64Field state = PBField.initInt64(0L);
  public final PBStringField topic = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\secmsg\SecMsgComu$SecGroupGroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */