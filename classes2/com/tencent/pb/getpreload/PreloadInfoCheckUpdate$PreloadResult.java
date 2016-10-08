package com.tencent.pb.getpreload;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class PreloadInfoCheckUpdate$PreloadResult
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "appid", "preload_switch", "preload", "preload_data", "mem_limit", "ext1" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), "" }, PreloadResult.class);
  public final PBInt32Field appid = PBField.initInt32(0);
  public final PBStringField ext1 = PBField.initString("");
  public final PBInt32Field mem_limit = PBField.initInt32(0);
  public final PBBoolField preload = PBField.initBool(false);
  public final PBBoolField preload_data = PBField.initBool(false);
  public final PBInt32Field preload_switch = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\getpreload\PreloadInfoCheckUpdate$PreloadResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */