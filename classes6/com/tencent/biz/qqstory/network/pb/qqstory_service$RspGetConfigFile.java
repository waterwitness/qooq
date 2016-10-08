package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspGetConfigFile
  extends MessageMicro
{
  public static final int CONFIG_DOWNLOAD_MD5_FIELD_NUMBER = 4;
  public static final int CONFIG_DOWNLOAD_URL_FIELD_NUMBER = 3;
  public static final int CONFIG_FILE_TYPE_FIELD_NUMBER = 2;
  public static final int RESULT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField config_download_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField config_download_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field config_file_type = PBField.initUInt32(0);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "result", "config_file_type", "config_download_url", "config_download_md5" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, RspGetConfigFile.class);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_service$RspGetConfigFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */