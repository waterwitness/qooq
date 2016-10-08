package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$ReqGetConfigFile
  extends MessageMicro
{
  public static final int CONFIG_FILE_TYPE_FIELD_NUMBER = 1;
  public static final int MOBILE_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "config_file_type", "mobile_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ReqGetConfigFile.class);
  public final PBUInt32Field config_file_type = PBField.initUInt32(0);
  public final PBUInt32Field mobile_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_service$ReqGetConfigFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */