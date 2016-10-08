package com.tencent.av;

import MessageSvcPack.SvcRequestSendVideoMsg;
import SharpSvrPack.MultiVideoMsg;
import SharpSvrPack.SharpVideoMsg;
import VideoSvrPack.VideoCallMsg;
import android.content.Intent;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.AbstractNetChannel;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.report.AVReport;
import com.tencent.av.report.AVReport.ReceiverNodeStage;
import com.tencent.av.report.AVReport.SenderNodeStage;
import com.tencent.av.report.VideoConnRateReport;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.report.StrupBuff;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0x625.Oidb_0x625.Open2Tiny_ReqBody;
import tencent.im.oidb.cmd0x625.Oidb_0x625.Open2Tiny_RspBody;
import tencent.im.oidb.cmd0x625.Oidb_0x625.OpenIDInfoReq;
import tencent.im.oidb.cmd0x626.Oidb_0x626.Tiny2Open_ReqBody;
import tencent.im.oidb.cmd0x626.Oidb_0x626.Tiny2Open_RspBody;
import tencent.im.oidb.cmd0x626.Oidb_0x626.TinyIDInfoReq;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class VideoServlet
  extends MSFServlet
{
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "VideoServlet";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 1;
  public static final int e = 2;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  
  public VideoServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private long a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (;;)
    {
      return 0L;
      try
      {
        long l = CharacterUtil.a(paramString);
        if (l >= 10000L) {
          return l;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return 0L;
  }
  
  private void a(MultiVideoMsg paramMultiVideoMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoServlet", 2, "sendMultiVideoAck, seq: " + paramMultiVideoMsg.msg_seq + ", videoMsg.type:" + paramMultiVideoMsg.type + ", videoMsg.from_uin:" + paramMultiVideoMsg.from_uin + ", videoMsg.to_uin.get(0):" + paramMultiVideoMsg.to_uin.get(0) + ", +videoMsg.to_uin.size():" + paramMultiVideoMsg.to_uin.size());
    }
    NewIntent localNewIntent = new NewIntent(this.a.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 9);
    localNewIntent.putExtra("ver", paramMultiVideoMsg.ver);
    localNewIntent.putExtra("type", paramMultiVideoMsg.type);
    localNewIntent.putExtra("cscmd", paramMultiVideoMsg.csCmd);
    localNewIntent.putExtra("subcmd", paramMultiVideoMsg.subCmd);
    localNewIntent.putExtra("from_uin", paramMultiVideoMsg.from_uin);
    localNewIntent.putExtra("to_uin", (Serializable)paramMultiVideoMsg.to_uin.get(0));
    localNewIntent.putExtra("video_buff", paramMultiVideoMsg.video_buff);
    localNewIntent.putExtra("msg_seq", paramMultiVideoMsg.msg_seq);
    localNewIntent.putExtra("msg_uid", paramMultiVideoMsg.msg_uid);
    localNewIntent.putExtra("msg_type", paramMultiVideoMsg.msg_type);
    localNewIntent.putExtra("msg_time", paramMultiVideoMsg.msg_time);
    localNewIntent.putExtra("erroMsg", "success");
    service(localNewIntent);
  }
  
  private void a(VideoCallMsg paramVideoCallMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoServlet", 2, "sendVideoM2MAck buf[2] = " + paramVideoCallMsg.vMsg[2]);
    }
    NewIntent localNewIntent = new NewIntent(this.a.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 2);
    localNewIntent.putExtra("fromUin", paramVideoCallMsg.lUin);
    localNewIntent.putExtra("toUin", paramVideoCallMsg.lPeerUin);
    localNewIntent.putExtra("seqId", paramVideoCallMsg.uSeqId);
    localNewIntent.putExtra("sessionId", paramVideoCallMsg.uSessionId);
    localNewIntent.putExtra("time", paramVideoCallMsg.uDateTime);
    localNewIntent.putExtra("erroMsg", "success");
    service(localNewIntent);
  }
  
  private void b(VideoCallMsg paramVideoCallMsg)
  {
    paramVideoCallMsg = paramVideoCallMsg.vMsg;
    if (QLog.isColorLevel()) {
      QLog.d("VideoServlet", 2, "Decode video Config message.");
    }
    this.a.a().d(paramVideoCallMsg);
  }
  
  private void c(SharpVideoMsg paramSharpVideoMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoServlet", 2, "sendSharpVideoAck, seq: " + paramSharpVideoMsg.msg_seq + ", videoMsg.type:" + paramSharpVideoMsg.type + ", videoMsg.from_uin:" + paramSharpVideoMsg.from_uin + ", videoMsg.to_uin.get(0):" + paramSharpVideoMsg.to_uin.get(0) + ", +videoMsg.to_uin.size():" + paramSharpVideoMsg.to_uin.size());
    }
    NewIntent localNewIntent = new NewIntent(this.a.getApplication(), VideoServlet.class);
    localNewIntent.setWithouLogin(true);
    localNewIntent.putExtra("reqType", 5);
    localNewIntent.putExtra("ver", paramSharpVideoMsg.ver);
    localNewIntent.putExtra("type", paramSharpVideoMsg.type);
    localNewIntent.putExtra("from_uin", paramSharpVideoMsg.from_uin);
    localNewIntent.putExtra("to_uin", (Serializable)paramSharpVideoMsg.to_uin.get(0));
    localNewIntent.putExtra("video_buff", paramSharpVideoMsg.video_buff);
    localNewIntent.putExtra("msg_seq", paramSharpVideoMsg.msg_seq);
    localNewIntent.putExtra("msg_uid", paramSharpVideoMsg.msg_uid);
    localNewIntent.putExtra("msg_type", paramSharpVideoMsg.msg_type);
    localNewIntent.putExtra("msg_time", paramSharpVideoMsg.msg_time);
    localNewIntent.putExtra("terminal_type", paramSharpVideoMsg.call_type);
    localNewIntent.putExtra("erroMsg", "success");
    service(localNewIntent);
  }
  
  private void c(VideoCallMsg paramVideoCallMsg)
  {
    short s = 0;
    byte[] arrayOfByte = paramVideoCallMsg.vMsg;
    long l1 = paramVideoCallMsg.lUin;
    long l2 = paramVideoCallMsg.lPeerUin;
    String str = "null";
    if (arrayOfByte != null) {
      str = String.valueOf(arrayOfByte[2]);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoServlet", 2, "Decode video M2M message: selfUin = " + l2 + ", fromUin = " + l1 + ", buffer[2] = " + str);
    }
    Object localObject = (Friends)((VideoAppInterface)getAppRuntime()).a(null).createEntityManager().a(Friends.class, String.valueOf(l1));
    if (localObject != null)
    {
      str = ((Friends)localObject).getFriendNick();
      s = ((Friends)localObject).faceid;
    }
    for (boolean bool = ((Friends)localObject).isFriend();; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoServlet", 2, "friendName = " + str + ", faceId = " + s);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("m2m", true);
      ((Bundle)localObject).putString("uin", String.valueOf(l2));
      ((Bundle)localObject).putString("fromUin", String.valueOf(l1));
      ((Bundle)localObject).putShort("faceID", s);
      ((Bundle)localObject).putByteArray("buffer", arrayOfByte);
      ((Bundle)localObject).putInt("time", paramVideoCallMsg.uDateTime);
      ((Bundle)localObject).putString("name", str);
      ((Bundle)localObject).putBoolean("isFriend", bool);
      this.a.a().a((Bundle)localObject);
      return;
      str = String.valueOf(l1);
    }
  }
  
  int a()
  {
    if (AudioUtil.a() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoServlet", 2, "phone ring mode is slient");
      }
      return 1;
    }
    return 0;
  }
  
  void a(SharpVideoMsg paramSharpVideoMsg)
  {
    boolean bool = false;
    byte[] arrayOfByte = paramSharpVideoMsg.video_buff;
    long l1 = paramSharpVideoMsg.from_uin;
    long l2 = ((Long)paramSharpVideoMsg.to_uin.get(0)).longValue();
    Friends localFriends = (Friends)((VideoAppInterface)getAppRuntime()).a(null).createEntityManager().a(Friends.class, String.valueOf(l1));
    Object localObject;
    short s;
    if (localFriends != null)
    {
      localObject = localFriends.getFriendNick();
      s = localFriends.faceid;
      bool = localFriends.isFriend();
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", String.valueOf(l2));
      localBundle.putString("fromUin", CharacterUtil.a(l1));
      localBundle.putShort("faceID", s);
      localBundle.putByteArray("buffer", arrayOfByte);
      localBundle.putLong("time", paramSharpVideoMsg.msg_time);
      localBundle.putString("name", (String)localObject);
      localBundle.putBoolean("isFriend", bool);
      this.a.a().d(localBundle);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("handle Sharp Video s2c Message OK, friendName = ").append((String)localObject).append(", faceId = ").append(s).append(", friendRemark = ");
        if (localFriends != null) {
          break label266;
        }
      }
    }
    label266:
    for (paramSharpVideoMsg = "";; paramSharpVideoMsg = localFriends.remark)
    {
      QLog.d("VideoServlet", 2, paramSharpVideoMsg + ",isFriend:" + bool);
      return;
      localObject = CharacterUtil.a(l1);
      s = 0;
      break;
    }
  }
  
  void b(SharpVideoMsg paramSharpVideoMsg)
  {
    paramSharpVideoMsg = paramSharpVideoMsg.video_buff;
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("buffer", paramSharpVideoMsg);
    this.a.a().e(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("VideoServlet", 2, "handle Sharp Video c2s Ack Message OK");
    }
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "VideoSvc.Send", "VideoCCSvc.Adaptation", "SharpSvr.c2sack", "SharpSvr.s2c", "MultiVideo.c2sack", "MultiVideo.s2c" };
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.a = ((VideoAppInterface)getAppRuntime());
    VideoConnRateReport.a().jdField_a_of_type_Boolean = true;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    if (paramIntent != null) {
      if ("VideoCCSvc.Adaptation".equalsIgnoreCase(str2)) {
        if (paramFromServiceMsg.isSuccess()) {
          b((VideoCallMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "VideoCallMsg", new VideoCallMsg()));
        }
      }
    }
    label53:
    label1260:
    label1283:
    label1520:
    label2141:
    do
    {
      do
      {
        do
        {
          break label53;
          break label53;
          break label53;
          break label53;
          break label53;
          break label53;
          break label53;
          break label53;
          break label53;
          break label53;
          break label53;
          break label53;
          break label53;
          break label53;
          break label53;
          for (;;)
          {
            return;
            if (QLog.isColorLevel())
            {
              QLog.d("VideoServlet", 2, "servlet recv video service resp: cmd = " + str2 + ", result = failed");
              return;
              if (MsfMsgUtil.getSetConnStatusMsg(null, 0).getServiceCmd().equalsIgnoreCase(str2))
              {
                paramIntent = (Integer)paramFromServiceMsg.getAttribute("status");
                if (paramIntent == null) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("VideoServlet", 2, "Receive getSetConnStatusMsg " + paramIntent);
                }
                this.a.a().e(paramIntent.intValue());
                return;
              }
              if (MsfMsgUtil.getGatewayIpMsg(null).getServiceCmd().equalsIgnoreCase(str2))
              {
                paramIntent = (String)paramFromServiceMsg.getAttribute(MsfMsgUtil.getGatewayIpMsg(null).getServiceCmd());
                if (paramIntent == null) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("VideoServlet", 2, "parse getGatewayIpMsg Ok " + paramIntent + " cmd " + str2);
                }
                this.a.a().g(paramIntent, 0);
                return;
              }
              int i;
              if ("OidbSvc.0x625".equalsIgnoreCase(str2))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive");
                }
                if (paramFromServiceMsg.isSuccess())
                {
                  try
                  {
                    i = paramFromServiceMsg.getWupBuffer().length - 4;
                    paramIntent = new byte[i];
                    PkgTools.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
                    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
                    paramFromServiceMsg.mergeFrom(paramIntent);
                    if (paramFromServiceMsg.uint32_result.get() != 0)
                    {
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive uint32_result = " + paramFromServiceMsg.uint32_result.get());
                      return;
                    }
                  }
                  catch (Exception paramIntent)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive Exception!");
                    }
                    paramIntent.printStackTrace();
                    return;
                  }
                  if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
                    break;
                  }
                  paramIntent = new Oidb_0x625.Open2Tiny_RspBody();
                  paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
                  paramIntent = paramIntent.msg_tinyid_rsp_info.get();
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive list = " + paramIntent.toString());
                  return;
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive not success!");
                return;
              }
              if ("OidbSvc.0x626".equalsIgnoreCase(str2))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive");
                }
                if (paramFromServiceMsg.isSuccess())
                {
                  try
                  {
                    i = paramFromServiceMsg.getWupBuffer().length - 4;
                    paramIntent = new byte[i];
                    PkgTools.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
                    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
                    paramFromServiceMsg.mergeFrom(paramIntent);
                    if (paramFromServiceMsg.uint32_result.get() != 0)
                    {
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive uint32_result = " + paramFromServiceMsg.uint32_result.get());
                      return;
                    }
                  }
                  catch (Exception paramIntent)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive Exception!");
                    }
                    paramIntent.printStackTrace();
                    return;
                  }
                  if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
                    break;
                  }
                  paramIntent = new Oidb_0x626.Tiny2Open_RspBody();
                  paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
                  paramIntent = paramIntent.msg_openid_rsp_info.get();
                  if (QLog.isColorLevel()) {
                    QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive list = " + paramIntent.toString());
                  }
                  new ArrayList();
                  paramIntent = PstnUtils.a(paramIntent);
                  this.a.a().c(paramIntent);
                  return;
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive not success!");
                return;
              }
              Bundle localBundle = paramIntent.getExtras();
              byte[] arrayOfByte = localBundle.getByteArray("vMsg");
              String str1 = "null";
              paramIntent = str1;
              if (arrayOfByte != null)
              {
                paramIntent = str1;
                if (arrayOfByte.length > 2) {
                  paramIntent = String.valueOf(arrayOfByte[2]);
                }
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("VideoServlet", 2, "servlet recv video service resp: cmd = " + str2 + ", friendUin = " + localBundle.getLong("toUin") + ", buffer[2] = " + paramIntent + ", result = " + String.valueOf(paramFromServiceMsg.isSuccess()));
              return;
              if ("VideoSvc.Send".equalsIgnoreCase(str2))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("VideoServlet", 2, "Receive video m2m message, cmd=VideoSvc.Send");
                }
                paramIntent = (VideoCallMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "VideoCallMsg", new VideoCallMsg());
                if (AbstractNetChannel.a(paramIntent.vMsg) == 1) {
                  this.a.a().a(String.valueOf(paramIntent.lUin), paramIntent.vMsg);
                }
                if ((!VcSystemInfo.e()) || (!VcSystemInfo.f()))
                {
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("VideoServlet", 2, "Discard video m2m message cause device not support");
                  return;
                }
                c(paramIntent);
                return;
              }
              if ("SharpSvr.s2c".equalsIgnoreCase(str2))
              {
                paramIntent = (SharpVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "SharpVideoMsg", new SharpVideoMsg());
                if (QLog.isColorLevel()) {
                  QLog.i("VideoServlet", 2, "Receive sharp video message,cmd=" + str2 + " seq:" + paramIntent.msg_seq + " type:" + paramIntent.msg_type);
                }
                if (paramIntent.msg_type == 3L)
                {
                  this.a.a().b(200, String.valueOf(paramIntent.from_uin));
                  if (this.a.a().b() != 0) {
                    break label1260;
                  }
                  this.a.a().b(205, String.valueOf(paramIntent.from_uin));
                }
                for (;;)
                {
                  if (!VideoConnRateReport.a().b) {
                    VideoConnRateReport.a().a(paramIntent.msg_seq);
                  }
                  VideoConnRateReport.a().a("eVideoRecvInviteMsg", 3L, paramIntent.msg_seq, ((Long)paramIntent.to_uin.get(0)).longValue(), paramIntent.from_uin, 0);
                  c(paramIntent);
                  if (VcSystemInfo.e()) {
                    break label1283;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("VideoServlet", 2, "Discard sharp video message cause device not support");
                  }
                  if (paramIntent.msg_type != 3L) {
                    break;
                  }
                  this.a.a().b(210, String.valueOf(paramIntent.from_uin));
                  return;
                  this.a.a().b(204, String.valueOf(paramIntent.from_uin));
                }
                if (paramIntent.msg_type == 3L) {
                  this.a.a().b(209, String.valueOf(paramIntent.from_uin));
                }
                if ((!AVReport.a().jdField_a_of_type_Boolean) && (AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$ReceiverNodeStage != AVReport.ReceiverNodeStage.other) && (paramFromServiceMsg != null) && (paramFromServiceMsg.getAttributes() != null))
                {
                  paramFromServiceMsg = paramFromServiceMsg.getAttributes().get("__timestamp_net2msf_boot");
                  if (paramFromServiceMsg != null) {
                    AVReport.a().q = ((Long)paramFromServiceMsg).longValue();
                  }
                }
                a(paramIntent);
                return;
              }
              if ("SharpSvr.c2sack".equalsIgnoreCase(str2))
              {
                if ((AVReport.a().jdField_a_of_type_Boolean) && (paramFromServiceMsg != null) && (paramFromServiceMsg.getAttributes() != null))
                {
                  if (AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$SenderNodeStage != AVReport.SenderNodeStage.SendAVRoomReq) {
                    break label1520;
                  }
                  paramIntent = paramFromServiceMsg.getAttributes().get("__timestamp_net2msf_boot");
                  if (paramIntent != null) {
                    AVReport.a().d = ((Long)paramIntent).longValue();
                  }
                  paramIntent = paramFromServiceMsg.getAttributes().get("__timestamp_msf2net_boot_sharp_c2s");
                  if (paramIntent != null) {
                    AVReport.a().c = ((Long)paramIntent).longValue();
                  }
                }
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("VideoServlet", 2, "Receive sharp video message c2s ack,cmd=SharpSvr.c2sack");
                  }
                  b((SharpVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "SharpVideoMsg", new SharpVideoMsg()));
                  return;
                  if (AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$SenderNodeStage == AVReport.SenderNodeStage.SendRequestReq)
                  {
                    AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$SenderNodeStage = AVReport.SenderNodeStage.other;
                    paramIntent = paramFromServiceMsg.getAttributes().get("__timestamp_msf2net_boot_sharp_c2s");
                    if (paramIntent != null) {
                      AVReport.a().g = ((Long)paramIntent).longValue();
                    }
                  }
                }
              }
              if ("MultiVideo.s2c".equalsIgnoreCase(str2))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("VideoServlet", 2, "Receive multi video message s2c ,cmd=MultiVideo.s2c");
                }
                paramIntent = (MultiVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
                a(paramIntent);
                this.a.a().b(paramIntent.video_buff);
                return;
              }
              if ("MultiVideo.c2sack".equalsIgnoreCase(str2))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("VideoServlet", 2, "Receive multi video message c2s ack,cmd=MultiVideo.c2sack");
                }
                paramIntent = (MultiVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
                this.a.a().c(paramIntent.video_buff);
                return;
              }
              if ("OidbSvc.0x625".equalsIgnoreCase(str2))
              {
                if (paramFromServiceMsg.isSuccess())
                {
                  try
                  {
                    paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
                    paramIntent = new byte[paramFromServiceMsg.getInt() - 4];
                    paramFromServiceMsg.get(paramIntent);
                    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
                    paramFromServiceMsg.mergeFrom(paramIntent);
                    if (paramFromServiceMsg.uint32_result.get() != 0)
                    {
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive uint32_result = " + paramFromServiceMsg.uint32_result.get());
                      return;
                    }
                  }
                  catch (Exception paramIntent)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive Exception!");
                    }
                    paramIntent.printStackTrace();
                    return;
                  }
                  if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
                    break;
                  }
                  paramIntent = new Oidb_0x625.Open2Tiny_RspBody();
                  paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
                  paramIntent = paramIntent.msg_tinyid_rsp_info.get();
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive list = " + paramIntent.toString());
                  return;
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive not success!");
                return;
              }
              if (!"OidbSvc.0x626".equalsIgnoreCase(str2)) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive");
              }
              if (!paramFromServiceMsg.isSuccess()) {
                break label2141;
              }
              try
              {
                i = paramFromServiceMsg.getWupBuffer().length - 4;
                paramIntent = new byte[i];
                PkgTools.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
                paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
                paramFromServiceMsg.mergeFrom(paramIntent);
                if (paramFromServiceMsg.uint32_result.get() != 0)
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive uint32_result = " + paramFromServiceMsg.uint32_result.get());
                }
              }
              catch (Exception paramIntent)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive Exception!");
                }
                paramIntent.printStackTrace();
                return;
              }
            }
          }
        } while (!paramFromServiceMsg.bytes_bodybuffer.has());
        paramIntent = new Oidb_0x626.Tiny2Open_RspBody();
        paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramIntent = paramIntent.msg_openid_rsp_info.get();
      } while (!QLog.isColorLevel());
      QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive list = " + paramIntent.toString());
      return;
    } while (!QLog.isColorLevel());
    QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive not success!");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getExtras();
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (((Bundle)localObject1).getInt("reqType", 0))
            {
            case 11: 
            case 12: 
            case 13: 
            case 16: 
            case 17: 
            default: 
              return;
            case 0: 
              paramPacket.setServantName("MessageSvc");
              paramPacket.setFuncName("SendVideoMsg");
              paramPacket.setSSOCommand("MessageSvc.SendVideoMsg");
              paramPacket.setNoResponse();
              paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
              paramIntent = new SvcRequestSendVideoMsg();
              paramIntent.lUin = a(((Bundle)localObject1).getString("selfuin"));
              paramIntent.lPeerUin = ((Bundle)localObject1).getLong("toUin");
              paramIntent.uDateTime = ((int)(System.currentTimeMillis() / 1000L));
              paramIntent.cVerifyType = ((Bundle)localObject1).getByte("cVerifyType");
              paramIntent.vMsg = ((Bundle)localObject1).getByteArray("vMsg");
              paramPacket.addRequestPacket("req_SendVideoMsg", paramIntent);
            }
          } while (paramIntent.vMsg == null);
          i = paramIntent.vMsg[2];
          return;
          paramPacket.setServantName("VideoSvc");
          paramPacket.setFuncName("SendVideoMsg");
          paramPacket.setSSOCommand("VideoSvc.Send");
          paramPacket.setNoResponse();
          paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
          paramIntent = new VideoCallMsg();
          paramIntent.ver = 1;
          paramIntent.type = 1;
          paramIntent.lUin = a(((Bundle)localObject1).getString("selfuin"));
          paramIntent.lPeerUin = ((Bundle)localObject1).getLong("toUin");
          paramIntent.uDateTime = ((int)(System.currentTimeMillis() / 1000L));
          paramIntent.cVerifyType = 0;
          paramIntent.uSeqId = 0;
          paramIntent.uSessionId = 0;
          paramIntent.vMsg = ((Bundle)localObject1).getByteArray("vMsg");
          paramPacket.addRequestPacket("VideoCallMsg", paramIntent);
        } while (paramIntent.vMsg == null);
        i = paramIntent.vMsg[2];
        return;
        paramPacket.setServantName("VideoSvc");
        paramPacket.setFuncName("SendAckMsg");
        paramPacket.setSSOCommand("VideoSvc.Ack");
        paramPacket.setNoResponse();
        paramIntent = new VideoCallMsg();
        paramIntent.lUin = ((Bundle)localObject1).getLong("fromUin");
        paramIntent.lPeerUin = ((Bundle)localObject1).getLong("toUin");
        paramIntent.uSeqId = ((Bundle)localObject1).getInt("seqId");
        paramIntent.uSessionId = ((Bundle)localObject1).getInt("sessionId");
        paramIntent.uDateTime = ((Bundle)localObject1).getInt("time");
        paramIntent.vMsg = new byte[0];
        localObject1 = ((Bundle)localObject1).getString("erroMsg");
        if (localObject1 != null) {}
        try
        {
          paramIntent.errMsg = ((String)localObject1).getBytes("utf-8");
          paramPacket.addRequestPacket("VideoCallMsg", paramIntent);
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        }
        paramPacket.setServantName("VideoSvc");
        paramPacket.setFuncName("SendVideoMsg");
        paramPacket.setSSOCommand("VideoCCSvc.Adaptation");
        paramIntent = new VideoCallMsg();
        paramIntent.ver = 1;
        paramIntent.type = 1;
        paramIntent.lUin = a(localUnsupportedEncodingException.getString("selfuin"));
        paramIntent.lPeerUin = localUnsupportedEncodingException.getLong("toUin");
        paramIntent.uDateTime = ((int)(System.currentTimeMillis() / 1000L));
        paramIntent.cVerifyType = 0;
        paramIntent.uSeqId = 0;
        paramIntent.uSessionId = 0;
        paramIntent.vMsg = localUnsupportedEncodingException.getByteArray("vMsg");
        paramPacket.addRequestPacket("VideoCallMsg", paramIntent);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("VideoServlet", 2, "=====send sharp SharpSvr.c2s!!!!=====");
        }
        paramPacket.setServantName("SharpSvr");
        paramPacket.setFuncName("c2s");
        paramPacket.setSSOCommand("SharpSvr.c2s");
        paramPacket.setNoResponse();
        paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
        paramIntent = new SharpVideoMsg();
        paramIntent.ver = 1;
        paramIntent.type = 1;
        paramIntent.from_uin = a(String.valueOf(localUnsupportedEncodingException.getLong("selfuin")));
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(Long.valueOf(localUnsupportedEncodingException.getLong("toUin")));
        paramIntent.to_uin = ((ArrayList)localObject3);
        paramIntent.msg_time = 0L;
        paramIntent.msg_type = 0L;
        paramIntent.msg_seq = 0L;
        paramIntent.msg_uid = 0L;
        paramIntent.video_buff = localUnsupportedEncodingException.getByteArray("vMsg");
        paramPacket.addRequestPacket("SharpVideoMsg", paramIntent);
        return;
        paramPacket = new ToServiceMsg(null, this.a.a(), "SharpSvr.s2cack");
        paramPacket.setMsfCommand(MsfCommand.sendVideoAck);
        paramPacket.setNeedCallback(false);
        localObject3 = new SharpVideoMsg();
        ((SharpVideoMsg)localObject3).ver = localUnsupportedEncodingException.getByte("ver");
        ((SharpVideoMsg)localObject3).type = localUnsupportedEncodingException.getByte("type");
        ((SharpVideoMsg)localObject3).from_uin = a(String.valueOf(localUnsupportedEncodingException.getLong("from_uin")));
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Long.valueOf(localUnsupportedEncodingException.getLong("to_uin")));
        ((SharpVideoMsg)localObject3).to_uin = localArrayList;
        ((SharpVideoMsg)localObject3).msg_time = localUnsupportedEncodingException.getLong("msg_time");
        ((SharpVideoMsg)localObject3).msg_type = localUnsupportedEncodingException.getLong("msg_type");
        ((SharpVideoMsg)localObject3).msg_seq = localUnsupportedEncodingException.getLong("msg_seq");
        ((SharpVideoMsg)localObject3).msg_uid = localUnsupportedEncodingException.getLong("msg_uid");
        ((SharpVideoMsg)localObject3).video_buff = localUnsupportedEncodingException.getByteArray("video_buff");
        ((SharpVideoMsg)localObject3).call_type = localUnsupportedEncodingException.getShort("terminal_type");
        ((SharpVideoMsg)localObject3).client_state = a();
        localObject2 = new UniPacket();
        ((UniPacket)localObject2).setServantName("SharpSvr");
        ((UniPacket)localObject2).setFuncName("s2cack");
        ((UniPacket)localObject2).put("SharpVideoMsg", localObject3);
        paramPacket.putWupBuffer(((UniPacket)localObject2).encode());
        paramPacket.addAttribute("stype", Long.valueOf(((SharpVideoMsg)localObject3).msg_type));
        if (((SharpVideoMsg)localObject3).msg_type == 3L)
        {
          VideoConnRateReport.a().a("eVideoSendACK", ((SharpVideoMsg)localObject3).msg_type, ((SharpVideoMsg)localObject3).msg_seq, ((Long)((SharpVideoMsg)localObject3).to_uin.get(0)).longValue(), ((SharpVideoMsg)localObject3).from_uin, 0);
          VideoConnRateReport.a().b();
        }
        if (QLog.isColorLevel()) {
          QLog.i("VideoServlet", 2, "send sharp s2c ack message,cmd=s2cack seq:" + ((SharpVideoMsg)localObject3).msg_seq + " type:" + ((SharpVideoMsg)localObject3).msg_type);
        }
        sendToMSF(paramIntent, paramPacket);
        return;
        paramIntent = new StrupBuff();
        paramIntent.prefix = "";
        localObject3 = new ArrayList();
        localObject2 = ((Bundle)localObject2).getString("vMsg");
        if (localObject2 != null) {}
        try
        {
          ((ArrayList)localObject3).add(((String)localObject2).getBytes("utf-8"));
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("custom_set", localObject3);
          paramIntent.logstring = new HashMap((Map)localObject2);
          paramIntent.encoding = 2;
          paramPacket.setSSOCommand("CliLogSvc.UploadReq");
          paramPacket.setServantName("QQService.CliLogSvc.MainServantObj");
          paramPacket.setFuncName("UploadReq");
          paramPacket.addRequestPacket("Data", paramIntent);
          paramPacket.setNoResponse();
          return;
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
        paramPacket = MsfMsgUtil.getGatewayIpMsg(null);
        paramPacket.setTimeout(30000L);
        paramPacket.setNeedCallback(true);
        paramPacket.setNeedRemindSlowNetwork(false);
        paramPacket.setAppId(this.a.a());
        sendToMSF(paramIntent, paramPacket);
        return;
        paramPacket = MsfMsgUtil.getSetConnStatusMsg(null, ((Bundle)localObject2).getInt("status"));
        paramPacket.setTimeout(30000L);
        paramPacket.setNeedCallback(true);
        paramPacket.setNeedRemindSlowNetwork(false);
        paramPacket.setAppId(this.a.a());
        sendToMSF(paramIntent, paramPacket);
        return;
        paramPacket.setServantName("MultiVideo");
        paramPacket.setFuncName("MultiVideoMsg");
        paramPacket.setSSOCommand("MultiVideo.c2s");
        paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
        paramIntent = new MultiVideoMsg();
        paramIntent.ver = ((Bundle)localObject2).getByte("ver");
        paramIntent.type = ((Bundle)localObject2).getByte("type");
        paramIntent.csCmd = ((Bundle)localObject2).getShort("cscmd");
        paramIntent.from_uin = a(String.valueOf(((Bundle)localObject2).getLong("from_uin")));
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(Long.valueOf(((Bundle)localObject2).getLong("toUin")));
        paramIntent.to_uin = ((ArrayList)localObject3);
        paramIntent.msg_time = ((Bundle)localObject2).getLong("msg_time");
        paramIntent.msg_type = ((Bundle)localObject2).getLong("msg_type");
        paramIntent.msg_seq = ((Bundle)localObject2).getLong("msg_seq");
        paramIntent.msg_uid = ((Bundle)localObject2).getLong("msg_uid");
        paramIntent.video_buff = ((Bundle)localObject2).getByteArray("vMsg");
        paramPacket.addRequestPacket("MultiVideoMsg", paramIntent);
        return;
        paramPacket.setServantName("MultiVideo");
        paramPacket.setFuncName("MultiVideos2cack");
        paramPacket.setSSOCommand("MultiVideo.s2cack");
        paramIntent = new MultiVideoMsg();
        paramIntent.ver = ((Bundle)localObject2).getByte("ver");
        paramIntent.type = ((Bundle)localObject2).getByte("type");
        paramIntent.csCmd = ((Bundle)localObject2).getShort("cscmd");
        paramIntent.subCmd = ((Bundle)localObject2).getShort("subcmd");
        paramIntent.from_uin = a(String.valueOf(((Bundle)localObject2).getLong("from_uin")));
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(Long.valueOf(((Bundle)localObject2).getLong("to_uin")));
        paramIntent.to_uin = ((ArrayList)localObject3);
        paramIntent.msg_time = ((Bundle)localObject2).getLong("msg_time");
        paramIntent.msg_type = ((Bundle)localObject2).getLong("msg_type");
        paramIntent.msg_seq = ((Bundle)localObject2).getLong("msg_seq");
        paramIntent.msg_uid = ((Bundle)localObject2).getLong("msg_uid");
        paramIntent.video_buff = ((Bundle)localObject2).getByteArray("video_buff");
        paramPacket.addRequestPacket("MultiVideoMsg", paramIntent);
        return;
        paramIntent = new Oidb_0x625.Open2Tiny_ReqBody();
        localObject2 = (ArrayList)((Bundle)localObject2).getSerializable("openid_list");
        i = 0;
        while (i < ((ArrayList)localObject2).size())
        {
          localObject3 = new Oidb_0x625.OpenIDInfoReq();
          ((Oidb_0x625.OpenIDInfoReq)localObject3).bytes_openid.set(ByteStringMicro.copyFromUtf8((String)((ArrayList)localObject2).get(i)));
          ((Oidb_0x625.OpenIDInfoReq)localObject3).uint32_acounttype.set(101);
          ((Oidb_0x625.OpenIDInfoReq)localObject3).uint32_appid.set(1600000144);
          paramIntent.msg_openid_req_info.add((MessageMicro)localObject3);
          i += 1;
        }
        localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1573);
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
        paramIntent = ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray();
        localObject2 = new byte[paramIntent.length + 4];
        PkgTools.a((byte[])localObject2, 0, paramIntent.length + 4);
        PkgTools.a((byte[])localObject2, 4, paramIntent, paramIntent.length);
        paramPacket.setSSOCommand("OidbSvc.0x625");
        paramPacket.putSendData((byte[])localObject2);
      } while (!QLog.isColorLevel());
      QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onSend");
      return;
      paramIntent = new Oidb_0x626.Tiny2Open_ReqBody();
      localObject2 = (ArrayList)((Bundle)localObject2).getSerializable("tinyid_list");
      int i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        localObject3 = new Oidb_0x626.TinyIDInfoReq();
        ((Oidb_0x626.TinyIDInfoReq)localObject3).uint64_tinyid.set(((Long)((ArrayList)localObject2).get(i)).longValue());
        paramIntent.msg_tinyid_req_info.add((MessageMicro)localObject3);
        i += 1;
      }
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1574);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
      paramIntent = ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray();
      localObject2 = new byte[paramIntent.length + 4];
      PkgTools.a((byte[])localObject2, 0, paramIntent.length + 4);
      PkgTools.a((byte[])localObject2, 4, paramIntent, paramIntent.length);
      paramPacket.setSSOCommand("OidbSvc.0x626");
      paramPacket.putSendData((byte[])localObject2);
    } while (!QLog.isColorLevel());
    QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onSend");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("VideoServlet", 2, "=====send sharp SharpSvr.c2s!!!! 0xc2=====");
    }
    paramPacket.setServantName("SharpSvr");
    paramPacket.setFuncName("c2s");
    paramPacket.setSSOCommand("SharpSvr.c2s");
    paramPacket.setNoResponse();
    paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
    paramIntent = new SharpVideoMsg();
    paramIntent.ver = 1;
    paramIntent.type = -62;
    paramIntent.from_uin = a(String.valueOf(((Bundle)localObject2).getLong("selfuin")));
    Object localObject3 = new ArrayList();
    ((ArrayList)localObject3).add(Long.valueOf(((Bundle)localObject2).getLong("toUin")));
    paramIntent.to_uin = ((ArrayList)localObject3);
    paramIntent.msg_time = 0L;
    paramIntent.msg_type = 0L;
    paramIntent.msg_seq = 0L;
    paramIntent.msg_uid = 0L;
    paramIntent.video_buff = ((Bundle)localObject2).getByteArray("vMsg");
    paramPacket.addRequestPacket("SharpVideoMsg", paramIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\VideoServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */