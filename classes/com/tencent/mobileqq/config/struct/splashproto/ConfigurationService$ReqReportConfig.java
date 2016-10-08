package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ConfigurationService$ReqReportConfig
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "config_list" }, new Object[] { null }, ReqReportConfig.class);
  public final PBRepeatMessageField config_list = PBField.initRepeatMessage(ConfigurationService.ReportConfig.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\config\struct\splashproto\ConfigurationService$ReqReportConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */