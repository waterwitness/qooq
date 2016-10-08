package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$RspAuthKey
  extends MessageMicro
{
  public static final int AUTH_KEY_FIELD_NUMBER = 7;
  public static final int BACKUP_SERVER_IP1_FIELD_NUMBER = 5;
  public static final int BACKUP_SERVER_IP2_FIELD_NUMBER = 6;
  public static final int EXPIRE_TIME_FIELD_NUMBER = 8;
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int SERVER_IP1_FIELD_NUMBER = 3;
  public static final int SERVER_IP2_FIELD_NUMBER = 4;
  public static final int USER_IP_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField auth_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField backup_server_ip1 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField backup_server_ip2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field expire_time = PBField.initUInt64(0L);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBBytesField server_ip1 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField server_ip2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField user_ip = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64 }, new String[] { "result", "user_ip", "server_ip1", "server_ip2", "backup_server_ip1", "backup_server_ip2", "auth_key", "expire_time" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Long.valueOf(0L) }, RspAuthKey.class);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_service$RspAuthKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */