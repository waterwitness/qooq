package com.tencent.mobileqq.msf.core.net;

class o
  extends Thread
{
  o(h paramh) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   4: iconst_0
    //   5: putfield 23	com/tencent/mobileqq/msf/core/net/h:D	I
    //   8: aload_0
    //   9: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   12: iconst_0
    //   13: putfield 27	com/tencent/mobileqq/msf/core/net/h:E	Z
    //   16: ldc 29
    //   18: invokevirtual 35	java/lang/String:getBytes	()[B
    //   21: astore_3
    //   22: sipush 128
    //   25: newarray <illegal type>
    //   27: astore 5
    //   29: aconst_null
    //   30: astore_2
    //   31: aconst_null
    //   32: astore 4
    //   34: aload_2
    //   35: astore_1
    //   36: new 37	java/net/URL
    //   39: dup
    //   40: ldc 39
    //   42: invokespecial 42	java/net/URL:<init>	(Ljava/lang/String;)V
    //   45: astore 6
    //   47: aload_2
    //   48: astore_1
    //   49: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   52: lstore 9
    //   54: aload_2
    //   55: astore_1
    //   56: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +13 -> 72
    //   62: aload_2
    //   63: astore_1
    //   64: ldc 56
    //   66: iconst_2
    //   67: ldc 58
    //   69: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_2
    //   73: astore_1
    //   74: aload 6
    //   76: invokevirtual 66	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   79: checkcast 68	java/net/HttpURLConnection
    //   82: astore_2
    //   83: aload_2
    //   84: iconst_1
    //   85: invokevirtual 72	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   88: aload_2
    //   89: ldc 74
    //   91: invokevirtual 77	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   94: aload_2
    //   95: sipush 10000
    //   98: invokevirtual 81	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   101: aload_2
    //   102: sipush 10000
    //   105: invokevirtual 84	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   108: aload_2
    //   109: invokevirtual 88	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   112: aload_3
    //   113: invokevirtual 94	java/io/OutputStream:write	([B)V
    //   116: aload_2
    //   117: invokevirtual 88	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   120: invokevirtual 97	java/io/OutputStream:flush	()V
    //   123: aload_2
    //   124: invokevirtual 88	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   127: invokevirtual 100	java/io/OutputStream:close	()V
    //   130: aload_2
    //   131: invokevirtual 104	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   134: aload 5
    //   136: invokevirtual 110	java/io/InputStream:read	([B)I
    //   139: istore 7
    //   141: aload_2
    //   142: invokevirtual 114	java/net/HttpURLConnection:getResponseCode	()I
    //   145: istore 8
    //   147: iload 8
    //   149: sipush 200
    //   152: if_icmpne +113 -> 265
    //   155: aload 6
    //   157: invokevirtual 118	java/net/URL:getHost	()Ljava/lang/String;
    //   160: aload_2
    //   161: invokevirtual 122	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   164: invokevirtual 118	java/net/URL:getHost	()Ljava/lang/String;
    //   167: invokevirtual 126	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   170: ifeq +95 -> 265
    //   173: ldc 56
    //   175: iconst_1
    //   176: new 128	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   183: ldc -125
    //   185: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: iload 8
    //   190: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: ldc -116
    //   195: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   201: lload 9
    //   203: lsub
    //   204: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   207: ldc -111
    //   209: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: iload 7
    //   214: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aload_0
    //   224: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   227: iload 8
    //   229: putfield 23	com/tencent/mobileqq/msf/core/net/h:D	I
    //   232: aload_0
    //   233: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   236: iconst_1
    //   237: putfield 27	com/tencent/mobileqq/msf/core/net/h:E	Z
    //   240: aload_2
    //   241: ifnull +7 -> 248
    //   244: aload_2
    //   245: invokevirtual 151	java/net/HttpURLConnection:disconnect	()V
    //   248: aload_0
    //   249: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   252: astore_1
    //   253: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   256: lstore 9
    //   258: aload_1
    //   259: lload 9
    //   261: putfield 155	com/tencent/mobileqq/msf/core/net/h:G	J
    //   264: return
    //   265: new 128	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   272: ldc -99
    //   274: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: iload 8
    //   279: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: pop
    //   286: ldc 56
    //   288: iconst_1
    //   289: new 128	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   296: ldc -97
    //   298: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: iload 8
    //   303: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   306: ldc -111
    //   308: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: iload 7
    //   313: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   316: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   322: goto -82 -> 240
    //   325: astore_3
    //   326: aload_2
    //   327: astore_1
    //   328: aload_3
    //   329: invokevirtual 160	java/lang/Throwable:toString	()Ljava/lang/String;
    //   332: astore 4
    //   334: aload_2
    //   335: astore_1
    //   336: aload_0
    //   337: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   340: iconst_0
    //   341: putfield 23	com/tencent/mobileqq/msf/core/net/h:D	I
    //   344: aload_2
    //   345: astore_1
    //   346: aload_0
    //   347: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   350: iconst_0
    //   351: putfield 27	com/tencent/mobileqq/msf/core/net/h:E	Z
    //   354: aload_2
    //   355: astore_1
    //   356: ldc 56
    //   358: iconst_1
    //   359: new 128	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   366: ldc -94
    //   368: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload 4
    //   373: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: aload_3
    //   380: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   383: aload_2
    //   384: ifnull +7 -> 391
    //   387: aload_2
    //   388: invokevirtual 151	java/net/HttpURLConnection:disconnect	()V
    //   391: aload_0
    //   392: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   395: astore_1
    //   396: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   399: lstore 9
    //   401: goto -143 -> 258
    //   404: astore_3
    //   405: aload_1
    //   406: astore_2
    //   407: aload_3
    //   408: astore_1
    //   409: aload_2
    //   410: ifnull +7 -> 417
    //   413: aload_2
    //   414: invokevirtual 151	java/net/HttpURLConnection:disconnect	()V
    //   417: aload_0
    //   418: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   421: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   424: putfield 155	com/tencent/mobileqq/msf/core/net/h:G	J
    //   427: aload_1
    //   428: athrow
    //   429: astore_1
    //   430: goto -21 -> 409
    //   433: astore_3
    //   434: aload 4
    //   436: astore_2
    //   437: goto -111 -> 326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	o
    //   35	393	1	localObject1	Object
    //   429	1	1	localObject2	Object
    //   30	407	2	localObject3	Object
    //   21	92	3	arrayOfByte1	byte[]
    //   325	55	3	localThrowable1	Throwable
    //   404	4	3	localObject4	Object
    //   433	1	3	localThrowable2	Throwable
    //   32	403	4	str	String
    //   27	108	5	arrayOfByte2	byte[]
    //   45	111	6	localURL	java.net.URL
    //   139	173	7	i	int
    //   145	157	8	j	int
    //   52	348	9	l	long
    // Exception table:
    //   from	to	target	type
    //   83	147	325	java/lang/Throwable
    //   155	240	325	java/lang/Throwable
    //   265	322	325	java/lang/Throwable
    //   36	47	404	finally
    //   49	54	404	finally
    //   56	62	404	finally
    //   64	72	404	finally
    //   74	83	404	finally
    //   328	334	404	finally
    //   336	344	404	finally
    //   346	354	404	finally
    //   356	383	404	finally
    //   83	147	429	finally
    //   155	240	429	finally
    //   265	322	429	finally
    //   36	47	433	java/lang/Throwable
    //   49	54	433	java/lang/Throwable
    //   56	62	433	java/lang/Throwable
    //   64	72	433	java/lang/Throwable
    //   74	83	433	java/lang/Throwable
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\net\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */