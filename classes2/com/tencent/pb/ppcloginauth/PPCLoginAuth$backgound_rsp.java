package com.tencent.pb.ppcloginauth;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class PPCLoginAuth$backgound_rsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ret" }, new Object[] { Integer.valueOf(0) }, backgound_rsp.class);
  public final PBRepeatField ret = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\ppcloginauth\PPCLoginAuth$backgound_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */