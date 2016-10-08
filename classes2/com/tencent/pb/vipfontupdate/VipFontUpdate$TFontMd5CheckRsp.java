package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class VipFontUpdate$TFontMd5CheckRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_md5_ret" }, new Object[] { null }, TFontMd5CheckRsp.class);
  public final PBRepeatMessageField rpt_md5_ret = PBField.initRepeatMessage(VipFontUpdate.TFontMd5CheckRsp.TMd5Ret.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\vipfontupdate\VipFontUpdate$TFontMd5CheckRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */