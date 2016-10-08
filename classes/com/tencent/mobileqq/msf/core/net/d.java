package com.tencent.mobileqq.msf.core.net;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.quicksend.f;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class d
{
  private static final String a = "LightHttpEngine";
  private String b;
  private URL c;
  private int d = 10000;
  private int e = 30000;
  private int f;
  private HttpURLConnection g;
  private int h;
  private String i;
  
  public d(int paramInt)
  {
    this.f = paramInt;
  }
  
  private String a(String paramString)
  {
    if (NetConnInfoCenterImpl.getSystemNetworkType() == 0) {
      return q.m.toString();
    }
    if (paramString.indexOf("illegal") > -1) {
      return q.g.toString();
    }
    if (paramString.indexOf("route to host") > -1) {
      return q.q.toString();
    }
    if (paramString.indexOf("unreachable") > -1) {
      return q.m.toString();
    }
    if (paramString.indexOf("permission") > -1) {
      return q.i.toString();
    }
    if (paramString.indexOf("refused") > -1) {
      return q.s.toString();
    }
    if (paramString.indexOf("reset") > -1) {
      return q.r.toString();
    }
    if ((paramString.indexOf("timeoutexception") > -1) || (paramString.indexOf(") after") > -1)) {
      return q.t.toString();
    }
    if (paramString.indexOf("unknownhost") > -1) {
      return q.p.toString();
    }
    if (paramString.indexOf("unresolved") > -1) {
      return q.o.toString();
    }
    if (paramString.indexOf("enotsock") > -1) {
      return q.h.toString();
    }
    if (paramString.indexOf("enobufs") > -1) {
      return q.l.toString();
    }
    if (paramString.indexOf("ebadf") > -1) {
      return q.j.toString();
    }
    if (paramString.indexOf("operation") > -1) {
      return q.t.toString();
    }
    if (paramString.indexOf("invalid") > -1) {
      return q.n.toString();
    }
    return q.u.toString();
  }
  
  private String b(String paramString)
  {
    Object localObject = new Random(System.currentTimeMillis());
    localObject = "r=" + String.valueOf(((Random)localObject).nextInt(100000));
    if (paramString.contains("?"))
    {
      if (paramString.endsWith("?")) {
        return paramString + (String)localObject;
      }
      return (String)localObject + "&" + (String)localObject;
    }
    return "?" + (String)localObject;
  }
  
  public void a()
  {
    QLog.d("LightHttpEngine", 1, "LightHttpEngine disconn " + this.b + " ssoseq:" + this.f);
    if (this.g != null)
    {
      this.g.disconnect();
      this.g = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, f paramf)
  {
    long l2 = 0L;
    long l1 = l2;
    try
    {
      this.e = a.Z();
      l1 = l2;
      paramString1 = "http://" + paramString1 + ":" + paramInt;
      l1 = l2;
      this.b = (paramString1 + b(paramString1));
      l1 = l2;
      this.b = MsfSdkUtils.insertMtype(paramString2, this.b);
      l1 = l2;
      QLog.d("LightHttpEngine", 1, "LightHttpEngine try connect " + this.b + " timeout:" + this.d + " ssoseq:" + this.f);
      l1 = l2;
      l2 = SystemClock.elapsedRealtime();
      l1 = l2;
      System.setProperty("http.keepAlive", "false");
      l1 = l2;
      this.c = new URL(this.b);
      l1 = l2;
      this.g = ((HttpURLConnection)this.c.openConnection());
      l1 = l2;
      this.g.setDoOutput(true);
      l1 = l2;
      this.g.setDoInput(true);
      l1 = l2;
      this.g.setUseCaches(false);
      l1 = l2;
      this.g.setReadTimeout(this.e);
      l1 = l2;
      this.g.setRequestMethod("POST");
      l1 = l2;
      this.g.setRequestProperty("User-Agent", "aqq");
      l1 = l2;
      this.g.setRequestProperty("content-type", "oct");
      l1 = l2;
      this.g.setConnectTimeout(this.d);
      l1 = l2;
      this.g.setRequestProperty("Connection", "close");
      l1 = l2;
      this.g.setRequestProperty("Accept-Encoding", "");
      l1 = l2;
      this.g.connect();
      l1 = l2;
      long l3 = SystemClock.elapsedRealtime();
      l1 = l2;
      QLog.d("LightHttpEngine", 1, "LightHttpEngine connect " + this.b + " succ costtime:" + (l3 - l2) + " ssoseq:" + this.f + " readTimeout:" + this.e);
      return true;
    }
    catch (Throwable paramString1)
    {
      l2 = SystemClock.elapsedRealtime();
    }
    try
    {
      if (this.g != null) {
        this.g.disconnect();
      }
      paramString1.printStackTrace();
      paramString1 = a(paramString1.toString().toLowerCase());
      paramString2 = new StringBuilder(paramf.l);
      paramString2.append("|").append(paramString1);
      paramf.l = paramString2.toString();
      QLog.d("LightHttpEngine", 1, "LightHttpEngine connect " + this.b + " fail costtime:" + (l2 - l1) + " ssoseq:" + this.f + " reason:" + paramString1);
      return false;
    }
    catch (Throwable paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
  }
  
  /* Error */
  public byte[] a(byte[] paramArrayOfByte, f paramf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: lconst_0
    //   7: lstore 12
    //   9: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   12: lstore 14
    //   14: lload 14
    //   16: lstore 12
    //   18: aload_0
    //   19: getfield 178	com/tencent/mobileqq/msf/core/net/d:g	Ljava/net/HttpURLConnection;
    //   22: invokevirtual 308	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   25: astore_3
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 314	java/io/OutputStream:write	([B)V
    //   31: aload_3
    //   32: invokevirtual 317	java/io/OutputStream:flush	()V
    //   35: ldc 8
    //   37: iconst_1
    //   38: new 133	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 319
    //   48: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_0
    //   52: getfield 30	com/tencent/mobileqq/msf/core/net/d:f	I
    //   55: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: ldc_w 321
    //   61: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: arraylength
    //   66: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: aload_0
    //   76: aload_0
    //   77: getfield 178	com/tencent/mobileqq/msf/core/net/d:g	Ljava/net/HttpURLConnection;
    //   80: invokevirtual 324	java/net/HttpURLConnection:getResponseCode	()I
    //   83: putfield 326	com/tencent/mobileqq/msf/core/net/d:h	I
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 178	com/tencent/mobileqq/msf/core/net/d:g	Ljava/net/HttpURLConnection;
    //   91: invokevirtual 330	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   94: invokevirtual 333	java/net/URL:getHost	()Ljava/lang/String;
    //   97: putfield 335	com/tencent/mobileqq/msf/core/net/d:i	Ljava/lang/String;
    //   100: aload_0
    //   101: getfield 178	com/tencent/mobileqq/msf/core/net/d:g	Ljava/net/HttpURLConnection;
    //   104: invokevirtual 339	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   107: astore_1
    //   108: aload_1
    //   109: astore 5
    //   111: aload_3
    //   112: astore 4
    //   114: new 341	java/io/BufferedInputStream
    //   117: dup
    //   118: aload_1
    //   119: invokespecial 344	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   122: astore 6
    //   124: aload_1
    //   125: astore 5
    //   127: aload_3
    //   128: astore 4
    //   130: new 346	org/apache/http/util/ByteArrayBuffer
    //   133: dup
    //   134: sipush 1024
    //   137: invokespecial 348	org/apache/http/util/ByteArrayBuffer:<init>	(I)V
    //   140: astore 9
    //   142: aload_1
    //   143: astore 5
    //   145: aload_3
    //   146: astore 4
    //   148: bipush 50
    //   150: newarray <illegal type>
    //   152: astore 10
    //   154: aload_1
    //   155: astore 5
    //   157: aload_3
    //   158: astore 4
    //   160: aload 6
    //   162: aload 10
    //   164: invokevirtual 352	java/io/BufferedInputStream:read	([B)I
    //   167: istore 11
    //   169: iload 11
    //   171: iconst_m1
    //   172: if_icmpne +115 -> 287
    //   175: aload_1
    //   176: astore 5
    //   178: aload_3
    //   179: astore 4
    //   181: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   184: lstore 12
    //   186: aload_1
    //   187: astore 5
    //   189: aload_3
    //   190: astore 4
    //   192: ldc 8
    //   194: iconst_1
    //   195: new 133	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 354
    //   205: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_0
    //   209: getfield 30	com/tencent/mobileqq/msf/core/net/d:f	I
    //   212: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: ldc_w 321
    //   218: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 9
    //   223: invokevirtual 357	org/apache/http/util/ByteArrayBuffer:length	()I
    //   226: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   229: ldc_w 359
    //   232: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: lload 12
    //   237: lload 14
    //   239: lsub
    //   240: invokevirtual 281	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   243: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload_1
    //   250: astore 5
    //   252: aload_3
    //   253: astore 4
    //   255: aload 9
    //   257: invokevirtual 363	org/apache/http/util/ByteArrayBuffer:toByteArray	()[B
    //   260: astore 6
    //   262: aload 6
    //   264: astore_2
    //   265: aload_3
    //   266: ifnull +7 -> 273
    //   269: aload_3
    //   270: invokevirtual 365	java/io/OutputStream:close	()V
    //   273: aload_2
    //   274: astore_3
    //   275: aload_1
    //   276: ifnull +9 -> 285
    //   279: aload_1
    //   280: invokevirtual 368	java/io/InputStream:close	()V
    //   283: aload_2
    //   284: astore_3
    //   285: aload_3
    //   286: areturn
    //   287: aload_1
    //   288: astore 5
    //   290: aload_3
    //   291: astore 4
    //   293: aload 9
    //   295: aload 10
    //   297: iconst_0
    //   298: iload 11
    //   300: invokevirtual 371	org/apache/http/util/ByteArrayBuffer:append	([BII)V
    //   303: goto -149 -> 154
    //   306: astore 6
    //   308: lload 14
    //   310: lstore 12
    //   312: aload_1
    //   313: astore 5
    //   315: aload_3
    //   316: astore 4
    //   318: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   321: lstore 14
    //   323: aload_1
    //   324: astore 5
    //   326: aload_3
    //   327: astore 4
    //   329: aload 6
    //   331: invokevirtual 286	java/lang/Throwable:printStackTrace	()V
    //   334: aload_1
    //   335: astore 5
    //   337: aload_3
    //   338: astore 4
    //   340: aload_2
    //   341: aload 6
    //   343: invokevirtual 287	java/lang/Throwable:toString	()Ljava/lang/String;
    //   346: putfield 373	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   349: aload_1
    //   350: astore 5
    //   352: aload_3
    //   353: astore 4
    //   355: ldc 8
    //   357: iconst_1
    //   358: new 133	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   365: ldc_w 375
    //   368: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload_0
    //   372: getfield 30	com/tencent/mobileqq/msf/core/net/d:f	I
    //   375: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   378: ldc_w 359
    //   381: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: lload 14
    //   386: lload 12
    //   388: lsub
    //   389: invokevirtual 281	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   392: ldc_w 303
    //   395: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload 6
    //   400: invokevirtual 287	java/lang/Throwable:toString	()Ljava/lang/String;
    //   403: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: aload_3
    //   413: ifnull +7 -> 420
    //   416: aload_3
    //   417: invokevirtual 365	java/io/OutputStream:close	()V
    //   420: aload 8
    //   422: astore_3
    //   423: aload_1
    //   424: ifnull -139 -> 285
    //   427: aload_1
    //   428: invokevirtual 368	java/io/InputStream:close	()V
    //   431: aconst_null
    //   432: areturn
    //   433: astore_1
    //   434: aload 7
    //   436: astore_2
    //   437: aload_1
    //   438: invokevirtual 286	java/lang/Throwable:printStackTrace	()V
    //   441: aload_2
    //   442: areturn
    //   443: astore_1
    //   444: aconst_null
    //   445: astore 5
    //   447: aconst_null
    //   448: astore_3
    //   449: aload_3
    //   450: ifnull +7 -> 457
    //   453: aload_3
    //   454: invokevirtual 365	java/io/OutputStream:close	()V
    //   457: aload 5
    //   459: ifnull +8 -> 467
    //   462: aload 5
    //   464: invokevirtual 368	java/io/InputStream:close	()V
    //   467: aload_1
    //   468: athrow
    //   469: astore_2
    //   470: aload_2
    //   471: invokevirtual 286	java/lang/Throwable:printStackTrace	()V
    //   474: goto -7 -> 467
    //   477: astore_1
    //   478: goto -41 -> 437
    //   481: astore_1
    //   482: goto -45 -> 437
    //   485: astore_1
    //   486: aconst_null
    //   487: astore 5
    //   489: goto -40 -> 449
    //   492: astore_1
    //   493: aload 4
    //   495: astore_3
    //   496: goto -47 -> 449
    //   499: astore 6
    //   501: aconst_null
    //   502: astore_1
    //   503: aconst_null
    //   504: astore_3
    //   505: goto -193 -> 312
    //   508: astore 6
    //   510: aconst_null
    //   511: astore_1
    //   512: lload 14
    //   514: lstore 12
    //   516: goto -204 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	this	d
    //   0	519	1	paramArrayOfByte	byte[]
    //   0	519	2	paramf	f
    //   25	480	3	localObject1	Object
    //   112	382	4	localObject2	Object
    //   109	379	5	arrayOfByte1	byte[]
    //   122	141	6	localObject3	Object
    //   306	93	6	localThrowable1	Throwable
    //   499	1	6	localThrowable2	Throwable
    //   508	1	6	localThrowable3	Throwable
    //   1	434	7	localObject4	Object
    //   4	417	8	localObject5	Object
    //   140	154	9	localByteArrayBuffer	org.apache.http.util.ByteArrayBuffer
    //   152	144	10	arrayOfByte2	byte[]
    //   167	132	11	j	int
    //   7	508	12	l1	long
    //   12	501	14	l2	long
    // Exception table:
    //   from	to	target	type
    //   114	124	306	java/lang/Throwable
    //   130	142	306	java/lang/Throwable
    //   148	154	306	java/lang/Throwable
    //   160	169	306	java/lang/Throwable
    //   181	186	306	java/lang/Throwable
    //   192	249	306	java/lang/Throwable
    //   255	262	306	java/lang/Throwable
    //   293	303	306	java/lang/Throwable
    //   416	420	433	java/lang/Throwable
    //   427	431	433	java/lang/Throwable
    //   9	14	443	finally
    //   18	26	443	finally
    //   453	457	469	java/lang/Throwable
    //   462	467	469	java/lang/Throwable
    //   269	273	477	java/lang/Throwable
    //   279	283	481	java/lang/Throwable
    //   26	108	485	finally
    //   114	124	492	finally
    //   130	142	492	finally
    //   148	154	492	finally
    //   160	169	492	finally
    //   181	186	492	finally
    //   192	249	492	finally
    //   255	262	492	finally
    //   293	303	492	finally
    //   318	323	492	finally
    //   329	334	492	finally
    //   340	349	492	finally
    //   355	412	492	finally
    //   9	14	499	java/lang/Throwable
    //   18	26	499	java/lang/Throwable
    //   26	108	508	java/lang/Throwable
  }
  
  public void b()
  {
    this.b = null;
    this.c = null;
    this.d = 10000;
    this.g = null;
    this.h = 0;
    this.i = null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\net\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */