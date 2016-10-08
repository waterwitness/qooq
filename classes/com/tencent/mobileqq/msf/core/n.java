package com.tencent.mobileqq.msf.core;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class n
{
  public static final String a = "MSF.C.Util";
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static long g = 0L;
  public static String h = "";
  public static String i = "";
  public static int j = 0;
  private static final int k = 60000;
  private static final int l = 1000000;
  private static final AtomicInteger m = new AtomicInteger(60000 + new Random().nextInt(100000));
  private static final String n = "sp_imei";
  private static String o = "";
  private static String p = "";
  private static int q;
  private static int r;
  private static String s = "";
  private static String t = "";
  private static String u = "";
  private static String v = "";
  private static String w = "";
  
  public static int a()
  {
    try
    {
      int i1 = m.incrementAndGet();
      if (i1 > 1000000) {
        m.set(60000 + new Random().nextInt(100000));
      }
      return i1;
    }
    finally {}
  }
  
  public static FromServiceMsg a(ToServiceMsg paramToServiceMsg)
  {
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    localFromServiceMsg.setAppId(paramToServiceMsg.getAppId());
    localFromServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
    localFromServiceMsg.setRequestSsoSeq(paramToServiceMsg.getRequestSsoSeq());
    localFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
    localFromServiceMsg.addAttribute("to_SenderProcessName", paramToServiceMsg.getAttribute("to_SenderProcessName"));
    localFromServiceMsg.addAttribute("__timestamp_net2msf", Long.valueOf(System.currentTimeMillis()));
    return localFromServiceMsg;
  }
  
  /* Error */
  private static void a(File paramFile, List paramList)
  {
    // Byte code:
    //   0: new 164	java/util/Properties
    //   3: dup
    //   4: invokespecial 165	java/util/Properties:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 171	java/io/File:exists	()Z
    //   12: ifne +8 -> 20
    //   15: aload_0
    //   16: invokevirtual 174	java/io/File:createNewFile	()Z
    //   19: pop
    //   20: aload_1
    //   21: invokeinterface 180 1 0
    //   26: astore_2
    //   27: aload_2
    //   28: invokeinterface 185 1 0
    //   33: ifeq +101 -> 134
    //   36: aload_2
    //   37: invokeinterface 189 1 0
    //   42: checkcast 191	com/tencent/qphone/base/remote/SimpleAccount
    //   45: astore_1
    //   46: aload_3
    //   47: aload_1
    //   48: invokevirtual 192	com/tencent/qphone/base/remote/SimpleAccount:getUin	()Ljava/lang/String;
    //   51: aload_1
    //   52: invokevirtual 195	com/tencent/qphone/base/remote/SimpleAccount:toStoreString	()Ljava/lang/String;
    //   55: invokevirtual 199	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: goto -32 -> 27
    //   62: astore_3
    //   63: aconst_null
    //   64: astore_2
    //   65: aload_2
    //   66: astore_1
    //   67: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +43 -> 113
    //   73: aload_2
    //   74: astore_1
    //   75: ldc 8
    //   77: iconst_2
    //   78: new 206	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   85: ldc -47
    //   87: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: invokevirtual 216	java/io/File:getName	()Ljava/lang/String;
    //   94: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc -38
    //   99: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_3
    //   103: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: aload_3
    //   110: invokestatic 227	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: iconst_0
    //   114: ifeq +11 -> 125
    //   117: new 229	java/lang/NullPointerException
    //   120: dup
    //   121: invokespecial 230	java/lang/NullPointerException:<init>	()V
    //   124: athrow
    //   125: aload_2
    //   126: ifnull +7 -> 133
    //   129: aload_2
    //   130: invokevirtual 235	java/io/FileOutputStream:close	()V
    //   133: return
    //   134: new 232	java/io/FileOutputStream
    //   137: dup
    //   138: aload_0
    //   139: invokespecial 238	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   142: astore_2
    //   143: aload_2
    //   144: astore_1
    //   145: aload_3
    //   146: aload_2
    //   147: ldc 65
    //   149: invokevirtual 242	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   152: aload_2
    //   153: astore_1
    //   154: aload_2
    //   155: invokevirtual 235	java/io/FileOutputStream:close	()V
    //   158: aload_2
    //   159: astore_1
    //   160: ldc 8
    //   162: iconst_1
    //   163: new 206	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   170: ldc -12
    //   172: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_0
    //   176: invokevirtual 216	java/io/File:getName	()Ljava/lang/String;
    //   179: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 247	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: iconst_0
    //   189: ifeq +11 -> 200
    //   192: new 229	java/lang/NullPointerException
    //   195: dup
    //   196: invokespecial 230	java/lang/NullPointerException:<init>	()V
    //   199: athrow
    //   200: aload_2
    //   201: ifnull -68 -> 133
    //   204: aload_2
    //   205: invokevirtual 235	java/io/FileOutputStream:close	()V
    //   208: return
    //   209: astore_0
    //   210: aload_0
    //   211: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   214: return
    //   215: astore_0
    //   216: aconst_null
    //   217: astore_1
    //   218: iconst_0
    //   219: ifeq +11 -> 230
    //   222: new 229	java/lang/NullPointerException
    //   225: dup
    //   226: invokespecial 230	java/lang/NullPointerException:<init>	()V
    //   229: athrow
    //   230: aload_1
    //   231: ifnull +7 -> 238
    //   234: aload_1
    //   235: invokevirtual 235	java/io/FileOutputStream:close	()V
    //   238: aload_0
    //   239: athrow
    //   240: astore_2
    //   241: aload_2
    //   242: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   245: goto -15 -> 230
    //   248: astore_1
    //   249: aload_1
    //   250: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   253: goto -15 -> 238
    //   256: astore_0
    //   257: aload_0
    //   258: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   261: goto -136 -> 125
    //   264: astore_0
    //   265: goto -55 -> 210
    //   268: astore_0
    //   269: aload_0
    //   270: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   273: goto -73 -> 200
    //   276: astore_0
    //   277: goto -59 -> 218
    //   280: astore_3
    //   281: goto -216 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	paramFile	File
    //   0	284	1	paramList	List
    //   26	179	2	localObject	Object
    //   240	2	2	localIOException	IOException
    //   7	40	3	localProperties	Properties
    //   62	84	3	localException1	Exception
    //   280	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	20	62	java/lang/Exception
    //   20	27	62	java/lang/Exception
    //   27	59	62	java/lang/Exception
    //   134	143	62	java/lang/Exception
    //   204	208	209	java/io/IOException
    //   8	20	215	finally
    //   20	27	215	finally
    //   27	59	215	finally
    //   134	143	215	finally
    //   222	230	240	java/io/IOException
    //   234	238	248	java/io/IOException
    //   117	125	256	java/io/IOException
    //   129	133	264	java/io/IOException
    //   192	200	268	java/io/IOException
    //   67	73	276	finally
    //   75	113	276	finally
    //   145	152	276	finally
    //   154	158	276	finally
    //   160	188	276	finally
    //   145	152	280	java/lang/Exception
    //   154	158	280	java/lang/Exception
    //   160	188	280	java/lang/Exception
  }
  
  public static void a(String paramString)
  {
    Object localObject = new File(MsfCore.SAVEPATH_IMEI);
    try
    {
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      if (((File)localObject).exists())
      {
        localObject = MsfSdkUtils.loadConfig(MsfCore.SAVEPATH_IMEI);
        ((Properties)localObject).put("imei", paramString);
        MsfSdkUtils.saveConfig(MsfCore.SAVEPATH_IMEI, (Properties)localObject);
        return;
      }
      QLog.d("MSF.C.Util", 1, "can not create imei file");
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("MSF.C.Util", 1, "save sys imei error", paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    g = paramLong;
    h = paramString1;
    i = paramString2;
  }
  
  private static void a(String paramString, List paramList)
  {
    int i1 = 1;
    for (;;)
    {
      if (i1 != 0)
      {
        Iterator localIterator = paramList.iterator();
        i1 = 0;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label64;
          }
          if (((SimpleAccount)localIterator.next()).getUin().equals(paramString))
          {
            paramList.remove(i1);
            i1 = 1;
            break;
          }
          i1 += 1;
        }
      }
      return;
      label64:
      i1 = 0;
    }
  }
  
  public static String b()
  {
    Random localRandom = new Random(System.currentTimeMillis());
    String str = "---------";
    int i1 = 0;
    while (i1 < 12)
    {
      str = str + String.valueOf(localRandom.nextInt(10));
      i1 += 1;
    }
    return str;
  }
  
  public static String b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getAttributes().get("to_SenderProcessName") != null) {
      return (String)paramToServiceMsg.getAttributes().get("to_SenderProcessName");
    }
    return "";
  }
  
  public static void c()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
    try
    {
      localObject1 = localTelephonyManager.getSubscriberId();
      if (localObject1 != null)
      {
        t = (String)localObject1;
        u = (String)localObject1;
      }
      localObject1 = localTelephonyManager.getNetworkOperatorName();
      if (localObject1 != null) {
        w = (String)localObject1;
      }
      o = localTelephonyManager.getNetworkCountryIso();
      p = localTelephonyManager.getSimCountryIso();
      localObject1 = localTelephonyManager.getCellLocation();
      if (!(localObject1 instanceof CdmaCellLocation)) {
        break label554;
      }
      localObject1 = (CdmaCellLocation)localTelephonyManager.getCellLocation();
      if (localObject1 != null) {
        q = ((CdmaCellLocation)localObject1).getBaseStationId();
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject1 = BaseApplication.getContext().getAssets().open("revision.txt");
          try
          {
            localObject4 = new byte[64];
            i1 = ((InputStream)localObject1).read((byte[])localObject4, 0, 64);
            if (i1 != -1)
            {
              v = new String((byte[])localObject4, 0, i1);
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.Util", 2, "revision:" + v);
              }
            }
            return;
          }
          catch (IOException localIOException)
          {
            label554:
            QLog.d("MSF.C.Util", 1, "get revision IOException " + localIOException.getMessage());
            return;
          }
          if (!(localObject1 instanceof GsmCellLocation)) {
            continue;
          }
          localObject1 = (GsmCellLocation)localTelephonyManager.getCellLocation();
          if (localObject1 == null) {
            continue;
          }
          q = ((GsmCellLocation)localObject1).getCid();
        }
        catch (Exception localException3)
        {
          QLog.d("MSF.C.Util", 1, "get revision error " + localException3.getMessage());
          return;
        }
        localException1 = localException1;
        QLog.d("MSF.C.Util", 1, "get imsi error " + localException1, localException1);
        continue;
        if (t.length() > 5)
        {
          t = t.substring(0, 5);
          continue;
          localObject4 = m();
          j = 4;
          localObject2 = localObject4;
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.Util", 2, "load imei:" + (String)localObject4);
            localObject2 = localObject4;
          }
        }
      }
    }
    if (t == null)
    {
      t = "";
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.Util", 2, "imsi:" + t + " networkOperatorName:" + w);
      }
    }
    for (;;)
    {
      try
      {
        j = 0;
        if (!new File(MsfCore.SAVEPATH_IMEI).exists()) {
          break label794;
        }
        localObject4 = MsfSdkUtils.loadConfig(MsfCore.SAVEPATH_IMEI).getProperty("imei");
        if (localObject4 != null)
        {
          localObject1 = localObject4;
          if (((String)localObject4).length() != 0) {}
        }
        else
        {
          Thread.sleep(200L);
          localObject1 = MsfSdkUtils.loadConfig(MsfCore.SAVEPATH_IMEI).getProperty("imei", null);
        }
        j = 1;
        localObject4 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.Util", 2, "read imei from file " + MsfCore.SAVEPATH_IMEI + ", imei:" + (String)localObject1);
          localObject4 = localObject1;
        }
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("MSF.C.Util", 0);
        if ((localObject4 != null) && (((String)localObject4).length() != 0)) {
          continue;
        }
        localObject1 = localSharedPreferences.getString("sp_imei", null);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.Util", 2, "read imei from sharepreference:" + (String)localObject1);
        }
        if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
          continue;
        }
        localObject4 = localTelephonyManager.getDeviceId();
        if ((localObject4 == null) || (((String)localObject4).length() <= 0)) {
          continue;
        }
        j = 3;
        localObject1 = localObject4;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.Util", 2, "read sys imei:" + (String)localObject4);
          localObject1 = localObject4;
        }
      }
      catch (Exception localException2)
      {
        SharedPreferences localSharedPreferences;
        int i1;
        Object localObject2;
        QLog.d("MSF.C.Util", 1, "read sys imei error " + localException2, localException2);
        continue;
        j = 2;
        continue;
        j = 1;
        Object localObject3 = localObject4;
        continue;
      }
      a((String)localObject1);
      Object localObject4 = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject4).putString("sp_imei", (String)localObject1);
      ((SharedPreferences.Editor)localObject4).commit();
      s = (String)localObject1;
      QLog.d("MSF.C.Util", 1, "save imei:" + s + ",with order:" + j);
      v = "testrevision";
      label794:
      localObject4 = null;
    }
  }
  
  public static String d()
  {
    return s;
  }
  
  public static String e()
  {
    return t;
  }
  
  public static String f()
  {
    return u;
  }
  
  public static String g()
  {
    return v;
  }
  
  public static int h()
  {
    return r;
  }
  
  public static String i()
  {
    return o;
  }
  
  public static String j()
  {
    return p;
  }
  
  public static int k()
  {
    return q;
  }
  
  public static String l()
  {
    return w;
  }
  
  public static String m()
  {
    String str1 = null;
    Object localObject = new File(MsfCore.SAVEPATH_IMEI);
    StringBuffer localStringBuffer;
    String str2;
    try
    {
      if (((File)localObject).exists()) {
        str1 = MsfSdkUtils.loadConfig(MsfCore.SAVEPATH_IMEI).getProperty("imei");
      }
      if (str1 != null)
      {
        i1 = str1.length();
        if (i1 > 0) {
          return str1;
        }
      }
    }
    catch (Exception localException1)
    {
      QLog.d("MSF.C.Util", 1, "load sys imei error", localException1);
      localStringBuffer = new StringBuffer();
      int i1 = 0;
      while (i1 < 15)
      {
        localStringBuffer.append(new Random().nextInt(10));
        i1 += 1;
      }
      str2 = localStringBuffer.toString();
    }
    for (;;)
    {
      try
      {
        if (!((File)localObject).exists()) {
          ((File)localObject).createNewFile();
        }
        if (!((File)localObject).exists()) {
          continue;
        }
        localObject = MsfSdkUtils.loadConfig(MsfCore.SAVEPATH_IMEI);
        ((Properties)localObject).put("imei", str2);
        MsfSdkUtils.saveConfig(MsfCore.SAVEPATH_IMEI, (Properties)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.Util", 2, "write imei " + str2);
        }
      }
      catch (Exception localException2)
      {
        QLog.d("MSF.C.Util", 1, "load imei error", localException2);
        continue;
      }
      return localStringBuffer.toString();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.Util", 2, "can not create imei file");
      }
    }
  }
  
  public static String n()
  {
    try
    {
      NetworkInterface localNetworkInterface;
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          do
          {
            if ((localObject == null) || (!((Enumeration)localObject).hasMoreElements())) {
              break;
            }
            localNetworkInterface = (NetworkInterface)((Enumeration)localObject).nextElement();
          } while (localNetworkInterface == null);
          localEnumeration = localNetworkInterface.getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while ((localInetAddress == null) || (localInetAddress.isLoopbackAddress()) || (localInetAddress.isAnyLocalAddress()) || (localInetAddress.isLinkLocalAddress()));
      Object localObject = localNetworkInterface.getName() + ":" + localInetAddress.getHostAddress();
      return (String)localObject;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MSF.C.Util", 2, "getDeviceIp error " + localException.toString(), localException);
      }
    }
    return "0";
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */