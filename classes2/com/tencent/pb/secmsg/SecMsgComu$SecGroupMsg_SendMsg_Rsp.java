package com.tencent.pb.secmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class SecMsgComu$SecGroupMsg_SendMsg_Rsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uts" }, new Object[] { Long.valueOf(0L) }, SecGroupMsg_SendMsg_Rsp.class);
  public final PBInt64Field uts = PBField.initInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\secmsg\SecMsgComu$SecGroupMsg_SendMsg_Rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */