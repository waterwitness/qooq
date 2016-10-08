package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class mobileqq_mp$ABTestControlMsgRequest
  extends MessageMicro
{
  public static final int ABTEST_GUANLIZHONGXIN = 2;
  public static final int ABTEST_SUBSCRIBE = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "versionInfo", "testType" }, new Object[] { "", Integer.valueOf(1) }, ABTestControlMsgRequest.class);
  public final PBEnumField testType = PBField.initEnum(1);
  public final PBStringField versionInfo = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\mp\mobileqq_mp$ABTestControlMsgRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */