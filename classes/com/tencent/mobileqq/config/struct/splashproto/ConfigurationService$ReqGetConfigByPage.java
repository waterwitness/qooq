package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ConfigurationService$ReqGetConfigByPage
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "type", "page_info", "device_info" }, new Object[] { Integer.valueOf(0), null, null }, ReqGetConfigByPage.class);
  public ConfigurationService.DeviceInfo device_info = new ConfigurationService.DeviceInfo();
  public ConfigurationService.PageReqInfo page_info = new ConfigurationService.PageReqInfo();
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\config\struct\splashproto\ConfigurationService$ReqGetConfigByPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */