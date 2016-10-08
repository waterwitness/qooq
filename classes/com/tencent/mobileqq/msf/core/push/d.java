package com.tencent.mobileqq.msf.core.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.net.h;
import com.tencent.mobileqq.msf.core.w;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.msf.service.c;
import com.tencent.mobileqq.msf.service.g;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.msf.service.protocol.pb.StatSvcSimpleGet.RspBody;
import com.tencent.msf.service.protocol.push.SvcReqRegister;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class d
{
  public static final String a = "StatSvc.register";
  public static final String b = "MSF.C.PushManager:PushCoder";
  public static long c = 0L;
  public static long d = 0L;
  public static String i = "StatSvc.get";
  public static String j = "StatSvc.SimpleGet";
  static boolean m = false;
  public static final String n = "com.tencent.mobileqq.msf.WatchdogForInfoLogin";
  private static String o = "SvcReqRegister";
  private static String p = "PushService";
  private static byte q;
  private static boolean r;
  private static int s = -1;
  private static String u = "PullUnreadMsgCount";
  private static String v = "MessageSvc";
  private static String w = "SvcReqGet";
  private static String x = "PushService";
  private static final BroadcastReceiver y = new e();
  private long A;
  private int B;
  f e;
  volatile boolean f = false;
  long g = 0L;
  int h = 0;
  long k = 0L;
  int l = 0;
  private final String t = "unrtime";
  private int z;
  
  public d(f paramf)
  {
    this.e = paramf;
  }
  
  long a(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("unrtime", 0).getLong(paramString, 0L);
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    if (this.A == 0L) {
      this.A = l1;
    }
    if ((this.B >= 5) && (l1 - this.A < 600000L))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog mStartWatchdogForInfoLoginRetryCount:" + this.B + " time:" + (l1 - this.A));
        QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog launch QQ Process too much stop.");
      }
      return;
    }
    if (this.B == 5)
    {
      this.B = 0;
      this.A = l1;
    }
    this.B += 1;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogForInfoLogin mnWatchdogForInfoLoginRetryCount:" + this.z);
    }
    if (!m)
    {
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.mobileqq.msf.WatchdogForInfoLogin");
      BaseApplication.getContext().registerReceiver(y, (IntentFilter)localObject);
      m = true;
    }
    MsfService.getCore().mbIsInfoLoginGetted.set(false);
    this.z = 0;
    Object localObject = new Intent("com.tencent.mobileqq.msf.WatchdogForInfoLogin");
    localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
    ((AlarmManager)BaseApplication.getContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + 10000L, (PendingIntent)localObject);
  }
  
  void a(a parama, ToServiceMsg paramToServiceMsg, boolean paramBoolean, m paramm)
  {
    if (parama.k == null) {}
    do
    {
      return;
      if ((!com.tencent.mobileqq.msf.core.a.a.ai()) || (com.tencent.mobileqq.msf.core.a.a.a(parama.k.uin))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.PushManager:PushCoder", 2, parama.k.uin + " is booting and can not autoRegisterPush,return.");
    return;
    boolean bool = a(paramm);
    if ((!bool) && (!paramBoolean) && (this.f) && (System.currentTimeMillis() - parama.e < 30000L))
    {
      parama = new StringBuilder().append("also send pushRegister, return. ");
      if (!bool)
      {
        bool = true;
        parama = parama.append(bool).append(" ");
        if (paramBoolean) {
          break label179;
        }
      }
      label179:
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.d("MSF.C.PushManager:PushCoder", 1, paramBoolean + " " + this.f);
        return;
        bool = false;
        break;
      }
    }
    if (paramBoolean) {}
    try
    {
      a(paramToServiceMsg.getUin(), System.currentTimeMillis());
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager:PushCoder", 2, "ConfigManager.isAutoStarting():" + com.tencent.mobileqq.msf.core.a.a.ai());
      }
      try
      {
        localObject2 = new UniPacket(true);
        ((UniPacket)localObject2).setServantName(p);
        ((UniPacket)localObject2).setFuncName(o);
        localObject1 = new SvcReqRegister();
        ((SvcReqRegister)localObject1).cConnType = q;
        ((SvcReqRegister)localObject1).lBid = parama.c;
        ((SvcReqRegister)localObject1).lUin = Long.parseLong(parama.k.uin);
        ((SvcReqRegister)localObject1).iStatus = parama.k.iStatus;
        ((SvcReqRegister)localObject1).bKikPC = parama.k.bKikPC;
        ((SvcReqRegister)localObject1).bKikWeak = parama.k.bKikWeak;
        ((SvcReqRegister)localObject1).timeStamp = parama.k.timeStamp;
        ((SvcReqRegister)localObject1).iLargeSeq = parama.k.iLargeSeq;
        if ((paramm == m.b) || (paramm == m.g)) {
          break label1088;
        }
        if (paramm != m.h) {
          break label891;
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          Object localObject2;
          Object localObject1;
          int i1;
          ToServiceMsg localToServiceMsg;
          long l1;
          long l2;
          long l3;
          QLog.d("MSF.C.PushManager:PushCoder", 1, "send registerPush error " + parama, parama);
          continue;
          if (NetConnInfoCenterImpl.isWifiConn())
          {
            localException1.cNetType = 1;
            continue;
            localException2.setMsfCommand(MsfCommand._msf_RegPush);
            continue;
            this.f = true;
            QLog.d("MSF.C.PushManager:PushCoder", 1, "handlerPush send " + MD5.toMD5(parama.k.uin) + " register push id " + parama.c + " pushStatus:" + parama.k.iStatus + " bRegType:" + localException1.bRegType + " timeStamp:" + localException1.timeStamp + " newIP:" + d + " oldIP:" + c);
            continue;
            i1 = 0;
          }
        }
      }
      ((SvcReqRegister)localObject1).bRegType = ((byte)i1);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          ((SvcReqRegister)localObject1).iOSVersion = Integer.parseInt(Build.VERSION.SDK);
          if (!NetConnInfoCenterImpl.isMobileConn()) {
            break;
          }
          ((SvcReqRegister)localObject1).cNetType = 0;
          ((SvcReqRegister)localObject1).vecGuid = NetConnInfoCenter.GUID;
          ((SvcReqRegister)localObject1).strDevName = Build.MODEL;
          ((SvcReqRegister)localObject1).strDevType = Build.MODEL;
          ((SvcReqRegister)localObject1).strOSVer = Build.VERSION.RELEASE;
          if (!paramBoolean)
          {
            ((SvcReqRegister)localObject1).uNewSSOIp = d;
            ((SvcReqRegister)localObject1).uOldSSOIp = c;
          }
          ((UniPacket)localObject2).put(o, localObject1);
          localObject2 = ((UniPacket)localObject2).encode();
          localToServiceMsg = new ToServiceMsg("", parama.k.uin, "StatSvc.register");
          localToServiceMsg.setAppId(parama.a);
          if (paramToServiceMsg != null)
          {
            localToServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
            localToServiceMsg.addAttribute("to_srcCmd", paramToServiceMsg.getServiceCmd());
          }
          localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
          localToServiceMsg.putWupBuffer((byte[])localObject2);
          localToServiceMsg.setTimeout(30000L);
          localToServiceMsg.addAttribute("regPushReason", paramm.toString());
          if (!paramBoolean) {
            break label953;
          }
          localToServiceMsg.setMsfCommand(MsfCommand._msf_UnRegPush);
          MsfSdkUtils.addToMsgProcessName(parama.b, localToServiceMsg);
          f.s = true;
          this.g = System.currentTimeMillis();
          this.e.b.sendSsoMsg(localToServiceMsg);
          parama.e = System.currentTimeMillis();
          if (!paramBoolean) {
            break label964;
          }
          QLog.d("MSF.C.PushManager:PushCoder", 1, "handlerPush send " + MD5.toMD5(parama.k.uin) + " unregister push id " + parama.c + " pushStatus:" + parama.k.iStatus + " bRegType:" + ((SvcReqRegister)localObject1).bRegType);
          this.e.a();
          return;
          if (paramToServiceMsg != null)
          {
            l1 = a(paramToServiceMsg.getUin());
            if (l1 != 0L)
            {
              l2 = System.currentTimeMillis();
              l3 = l2 - l1;
              if (l3 > 0L)
              {
                l3 /= 1000L;
                localObject1 = new HashMap();
                ((HashMap)localObject1).put("unRegtime", String.valueOf(l1));
                ((HashMap)localObject1).put("now", String.valueOf(l2));
                ((HashMap)localObject1).put("uin", paramToServiceMsg.getUin());
                this.e.b.getStatReporter().a("Msf.RegInterTime", true, l3, 0L, (Map)localObject1, false, false);
              }
              a(paramToServiceMsg.getUin(), 0L);
              continue;
              localException1 = localException1;
              QLog.d("MSF.C.PushManager:PushCoder", 1, "get reginterv error " + localException1, localException1);
            }
          }
        }
        label891:
        i1 = 1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  void a(a parama, boolean paramBoolean)
  {
    if ((com.tencent.mobileqq.msf.core.a.a.t) && (!paramBoolean))
    {
      long l1 = this.e.g() + this.e.e();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager:PushCoder", 2, "sendMsgPushQuery, check time now=" + f.g.format(Long.valueOf(System.currentTimeMillis())) + ", shouldSendQueryTime=" + f.g.format(Long.valueOf(l1)));
      }
      if (System.currentTimeMillis() < l1) {
        this.e.a(l1 - System.currentTimeMillis());
      }
    }
    label679:
    do
    {
      for (;;)
      {
        return;
        try
        {
          if (this.e.h() > 0L) {
            f.k = SystemClock.elapsedRealtime() - this.e.h();
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager:PushCoder", 2, "alarmTime: " + f.k + " ,lastRecvSsoPacketTimeForSimpleGet=" + this.e.h());
          }
          if ((com.tencent.mobileqq.msf.core.a.a.u) && (f.k > com.tencent.mobileqq.msf.core.a.a.bi()))
          {
            str = MsfService.getCore().getAccountCenter().i();
            if ((!com.tencent.mobileqq.msf.core.a.a.v) || (Long.parseLong(str) % 2L == 0L))
            {
              QLog.d("MSF.C.PushManager:PushCoder", 1, "try close conn by a exceeded time to wakeup alarm :" + f.k);
              this.e.b.sender.a.a(com.tencent.qphone.base.a.D);
              this.e.b.getStatReporter().a("1", str, true, 0L);
            }
          }
          else
          {
            if ((com.tencent.mobileqq.msf.core.a.a.u) && (f.k > com.tencent.mobileqq.msf.core.a.a.bj()) && (f.k <= com.tencent.mobileqq.msf.core.a.a.bi())) {
              this.e.D = SystemClock.elapsedRealtime();
            }
            if (parama.k == null) {
              continue;
            }
            if ((parama.k.uin == null) || (parama.c <= 0L)) {
              break label679;
            }
            str = this.e.c + "|" + NetConnInfoCenterImpl.getSystemNetworkType() + "|" + NetConnInfoCenterImpl.getCurrentAPN() + "|" + (System.currentTimeMillis() - this.k);
            localToServiceMsg = new ToServiceMsg("", parama.k.uin, j);
            localToServiceMsg.setAppId(parama.a);
            localToServiceMsg.setTimeout(30000L);
            localToServiceMsg.setMsfCommand(MsfCommand._msf_queryPush);
            localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
            if (f.k > 0L)
            {
              localToServiceMsg.addAttribute("_attr_alarm_elapsed_time", Long.valueOf(f.k));
              f.k = 0L;
            }
            MsfSdkUtils.addToMsgProcessName(parama.b, localToServiceMsg);
          }
        }
        catch (Exception localException1)
        {
          try
          {
            for (;;)
            {
              String str;
              ToServiceMsg localToServiceMsg;
              this.e.b.sendSsoMsg(localToServiceMsg);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("MSF.C.PushManager:PushCoder", 2, "send " + parama.k.uin + " query push id " + parama.c + " model:" + str);
              return;
              this.e.B = SystemClock.elapsedRealtime();
              QLog.d("MSF.C.PushManager:PushCoder", 1, "wakeup too long, but not close conn:" + f.k);
            }
            localException1 = localException1;
            QLog.d("MSF.C.PushManager:PushCoder", 1, "do PreDetectionAlarmTimeAlpha error!", localException1);
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              QLog.w("MSF.C.PushManager:PushCoder", 1, "query push error " + localException2, localException2);
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.PushManager:PushCoder", 2, "pushUin is " + parama.k.uin + ", queryPushId is " + parama.c + ". no query");
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = g.c();
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        UniPacket localUniPacket = new UniPacket(true);
        localUniPacket.decode(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = (com.tencent.msf.service.protocol.a.b)localUniPacket.getByClass("resp_PullUnreadMsgCount", new com.tencent.msf.service.protocol.a.b());
        if ((paramFromServiceMsg != null) && ((paramFromServiceMsg.c > 0L) || (paramFromServiceMsg.d > 0L) || (paramFromServiceMsg.e > 0L)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager:PushCoder", 2, "UnreadMsg getted, call QQ process now resp.c2c_count:" + paramFromServiceMsg.c + " resp.group_count :" + paramFromServiceMsg.d + " resp.discuss_count" + paramFromServiceMsg.e);
          }
          c(paramToServiceMsg);
          return;
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("MSF.C.PushManager:PushCoder", 2, "UnreadMsg getted,  resp.c2c_count:" + paramFromServiceMsg.c + " resp.group_count :" + paramFromServiceMsg.d + " resp.discuss_count" + paramFromServiceMsg.e);
        return;
      }
    }
    catch (Throwable paramFromServiceMsg)
    {
      QLog.d("MSF.C.PushManager:PushCoder", 1, "handle unreadmsg error " + paramFromServiceMsg, paramFromServiceMsg);
      c(paramToServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager:PushCoder", 2, "UnreadMsg timeout, call QQ process now");
    }
    c(paramToServiceMsg);
  }
  
  void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l3 = ((Long)paramToServiceMsg.getAttribute("__timestamp_app2msf")).longValue();
    if (l3 > this.g) {
      this.f = false;
    }
    long l4 = System.currentTimeMillis() - l3;
    long l5 = com.tencent.mobileqq.msf.core.c.m.a(paramToServiceMsg, paramFromServiceMsg);
    Object localObject2 = null;
    i3 = -1;
    l1 = -1L;
    i2 = -1;
    for (;;)
    {
      try
      {
        if (paramFromServiceMsg.isSuccess()) {
          continue;
        }
        l1 = -1L;
        i1 = 0;
      }
      catch (Throwable localThrowable2)
      {
        Object localObject4;
        label361:
        label386:
        long l2;
        Object localObject1 = "unknown";
        continue;
        localObject1 = "unknown";
        continue;
        l1 = -1L;
        int i1 = 0;
        continue;
        boolean bool = false;
        continue;
      }
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.getAttributes().containsKey("regPushReason"))) {
        continue;
      }
      localObject1 = (String)paramToServiceMsg.getAttribute("regPushReason");
      if (i1 == 0) {
        continue;
      }
      try
      {
        this.h = 0;
        this.k = System.currentTimeMillis();
        if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_UnRegPush)
        {
          QLog.d("MSF.C.PushManager:PushCoder", 1, "handlerPush unregister push succ " + MD5.toMD5(paramFromServiceMsg.getUin()));
          localObject4 = g.b(paramToServiceMsg);
          localObject4 = (a)this.e.h.get(localObject4);
          if (localObject4 != null)
          {
            ((a)localObject4).i = this.e.b.nowSocketConnAdd;
            ((a)localObject4).f = System.currentTimeMillis();
            if (localObject2 == null) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.PushManager:PushCoder", 2, "recv register push resp.iInterval=" + ((SvcRespRegister)localObject2).iHelloInterval + ", queryIntervTime=" + this.e.e() + ", next query time is " + f.g.format(Long.valueOf(System.currentTimeMillis() + ((SvcRespRegister)localObject2).iHelloInterval * 1000)));
            }
            if ((!com.tencent.mobileqq.msf.core.a.a.aM()) || (com.tencent.mobileqq.msf.core.net.a.b.e)) {
              this.e.A = (((SvcRespRegister)localObject2).iHelloInterval * 1000);
            }
            this.e.a(this.e.e());
          }
          if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_RegPush) {
            continue;
          }
          paramFromServiceMsg.setMsfCommand(MsfCommand.registerPush);
          if (!paramToServiceMsg.getAttributes().containsKey("to_srcCmd")) {
            continue;
          }
          this.e.b.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
          localObject2 = this.e.b.getStatReporter();
          i1 = paramFromServiceMsg.getBusinessFailCode();
          if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_UnRegPush) {
            continue;
          }
          bool = true;
          ((com.tencent.mobileqq.msf.core.c.m)localObject2).a(true, l4, i1, l5, bool, (String)localObject1);
          return;
          if ((paramFromServiceMsg.getWupBuffer() == null) || (paramFromServiceMsg.getWupBuffer().length < 5)) {
            continue;
          }
          localObject1 = new UniPacket(true);
          try
          {
            ((UniPacket)localObject1).decode(paramFromServiceMsg.getWupBuffer());
            localObject1 = (SvcRespRegister)((UniPacket)localObject1).getByClass("SvcRespRegister", new SvcRespRegister());
          }
          catch (Exception localException1)
          {
            try
            {
              w.c(((SvcRespRegister)localObject1).strClientIP);
              w.d(((SvcRespRegister)localObject1).iClientPort);
              i3 = ((SvcRespRegister)localObject1).bUpdateFlag;
              l2 = l1;
            }
            catch (Exception localException2)
            {
              int i4;
              Object localObject3;
              i1 = -1;
              i2 = -1;
              continue;
            }
            try
            {
              l1 = ((SvcRespRegister)localObject1).timeStamp;
              l2 = l1;
              i2 = ((SvcRespRegister)localObject1).cReplyCode;
            }
            catch (Exception localException3)
            {
              i1 = -1;
              i2 = i3;
              l1 = l2;
              continue;
            }
            try
            {
              NetConnInfoCenter.handleGetServerTimeResp(((SvcRespRegister)localObject1).lServerTime);
              if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.PushManager:PushCoder", 4, "pushresp servertime is " + ((SvcRespRegister)localObject1).lServerTime + this.e.b.timeFormatter.format(Long.valueOf(((SvcRespRegister)localObject1).lServerTime * 1000L)));
              }
              i1 = 1;
              localObject2 = localObject1;
            }
            catch (Exception localException4)
            {
              i1 = i2;
              i2 = i3;
              continue;
            }
            localException1 = localException1;
            i2 = -1;
            localObject1 = null;
            i1 = -1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager:PushCoder", 2, "decodeRegisterPushResp error", localException1);
          }
          i4 = 0;
          i3 = i2;
          localObject3 = localObject1;
          i2 = i1;
          i1 = i4;
        }
        else
        {
          QLog.d("MSF.C.PushManager:PushCoder", 1, "handlerPush register push succ " + MD5.toMD5(paramFromServiceMsg.getUin()) + " bUpdateFlag:" + i3 + " timeStamp:" + l1 + " cReplyCode:" + i2);
          b(g.b(paramToServiceMsg));
          continue;
          localObject4 = this.e.b.getStatReporter();
        }
      }
      catch (Throwable localThrowable1) {}
    }
    i1 = paramFromServiceMsg.getBusinessFailCode();
    if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_UnRegPush) {}
    for (bool = true;; bool = false)
    {
      ((com.tencent.mobileqq.msf.core.c.m)localObject4).a(false, l4, i1, l5, bool, (String)localObject1);
      this.e.a(this.e.e());
      localThrowable1.printStackTrace();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager:PushCoder", 2, "recv null register push resp, use default intervTime " + this.e.e());
      }
      this.e.a(this.e.e());
      break;
      if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_UnRegPush)
      {
        paramFromServiceMsg.setMsfCommand(MsfCommand.unRegisterPush);
        break label361;
      }
      paramFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
      break label361;
      MsfSdkUtils.addFromMsgProcessName(g.b(paramToServiceMsg), paramFromServiceMsg);
      this.e.b.addRespToQuque(null, paramFromServiceMsg);
      break label386;
      com.tencent.mobileqq.msf.core.c.m localm;
      if ((l3 > this.g) && (!this.f))
      {
        f.s = false;
        if (this.h > 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager:PushCoder", 2, "register push register error, retry count " + this.h + ", set retry at " + f.g.format(Long.valueOf(this.e.e() + System.currentTimeMillis())));
          }
          this.h = 0;
          this.e.a(this.e.e());
        }
      }
      else
      {
        localm = this.e.b.getStatReporter();
        i1 = paramFromServiceMsg.getBusinessFailCode();
        if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_UnRegPush) {
          break label1148;
        }
      }
      label1148:
      for (bool = true;; bool = false)
      {
        localm.a(false, l4, i1, l5, bool, (String)localObject1);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager:PushCoder", 2, "register push register error, retry count " + this.h + ",set retry at " + f.g.format(Long.valueOf(60000L + System.currentTimeMillis())));
        }
        this.h += 1;
        this.e.a(60000L);
        break;
      }
    }
  }
  
  void a(String paramString, long paramLong)
  {
    BaseApplication.getContext().getSharedPreferences("unrtime", 0).edit().putLong(paramString, paramLong).commit();
  }
  
  boolean a(m paramm)
  {
    return (paramm == m.b) || (paramm == m.g) || (paramm == m.h);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogCallback mnWatchdogForInfoLoginRetryCount:" + this.z);
    }
    String str = MsfSdkUtils.getProcessName(BaseApplication.getContext());
    Object localObject = str;
    if (str != null)
    {
      localObject = str;
      if (str.indexOf(":") > 0) {
        localObject = str.substring(0, str.indexOf(":"));
      }
    }
    localObject = (a)this.e.h.get(localObject);
    if ((localObject == null) || (((a)localObject).k == null) || (MsfService.getCore().getUinPushStatus(((a)localObject).k.uin) == 95)) {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogCallback in 95 status do not start QQ Process");
      }
    }
    do
    {
      do
      {
        return;
        if (!MsfService.getCore().mbIsInfoLoginGetted.get()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogCallback mbIsInfoLoginGetted:" + MsfService.getCore().mbIsInfoLoginGetted + " ok");
      return;
      if (!g.b()) {
        break;
      }
      if (this.z < 6)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogCallback QQProcessRunning mnWatchdogForInfoLoginRetryCount:" + this.z);
        }
        this.z += 1;
        localObject = new Intent("com.tencent.mobileqq.msf.WatchdogForInfoLogin");
        localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
        ((AlarmManager)BaseApplication.getContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + 10000L, (PendingIntent)localObject);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogCallback QQProcessRunning mnWatchdogForInfoLoginRetryCount:" + this.z);
    return;
    QLog.d("MSF.C.PushManager:PushCoder", 1, "watchdog startWatchdogCallback QQProcess killed restart now");
    c(g.c());
  }
  
  void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = g.b(paramToServiceMsg);
    if ((a)this.e.h.get(str) != null)
    {
      long l1 = System.currentTimeMillis();
      long l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_app2msf")).longValue();
      long l3 = com.tencent.mobileqq.msf.core.c.m.a(paramToServiceMsg, paramFromServiceMsg);
      try
      {
        if (paramFromServiceMsg.isSuccess())
        {
          this.e.c(SystemClock.elapsedRealtime());
          paramToServiceMsg = new byte[paramFromServiceMsg.getWupBuffer().length - 4];
          System.arraycopy(paramFromServiceMsg.getWupBuffer(), 4, paramToServiceMsg, 0, paramToServiceMsg.length);
          paramFromServiceMsg = new StatSvcSimpleGet.RspBody();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg);
          this.l = 0;
          if ((!com.tencent.mobileqq.msf.core.a.a.aM()) || (com.tencent.mobileqq.msf.core.net.a.b.e)) {
            this.e.A = (paramFromServiceMsg.uint32_hello_interval.get() * 1000);
          }
          this.e.a(this.e.e());
          w.c(paramFromServiceMsg.str_clientip.get());
          return;
        }
        this.e.b.getStatReporter().a(false, l1 - l2, paramFromServiceMsg.getBusinessFailCode(), l3);
        this.e.a(180000L);
        return;
      }
      catch (Throwable paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        this.e.a(this.e.e());
      }
    }
  }
  
  void b(String paramString)
  {
    if (c.a()) {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager:PushCoder", 2, paramString + " is running, no need send SvcRequestPullUnreadMsgCountReq");
      }
    }
    do
    {
      return;
      paramString = (a)this.e.h.get(paramString);
      if (MsfService.getCore().getUinPushStatus(paramString.k.uin) != 95) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.PushManager:PushCoder", 2, "on recvOfflineMsg status don't start QQ");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager:PushCoder", 2, "QQ not running, send SvcRequestPullUnreadMsgCountReq now");
    }
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName(v);
    localUniPacket.setFuncName(u);
    Object localObject = new com.tencent.msf.service.protocol.a.a();
    ((com.tencent.msf.service.protocol.a.a)localObject).a = true;
    ((com.tencent.msf.service.protocol.a.a)localObject).b = true;
    ((com.tencent.msf.service.protocol.a.a)localObject).c = true;
    localUniPacket.put("req_PullUnreadMsgCount", localObject);
    localObject = new ToServiceMsg("", paramString.k.uin, "MessageSvc.PullUnreadMsgCount");
    ((ToServiceMsg)localObject).setAppId(paramString.a);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
    ((ToServiceMsg)localObject).setNeedCallback(true);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).putWupBuffer(localUniPacket.encode());
    try
    {
      this.e.b.sendSsoMsg((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("MSF.C.PushManager:PushCoder", 1, "query push error " + paramString, paramString);
    }
  }
  
  void c(String paramString)
  {
    f.q = true;
    a();
    NetConnInfoCenterImpl.callQQProcess(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\push\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */