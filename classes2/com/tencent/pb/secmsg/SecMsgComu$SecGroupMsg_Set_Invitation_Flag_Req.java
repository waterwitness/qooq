package com.tencent.pb.secmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class SecMsgComu$SecGroupMsg_Set_Invitation_Flag_Req
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "flag" }, new Object[] { Boolean.valueOf(false) }, SecGroupMsg_Set_Invitation_Flag_Req.class);
  public final PBBoolField flag = PBField.initBool(false);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\secmsg\SecMsgComu$SecGroupMsg_Set_Invitation_Flag_Req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */