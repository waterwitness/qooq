package com.tencent.pb.secmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class SecMsgComu$SecMsg_CreateSS_Req
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "touin", "paper_id", "title" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "" }, SecMsg_CreateSS_Req.class);
  public final PBInt64Field paper_id = PBField.initInt64(0L);
  public final PBStringField title = PBField.initString("");
  public final PBInt64Field touin = PBField.initInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\secmsg\SecMsgComu$SecMsg_CreateSS_Req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */