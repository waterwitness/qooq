package ct;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.params.HttpParams;

public class bb
{
  public static String a;
  public static String b;
  public static String c;
  public static volatile boolean d = false;
  private static String e;
  private static String f;
  private static String g;
  private static String h;
  private static String i;
  private static Context j;
  private static volatile boolean k;
  private static String l;
  private static volatile int m;
  private static int n;
  private static String o = "";
  
  static
  {
    bb.class.getSimpleName();
    e = "cmwap";
    f = "3gwap";
    g = "uniwap";
    h = "ctwap";
    a = "nonetwork";
    i = "wifi";
    k = true;
    b = "";
    l = "";
    c = "";
    m = 0;
    n = 0;
  }
  
  public static String a()
  {
    for (;;)
    {
      try
      {
        switch (m)
        {
        case 1: 
          str = "unknown";
          return str;
        }
      }
      finally {}
      String str = "ssid_" + l + c;
      continue;
      str = "apn_" + b;
      continue;
      str = "4Gapn_" + b;
    }
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      j = paramContext;
      b();
      i();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(HttpClient paramHttpClient)
  {
    if ((d) && (!TextUtils.isEmpty(o)))
    {
      HttpHost localHttpHost = new HttpHost(o, 80);
      paramHttpClient.getParams().setParameter("http.route.default-proxy", localHttpHost);
      new StringBuilder("setProxy... sProxyAddress:").append(o).append(",apn:").append(b);
      bc.a();
      return;
    }
    paramHttpClient.getParams().setParameter("http.route.default-proxy", null);
  }
  
  /* Error */
  public static boolean a(Integer paramInteger)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: iload_3
    //   6: istore_2
    //   7: aload_0
    //   8: invokevirtual 147	java/lang/Integer:intValue	()I
    //   11: iconst_1
    //   12: if_icmpeq +25 -> 37
    //   15: iload_3
    //   16: istore_2
    //   17: aload_0
    //   18: invokevirtual 147	java/lang/Integer:intValue	()I
    //   21: iconst_2
    //   22: if_icmpeq +15 -> 37
    //   25: aload_0
    //   26: invokevirtual 147	java/lang/Integer:intValue	()I
    //   29: istore_1
    //   30: iload_1
    //   31: iconst_3
    //   32: if_icmpne +10 -> 42
    //   35: iload_3
    //   36: istore_2
    //   37: ldc 2
    //   39: monitorexit
    //   40: iload_2
    //   41: ireturn
    //   42: iconst_0
    //   43: istore_2
    //   44: goto -7 -> 37
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	paramInteger	Integer
    //   29	4	1	i1	int
    //   6	38	2	bool1	boolean
    //   1	35	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   7	15	47	finally
    //   17	30	47	finally
  }
  
  public static void b()
  {
    for (;;)
    {
      int i1;
      try
      {
        bc.b();
        localObject1 = ((ConnectivityManager)j.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localObject1 != null) {
          continue;
        }
        b = "";
        m = 0;
        d = false;
        o = "";
        k = false;
        b = a;
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        localThrowable.printStackTrace();
        continue;
      }
      finally {}
      return;
      if ((((NetworkInfo)localObject1).isAvailable()) && (((NetworkInfo)localObject1).isConnected()))
      {
        k = true;
        i1 = ((NetworkInfo)localObject1).getType();
        if (i1 == 1)
        {
          m = 1;
          d = false;
          o = "";
          localObject1 = ((WifiManager)j.getSystemService("wifi")).getConnectionInfo();
          l = ((WifiInfo)localObject1).getSSID();
          c = ((WifiInfo)localObject1).getBSSID();
          b = i;
        }
      }
      else
      {
        k = false;
        b = a;
        continue;
      }
      String str = ((NetworkInfo)localObject2).getExtraInfo();
      if (str == null)
      {
        b = "";
        m = 0;
        d = false;
        o = "";
      }
      else
      {
        b = str.trim().toLowerCase();
        if (i1 == 0)
        {
          i1 = ((NetworkInfo)localObject2).getSubtype();
          if ((i1 != 1) && (i1 != 2) && (i1 != 4)) {
            break label264;
          }
          m = 2;
        }
        for (;;)
        {
          n = j().intValue();
          if (!b.contains(f)) {
            break label284;
          }
          d = true;
          o = "10.0.0.172";
          break;
          label264:
          if (i1 == 13) {
            m = 4;
          } else {
            m = 3;
          }
        }
        label284:
        if (b.contains(e))
        {
          d = true;
          o = "10.0.0.172";
        }
        else if (b.contains(g))
        {
          d = true;
          o = "10.0.0.172";
        }
        else if (b.contains(h))
        {
          d = true;
          o = "10.0.0.200";
        }
        else
        {
          d = false;
          o = "";
        }
      }
    }
  }
  
  public static int c()
  {
    try
    {
      int i1 = m;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static int d()
  {
    try
    {
      int i1 = n;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static boolean e()
  {
    return k;
  }
  
  public static boolean f()
  {
    return m == 1;
  }
  
  public static boolean g()
  {
    return m == 2;
  }
  
  public static boolean h()
  {
    return m == 3;
  }
  
  private static void i()
  {
    try
    {
      new StringBuilder("showApnInfo... Apn:").append(b).append(",sIsNetworkOk:").append(k).append(",sNetType:").append(m).append(",sIsProxy:").append(d).append(",sProxyAddress:").append(o);
      bc.b();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static Integer j()
  {
    int i3 = 3;
    int i2 = 2;
    int i1 = 1;
    for (;;)
    {
      Object localObject4;
      try
      {
        if (m == 1)
        {
          localObject1 = l;
          if ((localObject1 == null) || (((String)localObject1).length() <= 0))
          {
            localObject1 = Integer.valueOf(0);
            n = ((Integer)localObject1).intValue();
            i1 = n;
            return Integer.valueOf(i1);
          }
          localObject1 = ((String)localObject1).toLowerCase();
          if (!((String)localObject1).contains("cmcc")) {
            break label364;
          }
          if (!((String)localObject1).contains("chinanet")) {
            break label361;
          }
          i1 = i3;
          if (!((String)localObject1).contains("chinaunicom")) {
            break label358;
          }
          i1 = i2;
          localObject1 = Integer.valueOf(i1);
          continue;
        }
        if ((m != 2) && (m != 3)) {
          break label351;
        }
        localObject4 = j;
        Object localObject1 = b;
        localObject4 = (TelephonyManager)((Context)localObject4).getSystemService("phone");
        if ((localObject4 == null) || (((TelephonyManager)localObject4).getSimState() != 5)) {
          break label234;
        }
        localObject4 = ((TelephonyManager)localObject4).getSimOperator();
        if (((String)localObject4).length() <= 0) {
          break label234;
        }
        if ((((String)localObject4).equals("46000")) || (((String)localObject4).equals("46002")))
        {
          localObject1 = Integer.valueOf(1);
          n = ((Integer)localObject1).intValue();
          continue;
        }
        if (!((String)localObject4).equals("46001")) {
          break label216;
        }
      }
      finally {}
      Object localObject3 = Integer.valueOf(2);
      continue;
      label216:
      if (((String)localObject4).equals("46003"))
      {
        localObject3 = Integer.valueOf(3);
      }
      else
      {
        label234:
        if (localObject3 != null)
        {
          localObject3 = ((String)localObject3).toLowerCase();
          if ((((String)localObject3).contains("cmnet")) || (((String)localObject3).contains("cmwap")))
          {
            localObject3 = Integer.valueOf(1);
            continue;
          }
          if ((((String)localObject3).contains("uninet")) || (((String)localObject3).contains("uniwap")) || (((String)localObject3).contains("3gnet")) || (((String)localObject3).contains("3gwap")))
          {
            localObject3 = Integer.valueOf(2);
            continue;
          }
          if ((((String)localObject3).contains("ctnet")) || (((String)localObject3).contains("ctwap")))
          {
            localObject3 = Integer.valueOf(3);
            continue;
          }
        }
        localObject3 = Integer.valueOf(0);
        continue;
        label351:
        n = 0;
        continue;
        label358:
        continue;
        label361:
        continue;
        label364:
        i1 = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */