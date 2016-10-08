package com.tencent.pb.funcall;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class VipFunCallAndRing$TSourceInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "str_media_url", "str_image_url", "str_ring_url", "str_thumb_url", "str_fc_name" }, new Object[] { "", "", "", "", "" }, TSourceInfo.class);
  public final PBStringField str_fc_name = PBField.initString("");
  public final PBStringField str_image_url = PBField.initString("");
  public final PBStringField str_media_url = PBField.initString("");
  public final PBStringField str_ring_url = PBField.initString("");
  public final PBStringField str_thumb_url = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\funcall\VipFunCallAndRing$TSourceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */