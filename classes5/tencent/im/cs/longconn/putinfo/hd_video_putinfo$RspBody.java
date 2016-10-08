package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class hd_video_putinfo$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_putinfo_head", "msg_to_client_config_info_rsq_body" }, new Object[] { null, null }, RspBody.class);
  public hd_video_putinfo.PutinfoHead msg_putinfo_head = new hd_video_putinfo.PutinfoHead();
  public hd_video_putinfo.CmdToClientConfigInfoRspBody msg_to_client_config_info_rsq_body = new hd_video_putinfo.CmdToClientConfigInfoRspBody();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\longconn\putinfo\hd_video_putinfo$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */