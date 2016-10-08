package com.tencent.pb.webssoagent;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class WebSSOAgent$UniSsoServerRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "ret", "errmsg", "comm", "rspdata" }, new Object[] { Long.valueOf(0L), "", null, "" }, UniSsoServerRsp.class);
  public WebSSOAgent.UniSsoServerRspComm comm = new WebSSOAgent.UniSsoServerRspComm();
  public final PBStringField errmsg = PBField.initString("");
  public final PBInt64Field ret = PBField.initInt64(0L);
  public final PBStringField rspdata = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\webssoagent\WebSSOAgent$UniSsoServerRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */