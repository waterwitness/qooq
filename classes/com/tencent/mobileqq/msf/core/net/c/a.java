package com.tencent.mobileqq.msf.core.net.c;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.n;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class a
  implements Runnable
{
  private static final String D = "HTTP/1.";
  private static final String E = "Cookie:";
  private static final String F = "Set-Cookie:";
  private static final String G = "Content-Length:";
  private static final String H = "md5=";
  private static final String I = "gateway=";
  private static final String J = ";";
  private static final String K = "\r\n";
  private static final String L = "\r\n\r\n";
  private static final String M = "200";
  private static final int N = 10240;
  private static final int O = 5;
  private static HostnameVerifier P = new b();
  long A = 0L;
  long B = 0L;
  long C = 0L;
  private String Q = "";
  private int R;
  private int S;
  private boolean T = true;
  a a;
  com.tencent.msf.service.protocol.push.a.d b;
  com.tencent.msf.service.protocol.push.a.b c;
  int d;
  int e;
  boolean f = false;
  DatagramSocket g = null;
  Socket h = null;
  OutputStream i = null;
  URL j = null;
  HttpURLConnection k;
  int l = 0;
  int m = 10000;
  InetAddress n = null;
  int o;
  d p = new d();
  c q = new c();
  long r = 0L;
  long s = 0L;
  long t = 0L;
  long u = 0L;
  long v = 0L;
  long w = 0L;
  long x = 0L;
  long y = 0L;
  long z = 0L;
  
  public a(com.tencent.msf.service.protocol.push.a.d paramd, a parama)
  {
    this.b = paramd;
    this.a = parama;
    this.c = null;
    this.d = 1;
    this.e = 0;
  }
  
  public a(com.tencent.msf.service.protocol.push.a.d paramd, com.tencent.msf.service.protocol.push.a.b paramb, a parama, int paramInt1, int paramInt2)
  {
    this.b = paramd;
    this.c = paramb;
    this.a = parama;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  private void a(a.d.a parama)
  {
    if (this.p.c.containsKey(parama))
    {
      int i1 = ((Integer)this.p.c.get(parama)).intValue();
      this.p.c.put(parama, Integer.valueOf(i1 + 1));
      return;
    }
    this.p.c.put(parama, Integer.valueOf(1));
  }
  
  private void a(String paramString)
  {
    if (NetConnInfoCenterImpl.getSystemNetworkType() == 0)
    {
      a(a.d.a.y);
      return;
    }
    if (paramString.indexOf("timeout") > -1)
    {
      a(a.d.a.x);
      return;
    }
    a(a.d.a.e);
  }
  
  private boolean a(int paramInt)
  {
    if (this.a == a.c) {
      if (paramInt != 0) {}
    }
    do
    {
      do
      {
        return true;
        if (paramInt > 524288)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + paramInt + " return http");
          }
          this.T = false;
          a(a.d.a.h);
          return false;
        }
      } while (paramInt >= 1);
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData too short, http qualityTestMsg.sPkgData.length:" + this.b.e.length);
      }
      a(a.d.a.i);
      return false;
      if (paramInt > 524288)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + paramInt + " return not http");
        }
        this.T = false;
        a(a.d.a.h);
        return false;
      }
    } while (paramInt >= 1);
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData too short, not http qualityTestMsg.sPkgData.length:" + this.b.e.length);
    }
    a(a.d.a.i);
    return false;
  }
  
  /* Error */
  private boolean a(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 286	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc -14
    //   8: iconst_2
    //   9: new 244	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 288
    //   19: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: iload_1
    //   33: ldc -22
    //   35: if_icmple +26 -> 61
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 144	com/tencent/mobileqq/msf/core/net/c/a:T	Z
    //   43: aload_0
    //   44: getstatic 290	com/tencent/mobileqq/msf/core/net/c/a$d$a:A	Lcom/tencent/mobileqq/msf/core/net/c/a$d$a;
    //   47: invokespecial 218	com/tencent/mobileqq/msf/core/net/c/a:a	(Lcom/tencent/mobileqq/msf/core/net/c/a$d$a;)V
    //   50: ldc -14
    //   52: iconst_1
    //   53: ldc_w 292
    //   56: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: iconst_0
    //   60: ireturn
    //   61: invokestatic 286	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   64: ifeq +35 -> 99
    //   67: ldc -14
    //   69: iconst_2
    //   70: new 244	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 294
    //   80: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_0
    //   84: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   87: getfield 296	com/tencent/msf/service/protocol/push/a/d:o	S
    //   90: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: getstatic 299	com/tencent/mobileqq/msf/core/net/c/a$1:a	[I
    //   102: aload_0
    //   103: getfield 172	com/tencent/mobileqq/msf/core/net/c/a:a	Lcom/tencent/mobileqq/msf/core/net/c/a$a;
    //   106: invokevirtual 302	com/tencent/mobileqq/msf/core/net/c/a$a:ordinal	()I
    //   109: iaload
    //   110: tableswitch	default:+3123->3233, 1:+26->136, 2:+760->870, 3:+1984->2094
    //   136: iload_1
    //   137: newarray <illegal type>
    //   139: astore_3
    //   140: new 304	java/net/DatagramPacket
    //   143: dup
    //   144: aload_3
    //   145: iload_1
    //   146: invokespecial 307	java/net/DatagramPacket:<init>	([BI)V
    //   149: astore 4
    //   151: aload_0
    //   152: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   155: putfield 160	com/tencent/mobileqq/msf/core/net/c/a:y	J
    //   158: aload_0
    //   159: getfield 120	com/tencent/mobileqq/msf/core/net/c/a:g	Ljava/net/DatagramSocket;
    //   162: aload 4
    //   164: invokevirtual 319	java/net/DatagramSocket:receive	(Ljava/net/DatagramPacket;)V
    //   167: aload_0
    //   168: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   171: putfield 162	com/tencent/mobileqq/msf/core/net/c/a:z	J
    //   174: aload_0
    //   175: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   178: aload_0
    //   179: getfield 152	com/tencent/mobileqq/msf/core/net/c/a:u	J
    //   182: putfield 321	com/tencent/mobileqq/msf/core/net/c/a$d:L	J
    //   185: aload_0
    //   186: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   189: aload_0
    //   190: getfield 162	com/tencent/mobileqq/msf/core/net/c/a:z	J
    //   193: putfield 323	com/tencent/mobileqq/msf/core/net/c/a$d:M	J
    //   196: aload_0
    //   197: aload_0
    //   198: getfield 162	com/tencent/mobileqq/msf/core/net/c/a:z	J
    //   201: aload_0
    //   202: getfield 152	com/tencent/mobileqq/msf/core/net/c/a:u	J
    //   205: lsub
    //   206: putfield 168	com/tencent/mobileqq/msf/core/net/c/a:C	J
    //   209: aload_0
    //   210: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   213: getfield 326	com/tencent/mobileqq/msf/core/net/c/a$d:I	Ljava/util/ArrayList;
    //   216: aload_0
    //   217: getfield 168	com/tencent/mobileqq/msf/core/net/c/a:C	J
    //   220: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   223: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   226: pop
    //   227: aload_0
    //   228: aload_0
    //   229: getfield 164	com/tencent/mobileqq/msf/core/net/c/a:A	J
    //   232: aload_0
    //   233: getfield 162	com/tencent/mobileqq/msf/core/net/c/a:z	J
    //   236: aload_0
    //   237: getfield 160	com/tencent/mobileqq/msf/core/net/c/a:y	J
    //   240: lsub
    //   241: ladd
    //   242: putfield 164	com/tencent/mobileqq/msf/core/net/c/a:A	J
    //   245: aload_0
    //   246: aload_0
    //   247: getfield 166	com/tencent/mobileqq/msf/core/net/c/a:B	J
    //   250: aload 4
    //   252: invokevirtual 339	java/net/DatagramPacket:getLength	()I
    //   255: i2l
    //   256: ladd
    //   257: putfield 166	com/tencent/mobileqq/msf/core/net/c/a:B	J
    //   260: aload_0
    //   261: aload_0
    //   262: getfield 341	com/tencent/mobileqq/msf/core/net/c/a:S	I
    //   265: aload 4
    //   267: invokevirtual 339	java/net/DatagramPacket:getLength	()I
    //   270: iadd
    //   271: putfield 341	com/tencent/mobileqq/msf/core/net/c/a:S	I
    //   274: aload_0
    //   275: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   278: astore 5
    //   280: aload 5
    //   282: aload 5
    //   284: getfield 343	com/tencent/mobileqq/msf/core/net/c/a$d:k	I
    //   287: i2l
    //   288: aload_0
    //   289: getfield 162	com/tencent/mobileqq/msf/core/net/c/a:z	J
    //   292: aload_0
    //   293: getfield 152	com/tencent/mobileqq/msf/core/net/c/a:u	J
    //   296: lsub
    //   297: ladd
    //   298: l2i
    //   299: putfield 343	com/tencent/mobileqq/msf/core/net/c/a$d:k	I
    //   302: aload_0
    //   303: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   306: getfield 296	com/tencent/msf/service/protocol/push/a/d:o	S
    //   309: ifeq +14 -> 323
    //   312: iconst_1
    //   313: aload_0
    //   314: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   317: getfield 296	com/tencent/msf/service/protocol/push/a/d:o	S
    //   320: if_icmpne +291 -> 611
    //   323: aload_2
    //   324: arraylength
    //   325: bipush 8
    //   327: isub
    //   328: newarray <illegal type>
    //   330: astore 4
    //   332: aload_2
    //   333: iconst_0
    //   334: aload 4
    //   336: iconst_0
    //   337: aload 4
    //   339: arraylength
    //   340: invokestatic 347	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   343: iload_1
    //   344: bipush 8
    //   346: isub
    //   347: newarray <illegal type>
    //   349: astore_2
    //   350: aload_3
    //   351: iconst_0
    //   352: aload_2
    //   353: iconst_0
    //   354: aload_2
    //   355: arraylength
    //   356: invokestatic 347	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   359: aload 4
    //   361: invokestatic 353	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   364: aload_2
    //   365: invokestatic 353	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   368: invokevirtual 356	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   371: ifne +108 -> 479
    //   374: aload_0
    //   375: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   378: getfield 326	com/tencent/mobileqq/msf/core/net/c/a$d:I	Ljava/util/ArrayList;
    //   381: aload_0
    //   382: getfield 168	com/tencent/mobileqq/msf/core/net/c/a:C	J
    //   385: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   388: invokevirtual 359	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   391: pop
    //   392: new 281	java/lang/Exception
    //   395: dup
    //   396: new 244	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   403: ldc_w 361
    //   406: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: aload_2
    //   410: invokestatic 353	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   413: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokespecial 363	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   422: athrow
    //   423: astore_2
    //   424: aload_0
    //   425: aload_2
    //   426: invokevirtual 364	java/lang/Exception:toString	()Ljava/lang/String;
    //   429: invokevirtual 367	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   432: invokespecial 369	com/tencent/mobileqq/msf/core/net/c/a:a	(Ljava/lang/String;)V
    //   435: ldc -14
    //   437: iconst_1
    //   438: ldc_w 371
    //   441: aload_2
    //   442: invokestatic 374	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   445: aload_0
    //   446: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   449: astore_2
    //   450: aload_2
    //   451: aload_2
    //   452: getfield 376	com/tencent/mobileqq/msf/core/net/c/a$d:n	I
    //   455: iconst_1
    //   456: iadd
    //   457: putfield 376	com/tencent/mobileqq/msf/core/net/c/a$d:n	I
    //   460: aload_0
    //   461: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   464: getfield 326	com/tencent/mobileqq/msf/core/net/c/a$d:I	Ljava/util/ArrayList;
    //   467: ldc2_w 377
    //   470: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   473: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   476: pop
    //   477: iconst_0
    //   478: ireturn
    //   479: ldc -14
    //   481: iconst_1
    //   482: new 244	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   489: ldc_w 380
    //   492: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: iload_1
    //   496: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   499: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   505: aload_0
    //   506: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   509: astore_2
    //   510: aload_2
    //   511: aload_2
    //   512: getfield 381	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   515: iconst_1
    //   516: iadd
    //   517: putfield 381	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   520: aload_3
    //   521: ifnull +2714 -> 3235
    //   524: aload_3
    //   525: arraylength
    //   526: iconst_4
    //   527: if_icmplt +2708 -> 3235
    //   530: aload_3
    //   531: iconst_0
    //   532: invokestatic 386	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   535: istore_1
    //   536: aload_3
    //   537: aload_3
    //   538: arraylength
    //   539: iconst_4
    //   540: isub
    //   541: invokestatic 386	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   544: istore 8
    //   546: iload 8
    //   548: i2l
    //   549: invokestatic 391	com/tencent/qphone/base/util/e:a	(J)Ljava/net/InetAddress;
    //   552: astore_2
    //   553: ldc -14
    //   555: iconst_1
    //   556: new 244	java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   563: ldc_w 393
    //   566: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: iload_1
    //   570: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   573: ldc_w 395
    //   576: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: aload_2
    //   580: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   583: ldc_w 400
    //   586: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: iload 8
    //   591: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   600: aload_0
    //   601: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   604: aload_2
    //   605: putfield 402	com/tencent/mobileqq/msf/core/net/c/a$d:d	Ljava/net/InetAddress;
    //   608: goto +2627 -> 3235
    //   611: iconst_2
    //   612: aload_0
    //   613: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   616: getfield 296	com/tencent/msf/service/protocol/push/a/d:o	S
    //   619: if_icmpne -99 -> 520
    //   622: aload 4
    //   624: invokevirtual 406	java/net/DatagramPacket:getAddress	()Ljava/net/InetAddress;
    //   627: aload_0
    //   628: getfield 132	com/tencent/mobileqq/msf/core/net/c/a:n	Ljava/net/InetAddress;
    //   631: invokevirtual 409	java/net/InetAddress:equals	(Ljava/lang/Object;)Z
    //   634: ifeq +15 -> 649
    //   637: aload 4
    //   639: invokevirtual 412	java/net/DatagramPacket:getPort	()I
    //   642: aload_0
    //   643: getfield 414	com/tencent/mobileqq/msf/core/net/c/a:o	I
    //   646: if_icmpeq +109 -> 755
    //   649: aload_0
    //   650: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   653: astore_2
    //   654: aload_2
    //   655: aload_2
    //   656: getfield 381	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   659: iconst_1
    //   660: iadd
    //   661: putfield 381	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   664: aload_0
    //   665: getstatic 416	com/tencent/mobileqq/msf/core/net/c/a$d$a:v	Lcom/tencent/mobileqq/msf/core/net/c/a$d$a;
    //   668: invokespecial 218	com/tencent/mobileqq/msf/core/net/c/a:a	(Lcom/tencent/mobileqq/msf/core/net/c/a$d$a;)V
    //   671: ldc -14
    //   673: iconst_2
    //   674: new 244	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   681: ldc_w 418
    //   684: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload_0
    //   688: getfield 132	com/tencent/mobileqq/msf/core/net/c/a:n	Ljava/net/InetAddress;
    //   691: invokevirtual 419	java/net/InetAddress:toString	()Ljava/lang/String;
    //   694: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: ldc_w 421
    //   700: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: aload_0
    //   704: getfield 414	com/tencent/mobileqq/msf/core/net/c/a:o	I
    //   707: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   710: ldc_w 423
    //   713: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: aload 4
    //   718: invokevirtual 406	java/net/DatagramPacket:getAddress	()Ljava/net/InetAddress;
    //   721: invokevirtual 419	java/net/InetAddress:toString	()Ljava/lang/String;
    //   724: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: ldc_w 421
    //   730: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: aload 4
    //   735: invokevirtual 412	java/net/DatagramPacket:getPort	()I
    //   738: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   741: ldc_w 425
    //   744: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   753: iconst_0
    //   754: ireturn
    //   755: ldc -14
    //   757: iconst_2
    //   758: new 244	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   765: ldc_w 427
    //   768: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: aload_0
    //   772: getfield 132	com/tencent/mobileqq/msf/core/net/c/a:n	Ljava/net/InetAddress;
    //   775: invokevirtual 419	java/net/InetAddress:toString	()Ljava/lang/String;
    //   778: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: ldc_w 421
    //   784: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: aload_0
    //   788: getfield 414	com/tencent/mobileqq/msf/core/net/c/a:o	I
    //   791: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   794: ldc_w 423
    //   797: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: aload 4
    //   802: invokevirtual 406	java/net/DatagramPacket:getAddress	()Ljava/net/InetAddress;
    //   805: invokevirtual 419	java/net/InetAddress:toString	()Ljava/lang/String;
    //   808: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: ldc_w 421
    //   814: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: aload 4
    //   819: invokevirtual 412	java/net/DatagramPacket:getPort	()I
    //   822: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   825: ldc_w 425
    //   828: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   834: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   837: aload_0
    //   838: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   841: astore_2
    //   842: aload_2
    //   843: aload_2
    //   844: getfield 381	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   847: iconst_1
    //   848: iadd
    //   849: putfield 381	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   852: invokestatic 286	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   855: ifeq -335 -> 520
    //   858: ldc -14
    //   860: iconst_2
    //   861: ldc_w 429
    //   864: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   867: goto -347 -> 520
    //   870: aconst_null
    //   871: astore 4
    //   873: aconst_null
    //   874: astore_3
    //   875: aload_0
    //   876: getfield 122	com/tencent/mobileqq/msf/core/net/c/a:h	Ljava/net/Socket;
    //   879: invokevirtual 435	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   882: astore 5
    //   884: aload 5
    //   886: astore_3
    //   887: aload 5
    //   889: astore 4
    //   891: getstatic 439	com/tencent/mobileqq/msf/core/net/c/f:f	Ljava/util/ArrayList;
    //   894: aload 5
    //   896: invokevirtual 440	java/lang/Object:toString	()Ljava/lang/String;
    //   899: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   902: pop
    //   903: aload 5
    //   905: astore_3
    //   906: aload 5
    //   908: astore 4
    //   910: iload_1
    //   911: newarray <illegal type>
    //   913: astore 6
    //   915: aload 5
    //   917: astore_3
    //   918: aload 5
    //   920: astore 4
    //   922: aload 5
    //   924: aload 6
    //   926: invokevirtual 446	java/io/InputStream:read	([B)I
    //   929: istore 9
    //   931: aload 5
    //   933: astore_3
    //   934: aload 5
    //   936: astore 4
    //   938: aload_0
    //   939: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   942: putfield 154	com/tencent/mobileqq/msf/core/net/c/a:v	J
    //   945: aload 5
    //   947: astore_3
    //   948: aload 5
    //   950: astore 4
    //   952: aload_0
    //   953: aload_0
    //   954: getfield 156	com/tencent/mobileqq/msf/core/net/c/a:w	J
    //   957: aload_0
    //   958: getfield 154	com/tencent/mobileqq/msf/core/net/c/a:v	J
    //   961: aload_0
    //   962: getfield 152	com/tencent/mobileqq/msf/core/net/c/a:u	J
    //   965: lsub
    //   966: ladd
    //   967: putfield 156	com/tencent/mobileqq/msf/core/net/c/a:w	J
    //   970: aload 5
    //   972: astore_3
    //   973: aload 5
    //   975: astore 4
    //   977: ldc -14
    //   979: iconst_1
    //   980: new 244	java/lang/StringBuilder
    //   983: dup
    //   984: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   987: ldc_w 448
    //   990: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: aload_2
    //   994: arraylength
    //   995: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   998: ldc_w 450
    //   1001: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: aload_0
    //   1005: getfield 154	com/tencent/mobileqq/msf/core/net/c/a:v	J
    //   1008: invokevirtual 453	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1011: ldc_w 455
    //   1014: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1017: aload_0
    //   1018: getfield 152	com/tencent/mobileqq/msf/core/net/c/a:u	J
    //   1021: invokevirtual 453	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1024: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1027: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1030: iload 9
    //   1032: iconst_m1
    //   1033: if_icmpeq +41 -> 1074
    //   1036: iload 9
    //   1038: istore 8
    //   1040: iload 8
    //   1042: iload_1
    //   1043: if_icmpge +192 -> 1235
    //   1046: aload 5
    //   1048: astore_3
    //   1049: aload 5
    //   1051: astore 4
    //   1053: iload 8
    //   1055: aload 5
    //   1057: aload 6
    //   1059: iload 8
    //   1061: iload_1
    //   1062: iload 8
    //   1064: isub
    //   1065: invokevirtual 458	java/io/InputStream:read	([BII)I
    //   1068: iadd
    //   1069: istore 8
    //   1071: goto -31 -> 1040
    //   1074: aload 5
    //   1076: ifnull +22 -> 1098
    //   1079: aload 5
    //   1081: astore_3
    //   1082: aload 5
    //   1084: astore 4
    //   1086: getstatic 439	com/tencent/mobileqq/msf/core/net/c/f:f	Ljava/util/ArrayList;
    //   1089: aload 5
    //   1091: invokevirtual 440	java/lang/Object:toString	()Ljava/lang/String;
    //   1094: invokevirtual 359	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   1097: pop
    //   1098: aload 5
    //   1100: astore_3
    //   1101: aload 5
    //   1103: astore 4
    //   1105: aload_0
    //   1106: getstatic 230	com/tencent/mobileqq/msf/core/net/c/a$d$a:e	Lcom/tencent/mobileqq/msf/core/net/c/a$d$a;
    //   1109: invokespecial 218	com/tencent/mobileqq/msf/core/net/c/a:a	(Lcom/tencent/mobileqq/msf/core/net/c/a$d$a;)V
    //   1112: aload 5
    //   1114: astore_3
    //   1115: aload 5
    //   1117: astore 4
    //   1119: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1122: ifeq +19 -> 1141
    //   1125: aload 5
    //   1127: astore_3
    //   1128: aload 5
    //   1130: astore 4
    //   1132: ldc -14
    //   1134: iconst_4
    //   1135: ldc_w 460
    //   1138: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1141: aload 5
    //   1143: astore_3
    //   1144: aload 5
    //   1146: astore 4
    //   1148: aload_0
    //   1149: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1152: getfield 326	com/tencent/mobileqq/msf/core/net/c/a$d:I	Ljava/util/ArrayList;
    //   1155: ldc2_w 377
    //   1158: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1161: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1164: pop
    //   1165: aload 5
    //   1167: ifnull +2064 -> 3231
    //   1170: aload 5
    //   1172: invokevirtual 463	java/io/InputStream:close	()V
    //   1175: iconst_0
    //   1176: ireturn
    //   1177: astore_2
    //   1178: aload_2
    //   1179: invokevirtual 466	java/lang/Throwable:printStackTrace	()V
    //   1182: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1185: ifeq +2046 -> 3231
    //   1188: ldc -14
    //   1190: iconst_4
    //   1191: ldc_w 468
    //   1194: aload_2
    //   1195: invokestatic 374	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1198: iconst_0
    //   1199: ireturn
    //   1200: astore_2
    //   1201: aload_0
    //   1202: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1205: astore_2
    //   1206: aload_2
    //   1207: aload_2
    //   1208: getfield 376	com/tencent/mobileqq/msf/core/net/c/a$d:n	I
    //   1211: iconst_1
    //   1212: iadd
    //   1213: putfield 376	com/tencent/mobileqq/msf/core/net/c/a$d:n	I
    //   1216: aload_0
    //   1217: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1220: getfield 326	com/tencent/mobileqq/msf/core/net/c/a$d:I	Ljava/util/ArrayList;
    //   1223: ldc2_w 377
    //   1226: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1229: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1232: pop
    //   1233: iconst_0
    //   1234: ireturn
    //   1235: aload 5
    //   1237: astore_3
    //   1238: aload 5
    //   1240: astore 4
    //   1242: getstatic 439	com/tencent/mobileqq/msf/core/net/c/f:f	Ljava/util/ArrayList;
    //   1245: aload 5
    //   1247: invokevirtual 440	java/lang/Object:toString	()Ljava/lang/String;
    //   1250: invokevirtual 359	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   1253: pop
    //   1254: aload 5
    //   1256: astore_3
    //   1257: aload 5
    //   1259: astore 4
    //   1261: aload_0
    //   1262: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   1265: putfield 162	com/tencent/mobileqq/msf/core/net/c/a:z	J
    //   1268: aload 5
    //   1270: astore_3
    //   1271: aload 5
    //   1273: astore 4
    //   1275: aload_0
    //   1276: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1279: aload_0
    //   1280: getfield 152	com/tencent/mobileqq/msf/core/net/c/a:u	J
    //   1283: putfield 321	com/tencent/mobileqq/msf/core/net/c/a$d:L	J
    //   1286: aload 5
    //   1288: astore_3
    //   1289: aload 5
    //   1291: astore 4
    //   1293: aload_0
    //   1294: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1297: aload_0
    //   1298: getfield 162	com/tencent/mobileqq/msf/core/net/c/a:z	J
    //   1301: putfield 323	com/tencent/mobileqq/msf/core/net/c/a$d:M	J
    //   1304: aload 5
    //   1306: astore_3
    //   1307: aload 5
    //   1309: astore 4
    //   1311: aload_0
    //   1312: aload_0
    //   1313: getfield 162	com/tencent/mobileqq/msf/core/net/c/a:z	J
    //   1316: aload_0
    //   1317: getfield 152	com/tencent/mobileqq/msf/core/net/c/a:u	J
    //   1320: lsub
    //   1321: putfield 168	com/tencent/mobileqq/msf/core/net/c/a:C	J
    //   1324: aload 5
    //   1326: astore_3
    //   1327: aload 5
    //   1329: astore 4
    //   1331: aload_0
    //   1332: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1335: getfield 326	com/tencent/mobileqq/msf/core/net/c/a$d:I	Ljava/util/ArrayList;
    //   1338: aload_0
    //   1339: getfield 168	com/tencent/mobileqq/msf/core/net/c/a:C	J
    //   1342: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1345: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1348: pop
    //   1349: aload 5
    //   1351: astore_3
    //   1352: aload 5
    //   1354: astore 4
    //   1356: aload_0
    //   1357: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1360: astore 7
    //   1362: aload 5
    //   1364: astore_3
    //   1365: aload 5
    //   1367: astore 4
    //   1369: aload 7
    //   1371: aload 7
    //   1373: getfield 343	com/tencent/mobileqq/msf/core/net/c/a$d:k	I
    //   1376: i2l
    //   1377: aload_0
    //   1378: getfield 162	com/tencent/mobileqq/msf/core/net/c/a:z	J
    //   1381: aload_0
    //   1382: getfield 152	com/tencent/mobileqq/msf/core/net/c/a:u	J
    //   1385: lsub
    //   1386: ladd
    //   1387: l2i
    //   1388: putfield 343	com/tencent/mobileqq/msf/core/net/c/a$d:k	I
    //   1391: iload 9
    //   1393: iload 8
    //   1395: if_icmpge +28 -> 1423
    //   1398: aload 5
    //   1400: astore_3
    //   1401: aload 5
    //   1403: astore 4
    //   1405: aload_0
    //   1406: aload_0
    //   1407: getfield 164	com/tencent/mobileqq/msf/core/net/c/a:A	J
    //   1410: aload_0
    //   1411: getfield 162	com/tencent/mobileqq/msf/core/net/c/a:z	J
    //   1414: aload_0
    //   1415: getfield 154	com/tencent/mobileqq/msf/core/net/c/a:v	J
    //   1418: lsub
    //   1419: ladd
    //   1420: putfield 164	com/tencent/mobileqq/msf/core/net/c/a:A	J
    //   1423: aload 5
    //   1425: astore_3
    //   1426: aload 5
    //   1428: astore 4
    //   1430: aload_0
    //   1431: aload_0
    //   1432: getfield 166	com/tencent/mobileqq/msf/core/net/c/a:B	J
    //   1435: iload_1
    //   1436: i2l
    //   1437: ladd
    //   1438: putfield 166	com/tencent/mobileqq/msf/core/net/c/a:B	J
    //   1441: aload 5
    //   1443: astore_3
    //   1444: aload 5
    //   1446: astore 4
    //   1448: aload_0
    //   1449: aload_0
    //   1450: getfield 341	com/tencent/mobileqq/msf/core/net/c/a:S	I
    //   1453: iload_1
    //   1454: iadd
    //   1455: putfield 341	com/tencent/mobileqq/msf/core/net/c/a:S	I
    //   1458: aload 5
    //   1460: astore_3
    //   1461: aload 5
    //   1463: astore 4
    //   1465: aload_0
    //   1466: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1469: getfield 296	com/tencent/msf/service/protocol/push/a/d:o	S
    //   1472: ifeq +21 -> 1493
    //   1475: aload 5
    //   1477: astore_3
    //   1478: aload 5
    //   1480: astore 4
    //   1482: iconst_1
    //   1483: aload_0
    //   1484: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1487: getfield 296	com/tencent/msf/service/protocol/push/a/d:o	S
    //   1490: if_icmpne +512 -> 2002
    //   1493: aload 5
    //   1495: astore_3
    //   1496: aload 5
    //   1498: astore 4
    //   1500: aload_2
    //   1501: arraylength
    //   1502: bipush 8
    //   1504: isub
    //   1505: newarray <illegal type>
    //   1507: astore 7
    //   1509: aload 5
    //   1511: astore_3
    //   1512: aload 5
    //   1514: astore 4
    //   1516: aload_2
    //   1517: iconst_0
    //   1518: aload 7
    //   1520: iconst_0
    //   1521: aload 7
    //   1523: arraylength
    //   1524: invokestatic 347	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1527: aload 5
    //   1529: astore_3
    //   1530: aload 5
    //   1532: astore 4
    //   1534: iload_1
    //   1535: bipush 8
    //   1537: isub
    //   1538: newarray <illegal type>
    //   1540: astore_2
    //   1541: aload 5
    //   1543: astore_3
    //   1544: aload 5
    //   1546: astore 4
    //   1548: aload 6
    //   1550: iconst_0
    //   1551: aload_2
    //   1552: iconst_0
    //   1553: aload_2
    //   1554: arraylength
    //   1555: invokestatic 347	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1558: aload 5
    //   1560: astore_3
    //   1561: aload 5
    //   1563: astore 4
    //   1565: aload 7
    //   1567: invokestatic 353	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   1570: aload_2
    //   1571: invokestatic 353	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   1574: invokevirtual 356	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1577: ifne +205 -> 1782
    //   1580: aload 5
    //   1582: astore_3
    //   1583: aload 5
    //   1585: astore 4
    //   1587: aload_0
    //   1588: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1591: getfield 326	com/tencent/mobileqq/msf/core/net/c/a$d:I	Ljava/util/ArrayList;
    //   1594: aload_0
    //   1595: getfield 168	com/tencent/mobileqq/msf/core/net/c/a:C	J
    //   1598: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1601: invokevirtual 359	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   1604: pop
    //   1605: aload 5
    //   1607: astore_3
    //   1608: aload 5
    //   1610: astore 4
    //   1612: new 281	java/lang/Exception
    //   1615: dup
    //   1616: new 244	java/lang/StringBuilder
    //   1619: dup
    //   1620: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   1623: ldc_w 361
    //   1626: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1629: aload_2
    //   1630: invokestatic 353	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   1633: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1636: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1639: invokespecial 363	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1642: athrow
    //   1643: astore_2
    //   1644: aload_3
    //   1645: ifnull +17 -> 1662
    //   1648: aload_3
    //   1649: astore 4
    //   1651: getstatic 439	com/tencent/mobileqq/msf/core/net/c/f:f	Ljava/util/ArrayList;
    //   1654: aload_3
    //   1655: invokevirtual 440	java/lang/Object:toString	()Ljava/lang/String;
    //   1658: invokevirtual 359	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   1661: pop
    //   1662: aload_3
    //   1663: astore 4
    //   1665: aload_0
    //   1666: aload_2
    //   1667: invokevirtual 364	java/lang/Exception:toString	()Ljava/lang/String;
    //   1670: invokevirtual 367	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1673: invokespecial 369	com/tencent/mobileqq/msf/core/net/c/a:a	(Ljava/lang/String;)V
    //   1676: aload_3
    //   1677: astore 4
    //   1679: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1682: ifeq +16 -> 1698
    //   1685: aload_3
    //   1686: astore 4
    //   1688: ldc -14
    //   1690: iconst_4
    //   1691: ldc_w 470
    //   1694: aload_2
    //   1695: invokestatic 374	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1698: aload_3
    //   1699: astore 4
    //   1701: aload_0
    //   1702: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1705: astore 5
    //   1707: aload_3
    //   1708: astore 4
    //   1710: aload 5
    //   1712: aload 5
    //   1714: getfield 376	com/tencent/mobileqq/msf/core/net/c/a$d:n	I
    //   1717: iconst_1
    //   1718: iadd
    //   1719: putfield 376	com/tencent/mobileqq/msf/core/net/c/a$d:n	I
    //   1722: aload_3
    //   1723: astore 4
    //   1725: aload_0
    //   1726: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1729: getfield 326	com/tencent/mobileqq/msf/core/net/c/a$d:I	Ljava/util/ArrayList;
    //   1732: ldc2_w 377
    //   1735: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1738: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1741: pop
    //   1742: aload_3
    //   1743: astore 4
    //   1745: aload_2
    //   1746: invokevirtual 471	java/lang/Exception:printStackTrace	()V
    //   1749: aload_3
    //   1750: ifnull +1481 -> 3231
    //   1753: aload_3
    //   1754: invokevirtual 463	java/io/InputStream:close	()V
    //   1757: iconst_0
    //   1758: ireturn
    //   1759: astore_2
    //   1760: aload_2
    //   1761: invokevirtual 466	java/lang/Throwable:printStackTrace	()V
    //   1764: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1767: ifeq +1464 -> 3231
    //   1770: ldc -14
    //   1772: iconst_4
    //   1773: ldc_w 468
    //   1776: aload_2
    //   1777: invokestatic 374	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1780: iconst_0
    //   1781: ireturn
    //   1782: aload 5
    //   1784: astore_3
    //   1785: aload 5
    //   1787: astore 4
    //   1789: ldc -14
    //   1791: iconst_1
    //   1792: new 244	java/lang/StringBuilder
    //   1795: dup
    //   1796: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   1799: ldc_w 473
    //   1802: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1805: iload_1
    //   1806: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1809: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1812: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1815: aload 5
    //   1817: astore_3
    //   1818: aload 5
    //   1820: astore 4
    //   1822: aload_0
    //   1823: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1826: astore_2
    //   1827: aload 5
    //   1829: astore_3
    //   1830: aload 5
    //   1832: astore 4
    //   1834: aload_2
    //   1835: aload_2
    //   1836: getfield 381	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   1839: iconst_1
    //   1840: iadd
    //   1841: putfield 381	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   1844: aload 6
    //   1846: ifnull +119 -> 1965
    //   1849: aload 5
    //   1851: astore_3
    //   1852: aload 5
    //   1854: astore 4
    //   1856: aload 6
    //   1858: arraylength
    //   1859: iconst_4
    //   1860: if_icmplt +105 -> 1965
    //   1863: aload 5
    //   1865: astore_3
    //   1866: aload 5
    //   1868: astore 4
    //   1870: aload 6
    //   1872: aload 6
    //   1874: arraylength
    //   1875: iconst_4
    //   1876: isub
    //   1877: invokestatic 386	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   1880: istore 8
    //   1882: aload 5
    //   1884: astore_3
    //   1885: aload 5
    //   1887: astore 4
    //   1889: iload 8
    //   1891: i2l
    //   1892: invokestatic 391	com/tencent/qphone/base/util/e:a	(J)Ljava/net/InetAddress;
    //   1895: astore_2
    //   1896: aload 5
    //   1898: astore_3
    //   1899: aload 5
    //   1901: astore 4
    //   1903: ldc -14
    //   1905: iconst_1
    //   1906: new 244	java/lang/StringBuilder
    //   1909: dup
    //   1910: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   1913: ldc_w 475
    //   1916: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1919: iload_1
    //   1920: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1923: ldc_w 395
    //   1926: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1929: aload_2
    //   1930: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1933: ldc_w 400
    //   1936: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1939: iload 8
    //   1941: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1944: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1947: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1950: aload 5
    //   1952: astore_3
    //   1953: aload 5
    //   1955: astore 4
    //   1957: aload_0
    //   1958: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1961: aload_2
    //   1962: putfield 402	com/tencent/mobileqq/msf/core/net/c/a$d:d	Ljava/net/InetAddress;
    //   1965: aload 5
    //   1967: ifnull +1268 -> 3235
    //   1970: aload 5
    //   1972: invokevirtual 463	java/io/InputStream:close	()V
    //   1975: goto +1260 -> 3235
    //   1978: astore_2
    //   1979: aload_2
    //   1980: invokevirtual 466	java/lang/Throwable:printStackTrace	()V
    //   1983: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1986: ifeq +1249 -> 3235
    //   1989: ldc -14
    //   1991: iconst_4
    //   1992: ldc_w 468
    //   1995: aload_2
    //   1996: invokestatic 374	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1999: goto +1236 -> 3235
    //   2002: aload 5
    //   2004: astore_3
    //   2005: aload 5
    //   2007: astore 4
    //   2009: iconst_2
    //   2010: aload_0
    //   2011: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2014: getfield 296	com/tencent/msf/service/protocol/push/a/d:o	S
    //   2017: if_icmpne -173 -> 1844
    //   2020: aload 5
    //   2022: astore_3
    //   2023: aload 5
    //   2025: astore 4
    //   2027: aload_0
    //   2028: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2031: astore_2
    //   2032: aload 5
    //   2034: astore_3
    //   2035: aload 5
    //   2037: astore 4
    //   2039: aload_2
    //   2040: aload_2
    //   2041: getfield 381	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   2044: iconst_1
    //   2045: iadd
    //   2046: putfield 381	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   2049: aload 5
    //   2051: astore_3
    //   2052: aload 5
    //   2054: astore 4
    //   2056: invokestatic 286	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2059: ifeq -215 -> 1844
    //   2062: aload 5
    //   2064: astore_3
    //   2065: aload 5
    //   2067: astore 4
    //   2069: ldc -14
    //   2071: iconst_2
    //   2072: ldc_w 477
    //   2075: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2078: goto -234 -> 1844
    //   2081: astore_2
    //   2082: aload 4
    //   2084: ifnull +8 -> 2092
    //   2087: aload 4
    //   2089: invokevirtual 463	java/io/InputStream:close	()V
    //   2092: aload_2
    //   2093: athrow
    //   2094: aconst_null
    //   2095: astore 4
    //   2097: aload_0
    //   2098: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2101: aload_0
    //   2102: getfield 479	com/tencent/mobileqq/msf/core/net/c/a:k	Ljava/net/HttpURLConnection;
    //   2105: invokevirtual 484	java/net/HttpURLConnection:getResponseCode	()I
    //   2108: putfield 486	com/tencent/mobileqq/msf/core/net/c/a$d:G	I
    //   2111: aload_0
    //   2112: getfield 152	com/tencent/mobileqq/msf/core/net/c/a:u	J
    //   2115: lconst_0
    //   2116: lcmp
    //   2117: ifne +10 -> 2127
    //   2120: aload_0
    //   2121: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   2124: putfield 152	com/tencent/mobileqq/msf/core/net/c/a:u	J
    //   2127: new 488	java/io/BufferedInputStream
    //   2130: dup
    //   2131: aload_0
    //   2132: getfield 479	com/tencent/mobileqq/msf/core/net/c/a:k	Ljava/net/HttpURLConnection;
    //   2135: invokevirtual 489	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2138: invokespecial 492	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   2141: astore_3
    //   2142: getstatic 439	com/tencent/mobileqq/msf/core/net/c/f:f	Ljava/util/ArrayList;
    //   2145: aload_3
    //   2146: invokevirtual 440	java/lang/Object:toString	()Ljava/lang/String;
    //   2149: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2152: pop
    //   2153: sipush 1024
    //   2156: newarray <illegal type>
    //   2158: astore 5
    //   2160: iload_1
    //   2161: newarray <illegal type>
    //   2163: astore 4
    //   2165: aload_0
    //   2166: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   2169: putfield 160	com/tencent/mobileqq/msf/core/net/c/a:y	J
    //   2172: iconst_0
    //   2173: istore 10
    //   2175: iconst_1
    //   2176: istore 11
    //   2178: iconst_0
    //   2179: istore 8
    //   2181: iload 8
    //   2183: iload_1
    //   2184: if_icmpge +400 -> 2584
    //   2187: aload_3
    //   2188: aload 5
    //   2190: invokevirtual 446	java/io/InputStream:read	([B)I
    //   2193: istore 12
    //   2195: iload 12
    //   2197: iconst_m1
    //   2198: if_icmpeq +386 -> 2584
    //   2201: iload 11
    //   2203: istore 9
    //   2205: iload 11
    //   2207: ifeq +104 -> 2311
    //   2210: iconst_0
    //   2211: istore 9
    //   2213: aload_0
    //   2214: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   2217: putfield 154	com/tencent/mobileqq/msf/core/net/c/a:v	J
    //   2220: aload_0
    //   2221: aload_0
    //   2222: getfield 156	com/tencent/mobileqq/msf/core/net/c/a:w	J
    //   2225: aload_0
    //   2226: getfield 154	com/tencent/mobileqq/msf/core/net/c/a:v	J
    //   2229: aload_0
    //   2230: getfield 152	com/tencent/mobileqq/msf/core/net/c/a:u	J
    //   2233: lsub
    //   2234: ladd
    //   2235: putfield 156	com/tencent/mobileqq/msf/core/net/c/a:w	J
    //   2238: ldc -14
    //   2240: iconst_1
    //   2241: new 244	java/lang/StringBuilder
    //   2244: dup
    //   2245: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   2248: ldc_w 494
    //   2251: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2254: aload_2
    //   2255: arraylength
    //   2256: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2259: ldc_w 450
    //   2262: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2265: aload_0
    //   2266: getfield 154	com/tencent/mobileqq/msf/core/net/c/a:v	J
    //   2269: invokevirtual 453	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2272: ldc_w 455
    //   2275: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2278: aload_0
    //   2279: getfield 152	com/tencent/mobileqq/msf/core/net/c/a:u	J
    //   2282: invokevirtual 453	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2285: ldc_w 496
    //   2288: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2291: aload_0
    //   2292: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2295: getfield 486	com/tencent/mobileqq/msf/core/net/c/a$d:G	I
    //   2298: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2301: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2304: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2307: iload 12
    //   2309: istore 10
    //   2311: iload 12
    //   2313: iload_1
    //   2314: if_icmple +97 -> 2411
    //   2317: aload 5
    //   2319: iconst_0
    //   2320: aload 4
    //   2322: iload 8
    //   2324: iload_1
    //   2325: invokestatic 347	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2328: iload 12
    //   2330: iload 8
    //   2332: iadd
    //   2333: istore 8
    //   2335: iload 8
    //   2337: ldc_w 497
    //   2340: if_icmple +884 -> 3224
    //   2343: aload_0
    //   2344: aload_0
    //   2345: getfield 166	com/tencent/mobileqq/msf/core/net/c/a:B	J
    //   2348: iload 8
    //   2350: i2l
    //   2351: ladd
    //   2352: putfield 166	com/tencent/mobileqq/msf/core/net/c/a:B	J
    //   2355: aload_0
    //   2356: aload_0
    //   2357: getfield 341	com/tencent/mobileqq/msf/core/net/c/a:S	I
    //   2360: iload 8
    //   2362: iadd
    //   2363: putfield 341	com/tencent/mobileqq/msf/core/net/c/a:S	I
    //   2366: aload_0
    //   2367: iconst_0
    //   2368: putfield 144	com/tencent/mobileqq/msf/core/net/c/a:T	Z
    //   2371: aload_0
    //   2372: getstatic 499	com/tencent/mobileqq/msf/core/net/c/a$d$a:u	Lcom/tencent/mobileqq/msf/core/net/c/a$d$a;
    //   2375: invokespecial 218	com/tencent/mobileqq/msf/core/net/c/a:a	(Lcom/tencent/mobileqq/msf/core/net/c/a$d$a;)V
    //   2378: aload_3
    //   2379: ifnull +852 -> 3231
    //   2382: aload_3
    //   2383: invokevirtual 463	java/io/InputStream:close	()V
    //   2386: iconst_0
    //   2387: ireturn
    //   2388: astore_2
    //   2389: aload_2
    //   2390: invokevirtual 466	java/lang/Throwable:printStackTrace	()V
    //   2393: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2396: ifeq +835 -> 3231
    //   2399: ldc -14
    //   2401: iconst_4
    //   2402: ldc_w 468
    //   2405: aload_2
    //   2406: invokestatic 374	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2409: iconst_0
    //   2410: ireturn
    //   2411: iload 12
    //   2413: iload 8
    //   2415: iadd
    //   2416: iload_1
    //   2417: if_icmple +141 -> 2558
    //   2420: aload 5
    //   2422: iconst_0
    //   2423: aload 4
    //   2425: iload 8
    //   2427: iload_1
    //   2428: iload 8
    //   2430: isub
    //   2431: invokestatic 347	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2434: goto -106 -> 2328
    //   2437: astore 4
    //   2439: aload_3
    //   2440: astore_2
    //   2441: aload 4
    //   2443: astore_3
    //   2444: aload_2
    //   2445: ifnull +14 -> 2459
    //   2448: getstatic 439	com/tencent/mobileqq/msf/core/net/c/f:f	Ljava/util/ArrayList;
    //   2451: aload_2
    //   2452: invokevirtual 440	java/lang/Object:toString	()Ljava/lang/String;
    //   2455: invokevirtual 359	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   2458: pop
    //   2459: aload_0
    //   2460: aload_3
    //   2461: invokevirtual 364	java/lang/Exception:toString	()Ljava/lang/String;
    //   2464: invokevirtual 367	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2467: invokespecial 369	com/tencent/mobileqq/msf/core/net/c/a:a	(Ljava/lang/String;)V
    //   2470: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2473: ifeq +13 -> 2486
    //   2476: ldc -14
    //   2478: iconst_4
    //   2479: ldc_w 501
    //   2482: aload_3
    //   2483: invokestatic 374	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2486: aload_0
    //   2487: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2490: astore 4
    //   2492: aload 4
    //   2494: aload 4
    //   2496: getfield 376	com/tencent/mobileqq/msf/core/net/c/a$d:n	I
    //   2499: iconst_1
    //   2500: iadd
    //   2501: putfield 376	com/tencent/mobileqq/msf/core/net/c/a$d:n	I
    //   2504: aload_0
    //   2505: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2508: getfield 326	com/tencent/mobileqq/msf/core/net/c/a$d:I	Ljava/util/ArrayList;
    //   2511: ldc2_w 377
    //   2514: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2517: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2520: pop
    //   2521: aload_3
    //   2522: invokevirtual 471	java/lang/Exception:printStackTrace	()V
    //   2525: aload_2
    //   2526: ifnull +705 -> 3231
    //   2529: aload_2
    //   2530: invokevirtual 463	java/io/InputStream:close	()V
    //   2533: iconst_0
    //   2534: ireturn
    //   2535: astore_2
    //   2536: aload_2
    //   2537: invokevirtual 466	java/lang/Throwable:printStackTrace	()V
    //   2540: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2543: ifeq +688 -> 3231
    //   2546: ldc -14
    //   2548: iconst_4
    //   2549: ldc_w 468
    //   2552: aload_2
    //   2553: invokestatic 374	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2556: iconst_0
    //   2557: ireturn
    //   2558: aload 5
    //   2560: iconst_0
    //   2561: aload 4
    //   2563: iload 8
    //   2565: iload 12
    //   2567: invokestatic 347	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2570: goto -242 -> 2328
    //   2573: astore_2
    //   2574: aload_3
    //   2575: ifnull +7 -> 2582
    //   2578: aload_3
    //   2579: invokevirtual 463	java/io/InputStream:close	()V
    //   2582: aload_2
    //   2583: athrow
    //   2584: getstatic 439	com/tencent/mobileqq/msf/core/net/c/f:f	Ljava/util/ArrayList;
    //   2587: aload_3
    //   2588: invokevirtual 440	java/lang/Object:toString	()Ljava/lang/String;
    //   2591: invokevirtual 359	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   2594: pop
    //   2595: aload_0
    //   2596: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   2599: putfield 162	com/tencent/mobileqq/msf/core/net/c/a:z	J
    //   2602: aload_0
    //   2603: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2606: aload_0
    //   2607: getfield 152	com/tencent/mobileqq/msf/core/net/c/a:u	J
    //   2610: putfield 321	com/tencent/mobileqq/msf/core/net/c/a$d:L	J
    //   2613: aload_0
    //   2614: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2617: aload_0
    //   2618: getfield 162	com/tencent/mobileqq/msf/core/net/c/a:z	J
    //   2621: putfield 323	com/tencent/mobileqq/msf/core/net/c/a$d:M	J
    //   2624: aload_0
    //   2625: aload_0
    //   2626: getfield 162	com/tencent/mobileqq/msf/core/net/c/a:z	J
    //   2629: aload_0
    //   2630: getfield 152	com/tencent/mobileqq/msf/core/net/c/a:u	J
    //   2633: lsub
    //   2634: putfield 168	com/tencent/mobileqq/msf/core/net/c/a:C	J
    //   2637: aload_0
    //   2638: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2641: getfield 326	com/tencent/mobileqq/msf/core/net/c/a$d:I	Ljava/util/ArrayList;
    //   2644: aload_0
    //   2645: getfield 168	com/tencent/mobileqq/msf/core/net/c/a:C	J
    //   2648: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2651: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2654: pop
    //   2655: aload_0
    //   2656: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2659: astore_2
    //   2660: aload_2
    //   2661: aload_2
    //   2662: getfield 343	com/tencent/mobileqq/msf/core/net/c/a$d:k	I
    //   2665: i2l
    //   2666: aload_0
    //   2667: getfield 162	com/tencent/mobileqq/msf/core/net/c/a:z	J
    //   2670: aload_0
    //   2671: getfield 152	com/tencent/mobileqq/msf/core/net/c/a:u	J
    //   2674: lsub
    //   2675: ladd
    //   2676: l2i
    //   2677: putfield 343	com/tencent/mobileqq/msf/core/net/c/a$d:k	I
    //   2680: iload 10
    //   2682: iload 8
    //   2684: if_icmpge +21 -> 2705
    //   2687: aload_0
    //   2688: aload_0
    //   2689: getfield 164	com/tencent/mobileqq/msf/core/net/c/a:A	J
    //   2692: aload_0
    //   2693: getfield 162	com/tencent/mobileqq/msf/core/net/c/a:z	J
    //   2696: aload_0
    //   2697: getfield 154	com/tencent/mobileqq/msf/core/net/c/a:v	J
    //   2700: lsub
    //   2701: ladd
    //   2702: putfield 164	com/tencent/mobileqq/msf/core/net/c/a:A	J
    //   2705: aload_0
    //   2706: aload_0
    //   2707: getfield 166	com/tencent/mobileqq/msf/core/net/c/a:B	J
    //   2710: iload 8
    //   2712: i2l
    //   2713: ladd
    //   2714: putfield 166	com/tencent/mobileqq/msf/core/net/c/a:B	J
    //   2717: aload_0
    //   2718: aload_0
    //   2719: getfield 341	com/tencent/mobileqq/msf/core/net/c/a:S	I
    //   2722: iload 8
    //   2724: iadd
    //   2725: putfield 341	com/tencent/mobileqq/msf/core/net/c/a:S	I
    //   2728: aload_0
    //   2729: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2732: getfield 502	com/tencent/msf/service/protocol/push/a/d:x	J
    //   2735: lconst_0
    //   2736: lcmp
    //   2737: ifle +134 -> 2871
    //   2740: aload_0
    //   2741: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2744: getfield 502	com/tencent/msf/service/protocol/push/a/d:x	J
    //   2747: l2i
    //   2748: istore 10
    //   2750: aload_0
    //   2751: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2754: getfield 503	com/tencent/msf/service/protocol/push/a/d:w	J
    //   2757: l2i
    //   2758: istore 11
    //   2760: iload 10
    //   2762: istore 9
    //   2764: iload 10
    //   2766: ldc_w 504
    //   2769: if_icmple +8 -> 2777
    //   2772: ldc_w 504
    //   2775: istore 9
    //   2777: iload 8
    //   2779: iload_1
    //   2780: invokestatic 510	java/lang/Math:min	(II)I
    //   2783: istore 10
    //   2785: iload 11
    //   2787: iload 10
    //   2789: if_icmpge +82 -> 2871
    //   2792: iload 9
    //   2794: iload 11
    //   2796: iadd
    //   2797: iload 10
    //   2799: if_icmple +322 -> 3121
    //   2802: aload_0
    //   2803: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2806: new 222	java/lang/String
    //   2809: dup
    //   2810: aload 4
    //   2812: iload 11
    //   2814: iload 10
    //   2816: iload 11
    //   2818: isub
    //   2819: invokespecial 513	java/lang/String:<init>	([BII)V
    //   2822: putfield 515	com/tencent/mobileqq/msf/core/net/c/a$d:O	Ljava/lang/String;
    //   2825: aload_0
    //   2826: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2829: iload 10
    //   2831: iload 11
    //   2833: isub
    //   2834: putfield 517	com/tencent/mobileqq/msf/core/net/c/a$d:N	I
    //   2837: aload_0
    //   2838: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2841: aload_0
    //   2842: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2845: getfield 515	com/tencent/mobileqq/msf/core/net/c/a$d:O	Ljava/lang/String;
    //   2848: invokestatic 520	com/tencent/qphone/base/util/e:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2851: putfield 515	com/tencent/mobileqq/msf/core/net/c/a$d:O	Ljava/lang/String;
    //   2854: aload_0
    //   2855: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2858: aload_0
    //   2859: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2862: getfield 515	com/tencent/mobileqq/msf/core/net/c/a$d:O	Ljava/lang/String;
    //   2865: invokevirtual 523	java/lang/String:length	()I
    //   2868: putfield 517	com/tencent/mobileqq/msf/core/net/c/a$d:N	I
    //   2871: new 222	java/lang/String
    //   2874: dup
    //   2875: aload 4
    //   2877: iconst_0
    //   2878: aload 4
    //   2880: arraylength
    //   2881: invokespecial 513	java/lang/String:<init>	([BII)V
    //   2884: astore_2
    //   2885: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2888: ifeq +45 -> 2933
    //   2891: ldc -14
    //   2893: iconst_4
    //   2894: new 244	java/lang/StringBuilder
    //   2897: dup
    //   2898: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   2901: ldc_w 525
    //   2904: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2907: aload_2
    //   2908: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2911: ldc_w 527
    //   2914: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2917: aload_0
    //   2918: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2921: getfield 529	com/tencent/msf/service/protocol/push/a/d:t	Ljava/lang/String;
    //   2924: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2927: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2930: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2933: aload_2
    //   2934: aload_0
    //   2935: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2938: getfield 529	com/tencent/msf/service/protocol/push/a/d:t	Ljava/lang/String;
    //   2941: invokevirtual 533	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2944: ifne +11 -> 2955
    //   2947: aload_0
    //   2948: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2951: iconst_1
    //   2952: putfield 535	com/tencent/mobileqq/msf/core/net/c/a$d:F	I
    //   2955: aload_0
    //   2956: aload_0
    //   2957: getfield 479	com/tencent/mobileqq/msf/core/net/c/a:k	Ljava/net/HttpURLConnection;
    //   2960: ldc_w 537
    //   2963: invokevirtual 540	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   2966: invokespecial 542	com/tencent/mobileqq/msf/core/net/c/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2969: astore_2
    //   2970: aload_2
    //   2971: ifnull +50 -> 3021
    //   2974: aload_2
    //   2975: invokestatic 546	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   2978: astore 4
    //   2980: aload_0
    //   2981: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2984: aload 4
    //   2986: putfield 402	com/tencent/mobileqq/msf/core/net/c/a$d:d	Ljava/net/InetAddress;
    //   2989: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2992: ifeq +29 -> 3021
    //   2995: ldc -14
    //   2997: iconst_4
    //   2998: new 244	java/lang/StringBuilder
    //   3001: dup
    //   3002: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   3005: ldc_w 548
    //   3008: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3011: aload_2
    //   3012: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3015: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3018: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3021: aload_0
    //   3022: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   3025: astore_2
    //   3026: aload_2
    //   3027: aload_2
    //   3028: getfield 381	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   3031: iconst_1
    //   3032: iadd
    //   3033: putfield 381	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   3036: ldc -14
    //   3038: iconst_1
    //   3039: new 244	java/lang/StringBuilder
    //   3042: dup
    //   3043: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   3046: ldc_w 550
    //   3049: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3052: iload 8
    //   3054: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3057: ldc_w 552
    //   3060: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3063: iload_1
    //   3064: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3067: ldc_w 554
    //   3070: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3073: aload_0
    //   3074: getfield 168	com/tencent/mobileqq/msf/core/net/c/a:C	J
    //   3077: invokevirtual 453	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3080: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3083: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3086: aload_3
    //   3087: ifnull +148 -> 3235
    //   3090: aload_3
    //   3091: invokevirtual 463	java/io/InputStream:close	()V
    //   3094: goto +141 -> 3235
    //   3097: astore_2
    //   3098: aload_2
    //   3099: invokevirtual 466	java/lang/Throwable:printStackTrace	()V
    //   3102: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3105: ifeq +130 -> 3235
    //   3108: ldc -14
    //   3110: iconst_4
    //   3111: ldc_w 468
    //   3114: aload_2
    //   3115: invokestatic 374	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3118: goto +117 -> 3235
    //   3121: aload_0
    //   3122: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   3125: new 222	java/lang/String
    //   3128: dup
    //   3129: aload 4
    //   3131: iload 11
    //   3133: iload 9
    //   3135: invokespecial 513	java/lang/String:<init>	([BII)V
    //   3138: putfield 515	com/tencent/mobileqq/msf/core/net/c/a$d:O	Ljava/lang/String;
    //   3141: aload_0
    //   3142: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   3145: iload 9
    //   3147: putfield 517	com/tencent/mobileqq/msf/core/net/c/a$d:N	I
    //   3150: goto -313 -> 2837
    //   3153: astore_3
    //   3154: aload_3
    //   3155: invokevirtual 466	java/lang/Throwable:printStackTrace	()V
    //   3158: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3161: ifeq -1069 -> 2092
    //   3164: ldc -14
    //   3166: iconst_4
    //   3167: ldc_w 468
    //   3170: aload_3
    //   3171: invokestatic 374	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3174: goto -1082 -> 2092
    //   3177: astore_3
    //   3178: aload_3
    //   3179: invokevirtual 466	java/lang/Throwable:printStackTrace	()V
    //   3182: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3185: ifeq -603 -> 2582
    //   3188: ldc -14
    //   3190: iconst_4
    //   3191: ldc_w 468
    //   3194: aload_3
    //   3195: invokestatic 374	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3198: goto -616 -> 2582
    //   3201: astore_2
    //   3202: aconst_null
    //   3203: astore_3
    //   3204: goto -630 -> 2574
    //   3207: astore 4
    //   3209: aload_2
    //   3210: astore_3
    //   3211: aload 4
    //   3213: astore_2
    //   3214: goto -640 -> 2574
    //   3217: astore_3
    //   3218: aload 4
    //   3220: astore_2
    //   3221: goto -777 -> 2444
    //   3224: iload 9
    //   3226: istore 11
    //   3228: goto -1047 -> 2181
    //   3231: iconst_0
    //   3232: ireturn
    //   3233: iconst_0
    //   3234: ireturn
    //   3235: iconst_1
    //   3236: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3237	0	this	a
    //   0	3237	1	paramInt	int
    //   0	3237	2	paramArrayOfByte	byte[]
    //   139	2952	3	localObject1	Object
    //   3153	18	3	localThrowable1	Throwable
    //   3177	18	3	localThrowable2	Throwable
    //   3203	8	3	arrayOfByte1	byte[]
    //   3217	1	3	localException1	Exception
    //   149	2275	4	localObject2	Object
    //   2437	5	4	localException2	Exception
    //   2490	640	4	localObject3	Object
    //   3207	12	4	localObject4	Object
    //   278	2281	5	localObject5	Object
    //   913	960	6	arrayOfByte2	byte[]
    //   1360	206	7	localObject6	Object
    //   544	2509	8	i1	int
    //   929	2296	9	i2	int
    //   2173	661	10	i3	int
    //   2176	1051	11	i4	int
    //   2193	373	12	i5	int
    // Exception table:
    //   from	to	target	type
    //   151	323	423	java/lang/Exception
    //   323	423	423	java/lang/Exception
    //   479	520	423	java/lang/Exception
    //   524	608	423	java/lang/Exception
    //   611	649	423	java/lang/Exception
    //   649	753	423	java/lang/Exception
    //   755	867	423	java/lang/Exception
    //   1170	1175	1177	java/lang/Throwable
    //   38	59	1200	java/lang/Exception
    //   61	99	1200	java/lang/Exception
    //   99	136	1200	java/lang/Exception
    //   136	151	1200	java/lang/Exception
    //   424	477	1200	java/lang/Exception
    //   1170	1175	1200	java/lang/Exception
    //   1178	1198	1200	java/lang/Exception
    //   1753	1757	1200	java/lang/Exception
    //   1760	1780	1200	java/lang/Exception
    //   1970	1975	1200	java/lang/Exception
    //   1979	1999	1200	java/lang/Exception
    //   2087	2092	1200	java/lang/Exception
    //   2092	2094	1200	java/lang/Exception
    //   2382	2386	1200	java/lang/Exception
    //   2389	2409	1200	java/lang/Exception
    //   2529	2533	1200	java/lang/Exception
    //   2536	2556	1200	java/lang/Exception
    //   2578	2582	1200	java/lang/Exception
    //   2582	2584	1200	java/lang/Exception
    //   3090	3094	1200	java/lang/Exception
    //   3098	3118	1200	java/lang/Exception
    //   3154	3174	1200	java/lang/Exception
    //   3178	3198	1200	java/lang/Exception
    //   875	884	1643	java/lang/Exception
    //   891	903	1643	java/lang/Exception
    //   910	915	1643	java/lang/Exception
    //   922	931	1643	java/lang/Exception
    //   938	945	1643	java/lang/Exception
    //   952	970	1643	java/lang/Exception
    //   977	1030	1643	java/lang/Exception
    //   1053	1071	1643	java/lang/Exception
    //   1086	1098	1643	java/lang/Exception
    //   1105	1112	1643	java/lang/Exception
    //   1119	1125	1643	java/lang/Exception
    //   1132	1141	1643	java/lang/Exception
    //   1148	1165	1643	java/lang/Exception
    //   1242	1254	1643	java/lang/Exception
    //   1261	1268	1643	java/lang/Exception
    //   1275	1286	1643	java/lang/Exception
    //   1293	1304	1643	java/lang/Exception
    //   1311	1324	1643	java/lang/Exception
    //   1331	1349	1643	java/lang/Exception
    //   1356	1362	1643	java/lang/Exception
    //   1369	1391	1643	java/lang/Exception
    //   1405	1423	1643	java/lang/Exception
    //   1430	1441	1643	java/lang/Exception
    //   1448	1458	1643	java/lang/Exception
    //   1465	1475	1643	java/lang/Exception
    //   1482	1493	1643	java/lang/Exception
    //   1500	1509	1643	java/lang/Exception
    //   1516	1527	1643	java/lang/Exception
    //   1534	1541	1643	java/lang/Exception
    //   1548	1558	1643	java/lang/Exception
    //   1565	1580	1643	java/lang/Exception
    //   1587	1605	1643	java/lang/Exception
    //   1612	1643	1643	java/lang/Exception
    //   1789	1815	1643	java/lang/Exception
    //   1822	1827	1643	java/lang/Exception
    //   1834	1844	1643	java/lang/Exception
    //   1856	1863	1643	java/lang/Exception
    //   1870	1882	1643	java/lang/Exception
    //   1889	1896	1643	java/lang/Exception
    //   1903	1950	1643	java/lang/Exception
    //   1957	1965	1643	java/lang/Exception
    //   2009	2020	1643	java/lang/Exception
    //   2027	2032	1643	java/lang/Exception
    //   2039	2049	1643	java/lang/Exception
    //   2056	2062	1643	java/lang/Exception
    //   2069	2078	1643	java/lang/Exception
    //   1753	1757	1759	java/lang/Throwable
    //   1970	1975	1978	java/lang/Throwable
    //   875	884	2081	finally
    //   891	903	2081	finally
    //   910	915	2081	finally
    //   922	931	2081	finally
    //   938	945	2081	finally
    //   952	970	2081	finally
    //   977	1030	2081	finally
    //   1053	1071	2081	finally
    //   1086	1098	2081	finally
    //   1105	1112	2081	finally
    //   1119	1125	2081	finally
    //   1132	1141	2081	finally
    //   1148	1165	2081	finally
    //   1242	1254	2081	finally
    //   1261	1268	2081	finally
    //   1275	1286	2081	finally
    //   1293	1304	2081	finally
    //   1311	1324	2081	finally
    //   1331	1349	2081	finally
    //   1356	1362	2081	finally
    //   1369	1391	2081	finally
    //   1405	1423	2081	finally
    //   1430	1441	2081	finally
    //   1448	1458	2081	finally
    //   1465	1475	2081	finally
    //   1482	1493	2081	finally
    //   1500	1509	2081	finally
    //   1516	1527	2081	finally
    //   1534	1541	2081	finally
    //   1548	1558	2081	finally
    //   1565	1580	2081	finally
    //   1587	1605	2081	finally
    //   1612	1643	2081	finally
    //   1651	1662	2081	finally
    //   1665	1676	2081	finally
    //   1679	1685	2081	finally
    //   1688	1698	2081	finally
    //   1701	1707	2081	finally
    //   1710	1722	2081	finally
    //   1725	1742	2081	finally
    //   1745	1749	2081	finally
    //   1789	1815	2081	finally
    //   1822	1827	2081	finally
    //   1834	1844	2081	finally
    //   1856	1863	2081	finally
    //   1870	1882	2081	finally
    //   1889	1896	2081	finally
    //   1903	1950	2081	finally
    //   1957	1965	2081	finally
    //   2009	2020	2081	finally
    //   2027	2032	2081	finally
    //   2039	2049	2081	finally
    //   2056	2062	2081	finally
    //   2069	2078	2081	finally
    //   2382	2386	2388	java/lang/Throwable
    //   2142	2172	2437	java/lang/Exception
    //   2187	2195	2437	java/lang/Exception
    //   2213	2307	2437	java/lang/Exception
    //   2317	2328	2437	java/lang/Exception
    //   2343	2378	2437	java/lang/Exception
    //   2420	2434	2437	java/lang/Exception
    //   2558	2570	2437	java/lang/Exception
    //   2584	2680	2437	java/lang/Exception
    //   2687	2705	2437	java/lang/Exception
    //   2705	2760	2437	java/lang/Exception
    //   2777	2785	2437	java/lang/Exception
    //   2802	2837	2437	java/lang/Exception
    //   2837	2871	2437	java/lang/Exception
    //   2871	2933	2437	java/lang/Exception
    //   2933	2955	2437	java/lang/Exception
    //   2955	2970	2437	java/lang/Exception
    //   2974	3021	2437	java/lang/Exception
    //   3021	3086	2437	java/lang/Exception
    //   3121	3150	2437	java/lang/Exception
    //   2529	2533	2535	java/lang/Throwable
    //   2142	2172	2573	finally
    //   2187	2195	2573	finally
    //   2213	2307	2573	finally
    //   2317	2328	2573	finally
    //   2343	2378	2573	finally
    //   2420	2434	2573	finally
    //   2558	2570	2573	finally
    //   2584	2680	2573	finally
    //   2687	2705	2573	finally
    //   2705	2760	2573	finally
    //   2777	2785	2573	finally
    //   2802	2837	2573	finally
    //   2837	2871	2573	finally
    //   2871	2933	2573	finally
    //   2933	2955	2573	finally
    //   2955	2970	2573	finally
    //   2974	3021	2573	finally
    //   3021	3086	2573	finally
    //   3121	3150	2573	finally
    //   3090	3094	3097	java/lang/Throwable
    //   2087	2092	3153	java/lang/Throwable
    //   2578	2582	3177	java/lang/Throwable
    //   2097	2127	3201	finally
    //   2127	2142	3201	finally
    //   2448	2459	3207	finally
    //   2459	2486	3207	finally
    //   2486	2525	3207	finally
    //   2097	2127	3217	java/lang/Exception
    //   2127	2142	3217	java/lang/Exception
  }
  
  private boolean a(com.tencent.msf.service.protocol.push.a.a parama)
  {
    if (this.b != null)
    {
      this.p.z = this.b.i;
      if ((this.b.i > 0L) && (this.b.i < 600L)) {
        this.m = ((int)this.b.i * 1000);
      }
    }
    for (;;)
    {
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: Start connecting " + this.n + " port:" + this.o + " strDomain:" + parama.c + " mTestType:" + this.a);
        }
        i1 = 1.a[this.a.ordinal()];
        switch (i1)
        {
        default: 
          return false;
        }
      }
      catch (Exception parama)
      {
        this.p.H.add(Long.valueOf(-1L));
        parama.printStackTrace();
        return false;
      }
      if (this.c != null)
      {
        this.p.z = this.c.i;
        if ((this.c.i > 0L) && (this.c.i < 600L))
        {
          this.m = ((int)this.c.i * 1000);
          continue;
          this.g = new DatagramSocket();
          this.g.setSoTimeout(this.m);
          this.p.H.add(Long.valueOf(-1L));
        }
      }
    }
    Object localObject;
    label1062:
    int i2;
    int i3;
    for (;;)
    {
      return true;
      try
      {
        parama = new InetSocketAddress(this.n, this.o);
        this.h = new Socket();
        this.h.setSoTimeout(this.m);
        this.h.setTcpNoDelay(true);
        this.h.setKeepAlive(true);
        this.r = System.currentTimeMillis();
        this.h.connect(parama, this.m);
        this.s = System.currentTimeMillis();
        this.t = (this.s - this.r);
        this.p.H.add(Long.valueOf(this.t));
        this.i = this.h.getOutputStream();
      }
      catch (Throwable parama)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: connecting " + this.n + " port:" + this.o + " mTestType:" + this.a + " failed", parama);
        }
        parama = this.p;
        parama.o += 1;
        this.p.H.add(Long.valueOf(-1L));
        return false;
      }
      for (;;)
      {
        try
        {
          if (this.b.y == 1)
          {
            localObject = "https://" + this.n.getHostAddress() + ":" + this.o + "/" + this.b.q;
            if (QLog.isDevelopLevel()) {
              QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: connecting http url:" + (String)localObject);
            }
            this.r = System.currentTimeMillis();
            this.j = new URL((String)localObject);
            this.k = ((HttpURLConnection)this.j.openConnection());
            if (this.b.y == 1)
            {
              g();
              ((HttpsURLConnection)this.k).setHostnameVerifier(P);
            }
            this.k.setConnectTimeout(this.m);
            this.k.setDoInput(true);
            this.k.setUseCaches(false);
            this.k.setReadTimeout(this.m);
            if (this.l != 0) {
              break label1062;
            }
            this.k.setDoOutput(true);
            this.k.setRequestMethod("POST");
            this.k.setRequestProperty("Host", parama.c);
            if ((this.b.s == null) || (this.b.s.size() <= 0)) {
              break;
            }
            parama = this.b.s.iterator();
            if (!parama.hasNext()) {
              break;
            }
            localObject = (com.tencent.msf.service.protocol.push.a.e)parama.next();
            if (localObject == null) {
              continue;
            }
            this.k.setRequestProperty(((com.tencent.msf.service.protocol.push.a.e)localObject).a, ((com.tencent.msf.service.protocol.push.a.e)localObject).b);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MSF.C.QualityTestManager", 4, "reqHead.strKey:" + ((com.tencent.msf.service.protocol.push.a.e)localObject).a + ",reqHead.strValue:" + ((com.tencent.msf.service.protocol.push.a.e)localObject).b);
            continue;
          }
          localObject = "http://" + this.n.getHostAddress() + ":" + this.o + "/" + this.b.q;
        }
        catch (Throwable parama)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: connecting " + this.n + " port:" + this.o + " mTestType:" + this.a + " failed", parama);
          }
          parama = this.p;
          parama.o += 1;
          this.p.H.add(Long.valueOf(-1L));
          return false;
        }
        continue;
        if (this.l == 1)
        {
          this.k.setInstanceFollowRedirects(false);
          this.k.setRequestMethod("GET");
        }
      }
      this.k.connect();
      parama = "";
      localObject = parama;
      if (this.l == 1)
      {
        i1 = this.k.getResponseCode();
        if ((this.b.r & 0x4) == 4) {
          break label1596;
        }
        i2 = 1;
        break label1557;
        i3 += 1;
        if (i3 <= 10) {
          break;
        }
        QLog.d("MSF.C.QualityTestManager", 4, "Redirect too much!");
        localObject = parama;
      }
      label1163:
      this.s = System.currentTimeMillis();
      this.t = (this.s - this.r);
      this.p.H.add(Long.valueOf(this.t));
      boolean bool = TextUtils.isEmpty((CharSequence)localObject);
      if (!bool)
      {
        try
        {
          parama = ((String)localObject).substring(((String)localObject).indexOf("://") + 3);
          parama = InetAddress.getByName(parama.substring(0, parama.indexOf("/")));
          this.p.K = parama.getHostAddress();
        }
        catch (Exception parama) {}
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "DNSParse for lastUrl error!", parama);
        }
      }
    }
    parama = this.k.getHeaderField("Location");
    this.k.disconnect();
    this.j = new URL(parama);
    this.k = ((HttpURLConnection)this.j.openConnection());
    this.k.setConnectTimeout(this.m);
    this.k.setDoInput(true);
    this.k.setUseCaches(false);
    this.k.setInstanceFollowRedirects(false);
    this.k.setReadTimeout(this.m);
    this.k.setRequestMethod("GET");
    if ((this.b.s != null) && (this.b.s.size() > 0))
    {
      localObject = this.b.s.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.msf.service.protocol.push.a.e locale = (com.tencent.msf.service.protocol.push.a.e)((Iterator)localObject).next();
        if (locale != null)
        {
          this.k.setRequestProperty(locale.a, locale.b);
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "reqHead.strKey:" + locale.a + ",reqHead.strValue:" + locale.b);
          }
        }
      }
    }
    int i1 = this.k.getResponseCode();
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.QualityTestManager", 4, "Redirect responseCode:" + i1 + ",lastRedirectUrl:" + parama);
    } else {}
    for (;;)
    {
      label1557:
      i3 = 0;
      localObject = parama;
      if (i2 == 0) {
        break label1163;
      }
      if ((i1 == 301) || (i1 == 302)) {
        break;
      }
      localObject = parama;
      if (i1 != 307) {
        break label1163;
      }
      break;
      label1596:
      i2 = 0;
    }
  }
  
  private boolean a(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        switch (1.a[this.a.ordinal()])
        {
        case 1: 
          DatagramPacket localDatagramPacket = new DatagramPacket(paramArrayOfByte, paramArrayOfByte.length, this.n, this.o);
          try
          {
            this.u = System.currentTimeMillis();
            this.g.send(localDatagramPacket);
            this.v = System.currentTimeMillis();
            this.w += this.v - this.u;
            this.x += paramArrayOfByte.length;
            this.R += paramArrayOfByte.length;
            QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send udp packet length:" + localDatagramPacket.getLength() + " sendEndTime:" + this.v + " sendTime:" + this.u);
            paramArrayOfByte = this.p;
            paramArrayOfByte.l += 1;
            return true;
          }
          catch (Exception paramArrayOfByte)
          {
            a(a.d.a.d);
            QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send udp packet error:", paramArrayOfByte);
            return false;
          }
        case 2: 
          try
          {
            this.u = System.currentTimeMillis();
            f.g.add(this.i.toString());
            this.i.write(paramArrayOfByte);
            this.i.flush();
            f.g.remove(this.i.toString());
            this.x += paramArrayOfByte.length;
            this.R += paramArrayOfByte.length;
            paramArrayOfByte = this.p;
            paramArrayOfByte.l += 1;
          }
          catch (Exception paramArrayOfByte)
          {
            if (this.i != null) {
              f.g.remove(this.i.toString());
            }
            a(a.d.a.d);
            QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send tcp error:", paramArrayOfByte);
            return false;
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        return false;
      }
      try
      {
        new String(paramArrayOfByte);
        this.u = System.currentTimeMillis();
        this.i = this.k.getOutputStream();
        f.g.add(this.i.toString());
        this.i.write(paramArrayOfByte);
        this.i.flush();
        f.g.remove(this.i.toString());
        this.x += paramArrayOfByte.length;
        this.R += paramArrayOfByte.length;
        paramArrayOfByte = this.p;
        paramArrayOfByte.l += 1;
      }
      catch (Exception paramArrayOfByte)
      {
        if (this.i != null) {
          f.g.remove(this.i.toString());
        }
        a(a.d.a.d);
        QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send http error:", paramArrayOfByte);
        return false;
      }
    }
    return false;
  }
  
  private byte[] a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.QualityTestManager", 2, "entry getSendData");
    }
    if (this.b != null)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt);
      byte[] arrayOfByte = new byte[paramInt];
      if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0)) {
        localByteBuffer.put(paramArrayOfByte1);
      }
      paramInt = 0;
      while (paramInt < this.b.f)
      {
        localByteBuffer.put(this.b.e);
        paramInt += 1;
      }
      if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0)) {
        localByteBuffer.put(paramArrayOfByte2);
      }
      localByteBuffer.flip();
      localByteBuffer.get(arrayOfByte);
      paramInt = arrayOfByte.length;
      if (this.a != a.c) {
        if ((this.b.o == 0) || (1 == this.b.o))
        {
          int i1 = com.tencent.mobileqq.msf.core.c.a(arrayOfByte, 0);
          if (i1 != paramInt)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("MSF.C.QualityTestManager", 4, "testdata length error stop dataTotalLen:" + i1 + " receBodySize:" + paramInt);
            }
            b(a.d.a.f, true);
            f.a();
            return null;
          }
        }
        else
        {
          if (2 != this.b.o) {
            break label248;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.QualityTestManager", 2, "qualityTestMsg.cTestType=2, Should*NOT* check head len");
          }
        }
      }
      return arrayOfByte;
      label248:
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.QualityTestManager", 2, "qualityTestMsg.cTestType" + this.b.o + "NotSupport, giveup speed_test");
      }
      return null;
    }
    if (this.c != null) {}
    return null;
  }
  
  private String b(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramString = Pattern.compile("(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})").matcher(paramString);
      if (paramString.find()) {
        return paramString.group();
      }
    }
    return null;
  }
  
  private void b(a.d.a parama, boolean paramBoolean)
  {
    a(parama, paramBoolean);
    if (paramBoolean) {
      parama = new ArrayList();
    }
    try
    {
      parama.add(this.Q.getBytes("utf-8"));
      localHashMap = new HashMap();
      localHashMap.put("QualTest", parama);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      try
      {
        HashMap localHashMap;
        f.a(this.T, this.b, this.c, this.S, this.R);
        f.d.configManager.a(localHashMap, "");
        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient finish, succ: " + this.Q);
        return;
        localUnsupportedEncodingException = localUnsupportedEncodingException;
        localUnsupportedEncodingException.printStackTrace();
      }
      catch (Exception parama)
      {
        for (;;)
        {
          parama.printStackTrace();
        }
      }
    }
  }
  
  private void b(com.tencent.msf.service.protocol.push.a.a parama)
  {
    long l1 = parama.a;
    int i1 = parama.b;
    try
    {
      this.n = com.tencent.qphone.base.util.e.a(l1);
      this.o = com.tencent.qphone.base.util.e.a(i1);
      this.p.e = this.n;
      this.p.f = this.o;
      this.p.C = parama.c;
      parama = parama.c;
      if ((parama == null) || (parama.length() <= 0) || (2 != this.b.o)) {
        break label314;
      }
    }
    catch (UnknownHostException localUnknownHostException)
    {
      try
      {
        l1 = SystemClock.elapsedRealtime();
        parama = InetAddress.getAllByName(parama);
        this.p.D = (SystemClock.elapsedRealtime() - l1);
        if ((parama == null) || (parama.length <= 0)) {
          break label305;
        }
        this.p.E = 0;
        if ((this.b.r & 0x1) == 1) {}
        for (this.n = parama[0];; this.n = parama[new java.util.Random().nextInt(parama.length)])
        {
          this.p.e = this.n;
          StringBuilder localStringBuilder = new StringBuilder();
          i1 = 0;
          while (i1 < parama.length)
          {
            localStringBuilder.append(parama[i1].getHostAddress()).append("|").append(parama[i1].getHostName()).append("**");
            i1 += 1;
          }
          localUnknownHostException = localUnknownHostException;
          localUnknownHostException.printStackTrace();
          break;
        }
        while (!QLog.isDevelopLevel()) {}
      }
      catch (UnknownHostException parama)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "dns parse error! ", parama);
        }
        this.p.E = 1;
        return;
      }
    }
    QLog.d("MSF.C.QualityTestManager", 4, "dns addrs " + localUnknownHostException.toString());
    return;
    label305:
    this.p.E = 1;
    return;
    label314:
    this.p.E = 0;
  }
  
  private boolean b(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (new String(paramArrayOfByte).endsWith("\r\n\r\n"));
  }
  
  /* Error */
  public static String d()
  {
    // Byte code:
    //   0: new 914	java/io/BufferedReader
    //   3: dup
    //   4: new 916	java/io/FileReader
    //   7: dup
    //   8: ldc_w 918
    //   11: invokespecial 919	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   14: sipush 8192
    //   17: invokespecial 922	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   20: astore_1
    //   21: aload_1
    //   22: astore_0
    //   23: aload_1
    //   24: invokevirtual 925	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: ldc_w 927
    //   30: ldc -122
    //   32: invokevirtual 931	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   35: ldc_w 618
    //   38: invokevirtual 935	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   41: astore_2
    //   42: aload_1
    //   43: astore_0
    //   44: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   47: ifeq +33 -> 80
    //   50: aload_1
    //   51: astore_0
    //   52: ldc -14
    //   54: iconst_4
    //   55: new 244	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   62: ldc_w 937
    //   65: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_2
    //   69: iconst_1
    //   70: aaload
    //   71: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_1
    //   81: invokevirtual 938	java/io/BufferedReader:close	()V
    //   84: aload_2
    //   85: iconst_1
    //   86: aaload
    //   87: areturn
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: astore_0
    //   93: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   96: ifeq +14 -> 110
    //   99: aload_1
    //   100: astore_0
    //   101: ldc -14
    //   103: iconst_4
    //   104: ldc_w 940
    //   107: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_1
    //   111: astore_0
    //   112: aload_2
    //   113: invokevirtual 471	java/lang/Exception:printStackTrace	()V
    //   116: aload_1
    //   117: invokevirtual 938	java/io/BufferedReader:close	()V
    //   120: ldc_w 942
    //   123: areturn
    //   124: astore_0
    //   125: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   128: ifeq +12 -> 140
    //   131: ldc -14
    //   133: iconst_4
    //   134: ldc_w 944
    //   137: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload_0
    //   141: invokevirtual 471	java/lang/Exception:printStackTrace	()V
    //   144: ldc_w 942
    //   147: areturn
    //   148: astore_1
    //   149: aconst_null
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 938	java/io/BufferedReader:close	()V
    //   155: aload_1
    //   156: athrow
    //   157: astore_0
    //   158: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   161: ifeq +12 -> 173
    //   164: ldc -14
    //   166: iconst_4
    //   167: ldc_w 944
    //   170: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload_0
    //   174: invokevirtual 471	java/lang/Exception:printStackTrace	()V
    //   177: goto -22 -> 155
    //   180: astore_0
    //   181: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   184: ifeq +12 -> 196
    //   187: ldc -14
    //   189: iconst_4
    //   190: ldc_w 944
    //   193: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_0
    //   197: invokevirtual 471	java/lang/Exception:printStackTrace	()V
    //   200: goto -116 -> 84
    //   203: astore_1
    //   204: goto -53 -> 151
    //   207: astore_2
    //   208: goto -117 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	90	0	localBufferedReader1	java.io.BufferedReader
    //   124	17	0	localException1	Exception
    //   150	2	0	localObject1	Object
    //   157	17	0	localException2	Exception
    //   180	17	0	localException3	Exception
    //   20	97	1	localBufferedReader2	java.io.BufferedReader
    //   148	8	1	localObject2	Object
    //   203	1	1	localObject3	Object
    //   41	44	2	arrayOfString	String[]
    //   88	25	2	localException4	Exception
    //   207	1	2	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   0	21	88	java/lang/Exception
    //   116	120	124	java/lang/Exception
    //   0	21	148	finally
    //   151	155	157	java/lang/Exception
    //   80	84	180	java/lang/Exception
    //   23	42	203	finally
    //   44	50	203	finally
    //   52	80	203	finally
    //   93	99	203	finally
    //   101	110	203	finally
    //   112	116	203	finally
    //   23	42	207	java/lang/Exception
    //   44	50	207	java/lang/Exception
    //   52	80	207	java/lang/Exception
  }
  
  /* Error */
  public static String e()
  {
    // Byte code:
    //   0: new 914	java/io/BufferedReader
    //   3: dup
    //   4: new 916	java/io/FileReader
    //   7: dup
    //   8: ldc_w 946
    //   11: invokespecial 919	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   14: sipush 8192
    //   17: invokespecial 922	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_0
    //   23: aload_2
    //   24: invokevirtual 925	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: ldc_w 948
    //   30: invokevirtual 935	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   33: astore_3
    //   34: iconst_2
    //   35: istore 4
    //   37: ldc -122
    //   39: astore_1
    //   40: aload_2
    //   41: astore_0
    //   42: iload 4
    //   44: aload_3
    //   45: arraylength
    //   46: if_icmpge +89 -> 135
    //   49: aload_2
    //   50: astore_0
    //   51: new 244	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   58: aload_1
    //   59: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_3
    //   63: iload 4
    //   65: aaload
    //   66: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc_w 950
    //   72: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_1
    //   79: iload 4
    //   81: iconst_1
    //   82: iadd
    //   83: istore 4
    //   85: goto -45 -> 40
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: astore_0
    //   93: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   96: ifeq +14 -> 110
    //   99: aload_1
    //   100: astore_0
    //   101: ldc -14
    //   103: iconst_4
    //   104: ldc_w 952
    //   107: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_1
    //   111: astore_0
    //   112: aload_3
    //   113: invokevirtual 471	java/lang/Exception:printStackTrace	()V
    //   116: ldc_w 954
    //   119: astore_0
    //   120: aload_1
    //   121: invokevirtual 938	java/io/BufferedReader:close	()V
    //   124: aload_0
    //   125: areturn
    //   126: astore_1
    //   127: aconst_null
    //   128: astore_0
    //   129: aload_0
    //   130: invokevirtual 938	java/io/BufferedReader:close	()V
    //   133: aload_1
    //   134: athrow
    //   135: aload_2
    //   136: invokevirtual 938	java/io/BufferedReader:close	()V
    //   139: aload_1
    //   140: astore_0
    //   141: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   144: ifeq -20 -> 124
    //   147: ldc -14
    //   149: iconst_4
    //   150: new 244	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 956
    //   160: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_1
    //   164: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload_1
    //   174: areturn
    //   175: astore_0
    //   176: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   179: ifeq +12 -> 191
    //   182: ldc -14
    //   184: iconst_4
    //   185: ldc_w 944
    //   188: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload_0
    //   192: invokevirtual 471	java/lang/Exception:printStackTrace	()V
    //   195: goto -62 -> 133
    //   198: astore_0
    //   199: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   202: ifeq +12 -> 214
    //   205: ldc -14
    //   207: iconst_4
    //   208: ldc_w 944
    //   211: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload_0
    //   215: invokevirtual 471	java/lang/Exception:printStackTrace	()V
    //   218: ldc_w 954
    //   221: areturn
    //   222: astore_0
    //   223: invokestatic 240	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   226: ifeq +12 -> 238
    //   229: ldc -14
    //   231: iconst_4
    //   232: ldc_w 944
    //   235: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aload_0
    //   239: invokevirtual 471	java/lang/Exception:printStackTrace	()V
    //   242: goto -103 -> 139
    //   245: astore_1
    //   246: goto -117 -> 129
    //   249: astore_3
    //   250: aload_2
    //   251: astore_1
    //   252: goto -161 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	119	0	localObject1	Object
    //   175	17	0	localException1	Exception
    //   198	17	0	localException2	Exception
    //   222	17	0	localException3	Exception
    //   39	82	1	str1	String
    //   126	48	1	str2	String
    //   245	1	1	localObject2	Object
    //   251	1	1	localBufferedReader1	java.io.BufferedReader
    //   20	231	2	localBufferedReader2	java.io.BufferedReader
    //   33	30	3	arrayOfString	String[]
    //   88	25	3	localException4	Exception
    //   249	1	3	localException5	Exception
    //   35	49	4	i1	int
    // Exception table:
    //   from	to	target	type
    //   0	21	88	java/lang/Exception
    //   0	21	126	finally
    //   129	133	175	java/lang/Exception
    //   120	124	198	java/lang/Exception
    //   135	139	222	java/lang/Exception
    //   23	34	245	finally
    //   42	49	245	finally
    //   51	79	245	finally
    //   93	99	245	finally
    //   101	110	245	finally
    //   112	116	245	finally
    //   23	34	249	java/lang/Exception
    //   42	49	249	java/lang/Exception
    //   51	79	249	java/lang/Exception
  }
  
  /* Error */
  public static ArrayList f()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore_0
    //   4: getstatic 974	android/os/Build$VERSION:SDK_INT	I
    //   7: bipush 21
    //   9: if_icmplt +158 -> 167
    //   12: invokestatic 980	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   15: ldc_w 982
    //   18: invokevirtual 986	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   21: checkcast 988	android/net/ConnectivityManager
    //   24: astore_0
    //   25: aload_0
    //   26: invokevirtual 992	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 997	android/net/NetworkInfo:getType	()I
    //   34: pop
    //   35: aload_1
    //   36: invokevirtual 997	android/net/NetworkInfo:getType	()I
    //   39: ifne +67 -> 106
    //   42: ldc_w 988
    //   45: ldc_w 999
    //   48: iconst_1
    //   49: anewarray 1001	java/lang/Class
    //   52: dup
    //   53: iconst_0
    //   54: getstatic 1005	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   57: aastore
    //   58: invokevirtual 1009	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   61: astore_1
    //   62: aload_1
    //   63: aload_0
    //   64: iconst_1
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: iload_2
    //   71: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokevirtual 1015	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 1019	java/lang/Object:getClass	()Ljava/lang/Class;
    //   83: ldc_w 1021
    //   86: invokevirtual 1025	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   89: astore_1
    //   90: aload_1
    //   91: iconst_1
    //   92: invokevirtual 1030	java/lang/reflect/Field:setAccessible	(Z)V
    //   95: aload_1
    //   96: aload_0
    //   97: invokevirtual 1031	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 333	java/util/ArrayList
    //   103: astore_0
    //   104: aload_0
    //   105: areturn
    //   106: aload_1
    //   107: invokevirtual 997	android/net/NetworkInfo:getType	()I
    //   110: iconst_1
    //   111: if_icmpne -69 -> 42
    //   114: iconst_1
    //   115: istore_2
    //   116: goto -74 -> 42
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 1032	java/lang/SecurityException:printStackTrace	()V
    //   124: aconst_null
    //   125: astore_0
    //   126: goto -22 -> 104
    //   129: astore_0
    //   130: aload_0
    //   131: invokevirtual 1033	java/lang/NoSuchFieldException:printStackTrace	()V
    //   134: aconst_null
    //   135: astore_0
    //   136: goto -32 -> 104
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 1034	java/lang/IllegalArgumentException:printStackTrace	()V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 1035	java/lang/NoSuchMethodException:printStackTrace	()V
    //   151: aconst_null
    //   152: areturn
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual 1036	java/lang/IllegalAccessException:printStackTrace	()V
    //   158: aconst_null
    //   159: areturn
    //   160: astore_0
    //   161: aload_0
    //   162: invokevirtual 1037	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   165: aconst_null
    //   166: areturn
    //   167: invokestatic 286	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq -66 -> 104
    //   173: ldc -14
    //   175: iconst_4
    //   176: new 244	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 1039
    //   186: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: getstatic 974	android/os/Build$VERSION:SDK_INT	I
    //   192: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: ldc_w 1041
    //   198: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aconst_null
    //   208: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	102	0	localObject1	Object
    //   119	2	0	localSecurityException	SecurityException
    //   125	1	0	localObject2	Object
    //   129	2	0	localNoSuchFieldException	NoSuchFieldException
    //   135	1	0	localObject3	Object
    //   139	2	0	localIllegalArgumentException	IllegalArgumentException
    //   146	2	0	localNoSuchMethodException	NoSuchMethodException
    //   153	2	0	localIllegalAccessException	IllegalAccessException
    //   160	2	0	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   29	78	1	localObject4	Object
    //   1	115	2	i1	int
    // Exception table:
    //   from	to	target	type
    //   79	104	119	java/lang/SecurityException
    //   79	104	129	java/lang/NoSuchFieldException
    //   62	79	139	java/lang/IllegalArgumentException
    //   79	104	139	java/lang/IllegalArgumentException
    //   120	124	139	java/lang/IllegalArgumentException
    //   130	134	139	java/lang/IllegalArgumentException
    //   42	62	146	java/lang/NoSuchMethodException
    //   62	79	146	java/lang/NoSuchMethodException
    //   79	104	146	java/lang/NoSuchMethodException
    //   120	124	146	java/lang/NoSuchMethodException
    //   130	134	146	java/lang/NoSuchMethodException
    //   140	144	146	java/lang/NoSuchMethodException
    //   154	158	146	java/lang/NoSuchMethodException
    //   161	165	146	java/lang/NoSuchMethodException
    //   62	79	153	java/lang/IllegalAccessException
    //   79	104	153	java/lang/IllegalAccessException
    //   120	124	153	java/lang/IllegalAccessException
    //   130	134	153	java/lang/IllegalAccessException
    //   62	79	160	java/lang/reflect/InvocationTargetException
    //   79	104	160	java/lang/reflect/InvocationTargetException
    //   120	124	160	java/lang/reflect/InvocationTargetException
    //   130	134	160	java/lang/reflect/InvocationTargetException
  }
  
  private static void g()
  {
    c localc = new c();
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      SecureRandom localSecureRandom = new SecureRandom();
      localSSLContext.init(null, new TrustManager[] { localc }, localSecureRandom);
      HttpsURLConnection.setDefaultSSLSocketFactory(localSSLContext.getSocketFactory());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MSF.C.QualityTestManager", 1, "trustallhost error! ", localException);
    }
  }
  
  private void h()
  {
    try
    {
      switch (1.a[this.a.ordinal()])
      {
      case 1: 
        this.g.close();
        if (QLog.isDevelopLevel())
        {
          QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close Udp socket");
          return;
        }
        break;
      case 2: 
        this.h.close();
        this.i.close();
        if (QLog.isDevelopLevel())
        {
          QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close Tcp socket");
          return;
        }
        break;
      case 3: 
        if (this.k != null)
        {
          this.k.disconnect();
          this.k = null;
        }
        this.i.close();
        if (QLog.isDevelopLevel())
        {
          QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close Http socket");
          return;
        }
        break;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void i()
  {
    if (this.b == null)
    {
      b(a.d.a.k, true);
      f.a();
      return;
    }
    j();
    this.p.r = this.b.a;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.QualityTestManager", 2, "cProtoType:" + this.b.a + " IpPort.size():" + this.b.b.size() + " cDomainToIpMode:" + this.b.r + " strRspMatchPattern" + this.b.t + " strUserInfo:" + this.b.u + " dwRecvCopyStart" + this.b.w + " dwRecvCopyLen" + this.b.x + " strDnsSrvIp:" + this.q.j + " dwLocationTime:" + this.q.l + " strAxis:" + this.q.m);
    }
    if (this.b.b.size() > 10)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
      }
      this.T = false;
      b(a.d.a.m, true);
      f.a();
      return;
    }
    if (this.b.b.size() <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too small, return ");
      }
      this.T = false;
      b(a.d.a.n, true);
      f.a();
      return;
    }
    if (this.b.h * 1000L < System.currentTimeMillis())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg expired, stop test qualityTestMsg.dwExpirTime:" + this.b.h + "System.currentTimeMillis():" + System.currentTimeMillis());
      }
      b(a.d.a.j, true);
      f.a();
      return;
    }
    int i1;
    int i2;
    if ((this.b.i > 0L) && (this.b.i < 1800L))
    {
      i1 = (int)this.b.i * 1000;
      i2 = 0;
    }
    for (;;)
    {
      try
      {
        int i3 = this.b.b.size();
        if (i2 >= i3) {
          continue;
        }
      }
      catch (Exception localException2)
      {
        String str1;
        QLog.d("MSF.C.QualityTestManager", 1, "networkDetectRun: error ", localException2);
        return;
        if ((this.b.v == null) || (this.b.v.size() <= 0)) {
          continue;
        }
        str3 = "";
        Iterator localIterator = this.b.v.iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        com.tencent.msf.service.protocol.push.a.c localc = (com.tencent.msf.service.protocol.push.a.c)localIterator.next();
        Object localObject1 = str3;
        if (localc == null) {
          break label1184;
        }
        str3 = str3 + localc.a + " " + localc.b + " ";
        localObject1 = str3;
        if (!QLog.isColorLevel()) {
          break label1184;
        }
        QLog.d("MSF.C.QualityTestManager", 4, "pingOptions.strKey:" + localc.a + ",pingOptions.strValue:" + localc.b);
        localObject1 = str3;
        break label1184;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MSF.C.QualityTestManager", 2, "pingParamStr : " + str3);
        ((d)localObject3).a(str3);
        Object localObject3 = ((d)localObject3).b();
        if ((localObject3 == null) || (!((d.a)localObject3).b)) {
          break label1189;
        }
        str3 = ((d.a)localObject3).d;
        localObject1 = str3;
        if (TextUtils.isEmpty(((d.a)localObject3).c)) {
          break label1152;
        }
        this.p.J = ((d.a)localObject3).c;
        bool1 = true;
        localObject1 = str3;
        continue;
        localObject3 = ((d)localObject3).a();
        if ((localObject3 == null) || (!((d.a)localObject3).b)) {
          break label1198;
        }
        str3 = ((d.a)localObject3).d;
        localObject1 = str3;
        if (TextUtils.isEmpty(((d.a)localObject3).c)) {
          break label1152;
        }
        this.p.J = ((d.a)localObject3).c;
        bool1 = true;
        localObject1 = str3;
        continue;
        b(a.d.a.b, bool2);
      }
      finally
      {
        f.a();
      }
      try
      {
        this.p.g = NetConnInfoCenterImpl.getSystemNetworkType();
        this.p.h = NetConnInfoCenter.getWifiStrength();
        this.p.j = NetConnInfoCenter.getCdmaStrength();
        this.p.i = NetConnInfoCenter.getGsmStrength();
        this.n = com.tencent.qphone.base.util.e.a(((com.tencent.msf.service.protocol.push.a.a)this.b.b.get(i2)).a);
        this.p.J = this.n.getHostAddress();
        this.p.C = ((com.tencent.msf.service.protocol.push.a.a)this.b.b.get(i2)).c;
        if ((this.p.C == null) || (this.p.C.isEmpty())) {
          this.p.C = this.p.J;
        }
        this.p.c.clear();
        str1 = this.p.C;
        this.p.L = System.currentTimeMillis();
        localObject3 = new d(str1, true, i1);
        switch (1.a[this.a.ordinal()])
        {
        case 4: 
          this.p.Q = com.tencent.qphone.base.util.e.a(str1);
          this.p.P = this.p.Q.length();
          this.p.M = System.currentTimeMillis();
          if (i2 != this.b.b.size() - 1) {
            break label1207;
          }
          bool2 = true;
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.QualityTestManager", 2, "testsuccess: " + bool1 + ",isUpload:" + bool2);
          }
          if (bool1) {
            b(a.d.a.a, bool2);
          }
          break;
        }
      }
      catch (Exception localException1)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("MSF.C.QualityTestManager", 4, "failed to get network info", localException1);
        continue;
      }
      label1152:
      boolean bool1 = true;
      continue;
      i1 = 1200000;
      break;
      String str2 = "";
      bool1 = true;
      continue;
      i2 += 1;
      continue;
      label1184:
      String str3 = str2;
      continue;
      label1189:
      str2 = "";
      bool1 = false;
      continue;
      label1198:
      str2 = "";
      bool1 = false;
      continue;
      label1207:
      boolean bool2 = false;
    }
  }
  
  private void j()
  {
    this.q.d = this.b.j;
    this.q.e = this.b.o;
    this.q.f = this.b.k;
    this.q.g = this.b.l;
    this.q.h = this.b.m;
    this.q.a = a.c.a.a;
    this.q.i = this.b.u;
    ArrayList localArrayList = f();
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      this.q.j = ((InetAddress)localArrayList.get(0)).getHostAddress();
    }
    for (;;)
    {
      if (0L != n.g)
      {
        this.q.l = n.g;
        this.q.m = (n.h + "," + n.i);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.QualityTestManager", 2, "mDnses is null");
      }
    }
  }
  
  private boolean k()
  {
    if ((this.b.g == null) && (this.b.g.length <= 0)) {
      return false;
    }
    String[] arrayOfString = new String(this.b.g).split("\r\n");
    Object localObject1 = "";
    Object localObject2 = "";
    int i2 = arrayOfString.length;
    int i1 = 0;
    if (i1 < i2)
    {
      String str = arrayOfString[i1];
      Object localObject4;
      Object localObject3;
      if (((!str.startsWith("Cookie:")) || (!str.contains("md5="))) && ((!str.startsWith("Set-Cookie:")) || (!str.contains("md5="))))
      {
        localObject4 = (String)localObject1 + str + "\r\n";
        localObject3 = localObject2;
      }
      for (;;)
      {
        i1 += 1;
        localObject2 = localObject3;
        localObject1 = localObject4;
        break;
        int i3 = str.indexOf("md5=");
        int i4 = str.indexOf(";", i3);
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (i3 != -1)
        {
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (i4 > "md5=".length() + i3)
          {
            localObject3 = str.substring("md5=".length() + i3, i4);
            localObject4 = localObject1;
          }
        }
      }
    }
    return ((String)localObject2).equals(MD5.toMD5((String)localObject1 + "\r\n"));
  }
  
  private void l()
  {
    if (this.c == null)
    {
      b(a.d.a.o, true);
      f.a();
      return;
    }
    this.p.a = a.d.b.b;
    this.p.g = NetConnInfoCenterImpl.getSystemNetworkType();
    this.p.r = this.c.a;
    this.p.s = this.c.g;
    this.p.t = this.c.f;
    this.p.u = new ArrayList();
    int i1 = 0;
    while (i1 < this.c.d.size())
    {
      this.p.u.add(this.c.d.get(i1));
      i1 += 1;
    }
    this.p.w = this.c.h;
    this.p.v = new ArrayList();
    QLog.d("MSF.C.QualityTestManager", 1, "PkgInterval :" + this.c.f + " IpPort.size():" + this.c.b.size() + " PkgData.length " + this.c.c.size() + " PkgNum:" + this.c.g);
    if (this.c.b.size() > 75)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
      }
      this.T = false;
      b(a.d.a.m, true);
      f.a();
      return;
    }
    if (this.c.b.size() <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too small, return ");
      }
      b(a.d.a.n, true);
      f.a();
      return;
    }
    if (this.c.g > 20L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much, return ");
      }
      this.T = false;
      b(a.d.a.l, true);
      f.a();
      return;
    }
    if (this.c.h * 1000L < System.currentTimeMillis())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "mtuTest expired, stop test mtuTest.dwExpirTime:" + this.c.h + "System.currentTimeMillis():" + System.currentTimeMillis());
      }
      b(a.d.a.j, true);
      f.a();
      return;
    }
    if ((this.c.e.size() != this.c.d.size()) || (this.c.c.size() != this.c.d.size()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData size error, stop test");
      }
      b(a.d.a.i, true);
      f.a();
      return;
    }
    if (this.c.g <= 0L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "mtuTest dwPkgNum too short, stop test mtuTest.dwPkgNum:" + this.c.g);
      }
      b(a.d.a.i, true);
      f.a();
      return;
    }
    if (this.c.g * this.c.c.size() > 20L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much, return ");
      }
      this.T = false;
      b(a.d.a.l, true);
      f.a();
      return;
    }
    int i3 = 0;
    for (;;)
    {
      int i4;
      int i5;
      try
      {
        if (i3 < this.c.b.size())
        {
          i1 = 0;
          this.p.y = new ArrayList();
          this.p.k = 0;
          this.p.n = 0;
          this.p.l = 0;
          this.p.m = 0;
          this.p.o = 0;
          this.p.c.clear();
          this.p.v.clear();
          try
          {
            this.p.h = NetConnInfoCenter.getWifiStrength();
            this.p.j = NetConnInfoCenter.getCdmaStrength();
            this.p.i = NetConnInfoCenter.getGsmStrength();
            i4 = 0;
            if (i4 >= this.c.c.size()) {
              break label1628;
            }
            if (((byte[])this.c.c.get(i4)).length < 8)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData too short, stop test qualityTestMsg.sPkgData.length");
              }
              a(a.d.a.i);
            }
          }
          catch (Exception localException1)
          {
            if (!QLog.isDevelopLevel()) {
              continue;
            }
            QLog.d("MSF.C.QualityTestManager", 4, "failed to get network strength");
            continue;
          }
        }
        int i6;
        ByteBuffer localByteBuffer;
        int i7;
        if (arrayOfByte == null) {
          break label1585;
        }
      }
      catch (Exception localException2)
      {
        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient  error ", localException2);
        return;
        if ((this.c.e.get(i4) == null) || (((byte[])this.c.e.get(i4)).length <= 0)) {
          break label1682;
        }
        i2 = ((byte[])this.c.e.get(i4)).length;
        i6 = (int)(i2 + ((byte[])this.c.c.get(i4)).length * ((Long)this.c.d.get(i4)).longValue());
        QLog.d("MSF.C.QualityTestManager", 1, "mtu allbodylength " + i6);
        if ((i6 > 262144) && (this.a == a.a))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i6 + " return ");
          }
          a(a.d.a.h);
        }
        else if (i6 > 262144)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i6 + " return ");
          }
          this.T = false;
          a(a.d.a.h);
        }
        else
        {
          if (this.c.f >= 10L) {
            break label1697;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "dwPkgInterval too small " + this.c.f + " return ");
          }
          a(a.d.a.g);
          break label1688;
          if (i5 < this.c.g)
          {
            i1 = i2;
            if (i2 == 0)
            {
              if (!a((com.tencent.msf.service.protocol.push.a.a)this.c.b.get(i3)))
              {
                if (QLog.isDevelopLevel()) {
                  QLog.d("MSF.C.QualityTestManager", 4, "connectToServer error, return ");
                }
                a(a.d.a.c);
                i1 = i2;
                break label1706;
              }
              this.w = 0L;
              this.A = 0L;
              this.x = 0L;
              this.B = 0L;
              i1 = 1;
            }
            try
            {
              localByteBuffer = ByteBuffer.allocate(i6);
              arrayOfByte = new byte[i6];
              if ((this.c.e.get(i4) == null) || (((byte[])this.c.e.get(i4)).length <= 0)) {
                break label1718;
              }
              localByteBuffer.put((byte[])this.c.e.get(i4));
            }
            catch (Exception localException3)
            {
              byte[] arrayOfByte;
              QLog.d("MSF.C.QualityTestManager", 1, "QualityClient:  error:", localException3);
              localException3.printStackTrace();
              try
              {
                Thread.sleep(this.c.f);
              }
              catch (Exception localException4)
              {
                QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: Thread sleep error " + localException4);
              }
            }
            if (i2 < ((Long)this.c.d.get(i4)).longValue())
            {
              localByteBuffer.put((byte[])this.c.c.get(i4));
              i2 += 1;
              continue;
            }
            localByteBuffer.flip();
            localByteBuffer.get(arrayOfByte);
            i2 = arrayOfByte.length;
            i7 = com.tencent.mobileqq.msf.core.c.a(arrayOfByte, 0);
            if (i7 != i2)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "testdata length error stop dataTotalLen:" + i7 + " receBodySize:" + i2);
              }
              a(a.d.a.f);
              this.p.y.add(Integer.valueOf(i6));
            }
          }
        }
      }
      finally
      {
        f.a();
      }
      if (!a(arrayOfByte))
      {
        i1 = 0;
      }
      else if (!a(arrayOfByte.length, arrayOfByte))
      {
        this.p.v.add(Integer.valueOf(arrayOfByte.length));
        i1 = 0;
      }
      else
      {
        label1585:
        label1628:
        h();
        if (i3 == this.c.b.size() - 1) {}
        for (boolean bool = true;; bool = false)
        {
          b(a.d.a.a, bool);
          i3 += 1;
          break;
        }
        i1 = i2;
        continue;
        label1682:
        i2 = 0;
        continue;
        label1688:
        i4 += 1;
        continue;
        label1697:
        i5 = 0;
        i2 = i1;
        continue;
      }
      label1706:
      i5 += 1;
      int i2 = i1;
      continue;
      label1718:
      i2 = 0;
    }
  }
  
  public String a()
  {
    return this.Q;
  }
  
  public void a(a.d.a parama, boolean paramBoolean)
  {
    if (parama == a.d.a.a)
    {
      this.p.b = parama;
      if (this.w == 0L) {
        break label316;
      }
      this.p.p = ((int)((float)this.x / (float)this.w));
      label43:
      if (this.A == 0L) {
        break label327;
      }
      this.p.q = ((int)((float)this.B / (float)this.A));
      label71:
      parama = this.p.toString();
      if (!TextUtils.isEmpty(this.Q)) {
        break label338;
      }
      this.Q += "(";
      if ((this.b == null) || (this.c != null) || (this.q.a != a.c.a.a) || (this.p.a != a.d.b.a)) {}
    }
    for (this.Q += this.q.toString();; this.Q += "*") {
      label316:
      label327:
      label338:
      do
      {
        this.Q += parama;
        if (paramBoolean) {}
        try
        {
          this.Q += ")";
          parama = new CRC32();
          parama.update(this.Q.getBytes());
          this.Q += parama.getValue();
          return;
        }
        catch (Exception parama)
        {
          parama.printStackTrace();
        }
        this.p.b = a.d.a.b;
        if (parama == a.d.a.b) {
          break;
        }
        a(parama);
        break;
        this.p.p = 0;
        break label43;
        this.p.q = 0;
        break label71;
      } while ((this.Q.endsWith("#")) || (this.Q.endsWith("(")));
    }
  }
  
  public String b()
  {
    c();
    if (this.f) {
      return this.Q;
    }
    return "";
  }
  
  public void c()
  {
    this.f = false;
    if (this.b == null)
    {
      b(a.d.a.k, true);
      f.a();
      return;
    }
    j();
    this.p.a = a.d.b.a;
    this.p.r = this.b.a;
    this.p.s = this.b.c;
    this.p.t = this.b.d;
    this.p.u = new ArrayList();
    this.p.u.add(Long.valueOf(this.b.f));
    this.p.w = this.b.h;
    this.p.B = this.b.o;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      if ("cProtoType:" + this.b.a + " PkgInterval:" + this.b.d + " IpPort.size():" + this.b.b.size() + " PkgNum:" + this.b.c + " HeadData.length:" + this.b.g == null) {
        break label328;
      }
      localObject1 = Integer.valueOf(this.b.g.length);
    }
    for (;;)
    {
      QLog.d("MSF.C.QualityTestManager", 2, new Object[] { localObject1 });
      if (this.d <= 1) {
        break;
      }
      if (this.b.b.size() <= 200) {
        break label800;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much for WiFi test, return ");
      }
      this.T = false;
      b(a.d.a.m, true);
      f.a();
      return;
      label328:
      if ("null TailData.length:" + this.b.p != null) {
        localObject1 = Integer.valueOf(this.b.p.length);
      } else if ("null RepeatTimes:" + this.b.f + " PkgData.length:" + this.b.e != null) {
        localObject1 = Integer.valueOf(this.b.e.length);
      } else {
        localObject1 = "null cDomainToIpMode:" + this.b.r + " dwTaskType:" + this.b.j + " dwTaskTime:" + this.b.k + " dwReserved1:" + this.b.l + " dwReserved2:" + this.b.m + " dwRecvLen:" + this.b.n + " cTestType:" + this.b.o + " strUserInfo:" + this.b.u + " strDnsSrvIp:" + this.q.j + " dwLocationTime:" + this.q.l + " strAxis:" + this.q.m + " sPkgData:" + Arrays.toString(this.b.e) + " cHttpsFunction" + this.b.y;
      }
    }
    if ((this.d == 1) && ((this.b.m & 0xFF) != 1L))
    {
      if (this.b.b.size() > 75)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
        }
        this.T = false;
        b(a.d.a.m, true);
        f.a();
      }
    }
    else if ((this.d == 1) && ((this.b.m & 0xFF) == 1L) && (this.b.b.size() > 200))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much for WiFi test, return ");
      }
      this.T = false;
      b(a.d.a.m, true);
      f.a();
      return;
    }
    label800:
    if (this.b.b.size() <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too small, return ");
      }
      b(a.d.a.n, true);
      f.a();
      return;
    }
    if (this.b.f <= 0L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "dwRepeatTimes must > 0");
      }
      b(a.d.a.q, true);
      f.a();
      return;
    }
    if (this.d > 1)
    {
      if (this.b.c > 50L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much for WiFi test, return ");
        }
        this.T = false;
        b(a.d.a.l, true);
        f.a();
      }
    }
    else if ((this.d == 1) && ((this.b.m & 0xFF) != 1L))
    {
      if (this.b.c > 20L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much, return ");
        }
        this.T = false;
        b(a.d.a.l, true);
        f.a();
      }
    }
    else if ((this.d == 1) && ((this.b.m & 0xFF) == 1L) && (this.b.c > 50L))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much for WiFi test, return ");
      }
      this.T = false;
      b(a.d.a.l, true);
      f.a();
      return;
    }
    if ((this.b.m >> 8 & 0xFF) > 20L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "dwReserved2>>8 &0xFF too much, return ");
      }
      this.T = false;
      b(a.d.a.l, true);
      f.a();
      return;
    }
    if (this.b.h * 1000L < System.currentTimeMillis())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg expired, stop test qualityTestMsg.dwExpirTime:" + this.b.h + "System.currentTimeMillis():" + System.currentTimeMillis());
      }
      b(a.d.a.j, true);
      f.a();
      return;
    }
    if ((this.b.o != 0) && (1 != this.b.o) && (2 != this.b.o))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.QualityTestManager", 2, "qualityTestMsg.cTestType " + this.b.o + " NoSupport");
      }
      b(a.d.a.w, true);
      f.a();
      return;
    }
    int i2 = 0;
    int i1 = i2;
    int i6;
    for (;;)
    {
      try
      {
        if (this.b.g != null)
        {
          i1 = i2;
          if (this.b.g.length > 0) {
            i1 = this.b.g.length;
          }
        }
        i6 = (int)(i1 + this.b.e.length * this.b.f);
        if ((this.b.p == null) || (this.b.p.length <= 0)) {
          break label3487;
        }
        i6 += this.b.p.length;
        QLog.d("MSF.C.QualityTestManager", 1, "allbodylength " + i6);
        if (this.a == a.c)
        {
          if (i6 != 0) {
            continue;
          }
          this.l = 1;
        }
        if (this.b.d >= 10L) {
          break;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "dwPkgInterval too small " + this.b.d + " return ");
        }
        b(a.d.a.g, true);
        f.a();
      }
      catch (Exception localException1)
      {
        label1503:
        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: error ", localException1);
        continue;
      }
      finally
      {
        f.a();
      }
      return;
      this.l = 0;
    }
    int i5 = 0;
    i1 = 0;
    label1540:
    int i3;
    long l1;
    label1890:
    int i4;
    label2022:
    label2359:
    label2524:
    boolean bool1;
    if ((i1 < this.b.b.size()) && (i5 == 0))
    {
      this.p.y = new ArrayList();
      this.p.k = 0;
      this.p.n = 0;
      this.p.l = 0;
      this.p.m = 0;
      this.p.o = 0;
      this.p.c.clear();
      this.p.x = false;
      this.p.A = null;
      this.p.H.clear();
      this.p.I.clear();
      this.p.d = null;
      this.p.D = 0L;
      this.p.E = 0;
      this.p.F = 0;
      this.p.G = 0;
      for (;;)
      {
        long l2;
        try
        {
          this.p.g = NetConnInfoCenterImpl.getSystemNetworkType();
          this.p.h = NetConnInfoCenter.getWifiStrength();
          this.p.j = NetConnInfoCenter.getCdmaStrength();
          this.p.i = NetConnInfoCenter.getGsmStrength();
          this.w = 0L;
          this.A = 0L;
          this.x = 0L;
          this.B = 0L;
          i3 = i1;
          try
          {
            if (!NetConnInfoCenterImpl.isWifiConn()) {
              break label2022;
            }
            i3 = i1;
            if (NetConnInfoCenter.getWifiStrength() <= 10) {
              break label2022;
            }
            i3 = i1;
            if (!f.e.equals("NotWiFi")) {
              continue;
            }
            i3 = i1;
            if (this.e == 0) {
              continue;
            }
            i3 = i1;
            if (!QLog.isColorLevel()) {
              break;
            }
            i3 = i1;
            QLog.d("MSF.C.QualityTestManager", 2, "lost wifi connection, give up qualitytest run_thread" + Thread.currentThread().getName());
          }
          catch (Exception localException2)
          {
            l2 = 1L;
            i2 = i3;
          }
          l1 = l2;
          i1 = i2;
          if (!QLog.isDevelopLevel()) {
            break label3490;
          }
          QLog.d("MSF.C.QualityTestManager", 4, "net change caused quality test error", localException2);
          l1 = l2;
          i1 = i2;
          break label3490;
          this.p.y.add(Integer.valueOf(i6));
          if (i4 != -1) {
            break label3362;
          }
        }
        catch (Exception localException3)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.d("MSF.C.QualityTestManager", 4, "failed to get network strength");
          continue;
          i3 = i1;
          if ((this.b.m & 0xFF) == 1L)
          {
            i3 = i1;
            if (this.d > 1)
            {
              i3 = i1;
              l1 = this.b.c / this.d;
              break label3490;
            }
            i3 = i1;
            l1 = this.b.m >> 8 & 0xFF;
            break label3490;
          }
          i3 = i1;
          l1 = this.b.c;
          break label3490;
        }
        i3 = i1;
        f.e = "NotWiFi";
        i3 = i1;
        if ((this.b.m & 0xFF) == 1L)
        {
          i3 = i1;
          if (this.d > 1)
          {
            i3 = i1;
            if (this.e != 0)
            {
              i3 = i1;
              if (!QLog.isColorLevel()) {
                break;
              }
              i3 = i1;
              QLog.d("MSF.C.QualityTestManager", 2, "lost wifi connection, give up qualitytest run_thread" + Thread.currentThread().getName());
              break;
            }
            i2 = -1;
            i3 = i2;
            this.d = 1;
            i3 = i2;
            if (this.b.b.size() > 75)
            {
              i3 = i2;
              if (QLog.isDevelopLevel())
              {
                i3 = i2;
                QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
              }
              i3 = i2;
              i1 = this.Q.indexOf("#");
              if (i1 != -1)
              {
                i3 = i2;
                this.Q = this.Q.substring(0, i1 + 1);
              }
              i3 = i2;
              this.p.c.clear();
              i3 = i2;
              this.T = false;
              i3 = i2;
              b(a.d.a.m, true);
              i3 = i2;
              f.a();
              break;
            }
            i3 = i2;
            l1 = this.b.m;
            l2 = l1 >> 8 & 0xFF;
            try
            {
              i3 = this.Q.indexOf("#");
              l1 = l2;
              i1 = i2;
              if (i3 == -1) {
                break label3490;
              }
              this.Q = this.Q.substring(0, i3 + 1);
              l1 = l2;
              i1 = i2;
            }
            catch (Exception localException4) {}
            continue;
          }
          i3 = i1;
          l1 = this.b.m >> 8 & 0xFF;
          break label3490;
        }
        i3 = i1;
        l1 = this.b.c;
        break label3490;
        i4 = i1;
        try
        {
          if (NetConnInfoCenterImpl.isWifiConn())
          {
            i4 = i1;
            if (NetConnInfoCenter.getWifiStrength() > 10)
            {
              i4 = i1;
              if (f.e.equals("NotWiFi"))
              {
                i4 = i1;
                if (this.e != 0)
                {
                  i4 = 1;
                  i5 = 1;
                  i1 = this.b.b.size();
                  i3 = i1;
                  i1 = i3;
                }
              }
            }
          }
        }
        catch (Exception localException10)
        {
          for (;;)
          {
            i1 = i3;
            i3 = i2;
            i2 = i4;
          }
        }
        try
        {
          if (QLog.isColorLevel())
          {
            i1 = i3;
            QLog.d("MSF.C.QualityTestManager", 2, "lost wifi connection, give up qualitytest run_thread" + this.e);
          }
          i4 = i3;
        }
        catch (Exception localException11)
        {
          i4 = 1;
          i3 = i2;
          i2 = i4;
          break label2864;
        }
      }
      i4 = i1;
      if ((this.b.m & 0xFF) == 1L)
      {
        i4 = i1;
        if (this.d > 1)
        {
          i4 = i1;
          l2 = this.b.c / this.d;
          l1 = l2;
          i4 = i1;
        }
      }
      for (;;)
      {
        try
        {
          b((com.tencent.msf.service.protocol.push.a.a)this.b.b.get(i3));
          if ((this.b.r & 0x2) == 2)
          {
            a(a.d.a.z);
            this.p.s = 0L;
            bool1 = false;
            h();
            i2 += 1;
            i1 = i4;
            break label3501;
            i4 = i1;
            l2 = this.b.m >> 8 & 0xFF;
            l1 = l2;
            break label2524;
            i4 = i1;
            l2 = this.b.c;
            l1 = l2;
            break label2524;
            i4 = i1;
            f.e = "NotWiFi";
            i4 = i1;
            if ((this.b.m & 0xFF) == 1L)
            {
              i4 = i1;
              if (this.d > 1)
              {
                i4 = i1;
                if (this.e != 0)
                {
                  i4 = 1;
                  i5 = 1;
                  i1 = this.b.b.size();
                  i3 = i1;
                  i1 = i3;
                  if (QLog.isColorLevel())
                  {
                    i1 = i3;
                    QLog.d("MSF.C.QualityTestManager", 2, "lost wifi connection, give up qualitytest run_thread" + this.e);
                  }
                  i4 = i3;
                  break label1890;
                }
                i2 = -1;
                i3 = 0;
                try
                {
                  this.d = 1;
                  if (this.b.b.size() <= 75) {
                    continue;
                  }
                  if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
                  }
                  i2 = this.Q.indexOf("#");
                  if (i2 != -1) {
                    this.Q = this.Q.substring(0, i2 + 1);
                  }
                  this.p.c.clear();
                  this.T = false;
                  b(a.d.a.m, true);
                  f.a();
                }
                catch (Exception localException5)
                {
                  i4 = -1;
                  i2 = i1;
                  i1 = i4;
                }
                label2864:
                if (QLog.isDevelopLevel()) {
                  QLog.d("MSF.C.QualityTestManager", 4, "net change caused quality test error", localException5);
                }
                i4 = i2;
                i2 = i3;
                i3 = i1;
                continue;
                l2 = this.b.m;
                l1 = l2 >> 8 & 0xFF;
                try
                {
                  int i7 = this.Q.indexOf("#");
                  i4 = i2;
                  i5 = i1;
                  if (i7 == -1) {
                    break label1890;
                  }
                  this.Q = this.Q.substring(0, i7 + 1);
                  i4 = i2;
                  i5 = i1;
                }
                catch (Exception localException6)
                {
                  i4 = -1;
                  i2 = i1;
                  i1 = i4;
                }
                continue;
              }
              i4 = i1;
              l2 = this.b.m >> 8 & 0xFF;
              l1 = l2;
              break label2524;
            }
            i4 = i1;
            l2 = this.b.c;
            l1 = l2;
            break label2524;
          }
          if (!a((com.tencent.msf.service.protocol.push.a.a)this.b.b.get(i3)))
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("MSF.C.QualityTestManager", 4, "connectToServer error, return ");
            }
            bool1 = false;
          }
        }
        catch (Exception localException8)
        {
          byte[] arrayOfByte;
          QLog.d("MSF.C.QualityTestManager", 1, "QualityClient:  error:", localException8);
          localException8.printStackTrace();
          h();
          continue;
        }
        finally
        {
          h();
        }
        try
        {
          this.p.I.add(Long.valueOf(-1L));
          a(a.d.a.c);
          h();
        }
        catch (Exception localException9)
        {
          bool1 = false;
          continue;
        }
        bool2 = a(i6);
        if (!bool2)
        {
          bool1 = false;
          h();
        }
        else
        {
          arrayOfByte = a(i6, this.b.g, this.b.p);
          if (arrayOfByte == null)
          {
            bool1 = false;
            h();
          }
          else
          {
            if ((this.a != a.c) || (this.l == 0))
            {
              bool2 = a(arrayOfByte);
              if (!bool2)
              {
                bool1 = false;
                this.p.I.add(Long.valueOf(-1L));
                h();
              }
            }
            else
            {
              this.u = System.currentTimeMillis();
            }
            i1 = 0;
            if ((this.b.o == 0) || (1 == this.b.o))
            {
              i1 = arrayOfByte.length;
              bool2 = a(i1, arrayOfByte);
              if (!bool2)
              {
                bool1 = false;
                h();
              }
            }
            else
            {
              if (2 != this.b.o) {
                continue;
              }
              l2 = this.b.n;
              i1 = (int)l2;
              continue;
            }
            h();
            try
            {
              Thread.sleep(this.b.d);
            }
            catch (Exception localException7)
            {
              QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: Thread sleep error " + localException7);
            }
          }
        }
      }
      label3362:
      if (i4 != this.b.b.size() - 1) {
        break label3540;
      }
    }
    label3487:
    label3490:
    label3501:
    label3532:
    label3540:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.QualityTestManager", 2, "testsuccess: " + bool1);
      }
      if (bool1) {
        b(a.d.a.a, bool2);
      }
      for (;;)
      {
        if (bool2)
        {
          this.f = true;
          break label3532;
          b(a.d.a.b, bool2);
          continue;
          break;
          bool1 = true;
          i3 = i1;
          i2 = 0;
          i1 = i5;
          i4 = i3;
          i5 = i1;
          if (i2 >= l1) {
            break label1890;
          }
          if (i3 != -1) {
            break label2359;
          }
          i4 = i3;
          i5 = i1;
          break label1890;
        }
      }
      i1 = i4 + 1;
      break label1540;
      break label1503;
    }
  }
  
  public void run()
  {
    try
    {
      if (this.b == null) {
        break label74;
      }
      switch (1.a[this.a.ordinal()])
      {
      case 1: 
      case 2: 
      case 3: 
        c();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.QualityTestManager", 1, "QualityClient start failed, Exception :", localException);
      return;
    }
    i();
    return;
    label74:
    if (this.c != null)
    {
      l();
      return;
    }
  }
  
  public static enum a
  {
    public static a a(String paramString)
    {
      return (a)Enum.valueOf(a.class, paramString);
    }
    
    public static a[] a()
    {
      return (a[])f.clone();
    }
  }
  
  static class b
  {
    public String[] a;
    public String b = "";
    
    public static b a(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      b localb = new b();
      int j = paramString.indexOf("\r\n\r\n");
      int i = j;
      if (j == -1) {
        i = paramString.length();
      }
      localb.a = paramString.substring(0, i).split("\r\n");
      return localb;
    }
    
    public String a()
    {
      if ((this.a == null) || (this.a.length == 0)) {
        return "";
      }
      String str1 = "";
      String[] arrayOfString = this.a;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str2 = arrayOfString[i];
        str1 = str1 + str2 + "\r\n";
        i += 1;
      }
      return str1 + "\r\n";
    }
    
    public String b()
    {
      if ((this.a == null) || (this.a.length == 0)) {}
      for (;;)
      {
        return "";
        String[] arrayOfString = this.a;
        int m = arrayOfString.length;
        int i = 0;
        while (i < m)
        {
          String str = arrayOfString[i];
          if (((str.startsWith("Set-Cookie:")) && (str.contains("gateway="))) || ((str.startsWith("Cookie:")) && (str.contains("gateway="))))
          {
            int n = str.indexOf("gateway=");
            int k = str.indexOf(";", n);
            int j = k;
            if (k == -1) {
              j = str.length();
            }
            if ((n != -1) && (j > n)) {
              return str.substring("gateway=".length() + n, j);
            }
          }
          i += 1;
        }
      }
    }
    
    public String c()
    {
      if ((this.a == null) || (this.a.length == 0)) {}
      for (;;)
      {
        return "";
        String[] arrayOfString = this.a;
        int m = arrayOfString.length;
        int i = 0;
        while (i < m)
        {
          String str = arrayOfString[i];
          if (((str.startsWith("Set-Cookie:")) && (str.contains("md5="))) || ((str.startsWith("Cookie:")) && (str.contains("md5="))))
          {
            int n = str.indexOf("md5=");
            int k = str.indexOf(";", n);
            int j = k;
            if (k == -1) {
              j = str.length();
            }
            if ((n != -1) && (j > n)) {
              return str.substring("md5=".length() + n, j);
            }
          }
          i += 1;
        }
      }
    }
    
    public String d()
    {
      if ((this.a == null) || (this.a.length == 0)) {
        return this.b;
      }
      String[] arrayOfString = this.a;
      int j = arrayOfString.length;
      Object localObject1 = "";
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        Object localObject2;
        if (str.startsWith("Set-Cookie:"))
        {
          localObject2 = localObject1;
          if (str.contains("md5=")) {}
        }
        else if (str.startsWith("Cookie:"))
        {
          localObject2 = localObject1;
          if (str.contains("md5=")) {}
        }
        else
        {
          localObject2 = (String)localObject1 + str + "\r\n";
        }
        i += 1;
        localObject1 = localObject2;
      }
      return (String)localObject1 + "\r\n";
    }
    
    public int e()
    {
      int k = -1;
      int j = k;
      if (this.a != null)
      {
        j = k;
        if (this.a.length <= 0) {}
      }
      try
      {
        String[] arrayOfString = this.a;
        int m = arrayOfString.length;
        int i = 0;
        for (;;)
        {
          j = k;
          if (i < m)
          {
            String str = arrayOfString[i];
            if (str.startsWith("Content-Length:")) {
              j = Integer.parseInt(str.substring("Content-Length:".length(), str.length()).trim());
            }
          }
          else
          {
            return j;
          }
          i += 1;
        }
        return -1;
      }
      catch (Exception localException) {}
    }
    
    public boolean f()
    {
      if ((this.a == null) || (this.a.length <= 0)) {}
      label63:
      for (;;)
      {
        return false;
        String[] arrayOfString = this.a;
        int j = arrayOfString.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label63;
          }
          String str = arrayOfString[i];
          if (str.startsWith("HTTP/1."))
          {
            if (!str.contains("200")) {
              break;
            }
            return true;
          }
          i += 1;
        }
      }
    }
    
    public boolean g()
    {
      return (f()) && (!TextUtils.isEmpty(c()));
    }
  }
  
  static class c
  {
    public a a = a.a;
    public String b;
    public int c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public String i;
    public String j;
    public String k;
    public long l;
    public String m;
    
    c()
    {
      String str = Build.VERSION.RELEASE.replaceAll("|", "_").replaceAll("#", "_").replace("*", "_");
      this.b = (a.e() + "," + a.d() + "," + str);
      this.c = 0;
      this.d = 0L;
      this.e = 0L;
      this.f = 0L;
      this.g = 0L;
      this.h = 0L;
      this.i = "";
      this.j = "0.0.0.0";
      this.k = n.e();
      this.l = 0L;
      this.m = "0,0";
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      localStringBuilder.append(this.a).append(":").append(5).append("|").append(this.i).append("|").append(this.j).append("|").append(this.k).append("|").append(this.l).append("|").append(this.m).append("|").append(this.e).append("|").append(this.d).append("|").append(this.f).append("|").append(this.c).append("|").append(this.b).append("|").append(this.g).append("|").append(this.h).append("#");
      return localStringBuilder.toString();
    }
    
    public static enum a
    {
      public static a a(String paramString)
      {
        return (a)Enum.valueOf(a.class, paramString);
      }
      
      public static a[] a()
      {
        return (a[])b.clone();
      }
    }
  }
  
  static class d
  {
    public String A;
    public long B = 0L;
    public String C;
    public long D = 0L;
    public int E = 0;
    public int F = 0;
    public int G = 0;
    public ArrayList H = new ArrayList();
    public ArrayList I = new ArrayList();
    public String J;
    public String K = "0.0.0.0";
    public long L = 0L;
    public long M = 0L;
    public int N = 0;
    public String O = "";
    public int P = 0;
    public String Q = "";
    public b a = b.a;
    public a b = a.a;
    public Map c = new HashMap();
    public InetAddress d;
    public InetAddress e;
    public int f = 0;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public int p = 0;
    public int q = 0;
    public int r = 0;
    public long s = 0L;
    public long t = 0L;
    ArrayList u;
    ArrayList v;
    public long w = 0L;
    public boolean x = false;
    ArrayList y;
    public long z;
    
    public String toString()
    {
      Object localObject1;
      label79:
      Object localObject3;
      label108:
      Object localObject4;
      if ((this.b == a.a) && (this.c.isEmpty()))
      {
        localObject1 = this.b;
        localObject1 = a.a.toString();
        if ((this.r != 5) && (this.r != 6)) {
          break label377;
        }
        if (this.J != null) {
          break label346;
        }
        localObject2 = "0|" + "0.0.0.0|";
        if (this.C != null)
        {
          localObject3 = localObject2;
          if (!this.C.isEmpty()) {}
        }
        else
        {
          this.C = this.J;
          localObject3 = localObject2;
        }
        localObject2 = "";
        localObject4 = localObject2;
        if (this.y == null) {
          break label559;
        }
        localObject4 = localObject2;
        if (this.y.size() == 0) {
          break label559;
        }
        i1 = 0;
        label137:
        localObject4 = localObject2;
        if (i1 >= this.y.size()) {
          break label559;
        }
        if (i1 == this.y.size() - 1) {
          break label529;
        }
      }
      label346:
      label377:
      label387:
      label480:
      label513:
      label529:
      for (Object localObject2 = (String)localObject2 + this.y.get(i1) + ",";; localObject2 = (String)localObject2 + this.y.get(i1))
      {
        i1 += 1;
        break label137;
        if ((this.c == null) || (this.c.isEmpty()))
        {
          localObject1 = this.b;
          localObject1 = a.b.toString();
          break;
        }
        localObject3 = this.c.entrySet().iterator();
        for (localObject2 = "";; localObject2 = (String)localObject2 + ((a)localObject4).toString() + ":" + i1 + ";")
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (Map.Entry)((Iterator)localObject3).next();
          localObject4 = (a)((Map.Entry)localObject1).getKey();
          i1 = ((Integer)((Map.Entry)localObject1).getValue()).intValue();
        }
        localObject2 = "0|" + this.J + "|";
        break label79;
        if (this.d == null)
        {
          localObject2 = "0.0.0.0|";
          if (this.e != null) {
            break label480;
          }
        }
        for (localObject2 = (String)localObject2 + "0.0.0.0|";; localObject2 = (String)localObject2 + this.e.getHostAddress() + "|")
        {
          if (this.C != null)
          {
            localObject3 = localObject2;
            if (!this.C.isEmpty()) {
              break;
            }
          }
          if (this.e != null) {
            break label513;
          }
          this.C = "0.0.0.0";
          localObject3 = localObject2;
          break;
          localObject2 = this.d.getHostAddress() + "|";
          break label387;
        }
        this.C = this.e.getHostAddress();
        localObject3 = localObject2;
        break label108;
      }
      label559:
      localObject2 = "";
      Object localObject5 = localObject2;
      if (this.u != null)
      {
        localObject5 = localObject2;
        if (this.u.size() != 0)
        {
          i1 = 0;
          localObject5 = localObject2;
          if (i1 < this.u.size())
          {
            if (i1 != this.u.size() - 1) {}
            for (localObject2 = (String)localObject2 + this.u.get(i1) + ",";; localObject2 = (String)localObject2 + this.u.get(i1))
            {
              i1 += 1;
              break;
            }
          }
        }
      }
      if (this.x) {}
      for (String str1 = this.A; this.a == b.a; str1 = "false") {
        return "" + (String)localObject1 + "|" + (String)localObject3 + this.f + "|" + this.K + "|" + this.L + "|" + this.M + "|" + this.N + "|" + this.O + "|" + this.P + "|" + this.Q + "|" + this.C + "|" + this.D + "|" + this.E + "|" + this.F + "|" + this.G + "|" + this.g + "|" + this.l + "|" + this.m + "|" + this.H.toString().replace("[", "").replace("]", "") + "|" + this.I.toString().replace("[", "").replace("]", "") + "|" + this.n + "|" + this.o + "|" + this.p + "|" + this.q + "|" + this.r + "|" + this.s + "|" + this.t + "|" + (String)localObject5 + "|" + this.w + "|" + str1 + "|" + (String)localObject4 + "|" + this.z + "|" + this.h + "," + this.i + "," + this.j;
      }
      int i1 = Math.min(this.l, this.m);
      String str2;
      if (i1 > 0)
      {
        str2 = Integer.toString(this.k / i1);
        String str3 = "";
        localObject2 = str3;
        if (this.v == null) {
          break label1332;
        }
        localObject2 = str3;
        if (this.v.size() == 0) {
          break label1332;
        }
        localObject2 = "";
        i1 = 0;
        label1227:
        if (i1 >= this.v.size()) {
          break label1332;
        }
        if (i1 == this.v.size() - 1) {
          break label1302;
        }
      }
      label1302:
      for (localObject2 = (String)localObject2 + this.v.get(i1) + ",";; localObject2 = (String)localObject2 + this.v.get(i1))
      {
        i1 += 1;
        break label1227;
        str2 = "0";
        break;
      }
      label1332:
      return "" + this.a + "|" + (String)localObject1 + "|" + (String)localObject3 + this.f + "|" + this.g + "|" + str2 + "|" + this.l + "|" + this.m + "|" + this.n + "|" + this.o + "|" + (String)localObject2 + "|" + this.p + "|" + this.q + "|" + this.r + "|" + this.s + "|" + this.t + "|" + (String)localObject5 + "|" + this.w + "|" + str1 + "|" + (String)localObject4 + "|" + this.z + "|" + this.h + "," + this.i + "," + this.j;
    }
    
    public static enum a
    {
      public static a a(String paramString)
      {
        return (a)Enum.valueOf(a.class, paramString);
      }
      
      public static a[] a()
      {
        return (a[])B.clone();
      }
    }
    
    public static enum b
    {
      public static b a(String paramString)
      {
        return (b)Enum.valueOf(b.class, paramString);
      }
      
      public static b[] a()
      {
        return (b[])c.clone();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\net\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */