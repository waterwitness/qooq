package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BubbleDiyComu$UserTextInfo
  extends MessageMicro
{
  public static final int CREATE_TS_FIELD_NUMBER = 4;
  public static final int TEXT_FIELD_NUMBER = 3;
  public static final int TEXT_ID_FIELD_NUMBER = 2;
  public static final int TEXT_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "text_uin", "text_id", "text", "create_ts" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", Long.valueOf(0L) }, UserTextInfo.class);
  public final PBInt64Field create_ts = PBField.initInt64(0L);
  public final PBStringField text = PBField.initString("");
  public final PBUInt32Field text_id = PBField.initUInt32(0);
  public final PBUInt64Field text_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\bubble\BubbleDiyComu$UserTextInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */