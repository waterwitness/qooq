package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.SecMsgUtil;
import com.tencent.pb.secmsg.SecMsgComu.SecMsg_GetBaseInfo_Req;
import com.tencent.pb.secmsg.SecMsgComu.SecMsg_GetBaseInfo_Rsp;
import com.tencent.pb.secmsg.SecMsgComu.SecMsg_Req;
import com.tencent.pb.secmsg.SecMsgComu.SecMsg_Req_Comm;
import com.tencent.pb.secmsg.SecMsgComu.SecMsg_Rsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import qga;
import qgb;
import tencent.im.s2c.msgtype0x210.submsgtype0x60.SubMsgType0x60.MsgBody;

public class SecMsgHandler
  extends BusinessHandler
{
  public static final int a = 5;
  public static final String a = "SecMsgHandler";
  public static volatile boolean a = false;
  public static final int b = 6;
  public static final String b = "extra_notification_sec_msg";
  public static volatile int c = 3;
  public static final String c = "extra_msg_type";
  public static int d = 5;
  public static final String d = "extra_ssid";
  public static final String e = "extra_sec_process_forground";
  private volatile long jdField_a_of_type_Long = -1L;
  public OnPluginInstallListener a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected SecMsgHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new qgb(this);
  }
  
  private SecMsgComu.SecMsg_Req a(int paramInt, long paramLong)
  {
    SecMsgComu.SecMsg_Req localSecMsg_Req = new SecMsgComu.SecMsg_Req();
    localSecMsg_Req.cmd.set(paramInt);
    localSecMsg_Req.packet_seq.set(paramLong);
    SecMsgComu.SecMsg_Req_Comm localSecMsg_Req_Comm = new SecMsgComu.SecMsg_Req_Comm();
    localSecMsg_Req_Comm.platform.set(109L);
    localSecMsg_Req_Comm.osver.set(DeviceInfoUtil.e());
    localSecMsg_Req_Comm.mqqver.set("6.5.5");
    localSecMsg_Req.comm.set(localSecMsg_Req_Comm);
    return localSecMsg_Req;
  }
  
  private void a(int paramInt, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgHandler", 2, "sendPbMsg2Msf, cmdIndex=" + paramInt);
    }
    NewIntent localNewIntent = new NewIntent(this.b.a(), SecMsgServlet.class);
    localNewIntent.putExtra("cmd", String.valueOf(paramInt));
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("timeout", paramLong);
    this.b.startServlet(localNewIntent);
  }
  
  private void a(long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgHandler", 2, "handleMsgNotifyInner, msgType=" + paramLong1 + ",ssid=" + paramString1 + ",msgContent=" + paramString2 + ",ts=" + paramLong2 + ",isPluginDownload=" + jdField_a_of_type_Boolean);
    }
    boolean bool1 = SecMsgUtil.a();
    paramString2 = (SecMsgManager)this.b.getManager(56);
    if ((SecMsgHandler.PushCmdType.c(paramLong1)) && (paramString2 != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecMsgHandler", 2, "handleMsgNotifyInner, preProcessPushMsg, isSecProcessForground=" + bool1);
      }
      paramString2.a(bool1, paramLong1);
    }
    Object localObject;
    if (!jdField_a_of_type_Boolean)
    {
      localObject = (IPluginManager)this.b.getManager(26);
      if ((localObject != null) && (!((IPluginManager)localObject).isPlugininstalled("secmsg_plugin.apk")) && (!jdField_a_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SecMsgHandler", 2, "handleMsgNotifyInner, plugin not installed, check it");
        }
        c = 3;
        a();
      }
    }
    else
    {
      return;
    }
    if (((paramLong1 == 1L) || (paramLong1 == 2L)) && (paramString2 != null)) {
      paramString2.a(true, paramLong2, paramLong1);
    }
    if (SecMsgHandler.PushCmdType.b(paramLong1))
    {
      boolean bool2 = NoDisturbUtil.a((BaseApplicationImpl)this.b.a(), this.b);
      if ((!bool1) && (bool2) && (SecMsgHandler.PushCmdType.b(paramLong1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SecMsgHandler", 2, "handleMsgNotifyInner, vibratorAndAudio");
        }
        this.b.r();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SecMsgHandler", 2, "handleMsgNotifyInner, isSecProcessForground=" + bool1 + ", canDisturb=" + bool2);
      }
      paramString2 = GuardManager.a;
      if ((bool2) && (paramString2.b())) {
        localObject = this.b.a().getResources();
      }
    }
    try
    {
      paramString2 = BitmapFactory.decodeResource((Resources)localObject, 2130838592);
      if (paramString2 != null)
      {
        Intent localIntent = new Intent(this.b.a(), SplashActivity.class);
        localIntent.putExtra("msgType", paramLong1);
        String str1 = ((Resources)localObject).getString(2131371340);
        String str2 = ((Resources)localObject).getString(2131371341);
        localObject = ((Resources)localObject).getString(2131371342);
        if (QLog.isColorLevel()) {
          QLog.d("SecMsgHandler", 2, "handleMsgNotifyInner, send notification, ticker=" + str1 + ", contentTitle=" + str2 + ", content=" + (String)localObject);
        }
        ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.a(), "CMD_SHOW_NOTIFIYCATION");
        localToServiceMsg.extraData.putStringArray("cmds", new String[] { str1, str2, localObject });
        localToServiceMsg.extraData.putParcelable("intent", localIntent);
        localToServiceMsg.extraData.putParcelable("bitmap", paramString2);
        this.b.a(localToServiceMsg);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SecMsgHandler", 2, "handleMsgNotifyInner, send broadcast to plugin process, msgType=" + paramLong1 + ", ssid=" + paramString1 + ", isSecProcessForground=" + bool1);
      }
      paramString2 = new Intent("com.tencent.mobileqq.secmsg.PushMsg");
      paramString2.putExtra("extra_msg_type", paramLong1);
      paramString2.putExtra("extra_ssid", paramString1);
      paramString2.putExtra("extra_sec_process_forground", bool1);
      this.b.getApplication().sendBroadcast(paramString2);
      return;
    }
    catch (OutOfMemoryError paramString2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SecMsgHandler", 2, "handleMsgNotifyInner , icon is null :" + paramString2.getMessage());
        }
        paramString2 = null;
      }
    }
  }
  
  private void b(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgHandler", 2, "getSecMsgBaseInfoInner, mask=" + paramLong1);
    }
    try
    {
      SecMsgComu.SecMsg_GetBaseInfo_Req localSecMsg_GetBaseInfo_Req = new SecMsgComu.SecMsg_GetBaseInfo_Req();
      localSecMsg_GetBaseInfo_Req.mask.set(paramLong1);
      SecMsgComu.SecMsg_Req localSecMsg_Req = a(6, paramLong2);
      localSecMsg_Req.reqcmd_0x06.set(localSecMsg_GetBaseInfo_Req);
      a(6, localSecMsg_Req.toByteArray(), 30000L);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SecMsgHandler", 2, "getSecMsgBaseInfoInner, e=" + MsfSdkUtils.getStackTraceString(localException));
    }
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgHandler", 2, "handleGetSecMsgBaseInfo");
    }
    paramIntent = paramIntent.getByteArrayExtra("data");
    if (paramIntent == null) {
      return;
    }
    Object localObject = new SecMsgComu.SecMsg_Req();
    ((SecMsgComu.SecMsg_Req)localObject).mergeFrom(paramIntent);
    if (((SecMsgComu.SecMsg_Req)localObject).reqcmd_0x06.has())
    {
      paramIntent = (SecMsgComu.SecMsg_GetBaseInfo_Req)((SecMsgComu.SecMsg_Req)localObject).reqcmd_0x06.get();
      if (!paramIntent.mask.has()) {}
    }
    for (long l2 = paramIntent.mask.get();; l2 = -1L)
    {
      if ((paramFromServiceMsg.getResultCode() != 1000) || (paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SecMsgHandler", 2, "handleGetSecMsgBaseInfo, timeout");
        }
        a(5, false, null);
        return;
      }
      localObject = new SecMsgComu.SecMsg_Rsp();
      ((SecMsgComu.SecMsg_Rsp)localObject).mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("SecMsgHandler", 2, "handleGetSecMsgBaseInfo, ret=" + ((SecMsgComu.SecMsg_Rsp)localObject).ret.get());
      }
      if (0L == ((SecMsgComu.SecMsg_Rsp)localObject).ret.get())
      {
        if (this.b == null) {
          break;
        }
        paramIntent = (SecMsgManager)this.b.getManager(56);
        if (paramIntent == null) {
          break;
        }
        paramFromServiceMsg = paramIntent.a();
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuffer();
          paramArrayOfByte.append("handleGetSecMsgBaseInfo, Local old baseInfo: mIsForbidden=").append(paramFromServiceMsg.jdField_a_of_type_Boolean).append(",mIsWhiteUser=").append(paramFromServiceMsg.jdField_b_of_type_Boolean).append(",mIsDisable=").append(paramFromServiceMsg.c).append(",mNewestSeq=").append(paramFromServiceMsg.jdField_a_of_type_Long).append(",mServerTimestamp=").append(paramFromServiceMsg.jdField_b_of_type_Long).append(",mFeatureState=").append(paramFromServiceMsg.d).append(",mShieldSessionList=").append(paramFromServiceMsg.jdField_a_of_type_JavaUtilList).append(",mask=").append(Long.toBinaryString(l2));
          QLog.d("SecMsgHandler", 2, paramArrayOfByte.toString());
        }
        long l4 = paramFromServiceMsg.jdField_a_of_type_Long;
        if (!((SecMsgComu.SecMsg_Rsp)localObject).rspcmd_0x06.has()) {
          break;
        }
        paramArrayOfByte = (SecMsgComu.SecMsg_GetBaseInfo_Rsp)((SecMsgComu.SecMsg_Rsp)localObject).rspcmd_0x06.get();
        if (paramArrayOfByte.f_forbid.has())
        {
          paramFromServiceMsg.jdField_a_of_type_Boolean = paramArrayOfByte.f_forbid.get();
          if (QLog.isColorLevel()) {
            QLog.d("SecMsgHandler", 2, "handleGetSecMsgBaseInfo, svr, f_forbid=" + paramFromServiceMsg.jdField_a_of_type_Boolean);
          }
        }
        if (paramArrayOfByte.f_whiteuser.has())
        {
          paramFromServiceMsg.jdField_b_of_type_Boolean = paramArrayOfByte.f_whiteuser.get();
          if (QLog.isColorLevel()) {
            QLog.d("SecMsgHandler", 2, "handleGetSecMsgBaseInfo, svr, f_whiteuser=" + paramFromServiceMsg.jdField_b_of_type_Boolean);
          }
        }
        if (paramArrayOfByte.f_disable.has())
        {
          paramFromServiceMsg.c = paramArrayOfByte.f_disable.get();
          if (QLog.isColorLevel()) {
            QLog.d("SecMsgHandler", 2, "handleGetSecMsgBaseInfo, svr, f_disable=" + paramFromServiceMsg.c);
          }
        }
        if (paramArrayOfByte.dss.has())
        {
          paramFromServiceMsg.jdField_a_of_type_JavaUtilList = paramArrayOfByte.dss.get();
          if (QLog.isColorLevel())
          {
            QLog.d("SecMsgHandler", 2, "handleGetSecMsgBaseInfo, svr, dss=" + paramFromServiceMsg.jdField_a_of_type_JavaUtilList);
            if ((paramFromServiceMsg.jdField_a_of_type_JavaUtilList != null) && (paramFromServiceMsg.jdField_a_of_type_JavaUtilList.size() > 0))
            {
              int j = paramFromServiceMsg.jdField_a_of_type_JavaUtilList.size();
              int i = 0;
              while (i < j)
              {
                QLog.d("SecMsgHandler", 2, "handleGetSecMsgBaseInfo, svr, dss[" + i + "]=" + (String)paramFromServiceMsg.jdField_a_of_type_JavaUtilList.get(i));
                i += 1;
              }
            }
          }
        }
        if (paramArrayOfByte.newest_seq.has())
        {
          paramFromServiceMsg.jdField_a_of_type_Long = paramArrayOfByte.newest_seq.get();
          if (QLog.isColorLevel()) {
            QLog.d("SecMsgHandler", 2, "handleGetSecMsgBaseInfo, svr, newest_seq=" + paramFromServiceMsg.jdField_a_of_type_Long);
          }
        }
        if (paramArrayOfByte.nowts.has())
        {
          paramFromServiceMsg.jdField_b_of_type_Long = paramArrayOfByte.nowts.get();
          if (QLog.isColorLevel()) {
            QLog.d("SecMsgHandler", 2, "handleGetSecMsgBaseInfo, svr, nowts=" + paramFromServiceMsg.jdField_b_of_type_Long);
          }
        }
        if (paramArrayOfByte.appstate.has())
        {
          paramFromServiceMsg.d = ((int)paramArrayOfByte.appstate.get());
          if (QLog.isColorLevel()) {
            QLog.d("SecMsgHandler", 2, "handleGetSecMsgBaseInfo, svr, appstate=" + paramFromServiceMsg.d);
          }
        }
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuffer();
          paramArrayOfByte.append("handleGetSecMsgBaseInfo, After merge: mIsForbidden=").append(paramFromServiceMsg.jdField_a_of_type_Boolean).append(",mIsWhiteUser=").append(paramFromServiceMsg.jdField_b_of_type_Boolean).append(",mIsDisable=").append(paramFromServiceMsg.c).append(",mNewestSeq=").append(paramFromServiceMsg.jdField_a_of_type_Long).append(",mServerTimestamp=").append(paramFromServiceMsg.jdField_b_of_type_Long).append(",mFeatureState=").append(paramFromServiceMsg.d).append(",mShieldSessionList=").append(paramFromServiceMsg.jdField_a_of_type_JavaUtilList).append(",mask=").append(Long.toBinaryString(l2));
          QLog.d("SecMsgHandler", 2, paramArrayOfByte.toString());
        }
        long l3;
        long l1;
        if (paramIntent != null)
        {
          paramIntent.a(paramFromServiceMsg, l2);
          l3 = -1L;
          l1 = l3;
          if (this.b != null)
          {
            paramArrayOfByte = this.b.a().a();
            l1 = l3;
            if (paramArrayOfByte != null)
            {
              paramArrayOfByte = paramArrayOfByte.a(AppConstants.aF, 9001);
              l1 = l3;
              if (paramArrayOfByte != null)
              {
                l1 = l3;
                if (paramArrayOfByte.lastmsgtime > 0L) {
                  l1 = paramArrayOfByte.lastmsgtime;
                }
              }
            }
          }
          if (l2 != -1L) {
            break label1348;
          }
          if (paramIntent.a()) {
            break label1143;
          }
          paramIntent.a(false, -1L, 0L);
          this.jdField_a_of_type_Long = -1L;
        }
        label1143:
        label1348:
        while (((0x10 & l2) != 16L) || (paramFromServiceMsg.jdField_a_of_type_Long <= paramIntent.a()))
        {
          a(5, true, null);
          return;
          l3 = NetConnInfoCenter.getServerTime();
          if (paramFromServiceMsg.jdField_a_of_type_Long > paramIntent.a()) {}
          for (boolean bool = true;; bool = false)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SecMsgHandler", 2, "handleGetSecMsgBaseInfo, hasNewSecMsg=" + bool + ", baseInfo.mNewestSeq=" + paramFromServiceMsg.jdField_a_of_type_Long + ", sm.getLastFetchMsgSeq()=" + paramIntent.a() + ", previousNewestSecMsgSeq=" + l4);
            }
            if (!bool) {
              break;
            }
            l2 = l3;
            if (l4 >= paramFromServiceMsg.jdField_a_of_type_Long)
            {
              l2 = l3;
              if (l1 > 0L)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("SecMsgHandler", 2, "handleGetSecMsgBaseInfo, hasNewSecMsg, use last time=" + l1);
                }
                l2 = l1;
              }
            }
            paramIntent.a(2L);
            paramIntent.a(true, l2, 0L);
            paramIntent = this.b.a(Conversation.class);
            if (paramIntent == null) {
              break;
            }
            paramIntent.sendEmptyMessage(1009);
            break;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SecMsgHandler", 2, "handleGetSecMsgBaseInfo, net reconnect, baseInfo.mNewestSeq=" + paramFromServiceMsg.jdField_a_of_type_Long + ", sm.getLastFetchMsgSeq()=" + paramIntent.a() + ", previousNewestSecMsgSeq=" + l4);
        }
        l2 = NetConnInfoCenter.getServerTime();
        if ((l4 < paramFromServiceMsg.jdField_a_of_type_Long) || (l1 <= 0L)) {
          break label1517;
        }
        l2 = l1;
        if (QLog.isColorLevel())
        {
          QLog.d("SecMsgHandler", 2, "handleGetSecMsgBaseInfo, net reconnect, hasNewSecMsg, use last time=" + l1);
          l2 = l1;
        }
      }
      label1517:
      for (;;)
      {
        a(2L, null, null, l2);
        break;
        a(5, false, null);
        return;
      }
    }
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgHandler", 2, "getSecMsgBaseInfo, mask=" + paramLong1);
    }
    if ((this.b != null) && (a())) {
      b(paramLong1, paramLong2);
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    int i = Integer.valueOf(paramIntent.getStringExtra("cmd")).intValue();
    switch (i)
    {
    default: 
      try
      {
        throw new Exception("unknow cmd");
      }
      catch (Exception paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SecMsgHandler", 2, "handle cmd=" + i + " exception:" + paramIntent.getMessage());
        }
        return;
      }
    }
    b(paramIntent, paramFromServiceMsg, paramArrayOfByte);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgHandler", 2, "handleOnlinePushSecMsg");
    }
    if (paramArrayOfByte == null) {}
    long l1;
    label126:
    do
    {
      do
      {
        for (;;)
        {
          return;
          localObject = new SubMsgType0x60.MsgBody();
          try
          {
            ((SubMsgType0x60.MsgBody)localObject).mergeFrom(paramArrayOfByte);
            l1 = ((SubMsgType0x60.MsgBody)localObject).uint32_pushcmd.get();
            if (SecMsgHandler.PushCmdType.a(l1)) {
              break label126;
            }
            if (QLog.isColorLevel())
            {
              QLog.e("SecMsgHandler", 2, "handleOnlinePushSecMsg, msgType " + l1 + " NOT SUPPORT, ABORT!!!");
              return;
            }
          }
          catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
        }
      } while (!QLog.isColorLevel());
      QLog.e("SecMsgHandler", 2, "handleOnlinePushSecMsg, parse error, exception: " + paramArrayOfByte.getMessage());
      return;
      if (!((SecMsgManager)this.b.getManager(56)).a(l1)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SecMsgHandler", 2, "handleOnlinePushSecMsg, interceptPushMsg, type " + l1 + ", ABORT!!!");
    return;
    long l2 = ((SubMsgType0x60.MsgBody)localObject).int64_ts.get();
    paramArrayOfByte = ((SubMsgType0x60.MsgBody)localObject).str_content.get();
    Object localObject = ((SubMsgType0x60.MsgBody)localObject).str_ssid.get();
    if (QLog.isColorLevel()) {
      QLog.e("SecMsgHandler", 2, "handleOnlinePushSecMsg, msgType=" + l1 + ",ssid=" + (String)localObject + ",msgContent=" + paramArrayOfByte + ",ts=" + l2);
    }
    a(l1, (String)localObject, paramArrayOfByte, l2);
  }
  
  public boolean a()
  {
    if (jdField_a_of_type_Boolean) {}
    int i;
    do
    {
      return false;
      IPluginManager localIPluginManager = (IPluginManager)this.b.getManager(26);
      if ((localIPluginManager == null) || (localIPluginManager.isPlugininstalled("secmsg_plugin.apk"))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SecMsgHandler", 2, "begin try download secmsg plugin. try num:" + c + ", pluginmanager is ready:" + localIPluginManager.isReady());
      }
      SecMsgManager localSecMsgManager = (SecMsgManager)this.b.getManager(56);
      if (localSecMsgManager != null)
      {
        Object localObject = this.b.a().a();
        if (localObject != null)
        {
          localObject = ((RecentUserProxy)localObject).a(AppConstants.aF, 9001);
          if ((localObject != null) && (((RecentUser)localObject).lastmsgtime > 0L))
          {
            this.jdField_a_of_type_Long = ((RecentUser)localObject).lastmsgtime;
            if (QLog.isColorLevel()) {
              QLog.d("SecMsgHandler", 2, "checkAvailable, hold lastTime=" + this.jdField_a_of_type_Long);
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SecMsgHandler", 2, "checkAvailable, hide entrance in msg tab");
        }
        localSecMsgManager.a(false, 0L, 0L);
      }
      if (localIPluginManager.isReady())
      {
        localIPluginManager.installPlugin("secmsg_plugin.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
        return false;
      }
      i = d;
      d = i - 1;
    } while (i <= 0);
    ThreadManager.b().postDelayed(new qga(this), 10000L);
    return false;
    jdField_a_of_type_Boolean = false;
    return true;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\SecMsgHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */