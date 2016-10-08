package com.tencent.avatarinfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQHeadUrl$ReqUsrInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "dstUin", "timestamp", "dstEncid" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "" }, ReqUsrInfo.class);
  public final PBStringField dstEncid = PBField.initString("");
  public final PBUInt64Field dstUin = PBField.initUInt64(0L);
  public final PBUInt32Field timestamp = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\avatarinfo\QQHeadUrl$ReqUsrInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */