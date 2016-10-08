package com.tencent.troop;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_activity_info$GroupActInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64 }, new String[] { "act_id", "title", "summary", "url", "small_pic", "big_pic", "start_time", "end_time" }, new Object[] { Long.valueOf(0L), "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, GroupActInfo.class);
  public final PBUInt64Field act_id = PBField.initUInt64(0L);
  public final PBStringField big_pic = PBField.initString("");
  public final PBUInt32Field end_time = PBField.initUInt32(0);
  public final PBStringField small_pic = PBField.initString("");
  public final PBUInt32Field start_time = PBField.initUInt32(0);
  public final PBStringField summary = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBStringField url = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\troop\group_activity_info$GroupActInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */