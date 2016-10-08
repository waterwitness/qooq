package com.tencent.pb.websafe;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WebSafe$CheckURLReq
  extends MessageMicro
{
  public static final int GDT_DATA_FIELD_NUMBER = 2;
  public static final int URL_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "url", "gdt_data" }, new Object[] { "", "" }, CheckURLReq.class);
  public final PBStringField gdt_data = PBField.initString("");
  public final PBStringField url = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\websafe\WebSafe$CheckURLReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */