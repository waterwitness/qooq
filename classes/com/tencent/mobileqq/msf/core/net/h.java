package com.tencent.mobileqq.msf.core.net;

import android.net.Proxy;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.w;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

public class h
{
  public static String H = "";
  private static String I;
  public static final String a = "MSF.C.NetConnTag";
  public static final int b = -10008;
  public static final int c = 300000;
  public static final int e = 302;
  static CopyOnWriteArraySet f = new CopyOnWriteArraySet();
  public static byte s = -1;
  public static long t = -1L;
  Thread A = null;
  long B = 0L;
  AtomicBoolean C = new AtomicBoolean(false);
  int D = 0;
  boolean E = false;
  boolean F = false;
  long G = 0L;
  Runnable d = null;
  MsfCore g;
  public com.tencent.mobileqq.msf.core.net.b.n h;
  protected g i;
  String j = "";
  String[] k = null;
  String[] l = null;
  long m = 0L;
  ArrayList n = new ArrayList();
  long o = 0L;
  long p = 0L;
  public long q;
  long r = 0L;
  public int u = 2;
  ArrayList v = new ArrayList();
  ArrayList w = new ArrayList();
  Thread x = null;
  long y = 0L;
  boolean z = false;
  
  static
  {
    I = "UTF-8";
  }
  
  public h(MsfCore paramMsfCore)
  {
    this.g = paramMsfCore;
    this.i = new g(paramMsfCore, true);
    this.h = new com.tencent.mobileqq.msf.core.net.b.j(paramMsfCore);
  }
  
  private a a(ArrayList paramArrayList, boolean paramBoolean, com.tencent.mobileqq.msf.core.d paramd)
  {
    a locala = new a();
    locala.i = System.currentTimeMillis();
    locala.b = paramd.a();
    locala.g = NetConnInfoCenterImpl.getSystemNetworkType();
    locala.j = 0;
    locala.k = 0;
    locala.l = 0;
    locala.m = 0;
    a(paramd, paramBoolean, locala);
    paramArrayList.add(locala);
    return locala;
  }
  
  static void a()
  {
    Iterator localIterator = f.iterator();
    while (localIterator.hasNext()) {
      CodecWarpper.setUseSimpleHead((String)localIterator.next(), false);
    }
    f.clear();
  }
  
  private void a(com.tencent.mobileqq.msf.core.d paramd, boolean paramBoolean, a parama)
  {
    if (paramd.b().equalsIgnoreCase("http")) {
      this.i.a(paramd, 2048, 10000, new b(this.g), paramBoolean, parama);
    }
    for (;;)
    {
      H = parama.f;
      return;
      this.i.a(paramd, 2048, 10000, new p(this.g), paramBoolean, parama);
    }
  }
  
  static void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      f.add(paramString);
    }
    for (;;)
    {
      CodecWarpper.setUseSimpleHead(paramString, paramBoolean);
      return;
      f.remove(paramString);
    }
  }
  
  private boolean a(CopyOnWriteArrayList paramCopyOnWriteArrayList1, CopyOnWriteArrayList paramCopyOnWriteArrayList2, ArrayList paramArrayList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "NetChanged selectAndConnect...");
    }
    int i1 = 1;
    int i6;
    int i5;
    int i2;
    int i3;
    label64:
    long l1;
    label297:
    int i4;
    label376:
    label929:
    label1053:
    label1066:
    label1072:
    Object localObject2;
    for (;;)
    {
      if (i1 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "NetChanged start connect...");
        }
        i6 = 0;
        int i7 = 0;
        i5 = 0;
        i2 = i6;
        for (;;)
        {
          try
          {
            if (x())
            {
              i1 = 0;
              i3 = 0;
              i2 = i6;
              if (i3 >= paramCopyOnWriteArrayList1.size()) {
                break label1490;
              }
              i2 = i6;
              localObject1 = (com.tencent.mobileqq.msf.core.d)paramCopyOnWriteArrayList1.get(i3);
              if (i3 == 0)
              {
                i2 = i6;
                l1 = SystemClock.elapsedRealtime();
                i2 = i6;
                s = com.tencent.mobileqq.msf.core.c.m.a(false, t, l1);
              }
              i2 = i6;
              localObject1 = a(paramArrayList, paramBoolean, (com.tencent.mobileqq.msf.core.d)localObject1);
              i2 = i6;
              if (((a)localObject1).e == q.c)
              {
                i2 = i6;
                if (!this.C.get()) {
                  break label1496;
                }
                i2 = i6;
                this.C.set(false);
                break label1496;
              }
              i2 = i6;
              if (((a)localObject1).e == q.m)
              {
                i3 -= 1;
                i2 = i1 + 1;
                i1 = i2;
                if (i2 > 3)
                {
                  i2 = i6;
                  this.C.set(false);
                  return false;
                }
              }
              else
              {
                i2 = i6;
                if (((a)localObject1).e != q.t)
                {
                  i2 = i6;
                  if (((a)localObject1).e != q.q) {
                    break label1498;
                  }
                }
                if (i3 != 0) {
                  break label1498;
                }
                i2 = i6;
                if (this.C.get()) {
                  break label1498;
                }
                i2 = i6;
                b(((a)localObject1).b);
                break label1498;
              }
              i2 = i6;
              if (((a)localObject1).h <= 0) {
                break label1507;
              }
              i2 = i6;
              Thread.sleep(((a)localObject1).h);
              i2 = i6;
              if (x()) {
                break label1507;
              }
              i2 = i6;
              if (!QLog.isColorLevel()) {
                break label1501;
              }
              i2 = i6;
              QLog.d("MSF.C.NetConnTag", 2, "NetChanged from wifi to mobile connect again");
              break label1501;
            }
            i2 = i6;
            if (w() == null) {
              break label1066;
            }
            i1 = 0;
            i4 = 0;
            i2 = i6;
            i3 = i7;
            if (i4 >= paramCopyOnWriteArrayList2.size()) {
              break label1518;
            }
            i2 = i6;
            Object localObject1 = (com.tencent.mobileqq.msf.core.d)paramCopyOnWriteArrayList2.get(i4);
            if (i4 == 0)
            {
              i2 = i6;
              l1 = SystemClock.elapsedRealtime();
              i2 = i6;
              s = com.tencent.mobileqq.msf.core.c.m.a(false, t, l1);
            }
            i2 = i6;
            if (((com.tencent.mobileqq.msf.core.d)localObject1).g != 1) {
              break label1535;
            }
            i2 = i6;
            localObject1 = a(paramArrayList, paramBoolean, (com.tencent.mobileqq.msf.core.d)localObject1);
            i2 = i6;
            if (((a)localObject1).e == q.c)
            {
              i2 = i6;
              if (!this.C.get()) {
                break label1516;
              }
              i2 = i6;
              this.C.set(false);
              break label1516;
            }
            i2 = i6;
            if (((a)localObject1).e == q.m)
            {
              i5 = i4 - 1;
              i1 += 1;
              i3 = i1;
              if (i1 <= 3) {
                continue;
              }
              i3 = i7;
              break label1518;
              i1 = i3;
              i2 = i3;
              if (i4 >= paramCopyOnWriteArrayList2.size()) {
                break;
              }
              i2 = i3;
              localObject1 = a(paramArrayList, paramBoolean, (com.tencent.mobileqq.msf.core.d)paramCopyOnWriteArrayList2.get(i4));
              i2 = i3;
              if (((a)localObject1).e != q.c) {
                continue;
              }
              i2 = i3;
              if (!this.C.get()) {
                break label1527;
              }
              i2 = i3;
              this.C.set(false);
              break label1527;
            }
            i2 = i6;
            if (((a)localObject1).e != q.t)
            {
              i5 = i4;
              i3 = i1;
              i2 = i6;
              if (((a)localObject1).e != q.q) {}
            }
            else
            {
              i5 = i4;
              i3 = i1;
              if (i4 == 0)
              {
                i5 = i4;
                i3 = i1;
                i2 = i6;
                if (!this.C.get())
                {
                  i2 = i6;
                  b(((a)localObject1).b);
                  i3 = i1;
                  i5 = i4;
                }
              }
            }
            i4 = i3;
            i2 = i6;
            i3 = i5;
            i1 = i4;
            if (((a)localObject1).h <= 0) {
              break label1539;
            }
            i2 = i6;
            Thread.sleep(((a)localObject1).h);
            i2 = i6;
            i3 = i5;
            i1 = i4;
            if (!x()) {
              break label1539;
            }
            i2 = i6;
            if (!QLog.isColorLevel()) {
              break label1529;
            }
            i2 = i6;
            QLog.d("MSF.C.NetConnTag", 2, "NetChanged from mobile to wifi connect again");
            break label1529;
            i2 = i3;
            if (((a)localObject1).e == q.m)
            {
              i4 -= 1;
              i2 = i5 + 1;
              i1 = i2;
              if (i2 > 3)
              {
                i2 = i3;
                this.C.set(false);
                return false;
              }
            }
            else
            {
              i2 = i3;
              if (((a)localObject1).e != q.t)
              {
                i2 = i3;
                if (((a)localObject1).e != q.q) {
                  break label1548;
                }
              }
              if (i4 != 0) {
                break label1548;
              }
              i2 = i3;
              if (this.C.get()) {
                break label1548;
              }
              i2 = i3;
              b(((a)localObject1).b);
              break label1548;
            }
            i2 = i3;
            if (((a)localObject1).h <= 0) {
              break label1053;
            }
            i2 = i3;
            Thread.sleep(((a)localObject1).h);
            i2 = i3;
            if (!x()) {
              break label1053;
            }
            i4 = 1;
            i3 = 1;
            i1 = i3;
            i2 = i4;
            if (!QLog.isColorLevel()) {
              break;
            }
            i2 = i4;
            QLog.d("MSF.C.NetConnTag", 2, "NetChanged from mobile to wifi connect again");
            i1 = i3;
          }
          catch (Exception localException)
          {
            i1 = i2;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MSF.C.NetConnTag", 2, "selectAndConnect error " + localException, localException);
          i1 = i2;
          break;
          i4 += 1;
          i5 = i1;
        }
        i3 = 0;
        i4 = 0;
        i1 = i5;
        i2 = i6;
        if (i4 < paramCopyOnWriteArrayList2.size())
        {
          i2 = i6;
          localObject2 = (com.tencent.mobileqq.msf.core.d)paramCopyOnWriteArrayList2.get(i4);
          if (i4 == 0)
          {
            i2 = i6;
            l1 = SystemClock.elapsedRealtime();
            i2 = i6;
            s = com.tencent.mobileqq.msf.core.c.m.a(false, t, l1);
          }
          i2 = i6;
          localObject2 = a(paramArrayList, paramBoolean, (com.tencent.mobileqq.msf.core.d)localObject2);
          i2 = i6;
          if (((a)localObject2).e == q.c)
          {
            i2 = i6;
            if (!this.C.get()) {
              break label1555;
            }
            i2 = i6;
            this.C.set(false);
            break label1555;
          }
          i2 = i6;
          if (((a)localObject2).e == q.m)
          {
            i1 = i4 - 1;
            i2 = i3 + 1;
            i3 = i1;
            i1 = i2;
            if (i2 > 3)
            {
              i2 = i6;
              this.C.set(false);
              return false;
            }
          }
          else
          {
            i2 = i6;
            if (((a)localObject2).e != q.t)
            {
              i2 = i6;
              if (((a)localObject2).e != q.q) {
                break label1557;
              }
            }
            if (i4 != 0) {
              break label1557;
            }
            i2 = i6;
            if (this.C.get()) {
              break label1557;
            }
            i2 = i6;
            b(((a)localObject2).b);
            break label1557;
          }
        }
      }
    }
    for (;;)
    {
      i2 = i6;
      if (((a)localObject2).h > 0)
      {
        i2 = i6;
        Thread.sleep(((a)localObject2).h);
        i2 = i6;
        if (x())
        {
          i2 = i6;
          if (QLog.isColorLevel())
          {
            i2 = i6;
            QLog.d("MSF.C.NetConnTag", 2, "NetChanged from mobile to wifi connect again");
          }
          i1 = 1;
          break;
        }
      }
      i4 = i3 + 1;
      i3 = i1;
      break label1072;
      if ((this.C.get()) && (this.E) && (!this.F) && (this.w.size() > 0))
      {
        this.C.set(false);
        this.E = false;
        this.F = false;
        l1 = System.currentTimeMillis();
        long l2 = this.G;
        this.g.getStatReporter().a(b(), this.D, l1 - l2, this.w);
        this.w.clear();
      }
      return false;
      label1490:
      i1 = 0;
      break label1504;
      label1496:
      return true;
      label1498:
      break label297;
      label1501:
      i1 = 1;
      label1504:
      break;
      label1507:
      i3 += 1;
      break label64;
      label1516:
      return true;
      for (;;)
      {
        label1518:
        i5 = 0;
        i4 = 0;
        break;
        label1527:
        return true;
        label1529:
        i3 = 1;
      }
      label1535:
      i3 = i4;
      label1539:
      i4 = i3 + 1;
      break label376;
      label1548:
      i1 = i5;
      break label929;
      label1555:
      return true;
      label1557:
      i1 = i3;
      i3 = i4;
    }
  }
  
  /* Error */
  private static void b(android.content.Context paramContext)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 12
    //   12: iconst_2
    //   13: ldc_w 355
    //   16: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 361	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   23: ldc_w 363
    //   26: invokevirtual 369	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: astore_3
    //   30: aload_3
    //   31: astore_1
    //   32: new 371	java/io/FileOutputStream
    //   35: dup
    //   36: new 324	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   43: aload_0
    //   44: invokevirtual 375	android/content/Context:getFilesDir	()Ljava/io/File;
    //   47: invokevirtual 380	java/io/File:getParent	()Ljava/lang/String;
    //   50: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 382
    //   56: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 337	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokespecial 384	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   65: astore_0
    //   66: sipush 1024
    //   69: newarray <illegal type>
    //   71: astore_2
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 390	java/io/InputStream:read	([B)I
    //   77: istore 4
    //   79: iload 4
    //   81: ifle +86 -> 167
    //   84: aload_0
    //   85: aload_2
    //   86: iconst_0
    //   87: iload 4
    //   89: invokevirtual 396	java/io/OutputStream:write	([BII)V
    //   92: goto -20 -> 72
    //   95: astore_2
    //   96: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +30 -> 129
    //   102: ldc 12
    //   104: iconst_2
    //   105: new 324	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 398
    //   115: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_2
    //   119: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 337	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aload_2
    //   126: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 401	java/io/InputStream:close	()V
    //   137: aload_0
    //   138: ifnull +7 -> 145
    //   141: aload_0
    //   142: invokevirtual 402	java/io/OutputStream:close	()V
    //   145: return
    //   146: astore_0
    //   147: aconst_null
    //   148: astore_1
    //   149: aload_1
    //   150: ifnull +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 401	java/io/InputStream:close	()V
    //   157: aload_2
    //   158: ifnull +7 -> 165
    //   161: aload_2
    //   162: invokevirtual 402	java/io/OutputStream:close	()V
    //   165: aload_0
    //   166: athrow
    //   167: aload_1
    //   168: ifnull +7 -> 175
    //   171: aload_1
    //   172: invokevirtual 401	java/io/InputStream:close	()V
    //   175: aload_0
    //   176: ifnull -31 -> 145
    //   179: goto -38 -> 141
    //   182: astore_0
    //   183: goto -34 -> 149
    //   186: astore_3
    //   187: aload_0
    //   188: astore_2
    //   189: aload_3
    //   190: astore_0
    //   191: goto -42 -> 149
    //   194: astore_3
    //   195: aload_0
    //   196: astore_2
    //   197: aload_3
    //   198: astore_0
    //   199: goto -50 -> 149
    //   202: astore_2
    //   203: aconst_null
    //   204: astore_0
    //   205: goto -109 -> 96
    //   208: astore_2
    //   209: aconst_null
    //   210: astore_0
    //   211: goto -115 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramContext	android.content.Context
    //   3	169	1	localObject1	Object
    //   1	85	2	arrayOfByte	byte[]
    //   95	67	2	localException1	Exception
    //   188	9	2	localContext	android.content.Context
    //   202	1	2	localException2	Exception
    //   208	1	2	localException3	Exception
    //   29	2	3	localInputStream	java.io.InputStream
    //   186	4	3	localObject2	Object
    //   194	4	3	localObject3	Object
    //   77	11	4	i1	int
    // Exception table:
    //   from	to	target	type
    //   66	72	95	java/lang/Exception
    //   72	79	95	java/lang/Exception
    //   84	92	95	java/lang/Exception
    //   19	30	146	finally
    //   32	66	182	finally
    //   66	72	186	finally
    //   72	79	186	finally
    //   84	92	186	finally
    //   96	129	194	finally
    //   19	30	202	java/lang/Exception
    //   32	66	208	java/lang/Exception
  }
  
  private void b(boolean paramBoolean)
  {
    long l1 = SystemClock.elapsedRealtime();
    StringBuffer localStringBuffer;
    if ((this.m == 0L) || (l1 - this.m > Long.parseLong(com.tencent.mobileqq.msf.core.a.a.h())))
    {
      this.m = l1;
      localStringBuffer = new StringBuffer();
      com.tencent.mobileqq.msf.core.d locald;
      if (NetConnInfoCenterImpl.isWifiConn())
      {
        localIterator = this.g.getSsoListManager().h().iterator();
        while (localIterator.hasNext())
        {
          locald = (com.tencent.mobileqq.msf.core.d)localIterator.next();
          localStringBuffer.append(locald.b() + "//" + locald.c() + ":" + locald.d() + ",");
        }
      }
      Iterator localIterator = this.g.getSsoListManager().i().iterator();
      while (localIterator.hasNext())
      {
        locald = (com.tencent.mobileqq.msf.core.d)localIterator.next();
        localStringBuffer.append(locald.b() + "//" + locald.c() + ":" + locald.d() + ",");
      }
    }
    try
    {
      this.g.configManager.a(this.g.sender.f(), this.g.sender.e(), 60000L, NetConnInfoCenterImpl.isWifiConn(), localStringBuffer.toString(), paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MSF.C.NetConnTag", 2, localException.toString(), localException);
    }
  }
  
  public static boolean i()
  {
    return j() != null;
  }
  
  public static String j()
  {
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("ps").getInputStream()));
      localObject = localBufferedReader.readLine().split("\\s+");
      i4 = localObject.length;
      i2 = 0;
      i3 = 1;
      i1 = 0;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        BufferedReader localBufferedReader;
        Object localObject;
        int i4;
        int i2;
        int i3;
        int i1;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.NetConnTag", 2, "Error killing tcpdump, msg=" + localIOException.getMessage());
          continue;
          i2 += 1;
          i1 += 1;
        }
      }
    }
    if (i2 < i4)
    {
      if (localObject[i2].equalsIgnoreCase("PID")) {
        i3 = i1;
      }
    }
    else
    {
      do
      {
        localObject = localBufferedReader.readLine();
        if (localObject == null) {
          break;
        }
      } while ((!((String)localObject).contains(BaseApplication.getContext().getFilesDir().getParent() + "/txlib/" + "tcpdump")) || (((String)localObject).contains("sh -c")));
      localObject = ((String)localObject).split("\\s+");
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump uid:" + localObject[i3]);
      }
      localBufferedReader.close();
      return localObject[i3];
      localBufferedReader.close();
      return null;
    }
  }
  
  public static void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "tcpdump: stopTCPDump begin");
    }
    try
    {
      Object localObject = j();
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "tcpdump: stopTCPDump pid not find");
        }
      }
      else
      {
        localObject = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[] { "su", "-c", "kill " + (String)localObject }).getErrorStream()));
        for (;;)
        {
          String str = ((BufferedReader)localObject).readLine();
          if (str == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "tcpdump kill error=" + str);
          }
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump Error killing tcpdump, msg=" + localIOException.getMessage());
        return;
        localIOException.close();
      }
    }
  }
  
  private String w()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return System.getProperty("http.proxyHost");
    }
    return Proxy.getDefaultHost();
  }
  
  private boolean x()
  {
    return (NetConnInfoCenterImpl.isWifiConn()) || ((!NetConnInfoCenterImpl.isWifiOrMobileConn()) && (NetConnInfoCenterImpl.getCurrentAPN() == null));
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    this.i.a(parama);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    long l2;
    if (this.o != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "firstResponseGetted getted Report now");
      }
      l2 = -1L;
      if (this.p >= this.o) {
        l2 = this.p - this.o;
      }
      if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "from msg TIMESTAMP_NET2MSF not find return");
        }
        d();
        this.q = 0L;
      }
    }
    else
    {
      return;
    }
    long l4 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue();
    long l5 = this.p;
    long l1;
    if (paramToServiceMsg.getAttribute("__timestamp_msf2net") == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "to msg TIMESTAMP_MSF2NET not find set nFirstPacketTimeElapse to 0");
      }
      l1 = 0L;
    }
    for (;;)
    {
      boolean bool = false;
      if (paramFromServiceMsg.getServiceCmd().equals("login.auth")) {
        bool = true;
      }
      if (this.n.size() > 0)
      {
        paramFromServiceMsg = (a)this.n.get(this.n.size() - 1);
        paramFromServiceMsg.m = 1;
        paramFromServiceMsg.l = 1;
        this.g.getStatReporter().a(true, l2, l4 - l5, l1, this.q, bool, this.n, this.u);
      }
      d();
      this.q = 0L;
      NetConnInfoCenter.onRecvFirstResp();
      return;
      long l6 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
      long l3 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - l6;
      if (l3 >= 0L)
      {
        l1 = l3;
        if (l6 != 0L) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "nFirstPacketTimeElapse:" + l3 + " reset 0 now TIMESTAMP_NET2MSF:" + this.g.timeFormatter.format(paramFromServiceMsg.getAttribute("__timestamp_net2msf")) + " TIMESTAMP_MSF2NET:" + this.g.timeFormatter.format(paramToServiceMsg.getAttribute("__timestamp_msf2net")));
        }
        l1 = 0L;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      this.j = paramString;
      com.tencent.qphone.base.BaseConstants.isUseDebugSso = true;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = new i(this, paramString, paramInt);
    paramString.setName("checkNetConnectBySocketThread");
    paramString.start();
  }
  
  public void a(boolean paramBoolean)
  {
    this.i.t.set(paramBoolean);
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      this.k = paramArrayOfString;
      com.tencent.qphone.base.BaseConstants.isUseDebugSso = false;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2, MsfCommand paramMsfCommand, String paramString3, int paramInt3, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg)
    throws Exception
  {
    byte[] arrayOfByte;
    if (!this.i.s.get())
    {
      t = SystemClock.elapsedRealtime();
      g();
      arrayOfByte = this.g.sender.e(paramToServiceMsg);
      QLog.d("MSF.C.NetConnTag", 1, "p ok re1: " + paramToServiceMsg.getRequestSsoSeq());
    }
    for (;;)
    {
      paramArrayOfByte = null;
      if (paramToServiceMsg.getAttributes().containsKey("infoLoginMsg")) {
        paramArrayOfByte = (ToServiceMsg)paramToServiceMsg.getAttributes().get("infoLoginMsg");
      }
      int i1;
      for (;;)
      {
        i1 = this.i.a(paramInt1, paramInt2, paramInt3, paramString3, paramString1, paramString2, paramMsfCommand, arrayOfByte, paramArrayOfByte);
        if (i1 != -100) {
          break label309;
        }
        g();
        arrayOfByte = this.g.sender.e(paramToServiceMsg);
        QLog.d("MSF.C.NetConnTag", 1, "p ok re2: " + paramToServiceMsg.getRequestSsoSeq());
        if (this.i.a(paramInt1, paramInt2, paramInt3, paramString3, paramString1, paramString2, paramMsfCommand, arrayOfByte, paramArrayOfByte) != -100) {
          break;
        }
        return false;
        if ("RegPrxySvc.infoLogin".equals(paramToServiceMsg.getServiceCmd())) {
          paramArrayOfByte = paramToServiceMsg;
        } else if ("RegPrxySvc.getOffMsg".equals(paramToServiceMsg.getServiceCmd())) {
          paramArrayOfByte = paramToServiceMsg;
        } else if ("RegPrxySvc.infoSync".equals(paramToServiceMsg.getServiceCmd())) {
          paramArrayOfByte = paramToServiceMsg;
        }
      }
      if ((this.r == 0L) && (this.o != 0L) && (this.p != 0L)) {
        this.r = System.currentTimeMillis();
      }
      return true;
      label309:
      if (i1 == 65336) {
        return true;
      }
      if ((this.r == 0L) && (this.o != 0L) && (this.p != 0L)) {
        this.r = System.currentTimeMillis();
      }
      return true;
      arrayOfByte = paramArrayOfByte;
    }
  }
  
  public void b(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.y > 180000L)
    {
      this.y = l1;
      n();
      a("3gimg.qq.com", 80);
      a("120.33.50.146", 80);
      h();
      c(paramString.split(":")[0].trim());
    }
  }
  
  public void b(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      this.l = paramArrayOfString;
      com.tencent.qphone.base.BaseConstants.isUseDebugSso = false;
    }
  }
  
  public boolean b()
  {
    return this.i.s.get();
  }
  
  public void c(String paramString)
  {
    paramString = new n(this, paramString);
    paramString.setName("pingServerThread");
    paramString.start();
  }
  
  public boolean c()
  {
    return this.i.t.get();
  }
  
  public void d()
  {
    this.r = 0L;
    this.o = 0L;
    this.p = 0L;
    this.n.clear();
    this.u = 2;
    if (this.d != null)
    {
      this.g.getMsfAlarmer().a(this.d);
      this.d = null;
    }
  }
  
  public void e()
  {
    long l1;
    if (this.o != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "loginConnectTimeOut Report now");
      }
      if (this.p < this.o) {
        break label188;
      }
      if (this.r == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "loginConnectTimeOut. m_firstPacketSendTimeAfterConnect == 0");
        }
        d();
        this.q = 0L;
        return;
      }
      l1 = this.p - this.o;
      this.g.sender.a.h.c();
    }
    for (;;)
    {
      this.g.getStatReporter().a(false, l1, -1L, -1L, this.q, false, this.n, this.u);
      d();
      this.q = 0L;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "loginConnectTimeOut m_startConnectTime : " + this.o + "no need Report");
      }
      d();
      this.q = 0L;
      return;
      label188:
      l1 = -1L;
    }
  }
  
  public void f()
  {
    if (this.n.size() > 0)
    {
      a locala = (a)this.n.get(this.n.size() - 1);
      if (locala != null)
      {
        locala.e = q.y;
        locala.d = false;
        locala.l = 0;
        locala.m = 1;
      }
    }
  }
  
  public boolean g()
    throws Exception
  {
    if (((this.k != null) && (this.k.length > 0)) || ((this.l != null) && (this.l.length > 0))) {}
    Object localObject3;
    long l1;
    boolean bool1;
    label541:
    label677:
    label760:
    do
    {
      do
      {
        int i2;
        int i1;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "start to connect lmassigned server " + Arrays.toString(this.k) + " " + Arrays.toString(this.l));
          }
          this.o = System.currentTimeMillis();
          this.p = this.o;
          CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
          localObject2 = new CopyOnWriteArrayList();
          if (this.k != null)
          {
            localObject3 = this.k;
            i2 = localObject3.length;
            i1 = 0;
            while (i1 < i2)
            {
              ((CopyOnWriteArrayList)localObject2).add(com.tencent.mobileqq.msf.core.d.a(localObject3[i1]));
              i1 += 1;
            }
          }
          if (this.l != null)
          {
            localObject3 = this.l;
            i2 = localObject3.length;
            i1 = 0;
            while (i1 < i2)
            {
              localCopyOnWriteArrayList.add(com.tencent.mobileqq.msf.core.d.a(localObject3[i1]));
              i1 += 1;
            }
          }
          bool2 = a(localCopyOnWriteArrayList, (CopyOnWriteArrayList)localObject2, new ArrayList(), false);
          if (bool2) {
            return bool2;
          }
        }
        catch (Exception localException1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "conn assigned server " + Arrays.toString(this.k) + " " + Arrays.toString(this.l) + " error " + localException1, localException1);
          }
        }
        if (this.j.length() > 0) {
          try
          {
            this.o = System.currentTimeMillis();
            this.p = this.o;
            a locala = new a();
            locala.b = this.j;
            locala.g = NetConnInfoCenterImpl.getSystemNetworkType();
            locala.j = 0;
            locala.k = 0;
            locala.l = 0;
            locala.m = 0;
            a(com.tencent.mobileqq.msf.core.d.a(this.j), true, locala);
            return true;
          }
          catch (Exception localException2)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "conn assigned server " + this.j + " error " + localException2, localException2);
            }
            return false;
          }
        }
        long l2 = SystemClock.elapsedRealtime();
        l1 = 0L;
        localObject1 = new ArrayList();
        this.o = System.currentTimeMillis();
        this.p = this.o;
        if ((this.g.getSsoListManager().h().size() > 0) || (this.g.getSsoListManager().i().size() > 0))
        {
          bool1 = a(this.g.getSsoListManager().h(), this.g.getSsoListManager().i(), (ArrayList)localObject1, false);
          l1 = SystemClock.elapsedRealtime() - l2;
          i2 = 1;
          localObject2 = ((ArrayList)localObject1).iterator();
          i1 = 0;
          if (!((Iterator)localObject2).hasNext()) {
            break label760;
          }
          localObject3 = (a)((Iterator)localObject2).next();
          if ((((a)localObject3).e != q.m) && (((a)localObject3).e != q.s) && (((a)localObject3).e != q.i) && (((a)localObject3).e != q.o) && (((a)localObject3).e != q.p) && (((a)localObject3).e != q.q) && (((a)localObject3).e != q.y)) {
            break label677;
          }
          this.q = (this.p - this.o);
          i1 = 1;
          d();
        }
        for (;;)
        {
          break label541;
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "sso list is null.");
          }
          bool1 = false;
          i2 = 0;
          break;
          if (this.o == 0L)
          {
            this.o = ((a)localObject3).i;
            this.p = this.o;
          }
          if (i1 == 0) {
            this.q = (this.p - this.o);
          }
          if (this.d == null) {
            this.d = this.g.getMsfAlarmer().a(this, 300000L);
          }
          this.n.add(localObject3);
          i1 = 0;
        }
        if (bool1) {
          break label1077;
        }
        l1 = SystemClock.elapsedRealtime();
        if ((NetConnInfoCenterImpl.isWifiOrMobileConn()) && (i2 != 0))
        {
          b(true);
          this.g.getStatReporter().a(false, false, false, l1 - l2, (ArrayList)localObject1);
        }
        NetConnInfoCenter.onOepnConnAllFailed();
        l1 = System.currentTimeMillis();
        if ((!NetConnInfoCenterImpl.isWifiConn()) && ((NetConnInfoCenterImpl.isWifiOrMobileConn()) || (NetConnInfoCenterImpl.getCurrentAPN() != null))) {
          break;
        }
        bool2 = bool1;
      } while (l1 - com.tencent.mobileqq.msf.core.a.a.H >= 60000L);
      localObject1 = new StringBuffer();
      localObject2 = this.g.getSsoListManager().h().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject2).next();
        if (localObject3 != null) {
          ((StringBuffer)localObject1).append(((com.tencent.mobileqq.msf.core.d)localObject3).toString() + ";");
        }
      }
      localObject1 = ((StringBuffer)localObject1).toString();
      this.g.getStatReporter().a(false, l1 - com.tencent.mobileqq.msf.core.a.a.H, (String)localObject1);
      com.tencent.mobileqq.msf.core.a.a.H = 0L;
      return bool1;
      boolean bool2 = bool1;
    } while (l1 - com.tencent.mobileqq.msf.core.a.a.I >= 60000L);
    Object localObject1 = new StringBuffer();
    Object localObject2 = this.g.getSsoListManager().i().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject2).next();
      if (localObject3 != null) {
        ((StringBuffer)localObject1).append(((com.tencent.mobileqq.msf.core.d)localObject3).toString() + ";");
      }
    }
    localObject1 = ((StringBuffer)localObject1).toString();
    this.g.getStatReporter().a(false, l1 - com.tencent.mobileqq.msf.core.a.a.I, (String)localObject1);
    com.tencent.mobileqq.msf.core.a.a.I = 0L;
    return bool1;
    label1077:
    NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
    if (!NetConnInfoCenterImpl.isWifiOrMobileConn()) {
      NetConnInfoCenterImpl.setLastConnSuccWithoutNet();
    }
    if (NetConnInfoCenterImpl.isWifiOrMobileConn()) {
      this.g.getStatReporter().a(false, false, bool1, l1, (ArrayList)localObject1);
    }
    return true;
  }
  
  public void h()
  {
    if (this.x != null) {}
    do
    {
      do
      {
        return;
      } while (com.tencent.mobileqq.msf.core.a.a.R() == 0);
      localObject = com.tencent.mobileqq.msf.core.a.a.Q();
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.NetConnTag", 2, "TcpdumpSSOVip is empty");
    return;
    this.v.clear();
    Object localObject = ((String)localObject).split(";");
    int i2 = localObject.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = localObject[i1];
      a locala = new a();
      locala.a = str;
      locala.b = 1;
      locala.c = "";
      this.v.add(locala);
      i1 += 1;
    }
    this.x = new j(this);
    this.x.setName("checkNetConnectByConnectSSOThread");
    this.x.start();
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "tcpdump Report begin");
    }
    if (this.A != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump tcpDumpReportThread started return");
      }
      return;
    }
    this.A = new k(this);
    this.A.setName("tcpDumpReportThread");
    this.A.start();
  }
  
  public void m()
  {
    if (i())
    {
      if (System.currentTimeMillis() - this.B > com.tencent.mobileqq.msf.core.a.a.ay()) {
        k();
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump is running return");
      }
      return;
    }
    m localm = new m(this);
    localm.setName("tcpDumpThread");
    localm.start();
  }
  
  public void n()
  {
    o localo = new o(this);
    localo.setName("checkNetConnectByHttpThread");
    localo.start();
    this.C.set(true);
  }
  
  public g o()
  {
    return this.i;
  }
  
  public String p()
  {
    return this.j;
  }
  
  public String[] q()
  {
    return this.k;
  }
  
  public String[] r()
  {
    return this.l;
  }
  
  public InetSocketAddress s()
  {
    return this.i.c;
  }
  
  public boolean t()
  {
    return (b()) && (this.o == 0L);
  }
  
  public OutputStream u()
  {
    return this.i.h;
  }
  
  public class a
  {
    public String a = "";
    public byte b = 1;
    public String c = "";
    
    public a() {}
    
    public void a()
    {
      this.b = 1;
      this.c = "";
      Object localObject = this.a;
      if (localObject == null) {}
      for (;;)
      {
        return;
        String str = localObject.split(":")[0].trim();
        int i = Integer.parseInt(localObject.split(":")[1].trim());
        this.b = 2;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "start send checkNetConnectByConnectSSO server:" + str + " port:" + i);
          }
          localObject = new Socket();
          InetSocketAddress localInetSocketAddress = new InetSocketAddress(str, i);
          ((Socket)localObject).setSoTimeout(10000);
          ((Socket)localObject).setTcpNoDelay(true);
          ((Socket)localObject).setKeepAlive(true);
          ((Socket)localObject).connect(localInetSocketAddress, 10000);
          this.b = 3;
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "checkNetConnectByConnectSSO connect server:" + str + " port:" + i + " success");
          }
          ((Socket)localObject).close();
          return;
        }
        catch (Throwable localThrowable)
        {
          if (localThrowable != null) {
            this.c = localThrowable.toString().toLowerCase();
          }
          if (this.c.indexOf("timeoutexception") > -1) {
            break label237;
          }
        }
        if (this.c.indexOf(") after") > -1) {}
        label237:
        for (this.b = 5; QLog.isColorLevel(); this.b = 4)
        {
          QLog.d("MSF.C.NetConnTag", 2, "checkNetConnectByConnectSSO Throwable connect server:" + str + " port:" + i + " failed" + localThrowable, localThrowable);
          return;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\net\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */