package com.tencent.pb.chatbgInfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class chatbgInfo$Bg_Auth_Rst
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "bgId", "result" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, Bg_Auth_Rst.class);
  public final PBInt32Field bgId = PBField.initInt32(0);
  public final PBInt32Field result = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\chatbgInfo\chatbgInfo$Bg_Auth_Rst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */