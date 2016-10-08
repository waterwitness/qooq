package com.tencent.pb.profilecard;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SummaryCardBusiEntry$ui
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 3;
  public static final int JUMP_URL_FIELD_NUMBER = 4;
  public static final int TITLE_FIELD_NUMBER = 2;
  public static final int URL_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "url", "title", "content", "jump_url" }, new Object[] { "", "", "", "" }, ui.class);
  public final PBStringField content = PBField.initString("");
  public final PBStringField jump_url = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBStringField url = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\profilecard\SummaryCardBusiEntry$ui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */