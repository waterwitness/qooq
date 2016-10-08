package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$MpGetNotifycationResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field fans_msg_id = PBField.initUInt64(0L);
  public final PBBytesField fans_msg_tips = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field publish_msg_id = PBField.initUInt64(0L);
  public final PBBytesField publish_msg_tips = PBField.initBytes(ByteStringMicro.EMPTY);
  public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42 }, new String[] { "ret_info", "fans_msg_id", "fans_msg_tips", "publish_msg_id", "publish_msg_tips" }, new Object[] { null, Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2 }, MpGetNotifycationResponse.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\mp\mobileqq_mp$MpGetNotifycationResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */