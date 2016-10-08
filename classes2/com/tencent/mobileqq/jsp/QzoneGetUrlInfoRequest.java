package com.tencent.mobileqq.jsp;

import NS_MOBILE_EXTRA.mobile_get_urlinfo_req;
import QMF_PROTOCAL.RetryInfo;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QzoneExternalRequest;

public class QzoneGetUrlInfoRequest
  extends QzoneExternalRequest
{
  public static final String a = "getUrlInfo";
  private static final String b = "QzoneNewService.getUrlInfo";
  private JceStruct a;
  
  public QzoneGetUrlInfoRequest(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    mobile_get_urlinfo_req localmobile_get_urlinfo_req = new mobile_get_urlinfo_req();
    localmobile_get_urlinfo_req.url = paramString;
    this.a = localmobile_get_urlinfo_req;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getUrlInfo";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public Object getRetryInfo()
  {
    return new RetryInfo((short)0, 0, System.currentTimeMillis());
  }
  
  public String uniKey()
  {
    return "getUrlInfo";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\jsp\QzoneGetUrlInfoRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */