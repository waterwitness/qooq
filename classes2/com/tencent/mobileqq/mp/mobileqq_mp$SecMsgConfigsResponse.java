package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class mobileqq_mp$SecMsgConfigsResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_ret", "int32_show_in_palist" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, SecMsgConfigsResponse.class);
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public final PBInt32Field int32_show_in_palist = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\mp\mobileqq_mp$SecMsgConfigsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */