package com.tencent.mobileqq.bnr;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class BnrReport$ExtInfo
  extends MessageMicro
{
  public static final int APP_VER_FIELD_NUMBER = 1;
  public static final int SYS_VER_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "app_ver", "sys_ver" }, new Object[] { "", "" }, ExtInfo.class);
  public final PBStringField app_ver = PBField.initString("");
  public final PBStringField sys_ver = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\bnr\BnrReport$ExtInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */