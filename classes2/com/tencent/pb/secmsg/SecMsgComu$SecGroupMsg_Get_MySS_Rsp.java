package com.tencent.pb.secmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SecMsgComu$SecGroupMsg_Get_MySS_Rsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "list", "max_group" }, new Object[] { null, Integer.valueOf(0) }, SecGroupMsg_Get_MySS_Rsp.class);
  public final PBRepeatMessageField list = PBField.initRepeatMessage(SecMsgComu.SecGroupGroupInfo.class);
  public final PBInt32Field max_group = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\secmsg\SecMsgComu$SecGroupMsg_Get_MySS_Rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */