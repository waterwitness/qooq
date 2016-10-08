package com.tencent.pb.emosm;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class EmosmPb$SubCmd0x5ReqBQRecommend
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "int32_last_recommend_version" }, new Object[] { Integer.valueOf(0) }, SubCmd0x5ReqBQRecommend.class);
  public final PBInt32Field int32_last_recommend_version = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\emosm\EmosmPb$SubCmd0x5ReqBQRecommend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */