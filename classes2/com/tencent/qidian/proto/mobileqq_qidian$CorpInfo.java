package com.tencent.qidian.proto;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$CorpInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64 }, new String[] { "str_corp_short_name", "str_corp_intro", "str_homepage", "str_address", "str_corp_call", "str_postcode", "str_logo", "uint64_master_uin" }, new Object[] { "", "", "", "", "", "", "", Long.valueOf(0L) }, CorpInfo.class);
  public final PBStringField str_address = PBField.initString("");
  public final PBStringField str_corp_call = PBField.initString("");
  public final PBStringField str_corp_intro = PBField.initString("");
  public final PBStringField str_corp_short_name = PBField.initString("");
  public final PBStringField str_homepage = PBField.initString("");
  public final PBStringField str_logo = PBField.initString("");
  public final PBStringField str_postcode = PBField.initString("");
  public final PBUInt64Field uint64_master_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\proto\mobileqq_qidian$CorpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */