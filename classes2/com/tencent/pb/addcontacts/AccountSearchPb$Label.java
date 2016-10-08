package com.tencent.pb.addcontacts;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AccountSearchPb$Label
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public AccountSearchPb.Color edging_color = new AccountSearchPb.Color();
  public AccountSearchPb.Color text_color = new AccountSearchPb.Color();
  public final PBUInt32Field uint32_label_attr = PBField.initUInt32(0);
  public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 26, 34, 40, 48 }, new String[] { "bytes_name", "text_color", "edging_color", "uint32_label_attr", "uint32_label_type" }, new Object[] { localByteStringMicro, null, null, Integer.valueOf(0), Integer.valueOf(0) }, Label.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\addcontacts\AccountSearchPb$Label.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */