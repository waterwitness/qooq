package com.tencent.mobileqq.msf.core;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.jce.wup.ObjectCreateException;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.a.a.a;
import com.tencent.mobileqq.msf.core.net.a.e;
import com.tencent.mobileqq.msf.core.net.f.b;
import com.tencent.mobileqq.msf.core.net.g;
import com.tencent.mobileqq.msf.core.net.h;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.l;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.msf.service.protocol.e.c;
import com.tencent.msf.service.protocol.pb.SSOLoginMerge.BusiBuffData;
import com.tencent.msf.service.protocol.pb.SSOLoginMerge.BusiBuffItem;
import com.tencent.msf.service.protocol.pb.SSOReserveField.ReserveFields;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class w
{
  public static ArrayList A;
  public static String D;
  public static String E;
  public static int F = 0;
  public static long H = -1L;
  public static int K = 0;
  public static long P = 0L;
  static int Q = -1;
  static AtomicBoolean R = new AtomicBoolean();
  public static final String T = "GrayUinPro.Check";
  public static final String U = "res";
  public static final int X = -10008;
  public static final int Y = -302;
  public static final int Z = 302;
  static CopyOnWriteArraySet aa = new CopyOnWriteArraySet();
  private static final AtomicInteger ai = new AtomicInteger();
  private static boolean aj = false;
  private static int am = 0;
  private static String an;
  private static String[] ao;
  private static AtomicBoolean aw = new AtomicBoolean();
  public static final String b = "__extraTimeoutSeq";
  public static final String o = "MSF.C.NetConnTag";
  public static boolean p;
  public static ConcurrentHashMap q = new ConcurrentHashMap();
  public static ConcurrentHashMap r = new ConcurrentHashMap();
  public static long s = -1L;
  public static int v = -1;
  public static int w;
  public static boolean x = true;
  public static long y = -1L;
  public static AtomicInteger z = new AtomicInteger(0);
  public a B = new a();
  MsfCore C;
  public com.tencent.mobileqq.msf.core.net.a.f G;
  c I = new c();
  long J;
  AtomicBoolean L = new AtomicBoolean();
  int M = 0;
  long N = 0L;
  long O = 0L;
  HashSet S = new HashSet();
  public int V = -1;
  public AtomicBoolean W = new AtomicBoolean();
  public h a;
  ArrayList ab = new ArrayList();
  boolean ac = false;
  private ConcurrentHashMap ad = new ConcurrentHashMap();
  private l ae = new l(1000);
  private l af = new l();
  private ToServiceMsg ag;
  private Handler ah;
  private int ak;
  private String al = "0";
  private HashSet ap = new HashSet();
  private volatile boolean aq;
  private Object ar = new Object();
  private long as;
  private byte[] at;
  private long au;
  private Random av = new Random(System.currentTimeMillis());
  public ConcurrentHashMap c = new ConcurrentHashMap();
  public ConcurrentHashMap d = new ConcurrentHashMap();
  b e = new b();
  public int f = 10;
  public int g = 3072;
  public int h;
  public int i = 500;
  public int j;
  public int k = 300;
  public long l;
  public boolean m;
  public volatile boolean n;
  public final String t = Environment.getExternalStorageDirectory().getPath() + "/tencent/MobileQQ/data/wifi";
  public SimpleDateFormat u = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
  
  static
  {
    A = new ArrayList();
    D = ":";
    E = "0";
    an = "";
    ao = new String[] { "StreamSvr.UploadStreamMsg" };
  }
  
  public w(MsfCore paramMsfCore)
  {
    this.C = paramMsfCore;
    HandlerThread localHandlerThread = new HandlerThread("mergehandle", 5);
    localHandlerThread.start();
    this.ah = new Handler(localHandlerThread.getLooper());
    this.ak = paramMsfCore.getMsfAppid();
    this.a = new h(paramMsfCore);
    this.I.setName("MsfCoreMsgSender");
    try
    {
      paramMsfCore = com.tencent.mobileqq.msf.core.a.a.c();
      if (paramMsfCore != null)
      {
        this.f = Integer.parseInt(paramMsfCore[0]);
        this.g = Integer.parseInt(paramMsfCore[1]);
        this.k = Integer.parseInt(paramMsfCore[2]);
        this.i = Integer.parseInt(paramMsfCore[3]);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "maxDelaySize: " + this.g + " noMergeSize: " + this.k + " globaldelayTime: " + this.i + " delayWaitSendCount: " + this.f);
        }
      }
      return;
    }
    catch (Exception paramMsfCore)
    {
      try
      {
        for (;;)
        {
          a(com.tencent.mobileqq.msf.core.a.a.d());
          try
          {
            this.j = Integer.parseInt(com.tencent.mobileqq.msf.core.a.a.e());
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "mergeDuration: " + this.j);
            }
            return;
          }
          catch (Exception paramMsfCore)
          {
            QLog.d("MSF.C.NetConnTag", 1, " " + paramMsfCore, paramMsfCore);
          }
          paramMsfCore = paramMsfCore;
          QLog.d("MSF.C.NetConnTag", 1, " " + paramMsfCore, paramMsfCore);
        }
      }
      catch (Exception paramMsfCore)
      {
        for (;;)
        {
          QLog.d("MSF.C.NetConnTag", 1, " " + paramMsfCore, paramMsfCore);
        }
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      aa.add(paramString);
      QLog.d("MSF.C.NetConnTag", 1, "use simple head for uin:" + MsfSdkUtils.getShortUin(paramString));
    }
    for (;;)
    {
      CodecWarpper.setUseSimpleHead(paramString, paramBoolean);
      return;
      aa.remove(paramString);
      QLog.d("MSF.C.NetConnTag", 1, "use full head for uin:" + MsfSdkUtils.getShortUin(paramString));
      if (q.containsKey(paramString))
      {
        q.remove(paramString);
        QLog.d("MSF.C.NetConnTag", 1, "clear storeSendSsoSeq tag for uin:" + MsfSdkUtils.getShortUin(paramString));
      }
    }
  }
  
  /* Error */
  private void b(android.content.Context paramContext)
  {
    // Byte code:
    //   0: getstatic 457	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   3: ifnull +58 -> 61
    //   6: getstatic 457	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   9: arraylength
    //   10: ifle +51 -> 61
    //   13: aload_0
    //   14: getfield 352	com/tencent/mobileqq/msf/core/w:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   17: getstatic 457	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   20: invokevirtual 458	com/tencent/mobileqq/msf/core/net/h:a	([Ljava/lang/String;)V
    //   23: invokestatic 375	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +34 -> 60
    //   29: ldc 66
    //   31: iconst_2
    //   32: new 230	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 460
    //   42: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: getstatic 457	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   48: invokestatic 465	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   51: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 389	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: return
    //   61: getstatic 468	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   64: ifnull +58 -> 122
    //   67: getstatic 468	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   70: arraylength
    //   71: ifle +51 -> 122
    //   74: aload_0
    //   75: getfield 352	com/tencent/mobileqq/msf/core/w:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   78: getstatic 468	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   81: invokevirtual 470	com/tencent/mobileqq/msf/core/net/h:b	([Ljava/lang/String;)V
    //   84: invokestatic 375	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq -27 -> 60
    //   90: ldc 66
    //   92: iconst_2
    //   93: new 230	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 460
    //   103: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: getstatic 457	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   109: invokestatic 465	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   112: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 389	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: return
    //   122: aload_1
    //   123: invokevirtual 475	android/content/Context:getPackageName	()Ljava/lang/String;
    //   126: astore_1
    //   127: new 239	java/io/File
    //   130: dup
    //   131: new 230	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   138: invokestatic 237	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   141: invokevirtual 243	java/io/File:getPath	()Ljava/lang/String;
    //   144: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 477
    //   150: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: ldc_w 479
    //   157: ldc_w 481
    //   160: invokevirtual 485	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   163: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc_w 487
    //   169: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 489	java/io/File:<init>	(Ljava/lang/String;)V
    //   178: astore_1
    //   179: new 491	java/util/Properties
    //   182: dup
    //   183: invokespecial 492	java/util/Properties:<init>	()V
    //   186: astore_3
    //   187: new 494	java/io/FileInputStream
    //   190: dup
    //   191: aload_1
    //   192: invokespecial 497	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   195: astore_2
    //   196: aload_2
    //   197: astore_1
    //   198: aload_3
    //   199: aload_2
    //   200: invokevirtual 501	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   203: aload_2
    //   204: astore_1
    //   205: aload_3
    //   206: ldc_w 503
    //   209: invokevirtual 506	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   212: astore 4
    //   214: aload_2
    //   215: astore_1
    //   216: aload_3
    //   217: ldc_w 508
    //   220: invokevirtual 506	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   223: astore_3
    //   224: aload_2
    //   225: astore_1
    //   226: aload 4
    //   228: ldc_w 510
    //   231: invokevirtual 514	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   234: putstatic 457	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   237: aload_2
    //   238: astore_1
    //   239: aload_3
    //   240: ldc_w 510
    //   243: invokevirtual 514	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   246: putstatic 468	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   249: aload_2
    //   250: astore_1
    //   251: aload_0
    //   252: getfield 352	com/tencent/mobileqq/msf/core/w:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   255: getstatic 457	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   258: invokevirtual 458	com/tencent/mobileqq/msf/core/net/h:a	([Ljava/lang/String;)V
    //   261: aload_2
    //   262: astore_1
    //   263: invokestatic 375	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq +36 -> 302
    //   269: aload_2
    //   270: astore_1
    //   271: ldc 66
    //   273: iconst_2
    //   274: new 230	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 516
    //   284: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: getstatic 457	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   290: invokestatic 465	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   293: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 389	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: aload_2
    //   303: astore_1
    //   304: aload_0
    //   305: getfield 352	com/tencent/mobileqq/msf/core/w:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   308: getstatic 468	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   311: invokevirtual 470	com/tencent/mobileqq/msf/core/net/h:b	([Ljava/lang/String;)V
    //   314: aload_2
    //   315: astore_1
    //   316: invokestatic 375	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +36 -> 355
    //   322: aload_2
    //   323: astore_1
    //   324: ldc 66
    //   326: iconst_2
    //   327: new 230	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   334: ldc_w 516
    //   337: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: getstatic 468	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   343: invokestatic 465	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   346: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 389	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: aload_2
    //   356: ifnull -296 -> 60
    //   359: aload_2
    //   360: invokevirtual 519	java/io/FileInputStream:close	()V
    //   363: return
    //   364: astore_1
    //   365: aload_1
    //   366: invokevirtual 522	java/lang/Exception:printStackTrace	()V
    //   369: return
    //   370: astore_3
    //   371: aconst_null
    //   372: astore_2
    //   373: aload_2
    //   374: astore_1
    //   375: aload_3
    //   376: invokevirtual 522	java/lang/Exception:printStackTrace	()V
    //   379: aload_2
    //   380: ifnull -320 -> 60
    //   383: aload_2
    //   384: invokevirtual 519	java/io/FileInputStream:close	()V
    //   387: return
    //   388: astore_1
    //   389: goto -24 -> 365
    //   392: astore_2
    //   393: aconst_null
    //   394: astore_1
    //   395: aload_1
    //   396: ifnull +7 -> 403
    //   399: aload_1
    //   400: invokevirtual 519	java/io/FileInputStream:close	()V
    //   403: aload_2
    //   404: athrow
    //   405: astore_1
    //   406: aload_1
    //   407: invokevirtual 522	java/lang/Exception:printStackTrace	()V
    //   410: goto -7 -> 403
    //   413: astore_2
    //   414: goto -19 -> 395
    //   417: astore_3
    //   418: goto -45 -> 373
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	this	w
    //   0	421	1	paramContext	android.content.Context
    //   195	189	2	localFileInputStream	java.io.FileInputStream
    //   392	12	2	localObject1	Object
    //   413	1	2	localObject2	Object
    //   186	54	3	localObject3	Object
    //   370	6	3	localException1	Exception
    //   417	1	3	localException2	Exception
    //   212	15	4	str	String
    // Exception table:
    //   from	to	target	type
    //   359	363	364	java/lang/Exception
    //   187	196	370	java/lang/Exception
    //   383	387	388	java/lang/Exception
    //   187	196	392	finally
    //   399	403	405	java/lang/Exception
    //   198	203	413	finally
    //   205	214	413	finally
    //   216	224	413	finally
    //   226	237	413	finally
    //   239	249	413	finally
    //   251	261	413	finally
    //   263	269	413	finally
    //   271	302	413	finally
    //   304	314	413	finally
    //   316	322	413	finally
    //   324	355	413	finally
    //   375	379	413	finally
    //   198	203	417	java/lang/Exception
    //   205	214	417	java/lang/Exception
    //   216	224	417	java/lang/Exception
    //   226	237	417	java/lang/Exception
    //   239	249	417	java/lang/Exception
    //   251	261	417	java/lang/Exception
    //   263	269	417	java/lang/Exception
    //   271	302	417	java/lang/Exception
    //   304	314	417	java/lang/Exception
    //   316	322	417	java/lang/Exception
    //   324	355	417	java/lang/Exception
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.a.b())
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Alive");
      localToServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setAppId(this.C.getMsfAppid());
      localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
      if (paramBoolean) {
        localToServiceMsg.setTimeout(com.tencent.mobileqq.msf.core.a.a.A());
      }
      for (;;)
      {
        a(localToServiceMsg);
        this.M = com.tencent.mobileqq.msf.core.a.a.G();
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.NetConnTag", 4, "send fast net detect Heartbeat msg ok");
        }
        if ((!paramBoolean) || (com.tencent.mobileqq.msf.core.a.a.O()))
        {
          this.N = System.currentTimeMillis();
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.NetConnTag", 1, "Update send heartbeat time: " + this.N);
          }
        }
        this.L.set(true);
        return;
        localToServiceMsg.setTimeout(10000L);
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.NetConnTag", 4, "conn is also closed.not need send heartbeat msg");
    }
    q();
  }
  
  public static boolean b(String paramString)
  {
    return aa.contains(paramString);
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i1 + 4);
    localByteBuffer.putInt(i1 + 4).put(paramArrayOfByte).flip();
    return localByteBuffer.array();
  }
  
  /* Error */
  private void c(android.content.Context paramContext)
  {
    // Byte code:
    //   0: getstatic 625	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   3: ifnull +75 -> 78
    //   6: getstatic 625	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   9: ldc -84
    //   11: invokevirtual 628	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifne +64 -> 78
    //   17: getstatic 625	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   20: invokestatic 633	com/tencent/mobileqq/msf/core/d:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/msf/core/d;
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 635	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   28: ifnull +10 -> 38
    //   31: aload_1
    //   32: invokevirtual 637	com/tencent/mobileqq/msf/core/d:d	()I
    //   35: ifgt +4 -> 39
    //   38: return
    //   39: aload_0
    //   40: getfield 352	com/tencent/mobileqq/msf/core/w:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   43: getstatic 625	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   46: invokevirtual 639	com/tencent/mobileqq/msf/core/net/h:a	(Ljava/lang/String;)V
    //   49: ldc 66
    //   51: iconst_1
    //   52: new 230	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   59: ldc_w 641
    //   62: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: getstatic 625	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   68: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 389	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: return
    //   78: aload_1
    //   79: invokevirtual 475	android/content/Context:getPackageName	()Ljava/lang/String;
    //   82: astore_1
    //   83: new 239	java/io/File
    //   86: dup
    //   87: new 230	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   94: invokestatic 237	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   97: invokevirtual 243	java/io/File:getPath	()Ljava/lang/String;
    //   100: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 477
    //   106: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_1
    //   110: ldc_w 479
    //   113: ldc_w 481
    //   116: invokevirtual 485	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   119: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc_w 643
    //   125: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokespecial 489	java/io/File:<init>	(Ljava/lang/String;)V
    //   134: astore_1
    //   135: new 491	java/util/Properties
    //   138: dup
    //   139: invokespecial 492	java/util/Properties:<init>	()V
    //   142: astore 4
    //   144: aload_1
    //   145: invokevirtual 646	java/io/File:exists	()Z
    //   148: ifeq +242 -> 390
    //   151: new 494	java/io/FileInputStream
    //   154: dup
    //   155: aload_1
    //   156: invokespecial 497	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   159: astore_2
    //   160: aload_2
    //   161: astore_1
    //   162: aload 4
    //   164: aload_2
    //   165: invokevirtual 501	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   168: aload_2
    //   169: astore_1
    //   170: aload_2
    //   171: invokevirtual 519	java/io/FileInputStream:close	()V
    //   174: aload_2
    //   175: ifnull +7 -> 182
    //   178: aload_2
    //   179: invokevirtual 519	java/io/FileInputStream:close	()V
    //   182: iconst_0
    //   183: ifeq +11 -> 194
    //   186: new 648	java/lang/NullPointerException
    //   189: dup
    //   190: invokespecial 649	java/lang/NullPointerException:<init>	()V
    //   193: athrow
    //   194: aload 4
    //   196: ldc_w 651
    //   199: invokevirtual 506	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   202: astore_2
    //   203: aload_2
    //   204: ifnull -166 -> 38
    //   207: aload_2
    //   208: invokevirtual 654	java/lang/String:trim	()Ljava/lang/String;
    //   211: invokevirtual 657	java/lang/String:length	()I
    //   214: ifle -176 -> 38
    //   217: aload_2
    //   218: invokestatic 633	com/tencent/mobileqq/msf/core/d:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/msf/core/d;
    //   221: astore_1
    //   222: aload_1
    //   223: invokevirtual 635	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   226: ifnull -188 -> 38
    //   229: aload_1
    //   230: invokevirtual 637	com/tencent/mobileqq/msf/core/d:d	()I
    //   233: ifle -195 -> 38
    //   236: aload_2
    //   237: invokevirtual 654	java/lang/String:trim	()Ljava/lang/String;
    //   240: ldc_w 402
    //   243: ldc -84
    //   245: invokevirtual 485	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   248: astore_1
    //   249: aload_0
    //   250: getfield 352	com/tencent/mobileqq/msf/core/w:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   253: aload_1
    //   254: invokevirtual 639	com/tencent/mobileqq/msf/core/net/h:a	(Ljava/lang/String;)V
    //   257: ldc 66
    //   259: iconst_1
    //   260: new 230	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   267: ldc_w 659
    //   270: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_1
    //   274: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 389	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: return
    //   284: astore_3
    //   285: aconst_null
    //   286: astore_2
    //   287: aload_2
    //   288: astore_1
    //   289: aload_3
    //   290: invokevirtual 522	java/lang/Exception:printStackTrace	()V
    //   293: aload_2
    //   294: ifnull +7 -> 301
    //   297: aload_2
    //   298: invokevirtual 519	java/io/FileInputStream:close	()V
    //   301: iconst_0
    //   302: ifeq -108 -> 194
    //   305: new 648	java/lang/NullPointerException
    //   308: dup
    //   309: invokespecial 649	java/lang/NullPointerException:<init>	()V
    //   312: athrow
    //   313: astore_1
    //   314: aload_1
    //   315: invokevirtual 660	java/io/IOException:printStackTrace	()V
    //   318: goto -124 -> 194
    //   321: astore_2
    //   322: aconst_null
    //   323: astore_1
    //   324: aload_1
    //   325: ifnull +7 -> 332
    //   328: aload_1
    //   329: invokevirtual 519	java/io/FileInputStream:close	()V
    //   332: iconst_0
    //   333: ifeq +11 -> 344
    //   336: new 648	java/lang/NullPointerException
    //   339: dup
    //   340: invokespecial 649	java/lang/NullPointerException:<init>	()V
    //   343: athrow
    //   344: aload_2
    //   345: athrow
    //   346: astore_1
    //   347: aload_1
    //   348: invokevirtual 660	java/io/IOException:printStackTrace	()V
    //   351: goto -19 -> 332
    //   354: astore_1
    //   355: aload_1
    //   356: invokevirtual 660	java/io/IOException:printStackTrace	()V
    //   359: goto -15 -> 344
    //   362: astore_1
    //   363: aload_1
    //   364: invokevirtual 660	java/io/IOException:printStackTrace	()V
    //   367: goto -66 -> 301
    //   370: astore_1
    //   371: aload_1
    //   372: invokevirtual 660	java/io/IOException:printStackTrace	()V
    //   375: goto -193 -> 182
    //   378: astore_1
    //   379: goto -65 -> 314
    //   382: astore_2
    //   383: goto -59 -> 324
    //   386: astore_3
    //   387: goto -100 -> 287
    //   390: aconst_null
    //   391: astore_2
    //   392: goto -218 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	w
    //   0	395	1	paramContext	android.content.Context
    //   159	139	2	localObject1	Object
    //   321	24	2	localObject2	Object
    //   382	1	2	localObject3	Object
    //   391	1	2	localObject4	Object
    //   284	6	3	localException1	Exception
    //   386	1	3	localException2	Exception
    //   142	53	4	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   144	160	284	java/lang/Exception
    //   305	313	313	java/io/IOException
    //   144	160	321	finally
    //   328	332	346	java/io/IOException
    //   336	344	354	java/io/IOException
    //   297	301	362	java/io/IOException
    //   178	182	370	java/io/IOException
    //   186	194	378	java/io/IOException
    //   162	168	382	finally
    //   170	174	382	finally
    //   289	293	382	finally
    //   162	168	386	java/lang/Exception
    //   170	174	386	java/lang/Exception
  }
  
  public static void c(String paramString)
  {
    an = paramString;
  }
  
  public static void d()
  {
    Iterator localIterator = aa.iterator();
    while (localIterator.hasNext()) {
      CodecWarpper.setUseSimpleHead((String)localIterator.next(), false);
    }
    aa.clear();
  }
  
  public static void d(int paramInt)
  {
    am = paramInt;
  }
  
  private void d(String paramString)
  {
    QLog.setUIN_REPORTLOG_LEVEL(Integer.parseInt(paramString));
  }
  
  public static byte[] f(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      int i2 = com.tencent.mobileqq.msf.core.a.a.bb();
      int i1 = i2;
      if (i2 < 1) {
        i1 = 1;
      }
      i2 = (int)(Math.random() * 100.0D);
      if ((paramToServiceMsg.getServiceCmd().equals("MessageSvc.PbGetMsg")) && (i2 % i1 == i1 - 1))
      {
        SSOReserveField.ReserveFields localReserveFields = new SSOReserveField.ReserveFields();
        paramToServiceMsg = (String)paramToServiceMsg.getAttribute("sso_push_timestamp");
        if (paramToServiceMsg != null)
        {
          String[] arrayOfString = paramToServiceMsg.split("\\|");
          String str1 = Build.MODEL.replace('\n', '-');
          i1 = Build.VERSION.SDK_INT;
          String str2 = Build.DISPLAY;
          String str3 = Build.MANUFACTURER;
          if (arrayOfString.length == 3)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("model:" + str1 + ";");
            localStringBuilder.append("os:" + i1 + ";");
            localStringBuilder.append("version:v2");
            if (com.tencent.mobileqq.msf.core.a.a.bh())
            {
              localStringBuilder.append("man:" + str3);
              localStringBuilder.append("sys:" + str2);
            }
            localReserveFields.sso_send.set(Long.parseLong(arrayOfString[0]));
            localReserveFields.sdk_recv.set(Long.parseLong(arrayOfString[1]));
            localReserveFields.app_recv.set(Long.parseLong(arrayOfString[2]));
            localReserveFields.sdk_send.set(System.currentTimeMillis());
            localReserveFields.type.set(v);
            localReserveFields.extra.set(localStringBuilder.toString());
          }
          QLog.d("MSF.C.NetConnTag", 1, "msf get timestamp:" + paramToServiceMsg + ", length:" + arrayOfString.length + ", model:" + str1 + ", type:" + v);
          paramToServiceMsg = localReserveFields.toByteArray();
          return paramToServiceMsg;
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.d("MSF.C.NetConnTag", 1, "failed to construct reserve field", paramToServiceMsg);
    }
    return null;
  }
  
  private int h(ToServiceMsg paramToServiceMsg)
  {
    Object localObject1;
    long l1;
    if (paramToServiceMsg.isNeedCallback())
    {
      this.c.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
      paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(ai.incrementAndGet()));
      if (paramToServiceMsg.getTimeout() == -1L)
      {
        paramToServiceMsg.setTimeout(30000L);
        localObject1 = this.C.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
        if (("LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))) {
          QLog.d("MSF.C.NetConnTag", 1, "Sender PicUpMsg timer start, appSeq: " + paramToServiceMsg.getAppSeq() + ", delayMillis: " + paramToServiceMsg.getTimeout());
        }
        paramToServiceMsg.addAttribute("to_timeoutCallbacker", localObject1);
        if (com.tencent.mobileqq.msf.core.a.a.w())
        {
          l1 = paramToServiceMsg.getTimeout() - com.tencent.mobileqq.msf.core.a.a.y();
          if (l1 > 0L) {
            paramToServiceMsg.addAttribute("to_predetect_timeoutCallbacker", this.C.msfAlarmer.b(paramToServiceMsg, l1));
          }
        }
        if ((com.tencent.mobileqq.msf.core.a.a.Y()) && (this.C.quicksender != null) && (this.C.quicksender.b(paramToServiceMsg)))
        {
          QLog.d("MSF.C.NetConnTag", 1, "add quick send timeout check " + paramToServiceMsg.getRequestSsoSeq());
          if ((this.a.b()) && (this.a.o() != null) && (this.a.o().B != null)) {
            paramToServiceMsg.getAttributes().put("connIDC", this.a.o().B.j);
          }
          this.C.quicksender.c(paramToServiceMsg);
        }
      }
    }
    for (;;)
    {
      try
      {
        this.C.quicksender.c.a(paramToServiceMsg);
        if (this.ae.offer(paramToServiceMsg)) {
          break label599;
        }
        QLog.d("MSF.C.NetConnTag", 1, "error, add " + paramToServiceMsg + " to send queue is full! size: " + this.ae.size());
        if (paramToServiceMsg.getServiceCmd().equals("SSO.LoginMerge")) {
          break label523;
        }
        localObject1 = n.a(paramToServiceMsg);
        ((FromServiceMsg)localObject1).setBusinessFail(1008, "send queue is full!");
        this.C.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject1);
        if ((!R.get()) && (f.b))
        {
          R.set(true);
          Q = paramToServiceMsg.getRequestSsoSeq();
        }
        return paramToServiceMsg.getRequestSsoSeq();
        localObject1 = this.C.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
      }
      if (paramToServiceMsg.getServiceCmd().equals("SSO.LoginMerge"))
      {
        this.C.msfAlarmer.a(paramToServiceMsg.getRequestSsoSeq(), 30000L);
        continue;
        label523:
        Object localObject2 = (ArrayList)this.ad.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
        if (localObject2 != null)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            ToServiceMsg localToServiceMsg = (ToServiceMsg)((Iterator)localObject2).next();
            FromServiceMsg localFromServiceMsg = n.a(localToServiceMsg);
            localFromServiceMsg.setBusinessFail(1008, "send queue is full!");
            this.C.addRespToQuque(localToServiceMsg, localFromServiceMsg);
          }
          continue;
          label599:
          if (this.ad.contains(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))) {
            this.ad.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.NetConnTag", 4, "add " + paramToServiceMsg + " to sendQueue");
          }
          l1 = SystemClock.elapsedRealtime();
          if (l1 - this.as >= 300000L)
          {
            this.as = l1;
            if (QLog.isColorLevel()) {
              r();
            }
          }
        }
      }
    }
  }
  
  public static int i()
  {
    return am;
  }
  
  private void i(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getUin().equals("0")) {}
    int i1;
    do
    {
      return;
      int i2 = 0;
      i1 = i2;
      if (!this.S.contains(paramToServiceMsg.getUin()))
      {
        this.au += 1L;
        if (this.au >= 2L)
        {
          i1 = i2;
          if (this.av.nextInt(20) >= 2) {}
        }
        else
        {
          i1 = 1;
        }
      }
    } while (i1 == 0);
    a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin());
  }
  
  public static String j()
  {
    return an;
  }
  
  private void p()
  {
    if (this.a.b())
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Alive");
      localToServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setAppId(this.C.getMsfAppid());
      localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
      localToServiceMsg.setTimeout(com.tencent.mobileqq.msf.core.a.a.y());
      a(localToServiceMsg);
      this.M += 1;
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.NetConnTag", 4, "send Heartbeat msg ok");
      }
      this.N = System.currentTimeMillis();
      this.L.set(true);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.NetConnTag", 4, "conn is also closed.not need send heartbeat msg");
    }
    q();
  }
  
  private void q()
  {
    this.M = 0;
    this.L.set(false);
  }
  
  private void r()
  {
    boolean bool2 = false;
    try
    {
      for (ThreadGroup localThreadGroup = Thread.currentThread().getThreadGroup(); localThreadGroup.getParent() != null; localThreadGroup = localThreadGroup.getParent()) {}
      Thread[] arrayOfThread = new Thread[localThreadGroup.activeCount()];
      localThreadGroup.enumerate(arrayOfThread);
      int i2 = this.ae.size();
      int i3 = arrayOfThread.length;
      int i1 = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i1 < i3)
        {
          localThreadGroup = arrayOfThread[i1];
          if ((localThreadGroup != null) && ("MsfCoreMsgSender".equals(localThreadGroup.getName()))) {
            bool1 = true;
          }
        }
        else
        {
          QLog.d("MSF.C.NetConnTag", 1, "sender alive:" + bool1 + " size: " + i2);
          return;
        }
        i1 += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.NetConnTag", 1, "printCurrentThreads error", localException);
    }
  }
  
  public int a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getRequestSsoSeq() == -1) {
      paramToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    }
    paramToServiceMsg.addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
    Runnable localRunnable;
    if (paramToServiceMsg.isNeedCallback())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "add " + paramToServiceMsg + " to send");
      }
      this.c.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
      paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(ai.incrementAndGet()));
      if (paramToServiceMsg.getTimeout() != -1L) {
        break label165;
      }
      paramToServiceMsg.setTimeout(30000L);
      localRunnable = this.C.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
    }
    for (;;)
    {
      paramToServiceMsg.addAttribute("to_timeoutCallbacker", localRunnable);
      try
      {
        this.ae.a(paramToServiceMsg);
        return paramToServiceMsg.getRequestSsoSeq();
        label165:
        localRunnable = this.C.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("MSF.C.NetConnTag", 1, "inset heartbeatMsg error. " + localException, localException);
        }
      }
    }
  }
  
  public Runnable a(int paramInt)
  {
    long l1 = com.tencent.mobileqq.msf.core.a.a.z();
    if (l1 > 0L) {
      return this.C.msfAlarmer.b(paramInt, l1);
    }
    b(paramInt);
    return null;
  }
  
  public void a(int paramInt, String paramString)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setRequestId(MsfCore.getNextSeq());
    localUniPacket.setServantName("KQQ.ConfigService.ConfigServantObj");
    localUniPacket.setFuncName("ClientReq");
    Object localObject = new c();
    ((c)localObject).a = paramInt;
    ((c)localObject).b = paramString;
    localUniPacket.put("req", localObject);
    localObject = new ToServiceMsg("", paramString, "GrayUinPro.Check");
    ((ToServiceMsg)localObject).setAppId(paramInt);
    ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
    ((ToServiceMsg)localObject).putWupBuffer(localUniPacket.encode());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).setMsfCommand(MsfCommand.checkRole);
    b((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "role send gray check for " + paramString + " use " + paramInt + " to:" + localObject);
    }
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    this.a.a(parama);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getResultCode() == 1000) {
      this.S.add(paramFromServiceMsg.getUin());
    }
    label331:
    for (;;)
    {
      try
      {
        Object localObject1 = paramFromServiceMsg.getWupBuffer();
        if ((localObject1.length <= 4) || (localObject1[0] != 0) || (localObject1[1] != 0) || (localObject1[2] != 0) || (localObject1[3] != 4)) {
          break label331;
        }
        Object localObject2 = new byte[localObject1.length - 4];
        System.arraycopy(localObject1, 4, localObject2, 0, localObject2.length);
        localObject1 = localObject2;
        QLog.d("MSF.C.NetConnTag", 1, "recv buf:" + HexUtil.bytes2HexStr((byte[])localObject1));
        localObject2 = new UniPacket();
        ((UniPacket)localObject2).decode((byte[])localObject1);
        localObject1 = (com.tencent.msf.service.protocol.e.d)((UniPacket)localObject2).getByClass("res", new com.tencent.msf.service.protocol.e.d());
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.NetConnTag", 4, "role received gray resp uin:" + paramFromServiceMsg.getUin() + " appid:" + paramFromServiceMsg.getAppId() + " status:" + ((com.tencent.msf.service.protocol.e.d)localObject1).a + " yyb:" + ((com.tencent.msf.service.protocol.e.d)localObject1).b + " msg:" + HexUtil.bytes2HexStr(((com.tencent.msf.service.protocol.e.d)localObject1).c));
        }
        if (((com.tencent.msf.service.protocol.e.d)localObject1).a == 1)
        {
          this.C.getSsoRespHandler();
          y.a.put(paramFromServiceMsg.getUin(), localObject1);
          this.C.getAccountCenter().l(paramFromServiceMsg.getUin());
          return;
        }
        y.a.remove(paramFromServiceMsg.getUin());
        return;
      }
      catch (ObjectCreateException paramFromServiceMsg)
      {
        if (!QLog.isDevelopLevel()) {
          break;
        }
      }
      QLog.d("MSF.C.NetConnTag", 4, "role gray check error", paramFromServiceMsg);
      return;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("MSF.C.NetConnTag", 4, "role gray check fail " + paramFromServiceMsg);
      return;
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    if (paramFromServiceMsg.getBusinessFailCode() == 1002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "handleHeartbeat wait " + paramToServiceMsg + " timeout.");
      }
      if (!this.a.b())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "conn is also closed.");
        }
        q();
      }
      do
      {
        return;
        if (this.M < com.tencent.mobileqq.msf.core.a.a.G()) {
          break;
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "Heartbeat continueTimeoutCount is " + this.M + ",try close conn");
          }
          this.C.sender.a.a(com.tencent.qphone.base.a.p);
          q();
          return;
        }
        catch (Exception paramFromServiceMsg) {}
      } while (!QLog.isColorLevel());
      QLog.d("MSF.C.NetConnTag", 2, paramFromServiceMsg.toString(), paramFromServiceMsg);
      return;
      long l1 = System.currentTimeMillis();
      if (l1 - this.N > com.tencent.mobileqq.msf.core.a.a.G() * com.tencent.mobileqq.msf.core.a.a.y())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "timenow - firstSendHeartBeatTime is " + (l1 - this.N) + ",try close conn");
        }
        this.C.sender.a.a(com.tencent.qphone.base.a.e);
        q();
        return;
      }
      p();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "recv heart resp.now conn is alive.");
    }
    q();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    paramToServiceMsg.getAttributes().put("_attr_regprxy_socket_hashcode", new Integer(paramInt));
    this.ag = paramToServiceMsg;
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.C.msfAlarmer.b(paramRunnable);
    }
  }
  
  public void a(String paramString)
  {
    CodecWarpper.nateiveRemoveAccountKey(paramString);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (-1L == s) {
      s = System.currentTimeMillis();
    }
    String str2 = com.tencent.mobileqq.msf.core.a.d.c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "unknown";
    }
    int i1;
    if (r.containsKey(str1))
    {
      i1 = ((Integer)r.get(str1)).intValue();
      if (i1 < com.tencent.mobileqq.msf.core.a.a.aV())
      {
        r.remove(str1);
        r.put(str1, Integer.valueOf(i1 + 1));
        i1 = 1;
      }
    }
    for (;;)
    {
      if (i1 != 0) {
        new d(paramString, str1, paramLong).run();
      }
      return;
      QLog.d("MSF.C.NetConnTag", 1, "single ssid " + str1 + " record times limited in " + i1);
      i1 = 0;
      continue;
      r.put(str1, Integer.valueOf(1));
      i1 = 1;
    }
  }
  
  public void a(HashMap paramHashMap)
  {
    this.ab.add(paramHashMap);
    this.ac = true;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "add waitReportData " + this.ab.size());
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.at = paramArrayOfByte;
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int i2 = paramArrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = paramArrayOfString[i1];
        this.ap.add(str);
        i1 += 1;
      }
    }
    this.ap.add("GrayUinPro.Check");
    this.ap.add("StatSvc.register");
    this.ap.add("StatSvc.get");
    this.ap.add("RegPrxySvc.infoLogin");
    this.ap.add("RegPrxySvc.infoSync");
    this.ap.add("wtlogin.login");
    this.ap.add("RegPrxySvc.getOffMsg");
    this.ap.add("login.auth");
    this.ap.add("wtlogin.exchange");
    this.ap.add("wtlogin.trans_emp");
    this.ap.add("MessageSvc.PbSendMsg");
    this.ap.add("LongConn.OffPicUp");
    this.ap.add("LongConn.OffPicDown");
    this.ap.add("ImgStore.GroupPicUp");
    this.ap.add("ImgStore.GroupPicDown");
    this.ap.add("StreamSvr.UploadStreamMsg");
    this.ap.add("StreamSvr.RespUploadStreamMsg");
    this.ap.add("StreamSvr.PushStreamMsg");
    this.ap.add("StreamSvr.RespPushStreamMsg");
    this.ap.add("OidbSvc.0x787_1");
    this.ap.add("OidbSvc.0x49d_107");
    this.ap.add("MultiMsg.ApplyUp");
    this.ap.add("MultiMsg.ApplyDown");
    this.ap.add("PttCenterSvr.ShortVideoUpReq");
    this.ap.add("PttCenterSvr.ShortVideoDownReq");
    this.ap.add("ImgStore.GroupPicUp#pttGu");
    this.ap.add("ImgStore.GroupPicDown#pttGd");
    this.ap.add("PttStore.GroupPttUp");
    this.ap.add("PttStore.GroupPttDown");
    this.ap.add("Heartbeat.Alive");
    this.ap.add("friendlist.getFriendGroupList");
    this.ap.add("VideoSvc.Send");
    this.ap.add("VideoSvc.Ack");
    this.ap.add("SharpSvr.c2s");
    this.ap.add("SharpSvr.c2sack");
    this.ap.add("SharpSvr.s2c");
    this.ap.add("SharpSvr.s2cack");
    this.ap.add("MultiVideo.c2s");
    this.ap.add("MultiVideo.c2sack");
    this.ap.add("MultiVideo.s2c");
    this.ap.add("MultiVideo.s2cack");
    this.ap.add("MessageSvc.PbGetMsg");
    this.ap.add("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200");
    this.ap.add("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500");
    this.ap.add("OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_APPLY_DOWNLOAD-1200");
    this.ap.add("cmd_openConn");
    this.ap.add("wtlogin.exchange_emp");
    this.ap.add("wtlogin.name2uin");
    this.ap.add("Client.CorrectTime");
    this.ap.add("StatSvc.RspMSFForceOffline");
  }
  
  public boolean a()
  {
    return this.c.isEmpty();
  }
  
  /* Error */
  public boolean a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 1317	com/tencent/mobileqq/msf/core/a/a:aE	()Z
    //   3: ifeq +23 -> 26
    //   6: aload_0
    //   7: new 1319	com/tencent/mobileqq/msf/core/net/a/f
    //   10: dup
    //   11: aload_0
    //   12: getfield 317	com/tencent/mobileqq/msf/core/w:C	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   15: aload_1
    //   16: invokespecial 1322	com/tencent/mobileqq/msf/core/net/a/f:<init>	(Lcom/tencent/mobileqq/msf/core/MsfCore;Landroid/content/Context;)V
    //   19: putfield 1324	com/tencent/mobileqq/msf/core/w:G	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   22: iconst_1
    //   23: putstatic 1326	com/tencent/mobileqq/msf/core/w:p	Z
    //   26: ldc 66
    //   28: iconst_1
    //   29: ldc_w 1328
    //   32: invokestatic 389	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 272	com/tencent/mobileqq/msf/core/w:B	Lcom/tencent/mobileqq/msf/core/w$a;
    //   39: aload_1
    //   40: iconst_0
    //   41: invokevirtual 1332	com/tencent/mobileqq/msf/core/w$a:init	(Landroid/content/Context;Z)V
    //   44: aload_0
    //   45: getfield 317	com/tencent/mobileqq/msf/core/w:C	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   48: invokevirtual 1134	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   51: invokevirtual 1334	com/tencent/mobileqq/msf/core/auth/b:f	()[B
    //   54: invokestatic 1337	com/tencent/qphone/base/util/CodecWarpper:setKsid	([B)V
    //   57: aload_0
    //   58: getfield 277	com/tencent/mobileqq/msf/core/w:I	Lcom/tencent/mobileqq/msf/core/w$c;
    //   61: invokevirtual 1338	com/tencent/mobileqq/msf/core/w$c:start	()V
    //   64: invokestatic 1344	com/tencent/mobileqq/msf/core/MsfStore:getNativeConfigStore	()Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   67: ldc_w 1346
    //   70: invokevirtual 1351	com/tencent/msf/boot/config/NativeConfigStore:getConfig	(Ljava/lang/String;)Ljava/lang/String;
    //   73: astore_1
    //   74: aload_1
    //   75: ifnull +68 -> 143
    //   78: aload_1
    //   79: invokevirtual 657	java/lang/String:length	()I
    //   82: ifle +61 -> 143
    //   85: invokestatic 1344	com/tencent/mobileqq/msf/core/MsfStore:getNativeConfigStore	()Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   88: ldc_w 1353
    //   91: invokevirtual 1351	com/tencent/msf/boot/config/NativeConfigStore:getConfig	(Ljava/lang/String;)Ljava/lang/String;
    //   94: astore_2
    //   95: aload_2
    //   96: ifnull +99 -> 195
    //   99: aload_2
    //   100: invokevirtual 657	java/lang/String:length	()I
    //   103: ifle +92 -> 195
    //   106: aload_2
    //   107: invokestatic 754	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   110: lstore_3
    //   111: invokestatic 302	java/lang/System:currentTimeMillis	()J
    //   114: lload_3
    //   115: lsub
    //   116: ldc2_w 1354
    //   119: lcmp
    //   120: ifle +39 -> 159
    //   123: new 1357	com/tencent/mobileqq/msf/core/x
    //   126: dup
    //   127: aload_0
    //   128: invokespecial 1358	com/tencent/mobileqq/msf/core/x:<init>	(Lcom/tencent/mobileqq/msf/core/w;)V
    //   131: astore_1
    //   132: aload_1
    //   133: ldc_w 1360
    //   136: invokevirtual 1361	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   139: aload_1
    //   140: invokevirtual 1362	java/lang/Thread:start	()V
    //   143: iconst_1
    //   144: ireturn
    //   145: astore_2
    //   146: ldc 66
    //   148: iconst_1
    //   149: ldc_w 1364
    //   152: aload_2
    //   153: invokestatic 408	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   156: goto -130 -> 26
    //   159: aload_0
    //   160: aload_1
    //   161: invokespecial 1366	com/tencent/mobileqq/msf/core/w:d	(Ljava/lang/String;)V
    //   164: iconst_1
    //   165: ireturn
    //   166: astore_1
    //   167: ldc 66
    //   169: iconst_1
    //   170: new 230	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 1368
    //   180: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_1
    //   184: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 389	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: iconst_1
    //   194: ireturn
    //   195: invokestatic 1344	com/tencent/mobileqq/msf/core/MsfStore:getNativeConfigStore	()Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   198: ldc_w 1353
    //   201: invokestatic 302	java/lang/System:currentTimeMillis	()J
    //   204: invokestatic 1371	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   207: invokevirtual 1375	com/tencent/msf/boot/config/NativeConfigStore:setConfig	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload_0
    //   211: aload_1
    //   212: invokespecial 1366	com/tencent/mobileqq/msf/core/w:d	(Ljava/lang/String;)V
    //   215: iconst_1
    //   216: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	w
    //   0	217	1	paramContext	android.content.Context
    //   94	13	2	str	String
    //   145	8	2	localThrowable	Throwable
    //   110	5	3	l1	long
    // Exception table:
    //   from	to	target	type
    //   0	26	145	java/lang/Throwable
    //   64	74	166	java/lang/Exception
    //   78	95	166	java/lang/Exception
    //   99	143	166	java/lang/Exception
    //   159	164	166	java/lang/Exception
    //   195	215	166	java/lang/Exception
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return false;
    }
    if (paramToServiceMsg.getMsfCommand() == MsfCommand.msf_ssoping)
    {
      this.C.sender.a.o().f();
      this.C.sender.a.a(com.tencent.qphone.base.a.B);
      return false;
    }
    if (paramToServiceMsg.getMsfCommand() == MsfCommand.msf_oshello)
    {
      QLog.d("MSF.C.NetConnTag", 1, "cannot get os hello response");
      return false;
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.isNeedRemindSlowNetwork())) {
      com.tencent.mobileqq.msf.core.net.f.a(f.b.a);
    }
    paramToServiceMsg.addAttribute("_tag_socket_connerror", h.H);
    paramFromServiceMsg.addAttribute("_tag_socket_connerror", h.H);
    if (paramToServiceMsg.getAttributes().containsKey("_tag_socket")) {
      paramFromServiceMsg.addAttribute("_tag_socket", paramToServiceMsg.getAttribute("_tag_socket"));
    }
    if ((p) && (com.tencent.mobileqq.msf.core.net.a.f.a())) {}
    long l1;
    long l2;
    try
    {
      this.G.b().a(paramToServiceMsg.getRequestSsoSeq(), true);
      if (paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net"))
      {
        l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
        l3 = System.currentTimeMillis();
        if (paramToServiceMsg.getAttributes().containsKey("__timestamp_addSendQueue")) {
          l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
        }
      }
    }
    catch (Exception localException2)
    {
      try
      {
        label229:
        if (paramToServiceMsg.getServiceCmd().equals("MessageSvc.PbGetMsg")) {
          this.C.statReporter.a("dim.Msf.PushSendFail", false, 0L, 0L, null, false, false);
        }
      }
      catch (Exception localException2)
      {
        try
        {
          while (paramToServiceMsg.getServiceCmd() == com.tencent.mobileqq.msf.core.push.d.j)
          {
            long l4 = ((Long)paramToServiceMsg.getAttribute("_attr_alarm_elapsed_time", Long.valueOf(0L))).longValue();
            if ((com.tencent.mobileqq.msf.core.a.a.u) && (l4 > com.tencent.mobileqq.msf.core.a.a.bj()) && (l2 >= this.a.o().c()))
            {
              String str = paramToServiceMsg.getUin();
              if (str != null) {
                if ((!com.tencent.mobileqq.msf.core.a.a.v) || (Long.parseLong(str) % 2L == 0L))
                {
                  QLog.d("MSF.C.NetConnTag", 1, "try close conn by wakeup alarm exceeded and detect timeout:" + l4);
                  this.C.sender.a.a(com.tencent.qphone.base.a.E);
                  this.C.getStatReporter().a("3", str, true, 0L);
                  return false;
                  localException1 = localException1;
                  QLog.d("MSF.C.NetConnTag", 1, "adaptor recv timeout failed", localException1);
                  continue;
                  localException2 = localException2;
                  QLog.d("MSF.C.NetConnTag", 1, "", localException2);
                }
                else
                {
                  this.C.pushManager.C = SystemClock.elapsedRealtime();
                  QLog.d("MSF.C.NetConnTag", 1, "wakeup alarm exceeded and detect timeout, but not close conn");
                }
              }
            }
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            long l3;
            QLog.d("MSF.C.NetConnTag", 1, "SimpleGet timeout error!", localException3);
          }
        }
        if ((l2 != 0L) && (l3 - l2 > paramToServiceMsg.getTimeout()) && (l3 - l2 > this.C.pushManager.e()) && (paramToServiceMsg.getTimeout() < this.C.pushManager.e()))
        {
          if (l2 >= this.a.o().c())
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "xiaomi 2s: " + paramToServiceMsg.getRequestSsoSeq() + " msg timeout , addtoqueueTime is " + (l3 - l2) + ",try close conn");
            }
            this.C.sender.a.a(com.tencent.qphone.base.a.q);
            q();
            return true;
          }
          return true;
        }
        if ((l1 == 0L) || (l1 > this.a.o().c()))
        {
          if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive)
          {
            QLog.d("MSF.C.NetConnTag", 1, "found timeout heartalive msg " + paramToServiceMsg.getRequestSsoSeq());
            a(paramFromServiceMsg, paramToServiceMsg);
            return false;
          }
          if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_QuickHeartBeat)
          {
            QLog.d("MSF.C.NetConnTag", 1, "found timeout quickheartbeat msg " + paramToServiceMsg.getRequestSsoSeq());
            this.C.quicksender.a(paramToServiceMsg, paramFromServiceMsg, false);
            return false;
          }
          try
          {
            if ((this.L.get()) && (System.currentTimeMillis() - this.N < com.tencent.mobileqq.msf.core.a.a.M() + 120000)) {
              break label949;
            }
            l1 = System.currentTimeMillis();
            if (l1 - this.N <= com.tencent.mobileqq.msf.core.a.a.M()) {
              break label894;
            }
            if (paramToServiceMsg.getRequestSsoSeq() == Q)
            {
              Q = -1;
              QLog.d("MSF.C.NetConnTag", 1, "found first msg screen on timeout try close conn " + paramToServiceMsg);
              this.C.sender.a.a(com.tencent.qphone.base.a.t);
              q();
              return true;
            }
          }
          finally {}
          if (com.tencent.mobileqq.msf.core.a.a.bk()) {
            p();
          }
        }
        for (;;)
        {
          if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_HeartbeatAlive) {
            break label1028;
          }
          return false;
          label894:
          QLog.d("MSF.C.NetConnTag", 1, "found timeout msg check time: timenow = " + l1 + " firstSendHeartBeatTime = " + this.N + " ConfigManager.getHeartBeatTimeInterval() = " + com.tencent.mobileqq.msf.core.a.a.M());
          break;
          label949:
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MSF.C.NetConnTag", 2, "sendingHeartBeat: " + this.L + "net detect has started, no need sendHeartbeat");
          break;
          QLog.d("MSF.C.NetConnTag", 1, "found timeout msg " + paramToServiceMsg + " before connSucc.");
        }
        label1028:
        if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_QuickHeartBeat)
        {
          this.C.quicksender.a(paramToServiceMsg, paramFromServiceMsg, true);
          return false;
        }
      }
    }
    for (;;)
    {
      int i1;
      try
      {
        if (!this.a.b()) {
          break label1352;
        }
        int i3 = 1;
        paramFromServiceMsg = ao;
        int i4 = paramFromServiceMsg.length;
        i1 = 0;
        int i2 = i3;
        if (i1 < i4)
        {
          CharSequence localCharSequence = paramFromServiceMsg[i1];
          if ((TextUtils.isEmpty(localCharSequence)) || (paramToServiceMsg == null) || (!localCharSequence.equals(paramToServiceMsg.getServiceCmd()))) {
            break label1354;
          }
          i2 = 0;
        }
        if (i2 == 0) {
          break label1352;
        }
        if (!A.contains(paramToServiceMsg.getServiceCmd())) {
          A.add(paramToServiceMsg.getServiceCmd());
        }
        if (z.incrementAndGet() < com.tencent.mobileqq.msf.core.a.a.H()) {
          break label1352;
        }
        if (A.size() > 2)
        {
          QLog.d("MSF.C.NetConnTag", 1, "Continue wait resp for bus packets ,try close conn");
          z.set(0);
          A.clear();
          this.C.sender.a.a(com.tencent.qphone.base.a.e);
          q();
        }
        else
        {
          QLog.d("MSF.C.NetConnTag", 1, "Continue wait resp timeout by single cmd:" + ((String)A.get(0)).hashCode());
          z.set(0);
          A.clear();
          paramToServiceMsg = new HashMap();
          paramToServiceMsg.put("event_cmd", A.get(0));
          this.C.getStatReporter().a("dim.Msf.SingleCmdTimeout", false, 0L, 0L, paramToServiceMsg, false, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.d("MSF.C.NetConnTag", 1, " Continue wait resp for bus packets ,try close conn failed: " + paramToServiceMsg);
      }
      l2 = 0L;
      break label229;
      l1 = 0L;
      break;
      label1352:
      return true;
      label1354:
      i1 += 1;
    }
  }
  
  public int b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    if (this.C.isSuspended())
    {
      ??? = n.a(paramToServiceMsg);
      ((FromServiceMsg)???).setBusinessFail(2009, "MSF is suspeded.");
      this.C.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
      return paramToServiceMsg.getRequestSsoSeq();
    }
    if ((paramToServiceMsg.getWupBuffer() != null) && (paramToServiceMsg.getWupBuffer().length > 103424))
    {
      ??? = n.a(paramToServiceMsg);
      ((FromServiceMsg)???).setBusinessFail(2019, "check the wupbuf size in range[0, 101kb]");
      this.C.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
      return paramToServiceMsg.getRequestSsoSeq();
    }
    Object localObject2;
    String str;
    int i1;
    if (this.C.configManager.L != null)
    {
      Iterator localIterator = this.C.configManager.L.iterator();
      ??? = null;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject2 = (a.a)localIterator.next();
          if (((a.a)localObject2).a + ((a.a)localObject2).b.b < System.currentTimeMillis() / 1000L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item expired sCmd = " + ((a.a)localObject2).c);
            }
            this.C.configManager.L.remove(localObject2);
            ??? = localObject2;
          }
          else
          {
            str = paramToServiceMsg.getServiceCmd();
            if (((a.a)localObject2).c.charAt(((a.a)localObject2).c.length() - 1) == '*')
            {
              ??? = localObject2;
              if (!str.startsWith(((a.a)localObject2).c.substring(0, ((a.a)localObject2).c.length() - 1))) {
                continue;
              }
              if (!QLog.isColorLevel()) {
                break label2108;
              }
              QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item matched strServiceCmd = " + str + " sCmd:" + ((a.a)localObject2).c);
              i1 = 1;
              ??? = localObject2;
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i1 != 0) && (??? != null))
      {
        if (((a.a)???).b.e == 1)
        {
          localObject2 = new FromServiceMsg();
          ((FromServiceMsg)localObject2).setUin("0");
          ((FromServiceMsg)localObject2).setMsfCommand(MsfCommand.onOverloadPushNotify);
          ((FromServiceMsg)localObject2).setAppId(this.C.getMsfAppid());
          ((FromServiceMsg)localObject2).setMsgSuccess();
          ((FromServiceMsg)localObject2).setRequestSsoSeq(MsfCore.getNextSeq());
          MsfSdkUtils.addFromMsgProcessName("*", (FromServiceMsg)localObject2);
          ((FromServiceMsg)localObject2).getAttributes().put("msg", new String(((a.a)???).b.d));
          this.C.addRespToQuque(null, (FromServiceMsg)localObject2);
          ((a.a)???).b.e = 0;
        }
        localObject2 = n.a(paramToServiceMsg);
        ((FromServiceMsg)localObject2).setBusinessFail(((a.a)???).b.c, new String(((a.a)???).b.d));
        this.C.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify server overload block tomsg: " + paramToServiceMsg + " frommsg: " + localObject2);
        }
        return paramToServiceMsg.getRequestSsoSeq();
        ??? = localObject2;
        if (!((a.a)localObject2).c.equals(str)) {
          break;
        }
        if (!QLog.isColorLevel()) {
          break label2108;
        }
        QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item matched strServiceCmd = " + str + " sCmd:" + ((a.a)localObject2).c);
        i1 = 1;
        ??? = localObject2;
        continue;
      }
      if ((paramToServiceMsg.getAppId() <= 0) && (paramToServiceMsg.getMsfCommand() != MsfCommand.openConn) && ((TextUtils.isEmpty(paramToServiceMsg.getServiceCmd())) || (!paramToServiceMsg.getServiceCmd().startsWith("wtlogin."))))
      {
        ??? = n.a(paramToServiceMsg);
        ((FromServiceMsg)???).setBusinessFail(1007, "msg appid is " + paramToServiceMsg.getAppId());
        this.C.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
        return paramToServiceMsg.getRequestSsoSeq();
      }
      if (aw.get())
      {
        ??? = n.a(paramToServiceMsg);
        ((FromServiceMsg)???).setBusinessFail(2014, "error");
        this.C.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
        return paramToServiceMsg.getRequestSsoSeq();
      }
      localObject2 = (com.tencent.msf.service.protocol.e.d)y.a.get(paramToServiceMsg.getUin());
      ??? = localObject2;
      if (localObject2 != null)
      {
        ??? = localObject2;
        if (paramToServiceMsg.getServiceCmd().equals("wtlogin.login"))
        {
          this.S.remove(paramToServiceMsg.getUin());
          y.a.remove(paramToServiceMsg.getUin());
          ??? = null;
        }
      }
      if ((??? != null) && (!paramToServiceMsg.getServiceCmd().startsWith("login.")) && (!paramToServiceMsg.getServiceCmd().startsWith("wtlogin.login")) && (!paramToServiceMsg.getServiceCmd().equals("GrayUinPro.Check")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "error, " + paramToServiceMsg.getUin() + " not in gray list");
        }
        localObject2 = n.a(paramToServiceMsg);
        try
        {
          ((FromServiceMsg)localObject2).setBusinessFail(2008, new String(((com.tencent.msf.service.protocol.e.d)???).c, "UTF-8"));
          ((FromServiceMsg)localObject2).addAttribute(((FromServiceMsg)localObject2).getServiceCmd(), String.valueOf(((com.tencent.msf.service.protocol.e.d)???).b));
          this.C.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject2);
          if (this.C.getAccountCenter().h(((FromServiceMsg)localObject2).getUin())) {
            this.C.getAccountCenter().l(((FromServiceMsg)localObject2).getUin());
          }
          return paramToServiceMsg.getRequestSsoSeq();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ((FromServiceMsg)localObject2).setBusinessFail(2008, paramToServiceMsg.getUin() + " not in gray list");
          }
        }
      }
      if ((this.C.standbyModeManager != null) && (this.C.standbyModeManager.b()))
      {
        if (!this.C.standbyModeManager.a(paramToServiceMsg.getServiceCmd()))
        {
          QLog.d("MSF.C.NetConnTag", 1, "refuse to send request cmd: " + paramToServiceMsg.getServiceCmd() + " ssoseq: " + paramToServiceMsg.getRequestSsoSeq() + " by standbyMode");
          this.C.getStandyModeManager().a(paramToServiceMsg);
          ??? = n.a(paramToServiceMsg);
          ((FromServiceMsg)???).setBusinessFail(2018, "standby mode force stop request");
          this.C.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
          if (!this.a.b())
          {
            ??? = MsfMsgUtil.getConnOpenMsg("");
            MsfSdkUtils.addToMsgProcessName("", (ToServiceMsg)???);
            this.C.sendSsoMsg((ToServiceMsg)???);
          }
          return paramToServiceMsg.getRequestSsoSeq();
        }
        this.C.getStandyModeManager().b(paramToServiceMsg);
      }
      CodecWarpper.getFileStoreKey();
      ??? = this.C.getAccountCenter().j(paramToServiceMsg.getUin());
      if (??? != null) {
        paramToServiceMsg.setUin((String)???);
      }
      if ((!paramToServiceMsg.getUin().equals("0")) && (!this.al.equals(paramToServiceMsg.getUin())))
      {
        this.al = paramToServiceMsg.getUin();
        this.C.statReporter.a(this.al);
        if (this.ak != paramToServiceMsg.getAppId()) {
          this.ak = paramToServiceMsg.getAppId();
        }
        if (paramToServiceMsg.getRequestSsoSeq() == -1) {
          paramToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
        }
        if (!paramToServiceMsg.getAttributes().containsKey("__timestamp_app2msf")) {
          paramToServiceMsg.addAttribute("__timestamp_app2msf", Long.valueOf(System.currentTimeMillis()));
        }
        paramToServiceMsg.addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
        if ((!this.m) && (this.n))
        {
          this.l = SystemClock.elapsedRealtime();
          this.m = true;
        }
        if (((paramToServiceMsg.getServiceCmd().equals("StatSvc.register")) || (paramToServiceMsg.getServiceCmd().equals("StatSvc.get"))) && (paramToServiceMsg.getMsfCommand().equals(MsfCommand._msf_RegPush)) && (this.n))
        {
          this.l = SystemClock.elapsedRealtime();
          this.m = true;
          ??? = com.tencent.mobileqq.msf.core.a.a.d();
          if ((??? == null) || (this.ap.size() == ???.length)) {
            break label1712;
          }
          a((String[])???);
        }
        label1415:
        if ((!this.n) || (SystemClock.elapsedRealtime() - this.l >= this.j)) {
          break label2096;
        }
        if (this.ap.size() == 0) {
          a(null);
        }
        if ((!this.ap.contains(paramToServiceMsg.getServiceCmd())) && ((TextUtils.isEmpty(paramToServiceMsg.getServiceCmd())) || (!paramToServiceMsg.getServiceCmd().startsWith("wtlogin.")))) {
          break label1834;
        }
        if ((!paramToServiceMsg.getServiceCmd().equals("RegPrxySvc.infoLogin")) && (!paramToServiceMsg.getServiceCmd().equals("RegPrxySvc.infoSync"))) {
          break label1828;
        }
        this.af.add(paramToServiceMsg);
        i1 = paramToServiceMsg.getWupBuffer().length;
      }
      for (;;)
      {
        synchronized (this.ar)
        {
          this.h = (i1 + this.h);
          if (!this.aq)
          {
            this.ah.post(this.e);
            this.aq = true;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.NetConnTag", 2, "add " + paramToServiceMsg.getRequestSsoSeq() + " scmd: " + paramToServiceMsg.getServiceCmd() + " uin: " + paramToServiceMsg.getUin() + " len: " + paramToServiceMsg.getWupBuffer().length + " msg to SSO.LoginMerge delayWaitSendList");
            return paramToServiceMsg.getRequestSsoSeq();
            if ((!paramToServiceMsg.getUin().equals("0")) || (paramToServiceMsg.getAttributes().containsKey("__base_tag_isAppMsg")) || (paramToServiceMsg.getServiceCmd().equals("PhSigLcId.Check"))) {
              break;
            }
            paramToServiceMsg.setUin(e());
            break;
            label1712:
            if (??? != null) {
              break label1415;
            }
            a(null);
          }
        }
        QLog.d("MSF.C.NetConnTag", 1, "add " + paramToServiceMsg.getRequestSsoSeq() + " scmd: " + paramToServiceMsg.getServiceCmd().hashCode() + " uin: " + MsfSdkUtils.getShortUin(paramToServiceMsg.getUin()) + " len: " + paramToServiceMsg.getWupBuffer().length + " msg to " + "SSO.LoginMerge".hashCode() + " delayWaitSendList");
      }
      label1828:
      return h(paramToServiceMsg);
      label1834:
      this.J = SystemClock.elapsedRealtime();
      this.af.add(paramToServiceMsg);
      i1 = paramToServiceMsg.getWupBuffer().length;
      for (;;)
      {
        synchronized (this.ar)
        {
          this.h = (i1 + this.h);
          if (!this.aq)
          {
            this.ah.postDelayed(this.e, this.i);
            this.aq = true;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.NetConnTag", 2, "add " + paramToServiceMsg.getRequestSsoSeq() + " scmd: " + paramToServiceMsg.getServiceCmd() + " uin: " + paramToServiceMsg.getUin() + " len: " + paramToServiceMsg.getWupBuffer().length + " msg to SSO.LoginMerge delayWaitSendList");
            return paramToServiceMsg.getRequestSsoSeq();
          }
        }
        QLog.d("MSF.C.NetConnTag", 1, "add " + paramToServiceMsg.getRequestSsoSeq() + " scmd: " + paramToServiceMsg.getServiceCmd().hashCode() + " uin: " + MsfSdkUtils.getShortUin(paramToServiceMsg.getUin()) + " len: " + paramToServiceMsg.getWupBuffer().length + " msg to " + "SSO.LoginMerge".hashCode() + " delayWaitSendList");
      }
      label2096:
      return h(paramToServiceMsg);
      i1 = 0;
      continue;
      label2108:
      i1 = 1;
      ??? = localObject2;
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      if ((this.a.b()) && (this.a.o() != null) && (this.a.o().g != null) && (this.a.o().g.hashCode() == paramInt)) {
        b(true);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(FromServiceMsg paramFromServiceMsg)
  {
    if ((this.ag == null) || (!this.ag.getAttributes().containsKey("_attr_regprxy_socket_hashcode")) || (!this.ag.getAttributes().containsKey("_attr_regprxy_random_code")))
    {
      QLog.d("MSF.C.NetConnTag", 1, "not tag regprxysvc resp seq:" + paramFromServiceMsg.getRequestSsoSeq() + " by infoLogin error");
      return;
    }
    if ((!this.a.b()) || (this.a.o().g == null))
    {
      QLog.d("MSF.C.NetConnTag", 1, "not tag regprxysvc resp seq:" + paramFromServiceMsg.getRequestSsoSeq() + " by disconn");
      return;
    }
    if (this.a.o().g.hashCode() == ((Integer)this.ag.getAttributes().get("_attr_regprxy_socket_hashcode")).intValue())
    {
      paramFromServiceMsg.getAttributes().put("_attr_regprxy_random_code", this.ag.getAttributes().get("_attr_regprxy_random_code"));
      return;
    }
    QLog.d("MSF.C.NetConnTag", 1, "not tag regprxysvc resp seq:" + paramFromServiceMsg.getRequestSsoSeq() + " by socket changed");
  }
  
  public byte[] b()
  {
    return this.at;
  }
  
  public ToServiceMsg c(int paramInt)
  {
    ToServiceMsg localToServiceMsg = (ToServiceMsg)this.c.remove(Integer.valueOf(paramInt));
    if (localToServiceMsg != null)
    {
      Runnable localRunnable = (Runnable)localToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
      this.C.msfAlarmer.b().removeCallbacks(localRunnable);
      if (com.tencent.mobileqq.msf.core.a.a.w())
      {
        localRunnable = (Runnable)localToServiceMsg.getAttributes().remove("to_predetect_timeoutCallbacker");
        if (localRunnable != null) {
          this.C.msfAlarmer.b().removeCallbacks(localRunnable);
        }
      }
    }
    return localToServiceMsg;
  }
  
  public void c()
  {
    if (this.al != "0") {
      this.C.getAccountCenter().a(false);
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg)
  {
    this.c.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
    paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(ai.incrementAndGet()));
    if (paramToServiceMsg.getTimeout() == -1L) {
      paramToServiceMsg.setTimeout(30000L);
    }
    for (Runnable localRunnable = this.C.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());; localRunnable = this.C.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout()))
    {
      paramToServiceMsg.addAttribute("to_timeoutCallbacker", localRunnable);
      return;
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    this.B.onReceData(paramArrayOfByte);
  }
  
  public void d(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      Runnable localRunnable = (Runnable)paramToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
      if (localRunnable != null) {
        this.C.msfAlarmer.b().removeCallbacks(localRunnable);
      }
      if (com.tencent.mobileqq.msf.core.a.a.w())
      {
        paramToServiceMsg = (Runnable)paramToServiceMsg.getAttributes().remove("to_predetect_timeoutCallbacker");
        if (paramToServiceMsg != null) {
          this.C.msfAlarmer.b().removeCallbacks(paramToServiceMsg);
        }
      }
    }
  }
  
  public String e()
  {
    return this.al;
  }
  
  public byte[] e(ToServiceMsg paramToServiceMsg)
  {
    Object localObject1 = null;
    if (paramToServiceMsg != null) {}
    for (;;)
    {
      int i1;
      try
      {
        Object localObject2 = paramToServiceMsg.getServiceCmd();
        i1 = ((String)localObject2).indexOf("#");
        localObject1 = localObject2;
        if (i1 != -1) {
          localObject1 = ((String)localObject2).substring(0, i1);
        }
        if (paramToServiceMsg.getWupBuffer() != null)
        {
          b1 = 0;
          if (NetConnInfoCenterImpl.isWifiConn())
          {
            b1 = 1;
            localObject2 = f(paramToServiceMsg);
            d();
            if (591 == CodecWarpper.getSharedObjectVersion()) {
              return CodecWarpper.encodeRequest(paramToServiceMsg.getRequestSsoSeq(), n.d(), n.f(), n.g(), "", (String)localObject1, b(), paramToServiceMsg.getAppId(), this.C.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, paramToServiceMsg.getWupBuffer(), false);
            }
          }
          else
          {
            if (!NetConnInfoCenterImpl.isMobileConn()) {
              continue;
            }
            int i2 = NetConnInfoCenterImpl.getMobileNetworkType() + 100;
            i1 = i2;
            if (i2 <= 254) {
              break label270;
            }
            i2 = 254;
            i1 = i2;
            if (!QLog.isColorLevel()) {
              break label270;
            }
            QLog.d("MSF.C.NetConnTag", 2, "error,netWorkType is " + 254);
            i1 = i2;
            break label270;
          }
          return CodecWarpper.encodeRequest(paramToServiceMsg.getRequestSsoSeq(), n.d(), n.f(), n.g(), "", (String)localObject1, b(), paramToServiceMsg.getAppId(), this.C.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, (byte[])localObject2, paramToServiceMsg.getWupBuffer(), false);
        }
        return new byte[0];
      }
      catch (Throwable paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        QLog.d("MSF.C.NetConnTag", 1, "encode packet failed", paramToServiceMsg);
        localObject1 = new byte[0];
      }
      return (byte[])localObject1;
      label270:
      byte b1 = (byte)i1;
    }
  }
  
  public int f()
  {
    return this.ak;
  }
  
  public void g()
  {
    try
    {
      if (this.ac)
      {
        Iterator localIterator = this.ab.iterator();
        while (localIterator.hasNext())
        {
          HashMap localHashMap = (HashMap)localIterator.next();
          try
          {
            this.C.configManager.a(localHashMap, "");
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
      }
      return;
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "report waitReportData error " + localException1);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "report waitReportData succ " + this.ab.size());
    }
    this.ab.clear();
    this.ac = false;
  }
  
  public void g(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {}
    while ((paramToServiceMsg.getMsfCommand() == MsfCommand.msf_ssoping) || (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive)) {
      return;
    }
    if (paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net")) {}
    for (long l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();; l1 = 0L)
    {
      if ((l1 != 0L) && (l1 <= this.a.o().c()))
      {
        QLog.d("MSF.C.NetConnTag", 1, "preDetectTimeoutMsg return before connSucc.");
        return;
      }
      for (;;)
      {
        synchronized (this.L)
        {
          if ((!this.L.get()) || (System.currentTimeMillis() - this.N >= com.tencent.mobileqq.msf.core.a.a.M() + 120000))
          {
            if (System.currentTimeMillis() - this.N > com.tencent.mobileqq.msf.core.a.a.N())
            {
              p();
              QLog.d("MSF.C.NetConnTag", 1, "preDetectTimeoutMsg cmd:" + paramToServiceMsg.getServiceCmd() + ", ssoSeq:" + paramToServiceMsg.getRequestSsoSeq());
              HashMap localHashMap = new HashMap();
              localHashMap.put("param_preDetectUin", paramToServiceMsg.getUin());
              localHashMap.put("param_preDetectCmd", paramToServiceMsg.getServiceCmd());
              localHashMap.put("param_preDetectSsoseq", String.valueOf(paramToServiceMsg.getRequestSsoSeq()));
              this.C.statReporter.a("dim.Msf.PreDetectTimeoutMsg", true, 0L, 0L, localHashMap, false, false);
            }
          }
          else {
            return;
          }
        }
        QLog.d("MSF.C.NetConnTag", 1, "notry preDetectTimeoutMsg cmd:" + paramToServiceMsg.getServiceCmd() + ", ssoSeq:" + paramToServiceMsg.getRequestSsoSeq());
      }
    }
  }
  
  public void h()
  {
    Iterator localIterator = this.c.entrySet().iterator();
    label209:
    for (;;)
    {
      Object localObject1;
      int i1;
      if (localIterator.hasNext())
      {
        localObject1 = (Map.Entry)localIterator.next();
        if (localObject1 == null) {
          continue;
        }
        localObject1 = (ToServiceMsg)((Map.Entry)localObject1).getValue();
        if ((localObject1 == null) || (this.ae.contains(localObject1))) {
          continue;
        }
        if (((ToServiceMsg)localObject1).isFastResendEnabled()) {
          i1 = 1;
        }
      }
      for (;;)
      {
        if (i1 == 0) {
          break label209;
        }
        Object localObject2 = MsfSdkUtils.constructResponse((ToServiceMsg)localObject1, 2901, "", null);
        ((FromServiceMsg)localObject2).setBusinessFail(2901);
        if ((localObject1 != null) && (this.C.quicksender != null) && (this.C.quicksender.b((ToServiceMsg)localObject1))) {
          this.C.quicksender.a((ToServiceMsg)localObject1, (FromServiceMsg)localObject2, -1);
        }
        this.C.addRespToQuque((ToServiceMsg)localObject1, (FromServiceMsg)localObject2);
        localIterator.remove();
        break;
        localObject2 = BaseConstants.CMD_NeedResendCmds;
        int i2 = localObject2.length;
        i1 = 0;
        for (;;)
        {
          if (i1 < i2)
          {
            Object localObject3 = localObject2[i1];
            if (((ToServiceMsg)localObject1).getServiceCmd().equals(localObject3))
            {
              i1 = 1;
              break;
            }
            i1 += 1;
            continue;
            return;
          }
        }
        i1 = 0;
      }
    }
  }
  
  public void k()
  {
    if ((this.a != null) && (this.a.o() != null)) {
      this.a.o().d();
    }
  }
  
  public void l()
  {
    if (-1L == s) {}
    long l1;
    do
    {
      return;
      l1 = System.currentTimeMillis();
    } while (l1 - s <= com.tencent.mobileqq.msf.core.a.a.aW());
    try
    {
      new e().run();
      s = l1;
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.NetConnTag", 1, "failed to report connect wifi info " + localException.toString());
    }
  }
  
  class a
    extends CodecWarpper
  {
    a() {}
    
    private com.tencent.qphone.base.a a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return com.tencent.qphone.base.a.u;
      case -2: 
        return com.tencent.qphone.base.a.v;
      case -3: 
        return com.tencent.qphone.base.a.w;
      case -4: 
        return com.tencent.qphone.base.a.x;
      case -5: 
        return com.tencent.qphone.base.a.j;
      case -6: 
        return com.tencent.qphone.base.a.r;
      case -7: 
        return com.tencent.qphone.base.a.s;
      }
      return com.tencent.qphone.base.a.y;
    }
    
    private void a(FromServiceMsg paramFromServiceMsg, int paramInt)
    {
      paramFromServiceMsg.addAttribute("__timestamp_net2msf", Long.valueOf(System.currentTimeMillis()));
      paramFromServiceMsg.addAttribute("__timestamp_net2msf_boot", Long.valueOf(SystemClock.elapsedRealtime()));
      Object localObject = paramFromServiceMsg.getMsgCookie();
      if ((localObject != null) && (localObject.length > 0)) {
        w.this.C.sender.a((byte[])localObject);
      }
      paramFromServiceMsg.setRequestSsoSeq(paramFromServiceMsg.getAppSeq());
      if ((!paramFromServiceMsg.isSuccess()) && (paramFromServiceMsg.getBusinessFailCode() == 55528)) {
        w.a(paramFromServiceMsg.getUin(), false);
      }
      ToServiceMsg localToServiceMsg;
      for (;;)
      {
        if (NetConnInfoCenterImpl.isNeedWifiAuth()) {
          NetConnInfoCenterImpl.setNeedWifiAuth(false);
        }
        localToServiceMsg = w.this.C.sender.c(paramFromServiceMsg.getRequestSsoSeq());
        label127:
        int i;
        String str;
        label219:
        long l2;
        long l1;
        StringBuilder localStringBuilder;
        if (localToServiceMsg != null)
        {
          localObject = localToServiceMsg.getServiceCmd();
          i = ((String)localObject).indexOf("#");
          if (i == -1) {
            break label1088;
          }
          str = ((String)localObject).substring(i + 1, ((String)localObject).length()) + "_new";
          localObject = ((String)localObject).substring(0, i);
          com.tencent.mobileqq.msf.core.c.i.a(true, paramFromServiceMsg.getUin(), paramInt, str, 1, w.this.a.o().l, w.this.a.o().m);
          l2 = 0L;
          l1 = l2;
          if (localToServiceMsg != null)
          {
            l1 = l2;
            if (localToServiceMsg.getAttribute("__timestamp_msf2net") != null)
            {
              l1 = l2;
              if (paramFromServiceMsg != null)
              {
                l1 = l2;
                if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null)
                {
                  l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)localToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
                  l1 = l2;
                  if (l2 < 0L) {
                    l1 = 0L;
                  }
                  l2 = l1;
                  if (l1 > 2147483647L) {
                    l2 = 0L;
                  }
                  paramFromServiceMsg.addAttribute("__timestamp_msf2net", localToServiceMsg.getAttribute("__timestamp_msf2net"));
                  l1 = l2;
                }
              }
            }
          }
          localStringBuilder = new StringBuilder();
          if (!QLog.isDevelopLevel()) {
            break label1226;
          }
          if (l1 != 0L) {
            break label1128;
          }
          str = String.valueOf(l1);
          label374:
          if (paramFromServiceMsg.getResultCode() == 1000) {
            break label1154;
          }
          QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + paramFromServiceMsg.getServiceCmd() + " len:" + paramInt + " costTime:" + str + " code:" + paramFromServiceMsg.getResultCode() + " failMsg:" + paramFromServiceMsg.getBusinessFailMsg());
          label477:
          paramFromServiceMsg.addAttribute("_tag_LOGSTR", w.D + "|" + paramFromServiceMsg.getRequestSsoSeq() + "|" + paramFromServiceMsg.getServiceCmd() + "|");
          paramFromServiceMsg.addAttribute("_tag_socket", w.D);
          paramFromServiceMsg.addAttribute("_tag_localsocket", w.E);
          paramFromServiceMsg.addAttribute("_tag_socket_nettype", Integer.valueOf(g.A));
          if (localToServiceMsg == null) {}
        }
        try
        {
          w.this.a.a(paramFromServiceMsg, localToServiceMsg);
          i = paramFromServiceMsg.getRequestSsoSeq();
          l2 = paramInt;
          if (localToServiceMsg == null)
          {
            bool = true;
            com.tencent.mobileqq.a.a.b.a((String)localObject, i, l2, l1, bool);
            if ((w.this.C.isReconnectSso.get()) && (w.this.C.sender.a()))
            {
              w.this.a.o().a(com.tencent.qphone.base.a.h);
              w.this.C.isReconnectSso.set(false);
            }
            if (localToServiceMsg == null) {
              break label1544;
            }
            paramFromServiceMsg.setAppSeq(localToServiceMsg.getAppSeq());
            paramFromServiceMsg.setMsfCommand(localToServiceMsg.getMsfCommand());
            paramFromServiceMsg.setAppId(localToServiceMsg.getAppId());
            if (paramFromServiceMsg.isSuccess()) {
              break label1544;
            }
            i = paramFromServiceMsg.getBusinessFailCode();
            paramInt = i;
            if (i == 302)
            {
              paramFromServiceMsg.setBusinessFail(65234);
              paramInt = 65234;
            }
            if (paramInt != 65234) {
              break label1490;
            }
            w.this.a.o().a(com.tencent.qphone.base.a.i);
            w.this.C.reSendMsg(localToServiceMsg);
            return;
            if ((paramFromServiceMsg.getUin() == null) || (paramFromServiceMsg.getUin().length() <= 4) || (w.aa.contains(paramFromServiceMsg.getUin())) || (!paramFromServiceMsg.isSuccess()) || (paramFromServiceMsg.getServiceCmd().startsWith("login.")) || (paramFromServiceMsg.getServiceCmd().startsWith("wtlogin.")) || (paramFromServiceMsg.getServiceCmd().equals("ConfigService.ClientReq")) || (paramFromServiceMsg.getServiceCmd().equals("GrayUinPro.Check")) || (paramFromServiceMsg.getServiceCmd().equals("account.RequestReBindMblWTLogin_emp")) || (paramFromServiceMsg.getServiceCmd().equals("account.RequestVerifyWTLogin_emp")) || (paramFromServiceMsg.getServiceCmd().equals("ConnAuthSvr.get_app_info_emp")) || (paramFromServiceMsg.getServiceCmd().equals("ConnAuthSvr.sdk_auth_api_emp")) || (paramFromServiceMsg.getServiceCmd().equals("ConnAuthSvr.get_auth_api_list_emp"))) {
              continue;
            }
            localObject = (ConcurrentLinkedQueue)w.q.get(paramFromServiceMsg.getUin());
            if ((localObject != null) && (((ConcurrentLinkedQueue)localObject).contains(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()))))
            {
              w.q.remove(paramFromServiceMsg.getUin());
              w.a(paramFromServiceMsg.getUin(), true);
              QLog.d(tag, 1, "recv Packet removeItem setV9, ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + ", uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
              continue;
            }
            QLog.d(tag, 1, "recv Packet ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + ", uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
            continue;
            localObject = paramFromServiceMsg.getServiceCmd();
            break label127;
            label1088:
            com.tencent.mobileqq.msf.core.c.i.a(true, paramFromServiceMsg.getUin(), paramInt, (String)localObject, 1, w.this.a.o().l, w.this.a.o().m);
            break label219;
            label1128:
            str = l1 + NetConnInfoCenter.getSignalStrengthsLog();
            break label374;
            label1154:
            QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + paramFromServiceMsg.getServiceCmd() + " len:" + paramInt + " costTime:" + str);
            break label477;
            label1226:
            if (paramFromServiceMsg.getResultCode() != 1000)
            {
              QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + paramFromServiceMsg.getServiceCmd().hashCode() + new StringBuilder().append(" ").append(paramFromServiceMsg.getRequestSsoSeq() + paramInt).toString() + " code:" + paramFromServiceMsg.getResultCode() + " failMsg:" + paramFromServiceMsg.getBusinessFailMsg());
              break label477;
            }
            QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + paramFromServiceMsg.getServiceCmd().hashCode() + new StringBuilder().append(" ").append(paramFromServiceMsg.getRequestSsoSeq() + paramInt).toString());
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            w.this.a.d();
            w.this.a.q = 0L;
            QLog.d(tag, 1, "call firstResponseGetted error " + localException, localException);
            continue;
            boolean bool = false;
          }
          label1490:
          if (paramInt == 55528)
          {
            if (!MsfMsgUtil.hasResendBy10008(localToServiceMsg))
            {
              localToServiceMsg.getAttributes().put("_attr_msg_has_resend_by_10008", Boolean.valueOf(true));
              w.this.C.reSendMsg(localToServiceMsg);
              return;
            }
            QLog.d(tag, 1, "This msg has already resend by -10008, won't resend again!");
          }
        }
      }
      label1544:
      if (w.o().get()) {
        QLog.e(tag, 1, "invalidSign, " + paramFromServiceMsg + " is droped.");
      }
      for (;;)
      {
        w.this.C.getAccountCenter().g.a();
        paramFromServiceMsg = w.this.C.netConnICenter;
        NetConnInfoCenter.impl.checkRecordTime();
        w.this.g();
        w.this.l();
        return;
        if (paramFromServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive)
        {
          w.this.a(paramFromServiceMsg, localToServiceMsg);
        }
        else if (paramFromServiceMsg.getMsfCommand() == MsfCommand._msf_QuickHeartBeat)
        {
          w.this.C.quicksender.a(localToServiceMsg, paramFromServiceMsg, false);
        }
        else
        {
          w.z.set(0);
          w.A.clear();
          w.this.C.getSsoRespHandler().b(localToServiceMsg, paramFromServiceMsg);
        }
      }
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3)
    {
      QLog.d(tag, 1, "MSF.C.CodecWarpper loginMerge onInvalidData " + paramInt1 + " size is " + paramInt2 + ", try to closeConn");
      w.this.a.o().a(a(paramInt1));
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(w.e(w.this)).append("|").append(MsfCore.mobileQQAppid).append("|").append(paramInt3).append("|").append(paramInt1).append("|").append(w.this.a.o().l + ":" + w.this.a.o().m);
      if (QLog.isDevelopLevel()) {
        QLog.d(tag, 4, "CodecStatHelper Report loginMerge_error " + localStringBuffer.toString());
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("loginMerge_failDetail", localStringBuffer.toString());
      MsfService.getCore().getStatReporter().a("loginMerge_error", true, 0L, 0L, localHashMap, false, false);
    }
    
    public void onInvalidData(int paramInt1, int paramInt2)
    {
      QLog.d(tag, 1, "MSF.C.CodecWarpper onInvalidData " + paramInt1 + " size is " + paramInt2 + ", try to closeConn");
      w.this.a.o().a(a(paramInt1));
      try
      {
        w.this.a.f();
        return;
      }
      catch (Exception localException)
      {
        QLog.d(tag, 1, "call findResponseDataError error " + localException);
      }
    }
    
    public void onInvalidSign()
    {
      QLog.d(tag, 1, "MSF.C.CodecWarpper onInvalidSign");
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(w.this.C.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_InvalidSign");
      localFromServiceMsg.setBusinessFail(2014, "onInvalidSign");
      localFromServiceMsg.setMsfCommand(MsfCommand.onInvalidSign);
      MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
      w.this.C.addRespToQuque(null, localFromServiceMsg);
      w.o().set(true);
    }
    
    public void onResponse(int paramInt1, Object paramObject, int paramInt2)
    {
      Object localObject4 = null;
      if (paramObject != null) {}
      try
      {
        if (w.Q != -1) {
          w.Q = -1;
        }
        w.this.O = System.currentTimeMillis();
        w.P = w.this.O;
        localObject1 = (FromServiceMsg)paramObject;
        try
        {
          paramInt1 = ((FromServiceMsg)localObject1).getWupBuffer().length;
          if (!((FromServiceMsg)localObject1).getServiceCmd().equals("SSO.LoginMerge")) {
            break label386;
          }
          ((FromServiceMsg)localObject1).setRequestSsoSeq(((FromServiceMsg)localObject1).getAppSeq());
          if (((FromServiceMsg)localObject1).isSuccess()) {
            break label386;
          }
          QLog.d("MSF.C.NetConnTag", 1, "failed merge netRecv ssoSeq:" + ((FromServiceMsg)localObject1).getRequestSsoSeq() + " scmd: " + ((FromServiceMsg)localObject1).getServiceCmd() + " len: " + ((FromServiceMsg)localObject1).getWupBuffer().length);
          Object localObject2 = (ArrayList)w.this.d.remove(Integer.valueOf(((FromServiceMsg)localObject1).getRequestSsoSeq()));
          if (((FromServiceMsg)localObject1).getBusinessFailCode() == 55429)
          {
            if (w.this.n) {
              w.this.n = false;
            }
            QLog.d("MSF.C.NetConnTag", 1, "merge not support, " + Arrays.toString(((ArrayList)localObject2).toArray()) + "resend, close merge.");
          }
          if (localObject2 == null) {
            break label386;
          }
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramInt1 = ((Integer)((Iterator)localObject2).next()).intValue();
            localObject4 = w.this.C.sender.c(paramInt1);
            if (localObject4 != null) {
              w.a(w.this, (ToServiceMsg)localObject4);
            }
          }
          if (!localThrowable1.toString().contains("InvalidProtocol")) {
            break label336;
          }
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          label336:
          Object localObject3;
          Object localObject1 = localException;
        }
      }
      if (localObject1 != null) {
        a(-8, paramInt2, ((FromServiceMsg)localObject1).getRequestSsoSeq());
      }
      if (QLog.isColorLevel()) {
        QLog.d(tag, 2, "handleSsoResp " + paramObject + " error " + localThrowable1.toString(), localThrowable1);
      }
      for (;;)
      {
        return;
        label386:
        int i;
        if ((((FromServiceMsg)localObject1).getFlag() & 0x1) != 0)
        {
          localObject3 = ((FromServiceMsg)localObject1).getWupBuffer();
          i = localObject3.length;
          if (i > 4) {
            i = (localObject3[0] & 0xFF) << 24 | 0x0 | (localObject3[1] & 0xFF) << 16 | (localObject3[2] & 0xFF) << 8 | localObject3[3] & 0xFF;
          }
        }
        else
        {
          try
          {
            localObject4 = new byte[i];
            System.arraycopy(localObject3, 4, localObject4, 0, i - 4);
            localObject4 = com.tencent.qphone.base.util.i.b((byte[])localObject4);
            Object localObject5 = new byte[localObject4.length + 4];
            localObject5[0] = ((byte)(localObject4.length + 4 >> 24 & 0xFF));
            localObject5[1] = ((byte)(localObject4.length + 4 >> 16 & 0xFF));
            localObject5[2] = ((byte)(localObject4.length + 4 >> 8 & 0xFF));
            localObject5[3] = ((byte)(localObject4.length + 4 & 0xFF));
            System.arraycopy(localObject4, 0, localObject5, 4, localObject4.length);
            ((FromServiceMsg)localObject1).putWupBuffer((byte[])localObject5);
            if ((!((FromServiceMsg)localObject1).isSuccess()) || (!((FromServiceMsg)localObject1).getServiceCmd().equals("SSO.LoginMerge"))) {
              break label971;
            }
            QLog.d("MSF.C.NetConnTag", 1, "netRecv Delay FromServiceMsg ssoSeq:" + ((FromServiceMsg)localObject1).getRequestSsoSeq() + " scmd: " + ((FromServiceMsg)localObject1).getServiceCmd() + " len: " + paramInt1 + " uncompressed len: " + ((FromServiceMsg)localObject1).getWupBuffer().length);
            localObject3 = new SSOLoginMerge.BusiBuffData();
            localObject4 = new byte[((FromServiceMsg)localObject1).getWupBuffer().length - 4];
            System.arraycopy(((FromServiceMsg)localObject1).getWupBuffer(), 4, localObject4, 0, localObject4.length);
            localObject3 = ((SSOLoginMerge.BusiBuffData)((SSOLoginMerge.BusiBuffData)localObject3).mergeFrom((byte[])localObject4)).BusiBuffVec.get().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (SSOLoginMerge.BusiBuffItem)((Iterator)localObject3).next();
              localObject5 = new FromServiceMsg();
              ((FromServiceMsg)localObject5).setServiceCmd(((SSOLoginMerge.BusiBuffItem)localObject4).ServiceCmd.get());
              ((FromServiceMsg)localObject5).setRequestSsoSeq(((SSOLoginMerge.BusiBuffItem)localObject4).SeqNo.get());
              ((FromServiceMsg)localObject5).putWupBuffer(((SSOLoginMerge.BusiBuffItem)localObject4).BusiBuff.get().toByteArray());
              ((FromServiceMsg)localObject5).setAppSeq(((FromServiceMsg)localObject5).getRequestSsoSeq());
              ((FromServiceMsg)localObject5).setMsgSuccess();
              ((FromServiceMsg)localObject5).setUin(((FromServiceMsg)localObject1).getUin());
              ((FromServiceMsg)localObject5).putWupBuffer(w.b(((FromServiceMsg)localObject5).getWupBuffer()));
              a((FromServiceMsg)localObject5, ((FromServiceMsg)localObject5).getWupBuffer().length);
            }
            if (((FromServiceMsg)localObject1).getServiceCmd().equals("SSO.LoginMerge")) {
              break label956;
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d(tag, 2, "uncompress data failed " + localException);
            }
            if (!((FromServiceMsg)localObject1).getServiceCmd().equals("SSO.LoginMerge"))
            {
              onInvalidData(-7, localObject3.length);
              return;
            }
            a(-7, localObject3.length, ((FromServiceMsg)localObject1).getRequestSsoSeq());
            return;
          }
        }
      }
      onInvalidData(-6, localObject3.length);
      return;
      label956:
      a(-6, localObject3.length, ((FromServiceMsg)localObject1).getRequestSsoSeq());
      return;
      label971:
      a((FromServiceMsg)localObject1, paramInt2);
    }
    
    public void onResponse(int paramInt1, Object paramObject, int paramInt2, byte[] paramArrayOfByte)
    {
      FromServiceMsg localFromServiceMsg2 = null;
      Object localObject1;
      if (paramObject != null)
      {
        localFromServiceMsg1 = localFromServiceMsg2;
        try
        {
          if (w.Q != -1)
          {
            localFromServiceMsg1 = localFromServiceMsg2;
            w.Q = -1;
          }
          localFromServiceMsg1 = localFromServiceMsg2;
          w.this.O = System.currentTimeMillis();
          localFromServiceMsg1 = localFromServiceMsg2;
          w.P = w.this.O;
          localFromServiceMsg1 = localFromServiceMsg2;
          localFromServiceMsg2 = (FromServiceMsg)paramObject;
          localFromServiceMsg1 = localFromServiceMsg2;
          paramInt1 = localFromServiceMsg2.getWupBuffer().length;
          localFromServiceMsg1 = localFromServiceMsg2;
          if (localFromServiceMsg2.getServiceCmd().equals("SSO.LoginMerge"))
          {
            localFromServiceMsg1 = localFromServiceMsg2;
            localFromServiceMsg2.setRequestSsoSeq(localFromServiceMsg2.getAppSeq());
            localFromServiceMsg1 = localFromServiceMsg2;
            if (!localFromServiceMsg2.isSuccess())
            {
              localFromServiceMsg1 = localFromServiceMsg2;
              QLog.d("MSF.C.NetConnTag", 1, "failed merge netRecv ssoSeq:" + localFromServiceMsg2.getRequestSsoSeq() + " scmd: " + localFromServiceMsg2.getServiceCmd() + " len: " + localFromServiceMsg2.getWupBuffer().length);
              localFromServiceMsg1 = localFromServiceMsg2;
              localObject1 = (ArrayList)w.this.d.remove(Integer.valueOf(localFromServiceMsg2.getRequestSsoSeq()));
              localFromServiceMsg1 = localFromServiceMsg2;
              if (localFromServiceMsg2.getBusinessFailCode() == 55429)
              {
                localFromServiceMsg1 = localFromServiceMsg2;
                if (w.this.n)
                {
                  localFromServiceMsg1 = localFromServiceMsg2;
                  w.this.n = false;
                }
                localFromServiceMsg1 = localFromServiceMsg2;
                QLog.d("MSF.C.NetConnTag", 1, "merge not support, " + Arrays.toString(((ArrayList)localObject1).toArray()) + "resend, close merge.");
              }
              if (localObject1 != null)
              {
                localFromServiceMsg1 = localFromServiceMsg2;
                paramArrayOfByte = ((ArrayList)localObject1).iterator();
                for (;;)
                {
                  localFromServiceMsg1 = localFromServiceMsg2;
                  if (!paramArrayOfByte.hasNext()) {
                    break;
                  }
                  localFromServiceMsg1 = localFromServiceMsg2;
                  paramInt1 = ((Integer)paramArrayOfByte.next()).intValue();
                  localFromServiceMsg1 = localFromServiceMsg2;
                  localObject1 = w.this.C.sender.c(paramInt1);
                  if (localObject1 != null)
                  {
                    localFromServiceMsg1 = localFromServiceMsg2;
                    w.a(w.this, (ToServiceMsg)localObject1);
                  }
                }
                return;
              }
            }
          }
        }
        catch (Throwable paramArrayOfByte)
        {
          if ((paramArrayOfByte.toString().contains("InvalidProtocol")) && (localFromServiceMsg1 != null)) {
            a(-8, paramInt2, localFromServiceMsg1.getRequestSsoSeq());
          }
          if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "handleSsoResp " + paramObject + " error " + paramArrayOfByte.toString(), paramArrayOfByte);
          }
        }
      }
      FromServiceMsg localFromServiceMsg1 = localFromServiceMsg2;
      int i;
      if ((localFromServiceMsg2.getFlag() & 0x1) != 0)
      {
        localFromServiceMsg1 = localFromServiceMsg2;
        localObject1 = localFromServiceMsg2.getWupBuffer();
        localFromServiceMsg1 = localFromServiceMsg2;
        i = localObject1.length;
        if (i <= 4) {
          break label1353;
        }
        i = 0x0 | (localObject1[0] & 0xFF) << 24 | (localObject1[1] & 0xFF) << 16 | (localObject1[2] & 0xFF) << 8 | localObject1[3] & 0xFF;
        localFromServiceMsg1 = localFromServiceMsg2;
      }
      for (;;)
      {
        try
        {
          localObject2 = new byte[i];
          localFromServiceMsg1 = localFromServiceMsg2;
          System.arraycopy(localObject1, 4, localObject2, 0, i - 4);
          localFromServiceMsg1 = localFromServiceMsg2;
          localObject2 = com.tencent.qphone.base.util.i.b((byte[])localObject2);
          localFromServiceMsg1 = localFromServiceMsg2;
          byte[] arrayOfByte = new byte[localObject2.length + 4];
          localFromServiceMsg1 = localFromServiceMsg2;
          arrayOfByte[0] = ((byte)(localObject2.length + 4 >> 24 & 0xFF));
          localFromServiceMsg1 = localFromServiceMsg2;
          arrayOfByte[1] = ((byte)(localObject2.length + 4 >> 16 & 0xFF));
          localFromServiceMsg1 = localFromServiceMsg2;
          arrayOfByte[2] = ((byte)(localObject2.length + 4 >> 8 & 0xFF));
          localFromServiceMsg1 = localFromServiceMsg2;
          arrayOfByte[3] = ((byte)(localObject2.length + 4 & 0xFF));
          localFromServiceMsg1 = localFromServiceMsg2;
          System.arraycopy(localObject2, 0, arrayOfByte, 4, localObject2.length);
          localFromServiceMsg1 = localFromServiceMsg2;
          localFromServiceMsg2.putWupBuffer(arrayOfByte);
          if (paramArrayOfByte != null) {
            localFromServiceMsg1 = localFromServiceMsg2;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          Object localObject2;
          localFromServiceMsg1 = localFromServiceMsg2;
          if (QLog.isColorLevel())
          {
            localFromServiceMsg1 = localFromServiceMsg2;
            QLog.d(tag, 2, "uncompress data failed " + paramArrayOfByte);
          }
          localFromServiceMsg1 = localFromServiceMsg2;
          if (!localFromServiceMsg2.getServiceCmd().equals("SSO.LoginMerge"))
          {
            localFromServiceMsg1 = localFromServiceMsg2;
            onInvalidData(-7, localObject1.length);
            return;
          }
          localFromServiceMsg1 = localFromServiceMsg2;
          a(-7, localObject1.length, localFromServiceMsg2.getRequestSsoSeq());
          return;
        }
        try
        {
          if (localFromServiceMsg2.getServiceCmd().equals("MessageSvc.PushNotify"))
          {
            localFromServiceMsg1 = localFromServiceMsg2;
            long l = SystemClock.elapsedRealtime();
            localFromServiceMsg1 = localFromServiceMsg2;
            w.v = com.tencent.mobileqq.msf.core.c.m.a(false, l - 5000L, l);
            localFromServiceMsg1 = localFromServiceMsg2;
            localObject1 = new SSOReserveField.ReserveFields();
            localFromServiceMsg1 = localFromServiceMsg2;
            ((SSOReserveField.ReserveFields)localObject1).mergeFrom(paramArrayOfByte);
            localFromServiceMsg1 = localFromServiceMsg2;
            paramArrayOfByte = new StringBuilder();
            localFromServiceMsg1 = localFromServiceMsg2;
            paramArrayOfByte.append(((SSOReserveField.ReserveFields)localObject1).sso_send.get()).append("|").append(System.currentTimeMillis());
            localFromServiceMsg1 = localFromServiceMsg2;
            localFromServiceMsg2.addAttribute("sso_push_timestamp", paramArrayOfByte.toString());
            localFromServiceMsg1 = localFromServiceMsg2;
            QLog.d(tag, 1, "pushnotify add timestamp " + paramArrayOfByte.toString());
            localFromServiceMsg1 = localFromServiceMsg2;
            w.this.C.statReporter.a("dim.Msf.PushRecvEvent", true, 0L, 0L, null, false, false);
          }
        }
        catch (Exception paramArrayOfByte)
        {
          localFromServiceMsg1 = localFromServiceMsg2;
          QLog.d(tag, 1, "resolve sso reserve field failed", paramArrayOfByte);
          continue;
          localFromServiceMsg1 = localFromServiceMsg2;
          a(localFromServiceMsg2, paramInt2);
        }
      }
      localFromServiceMsg1 = localFromServiceMsg2;
      if (localFromServiceMsg2.isSuccess())
      {
        localFromServiceMsg1 = localFromServiceMsg2;
        if (localFromServiceMsg2.getServiceCmd().equals("SSO.LoginMerge"))
        {
          localFromServiceMsg1 = localFromServiceMsg2;
          QLog.d("MSF.C.NetConnTag", 1, "netRecv Delay FromServiceMsg ssoSeq:" + localFromServiceMsg2.getRequestSsoSeq() + " scmd: " + localFromServiceMsg2.getServiceCmd() + " len: " + paramInt1 + " uncompressed len: " + localFromServiceMsg2.getWupBuffer().length);
          localFromServiceMsg1 = localFromServiceMsg2;
          paramArrayOfByte = new SSOLoginMerge.BusiBuffData();
          localFromServiceMsg1 = localFromServiceMsg2;
          localObject1 = new byte[localFromServiceMsg2.getWupBuffer().length - 4];
          localFromServiceMsg1 = localFromServiceMsg2;
          System.arraycopy(localFromServiceMsg2.getWupBuffer(), 4, localObject1, 0, localObject1.length);
          localFromServiceMsg1 = localFromServiceMsg2;
          paramArrayOfByte = ((SSOLoginMerge.BusiBuffData)paramArrayOfByte.mergeFrom((byte[])localObject1)).BusiBuffVec.get().iterator();
          for (;;)
          {
            localFromServiceMsg1 = localFromServiceMsg2;
            if (!paramArrayOfByte.hasNext()) {
              break;
            }
            localFromServiceMsg1 = localFromServiceMsg2;
            localObject1 = (SSOLoginMerge.BusiBuffItem)paramArrayOfByte.next();
            localFromServiceMsg1 = localFromServiceMsg2;
            localObject2 = new FromServiceMsg();
            localFromServiceMsg1 = localFromServiceMsg2;
            ((FromServiceMsg)localObject2).setServiceCmd(((SSOLoginMerge.BusiBuffItem)localObject1).ServiceCmd.get());
            localFromServiceMsg1 = localFromServiceMsg2;
            ((FromServiceMsg)localObject2).setRequestSsoSeq(((SSOLoginMerge.BusiBuffItem)localObject1).SeqNo.get());
            localFromServiceMsg1 = localFromServiceMsg2;
            ((FromServiceMsg)localObject2).putWupBuffer(((SSOLoginMerge.BusiBuffItem)localObject1).BusiBuff.get().toByteArray());
            localFromServiceMsg1 = localFromServiceMsg2;
            ((FromServiceMsg)localObject2).setAppSeq(((FromServiceMsg)localObject2).getRequestSsoSeq());
            localFromServiceMsg1 = localFromServiceMsg2;
            ((FromServiceMsg)localObject2).setMsgSuccess();
            localFromServiceMsg1 = localFromServiceMsg2;
            ((FromServiceMsg)localObject2).setUin(localFromServiceMsg2.getUin());
            localFromServiceMsg1 = localFromServiceMsg2;
            ((FromServiceMsg)localObject2).putWupBuffer(w.b(((FromServiceMsg)localObject2).getWupBuffer()));
            localFromServiceMsg1 = localFromServiceMsg2;
            a((FromServiceMsg)localObject2, ((FromServiceMsg)localObject2).getWupBuffer().length);
          }
          label1353:
          localFromServiceMsg1 = localFromServiceMsg2;
          if (!localFromServiceMsg2.getServiceCmd().equals("SSO.LoginMerge"))
          {
            localFromServiceMsg1 = localFromServiceMsg2;
            onInvalidData(-6, localObject1.length);
            return;
          }
          localFromServiceMsg1 = localFromServiceMsg2;
          a(-6, localObject1.length, localFromServiceMsg2.getRequestSsoSeq());
          return;
        }
      }
    }
    
    public void onSSOPingResponse(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null)
      {
        QLog.d(tag, 1, "MSF.C.CodecWarpper onSSOPingResponse error, data null");
        return;
      }
      if (paramArrayOfByte.length <= 4)
      {
        QLog.d(tag, 1, "MSF.C.CodecWarpper onSSOPingResponse error, length: " + paramArrayOfByte.length);
        return;
      }
      int i = paramArrayOfByte.length;
      Object localObject2;
      try
      {
        localObject1 = ByteBuffer.wrap(paramArrayOfByte);
        ((ByteBuffer)localObject1).getInt();
        ((ByteBuffer)localObject1).getInt();
        ((ByteBuffer)localObject1).getInt();
        j = ((ByteBuffer)localObject1).get();
        localObject2 = new byte[j];
        ((ByteBuffer)localObject1).get((byte[])localObject2, 0, j);
        if ((!new String((byte[])localObject2).equals("MSF")) && (com.tencent.mobileqq.msf.core.a.a.aM()))
        {
          boolean bool = com.tencent.mobileqq.msf.core.net.a.b.b();
          if (bool) {
            try
            {
              com.tencent.mobileqq.msf.core.net.a.b.b(paramArrayOfByte);
              return;
            }
            catch (Exception paramArrayOfByte)
            {
              QLog.d(tag, 1, "heartbeatproxy failed to process back msg ", paramArrayOfByte);
              return;
            }
          }
        }
        ((ByteBuffer)localObject1).position(((ByteBuffer)localObject1).get() + ((ByteBuffer)localObject1).position());
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        QLog.d(tag, 1, "MSF.C.CodecWarpper onSSOPingResponse error, exception : ", paramArrayOfByte);
        return;
      }
      int j = ((ByteBuffer)localObject1).getInt();
      new StringBuilder().append(j >> 24 & 0xFF).append('.').append(j >> 16 & 0xFF).append('.').append(j >> 8 & 0xFF).append('.').append(j & 0xFF).toString();
      Object localObject1 = w.this.a.o().f();
      w.this.a.a(true);
      long l1;
      if ((localObject1 != null) && (((ToServiceMsg)localObject1).getAttribute("__timestamp_msf2net") != null))
      {
        long l2 = SystemClock.elapsedRealtime() - ((Long)((ToServiceMsg)localObject1).getAttribute("__timestamp_msf2net")).longValue();
        l1 = l2;
        if (l2 >= 0L) {
          break label614;
        }
        l1 = 0L;
      }
      for (;;)
      {
        localObject2 = new StringBuilder();
        if (QLog.isDevelopLevel()) {
          if (l1 == 0L)
          {
            paramArrayOfByte = String.valueOf(l1);
            label357:
            QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + ((ToServiceMsg)localObject1).getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(((ToServiceMsg)localObject1).getUin()) + " cmd:" + ((ToServiceMsg)localObject1).getServiceCmd() + " len:" + i + " costTime:" + paramArrayOfByte);
          }
        }
        for (;;)
        {
          if (0L == l1) {
            break label603;
          }
          try
          {
            if (!NetConnInfoCenterImpl.isWifiConn()) {
              break;
            }
            w.this.a(w.this.u.format(Long.valueOf(System.currentTimeMillis())), l1);
            return;
          }
          catch (Exception paramArrayOfByte)
          {
            QLog.d(tag, 1, "failed to store connect wifi info " + paramArrayOfByte.toString());
            return;
          }
          paramArrayOfByte = l1 + NetConnInfoCenter.getSignalStrengthsLog();
          break label357;
          QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + ((ToServiceMsg)localObject1).getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(((ToServiceMsg)localObject1).getUin()) + " cmd:" + ((ToServiceMsg)localObject1).getServiceCmd().hashCode() + new StringBuilder().append(" ").append(i + ((ToServiceMsg)localObject1).getRequestSsoSeq()).toString());
        }
        label603:
        break;
        label614:
        do
        {
          break;
          l1 = 0L;
          break;
        } while (l1 <= 2147483647L);
        l1 = 0L;
      }
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      int j;
      long l;
      synchronized (w.a(w.this))
      {
        j = w.b(w.this).size();
        i = j;
        if (j > w.this.f) {
          i = w.this.f;
        }
        l = SystemClock.elapsedRealtime();
        if (w.this.J >= l)
        {
          w.c(w.this).postDelayed(w.this.e, w.this.i);
          if ((!w.d(w.this)) && (w.b(w.this).size() - w.this.g > 0))
          {
            w.c(w.this).postDelayed(w.this.e, w.this.i);
            w.a(w.this, true);
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.NetConnTag", 4, "delayWaitSendList size is " + w.b(w.this).size() + ", " + i + " sso package should be merged.");
          }
          if (i <= 0) {
            break label1608;
          }
          j = i;
        }
        try
        {
          if (i > w.b(w.this).size()) {
            j = w.b(w.this).size();
          }
          if (j != 1) {
            break label347;
          }
          ??? = (ToServiceMsg)w.b(w.this).peek();
          if ((??? == null) || (((ToServiceMsg)???).getWupBuffer().length >= w.this.k)) {
            break label347;
          }
          w localw = w.this;
          localw.h -= ((ToServiceMsg)???).getWupBuffer().length;
          w.a(w.this, (ToServiceMsg)w.b(w.this).poll());
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            synchronized (w.a(w.this))
            {
              if ((w.this.h >= w.this.g) && (!w.d(w.this)))
              {
                w.a(w.this, true);
                w.c(w.this).post(w.this.e);
                if (j > 0)
                {
                  w.this.d.put(Integer.valueOf(((ToServiceMsg)???).getRequestSsoSeq()), localArrayList);
                  w.f(w.this).put(Integer.valueOf(((ToServiceMsg)???).getRequestSsoSeq()), localObject6);
                  localObject5 = ((SSOLoginMerge.BusiBuffData)localObject5).toByteArray();
                  localObject6 = new ByteArrayOutputStream();
                  com.tencent.qphone.base.util.i.a((byte[])localObject5, (OutputStream)localObject6);
                  localObject6 = w.b(((ByteArrayOutputStream)localObject6).toByteArray());
                  ((ToServiceMsg)???).putWupBuffer((byte[])localObject6);
                  ((ToServiceMsg)???).getAttributes().put("mergeCount", Integer.valueOf(j));
                  ((ToServiceMsg)???).getAttributes().put("noRespCount", Integer.valueOf(i));
                  if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.NetConnTag", 4, "Delay ToServiceMsg ssoseq: " + ((ToServiceMsg)???).getRequestSsoSeq() + " delayWaitSendList buffer size is " + localObject5.length + ", zip size is " + localObject6.length);
                  }
                }
                if (??? == null) {
                  continue;
                }
                ((ToServiceMsg)???).addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
                w.a(w.this, (ToServiceMsg)???);
                return;
                localException = localException;
                QLog.d("MSF.C.NetConnTag", 1, "add delayMsg to send error, close LoginMerge. " + localException, localException);
                w.this.n = false;
                if (w.b(w.this).size() <= 0) {
                  continue;
                }
                localToServiceMsg1 = (ToServiceMsg)w.b(w.this).poll();
                if (localToServiceMsg1 == null) {
                  continue;
                }
                w.a(w.this, localToServiceMsg1);
                continue;
                if ("RegPrxySvc.getOffMsg".equals(localToServiceMsg2.getServiceCmd()))
                {
                  localToServiceMsg1.getAttributes().put("infoLoginMsg", localToServiceMsg2);
                  continue;
                }
                if (!"RegPrxySvc.infoSync".equals(localToServiceMsg2.getServiceCmd())) {
                  continue;
                }
                localToServiceMsg1.getAttributes().put("infoLoginMsg", localToServiceMsg2);
                continue;
                ??? = w.this;
                ((w)???).h -= localToServiceMsg2.getWupBuffer().length;
                if (k == 0)
                {
                  localToServiceMsg1.setUin(localToServiceMsg2.getUin());
                  localBusiBuffItem = new SSOLoginMerge.BusiBuffItem();
                  localBusiBuffItem.SeqNo.set(localToServiceMsg2.getRequestSsoSeq());
                  localBusiBuffItem.ServiceCmd.set(localToServiceMsg2.getServiceCmd());
                  if (localToServiceMsg2.getWupBuffer().length < 4)
                  {
                    localBusiBuffItem.BusiBuffLen.set(w.b(localToServiceMsg2.getWupBuffer()).length);
                    if (localToServiceMsg2.getWupBuffer().length < 4) {
                      continue;
                    }
                    ??? = new byte[localToServiceMsg2.getWupBuffer().length - 4];
                    System.arraycopy(localToServiceMsg2.getWupBuffer(), 4, ???, 0, ???.length);
                    localBusiBuffItem.BusiBuff.set(ByteStringMicro.copyFrom((byte[])???));
                    localBusiBuffItem.NeedResp.set(localToServiceMsg2.isNeedCallback());
                    ((SSOLoginMerge.BusiBuffData)localObject5).BusiBuffVec.add(localBusiBuffItem);
                    localArrayList.add(Integer.valueOf(localToServiceMsg2.getRequestSsoSeq()));
                    ((ArrayList)localObject6).add(localToServiceMsg2);
                    w.this.c.put(Integer.valueOf(localToServiceMsg2.getRequestSsoSeq()), localToServiceMsg2);
                    localToServiceMsg2.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(w.m().incrementAndGet()));
                    if (localToServiceMsg2.getTimeout() != -1L) {
                      continue;
                    }
                    localToServiceMsg2.setTimeout(30000L);
                    ??? = w.this.C.msfAlarmer.a(localToServiceMsg2, localToServiceMsg2.getTimeout());
                    localToServiceMsg2.addAttribute("to_timeoutCallbacker", ???);
                    if (com.tencent.mobileqq.msf.core.a.a.w())
                    {
                      l = localToServiceMsg2.getTimeout() - com.tencent.mobileqq.msf.core.a.a.y();
                      if (l > 0L) {
                        localToServiceMsg2.addAttribute("to_predetect_timeoutCallbacker", w.this.C.msfAlarmer.b(localToServiceMsg2, l));
                      }
                    }
                    com.tencent.mobileqq.msf.core.c.i.a(true, w.e(w.this), localToServiceMsg2.getWupBuffer().length, localToServiceMsg2.getServiceCmd(), 0, w.this.a.o().l, w.this.a.o().m);
                    break;
                  }
                }
                else
                {
                  if (localToServiceMsg1.getUin().equals(localToServiceMsg2.getUin())) {
                    continue;
                  }
                  w.b(w.this).a(localToServiceMsg2);
                  ??? = w.this;
                  ((w)???).h += localToServiceMsg2.getWupBuffer().length;
                  continue;
                }
                localBusiBuffItem.BusiBuffLen.set(localToServiceMsg2.getWupBuffer().length);
                continue;
                ??? = localToServiceMsg2.getWupBuffer();
                continue;
                ??? = w.this.C.msfAlarmer.a(localToServiceMsg2, localToServiceMsg2.getTimeout());
                continue;
              }
              if ((!w.d(w.this)) && (w.b(w.this).size() >= w.this.f))
              {
                w.a(w.this, true);
                w.c(w.this).post(w.this.e);
              }
            }
            if ((!w.d(w.this)) && (!w.b(w.this).isEmpty()))
            {
              w.c(w.this).postDelayed(w.this.e, w.this.i);
              w.a(w.this, true);
            }
          }
        }
        w.a(w.this, false);
      }
      label347:
      ??? = new ToServiceMsg("MSF SSOPackageMerge", w.e(w.this), "SSO.LoginMerge");
      ((ToServiceMsg)???).setAppId(MsfCore.mobileQQAppid);
      ((ToServiceMsg)???).setMsfCommand(MsfCommand.unknown);
      if (((ToServiceMsg)???).getRequestSsoSeq() == -1) {
        ((ToServiceMsg)???).setRequestSsoSeq(MsfCore.getNextSeq());
      }
      ((ToServiceMsg)???).setTimeout(30000L);
      ((ToServiceMsg)???).setNeedCallback(false);
      ArrayList localArrayList = new ArrayList();
      Object localObject6 = new ArrayList();
      Object localObject5 = new SSOLoginMerge.BusiBuffData();
      int i = j;
      if (i > w.b(w.this).size()) {
        j = w.b(w.this).size();
      }
      for (;;)
      {
        label466:
        int k;
        ToServiceMsg localToServiceMsg2;
        int m;
        if (k < j)
        {
          localToServiceMsg2 = (ToServiceMsg)w.b(w.this).poll();
          if (localToServiceMsg2 != null) {
            if ("RegPrxySvc.infoLogin".equals(localToServiceMsg2.getServiceCmd()))
            {
              ((ToServiceMsg)???).getAttributes().put("infoLoginMsg", localToServiceMsg2);
              if (localToServiceMsg2.isNeedCallback()) {
                break label1592;
              }
              i += 1;
              m += localToServiceMsg2.getWupBuffer().length;
              if ((m < w.this.g) || (k == 0)) {
                break label971;
              }
              w.b(w.this).a(localToServiceMsg2);
              j = k;
            }
          }
        }
        for (;;)
        {
          ToServiceMsg localToServiceMsg1;
          label971:
          SSOLoginMerge.BusiBuffItem localBusiBuffItem;
          label1592:
          break label1632;
          continue;
          j = i;
          break label1620;
          label1608:
          localObject5 = null;
          localObject6 = null;
          localArrayList = null;
          Object localObject3 = null;
          break;
          label1620:
          m = 0;
          i = 0;
          k = 0;
          break label466;
        }
        label1632:
        k += 1;
      }
    }
  }
  
  class c
    extends Thread
  {
    long a = 0L;
    
    c() {}
    
    private void a(ToServiceMsg paramToServiceMsg, String paramString1, String paramString2)
    {
      w.this.c(paramToServiceMsg.getRequestSsoSeq());
    }
    
    public void run()
    {
      ToServiceMsg localToServiceMsg;
      String str;
      int m;
      Object localObject2;
      long l1;
      long l2;
      int k;
      int i;
      for (;;)
      {
        try
        {
          localToServiceMsg = (ToServiceMsg)w.g(w.this).k();
          if (localToServiceMsg != null) {
            try
            {
              str = localToServiceMsg.getServiceCmd();
              m = str.indexOf("#");
              if (m == -1) {
                break label2082;
              }
              localObject2 = str.substring(m + 1, str.length()) + "_new";
              str = str.substring(0, m);
              l1 = ((Long)localToServiceMsg.getAttribute("__timestamp_addSendQueue", Long.valueOf(0L))).longValue();
              l2 = System.currentTimeMillis();
              w.this.C.configManager.a(localToServiceMsg, l2);
              if (localToServiceMsg.getWupBuffer() == null) {
                break label942;
              }
              k = 0;
              if (NetConnInfoCenterImpl.isWifiConn())
              {
                i = 1;
                label145:
                if (i != w.K)
                {
                  w.K = i;
                  w.d();
                  QLog.d("MSF.C.NetConnTag", 1, "resetUserSimpleHead network type changed");
                }
                if (com.tencent.mobileqq.msf.core.auth.d.f.containsKey(localToServiceMsg.getUin()))
                {
                  w.this.C.getAccountCenter().p(localToServiceMsg.getUin());
                  com.tencent.mobileqq.msf.core.auth.d.f.remove(localToServiceMsg.getUin());
                  QLog.d("MSF.C.NetConnTag", 1, "ReloadKey for uin:" + MsfSdkUtils.getShortUin(localToServiceMsg.getUin()) + " while ssoSeq=" + localToServiceMsg.getRequestSsoSeq());
                }
                if (!w.this.a.b())
                {
                  w.d();
                  QLog.d("MSF.C.NetConnTag", 1, "resetUserSimpleHead not connect network");
                }
                arrayOfByte1 = w.f(localToServiceMsg);
              }
            }
            catch (Throwable localThrowable1)
            {
              byte[] arrayOfByte1;
              label495:
              QLog.d("MSF.C.NetConnTag", 1, localThrowable1.toString(), localThrowable1);
              a(localToServiceMsg, "发送错误", localThrowable1.toString());
              w.g(w.this).remove(localToServiceMsg);
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          QLog.d("MSF.C.NetConnTag", 1, localThrowable2.toString(), localThrowable2);
        }
        try
        {
          if (localToServiceMsg.getWupBuffer() == null)
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("cmd", localToServiceMsg.getServiceCmd());
            w.this.C.getStatReporter().a("dim.Msf.SendNullMsg", false, 0L, 0L, localHashMap, false, false);
          }
          if (!w.n())
          {
            if (CodecWarpper.getSharedObjectVersion() != 600) {
              w.this.C.getStatReporter().a("dim.Msf.SOReplaceFail", false, 0L, 0L, null, false, false);
            }
            w.a(true);
          }
        }
        catch (Exception localException3)
        {
          QLog.d("MSF.C.NetConnTag", 1, "failed to report send null msg event ", localException3);
          continue;
          arrayOfByte2 = CodecWarpper.encodeRequest(localToServiceMsg.getRequestSsoSeq(), n.d(), n.f(), n.g(), "", str, w.this.b(), localToServiceMsg.getAppId(), w.this.C.getMsfAppid(), localToServiceMsg.getUin(), (byte)0, i, localException1, localToServiceMsg.getWupBuffer(), false);
          continue;
        }
        if (591 != CodecWarpper.getSharedObjectVersion()) {
          break label881;
        }
        arrayOfByte1 = CodecWarpper.encodeRequest(localToServiceMsg.getRequestSsoSeq(), n.d(), n.f(), n.g(), "", str, w.this.b(), localToServiceMsg.getAppId(), w.this.C.getMsfAppid(), localToServiceMsg.getUin(), (byte)0, i, localToServiceMsg.getWupBuffer(), false);
        if (arrayOfByte1 != null) {
          localToServiceMsg.getAttributes().put("reqPkgSize", Integer.valueOf(arrayOfByte1.length));
        }
        QLog.d("MSF.C.NetConnTag", 1, "pa ok: " + localToServiceMsg.getRequestSsoSeq());
        if (arrayOfByte1 != null) {
          break label949;
        }
        w.this.c(localToServiceMsg.getRequestSsoSeq());
      }
      label553:
      label881:
      label942:
      label949:
      label1475:
      label1534:
      label2082:
      label2095:
      label2102:
      for (;;)
      {
        Object localObject1 = localToServiceMsg.getMsfCommand();
        localObject2 = MsfCommand._msf_kickedAndCleanTokenResp;
        if (localObject1 == localObject2) {}
        boolean bool1;
        try
        {
          localObject1 = (FromServiceMsg)localToServiceMsg.getAttribute(localToServiceMsg.getServiceCmd());
          w.this.C.getAccountCenter().l(((FromServiceMsg)localObject1).getUin());
          ((FromServiceMsg)localObject1).setBusinessFail(2012, ((FromServiceMsg)localObject1).getBusinessFailMsg());
          bool1 = false;
          if (localToServiceMsg.getAttributes().containsKey("_attr_sameDevice")) {
            bool1 = ((Boolean)localToServiceMsg.getAttribute("_attr_sameDevice")).booleanValue();
          }
          ((FromServiceMsg)localObject1).addAttribute("_attr_sameDevice", Boolean.valueOf(bool1));
          MsfSdkUtils.addFromMsgProcessName("*", (FromServiceMsg)localObject1);
          w.this.C.addRespToQuque(null, (FromServiceMsg)localObject1);
          w.this.a.a(com.tencent.qphone.base.a.a);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int n;
            byte[] arrayOfByte2;
            QLog.e("MSF.C.NetConnTag", 1, "send offlineMsg to app error " + localException2.toString());
          }
        }
        Thread.sleep(10L);
        break;
        break;
        if (NetConnInfoCenterImpl.isMobileConn())
        {
          n = NetConnInfoCenterImpl.getMobileNetworkType() + 100;
          m = n;
          if (n > 254)
          {
            n = 254;
            m = n;
            if (QLog.isColorLevel())
            {
              QLog.d("MSF.C.NetConnTag", 2, "error,netWorkType is " + 254);
              m = n;
            }
          }
        }
        else
        {
          if (this.a != 0L)
          {
            i = k;
            if (l2 - this.a <= 60000L) {
              break label145;
            }
          }
          this.a = l2;
          try
          {
            NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
            i = k;
          }
          catch (Exception localException1)
          {
            QLog.d("MSF.C.NetConnTag", 1, "checkConnInfo " + localException1);
            i = k;
          }
          break label145;
          arrayOfByte2 = new byte[0];
          break label495;
          if ((localToServiceMsg.getUin().equals("0")) || (((Boolean)localToServiceMsg.getAttribute("grayCheck", Boolean.valueOf(false))).booleanValue()) || (localToServiceMsg.getAppId() == -1) || (localToServiceMsg.getAppId() == 100)) {
            break label2095;
          }
          w.b(w.this, localToServiceMsg);
          break label2095;
        }
        for (;;)
        {
          if (bool1) {
            break label2102;
          }
          l2 = System.currentTimeMillis();
          if (l2 - l1 > localToServiceMsg.getTimeout())
          {
            if (!QLog.isColorLevel()) {
              break label553;
            }
            QLog.d("MSF.C.NetConnTag", 2, localToServiceMsg + " is already sendTimeout,break.");
            break label553;
          }
          if ((w.P != 0L) && (l2 - w.P > com.tencent.mobileqq.msf.core.a.a.P()) && (w.this.a.b()))
          {
            if (w.P < w.this.a.o().c()) {
              break label1475;
            }
            w.P = 0L;
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "lastMessageTimeTooLong Close socket now. System.currentTimeMillis() - lastRecvSsoRespTime :" + (System.currentTimeMillis() - w.P) + " getNetIdleTimeInterval()" + com.tencent.mobileqq.msf.core.a.a.P());
            }
            w.this.a(com.tencent.qphone.base.a.o);
          }
          for (;;)
          {
            if ((w.P != 0L) && (l2 - w.P > 360000L) && (w.this.a.b()) && (w.P >= w.this.a.o().c()) && (!w.this.L.get()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag", 2, "no receive data for 5 minutes, start fast net detect now.");
              }
              w.b(w.this, false);
            }
            try
            {
              localToServiceMsg.addAttribute("__timestamp_msf2net_boot", Long.valueOf(SystemClock.elapsedRealtime()));
              localToServiceMsg.addAttribute("__timestamp_msf2net", Long.valueOf(0L));
              localToServiceMsg.addAttribute("_tag_socket", w.D);
              localToServiceMsg.addAttribute("_tag_localsocket", w.E);
              bool2 = w.this.a.a(localToServiceMsg.getAppId(), localToServiceMsg.getAppSeq(), str, (String)localObject2, localToServiceMsg.getMsfCommand(), localToServiceMsg.getUin(), localToServiceMsg.getRequestSsoSeq(), arrayOfByte2, localToServiceMsg);
              bool1 = bool2;
            }
            catch (Throwable localThrowable3)
            {
              for (;;)
              {
                QLog.d("MSF.C.NetConnTag", 1, "send msg error " + localThrowable3, localThrowable3);
              }
            }
            if (bool1) {
              break label1534;
            }
            localToServiceMsg.getAttributes().remove("__timestamp_msf2net_boot");
            localToServiceMsg.getAttributes().remove("__timestamp_msf2net");
            localToServiceMsg.getAttributes().remove("_tag_socket");
            localToServiceMsg.getAttributes().remove("_tag_localsocket");
            localToServiceMsg.getAttributes().put("_tag_senddata_error", Boolean.valueOf(true));
            w.this.a.a(com.tencent.qphone.base.a.d);
            try
            {
              Thread.sleep(BaseConstants.reSendIntrevTime);
            }
            catch (Exception localException4)
            {
              QLog.d("MSF.C.NetConnTag", 1, localException4.toString(), localException4);
            }
            w.P = 0L;
          }
          continue;
          m = 0;
          n = 0;
          int i1 = 0;
          boolean bool2 = "SSO.LoginMerge".equals(str);
          if (bool2) {}
          for (m = n;; m = i1)
          {
            try
            {
              n = ((Integer)localToServiceMsg.getAttributes().get("mergeCount")).intValue();
              m = n;
              int i2 = ((Integer)localToServiceMsg.getAttributes().get("noRespCount")).intValue();
              m = i2;
              i1 = m;
              if (!"SSO.LoginMerge".equals(str))
              {
                i1 = m;
                if (!localToServiceMsg.isNeedCallback()) {
                  i1 = 1;
                }
              }
              com.tencent.mobileqq.a.a.b.a(str, localToServiceMsg.getRequestSsoSeq(), arrayOfByte2.length, n, i1);
              if ((localToServiceMsg.getUin() != null) && (localToServiceMsg.getUin().length() > 4) && (!localToServiceMsg.getServiceCmd().startsWith("login.")) && (!localToServiceMsg.getServiceCmd().startsWith("wtlogin.")) && (!localToServiceMsg.getServiceCmd().equals("ConfigService.ClientReq")) && (!localToServiceMsg.getServiceCmd().equals("GrayUinPro.Check")) && (!localToServiceMsg.getServiceCmd().equals("account.RequestReBindMblWTLogin_emp")) && (!localToServiceMsg.getServiceCmd().equals("account.RequestVerifyWTLogin_emp")) && (!localToServiceMsg.getServiceCmd().equals("ConnAuthSvr.get_app_info_emp")) && (!localToServiceMsg.getServiceCmd().equals("ConnAuthSvr.sdk_auth_api_emp")) && (!localToServiceMsg.getServiceCmd().equals("ConnAuthSvr.get_auth_api_list_emp")) && (!w.aa.contains(localToServiceMsg.getUin())))
              {
                if (w.q.get(localToServiceMsg.getUin()) == null)
                {
                  ConcurrentLinkedQueue localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
                  w.q.put(localToServiceMsg.getUin(), localConcurrentLinkedQueue);
                }
                ((ConcurrentLinkedQueue)w.q.get(localToServiceMsg.getUin())).offer(Integer.valueOf(localToServiceMsg.getRequestSsoSeq()));
                QLog.d("MSF.C.NetConnTag", 1, "send Packet addQueue, ssoSeq=" + localToServiceMsg.getRequestSsoSeq() + ", uin=" + MsfSdkUtils.getShortUin(localToServiceMsg.getUin()));
              }
              localToServiceMsg.addAttribute("__timestamp_msf2net", Long.valueOf(System.currentTimeMillis()));
              if (localToServiceMsg.getServiceCmd().startsWith("SharpSvr.c2s")) {
                w.H = SystemClock.elapsedRealtime();
              }
              if ((!w.this.W.get()) || (w.this.V != -1)) {
                break;
              }
              w.this.V = localToServiceMsg.getRequestSsoSeq();
              QLog.d("MSF.C.NetConnTag", 1, "set afterReloadD2SendSeq " + w.this.V);
            }
            catch (Exception localException5)
            {
              localException5.printStackTrace();
            }
            n = m;
          }
          localObject2 = null;
          break;
          int j = (byte)m;
          break label145;
          bool1 = false;
        }
      }
    }
  }
  
  public class d
    implements Runnable
  {
    String a;
    long b;
    String c;
    
    public d(String paramString1, String paramString2, long paramLong)
    {
      this.a = paramString1;
      this.c = paramString2;
      this.b = paramLong;
    }
    
    public void run()
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a).append("+").append(this.b).append("+").append(this.c).append("\n");
        FileOutputStream localFileOutputStream = new FileOutputStream(new File(w.this.t), true);
        localFileOutputStream.write(localStringBuilder.toString().getBytes());
        localFileOutputStream.close();
        return;
      }
      catch (Exception localException)
      {
        QLog.d("MSF.C.NetConnTag", 1, "connect ssid file write failed");
      }
    }
  }
  
  class e
    implements Runnable
  {
    e() {}
    
    public void run()
    {
      boolean bool = false;
      try
      {
        HashMap localHashMap = new HashMap();
        File localFile = new File(w.this.t);
        if (localFile.isFile())
        {
          FileReader localFileReader = new FileReader(localFile);
          BufferedReader localBufferedReader = new BufferedReader(localFileReader);
          int i = 1;
          for (;;)
          {
            String str = localBufferedReader.readLine();
            if (str == null) {
              break;
            }
            localHashMap.put("SSID" + String.valueOf(i), str);
            i += 1;
          }
          localFileReader.close();
          if (localFile.delete())
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "reportConnectWiFiThread succ to delete file");
            }
            w.r.clear();
            bool = true;
          }
          MsfService.core.getStatReporter().a("dim.Msf.ConnectWiFiSSID", bool, 0L, 0L, localHashMap, false, false);
          return;
        }
        QLog.d("MSF.C.NetConnTag", 1, "reportConnectWiFiThread not a file");
        return;
      }
      catch (Exception localException)
      {
        QLog.d("MSF.C.NetConnTag", 1, "failed to report connect wifi info " + localException.toString());
      }
    }
  }
  
  class f
    implements Runnable
  {
    int a = 0;
    
    public f(int paramInt)
    {
      this.a = paramInt;
    }
    
    public void run()
    {
      try
      {
        long l = System.currentTimeMillis();
        Object localObject = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/com/tencent/mobileqq/" + "com.tencent.mobileqq_logcat_" + this.a + "_" + QLog.getLogFileFormatter().format(Long.valueOf(l)) + ".log";
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "start to store logcat " + (String)localObject);
        }
        localObject = "logcat -b main -b system -b radio -b events -v time -f " + (String)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "start to execute command " + (String)localObject);
        }
        localObject = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String)localObject).getErrorStream()));
        for (;;)
        {
          String str = ((BufferedReader)localObject).readLine();
          if (str == null) {
            break;
          }
          QLog.d("MSF.C.NetConnTag", 1, "logcat storage error:" + str);
        }
        localException.close();
      }
      catch (Exception localException)
      {
        QLog.d("MSF.C.NetConnTag", 1, "failed to store logcat ", localException);
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */