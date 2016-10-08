package com.tencent.mobileqq.msf.core;

import LBS.LBSInfo;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.push.f;
import com.tencent.mobileqq.msf.service.g;
import com.tencent.msf.service.protocol.QQWiFi.WiFiService;
import com.tencent.msf.service.protocol.QQWiFi.a;
import com.tencent.msf.service.protocol.QQWiFi.b;
import com.tencent.msf.service.protocol.QQWiFi.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class o
{
  public static final int A = 4;
  public static final int B = 5;
  public static final int C = 6;
  public static final int D = 1;
  public static final int E = 2;
  public static final int F = 3;
  static final String G = "health_manager";
  static int H = 0;
  static long I = 0L;
  static final int J = 1200000;
  static SensorManager K;
  static SensorEventListener L;
  static boolean M = true;
  static boolean N = false;
  public static int O = 1;
  public static int P = O + 1;
  public static int Q = P + 1;
  static int R = 0;
  static int S = 0;
  static int T = 99999999;
  static int U = 20000;
  static int V = 3000000;
  static volatile int W = 0;
  static volatile int X = 0;
  static volatile int Y = 0;
  static AtomicBoolean Z = new AtomicBoolean(false);
  public static final String a = "mobileqq.service";
  private static BroadcastReceiver aE = new u();
  static long aa = 0L;
  static final String ab = BaseApplication.getContext().getFilesDir() + File.separator + "step.info";
  static JSONObject ac;
  static final String ad = "4eY#X@~g.+U)2%$<";
  static AtomicBoolean ae = new AtomicBoolean(false);
  private static final String af = "QQWiFiScanManager";
  private static o ag;
  public static final String b = "MQQ.QQWiFiMgrServer.QQWiFiMgrObj";
  public static final String c = "AvailQQWiFiForMSF";
  public static final String d = "QQWifiSvc.AvailQQWiFiForMSF";
  public static final String e = "MQQ.WiFiMapServer.WiFiMapObj";
  public static final String f = "getNearbyAvailWiFiInfo";
  public static final String g = "QQWifiSvc.getNearbyAvailWiFiInfo";
  public static final long h = 25000L;
  public static final long i = 21600000L;
  public static final int j = 1001;
  public static final int k = 1003;
  public static final int l = 1004;
  public static final int m = 1007;
  public static final int n = 1008;
  public static final int o = 1009;
  public static final int p = -80;
  public static final int q = 20000;
  public static final int r = 1;
  public static final int s = 2;
  public static final int t = 4;
  public static final int u = 1;
  public static final int v = -1;
  public static final int w = 0;
  public static final int x = 1;
  public static final int y = 2;
  public static final int z = 3;
  private boolean aA = true;
  private boolean aB;
  private int aC = 1;
  private final BroadcastReceiver aD = new p(this);
  private MsfCore ah;
  private Context ai = BaseApplication.getContext();
  private a aj = new a(null);
  private Notification ak;
  private int al;
  private String am = "";
  private RemoteViews an;
  private LBSInfo ao;
  private long ap;
  private long aq;
  private long ar;
  private List as = Collections.synchronizedList(new ArrayList());
  private List at = Collections.synchronizedList(new ArrayList());
  private List au = Collections.synchronizedList(new ArrayList());
  private List av = Collections.synchronizedList(new ArrayList());
  private boolean aw;
  private boolean ax;
  private boolean ay;
  private boolean az;
  
  public static o a()
  {
    if (ag == null) {
      ag = new o();
    }
    return ag;
  }
  
  private String a(Context paramContext, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.aj.r))
    {
      if (QLog.isColorLevel()) {
        QLog.e("health_manager", 2, "getNotNetworkSupportSsidList mControlConfig.noNetSupport is empty");
      }
      return null;
    }
    paramContext = BaseApplication.getContext();
    int i1;
    SharedPreferences localSharedPreferences;
    int i2;
    if (Build.VERSION.SDK_INT > 10)
    {
      i1 = 4;
      localSharedPreferences = paramContext.getSharedPreferences("no_network_support_qqwifi", i1);
      paramContext = new StringBuffer();
      try
      {
        localJSONArray1 = new JSONArray(this.aj.r);
        i5 = localJSONArray1.length();
        i1 = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          JSONArray localJSONArray1;
          int i5;
          JSONObject localJSONObject1;
          JSONArray localJSONArray2;
          int i6;
          int i4;
          continue;
          i1 += 1;
        }
      }
      if (i1 < i5)
      {
        localJSONObject1 = localJSONArray1.getJSONObject(i1);
        if ((localJSONObject1 == null) || ((paramBoolean) && (localJSONObject1.optInt("canPush") != 1))) {
          break label277;
        }
        localJSONArray2 = localJSONObject1.optJSONArray("jar");
        i6 = localJSONArray2.length();
        i4 = 0;
        i2 = 0;
      }
    }
    for (;;)
    {
      int i3 = i4;
      if (i2 < i6)
      {
        JSONObject localJSONObject2 = localJSONArray2.optJSONObject(i2);
        String str = localJSONObject2.optString("pkgid");
        i3 = localJSONObject2.optInt("limitVersion");
        if ((localSharedPreferences.contains(str)) && (localSharedPreferences.getInt(str, 0) > i3)) {
          i3 = 1;
        }
      }
      else
      {
        if (i3 != 0)
        {
          paramContext.append(localJSONObject1.optString("ssid"));
          paramContext.append("|");
          break label277;
          if (paramContext.length() > 0) {
            paramContext.delete(paramContext.length() - 1, paramContext.length());
          }
          return paramContext.toString();
        }
        label277:
        i1 = 0;
        break;
      }
      i2 += 1;
    }
  }
  
  private Map a(Context paramContext)
  {
    try
    {
      paramContext = a(new File(paramContext.getDir("qqwifi_dir", 0), "params_file"));
      if (TextUtils.isEmpty(paramContext)) {
        return null;
      }
      paramContext = new JSONObject(paramContext);
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramContext.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramContext.getString(str));
      }
      return localHashMap;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
  }
  
  public static void a(int paramInt)
  {
    if (paramInt == P)
    {
      QLog.i("health_manager", 1, "msf ondestory!");
      if (N)
      {
        BaseApplication.getContext().unregisterReceiver(aE);
        N = false;
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (paramInt == O)
        {
          if (Build.VERSION.SDK_INT < 19) {
            continue;
          }
          K = (SensorManager)BaseApplication.getContext().getSystemService("sensor");
          Sensor localSensor = K.getDefaultSensor(19);
          if (localSensor == null) {
            continue;
          }
          if (!N) {}
          try
          {
            Object localObject = new IntentFilter();
            ((IntentFilter)localObject).addAction("android.intent.action.ACTION_SHUTDOWN");
            ((IntentFilter)localObject).addAction("MSF_Action_Refresh_Steps");
            BaseApplication.getContext().registerReceiver(aE, (IntentFilter)localObject);
            N = true;
            localObject = new Intent("MSF_Action_Refresh_Steps");
            ((Intent)localObject).setAction("MSF_Action_Refresh_Steps");
            localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
            AlarmManager localAlarmManager = (AlarmManager)BaseApplication.getContext().getSystemService("alarm");
            Calendar localCalendar = Calendar.getInstance();
            localCalendar.set(11, 23);
            localCalendar.set(12, 55);
            localCalendar.set(13, 0);
            localAlarmManager.setRepeating(0, localCalendar.getTimeInMillis(), 86400000L, (PendingIntent)localObject);
            if (ac == null) {
              new Thread(new s()).start();
            }
            L = new t();
            try
            {
              localObject = K.getClass().getMethod("registerListener", new Class[] { SensorEventListener.class, Sensor.class, Integer.TYPE, Integer.TYPE });
              ((Method)localObject).setAccessible(true);
              ((Method)localObject).invoke(K, new Object[] { L, localSensor, Integer.valueOf(3), Integer.valueOf(360000000) });
              return;
            }
            catch (Exception localException1) {}
            if (QLog.isColorLevel())
            {
              QLog.e("health_manager", 2, "Exception:" + localException1.toString());
              return;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("health_manager", 2, "register receiver Exception:" + localException2.toString());
              }
            }
          }
        }
      }
    } while (paramInt != Q);
    Y += X - W;
    W = X;
    QLog.i("health_manager", 1, "system shut down set offset:" + Y + ",step:" + W);
    a(false, null, null);
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    Object localObject = BaseApplication.getContext();
    String str = this.aj.c;
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i1 = 4;; i1 = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences(str, i1);
      switch (paramInt)
      {
      default: 
        return;
      }
    }
    paramInt = ((SharedPreferences)localObject).getInt("showQQWiFiNotifyCount", 0);
    ((SharedPreferences)localObject).edit().putInt("showQQWiFiNotifyCount", paramInt + 1).commit();
    return;
    ((SharedPreferences)localObject).edit().putInt("QQWiFiShowRedTouch", paramBundle.getInt("id")).commit();
    return;
    paramInt = ((SharedPreferences)localObject).getInt("showQQWiFiAvailExtend", 0);
    ((SharedPreferences)localObject).edit().putInt("showQQWiFiAvailExtend", paramInt + 1).commit();
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.aj.b) {}
    do
    {
      do
      {
        return;
      } while ((!c(paramInt)) && (!paramBoolean2));
      a(paramInt, paramString, paramBoolean1);
      this.al = paramInt;
      this.am = paramString;
    } while (paramInt == 1008);
    this.ay = true;
  }
  
  private void a(Intent paramIntent, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    NotificationManager localNotificationManager = (NotificationManager)BaseApplication.getContext().getSystemService("notification");
    if (this.an == null) {
      this.an = new RemoteViews(BaseApplication.getContext().getPackageName(), BaseApplication.qqWifiLayout);
    }
    Object localObject;
    int i1;
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.an.setImageViewResource(BaseApplication.qqWifiSettingViewId, BaseApplication.qqWifiSettings);
      this.an.setViewVisibility(BaseApplication.qqWifiRedTouchViewId, 8);
      localObject = new Intent("com.tencent.mobileqq.msf.qqwifi.settings");
      ((Intent)localObject).putExtras(new Bundle());
      ((Intent)localObject).addFlags(603979776);
      localObject = PendingIntent.getActivity(BaseApplication.getContext(), 0, (Intent)localObject, 134217728);
      this.an.setOnClickPendingIntent(BaseApplication.qqWifiSettingViewId, (PendingIntent)localObject);
      localObject = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label672;
      }
      i1 = 4;
      localObject = ((BaseApplication)localObject).getSharedPreferences("qqwifi", i1);
      i1 = ((SharedPreferences)localObject).getInt("BarOperation_id", 0);
      if (i1 != 0)
      {
        boolean bool = ((SharedPreferences)localObject).getBoolean(this.aj.c + "hasClicked" + i1, false);
        long l1 = ((SharedPreferences)localObject).getLong("BarOperation_expiry", 0L);
        if ((!bool) && (System.currentTimeMillis() < l1 * 1000L))
        {
          int i2 = ((SharedPreferences)localObject).getInt("BarOperation_type", 0);
          localObject = ((SharedPreferences)localObject).getString("BarOperation_url", "");
          Intent localIntent = new Intent("com.tencent.mobileqq.msf.qqwifi.redtouch");
          localIntent.putExtra("type", i2);
          localIntent.putExtra("url", (String)localObject);
          localIntent.putExtra("id", i1);
          localIntent.addFlags(603979776);
          localObject = PendingIntent.getActivity(BaseApplication.getContext(), 0, localIntent, 134217728);
          this.an.setOnClickPendingIntent(BaseApplication.qqWifiRedTouchViewId, (PendingIntent)localObject);
          this.an.setImageViewResource(BaseApplication.qqWifiRedTouchViewId, BaseApplication.qqWifiOperation);
          this.an.setViewVisibility(BaseApplication.qqWifiRedTouchViewId, 0);
          localObject = new Bundle();
          ((Bundle)localObject).putInt("id", i1);
          a(2, (Bundle)localObject);
        }
      }
    }
    this.an.setImageViewResource(BaseApplication.qqWifiStateIconViewId, paramInt2);
    this.an.setTextViewText(BaseApplication.qqWifiStateTextSingleLine, paramString1);
    this.an.setViewVisibility(BaseApplication.qqWifiTextDoubleLine, 8);
    this.an.setViewVisibility(BaseApplication.qqWifiStateTextSingleLine, 0);
    if (this.ak == null)
    {
      this.ak = new Notification();
      if (Build.VERSION.SDK_INT >= 16) {
        this.ak.priority = 2;
      }
      localObject = this.ak;
      ((Notification)localObject).flags |= 0x20;
      this.ak.contentView = this.an;
    }
    if (paramInt1 == 1008)
    {
      this.ak.flags = 16;
      label535:
      paramIntent = PendingIntent.getActivity(BaseApplication.getContext(), f.H, paramIntent, 0);
      if (BaseApplication.qqWifiNoSignal != paramInt2) {
        break label690;
      }
      this.ak.icon = BaseApplication.qqwifinotifynoneicon;
      label564:
      if (paramString3 == null) {
        break label741;
      }
      this.ak.defaults = 1;
    }
    for (this.ak.tickerText = paramString3;; this.ak.tickerText = "")
    {
      this.ak.contentIntent = paramIntent;
      localNotificationManager.notify(f.H, this.ak);
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "type=" + paramInt1 + "," + paramString1 + ", " + paramString2 + "," + paramString3);
      }
      return;
      label672:
      i1 = 0;
      break;
      this.ak.flags = 32;
      break label535;
      label690:
      if (BaseApplication.qqWifiUserful == paramInt2)
      {
        this.ak.icon = BaseApplication.qqwifinotifyusefulicon;
        break label564;
      }
      if (BaseApplication.qqWifiConnecticon3 == paramInt2)
      {
        this.ak.icon = BaseApplication.qqwifinotifyconnectedicon;
        break label564;
      }
      this.ak.icon = paramInt2;
      break label564;
      label741:
      this.ak.defaults = 0;
    }
  }
  
  private void a(SharedPreferences paramSharedPreferences)
  {
    int i2 = 0;
    Object localObject1 = paramSharedPreferences;
    int i1;
    if (paramSharedPreferences == null)
    {
      paramSharedPreferences = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT > 10)
      {
        i1 = 4;
        localObject1 = paramSharedPreferences.getSharedPreferences("mobileQQ", i1);
      }
    }
    else if (localObject1 != null)
    {
      paramSharedPreferences = ((SharedPreferences)localObject1).getString("autoconnect_bssids", "");
      if (!TextUtils.isEmpty(paramSharedPreferences))
      {
        localObject1 = paramSharedPreferences.split("\\|");
        if ((localObject1 != null) && (localObject1.length != 0)) {
          break label140;
        }
        this.av.add(paramSharedPreferences);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "updateConfig, bssidsString=" + paramSharedPreferences + " ssid list=" + this.av.toString());
      }
      return;
      i1 = 0;
      break;
      label140:
      int i3 = localObject1.length;
      i1 = i2;
      while (i1 < i3)
      {
        Object localObject2 = localObject1[i1];
        this.av.add(localObject2);
        i1 += 1;
      }
    }
  }
  
  private void a(MsfCore paramMsfCore)
  {
    f();
    paramMsfCore = new IntentFilter();
    paramMsfCore.addAction("android.intent.action.SCREEN_ON");
    paramMsfCore.addAction("android.intent.action.SCREEN_OFF");
    paramMsfCore.addAction("android.net.wifi.SCAN_RESULTS");
    BaseApplication.getContext().registerReceiver(this.aD, paramMsfCore);
    e();
    if (this.aj.b) {
      ((WifiManager)this.ai.getSystemService("wifi")).startScan();
    }
  }
  
  public static void a(String paramString, ToServiceMsg paramToServiceMsg)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      do
      {
        return;
        if (((String)localObject).equals("cmd_refresh_steps"))
        {
          if (QLog.isColorLevel()) {
            QLog.i("health_manager", 2, "MSF_Action_Refresh_Steps:" + M);
          }
          if ((!M) && (K != null) && (L != null))
          {
            K.unregisterListener(L);
            K = null;
            L = null;
          }
          if ((!M) || (H <= X))
          {
            localObject = g.a(paramToServiceMsg);
            ((FromServiceMsg)localObject).setMsgSuccess();
            if (ac != null) {
              ((FromServiceMsg)localObject).addAttribute("StepInfoJSON", ac.toString());
            }
            com.tencent.mobileqq.msf.service.c.a(paramString, paramToServiceMsg, (FromServiceMsg)localObject);
            return;
          }
          X = H;
          a(true, paramString, paramToServiceMsg);
          return;
        }
        if (((String)localObject).equals("cmd_health_switch"))
        {
          localObject = g.a(paramToServiceMsg);
          ((FromServiceMsg)localObject).setMsgSuccess();
          boolean bool = ((Boolean)paramToServiceMsg.getAttribute("isOpen", Boolean.valueOf(false))).booleanValue();
          if (QLog.isColorLevel()) {
            QLog.i("health_manager", 2, "Action_Register_Step_Listener:" + bool);
          }
          if (bool) {}
          for (;;)
          {
            try
            {
              if (!M)
              {
                M = true;
                a(O);
              }
              X = H;
              a(false, null, null);
            }
            catch (Exception localException)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("health_manager", 2, "Exception:" + localException.toString());
              ((FromServiceMsg)localObject).setMsgFail();
              continue;
            }
            com.tencent.mobileqq.msf.service.c.a(paramString, paramToServiceMsg, (FromServiceMsg)localObject);
            return;
            M = false;
            if ((K != null) && (L != null))
            {
              if (QLog.isColorLevel()) {
                QLog.i("health_manager", 2, "step counter off.");
              }
              K.unregisterListener(L);
              K = null;
              L = null;
            }
          }
        }
      } while (!((String)localObject).equals("cmd_update_lastreport_time"));
      paramString = paramToServiceMsg.getAttribute("last_report_time");
      if ((paramString instanceof Long)) {
        aa = ((Long)paramString).longValue();
      }
      paramString = paramToServiceMsg.getAttribute("has_report_yes");
    } while ((!(paramString instanceof Boolean)) || (!((Boolean)paramString).booleanValue()));
    ac = new JSONObject();
    paramString = Calendar.getInstance();
    paramString.set(11, 0);
    paramString.set(12, 0);
    paramString.set(13, 0);
    paramString.set(14, 0);
    paramString = String.valueOf(paramString.getTimeInMillis());
    try
    {
      ac.put(paramString + "_offset", Y);
      ac.put(paramString + "_init", W);
      ac.put(paramString + "_total", X);
      ac.put("isStepCounterEnable", M);
      ac.put("last_report_time", aa);
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiScanManager", 2, "checkAvailForOperation");
    }
    boolean bool = c(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "processWiFiScanResultForBar, hasIntersection=" + bool);
    }
    if (bool) {
      d(paramArrayList);
    }
    Object localObject = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.c < -80) {
        localIterator.remove();
      } else {
        ((List)localObject).add(locald.b);
      }
    }
    if (!a(this.at, (List)localObject))
    {
      e(paramArrayList);
      this.at.clear();
      paramArrayList = ((List)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.at.add(localObject);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "processWiFiScanResultForOperation, isSubset=true");
    }
  }
  
  private void a(List paramList)
  {
    if (paramList != null) {
      try
      {
        if (paramList.isEmpty()) {
          return;
        }
        paramList = new ArrayList(paramList);
        if (QLog.isColorLevel()) {
          QLog.i("QQWiFiScanManager", 2, "startAutoConnect services all avail:" + paramList.toString());
        }
        if (!q())
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect isEnableAutoconnect false,return");
        }
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel())
        {
          paramList.printStackTrace();
          return;
          paramList = d(paramList);
          if ((paramList == null) || (paramList.isEmpty()))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect services empty after filtered,return");
            }
          }
          else if (b(paramList))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect in time protected,return");
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("QQWiFiScanManager", 2, "startAutoConnect services:" + paramList.toString());
            }
            this.ar = System.currentTimeMillis();
            Intent localIntent = new Intent("com.tencent.mobileqq.msf.qqwifi.autoconnect");
            localIntent.putExtra("services", new ArrayList(paramList));
            BaseApplication.getContext().sendBroadcast(localIntent);
          }
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, ToServiceMsg paramToServiceMsg)
  {
    if (X == 0.0F) {
      return;
    }
    new Thread(new v(paramBoolean, paramString, paramToServiceMsg)).start();
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    BaseApplication localBaseApplication;
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      localBaseApplication = BaseApplication.getContext();
      str = localBaseApplication.getPackageName() + "_preferences";
      if (Build.VERSION.SDK_INT <= 10) {
        break label87;
      }
    }
    label87:
    for (int i1 = 4;; i1 = 0)
    {
      bool = localBaseApplication.getSharedPreferences(str, i1).getBoolean("login_auto" + paramString, false);
      return bool;
    }
  }
  
  private boolean a(List paramList1, List paramList2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramList1 != null)
    {
      bool1 = bool2;
      if (paramList2 != null)
      {
        bool1 = bool2;
        if (paramList1.size() > 0)
        {
          Iterator localIterator = paramList2.iterator();
          int i1 = 0;
          while ((localIterator.hasNext()) && (paramList1.contains(localIterator.next()))) {
            i1 += 1;
          }
          bool1 = bool2;
          if (i1 == paramList2.size()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void b(int paramInt)
  {
    int i1 = 4;
    int i2 = 0;
    Object localObject;
    switch (paramInt)
    {
    default: 
    case 0: 
    case 2: 
    case 6: 
    case 1: 
      do
      {
        do
        {
          for (;;)
          {
            return;
            File localFile = new File(this.ai.getDir("qqwifi_dir", 0), "enable_file");
            if (localFile.exists()) {
              try
              {
                if (new JSONObject(a(localFile)).has("mIsQQWiFiEnable_" + this.aj.c)) {
                  this.aj.b = false;
                }
                if (QLog.isColorLevel())
                {
                  QLog.d("QQWiFiScanManager", 2, "updateConfig, mIsQQWiFiEnable_" + this.aj.c + "=" + this.aj.b);
                  return;
                }
              }
              catch (Exception localException1) {}
            }
          }
        } while (!QLog.isColorLevel());
        QLog.e("QQWiFiScanManager", 2, "updateConfig, enable_file exception");
        return;
        localObject = BaseApplication.getContext();
        if (Build.VERSION.SDK_INT > 10) {}
        for (;;)
        {
          localObject = ((BaseApplication)localObject).getSharedPreferences("mobileQQ", i1);
          if (localObject == null) {
            break;
          }
          this.aj.d = ((SharedPreferences)localObject).getInt("bar_switch_operation" + this.aj.c, 0);
          if (QLog.isColorLevel()) {
            QLog.d("QQWiFiScanManager", 2, "updateConfig, BarSwitch=" + this.aj.d);
          }
          if (this.aj.d != -1) {
            break;
          }
          this.ay = false;
          this.al = 0;
          return;
          i1 = 0;
        }
        localObject = BaseApplication.getContext();
        if (Build.VERSION.SDK_INT > 10) {}
        for (;;)
        {
          localObject = ((BaseApplication)localObject).getSharedPreferences("qqwifi", i1);
          this.aj.e = ((SharedPreferences)localObject).getBoolean("availNotificationSwitch", false);
          return;
          i1 = 0;
        }
        localObject = new File(this.ai.getDir("qqwifi_dir", 0), "ssids_file");
      } while (!((File)localObject).exists());
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONObject(a((File)localObject)).getJSONArray("ssidList");
        localObject = "";
        i1 = localJSONArray.length();
        paramInt = i2;
        if (paramInt < localJSONArray.length())
        {
          String str = (String)localObject + localJSONArray.get(paramInt).toString();
          localObject = str;
          if (paramInt >= i1 - 1) {
            break label587;
          }
          localObject = str + "|";
          break label587;
        }
        this.aj.a = ((String)localObject);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQWiFiScanManager", 2, "updateConfig, pattern - " + (String)localObject);
        return;
      }
      catch (Exception localException2) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("QQWiFiScanManager", 2, "updateConfig, ssids_file exception");
      return;
      u();
      return;
      b(null);
      return;
      a(null);
      return;
      label587:
      paramInt += 1;
    }
  }
  
  private void b(SharedPreferences paramSharedPreferences)
  {
    SharedPreferences localSharedPreferences = paramSharedPreferences;
    if (paramSharedPreferences == null)
    {
      paramSharedPreferences = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label112;
      }
    }
    label112:
    for (int i1 = 4;; i1 = 0)
    {
      localSharedPreferences = paramSharedPreferences.getSharedPreferences("mobileQQ", i1);
      if (localSharedPreferences != null)
      {
        this.aj.m = localSharedPreferences.getInt("autoconnect_switch_operation" + this.aj.c, 0);
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "updateConfig, AutoSwitch=" + this.aj.m);
        }
      }
      return;
    }
  }
  
  private void b(ArrayList paramArrayList)
  {
    boolean bool = c(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "processWiFiScanResultForBar, hasIntersection=" + bool);
    }
    if (bool) {
      if (n())
      {
        if (l()) {
          a(1008, "", false, false);
        }
        d(paramArrayList);
      }
    }
    ArrayList localArrayList;
    do
    {
      return;
      a(1001, "", false, false);
      break;
      localArrayList = new ArrayList();
      Object localObject2;
      d locald;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        localObject2 = paramArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          locald = (d)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append(locald.a + "," + locald.b + "," + locald.c + "|");
        }
        QLog.d("QQWiFiScanManager", 2, "scanlist before filter:" + ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = paramArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        if (((d)localObject2).c < -80) {
          ((Iterator)localObject1).remove();
        } else {
          localArrayList.add(((d)localObject2).b);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        localObject2 = paramArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          locald = (d)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append(locald.a + "," + locald.b + "," + locald.c + "|");
        }
        QLog.d("QQWiFiScanManager", 2, "scanlist after filter:" + ((StringBuilder)localObject1).toString());
        QLog.d("QQWiFiScanManager", 2, "bssidSet:" + localArrayList.toString());
      }
      bool = a(this.as, localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "processWiFiScanResultForBar, isSubset=" + bool + ", bssidSet.size=" + localArrayList.size());
      }
    } while (bool);
    e(paramArrayList);
    this.as.clear();
    this.as.addAll(localArrayList);
  }
  
  private static boolean b(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext != null)
      {
        boolean bool = paramContext.isConnected();
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  private boolean b(String paramString)
  {
    boolean bool1 = false;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.replace("\"", "");
      Pattern localPattern = Pattern.compile(this.aj.a);
      boolean bool2 = localPattern.matcher(paramString).matches();
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("QQWiFiScanManager", 2, "isQQWiFi, " + localPattern + ", " + paramString + ", " + bool2);
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  private boolean b(List paramList)
  {
    boolean bool2 = false;
    Object localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i1 = 4;; i1 = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("mobileQQ", i1);
      boolean bool1 = bool2;
      if (localObject != null)
      {
        long l1 = ((SharedPreferences)localObject).getLong("autoconnect_reference_time", 0L);
        long l2 = System.currentTimeMillis() - l1;
        if (QLog.isColorLevel()) {
          QLog.i("QQWiFiScanManager", 2, "isInAutoconnectIntervalProtected lasttime=" + l1 + " interval=" + l2 + " autoConnectProtectedInterval=" + this.aj.n);
        }
        bool1 = bool2;
        if (l2 < this.aj.n)
        {
          bool1 = bool2;
          if (c(paramList)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
  }
  
  private boolean c(int paramInt)
  {
    if (this.ay)
    {
      if (this.aw) {
        break label85;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "canPushNotification, not registered.");
      }
    }
    label29:
    label85:
    label239:
    label292:
    do
    {
      do
      {
        return false;
        try
        {
          List localList = ((WifiManager)this.ai.getSystemService("wifi")).getScanResults();
          if (localList == null) {
            break label29;
          }
          if (localList.size() > 0) {
            break;
          }
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQWiFiScanManager", 2, localException.getMessage());
            }
            localObject = null;
          }
        }
        Object localObject = BaseApplication.getContext();
        if (Build.VERSION.SDK_INT > 10) {}
        for (int i1 = 4;; i1 = 0)
        {
          localObject = ((BaseApplication)localObject).getSharedPreferences("mobileQQ", i1);
          if ((localObject != null) && (!TextUtils.isEmpty(this.aj.c)))
          {
            this.aj.d = ((SharedPreferences)localObject).getInt("bar_switch_operation" + this.aj.c, 0);
            if (QLog.isColorLevel()) {
              QLog.d("QQWiFiScanManager", 2, "canPushNotification, BarSwitch=" + this.aj.d);
            }
          }
          if ((!n()) || (paramInt == 1008)) {
            break label239;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("QQWiFiScanManager", 2, "canPushNotification, bar closed.");
          return false;
        }
        localObject = ((ConnectivityManager)this.ai.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject == null) || (((NetworkInfo)localObject).getType() != 1) || (paramInt != 1001)) {
          break label292;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQWiFiScanManager", 2, "canPushNotification, dont push qqwifi info while wifi is connected");
      return false;
    } while (!a(this.aj.c));
    return true;
  }
  
  private boolean c(ArrayList paramArrayList)
  {
    if (this.au != null)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.au.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(((WiFiService)localIterator.next()).wifi.b);
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (localHashSet.contains(((d)paramArrayList.next()).b)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean c(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((WiFiService)paramList.next()).wifi.b);
    }
    int i2 = Math.min(Math.min(localArrayList.size(), this.av.size()), this.aj.o);
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiScanManager", 2, "lastAutoBssids=" + this.av.toString() + " curSet:" + localArrayList.toString() + " isSubSet=" + " maxAutoConnecttimes=" + this.aj.o + " min=" + i2);
    }
    int i1 = 0;
    while (i1 < i2)
    {
      paramList = (String)localArrayList.get(i1);
      if (this.av.contains(paramList))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQWiFiScanManager", 2, "return true:" + paramList + "has already tryed i=" + i1);
        }
        return true;
      }
      i1 += 1;
    }
    i();
    return false;
  }
  
  private List d(List paramList)
  {
    if (paramList == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      WiFiService localWiFiService = (WiFiService)paramList.next();
      if ((localWiFiService.autoConnFlag == 1) && (localArrayList.size() < this.aj.o)) {
        localArrayList.add(localWiFiService);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiScanManager", 2, "after filtered:" + localArrayList.toString());
    }
    return localArrayList;
  }
  
  private void d(ArrayList paramArrayList)
  {
    if (q())
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.au.iterator();
      while (localIterator.hasNext())
      {
        WiFiService localWiFiService = (WiFiService)localIterator.next();
        if (localWiFiService.autoConnFlag == 1) {
          localHashSet.add(localWiFiService.wifi.b);
        }
      }
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
      } while (!localHashSet.contains(((d)paramArrayList.next()).b));
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "processWiFiScanResultForBar, hasAutoIntersection=" + bool);
      }
      if (bool) {
        a(this.au);
      }
      return;
    }
  }
  
  private void e(ArrayList paramArrayList)
  {
    try
    {
      this.aq = System.currentTimeMillis();
      int i1 = m();
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "getAvailableQQWifi size:" + paramArrayList.size() + " scanType=" + i1 + " needcallback=" + true);
      }
      Object localObject = new UniPacket(true);
      ((UniPacket)localObject).setEncodeName("UTF-8");
      a locala = new a();
      locala.a = paramArrayList;
      locala.b = c.f(this.ai);
      locala.c = "Android";
      locala.d = i1;
      ((UniPacket)localObject).setServantName("MQQ.QQWiFiMgrServer.QQWiFiMgrObj");
      ((UniPacket)localObject).setFuncName("AvailQQWiFiForMSF");
      ((UniPacket)localObject).put("req", locala);
      paramArrayList = ((UniPacket)localObject).encode();
      localObject = new ToServiceMsg("mobileqq.service", this.aj.c, "QQWifiSvc.AvailQQWiFiForMSF");
      ((ToServiceMsg)localObject).setAppId(this.ah.sender.f());
      ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
      ((ToServiceMsg)localObject).setTimeout(20000L);
      ((ToServiceMsg)localObject).setNeedCallback(true);
      ((ToServiceMsg)localObject).putWupBuffer(paramArrayList);
      ((ToServiceMsg)localObject).addAttribute("isformsf", Boolean.valueOf(true));
      this.ah.sendSsoMsg((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramArrayList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQWiFiScanManager", 2, "getAvailableQQWifi exp:" + paramArrayList);
    }
  }
  
  private void f()
  {
    if (this.ax) {
      return;
    }
    this.ax = true;
    h();
    g();
    u();
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 255	com/tencent/mobileqq/msf/core/o:ai	Landroid/content/Context;
    //   4: ldc_w 364
    //   7: iconst_0
    //   8: invokevirtual 370	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   11: astore_1
    //   12: new 198	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: ldc_w 1010
    //   20: invokespecial 375	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore_2
    //   24: aload_2
    //   25: invokevirtual 1013	java/io/File:exists	()Z
    //   28: ifeq +109 -> 137
    //   31: new 317	org/json/JSONObject
    //   34: dup
    //   35: aload_0
    //   36: aload_2
    //   37: invokevirtual 378	com/tencent/mobileqq/msf/core/o:a	(Ljava/io/File;)Ljava/lang/String;
    //   40: invokespecial 379	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   43: new 180	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 1015
    //   53: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   60: getfield 557	com/tencent/mobileqq/msf/core/o$a:c	Ljava/lang/String;
    //   63: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokevirtual 1018	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   72: ifeq +65 -> 137
    //   75: aload_0
    //   76: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   79: iconst_0
    //   80: putfield 585	com/tencent/mobileqq/msf/core/o$a:b	Z
    //   83: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +51 -> 137
    //   89: ldc 64
    //   91: iconst_2
    //   92: new 180	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 1314
    //   102: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   109: getfield 557	com/tencent/mobileqq/msf/core/o$a:c	Ljava/lang/String;
    //   112: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc_w 1022
    //   118: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_0
    //   122: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   125: getfield 585	com/tencent/mobileqq/msf/core/o$a:b	Z
    //   128: invokevirtual 835	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   131: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 761	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: new 198	java/io/File
    //   140: dup
    //   141: aload_1
    //   142: ldc_w 1036
    //   145: invokespecial 375	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   148: astore_1
    //   149: aload_1
    //   150: invokevirtual 1013	java/io/File:exists	()Z
    //   153: ifeq +170 -> 323
    //   156: new 317	org/json/JSONObject
    //   159: dup
    //   160: aload_0
    //   161: aload_1
    //   162: invokevirtual 378	com/tencent/mobileqq/msf/core/o:a	(Ljava/io/File;)Ljava/lang/String;
    //   165: invokespecial 379	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   168: ldc_w 1038
    //   171: invokevirtual 1041	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   174: astore_3
    //   175: aload_3
    //   176: invokevirtual 309	org/json/JSONArray:length	()I
    //   179: istore 5
    //   181: ldc -33
    //   183: astore_1
    //   184: iconst_0
    //   185: istore 4
    //   187: iload 4
    //   189: aload_3
    //   190: invokevirtual 309	org/json/JSONArray:length	()I
    //   193: if_icmpge +90 -> 283
    //   196: new 180	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   203: aload_1
    //   204: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_3
    //   208: iload 4
    //   210: invokevirtual 1045	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   213: invokevirtual 795	java/lang/Object:toString	()Ljava/lang/String;
    //   216: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: astore_2
    //   223: aload_2
    //   224: astore_1
    //   225: iload 4
    //   227: iload 5
    //   229: iconst_1
    //   230: isub
    //   231: if_icmpge +24 -> 255
    //   234: new 180	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   241: aload_2
    //   242: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc_w 355
    //   248: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: astore_1
    //   255: iload 4
    //   257: iconst_1
    //   258: iadd
    //   259: istore 4
    //   261: goto -74 -> 187
    //   264: astore_2
    //   265: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq -131 -> 137
    //   271: ldc 64
    //   273: iconst_2
    //   274: ldc_w 1316
    //   277: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: goto -143 -> 137
    //   283: aload_0
    //   284: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   287: aload_1
    //   288: putfield 1047	com/tencent/mobileqq/msf/core/o$a:a	Ljava/lang/String;
    //   291: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +29 -> 323
    //   297: ldc 64
    //   299: iconst_2
    //   300: new 180	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   307: ldc_w 1318
    //   310: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_1
    //   314: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 761	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: return
    //   324: astore_1
    //   325: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   328: ifeq -5 -> 323
    //   331: ldc 64
    //   333: iconst_2
    //   334: ldc_w 1320
    //   337: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	o
    //   11	303	1	localObject1	Object
    //   324	1	1	localException1	Exception
    //   23	219	2	localObject2	Object
    //   264	1	2	localException2	Exception
    //   174	34	3	localJSONArray	JSONArray
    //   185	75	4	i1	int
    //   179	52	5	i2	int
    // Exception table:
    //   from	to	target	type
    //   31	137	264	java/lang/Exception
    //   156	181	324	java/lang/Exception
    //   187	223	324	java/lang/Exception
    //   234	255	324	java/lang/Exception
    //   283	323	324	java/lang/Exception
  }
  
  private void h()
  {
    int i2 = 4;
    Object localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10)
    {
      i1 = 4;
      localObject = ((BaseApplication)localObject).getSharedPreferences("Last_Login", i1);
      if (localObject != null)
      {
        this.aj.c = ((SharedPreferences)localObject).getString("uin", "");
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "lastLoginUin = " + this.aj.c);
        }
      }
      localObject = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label227;
      }
    }
    label227:
    for (int i1 = i2;; i1 = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("mobileQQ", i1);
      if (localObject != null)
      {
        this.aj.d = ((SharedPreferences)localObject).getInt("bar_switch_operation" + this.aj.c, 0);
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "initConfig, barOperation=" + this.aj.d);
        }
        a((SharedPreferences)localObject);
        b((SharedPreferences)localObject);
      }
      ((SharedPreferences)localObject).edit().putBoolean("hasPushedAvailNotification", false).commit();
      return;
      i1 = 0;
      break;
    }
  }
  
  private void i()
  {
    Object localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i1 = 4;; i1 = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("mobileQQ", i1);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().remove("autoconnect_bssids").commit();
      }
      return;
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "onAccountChange");
    }
    b(0);
    b(2);
    b(4);
    b(3);
    if ((this.aw) && (this.ay) && (n()))
    {
      ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(f.H);
      this.ay = false;
      this.al = 0;
    }
  }
  
  private boolean k()
  {
    if (this.aB) {}
    int i1;
    label268:
    do
    {
      return false;
      Object localObject = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT > 10) {}
      for (i1 = 4;; i1 = 0)
      {
        localObject = ((BaseApplication)localObject).getSharedPreferences("Last_Login", i1).getString("uin", "");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (!((String)localObject).equals(this.aj.c))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQWiFiScanManager", 2, "onAccountChange, " + this.aj.c + ", " + (String)localObject);
          }
          this.aj.c = ((String)localObject);
          j();
        }
        if ((!a(this.aj.c)) || (!this.aA) || (!this.aw) || (!this.aj.b)) {
          break;
        }
        localObject = ((ConnectivityManager)this.ai.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject == null) || (((NetworkInfo)localObject).getType() != 1)) {
          break label268;
        }
        WifiInfo localWifiInfo = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
        String str = "";
        localObject = str;
        if (localWifiInfo != null)
        {
          localObject = str;
          if (!TextUtils.isEmpty(localWifiInfo.getSSID())) {
            localObject = localWifiInfo.getSSID().replace("\"", "");
          }
        }
        if (b((String)localObject)) {
          break;
        }
        a(1007, (String)localObject, false, false);
        return false;
      }
      if ((localObject == null) || (!((NetworkInfo)localObject).isAvailable()))
      {
        a(1003, "", false, false);
        return false;
      }
      i1 = m();
      if (i1 > 0) {
        break;
      }
    } while (!l());
    return true;
    if ((i1 != 2) || (l())) {}
    while (System.currentTimeMillis() - this.aq >= this.aj.k) {
      return true;
    }
    return false;
  }
  
  private boolean l()
  {
    if (this.aC == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "canPushAvailableWiFiToBarClosedUser, availpush=0");
      }
    }
    label92:
    do
    {
      return false;
      Object localObject = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT > 10) {}
      for (int i1 = 4;; i1 = 0)
      {
        localObject = ((BaseApplication)localObject).getSharedPreferences("qqwifi", i1);
        long l1 = ((SharedPreferences)localObject).getLong("lastPushAvailableWiFiToBarClosedUser", 0L);
        if (System.currentTimeMillis() - l1 >= 21600000L) {
          break label92;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQWiFiScanManager", 2, "canPushAvailableWiFiToBarClosedUser, time limit");
        return false;
      }
      if (((SharedPreferences)localObject).getBoolean("availNotificationSwitch", false)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQWiFiScanManager", 2, "canPushAvailableWiFiToBarClosedUser, avail switch is turned off");
    return false;
    return true;
  }
  
  private int m()
  {
    int i2 = 0;
    if (!n()) {
      i2 = 1;
    }
    int i1 = i2;
    if (this.aj.g) {
      i1 = i2 | 0x2;
    }
    i2 = i1;
    if (o()) {
      i2 = i1 | 0x4;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiScanManager", 2, "scantype=" + i2);
    }
    return i2;
  }
  
  private boolean n()
  {
    if (this.aj.d == 1) {}
    do
    {
      return false;
      if (this.aj.d == -1) {
        return true;
      }
    } while (this.aj.f);
    return true;
  }
  
  private boolean o()
  {
    if (!this.aj.b) {}
    do
    {
      return false;
      if (this.aj.m == 1) {
        return true;
      }
    } while ((this.aj.m == -1) || (!this.aj.l));
    return true;
  }
  
  private void p()
  {
    if (!this.aj.b) {}
    label243:
    label297:
    label479:
    label873:
    label883:
    label888:
    label892:
    for (;;)
    {
      return;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      int i1;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      if (!b(this.ai))
      {
        localObject2 = a(this.ai, n());
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = Pattern.compile((String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("QQWiFiScanManager", 2, "NotNetworkSupportSsidList pattern: " + (String)localObject2);
          }
          localObject2 = ((WifiManager)this.ai.getSystemService("wifi")).getScanResults();
          if (localObject2 != null)
          {
            localObject3 = new ArrayList();
            i1 = 0;
            while (i1 < ((List)localObject2).size())
            {
              localObject4 = (ScanResult)((List)localObject2).get(i1);
              localObject5 = ((ScanResult)localObject4).SSID.replace("\"", "");
              if (((Pattern)localObject1).matcher((CharSequence)localObject5).matches())
              {
                localObject6 = new d();
                ((d)localObject6).a = ((String)localObject5);
                ((d)localObject6).b = ((ScanResult)localObject4).BSSID;
                ((d)localObject6).c = ((short)((ScanResult)localObject4).level);
                ((ArrayList)localObject3).add(localObject6);
              }
              i1 += 1;
            }
            if (!((ArrayList)localObject3).isEmpty()) {
              if (n())
              {
                localObject1 = BaseApplication.getContext();
                if (Build.VERSION.SDK_INT > 10)
                {
                  i1 = 4;
                  long l1 = ((BaseApplication)localObject1).getSharedPreferences("qqwifi", i1).getLong("lastPushAvailableWiFiToBarClosedUser", 0L);
                  if ((l1 > 0L) && (System.currentTimeMillis() - l1 < 21600000L)) {
                    break label888;
                  }
                  a(1008, "", false, true);
                  i1 = 1;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        if ((i1 != 0) || (!k())) {
          break label892;
        }
        this.ap = System.currentTimeMillis();
        localObject5 = new ArrayList();
        if ((!TextUtils.isEmpty(this.aj.a)) || (!TextUtils.isEmpty(this.aj.q))) {
          if (TextUtils.isEmpty(this.aj.a)) {
            break label883;
          }
        }
        for (localObject1 = Pattern.compile(this.aj.a);; localObject1 = null)
        {
          if (!TextUtils.isEmpty(this.aj.q)) {}
          for (localObject2 = Pattern.compile(this.aj.q);; localObject2 = null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQWiFiScanManager", 2, "pattern: " + this.aj.a + " reportPattern: " + this.aj.q);
            }
            localObject6 = ((WifiManager)this.ai.getSystemService("wifi")).getScanResults();
            ScanResult localScanResult;
            String str;
            if (localObject6 != null)
            {
              i1 = 0;
              if (i1 < ((List)localObject6).size())
              {
                localScanResult = (ScanResult)((List)localObject6).get(i1);
                str = localScanResult.SSID.replace("\"", "");
                if (localObject1 == null) {
                  break label873;
                }
              }
            }
            for (localObject3 = ((Pattern)localObject1).matcher(str);; localObject3 = null)
            {
              if (localObject2 != null) {}
              for (localObject4 = ((Pattern)localObject2).matcher(str);; localObject4 = null)
              {
                if (((localObject3 != null) && (((Matcher)localObject3).matches())) || ((localObject4 != null) && (((Matcher)localObject4).matches())))
                {
                  localObject3 = new d();
                  ((d)localObject3).a = str;
                  ((d)localObject3).b = localScanResult.BSSID;
                  ((d)localObject3).c = ((short)localScanResult.level);
                  ((ArrayList)localObject5).add(localObject3);
                }
                i1 += 1;
                break label479;
                i1 = 0;
                break label243;
                a(1001, "", false, true);
                i1 = 1;
                break label297;
                if (((ArrayList)localObject5).isEmpty())
                {
                  i();
                  localObject1 = ((ConnectivityManager)this.ai.getSystemService("connectivity")).getActiveNetworkInfo();
                  localObject2 = (WifiManager)this.ai.getSystemService("wifi");
                  i1 = ((WifiManager)localObject2).getWifiState();
                  if (localObject1 == null)
                  {
                    if (3 == i1)
                    {
                      a(1003, "", false, false);
                      return;
                    }
                    a(1004, "", false, false);
                    return;
                  }
                  if (3 != i1)
                  {
                    a(1004, "", false, false);
                    return;
                  }
                  if ((((NetworkInfo)localObject1).getType() == 1) || (((NetworkInfo)localObject1).getType() == 9))
                  {
                    localObject3 = ((WifiManager)localObject2).getConnectionInfo();
                    localObject2 = "";
                    localObject1 = localObject2;
                    if (localObject3 != null)
                    {
                      localObject1 = localObject2;
                      if (!TextUtils.isEmpty(((WifiInfo)localObject3).getSSID())) {
                        localObject1 = ((WifiInfo)localObject3).getSSID().replace("\"", "");
                      }
                    }
                    a(1007, (String)localObject1, false, false);
                    return;
                  }
                  a(1009, "", false, false);
                  return;
                }
                i1 = m();
                if (((i1 & 0x1) > 0) || (l()))
                {
                  b((ArrayList)localObject5);
                  return;
                }
                if (((i1 & 0x2) <= 0) && ((i1 & 0x4) <= 0)) {
                  break;
                }
                a((ArrayList)localObject5);
                return;
              }
            }
          }
        }
        i1 = 0;
      }
    }
  }
  
  private boolean q()
  {
    if (this.aB) {
      if (QLog.isColorLevel()) {
        QLog.i("QQWiFiScanManager", 2, "CurUinQuited,return");
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
            return false;
            if (System.currentTimeMillis() - this.ar >= 60000L) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect in frequency limit,return");
          return false;
          if (o()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect isOpened false,return");
        return false;
        if (r()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect isDeviceSituationOk false,return");
      return false;
      if (s()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect isCurNetstatuAvailForAutoconnect false,return");
    return false;
    return true;
  }
  
  private boolean r()
  {
    return this.aA;
  }
  
  private boolean s()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.ai.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
    {
      if (localNetworkInfo.getType() == 1) {
        return false;
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  private boolean t()
  {
    if (!this.az)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "startAccScan");
      }
      new r(this).start();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "startAccScan, already running.");
    }
    return false;
  }
  
  /* Error */
  private void u()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 255	com/tencent/mobileqq/msf/core/o:ai	Landroid/content/Context;
    //   5: invokespecial 1447	com/tencent/mobileqq/msf/core/o:a	(Landroid/content/Context;)Ljava/util/Map;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +994 -> 1004
    //   13: aload_1
    //   14: ldc_w 1449
    //   17: invokeinterface 1452 2 0
    //   22: checkcast 397	java/lang/String
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull +52 -> 79
    //   30: aload_0
    //   31: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   34: aload_2
    //   35: invokestatic 1455	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   38: putfield 1457	com/tencent/mobileqq/msf/core/o$a:h	I
    //   41: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +35 -> 79
    //   47: ldc 64
    //   49: iconst_2
    //   50: new 180	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   57: ldc_w 1459
    //   60: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_0
    //   64: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   67: getfield 1457	com/tencent/mobileqq/msf/core/o$a:h	I
    //   70: invokevirtual 549	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 761	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: aload_1
    //   80: ldc_w 1461
    //   83: invokeinterface 1452 2 0
    //   88: checkcast 397	java/lang/String
    //   91: astore_2
    //   92: aload_2
    //   93: ifnull +57 -> 150
    //   96: aload_0
    //   97: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   100: aload_2
    //   101: invokestatic 1455	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   104: sipush 1000
    //   107: imul
    //   108: i2l
    //   109: putfield 1463	com/tencent/mobileqq/msf/core/o$a:i	J
    //   112: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +35 -> 150
    //   118: ldc 64
    //   120: iconst_2
    //   121: new 180	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   128: ldc_w 1459
    //   131: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_0
    //   135: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   138: getfield 1463	com/tencent/mobileqq/msf/core/o$a:i	J
    //   141: invokevirtual 1130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   144: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 761	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_1
    //   151: ldc_w 1465
    //   154: invokeinterface 1452 2 0
    //   159: checkcast 397	java/lang/String
    //   162: astore_2
    //   163: aload_2
    //   164: ifnull +57 -> 221
    //   167: aload_0
    //   168: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   171: aload_2
    //   172: invokestatic 1455	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   175: sipush 1000
    //   178: imul
    //   179: i2l
    //   180: putfield 1467	com/tencent/mobileqq/msf/core/o$a:j	J
    //   183: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +35 -> 221
    //   189: ldc 64
    //   191: iconst_2
    //   192: new 180	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 1469
    //   202: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_0
    //   206: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   209: getfield 1467	com/tencent/mobileqq/msf/core/o$a:j	J
    //   212: invokevirtual 1130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   215: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 761	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: aload_1
    //   222: ldc_w 1471
    //   225: invokeinterface 1452 2 0
    //   230: checkcast 397	java/lang/String
    //   233: astore_2
    //   234: aload_0
    //   235: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   238: astore_3
    //   239: ldc_w 1473
    //   242: aload_2
    //   243: invokevirtual 830	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   246: ifeq +759 -> 1005
    //   249: iconst_1
    //   250: istore 4
    //   252: aload_3
    //   253: iload 4
    //   255: putfield 1382	com/tencent/mobileqq/msf/core/o$a:f	Z
    //   258: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +45 -> 306
    //   264: ldc 64
    //   266: iconst_2
    //   267: new 180	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   274: ldc_w 1475
    //   277: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_0
    //   281: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   284: getfield 1382	com/tencent/mobileqq/msf/core/o$a:f	Z
    //   287: invokevirtual 835	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   290: ldc_w 759
    //   293: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_2
    //   297: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 761	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload_1
    //   307: ldc_w 1477
    //   310: invokeinterface 1452 2 0
    //   315: checkcast 397	java/lang/String
    //   318: astore_2
    //   319: aload_0
    //   320: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   323: astore_3
    //   324: ldc_w 1473
    //   327: aload_2
    //   328: invokevirtual 830	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   331: ifeq +680 -> 1011
    //   334: iconst_1
    //   335: istore 4
    //   337: aload_3
    //   338: iload 4
    //   340: putfield 1376	com/tencent/mobileqq/msf/core/o$a:g	Z
    //   343: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   346: ifeq +45 -> 391
    //   349: ldc 64
    //   351: iconst_2
    //   352: new 180	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   359: ldc_w 1479
    //   362: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_0
    //   366: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   369: getfield 1376	com/tencent/mobileqq/msf/core/o$a:g	Z
    //   372: invokevirtual 835	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   375: ldc_w 757
    //   378: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_2
    //   382: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 761	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: aload_1
    //   392: ldc_w 1481
    //   395: invokeinterface 1452 2 0
    //   400: checkcast 397	java/lang/String
    //   403: astore_2
    //   404: aload_0
    //   405: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   408: astore_3
    //   409: ldc_w 1473
    //   412: aload_2
    //   413: invokevirtual 830	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   416: ifeq +601 -> 1017
    //   419: iconst_1
    //   420: istore 4
    //   422: aload_3
    //   423: iload 4
    //   425: putfield 1384	com/tencent/mobileqq/msf/core/o$a:l	Z
    //   428: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq +45 -> 476
    //   434: ldc 64
    //   436: iconst_2
    //   437: new 180	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   444: ldc_w 1483
    //   447: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload_0
    //   451: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   454: getfield 1384	com/tencent/mobileqq/msf/core/o$a:l	Z
    //   457: invokevirtual 835	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   460: ldc_w 757
    //   463: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload_2
    //   467: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 761	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: aload_1
    //   477: ldc_w 1485
    //   480: invokeinterface 1452 2 0
    //   485: checkcast 397	java/lang/String
    //   488: astore_2
    //   489: aload_2
    //   490: ifnull +56 -> 546
    //   493: aload_0
    //   494: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   497: aload_2
    //   498: invokestatic 1489	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   501: ldc2_w 670
    //   504: lmul
    //   505: putfield 1136	com/tencent/mobileqq/msf/core/o$a:n	J
    //   508: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   511: ifeq +35 -> 546
    //   514: ldc 64
    //   516: iconst_2
    //   517: new 180	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   524: ldc_w 1491
    //   527: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload_0
    //   531: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   534: getfield 1136	com/tencent/mobileqq/msf/core/o$a:n	J
    //   537: invokevirtual 1130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   540: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokestatic 761	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   546: aload_1
    //   547: ldc_w 1493
    //   550: invokeinterface 1452 2 0
    //   555: checkcast 397	java/lang/String
    //   558: astore_2
    //   559: aload_2
    //   560: ifnull +52 -> 612
    //   563: aload_0
    //   564: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   567: aload_2
    //   568: invokestatic 1455	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   571: putfield 1183	com/tencent/mobileqq/msf/core/o$a:o	I
    //   574: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   577: ifeq +35 -> 612
    //   580: ldc 64
    //   582: iconst_2
    //   583: new 180	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   590: ldc_w 1495
    //   593: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_0
    //   597: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   600: getfield 1183	com/tencent/mobileqq/msf/core/o$a:o	I
    //   603: invokevirtual 549	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   606: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokestatic 761	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   612: aload_1
    //   613: ldc_w 1493
    //   616: invokeinterface 1452 2 0
    //   621: checkcast 397	java/lang/String
    //   624: astore_3
    //   625: aload_3
    //   626: ifnull +65 -> 691
    //   629: aload_0
    //   630: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   633: astore_3
    //   634: aload_2
    //   635: ldc_w 1473
    //   638: invokevirtual 830	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   641: ifeq +382 -> 1023
    //   644: iconst_1
    //   645: istore 4
    //   647: aload_3
    //   648: iload 4
    //   650: putfield 1497	com/tencent/mobileqq/msf/core/o$a:p	Z
    //   653: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   656: ifeq +35 -> 691
    //   659: ldc 64
    //   661: iconst_2
    //   662: new 180	java/lang/StringBuilder
    //   665: dup
    //   666: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   669: ldc_w 1499
    //   672: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: aload_0
    //   676: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   679: getfield 1497	com/tencent/mobileqq/msf/core/o$a:p	Z
    //   682: invokevirtual 835	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   685: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 761	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   691: aload_1
    //   692: ldc_w 1501
    //   695: invokeinterface 1452 2 0
    //   700: checkcast 397	java/lang/String
    //   703: astore_2
    //   704: aload_2
    //   705: ifnull +57 -> 762
    //   708: aload_0
    //   709: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   712: aload_2
    //   713: ldc_w 1503
    //   716: ldc -33
    //   718: invokevirtual 1506	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   721: putfield 269	com/tencent/mobileqq/msf/core/o$a:r	Ljava/lang/String;
    //   724: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   727: ifeq +35 -> 762
    //   730: ldc 64
    //   732: iconst_2
    //   733: new 180	java/lang/StringBuilder
    //   736: dup
    //   737: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   740: ldc_w 1508
    //   743: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: aload_0
    //   747: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   750: getfield 269	com/tencent/mobileqq/msf/core/o$a:r	Ljava/lang/String;
    //   753: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 761	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   762: aload_1
    //   763: ldc_w 1510
    //   766: invokeinterface 1452 2 0
    //   771: checkcast 397	java/lang/String
    //   774: astore_1
    //   775: aload_1
    //   776: ifnull +228 -> 1004
    //   779: aload_0
    //   780: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   783: aload_1
    //   784: putfield 1408	com/tencent/mobileqq/msf/core/o$a:q	Ljava/lang/String;
    //   787: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   790: ifeq +214 -> 1004
    //   793: ldc 64
    //   795: iconst_2
    //   796: new 180	java/lang/StringBuilder
    //   799: dup
    //   800: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   803: ldc_w 1512
    //   806: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: aload_0
    //   810: getfield 260	com/tencent/mobileqq/msf/core/o:aj	Lcom/tencent/mobileqq/msf/core/o$a;
    //   813: getfield 1408	com/tencent/mobileqq/msf/core/o$a:q	Ljava/lang/String;
    //   816: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   822: invokestatic 761	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   825: return
    //   826: astore_2
    //   827: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   830: ifeq -789 -> 41
    //   833: ldc 64
    //   835: iconst_2
    //   836: ldc_w 1514
    //   839: aload_2
    //   840: invokestatic 1517	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   843: goto -802 -> 41
    //   846: astore_1
    //   847: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   850: ifeq +154 -> 1004
    //   853: ldc 64
    //   855: iconst_2
    //   856: aload_1
    //   857: invokevirtual 542	java/lang/Exception:toString	()Ljava/lang/String;
    //   860: invokestatic 1519	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   863: return
    //   864: astore_2
    //   865: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   868: ifeq -756 -> 112
    //   871: ldc 64
    //   873: iconst_2
    //   874: ldc_w 1521
    //   877: aload_2
    //   878: invokestatic 1517	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   881: goto -769 -> 112
    //   884: astore_2
    //   885: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   888: ifeq -667 -> 221
    //   891: ldc 64
    //   893: iconst_2
    //   894: ldc_w 1523
    //   897: aload_2
    //   898: invokestatic 1517	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   901: goto -680 -> 221
    //   904: astore_2
    //   905: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   908: ifeq -400 -> 508
    //   911: ldc 64
    //   913: iconst_2
    //   914: ldc_w 1525
    //   917: aload_2
    //   918: invokestatic 1517	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   921: goto -413 -> 508
    //   924: astore_3
    //   925: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   928: ifeq -354 -> 574
    //   931: ldc 64
    //   933: iconst_2
    //   934: ldc_w 1527
    //   937: aload_3
    //   938: invokestatic 1517	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   941: goto -367 -> 574
    //   944: astore_2
    //   945: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   948: ifeq -295 -> 653
    //   951: ldc 64
    //   953: iconst_2
    //   954: ldc_w 1529
    //   957: aload_2
    //   958: invokestatic 1517	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   961: goto -308 -> 653
    //   964: astore_2
    //   965: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   968: ifeq -244 -> 724
    //   971: ldc 64
    //   973: iconst_2
    //   974: ldc_w 1531
    //   977: aload_2
    //   978: invokestatic 1517	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   981: goto -257 -> 724
    //   984: astore_1
    //   985: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   988: ifeq -201 -> 787
    //   991: ldc 64
    //   993: iconst_2
    //   994: ldc_w 1533
    //   997: aload_1
    //   998: invokestatic 1517	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1001: goto -214 -> 787
    //   1004: return
    //   1005: iconst_0
    //   1006: istore 4
    //   1008: goto -756 -> 252
    //   1011: iconst_0
    //   1012: istore 4
    //   1014: goto -677 -> 337
    //   1017: iconst_0
    //   1018: istore 4
    //   1020: goto -598 -> 422
    //   1023: iconst_0
    //   1024: istore 4
    //   1026: goto -379 -> 647
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1029	0	this	o
    //   8	776	1	localObject1	Object
    //   846	11	1	localException1	Exception
    //   984	14	1	localException2	Exception
    //   25	688	2	str	String
    //   826	14	2	localNumberFormatException1	NumberFormatException
    //   864	14	2	localNumberFormatException2	NumberFormatException
    //   884	14	2	localNumberFormatException3	NumberFormatException
    //   904	14	2	localNumberFormatException4	NumberFormatException
    //   944	14	2	localException3	Exception
    //   964	14	2	localException4	Exception
    //   238	410	3	localObject2	Object
    //   924	14	3	localException5	Exception
    //   250	775	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   30	41	826	java/lang/NumberFormatException
    //   0	9	846	java/lang/Exception
    //   13	26	846	java/lang/Exception
    //   30	41	846	java/lang/Exception
    //   41	79	846	java/lang/Exception
    //   79	92	846	java/lang/Exception
    //   96	112	846	java/lang/Exception
    //   112	150	846	java/lang/Exception
    //   150	163	846	java/lang/Exception
    //   167	221	846	java/lang/Exception
    //   221	249	846	java/lang/Exception
    //   252	306	846	java/lang/Exception
    //   306	334	846	java/lang/Exception
    //   337	391	846	java/lang/Exception
    //   391	419	846	java/lang/Exception
    //   422	476	846	java/lang/Exception
    //   476	489	846	java/lang/Exception
    //   493	508	846	java/lang/Exception
    //   508	546	846	java/lang/Exception
    //   546	559	846	java/lang/Exception
    //   574	612	846	java/lang/Exception
    //   612	625	846	java/lang/Exception
    //   653	691	846	java/lang/Exception
    //   691	704	846	java/lang/Exception
    //   724	762	846	java/lang/Exception
    //   762	775	846	java/lang/Exception
    //   787	825	846	java/lang/Exception
    //   827	843	846	java/lang/Exception
    //   865	881	846	java/lang/Exception
    //   885	901	846	java/lang/Exception
    //   905	921	846	java/lang/Exception
    //   925	941	846	java/lang/Exception
    //   945	961	846	java/lang/Exception
    //   965	981	846	java/lang/Exception
    //   985	1001	846	java/lang/Exception
    //   96	112	864	java/lang/NumberFormatException
    //   167	221	884	java/lang/NumberFormatException
    //   493	508	904	java/lang/NumberFormatException
    //   563	574	924	java/lang/Exception
    //   629	644	944	java/lang/Exception
    //   647	653	944	java/lang/Exception
    //   708	724	964	java/lang/Exception
    //   779	787	984	java/lang/Exception
  }
  
  /* Error */
  public String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_3
    //   3: astore_2
    //   4: aload_1
    //   5: ifnull +12 -> 17
    //   8: aload_1
    //   9: invokevirtual 1013	java/io/File:exists	()Z
    //   12: ifne +7 -> 19
    //   15: aload_3
    //   16: astore_2
    //   17: aload_2
    //   18: areturn
    //   19: new 180	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   26: astore 4
    //   28: new 1539	java/io/BufferedReader
    //   31: dup
    //   32: new 1541	java/io/FileReader
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 1544	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   40: invokespecial 1547	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   43: astore_3
    //   44: aload_3
    //   45: astore_2
    //   46: aload_3
    //   47: invokevirtual 1550	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +46 -> 98
    //   55: aload_3
    //   56: astore_2
    //   57: aload 4
    //   59: aload_1
    //   60: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: goto -20 -> 44
    //   67: astore 4
    //   69: ldc -33
    //   71: astore_1
    //   72: aload_3
    //   73: astore_2
    //   74: aload 4
    //   76: invokevirtual 1551	java/io/FileNotFoundException:printStackTrace	()V
    //   79: aload_1
    //   80: astore_2
    //   81: aload_3
    //   82: ifnull -65 -> 17
    //   85: aload_3
    //   86: invokevirtual 1554	java/io/BufferedReader:close	()V
    //   89: aload_1
    //   90: areturn
    //   91: astore_2
    //   92: aload_2
    //   93: invokevirtual 1555	java/io/IOException:printStackTrace	()V
    //   96: aload_1
    //   97: areturn
    //   98: aload_3
    //   99: astore_2
    //   100: aload 4
    //   102: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: astore_1
    //   106: aload_3
    //   107: astore_2
    //   108: aload_3
    //   109: invokevirtual 1554	java/io/BufferedReader:close	()V
    //   112: aload_1
    //   113: astore_2
    //   114: aload_3
    //   115: ifnull -98 -> 17
    //   118: aload_3
    //   119: invokevirtual 1554	java/io/BufferedReader:close	()V
    //   122: aload_1
    //   123: areturn
    //   124: astore_2
    //   125: goto -33 -> 92
    //   128: astore 4
    //   130: aconst_null
    //   131: astore_3
    //   132: ldc -33
    //   134: astore_1
    //   135: aload_3
    //   136: astore_2
    //   137: aload 4
    //   139: invokevirtual 1555	java/io/IOException:printStackTrace	()V
    //   142: aload_1
    //   143: astore_2
    //   144: aload_3
    //   145: ifnull -128 -> 17
    //   148: aload_3
    //   149: invokevirtual 1554	java/io/BufferedReader:close	()V
    //   152: aload_1
    //   153: areturn
    //   154: astore_2
    //   155: goto -63 -> 92
    //   158: astore_1
    //   159: aconst_null
    //   160: astore_2
    //   161: aload_2
    //   162: ifnull +7 -> 169
    //   165: aload_2
    //   166: invokevirtual 1554	java/io/BufferedReader:close	()V
    //   169: aload_1
    //   170: athrow
    //   171: astore_2
    //   172: aload_2
    //   173: invokevirtual 1555	java/io/IOException:printStackTrace	()V
    //   176: goto -7 -> 169
    //   179: astore_1
    //   180: goto -19 -> 161
    //   183: astore 4
    //   185: ldc -33
    //   187: astore_1
    //   188: goto -53 -> 135
    //   191: astore 4
    //   193: goto -58 -> 135
    //   196: astore 4
    //   198: aconst_null
    //   199: astore_3
    //   200: ldc -33
    //   202: astore_1
    //   203: goto -131 -> 72
    //   206: astore 4
    //   208: goto -136 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	o
    //   0	211	1	paramFile	File
    //   3	78	2	localObject1	Object
    //   91	2	2	localIOException1	java.io.IOException
    //   99	15	2	localObject2	Object
    //   124	1	2	localIOException2	java.io.IOException
    //   136	8	2	localObject3	Object
    //   154	1	2	localIOException3	java.io.IOException
    //   160	6	2	localObject4	Object
    //   171	2	2	localIOException4	java.io.IOException
    //   1	199	3	localBufferedReader	java.io.BufferedReader
    //   26	32	4	localStringBuilder	StringBuilder
    //   67	34	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   128	10	4	localIOException5	java.io.IOException
    //   183	1	4	localIOException6	java.io.IOException
    //   191	1	4	localIOException7	java.io.IOException
    //   196	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   206	1	4	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   46	51	67	java/io/FileNotFoundException
    //   57	64	67	java/io/FileNotFoundException
    //   100	106	67	java/io/FileNotFoundException
    //   85	89	91	java/io/IOException
    //   118	122	124	java/io/IOException
    //   19	44	128	java/io/IOException
    //   148	152	154	java/io/IOException
    //   19	44	158	finally
    //   165	169	171	java/io/IOException
    //   46	51	179	finally
    //   57	64	179	finally
    //   74	79	179	finally
    //   100	106	179	finally
    //   108	112	179	finally
    //   137	142	179	finally
    //   46	51	183	java/io/IOException
    //   57	64	183	java/io/IOException
    //   100	106	183	java/io/IOException
    //   108	112	191	java/io/IOException
    //   19	44	196	java/io/FileNotFoundException
    //   108	112	206	java/io/FileNotFoundException
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (!this.aj.b) {
      return;
    }
    switch (paramInt)
    {
    case 1002: 
    case 1005: 
    case 1006: 
    default: 
      return;
    case 1001: 
      Intent localIntent = new Intent("com.tencent.mobileqq.action.QQWiFi");
      localIntent.putExtra("hasvailable", true);
      if (paramBoolean)
      {
        i1 = BaseApplication.qqWifiUserful;
        if (TextUtils.isEmpty(paramString)) {
          paramString = "当前有免费WiFi，点击查看";
        }
        for (;;)
        {
          a(localIntent, paramInt, i1, paramString, "试试一键连接", "当前有可用的 QQ WiFi,点击进入连接");
          a(1, null);
          return;
        }
      }
      int i1 = BaseApplication.qqWifiUserful;
      if (TextUtils.isEmpty(paramString)) {
        paramString = "当前有免费WiFi，点击查看";
      }
      for (;;)
      {
        a(localIntent, paramInt, i1, paramString, "试试一键连接", null);
        break;
      }
    case 1003: 
      a(new Intent("com.tencent.mobileqq.action.QQWiFi"), paramInt, BaseApplication.qqWifiNoSignal, "网络连接不可用", "网络恢复后查看", null);
      return;
    case 1004: 
      a(new Intent("com.tencent.mobileqq.action.QQWiFi"), paramInt, BaseApplication.qqWifiNoSignal, "已关闭无线网络", "打开后查看", null);
      return;
    case 1007: 
      a(new Intent("com.tencent.mobileqq.action.QQWiFi"), paramInt, BaseApplication.qqWifiConnecticon3, "已连接 " + paramString, "快来赚取免费QQ WiFi时长", null);
      return;
    case 1008: 
      a(new Intent("com.tencent.mobileqq.action.QQWiFi"), paramInt, BaseApplication.qqWifiUserful, "当前有免费WiFi，点击查看", "试试一键连接", "当前有可用的QQ WiFi，点击进入连接");
      paramString = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT > 10) {}
      for (paramInt = 4;; paramInt = 0)
      {
        paramString.getSharedPreferences("qqwifi", paramInt).edit().putLong("lastPushAvailableWiFiToBarClosedUser", System.currentTimeMillis()).commit();
        a(3, null);
        return;
      }
    }
    a(new Intent("com.tencent.mobileqq.action.QQWiFi"), paramInt, BaseApplication.qqWifiNoSignal, "未连接任何WiFi", "xxx", null);
  }
  
  public void a(Intent paramIntent)
  {
    int i1 = 4;
    if (paramIntent != null)
    {
      if (!paramIntent.hasExtra("isNeedScanRunning")) {
        break label113;
      }
      boolean bool = paramIntent.getBooleanExtra("isNeedScanRunning", false);
      paramIntent = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label79;
      }
      paramIntent = paramIntent.getSharedPreferences("mobileQQ", i1);
      if (!bool) {
        break label84;
      }
      NetConnInfoCenterImpl localNetConnInfoCenterImpl = NetConnInfoCenter.impl;
      a(NetConnInfoCenterImpl.msfCore, true);
      this.ay = paramIntent.getBoolean("hasPushedAvailNotification", false);
    }
    label79:
    label84:
    label113:
    label189:
    label242:
    do
    {
      do
      {
        do
        {
          return;
          i1 = 0;
          break;
          b();
          paramIntent.edit().putBoolean("hasPushedAvailNotification", this.ay).commit();
          return;
          if (paramIntent.hasExtra("enableChange"))
          {
            b(0);
            b(1);
            b(3);
            return;
          }
          if (!paramIntent.hasExtra("barswitch")) {
            break label189;
          }
          b(2);
        } while ((n()) || (!this.aj.b));
        ((WifiManager)this.ai.getSystemService("wifi")).startScan();
        return;
        if (paramIntent.hasExtra("availswitch"))
        {
          b(6);
          return;
        }
        if (!paramIntent.hasExtra("redTouch")) {
          break label242;
        }
      } while (!paramIntent.getBooleanExtra("redTouch", false));
      a(this.al, this.am, false, true);
      return;
      if (paramIntent.hasExtra("autoswitch"))
      {
        b(4);
        return;
      }
    } while (!paramIntent.hasExtra("autoConnectArrived"));
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "onReceiveScanStateChange, autoConnectArrived");
    }
    b(5);
  }
  
  public void a(MsfCore paramMsfCore, boolean paramBoolean)
  {
    if (this.aw)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "QQWifi already register.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "QQWifi register,isSyncRegister=" + paramBoolean);
    }
    this.ah = paramMsfCore;
    this.aw = true;
    if (paramBoolean)
    {
      a(paramMsfCore);
      return;
    }
    new Thread(new q(this, paramMsfCore)).start();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = 1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onRecvAvailResponse :");
      if (paramFromServiceMsg == null)
      {
        paramToServiceMsg = "null";
        QLog.d("QQWiFiScanManager", 2, paramToServiceMsg);
      }
    }
    else
    {
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess())) {
        break label434;
      }
      paramToServiceMsg = new UniPacket(true);
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (b)paramToServiceMsg.getByClass("rsp", new b());
      if ((paramToServiceMsg == null) || (paramToServiceMsg.a != 0)) {
        break label352;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "onRecvAvailResponse, availpush=" + paramToServiceMsg.d);
      }
      this.aC = paramToServiceMsg.d;
      if (paramToServiceMsg.b.isEmpty()) {
        break label282;
      }
      if (!n()) {
        break label260;
      }
      if ((this.aj.e) && (this.aC == 1)) {
        a(1008, "", false, false);
      }
      label198:
      if (!a(this.au, paramToServiceMsg.b)) {
        break label274;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "onRecvAvailResponse, isSubset=true");
      }
    }
    for (;;)
    {
      this.au.clear();
      this.au.addAll(paramToServiceMsg.b);
      return;
      paramToServiceMsg = paramFromServiceMsg.toString();
      break;
      label260:
      a(1001, "", false, false);
      break label198;
      label274:
      t();
    }
    for (;;)
    {
      try
      {
        label282:
        paramToServiceMsg = ((ConnectivityManager)this.ai.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((paramToServiceMsg == null) || (paramToServiceMsg.getType() != 1)) {
          break label346;
        }
        if (i1 != 0) {
          break;
        }
        a(1009, "", false, false);
        return;
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("QQWiFiScanManager", 2, "onRecvAvailResponse, qqwifi not avail", paramToServiceMsg);
      return;
      label346:
      i1 = 0;
    }
    label352:
    this.as.clear();
    for (;;)
    {
      try
      {
        paramToServiceMsg = ((ConnectivityManager)this.ai.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((paramToServiceMsg == null) || (paramToServiceMsg.getType() != 1)) {
          break label428;
        }
        i1 = 1;
        if (i1 != 0) {
          break;
        }
        a(1009, "", false, false);
        return;
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("QQWiFiScanManager", 2, "onRecvAvailResponse, qqwifi not avail", paramToServiceMsg);
      return;
      label428:
      i1 = 0;
    }
    label434:
    this.as.clear();
  }
  
  public void a(boolean paramBoolean)
  {
    this.aB = paramBoolean;
    if (paramBoolean) {
      ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(f.H);
    }
  }
  
  public void b()
  {
    if (this.aw) {
      BaseApplication.getContext().unregisterReceiver(this.aD);
    }
    this.aw = false;
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "unregister");
    }
  }
  
  public void b(Intent paramIntent)
  {
    if (this.aB)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "onResponseWifiStatechange isCurUinQuited true, return");
      }
      return;
    }
    int i1 = paramIntent.getIntExtra("wifi_state", 0);
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiScanManager", 2, " onResponseWifiStatechange, wifiState=" + i1);
    }
    switch (i1)
    {
    case 2: 
    default: 
      return;
    case 1: 
      a(1004, "", false, false);
      return;
    }
    paramIntent = (ConnectivityManager)this.ai.getSystemService("connectivity");
    for (;;)
    {
      try
      {
        paramIntent = paramIntent.getAllNetworkInfo();
        if ((paramIntent == null) || (paramIntent.length >= 0) || (paramIntent[0].getState() != NetworkInfo.State.CONNECTED)) {
          break label181;
        }
        i1 = 1;
        if (i1 != 0) {
          break;
        }
        a(1003, "", false, false);
        return;
      }
      catch (Throwable paramIntent) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("QQWiFiScanManager", 2, QLog.getStackTraceString(paramIntent));
      return;
      label181:
      i1 = 0;
    }
  }
  
  public void c()
  {
    try
    {
      if ((k()) && (this.aj.b)) {
        ((WifiManager)this.ai.getSystemService("wifi")).startScan();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQWiFiScanManager", 2, "scan", localThrowable);
    }
  }
  
  public void d()
  {
    try
    {
      if (this.aB) {
        return;
      }
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.ai.getSystemService("connectivity")).getActiveNetworkInfo();
      localObject2 = (WifiManager)this.ai.getSystemService("wifi");
      i1 = ((WifiManager)localObject2).getWifiState();
      if (localNetworkInfo == null) {
        if (3 == i1)
        {
          a(1003, "", false, false);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      int i1;
      if (QLog.isColorLevel())
      {
        QLog.e("QQWiFiScanManager", 2, localException.getMessage());
        return;
        a(1004, "", false, false);
        return;
        if (3 != i1)
        {
          a(1004, "", false, false);
          return;
        }
        if ((localException.getType() == 1) || (localException.getType() == 9))
        {
          WifiInfo localWifiInfo = ((WifiManager)localObject2).getConnectionInfo();
          localObject2 = "";
          Object localObject1 = localObject2;
          if (localWifiInfo != null)
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(localWifiInfo.getSSID())) {
              localObject1 = localWifiInfo.getSSID().replace("\"", "");
            }
          }
          a(1007, (String)localObject1, false, false);
          return;
        }
        if ((k()) && (this.aj.b)) {
          ((WifiManager)localObject2).startScan();
        }
      }
    }
  }
  
  public void e()
  {
    if (!this.aj.b) {}
    Object localObject3;
    int i1;
    label422:
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject1 = ((ConnectivityManager)this.ai.getSystemService("connectivity")).getActiveNetworkInfo();
          if ((localObject1 != null) && (((NetworkInfo)localObject1).getType() == 1))
          {
            localObject1 = ((ActivityManager)this.ai.getSystemService("activity")).getRunningAppProcesses();
            if (localObject1 != null)
            {
              localObject1 = ((List)localObject1).iterator();
              while (((Iterator)localObject1).hasNext()) {
                if ("com.tencent.mobileqq:qqwifi".equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next()).processName)) {
                  return;
                }
              }
            }
            localObject1 = NetConnInfoCenter.impl;
            a(NetConnInfoCenterImpl.msfCore, true);
            localObject3 = "";
            localObject1 = "";
            Object localObject4 = ((WifiManager)this.ai.getSystemService("wifi")).getConnectionInfo();
            if (localObject4 != null)
            {
              localObject3 = ((WifiInfo)localObject4).getBSSID();
              i1 = ((WifiInfo)localObject4).getIpAddress();
              localObject1 = String.format("%d.%d.%d.%d", new Object[] { Integer.valueOf(i1 & 0xFF), Integer.valueOf(i1 >> 8 & 0xFF), Integer.valueOf(i1 >> 16 & 0xFF), Integer.valueOf(i1 >> 24 & 0xFF) });
            }
            if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
            {
              localObject4 = BaseApplication.getContext();
              if (Build.VERSION.SDK_INT <= 10) {
                break label638;
              }
              i1 = 4;
              localObject4 = ((BaseApplication)localObject4).getSharedPreferences("mobileQQ", i1);
              if (localObject4 != null)
              {
                localObject4 = ((SharedPreferences)localObject4).getString("qqwifiConnInfo", "");
                if (!TextUtils.isEmpty((CharSequence)localObject4))
                {
                  Object localObject6 = new JSONObject((String)localObject4);
                  localObject4 = ((JSONObject)localObject6).optString("ssid");
                  Object localObject5 = ((JSONObject)localObject6).optString("bssid");
                  localObject6 = ((JSONObject)localObject6).optString("IPAdress");
                  if ((((String)localObject3).equals(localObject5)) && (((String)localObject1).equals(localObject6)))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.i("QQWiFiScanManager", 2, "checkConnection:remove netWork！ssid=" + (String)localObject4 + " bssid=" + (String)localObject5 + " IPAdress=" + (String)localObject6);
                    }
                    localObject5 = (WifiManager)this.ai.getSystemService("wifi");
                    localObject6 = ((WifiManager)localObject5).getConfiguredNetworks();
                    if (localObject6 != null)
                    {
                      i1 = 0;
                      localObject1 = localObject4;
                      if (i1 < ((List)localObject6).size())
                      {
                        localObject4 = (WifiConfiguration)((List)localObject6).get(i1);
                        localObject3 = localObject1;
                        if (localObject4 == null) {
                          break label644;
                        }
                        if (TextUtils.isEmpty(((WifiConfiguration)localObject4).SSID)) {
                          break label629;
                        }
                        String str = ((WifiConfiguration)localObject4).SSID.replace("\"", "");
                        localObject1 = ((String)localObject1).replace("\"", "");
                        localObject3 = localObject1;
                        if (!str.equals(localObject1)) {
                          break label644;
                        }
                        ((WifiManager)localObject5).removeNetwork(((WifiConfiguration)localObject4).networkId);
                        localObject3 = localObject1;
                        if (!QLog.isColorLevel()) {
                          break label644;
                        }
                        QLog.i("QQWiFiScanManager", 2, "checkConnection：已经删除了" + ((WifiConfiguration)localObject4).SSID + "网络" + " networkId:" + ((WifiConfiguration)localObject4).networkId + " bssid:" + ((WifiConfiguration)localObject4).BSSID);
                        localObject3 = localObject1;
                        break label644;
                      }
                      ((WifiManager)localObject5).saveConfiguration();
                      return;
                    }
                  }
                }
              }
            }
          }
        }
        catch (Throwable localThrowable) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQWiFiScanManager", 2, "checkConnection:Exception:" + localThrowable.getMessage());
    return;
    for (;;)
    {
      label629:
      i1 += 1;
      break label422;
      label638:
      i1 = 0;
      break;
      label644:
      Object localObject2 = localObject3;
    }
  }
  
  private class a
  {
    public String a = "";
    public boolean b;
    public String c = "";
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public int h = 10;
    public long i = 30000L;
    public long j = 60000L;
    public long k = 86400000L;
    public boolean l;
    public int m;
    public long n = 21600000L;
    public int o = 1;
    public boolean p;
    public String q;
    public String r;
    
    private a() {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */