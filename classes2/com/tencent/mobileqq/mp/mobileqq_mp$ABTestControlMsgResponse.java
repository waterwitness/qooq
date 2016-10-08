package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class mobileqq_mp$ABTestControlMsgResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "ret_info", "subscribe_newaio_switch", "abtest_switch", "extra_info" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "" }, ABTestControlMsgResponse.class);
  public final PBInt32Field abtest_switch = PBField.initInt32(0);
  public final PBStringField extra_info = PBField.initString("");
  public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  public final PBInt32Field subscribe_newaio_switch = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\mp\mobileqq_mp$ABTestControlMsgResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */