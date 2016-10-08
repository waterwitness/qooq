package com.tencent.qwallet;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CodeGenerate$CodeGenerateRes
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "retcode", "retmsg", "uin", "cn", "token", "token_md5", "pay_type", "valid_end", "random", "pay_desc", "code_prefix", "forbid_watch" }, new Object[] { "", "", "", "", "", "", "", "", "", "", "", "" }, CodeGenerateRes.class);
  public final PBStringField cn = PBField.initString("");
  public final PBStringField code_prefix = PBField.initString("");
  public final PBStringField forbid_watch = PBField.initString("");
  public final PBStringField pay_desc = PBField.initString("");
  public final PBStringField pay_type = PBField.initString("");
  public final PBStringField random = PBField.initString("");
  public final PBStringField retcode = PBField.initString("");
  public final PBStringField retmsg = PBField.initString("");
  public final PBStringField token = PBField.initString("");
  public final PBStringField token_md5 = PBField.initString("");
  public final PBStringField uin = PBField.initString("");
  public final PBStringField valid_end = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qwallet\CodeGenerate$CodeGenerateRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */