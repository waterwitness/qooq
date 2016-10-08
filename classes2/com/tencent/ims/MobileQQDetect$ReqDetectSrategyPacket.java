package com.tencent.ims;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MobileQQDetect$ReqDetectSrategyPacket
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "u32_version", "u32_lastTime", "u32_lastUid", "envParam" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, ReqDetectSrategyPacket.class);
  public MobileQQDetect.EnvParamPacket envParam = new MobileQQDetect.EnvParamPacket();
  public final PBUInt32Field u32_lastTime = PBField.initUInt32(0);
  public final PBUInt32Field u32_lastUid = PBField.initUInt32(0);
  public final PBUInt32Field u32_version = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\ims\MobileQQDetect$ReqDetectSrategyPacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */