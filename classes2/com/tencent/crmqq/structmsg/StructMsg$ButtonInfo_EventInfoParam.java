package com.tencent.crmqq.structmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class StructMsg$ButtonInfo_EventInfoParam
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "key", "value" }, new Object[] { "", "" }, ButtonInfo_EventInfoParam.class);
  public final PBStringField key = PBField.initString("");
  public final PBStringField value = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\crmqq\structmsg\StructMsg$ButtonInfo_EventInfoParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */