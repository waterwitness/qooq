package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class VipFontUpdate$TFontMd5CheckRsp$TMd5Ret
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "i32_check_font_id", "i32_check_ret" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, TMd5Ret.class);
  public final PBInt32Field i32_check_font_id = PBField.initInt32(0);
  public final PBInt32Field i32_check_ret = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\vipfontupdate\VipFontUpdate$TFontMd5CheckRsp$TMd5Ret.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */