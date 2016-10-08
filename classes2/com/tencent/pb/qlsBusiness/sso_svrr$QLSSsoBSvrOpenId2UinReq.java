package com.tencent.pb.qlsBusiness;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class sso_svrr$QLSSsoBSvrOpenId2UinReq
  extends MessageMicro
{
  public static final int APPID_FIELD_NUMBER = 2;
  public static final int HEADER_FIELD_NUMBER = 1;
  public static final int OPENID_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "header", "appid", "openid" }, new Object[] { null, Integer.valueOf(0), "" }, QLSSsoBSvrOpenId2UinReq.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public sso_svrr.QLSSsoBSvrHeader header = new sso_svrr.QLSSsoBSvrHeader();
  public final PBStringField openid = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\qlsBusiness\sso_svrr$QLSSsoBSvrOpenId2UinReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */