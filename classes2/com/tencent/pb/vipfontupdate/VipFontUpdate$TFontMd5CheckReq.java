package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class VipFontUpdate$TFontMd5CheckReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_md5_info" }, new Object[] { null }, TFontMd5CheckReq.class);
  public final PBRepeatMessageField rpt_md5_info = PBField.initRepeatMessage(VipFontUpdate.TFontMd5CheckReq.TMd5Info.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\vipfontupdate\VipFontUpdate$TFontMd5CheckReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */