package com.tencent.pb.profilecard;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SummaryCardUpdate$SUpdateRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58 }, new String[] { "cmd", "code", "version", "url", "interv", "buff", "appname" }, new Object[] { Integer.valueOf(3), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "" }, SUpdateRsp.class);
  public final PBStringField appname = PBField.initString("");
  public final PBStringField buff = PBField.initString("");
  public final PBEnumField cmd = PBField.initEnum(3);
  public final PBUInt32Field code = PBField.initUInt32(0);
  public final PBUInt32Field interv = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  public final PBStringField version = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\profilecard\SummaryCardUpdate$SUpdateRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */