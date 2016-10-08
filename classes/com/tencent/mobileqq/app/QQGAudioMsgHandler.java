package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.service.QavWrapper;
import com.tencent.av.ui.SysCallTransparentActivity;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.VideoConfigServlet;
import com.tencent.mobileqq.troop.utils.TroopVideoManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.GroupVideoWrapper;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.NewIntent;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import qeu;
import qev;
import qew;
import qex;
import qey;
import qez;
import qfa;
import qfb;
import tencent.im.groupvideo.s2c.gv_pstn_bill.GroupVideoS2CBody;
import tencent.im.groupvideo.s2c.gv_pstn_bill.S2CNotifyBillReq;
import tencent.im.msg.im_msg_body.MsgBody;

public class QQGAudioMsgHandler
  implements Handler.Callback
{
  static final int jdField_a_of_type_Int = 141;
  static final String jdField_a_of_type_JavaLangString = "QQGAudioMsgHandler";
  static ArrayList jdField_a_of_type_JavaUtilArrayList;
  static final int jdField_b_of_type_Int = 195;
  private static final String jdField_b_of_type_JavaLangString = "com.tencent.mobileqq:video";
  static ArrayList jdField_b_of_type_JavaUtilArrayList;
  static final int c = 149;
  static final int d = 49;
  static final int e = 59;
  static final int f = 7;
  static final int g = 1025;
  Handler jdField_a_of_type_AndroidOsHandler;
  AVNotifyCenter jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  Vector jdField_a_of_type_JavaUtilVector = new Vector();
  boolean jdField_a_of_type_Boolean = false;
  public byte[] a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    try
    {
      jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg create successful!");
      }
      try
      {
        b = new ArrayList();
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioMsgHandler", 2, "sCacheMsgList create successful!");
        }
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public QQGAudioMsgHandler(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ArrayOfByte = new byte['ª'];
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt)
  {
    int k = 0;
    int j = 0;
    int i = j;
    if (paramArrayOfByte.length == paramInt)
    {
      if (paramArrayOfByte.length > 4) {
        i = j;
      }
    }
    else {
      return i;
    }
    j = paramInt - 1;
    paramInt = k;
    for (;;)
    {
      i = paramInt;
      if (j < 0) {
        break;
      }
      paramInt = (int)(paramInt | (paramArrayOfByte[j] & 0xFF) << j * 8);
      j -= 1;
    }
  }
  
  private void k(byte[] paramArrayOfByte)
  {
    int i = 0;
    Object localObject = new byte[1];
    System.arraycopy(paramArrayOfByte, 11, localObject, 0, 1);
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvRoomDestroy-->CAuthType = " + localObject);
    }
    if (localObject[0] != 3) {
      return;
    }
    localObject = BaseApplication.getContext();
    long l = this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a();
    int j = this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a();
    if (l > 0L) {
      i = this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.b(l);
    }
    if ((j == 1) && (i == 2))
    {
      new GroupVideoWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(new qey(this, paramArrayOfByte));
      return;
    }
    new QavWrapper((Context)localObject).a(new qez(this, paramArrayOfByte));
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaUtilVector != null) {
      this.jdField_a_of_type_JavaUtilVector.clear();
    }
    if ((jdField_a_of_type_JavaUtilArrayList == null) || (jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is empty!");
      }
    }
    do
    {
      return;
      jdField_a_of_type_JavaUtilArrayList.clear();
    } while (!QLog.isColorLevel());
    QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is clear in clearOnLineQueue");
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, long paramLong4)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoLevelUpgrade");
      localIntent.putExtra("type", paramInt1);
      localIntent.putExtra("fromUin", paramLong1);
      localIntent.putExtra("toUin", paramLong2);
      localIntent.putExtra("enable", paramInt2);
      localIntent.putExtra("level", paramInt3);
      localIntent.putExtra("seq", paramLong3);
      localIntent.putExtra("groupId", paramLong4);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoGift");
      localIntent.putExtra("type", paramInt1);
      localIntent.putExtra("fromUin", paramLong1);
      localIntent.putExtra("toUin", paramLong2);
      localIntent.putExtra("count", paramInt2);
      localIntent.putExtra("seq", paramLong3);
      localIntent.putExtra("groupId", paramLong4);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, long[] paramArrayOfLong, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvGroupVideoMemberNumber-->relationType=" + paramInt1 + " relationId=" + paramString + " memNum=" + paramInt2 + " avtype=" + paramInt3);
    }
    if (paramInt2 <= 0) {}
    for (int i = 23;; i = 21)
    {
      long l = Long.parseLong(paramString);
      AVNotifyCenter.VideoRoomInfo localVideoRoomInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
      if ((localVideoRoomInfo != null) && (localVideoRoomInfo.a > 0) && (paramInt2 == 0)) {
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(1, l, null, localVideoRoomInfo.a);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l, paramInt3, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.parseLong(paramString), paramInt3, i, paramInt2);
      if (paramInt2 == 0)
      {
        a(Long.valueOf(paramString).longValue(), paramInt3);
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 1, Long.valueOf(paramString).longValue(), 0L);
        paramArrayOfLong = new Intent();
        paramArrayOfLong.setAction("tencent.video.q2v.membersChange");
        paramArrayOfLong.putExtra("relationType", 1);
        paramArrayOfLong.putExtra("avtype", paramInt3);
        paramArrayOfLong.putExtra("relationId", Long.valueOf(paramString).longValue());
        if (paramInt2 != 0) {
          break label375;
        }
        paramArrayOfLong.putExtra("Exit", true);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramArrayOfLong);
        return;
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(1, Long.valueOf(paramString).longValue(), paramArrayOfLong, paramInt2);
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(Long.valueOf(paramString).longValue(), paramInt3);
        if ((paramInt3 == 2) && (paramInt1 == 1) && (((TroopVideoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163)).a(paramString) == 1)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.parseLong(paramString), true);
        }
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 1, Long.valueOf(paramString).longValue(), 0L);
        break;
        label375:
        paramArrayOfLong.putExtra("Exit", false);
      }
    }
  }
  
  void a(int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "showDevNotSurportMsg-->MsgType" + paramInt);
    }
    if (paramInt == 141)
    {
      paramInt = paramArrayOfByte[10];
      arrayOfByte = new byte[4];
      System.arraycopy(paramArrayOfByte, (paramInt & 0xFF) + 34, arrayOfByte, 0, 4);
      paramInt = a(arrayOfByte, 4);
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, 18, false, String.valueOf(paramInt), paramArrayOfByte, false, null, false, new Object[0]);
    }
    while (paramInt != 7) {
      return;
    }
    paramInt = (paramArrayOfByte[10] & 0xFF) + 19;
    byte[] arrayOfByte = new byte[8];
    System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 0, 8);
    VideoController.a(arrayOfByte, 8);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, paramInt + 12, arrayOfByte, 0, 4);
    paramInt = a(arrayOfByte, 4);
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 18, false, String.valueOf(paramInt), paramArrayOfByte, false, null, false, new Object[0]);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoRankListUpdate");
      localIntent.putExtra("groupId", paramLong);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioMsgHandler", 2, "onGroupChatRoomDestroy-->can not get mNotifycenter or mapp");
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(1, paramLong) > 0L)
      {
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(1, paramLong, null, 0L);
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 14, false, String.valueOf(paramLong), str, false, null, false, paramInt, new Object[0]);
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 1, paramLong, 0L);
      }
      while (paramInt == 2)
      {
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(paramLong, false);
        return;
        if (QLog.isColorLevel()) {
          QLog.w("QQGAudioMsgHandler", 2, "MultiRoomMemberNum is 0");
        }
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(23, 1, paramLong, 0L);
      }
    }
  }
  
  void a(long paramLong, int paramInt, byte paramByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    byte[] arrayOfByte = new byte[33];
    arrayOfByte[0] = ((byte)0);
    arrayOfByte[1] = ((byte)48);
    long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
    int i = 0;
    while (i < 8)
    {
      arrayOfByte[(i + 2)] = ((byte)(int)(l >> (7 - i) * 8 & 0xFF));
      i += 1;
    }
    arrayOfByte[10] = 0;
    arrayOfByte[11] = 0;
    arrayOfByte[12] = 0;
    arrayOfByte[13] = 0;
    arrayOfByte[14] = 0;
    arrayOfByte[15] = ((byte)paramInt);
    arrayOfByte[16] = 4;
    paramInt = 0;
    while (paramInt < 4)
    {
      arrayOfByte[(paramInt + 17)] = ((byte)(int)(paramLong >> (3 - paramInt) * 8 & 0xFF));
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < 8)
    {
      arrayOfByte[(paramInt + 21)] = ((byte)(int)(531L >> (7 - paramInt) * 8 & 0xFF));
      paramInt += 1;
    }
    arrayOfByte[29] = 0;
    arrayOfByte[30] = 0;
    arrayOfByte[31] = 0;
    arrayOfByte[32] = paramByte;
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), VideoConfigServlet.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("cscmd", (short)462);
    localNewIntent.putExtra("selfuin", l);
    localNewIntent.putExtra("toUin", paramLong);
    localNewIntent.putExtra("vMsg", arrayOfByte);
    localNewIntent.putExtra("reqType", 8);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoMemRejectInvite");
      localIntent.putExtra("groupId", paramLong1);
      localIntent.putExtra("dealMemUin", paramLong2);
      localIntent.putExtra("invitedId", paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.KickOutVisitor");
      localIntent.putExtra("groupId", paramLong);
      localIntent.putExtra("isAllVisitor", paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GVideoMedalChange");
      localIntent.putExtra("jsonString", paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[2];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 2);
    int i = arrayOfByte[0];
    i = (arrayOfByte[1] & 0xFF) << 0 | (i & 0xFF) << 8;
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoS2CData: msgType = " + i);
    }
    if (!a()) {
      if ((141 == i) || (7 == i)) {
        a(i, paramArrayOfByte);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (i)
            {
            default: 
              return;
            }
          } while (this.jdField_a_of_type_ArrayOfByte == null);
          i = paramArrayOfByte.length;
        } while (i < 40);
        if (this.jdField_a_of_type_ArrayOfByte.length < i) {
          this.jdField_a_of_type_ArrayOfByte = new byte[i];
        }
        System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, i);
        g(paramArrayOfByte);
        return;
        a(paramArrayOfByte, 27);
        return;
      } while (this.jdField_a_of_type_ArrayOfByte == null);
      i = paramArrayOfByte.length;
    } while (i < 40);
    if (this.jdField_a_of_type_ArrayOfByte.length < i) {
      this.jdField_a_of_type_ArrayOfByte = new byte[i];
    }
    System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, i);
    f(this.jdField_a_of_type_ArrayOfByte);
    return;
    e(paramArrayOfByte);
    return;
    k(paramArrayOfByte);
    return;
    h(paramArrayOfByte);
  }
  
  void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "sendRoomInfoBroadcast");
    }
    Intent localIntent = new Intent("tencent.video.q2v.MultiVideo");
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localIntent.putExtra("type", paramInt);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("buffer", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
  }
  
  public void a(byte[] paramArrayOfByte, msg_comm.Msg paramMsg)
  {
    if (!a()) {}
    Object localObject;
    long l2;
    String str;
    do
    {
      int j;
      int k;
      int m;
      do
      {
        do
        {
          return;
          localObject = new byte[2];
          System.arraycopy(paramArrayOfByte, 0, localObject, 0, 2);
          i = localObject[0];
          i = (localObject[1] & 0xFF) << 0 | (i & 0xFF) << 8;
        } while ((i != 141) && (i != 7));
        j = (paramArrayOfByte[10] & 0xFF) + 19;
        localObject = new byte[8];
        System.arraycopy(paramArrayOfByte, j, localObject, 0, 8);
        l1 = VideoController.a((byte[])localObject, 8);
        k = j + 8;
        localObject = new byte[4];
        System.arraycopy(paramArrayOfByte, k, localObject, 0, 4);
        j = VideoController.a((byte[])localObject, 4);
        k += 4;
        localObject = new byte[2];
        System.arraycopy(paramArrayOfByte, k, localObject, 0, 2);
        m = localObject[0];
        m = (localObject[1] & 0xFF) << 0 | (m & 0xFF) << 8;
        if (i == 7)
        {
          paramMsg = new byte[4];
          System.arraycopy(paramArrayOfByte, k, paramMsg, 0, 4);
          l2 = VideoController.a(paramMsg, 4);
          VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 13, true, Long.toString(l2), Long.toString(l1), false, null, false, j, new Object[0]);
          this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(l2, j);
          ((TroopVideoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163)).a(l2);
          this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(l2, 1, 2, true);
          return;
        }
        if ((m == 1) || (m == 2) || (m == 3)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQGAudioMsgHandler", 2, "unsupport relationship");
      return;
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, k + 3, localObject, 0, 4);
      i = a((byte[])localObject, 4);
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "GAudioOfflineMsg discussId is:" + i);
      }
      str = Integer.toString(i);
      localObject = Long.toString(l1);
      if (1 == m)
      {
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 13, false, str, (String)localObject, false, null, false, j, new Object[0]);
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(i, 1, 10, true);
        return;
      }
      if (3 != m) {
        break label656;
      }
      paramArrayOfByte = str;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(localObject)) {
        paramArrayOfByte = (byte[])localObject;
      }
      if (!TextUtils.isEmpty(paramArrayOfByte)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQGAudioMsgHandler", 2, "GAudioOfflineMsg friendUin is empty!");
    return;
    long l1 = 0L;
    if (paramMsg != null) {
      l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    }
    if ((l1 > 0L) && (l1 - NetConnInfoCenter.getServerTime() - 60000L > 0L)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, 6, true, paramArrayOfByte, (String)localObject, false, null, false, new Object[] { paramMsg });
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "GAudioOfflineMsg double meeting friendUin is:" + paramArrayOfByte);
      }
      l2 = l1;
      if (l1 == 0L) {
        l2 = MessageCache.a();
      }
      if ((jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_AndroidOsHandler == null)) {
        break;
      }
      jdField_a_of_type_JavaUtilArrayList.add(new qfa(paramMsg, Long.valueOf(paramArrayOfByte).longValue(), l2));
      a(Long.valueOf(paramArrayOfByte).longValue(), 4, (byte)8);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 10000L);
      return;
      label656:
      paramMsg = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(localObject))) {
        paramMsg.a(1, i, (String)localObject);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(i, 2, 0, true);
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, 13, false, str, (String)localObject, false, null, false, new Object[0]);
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        i(paramArrayOfByte);
        return;
        if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(2, i) <= 0L) {
          paramMsg.a(str, (String)localObject);
        }
      }
      if (this.jdField_a_of_type_JavaUtilVector == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilVector.add(paramArrayOfByte);
      return;
    }
  }
  
  boolean a()
  {
    if ((!VcSystemInfo.e()) || (!VcSystemInfo.f()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "device not surpport Sharp audio");
      }
      return false;
    }
    return true;
  }
  
  void b(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(2, paramLong) <= 0L) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(2, paramLong, null, 0L);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 2, paramLong, 0L);
    ((QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37)).a(paramLong);
    ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(paramLong);
    VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, 14, false, String.valueOf(paramLong), str, false, null, false, new Object[0]);
  }
  
  public void b(long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoMemUntInvite");
      localIntent.putExtra("groupId", paramLong1);
      localIntent.putExtra("dealMemUin", paramLong2);
      localIntent.putExtra("invitedId", paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.ChangeVisitorSpeakMode");
      localIntent.putExtra("groupId", paramLong);
      localIntent.putExtra("visitorSpeakEnabled", paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    Object localObject = new byte[2];
    System.arraycopy(paramArrayOfByte, 0, localObject, 0, 2);
    int i = localObject[0];
    if (((localObject[1] & 0xFF) << 0 | (i & 0xFF) << 8) == 49) {
      d(paramArrayOfByte);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject = new Intent("tencent.video.q2v.MultiVideo");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      ((Intent)localObject).putExtra("type", 30);
      ((Intent)localObject).putExtra("buffer", paramArrayOfByte);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast((Intent)localObject);
    }
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localObject != null) {
        Long.valueOf((String)localObject).longValue();
      }
    }
    Object localObject = new byte[2];
    System.arraycopy(paramArrayOfByte, 8, localObject, 0, 2);
    int n = (localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0;
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->tlvNum=" + n);
    }
    byte[] arrayOfByte1 = new byte[4];
    byte[] arrayOfByte2 = new byte[8];
    int i = 10;
    int k = 0;
    if (k < n)
    {
      System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
      i += 2;
      switch ((localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0)
      {
      default: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
        for (;;)
        {
          k += 1;
          break;
          i += 2;
          System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 4);
          i += 4;
          VideoController.a(arrayOfByte1, 4);
          continue;
          i += 6;
          continue;
          System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
          i = i + 2 + ((localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0);
          continue;
          i += 10;
          continue;
          i += 6;
          continue;
          i += 6;
          continue;
          i += 6;
          continue;
          System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
          i = i + 2 + ((localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0);
          continue;
          i += 6;
        }
      }
      System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
      int i1 = ((localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0) / 8;
      long[] arrayOfLong = new long[i1];
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->userNum=" + i1);
      }
      j = i + 2;
      int m = 0;
      for (;;)
      {
        i = j;
        if (m >= i1) {
          break;
        }
        System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 8);
        VideoController.a(arrayOfByte2, 8);
        m += 1;
        j += 8;
      }
    }
    System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
    int j = (localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0;
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->wReverseLen=" + j);
    }
    localObject = new byte[j];
    System.arraycopy(paramArrayOfByte, i + 2, localObject, 0, j);
    long l1 = VideoController.a((byte[])localObject, j);
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->uin=" + l1);
    }
    long l2;
    if (paramInt != 0)
    {
      if ((jdField_a_of_type_JavaUtilArrayList != null) && (!jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->msgList size=" + jdField_a_of_type_JavaUtilArrayList.size());
        }
        paramInt = 0;
        while (paramInt < jdField_a_of_type_JavaUtilArrayList.size())
        {
          paramArrayOfByte = (qfa)jdField_a_of_type_JavaUtilArrayList.get(paramInt);
          if ((paramArrayOfByte != null) && (paramArrayOfByte.jdField_a_of_type_Long == l1) && (paramArrayOfByte.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)))
          {
            localObject = new byte[8];
            arrayOfByte1 = ((im_msg_body.MsgBody)paramArrayOfByte.jdField_a_of_type_MsfMsgcommMsg_comm$Msg.msg_body.get()).msg_content.get().toByteArray();
            System.arraycopy(arrayOfByte1, (arrayOfByte1[10] & 0xFF) + 19, localObject, 0, 8);
            l2 = VideoController.a((byte[])localObject, 8);
            VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, 6, true, Long.toString(l1), Long.toString(l2), false, null, false, new Object[] { paramArrayOfByte.jdField_a_of_type_MsfMsgcommMsg_comm$Msg });
          }
          paramInt += 1;
        }
      }
    }
    else {
      if ((jdField_a_of_type_JavaUtilArrayList != null) && (!jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
        break label858;
      }
    }
    label858:
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->msgList size=" + jdField_a_of_type_JavaUtilArrayList.size());
          }
          paramArrayOfByte = new ArrayList();
          paramInt = 0;
          while (paramInt < jdField_a_of_type_JavaUtilArrayList.size())
          {
            localObject = (qfa)jdField_a_of_type_JavaUtilArrayList.get(paramInt);
            if ((localObject != null) && (((qfa)localObject).jdField_a_of_type_Long == l1) && (((qfa)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))) {
              paramArrayOfByte.add(localObject);
            }
            paramInt += 1;
          }
          Collections.sort(paramArrayOfByte, new qfb());
          paramInt = 0;
          while (paramInt < paramArrayOfByte.size() - 1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->list =" + ((qfa)paramArrayOfByte.get(paramInt)).b);
            }
            localObject = (qfa)paramArrayOfByte.get(paramInt);
            arrayOfByte1 = new byte[8];
            arrayOfByte2 = ((im_msg_body.MsgBody)((qfa)localObject).jdField_a_of_type_MsfMsgcommMsg_comm$Msg.msg_body.get()).msg_content.get().toByteArray();
            System.arraycopy(arrayOfByte2, (arrayOfByte2[10] & 0xFF) + 19, arrayOfByte1, 0, 8);
            l2 = VideoController.a(arrayOfByte1, 8);
            VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, 6, true, Long.toString(l1), Long.toString(l2), false, null, false, new Object[] { ((qfa)localObject).jdField_a_of_type_MsfMsgcommMsg_comm$Msg });
            paramInt += 1;
          }
        } while (paramArrayOfByte.size() <= 0);
        paramArrayOfByte = ((im_msg_body.MsgBody)((qfa)paramArrayOfByte.get(paramArrayOfByte.size() - 1)).jdField_a_of_type_MsfMsgcommMsg_comm$Msg.msg_body.get()).msg_content.get().toByteArray();
      } while (this.jdField_a_of_type_ArrayOfByte == null);
      paramInt = paramArrayOfByte.length;
    } while (paramInt < 40);
    if (this.jdField_a_of_type_ArrayOfByte.length < paramInt) {
      this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
    }
    System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, paramInt);
    f(this.jdField_a_of_type_ArrayOfByte);
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (!a()) {}
    byte[] arrayOfByte1;
    Object localObject3;
    byte[] arrayOfByte2;
    Object localObject1;
    int i4;
    do
    {
      do
      {
        return;
        arrayOfByte1 = new byte[2];
        localObject3 = new byte[4];
        arrayOfByte2 = new byte[8];
        localObject1 = null;
      } while ((arrayOfByte1 == null) || (localObject3 == null) || (arrayOfByte2 == null));
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, 2);
      i4 = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
    } while (i4 < 4);
    int k = 2;
    int j = 0;
    int i = 0;
    int i1 = 0;
    int m = 0;
    label95:
    if (i1 < i4)
    {
      System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, 2);
      k += 2;
      switch ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0)
      {
      }
    }
    for (;;)
    {
      i1 += 1;
      break label95;
      k += 2;
      System.arraycopy(paramArrayOfByte, k, localObject3, 0, 4);
      j = VideoController.a((byte[])localObject3, 4);
      k += 4;
      continue;
      k += 2;
      System.arraycopy(paramArrayOfByte, k, localObject3, 0, 4);
      i = VideoController.a((byte[])localObject3, 4);
      if (i == 0)
      {
        b(j);
        paramArrayOfByte = new Intent();
        paramArrayOfByte.setAction("tencent.video.q2v.membersChange");
        paramArrayOfByte.putExtra("relationType", 2);
        paramArrayOfByte.putExtra("relationId", j);
        paramArrayOfByte.putExtra("Exit", true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramArrayOfByte);
        return;
        k += 6;
        continue;
        System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, 2);
        m = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
        if (m <= 0) {
          break;
        }
        int i3 = m / 8;
        Object localObject2 = new long[i3];
        int n = k + 2;
        int i2 = 0;
        for (;;)
        {
          m = i3;
          k = n;
          localObject1 = localObject2;
          if (i2 >= i3) {
            break;
          }
          System.arraycopy(paramArrayOfByte, n, arrayOfByte2, 0, 8);
          localObject2[i2] = VideoController.a(arrayOfByte2, 8);
          i2 += 1;
          n += 8;
        }
        System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, 2);
        i2 = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioMsgHandler", 2, "TLV-NUMBER = " + i2);
        }
        localObject2 = new int[m];
        localObject3 = new int[m];
        n = 0;
        k += 2;
        if (n < i2)
        {
          System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, 2);
          i1 = k + 2;
          k = arrayOfByte1[0];
          i4 = arrayOfByte1[1];
          System.arraycopy(paramArrayOfByte, i1, arrayOfByte1, 0, 2);
          i1 += 2;
          i3 = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
          switch ((k & 0xFF) << 8 | (i4 & 0xFF) << 0)
          {
          default: 
            k = i1 + i3;
          }
          for (;;)
          {
            n += 1;
            break;
            k = i1;
            if (i3 == m)
            {
              System.arraycopy(paramArrayOfByte, i1, arrayOfByte1, 0, i3);
              k = 0;
              while (k < i3)
              {
                localObject2[k] = arrayOfByte1[k];
                k += 1;
              }
              k = i1 + i3;
              continue;
              k = i1;
              if (i3 == m)
              {
                System.arraycopy(paramArrayOfByte, i1, arrayOfByte1, 0, i3);
                k = 0;
                while (k < i3)
                {
                  localObject3[k] = arrayOfByte1[k];
                  k += 1;
                }
                k = i1 + i3;
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioMsgHandler", 2, "onRecvAppTipMsgData --> roomUserNum = " + i + " ,qqUserLen = " + m);
        }
        if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter == null) {
          break;
        }
        long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
        if ((i == 1) && (l == localObject1[0]) && (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a() == 0L))
        {
          if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(2, j) != 0L) {
            break;
          }
          a(j, 1, (byte)1);
          return;
        }
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(2, j, (long[])localObject1, (int[])localObject2, i);
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 2, j, 0L);
        paramArrayOfByte = new Intent();
        paramArrayOfByte.setAction("tencent.video.q2v.membersChange");
        paramArrayOfByte.putExtra("relationType", 2);
        paramArrayOfByte.putExtra("relationId", j);
        paramArrayOfByte.putExtra("Exit", false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramArrayOfByte);
        return;
      }
      k += 4;
    }
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31");
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter == null) {
      return;
    }
    Object localObject1 = null;
    Object localObject2;
    long l1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        l1 = Long.valueOf((String)localObject2).longValue();
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      byte[] arrayOfByte1 = new byte[2];
      byte[] arrayOfByte2 = new byte[4];
      byte[] arrayOfByte3 = new byte[8];
      if ((arrayOfByte1 == null) || (arrayOfByte2 == null) || (arrayOfByte3 == null)) {
        break;
      }
      System.arraycopy(paramArrayOfByte, 2, arrayOfByte2, 0, 4);
      int i = VideoController.a(arrayOfByte2, 4);
      if (i != 0)
      {
        localObject1 = new byte[2];
        System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 2, localObject1, 0, 2);
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->wR0=" + localObject1[0] + " wR1=" + localObject1[1]);
        }
        if (localObject1[0] == 3)
        {
          b(paramArrayOfByte, i);
          return;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31 error retCode = " + i);
        return;
      }
      localObject2 = new byte[2];
      System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 2, localObject2, 0, 2);
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-->wR0=" + localObject2[0] + " wR1=" + localObject2[1]);
      }
      int k;
      int j;
      int m;
      if (localObject2[0] == 1)
      {
        k = 1;
        System.arraycopy(paramArrayOfByte, 8, arrayOfByte1, 0, 2);
        int i3 = arrayOfByte1[0];
        int i4 = arrayOfByte1[1];
        i = 0;
        j = 10;
        m = 0;
        localObject2 = null;
        label325:
        if (m < ((i3 & 0xFF) << 8 | (i4 & 0xFF) << 0))
        {
          System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
          j += 2;
        }
      }
      else
      {
        switch ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0)
        {
        default: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
          for (;;)
          {
            m += 1;
            break label325;
            if (localObject2[0] == 2)
            {
              k = 2;
              break;
            }
            if (localObject2[0] == 3)
            {
              b(paramArrayOfByte, i);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.e("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-->wrong relation type=" + localObject2[0]);
            }
            k = 2;
            break;
            i = j + 2;
            System.arraycopy(paramArrayOfByte, i, arrayOfByte2, 0, 4);
            j = i + 4;
            i = VideoController.a(arrayOfByte2, 4);
            continue;
            j += 6;
            continue;
            System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
            j = j + 2 + ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0);
            continue;
            j += 10;
            continue;
            j += 6;
            continue;
            j += 6;
            continue;
            j += 6;
            continue;
            System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
            j = j + 2 + ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0);
            continue;
            j += 6;
          }
        }
        System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
        j += 2;
        int i5 = ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0) / 8;
        localObject2 = new long[i5];
        int i1 = 0;
        int n = 0;
        while (n < i5)
        {
          System.arraycopy(paramArrayOfByte, j, arrayOfByte3, 0, 8);
          int i2 = j + 8;
          long l2 = VideoController.a(arrayOfByte3, 8);
          localObject2[n] = l2;
          j = i1;
          if (l2 == l1)
          {
            j = i1;
            if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a() == 0L)
            {
              j = i1;
              if (0L == this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(k, i)) {
                j = 1;
              }
            }
          }
          n += 1;
          i1 = j;
          j = i2;
        }
        String str;
        if (i1 != 0)
        {
          str = Integer.toString(i);
          if (k != 2) {
            break label905;
          }
        }
        label905:
        for (n = 3000;; n = 1)
        {
          VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, n, 13, false, str, (String)localObject1, true, null, true, new Object[0]);
          break;
        }
      }
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(k, i, (long[])localObject2);
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, k, i, 0L);
      return;
      l1 = 0L;
    }
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoS2C_0x95");
    }
    if (!a()) {}
    int i;
    do
    {
      return;
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
      localByteBuffer.getShort();
      localByteBuffer.getLong();
      int n = localByteBuffer.getShort();
      long l1 = 0L;
      i = 0;
      int k;
      int m;
      int i2;
      if (n > 0)
      {
        j = 0;
        while (j < n)
        {
          i1 = localByteBuffer.getShort();
          paramArrayOfByte = null;
          k = 0;
          if (k < i1)
          {
            m = localByteBuffer.getShort();
            i2 = localByteBuffer.getShort();
            switch (m)
            {
            default: 
              localByteBuffer.get(new byte[i2], 0, i2);
            }
            for (;;)
            {
              k += 1;
              break;
              l1 = localByteBuffer.getInt();
              continue;
              i = localByteBuffer.getInt();
              continue;
              localByteBuffer.getInt();
              continue;
              paramArrayOfByte = new long[i2 / 8];
              m = 0;
              while (m < i2 / 8)
              {
                paramArrayOfByte[m] = localByteBuffer.getLong();
                m += 1;
              }
              continue;
              localByteBuffer.getInt();
              continue;
              localByteBuffer.getInt();
            }
          }
          this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(2, l1, paramArrayOfByte, i);
          this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 2, l1, 0L);
          j += 1;
        }
      }
      n = localByteBuffer.getShort();
      l1 = 0L;
      i = 0;
      long l2 = l1;
      if (n > 0)
      {
        j = 0;
        for (;;)
        {
          l2 = l1;
          if (j >= n) {
            break;
          }
          i1 = localByteBuffer.getShort();
          k = 0;
          if (k < i1)
          {
            m = localByteBuffer.getShort();
            i2 = localByteBuffer.getShort();
            switch (m)
            {
            default: 
              localByteBuffer.get(new byte[i2], 0, i2);
            }
            for (;;)
            {
              k += 1;
              break;
              l1 = localByteBuffer.getInt();
              continue;
              i = localByteBuffer.getInt();
              continue;
              localByteBuffer.getInt();
              continue;
              paramArrayOfByte = new long[i2 / 8];
              m = 0;
              while (m < i2 / 8)
              {
                paramArrayOfByte[m] = localByteBuffer.getLong();
                m += 1;
              }
              continue;
              localByteBuffer.getInt();
              continue;
              localByteBuffer.getInt();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.e("QQGAudioMsgHandler", 2, "onRecvMultiVideoS2C_0x95  222 " + l1 + "roomUserNum:" + i);
          }
          this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(1, l1, null, i);
          this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(l1, 2, 21, i);
          this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 1, l1, 0L);
          j += 1;
        }
      }
      int i1 = localByteBuffer.getShort();
      l1 = 0L;
      j = 0;
      if (i1 > 0)
      {
        i = 0;
        while (i < i1)
        {
          i2 = localByteBuffer.getShort();
          k = 0;
          if (k < i2)
          {
            m = localByteBuffer.getShort();
            int i3 = localByteBuffer.getShort();
            long l3;
            switch (m)
            {
            default: 
              localByteBuffer.get(new byte[i3], 0, i3);
              m = j;
              l3 = l1;
            }
            for (;;)
            {
              k += 1;
              l1 = l3;
              j = m;
              break;
              l3 = localByteBuffer.getInt();
              m = j;
              continue;
              m = localByteBuffer.getInt();
              l3 = l1;
              continue;
              localByteBuffer.getInt();
              l3 = l1;
              m = j;
              continue;
              paramArrayOfByte = new long[i3 / 8];
              n = 0;
              for (;;)
              {
                l3 = l1;
                m = j;
                if (n >= i3 / 8) {
                  break;
                }
                paramArrayOfByte[n] = localByteBuffer.getLong();
                n += 1;
              }
              localByteBuffer.getInt();
              l3 = l1;
              m = j;
              continue;
              localByteBuffer.getInt();
              l3 = l1;
              m = j;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.e("QQGAudioMsgHandler", 2, "onRecvMultiVideoS2C_0x95  222 " + l1 + "roomUserNum:" + j);
          }
          this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(1, l1, null, j);
          this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(l2, 10, 21, j);
          this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 1, l1, 0L);
          i += 1;
        }
      }
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_JavaUtilVector == null);
    int j = this.jdField_a_of_type_JavaUtilVector.size();
    if (j > 0)
    {
      i = 0;
      while (i < j)
      {
        i((byte[])this.jdField_a_of_type_JavaUtilVector.elementAt(i));
        i += 1;
      }
    }
    this.jdField_a_of_type_JavaUtilVector.clear();
  }
  
  void f(byte[] paramArrayOfByte)
  {
    int i = (paramArrayOfByte[10] & 0xFF) + 19;
    Object localObject = new byte[8];
    System.arraycopy(paramArrayOfByte, i, localObject, 0, 8);
    long l = VideoController.a((byte[])localObject, 8);
    int j = i + 8;
    localObject = new byte[4];
    System.arraycopy(paramArrayOfByte, j, localObject, 0, 4);
    i = VideoController.a((byte[])localObject, 4);
    int k = j + 4;
    localObject = new byte[2];
    System.arraycopy(paramArrayOfByte, k, localObject, 0, 2);
    j = (localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0;
    if ((j != 3) && (j != 2) && (j == 2) && (i != 10))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "Current version is only surpport discussion and friend. RelationType=" + j);
      }
      return;
    }
    if (j == 2)
    {
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, k + 3, localObject, 0, 4);
      k = a((byte[])localObject, 4);
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "onRecvMuitiInvite discussId is" + k + "InviteUin:" + l);
      }
      ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).b(k);
      if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter != null) {
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(2, k, new long[] { l }, 1L);
      }
      paramArrayOfByte = Integer.toString(k);
      localObject = Long.toString(l);
      ((QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37)).a(0, k, (String)localObject, "");
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) {
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, 13, false, paramArrayOfByte, (String)localObject, false, null, true, new Object[0]);
      }
    }
    while ((j == 1) && (i == 2))
    {
      new GroupVideoWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(new qeu(this));
      return;
      if ((j == 1) && (i == 10))
      {
        localObject = new byte[4];
        System.arraycopy(paramArrayOfByte, k + 3, localObject, 0, 4);
        k = a((byte[])localObject, 4);
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioMsgHandler", 2, "onRecvMuitiInvite groupUin is" + k + "InviteUin:" + l);
        }
        if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter != null)
        {
          this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(k, 10, 20, 1);
          this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(1, k, null, 1L);
          this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 1, Long.valueOf(k).longValue(), 0L);
        }
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 13, false, Long.toString(k), Long.toString(l), false, null, false, i, new Object[0]);
      }
    }
    new QavWrapper(BaseApplication.getContext()).a(new qev(this));
  }
  
  void g(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvGroupVideoInvite");
    }
    int i = (paramArrayOfByte[10] & 0xFF) + 19;
    byte[] arrayOfByte = new byte[8];
    System.arraycopy(paramArrayOfByte, i, arrayOfByte, 0, 8);
    long l1 = VideoController.a(arrayOfByte, 8);
    i += 8;
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, i, arrayOfByte, 0, 4);
    int j = VideoController.a(arrayOfByte, 4);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, i + 4, arrayOfByte, 0, 4);
    long l2 = VideoController.a(arrayOfByte, 4);
    if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter != null)
    {
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(l2, j, 20, 1);
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(l2, true);
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 1, Long.valueOf(l2).longValue(), 0L);
    }
    VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 13, false, Long.toString(l2), Long.toString(l1), false, null, false, j, new Object[0]);
    if (j == 2)
    {
      new GroupVideoWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(new qew(this));
      return;
    }
    new QavWrapper(BaseApplication.getContext()).a(new qex(this));
  }
  
  void h(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    Object localObject = new byte[i - 6];
    System.arraycopy(paramArrayOfByte, 6, localObject, 0, i - 6);
    paramArrayOfByte = new gv_pstn_bill.GroupVideoS2CBody();
    try
    {
      paramArrayOfByte = (gv_pstn_bill.GroupVideoS2CBody)paramArrayOfByte.mergeFrom((byte[])localObject);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.msg_s2c_notify_bill_req.has()))
      {
        localObject = (gv_pstn_bill.S2CNotifyBillReq)paramArrayOfByte.msg_s2c_notify_bill_req.get();
        if (localObject != null)
        {
          paramArrayOfByte = ((gv_pstn_bill.S2CNotifyBillReq)localObject).str_bill_msg.get();
          localObject = ((gv_pstn_bill.S2CNotifyBillReq)localObject).str_bill_detail.get();
          if (QLog.isColorLevel()) {
            QLog.e("QQGAudioMsgHandler", 2, "str_bill_msg=" + paramArrayOfByte + ", str_bill_detail=" + (String)localObject);
          }
          if ((!TextUtils.isEmpty(paramArrayOfByte)) && (!TextUtils.isEmpty((CharSequence)localObject)))
          {
            BaseApplication localBaseApplication = BaseApplication.getContext();
            Intent localIntent = new Intent(localBaseApplication, SysCallTransparentActivity.class);
            localIntent.addFlags(268435456);
            localIntent.putExtra("pstn_dialog_type", 1);
            localIntent.putExtra("pstn_guide_title", paramArrayOfByte);
            localIntent.putExtra("pstn_guide_content", (String)localObject);
            localBaseApplication.startActivity(localIntent);
          }
        }
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQGAudioMsgHandler", 2, "<---onRecvGroupVideoEndPushBill: exception occurs while parsing the pb bytes.", paramArrayOfByte);
        }
        paramArrayOfByte = null;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage == null) || (jdField_a_of_type_JavaUtilArrayList == null)) {}
    label79:
    do
    {
      do
      {
        for (;;)
        {
          return true;
          try
          {
            switch (paramMessage.what)
            {
            case 1: 
              if (!jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
                break label79;
              }
              if (QLog.isColorLevel())
              {
                QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is empty!");
                return true;
              }
              break;
            }
          }
          catch (Exception paramMessage) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQGAudioMsgHandler", 2, "handleMessage sDoubleMeetingMsg error!");
      return true;
      jdField_a_of_type_JavaUtilArrayList.clear();
    } while (!QLog.isColorLevel());
    QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is clear after 10 seconds");
    return true;
    return true;
  }
  
  void i(byte[] paramArrayOfByte)
  {
    if ((this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    int i;
    do
    {
      return;
      i = paramArrayOfByte[10];
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, (i & 0xFF) + 34, localObject, 0, 4);
      i = a((byte[])localObject, 4);
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "dealGAudioOfflineMsg discussId is:" + i);
      }
    } while (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(2, i) <= 0L);
    ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).b(i);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Intent localIntent = new Intent("tencent.video.q2v.RecvMultiVideoCall");
    localIntent.putExtra("uin", (String)localObject);
    localIntent.putExtra("buffer", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
  }
  
  public void j(byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent("tencent.video.q2v.VisitorSendGift");
    localIntent.putExtra("data", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\QQGAudioMsgHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */