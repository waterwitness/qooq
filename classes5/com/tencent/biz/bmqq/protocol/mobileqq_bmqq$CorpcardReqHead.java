package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class mobileqq_bmqq$CorpcardReqHead
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "reqHead" }, new Object[] { null }, CorpcardReqHead.class);
  public mobileqq_bmqq.HRTXHead reqHead = new mobileqq_bmqq.HRTXHead();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\bmqq\protocol\mobileqq_bmqq$CorpcardReqHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */