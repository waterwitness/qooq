package com.tencent.pb.chatbgInfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class chatbgInfo$Bg_CheckAuth_Req
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "IdList" }, new Object[] { Integer.valueOf(0) }, Bg_CheckAuth_Req.class);
  public final PBRepeatField IdList = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\chatbgInfo\chatbgInfo$Bg_CheckAuth_Req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */