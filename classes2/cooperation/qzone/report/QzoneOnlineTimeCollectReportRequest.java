package cooperation.qzone.report;

import NS_MOBILE_FEEDS.mobile_online_report_req;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

public class QzoneOnlineTimeCollectReportRequest
  extends QzoneExternalRequest
{
  public static final String a = "reportOnlineTime";
  public JceStruct a;
  
  public QzoneOnlineTimeCollectReportRequest(long paramLong, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    mobile_online_report_req localmobile_online_report_req = new mobile_online_report_req();
    localmobile_online_report_req.appid = 8001;
    localmobile_online_report_req.type_id = 0;
    localmobile_online_report_req.uin = paramLong;
    localmobile_online_report_req.vecOnlineItem = paramArrayList;
    this.a = localmobile_online_report_req;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.reportOnlineTime";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "reportOnlineTime";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\report\QzoneOnlineTimeCollectReportRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */