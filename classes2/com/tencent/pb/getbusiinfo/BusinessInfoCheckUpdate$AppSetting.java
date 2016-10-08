package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfoCheckUpdate$AppSetting
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "appid", "setting", "modify_ts" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Long.valueOf(0L) }, AppSetting.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBUInt64Field modify_ts = PBField.initUInt64(0L);
  public final PBBoolField setting = PBField.initBool(false);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\getbusiinfo\BusinessInfoCheckUpdate$AppSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */