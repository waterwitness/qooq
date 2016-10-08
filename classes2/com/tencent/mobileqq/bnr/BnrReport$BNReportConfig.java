package com.tencent.mobileqq.bnr;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class BnrReport$BNReportConfig
  extends MessageMicro
{
  public static final int DICLIST_FIELD_NUMBER = 3;
  public static final int IDLIST_FIELD_NUMBER = 4;
  public static final int ID_FIELD_NUMBER = 1;
  public static final int SEQNO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "id", "seqno", "dicList", "idList" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, BNReportConfig.class);
  public final PBRepeatField dicList = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBRepeatField idList = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field seqno = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\bnr\BnrReport$BNReportConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */