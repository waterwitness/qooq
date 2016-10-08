package com.tencent.mobileqq;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WebSsoBody$WebSsoControlData
  extends MessageMicro
{
  public static final int FREQUENCY_FIELD_NUMBER = 1;
  public static final int PACKAGESIZE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "frequency", "packageSize" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, WebSsoControlData.class);
  public final PBUInt32Field frequency = PBField.initUInt32(0);
  public final PBUInt32Field packageSize = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\WebSsoBody$WebSsoControlData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */