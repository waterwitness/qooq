package com.tencent.crmqq.structmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class StructMsg$SendMenuEventRequest
  extends MessageMicro
{
  public static final int CLICK = 1;
  public static final int EVENT = 3;
  public static final int URL = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 41, 49 }, new String[] { "uin", "key", "type", "is_need_lbs", "latitude", "longitude" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(1), Boolean.valueOf(false), Double.valueOf(0.0D), Double.valueOf(0.0D) }, SendMenuEventRequest.class);
  public final PBBoolField is_need_lbs = PBField.initBool(false);
  public final PBStringField key = PBField.initString("");
  public final PBDoubleField latitude = PBField.initDouble(0.0D);
  public final PBDoubleField longitude = PBField.initDouble(0.0D);
  public final PBEnumField type = PBField.initEnum(1);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\crmqq\structmsg\StructMsg$SendMenuEventRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */