package com.tencent.pb.webssoagent;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WebSSOAgent$UniSsoServerReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "comm", "reqdata" }, new Object[] { null, "" }, UniSsoServerReq.class);
  public WebSSOAgent.UniSsoServerReqComm comm = new WebSSOAgent.UniSsoServerReqComm();
  public final PBStringField reqdata = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\webssoagent\WebSSOAgent$UniSsoServerReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */