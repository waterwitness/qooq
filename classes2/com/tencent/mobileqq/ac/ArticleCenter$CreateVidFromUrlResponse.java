package com.tencent.mobileqq.ac;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class ArticleCenter$CreateVidFromUrlResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public ArticleCenter.RetInfo ret_info = new ArticleCenter.RetInfo();
  public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "ret_info", "url", "vid" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2 }, CreateVidFromUrlResponse.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ac\ArticleCenter$CreateVidFromUrlResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */