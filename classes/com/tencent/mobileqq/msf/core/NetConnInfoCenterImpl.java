package com.tencent.mobileqq.msf.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.c.i;
import com.tencent.mobileqq.msf.core.c.m;
import com.tencent.mobileqq.msf.core.net.b.n;
import com.tencent.mobileqq.msf.core.net.h;
import com.tencent.mobileqq.msf.core.push.f;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.security.c;
import com.tencent.msf.service.protocol.security.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class NetConnInfoCenterImpl
{
  public static final int CONFIGDEFAULTAPPID = 100;
  public static final String KEY_RECORD_SERVER_TIME = "recordSysTimeKey";
  private static int _activeNetInfoType = 0;
  static int _dayOfYear = 0;
  private static String _lastMobileApn;
  private static String _lastWifiSSID;
  private static AtomicBoolean _netSupport;
  static String currentAPN;
  private static long lastCheckTime = 0L;
  private static long lastCompareTime = 0L;
  private static AtomicBoolean lastConnSuccWithoutNet;
  private static long lastConnSuccWithoutNetTime = 0L;
  private static int mobileNetworkType = 0;
  private static final byte mobileStat = 0;
  public static MsfCore msfCore;
  static boolean needWifiAuth = false;
  static AtomicInteger netChangeCount;
  private static final String serverTimeDiffKey = "servetTimeDiff";
  static String subtypeName;
  static String tag = "MSF.C.NetConnInfoCenter";
  private static final byte wifiStat = 1;
  boolean calculateSignalLevel = true;
  private long firstGetServerTime;
  int lastCdmaStrenght;
  private long lastGetServerTimeInterval;
  int lastGsmStrength;
  int lastWifiStrength;
  private int sendGetServerTimeMsgCount;
  
  static
  {
    netChangeCount = new AtomicInteger(0);
    _dayOfYear = Calendar.getInstance().get(6);
    _netSupport = new AtomicBoolean(false);
    lastCheckTime = -1L;
    lastConnSuccWithoutNet = new AtomicBoolean();
    currentAPN = "";
    subtypeName = "";
  }
  
  public static void callQQProcess(String paramString)
  {
    int i = 0;
    try
    {
      if (f.q)
      {
        long l = com.tencent.mobileqq.msf.core.a.a.V();
        Object localObject = new Intent(paramString);
        paramString = f.r;
        if (msfCore != null) {
          i = msfCore.getUinPushStatus(paramString);
        }
        ((Intent)localObject).putExtra("uin", paramString);
        ((Intent)localObject).putExtra("istatus", i);
        ((Intent)localObject).putExtra("gatewayip", w.j());
        if (l > 0L)
        {
          localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
          ((AlarmManager)BaseApplication.getContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + com.tencent.mobileqq.msf.core.a.a.V(), (PendingIntent)localObject);
          QLog.d(tag, 1, "send bootAction for QQ " + MsfSdkUtils.getShortUin(paramString) + " delayed: " + l);
        }
        for (;;)
        {
          f.q = false;
          return;
          BaseApplication.getContext().sendBroadcast((Intent)localObject);
          QLog.d(tag, 1, "send bootAction for QQ " + MsfSdkUtils.getShortUin(paramString) + " right now");
        }
      }
      QLog.d(tag, 1, "not need send bootAction for QQ");
    }
    catch (Exception paramString)
    {
      QLog.d(tag, 1, "send bootAction for QQ error " + paramString);
      return;
    }
  }
  
  private void closeNowConn()
  {
    if ((msfCore != null) && (msfCore.sender != null)) {
      msfCore.sender.a(com.tencent.qphone.base.a.b);
    }
  }
  
  public static String getCurrentAPN()
  {
    return currentAPN;
  }
  
  public static String getLastWifiSSID()
  {
    return _lastWifiSSID;
  }
  
  public static int getMobileNetworkType()
  {
    return mobileNetworkType;
  }
  
  private static String getNetStatusMsg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "NONE";
    case 1: 
      return "MOBILE";
    case 2: 
      return "WiFi";
    }
    return "WiFi";
  }
  
  public static String getNetSubtypeName()
  {
    return subtypeName;
  }
  
  public static int getSystemNetState()
  {
    if (isWifiConn()) {
      return 2;
    }
    if (isMobileConn()) {
      return 1;
    }
    return 0;
  }
  
  public static int getSystemNetworkType()
  {
    int i = 0;
    if (isWifiConn()) {
      i = _activeNetInfoType;
    }
    while (!isMobileConn()) {
      return i;
    }
    return getMobileNetworkType() + 10000;
  }
  
  public static InetAddress intToInetAddress(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)(paramInt >> 8 & 0xFF);
    int k = (byte)(paramInt >> 16 & 0xFF);
    int m = (byte)(paramInt >> 24 & 0xFF);
    try
    {
      InetAddress localInetAddress = InetAddress.getByAddress(new byte[] { i, j, k, m });
      return localInetAddress;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      throw new AssertionError();
    }
  }
  
  public static boolean isMobileConn()
  {
    return _activeNetInfoType == 1;
  }
  
  public static boolean isMobileNetworkInfo(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo.getType() == 0) || (50 == paramNetworkInfo.getType());
  }
  
  public static boolean isNeedWifiAuth()
  {
    return needWifiAuth;
  }
  
  public static boolean isNetSupport()
  {
    return _netSupport.get();
  }
  
  public static boolean isWifiConn()
  {
    return (_activeNetInfoType == 2) || (_activeNetInfoType == 3);
  }
  
  public static boolean isWifiOrMobileConn()
  {
    return (isWifiConn()) || (isMobileConn());
  }
  
  private void mobileConnected(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo != null) {
      mobileNetworkType = paramNetworkInfo.getSubtype();
    }
    for (;;)
    {
      setConnInfo(_activeNetInfoType | 0x1);
      return;
      try
      {
        mobileNetworkType = ((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getNetworkType();
      }
      catch (Exception paramNetworkInfo)
      {
        paramNetworkInfo.printStackTrace();
      }
    }
  }
  
  private void mobileDisConnected()
  {
    setConnInfo(_activeNetInfoType & 0xFFFFFFFE);
  }
  
  private void onMobileConnChnaged()
  {
    if ((isMobileConn()) && (msfCore != null) && (msfCore.standbyModeManager != null)) {
      msfCore.standbyModeManager.d();
    }
  }
  
  private void onWifiConnChanged()
  {
    if (isWifiConn()) {
      if ((msfCore != null) && (msfCore.sender != null))
      {
        msfCore.sender.a.h.a(_lastWifiSSID);
        if (msfCore.standbyModeManager != null) {
          msfCore.standbyModeManager.e();
        }
      }
    }
    while ((msfCore == null) || (msfCore.sender == null)) {
      return;
    }
    msfCore.sender.a.h.a();
  }
  
  private static void resetLastConnSuccWithoutNet()
  {
    lastConnSuccWithoutNet.set(false);
    lastConnSuccWithoutNetTime = 0L;
  }
  
  private void sendNewCheckServerTime()
  {
    if (msfCore != null)
    {
      localToServiceMsg = new ToServiceMsg("", "0", "Client.CorrectTime");
      localToServiceMsg.setMsfCommand(MsfCommand.getServerTime);
      if (msfCore.sender.f() == -1)
      {
        i = 100;
        localToServiceMsg.setAppId(i);
        localToServiceMsg.setTimeout(30000L);
        localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
        localToServiceMsg.addAttribute("__base_tag_isAppMsg", Boolean.valueOf(true));
        localToServiceMsg.putWupBuffer(MsfSdkUtils.convertInt2Bytes(4));
        msfCore.sender.b(localToServiceMsg);
      }
    }
    while (!QLog.isDevelopLevel()) {
      for (;;)
      {
        ToServiceMsg localToServiceMsg;
        return;
        int i = msfCore.sender.f();
      }
    }
    QLog.d(tag, 4, "msfCore not inited. can not send checkServerTimeMsg.");
  }
  
  private void sendOldCheckServerTime()
  {
    if (msfCore != null)
    {
      localToServiceMsg = new ToServiceMsg("", "0", "login.time");
      localToServiceMsg.setMsfCommand(MsfCommand.getServerTime);
      if (msfCore.sender.f() == -1)
      {
        i = 100;
        localToServiceMsg.setAppId(i);
        localToServiceMsg.setTimeout(30000L);
        localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
        localUniPacket = new UniPacket(true);
        localUniPacket.setServantName("test");
        localUniPacket.setFuncName("cmdstr");
        locald = new d(1, 15, MsfCore.getNextSeq(), 1, "0", msfCore.sender.f(), String.valueOf(msfCore.sender.f()), "123", 0);
        localc = new c();
        localc.a = ((int)(System.currentTimeMillis() / 1000L));
        localUniPacket.put("RequestHeader", locald);
        localUniPacket.put("RequestGetServerTime", localc);
        localToServiceMsg.putWupBuffer(localUniPacket.encode());
        msfCore.sender.b(localToServiceMsg);
      }
    }
    while (!QLog.isDevelopLevel()) {
      for (;;)
      {
        ToServiceMsg localToServiceMsg;
        UniPacket localUniPacket;
        d locald;
        c localc;
        return;
        int i = msfCore.sender.f();
      }
    }
    QLog.d(tag, 4, "msfCore not inited. can not send checkServerTimeMsg.");
  }
  
  public static void setLastConnSuccWithoutNet()
  {
    lastConnSuccWithoutNetTime = System.currentTimeMillis();
    lastConnSuccWithoutNet.set(true);
  }
  
  static void setMsfCore(MsfCore paramMsfCore)
  {
    msfCore = paramMsfCore;
    NetConnInfoCenter.servetTimeSecondInterv = BaseApplication.getContext().getSharedPreferences(tag, 0).getLong("servetTimeDiff", 0L);
  }
  
  public static void setNeedWifiAuth(boolean paramBoolean)
  {
    needWifiAuth = paramBoolean;
  }
  
  public static void setNetSupport(boolean paramBoolean)
  {
    _netSupport.set(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(tag, 2, "setNetSupport " + _netSupport.get());
    }
  }
  
  private void wifiConnected()
  {
    WifiInfo localWifiInfo = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
    if (localWifiInfo != null)
    {
      int i = localWifiInfo.getIpAddress();
      if (QLog.isColorLevel()) {
        QLog.d(tag, 2, "wifiConnected localAddress " + i + "(" + intToInetAddress(i).getHostAddress() + "), " + localWifiInfo.toString());
      }
      if (msfCore != null) {
        msfCore.getStatReporter().a(localWifiInfo);
      }
    }
    setConnInfo(_activeNetInfoType | 0x2);
  }
  
  private void wifiDisConnected()
  {
    setConnInfo(_activeNetInfoType & 0xFFFFFFFD);
  }
  
  public void checkConnInfo(Context paramContext, NetworkInfo paramNetworkInfo)
  {
    checkConnInfo(paramContext, paramNetworkInfo, false);
  }
  
  public void checkConnInfo(Context paramContext, NetworkInfo paramNetworkInfo, boolean paramBoolean)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramBoolean) {
      i.e();
    }
    checkConnInfo(localConnectivityManager.getActiveNetworkInfo(), paramNetworkInfo);
    try
    {
      paramContext = localConnectivityManager.getNetworkInfo(0);
      if (paramContext != null) {
        break label98;
      }
      paramContext = localConnectivityManager.getNetworkInfo(50);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.d(tag, 1, "get currentAPN error " + paramContext);
      }
    }
    if (paramContext != null) {
      currentAPN = paramContext.getExtraInfo();
    }
    if (paramBoolean) {
      i.e();
    }
  }
  
  public void checkConnInfo(NetworkInfo paramNetworkInfo1, NetworkInfo paramNetworkInfo2)
  {
    String str;
    if (paramNetworkInfo1 != null) {
      str = paramNetworkInfo1.getTypeName();
    }
    do
    {
      do
      {
        try
        {
          subtypeName = paramNetworkInfo1.getSubtypeName();
          if (str.toLowerCase().contains("mobile_mms")) {
            return;
          }
        }
        catch (Exception localException)
        {
          do
          {
            do
            {
              do
              {
                for (;;)
                {
                  QLog.d(tag, 1, "get subtypeName error " + localException);
                }
                QLog.d(tag, 1, "currentAPN:" + currentAPN + ". received networkInfo: " + paramNetworkInfo1.getDetailedState() + " :" + paramNetworkInfo1 + ". extra NetworkInfo: " + paramNetworkInfo2);
                if ((!paramNetworkInfo1.isAvailable()) || (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.CONNECTED)) {
                  break;
                }
                if (1 == paramNetworkInfo1.getType())
                {
                  wifiConnected();
                  return;
                }
              } while (!isMobileNetworkInfo(paramNetworkInfo1));
              wifiDisConnected();
              mobileConnected(paramNetworkInfo1);
              return;
            } while ((paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED) && (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.FAILED) && (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.IDLE) && (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.SUSPENDED));
            if (1 == paramNetworkInfo1.getType())
            {
              wifiDisConnected();
              return;
            }
          } while (!isMobileNetworkInfo(paramNetworkInfo1));
          mobileDisConnected();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(tag, 2, "currentAPN:" + currentAPN + ". active NetworkInfo: " + paramNetworkInfo1 + ". extra NetworkInfo: " + paramNetworkInfo2);
        }
      } while ((paramNetworkInfo2 == null) || ((paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED) && (paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.FAILED) && (paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.IDLE) && (paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.SUSPENDED)));
      if (1 == paramNetworkInfo2.getType())
      {
        wifiDisConnected();
        return;
      }
    } while (!isMobileNetworkInfo(paramNetworkInfo2));
    mobileDisConnected();
  }
  
  public void checkRecordTime()
  {
    try
    {
      long l = SystemClock.elapsedRealtime();
      if ((0L != lastCompareTime) && (l > lastCompareTime + com.tencent.mobileqq.msf.core.a.a.L()))
      {
        lastCompareTime = l;
        String str;
        if ((-1L == lastCheckTime) && (MsfStore.getNativeConfigStore() != null))
        {
          str = MsfStore.getNativeConfigStore().getConfig("recordSysTimeKey");
          if (str == null) {}
        }
        try
        {
          lastCheckTime = Long.parseLong(str);
          l = System.currentTimeMillis();
          if (-1L != lastCheckTime)
          {
            if (l <= lastCheckTime + com.tencent.mobileqq.msf.core.a.a.J() + Math.random() * com.tencent.mobileqq.msf.core.a.a.K()) {
              return;
            }
            checkServerTime();
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d(tag, 2, "get lastCheckTime catch Exception " + localException1);
            }
          }
        }
      }
      return;
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel())
      {
        QLog.d(tag, 2, "checkRecordTime catch Exception " + localException2);
        return;
        lastCheckTime = l;
        if (MsfStore.getNativeConfigStore() != null)
        {
          MsfStore.getNativeConfigStore().n_setConfig("recordSysTimeKey", String.valueOf(lastCheckTime));
          return;
          if (0L == lastCompareTime) {
            lastCompareTime = l;
          }
        }
      }
    }
  }
  
  public void checkServerTime()
  {
    System.currentTimeMillis();
    long l1 = SystemClock.elapsedRealtime();
    if ((l1 - this.lastGetServerTimeInterval > 0L) && (l1 - this.lastGetServerTimeInterval <= com.tencent.mobileqq.msf.core.a.a.I()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(tag, 2, "quit to checkTimeMsg too frequency.");
      }
      return;
    }
    if (this.sendGetServerTimeMsgCount < 10)
    {
      sendNewCheckServerTime();
      this.sendGetServerTimeMsgCount += 1;
      this.lastGetServerTimeInterval = l1;
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if ((this.firstGetServerTime == 0L) || (l1 - this.firstGetServerTime > 600000L))
      {
        this.firstGetServerTime = l1;
        this.sendGetServerTimeMsgCount = 0;
      }
      lastCheckTime = l2;
      if (MsfStore.getNativeConfigStore() == null) {
        break;
      }
      MsfStore.getNativeConfigStore().n_setConfig("recordSysTimeKey", String.valueOf(l2));
      return;
      if (QLog.isColorLevel()) {
        QLog.d(tag, 2, "also send checkTimeMsg " + this.sendGetServerTimeMsgCount);
      }
    }
  }
  
  void checkWifiSignalStrengths()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.calculateSignalLevel;
        if (!bool) {
          break label124;
        }
        try
        {
          Object localObject1 = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
          if (localObject1 != null)
          {
            localObject1 = ((WifiManager)localObject1).getConnectionInfo();
            if (localObject1 == null) {
              continue;
            }
            i = 1;
            if (((WifiInfo)localObject1).getBSSID() == null) {
              continue;
            }
            j = 1;
            if ((j & i) != 0) {
              this.lastWifiStrength = WifiManager.calculateSignalLevel(((WifiInfo)localObject1).getRssi(), 32);
            }
          }
        }
        catch (Exception localException)
        {
          int i;
          int j;
          QLog.d(tag, 1, "check WifiState error " + localException, localException);
          this.calculateSignalLevel = false;
          continue;
        }
        return;
      }
      finally {}
      i = 0;
      continue;
      j = 0;
      continue;
      label124:
      this.lastWifiStrength = 0;
    }
  }
  
  public void handleGetServerTimeResp(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(tag, 4, "handleGetServerTimeResp servertime is " + paramLong);
    }
    NetConnInfoCenter.servetTimeSecondInterv = paramLong - System.currentTimeMillis() / 1000L;
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(tag, 0).edit();
    localEditor.putLong("servetTimeDiff", NetConnInfoCenter.servetTimeSecondInterv);
    localEditor.commit();
    if (QLog.isColorLevel()) {
      QLog.d(tag, 2, "set serverTime is " + msfCore.timeFormatter.format(Long.valueOf(System.currentTimeMillis() + NetConnInfoCenter.servetTimeSecondInterv * 1000L)));
    }
    MsfCore.initAppProMsg("*", msfCore.sender.f());
  }
  
  public void onConnClosed(com.tencent.qphone.base.a parama)
  {
    NetConnInfoCenter.socketConnState = 1;
    if ((msfCore != null) || (msfCore.pushManager != null)) {
      try
      {
        msfCore.pushManager.a(parama);
        if ((msfCore.standbyModeManager != null) && (!msfCore.standbyModeManager.b()))
        {
          parama = new FromServiceMsg(msfCore.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connClosed");
          parama.setMsgSuccess();
          parama.setMsfCommand(MsfCommand.onConnClosed);
          MsfSdkUtils.addFromMsgProcessName("*", parama);
          msfCore.addRespToQuque(null, parama);
          return;
        }
        QLog.d(tag, 1, "onConnClosed, stop notify by standby");
        return;
      }
      catch (Exception parama)
      {
        QLog.d(tag, 1, "", parama);
      }
    }
  }
  
  public void onConnOpened(String paramString1, String paramString2)
  {
    NetConnInfoCenter.socketConnState = 2;
    if (msfCore == null)
    {
      QLog.d(tag, 1, "onConnOpened, return by msfCore null");
      return;
    }
    msfCore.pushManager.d();
    if ((msfCore.standbyModeManager != null) && (!msfCore.standbyModeManager.b()))
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(msfCore.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connOpened");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localFromServiceMsg.setMsfCommand(MsfCommand.onConnOpened);
      localFromServiceMsg.addAttribute("resp_connopen_serverAdd", paramString1);
      localFromServiceMsg.addAttribute("resp_connopen_localAdd", paramString2);
      if (msfCore.pushManager.b()) {
        localFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
      }
      MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
      msfCore.addRespToQuque(null, localFromServiceMsg);
      return;
    }
    if (msfCore.standbyModeManager != null) {
      msfCore.standbyModeManager.g();
    }
    QLog.d(tag, 1, "onConnOpened, stop notify by standby");
  }
  
  public void onOepnConnAllFailed()
  {
    if ((msfCore != null) && (msfCore.standbyModeManager != null) && (!msfCore.standbyModeManager.b()))
    {
      NetConnInfoCenter.socketConnState = 3;
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(msfCore.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connAllFailed");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localFromServiceMsg.setMsfCommand(MsfCommand.onOepnConnAllFailed);
      if (msfCore.pushManager.b()) {
        localFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
      }
      MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
      msfCore.addRespToQuque(null, localFromServiceMsg);
    }
    for (;;)
    {
      if ((msfCore != null) && (msfCore.sender != null)) {
        msfCore.sender.a.h.b();
      }
      return;
      QLog.d(tag, 1, "onOepnConnAllFailed, stop notify by standby");
    }
  }
  
  public void onRecvFirstResp()
  {
    if ((isWifiConn()) && (msfCore != null) && (msfCore.sender != null)) {
      msfCore.sender.a.h.b(_lastWifiSSID);
    }
    if ((msfCore.standbyModeManager != null) && (!msfCore.standbyModeManager.b()))
    {
      NetConnInfoCenter.socketConnState = 4;
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(msfCore.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_recvFirstResp");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localFromServiceMsg.setMsfCommand(MsfCommand.onReceFirstResp);
      if (msfCore.pushManager.b()) {
        localFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
      }
      MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
      msfCore.addRespToQuque(null, localFromServiceMsg);
      return;
    }
    QLog.d(tag, 1, "onRecvFirstResp, stop notify by standby");
  }
  
  public void registerSignalStrengthsChanged(Context paramContext)
  {
    Object localObject = new a(null);
    ((TelephonyManager)paramContext.getSystemService("phone")).listen((PhoneStateListener)localObject, 256);
    localObject = new b(null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.RSSI_CHANGED");
    paramContext.registerReceiver((BroadcastReceiver)localObject, localIntentFilter);
  }
  
  /* Error */
  public void setConnInfo(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 859	com/tencent/mobileqq/msf/core/a/d:c	()Ljava/lang/String;
    //   5: astore_2
    //   6: invokestatic 861	com/tencent/mobileqq/msf/core/a/d:b	()Ljava/lang/String;
    //   9: astore_3
    //   10: getstatic 271	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   13: iload_1
    //   14: if_icmpne +257 -> 271
    //   17: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +54 -> 74
    //   23: getstatic 63	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   26: iconst_2
    //   27: new 190	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 863
    //   37: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokestatic 865	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:isNetSupport	()Z
    //   43: invokevirtual 492	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   46: ldc_w 867
    //   49: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: iload_1
    //   53: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: ldc_w 869
    //   59: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: getstatic 271	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   65: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_2
    //   75: ifnull +96 -> 171
    //   78: getstatic 247	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   81: ifnull +13 -> 94
    //   84: getstatic 247	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   87: aload_2
    //   88: invokevirtual 873	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   91: ifne +80 -> 171
    //   94: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +42 -> 139
    //   100: getstatic 63	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   103: iconst_2
    //   104: new 190	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 875
    //   114: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_2
    //   118: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc_w 877
    //   124: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: getstatic 247	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   130: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload_2
    //   140: putstatic 247	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   143: getstatic 134	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   146: ifnull +25 -> 171
    //   149: getstatic 134	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   152: getfield 881	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   155: ifnull +16 -> 171
    //   158: getstatic 134	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   161: getfield 881	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   164: invokevirtual 883	com/tencent/mobileqq/msf/core/a/d:f	()V
    //   167: aload_0
    //   168: invokespecial 885	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:onWifiConnChanged	()V
    //   171: aload_3
    //   172: ifnull +96 -> 268
    //   175: getstatic 887	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   178: ifnull +13 -> 191
    //   181: getstatic 887	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   184: aload_3
    //   185: invokevirtual 873	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   188: ifne +80 -> 268
    //   191: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +42 -> 236
    //   197: ldc_w 889
    //   200: iconst_2
    //   201: new 190	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 891
    //   211: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_3
    //   215: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 893
    //   221: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: getstatic 887	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   227: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload_3
    //   237: putstatic 887	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   240: getstatic 134	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   243: ifnull +21 -> 264
    //   246: getstatic 134	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   249: getfield 881	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   252: ifnull +12 -> 264
    //   255: getstatic 134	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   258: getfield 881	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   261: invokevirtual 894	com/tencent/mobileqq/msf/core/a/d:e	()V
    //   264: aload_0
    //   265: invokespecial 896	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:onMobileConnChnaged	()V
    //   268: aload_0
    //   269: monitorexit
    //   270: return
    //   271: iload_1
    //   272: ifle +258 -> 530
    //   275: iconst_1
    //   276: invokestatic 898	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:setNetSupport	(Z)V
    //   279: getstatic 98	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:lastConnSuccWithoutNet	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   282: invokevirtual 299	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   285: ifeq +74 -> 359
    //   288: new 900	java/util/HashMap
    //   291: dup
    //   292: invokespecial 901	java/util/HashMap:<init>	()V
    //   295: astore 4
    //   297: aload 4
    //   299: ldc_w 903
    //   302: invokestatic 184	java/lang/System:currentTimeMillis	()J
    //   305: getstatic 352	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:lastConnSuccWithoutNetTime	J
    //   308: lsub
    //   309: ldc2_w 449
    //   312: ldiv
    //   313: invokestatic 673	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   316: invokeinterface 908 3 0
    //   321: pop
    //   322: aload 4
    //   324: ldc_w 910
    //   327: iload_1
    //   328: invokestatic 440	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   331: invokeinterface 908 3 0
    //   336: pop
    //   337: getstatic 134	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   340: invokevirtual 525	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/m;
    //   343: ldc_w 912
    //   346: iconst_0
    //   347: lconst_0
    //   348: lconst_0
    //   349: aload 4
    //   351: iconst_0
    //   352: iconst_0
    //   353: invokevirtual 915	com/tencent/mobileqq/msf/core/c/m:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   356: invokestatic 917	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:resetLastConnSuccWithoutNet	()V
    //   359: getstatic 271	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   362: invokestatic 919	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:getNetStatusMsg	(I)Ljava/lang/String;
    //   365: astore 4
    //   367: iload_1
    //   368: invokestatic 919	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:getNetStatusMsg	(I)Ljava/lang/String;
    //   371: astore 5
    //   373: getstatic 63	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   376: iconst_1
    //   377: new 190	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   384: ldc_w 921
    //   387: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload 4
    //   392: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: ldc_w 923
    //   398: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload 5
    //   403: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: aload_0
    //   413: invokevirtual 925	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:checkWifiSignalStrengths	()V
    //   416: iload_1
    //   417: iconst_2
    //   418: if_icmpeq +8 -> 426
    //   421: iload_1
    //   422: iconst_3
    //   423: if_icmpne +399 -> 822
    //   426: iconst_1
    //   427: istore 8
    //   429: iload 8
    //   431: invokestatic 927	com/tencent/mobileqq/msf/core/c/i:a	(Z)V
    //   434: ldc 100
    //   436: invokestatic 929	com/tencent/mobileqq/msf/core/w:c	(Ljava/lang/String;)V
    //   439: iconst_0
    //   440: invokestatic 931	com/tencent/mobileqq/msf/core/w:d	(I)V
    //   443: iconst_0
    //   444: istore 7
    //   446: iload_1
    //   447: iconst_1
    //   448: if_icmpne +386 -> 834
    //   451: iload 7
    //   453: istore 6
    //   455: getstatic 271	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   458: ifeq +15 -> 473
    //   461: getstatic 271	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   464: bipush -2
    //   466: if_icmpne +104 -> 570
    //   469: iload 7
    //   471: istore 6
    //   473: iload_1
    //   474: putstatic 271	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   477: aload_0
    //   478: invokespecial 885	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:onWifiConnChanged	()V
    //   481: aload_0
    //   482: invokespecial 896	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:onMobileConnChnaged	()V
    //   485: iload 6
    //   487: ifeq +7 -> 494
    //   490: aload_0
    //   491: invokespecial 933	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:closeNowConn	()V
    //   494: iload_1
    //   495: ifle -227 -> 268
    //   498: getstatic 134	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   501: ifnull -233 -> 268
    //   504: getstatic 134	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   507: getfield 755	com/tencent/mobileqq/msf/core/MsfCore:pushManager	Lcom/tencent/mobileqq/msf/core/push/f;
    //   510: ifnull -242 -> 268
    //   513: getstatic 134	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   516: getfield 755	com/tencent/mobileqq/msf/core/MsfCore:pushManager	Lcom/tencent/mobileqq/msf/core/push/f;
    //   519: invokevirtual 935	com/tencent/mobileqq/msf/core/push/f:c	()V
    //   522: goto -254 -> 268
    //   525: astore_2
    //   526: aload_0
    //   527: monitorexit
    //   528: aload_2
    //   529: athrow
    //   530: iconst_0
    //   531: invokestatic 898	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:setNetSupport	(Z)V
    //   534: goto -175 -> 359
    //   537: astore 4
    //   539: getstatic 63	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   542: iconst_1
    //   543: new 190	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   550: ldc_w 937
    //   553: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload 4
    //   558: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   567: goto -133 -> 434
    //   570: getstatic 271	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   573: iconst_2
    //   574: if_icmpeq +14 -> 588
    //   577: iload 7
    //   579: istore 6
    //   581: getstatic 271	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   584: iconst_3
    //   585: if_icmpne -112 -> 473
    //   588: aload_3
    //   589: ifnull +239 -> 828
    //   592: getstatic 887	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   595: ifnull +13 -> 608
    //   598: getstatic 887	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   601: aload_3
    //   602: invokevirtual 873	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   605: ifne +223 -> 828
    //   608: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   611: ifeq +42 -> 653
    //   614: ldc_w 889
    //   617: iconst_2
    //   618: new 190	java/lang/StringBuilder
    //   621: dup
    //   622: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   625: ldc_w 939
    //   628: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: aload_3
    //   632: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: ldc_w 893
    //   638: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: getstatic 887	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   644: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   653: aload_3
    //   654: putstatic 887	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   657: getstatic 134	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   660: ifnull +168 -> 828
    //   663: getstatic 134	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   666: getfield 881	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   669: ifnull +159 -> 828
    //   672: getstatic 134	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   675: getfield 881	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   678: invokevirtual 894	com/tencent/mobileqq/msf/core/a/d:e	()V
    //   681: goto +147 -> 828
    //   684: iload 7
    //   686: istore 6
    //   688: getstatic 271	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   691: ifeq -218 -> 473
    //   694: iload 7
    //   696: istore 6
    //   698: getstatic 271	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   701: bipush -2
    //   703: if_icmpeq -230 -> 473
    //   706: iload 7
    //   708: istore 6
    //   710: getstatic 271	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   713: iconst_1
    //   714: if_icmpne -241 -> 473
    //   717: aload_2
    //   718: ifnull +92 -> 810
    //   721: getstatic 247	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   724: ifnull +13 -> 737
    //   727: getstatic 247	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   730: aload_2
    //   731: invokevirtual 873	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   734: ifne +76 -> 810
    //   737: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   740: ifeq +42 -> 782
    //   743: getstatic 63	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   746: iconst_2
    //   747: new 190	java/lang/StringBuilder
    //   750: dup
    //   751: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   754: ldc_w 875
    //   757: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: aload_2
    //   761: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: ldc_w 877
    //   767: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: getstatic 247	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   773: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   782: aload_2
    //   783: putstatic 247	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   786: getstatic 134	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   789: ifnull +21 -> 810
    //   792: getstatic 134	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   795: getfield 881	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   798: ifnull +12 -> 810
    //   801: getstatic 134	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   804: getfield 881	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   807: invokevirtual 883	com/tencent/mobileqq/msf/core/a/d:f	()V
    //   810: iconst_1
    //   811: istore 6
    //   813: goto -340 -> 473
    //   816: iconst_1
    //   817: istore 6
    //   819: goto -346 -> 473
    //   822: iconst_0
    //   823: istore 8
    //   825: goto -396 -> 429
    //   828: iconst_1
    //   829: istore 6
    //   831: goto -358 -> 473
    //   834: iload_1
    //   835: iconst_2
    //   836: if_icmpeq -152 -> 684
    //   839: iload_1
    //   840: iconst_3
    //   841: if_icmpne -25 -> 816
    //   844: goto -160 -> 684
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	847	0	this	NetConnInfoCenterImpl
    //   0	847	1	paramInt	int
    //   5	135	2	str1	String
    //   525	258	2	localObject1	Object
    //   9	645	3	str2	String
    //   295	96	4	localObject2	Object
    //   537	20	4	localIOException	java.io.IOException
    //   371	31	5	str3	String
    //   453	377	6	i	int
    //   444	263	7	j	int
    //   427	397	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	74	525	finally
    //   78	94	525	finally
    //   94	139	525	finally
    //   139	171	525	finally
    //   175	191	525	finally
    //   191	236	525	finally
    //   236	264	525	finally
    //   264	268	525	finally
    //   275	359	525	finally
    //   359	416	525	finally
    //   429	434	525	finally
    //   434	443	525	finally
    //   455	469	525	finally
    //   473	485	525	finally
    //   490	494	525	finally
    //   498	522	525	finally
    //   530	534	525	finally
    //   539	567	525	finally
    //   570	577	525	finally
    //   581	588	525	finally
    //   592	608	525	finally
    //   608	653	525	finally
    //   653	681	525	finally
    //   688	694	525	finally
    //   698	706	525	finally
    //   710	717	525	finally
    //   721	737	525	finally
    //   737	782	525	finally
    //   782	810	525	finally
    //   429	434	537	java/io/IOException
  }
  
  private class a
    extends PhoneStateListener
  {
    private a() {}
    
    public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      super.onSignalStrengthsChanged(paramSignalStrength);
      int i = paramSignalStrength.getCdmaDbm();
      NetConnInfoCenterImpl.this.lastCdmaStrenght = i;
      int j = paramSignalStrength.getGsmSignalStrength();
      i = j;
      if (j == 99) {
        i = -3;
      }
      NetConnInfoCenterImpl.this.lastGsmStrength = i;
      NetConnInfoCenterImpl.this.checkWifiSignalStrengths();
    }
  }
  
  private class b
    extends BroadcastReceiver
  {
    private b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      NetConnInfoCenterImpl.this.checkWifiSignalStrengths();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\NetConnInfoCenterImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */