package com.tencent.mobileqq.bnr;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class BnrReport$BNReportGroupInfo
  extends MessageMicro
{
  public static final int ID_FIELD_NUMBER = 1;
  public static final int SEQNO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "id", "seqno" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, BNReportGroupInfo.class);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBUInt32Field seqno = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\bnr\BnrReport$BNReportGroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */