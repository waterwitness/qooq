package com.tencent.protofile.getappinfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetAppInfoProto$IOSInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "urlSchema", "boundleID", "appstoreID", "sourceUrl", "officalwebsite", "messagetail", "a_bundleid" }, new Object[] { "", "", "", "", "", "", "" }, IOSInfo.class);
  public final PBStringField a_bundleid = PBField.initString("");
  public final PBStringField appstoreID = PBField.initString("");
  public final PBStringField boundleID = PBField.initString("");
  public final PBStringField messagetail = PBField.initString("");
  public final PBStringField officalwebsite = PBField.initString("");
  public final PBStringField sourceUrl = PBField.initString("");
  public final PBStringField urlSchema = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\protofile\getappinfo\GetAppInfoProto$IOSInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */