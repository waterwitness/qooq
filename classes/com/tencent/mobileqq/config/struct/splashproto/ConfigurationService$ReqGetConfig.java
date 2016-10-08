package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ConfigurationService$ReqGetConfig
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "seq_list", "device_info", "str_info", "province", "city" }, new Object[] { null, null, "", "", "" }, ReqGetConfig.class);
  public final PBStringField city = PBField.initString("");
  public ConfigurationService.DeviceInfo device_info = new ConfigurationService.DeviceInfo();
  public final PBStringField province = PBField.initString("");
  public final PBRepeatMessageField seq_list = PBField.initRepeatMessage(ConfigurationService.ConfigSeq.class);
  public final PBStringField str_info = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\config\struct\splashproto\ConfigurationService$ReqGetConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */