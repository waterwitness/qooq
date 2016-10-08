package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class VipFontUpdate$TFontFreshReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "i32_local_font_id" }, new Object[] { Integer.valueOf(0) }, TFontFreshReq.class);
  public final PBInt32Field i32_local_font_id = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\vipfontupdate\VipFontUpdate$TFontFreshReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */