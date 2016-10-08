package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$ActionInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "actionData", "i_actionData", "a_actionData", "appid" }, new Object[] { "", "", "", Integer.valueOf(0) }, ActionInfo.class);
  public final PBStringField a_actionData = PBField.initString("");
  public final PBStringField actionData = PBField.initString("");
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBStringField i_actionData = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\mp\mobileqq_mp$ActionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */