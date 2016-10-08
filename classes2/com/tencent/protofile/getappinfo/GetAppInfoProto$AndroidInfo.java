package com.tencent.protofile.getappinfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetAppInfoProto$AndroidInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "apkDownUrl", "packName", "className", "sourceUrl", "officalwebsite", "messagetail", "bundleid" }, new Object[] { "", "", "", "", "", "", "" }, AndroidInfo.class);
  public final PBStringField apkDownUrl = PBField.initString("");
  public final PBStringField bundleid = PBField.initString("");
  public final PBStringField className = PBField.initString("");
  public final PBStringField messagetail = PBField.initString("");
  public final PBStringField officalwebsite = PBField.initString("");
  public final PBStringField packName = PBField.initString("");
  public final PBStringField sourceUrl = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\protofile\getappinfo\GetAppInfoProto$AndroidInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */