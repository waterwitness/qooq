package com.tencent.mobileqq.msf.core.net;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.i;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.core.net.a.e;
import com.tencent.mobileqq.msf.core.w;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class g
{
  public static int A = 0;
  public static final int a = -100;
  public static final int b = -200;
  public static ArrayList n = new ArrayList();
  public d B;
  private AtomicInteger C = new AtomicInteger();
  private long D;
  protected InetSocketAddress c;
  d d;
  int e;
  int f = 30000;
  public Socket g;
  OutputStream h = null;
  public c i;
  a j;
  MsfSocketInputBuffer k = null;
  public String l = "";
  public int m;
  AtomicLong o = new AtomicLong();
  AtomicLong p = new AtomicLong();
  long q = 0L;
  boolean r = false;
  AtomicBoolean s = new AtomicBoolean();
  AtomicBoolean t = new AtomicBoolean();
  AtomicBoolean u = new AtomicBoolean();
  ReentrantLock v = new ReentrantLock();
  boolean w;
  ToServiceMsg x;
  Runnable y;
  MsfCore z;
  
  public g(MsfCore paramMsfCore, boolean paramBoolean)
  {
    this.z = paramMsfCore;
    this.w = paramBoolean;
  }
  
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    for (Object localObject = paramThrowable; localObject != null; localObject = ((Throwable)localObject).getCause()) {
      if ((localObject instanceof UnknownHostException)) {
        return "";
      }
    }
    localObject = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter((Writer)localObject);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    return ((StringWriter)localObject).toString();
  }
  
  private void g()
  {
    if ((this.z != null) && (this.z.pushManager != null) && (this.z.pushManager.ap != null))
    {
      this.z.sendSsoMsg(this.z.pushManager.ap);
      this.z.pushManager.ap = null;
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, MsfCommand paramMsfCommand, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg)
    throws IOException
  {
    if ((this.u.get()) || (!this.s.get()) || (this.i == null)) {
      return -100;
    }
    if (paramMsfCommand == MsfCommand.openConn) {}
    for (;;)
    {
      return paramArrayOfByte.length;
      paramMsfCommand = this.i.a(this.d, paramString1, paramString2, paramArrayOfByte);
      if (paramString2.equals("SSO.LoginMerge"))
      {
        if (!this.z.sender.n)
        {
          paramString1 = (ArrayList)this.z.sender.d.remove(Integer.valueOf(paramInt3));
          QLog.d("MSF.C.NetConnTag", 1, "NetChanged devide merge package, " + Arrays.toString(paramString1.toArray()) + " resend.");
          if (paramString1 != null)
          {
            paramString1 = paramString1.iterator();
            while (paramString1.hasNext())
            {
              paramString2 = (Integer)paramString1.next();
              paramString2 = this.z.sender.c(paramString2.intValue());
              this.z.sender.b(paramString2);
            }
          }
          return 65336;
        }
        if (paramToServiceMsg != null) {
          this.z.sender.a(paramToServiceMsg, this.g.hashCode());
        }
        if ((!w.p) || (!com.tencent.mobileqq.msf.core.net.a.f.a())) {
          break label532;
        }
        QLog.d("MSF.C.NetConnTag", 1, "send data in socket adaptor way");
      }
      for (;;)
      {
        try
        {
          if (this.z.sender.G != null) {
            this.z.sender.G.b().a(paramMsfCommand, this.g, paramInt3);
          }
          this.o.addAndGet(paramMsfCommand.length);
          paramToServiceMsg = new StringBuilder();
          if (!QLog.isDevelopLevel()) {
            break label551;
          }
          QLog.d("MSF.C.NetConnTag", 1, "netSend appid:" + paramInt1 + " appSeq:" + paramInt2 + " ssoSeq:" + paramInt3 + " uin:" + MsfSdkUtils.getShortUin(paramString1) + " cmd:" + paramString2 + " len:" + paramArrayOfByte.length);
          if (!paramString2.equals("SSO.LoginMerge")) {
            break label630;
          }
          return paramArrayOfByte.length;
          if (paramString2.equals("RegPrxySvc.infoLogin"))
          {
            this.z.sender.a(paramToServiceMsg, this.g.hashCode());
            break;
          }
          if (paramString2.equals("RegPrxySvc.getOffMsg"))
          {
            this.z.sender.a(paramToServiceMsg, this.g.hashCode());
            break;
          }
          if (!paramString2.equals("RegPrxySvc.infoSync")) {
            break;
          }
          this.z.sender.a(paramToServiceMsg, this.g.hashCode());
        }
        catch (Exception paramToServiceMsg)
        {
          QLog.d("MSF.C.NetConnTag", 1, "", paramToServiceMsg);
          continue;
        }
        label532:
        this.h.write(paramMsfCommand);
        this.h.flush();
        continue;
        label551:
        QLog.d("MSF.C.NetConnTag", 1, "netSend ssoSeq:" + paramInt3 + " uin:" + MsfSdkUtils.getShortUin(paramString1) + " cmd:" + paramString2.hashCode() + new StringBuilder().append(" ").append(paramArrayOfByte.length + paramInt3).toString());
      }
      label630:
      if (paramString3 == null) {
        i.a(true, paramString1, paramMsfCommand.length, paramString2, 0, this.l, this.m);
      } else {
        i.a(true, paramString1, paramMsfCommand.length, paramString3, 0, this.l, this.m);
      }
    }
  }
  
  /* Error */
  public void a(d paramd, int paramInt1, int paramInt2, c paramc, boolean paramBoolean, a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 105	com/tencent/mobileqq/msf/core/net/g:u	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 166	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: ifne +13 -> 20
    //   10: aload_0
    //   11: getfield 101	com/tencent/mobileqq/msf/core/net/g:s	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   14: invokevirtual 166	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   17: ifne +28 -> 45
    //   20: aload_0
    //   21: getfield 105	com/tencent/mobileqq/msf/core/net/g:u	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   24: invokevirtual 166	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   27: ifeq +18 -> 45
    //   30: aload_0
    //   31: getfield 105	com/tencent/mobileqq/msf/core/net/g:u	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   34: iconst_0
    //   35: invokevirtual 354	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   38: aload_0
    //   39: getstatic 359	com/tencent/qphone/base/a:f	Lcom/tencent/qphone/base/a;
    //   42: invokevirtual 362	com/tencent/mobileqq/msf/core/net/g:a	(Lcom/tencent/qphone/base/a;)V
    //   45: aload_0
    //   46: getfield 364	com/tencent/mobileqq/msf/core/net/g:x	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   49: ifnull +22 -> 71
    //   52: aload_0
    //   53: invokevirtual 367	com/tencent/mobileqq/msf/core/net/g:f	()Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   56: pop
    //   57: aload_0
    //   58: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   61: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   64: aload_0
    //   65: getfield 369	com/tencent/mobileqq/msf/core/net/g:y	Ljava/lang/Runnable;
    //   68: invokevirtual 372	com/tencent/mobileqq/msf/core/w:a	(Ljava/lang/Runnable;)V
    //   71: aload_0
    //   72: aload_1
    //   73: putfield 176	com/tencent/mobileqq/msf/core/net/g:d	Lcom/tencent/mobileqq/msf/core/d;
    //   76: aload_0
    //   77: aload 4
    //   79: putfield 168	com/tencent/mobileqq/msf/core/net/g:i	Lcom/tencent/mobileqq/msf/core/net/c;
    //   82: aload_0
    //   83: iload 5
    //   85: putfield 96	com/tencent/mobileqq/msf/core/net/g:r	Z
    //   88: aload_0
    //   89: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   92: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   95: aload_1
    //   96: invokevirtual 376	com/tencent/mobileqq/msf/core/d:h	()Z
    //   99: putfield 197	com/tencent/mobileqq/msf/core/w:n	Z
    //   102: getstatic 381	com/tencent/mobileqq/msf/core/net/q:b	Lcom/tencent/mobileqq/msf/core/net/q;
    //   105: astore 10
    //   107: ldc 78
    //   109: astore 11
    //   111: aload_0
    //   112: lconst_0
    //   113: putfield 94	com/tencent/mobileqq/msf/core/net/g:q	J
    //   116: aload_0
    //   117: getfield 110	com/tencent/mobileqq/msf/core/net/g:v	Ljava/util/concurrent/locks/ReentrantLock;
    //   120: ldc2_w 382
    //   123: getstatic 389	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   126: invokevirtual 393	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   129: ifeq +1892 -> 2021
    //   132: invokestatic 399	android/os/SystemClock:elapsedRealtime	()J
    //   135: lstore 23
    //   137: invokestatic 404	java/lang/System:currentTimeMillis	()J
    //   140: lstore 15
    //   142: invokestatic 404	java/lang/System:currentTimeMillis	()J
    //   145: pop2
    //   146: lload 15
    //   148: lstore 17
    //   150: aload 11
    //   152: astore 8
    //   154: aload 10
    //   156: astore 7
    //   158: aload 11
    //   160: astore 9
    //   162: aload 10
    //   164: astore 4
    //   166: aload_0
    //   167: new 406	java/net/InetSocketAddress
    //   170: dup
    //   171: aload_1
    //   172: invokevirtual 408	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   175: aload_1
    //   176: invokevirtual 410	com/tencent/mobileqq/msf/core/d:d	()I
    //   179: invokespecial 413	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   182: putfield 415	com/tencent/mobileqq/msf/core/net/g:c	Ljava/net/InetSocketAddress;
    //   185: lload 15
    //   187: lstore 17
    //   189: aload 11
    //   191: astore 8
    //   193: aload 10
    //   195: astore 7
    //   197: aload 11
    //   199: astore 9
    //   201: aload 10
    //   203: astore 4
    //   205: new 216	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   212: astore 13
    //   214: lload 15
    //   216: lstore 17
    //   218: aload 11
    //   220: astore 8
    //   222: aload 10
    //   224: astore 7
    //   226: aload 11
    //   228: astore 9
    //   230: aload 10
    //   232: astore 4
    //   234: new 216	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   241: aload 13
    //   243: ldc_w 417
    //   246: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_0
    //   250: getfield 415	com/tencent/mobileqq/msf/core/net/g:c	Ljava/net/InetSocketAddress;
    //   253: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: astore 14
    //   264: lload 15
    //   266: lstore 17
    //   268: aload 11
    //   270: astore 8
    //   272: aload 10
    //   274: astore 7
    //   276: aload 11
    //   278: astore 9
    //   280: aload 10
    //   282: astore 4
    //   284: aload_1
    //   285: getfield 422	com/tencent/mobileqq/msf/core/d:h	Z
    //   288: ifeq +1734 -> 2022
    //   291: ldc_w 424
    //   294: astore 12
    //   296: lload 15
    //   298: lstore 17
    //   300: aload 11
    //   302: astore 8
    //   304: aload 10
    //   306: astore 7
    //   308: aload 11
    //   310: astore 9
    //   312: aload 10
    //   314: astore 4
    //   316: ldc -42
    //   318: iconst_1
    //   319: aload 14
    //   321: aload 12
    //   323: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: lload 15
    //   334: lstore 17
    //   336: aload 11
    //   338: astore 8
    //   340: aload 10
    //   342: astore 7
    //   344: aload 11
    //   346: astore 9
    //   348: aload 10
    //   350: astore 4
    //   352: invokestatic 404	java/lang/System:currentTimeMillis	()J
    //   355: lstore 19
    //   357: lload 19
    //   359: lstore 17
    //   361: aload 11
    //   363: astore 8
    //   365: aload 10
    //   367: astore 7
    //   369: aload 11
    //   371: astore 9
    //   373: aload 10
    //   375: astore 4
    //   377: aload_0
    //   378: lload 19
    //   380: putfield 426	com/tencent/mobileqq/msf/core/net/g:D	J
    //   383: lload 19
    //   385: lstore 17
    //   387: aload 11
    //   389: astore 8
    //   391: aload 10
    //   393: astore 7
    //   395: aload 11
    //   397: astore 9
    //   399: aload 10
    //   401: astore 4
    //   403: aload_0
    //   404: new 428	java/net/Socket
    //   407: dup
    //   408: invokespecial 429	java/net/Socket:<init>	()V
    //   411: putfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   414: lload 19
    //   416: lstore 17
    //   418: aload 11
    //   420: astore 8
    //   422: aload 10
    //   424: astore 7
    //   426: aload 11
    //   428: astore 9
    //   430: aload 10
    //   432: astore 4
    //   434: aload_0
    //   435: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   438: iload_3
    //   439: invokevirtual 433	java/net/Socket:setSoTimeout	(I)V
    //   442: lload 19
    //   444: lstore 17
    //   446: aload 11
    //   448: astore 8
    //   450: aload 10
    //   452: astore 7
    //   454: aload 11
    //   456: astore 9
    //   458: aload 10
    //   460: astore 4
    //   462: aload_0
    //   463: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   466: iconst_1
    //   467: invokevirtual 436	java/net/Socket:setTcpNoDelay	(Z)V
    //   470: lload 19
    //   472: lstore 17
    //   474: aload 11
    //   476: astore 8
    //   478: aload 10
    //   480: astore 7
    //   482: aload 11
    //   484: astore 9
    //   486: aload 10
    //   488: astore 4
    //   490: aload_0
    //   491: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   494: iconst_1
    //   495: invokevirtual 439	java/net/Socket:setKeepAlive	(Z)V
    //   498: lload 19
    //   500: lstore 17
    //   502: aload 11
    //   504: astore 8
    //   506: aload 10
    //   508: astore 7
    //   510: aload 11
    //   512: astore 9
    //   514: aload 10
    //   516: astore 4
    //   518: aload_0
    //   519: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   522: aload_0
    //   523: getfield 415	com/tencent/mobileqq/msf/core/net/g:c	Ljava/net/InetSocketAddress;
    //   526: aload_1
    //   527: invokevirtual 441	com/tencent/mobileqq/msf/core/d:e	()I
    //   530: invokevirtual 445	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   533: lload 19
    //   535: lstore 17
    //   537: aload 11
    //   539: astore 8
    //   541: aload 10
    //   543: astore 7
    //   545: aload 11
    //   547: astore 9
    //   549: aload 10
    //   551: astore 4
    //   553: aload 6
    //   555: iconst_1
    //   556: putfield 449	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   559: lload 19
    //   561: lstore 17
    //   563: aload 11
    //   565: astore 8
    //   567: aload 10
    //   569: astore 7
    //   571: aload 11
    //   573: astore 9
    //   575: aload 10
    //   577: astore 4
    //   579: aload 6
    //   581: aload 6
    //   583: getfield 451	com/tencent/mobileqq/msf/core/net/a:j	I
    //   586: iconst_1
    //   587: iadd
    //   588: putfield 451	com/tencent/mobileqq/msf/core/net/a:j	I
    //   591: lload 19
    //   593: lstore 17
    //   595: aload 11
    //   597: astore 8
    //   599: aload 10
    //   601: astore 7
    //   603: aload 11
    //   605: astore 9
    //   607: aload 10
    //   609: astore 4
    //   611: aload_0
    //   612: invokestatic 404	java/lang/System:currentTimeMillis	()J
    //   615: putfield 94	com/tencent/mobileqq/msf/core/net/g:q	J
    //   618: lload 19
    //   620: lstore 17
    //   622: aload 11
    //   624: astore 8
    //   626: aload 10
    //   628: astore 7
    //   630: aload 11
    //   632: astore 9
    //   634: aload 10
    //   636: astore 4
    //   638: aload_0
    //   639: getfield 94	com/tencent/mobileqq/msf/core/net/g:q	J
    //   642: lload 19
    //   644: lsub
    //   645: lstore 21
    //   647: lload 19
    //   649: lstore 17
    //   651: aload 11
    //   653: astore 8
    //   655: aload 10
    //   657: astore 7
    //   659: aload 11
    //   661: astore 9
    //   663: aload 10
    //   665: astore 4
    //   667: aload_0
    //   668: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   671: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   674: getfield 454	com/tencent/mobileqq/msf/core/w:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   677: astore 12
    //   679: lload 19
    //   681: lstore 17
    //   683: aload 11
    //   685: astore 8
    //   687: aload 10
    //   689: astore 7
    //   691: aload 11
    //   693: astore 9
    //   695: aload 10
    //   697: astore 4
    //   699: aload 12
    //   701: aload 12
    //   703: getfield 458	com/tencent/mobileqq/msf/core/net/h:p	J
    //   706: lload 21
    //   708: ladd
    //   709: putfield 458	com/tencent/mobileqq/msf/core/net/h:p	J
    //   712: lload 21
    //   714: lstore 15
    //   716: lload 21
    //   718: lconst_0
    //   719: lcmp
    //   720: ifge +6 -> 726
    //   723: lconst_0
    //   724: lstore 15
    //   726: lload 19
    //   728: lstore 17
    //   730: aload 11
    //   732: astore 8
    //   734: aload 10
    //   736: astore 7
    //   738: aload 11
    //   740: astore 9
    //   742: aload 10
    //   744: astore 4
    //   746: aload_0
    //   747: getfield 94	com/tencent/mobileqq/msf/core/net/g:q	J
    //   750: putstatic 461	com/tencent/mobileqq/msf/core/w:P	J
    //   753: lload 19
    //   755: lstore 17
    //   757: aload 11
    //   759: astore 8
    //   761: aload 10
    //   763: astore 7
    //   765: aload 11
    //   767: astore 9
    //   769: aload 10
    //   771: astore 4
    //   773: aload_0
    //   774: getfield 90	com/tencent/mobileqq/msf/core/net/g:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   777: lconst_0
    //   778: invokevirtual 464	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   781: lload 19
    //   783: lstore 17
    //   785: aload 11
    //   787: astore 8
    //   789: aload 10
    //   791: astore 7
    //   793: aload 11
    //   795: astore 9
    //   797: aload 10
    //   799: astore 4
    //   801: aload_0
    //   802: getfield 92	com/tencent/mobileqq/msf/core/net/g:p	Ljava/util/concurrent/atomic/AtomicLong;
    //   805: lconst_0
    //   806: invokevirtual 464	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   809: lload 19
    //   811: lstore 17
    //   813: aload 11
    //   815: astore 8
    //   817: aload 10
    //   819: astore 7
    //   821: aload 11
    //   823: astore 9
    //   825: aload 10
    //   827: astore 4
    //   829: aload_0
    //   830: aload_0
    //   831: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   834: invokevirtual 468	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   837: putfield 74	com/tencent/mobileqq/msf/core/net/g:h	Ljava/io/OutputStream;
    //   840: lload 19
    //   842: lstore 17
    //   844: aload 11
    //   846: astore 8
    //   848: aload 10
    //   850: astore 7
    //   852: aload 11
    //   854: astore 9
    //   856: aload 10
    //   858: astore 4
    //   860: getstatic 67	com/tencent/mobileqq/msf/core/net/g:n	Ljava/util/ArrayList;
    //   863: aload_0
    //   864: getfield 74	com/tencent/mobileqq/msf/core/net/g:h	Ljava/io/OutputStream;
    //   867: invokevirtual 469	java/lang/Object:toString	()Ljava/lang/String;
    //   870: invokevirtual 472	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   873: ifne +37 -> 910
    //   876: lload 19
    //   878: lstore 17
    //   880: aload 11
    //   882: astore 8
    //   884: aload 10
    //   886: astore 7
    //   888: aload 11
    //   890: astore 9
    //   892: aload 10
    //   894: astore 4
    //   896: getstatic 67	com/tencent/mobileqq/msf/core/net/g:n	Ljava/util/ArrayList;
    //   899: aload_0
    //   900: getfield 74	com/tencent/mobileqq/msf/core/net/g:h	Ljava/io/OutputStream;
    //   903: invokevirtual 469	java/lang/Object:toString	()Ljava/lang/String;
    //   906: invokevirtual 475	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   909: pop
    //   910: lload 19
    //   912: lstore 17
    //   914: aload 11
    //   916: astore 8
    //   918: aload 10
    //   920: astore 7
    //   922: aload 11
    //   924: astore 9
    //   926: aload 10
    //   928: astore 4
    //   930: aload_0
    //   931: new 477	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   934: dup
    //   935: aload_0
    //   936: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   939: iload_2
    //   940: ldc_w 479
    //   943: iconst_m1
    //   944: invokespecial 482	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
    //   947: putfield 76	com/tencent/mobileqq/msf/core/net/g:k	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   950: lload 19
    //   952: lstore 17
    //   954: aload 11
    //   956: astore 8
    //   958: aload 10
    //   960: astore 7
    //   962: aload 11
    //   964: astore 9
    //   966: aload 10
    //   968: astore 4
    //   970: aload_0
    //   971: new 6	com/tencent/mobileqq/msf/core/net/g$a
    //   974: dup
    //   975: aload_0
    //   976: invokespecial 485	com/tencent/mobileqq/msf/core/net/g$a:<init>	(Lcom/tencent/mobileqq/msf/core/net/g;)V
    //   979: putfield 487	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   982: lload 19
    //   984: lstore 17
    //   986: aload 11
    //   988: astore 8
    //   990: aload 10
    //   992: astore 7
    //   994: aload 11
    //   996: astore 9
    //   998: aload 10
    //   1000: astore 4
    //   1002: aload_0
    //   1003: getfield 487	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   1006: ldc_w 489
    //   1009: invokevirtual 493	com/tencent/mobileqq/msf/core/net/g$a:setName	(Ljava/lang/String;)V
    //   1012: lload 19
    //   1014: lstore 17
    //   1016: aload 11
    //   1018: astore 8
    //   1020: aload 10
    //   1022: astore 7
    //   1024: aload 11
    //   1026: astore 9
    //   1028: aload 10
    //   1030: astore 4
    //   1032: aload_0
    //   1033: getfield 487	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   1036: invokevirtual 496	com/tencent/mobileqq/msf/core/net/g$a:start	()V
    //   1039: lload 19
    //   1041: lstore 17
    //   1043: aload 11
    //   1045: astore 8
    //   1047: aload 10
    //   1049: astore 7
    //   1051: aload 11
    //   1053: astore 9
    //   1055: aload 10
    //   1057: astore 4
    //   1059: aload_0
    //   1060: getfield 101	com/tencent/mobileqq/msf/core/net/g:s	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1063: iconst_1
    //   1064: invokevirtual 354	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1067: lload 19
    //   1069: lstore 17
    //   1071: aload 11
    //   1073: astore 8
    //   1075: aload 10
    //   1077: astore 7
    //   1079: aload 11
    //   1081: astore 9
    //   1083: aload 10
    //   1085: astore 4
    //   1087: getstatic 498	com/tencent/mobileqq/msf/core/net/q:c	Lcom/tencent/mobileqq/msf/core/net/q;
    //   1090: astore 10
    //   1092: ldc_w 500
    //   1095: astore 11
    //   1097: lload 19
    //   1099: lstore 17
    //   1101: aload 11
    //   1103: astore 8
    //   1105: aload 10
    //   1107: astore 7
    //   1109: aload 11
    //   1111: astore 9
    //   1113: aload 10
    //   1115: astore 4
    //   1117: aload_0
    //   1118: aload_1
    //   1119: putfield 502	com/tencent/mobileqq/msf/core/net/g:B	Lcom/tencent/mobileqq/msf/core/d;
    //   1122: lload 19
    //   1124: lstore 17
    //   1126: aload 11
    //   1128: astore 8
    //   1130: aload 10
    //   1132: astore 7
    //   1134: aload 11
    //   1136: astore 9
    //   1138: aload 10
    //   1140: astore 4
    //   1142: invokestatic 504	com/tencent/mobileqq/msf/core/w:d	()V
    //   1145: lload 19
    //   1147: lstore 17
    //   1149: aload 11
    //   1151: astore 8
    //   1153: aload 10
    //   1155: astore 7
    //   1157: aload 11
    //   1159: astore 9
    //   1161: aload 10
    //   1163: astore 4
    //   1165: new 216	java/lang/StringBuilder
    //   1168: dup
    //   1169: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   1172: aload_0
    //   1173: getfield 502	com/tencent/mobileqq/msf/core/net/g:B	Lcom/tencent/mobileqq/msf/core/d;
    //   1176: invokevirtual 408	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   1179: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: ldc_w 506
    //   1185: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: aload_0
    //   1189: getfield 502	com/tencent/mobileqq/msf/core/net/g:B	Lcom/tencent/mobileqq/msf/core/d;
    //   1192: invokevirtual 410	com/tencent/mobileqq/msf/core/d:d	()I
    //   1195: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1198: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1201: putstatic 508	com/tencent/mobileqq/msf/core/w:D	Ljava/lang/String;
    //   1204: lload 19
    //   1206: lstore 17
    //   1208: aload 11
    //   1210: astore 8
    //   1212: aload 10
    //   1214: astore 7
    //   1216: aload 11
    //   1218: astore 9
    //   1220: aload 10
    //   1222: astore 4
    //   1224: new 216	java/lang/StringBuilder
    //   1227: dup
    //   1228: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   1231: aload_0
    //   1232: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   1235: invokevirtual 512	java/net/Socket:getLocalSocketAddress	()Ljava/net/SocketAddress;
    //   1238: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1241: ldc_w 514
    //   1244: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: aload_0
    //   1248: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   1251: invokevirtual 517	java/net/Socket:getLocalPort	()I
    //   1254: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1257: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1260: putstatic 520	com/tencent/mobileqq/msf/core/w:E	Ljava/lang/String;
    //   1263: lload 19
    //   1265: lstore 17
    //   1267: aload 11
    //   1269: astore 8
    //   1271: aload 10
    //   1273: astore 7
    //   1275: aload 11
    //   1277: astore 9
    //   1279: aload 10
    //   1281: astore 4
    //   1283: invokestatic 525	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:isWifiConn	()Z
    //   1286: ifeq +744 -> 2030
    //   1289: lload 19
    //   1291: lstore 17
    //   1293: aload 11
    //   1295: astore 8
    //   1297: aload 10
    //   1299: astore 7
    //   1301: aload 11
    //   1303: astore 9
    //   1305: aload 10
    //   1307: astore 4
    //   1309: iconst_1
    //   1310: putstatic 528	com/tencent/mobileqq/msf/core/w:F	I
    //   1313: lload 19
    //   1315: lstore 17
    //   1317: aload 11
    //   1319: astore 8
    //   1321: aload 10
    //   1323: astore 7
    //   1325: aload 11
    //   1327: astore 9
    //   1329: aload 10
    //   1331: astore 4
    //   1333: aload_0
    //   1334: getfield 502	com/tencent/mobileqq/msf/core/net/g:B	Lcom/tencent/mobileqq/msf/core/d;
    //   1337: invokevirtual 530	com/tencent/mobileqq/msf/core/d:f	()V
    //   1340: lload 19
    //   1342: lstore 17
    //   1344: aload 11
    //   1346: astore 8
    //   1348: aload 10
    //   1350: astore 7
    //   1352: aload 11
    //   1354: astore 9
    //   1356: aload 10
    //   1358: astore 4
    //   1360: aload 13
    //   1362: iconst_0
    //   1363: aload 13
    //   1365: invokevirtual 533	java/lang/StringBuilder:length	()I
    //   1368: invokevirtual 537	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1371: pop
    //   1372: lload 19
    //   1374: lstore 17
    //   1376: aload 11
    //   1378: astore 8
    //   1380: aload 10
    //   1382: astore 7
    //   1384: aload 11
    //   1386: astore 9
    //   1388: aload 10
    //   1390: astore 4
    //   1392: new 216	java/lang/StringBuilder
    //   1395: dup
    //   1396: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   1399: aload 13
    //   1401: ldc_w 539
    //   1404: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1407: aload_0
    //   1408: getfield 415	com/tencent/mobileqq/msf/core/net/g:c	Ljava/net/InetSocketAddress;
    //   1411: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1414: ldc_w 541
    //   1417: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1420: lload 15
    //   1422: invokevirtual 544	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1425: ldc_w 546
    //   1428: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: aload_1
    //   1432: invokevirtual 441	com/tencent/mobileqq/msf/core/d:e	()I
    //   1435: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1438: ldc_w 548
    //   1441: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1444: aload_0
    //   1445: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   1448: invokevirtual 552	java/net/Socket:getLocalAddress	()Ljava/net/InetAddress;
    //   1451: invokevirtual 557	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1454: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: ldc_w 506
    //   1460: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1463: aload_0
    //   1464: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   1467: invokevirtual 517	java/net/Socket:getLocalPort	()I
    //   1470: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1473: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1476: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1479: astore 13
    //   1481: lload 19
    //   1483: lstore 17
    //   1485: aload 11
    //   1487: astore 8
    //   1489: aload 10
    //   1491: astore 7
    //   1493: aload 11
    //   1495: astore 9
    //   1497: aload 10
    //   1499: astore 4
    //   1501: aload_1
    //   1502: getfield 422	com/tencent/mobileqq/msf/core/d:h	Z
    //   1505: ifeq +779 -> 2284
    //   1508: ldc_w 424
    //   1511: astore 12
    //   1513: lload 19
    //   1515: lstore 17
    //   1517: aload 11
    //   1519: astore 8
    //   1521: aload 10
    //   1523: astore 7
    //   1525: aload 11
    //   1527: astore 9
    //   1529: aload 10
    //   1531: astore 4
    //   1533: ldc -42
    //   1535: iconst_1
    //   1536: aload 13
    //   1538: aload 12
    //   1540: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1543: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1546: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1549: lload 19
    //   1551: lstore 17
    //   1553: aload 11
    //   1555: astore 8
    //   1557: aload 10
    //   1559: astore 7
    //   1561: aload 11
    //   1563: astore 9
    //   1565: aload 10
    //   1567: astore 4
    //   1569: aload_0
    //   1570: getfield 85	com/tencent/mobileqq/msf/core/net/g:C	Ljava/util/concurrent/atomic/AtomicInteger;
    //   1573: iconst_0
    //   1574: invokevirtual 559	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   1577: lload 19
    //   1579: lstore 17
    //   1581: aload 11
    //   1583: astore 8
    //   1585: aload 10
    //   1587: astore 7
    //   1589: aload 11
    //   1591: astore 9
    //   1593: aload 10
    //   1595: astore 4
    //   1597: getstatic 272	com/tencent/mobileqq/msf/core/w:p	Z
    //   1600: ifeq +137 -> 1737
    //   1603: lload 19
    //   1605: lstore 17
    //   1607: aload 11
    //   1609: astore 8
    //   1611: aload 10
    //   1613: astore 7
    //   1615: aload 11
    //   1617: astore 9
    //   1619: aload 10
    //   1621: astore 4
    //   1623: invokestatic 276	com/tencent/mobileqq/msf/core/net/a/f:a	()Z
    //   1626: istore 5
    //   1628: iload 5
    //   1630: ifeq +107 -> 1737
    //   1633: lload 19
    //   1635: lstore 17
    //   1637: aload 11
    //   1639: astore 8
    //   1641: aload 10
    //   1643: astore 7
    //   1645: aload 11
    //   1647: astore 9
    //   1649: aload 10
    //   1651: astore 4
    //   1653: ldc -42
    //   1655: iconst_1
    //   1656: ldc_w 561
    //   1659: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1662: lload 19
    //   1664: lstore 17
    //   1666: aload 11
    //   1668: astore 8
    //   1670: aload 10
    //   1672: astore 7
    //   1674: aload 11
    //   1676: astore 9
    //   1678: aload 10
    //   1680: astore 4
    //   1682: aload_0
    //   1683: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1686: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   1689: getfield 282	com/tencent/mobileqq/msf/core/w:G	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   1692: ifnull +45 -> 1737
    //   1695: lload 19
    //   1697: lstore 17
    //   1699: aload 11
    //   1701: astore 8
    //   1703: aload 10
    //   1705: astore 7
    //   1707: aload 11
    //   1709: astore 9
    //   1711: aload 10
    //   1713: astore 4
    //   1715: aload_0
    //   1716: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1719: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   1722: getfield 282	com/tencent/mobileqq/msf/core/w:G	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   1725: invokevirtual 285	com/tencent/mobileqq/msf/core/net/a/f:b	()Lcom/tencent/mobileqq/msf/core/net/a/e;
    //   1728: aload_0
    //   1729: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   1732: invokeinterface 564 2 0
    //   1737: aload_0
    //   1738: getfield 110	com/tencent/mobileqq/msf/core/net/g:v	Ljava/util/concurrent/locks/ReentrantLock;
    //   1741: invokevirtual 567	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1744: aload 10
    //   1746: getstatic 498	com/tencent/mobileqq/msf/core/net/q:c	Lcom/tencent/mobileqq/msf/core/net/q;
    //   1749: if_acmpeq +21 -> 1770
    //   1752: aload 6
    //   1754: iconst_0
    //   1755: putfield 449	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   1758: aload 6
    //   1760: aload 6
    //   1762: getfield 569	com/tencent/mobileqq/msf/core/net/a:k	I
    //   1765: iconst_1
    //   1766: iadd
    //   1767: putfield 569	com/tencent/mobileqq/msf/core/net/a:k	I
    //   1770: aload 6
    //   1772: aload 10
    //   1774: putfield 571	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/q;
    //   1777: aload 6
    //   1779: ldc_w 500
    //   1782: putfield 573	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   1785: aload 6
    //   1787: invokestatic 399	android/os/SystemClock:elapsedRealtime	()J
    //   1790: lload 23
    //   1792: lsub
    //   1793: putfield 575	com/tencent/mobileqq/msf/core/net/a:a	J
    //   1796: aload 10
    //   1798: astore 8
    //   1800: aload 8
    //   1802: getstatic 498	com/tencent/mobileqq/msf/core/net/q:c	Lcom/tencent/mobileqq/msf/core/net/q;
    //   1805: if_acmpne +1523 -> 3328
    //   1808: aload_0
    //   1809: getfield 114	com/tencent/mobileqq/msf/core/net/g:w	Z
    //   1812: ifeq +1516 -> 3328
    //   1815: invokestatic 578	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:isNetSupport	()Z
    //   1818: ifne +7 -> 1825
    //   1821: iconst_1
    //   1822: invokestatic 581	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:setNetSupport	(Z)V
    //   1825: invokestatic 584	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:getSystemNetworkType	()I
    //   1828: putstatic 586	com/tencent/mobileqq/msf/core/net/g:A	I
    //   1831: aload_0
    //   1832: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1835: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   1838: aconst_null
    //   1839: invokevirtual 588	com/tencent/mobileqq/msf/core/w:a	([B)V
    //   1842: aload_0
    //   1843: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1846: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   1849: invokevirtual 590	com/tencent/mobileqq/msf/core/w:c	()V
    //   1852: getstatic 592	com/tencent/mobileqq/msf/core/w:z	Ljava/util/concurrent/atomic/AtomicInteger;
    //   1855: iconst_0
    //   1856: invokevirtual 559	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   1859: getstatic 594	com/tencent/mobileqq/msf/core/w:A	Ljava/util/ArrayList;
    //   1862: invokevirtual 597	java/util/ArrayList:clear	()V
    //   1865: aload_0
    //   1866: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   1869: ifnull +152 -> 2021
    //   1872: aload_0
    //   1873: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1876: new 216	java/lang/StringBuilder
    //   1879: dup
    //   1880: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   1883: aload_0
    //   1884: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   1887: invokevirtual 552	java/net/Socket:getLocalAddress	()Ljava/net/InetAddress;
    //   1890: invokevirtual 557	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1893: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1896: ldc_w 506
    //   1899: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1902: aload_0
    //   1903: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   1906: invokevirtual 517	java/net/Socket:getLocalPort	()I
    //   1909: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1912: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1915: putfield 600	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   1918: aload_0
    //   1919: getfield 103	com/tencent/mobileqq/msf/core/net/g:t	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1922: iconst_0
    //   1923: invokevirtual 354	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1926: invokestatic 604	com/tencent/mobileqq/msf/core/a/a:u	()Z
    //   1929: ifeq +1334 -> 3263
    //   1932: aload_0
    //   1933: invokevirtual 606	com/tencent/mobileqq/msf/core/net/g:e	()V
    //   1936: aload_0
    //   1937: invokespecial 608	com/tencent/mobileqq/msf/core/net/g:g	()V
    //   1940: invokestatic 610	com/tencent/mobileqq/msf/core/a/a:v	()Z
    //   1943: ifeq +1353 -> 3296
    //   1946: aload_0
    //   1947: aload_0
    //   1948: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1951: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   1954: aload_0
    //   1955: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   1958: invokevirtual 267	java/lang/Object:hashCode	()I
    //   1961: invokevirtual 613	com/tencent/mobileqq/msf/core/w:a	(I)Ljava/lang/Runnable;
    //   1964: putfield 369	com/tencent/mobileqq/msf/core/net/g:y	Ljava/lang/Runnable;
    //   1967: aload_0
    //   1968: getfield 502	com/tencent/mobileqq/msf/core/net/g:B	Lcom/tencent/mobileqq/msf/core/d;
    //   1971: invokevirtual 408	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   1974: invokestatic 618	com/tencent/qphone/base/util/e:b	(Ljava/lang/String;)J
    //   1977: putstatic 622	com/tencent/mobileqq/msf/core/push/d:d	J
    //   1980: aload_1
    //   1981: invokevirtual 408	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   1984: aload_1
    //   1985: invokevirtual 410	com/tencent/mobileqq/msf/core/d:d	()I
    //   1988: getstatic 586	com/tencent/mobileqq/msf/core/net/g:A	I
    //   1991: invokestatic 627	com/tencent/mobileqq/a/a/b:a	(Ljava/lang/String;II)V
    //   1994: aload_0
    //   1995: getfield 415	com/tencent/mobileqq/msf/core/net/g:c	Ljava/net/InetSocketAddress;
    //   1998: invokevirtual 628	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   2001: aload_0
    //   2002: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2005: getfield 600	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   2008: invokestatic 634	com/tencent/mobileqq/msf/core/NetConnInfoCenter:onConnOpened	(Ljava/lang/String;Ljava/lang/String;)V
    //   2011: aload_0
    //   2012: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2015: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   2018: invokevirtual 636	com/tencent/mobileqq/msf/core/w:h	()V
    //   2021: return
    //   2022: ldc_w 638
    //   2025: astore 12
    //   2027: goto -1731 -> 296
    //   2030: lload 19
    //   2032: lstore 17
    //   2034: aload 11
    //   2036: astore 8
    //   2038: aload 10
    //   2040: astore 7
    //   2042: aload 11
    //   2044: astore 9
    //   2046: aload 10
    //   2048: astore 4
    //   2050: invokestatic 641	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:isMobileConn	()Z
    //   2053: ifeq -740 -> 1313
    //   2056: lload 19
    //   2058: lstore 17
    //   2060: aload 11
    //   2062: astore 8
    //   2064: aload 10
    //   2066: astore 7
    //   2068: aload 11
    //   2070: astore 9
    //   2072: aload 10
    //   2074: astore 4
    //   2076: invokestatic 644	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:getMobileNetworkType	()I
    //   2079: bipush 100
    //   2081: iadd
    //   2082: putstatic 528	com/tencent/mobileqq/msf/core/w:F	I
    //   2085: goto -772 -> 1313
    //   2088: astore 12
    //   2090: aload 8
    //   2092: astore 9
    //   2094: aload 7
    //   2096: astore 4
    //   2098: invokestatic 404	java/lang/System:currentTimeMillis	()J
    //   2101: lload 17
    //   2103: lsub
    //   2104: lstore 15
    //   2106: aload 8
    //   2108: astore 9
    //   2110: aload 7
    //   2112: astore 4
    //   2114: aload_0
    //   2115: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2118: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   2121: getfield 454	com/tencent/mobileqq/msf/core/w:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2124: astore 10
    //   2126: aload 8
    //   2128: astore 9
    //   2130: aload 7
    //   2132: astore 4
    //   2134: aload 10
    //   2136: aload 10
    //   2138: getfield 458	com/tencent/mobileqq/msf/core/net/h:p	J
    //   2141: lload 15
    //   2143: ladd
    //   2144: putfield 458	com/tencent/mobileqq/msf/core/net/h:p	J
    //   2147: aload 8
    //   2149: astore 9
    //   2151: aload 7
    //   2153: astore 4
    //   2155: aload 12
    //   2157: invokevirtual 645	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2160: invokevirtual 648	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2163: astore 11
    //   2165: aload 11
    //   2167: astore 9
    //   2169: aload 7
    //   2171: astore 4
    //   2173: invokestatic 584	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:getSystemNetworkType	()I
    //   2176: ifne +256 -> 2432
    //   2179: aload 11
    //   2181: astore 9
    //   2183: aload 7
    //   2185: astore 4
    //   2187: getstatic 650	com/tencent/mobileqq/msf/core/net/q:m	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2190: astore 8
    //   2192: aload 11
    //   2194: astore 9
    //   2196: aload 8
    //   2198: astore 4
    //   2200: aload 8
    //   2202: invokevirtual 651	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2205: astore 7
    //   2207: aload 7
    //   2209: astore 9
    //   2211: aload 8
    //   2213: astore 4
    //   2215: aload 6
    //   2217: invokestatic 654	com/tencent/mobileqq/msf/core/a/a:aA	()I
    //   2220: putfield 656	com/tencent/mobileqq/msf/core/net/a:h	I
    //   2223: aload_0
    //   2224: getfield 110	com/tencent/mobileqq/msf/core/net/g:v	Ljava/util/concurrent/locks/ReentrantLock;
    //   2227: invokevirtual 567	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2230: aload 8
    //   2232: getstatic 498	com/tencent/mobileqq/msf/core/net/q:c	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2235: if_acmpeq +21 -> 2256
    //   2238: aload 6
    //   2240: iconst_0
    //   2241: putfield 449	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   2244: aload 6
    //   2246: aload 6
    //   2248: getfield 569	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2251: iconst_1
    //   2252: iadd
    //   2253: putfield 569	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2256: aload 6
    //   2258: aload 8
    //   2260: putfield 571	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2263: aload 6
    //   2265: aload 7
    //   2267: putfield 573	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   2270: aload 6
    //   2272: invokestatic 399	android/os/SystemClock:elapsedRealtime	()J
    //   2275: lload 23
    //   2277: lsub
    //   2278: putfield 575	com/tencent/mobileqq/msf/core/net/a:a	J
    //   2281: goto -481 -> 1800
    //   2284: ldc_w 638
    //   2287: astore 12
    //   2289: goto -776 -> 1513
    //   2292: astore 12
    //   2294: lload 19
    //   2296: lstore 17
    //   2298: aload 11
    //   2300: astore 8
    //   2302: aload 10
    //   2304: astore 7
    //   2306: aload 11
    //   2308: astore 9
    //   2310: aload 10
    //   2312: astore 4
    //   2314: ldc -42
    //   2316: iconst_1
    //   2317: ldc_w 658
    //   2320: aload 12
    //   2322: invokestatic 327	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2325: goto -588 -> 1737
    //   2328: astore_1
    //   2329: aload_0
    //   2330: getfield 110	com/tencent/mobileqq/msf/core/net/g:v	Ljava/util/concurrent/locks/ReentrantLock;
    //   2333: invokevirtual 567	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2336: aload 4
    //   2338: getstatic 498	com/tencent/mobileqq/msf/core/net/q:c	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2341: if_acmpeq +21 -> 2362
    //   2344: aload 6
    //   2346: iconst_0
    //   2347: putfield 449	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   2350: aload 6
    //   2352: aload 6
    //   2354: getfield 569	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2357: iconst_1
    //   2358: iadd
    //   2359: putfield 569	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2362: aload 6
    //   2364: aload 4
    //   2366: putfield 571	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2369: aload 6
    //   2371: aload 9
    //   2373: putfield 573	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   2376: aload 6
    //   2378: invokestatic 399	android/os/SystemClock:elapsedRealtime	()J
    //   2381: lload 23
    //   2383: lsub
    //   2384: putfield 575	com/tencent/mobileqq/msf/core/net/a:a	J
    //   2387: aload_1
    //   2388: athrow
    //   2389: astore_1
    //   2390: aload 6
    //   2392: iconst_0
    //   2393: putfield 449	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   2396: aload 6
    //   2398: aload 6
    //   2400: getfield 569	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2403: iconst_1
    //   2404: iadd
    //   2405: putfield 569	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2408: aload 6
    //   2410: getstatic 660	com/tencent/mobileqq/msf/core/net/q:f	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2413: putfield 571	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2416: aload 6
    //   2418: aload_1
    //   2419: invokevirtual 661	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   2422: putfield 573	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   2425: aload 6
    //   2427: lconst_0
    //   2428: putfield 575	com/tencent/mobileqq/msf/core/net/a:a	J
    //   2431: return
    //   2432: aload 11
    //   2434: astore 9
    //   2436: aload 7
    //   2438: astore 4
    //   2440: aload 11
    //   2442: ldc_w 663
    //   2445: invokevirtual 667	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2448: iconst_m1
    //   2449: if_icmple +34 -> 2483
    //   2452: aload 11
    //   2454: astore 9
    //   2456: aload 7
    //   2458: astore 4
    //   2460: getstatic 669	com/tencent/mobileqq/msf/core/net/q:g	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2463: astore 8
    //   2465: aload 11
    //   2467: astore 9
    //   2469: aload 8
    //   2471: astore 4
    //   2473: aload 8
    //   2475: invokevirtual 651	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2478: astore 7
    //   2480: goto -257 -> 2223
    //   2483: aload 11
    //   2485: astore 9
    //   2487: aload 7
    //   2489: astore 4
    //   2491: aload 11
    //   2493: ldc_w 671
    //   2496: invokevirtual 667	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2499: iconst_m1
    //   2500: if_icmple +34 -> 2534
    //   2503: aload 11
    //   2505: astore 9
    //   2507: aload 7
    //   2509: astore 4
    //   2511: getstatic 673	com/tencent/mobileqq/msf/core/net/q:q	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2514: astore 8
    //   2516: aload 11
    //   2518: astore 9
    //   2520: aload 8
    //   2522: astore 4
    //   2524: aload 8
    //   2526: invokevirtual 651	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2529: astore 7
    //   2531: goto -308 -> 2223
    //   2534: aload 11
    //   2536: astore 9
    //   2538: aload 7
    //   2540: astore 4
    //   2542: aload 11
    //   2544: ldc_w 675
    //   2547: invokevirtual 667	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2550: iconst_m1
    //   2551: if_icmple +50 -> 2601
    //   2554: aload 11
    //   2556: astore 9
    //   2558: aload 7
    //   2560: astore 4
    //   2562: getstatic 650	com/tencent/mobileqq/msf/core/net/q:m	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2565: astore 8
    //   2567: aload 11
    //   2569: astore 9
    //   2571: aload 8
    //   2573: astore 4
    //   2575: aload 8
    //   2577: invokevirtual 651	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2580: astore 7
    //   2582: aload 7
    //   2584: astore 9
    //   2586: aload 8
    //   2588: astore 4
    //   2590: aload 6
    //   2592: invokestatic 654	com/tencent/mobileqq/msf/core/a/a:aA	()I
    //   2595: putfield 656	com/tencent/mobileqq/msf/core/net/a:h	I
    //   2598: goto -375 -> 2223
    //   2601: aload 11
    //   2603: astore 9
    //   2605: aload 7
    //   2607: astore 4
    //   2609: aload 11
    //   2611: ldc_w 677
    //   2614: invokevirtual 667	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2617: iconst_m1
    //   2618: if_icmple +34 -> 2652
    //   2621: aload 11
    //   2623: astore 9
    //   2625: aload 7
    //   2627: astore 4
    //   2629: getstatic 679	com/tencent/mobileqq/msf/core/net/q:i	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2632: astore 8
    //   2634: aload 11
    //   2636: astore 9
    //   2638: aload 8
    //   2640: astore 4
    //   2642: aload 8
    //   2644: invokevirtual 651	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2647: astore 7
    //   2649: goto -426 -> 2223
    //   2652: aload 11
    //   2654: astore 9
    //   2656: aload 7
    //   2658: astore 4
    //   2660: aload 11
    //   2662: ldc_w 681
    //   2665: invokevirtual 667	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2668: iconst_m1
    //   2669: if_icmple +34 -> 2703
    //   2672: aload 11
    //   2674: astore 9
    //   2676: aload 7
    //   2678: astore 4
    //   2680: getstatic 683	com/tencent/mobileqq/msf/core/net/q:s	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2683: astore 8
    //   2685: aload 11
    //   2687: astore 9
    //   2689: aload 8
    //   2691: astore 4
    //   2693: aload 8
    //   2695: invokevirtual 651	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2698: astore 7
    //   2700: goto -477 -> 2223
    //   2703: aload 11
    //   2705: astore 9
    //   2707: aload 7
    //   2709: astore 4
    //   2711: aload 11
    //   2713: ldc_w 685
    //   2716: invokevirtual 667	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2719: iconst_m1
    //   2720: if_icmple +34 -> 2754
    //   2723: aload 11
    //   2725: astore 9
    //   2727: aload 7
    //   2729: astore 4
    //   2731: getstatic 687	com/tencent/mobileqq/msf/core/net/q:r	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2734: astore 8
    //   2736: aload 11
    //   2738: astore 9
    //   2740: aload 8
    //   2742: astore 4
    //   2744: aload 8
    //   2746: invokevirtual 651	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2749: astore 7
    //   2751: goto -528 -> 2223
    //   2754: aload 11
    //   2756: astore 9
    //   2758: aload 7
    //   2760: astore 4
    //   2762: aload 11
    //   2764: ldc_w 689
    //   2767: invokevirtual 667	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2770: iconst_m1
    //   2771: if_icmpgt +23 -> 2794
    //   2774: aload 11
    //   2776: astore 9
    //   2778: aload 7
    //   2780: astore 4
    //   2782: aload 11
    //   2784: ldc_w 691
    //   2787: invokevirtual 667	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2790: iconst_m1
    //   2791: if_icmple +34 -> 2825
    //   2794: aload 11
    //   2796: astore 9
    //   2798: aload 7
    //   2800: astore 4
    //   2802: getstatic 693	com/tencent/mobileqq/msf/core/net/q:t	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2805: astore 8
    //   2807: aload 11
    //   2809: astore 9
    //   2811: aload 8
    //   2813: astore 4
    //   2815: aload 8
    //   2817: invokevirtual 651	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2820: astore 7
    //   2822: goto -599 -> 2223
    //   2825: aload 11
    //   2827: astore 9
    //   2829: aload 7
    //   2831: astore 4
    //   2833: aload 11
    //   2835: ldc_w 695
    //   2838: invokevirtual 667	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2841: iconst_m1
    //   2842: if_icmple +34 -> 2876
    //   2845: aload 11
    //   2847: astore 9
    //   2849: aload 7
    //   2851: astore 4
    //   2853: getstatic 697	com/tencent/mobileqq/msf/core/net/q:p	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2856: astore 8
    //   2858: aload 11
    //   2860: astore 9
    //   2862: aload 8
    //   2864: astore 4
    //   2866: aload 8
    //   2868: invokevirtual 651	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2871: astore 7
    //   2873: goto -650 -> 2223
    //   2876: aload 11
    //   2878: astore 9
    //   2880: aload 7
    //   2882: astore 4
    //   2884: aload 11
    //   2886: ldc_w 699
    //   2889: invokevirtual 667	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2892: iconst_m1
    //   2893: if_icmple +34 -> 2927
    //   2896: aload 11
    //   2898: astore 9
    //   2900: aload 7
    //   2902: astore 4
    //   2904: getstatic 701	com/tencent/mobileqq/msf/core/net/q:o	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2907: astore 8
    //   2909: aload 11
    //   2911: astore 9
    //   2913: aload 8
    //   2915: astore 4
    //   2917: aload 8
    //   2919: invokevirtual 651	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2922: astore 7
    //   2924: goto -701 -> 2223
    //   2927: aload 11
    //   2929: astore 9
    //   2931: aload 7
    //   2933: astore 4
    //   2935: aload 11
    //   2937: ldc_w 703
    //   2940: invokevirtual 667	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2943: iconst_m1
    //   2944: if_icmple +34 -> 2978
    //   2947: aload 11
    //   2949: astore 9
    //   2951: aload 7
    //   2953: astore 4
    //   2955: getstatic 705	com/tencent/mobileqq/msf/core/net/q:h	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2958: astore 8
    //   2960: aload 11
    //   2962: astore 9
    //   2964: aload 8
    //   2966: astore 4
    //   2968: aload 8
    //   2970: invokevirtual 651	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2973: astore 7
    //   2975: goto -752 -> 2223
    //   2978: aload 11
    //   2980: astore 9
    //   2982: aload 7
    //   2984: astore 4
    //   2986: aload 11
    //   2988: ldc_w 707
    //   2991: invokevirtual 667	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2994: iconst_m1
    //   2995: if_icmple +34 -> 3029
    //   2998: aload 11
    //   3000: astore 9
    //   3002: aload 7
    //   3004: astore 4
    //   3006: getstatic 709	com/tencent/mobileqq/msf/core/net/q:l	Lcom/tencent/mobileqq/msf/core/net/q;
    //   3009: astore 8
    //   3011: aload 11
    //   3013: astore 9
    //   3015: aload 8
    //   3017: astore 4
    //   3019: aload 8
    //   3021: invokevirtual 651	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   3024: astore 7
    //   3026: goto -803 -> 2223
    //   3029: aload 11
    //   3031: astore 9
    //   3033: aload 7
    //   3035: astore 4
    //   3037: aload 11
    //   3039: ldc_w 711
    //   3042: invokevirtual 667	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3045: iconst_m1
    //   3046: if_icmple +34 -> 3080
    //   3049: aload 11
    //   3051: astore 9
    //   3053: aload 7
    //   3055: astore 4
    //   3057: getstatic 713	com/tencent/mobileqq/msf/core/net/q:j	Lcom/tencent/mobileqq/msf/core/net/q;
    //   3060: astore 8
    //   3062: aload 11
    //   3064: astore 9
    //   3066: aload 8
    //   3068: astore 4
    //   3070: aload 8
    //   3072: invokevirtual 651	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   3075: astore 7
    //   3077: goto -854 -> 2223
    //   3080: aload 11
    //   3082: astore 9
    //   3084: aload 7
    //   3086: astore 4
    //   3088: aload 11
    //   3090: ldc_w 715
    //   3093: invokevirtual 667	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3096: iconst_m1
    //   3097: if_icmple +34 -> 3131
    //   3100: aload 11
    //   3102: astore 9
    //   3104: aload 7
    //   3106: astore 4
    //   3108: getstatic 693	com/tencent/mobileqq/msf/core/net/q:t	Lcom/tencent/mobileqq/msf/core/net/q;
    //   3111: astore 8
    //   3113: aload 11
    //   3115: astore 9
    //   3117: aload 8
    //   3119: astore 4
    //   3121: aload 8
    //   3123: invokevirtual 651	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   3126: astore 7
    //   3128: goto -905 -> 2223
    //   3131: aload 11
    //   3133: astore 9
    //   3135: aload 7
    //   3137: astore 4
    //   3139: aload 11
    //   3141: ldc_w 717
    //   3144: invokevirtual 667	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3147: iconst_m1
    //   3148: if_icmple +34 -> 3182
    //   3151: aload 11
    //   3153: astore 9
    //   3155: aload 7
    //   3157: astore 4
    //   3159: getstatic 719	com/tencent/mobileqq/msf/core/net/q:n	Lcom/tencent/mobileqq/msf/core/net/q;
    //   3162: astore 8
    //   3164: aload 11
    //   3166: astore 9
    //   3168: aload 8
    //   3170: astore 4
    //   3172: aload 8
    //   3174: invokevirtual 651	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   3177: astore 7
    //   3179: goto -956 -> 2223
    //   3182: aload 11
    //   3184: astore 9
    //   3186: aload 7
    //   3188: astore 4
    //   3190: getstatic 721	com/tencent/mobileqq/msf/core/net/q:u	Lcom/tencent/mobileqq/msf/core/net/q;
    //   3193: astore 10
    //   3195: aload 11
    //   3197: astore 9
    //   3199: aload 10
    //   3201: astore 4
    //   3203: aload 12
    //   3205: invokestatic 723	com/tencent/mobileqq/msf/core/net/g:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3208: astore 11
    //   3210: aload 11
    //   3212: astore 7
    //   3214: aload 10
    //   3216: astore 8
    //   3218: aload 11
    //   3220: astore 9
    //   3222: aload 10
    //   3224: astore 4
    //   3226: aload 11
    //   3228: invokevirtual 724	java/lang/String:length	()I
    //   3231: sipush 200
    //   3234: if_icmple -1011 -> 2223
    //   3237: aload 11
    //   3239: astore 9
    //   3241: aload 10
    //   3243: astore 4
    //   3245: aload 11
    //   3247: iconst_0
    //   3248: sipush 200
    //   3251: invokevirtual 728	java/lang/String:substring	(II)Ljava/lang/String;
    //   3254: astore 7
    //   3256: aload 10
    //   3258: astore 8
    //   3260: goto -1037 -> 2223
    //   3263: ldc -42
    //   3265: iconst_1
    //   3266: ldc_w 730
    //   3269: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3272: goto -1332 -> 1940
    //   3275: astore 4
    //   3277: aload 4
    //   3279: invokevirtual 732	java/lang/Exception:printStackTrace	()V
    //   3282: ldc -42
    //   3284: iconst_1
    //   3285: ldc_w 734
    //   3288: aload 4
    //   3290: invokestatic 327	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3293: goto -1326 -> 1967
    //   3296: ldc -42
    //   3298: iconst_1
    //   3299: ldc_w 736
    //   3302: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3305: goto -1338 -> 1967
    //   3308: astore 4
    //   3310: ldc2_w 737
    //   3313: putstatic 622	com/tencent/mobileqq/msf/core/push/d:d	J
    //   3316: ldc -42
    //   3318: iconst_1
    //   3319: ldc_w 740
    //   3322: invokestatic 742	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3325: goto -1345 -> 1980
    //   3328: aload 8
    //   3330: getstatic 498	com/tencent/mobileqq/msf/core/net/q:c	Lcom/tencent/mobileqq/msf/core/net/q;
    //   3333: if_acmpeq -1312 -> 2021
    //   3336: new 216	java/lang/StringBuilder
    //   3339: dup
    //   3340: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   3343: astore 4
    //   3345: new 216	java/lang/StringBuilder
    //   3348: dup
    //   3349: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   3352: aload 4
    //   3354: ldc_w 744
    //   3357: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3360: aload_0
    //   3361: getfield 415	com/tencent/mobileqq/msf/core/net/g:c	Ljava/net/InetSocketAddress;
    //   3364: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3367: ldc_w 746
    //   3370: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3373: aload 6
    //   3375: getfield 573	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   3378: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3381: ldc_w 748
    //   3384: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3387: lload 15
    //   3389: invokevirtual 544	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3392: ldc_w 546
    //   3395: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3398: aload_1
    //   3399: invokevirtual 441	com/tencent/mobileqq/msf/core/d:e	()I
    //   3402: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3405: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3408: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3411: astore 4
    //   3413: aload_1
    //   3414: getfield 422	com/tencent/mobileqq/msf/core/d:h	Z
    //   3417: ifeq +23 -> 3440
    //   3420: ldc_w 424
    //   3423: astore_1
    //   3424: ldc -42
    //   3426: iconst_1
    //   3427: aload 4
    //   3429: aload_1
    //   3430: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3433: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3436: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3439: return
    //   3440: ldc_w 638
    //   3443: astore_1
    //   3444: goto -20 -> 3424
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3447	0	this	g
    //   0	3447	1	paramd	d
    //   0	3447	2	paramInt1	int
    //   0	3447	3	paramInt2	int
    //   0	3447	4	paramc	c
    //   0	3447	5	paramBoolean	boolean
    //   0	3447	6	parama	a
    //   156	3099	7	localObject1	Object
    //   152	3177	8	localObject2	Object
    //   160	3080	9	localObject3	Object
    //   105	3152	10	localObject4	Object
    //   109	3137	11	str1	String
    //   294	1732	12	localObject5	Object
    //   2088	68	12	localThrowable	Throwable
    //   2287	1	12	str2	String
    //   2292	912	12	localException	Exception
    //   212	1325	13	localStringBuilder1	StringBuilder
    //   262	58	14	localStringBuilder2	StringBuilder
    //   140	3248	15	l1	long
    //   148	2149	17	l2	long
    //   355	1940	19	l3	long
    //   645	72	21	l4	long
    //   135	2247	23	l5	long
    // Exception table:
    //   from	to	target	type
    //   166	185	2088	java/lang/Throwable
    //   205	214	2088	java/lang/Throwable
    //   234	264	2088	java/lang/Throwable
    //   284	291	2088	java/lang/Throwable
    //   316	332	2088	java/lang/Throwable
    //   352	357	2088	java/lang/Throwable
    //   377	383	2088	java/lang/Throwable
    //   403	414	2088	java/lang/Throwable
    //   434	442	2088	java/lang/Throwable
    //   462	470	2088	java/lang/Throwable
    //   490	498	2088	java/lang/Throwable
    //   518	533	2088	java/lang/Throwable
    //   553	559	2088	java/lang/Throwable
    //   579	591	2088	java/lang/Throwable
    //   611	618	2088	java/lang/Throwable
    //   638	647	2088	java/lang/Throwable
    //   667	679	2088	java/lang/Throwable
    //   699	712	2088	java/lang/Throwable
    //   746	753	2088	java/lang/Throwable
    //   773	781	2088	java/lang/Throwable
    //   801	809	2088	java/lang/Throwable
    //   829	840	2088	java/lang/Throwable
    //   860	876	2088	java/lang/Throwable
    //   896	910	2088	java/lang/Throwable
    //   930	950	2088	java/lang/Throwable
    //   970	982	2088	java/lang/Throwable
    //   1002	1012	2088	java/lang/Throwable
    //   1032	1039	2088	java/lang/Throwable
    //   1059	1067	2088	java/lang/Throwable
    //   1087	1092	2088	java/lang/Throwable
    //   1117	1122	2088	java/lang/Throwable
    //   1142	1145	2088	java/lang/Throwable
    //   1165	1204	2088	java/lang/Throwable
    //   1224	1263	2088	java/lang/Throwable
    //   1283	1289	2088	java/lang/Throwable
    //   1309	1313	2088	java/lang/Throwable
    //   1333	1340	2088	java/lang/Throwable
    //   1360	1372	2088	java/lang/Throwable
    //   1392	1481	2088	java/lang/Throwable
    //   1501	1508	2088	java/lang/Throwable
    //   1533	1549	2088	java/lang/Throwable
    //   1569	1577	2088	java/lang/Throwable
    //   1597	1603	2088	java/lang/Throwable
    //   1623	1628	2088	java/lang/Throwable
    //   1653	1662	2088	java/lang/Throwable
    //   1682	1695	2088	java/lang/Throwable
    //   1715	1737	2088	java/lang/Throwable
    //   2050	2056	2088	java/lang/Throwable
    //   2076	2085	2088	java/lang/Throwable
    //   2314	2325	2088	java/lang/Throwable
    //   1653	1662	2292	java/lang/Exception
    //   1682	1695	2292	java/lang/Exception
    //   1715	1737	2292	java/lang/Exception
    //   166	185	2328	finally
    //   205	214	2328	finally
    //   234	264	2328	finally
    //   284	291	2328	finally
    //   316	332	2328	finally
    //   352	357	2328	finally
    //   377	383	2328	finally
    //   403	414	2328	finally
    //   434	442	2328	finally
    //   462	470	2328	finally
    //   490	498	2328	finally
    //   518	533	2328	finally
    //   553	559	2328	finally
    //   579	591	2328	finally
    //   611	618	2328	finally
    //   638	647	2328	finally
    //   667	679	2328	finally
    //   699	712	2328	finally
    //   746	753	2328	finally
    //   773	781	2328	finally
    //   801	809	2328	finally
    //   829	840	2328	finally
    //   860	876	2328	finally
    //   896	910	2328	finally
    //   930	950	2328	finally
    //   970	982	2328	finally
    //   1002	1012	2328	finally
    //   1032	1039	2328	finally
    //   1059	1067	2328	finally
    //   1087	1092	2328	finally
    //   1117	1122	2328	finally
    //   1142	1145	2328	finally
    //   1165	1204	2328	finally
    //   1224	1263	2328	finally
    //   1283	1289	2328	finally
    //   1309	1313	2328	finally
    //   1333	1340	2328	finally
    //   1360	1372	2328	finally
    //   1392	1481	2328	finally
    //   1501	1508	2328	finally
    //   1533	1549	2328	finally
    //   1569	1577	2328	finally
    //   1597	1603	2328	finally
    //   1623	1628	2328	finally
    //   1653	1662	2328	finally
    //   1682	1695	2328	finally
    //   1715	1737	2328	finally
    //   2050	2056	2328	finally
    //   2076	2085	2328	finally
    //   2098	2106	2328	finally
    //   2114	2126	2328	finally
    //   2134	2147	2328	finally
    //   2155	2165	2328	finally
    //   2173	2179	2328	finally
    //   2187	2192	2328	finally
    //   2200	2207	2328	finally
    //   2215	2223	2328	finally
    //   2314	2325	2328	finally
    //   2440	2452	2328	finally
    //   2460	2465	2328	finally
    //   2473	2480	2328	finally
    //   2491	2503	2328	finally
    //   2511	2516	2328	finally
    //   2524	2531	2328	finally
    //   2542	2554	2328	finally
    //   2562	2567	2328	finally
    //   2575	2582	2328	finally
    //   2590	2598	2328	finally
    //   2609	2621	2328	finally
    //   2629	2634	2328	finally
    //   2642	2649	2328	finally
    //   2660	2672	2328	finally
    //   2680	2685	2328	finally
    //   2693	2700	2328	finally
    //   2711	2723	2328	finally
    //   2731	2736	2328	finally
    //   2744	2751	2328	finally
    //   2762	2774	2328	finally
    //   2782	2794	2328	finally
    //   2802	2807	2328	finally
    //   2815	2822	2328	finally
    //   2833	2845	2328	finally
    //   2853	2858	2328	finally
    //   2866	2873	2328	finally
    //   2884	2896	2328	finally
    //   2904	2909	2328	finally
    //   2917	2924	2328	finally
    //   2935	2947	2328	finally
    //   2955	2960	2328	finally
    //   2968	2975	2328	finally
    //   2986	2998	2328	finally
    //   3006	3011	2328	finally
    //   3019	3026	2328	finally
    //   3037	3049	2328	finally
    //   3057	3062	2328	finally
    //   3070	3077	2328	finally
    //   3088	3100	2328	finally
    //   3108	3113	2328	finally
    //   3121	3128	2328	finally
    //   3139	3151	2328	finally
    //   3159	3164	2328	finally
    //   3172	3179	2328	finally
    //   3190	3195	2328	finally
    //   3203	3210	2328	finally
    //   3226	3237	2328	finally
    //   3245	3256	2328	finally
    //   116	146	2389	java/lang/InterruptedException
    //   1737	1770	2389	java/lang/InterruptedException
    //   1770	1796	2389	java/lang/InterruptedException
    //   1800	1825	2389	java/lang/InterruptedException
    //   1825	1918	2389	java/lang/InterruptedException
    //   1918	1940	2389	java/lang/InterruptedException
    //   1940	1967	2389	java/lang/InterruptedException
    //   1967	1980	2389	java/lang/InterruptedException
    //   1980	2021	2389	java/lang/InterruptedException
    //   2223	2256	2389	java/lang/InterruptedException
    //   2256	2281	2389	java/lang/InterruptedException
    //   2329	2362	2389	java/lang/InterruptedException
    //   2362	2389	2389	java/lang/InterruptedException
    //   3263	3272	2389	java/lang/InterruptedException
    //   3277	3293	2389	java/lang/InterruptedException
    //   3296	3305	2389	java/lang/InterruptedException
    //   3310	3325	2389	java/lang/InterruptedException
    //   3328	3420	2389	java/lang/InterruptedException
    //   3424	3439	2389	java/lang/InterruptedException
    //   1918	1940	3275	java/lang/Exception
    //   1940	1967	3275	java/lang/Exception
    //   3263	3272	3275	java/lang/Exception
    //   3296	3305	3275	java/lang/Exception
    //   1967	1980	3308	java/lang/Exception
  }
  
  /* Error */
  public void a(com.tencent.qphone.base.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   4: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   7: iconst_0
    //   8: putfield 750	com/tencent/mobileqq/msf/core/w:m	Z
    //   11: aload_0
    //   12: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   15: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   18: iconst_0
    //   19: putfield 197	com/tencent/mobileqq/msf/core/w:n	Z
    //   22: aload_0
    //   23: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   26: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   29: lconst_0
    //   30: putfield 752	com/tencent/mobileqq/msf/core/w:l	J
    //   33: aload_0
    //   34: getfield 502	com/tencent/mobileqq/msf/core/net/g:B	Lcom/tencent/mobileqq/msf/core/d;
    //   37: ifnull +16 -> 53
    //   40: aload_0
    //   41: getfield 502	com/tencent/mobileqq/msf/core/net/g:B	Lcom/tencent/mobileqq/msf/core/d;
    //   44: invokevirtual 408	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   47: invokestatic 618	com/tencent/qphone/base/util/e:b	(Ljava/lang/String;)J
    //   50: putstatic 754	com/tencent/mobileqq/msf/core/push/d:c	J
    //   53: aload_0
    //   54: getfield 364	com/tencent/mobileqq/msf/core/net/g:x	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   57: ifnull +22 -> 79
    //   60: aload_0
    //   61: invokevirtual 367	com/tencent/mobileqq/msf/core/net/g:f	()Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   64: pop
    //   65: aload_0
    //   66: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   69: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   72: aload_0
    //   73: getfield 369	com/tencent/mobileqq/msf/core/net/g:y	Ljava/lang/Runnable;
    //   76: invokevirtual 372	com/tencent/mobileqq/msf/core/w:a	(Ljava/lang/Runnable;)V
    //   79: aload_0
    //   80: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   83: ifnonnull +49 -> 132
    //   86: ldc -42
    //   88: iconst_1
    //   89: new 216	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 756
    //   99: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: return
    //   113: astore_2
    //   114: ldc2_w 737
    //   117: putstatic 754	com/tencent/mobileqq/msf/core/push/d:c	J
    //   120: ldc -42
    //   122: iconst_1
    //   123: ldc_w 758
    //   126: invokestatic 742	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: goto -76 -> 53
    //   132: invokestatic 761	com/tencent/mobileqq/msf/core/a/a:aE	()Z
    //   135: ifeq +539 -> 674
    //   138: getstatic 272	com/tencent/mobileqq/msf/core/w:p	Z
    //   141: ifeq +49 -> 190
    //   144: invokestatic 276	com/tencent/mobileqq/msf/core/net/a/f:a	()Z
    //   147: ifeq +43 -> 190
    //   150: ldc -42
    //   152: iconst_1
    //   153: ldc_w 763
    //   156: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload_0
    //   160: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   163: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   166: getfield 282	com/tencent/mobileqq/msf/core/w:G	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   169: ifnull +21 -> 190
    //   172: aload_0
    //   173: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   176: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   179: getfield 282	com/tencent/mobileqq/msf/core/w:G	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   182: invokevirtual 285	com/tencent/mobileqq/msf/core/net/a/f:b	()Lcom/tencent/mobileqq/msf/core/net/a/e;
    //   185: invokeinterface 765 1 0
    //   190: iconst_1
    //   191: istore 8
    //   193: invokestatic 766	com/tencent/mobileqq/a/a/b:a	()V
    //   196: invokestatic 769	com/tencent/mobileqq/msf/core/a/a:aD	()Z
    //   199: ifeq +6 -> 205
    //   202: invokestatic 772	com/tencent/mobileqq/a/a/a:a	()V
    //   205: aload_0
    //   206: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   209: invokevirtual 773	java/net/Socket:toString	()Ljava/lang/String;
    //   212: astore_2
    //   213: aload_0
    //   214: getfield 110	com/tencent/mobileqq/msf/core/net/g:v	Ljava/util/concurrent/locks/ReentrantLock;
    //   217: ldc2_w 382
    //   220: getstatic 389	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   223: invokevirtual 393	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   226: istore 7
    //   228: iload 7
    //   230: ifeq +507 -> 737
    //   233: aload_0
    //   234: getfield 85	com/tencent/mobileqq/msf/core/net/g:C	Ljava/util/concurrent/atomic/AtomicInteger;
    //   237: iconst_0
    //   238: invokevirtual 559	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   241: aload_0
    //   242: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   245: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   248: aconst_null
    //   249: invokevirtual 588	com/tencent/mobileqq/msf/core/w:a	([B)V
    //   252: aload_0
    //   253: getfield 101	com/tencent/mobileqq/msf/core/net/g:s	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   256: invokevirtual 166	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   259: istore 7
    //   261: aload_0
    //   262: getfield 487	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   265: ifnull +14 -> 279
    //   268: aload_0
    //   269: getfield 487	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   272: getfield 775	com/tencent/mobileqq/msf/core/net/g$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   275: iconst_0
    //   276: invokevirtual 354	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   279: aload_0
    //   280: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   283: invokevirtual 779	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   286: ifnull +13 -> 299
    //   289: aload_0
    //   290: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   293: invokevirtual 779	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   296: invokevirtual 784	java/io/InputStream:close	()V
    //   299: aload_0
    //   300: getfield 74	com/tencent/mobileqq/msf/core/net/g:h	Ljava/io/OutputStream;
    //   303: astore_3
    //   304: aload_3
    //   305: ifnull +24 -> 329
    //   308: getstatic 67	com/tencent/mobileqq/msf/core/net/g:n	Ljava/util/ArrayList;
    //   311: aload_0
    //   312: getfield 74	com/tencent/mobileqq/msf/core/net/g:h	Ljava/io/OutputStream;
    //   315: invokevirtual 469	java/lang/Object:toString	()Ljava/lang/String;
    //   318: invokevirtual 786	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   321: pop
    //   322: aload_0
    //   323: getfield 74	com/tencent/mobileqq/msf/core/net/g:h	Ljava/io/OutputStream;
    //   326: invokevirtual 787	java/io/OutputStream:close	()V
    //   329: aload_0
    //   330: aconst_null
    //   331: putfield 487	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   334: aload_0
    //   335: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   338: astore_3
    //   339: aload_3
    //   340: ifnull +30 -> 370
    //   343: aload_0
    //   344: getfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   347: invokevirtual 788	java/net/Socket:close	()V
    //   350: aload_1
    //   351: invokestatic 791	com/tencent/mobileqq/msf/core/aa:a	(Lcom/tencent/qphone/base/a;)V
    //   354: aload_0
    //   355: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   358: invokevirtual 795	com/tencent/mobileqq/msf/core/MsfCore:getStandyModeManager	()Lcom/tencent/mobileqq/msf/core/d/a;
    //   361: invokevirtual 798	com/tencent/mobileqq/msf/core/d/a:f	()V
    //   364: getstatic 67	com/tencent/mobileqq/msf/core/net/g:n	Ljava/util/ArrayList;
    //   367: invokevirtual 597	java/util/ArrayList:clear	()V
    //   370: aload_0
    //   371: aconst_null
    //   372: putfield 264	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   375: aload_0
    //   376: getfield 101	com/tencent/mobileqq/msf/core/net/g:s	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   379: iconst_0
    //   380: invokevirtual 354	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   383: aload_0
    //   384: aconst_null
    //   385: putfield 168	com/tencent/mobileqq/msf/core/net/g:i	Lcom/tencent/mobileqq/msf/core/net/c;
    //   388: aload_0
    //   389: getfield 110	com/tencent/mobileqq/msf/core/net/g:v	Ljava/util/concurrent/locks/ReentrantLock;
    //   392: invokevirtual 567	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   395: aload_0
    //   396: getfield 105	com/tencent/mobileqq/msf/core/net/g:u	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   399: invokevirtual 166	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   402: ifne +201 -> 603
    //   405: iload 7
    //   407: ifeq +196 -> 603
    //   410: aload_0
    //   411: getfield 114	com/tencent/mobileqq/msf/core/net/g:w	Z
    //   414: ifeq +189 -> 603
    //   417: aload_0
    //   418: getfield 94	com/tencent/mobileqq/msf/core/net/g:q	J
    //   421: lconst_0
    //   422: lcmp
    //   423: ifle +108 -> 531
    //   426: invokestatic 404	java/lang/System:currentTimeMillis	()J
    //   429: aload_0
    //   430: getfield 94	com/tencent/mobileqq/msf/core/net/g:q	J
    //   433: lsub
    //   434: lstore 5
    //   436: aload_0
    //   437: lconst_0
    //   438: putfield 94	com/tencent/mobileqq/msf/core/net/g:q	J
    //   441: aload_0
    //   442: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   445: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   448: invokevirtual 801	com/tencent/mobileqq/msf/core/w:b	()[B
    //   451: invokestatic 807	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   454: astore_3
    //   455: invokestatic 810	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:getCurrentAPN	()Ljava/lang/String;
    //   458: astore 4
    //   460: aload_0
    //   461: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   464: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   467: getfield 454	com/tencent/mobileqq/msf/core/w:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   470: invokevirtual 811	com/tencent/mobileqq/msf/core/net/h:d	()V
    //   473: aload_0
    //   474: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   477: getfield 193	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/w;
    //   480: getfield 454	com/tencent/mobileqq/msf/core/w:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   483: lconst_0
    //   484: putfield 812	com/tencent/mobileqq/msf/core/net/h:q	J
    //   487: aload_0
    //   488: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   491: invokevirtual 816	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/m;
    //   494: iconst_0
    //   495: lload 5
    //   497: ldc2_w 817
    //   500: ldiv
    //   501: aload_0
    //   502: getfield 176	com/tencent/mobileqq/msf/core/net/g:d	Lcom/tencent/mobileqq/msf/core/d;
    //   505: aload_1
    //   506: getstatic 528	com/tencent/mobileqq/msf/core/w:F	I
    //   509: lload 5
    //   511: aload_0
    //   512: getfield 90	com/tencent/mobileqq/msf/core/net/g:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   515: invokevirtual 820	java/util/concurrent/atomic/AtomicLong:get	()J
    //   518: aload_0
    //   519: getfield 92	com/tencent/mobileqq/msf/core/net/g:p	Ljava/util/concurrent/atomic/AtomicLong;
    //   522: invokevirtual 820	java/util/concurrent/atomic/AtomicLong:get	()J
    //   525: aload_3
    //   526: aload 4
    //   528: invokevirtual 825	com/tencent/mobileqq/msf/core/c/m:a	(ZJLcom/tencent/mobileqq/msf/core/d;Lcom/tencent/qphone/base/a;IJJJLjava/lang/String;Ljava/lang/String;)V
    //   531: ldc -42
    //   533: iconst_1
    //   534: new 216	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   541: ldc_w 827
    //   544: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload_2
    //   548: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: ldc_w 829
    //   554: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: aload_1
    //   558: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   567: aload_0
    //   568: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   571: aconst_null
    //   572: putfield 600	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   575: aload_0
    //   576: aconst_null
    //   577: putfield 176	com/tencent/mobileqq/msf/core/net/g:d	Lcom/tencent/mobileqq/msf/core/d;
    //   580: aload_0
    //   581: getfield 90	com/tencent/mobileqq/msf/core/net/g:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   584: lconst_0
    //   585: invokevirtual 464	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   588: aload_0
    //   589: getfield 92	com/tencent/mobileqq/msf/core/net/g:p	Ljava/util/concurrent/atomic/AtomicLong;
    //   592: lconst_0
    //   593: invokevirtual 464	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   596: invokestatic 834	com/tencent/qphone/base/util/CodecWarpper:onConnClose	()V
    //   599: aload_1
    //   600: invokestatic 837	com/tencent/mobileqq/msf/core/NetConnInfoCenter:onConnClosed	(Lcom/tencent/qphone/base/a;)V
    //   603: aload_0
    //   604: getfield 502	com/tencent/mobileqq/msf/core/net/g:B	Lcom/tencent/mobileqq/msf/core/d;
    //   607: ifnull +28 -> 635
    //   610: aload_0
    //   611: getfield 502	com/tencent/mobileqq/msf/core/net/g:B	Lcom/tencent/mobileqq/msf/core/d;
    //   614: aload_1
    //   615: invokevirtual 840	com/tencent/mobileqq/msf/core/d:a	(Lcom/tencent/qphone/base/a;)Z
    //   618: ifeq +17 -> 635
    //   621: aload_0
    //   622: getfield 112	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   625: invokevirtual 844	com/tencent/mobileqq/msf/core/MsfCore:getSsoListManager	()Lcom/tencent/mobileqq/msf/core/a/d;
    //   628: aload_0
    //   629: getfield 502	com/tencent/mobileqq/msf/core/net/g:B	Lcom/tencent/mobileqq/msf/core/d;
    //   632: invokevirtual 849	com/tencent/mobileqq/msf/core/a/d:a	(Lcom/tencent/mobileqq/msf/core/d;)V
    //   635: aload_0
    //   636: aconst_null
    //   637: putfield 502	com/tencent/mobileqq/msf/core/net/g:B	Lcom/tencent/mobileqq/msf/core/d;
    //   640: ldc_w 506
    //   643: putstatic 508	com/tencent/mobileqq/msf/core/w:D	Ljava/lang/String;
    //   646: ldc_w 851
    //   649: putstatic 520	com/tencent/mobileqq/msf/core/w:E	Ljava/lang/String;
    //   652: return
    //   653: astore_1
    //   654: aload_1
    //   655: invokevirtual 732	java/lang/Exception:printStackTrace	()V
    //   658: return
    //   659: astore_2
    //   660: getstatic 855	com/tencent/mobileqq/msf/core/net/a/a:a	Ljava/lang/String;
    //   663: iconst_1
    //   664: ldc_w 857
    //   667: aload_2
    //   668: invokestatic 327	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   671: goto -481 -> 190
    //   674: iconst_0
    //   675: putstatic 272	com/tencent/mobileqq/msf/core/w:p	Z
    //   678: goto -488 -> 190
    //   681: astore_3
    //   682: aload_3
    //   683: invokevirtual 858	java/lang/Throwable:printStackTrace	()V
    //   686: goto -322 -> 364
    //   689: astore_3
    //   690: goto -320 -> 370
    //   693: astore_3
    //   694: iconst_1
    //   695: istore 7
    //   697: aload_0
    //   698: getfield 110	com/tencent/mobileqq/msf/core/net/g:v	Ljava/util/concurrent/locks/ReentrantLock;
    //   701: invokevirtual 567	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   704: aload_3
    //   705: athrow
    //   706: astore_3
    //   707: ldc -42
    //   709: iconst_1
    //   710: new 216	java/lang/StringBuilder
    //   713: dup
    //   714: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   717: ldc_w 860
    //   720: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: aload_3
    //   724: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   727: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: aload_3
    //   731: invokestatic 327	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   734: goto -339 -> 395
    //   737: aload_0
    //   738: getfield 487	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   741: ifnull +14 -> 755
    //   744: aload_0
    //   745: getfield 487	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   748: getfield 775	com/tencent/mobileqq/msf/core/net/g$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   751: iconst_0
    //   752: invokevirtual 354	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   755: ldc -42
    //   757: iconst_1
    //   758: ldc_w 862
    //   761: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   764: aload_0
    //   765: getfield 105	com/tencent/mobileqq/msf/core/net/g:u	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   768: iconst_1
    //   769: invokevirtual 354	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   772: iload 8
    //   774: istore 7
    //   776: aload_0
    //   777: getfield 85	com/tencent/mobileqq/msf/core/net/g:C	Ljava/util/concurrent/atomic/AtomicInteger;
    //   780: iconst_1
    //   781: invokevirtual 865	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   784: bipush 10
    //   786: if_icmpne -391 -> 395
    //   789: invokestatic 870	android/os/Process:myPid	()I
    //   792: invokestatic 873	android/os/Process:killProcess	(I)V
    //   795: iload 8
    //   797: istore 7
    //   799: goto -404 -> 395
    //   802: astore_3
    //   803: iconst_1
    //   804: istore 7
    //   806: goto -99 -> 707
    //   809: astore_2
    //   810: ldc -42
    //   812: iconst_1
    //   813: new 216	java/lang/StringBuilder
    //   816: dup
    //   817: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   820: ldc_w 875
    //   823: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: aload_2
    //   827: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   830: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: aload_2
    //   834: invokestatic 327	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   837: goto -238 -> 599
    //   840: astore_3
    //   841: iconst_1
    //   842: istore 7
    //   844: ldc 78
    //   846: astore_2
    //   847: goto -140 -> 707
    //   850: astore_3
    //   851: goto -144 -> 707
    //   854: astore_3
    //   855: goto -158 -> 697
    //   858: astore_3
    //   859: goto -530 -> 329
    //   862: astore_3
    //   863: goto -564 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	866	0	this	g
    //   0	866	1	parama	com.tencent.qphone.base.a
    //   113	1	2	localException1	Exception
    //   212	336	2	str1	String
    //   659	9	2	localException2	Exception
    //   809	25	2	localException3	Exception
    //   846	1	2	str2	String
    //   303	223	3	localObject1	Object
    //   681	2	3	localThrowable1	Throwable
    //   689	1	3	localThrowable2	Throwable
    //   693	12	3	localObject2	Object
    //   706	25	3	localThrowable3	Throwable
    //   802	1	3	localThrowable4	Throwable
    //   840	1	3	localThrowable5	Throwable
    //   850	1	3	localThrowable6	Throwable
    //   854	1	3	localObject3	Object
    //   858	1	3	localException4	Exception
    //   862	1	3	localThrowable7	Throwable
    //   458	69	4	str3	String
    //   434	76	5	l1	long
    //   226	617	7	bool1	boolean
    //   191	605	8	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   40	53	113	java/lang/Exception
    //   603	635	653	java/lang/Exception
    //   635	652	653	java/lang/Exception
    //   150	190	659	java/lang/Exception
    //   350	364	681	java/lang/Throwable
    //   343	350	689	java/lang/Throwable
    //   364	370	689	java/lang/Throwable
    //   682	686	689	java/lang/Throwable
    //   233	261	693	finally
    //   697	706	706	java/lang/Throwable
    //   213	228	802	java/lang/Throwable
    //   737	755	802	java/lang/Throwable
    //   755	772	802	java/lang/Throwable
    //   776	795	802	java/lang/Throwable
    //   596	599	809	java/lang/Exception
    //   205	213	840	java/lang/Throwable
    //   388	395	850	java/lang/Throwable
    //   261	279	854	finally
    //   279	299	854	finally
    //   299	304	854	finally
    //   308	329	854	finally
    //   329	339	854	finally
    //   343	350	854	finally
    //   350	364	854	finally
    //   364	370	854	finally
    //   370	388	854	finally
    //   682	686	854	finally
    //   308	329	858	java/lang/Exception
    //   279	299	862	java/lang/Throwable
  }
  
  public boolean a()
  {
    return this.r;
  }
  
  public boolean b()
  {
    return this.s.get();
  }
  
  public long c()
  {
    return this.q;
  }
  
  public void d()
  {
    try
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "MSF");
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setMsfCommand(MsfCommand.msf_msgsignal);
      QLog.d("MSF.C.NetConnTag", 1, "msgSignal seq: " + localToServiceMsg.getRequestSsoSeq());
      int i1 = "CHNK".getBytes().length + 13 + 1 + 0 + 4;
      byte b1 = (byte)("CHNK".getBytes().length + 1);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i1);
      localByteBuffer.putInt(i1).putInt(20140601).putInt(0).put(b1).put("CHNK".getBytes()).put((byte)1).putInt(0);
      localToServiceMsg.putWupBuffer(localByteBuffer.array());
      a(this.z.getMsfAppid(), 0, localToServiceMsg.getRequestSsoSeq(), localToServiceMsg.getUin(), localToServiceMsg.getServiceCmd(), "", localToServiceMsg.getMsfCommand(), localToServiceMsg.getWupBuffer(), null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("MSF.C.NetConnTag", 1, "send MsgSignal pkg fail, exception ", localException);
    }
  }
  
  public void e()
  {
    try
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "MSF");
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setMsfCommand(MsfCommand.msf_ssoping);
      long l1 = com.tencent.mobileqq.msf.core.a.a.t();
      if (l1 > 10000L) {
        localToServiceMsg.setTimeout(l1);
      }
      for (;;)
      {
        QLog.d("MSF.C.NetConnTag", 1, "ssoping seq: " + localToServiceMsg.getRequestSsoSeq() + " timeout: " + localToServiceMsg.getTimeout());
        int i1 = "MSF".getBytes().length + 13 + 1 + 0 + 4;
        byte b1 = (byte)"MSF".getBytes().length;
        ByteBuffer localByteBuffer = ByteBuffer.allocate(i1);
        localByteBuffer.putInt(i1).putInt(20140601).putInt(0).put(b1).put("MSF".getBytes()).put((byte)0).putInt(0);
        localToServiceMsg.putWupBuffer(localByteBuffer.array());
        this.x = localToServiceMsg;
        this.z.sender.c(localToServiceMsg);
        localToServiceMsg.getAttributes().put("__timestamp_msf2net", Long.valueOf(SystemClock.elapsedRealtime()));
        if (a(this.z.getMsfAppid(), 0, localToServiceMsg.getRequestSsoSeq(), localToServiceMsg.getUin(), localToServiceMsg.getServiceCmd(), "", localToServiceMsg.getMsfCommand(), localToServiceMsg.getWupBuffer(), null) <= 0) {
          break;
        }
        return;
        localToServiceMsg.setTimeout(10000L);
      }
      this.z.sender.c(localException.getRequestSsoSeq());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("MSF.C.NetConnTag", 1, "send SSOPing pkg fail, exception ", localException);
      return;
    }
    this.z.sender.d(localException);
    QLog.d("MSF.C.NetConnTag", 1, "send SSOPing pkg fail");
    a(com.tencent.qphone.base.a.C);
  }
  
  public ToServiceMsg f()
  {
    if (this.x != null)
    {
      this.z.sender.c(this.x.getRequestSsoSeq());
      this.z.sender.d(this.x);
    }
    return this.x;
  }
  
  class a
    extends Thread
  {
    AtomicBoolean a = new AtomicBoolean(true);
    long b = SystemClock.elapsedRealtime();
    
    a() {}
    
    public void run()
    {
      while (this.a.get()) {
        try
        {
          while (!g.this.k.isDataAvailable(g.this.f)) {
            if (!this.a.get()) {
              return;
            }
          }
          if (!this.a.get()) {
            break;
          }
          g.this.i.a(g.this.k);
          g.this.p.addAndGet(g.this.k.getBufferlen());
          g.this.k.reset();
        }
        catch (Throwable localThrowable)
        {
          this.a.set(false);
          QLog.d("MSF.C.NetConnTag", 1, "read DataError " + localThrowable);
          g.this.a(com.tencent.qphone.base.a.c);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\net\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */