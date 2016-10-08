package pttcenterservice;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PttShortVideo$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 800 }, new String[] { "uint32_cmd", "uint32_seq", "msg_PttShortVideoUpload_Resp", "msg_PttShortVideoDownload_Resp", "rpt_msg_short_video_retweet_resp", "rpt_msg_short_video_delete_resp", "uint32_change_channel" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0) }, RspBody.class);
  public PttShortVideo.PttShortVideoDownloadResp msg_PttShortVideoDownload_Resp = new PttShortVideo.PttShortVideoDownloadResp();
  public PttShortVideo.PttShortVideoUploadResp msg_PttShortVideoUpload_Resp = new PttShortVideo.PttShortVideoUploadResp();
  public final PBRepeatMessageField rpt_msg_short_video_delete_resp = PBField.initRepeatMessage(PttShortVideo.PttShortVideoDeleteResp.class);
  public final PBRepeatMessageField rpt_msg_short_video_retweet_resp = PBField.initRepeatMessage(PttShortVideo.PttShortVideoRetweetResp.class);
  public final PBUInt32Field uint32_change_channel = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\pttcenterservice\PttShortVideo$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */