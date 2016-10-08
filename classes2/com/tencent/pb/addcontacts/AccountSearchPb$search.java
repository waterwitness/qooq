package com.tencent.pb.addcontacts;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AccountSearchPb$search
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 82, 88, 96, 106, 114, 122 }, new String[] { "start", "count", "end", "keyword", "list", "highlight", "msg_user_location", "bool_location_group", "filtertype", "recommend_list", "hotword_record", "article_more_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", null, "", null, Boolean.valueOf(false), Integer.valueOf(0), null, null, "" }, search.class);
  public final PBStringField article_more_url = PBField.initString("");
  public final PBBoolField bool_location_group = PBField.initBool(false);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBUInt32Field end = PBField.initUInt32(0);
  public final PBInt32Field filtertype = PBField.initInt32(0);
  public final PBRepeatField highlight = PBField.initRepeat(PBStringField.__repeatHelper__);
  public AccountSearchPb.hotwordrecord hotword_record = new AccountSearchPb.hotwordrecord();
  public final PBStringField keyword = PBField.initString("");
  public final PBRepeatMessageField list = PBField.initRepeatMessage(AccountSearchPb.record.class);
  public AccountSearchPb.Location msg_user_location = new AccountSearchPb.Location();
  public final PBRepeatMessageField recommend_list = PBField.initRepeatMessage(AccountSearchPb.record.class);
  public final PBInt32Field start = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\addcontacts\AccountSearchPb$search.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */