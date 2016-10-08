package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.b;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class q
{
  private static q b;
  public Map<String, String> a = null;
  private Context c;
  
  private q(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public static q a(Context paramContext)
  {
    if (b == null) {
      b = new q(paramContext);
    }
    return b;
  }
  
  private static HttpURLConnection a(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new URL(paramString2);
      if ((paramString1 != null) && (paramString1.toLowerCase(Locale.US).contains("wap"))) {
        paramString1 = new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")));
      }
      for (paramString1 = (HttpURLConnection)paramString2.openConnection(new Proxy(Proxy.Type.HTTP, paramString1));; paramString1 = (HttpURLConnection)paramString2.openConnection())
      {
        paramString1.setConnectTimeout(30000);
        paramString1.setReadTimeout(10000);
        paramString1.setDoOutput(true);
        paramString1.setDoInput(true);
        paramString1.setRequestMethod("POST");
        paramString1.setUseCaches(false);
        paramString1.setInstanceFollowRedirects(false);
        return paramString1;
      }
      return null;
    }
    catch (Throwable paramString1)
    {
      if (!v.a(paramString1)) {
        paramString1.printStackTrace();
      }
    }
  }
  
  private HttpURLConnection a(String paramString1, byte[] paramArrayOfByte, String paramString2, Map<String, String> paramMap)
  {
    if (paramString1 == null)
    {
      v.e("destUrl is null.", new Object[0]);
      return null;
    }
    paramString1 = a(paramString2, paramString1);
    if (paramString1 == null)
    {
      v.e("Failed to get HttpURLConnection object.", new Object[0]);
      return null;
    }
    try
    {
      paramString1.setRequestProperty("wup_version", "3.0");
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          paramString1.setRequestProperty((String)localEntry.getKey(), URLEncoder.encode((String)localEntry.getValue(), "utf-8"));
        }
      }
      paramString1.setRequestProperty("A37", URLEncoder.encode(paramString2, "utf-8"));
    }
    catch (Throwable paramString1)
    {
      if (!v.a(paramString1)) {
        paramString1.printStackTrace();
      }
      v.e("Failed to upload crash, please check your network.", new Object[0]);
      return null;
    }
    paramString1.setRequestProperty("A38", URLEncoder.encode(b.e(this.c), "utf-8"));
    paramString1.connect();
    paramString2 = paramString1.getOutputStream();
    if (paramArrayOfByte == null) {
      paramString2.write(0);
    } else {
      paramString2.write(paramArrayOfByte);
    }
    return paramString1;
  }
  
  private static Map<String, String> a(HttpURLConnection paramHttpURLConnection)
  {
    HashMap localHashMap = new HashMap();
    paramHttpURLConnection = paramHttpURLConnection.getHeaderFields();
    if ((paramHttpURLConnection == null) || (paramHttpURLConnection.size() == 0)) {
      return null;
    }
    Iterator localIterator = paramHttpURLConnection.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      List localList = (List)paramHttpURLConnection.get(str);
      if (localList.size() > 0) {
        localHashMap.put(str, localList.get(0));
      }
    }
    return localHashMap;
  }
  
  /* Error */
  private static byte[] b(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 244	java/io/BufferedInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokevirtual 248	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   14: invokespecial 251	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_1
    //   18: aload_1
    //   19: astore_0
    //   20: new 253	java/io/ByteArrayOutputStream
    //   23: dup
    //   24: invokespecial 254	java/io/ByteArrayOutputStream:<init>	()V
    //   27: astore_2
    //   28: aload_1
    //   29: astore_0
    //   30: sipush 1024
    //   33: newarray <illegal type>
    //   35: astore_3
    //   36: aload_1
    //   37: astore_0
    //   38: aload_1
    //   39: aload_3
    //   40: invokevirtual 258	java/io/BufferedInputStream:read	([B)I
    //   43: istore 4
    //   45: iload 4
    //   47: ifle +49 -> 96
    //   50: aload_1
    //   51: astore_0
    //   52: aload_2
    //   53: aload_3
    //   54: iconst_0
    //   55: iload 4
    //   57: invokevirtual 261	java/io/ByteArrayOutputStream:write	([BII)V
    //   60: goto -24 -> 36
    //   63: astore_2
    //   64: aload_1
    //   65: astore_0
    //   66: aload_2
    //   67: invokestatic 123	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   70: ifne +9 -> 79
    //   73: aload_1
    //   74: astore_0
    //   75: aload_2
    //   76: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   79: aload_1
    //   80: ifnull -76 -> 4
    //   83: aload_1
    //   84: invokevirtual 264	java/io/BufferedInputStream:close	()V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   94: aconst_null
    //   95: areturn
    //   96: aload_1
    //   97: astore_0
    //   98: aload_2
    //   99: invokevirtual 267	java/io/ByteArrayOutputStream:flush	()V
    //   102: aload_1
    //   103: astore_0
    //   104: aload_2
    //   105: invokevirtual 271	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   108: astore_2
    //   109: aload_1
    //   110: invokevirtual 264	java/io/BufferedInputStream:close	()V
    //   113: aload_2
    //   114: areturn
    //   115: astore_0
    //   116: aload_0
    //   117: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   120: aload_2
    //   121: areturn
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 264	java/io/BufferedInputStream:close	()V
    //   133: aload_1
    //   134: athrow
    //   135: astore_0
    //   136: aload_0
    //   137: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   140: goto -7 -> 133
    //   143: astore_1
    //   144: goto -19 -> 125
    //   147: astore_2
    //   148: aconst_null
    //   149: astore_1
    //   150: goto -86 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramHttpURLConnection	HttpURLConnection
    //   17	93	1	localBufferedInputStream	java.io.BufferedInputStream
    //   122	12	1	localObject1	Object
    //   143	1	1	localObject2	Object
    //   149	1	1	localObject3	Object
    //   27	26	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   63	42	2	localThrowable1	Throwable
    //   108	13	2	arrayOfByte1	byte[]
    //   147	1	2	localThrowable2	Throwable
    //   35	19	3	arrayOfByte2	byte[]
    //   43	13	4	i	int
    // Exception table:
    //   from	to	target	type
    //   20	28	63	java/lang/Throwable
    //   30	36	63	java/lang/Throwable
    //   38	45	63	java/lang/Throwable
    //   52	60	63	java/lang/Throwable
    //   98	102	63	java/lang/Throwable
    //   104	109	63	java/lang/Throwable
    //   83	87	89	java/lang/Throwable
    //   109	113	115	java/lang/Throwable
    //   6	18	122	finally
    //   129	133	135	java/lang/Throwable
    //   20	28	143	finally
    //   30	36	143	finally
    //   38	45	143	finally
    //   52	60	143	finally
    //   66	73	143	finally
    //   75	79	143	finally
    //   98	102	143	finally
    //   104	109	143	finally
    //   6	18	147	java/lang/Throwable
  }
  
  /* Error */
  public final byte[] a(String paramString, byte[] paramArrayOfByte, t paramt, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +16 -> 17
    //   4: ldc_w 276
    //   7: iconst_0
    //   8: anewarray 4	java/lang/Object
    //   11: invokestatic 133	com/tencent/bugly/proguard/v:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   14: pop
    //   15: aconst_null
    //   16: areturn
    //   17: iconst_0
    //   18: istore 8
    //   20: aload_2
    //   21: ifnonnull +114 -> 135
    //   24: lconst_0
    //   25: lstore 17
    //   27: ldc_w 278
    //   30: iconst_4
    //   31: anewarray 4	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: aload_1
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: lload 17
    //   42: invokestatic 284	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   45: aastore
    //   46: dup
    //   47: iconst_2
    //   48: invokestatic 289	android/os/Process:myPid	()I
    //   51: invokestatic 292	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: aastore
    //   55: dup
    //   56: iconst_3
    //   57: invokestatic 295	android/os/Process:myTid	()I
    //   60: invokestatic 292	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   63: aastore
    //   64: invokestatic 297	com/tencent/bugly/proguard/v:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   67: pop
    //   68: iconst_0
    //   69: istore 13
    //   71: iconst_0
    //   72: istore 10
    //   74: iload 10
    //   76: iconst_1
    //   77: iadd
    //   78: istore 9
    //   80: iload 10
    //   82: iconst_2
    //   83: if_icmpge +817 -> 900
    //   86: iload 8
    //   88: ifgt +812 -> 900
    //   91: iload 13
    //   93: ifeq +50 -> 143
    //   96: iconst_0
    //   97: istore 10
    //   99: aload_0
    //   100: getfield 20	com/tencent/bugly/proguard/q:c	Landroid/content/Context;
    //   103: invokestatic 198	com/tencent/bugly/crashreport/common/info/b:e	(Landroid/content/Context;)Ljava/lang/String;
    //   106: astore 5
    //   108: aload 5
    //   110: ifnonnull +100 -> 210
    //   113: ldc_w 299
    //   116: iconst_0
    //   117: anewarray 4	java/lang/Object
    //   120: invokestatic 302	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   123: pop
    //   124: iload 10
    //   126: istore 13
    //   128: iload 9
    //   130: istore 10
    //   132: goto -58 -> 74
    //   135: aload_2
    //   136: arraylength
    //   137: i2l
    //   138: lstore 17
    //   140: goto -113 -> 27
    //   143: iload 13
    //   145: istore 10
    //   147: iload 9
    //   149: iconst_1
    //   150: if_icmple -51 -> 99
    //   153: new 304	java/lang/StringBuilder
    //   156: dup
    //   157: ldc_w 306
    //   160: invokespecial 307	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: iload 9
    //   165: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: iconst_0
    //   172: anewarray 4	java/lang/Object
    //   175: invokestatic 297	com/tencent/bugly/proguard/v:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   178: pop
    //   179: new 317	java/util/Random
    //   182: dup
    //   183: invokestatic 321	java/lang/System:currentTimeMillis	()J
    //   186: invokespecial 324	java/util/Random:<init>	(J)V
    //   189: sipush 10000
    //   192: invokevirtual 328	java/util/Random:nextInt	(I)I
    //   195: i2l
    //   196: ldc2_w 329
    //   199: ladd
    //   200: invokestatic 335	android/os/SystemClock:sleep	(J)V
    //   203: iload 13
    //   205: istore 10
    //   207: goto -108 -> 99
    //   210: aload_3
    //   211: lload 17
    //   213: invokevirtual 339	com/tencent/bugly/proguard/t:a	(J)V
    //   216: aload_0
    //   217: aload_1
    //   218: aload_2
    //   219: aload 5
    //   221: aload 4
    //   223: invokespecial 341	com/tencent/bugly/proguard/q:a	(Ljava/lang/String;[BLjava/lang/String;Ljava/util/Map;)Ljava/net/HttpURLConnection;
    //   226: astore 7
    //   228: aload 7
    //   230: ifnull +640 -> 870
    //   233: iload 10
    //   235: istore 13
    //   237: iload 8
    //   239: istore 14
    //   241: iload 9
    //   243: istore 15
    //   245: aload_1
    //   246: astore 6
    //   248: aload 7
    //   250: invokevirtual 344	java/net/HttpURLConnection:getResponseCode	()I
    //   253: istore 16
    //   255: iload 16
    //   257: sipush 200
    //   260: if_icmpne +129 -> 389
    //   263: iload 10
    //   265: istore 13
    //   267: iload 8
    //   269: istore 14
    //   271: iload 9
    //   273: istore 15
    //   275: aload_1
    //   276: astore 6
    //   278: aload_0
    //   279: aload 7
    //   281: invokestatic 346	com/tencent/bugly/proguard/q:a	(Ljava/net/HttpURLConnection;)Ljava/util/Map;
    //   284: putfield 18	com/tencent/bugly/proguard/q:a	Ljava/util/Map;
    //   287: iload 10
    //   289: istore 13
    //   291: iload 8
    //   293: istore 14
    //   295: iload 9
    //   297: istore 15
    //   299: aload_1
    //   300: astore 6
    //   302: aload 7
    //   304: invokestatic 348	com/tencent/bugly/proguard/q:b	(Ljava/net/HttpURLConnection;)[B
    //   307: astore 5
    //   309: aload 5
    //   311: ifnonnull +35 -> 346
    //   314: lconst_0
    //   315: lstore 19
    //   317: iload 10
    //   319: istore 13
    //   321: iload 8
    //   323: istore 14
    //   325: iload 9
    //   327: istore 15
    //   329: aload_1
    //   330: astore 6
    //   332: aload_3
    //   333: lload 19
    //   335: invokevirtual 350	com/tencent/bugly/proguard/t:b	(J)V
    //   338: aload 7
    //   340: invokevirtual 353	java/net/HttpURLConnection:disconnect	()V
    //   343: aload 5
    //   345: areturn
    //   346: iload 10
    //   348: istore 13
    //   350: iload 8
    //   352: istore 14
    //   354: iload 9
    //   356: istore 15
    //   358: aload_1
    //   359: astore 6
    //   361: aload 5
    //   363: arraylength
    //   364: istore 11
    //   366: iload 11
    //   368: i2l
    //   369: lstore 19
    //   371: goto -54 -> 317
    //   374: astore_1
    //   375: aload_1
    //   376: invokestatic 123	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   379: ifne -36 -> 343
    //   382: aload_1
    //   383: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   386: goto -43 -> 343
    //   389: iload 16
    //   391: sipush 301
    //   394: if_icmpeq +27 -> 421
    //   397: iload 16
    //   399: sipush 302
    //   402: if_icmpeq +19 -> 421
    //   405: iload 16
    //   407: sipush 303
    //   410: if_icmpeq +11 -> 421
    //   413: iload 16
    //   415: sipush 307
    //   418: if_icmpne +80 -> 498
    //   421: iconst_1
    //   422: istore 13
    //   424: iload 10
    //   426: istore 12
    //   428: iload 8
    //   430: istore 11
    //   432: iload 9
    //   434: istore 10
    //   436: aload_1
    //   437: astore 5
    //   439: iload 13
    //   441: ifeq +121 -> 562
    //   444: aload 7
    //   446: ldc_w 355
    //   449: invokevirtual 358	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   452: astore 5
    //   454: aload 5
    //   456: ifnonnull +63 -> 519
    //   459: new 304	java/lang/StringBuilder
    //   462: dup
    //   463: ldc_w 360
    //   466: invokespecial 307	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   469: iload 16
    //   471: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   474: ldc_w 362
    //   477: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: iconst_0
    //   484: anewarray 4	java/lang/Object
    //   487: invokestatic 133	com/tencent/bugly/proguard/v:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   490: pop
    //   491: aload 7
    //   493: invokevirtual 353	java/net/HttpURLConnection:disconnect	()V
    //   496: aconst_null
    //   497: areturn
    //   498: iconst_0
    //   499: istore 13
    //   501: goto -77 -> 424
    //   504: astore_1
    //   505: aload_1
    //   506: invokestatic 123	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   509: ifne -13 -> 496
    //   512: aload_1
    //   513: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   516: goto -20 -> 496
    //   519: iload 8
    //   521: iconst_1
    //   522: iadd
    //   523: istore 8
    //   525: iconst_0
    //   526: istore 11
    //   528: iconst_0
    //   529: istore 10
    //   531: ldc_w 367
    //   534: iconst_2
    //   535: anewarray 4	java/lang/Object
    //   538: dup
    //   539: iconst_0
    //   540: iload 16
    //   542: invokestatic 292	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   545: aastore
    //   546: dup
    //   547: iconst_1
    //   548: aload 5
    //   550: aastore
    //   551: invokestatic 297	com/tencent/bugly/proguard/v:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   554: pop
    //   555: iconst_1
    //   556: istore 12
    //   558: iload 8
    //   560: istore 11
    //   562: iload 12
    //   564: istore 13
    //   566: iload 11
    //   568: istore 14
    //   570: iload 10
    //   572: istore 15
    //   574: aload 5
    //   576: astore 6
    //   578: new 304	java/lang/StringBuilder
    //   581: dup
    //   582: ldc_w 369
    //   585: invokespecial 307	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   588: iload 16
    //   590: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   593: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: iconst_0
    //   597: anewarray 4	java/lang/Object
    //   600: invokestatic 302	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   603: pop
    //   604: iload 12
    //   606: istore 13
    //   608: iload 11
    //   610: istore 14
    //   612: iload 10
    //   614: istore 15
    //   616: aload 5
    //   618: astore 6
    //   620: aload 7
    //   622: invokevirtual 372	java/net/HttpURLConnection:getContentLength	()I
    //   625: i2l
    //   626: lstore 21
    //   628: lload 21
    //   630: lstore 19
    //   632: lload 21
    //   634: lconst_0
    //   635: lcmp
    //   636: ifge +6 -> 642
    //   639: lconst_0
    //   640: lstore 19
    //   642: iload 12
    //   644: istore 13
    //   646: iload 11
    //   648: istore 14
    //   650: iload 10
    //   652: istore 15
    //   654: aload 5
    //   656: astore 6
    //   658: aload_3
    //   659: lload 19
    //   661: invokevirtual 350	com/tencent/bugly/proguard/t:b	(J)V
    //   664: aload 7
    //   666: invokevirtual 353	java/net/HttpURLConnection:disconnect	()V
    //   669: aload 5
    //   671: astore 6
    //   673: iload 10
    //   675: istore 9
    //   677: iload 11
    //   679: istore 14
    //   681: iload 12
    //   683: istore 13
    //   685: iload 14
    //   687: istore 8
    //   689: aload 6
    //   691: astore_1
    //   692: iload 9
    //   694: istore 10
    //   696: goto -622 -> 74
    //   699: astore_1
    //   700: iload 12
    //   702: istore 13
    //   704: iload 11
    //   706: istore 14
    //   708: iload 10
    //   710: istore 9
    //   712: aload 5
    //   714: astore 6
    //   716: aload_1
    //   717: invokestatic 123	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   720: ifne -35 -> 685
    //   723: aload_1
    //   724: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   727: iload 12
    //   729: istore 13
    //   731: iload 11
    //   733: istore 14
    //   735: iload 10
    //   737: istore 9
    //   739: aload 5
    //   741: astore 6
    //   743: goto -58 -> 685
    //   746: astore 5
    //   748: aload 6
    //   750: astore_1
    //   751: iload 15
    //   753: istore 11
    //   755: iload 14
    //   757: istore 8
    //   759: iload 13
    //   761: istore 10
    //   763: aload 5
    //   765: invokestatic 123	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   768: ifne +8 -> 776
    //   771: aload 5
    //   773: invokevirtual 373	java/io/IOException:printStackTrace	()V
    //   776: aload 7
    //   778: invokevirtual 353	java/net/HttpURLConnection:disconnect	()V
    //   781: iload 10
    //   783: istore 13
    //   785: iload 8
    //   787: istore 14
    //   789: iload 11
    //   791: istore 9
    //   793: aload_1
    //   794: astore 6
    //   796: goto -111 -> 685
    //   799: astore 5
    //   801: iload 10
    //   803: istore 13
    //   805: iload 8
    //   807: istore 14
    //   809: iload 11
    //   811: istore 9
    //   813: aload_1
    //   814: astore 6
    //   816: aload 5
    //   818: invokestatic 123	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   821: ifne -136 -> 685
    //   824: aload 5
    //   826: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   829: iload 10
    //   831: istore 13
    //   833: iload 8
    //   835: istore 14
    //   837: iload 11
    //   839: istore 9
    //   841: aload_1
    //   842: astore 6
    //   844: goto -159 -> 685
    //   847: astore_1
    //   848: aload 7
    //   850: invokevirtual 353	java/net/HttpURLConnection:disconnect	()V
    //   853: aload_1
    //   854: athrow
    //   855: astore_2
    //   856: aload_2
    //   857: invokestatic 123	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   860: ifne -7 -> 853
    //   863: aload_2
    //   864: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   867: goto -14 -> 853
    //   870: ldc_w 375
    //   873: iconst_0
    //   874: anewarray 4	java/lang/Object
    //   877: invokestatic 297	com/tencent/bugly/proguard/v:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   880: pop
    //   881: aload_3
    //   882: lconst_0
    //   883: invokevirtual 350	com/tencent/bugly/proguard/t:b	(J)V
    //   886: iload 10
    //   888: istore 13
    //   890: iload 8
    //   892: istore 14
    //   894: aload_1
    //   895: astore 6
    //   897: goto -212 -> 685
    //   900: aconst_null
    //   901: areturn
    //   902: astore 5
    //   904: iconst_1
    //   905: istore 10
    //   907: iload 9
    //   909: istore 11
    //   911: goto -148 -> 763
    //   914: astore 6
    //   916: aload 5
    //   918: astore_1
    //   919: aload 6
    //   921: astore 5
    //   923: iconst_1
    //   924: istore 10
    //   926: goto -163 -> 763
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	929	0	this	q
    //   0	929	1	paramString	String
    //   0	929	2	paramArrayOfByte	byte[]
    //   0	929	3	paramt	t
    //   0	929	4	paramMap	Map<String, String>
    //   106	634	5	localObject1	Object
    //   746	26	5	localIOException1	java.io.IOException
    //   799	26	5	localThrowable	Throwable
    //   902	15	5	localIOException2	java.io.IOException
    //   921	1	5	localObject2	Object
    //   246	650	6	localObject3	Object
    //   914	6	6	localIOException3	java.io.IOException
    //   226	623	7	localHttpURLConnection	HttpURLConnection
    //   18	873	8	i	int
    //   78	830	9	j	int
    //   72	853	10	k	int
    //   364	546	11	m	int
    //   426	302	12	n	int
    //   69	820	13	i1	int
    //   239	654	14	i2	int
    //   243	509	15	i3	int
    //   253	336	16	i4	int
    //   25	187	17	l1	long
    //   315	345	19	l2	long
    //   626	7	21	l3	long
    // Exception table:
    //   from	to	target	type
    //   338	343	374	java/lang/Throwable
    //   491	496	504	java/lang/Throwable
    //   664	669	699	java/lang/Throwable
    //   248	255	746	java/io/IOException
    //   278	287	746	java/io/IOException
    //   302	309	746	java/io/IOException
    //   332	338	746	java/io/IOException
    //   361	366	746	java/io/IOException
    //   578	604	746	java/io/IOException
    //   620	628	746	java/io/IOException
    //   658	664	746	java/io/IOException
    //   776	781	799	java/lang/Throwable
    //   248	255	847	finally
    //   278	287	847	finally
    //   302	309	847	finally
    //   332	338	847	finally
    //   361	366	847	finally
    //   444	454	847	finally
    //   459	491	847	finally
    //   531	555	847	finally
    //   578	604	847	finally
    //   620	628	847	finally
    //   658	664	847	finally
    //   763	776	847	finally
    //   848	853	855	java/lang/Throwable
    //   444	454	902	java/io/IOException
    //   459	491	902	java/io/IOException
    //   531	555	914	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\proguard\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */