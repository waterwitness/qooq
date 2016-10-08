package com.tencent.pb.getpreload;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class PreloadInfoCheckUpdate$WebViewConfigRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "head", "url_check", "url_list", "js_report", "interval" }, new Object[] { null, Boolean.valueOf(false), "", Boolean.valueOf(false), Integer.valueOf(0) }, WebViewConfigRsp.class);
  public PreloadInfoCheckUpdate.ControlRspHead head = new PreloadInfoCheckUpdate.ControlRspHead();
  public final PBInt32Field interval = PBField.initInt32(0);
  public final PBBoolField js_report = PBField.initBool(false);
  public final PBBoolField url_check = PBField.initBool(false);
  public final PBRepeatField url_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\getpreload\PreloadInfoCheckUpdate$WebViewConfigRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */