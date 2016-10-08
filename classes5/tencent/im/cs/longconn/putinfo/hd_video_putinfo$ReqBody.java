package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class hd_video_putinfo$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_putinfo_head", "msg_report_client_info_req_body" }, new Object[] { null, null }, ReqBody.class);
  public hd_video_putinfo.PutinfoHead msg_putinfo_head = new hd_video_putinfo.PutinfoHead();
  public hd_video_putinfo.CmdReportClientInfoReqBody msg_report_client_info_req_body = new hd_video_putinfo.CmdReportClientInfoReqBody();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\longconn\putinfo\hd_video_putinfo$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */