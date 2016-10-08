package com.tencent.pb.getpreload;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class PreloadInfoCheckUpdate$FirstShowReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "head", "appid" }, new Object[] { null, Integer.valueOf(0) }, FirstShowReq.class);
  public final PBInt32Field appid = PBField.initInt32(0);
  public PreloadInfoCheckUpdate.ControlReqHead head = new PreloadInfoCheckUpdate.ControlReqHead();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\getpreload\PreloadInfoCheckUpdate$FirstShowReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */