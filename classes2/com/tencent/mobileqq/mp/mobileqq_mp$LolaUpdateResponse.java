package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class mobileqq_mp$LolaUpdateResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ret_info", "response_item" }, new Object[] { null, null }, LolaUpdateResponse.class);
  public final PBRepeatMessageField response_item = PBField.initRepeatMessage(mobileqq_mp.UpdateResponseItem.class);
  public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\mp\mobileqq_mp$LolaUpdateResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */