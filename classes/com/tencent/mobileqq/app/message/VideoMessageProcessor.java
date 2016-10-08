package com.tencent.mobileqq.app.message;

import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import android.content.Intent;
import com.tencent.av.core.AbstractNetChannel;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm.Msg;
import qmb;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader;

public class VideoMessageProcessor
  extends BaseMessageProcessor
{
  public VideoMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    label69:
    long l1;
    long l2;
    do
    {
      do
      {
        for (;;)
        {
          return;
          C2CType0x211_SubC2CType0xb.MsgBody localMsgBody = new C2CType0x211_SubC2CType0xb.MsgBody();
          try
          {
            paramArrayOfByte = (C2CType0x211_SubC2CType0xb.MsgBody)localMsgBody.mergeFrom(paramArrayOfByte);
            paramArrayOfByte = (C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader)paramArrayOfByte.msg_msg_header.get();
            if (paramArrayOfByte != null) {
              break label69;
            }
            if (QLog.isColorLevel())
            {
              QLog.e("Q.msg.BaseMessageProcessor", 2, "<VideoMessageProcessor><---handle0x2110xbMsg : subMsgType[0xb] MsgHeader failed");
              return;
            }
          }
          catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.msg.BaseMessageProcessor", 2, "<VideoMessageProcessor><---handle0x2110xbMsg : subMsgType[0xb] MsgBody failed", paramArrayOfByte);
      return;
      l1 = paramArrayOfByte.uint64_to_uin.get();
      l2 = paramArrayOfByte.uint64_room_id.get();
      paramArrayOfByte = new Intent();
      paramArrayOfByte.setAction("tencent.video.q2v.AudioEngineReady");
      paramArrayOfByte.putExtra("uin", String.valueOf(l1));
      paramArrayOfByte.putExtra("c2cuin", l1);
      paramArrayOfByte.putExtra("c2croomid", l2);
      this.a.a().sendBroadcast(paramArrayOfByte);
    } while (!QLog.isColorLevel());
    QLog.d("svenxu", 2, "Send video c2c broadcast: selfUin = " + l1 + " " + "roomid = " + l2);
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramArrayOfByte);
  }
  
  public List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    return null;
  }
  
  public qmb a(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return new qmb(null, true);
      if ((paramMsgInfo != null) && (paramSvcReqPushMsg != null))
      {
        a(paramSvcReqPushMsg.lUin, paramMsgInfo.vMsg, paramMsgInfo.lFromUin, (int)paramMsgInfo.uMsgTime);
      }
      else
      {
        a(getClass().getName(), paramInt);
        continue;
        if ((paramMsgInfo != null) && (paramSvcReqPushMsg != null))
        {
          boolean bool = AbstractNetChannel.a(paramMsgInfo.vMsg);
          this.a.a().a(paramSvcReqPushMsg.lUin, paramMsgInfo.vMsg, paramMsgInfo.lFromUin, (int)paramMsgInfo.uMsgTime, bool);
        }
        else
        {
          a(getClass().getName(), paramInt);
        }
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((byte[])paramVarArgs[2], 11);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt)
  {
    if ((!VcSystemInfo.e()) || (!VcSystemInfo.f()))
    {
      if (paramArrayOfByte[2] == 1) {
        VideoMsgTools.a(this.a, 0, 8, true, String.valueOf(paramLong2), String.valueOf(paramLong1), false, null, false, new Object[0]);
      }
      return;
    }
    if (paramArrayOfByte != null) {}
    for (String str = String.valueOf(paramArrayOfByte[2]);; str = "null")
    {
      if (QLog.isColorLevel()) {
        QLog.d("svenxu", 2, "Decode video message: selfUin = " + paramLong1 + " " + "fromUin = " + paramLong2 + " " + "buffer[2] = " + str);
      }
      Friends localFriends = ((FriendsManager)this.a.getManager(50)).c(String.valueOf(paramLong2));
      boolean bool = false;
      Object localObject2;
      Object localObject1;
      short s;
      if (localFriends != null)
      {
        localObject2 = localFriends.name;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).trim().length() != 0) {}
        }
        else
        {
          localObject1 = String.valueOf(paramLong2);
        }
        s = localFriends.faceid;
        bool = localFriends.isFriend();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("svenxu", 2, "isFriend: " + bool);
        }
        localObject2 = new Intent("tencent.video.q2v.RecvVideoCall");
        ((Intent)localObject2).setClassName(this.a.getApplication().getPackageName(), "com.tencent.av.VideoMsgBroadcastReceiver");
        ((Intent)localObject2).putExtra("m2m", false);
        ((Intent)localObject2).putExtra("uin", String.valueOf(paramLong1));
        ((Intent)localObject2).putExtra("fromUin", String.valueOf(paramLong2));
        ((Intent)localObject2).putExtra("faceID", s);
        ((Intent)localObject2).putExtra("buffer", paramArrayOfByte);
        ((Intent)localObject2).putExtra("time", paramInt);
        ((Intent)localObject2).putExtra("name", (String)localObject1);
        ((Intent)localObject2).putExtra("isFriend", bool);
        ((Intent)localObject2).putExtra("isPttRecordingOrPlaying", this.a.q());
        this.a.a().sendBroadcast((Intent)localObject2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("svenxu", 2, "Send video recv broadcast: selfUin = " + paramLong1 + " " + "fromUin = " + paramLong2 + " " + "buffer[2] = " + str);
        return;
        localObject1 = String.valueOf(paramLong2);
        s = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\VideoMessageProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */