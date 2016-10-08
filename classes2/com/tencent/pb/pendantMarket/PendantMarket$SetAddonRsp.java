package com.tencent.pb.pendantMarket;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PendantMarket$SetAddonRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int_result", "str_msg", "str_url" }, new Object[] { Integer.valueOf(0), "", "" }, SetAddonRsp.class);
  public final PBUInt32Field int_result = PBField.initUInt32(0);
  public final PBStringField str_msg = PBField.initString("");
  public final PBStringField str_url = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\pendantMarket\PendantMarket$SetAddonRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */