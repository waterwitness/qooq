package com.tencent.mobileqq.qzonestatus;

import NS_MOBILE_NEWEST_FEEDS.newest_feeds_req;
import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QzoneExternalRequest;

public class QzoneContactsFeedRequest
  extends QzoneExternalRequest
{
  public static final String a = "getAIONewestFeeds";
  private static final String b = "getAIONewestFeeds";
  private static final String c = "QzoneNewService.getAIONewestFeeds";
  private static final String d = "getAIONewestFeeds";
  public JceStruct a;
  
  public QzoneContactsFeedRequest(newest_feeds_req paramnewest_feeds_req)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    super.setHostUin(paramnewest_feeds_req.login_uin);
    super.setLoginUserId(paramnewest_feeds_req.login_uin);
    this.a = paramnewest_feeds_req;
  }
  
  public static newest_feeds_rsp a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    newest_feeds_rsp localnewest_feeds_rsp;
    do
    {
      return paramArrayOfByte;
      localnewest_feeds_rsp = (newest_feeds_rsp)decode(paramArrayOfByte, "getAIONewestFeeds");
      paramArrayOfByte = localnewest_feeds_rsp;
    } while (localnewest_feeds_rsp != null);
    return null;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getAIONewestFeeds";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "getAIONewestFeeds";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qzonestatus\QzoneContactsFeedRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */