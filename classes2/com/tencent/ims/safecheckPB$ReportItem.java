package com.tencent.ims;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class safecheckPB$ReportItem
  extends MessageMicro
{
  public static final int STRING_TARGET_MD5_FIELD_NUMBER = 2;
  public static final int STRING_TARGET_PACKNAME_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "string_target_packname", "string_target_md5" }, new Object[] { "", "" }, ReportItem.class);
  public final PBStringField string_target_md5 = PBField.initString("");
  public final PBStringField string_target_packname = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\ims\safecheckPB$ReportItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */