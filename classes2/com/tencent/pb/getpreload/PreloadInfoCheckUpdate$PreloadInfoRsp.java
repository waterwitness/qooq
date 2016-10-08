package com.tencent.pb.getpreload;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class PreloadInfoCheckUpdate$PreloadInfoRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 48, 56, 66 }, new String[] { "head", "preload_switch", "preload", "interval", "applist", "red_ram", "click_ram", "preload_result" }, new Object[] { null, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), null }, PreloadInfoRsp.class);
  public final PBRepeatField applist = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt32Field click_ram = PBField.initInt32(0);
  public PreloadInfoCheckUpdate.ControlRspHead head = new PreloadInfoCheckUpdate.ControlRspHead();
  public final PBInt32Field interval = PBField.initInt32(0);
  public final PBBoolField preload = PBField.initBool(false);
  public final PBRepeatMessageField preload_result = PBField.initRepeatMessage(PreloadInfoCheckUpdate.PreloadResult.class);
  public final PBInt32Field preload_switch = PBField.initInt32(0);
  public final PBInt32Field red_ram = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\getpreload\PreloadInfoCheckUpdate$PreloadInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */