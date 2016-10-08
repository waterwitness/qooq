package com.tencent.mobileqq.msf.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
{
  static List a;
  static List b;
  static volatile boolean c = false;
  static a d;
  static Handler e;
  static NetworkInfo f;
  public static boolean g = false;
  public static int h = 0;
  public static String i;
  public static String j;
  public static String k;
  static BroadcastReceiver l = new b();
  private static String m = "MSF.D.AppNetInfoImpl";
  private static final String n = "http://3gimg.qq.com/ping.html";
  private static int o = 0;
  private static AtomicBoolean p = new AtomicBoolean(false);
  private static final int q = 1;
  private static final int r = 2;
  private static final int s = 3;
  private static final int t = 17;
  private static int u = 0;
  private static Uri v;
  private static final byte w = 0;
  private static final byte x = 1;
  
  static
  {
    a = new LinkedList();
    b = new LinkedList();
    c = false;
    d = new a("nethandlerthread");
    u = -1;
    h = 3;
    i = "";
    j = "";
    k = "";
    v = Uri.parse("content://telephony/carriers/preferapn");
  }
  
  private static String a(int paramInt)
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
  
  public static void a()
    throws Exception
  {
    Object localObject = (HttpURLConnection)new URL("http://3gimg.qq.com/ping.html").openConnection();
    ((HttpURLConnection)localObject).setDoOutput(true);
    ((HttpURLConnection)localObject).setDoInput(true);
    ((HttpURLConnection)localObject).setRequestMethod("GET");
    ((HttpURLConnection)localObject).setUseCaches(false);
    ((HttpURLConnection)localObject).setInstanceFollowRedirects(false);
    ((HttpURLConnection)localObject).setReadTimeout(60000);
    ((HttpURLConnection)localObject).connect();
    byte[] arrayOfByte = new byte[8];
    ((HttpURLConnection)localObject).getInputStream().read(arrayOfByte);
    ((HttpURLConnection)localObject).getInputStream().close();
    ((HttpURLConnection)localObject).disconnect();
    localObject = new String(arrayOfByte);
    if ("Poduct3G".equals(localObject))
    {
      a(true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(m, 2, "wifi ping resp content is " + (String)localObject);
    }
    g = true;
  }
  
  public static void a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    a(paramContext.getActiveNetworkInfo());
    paramContext = paramContext.getNetworkInfo(0);
    if (paramContext != null) {}
    try
    {
      i = paramContext.getExtraInfo();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.d(m, 1, "get currentAPN error " + paramContext);
    }
  }
  
  public static void a(Context paramContext, INetEventHandler paramINetEventHandler)
  {
    try
    {
      i();
      paramContext = e.obtainMessage();
      paramContext.what = 2;
      paramContext.obj = paramINetEventHandler;
      e.sendMessage(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.d(m, 1, "register net change thread create failed " + paramContext.toString());
      c = false;
    }
  }
  
  public static void a(Context paramContext, INetInfoHandler paramINetInfoHandler)
  {
    try
    {
      i();
      paramContext = e.obtainMessage();
      paramContext.what = 1;
      paramContext.obj = paramINetInfoHandler;
      e.sendMessage(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.d(m, 1, "register connection change thread create failed " + paramContext.toString());
      c = false;
    }
  }
  
  public static void a(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo != null) {
      str = paramNetworkInfo.getTypeName();
    }
    while (!QLog.isColorLevel()) {
      try
      {
        String str;
        j = paramNetworkInfo.getSubtypeName();
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
                QLog.d(m, 1, "get subtypeName error " + localException);
              }
              QLog.d(m, 1, "currentAPN:" + i + ". received networkInfo: " + paramNetworkInfo.getDetailedState() + " :" + paramNetworkInfo);
              if (paramNetworkInfo.getDetailedState() != NetworkInfo.DetailedState.CONNECTED) {
                break;
              }
              if (1 == paramNetworkInfo.getType())
              {
                q();
                return;
              }
            } while (!b(paramNetworkInfo));
            p();
            return;
          } while ((paramNetworkInfo.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED) && (paramNetworkInfo.getDetailedState() != NetworkInfo.DetailedState.FAILED) && (paramNetworkInfo.getDetailedState() != NetworkInfo.DetailedState.IDLE) && (paramNetworkInfo.getDetailedState() != NetworkInfo.DetailedState.SUSPENDED));
          if (1 == paramNetworkInfo.getType())
          {
            s();
            return;
          }
        } while (!b(paramNetworkInfo));
        r();
        return;
      }
    }
    QLog.d(m, 2, "currentAPN:" + i + ". NetworkInfo: " + paramNetworkInfo);
  }
  
  private static void a(boolean paramBoolean)
  {
    p.set(paramBoolean);
  }
  
  public static boolean a(INetEventHandler paramINetEventHandler)
  {
    try
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext())
      {
        INetEventHandler localINetEventHandler = (INetEventHandler)localIterator.next();
        if (localINetEventHandler == paramINetEventHandler)
        {
          boolean bool = b.remove(localINetEventHandler);
          return bool;
        }
      }
    }
    catch (Exception paramINetEventHandler)
    {
      QLog.d(m, 1, "unregisterNetEventHandler failed " + paramINetEventHandler.toString());
    }
    return false;
  }
  
  public static boolean a(INetInfoHandler paramINetInfoHandler)
  {
    try
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        INetInfoHandler localINetInfoHandler = (INetInfoHandler)localIterator.next();
        if (localINetInfoHandler == paramINetInfoHandler)
        {
          boolean bool = a.remove(localINetInfoHandler);
          return bool;
        }
      }
    }
    catch (Exception paramINetInfoHandler)
    {
      QLog.d(m, 1, "unregisterNetInfoHandler failed " + paramINetInfoHandler.toString());
    }
    return false;
  }
  
  public static boolean a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return false;
    }
    if (e == null) {}
    synchronized (d)
    {
      if (e == null)
      {
        d.start();
        e = new Handler(d.getLooper(), d);
        QLog.i(m, 1, "runOnNetHandlerThread init handler");
      }
      return e.post(paramRunnable);
    }
  }
  
  private static void b(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (o == paramInt)
        {
          if (QLog.isColorLevel()) {
            QLog.d(m, 2, "found repeat net event , now is " + b() + " now:" + paramInt + " last:" + o);
          }
          return;
        }
        if (paramInt > 0)
        {
          a(true);
          QLog.d(m, 1, "netchange " + a(o) + " to " + a(paramInt));
          u = -1;
          if (paramInt != 1) {
            break;
          }
          if ((o != 0) && (o != -2)) {
            break label171;
          }
          u = 0;
          o = paramInt;
          continue;
        }
        a(false);
      }
      finally {}
      continue;
      label171:
      if ((o == 2) || (o == 3)) {
        u = 1;
      }
    }
    for (;;)
    {
      label192:
      if ((o == 0) || (o == -2))
      {
        u = 2;
        break;
      }
      if (o != 1) {
        break;
      }
      u = 3;
      break;
      do
      {
        if (o == 1)
        {
          u = 4;
          break;
        }
        if ((o != 2) && (o != 3)) {
          break;
        }
        u = 5;
        break;
        if (paramInt == 2) {
          break label192;
        }
      } while (paramInt != 3);
    }
  }
  
  public static boolean b()
  {
    return p.get();
  }
  
  public static boolean b(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo.getType() == 0) || (50 == paramNetworkInfo.getType());
  }
  
  public static int c()
  {
    if (e())
    {
      if (g) {
        return 3;
      }
      return 2;
    }
    if (f()) {
      return 1;
    }
    return 0;
  }
  
  public static int d()
  {
    return h;
  }
  
  public static boolean e()
  {
    return (o == 2) || (o == 3);
  }
  
  public static boolean f()
  {
    return o == 1;
  }
  
  public static void g()
  {
    try
    {
      f = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      a(f);
      if (e != null) {
        e.sendEmptyMessage(3);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(m, 2, localException.toString(), localException);
    }
  }
  
  public static NetworkInfo h()
  {
    return f;
  }
  
  public static void i()
  {
    try
    {
      if (c)
      {
        if (e == null) {
          synchronized (d)
          {
            if (e == null)
            {
              d.start();
              e = new Handler(d.getLooper(), d);
              QLog.i(m, 1, "checkInitOps init handler");
            }
            return;
          }
        }
      }
      else {
        synchronized (d)
        {
          if (!c)
          {
            d.start();
            e = new Handler(d.getLooper(), d);
            c = true;
            IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            BaseApplication.getContext().registerReceiver(l, localIntentFilter);
            g();
          }
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.d(m, 1, "failed to check init ops " + localException.toString());
      c = false;
      return;
    }
  }
  
  /* Error */
  private static void n()
  {
    // Byte code:
    //   0: invokestatic 415	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: ldc -46
    //   5: invokevirtual 416	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   8: checkcast 218	android/net/ConnectivityManager
    //   11: iconst_0
    //   12: invokevirtual 229	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
    //   15: astore_0
    //   16: aload_0
    //   17: ifnull +11 -> 28
    //   20: aload_0
    //   21: invokevirtual 234	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   24: putstatic 87	com/tencent/mobileqq/msf/sdk/a:i	Ljava/lang/String;
    //   27: return
    //   28: invokestatic 415	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   31: invokevirtual 450	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   34: getstatic 101	com/tencent/mobileqq/msf/sdk/a:v	Landroid/net/Uri;
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: invokevirtual 456	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore_1
    //   45: aload_1
    //   46: ifnull +98 -> 144
    //   49: aload_1
    //   50: astore_0
    //   51: aload_1
    //   52: invokeinterface 461 1 0
    //   57: ifeq +87 -> 144
    //   60: aload_1
    //   61: astore_0
    //   62: aload_1
    //   63: aload_1
    //   64: ldc_w 463
    //   67: invokeinterface 467 2 0
    //   72: invokeinterface 470 2 0
    //   77: putstatic 87	com/tencent/mobileqq/msf/sdk/a:i	Ljava/lang/String;
    //   80: goto -35 -> 45
    //   83: astore_2
    //   84: aload_1
    //   85: astore_0
    //   86: aload_2
    //   87: invokevirtual 473	java/lang/Throwable:printStackTrace	()V
    //   90: aload_1
    //   91: ifnull -64 -> 27
    //   94: aload_1
    //   95: invokeinterface 474 1 0
    //   100: return
    //   101: astore_0
    //   102: getstatic 54	com/tencent/mobileqq/msf/sdk/a:m	Ljava/lang/String;
    //   105: iconst_1
    //   106: new 190	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   113: ldc -20
    //   115: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 204	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: return
    //   129: astore_1
    //   130: aconst_null
    //   131: astore_0
    //   132: aload_0
    //   133: ifnull +9 -> 142
    //   136: aload_0
    //   137: invokeinterface 474 1 0
    //   142: aload_1
    //   143: athrow
    //   144: aload_1
    //   145: ifnull -118 -> 27
    //   148: aload_1
    //   149: invokeinterface 474 1 0
    //   154: return
    //   155: astore_1
    //   156: goto -24 -> 132
    //   159: astore_2
    //   160: aconst_null
    //   161: astore_1
    //   162: goto -78 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	71	0	localObject1	Object
    //   101	18	0	localException	Exception
    //   131	6	0	localObject2	Object
    //   44	51	1	localCursor	android.database.Cursor
    //   129	20	1	localObject3	Object
    //   155	1	1	localObject4	Object
    //   161	1	1	localObject5	Object
    //   83	4	2	localThrowable1	Throwable
    //   159	1	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   51	60	83	java/lang/Throwable
    //   62	80	83	java/lang/Throwable
    //   20	27	101	java/lang/Exception
    //   94	100	101	java/lang/Exception
    //   136	142	101	java/lang/Exception
    //   142	144	101	java/lang/Exception
    //   148	154	101	java/lang/Exception
    //   28	45	129	finally
    //   51	60	155	finally
    //   62	80	155	finally
    //   86	90	155	finally
    //   28	45	159	java/lang/Throwable
  }
  
  private static void o()
  {
    try
    {
      WifiInfo localWifiInfo = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
      if (localWifiInfo != null)
      {
        QLog.d(m, 1, "checknetinfo get wifi ssid " + localWifiInfo.getSSID());
        k = localWifiInfo.getSSID();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d(m, 1, "failed to get wifi ssid");
    }
  }
  
  private static void p()
  {
    b(o | 0x1);
  }
  
  private static void q()
  {
    b(o | 0x2);
  }
  
  private static void r()
  {
    b(o & 0xFFFFFFFE);
  }
  
  private static void s()
  {
    b(o & 0xFFFFFFFD);
  }
  
  static class a
    extends HandlerThread
    implements Handler.Callback
  {
    public a(String paramString)
    {
      super();
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      switch (i)
      {
      }
      label285:
      boolean bool;
      do
      {
        int j;
        do
        {
          return false;
          try
          {
            paramMessage = (INetInfoHandler)paramMessage.obj;
            a.a.add(paramMessage);
            return false;
          }
          catch (Exception paramMessage)
          {
            QLog.d(a.k(), 1, "failed to handle msg " + i);
            return false;
          }
          paramMessage = (INetEventHandler)paramMessage.obj;
          a.b.add(paramMessage);
          return false;
          j = a.j();
          if (j != -1) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(a.k(), 2, "no change in connectivity");
        return false;
        if (a.f())
        {
          a.l();
          paramMessage = a.a.iterator();
        }
        Object localObject;
        for (;;)
        {
          if (!paramMessage.hasNext()) {
            break label285;
          }
          localObject = (INetInfoHandler)paramMessage.next();
          if (localObject != null)
          {
            if (j == 0)
            {
              ((INetInfoHandler)localObject).onNetNone2Mobile(a.i);
              continue;
              if (!a.e()) {
                break;
              }
              a.m();
              break;
            }
            if (j == 1) {
              ((INetInfoHandler)localObject).onNetWifi2Mobile(a.i);
            } else if (j == 2) {
              ((INetInfoHandler)localObject).onNetNone2Wifi(a.k);
            } else if (j == 3) {
              ((INetInfoHandler)localObject).onNetMobile2Wifi(a.k);
            } else if (j == 4) {
              ((INetInfoHandler)localObject).onNetMobile2None();
            } else if (j == 5) {
              ((INetInfoHandler)localObject).onNetWifi2None();
            }
          }
        }
        paramMessage = a.b.iterator();
        while (paramMessage.hasNext())
        {
          localObject = (INetEventHandler)paramMessage.next();
          if (localObject != null)
          {
            if (j == 4) {
              break label534;
            }
            if (j != 5) {
              break label528;
            }
            break label534;
            ((INetEventHandler)localObject).onNetChangeEvent(bool);
          }
        }
      } while (!a.f());
      if ((a.f != null) && (a.f.isAvailable())) {
        switch (a.f.getType())
        {
        case 1: 
          a.h = -1;
          return false;
        case 0: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
          label408:
          switch (((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getNetworkType())
          {
          }
          break;
        }
      }
      for (;;)
      {
        a.h = 0;
        return false;
        a.h = 2;
        return false;
        a.h = 1;
        return false;
        a.h = 3;
        return false;
        label528:
        bool = true;
        break;
        label534:
        bool = false;
        break;
        break label408;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */