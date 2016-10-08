package com.tencent.mobileqq.app.soso;

import NearbyGroup.Attr;
import NearbyGroup.Cell;
import NearbyGroup.GPS;
import NearbyGroup.LBSInfo;
import NearbyGroup.Wifi;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.map.geolocation.internal.TencentLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qny;
import qoa;
import qob;
import qoc;
import qod;

public class SosoInterface
  implements TencentLog
{
  public static final int a = -10000;
  public static long a = 0L;
  private static TencentLocationListener jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener = new qny();
  private static TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  private static TencentLog jdField_a_of_type_ComTencentMapGeolocationInternalTencentLog;
  private static final SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new qoa(0, false, false, 0L, false, false, "reqRawData");
  public static SosoInterface.SosoLbsInfo a;
  public static final Object a;
  public static final String a = "SOSO.LBS";
  private static final ArrayList jdField_a_of_type_JavaUtilArrayList;
  private static HashSet jdField_a_of_type_JavaUtilHashSet;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static long[] jdField_a_of_type_ArrayOfLong;
  public static final int b = 30000;
  public static long b = 0L;
  public static final String b = "soso_lbs";
  public static final int c = 2000;
  public static long c = 0L;
  public static final String c = "timeDenyPer";
  public static final int d = 0;
  private static long d = 0L;
  public static final String d = "qq_";
  public static final int e = 1;
  public static final int f = 2;
  private static int g;
  private static int h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    jdField_a_of_type_ArrayOfLong = new long[] { 0L, 0L, 0L, 0L, 0L };
  }
  
  public static LBSInfo a()
  {
    return a(false, a());
  }
  
  public static LBSInfo a(boolean paramBoolean, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    Attr localAttr = null;
    if (paramSosoLbsInfo == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    if (paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SosoInterface.SosoCell)((Iterator)localObject1).next();
        localArrayList.add(new Cell((short)((SosoInterface.SosoCell)localObject2).jdField_a_of_type_Int, (short)((SosoInterface.SosoCell)localObject2).jdField_b_of_type_Int, ((SosoInterface.SosoCell)localObject2).c, ((SosoInterface.SosoCell)localObject2).d, (short)((SosoInterface.SosoCell)localObject2).e));
      }
    }
    for (;;)
    {
      try
      {
        if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null) {
          break label313;
        }
        if (!paramBoolean) {
          continue;
        }
        localObject1 = new GPS((int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Double * 1000000.0D), (int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_Double * 1000000.0D), -1, 1);
      }
      catch (Exception localException)
      {
        Iterator localIterator;
        SosoInterface.SosoWifi localSosoWifi;
        localGPS = null;
        continue;
        if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute == null) {
          continue;
        }
        localAttr = new Attr(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.jdField_a_of_type_JavaLangString, paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.jdField_b_of_type_JavaLangString, paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.jdField_c_of_type_JavaLangString);
        return new LBSInfo(localGPS, (ArrayList)localObject2, localArrayList, localAttr);
      }
      localObject2 = new ArrayList();
      if (paramSosoLbsInfo.jdField_b_of_type_JavaUtilArrayList != null)
      {
        localIterator = paramSosoLbsInfo.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          localSosoWifi = (SosoInterface.SosoWifi)localIterator.next();
          if (localSosoWifi == null) {
            continue;
          }
          ((ArrayList)localObject2).add(new Wifi(localSosoWifi.jdField_a_of_type_Long, (short)localSosoWifi.jdField_a_of_type_Int));
          continue;
          localObject1 = new GPS((int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_c_of_type_Double * 1000000.0D), (int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_d_of_type_Double * 1000000.0D), -1, 0);
          continue;
        }
      }
      label313:
      GPS localGPS = null;
    }
  }
  
  public static SosoInterface.SosoLbsInfo a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null) {
      return null;
    }
    SosoInterface.SosoLbsInfo localSosoLbsInfo = new SosoInterface.SosoLbsInfo();
    localSosoLbsInfo.jdField_a_of_type_ArrayOfByte = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ArrayOfByte;
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null) {
      localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a();
    }
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute != null) {
      localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.a();
    }
    ArrayList localArrayList = new ArrayList();
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_JavaUtilArrayList != null) {
      localArrayList.addAll(jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_JavaUtilArrayList);
    }
    localSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    localArrayList = new ArrayList();
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_b_of_type_JavaUtilArrayList != null) {
      localArrayList.addAll(jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_b_of_type_JavaUtilArrayList);
    }
    localSosoLbsInfo.jdField_b_of_type_JavaUtilArrayList = localArrayList;
    localSosoLbsInfo.jdField_a_of_type_Long = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_Long;
    localSosoLbsInfo.jdField_a_of_type_JavaLangString = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_JavaLangString;
    localSosoLbsInfo.jdField_b_of_type_JavaLangString = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_b_of_type_JavaLangString;
    return localSosoLbsInfo;
  }
  
  public static void a()
  {
    
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  /* Error */
  @Deprecated
  public static void a(long paramLong, String paramString)
  {
    // Byte code:
    //   0: invokestatic 238	com/tencent/mobileqq/app/ThreadManager:b	()Ljava/lang/Thread;
    //   3: invokestatic 243	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6: if_acmpeq +15 -> 21
    //   9: invokestatic 243	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12: invokestatic 249	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   15: invokevirtual 252	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   18: if_acmpne +31 -> 49
    //   21: new 254	android/util/AndroidRuntimeException
    //   24: dup
    //   25: new 256	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 259
    //   35: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 270	android/util/AndroidRuntimeException:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: invokestatic 243	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   52: invokevirtual 274	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   55: astore 5
    //   57: ldc_w 276
    //   60: astore 4
    //   62: aload 4
    //   64: astore_3
    //   65: aload 5
    //   67: ifnull +89 -> 156
    //   70: aload 4
    //   72: astore_3
    //   73: aload 5
    //   75: arraylength
    //   76: iconst_4
    //   77: if_icmplt +79 -> 156
    //   80: aload 5
    //   82: iconst_3
    //   83: aaload
    //   84: astore_3
    //   85: new 256	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   92: aload_3
    //   93: invokevirtual 281	java/lang/StackTraceElement:getClassName	()Ljava/lang/String;
    //   96: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc_w 283
    //   102: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_3
    //   106: invokevirtual 286	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
    //   109: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore 4
    //   117: aload 4
    //   119: astore_3
    //   120: invokestatic 291	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +33 -> 156
    //   126: ldc 21
    //   128: iconst_2
    //   129: new 256	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   136: ldc_w 293
    //   139: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload 4
    //   144: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 297	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload 4
    //   155: astore_3
    //   156: lload_0
    //   157: lconst_0
    //   158: lcmp
    //   159: ifle +138 -> 297
    //   162: invokestatic 302	android/os/SystemClock:elapsedRealtime	()J
    //   165: getstatic 303	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_Long	J
    //   168: lload_0
    //   169: ladd
    //   170: lcmp
    //   171: ifge +126 -> 297
    //   174: invokestatic 291	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +29 -> 206
    //   180: ldc 21
    //   182: iconst_2
    //   183: new 256	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   190: ldc_w 305
    //   193: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_2
    //   197: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: new 309	java/util/HashMap
    //   209: dup
    //   210: invokespecial 310	java/util/HashMap:<init>	()V
    //   213: astore 4
    //   215: aload_2
    //   216: ifnull +20 -> 236
    //   219: aload_2
    //   220: invokevirtual 315	java/lang/String:length	()I
    //   223: ifle +13 -> 236
    //   226: aload 4
    //   228: ldc_w 317
    //   231: aload_2
    //   232: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   235: pop
    //   236: aload_3
    //   237: invokestatic 327	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   240: ifne +13 -> 253
    //   243: aload 4
    //   245: ldc_w 329
    //   248: aload_3
    //   249: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   252: pop
    //   253: aload 4
    //   255: ldc_w 331
    //   258: getstatic 337	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   261: invokevirtual 340	java/lang/Boolean:booleanValue	()Z
    //   264: invokestatic 343	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   267: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   270: pop
    //   271: invokestatic 347	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	()Ljava/lang/String;
    //   274: astore_2
    //   275: invokestatic 353	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   278: invokestatic 358	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   281: aload_2
    //   282: ldc_w 360
    //   285: iconst_1
    //   286: lconst_0
    //   287: lconst_0
    //   288: aload 4
    //   290: ldc_w 276
    //   293: invokevirtual 363	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   296: return
    //   297: invokestatic 291	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +39 -> 339
    //   303: ldc 21
    //   305: iconst_2
    //   306: new 256	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   313: ldc_w 365
    //   316: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_2
    //   320: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: ldc_w 367
    //   326: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: lload_0
    //   330: invokevirtual 370	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   333: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   339: getstatic 84	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener	Lcom/tencent/mobileqq/app/soso/SosoInterface$OnLocationListener;
    //   342: aload_2
    //   343: putfield 373	com/tencent/mobileqq/app/soso/SosoInterface$OnLocationListener:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   346: getstatic 84	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener	Lcom/tencent/mobileqq/app/soso/SosoInterface$OnLocationListener;
    //   349: invokestatic 376	com/tencent/mobileqq/app/soso/SosoInterface:a	(Lcom/tencent/mobileqq/app/soso/SosoInterface$OnLocationListener;)V
    //   352: invokestatic 302	android/os/SystemClock:elapsedRealtime	()J
    //   355: lstore_0
    //   356: iconst_0
    //   357: istore 12
    //   359: iconst_0
    //   360: istore 11
    //   362: iload 11
    //   364: istore 10
    //   366: getstatic 56	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   369: astore 4
    //   371: iload 11
    //   373: istore 10
    //   375: aload 4
    //   377: monitorenter
    //   378: iload 12
    //   380: istore 11
    //   382: invokestatic 302	android/os/SystemClock:elapsedRealtime	()J
    //   385: lstore 6
    //   387: iload 12
    //   389: istore 11
    //   391: getstatic 303	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_Long	J
    //   394: lstore 8
    //   396: lload 6
    //   398: lload 8
    //   400: ldc2_w 377
    //   403: ladd
    //   404: lcmp
    //   405: ifge +79 -> 484
    //   408: iconst_1
    //   409: istore 10
    //   411: aload 4
    //   413: monitorexit
    //   414: invokestatic 291	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq -121 -> 296
    //   420: ldc 21
    //   422: iconst_2
    //   423: new 256	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   430: ldc_w 380
    //   433: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: getstatic 383	com/tencent/mobileqq/app/NearbyHandler:d	I
    //   439: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   442: ldc_w 388
    //   445: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload_2
    //   449: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: ldc_w 390
    //   455: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: iload 10
    //   460: invokevirtual 393	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   463: ldc_w 395
    //   466: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokestatic 302	android/os/SystemClock:elapsedRealtime	()J
    //   472: lload_0
    //   473: lsub
    //   474: invokevirtual 370	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   477: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: return
    //   484: iload 12
    //   486: istore 11
    //   488: getstatic 56	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   491: ldc2_w 396
    //   494: invokevirtual 401	java/lang/Object:wait	(J)V
    //   497: iconst_0
    //   498: istore 10
    //   500: goto -89 -> 411
    //   503: iload 10
    //   505: istore 11
    //   507: aload 4
    //   509: monitorexit
    //   510: aload_3
    //   511: athrow
    //   512: astore_3
    //   513: bipush -11
    //   515: putstatic 383	com/tencent/mobileqq/app/NearbyHandler:d	I
    //   518: goto -104 -> 414
    //   521: astore_3
    //   522: goto -19 -> 503
    //   525: astore_3
    //   526: iload 11
    //   528: istore 10
    //   530: goto -27 -> 503
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	533	0	paramLong	long
    //   0	533	2	paramString	String
    //   64	447	3	localObject1	Object
    //   512	1	3	localInterruptedException	InterruptedException
    //   521	1	3	localObject2	Object
    //   525	1	3	localObject3	Object
    //   60	448	4	localObject4	Object
    //   55	26	5	arrayOfStackTraceElement	StackTraceElement[]
    //   385	12	6	l1	long
    //   394	5	8	l2	long
    //   364	165	10	bool1	boolean
    //   360	167	11	bool2	boolean
    //   357	128	12	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   366	371	512	java/lang/InterruptedException
    //   375	378	512	java/lang/InterruptedException
    //   510	512	512	java/lang/InterruptedException
    //   411	414	521	finally
    //   382	387	525	finally
    //   391	396	525	finally
    //   488	497	525	finally
    //   507	510	525	finally
  }
  
  public static void a(SosoInterface.OnLocationListener paramOnLocationListener)
  {
    boolean bool1 = true;
    if (paramOnLocationListener == null) {}
    int i;
    label128:
    label144:
    label220:
    label226:
    label236:
    long l;
    Object localObject2;
    for (;;)
    {
      return;
      for (;;)
      {
        try
        {
          if (SosoInterface.OnLocationListener.a(paramOnLocationListener)) {
            SosoInterface.OnLocationListener.a(paramOnLocationListener, false);
          }
          localObject1 = Thread.currentThread().getStackTrace();
          if (paramOnLocationListener != jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener) {
            break label220;
          }
          i = 4;
          if ((localObject1 == null) || (localObject1.length < i + 1)) {
            break label915;
          }
          localObject1 = localObject1[i];
          localObject1 = ((StackTraceElement)localObject1).getClassName() + "." + ((StackTraceElement)localObject1).getMethodName();
          if (!QLog.isColorLevel()) {
            break label920;
          }
          QLog.i("SOSO.LBS", 2, "startLocation caller route: " + (String)localObject1);
        }
        finally {}
        boolean bool2 = HwNetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext());
        if (bool2) {
          break label909;
        }
        i = 1;
        if (i == 0) {
          break label236;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "startLocation() return. perCheckCode=" + i + " hasNet=" + bool2);
        }
        localObject1 = b();
        if (!paramOnLocationListener.jdField_e_of_type_Boolean) {
          break label226;
        }
        b(paramOnLocationListener, i, (SosoInterface.SosoLbsInfo)localObject1);
        break;
        i = 3;
      }
      paramOnLocationListener.a(i, (SosoInterface.SosoLbsInfo)localObject1);
      continue;
      if ((jdField_a_of_type_ComTencentMapGeolocationInternalTencentLog == null) && (paramOnLocationListener.jdField_e_of_type_Long <= 0L)) {
        break label903;
      }
      l = SystemClock.elapsedRealtime();
      if (!paramOnLocationListener.g) {
        break label478;
      }
      if ((jdField_a_of_type_ArrayOfLong[paramOnLocationListener.jdField_b_of_type_Int] <= 0L) || (l >= jdField_a_of_type_ArrayOfLong[paramOnLocationListener.jdField_b_of_type_Int] + paramOnLocationListener.jdField_e_of_type_Long)) {
        break label903;
      }
      localObject2 = b();
      if (!paramOnLocationListener.jdField_e_of_type_Boolean) {
        break;
      }
      b(paramOnLocationListener, 0, (SosoInterface.SosoLbsInfo)localObject2);
      break label923;
      label315:
      if (i == 0) {
        break label535;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SOSO.LBS", 2, "startLocation() lis=" + paramOnLocationListener.jdField_b_of_type_JavaLangString + " use cache and callback now");
      }
      localObject2 = new HashMap();
      if ((paramOnLocationListener.jdField_b_of_type_JavaLangString != null) && (paramOnLocationListener.jdField_b_of_type_JavaLangString.length() > 0)) {
        ((HashMap)localObject2).put("param_caller", paramOnLocationListener.jdField_b_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((HashMap)localObject2).put("param_caller_route", localObject1);
      }
      ((HashMap)localObject2).put("param_useCache", Boolean.toString(Boolean.TRUE.booleanValue()));
      localObject1 = EarlyDownloadManager.a();
      StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplicationImpl.getContext());
      if (!paramOnLocationListener.g) {
        break label935;
      }
      paramOnLocationListener = "actSosoLocationCache";
      label453:
      localStatisticCollector.a((String)localObject1, paramOnLocationListener, true, 0L, 0L, (HashMap)localObject2, "");
    }
    paramOnLocationListener.a(0, (SosoInterface.SosoLbsInfo)localObject2);
    break label923;
    label478:
    if ((jdField_a_of_type_Long > 0L) && (l < jdField_a_of_type_Long + paramOnLocationListener.jdField_e_of_type_Long) && (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null))
    {
      localObject2 = a();
      if (paramOnLocationListener.jdField_e_of_type_Boolean)
      {
        b(paramOnLocationListener, 0, (SosoInterface.SosoLbsInfo)localObject2);
        break label929;
      }
      paramOnLocationListener.a(0, (SosoInterface.SosoLbsInfo)localObject2);
      break label929;
      label535:
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("startLocation() reqLoc=").append(paramOnLocationListener.g).append(" askGPS=").append(paramOnLocationListener.h).append(" level=");
        if (paramOnLocationListener.jdField_b_of_type_Int != 3) {
          break label828;
        }
        localObject1 = "ADMIN_AREA";
        label593:
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(" caller=").append(paramOnLocationListener.jdField_b_of_type_JavaLangString).append(" ui=").append(paramOnLocationListener.jdField_e_of_type_Boolean).append(" goon=").append(paramOnLocationListener.f);
        if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) {
          break label949;
        }
      }
    }
    label692:
    label828:
    label897:
    label903:
    label909:
    label915:
    label920:
    label923:
    label929:
    label935:
    label942:
    label949:
    for (Object localObject1 = " do startLocation";; localObject1 = " waitting...")
    {
      QLog.d("SOSO.LBS", 2, (String)localObject1);
      c(paramOnLocationListener);
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) {
        break;
      }
      if (paramOnLocationListener == jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener)
      {
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
        paramOnLocationListener.d = SystemClock.elapsedRealtime();
        localObject1 = TencentLocationRequest.create();
        ((TencentLocationRequest)localObject1).setInterval(2000L);
        ((TencentLocationRequest)localObject1).setRequestLevel(paramOnLocationListener.jdField_b_of_type_Int);
        ((TencentLocationRequest)localObject1).setAllowCache(true);
        if (paramOnLocationListener.h) {
          TencentExtraKeys.setAllowGps((TencentLocationRequest)localObject1, true);
        }
        if (paramOnLocationListener.g) {
          break label897;
        }
      }
      for (;;)
      {
        TencentExtraKeys.setRequestRawData((TencentLocationRequest)localObject1, bool1);
        ((TencentLocationRequest)localObject1).getExtras().putInt("qq_level", paramOnLocationListener.jdField_b_of_type_Int);
        ((TencentLocationRequest)localObject1).getExtras().putBoolean("qq_reqLocation", paramOnLocationListener.g);
        ((TencentLocationRequest)localObject1).getExtras().putString("qq_caller", paramOnLocationListener.jdField_b_of_type_JavaLangString);
        ((TencentLocationRequest)localObject1).getExtras().putBoolean("qq_goonListener", paramOnLocationListener.f);
        ThreadManager.b().post(new qoc(paramOnLocationListener, (TencentLocationRequest)localObject1));
        break;
        if (paramOnLocationListener.jdField_b_of_type_Int == 5)
        {
          localObject1 = "FORMATTED_ADDRESS";
          break label593;
        }
        if (paramOnLocationListener.jdField_b_of_type_Int == 0)
        {
          localObject1 = "GEO";
          break label593;
        }
        if (paramOnLocationListener.jdField_b_of_type_Int == 1)
        {
          localObject1 = "NAME";
          break label593;
        }
        if (paramOnLocationListener.jdField_b_of_type_Int != 4) {
          break label942;
        }
        localObject1 = "POI";
        break label593;
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
        break label692;
        bool1 = false;
      }
      i = 0;
      break label315;
      i = 0;
      break label144;
      localObject1 = null;
      break label128;
      break label128;
      i = 1;
      break label315;
      i = 1;
      break label315;
      paramOnLocationListener = "actSosoRawDataCache";
      break label453;
      localObject1 = "unknown";
      break label593;
    }
  }
  
  private static void a(String paramString)
  {
    ThreadManager.c().post(new qod(paramString));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.a(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 2204);
    localNewIntent.putExtra("longitude", paramString1);
    localNewIntent.putExtra("latitude", paramString2);
    BaseApplicationImpl.a().a().startServlet(localNewIntent);
  }
  
  private static boolean a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (jdField_a_of_type_JavaUtilHashSet == null)) {
      return false;
    }
    return jdField_a_of_type_JavaUtilHashSet.contains(paramString);
  }
  
  public static SosoInterface.SosoLbsInfo b()
  {
    if ((jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null) || (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null)) {
      return null;
    }
    SosoInterface.SosoLbsInfo localSosoLbsInfo = new SosoInterface.SosoLbsInfo();
    localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a();
    return localSosoLbsInfo;
  }
  
  private static void b(int paramInt, TencentLocation paramTencentLocation)
  {
    if (paramTencentLocation == null) {
      return;
    }
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null)
    {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = new SosoInterface.SosoLbsInfo();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = new SosoInterface.SosoLocation(1, paramTencentLocation.getLatitude(), paramTencentLocation.getLongitude());
    }
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_Double = paramTencentLocation.getLongitude();
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Double = paramTencentLocation.getLatitude();
    switch (paramInt)
    {
    }
    for (;;)
    {
      b = SystemClock.elapsedRealtime();
      if (b - c <= 3000L) {
        break;
      }
      a(String.valueOf(paramTencentLocation.getLongitude()), String.valueOf(paramTencentLocation.getLatitude()));
      c = b;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SOSO.LBS", 2, "saveGeogInfo cost: " + (SystemClock.elapsedRealtime() - c));
      return;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_JavaUtilList = paramTencentLocation.getPoiList();
      jdField_a_of_type_ArrayOfLong[4] = SystemClock.elapsedRealtime();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_c_of_type_JavaLangString = paramTencentLocation.getNation();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_d_of_type_JavaLangString = paramTencentLocation.getProvince();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_e_of_type_JavaLangString = paramTencentLocation.getCity();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.f = paramTencentLocation.getDistrict();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.g = paramTencentLocation.getTown();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.h = paramTencentLocation.getVillage();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.i = paramTencentLocation.getStreet();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.j = paramTencentLocation.getStreetNo();
      jdField_a_of_type_ArrayOfLong[3] = SystemClock.elapsedRealtime();
      if (paramInt == 1)
      {
        jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_JavaLangString = paramTencentLocation.getName();
        jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_JavaLangString = paramTencentLocation.getAddress();
        jdField_a_of_type_ArrayOfLong[1] = SystemClock.elapsedRealtime();
      }
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_e_of_type_Double = paramTencentLocation.getAltitude();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Float = paramTencentLocation.getAccuracy();
      jdField_a_of_type_ArrayOfLong[0] = SystemClock.elapsedRealtime();
    }
  }
  
  public static void b(SosoInterface.OnLocationListener paramOnLocationListener)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilArrayList.remove(paramOnLocationListener);
      SosoInterface.OnLocationListener.a(paramOnLocationListener, true);
      SosoInterface.OnLocationListener.b(paramOnLocationListener, false);
      if (QLog.isColorLevel()) {
        QLog.d("SOSO.LBS", 2, "removeOnLocationListener() lis=" + paramOnLocationListener.jdField_b_of_type_JavaLangString + " removed.");
      }
      if (jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        c();
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "removeOnLocationListener() listener is empty. remveUpdate and stop LBS");
        }
      }
      return;
    }
  }
  
  private static void b(SosoInterface.OnLocationListener paramOnLocationListener, int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramOnLocationListener == null) {
      return;
    }
    ThreadManager.c().post(new qob(paramOnLocationListener, paramInt, paramSosoLbsInfo));
  }
  
  private static void b(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null) {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = new SosoInterface.SosoLbsInfo();
    }
    try
    {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      localJSONObject = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
      d2 = 0.0D;
      d1 = d2;
      for (;;)
      {
        try
        {
          paramArrayOfByte = localJSONObject.getJSONObject("location");
          d1 = d2;
          d2 = paramArrayOfByte.getDouble("latitude");
          d1 = d2;
          d3 = paramArrayOfByte.getDouble("longitude");
          d1 = d3;
        }
        catch (JSONException paramArrayOfByte)
        {
          SosoInterface.SosoAttribute localSosoAttribute;
          ArrayList localArrayList1;
          int j;
          int i;
          Object localObject;
          ArrayList localArrayList2;
          double d3 = 0.0D;
          d2 = d1;
          d1 = d3;
          continue;
          boolean bool = false;
          continue;
        }
        try
        {
          paramArrayOfByte = localJSONObject.getJSONObject("attribute");
          localSosoAttribute = new SosoInterface.SosoAttribute(paramArrayOfByte.getString("imei"), paramArrayOfByte.getString("imsi"), paramArrayOfByte.getString("phonenum"), paramArrayOfByte.getString("qq"), paramArrayOfByte.getBoolean("roaming"));
          localArrayList1 = new ArrayList();
          paramArrayOfByte = localJSONObject.getJSONArray("cells");
          j = paramArrayOfByte.length();
          i = 0;
          if (i < j)
          {
            localObject = paramArrayOfByte.getJSONObject(i);
            int k = ((JSONObject)localObject).getInt("mcc");
            int m = ((JSONObject)localObject).getInt("mnc");
            int n = ((JSONObject)localObject).getInt("lac");
            int i1 = ((JSONObject)localObject).getInt("cellid");
            int i2 = ((JSONObject)localObject).getInt("rss");
            if (i != 0) {
              continue;
            }
            bool = true;
            localArrayList1.add(new SosoInterface.SosoCell(k, m, n, i1, i2, bool));
            i += 1;
          }
        }
        catch (JSONException paramArrayOfByte)
        {
          localSosoAttribute = new SosoInterface.SosoAttribute("", "", "", "", false);
          continue;
          localArrayList2 = new ArrayList();
          paramArrayOfByte = localJSONObject.getJSONArray("wifis");
          i = 0;
          j = paramArrayOfByte.length();
          if (i < j)
          {
            localObject = paramArrayOfByte.getJSONObject(i);
            localArrayList2.add(new SosoInterface.SosoWifi(((JSONObject)localObject).getString("mac"), ((JSONObject)localObject).getInt("rssi")));
            i += 1;
          }
          else
          {
            paramArrayOfByte = "";
          }
        }
      }
    }
    catch (Exception paramString)
    {
      JSONObject localJSONObject;
      double d2;
      double d1;
      label410:
      return;
    }
    try
    {
      localObject = localJSONObject.getString("version");
      paramArrayOfByte = (byte[])localObject;
      l = localJSONObject.getLong("source");
    }
    catch (JSONException localJSONException)
    {
      l = 0L;
      byte[] arrayOfByte = paramArrayOfByte;
      break label410;
    }
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null) {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = new SosoInterface.SosoLocation(0, d2, d1);
    }
    for (;;)
    {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute = localSosoAttribute;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_JavaUtilArrayList = localArrayList1;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_b_of_type_JavaUtilArrayList = localArrayList2;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_Long = l;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_JavaLangString = ((String)localObject);
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_b_of_type_JavaLangString = paramString;
      jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      return;
      if (d2 != 0.0D) {
        jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_c_of_type_Double = d2;
      }
      if (d1 != 0.0D) {
        jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_d_of_type_Double = d1;
      }
    }
  }
  
  private static void b(boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, boolean paramBoolean3)
  {
    if ((String.valueOf(paramString2).equals("ERROR_NETWORK")) && ((paramInt2 == -4) || (paramInt2 == -17))) {}
    while (((paramBoolean1) || (!HwNetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))) && (!paramBoolean1)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInt1));
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      localHashMap.put("param_caller", paramString1);
    }
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      localHashMap.put("param_reason", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put("param_caller_route", paramString3);
    }
    localHashMap.put("param_detail", Integer.toString(paramInt2));
    localHashMap.put("param_useCache", Boolean.toString(Boolean.FALSE.booleanValue()));
    localHashMap.put("param_askGps", Boolean.toString(paramBoolean3));
    localHashMap.put("param_costTime", Long.toString(paramLong));
    paramString2 = EarlyDownloadManager.a();
    paramString3 = StatisticCollector.a(BaseApplicationImpl.getContext());
    if (paramBoolean2) {}
    for (paramString1 = "actSosoLocation";; paramString1 = "actSosoRawData")
    {
      paramString3.a(paramString2, paramString1, paramBoolean1, paramLong, 0L, localHashMap, "");
      return;
    }
  }
  
  private static void c()
  {
    if ((jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener != null) && (jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager != null))
    {
      jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.removeUpdates(jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
      jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SOSO.LBS", 2, "stopLocation() stop LBS");
    }
  }
  
  private static void c(SosoInterface.OnLocationListener paramOnLocationListener)
  {
    if (paramOnLocationListener == null) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(paramOnLocationListener)) {
        jdField_a_of_type_JavaUtilArrayList.add(paramOnLocationListener);
      }
      return;
    }
  }
  
  private static void d()
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    jdField_a_of_type_JavaUtilHashSet.add("ecshop");
    jdField_a_of_type_JavaUtilHashSet.add("AbsPublish");
    jdField_a_of_type_JavaUtilHashSet.add("QQYPHomePageActivity");
    jdField_a_of_type_JavaUtilHashSet.add("RedpointHandler");
    jdField_a_of_type_JavaUtilHashSet.add("HotSpotNodeUtil");
    jdField_a_of_type_JavaUtilHashSet.add("smartdevice:lightapp");
    jdField_a_of_type_JavaUtilHashSet.add("HYNearbyHelper");
    jdField_a_of_type_JavaUtilHashSet.add("AbsPublishIphoneTitleBarActivity");
    jdField_a_of_type_JavaUtilHashSet.add("DatingHandler");
    jdField_a_of_type_JavaUtilHashSet.add("BizTroopHandler");
    jdField_a_of_type_JavaUtilHashSet.add("FreshNewsHandler");
    jdField_a_of_type_JavaUtilHashSet.add("GetNearbyRecommender");
    jdField_a_of_type_JavaUtilHashSet.add("HotChatHandler");
    jdField_a_of_type_JavaUtilHashSet.add("LBSService");
    jdField_a_of_type_JavaUtilHashSet.add("LBSService.Encounter");
    jdField_a_of_type_JavaUtilHashSet.add("LBSService.Point");
    jdField_a_of_type_JavaUtilHashSet.add("MyBusinessServlet");
    jdField_a_of_type_JavaUtilHashSet.add("NearbyHandler");
    jdField_a_of_type_JavaUtilHashSet.add("NearbyProtocolCoder.Encounter");
    jdField_a_of_type_JavaUtilHashSet.add("AccountConfigReq");
    jdField_a_of_type_JavaUtilHashSet.add("AddContactTroopHandler");
    jdField_a_of_type_JavaUtilHashSet.add("AddFriendVerifyActivity");
    jdField_a_of_type_JavaUtilHashSet.add("AutoLocationMapView");
    jdField_a_of_type_JavaUtilHashSet.add("BaseProtocolCoder.Point");
    jdField_a_of_type_JavaUtilHashSet.add("BusinessCmrTmpChatPie");
    jdField_a_of_type_JavaUtilHashSet.add("BusinessHandler");
    jdField_a_of_type_JavaUtilHashSet.add("c2blbs");
    jdField_a_of_type_JavaUtilHashSet.add("CardHandler");
    jdField_a_of_type_JavaUtilHashSet.add("CreateFaceToFaceDiscussionActivity");
    jdField_a_of_type_JavaUtilHashSet.add("CrmIvr");
    jdField_a_of_type_JavaUtilHashSet.add("EnterpriseQQManager");
    jdField_a_of_type_JavaUtilHashSet.add("FlowCameraActivity2");
    jdField_a_of_type_JavaUtilHashSet.add("GeneralLBSConfigs");
    jdField_a_of_type_JavaUtilHashSet.add("IphoneTitleBarActivity");
    jdField_a_of_type_JavaUtilHashSet.add("LBSHandler");
    jdField_a_of_type_JavaUtilHashSet.add("LBSService.Groups");
    jdField_a_of_type_JavaUtilHashSet.add("Leba");
    jdField_a_of_type_JavaUtilHashSet.add("NearbyCmdHelper.Point");
    jdField_a_of_type_JavaUtilHashSet.add("NearbyTroopsView");
    jdField_a_of_type_JavaUtilHashSet.add("PersonalInfoReq");
    jdField_a_of_type_JavaUtilHashSet.add("PublicAccountChatPie");
    jdField_a_of_type_JavaUtilHashSet.add("PublicAccountManager");
    jdField_a_of_type_JavaUtilHashSet.add("PublicView");
    jdField_a_of_type_JavaUtilHashSet.add("QLifeCommentActivity");
    jdField_a_of_type_JavaUtilHashSet.add("QQCardService");
    jdField_a_of_type_JavaUtilHashSet.add("QQMapActivity");
    jdField_a_of_type_JavaUtilHashSet.add("QQSettingRedesign");
    jdField_a_of_type_JavaUtilHashSet.add("QQYPCityActivity");
    jdField_a_of_type_JavaUtilHashSet.add("Qwallet");
    jdField_a_of_type_JavaUtilHashSet.add("RealEventReq");
    jdField_a_of_type_JavaUtilHashSet.add("RecommendTroopView");
    jdField_a_of_type_JavaUtilHashSet.add("reqRawData");
    jdField_a_of_type_JavaUtilHashSet.add("SearchActivity");
    jdField_a_of_type_JavaUtilHashSet.add("SearchContacts");
    jdField_a_of_type_JavaUtilHashSet.add("SearchProtocol");
    jdField_a_of_type_JavaUtilHashSet.add("smartdevice:deviceinterface");
    jdField_a_of_type_JavaUtilHashSet.add("StatusServlet");
    jdField_a_of_type_JavaUtilHashSet.add("ThirdPayManager");
    jdField_a_of_type_JavaUtilHashSet.add("TroopFileHandler");
    jdField_a_of_type_JavaUtilHashSet.add("TroopNearByBigMapView");
    jdField_a_of_type_JavaUtilHashSet.add("VipMapRoamActivity");
    jdField_a_of_type_JavaUtilHashSet.add("webview");
    jdField_a_of_type_JavaUtilHashSet.add("HotChatHandler");
    jdField_a_of_type_JavaUtilHashSet.add("NearbyHandler");
    jdField_a_of_type_JavaUtilHashSet.add("MyBusinessServlet");
    jdField_a_of_type_JavaUtilHashSet.add("PublicAccountHandler");
    jdField_a_of_type_JavaUtilHashSet.add("NearbyProtocolCoder.Encounter");
    jdField_a_of_type_JavaUtilHashSet.add("LBSService");
    jdField_a_of_type_JavaUtilHashSet.add("LBSService.Encounter");
    jdField_a_of_type_JavaUtilHashSet.add("FreshNewsHandler");
    jdField_a_of_type_JavaUtilHashSet.add("LBSService.Groups");
    jdField_a_of_type_JavaUtilHashSet.add("GetNearbyRecommender");
    jdField_a_of_type_JavaUtilHashSet.add("LBSService.Point");
    jdField_a_of_type_JavaUtilHashSet.add("BizTroopHandler");
    jdField_a_of_type_JavaUtilHashSet.add("QQCardService");
    jdField_a_of_type_JavaUtilHashSet.add("DatingHandler");
    jdField_a_of_type_JavaUtilHashSet.add("NearbyCardHandler");
    jdField_a_of_type_JavaUtilHashSet.add("LbsMngLocationListener");
    jdField_a_of_type_JavaUtilHashSet.add("QWalletBaseProtocol");
    jdField_a_of_type_JavaUtilHashSet.add("buscardLocation");
    jdField_a_of_type_JavaUtilHashSet.add("NewFlowCameraActivity");
    jdField_a_of_type_JavaUtilHashSet.add("olympic");
    jdField_a_of_type_JavaUtilHashSet.add("NewStoryTakeVideoActivity");
    jdField_a_of_type_JavaUtilHashSet.add("PrecoverLbsConfig");
  }
  
  public void println(String paramString1, int paramInt, String paramString2)
  {
    if ((QLog.isColorLevel()) && (paramString2 != null))
    {
      String str = paramString2;
      if (paramString2.length() > 100) {
        str = paramString2.substring(0, 100);
      }
      QLog.d(paramString1, 2, str);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\soso\SosoInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */