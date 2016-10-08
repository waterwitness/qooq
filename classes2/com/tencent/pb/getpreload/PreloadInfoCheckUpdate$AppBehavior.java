package com.tencent.pb.getpreload;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PreloadInfoCheckUpdate$AppBehavior
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "appid", "click_num", "click_red_num", "red_state" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, AppBehavior.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBInt32Field click_num = PBField.initInt32(0);
  public final PBInt32Field click_red_num = PBField.initInt32(0);
  public final PBInt32Field red_state = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\getpreload\PreloadInfoCheckUpdate$AppBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */