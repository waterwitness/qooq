package com.tencent.pb.addcontacts;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AccountSearchPb$hotwordrecord
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "hotword", "hotword_type", "hotword_cover_url", "hotword_title", "hotword_description" }, new Object[] { "", Integer.valueOf(0), "", "", "" }, hotwordrecord.class);
  public final PBStringField hotword = PBField.initString("");
  public final PBStringField hotword_cover_url = PBField.initString("");
  public final PBStringField hotword_description = PBField.initString("");
  public final PBStringField hotword_title = PBField.initString("");
  public final PBUInt32Field hotword_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\addcontacts\AccountSearchPb$hotwordrecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */