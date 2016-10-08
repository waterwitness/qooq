package com.tencent.mobileqq.servlet;

import SharpSvrPack.MultiVideoMsg;
import VideoSvrPack.VideoCallMsg;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.PstnUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioHelper.AudioPlayerParameter;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;
import tencent.im.oidb.cmd0x626.Oidb_0x626.Tiny2Open_ReqBody;
import tencent.im.oidb.cmd0x626.Oidb_0x626.Tiny2Open_RspBody;
import tencent.im.oidb.cmd0x626.Oidb_0x626.TinyIDInfoReq;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class VideoConfigServlet
  extends MSFServlet
{
  private static final int a = 33;
  
  public VideoConfigServlet()
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
        long l = Long.parseLong(paramString);
        if (l >= 10000L) {
          return l;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return 0L;
  }
  
  private void a(VideoCallMsg paramVideoCallMsg)
  {
    boolean bool2 = true;
    int i;
    int j;
    if ((paramVideoCallMsg != null) && (paramVideoCallMsg.vMsg != null))
    {
      int[] arrayOfInt = ConfigSystemImpl.a(paramVideoCallMsg.vMsg);
      if (arrayOfInt != null)
      {
        i = arrayOfInt[0];
        j = arrayOfInt[1];
        if (arrayOfInt[2] != 1) {
          break label232;
        }
        bool1 = true;
        AudioHelper.a(0, new AudioHelper.AudioPlayerParameter(i, j, bool1));
        i = arrayOfInt[3];
        j = arrayOfInt[4];
        if (arrayOfInt[5] != 1) {
          break label238;
        }
        bool1 = true;
        label80:
        AudioHelper.a(1, new AudioHelper.AudioPlayerParameter(i, j, bool1));
        i = arrayOfInt[6];
        j = arrayOfInt[7];
        if (arrayOfInt[8] != 1) {
          break label244;
        }
        bool1 = true;
        label118:
        AudioHelper.a(2, new AudioHelper.AudioPlayerParameter(i, j, bool1));
        i = arrayOfInt[9];
        j = arrayOfInt[10];
        if (arrayOfInt[11] != 1) {
          break label250;
        }
      }
    }
    label232:
    label238:
    label244:
    label250:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      AudioHelper.a(3, new AudioHelper.AudioPlayerParameter(i, j, bool1));
      if (ConfigSystemImpl.a(String.valueOf(AppSetting.a), getAppRuntime().getApplication(), paramVideoCallMsg.vMsg))
      {
        paramVideoCallMsg = new Intent("tencent.video.q2v.UpdateConfig");
        paramVideoCallMsg.putExtra("uin", getAppRuntime().getAccount());
        getAppRuntime().getApplication().sendBroadcast(paramVideoCallMsg);
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label80;
      bool1 = false;
      break label118;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (paramIntent != null)
    {
      if (!"VideoCCSvc.Adaptation".equalsIgnoreCase(str)) {
        break label79;
      }
      if (!paramFromServiceMsg.isSuccess()) {
        break label64;
      }
      a((VideoCallMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "VideoCallMsg", new VideoCallMsg()));
      if (QLog.isColorLevel()) {
        QLog.d("svenxu", 2, "VideoConfigServlet receive resp: result = success");
      }
    }
    label63:
    label64:
    label79:
    label326:
    do
    {
      do
      {
        do
        {
          break label63;
          break label63;
          for (;;)
          {
            return;
            if (QLog.isColorLevel())
            {
              QLog.d("svenxu", 2, "VideoConfigServlet receive resp: result = failed");
              return;
              if (!"OidbSvc.0x626".equalsIgnoreCase(str)) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("CMD_OIDB_0x626", 2, "CMD_OIDB_0x626 onReceive");
              }
              if (!paramFromServiceMsg.isSuccess()) {
                break label326;
              }
              try
              {
                int i = paramFromServiceMsg.getWupBuffer().length - 4;
                paramIntent = new byte[i];
                PkgTools.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
                paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
                paramFromServiceMsg.mergeFrom(paramIntent);
                if (paramFromServiceMsg.uint32_result.get() != 0)
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("CMD_OIDB_0x626", 2, "CMD_OIDB_0x626 onReceive uint32_result = " + paramFromServiceMsg.uint32_result.get());
                }
              }
              catch (Exception paramIntent)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("CMD_OIDB_0x626", 2, "CMD_OIDB_0x626 onReceive Exception!");
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
        if (QLog.isColorLevel()) {
          QLog.d("CMD_OIDB_0x626", 2, "CMD_OIDB_0x626 onReceive list = " + paramIntent.toString());
        }
        new ArrayList();
        paramIntent = PstnUtils.a(paramIntent);
        paramFromServiceMsg = (QQAppInterface)getAppRuntime();
      } while (paramFromServiceMsg == null);
      paramFromServiceMsg.a().b(paramIntent);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("CMD_OIDB_0x626", 2, "CMD_OIDB_0x626 onReceive not success!");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("svenxu", 2, "VideoConfigServlet send request.");
    }
    Object localObject1 = paramIntent.getExtras();
    if (localObject1 == null) {}
    do
    {
      return;
      int i = ((Bundle)localObject1).getInt("reqType", 0);
      Object localObject2;
      if (i == 8)
      {
        paramPacket.setServantName("MultiVideo");
        paramPacket.setFuncName("MultiVideoMsg");
        paramPacket.setSSOCommand("MultiVideo.c2s");
        paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
        paramIntent = new MultiVideoMsg();
        paramIntent.ver = ((Bundle)localObject1).getByte("ver");
        paramIntent.type = ((Bundle)localObject1).getByte("type");
        paramIntent.csCmd = ((Bundle)localObject1).getShort("cscmd");
        paramIntent.from_uin = a(String.valueOf(((Bundle)localObject1).getLong("from_uin")));
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(Long.valueOf(((Bundle)localObject1).getLong("toUin")));
        paramIntent.to_uin = ((ArrayList)localObject2);
        paramIntent.msg_time = ((Bundle)localObject1).getLong("msg_time");
        paramIntent.msg_type = ((Bundle)localObject1).getLong("msg_type");
        paramIntent.msg_seq = ((Bundle)localObject1).getLong("msg_seq");
        paramIntent.msg_uid = ((Bundle)localObject1).getLong("msg_uid");
        paramIntent.video_buff = ((Bundle)localObject1).getByteArray("vMsg");
        paramPacket.addRequestPacket("MultiVideoMsg", paramIntent);
        return;
      }
      if (i != 15) {
        break;
      }
      paramIntent = new Oidb_0x626.Tiny2Open_ReqBody();
      localObject1 = (ArrayList)((Bundle)localObject1).getSerializable("tinyid_list");
      i = 0;
      while (i < ((ArrayList)localObject1).size())
      {
        localObject2 = new Oidb_0x626.TinyIDInfoReq();
        ((Oidb_0x626.TinyIDInfoReq)localObject2).uint64_tinyid.set(((Long)((ArrayList)localObject1).get(i)).longValue());
        paramIntent.msg_tinyid_req_info.add((MessageMicro)localObject2);
        i += 1;
      }
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1574);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
      paramIntent = ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray();
      localObject1 = new byte[paramIntent.length + 4];
      PkgTools.a((byte[])localObject1, 0, paramIntent.length + 4);
      PkgTools.a((byte[])localObject1, 4, paramIntent, paramIntent.length);
      paramPacket.setSSOCommand("OidbSvc.0x626");
      paramPacket.putSendData((byte[])localObject1);
    } while (!QLog.isColorLevel());
    QLog.d("CMD_OIDB_0x626", 2, "CMD_OIDB_0x626 onSend");
    return;
    paramPacket.setServantName("VideoSvc");
    paramPacket.setFuncName("SendVideoMsg");
    paramPacket.setSSOCommand("VideoCCSvc.Adaptation");
    paramIntent = new VideoCallMsg();
    paramIntent.ver = 1;
    paramIntent.type = 1;
    paramIntent.lUin = a(getAppRuntime().getAccount());
    paramIntent.lPeerUin = 0L;
    paramIntent.uDateTime = ((int)(System.currentTimeMillis() / 1000L));
    paramIntent.cVerifyType = 0;
    paramIntent.uSeqId = 0;
    paramIntent.uSessionId = 0;
    paramIntent.vMsg = ConfigSystemImpl.a(paramIntent.lUin, String.valueOf(AppSetting.a), getAppRuntime().getApplication());
    paramPacket.addRequestPacket("VideoCallMsg", paramIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\servlet\VideoConfigServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */