package com.tencent.mobileqq.msf.core.push;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat.Builder;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.mobileqq.msf.core.c.e.a;
import com.tencent.mobileqq.msf.core.c.i;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.msf.core.w;
import com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.pb.offlinepush.C2CMsgReadedNotify;
import com.tencent.msf.service.protocol.pb.offlinepush.C2CTmpOffMsgHead;
import com.tencent.msf.service.protocol.pb.offlinepush.DisMsgReadedNotify;
import com.tencent.msf.service.protocol.pb.offlinepush.DiscussOffInfo;
import com.tencent.msf.service.protocol.pb.offlinepush.GroupOffInfo;
import com.tencent.msf.service.protocol.pb.offlinepush.PbPushOffMsg;
import com.tencent.msf.service.protocol.pb.offlinepush.PbPushOffReadedNotify;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class f
  extends BroadcastReceiver
{
  static int E = 10101;
  static int F = 10102;
  public static int G = 10103;
  public static int H = 10104;
  public static final String M = "com.tencent.mobileqq.msf.receiveofflinepush";
  public static final String N = "com.tencent.mobileqq.msf.offlinepushclearall";
  public static final String O = "com.tencent.mobileqq.msf.devlockquickloginpush";
  public static final String P = "com.tencent.mobileqq.msf.devlockquickloginpushclear";
  public static final String Q = "com.tencent.mobileqq.action.QQWiFi";
  public static final String R = "com.tencent.mobileqq.msf.qqwifi.settings";
  public static final String S = "com.tencent.mobileqq.msf.qqwifi.redtouch";
  public static final String T = "com.tencent.mobileqq.msf.qqwifi.autoconnect";
  public static final String U = "com.tencent.mobileqq.msf.receiveofflinepushav";
  public static final String V = "com.tencent.mobileqq.msf.offlinepushclearallav";
  static final int X = 20140416;
  public static final String a = "app_push_info_";
  private static final String aA = "com.tencent.mobileqq.broadcast.pcactiveQQ";
  public static final int ag = 0;
  public static final int ah = 1;
  public static final int ai = 2;
  public static final int aj = 3;
  public static final int ak = -56;
  public static final int al = -55;
  private static final int[] aq = { 1, 1, 1, 5, 5, 10, 10, 30, 30, 60, 60, 900, 900 };
  private static int ar = 0;
  private static final long[] az = { 100L, 200L, 200L, 100L };
  static final String e = "MSF.C.PushManager";
  static final String f = "PCActivePush";
  static SimpleDateFormat g = new SimpleDateFormat("dd HH:mm:ss");
  public static final String j = "alarmAddedTime";
  public static long k = 0L;
  public static boolean q = false;
  public static String r = "0";
  public static volatile boolean s = false;
  static final String t = "OnlinePush.ReqPush";
  static final String u = "CliNotifySvc.SvcReqPush";
  static final String v = "StatSvc.QueryHB";
  long A = 0L;
  public long B;
  public long C;
  public long D;
  ArrayList I = new ArrayList();
  ArrayList J = new ArrayList();
  boolean K = false;
  boolean L = false;
  public MediaPlayer W;
  Handler Y = new l(this);
  String Z = Environment.getExternalStorageDirectory().getAbsolutePath();
  private AtomicBoolean aB = new AtomicBoolean(false);
  private String aC = "0";
  private int aD = -1;
  private PendingIntent aE;
  private BroadcastReceiver aF = new k(this);
  private int aG;
  private boolean aH;
  private Object aI = new Object();
  String aa = this.Z + "/Tencent/MobileQQ/";
  String ab = "head/";
  String ac = this.aa + this.ab + "_hd/";
  String ad = this.aa + this.ab + "_thd/";
  String ae = this.ab + "_hd/";
  String af = this.aa + ".billd_urldrawable/";
  String am = "message.ring.switch";
  String an = "message.vibrate.switch";
  String ao = "message.ring.care";
  public ToServiceMsg ap;
  private final int as = 1;
  private PendingIntent at;
  private b au;
  private Handler av = new g(this);
  private boolean aw;
  private long ax;
  private long ay;
  MsfCore b;
  String c = "";
  String d = "";
  public ConcurrentHashMap h = new ConcurrentHashMap();
  public d i;
  AlarmManager l;
  b m = new b();
  int n = -1;
  boolean o = false;
  boolean p = false;
  volatile Object w = new Object();
  int x = 30000;
  long y = 0L;
  final long z = 300000L;
  
  public f(MsfCore paramMsfCore)
  {
    this.b = paramMsfCore;
    this.i = new d(this);
    this.m.setName("MsfCorePushManager");
    this.au = new b(paramMsfCore);
    this.o = CommonBadgeUtilImpl.isMIUI6();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i2 = 0;
    int i1 = i2;
    switch (paramInt1)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg unknow msgtype:" + paramInt1);
      }
      i1 = -1;
    case 9: 
    case 10: 
    case 16: 
    case 17: 
    case 31: 
    case 79: 
    case 97: 
    case 120: 
    case 132: 
    case 133: 
    case 166: 
    case 167: 
    case 208: 
    case 529: 
    case 562: 
    case 734: 
      return i1;
    case 42: 
    case 83: 
      return 1;
    case 215: 
    case 519: 
      i1 = i2;
      switch (paramInt2)
      {
      case 1: 
      case 11: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg unknow dwVideoType:" + paramInt2);
        }
        return -1;
      case 2: 
      case 12: 
        return 2;
      }
      return 1;
    case 140: 
    case 141: 
      return 2;
    }
    return 3;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      if (paramBitmap == null) {
        return null;
      }
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
      Object localObject = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect((RectF)localObject, paramFloat, paramFloat, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localObject = new Matrix();
      ((Matrix)localObject).setRectToRect(new RectF(localRect1), new RectF(localRect2), Matrix.ScaleToFit.FILL);
      localCanvas.drawBitmap(Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true), localRect2, localRect2, localPaint);
      return localBitmap;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f1 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    int i1 = (paramInt1 + paramInt2) / 2;
    int i2 = (int)(f1 * 4.0D);
    if (i1 <= 70) {
      i1 = (int)(2.0D * f1);
    }
    for (;;)
    {
      paramInt1 = (int)(paramInt1 * f1);
      paramInt2 = (int)(f1 * paramInt2);
      return a(paramBitmap, i1, paramInt1, paramInt2);
      if (i1 <= 100) {
        i1 = (int)(f1 * 4.0D);
      } else if (i1 <= 128) {
        i1 = (int)(8.0D * f1);
      } else {
        i1 = (int)((paramInt1 / 100 * 4 + 8) * f1);
      }
    }
  }
  
  private MediaPlayer a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = paramContext.getResources().openRawResourceFd(paramInt);
      if (paramContext == null) {
        return null;
      }
      MediaPlayer localMediaPlayer = new MediaPlayer();
      a(localMediaPlayer);
      localMediaPlayer.setDataSource(paramContext.getFileDescriptor(), paramContext.getStartOffset(), paramContext.getLength());
      paramContext.close();
      localMediaPlayer.prepare();
      return localMediaPlayer;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "createAndSetAudioStreamType  create failed:", paramContext);
      }
    }
    return null;
  }
  
  private MediaPlayer a(Context paramContext, Uri paramUri)
  {
    try
    {
      MediaPlayer localMediaPlayer = new MediaPlayer();
      a(localMediaPlayer);
      localMediaPlayer.setDataSource(paramContext, paramUri);
      localMediaPlayer.prepare();
      return localMediaPlayer;
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "createAndSetAudioStreamType create failed:", paramContext);
      }
    }
    return null;
  }
  
  static Object a(Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
    throws Exception
  {
    paramString = paramObject.getClass().getMethod(paramString, paramArrayOfClass);
    paramString.setAccessible(true);
    return paramString.invoke(paramObject, paramArrayOfObject);
  }
  
  static Object a(Object paramObject, String paramString, Object[] paramArrayOfObject)
    throws Exception
  {
    return a(paramObject, paramString, a(paramArrayOfObject), paramArrayOfObject);
  }
  
  static Object a(String paramString1, String paramString2, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
    throws Exception
  {
    paramString1 = Class.forName(paramString1);
    return paramString1.getDeclaredMethod(paramString2, paramArrayOfClass).invoke(paramString1, paramArrayOfObject);
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("", Long.toString(paramLong), "OnlinePush.RespPush");
    Object localObject = BaseApplication.getContext().getPackageName();
    localToServiceMsg.setAppId(((a)this.h.get(localObject)).a);
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.setRequestSsoSeq(paramInt1);
    localToServiceMsg.setNeedCallback(false);
    localObject = new com.tencent.msf.service.protocol.c.b();
    ((com.tencent.msf.service.protocol.c.b)localObject).a = paramLong;
    ((com.tencent.msf.service.protocol.c.b)localObject).c = paramInt2;
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName("OnlinePush.RespPush");
    localUniPacket.setFuncName("SvcRespPushMsg");
    localUniPacket.setRequestId(paramInt1);
    localUniPacket.put("resp", localObject);
    localToServiceMsg.putWupBuffer(localUniPacket.encode());
    this.b.sender.b(localToServiceMsg);
  }
  
  private void a(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.setAudioStreamType(r());
  }
  
  private void a(String paramString, int paramInt)
  {
    if (com.tencent.mobileqq.msf.service.c.a())
    {
      QLog.d("PCActivePush", 1, "stop tryActiveQQ by mainProcessReady");
      try
      {
        BaseApplication.getContext().unregisterReceiver(this.aF);
        HashMap localHashMap1 = new HashMap();
        localHashMap1.put("account", paramString);
        localHashMap1.put("retryIndex", String.valueOf(paramInt));
        localHashMap1.put("reason", "mainProcessReady");
        this.b.getStatReporter().a("dim.Msf.PCActiveQQResult", true, 0L, 0L, localHashMap1, false, false);
        this.aB.set(false);
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
        }
      }
    }
    if (paramInt >= com.tencent.mobileqq.msf.core.a.a.T())
    {
      QLog.d("PCActivePush", 1, "stop tryActiveQQ index: " + paramInt);
      try
      {
        BaseApplication.getContext().unregisterReceiver(this.aF);
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put("account", paramString);
        localHashMap2.put("retryIndex", String.valueOf(paramInt));
        localHashMap2.put("reason", "tryTooMuch");
        this.b.getStatReporter().a("dim.Msf.PCActiveQQResult", false, 0L, 0L, localHashMap2, false, false);
        this.aB.set(false);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
    QLog.d("PCActivePush", 1, "tryActiveQQ index: " + paramInt);
    Intent localIntent = new Intent("com.tencent.mobileqq.broadcast.qq");
    localIntent.putExtra("k_start_mode", 1);
    localIntent.putExtra("k_pcactive_uin", paramString);
    localIntent.putExtra("k_pcactive_retryIndex", paramInt);
    BaseApplication.getContext().sendBroadcast(localIntent);
    this.aC = paramString;
    this.aD = paramInt;
    localIntent = new Intent("com.tencent.mobileqq.broadcast.pcactiveQQ");
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("retryIndex", paramInt + 1);
    this.aE = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, localIntent, 134217728);
    this.l.set(0, System.currentTimeMillis() + 300000, this.aE);
  }
  
  public static boolean a(Context paramContext, long paramLong)
  {
    if (SettingCloneUtil.readValue(paramContext, "" + paramLong, "通知时指示灯闪烁", "qqsetting_notify_blncontrol_key", true))
    {
      boolean bool = SettingCloneUtil.readValue(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false);
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg isNoDisturbMode:" + bool);
        }
        int i1 = Calendar.getInstance().get(11);
        if ((i1 < 23) && (i1 >= 8)) {}
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  private boolean a(SharedPreferences paramSharedPreferences)
  {
    try
    {
      if ((this.I != null) && (this.I.size() > 0))
      {
        offlinepush.PbPushOffMsg localPbPushOffMsg = ((a)this.I.get(this.I.size() - 1)).a;
        boolean bool = paramSharedPreferences.contains("special_sound_type" + localPbPushOffMsg.to_uin.get() + localPbPushOffMsg.from_uin.get());
        return bool;
      }
    }
    catch (Exception paramSharedPreferences)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushManager", 2, "-->isSpecialCareSound...exception=" + paramSharedPreferences.getMessage());
      }
      paramSharedPreferences.printStackTrace();
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    return (paramString1.equals(paramString2)) || (paramString1.equals(paramString2 + ":video")) || (paramString1.equals(paramString2 + ":QQ"));
  }
  
  static Class[] a(Object[] paramArrayOfObject)
  {
    Object localObject = (Class[])null;
    if (paramArrayOfObject != null)
    {
      Class[] arrayOfClass = new Class[paramArrayOfObject.length];
      int i1 = 0;
      int i2 = paramArrayOfObject.length;
      localObject = arrayOfClass;
      if (i1 < i2)
      {
        if (paramArrayOfObject[i1] != null)
        {
          arrayOfClass[i1] = paramArrayOfObject[i1].getClass();
          label44:
          if (arrayOfClass[i1] != Integer.class) {
            break label75;
          }
          arrayOfClass[i1] = Integer.TYPE;
        }
        for (;;)
        {
          i1 += 1;
          break;
          arrayOfClass[i1] = String.class;
          break label44;
          label75:
          if (arrayOfClass[i1] == Boolean.class) {
            arrayOfClass[i1] = Boolean.TYPE;
          }
        }
      }
    }
    return (Class[])localObject;
  }
  
  public static boolean b(Context paramContext)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    boolean bool;
    if (localTelephonyManager != null) {
      if (localTelephonyManager.getCallState() != 0) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "isCalling: " + bool);
      }
      return bool;
      int i1;
      try
      {
        if (((Integer)a(localTelephonyManager, "getCallStateGemini", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) })).intValue() != 0)
        {
          bool = true;
          continue;
        }
        i1 = ((Integer)a(localTelephonyManager, "getCallStateGemini", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) })).intValue();
        if (i1 != 0) {
          bool = true;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "1 isCalling Exception", localException);
        }
      }
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone2");
        if (paramContext != null) {
          if (paramContext.getCallState() != 0) {
            bool = true;
          }
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext = null;
        }
        try
        {
          if (((Integer)a(paramContext, "getCallStateGemini", new Object[] { Integer.valueOf(0) })).intValue() != 0)
          {
            bool = true;
            continue;
          }
          i1 = ((Integer)a(paramContext, "getCallStateGemini", new Object[] { Integer.valueOf(1) })).intValue();
          if (i1 != 0) {
            bool = true;
          }
        }
        catch (Exception paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager", 2, "2 isCalling Exception", paramContext);
          }
        }
        try
        {
          paramContext = a("android.telephony.MSimTelephonyManager", "getDefault", null, null);
          if (((Integer)a(paramContext, "getCallState", new Object[] { Integer.valueOf(0) })).intValue() != 0)
          {
            bool = true;
          }
          else
          {
            i1 = ((Integer)a(paramContext, "getCallState", new Object[] { Integer.valueOf(1) })).intValue();
            if (i1 != 0) {
              bool = true;
            } else {
              bool = false;
            }
          }
        }
        catch (Exception paramContext)
        {
          bool = false;
        }
      }
    }
  }
  
  private Object[] b(int paramInt, String paramString)
  {
    if ((paramInt != 3) && (paramInt == 1)) {
      new StringBuilder().append("troop_").append(paramString).toString();
    }
    return new Object[] { Integer.valueOf(paramInt), paramString };
  }
  
  private Object[] b(offlinepush.PbPushOffMsg paramPbPushOffMsg)
  {
    Object localObject5 = null;
    String str;
    int i1;
    if (paramPbPushOffMsg.msg_str.has())
    {
      str = paramPbPushOffMsg.msg_str.get().toStringUtf8();
      i1 = a(paramPbPushOffMsg.msg_type.get(), paramPbPushOffMsg.dwViedoType.get());
      this.n = i1;
    }
    Object localObject1;
    Object localObject4;
    Object localObject3;
    label251:
    label306:
    long l1;
    switch (i1)
    {
    default: 
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg no msg str exit");
      }
      return null;
    case 0: 
      if ((paramPbPushOffMsg.from_nick.has()) && (paramPbPushOffMsg.from_nick.get().toStringUtf8().length() != 0))
      {
        localObject1 = paramPbPushOffMsg.from_nick.get().toStringUtf8();
        if (!paramPbPushOffMsg.from_uin.has()) {
          break label251;
        }
        paramPbPushOffMsg.from_uin.get();
        paramPbPushOffMsg = a(0, "" + paramPbPushOffMsg.from_uin.get());
        localObject4 = null;
        localObject2 = localObject1;
        localObject3 = localObject5;
        localObject1 = localObject4;
      }
    case 1: 
    case 2: 
      for (;;)
      {
        return new Object[] { Integer.valueOf(i1), str, localObject2, paramPbPushOffMsg, localObject1, localObject3 };
        localObject1 = Long.toString(paramPbPushOffMsg.from_uin.get());
        break;
        localObject3 = null;
        localObject2 = localObject1;
        paramPbPushOffMsg = "";
        localObject1 = localObject3;
        localObject3 = localObject5;
        continue;
        if (paramPbPushOffMsg.discuss_info.has())
        {
          if (paramPbPushOffMsg.discuss_info.discuss_remark.has())
          {
            localObject1 = paramPbPushOffMsg.discuss_info.discuss_remark.get().toStringUtf8();
            if (!paramPbPushOffMsg.discuss_info.dis_name.has()) {
              break label455;
            }
          }
          label455:
          for (localObject2 = paramPbPushOffMsg.discuss_info.dis_name.get().toStringUtf8();; localObject2 = Long.toString(paramPbPushOffMsg.discuss_info.discuss_uin.get()))
          {
            if (!paramPbPushOffMsg.discuss_info.discuss_uin.has()) {
              break label489;
            }
            l1 = paramPbPushOffMsg.discuss_info.discuss_uin.get();
            if (localObject2 != null)
            {
              localObject3 = localObject2;
              if (((String)localObject2).length() != 0) {}
            }
            else
            {
              localObject3 = Long.toString(l1);
            }
            paramPbPushOffMsg = a(3, "" + l1);
            localObject2 = localObject1;
            localObject1 = localObject3;
            localObject3 = localObject5;
            break;
            if (paramPbPushOffMsg.from_nick.has())
            {
              localObject1 = paramPbPushOffMsg.from_nick.get().toStringUtf8();
              break label306;
            }
            localObject1 = Long.toString(paramPbPushOffMsg.from_uin.get());
            break label306;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get discuss msg, but no msg.discuss_info exit");
        }
        return null;
        label489:
        localObject4 = localObject1;
        paramPbPushOffMsg = "";
        localObject1 = localObject2;
        localObject3 = localObject5;
        localObject2 = localObject4;
        continue;
        if (paramPbPushOffMsg.c2c_tmp_msg_head.has())
        {
          if ((paramPbPushOffMsg.from_nick.has()) && (paramPbPushOffMsg.from_nick.get().toStringUtf8().length() != 0)) {
            localObject1 = paramPbPushOffMsg.from_nick.get().toStringUtf8();
          }
          for (;;)
          {
            if (!paramPbPushOffMsg.c2c_tmp_msg_head.group_uin.has()) {
              break label756;
            }
            l1 = paramPbPushOffMsg.c2c_tmp_msg_head.group_uin.get();
            paramPbPushOffMsg = a(3, "" + l1);
            localObject3 = null;
            localObject2 = localObject1;
            localObject1 = localObject3;
            localObject3 = localObject5;
            break;
            if (paramPbPushOffMsg.c2c_tmp_msg_head.discuss_remark.has())
            {
              localObject1 = paramPbPushOffMsg.c2c_tmp_msg_head.discuss_remark.get().toStringUtf8();
            }
            else if (paramPbPushOffMsg.c2c_tmp_msg_head.group_card.has())
            {
              localObject1 = paramPbPushOffMsg.c2c_tmp_msg_head.group_card.get().toStringUtf8();
            }
            else if (paramPbPushOffMsg.c2c_tmp_msg_head.group_name.has())
            {
              localObject1 = paramPbPushOffMsg.c2c_tmp_msg_head.group_name.get().toStringUtf8();
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get c2c temp msg, no nick find use from_uin");
              }
              localObject1 = Long.toString(paramPbPushOffMsg.from_uin.get());
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get c2c temp msg, but no msg.c2c_tmp_msg_head exit");
        }
        return null;
        label756:
        if (paramPbPushOffMsg.c2c_tmp_msg_head.group_code.has())
        {
          l1 = paramPbPushOffMsg.c2c_tmp_msg_head.group_code.get();
          paramPbPushOffMsg = a(3, "" + l1);
          localObject3 = null;
          localObject2 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject5;
        }
        else
        {
          localObject3 = null;
          localObject2 = localObject1;
          paramPbPushOffMsg = "";
          localObject1 = localObject3;
          localObject3 = localObject5;
        }
      }
    }
    if (paramPbPushOffMsg.group_info.has()) {
      if (paramPbPushOffMsg.group_info.group_card.has())
      {
        localObject1 = paramPbPushOffMsg.group_info.group_card.get().toStringUtf8();
        label877:
        if (!paramPbPushOffMsg.group_info.group_name.has()) {
          break label1046;
        }
      }
    }
    label1046:
    for (Object localObject2 = paramPbPushOffMsg.group_info.group_name.get().toStringUtf8();; localObject2 = null)
    {
      if (paramPbPushOffMsg.group_info.group_code.has())
      {
        l1 = paramPbPushOffMsg.group_info.group_code.get();
        if (localObject2 != null)
        {
          paramPbPushOffMsg = (offlinepush.PbPushOffMsg)localObject2;
          if (((String)localObject2).length() != 0) {}
        }
        else
        {
          paramPbPushOffMsg = Long.toString(l1);
        }
        localObject3 = a(1, "" + l1);
        localObject4 = null;
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = paramPbPushOffMsg;
        paramPbPushOffMsg = (offlinepush.PbPushOffMsg)localObject1;
        localObject1 = localObject4;
        break;
        localObject1 = Long.toString(paramPbPushOffMsg.from_uin.get());
        break label877;
      }
      localObject3 = null;
      localObject4 = localObject1;
      paramPbPushOffMsg = "";
      localObject1 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject4;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get troop msg, but no msg.group_info exit");
      }
      return null;
    }
  }
  
  private Object[] b(boolean paramBoolean)
  {
    Object[] arrayOfObject;
    Object localObject;
    String str1;
    String str2;
    String str3;
    long l1;
    if ((this.I.size() == 1) && (!paramBoolean))
    {
      arrayOfObject = new Object[4];
      localObject = b(((a)this.I.get(0)).a);
      if (localObject == null) {
        return null;
      }
      switch (((Integer)localObject[0]).intValue())
      {
      default: 
        return null;
      case 0: 
      case 2: 
        str1 = "[离线消息]" + localObject[2] + ":" + localObject[1];
        str2 = localObject[2] + "[离线消息]";
        str3 = (String)localObject[1];
        arrayOfObject[0] = str1;
        arrayOfObject[1] = str2;
        arrayOfObject[2] = str3;
        arrayOfObject[3] = localObject[3];
        return arrayOfObject;
      case 1: 
        str1 = "[离线消息]" + localObject[2] + "(" + localObject[4] + ")" + ":" + localObject[1];
        str2 = localObject[4] + "[离线消息]";
        str3 = localObject[2] + ":" + localObject[1];
        arrayOfObject[0] = str1;
        arrayOfObject[1] = str2;
        arrayOfObject[2] = str3;
        arrayOfObject[3] = localObject[3];
        return arrayOfObject;
      }
      if (!((a)this.I.get(0)).a.msg_flag.has()) {
        break label1764;
      }
      l1 = ((a)this.I.get(0)).a.msg_flag.get();
      if ((0x2 & l1) == 2L) {
        str1 = "[有人@我]";
      }
    }
    for (;;)
    {
      str2 = "[离线消息]" + str1 + localObject[2] + ":" + localObject[1];
      str3 = localObject[5] + "[离线消息]";
      str1 = str1 + localObject[2] + ":" + localObject[1];
      arrayOfObject[0] = str2;
      arrayOfObject[1] = str3;
      arrayOfObject[2] = str1;
      arrayOfObject[3] = localObject[3];
      return arrayOfObject;
      if ((l1 & 1L) == 1L)
      {
        str1 = "[特别关注]";
        continue;
        int i1 = t();
        if ((i1 == 1) && (!paramBoolean))
        {
          arrayOfObject = b(((a)this.I.get(this.I.size() - 1)).a);
          if (arrayOfObject == null) {
            return null;
          }
          localObject = new Object[4];
          switch (((Integer)arrayOfObject[0]).intValue())
          {
          default: 
            return null;
          case 0: 
          case 2: 
            str1 = "[离线消息]" + arrayOfObject[2] + ":" + arrayOfObject[1];
            str2 = arrayOfObject[2] + "[" + this.I.size() + "条离线消息]";
            str3 = (String)arrayOfObject[1];
            localObject[0] = str1;
            localObject[1] = str2;
            localObject[2] = str3;
            localObject[3] = arrayOfObject[3];
            return (Object[])localObject;
          case 1: 
            int i2 = u();
            if (i2 == 1) {}
            for (i1 = 1; i1 != 0; i1 = 0)
            {
              str1 = "[离线消息]" + arrayOfObject[2] + "(" + arrayOfObject[4] + ")" + ":" + arrayOfObject[1];
              str2 = arrayOfObject[4] + "[" + this.I.size() + "条离线消息]";
              str3 = arrayOfObject[2] + ":" + arrayOfObject[1];
              localObject[0] = str1;
              localObject[1] = str2;
              localObject[2] = str3;
              localObject[3] = arrayOfObject[3];
              return (Object[])localObject;
            }
            localObject[2] = ("有" + i2 + "个联系人给你发来" + this.I.size() + "条离线消息");
            localObject[3] = arrayOfObject[3];
            localObject[1] = "QQ[离线消息]";
            localObject[0] = ("[离线消息]" + arrayOfObject[2] + "(" + arrayOfObject[4] + ")" + ":" + arrayOfObject[1]);
            return (Object[])localObject;
          }
          if (!((a)this.I.get(0)).a.msg_flag.has()) {
            break label1758;
          }
          l1 = ((a)this.I.get(this.I.size() - 1)).a.msg_flag.get();
          if ((0x2 & l1) == 2L) {
            str1 = "[有人@我]";
          }
        }
        for (;;)
        {
          str2 = "[离线消息]" + str1 + arrayOfObject[2] + ":" + arrayOfObject[1];
          str3 = arrayOfObject[5] + "[" + this.I.size() + "条离线消息]";
          str1 = str1 + arrayOfObject[2] + ":" + arrayOfObject[1];
          localObject[0] = str2;
          localObject[1] = str3;
          localObject[2] = str1;
          localObject[3] = arrayOfObject[3];
          return (Object[])localObject;
          if ((l1 & 1L) == 1L)
          {
            str1 = "[特别关注]";
            continue;
            arrayOfObject = b(((a)this.I.get(this.I.size() - 1)).a);
            if (arrayOfObject == null) {
              return null;
            }
            switch (((Integer)arrayOfObject[0]).intValue())
            {
            default: 
              break;
            case 0: 
            case 2: 
              str1 = "有" + i1 + "个联系人给你发来" + this.I.size() + "条离线消息";
              localObject = arrayOfObject[3];
              return new Object[] { "[离线消息]" + arrayOfObject[2] + ":" + arrayOfObject[1], "QQ[离线消息]", str1, localObject };
            case 1: 
              str1 = "有" + i1 + "个联系人给你发来" + this.I.size() + "条离线消息";
              localObject = arrayOfObject[3];
              return new Object[] { "[离线消息]" + arrayOfObject[2] + "(" + arrayOfObject[4] + ")" + ":" + arrayOfObject[1], "QQ[离线消息]", str1, localObject };
            case 3: 
              if (((a)this.I.get(0)).a.msg_flag.has())
              {
                l1 = ((a)this.I.get(this.I.size() - 1)).a.msg_flag.get();
                if ((0x2 & l1) == 2L) {
                  str1 = "[有人@我]";
                }
              }
              for (;;)
              {
                return new Object[] { "[离线消息]" + str1 + arrayOfObject[2] + ":" + arrayOfObject[1], "QQ[离线消息]", "有" + i1 + "个联系人给你发来" + this.I.size() + "条离线消息", arrayOfObject[3] };
                if ((l1 & 1L) == 1L) {
                  str1 = "[特别关注]";
                } else {
                  str1 = "";
                }
              }
            }
          }
          label1758:
          str1 = "";
        }
      }
      else
      {
        label1764:
        str1 = "";
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    offlinepush.PbPushOffMsg localPbPushOffMsg;
    BaseApplication localBaseApplication;
    if (this.I.size() > 0)
    {
      localPbPushOffMsg = ((a)this.I.get(0)).a;
      localBaseApplication = BaseApplication.getContext();
      localObject1 = b(paramBoolean);
      if (localObject1 == null) {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "Decode Message error, exit now");
        }
      }
    }
    else
    {
      ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(E);
      return;
    }
    Object localObject2 = (String)localObject1[0];
    Object localObject4 = (String)localObject1[1];
    String str = (String)localObject1[2];
    Object localObject1 = BitmapFactory.decodeFile((String)localObject1[3]);
    if (localObject1 != null) {
      localObject1 = a((Bitmap)localObject1, 50, 50);
    }
    for (;;)
    {
      NotificationManager localNotificationManager = (NotificationManager)localBaseApplication.getSystemService("notification");
      localObject2 = new NotificationCompat.Builder(localBaseApplication).setContentTitle((CharSequence)localObject4).setContentText(str).setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker((CharSequence)localObject2).setWhen(System.currentTimeMillis());
      label188:
      int i1;
      if (localObject1 != null)
      {
        ((NotificationCompat.Builder)localObject2).setLargeIcon((Bitmap)localObject1);
        if (Build.VERSION.SDK_INT < 11) {
          ((NotificationCompat.Builder)localObject2).setSmallIcon(BaseApplication.qqlaunchicon);
        }
        if (a(localBaseApplication, localPbPushOffMsg.to_uin.get()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager", 2, "isShowNofityLight=true");
          }
          i1 = Calendar.getInstance().get(11);
          if ((i1 < 23) && (i1 < 8)) {}
          ((NotificationCompat.Builder)localObject2).setLights(-16711936, 2000, 2000);
        }
        ((NotificationCompat.Builder)localObject2).setContentIntent(PendingIntent.getBroadcast(localBaseApplication, 0, new Intent("com.tencent.mobileqq.msf.receiveofflinepush"), 0));
        ((NotificationCompat.Builder)localObject2).setDeleteIntent(PendingIntent.getBroadcast(localBaseApplication, 0, new Intent("com.tencent.mobileqq.msf.offlinepushclearall"), 0));
        localObject1 = ((NotificationCompat.Builder)localObject2).build();
        if (localNotificationManager != null) {
          localNotificationManager.cancel(E);
        }
        if (!this.o) {}
      }
      try
      {
        localObject2 = BaseApplication.getContext().getSharedPreferences("unreadcount", 4);
        i1 = ((SharedPreferences)localObject2).getInt("unread", -1);
        if (QLog.isColorLevel()) {
          QLog.i("BadgeUtilImpl", 2, "NOTIFICATION_ID_PUSH_MSG mIsPushOffAVShow " + this.L + "count=" + i1);
        }
        if (this.L)
        {
          i1 = this.I.size();
          label432:
          if (QLog.isColorLevel()) {
            QLog.i("BadgeUtilImpl", 2, "NOTIFICATION_ID_PUSH_MSG changeMI6Badge count=" + i1);
          }
          i2 = i1;
          if (this.L)
          {
            i2 = i1;
            if (this.K) {
              i2 = i1 + ((SharedPreferences)localObject2).getInt("unread", -1);
            }
          }
          this.K = true;
          BadgeUtilImpl.changeMI6Badge(BaseApplication.getContext(), i2, (Notification)localObject1);
          label518:
          localNotificationManager.notify(E, (Notification)localObject1);
          localObject1 = PreferenceManager.getDefaultSharedPreferences(localBaseApplication);
          localObject2 = localBaseApplication.getSharedPreferences("com.tencent.mobileqq_preferences", 4);
          if (c(String.valueOf(localPbPushOffMsg.to_uin.get()), localBaseApplication) != 0) {
            break label1017;
          }
          if (a(String.valueOf(localPbPushOffMsg.to_uin.get()), localBaseApplication) != 1) {
            break label1011;
          }
          i1 = 1;
          label586:
          if ((b(String.valueOf(localPbPushOffMsg.to_uin.get()), localBaseApplication) == 1) && (y()))
          {
            localObject4 = (Vibrator)localBaseApplication.getSystemService("vibrator");
            if (!a((SharedPreferences)localObject2)) {
              break label1049;
            }
            ((Vibrator)localObject4).vibrate(1000L);
          }
          label643:
          if ((i1 != 0) && (x()))
          {
            if (QLog.isColorLevel()) {
              QLog.i("PushManager", 2, "-->isSpecialCareSound:" + a((SharedPreferences)localObject2));
            }
            if (a((SharedPreferences)localObject2))
            {
              i1 = ((SharedPreferences)localObject1).getInt("sound_type" + localPbPushOffMsg.to_uin.get(), BaseApplication.defaultNotifSoundResourceId);
              i1 = ((SharedPreferences)localObject2).getInt("special_sound_type" + ((a)this.I.get(this.I.size() - 1)).a.to_uin.get() + ((a)this.I.get(this.I.size() - 1)).a.from_uin.get(), i1);
              if (i1 != 1) {
                break label1061;
              }
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          int i2;
          ((SharedPreferences)localObject2).getInt("defaulut_special_sound_source" + i1, i1);
          label1011:
          label1017:
          label1049:
          label1061:
          do
          {
            if ((a(String.valueOf(localPbPushOffMsg.to_uin.get()), localBaseApplication) != 1) || (!x())) {
              break;
            }
            a(((SharedPreferences)localObject1).getInt("sound_type" + localPbPushOffMsg.to_uin.get(), BaseApplication.defaultNotifSoundResourceId), false);
            return;
            ((NotificationCompat.Builder)localObject2).setLargeIcon(BitmapFactory.decodeResource(localBaseApplication.getResources(), BaseApplication.qqlaunchicon));
            break label188;
            i2 = this.I.size();
            i1 += i2;
            break label432;
            localThrowable = localThrowable;
            if (!QLog.isColorLevel()) {
              break label518;
            }
            QLog.i("BadgeUtilImpl", 2, "NOTIFICATION_ID_PUSH_MSG exception ex=" + localThrowable);
            break label518;
            i1 = 0;
            break label586;
            if (c(String.valueOf(localPbPushOffMsg.to_uin.get()), localBaseApplication) == 1) {}
            for (i1 = 1;; i1 = 0) {
              break;
            }
            ((Vibrator)localObject4).vibrate(az, -1);
            break label643;
            localObject3 = localThrowable.getString("special_sound_url" + i1, "");
          } while (TextUtils.isEmpty((CharSequence)localObject3));
          Object localObject3 = new File(BaseApplication.getContext().getFilesDir(), (String)localObject3);
          if (((File)localObject3).exists())
          {
            a(((File)localObject3).getAbsolutePath(), false);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("PushManager", 2, "special sound play exception|" + localException.getMessage());
            }
            localException.printStackTrace();
            continue;
            if (QLog.isColorLevel()) {
              QLog.i("PushManager", 2, "-->special sound not exist.");
            }
          }
        }
      }
    }
  }
  
  private boolean c(offlinepush.PbPushOffMsg paramPbPushOffMsg)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.PushManager", 4, "onRecvPbPushOffMsg msg_type:0x" + Integer.toHexString(paramPbPushOffMsg.msg_type.get()) + " dwViedoType:" + paramPbPushOffMsg.dwViedoType.get());
    }
    return (paramPbPushOffMsg.msg_type.get() == 734) || (paramPbPushOffMsg.msg_type.get() == 215) || (paramPbPushOffMsg.msg_type.get() == 519) || (paramPbPushOffMsg.msg_type.get() == 562);
  }
  
  private void e(String paramString)
  {
    a locala = (a)this.h.get(paramString);
    locala.n = String.valueOf(com.tencent.mobileqq.msf.core.c.e(BaseApplication.getContext()));
    JceOutputStream localJceOutputStream = new JceOutputStream();
    locala.writeTo(localJceOutputStream);
    MsfStore.getNativeConfigStore().setConfig("app_push_info_" + paramString, HexUtil.bytes2HexStr(localJceOutputStream.toByteArray()));
  }
  
  private void s()
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.msf.wakeup");
    BaseApplication.getContext().sendBroadcast(localIntent);
  }
  
  private int t()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.I.iterator();
    label106:
    for (;;)
    {
      Long localLong;
      if (localIterator1.hasNext())
      {
        localLong = Long.valueOf(((a)localIterator1.next()).a.from_uin.get());
        Iterator localIterator2 = localArrayList.iterator();
        do
        {
          if (!localIterator2.hasNext()) {
            break;
          }
        } while (!((Long)localIterator2.next()).equals(localLong));
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          break label106;
        }
        localArrayList.add(localLong);
        break;
        return localArrayList.size();
      }
    }
  }
  
  private int u()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.I.iterator();
    label172:
    for (;;)
    {
      Object localObject;
      if (localIterator1.hasNext())
      {
        localObject = (a)localIterator1.next();
        switch (a(((a)localObject).a.msg_type.get(), ((a)localObject).a.dwViedoType.get()))
        {
        case 0: 
        default: 
          break;
        case 1: 
          if (!((a)localObject).a.discuss_info.has()) {
            continue;
          }
          localObject = Long.valueOf(((a)localObject).a.discuss_info.discuss_uin.get());
          Iterator localIterator2 = localArrayList.iterator();
          do
          {
            if (!localIterator2.hasNext()) {
              break;
            }
          } while (!((Long)localIterator2.next()).equals(localObject));
        }
      }
      else
      {
        for (int i1 = 1;; i1 = 0)
        {
          if (i1 != 0) {
            break label172;
          }
          localArrayList.add(localObject);
          break;
          return localArrayList.size();
        }
      }
    }
  }
  
  private Object[] v()
  {
    Object[] arrayOfObject1;
    Object[] arrayOfObject2;
    Object localObject;
    String str2;
    String str1;
    if (this.J.size() == 1)
    {
      arrayOfObject1 = new Object[4];
      arrayOfObject2 = b(((a)this.J.get(0)).a);
      if (arrayOfObject2 == null) {
        return null;
      }
      switch (((Integer)arrayOfObject2[0]).intValue())
      {
      default: 
        return null;
      case 0: 
      case 2: 
        localObject = "[离线消息]" + arrayOfObject2[2] + ":" + arrayOfObject2[1];
        str2 = arrayOfObject2[2] + "[离线消息]";
        str1 = (String)arrayOfObject2[1];
        if (b(BaseApplication.getContext())) {
          if (((String)arrayOfObject2[1]).contains("视频"))
          {
            localObject = arrayOfObject2[2] + "给你发起过视频通话，请结束当前电话后回拨。";
            str1 = "给你发起过视频通话，请结束当前电话后回拨。";
            if (((String)arrayOfObject2[1]).contains("语音"))
            {
              str1 = "给你发起过语音通话，请结束当前电话后回拨。";
              localObject = arrayOfObject2[2] + "给你发起过语音通话，请结束当前电话后回拨。";
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      arrayOfObject1[0] = localObject;
      arrayOfObject1[1] = str2;
      arrayOfObject1[2] = str1;
      arrayOfObject1[3] = arrayOfObject2[3];
      return arrayOfObject1;
      localObject = "[离线消息]" + arrayOfObject2[2] + "(" + arrayOfObject2[4] + ")" + ":" + arrayOfObject2[1];
      str1 = arrayOfObject2[4] + "[离线消息]";
      str2 = arrayOfObject2[2] + ":" + arrayOfObject2[1];
      arrayOfObject1[0] = localObject;
      arrayOfObject1[1] = str1;
      arrayOfObject1[2] = str2;
      arrayOfObject1[3] = arrayOfObject2[3];
      return arrayOfObject1;
      localObject = new Object[4];
      str1 = "收到" + this.J.size() + "个未接来电";
      localObject[2] = str1;
      localObject[1] = "QQ[离线消息]";
      localObject[0] = ("[离线消息]QQ " + str1);
      return (Object[])localObject;
      break;
    }
  }
  
  private void w()
  {
    offlinepush.PbPushOffMsg localPbPushOffMsg;
    BaseApplication localBaseApplication;
    if (this.J.size() > 0)
    {
      localPbPushOffMsg = ((a)this.J.get(0)).a;
      localBaseApplication = BaseApplication.getContext();
      localObject1 = v();
      if (localObject1 == null) {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "Decode Message error, exit now");
        }
      }
    }
    else
    {
      ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(F);
      return;
    }
    Object localObject2 = (String)localObject1[0];
    String str1 = (String)localObject1[1];
    String str2 = (String)localObject1[2];
    Object localObject1 = BitmapFactory.decodeFile((String)localObject1[3]);
    if (localObject1 != null) {
      localObject1 = a((Bitmap)localObject1, 50, 50);
    }
    for (;;)
    {
      NotificationManager localNotificationManager = (NotificationManager)localBaseApplication.getSystemService("notification");
      localObject2 = new NotificationCompat.Builder(localBaseApplication).setContentTitle(str1).setContentText(str2).setAutoCancel(true).setSmallIcon(BaseApplication.appnewavmsgicon).setTicker((CharSequence)localObject2).setWhen(System.currentTimeMillis());
      label184:
      int i1;
      if (localObject1 != null)
      {
        ((NotificationCompat.Builder)localObject2).setLargeIcon((Bitmap)localObject1);
        if (Build.VERSION.SDK_INT < 11) {
          ((NotificationCompat.Builder)localObject2).setSmallIcon(BaseApplication.qqlaunchicon);
        }
        if (a(localBaseApplication, localPbPushOffMsg.to_uin.get()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager", 2, "isShowNofityLight=true");
          }
          i1 = Calendar.getInstance().get(11);
          if ((i1 < 23) && (i1 < 8)) {}
          ((NotificationCompat.Builder)localObject2).setLights(-16711936, 2000, 2000);
        }
        ((NotificationCompat.Builder)localObject2).setContentIntent(PendingIntent.getBroadcast(localBaseApplication, 0, new Intent("com.tencent.mobileqq.msf.receiveofflinepushav"), 0));
        ((NotificationCompat.Builder)localObject2).setDeleteIntent(PendingIntent.getBroadcast(localBaseApplication, 0, new Intent("com.tencent.mobileqq.msf.offlinepushclearallav"), 0));
        localObject1 = ((NotificationCompat.Builder)localObject2).build();
        if (localNotificationManager != null) {
          localNotificationManager.cancel(F);
        }
        if (!this.o) {}
      }
      for (;;)
      {
        try
        {
          i1 = BaseApplication.getContext().getSharedPreferences("unreadcount", 4).getInt("unread", -1);
          if (!this.K) {
            continue;
          }
          i1 = this.J.size();
          if (QLog.isColorLevel()) {
            QLog.i("BadgeUtilImpl", 2, "NOTIFICATION_ID_PUSH_AVMSG changeMI6Badge count=" + i1);
          }
          this.L = true;
          BadgeUtilImpl.changeMI6Badge(BaseApplication.getContext(), i1, (Notification)localObject1);
        }
        catch (Throwable localThrowable)
        {
          int i2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("BadgeUtilImpl", 2, "NOTIFICATION_ID_PUSH_AVMSG exception ex=" + localThrowable);
          continue;
        }
        localNotificationManager.notify(F, (Notification)localObject1);
        if ((a(String.valueOf(localPbPushOffMsg.to_uin.get()), localBaseApplication) == 1) && (x())) {
          a(PreferenceManager.getDefaultSharedPreferences(localBaseApplication).getInt("sound_type" + localPbPushOffMsg.to_uin.get(), BaseApplication.defaultNotifSoundResourceId), false);
        }
        if ((b(String.valueOf(localPbPushOffMsg.to_uin.get()), localBaseApplication) != 1) || (!y())) {
          break;
        }
        ((Vibrator)localBaseApplication.getSystemService("vibrator")).vibrate(az, -1);
        return;
        ((NotificationCompat.Builder)localObject2).setLargeIcon(BitmapFactory.decodeResource(localBaseApplication.getResources(), BaseApplication.qqlaunchicon));
        break label184;
        i2 = this.J.size();
        i1 += i2;
      }
    }
  }
  
  private boolean x()
  {
    return com.tencent.qphone.base.util.a.b();
  }
  
  private boolean y()
  {
    return (com.tencent.qphone.base.util.a.d()) || ((com.tencent.qphone.base.util.a.b()) && (com.tencent.qphone.base.util.a.c()));
  }
  
  public int a(String paramString)
  {
    Iterator localIterator = this.h.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (a)this.h.get(localObject);
      if ((localObject != null) && (((a)localObject).k != null) && (((a)localObject).k.uin.equals(paramString)))
      {
        if (((a)localObject).c == 0L) {
          return -2;
        }
        return ((a)localObject).k.iStatus;
      }
    }
    return -1;
  }
  
  public int a(String paramString, Context paramContext)
  {
    if (paramString == null) {
      return 1;
    }
    paramString = paramContext.getSharedPreferences(paramString, 4).getString(this.am, String.valueOf(1));
    try
    {
      int i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 1;
  }
  
  public String a(int paramInt, String paramString)
  {
    Object localObject = BaseApplication.getContext().getFilesDir().getPath();
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      localStringBuilder.append(this.ac);
      localObject = b(paramInt, paramString);
      switch (((Integer)localObject[0]).intValue())
      {
      }
    }
    for (;;)
    {
      localObject = MD5.toMD5(paramString);
      localObject = MD5.toMD5((String)localObject + paramString);
      localStringBuilder.append(MD5.toMD5((String)localObject + paramString));
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
      localStringBuilder.append((String)localObject + this.ae);
      break;
      localStringBuilder.append("troop_sys_");
      paramString = (String)localObject[1];
      continue;
      localStringBuilder.append("sys_");
      paramString = (String)localObject[1];
      continue;
      localStringBuilder.append("discussion_");
      continue;
      localStringBuilder.append("troop_");
    }
  }
  
  public void a()
  {
    try
    {
      if (!this.p)
      {
        this.m.start();
        this.p = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   6: ifnull +32 -> 38
    //   9: aload_0
    //   10: getfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   13: invokevirtual 1399	android/media/MediaPlayer:isPlaying	()Z
    //   16: istore 4
    //   18: iload 4
    //   20: ifeq +6 -> 26
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   30: invokevirtual 1402	android/media/MediaPlayer:release	()V
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   38: iload_1
    //   39: sipush 1000
    //   42: if_icmpeq +68 -> 110
    //   45: aload_0
    //   46: aload_0
    //   47: invokestatic 470	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   50: iload_1
    //   51: invokespecial 1404	com/tencent/mobileqq/msf/core/push/f:a	(Landroid/content/Context;I)Landroid/media/MediaPlayer;
    //   54: putfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   57: aload_0
    //   58: getfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   61: ifnull -38 -> 23
    //   64: aload_0
    //   65: getfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   68: new 1406	com/tencent/mobileqq/msf/core/push/j
    //   71: dup
    //   72: aload_0
    //   73: invokespecial 1407	com/tencent/mobileqq/msf/core/push/j:<init>	(Lcom/tencent/mobileqq/msf/core/push/f;)V
    //   76: invokevirtual 1411	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   79: aload_0
    //   80: getfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   83: invokevirtual 1412	android/media/MediaPlayer:start	()V
    //   86: aload_0
    //   87: getfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   90: iload_2
    //   91: invokevirtual 1415	android/media/MediaPlayer:setLooping	(Z)V
    //   94: goto -71 -> 23
    //   97: astore_3
    //   98: aload_0
    //   99: aconst_null
    //   100: putfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   103: aload_3
    //   104: athrow
    //   105: astore_3
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_3
    //   109: athrow
    //   110: aload_0
    //   111: aload_0
    //   112: invokestatic 470	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   115: getstatic 1421	android/provider/Settings$System:DEFAULT_NOTIFICATION_URI	Landroid/net/Uri;
    //   118: invokespecial 1423	com/tencent/mobileqq/msf/core/push/f:a	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   121: putfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   124: goto -67 -> 57
    //   127: astore_3
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   133: goto -95 -> 38
    //   136: astore_3
    //   137: goto -114 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	f
    //   0	140	1	paramInt	int
    //   0	140	2	paramBoolean	boolean
    //   97	7	3	localObject1	Object
    //   105	4	3	localObject2	Object
    //   127	1	3	localException1	Exception
    //   136	1	3	localException2	Exception
    //   16	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   26	33	97	finally
    //   2	18	105	finally
    //   33	38	105	finally
    //   45	57	105	finally
    //   57	94	105	finally
    //   98	105	105	finally
    //   110	124	105	finally
    //   128	133	105	finally
    //   26	33	127	java/lang/Exception
    //   2	18	136	java/lang/Exception
    //   33	38	136	java/lang/Exception
    //   45	57	136	java/lang/Exception
    //   57	94	136	java/lang/Exception
    //   98	105	136	java/lang/Exception
    //   110	124	136	java/lang/Exception
    //   128	133	136	java/lang/Exception
  }
  
  public void a(long paramLong)
  {
    long l1;
    if (paramLong < 30000L)
    {
      if (!QLog.isColorLevel()) {
        break label204;
      }
      QLog.d("MSF.C.PushManager", 2, "queryPushIntervTime less than 30000,change to 30000.");
      l1 = 30000L;
    }
    for (;;)
    {
      if (this.at != null) {
        a(BaseApplication.getContext());
      }
      Intent localIntent = new Intent(this.d);
      localIntent.setAction(this.d);
      this.at = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, localIntent, 0);
      this.l = ((AlarmManager)BaseApplication.getContext().getSystemService("alarm"));
      this.l.set(0, System.currentTimeMillis() + l1, this.at);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "register " + this.d + " alarm alive send at " + g.format(Long.valueOf(System.currentTimeMillis() + l1)));
      }
      return;
      l1 = paramLong;
      if (paramLong > 3600000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "queryPushIntervTime greater than 600000 ,change to 600000.");
        }
        l1 = 3600000L;
        continue;
        label204:
        l1 = 30000L;
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.ax = paramLong1;
    c(paramLong2);
  }
  
  public void a(Context paramContext)
  {
    if (this.at != null) {
      this.l.cancel(this.at);
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    this.c = (Build.MODEL + "|" + Build.VERSION.RELEASE);
    this.d = (MsfSdkUtils.getProcessName(paramContext) + "_" + getClass().hashCode());
    paramContext = new IntentFilter();
    paramContext.addAction(this.d);
    BaseApplication.getContext().registerReceiver(this, paramContext);
    this.l = ((AlarmManager)BaseApplication.getContext().getSystemService("alarm"));
    a(paramBoolean);
  }
  
  public void a(a parama, m paramm)
  {
    if (parama.c > 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "send " + parama.b + " push register, pushId is " + parama.c);
      }
      this.i.a(parama, null, false, paramm);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MSF.C.PushManager", 2, parama.b + " queryPushId is " + parama.c + " ,skip register.");
  }
  
  public void a(CommandCallbackerInfo paramCommandCallbackerInfo, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      String str = com.tencent.mobileqq.msf.service.g.b(paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + str + " appCmdCallbacker " + paramCommandCallbackerInfo);
      }
      if (!this.h.containsKey(str)) {
        this.h.putIfAbsent(str, new a(str));
      }
      ((a)this.h.get(str)).m = paramCommandCallbackerInfo;
      paramCommandCallbackerInfo = com.tencent.mobileqq.msf.service.g.a(paramToServiceMsg);
      paramCommandCallbackerInfo.setMsgSuccess();
      this.b.addRespToQuque(paramToServiceMsg, paramCommandCallbackerInfo);
      e(str);
      return;
    }
    finally {}
  }
  
  public void a(PushRegisterInfo paramPushRegisterInfo, ToServiceMsg paramToServiceMsg)
  {
    String str;
    try
    {
      str = com.tencent.mobileqq.msf.service.g.b(paramToServiceMsg);
      if (!a(str, BaseApplication.getContext().getPackageName())) {
        break label310;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + str + " recv unRegisterPush ");
      }
      if (!this.h.containsKey(str)) {
        this.h.putIfAbsent(str, new a(str));
      }
      ((a)this.h.get(str)).k = paramPushRegisterInfo;
      ((a)this.h.get(str)).a = paramToServiceMsg.getAppId();
      ((a)this.h.get(str)).c = 0L;
      this.i.a((a)this.h.get(str), paramToServiceMsg, true, m.b);
      paramToServiceMsg = ((a)this.h.get(str)).k.pushIds;
      paramPushRegisterInfo = paramPushRegisterInfo.pushIds;
      ArrayList localArrayList = new ArrayList();
      paramToServiceMsg = paramToServiceMsg.iterator();
      while (paramToServiceMsg.hasNext())
      {
        long l1 = ((Long)paramToServiceMsg.next()).longValue();
        if (!paramPushRegisterInfo.contains(Long.valueOf(l1))) {
          localArrayList.add(Long.valueOf(l1));
        }
      }
      ((a)this.h.get(str)).k.pushIds = localArrayList;
    }
    finally {}
    if (((a)this.h.get(str)).c == 0L) {
      ((a)this.h.get(str)).k = null;
    }
    e(str);
    for (;;)
    {
      return;
      label310:
      if (QLog.isColorLevel()) {
        QLog.e("MSF.C.PushManager", 2, "recv other processName:" + str + " recv unRegisterPush ");
      }
    }
  }
  
  public void a(com.tencent.mobileqq.msf.sdk.m paramm, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + com.tencent.mobileqq.msf.service.g.b(paramToServiceMsg) + " recv ProxyRegisterInfo " + paramm);
      }
      if (!this.h.containsKey(paramm.b)) {
        this.h.putIfAbsent(paramm.b, new a(paramm.b));
      }
      Object localObject = (a)this.h.get(paramm.b);
      ((a)localObject).a = paramm.a;
      ((a)localObject).m = paramm.e;
      ((a)localObject).l = paramm.d;
      localObject = com.tencent.mobileqq.msf.core.n.a(paramToServiceMsg);
      ((FromServiceMsg)localObject).setMsgSuccess();
      this.b.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject);
      e(paramm.b);
      return;
    }
    finally {}
  }
  
  public void a(offlinepush.PbPushOffMsg paramPbPushOffMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onRecvDevlockQuickloginOfflinePush start...");
    }
    try
    {
      if (paramPbPushOffMsg.msg_str.has())
      {
        paramPbPushOffMsg = new String(paramPbPushOffMsg.msg_str.get().toByteArray(), "utf-8");
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "onRecvDevlockQuickloginOfflinePush  maintip=" + paramPbPushOffMsg);
        }
        localBaseApplication = BaseApplication.getContext();
        Bitmap localBitmap = BitmapFactory.decodeResource(localBaseApplication.getResources(), BaseApplication.devlockQuickloginIcon);
        Object localObject = localBitmap;
        if (localBitmap != null) {
          localObject = a(localBitmap, 50, 50);
        }
        paramPbPushOffMsg = new NotificationCompat.Builder(localBaseApplication).setContentTitle("一键验证").setContentText(paramPbPushOffMsg).setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker("一键验证").setWhen(System.currentTimeMillis());
        if (localObject == null) {
          break label289;
        }
        paramPbPushOffMsg.setLargeIcon((Bitmap)localObject);
        if (Build.VERSION.SDK_INT < 11) {
          paramPbPushOffMsg.setSmallIcon(BaseApplication.qqlaunchicon);
        }
        paramPbPushOffMsg.setContentIntent(PendingIntent.getBroadcast(localBaseApplication, 0, new Intent("com.tencent.mobileqq.msf.receiveofflinepush"), 0));
        paramPbPushOffMsg.setDeleteIntent(PendingIntent.getBroadcast(localBaseApplication, 0, new Intent("com.tencent.mobileqq.msf.devlockquickloginpushclear"), 0));
        paramPbPushOffMsg = paramPbPushOffMsg.build();
        localObject = (NotificationManager)localBaseApplication.getSystemService("notification");
        if (localObject != null)
        {
          ((NotificationManager)localObject).cancel(G);
          ((NotificationManager)localObject).notify(G, paramPbPushOffMsg);
          this.Y.removeMessages(20140416);
          this.Y.sendEmptyMessageDelayed(20140416, 120000L);
        }
      }
    }
    catch (Exception paramPbPushOffMsg)
    {
      for (;;)
      {
        BaseApplication localBaseApplication;
        paramPbPushOffMsg.printStackTrace();
        paramPbPushOffMsg = null;
        continue;
        label289:
        paramPbPushOffMsg.setLargeIcon(BitmapFactory.decodeResource(localBaseApplication.getResources(), BaseApplication.qqlaunchicon));
      }
    }
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onConnClosed " + parama);
    }
    int i2 = 0;
    Object localObject = "0";
    boolean bool2 = true;
    long l2 = 0L;
    boolean bool1;
    long l1;
    try
    {
      l3 = SystemClock.elapsedRealtime();
      i1 = i2;
      parama = (com.tencent.qphone.base.a)localObject;
      bool1 = bool2;
      l1 = l2;
      if (this.B > 0L)
      {
        i1 = i2;
        parama = (com.tencent.qphone.base.a)localObject;
        bool1 = bool2;
        l1 = l2;
        if (this.ay > 0L)
        {
          if (this.B <= this.ay) {
            break label373;
          }
          bool1 = true;
          l1 = l3 - this.B;
        }
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        long l3;
        QLog.d("MSF.C.PushManager", 1, "onCloseConn's report error! ", parama);
        continue;
        parama = "2";
        int i1 = 1;
      }
    }
    i2 = i1;
    localObject = parama;
    bool2 = bool1;
    l2 = l1;
    if (this.C > 0L)
    {
      i2 = i1;
      localObject = parama;
      bool2 = bool1;
      l2 = l1;
      if (this.ay > 0L)
      {
        if (this.C <= this.ay) {
          break label383;
        }
        bool1 = true;
        l1 = l3 - this.C;
        break label412;
      }
    }
    for (;;)
    {
      if (i2 != 0)
      {
        QLog.d("MSF.C.PushManager", 1, "t1:" + this.B + ",t2:" + this.C + ",t3:" + this.ay + ",t4:" + l3);
        parama = MsfService.getCore().getAccountCenter().i();
        this.b.getStatReporter().a((String)localObject, parama, bool2, l2, this.B, this.C, this.D, this.ay, l3);
      }
      s = false;
      this.i.f = false;
      this.A = 0L;
      this.ax = 0L;
      this.ay = 0L;
      this.B = 0L;
      this.C = 0L;
      this.D = 0L;
      k = 0L;
      parama = new h(this);
      parama.setName("onConnClosedPushThread");
      parama.start();
      return;
      label373:
      bool1 = false;
      l1 = l2;
      break label403;
      label383:
      bool1 = false;
      label403:
      label412:
      localObject = "4";
      i2 = 1;
      bool2 = bool1;
      l2 = l1;
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    Iterator localIterator = this.h.keySet().iterator();
    int i1 = 0;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localObject = (a)this.h.get(localObject);
        if (localObject != null) {
          if (paramFromServiceMsg.getServiceCmd().equals("CliNotifySvc.SvcReqPush"))
          {
            localObject = new UniPacket(true);
            ((UniPacket)localObject).setEncodeName("UTF-8");
            try
            {
              ((UniPacket)localObject).decode(paramFromServiceMsg.getWupBuffer());
            }
            catch (Throwable paramFromServiceMsg)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.PushManager", 2, "decode PushMsg error " + paramFromServiceMsg, paramFromServiceMsg);
              }
            }
          }
        }
      }
    }
    while ((i1 != 0) || (!QLog.isColorLevel())) {
      for (;;)
      {
        Object localObject;
        return;
        if (paramFromServiceMsg.getServiceCmd().equals("StatSvc.QueryHB"))
        {
          if (com.tencent.mobileqq.msf.core.a.a.t)
          {
            ((a)localObject).i = this.b.nowSocketConnAdd;
            ((a)localObject).f = System.currentTimeMillis();
            a((a)localObject, m.f);
            i1 = 1;
          }
          else if (QLog.isColorLevel())
          {
            QLog.e("MSF.C.PushManager", 2, "recv push StatSvc.QueryHB, but do not support useAnyPacketAsPushHB ");
          }
        }
        else if (paramFromServiceMsg.isSuccess())
        {
          if (a((a)localObject, paramFromServiceMsg)) {
            i1 = 1;
          }
        }
        else
        {
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
            e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 3);
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager", 2, "recv error onRecvPushMsg FromServiceMsg  " + paramFromServiceMsg);
          }
        }
      }
    }
    QLog.w("MSF.C.PushManager", 2, "found not handle push msg " + paramFromServiceMsg);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    this.i.a(paramFromServiceMsg, paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, m paramm)
  {
    if (this.av.hasMessages(1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "remove message handler mLoadPushInfoHandler");
      }
      this.av.removeMessages(1);
    }
    String str = com.tencent.mobileqq.msf.service.g.b(paramToServiceMsg);
    if (a(str, BaseApplication.getContext().getPackageName()))
    {
      if (!this.h.containsKey(str)) {
        this.h.putIfAbsent(str, new a(str));
      }
      localPushRegisterInfo = com.tencent.mobileqq.msf.sdk.n.b(paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + str + " recv regPush ");
      }
      locala = (a)this.h.get(str);
      if ((locala != null) && (locala.k != null) && (locala.c != 0L) && (locala.k.uin.equals(localPushRegisterInfo.uin)) && (locala.k.iStatus == localPushRegisterInfo.iStatus) && (locala.k.bKikPC == localPushRegisterInfo.bKikPC) && (locala.k.bKikWeak == localPushRegisterInfo.bKikWeak) && (locala.k.timeStamp == localPushRegisterInfo.timeStamp) && (locala.k.iLargeSeq == localPushRegisterInfo.iLargeSeq))
      {
        if (QLog.isColorLevel()) {
          QLog.e("MSF.C.PushManager", 2, "handlerPush also register Push " + MD5.toMD5(localPushRegisterInfo.uin) + "iStatus:" + localPushRegisterInfo.iStatus);
        }
        paramm = com.tencent.mobileqq.msf.service.g.a(paramToServiceMsg);
        paramm.setMsgSuccess();
        this.b.addRespToQuque(paramToServiceMsg, paramm);
        if ((localPushRegisterInfo.iStatus != 95) && (localPushRegisterInfo.iStatus != 21))
        {
          this.b.stopPCActivePolling("regPush");
          MsfService.core.pushManager.m();
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        PushRegisterInfo localPushRegisterInfo;
        a locala;
        return;
        if (QLog.isColorLevel()) {
          QLog.e("MSF.C.PushManager", 2, "handlerPush not found the same register Push " + MD5.toMD5(localPushRegisterInfo.uin) + " iStatus:" + localPushRegisterInfo.iStatus);
        }
        locala.k = localPushRegisterInfo;
        locala.a = paramToServiceMsg.getAppId();
        Iterator localIterator = localPushRegisterInfo.pushIds.iterator();
        while (localIterator.hasNext()) {
          locala.c = (((Long)localIterator.next()).longValue() | locala.c);
        }
        e(str);
        this.i.a(locala, paramToServiceMsg, false, paramm);
      }
    }
    QLog.e("MSF.C.PushManager", 2, "recv other processName:" + str + " recv regPush ");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.i.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(String paramString, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + com.tencent.mobileqq.msf.service.g.b(paramToServiceMsg) + " recv proxyUnRegister " + paramString);
      }
      this.h.remove(paramString);
      FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.core.n.a(paramToServiceMsg);
      localFromServiceMsg.setMsgSuccess();
      this.b.addRespToQuque(paramToServiceMsg, localFromServiceMsg);
      MsfStore.getNativeConfigStore().removeConfig("app_push_info_" + paramString);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   6: ifnull +32 -> 38
    //   9: aload_0
    //   10: getfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   13: invokevirtual 1399	android/media/MediaPlayer:isPlaying	()Z
    //   16: istore 4
    //   18: iload 4
    //   20: ifeq +6 -> 26
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   30: invokevirtual 1402	android/media/MediaPlayer:release	()V
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   38: aload_0
    //   39: getfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   42: ifnonnull +14 -> 56
    //   45: aload_0
    //   46: new 505	android/media/MediaPlayer
    //   49: dup
    //   50: invokespecial 506	android/media/MediaPlayer:<init>	()V
    //   53: putfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   56: aload_0
    //   57: getfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   60: invokevirtual 1793	android/media/MediaPlayer:reset	()V
    //   63: aload_0
    //   64: getfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   67: new 1795	java/io/FileInputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 1796	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   75: invokevirtual 1799	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   78: invokevirtual 1802	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   86: invokespecial 509	com/tencent/mobileqq/msf/core/push/f:a	(Landroid/media/MediaPlayer;)V
    //   89: aload_0
    //   90: getfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   93: invokevirtual 532	android/media/MediaPlayer:prepare	()V
    //   96: aload_0
    //   97: getfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   100: new 1804	com/tencent/mobileqq/msf/core/push/i
    //   103: dup
    //   104: aload_0
    //   105: invokespecial 1805	com/tencent/mobileqq/msf/core/push/i:<init>	(Lcom/tencent/mobileqq/msf/core/push/f;)V
    //   108: invokevirtual 1411	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   111: aload_0
    //   112: getfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   115: invokevirtual 1412	android/media/MediaPlayer:start	()V
    //   118: aload_0
    //   119: getfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   122: iload_2
    //   123: invokevirtual 1415	android/media/MediaPlayer:setLooping	(Z)V
    //   126: goto -103 -> 23
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 720	java/lang/Exception:printStackTrace	()V
    //   134: goto -111 -> 23
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    //   142: astore_1
    //   143: aload_0
    //   144: aconst_null
    //   145: putfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   148: aload_1
    //   149: athrow
    //   150: astore_3
    //   151: aload_0
    //   152: aconst_null
    //   153: putfield 1396	com/tencent/mobileqq/msf/core/push/f:W	Landroid/media/MediaPlayer;
    //   156: goto -118 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	f
    //   0	159	1	paramString	String
    //   0	159	2	paramBoolean	boolean
    //   150	1	3	localException	Exception
    //   16	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	129	java/lang/Exception
    //   33	38	129	java/lang/Exception
    //   38	56	129	java/lang/Exception
    //   56	126	129	java/lang/Exception
    //   143	150	129	java/lang/Exception
    //   151	156	129	java/lang/Exception
    //   2	18	137	finally
    //   33	38	137	finally
    //   38	56	137	finally
    //   56	126	137	finally
    //   130	134	137	finally
    //   143	150	137	finally
    //   151	156	137	finally
    //   26	33	142	finally
    //   26	33	150	java/lang/Exception
  }
  
  public void a(boolean paramBoolean)
  {
    String[] arrayOfString = MsfStore.getNativeConfigStore().getConfigList("app_push_info_");
    Object localObject1;
    int i4;
    int i2;
    label137:
    Object localObject2;
    if ((true == paramBoolean) && (arrayOfString == null) && (ar < aq.length))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "loop to loadAppPushInfo with time " + aq[ar] + " seconds");
      }
      localObject1 = this.av.obtainMessage();
      ((Message)localObject1).what = 1;
      ((Message)localObject1).obj = Boolean.valueOf(paramBoolean);
      this.av.sendMessageDelayed((Message)localObject1, aq[ar] * 1000);
      ar += 1;
      i4 = com.tencent.mobileqq.msf.core.c.e(BaseApplication.getContext());
      int i5 = arrayOfString.length;
      i2 = 0;
      if (i2 >= i5) {
        return;
      }
      localObject2 = HexUtil.hexStr2Bytes(arrayOfString[i2]);
      localObject1 = new a();
      ((a)localObject1).readFrom(new JceInputStream((byte[])localObject2));
      localObject2 = BaseApplication.getContext().getPackageName();
      if (a(((a)localObject1).b, (String)localObject2)) {
        break label328;
      }
      if (QLog.isColorLevel()) {
        QLog.e("MSF.C.PushManager", 2, "filter other push process. processName:" + ((a)localObject1).b);
      }
      MsfStore.getNativeConfigStore().removeConfig("app_push_info_" + ((a)localObject1).b);
    }
    label282:
    label322:
    label328:
    label416:
    label854:
    label860:
    for (;;)
    {
      i2 += 1;
      break label137;
      localObject1 = this.b.getStatReporter();
      boolean bool;
      long l1;
      if (arrayOfString == null)
      {
        bool = false;
        l1 = ar;
        if (true != paramBoolean) {
          break label322;
        }
      }
      for (int i1 = 0;; i1 = 1)
      {
        ((com.tencent.mobileqq.msf.core.c.m)localObject1).a("dim.Msf.LoadPushTimes", bool, l1, i1, null, false, false);
        break;
        bool = true;
        break label282;
      }
      this.h.put(((a)localObject1).b, localObject1);
      if ((((a)localObject1).k != null) && (((a)localObject1).c > 0L))
      {
        int i3 = 0;
        if (i4 == -1)
        {
          i3 = 1;
          i1 = i3;
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.PushManager", 2, "nVersionCode:" + i4 + " sendMsgPushRegister now");
            i1 = i3;
          }
          if (i1 == 0) {
            break label854;
          }
          if ((localObject1 != null) && (((a)localObject1).k != null)) {
            this.b.getAccountCenter().b(((a)localObject1).k.uin, "autoRegPush");
          }
          this.i.a((a)localObject1, null, false, m.a);
        }
        for (;;)
        {
          if (q) {
            break label860;
          }
          q = true;
          r = ((a)localObject1).k.uin;
          break;
          localObject2 = String.valueOf(i4);
          if (((a)localObject1).n != null)
          {
            if (((a)localObject1).n.equals(localObject2))
            {
              i3 = 1;
              i1 = i3;
              if (!QLog.isColorLevel()) {
                break label416;
              }
              QLog.d("MSF.C.PushManager", 2, "info.installVersion :" + ((a)localObject1).n + " strVersionCode:" + (String)localObject2 + " sendMsgPushRegister now");
              i1 = i3;
              break label416;
            }
            if (paramBoolean)
            {
              i3 = 1;
              i1 = i3;
              if (!QLog.isColorLevel()) {
                break label416;
              }
              QLog.d("MSF.C.PushManager", 2, "info.installVersion :" + ((a)localObject1).n + " bBoot:" + paramBoolean + " strVersionCode:" + (String)localObject2 + " sendMsgPushRegister now");
              i1 = i3;
              break label416;
            }
            i1 = i3;
            if (!QLog.isColorLevel()) {
              break label416;
            }
            QLog.d("MSF.C.PushManager", 2, "info.installVersion :" + ((a)localObject1).n + " strVersionCode:" + (String)localObject2 + " no need sendMsgPushRegister");
            i1 = i3;
            break label416;
          }
          if (paramBoolean)
          {
            i3 = 1;
            i1 = i3;
            if (!QLog.isColorLevel()) {
              break label416;
            }
            QLog.d("MSF.C.PushManager", 2, "info.installVersion :" + ((a)localObject1).n + " bBoot:" + paramBoolean + " sendMsgPushRegister now");
            i1 = i3;
            break label416;
          }
          i1 = i3;
          if (!QLog.isColorLevel()) {
            break label416;
          }
          QLog.d("MSF.C.PushManager", 2, "info.installVersion :" + ((a)localObject1).n + " bBoot:" + paramBoolean + " no need sendMsgPushRegister");
          i1 = i3;
          break label416;
          ((a)localObject1).c = 0L;
        }
      }
    }
  }
  
  public boolean a(a parama, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parama.m != null)
    {
      bool1 = bool2;
      if (parama.m.uin.equals(paramFromServiceMsg.getUin()))
      {
        Iterator localIterator = parama.m.cmds.iterator();
        bool1 = false;
        if (localIterator.hasNext())
        {
          if (!((String)localIterator.next()).equals(paramFromServiceMsg.getServiceCmd())) {
            break label135;
          }
          if (!"ConfigPushSvc.PushDomain".equals(paramFromServiceMsg.getMsfCommand())) {
            paramFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
          }
          MsfSdkUtils.addFromMsgProcessName(parama.b, paramFromServiceMsg);
          paramFromServiceMsg.setMsfCommand(MsfCommand.onRecvPushMsg);
          this.b.addRespToQuque(null, paramFromServiceMsg);
          bool1 = true;
        }
      }
    }
    label135:
    for (;;)
    {
      break;
      return bool1;
    }
  }
  
  public int b(String paramString, Context paramContext)
  {
    if (paramString == null) {
      return 1;
    }
    paramString = paramContext.getSharedPreferences(paramString, 4).getString(this.an, String.valueOf(1));
    try
    {
      int i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 1;
  }
  
  public void b(long paramLong)
  {
    if ((paramLong > 30000L) && (paramLong < 3600000L)) {
      this.A = paramLong;
    }
  }
  
  public void b(CommandCallbackerInfo paramCommandCallbackerInfo, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      String str = com.tencent.mobileqq.msf.service.g.b(paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + str + " recv unRegisterCmdCall ");
      }
      if (!this.h.containsKey(str)) {
        this.h.putIfAbsent(str, new a(str));
      }
      ((a)this.h.get(str)).m = paramCommandCallbackerInfo;
      paramCommandCallbackerInfo = com.tencent.mobileqq.msf.service.g.a(paramToServiceMsg);
      paramCommandCallbackerInfo.setMsgSuccess();
      this.b.addRespToQuque(paramToServiceMsg, paramCommandCallbackerInfo);
      e(str);
      return;
    }
    finally {}
  }
  
  public void b(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.PushManager", 4, "onRecvPushReaded getted");
    }
    long l1 = 0L;
    offlinepush.PbPushOffReadedNotify localPbPushOffReadedNotify;
    Object localObject1;
    Object localObject2;
    int i1;
    long l2;
    Iterator localIterator;
    a locala;
    try
    {
      localPbPushOffReadedNotify = new offlinepush.PbPushOffReadedNotify();
      localObject1 = paramFromServiceMsg.getWupBuffer();
      localObject2 = new byte[localObject1.length - 4];
      System.arraycopy(localObject1, 4, localObject2, 0, localObject1.length - 4);
      localPbPushOffReadedNotify.mergeFrom((byte[])localObject2);
      i1 = localPbPushOffReadedNotify.cNotifyType.get();
      if ((i1 & 0x1) == 0) {
        break label323;
      }
      localObject1 = new ArrayList();
      localObject2 = localPbPushOffReadedNotify.vC2CReadedNotify.get().iterator();
      l1 = 0L;
      while (((Iterator)localObject2).hasNext())
      {
        l2 = ((offlinepush.C2CMsgReadedNotify)((Iterator)localObject2).next()).lPeerUin.get();
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.PushManager", 4, "onRecvPushReaded C2C uin:" + l2);
        }
        localIterator = this.I.iterator();
        while (localIterator.hasNext())
        {
          locala = (a)localIterator.next();
          l1 = locala.a.to_uin.get();
          if (locala.a.from_uin.get() == l2) {
            ((List)localObject1).add(locala);
          }
        }
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "onRecvPushReaded decode error:" + paramFromServiceMsg, paramFromServiceMsg);
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.PushManager", 4, "onRecvPushReaded remove" + ((List)localObject1).size() + " message");
    }
    this.I.removeAll((Collection)localObject1);
    label323:
    if ((i1 & 0x4) != 0)
    {
      localObject1 = new ArrayList();
      localObject2 = localPbPushOffReadedNotify.vDisReadedNotify.get().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        l2 = ((offlinepush.DisMsgReadedNotify)((Iterator)localObject2).next()).lDisUin.get();
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.PushManager", 4, "onRecvPushReaded Discuss uin:" + l2);
        }
        localIterator = this.I.iterator();
        while (localIterator.hasNext())
        {
          locala = (a)localIterator.next();
          l1 = locala.a.to_uin.get();
          if (locala.a.discuss_info.discuss_uin.get() == l2) {
            ((List)localObject1).add(locala);
          }
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.PushManager", 4, "onRecvPushReaded remove" + ((List)localObject1).size() + " message");
      }
      this.I.removeAll((Collection)localObject1);
    }
    for (;;)
    {
      i1 = BaseApplication.getContext().getSharedPreferences("unreadcount", 4).getInt("unread", -1);
      int i2 = this.I.size();
      BadgeUtilImpl.setBadge(BaseApplication.getContext(), i1 + i2);
      c(true);
      a(l1, paramFromServiceMsg.getRequestSsoSeq(), localPbPushOffReadedNotify.svr_ip.get());
      return;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.i.b(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void b(String paramString)
  {
    try
    {
      String str = BaseApplication.getContext().getPackageName();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + str + " recv KickedMsg ");
      }
      a locala = (a)this.h.get(str);
      if ((locala != null) && (locala.k != null) && (locala.k.uin.equals(paramString)))
      {
        locala.c = 0L;
        locala.k = null;
        e(str);
      }
      if (this.b.getAccountCenter().i().equals(paramString))
      {
        this.b.getAccountCenter().b("0", "onKicked");
        this.b.stopPCActivePolling("onKicked");
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    Iterator localIterator = this.h.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (a)this.h.get(localObject);
      if ((localObject != null) && (((a)localObject).k != null) && (((a)localObject).c != 0L)) {
        return true;
      }
    }
    return false;
  }
  
  public int c(String paramString, Context paramContext)
  {
    if (paramString == null) {
      return 1;
    }
    paramString = paramContext.getSharedPreferences(paramString, 4).getString(this.ao, String.valueOf(1));
    try
    {
      int i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 1;
  }
  
  public void c()
  {
    synchronized (this.w)
    {
      this.w.notify();
      return;
    }
  }
  
  public void c(long paramLong)
  {
    if ((this.b != null) && (this.b.sender != null) && (this.b.sender.a.b())) {
      this.ay = paramLong;
    }
    while ((this.b == null) || (this.b.sender == null)) {
      return;
    }
    QLog.i("MSF.C.PushManager", 1, "not need to update lastRecvTimeForSG, isConned:" + this.b.sender.a.b());
  }
  
  public void c(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.PushManager", 4, "onRecvPbPushOffMsg getted");
    }
    if (MsfService.getCore().getUinPushStatus(paramFromServiceMsg.getUin()) != 95) {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.PushManager", 4, "onRecvPbPushOffMsg client status:" + MsfService.getCore().getUinPushStatus(paramFromServiceMsg.getUin()) + " drop now");
      }
    }
    int i1;
    do
    {
      do
      {
        do
        {
          return;
          if (!com.tencent.mobileqq.msf.service.c.a()) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.d("MSF.C.PushManager", 4, "onRecvPbPushOffMsg mobileqq is running drop now");
        return;
        localObject = this.I.iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          i1 = ((a)((Iterator)localObject).next()).b;
        } while (paramFromServiceMsg.getRequestSsoSeq() != i1);
      } while (!QLog.isColorLevel());
      QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get duplicate msg drop now.");
      return;
      localObject = this.J.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        i1 = ((a)((Iterator)localObject).next()).b;
      } while (paramFromServiceMsg.getRequestSsoSeq() != i1);
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get duplicate av msg drop now ssoseq:" + i1);
    return;
    Object localObject = new a();
    for (;;)
    {
      offlinepush.PbPushOffMsg localPbPushOffMsg;
      try
      {
        localPbPushOffMsg = new offlinepush.PbPushOffMsg();
        byte[] arrayOfByte1 = paramFromServiceMsg.getWupBuffer();
        byte[] arrayOfByte2 = new byte[arrayOfByte1.length - 4];
        System.arraycopy(arrayOfByte1, 4, arrayOfByte2, 0, arrayOfByte1.length - 4);
        localPbPushOffMsg.mergeFrom(arrayOfByte2);
        ((a)localObject).a = localPbPushOffMsg;
        ((a)localObject).b = paramFromServiceMsg.getRequestSsoSeq();
        if (!c(localPbPushOffMsg)) {
          break label429;
        }
        this.J.add(localObject);
        w();
        a(localPbPushOffMsg.to_uin.get(), paramFromServiceMsg.getRequestSsoSeq(), localPbPushOffMsg.svr_ip.get());
        i1 = BaseApplication.getContext().getSharedPreferences("unreadcount", 4).getInt("unread", -5);
        int i2 = this.I.size();
        int i3 = this.J.size();
        BadgeUtilImpl.setBadge(BaseApplication.getContext(), i1 + (i2 + i3));
        return;
      }
      catch (Exception paramFromServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg decode error:" + paramFromServiceMsg, paramFromServiceMsg);
      return;
      label429:
      if (localPbPushOffMsg.msg_type.get() == 528)
      {
        a(localPbPushOffMsg);
      }
      else
      {
        this.I.add(localObject);
        c(false);
      }
    }
  }
  
  public void c(String paramString)
  {
    QLog.d("PCActivePush", 1, "onPCActive");
    ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(E);
    this.I.clear();
    this.aB.set(true);
    BaseApplication.getContext().registerReceiver(this.aF, new IntentFilter("com.tencent.mobileqq.broadcast.pcactiveQQ"));
    this.aD = 0;
    this.aC = paramString;
    a(paramString, 0);
  }
  
  public void d()
  {
    s = false;
    f();
  }
  
  public void d(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onRecvSsoHelloPush from:" + paramFromServiceMsg);
    }
    for (;;)
    {
      try
      {
        localToServiceMsg = new ToServiceMsg("", paramFromServiceMsg.getUin(), "SSO.HelloPush");
        localToServiceMsg.putWupBuffer(paramFromServiceMsg.getWupBuffer());
        localToServiceMsg.setAppId(this.b.getMsfAppid());
        localToServiceMsg.setNeedCallback(false);
        localToServiceMsg.setTimeout(30000L);
        localToServiceMsg.setRequestSsoSeq(paramFromServiceMsg.getRequestSsoSeq());
        this.ap = localToServiceMsg;
      }
      catch (Exception paramFromServiceMsg)
      {
        ToServiceMsg localToServiceMsg;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("MSF.C.PushManager", 2, "onRecvSsoHelloPush error " + paramFromServiceMsg, paramFromServiceMsg);
      }
      try
      {
        this.b.sendSsoMsg(localToServiceMsg);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("MSF.C.PushManager", 2, "send sso hello push resp error " + paramFromServiceMsg, paramFromServiceMsg);
          return;
        }
      }
    }
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MSF.C.PushManager", 2, "MSF onNotificationQQWiFi=" + paramString);
    }
    BaseApplication.getContext().startActivity(new Intent(paramString));
  }
  
  public long e()
  {
    if (this.A == 0L) {
      return 300000L;
    }
    return this.A;
  }
  
  void f()
  {
    Iterator localIterator = this.h.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (a)this.h.get(localObject);
      if ((localObject != null) && (((a)localObject).k != null) && (((a)localObject).c != 0L))
      {
        try
        {
          long l1 = System.currentTimeMillis();
          if ((((a)localObject).f == 0L) || (l1 - ((a)localObject).f <= 25200000L)) {
            break label122;
          }
          a((a)localObject, m.d);
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel())
        {
          QLog.w("MSF.C.PushManager", 2, localException.toString(), localException);
          continue;
          label122:
          if ((s) && (localException.i != null) && (this.b.nowSocketConnAdd != null) && (localException.i.equals(this.b.nowSocketConnAdd)))
          {
            this.i.a(localException, false);
          }
          else
          {
            ToServiceMsg localToServiceMsg;
            if (this.b.nowSocketConnAdd == null)
            {
              localToServiceMsg = MsfMsgUtil.getConnOpenMsg("");
              MsfSdkUtils.addToMsgProcessName("", localToServiceMsg);
              this.b.sendSsoMsg(localToServiceMsg);
              a(e());
            }
            else
            {
              a(localToServiceMsg, m.e);
            }
          }
        }
      }
    }
  }
  
  public long g()
  {
    return this.ax;
  }
  
  public long h()
  {
    return this.ay;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onNotificationClearAll");
    }
    this.I.clear();
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onNotificationClearAllAV");
    }
    this.J.clear();
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "clearOfflinePushNotification");
    }
    ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(E);
    this.I.clear();
    this.K = false;
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "clearOfflinePushNotificationAV");
    }
    ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(F);
    this.J.clear();
    this.L = false;
  }
  
  public void m()
  {
    if (this.aB.get()) {
      QLog.d("PCActivePush", 1, "stop tryActiveQQ by regPush");
    }
    try
    {
      BaseApplication.getContext().unregisterReceiver(this.aF);
      HashMap localHashMap = new HashMap();
      localHashMap.put("account", this.aC);
      localHashMap.put("retryIndex", String.valueOf(this.aD));
      localHashMap.put("reason", "regpush");
      this.b.getStatReporter().a("dim.Msf.PCActiveQQResult", true, 0L, 0L, localHashMap, false, false);
      if ((this.aE == null) || (this.l == null)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.l.cancel(this.aE);
        this.aB.set(false);
        return;
        localException1 = localException1;
        localException1.printStackTrace();
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
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onNotificationBroadcast");
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    ((NotificationManager)localBaseApplication.getSystemService("notification")).cancel(E);
    this.I.clear();
    try
    {
      if (b())
      {
        localIntent = new Intent("com.tencent.mobileqq.action.MAINACTIVITY");
        localIntent.addFlags(268435456);
        localBaseApplication.startActivity(localIntent);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "uin kicked out");
      }
      Intent localIntent = new Intent("com.tencent.mobileqq.action.MAINACTIVITY");
      localIntent.addFlags(268435456);
      localBaseApplication.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "Start QQ failed" + localException);
      }
    }
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onAVNotificationBroadcast");
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    ((NotificationManager)localBaseApplication.getSystemService("notification")).cancel(F);
    this.J.clear();
    try
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.action.MAINACTIVITY");
      localIntent.addFlags(268435456);
      localBaseApplication.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MSF.C.PushManager", 2, "Start QQ failed" + localException);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "alarm receive " + paramIntent);
    }
    for (;;)
    {
      boolean bool;
      synchronized (this.w)
      {
        this.w.notify();
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "QQWiFi : starScan from alarmReceiver!");
        }
        o.a().c();
        if (this.aw) {
          o.a().e();
        }
        if (QLog.isColorLevel())
        {
          this.b.netFlowStore.a(paramContext, paramIntent);
          if (this.aw) {
            break label171;
          }
          bool = true;
          this.aw = bool;
          if (this.b.getStandyModeManager() != null) {
            this.b.getStandyModeManager().a();
          }
          com.tencent.mobileqq.msf.core.f.b();
          s();
          return;
        }
      }
      if (this.aw)
      {
        this.b.netFlowStore.a(paramContext, paramIntent);
        continue;
        label171:
        bool = false;
      }
    }
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "clearDevlockQuickloginNotification");
    }
    NotificationManager localNotificationManager = (NotificationManager)BaseApplication.getContext().getSystemService("notification");
    if (localNotificationManager != null) {
      localNotificationManager.cancel(G);
    }
  }
  
  public b q()
  {
    return this.au;
  }
  
  public int r()
  {
    return 3;
  }
  
  class a
  {
    public offlinepush.PbPushOffMsg a;
    public int b;
    
    a() {}
  }
  
  class b
    extends Thread
  {
    b() {}
    
    public void run()
    {
      synchronized (f.this.w)
      {
        try
        {
          f.this.w.wait();
          f.this.f();
          i.e();
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("MSF.C.PushManager", 2, localInterruptedException.toString(), localInterruptedException);
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\push\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */