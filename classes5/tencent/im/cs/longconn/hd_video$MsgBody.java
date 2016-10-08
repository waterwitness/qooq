package tencent.im.cs.longconn;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class hd_video$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82, 90 }, new String[] { "msg_video_head", "msg_pstn_callback_notify_accept", "msg_pstn_callback_notify_logout" }, new Object[] { null, null, null }, MsgBody.class);
  public hd_video.CmdPSTNCallbackNotifyAccept msg_pstn_callback_notify_accept = new hd_video.CmdPSTNCallbackNotifyAccept();
  public hd_video.CmdPSTNCallbackNotifyLogout msg_pstn_callback_notify_logout = new hd_video.CmdPSTNCallbackNotifyLogout();
  public hd_video.VideoHead msg_video_head = new hd_video.VideoHead();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\longconn\hd_video$MsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */