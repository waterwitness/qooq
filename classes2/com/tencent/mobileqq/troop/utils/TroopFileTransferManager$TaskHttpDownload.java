package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TroopFileTransferManager$TaskHttpDownload
  extends TroopFileTransferManager.Task
{
  public TroopFileTransferManager$TaskHttpDownload(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem)
  {
    super(paramTroopFileTransferManager, paramItem, 3);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Boolean = true;
  }
  
  /* Error */
  private java.net.HttpURLConnection a(String paramString1, long paramLong1, long paramLong2, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 32	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   7: lload_2
    //   8: invokevirtual 39	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11: ldc 41
    //   13: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: astore 9
    //   21: new 32	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   28: aload_1
    //   29: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 50
    //   34: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: lload_2
    //   38: invokevirtual 39	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   41: ldc 52
    //   43: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore 8
    //   51: aload_0
    //   52: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   55: aload 8
    //   57: putfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:downUrlStr4Report	Ljava/lang/String;
    //   60: aload_0
    //   61: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   64: invokestatic 67	java/lang/System:currentTimeMillis	()J
    //   67: putfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
    //   70: new 73	java/net/URL
    //   73: dup
    //   74: aload 8
    //   76: invokespecial 76	java/net/URL:<init>	(Ljava/lang/String;)V
    //   79: astore_1
    //   80: aload_1
    //   81: invokevirtual 80	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   84: checkcast 82	java/net/HttpURLConnection
    //   87: astore 6
    //   89: aload 6
    //   91: ifnonnull +30 -> 121
    //   94: aconst_null
    //   95: astore_1
    //   96: aload_1
    //   97: areturn
    //   98: astore_1
    //   99: iload 7
    //   101: ifeq +18 -> 119
    //   104: aload_0
    //   105: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   108: aload_0
    //   109: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   112: bipush 10
    //   114: bipush 102
    //   116: invokevirtual 87	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   119: aconst_null
    //   120: areturn
    //   121: aload 6
    //   123: sipush 30000
    //   126: invokevirtual 91	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   129: aload 6
    //   131: sipush 30000
    //   134: invokevirtual 94	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   137: aload 6
    //   139: ldc 96
    //   141: invokevirtual 99	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   144: aload 6
    //   146: ldc 101
    //   148: ldc 103
    //   150: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: lload 4
    //   155: lconst_0
    //   156: lcmp
    //   157: ifeq +30 -> 187
    //   160: aload 6
    //   162: ldc 109
    //   164: new 32	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   171: ldc 111
    //   173: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 9
    //   178: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload 6
    //   189: ldc 113
    //   191: ldc 115
    //   193: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload 6
    //   198: astore_1
    //   199: aload 6
    //   201: invokevirtual 119	java/net/HttpURLConnection:getResponseCode	()I
    //   204: sipush 200
    //   207: if_icmpeq -111 -> 96
    //   210: aload 6
    //   212: astore_1
    //   213: aload 6
    //   215: invokevirtual 119	java/net/HttpURLConnection:getResponseCode	()I
    //   218: sipush 206
    //   221: if_icmpeq -125 -> 96
    //   224: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +32 -> 259
    //   230: ldc 127
    //   232: iconst_2
    //   233: new 32	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   240: ldc -127
    //   242: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload 6
    //   247: invokevirtual 119	java/net/HttpURLConnection:getResponseCode	()I
    //   250: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: aconst_null
    //   260: areturn
    //   261: astore_1
    //   262: aload_1
    //   263: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   266: aconst_null
    //   267: areturn
    //   268: astore_1
    //   269: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +41 -> 313
    //   275: ldc 127
    //   277: iconst_2
    //   278: new 32	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   285: ldc -115
    //   287: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 8
    //   292: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc -113
    //   297: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload_1
    //   301: invokevirtual 146	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   304: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aconst_null
    //   314: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	TaskHttpDownload
    //   0	315	1	paramString1	String
    //   0	315	2	paramLong1	long
    //   0	315	4	paramLong2	long
    //   0	315	6	paramString2	String
    //   0	315	7	paramBoolean	boolean
    //   49	242	8	str1	String
    //   19	158	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   70	80	98	java/net/MalformedURLException
    //   80	89	261	java/io/IOException
    //   121	153	261	java/io/IOException
    //   160	187	261	java/io/IOException
    //   187	196	261	java/io/IOException
    //   199	210	261	java/io/IOException
    //   213	259	261	java/io/IOException
    //   80	89	268	java/lang/NullPointerException
    //   121	153	268	java/lang/NullPointerException
    //   160	187	268	java/lang/NullPointerException
    //   187	196	268	java/lang/NullPointerException
    //   199	210	268	java/lang/NullPointerException
    //   213	259	268	java/lang/NullPointerException
  }
  
  /* Error */
  private java.net.HttpURLConnection a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4, String paramString5, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 32	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   7: lload 4
    //   9: invokevirtual 39	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12: ldc 41
    //   14: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: lload 6
    //   19: lconst_1
    //   20: lsub
    //   21: invokevirtual 39	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   24: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore 11
    //   29: lload 4
    //   31: lconst_0
    //   32: lcmp
    //   33: ifne +92 -> 125
    //   36: new 32	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   43: ldc -107
    //   45: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc -105
    //   54: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_2
    //   58: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc -103
    //   63: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_3
    //   67: invokestatic 158	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   70: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload 9
    //   75: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   86: aload_1
    //   87: putfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:downUrlStr4Report	Ljava/lang/String;
    //   90: aload_0
    //   91: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   94: invokestatic 67	java/lang/System:currentTimeMillis	()J
    //   97: putfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
    //   100: new 73	java/net/URL
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 76	java/net/URL:<init>	(Ljava/lang/String;)V
    //   108: astore_2
    //   109: aload_2
    //   110: invokevirtual 80	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   113: checkcast 82	java/net/HttpURLConnection
    //   116: astore_3
    //   117: aload_3
    //   118: ifnonnull +89 -> 207
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_2
    //   124: areturn
    //   125: new 32	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   132: ldc -107
    //   134: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc -105
    //   143: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_2
    //   147: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc -103
    //   152: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_3
    //   156: invokestatic 158	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   159: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc -96
    //   164: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 11
    //   169: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 9
    //   174: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: astore_1
    //   181: goto -99 -> 82
    //   184: astore_1
    //   185: iload 10
    //   187: ifeq +18 -> 205
    //   190: aload_0
    //   191: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   194: aload_0
    //   195: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   198: bipush 10
    //   200: bipush 102
    //   202: invokevirtual 87	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   205: aconst_null
    //   206: areturn
    //   207: aload_3
    //   208: sipush 30000
    //   211: invokevirtual 91	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   214: aload_3
    //   215: sipush 30000
    //   218: invokevirtual 94	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   221: aload_3
    //   222: ldc 96
    //   224: invokevirtual 99	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   227: aload_3
    //   228: ldc 101
    //   230: ldc -94
    //   232: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: lload 6
    //   237: lconst_0
    //   238: lcmp
    //   239: ifeq +29 -> 268
    //   242: aload_3
    //   243: ldc 109
    //   245: new 32	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   252: ldc 111
    //   254: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload 11
    //   259: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload_3
    //   269: ldc 113
    //   271: ldc 115
    //   273: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload_3
    //   277: ldc -92
    //   279: new 32	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   286: ldc -90
    //   288: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload 8
    //   293: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   302: aload_3
    //   303: astore_2
    //   304: aload_3
    //   305: invokevirtual 119	java/net/HttpURLConnection:getResponseCode	()I
    //   308: sipush 200
    //   311: if_icmpeq -188 -> 123
    //   314: aload_3
    //   315: astore_2
    //   316: aload_3
    //   317: invokevirtual 119	java/net/HttpURLConnection:getResponseCode	()I
    //   320: sipush 206
    //   323: if_icmpeq -200 -> 123
    //   326: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +31 -> 360
    //   332: ldc 127
    //   334: iconst_2
    //   335: new 32	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   342: ldc -127
    //   344: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_3
    //   348: invokevirtual 119	java/net/HttpURLConnection:getResponseCode	()I
    //   351: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: aconst_null
    //   361: areturn
    //   362: astore_1
    //   363: aload_1
    //   364: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   367: aconst_null
    //   368: areturn
    //   369: astore_2
    //   370: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   373: ifeq +40 -> 413
    //   376: ldc 127
    //   378: iconst_2
    //   379: new 32	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   386: ldc -115
    //   388: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload_1
    //   392: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: ldc -113
    //   397: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload_2
    //   401: invokevirtual 146	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   404: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   413: aconst_null
    //   414: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	this	TaskHttpDownload
    //   0	415	1	paramString1	String
    //   0	415	2	paramString2	String
    //   0	415	3	paramString3	String
    //   0	415	4	paramLong1	long
    //   0	415	6	paramLong2	long
    //   0	415	8	paramString4	String
    //   0	415	9	paramString5	String
    //   0	415	10	paramBoolean	boolean
    //   27	231	11	str	String
    // Exception table:
    //   from	to	target	type
    //   100	109	184	java/net/MalformedURLException
    //   109	117	362	java/io/IOException
    //   207	235	362	java/io/IOException
    //   242	268	362	java/io/IOException
    //   268	302	362	java/io/IOException
    //   304	314	362	java/io/IOException
    //   316	360	362	java/io/IOException
    //   109	117	369	java/lang/NullPointerException
    //   207	235	369	java/lang/NullPointerException
    //   242	268	369	java/lang/NullPointerException
    //   268	302	369	java/lang/NullPointerException
    //   304	314	369	java/lang/NullPointerException
    //   316	360	369	java/lang/NullPointerException
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   4: aload_0
    //   5: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   8: invokevirtual 174	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: invokestatic 177	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   18: ifeq +11 -> 29
    //   21: ldc 127
    //   23: iconst_4
    //   24: ldc -77
    //   26: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: invokestatic 186	com/tencent/open/appcommon/Common:a	()Z
    //   32: ifne +20 -> 52
    //   35: aload_0
    //   36: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   39: aload_0
    //   40: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   43: bipush 10
    //   45: sipush 308
    //   48: invokevirtual 87	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   51: return
    //   52: new 188	java/io/File
    //   55: dup
    //   56: getstatic 193	com/tencent/mobileqq/app/AppConstants:by	Ljava/lang/String;
    //   59: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 197	java/io/File:exists	()Z
    //   67: ifne +8 -> 75
    //   70: aload_1
    //   71: invokevirtual 200	java/io/File:mkdirs	()Z
    //   74: pop
    //   75: aload_0
    //   76: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   79: new 32	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   86: getstatic 193	com/tencent/mobileqq/app/AppConstants:by	Ljava/lang/String;
    //   89: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   96: getfield 203	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   99: invokevirtual 209	java/lang/String:getBytes	()[B
    //   102: invokestatic 212	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   105: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc -42
    //   110: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: putfield 217	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:TmpFile	Ljava/lang/String;
    //   119: new 188	java/io/File
    //   122: dup
    //   123: aload_0
    //   124: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   127: getfield 217	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:TmpFile	Ljava/lang/String;
    //   130: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   133: astore 4
    //   135: aload 4
    //   137: invokevirtual 197	java/io/File:exists	()Z
    //   140: ifne +9 -> 149
    //   143: aload 4
    //   145: invokevirtual 220	java/io/File:createNewFile	()Z
    //   148: pop
    //   149: aload_0
    //   150: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   153: aload 4
    //   155: invokevirtual 223	java/io/File:length	()J
    //   158: putfield 226	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   161: iconst_0
    //   162: istore 7
    //   164: aload_0
    //   165: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   168: iconst_0
    //   169: putfield 230	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   172: iload 7
    //   174: istore 6
    //   176: aload_0
    //   177: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   180: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   183: aload_0
    //   184: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   187: getfield 226	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   190: lcmp
    //   191: ifgt +19 -> 210
    //   194: aload_0
    //   195: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   198: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   201: lconst_0
    //   202: lcmp
    //   203: ifne +25 -> 228
    //   206: iload 7
    //   208: istore 6
    //   210: aload_0
    //   211: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   214: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   217: aload_0
    //   218: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   221: getfield 226	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   224: lcmp
    //   225: ifne +304 -> 529
    //   228: aload_0
    //   229: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   232: getfield 236	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   235: invokevirtual 238	java/lang/String:length	()I
    //   238: bipush 85
    //   240: if_icmple +69 -> 309
    //   243: aload_0
    //   244: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   247: getfield 236	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   250: bipush 46
    //   252: invokevirtual 242	java/lang/String:lastIndexOf	(I)I
    //   255: istore 7
    //   257: iload 7
    //   259: istore 6
    //   261: iload 7
    //   263: ifge +6 -> 269
    //   266: iconst_0
    //   267: istore 6
    //   269: aload_0
    //   270: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   273: getfield 236	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   276: invokevirtual 238	java/lang/String:length	()I
    //   279: bipush 85
    //   281: isub
    //   282: istore 7
    //   284: iload 6
    //   286: ifne +1335 -> 1621
    //   289: aload_0
    //   290: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   293: aload_0
    //   294: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   297: getfield 236	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   300: iconst_0
    //   301: bipush 85
    //   303: invokevirtual 246	java/lang/String:substring	(II)Ljava/lang/String;
    //   306: putfield 236	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   309: aload_0
    //   310: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   313: getfield 236	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   316: astore_2
    //   317: aload_2
    //   318: astore_1
    //   319: aload_0
    //   320: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   323: getfield 249	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:NameForSave	Ljava/lang/String;
    //   326: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   329: ifne +24 -> 353
    //   332: aload_2
    //   333: astore_1
    //   334: aload_0
    //   335: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   338: getfield 258	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:SafeCheckRes	I
    //   341: iconst_2
    //   342: if_icmpne +11 -> 353
    //   345: aload_0
    //   346: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   349: getfield 249	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:NameForSave	Ljava/lang/String;
    //   352: astore_1
    //   353: iconst_0
    //   354: istore 6
    //   356: iload 6
    //   358: sipush 1000
    //   361: if_icmpge +1356 -> 1717
    //   364: iload 6
    //   366: ifle +1318 -> 1684
    //   369: aload_1
    //   370: bipush 46
    //   372: invokevirtual 242	java/lang/String:lastIndexOf	(I)I
    //   375: istore 8
    //   377: iload 8
    //   379: istore 7
    //   381: iload 8
    //   383: ifge +6 -> 389
    //   386: iconst_0
    //   387: istore 7
    //   389: new 32	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   396: getstatic 261	com/tencent/mobileqq/app/AppConstants:bv	Ljava/lang/String;
    //   399: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_1
    //   403: iconst_0
    //   404: iload 7
    //   406: invokevirtual 246	java/lang/String:substring	(II)Ljava/lang/String;
    //   409: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: ldc_w 263
    //   415: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: iload 6
    //   420: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   423: ldc_w 265
    //   426: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_1
    //   430: iload 7
    //   432: invokevirtual 268	java/lang/String:substring	(I)Ljava/lang/String;
    //   435: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: astore_2
    //   442: new 188	java/io/File
    //   445: dup
    //   446: aload_2
    //   447: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   450: astore_3
    //   451: aload_3
    //   452: invokevirtual 197	java/io/File:exists	()Z
    //   455: ifne +1253 -> 1708
    //   458: aload 4
    //   460: aload_3
    //   461: invokevirtual 272	java/io/File:renameTo	(Ljava/io/File;)Z
    //   464: ifeq +1244 -> 1708
    //   467: aload_0
    //   468: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   471: aload_2
    //   472: putfield 275	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   475: aload_0
    //   476: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   479: aload_0
    //   480: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   483: bipush 11
    //   485: invokevirtual 278	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   488: aload_0
    //   489: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   492: aload_0
    //   493: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   496: aload_0
    //   497: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   500: getfield 281	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   503: invokevirtual 285	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   506: iconst_0
    //   507: invokevirtual 288	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;Z)V
    //   510: return
    //   511: astore_1
    //   512: aload_0
    //   513: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   516: aload_0
    //   517: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   520: bipush 10
    //   522: sipush 303
    //   525: invokevirtual 87	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   528: return
    //   529: iload 6
    //   531: iconst_3
    //   532: if_icmplt +57 -> 589
    //   535: aload_0
    //   536: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   539: aload_0
    //   540: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   543: bipush 10
    //   545: bipush 105
    //   547: invokevirtual 87	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   550: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   553: ifeq -539 -> 14
    //   556: ldc 127
    //   558: iconst_2
    //   559: new 32	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   566: ldc_w 290
    //   569: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload_0
    //   573: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   576: getfield 293	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   579: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   588: return
    //   589: iload 6
    //   591: ifle +103 -> 694
    //   594: invokestatic 299	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   597: invokestatic 305	com/tencent/mobileqq/utils/NetworkUtil:h	(Landroid/content/Context;)Z
    //   600: ifne +19 -> 619
    //   603: aload_0
    //   604: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   607: aload_0
    //   608: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   611: bipush 10
    //   613: bipush 106
    //   615: invokevirtual 87	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   618: return
    //   619: iconst_0
    //   620: istore 7
    //   622: iload 7
    //   624: iload 6
    //   626: bipush 100
    //   628: imul
    //   629: if_icmpge +65 -> 694
    //   632: ldc2_w 306
    //   635: invokestatic 313	java/lang/Thread:sleep	(J)V
    //   638: aload_0
    //   639: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   642: aload_0
    //   643: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   646: invokevirtual 174	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   649: ifne -635 -> 14
    //   652: invokestatic 299	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   655: invokestatic 305	com/tencent/mobileqq/utils/NetworkUtil:h	(Landroid/content/Context;)Z
    //   658: ifne +27 -> 685
    //   661: aload_0
    //   662: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   665: aload_0
    //   666: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   669: bipush 10
    //   671: bipush 106
    //   673: invokevirtual 87	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   676: return
    //   677: astore_1
    //   678: aload_1
    //   679: invokevirtual 314	java/lang/InterruptedException:printStackTrace	()V
    //   682: goto -44 -> 638
    //   685: iload 7
    //   687: iconst_1
    //   688: iadd
    //   689: istore 7
    //   691: goto -69 -> 622
    //   694: aload_0
    //   695: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   698: aload_0
    //   699: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   702: invokevirtual 174	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   705: ifne -691 -> 14
    //   708: iload 6
    //   710: iconst_1
    //   711: iadd
    //   712: istore 6
    //   714: aload_0
    //   715: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   718: iload 6
    //   720: putfield 230	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   723: aconst_null
    //   724: astore_3
    //   725: aconst_null
    //   726: astore_2
    //   727: aload_3
    //   728: astore_1
    //   729: aload_0
    //   730: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   733: invokevirtual 317	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   736: ifnull +224 -> 960
    //   739: aload_3
    //   740: astore_1
    //   741: aload_0
    //   742: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   745: getfield 320	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isZipInnerFile	Z
    //   748: ifne +212 -> 960
    //   751: aload_0
    //   752: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   755: invokevirtual 317	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   758: iconst_5
    //   759: invokeinterface 326 2 0
    //   764: astore 5
    //   766: aload_3
    //   767: astore_1
    //   768: aload 5
    //   770: ifnull +190 -> 960
    //   773: aload_3
    //   774: astore_1
    //   775: aload 5
    //   777: invokeinterface 330 1 0
    //   782: ifne +178 -> 960
    //   785: aload 5
    //   787: invokeinterface 334 1 0
    //   792: astore_3
    //   793: aload_2
    //   794: astore_1
    //   795: aload_3
    //   796: invokeinterface 339 1 0
    //   801: ifeq +159 -> 960
    //   804: aload_3
    //   805: invokeinterface 343 1 0
    //   810: checkcast 345	mqq/manager/ProxyIpManager$ProxyIp
    //   813: astore_1
    //   814: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   817: ifeq +36 -> 853
    //   820: ldc 127
    //   822: iconst_2
    //   823: ldc_w 347
    //   826: iconst_2
    //   827: anewarray 349	java/lang/Object
    //   830: dup
    //   831: iconst_0
    //   832: aload_1
    //   833: getfield 352	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   836: aastore
    //   837: dup
    //   838: iconst_1
    //   839: aload_1
    //   840: getfield 355	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   843: invokestatic 361	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   846: aastore
    //   847: invokestatic 365	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   850: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   853: ldc_w 367
    //   856: iconst_2
    //   857: anewarray 349	java/lang/Object
    //   860: dup
    //   861: iconst_0
    //   862: aload_0
    //   863: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   866: getfield 293	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   869: aastore
    //   870: dup
    //   871: iconst_1
    //   872: bipush 80
    //   874: invokestatic 361	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   877: aastore
    //   878: invokestatic 365	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   881: astore_2
    //   882: aload_0
    //   883: aload_1
    //   884: getfield 352	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   887: aload_0
    //   888: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   891: getfield 370	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   894: aload_0
    //   895: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   898: getfield 203	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   901: aload_0
    //   902: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   905: getfield 226	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   908: aload_0
    //   909: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   912: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   915: aload_0
    //   916: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   919: getfield 373	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   922: aload_2
    //   923: iconst_0
    //   924: invokespecial 375	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Z)Ljava/net/HttpURLConnection;
    //   927: astore_2
    //   928: aload_2
    //   929: astore_1
    //   930: aload_2
    //   931: ifnull -136 -> 795
    //   934: aload_2
    //   935: astore_1
    //   936: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   939: ifeq +21 -> 960
    //   942: ldc 127
    //   944: iconst_2
    //   945: ldc_w 377
    //   948: iconst_0
    //   949: anewarray 349	java/lang/Object
    //   952: invokestatic 365	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   955: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   958: aload_2
    //   959: astore_1
    //   960: aload_1
    //   961: astore_2
    //   962: aload_1
    //   963: ifnonnull +210 -> 1173
    //   966: aload_0
    //   967: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   970: getfield 320	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isZipInnerFile	Z
    //   973: ifeq +120 -> 1093
    //   976: aload_0
    //   977: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   980: getfield 380	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:PreviewUrl	Ljava/lang/String;
    //   983: ifnull +110 -> 1093
    //   986: aload_0
    //   987: aload_0
    //   988: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   991: getfield 380	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:PreviewUrl	Ljava/lang/String;
    //   994: aload_0
    //   995: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   998: getfield 226	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1001: aload_0
    //   1002: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1005: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1008: aload_0
    //   1009: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1012: getfield 373	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   1015: iconst_0
    //   1016: invokespecial 382	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;JJLjava/lang/String;Z)Ljava/net/HttpURLConnection;
    //   1019: astore_1
    //   1020: aload_1
    //   1021: ifnonnull +126 -> 1147
    //   1024: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1027: ifeq +731 -> 1758
    //   1030: new 32	java/lang/StringBuilder
    //   1033: dup
    //   1034: ldc_w 384
    //   1037: invokespecial 385	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1040: astore_1
    //   1041: aload_1
    //   1042: iload 6
    //   1044: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1047: ldc_w 387
    //   1050: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: aload_0
    //   1054: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1057: getfield 293	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   1060: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: ldc_w 389
    //   1066: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: aload_0
    //   1070: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1073: getfield 370	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   1076: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1079: pop
    //   1080: ldc 127
    //   1082: iconst_2
    //   1083: aload_1
    //   1084: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1087: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1090: goto -880 -> 210
    //   1093: aload_0
    //   1094: aload_0
    //   1095: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1098: getfield 293	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   1101: aload_0
    //   1102: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1105: getfield 370	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   1108: aload_0
    //   1109: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1112: getfield 203	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   1115: aload_0
    //   1116: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1119: getfield 226	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1122: aload_0
    //   1123: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1126: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1129: aload_0
    //   1130: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1133: getfield 373	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   1136: ldc_w 391
    //   1139: iconst_1
    //   1140: invokespecial 375	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Z)Ljava/net/HttpURLConnection;
    //   1143: astore_1
    //   1144: goto -124 -> 1020
    //   1147: aload_1
    //   1148: astore_2
    //   1149: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1152: ifeq +21 -> 1173
    //   1155: ldc 127
    //   1157: iconst_2
    //   1158: ldc_w 393
    //   1161: iconst_0
    //   1162: anewarray 349	java/lang/Object
    //   1165: invokestatic 365	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1168: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1171: aload_1
    //   1172: astore_2
    //   1173: iload 6
    //   1175: istore 7
    //   1177: aload_2
    //   1178: invokevirtual 397	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1181: astore_3
    //   1182: iload 6
    //   1184: istore 7
    //   1186: aload_0
    //   1187: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1190: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1193: lconst_0
    //   1194: lcmp
    //   1195: ifne +19 -> 1214
    //   1198: iload 6
    //   1200: istore 7
    //   1202: aload_0
    //   1203: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1206: aload_2
    //   1207: invokevirtual 400	java/net/HttpURLConnection:getContentLength	()I
    //   1210: i2l
    //   1211: putfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1214: iload 6
    //   1216: istore 7
    //   1218: new 402	java/io/FileOutputStream
    //   1221: dup
    //   1222: aload 4
    //   1224: iconst_1
    //   1225: invokespecial 405	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   1228: astore_1
    //   1229: iload 6
    //   1231: istore 7
    //   1233: sipush 4096
    //   1236: newarray <illegal type>
    //   1238: astore_2
    //   1239: iload 6
    //   1241: istore 7
    //   1243: aload_3
    //   1244: aload_2
    //   1245: invokevirtual 411	java/io/InputStream:read	([B)I
    //   1248: istore 8
    //   1250: iload 8
    //   1252: iconst_m1
    //   1253: if_icmpeq +342 -> 1595
    //   1256: iload 6
    //   1258: istore 7
    //   1260: aload_0
    //   1261: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1264: getfield 226	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1267: iload 8
    //   1269: i2l
    //   1270: ladd
    //   1271: aload_0
    //   1272: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1275: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1278: lcmp
    //   1279: ifle +101 -> 1380
    //   1282: iload 6
    //   1284: istore 7
    //   1286: aload_0
    //   1287: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1290: aload_0
    //   1291: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1294: bipush 10
    //   1296: sipush 305
    //   1299: invokevirtual 87	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1302: aload_3
    //   1303: invokevirtual 414	java/io/InputStream:close	()V
    //   1306: aload_1
    //   1307: invokevirtual 415	java/io/FileOutputStream:close	()V
    //   1310: return
    //   1311: astore_1
    //   1312: return
    //   1313: astore_1
    //   1314: iload 6
    //   1316: istore 7
    //   1318: aload_0
    //   1319: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1322: aload_0
    //   1323: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1326: bipush 10
    //   1328: sipush 304
    //   1331: invokevirtual 87	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1334: return
    //   1335: astore_1
    //   1336: iload 7
    //   1338: istore 6
    //   1340: invokestatic 177	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1343: ifeq -1133 -> 210
    //   1346: ldc 127
    //   1348: iconst_4
    //   1349: new 32	java/lang/StringBuilder
    //   1352: dup
    //   1353: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   1356: ldc_w 417
    //   1359: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: iload 7
    //   1364: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1367: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1370: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1373: iload 7
    //   1375: istore 6
    //   1377: goto -1167 -> 210
    //   1380: iload 6
    //   1382: istore 7
    //   1384: aload_1
    //   1385: aload_2
    //   1386: iconst_0
    //   1387: iload 8
    //   1389: invokevirtual 421	java/io/FileOutputStream:write	([BII)V
    //   1392: iload 6
    //   1394: istore 7
    //   1396: aload_0
    //   1397: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1400: astore 5
    //   1402: iload 6
    //   1404: istore 7
    //   1406: aload 5
    //   1408: aload 5
    //   1410: getfield 226	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1413: iload 8
    //   1415: i2l
    //   1416: ladd
    //   1417: putfield 226	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1420: iload 6
    //   1422: istore 7
    //   1424: aload_0
    //   1425: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1428: astore 5
    //   1430: iload 6
    //   1432: istore 7
    //   1434: aload 5
    //   1436: aload 5
    //   1438: getfield 424	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
    //   1441: iload 8
    //   1443: i2l
    //   1444: ladd
    //   1445: putfield 424	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
    //   1448: iload 6
    //   1450: istore 7
    //   1452: aload_0
    //   1453: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1456: iconst_1
    //   1457: iload 8
    //   1459: i2l
    //   1460: invokevirtual 427	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(IJ)V
    //   1463: iload 6
    //   1465: istore 7
    //   1467: aload_0
    //   1468: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1471: aload_0
    //   1472: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1475: invokevirtual 174	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   1478: istore 13
    //   1480: iload 13
    //   1482: ifeq +46 -> 1528
    //   1485: aload_3
    //   1486: invokevirtual 414	java/io/InputStream:close	()V
    //   1489: aload_1
    //   1490: invokevirtual 415	java/io/FileOutputStream:close	()V
    //   1493: return
    //   1494: astore_1
    //   1495: return
    //   1496: astore_2
    //   1497: iload 6
    //   1499: istore 7
    //   1501: aload_0
    //   1502: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1505: aload_0
    //   1506: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1509: bipush 10
    //   1511: sipush 306
    //   1514: invokevirtual 87	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1517: aload_3
    //   1518: invokevirtual 414	java/io/InputStream:close	()V
    //   1521: aload_1
    //   1522: invokevirtual 415	java/io/FileOutputStream:close	()V
    //   1525: return
    //   1526: astore_1
    //   1527: return
    //   1528: iconst_0
    //   1529: istore 8
    //   1531: iconst_0
    //   1532: istore 6
    //   1534: iload 8
    //   1536: istore 7
    //   1538: aload_0
    //   1539: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1542: iconst_0
    //   1543: putfield 230	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   1546: iload 8
    //   1548: istore 7
    //   1550: aload_0
    //   1551: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1554: aload_0
    //   1555: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1558: invokevirtual 430	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1561: iload 8
    //   1563: istore 7
    //   1565: aload_0
    //   1566: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1569: getfield 226	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1572: lstore 9
    //   1574: iload 8
    //   1576: istore 7
    //   1578: aload_0
    //   1579: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1582: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1585: lstore 11
    //   1587: lload 9
    //   1589: lload 11
    //   1591: lcmp
    //   1592: ifne -353 -> 1239
    //   1595: aload_3
    //   1596: invokevirtual 414	java/io/InputStream:close	()V
    //   1599: aload_1
    //   1600: invokevirtual 415	java/io/FileOutputStream:close	()V
    //   1603: goto -1375 -> 228
    //   1606: astore_1
    //   1607: goto -1379 -> 228
    //   1610: astore_2
    //   1611: aload_3
    //   1612: invokevirtual 414	java/io/InputStream:close	()V
    //   1615: aload_1
    //   1616: invokevirtual 415	java/io/FileOutputStream:close	()V
    //   1619: aload_2
    //   1620: athrow
    //   1621: iload 6
    //   1623: iload 7
    //   1625: if_icmple -1316 -> 309
    //   1628: new 32	java/lang/StringBuilder
    //   1631: dup
    //   1632: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   1635: aload_0
    //   1636: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1639: getfield 236	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1642: iconst_0
    //   1643: iload 6
    //   1645: iload 7
    //   1647: isub
    //   1648: invokevirtual 246	java/lang/String:substring	(II)Ljava/lang/String;
    //   1651: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1654: aload_0
    //   1655: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1658: getfield 236	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1661: iload 6
    //   1663: invokevirtual 268	java/lang/String:substring	(I)Ljava/lang/String;
    //   1666: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1669: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1672: astore_1
    //   1673: aload_0
    //   1674: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1677: aload_1
    //   1678: putfield 236	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1681: goto -1372 -> 309
    //   1684: new 32	java/lang/StringBuilder
    //   1687: dup
    //   1688: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   1691: getstatic 261	com/tencent/mobileqq/app/AppConstants:bv	Ljava/lang/String;
    //   1694: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1697: aload_1
    //   1698: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1701: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1704: astore_2
    //   1705: goto -1263 -> 442
    //   1708: iload 6
    //   1710: iconst_1
    //   1711: iadd
    //   1712: istore 6
    //   1714: goto -1358 -> 356
    //   1717: aload_0
    //   1718: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1721: aload_0
    //   1722: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1725: bipush 10
    //   1727: sipush 307
    //   1730: invokevirtual 87	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1733: return
    //   1734: astore_2
    //   1735: goto -429 -> 1306
    //   1738: astore_2
    //   1739: goto -218 -> 1521
    //   1742: astore_2
    //   1743: goto -254 -> 1489
    //   1746: astore_2
    //   1747: goto -148 -> 1599
    //   1750: astore_3
    //   1751: goto -136 -> 1615
    //   1754: astore_1
    //   1755: goto -136 -> 1619
    //   1758: goto -1548 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1761	0	this	TaskHttpDownload
    //   62	368	1	localObject1	Object
    //   511	1	1	localIOException1	java.io.IOException
    //   677	2	1	localInterruptedException	InterruptedException
    //   728	579	1	localObject2	Object
    //   1311	1	1	localIOException2	java.io.IOException
    //   1313	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   1335	155	1	localIOException3	java.io.IOException
    //   1494	28	1	localIOException4	java.io.IOException
    //   1526	74	1	localIOException5	java.io.IOException
    //   1606	10	1	localIOException6	java.io.IOException
    //   1672	26	1	str1	String
    //   1754	1	1	localIOException7	java.io.IOException
    //   316	1070	2	localObject3	Object
    //   1496	1	2	localIOException8	java.io.IOException
    //   1610	10	2	localObject4	Object
    //   1704	1	2	str2	String
    //   1734	1	2	localIOException9	java.io.IOException
    //   1738	1	2	localIOException10	java.io.IOException
    //   1742	1	2	localIOException11	java.io.IOException
    //   1746	1	2	localIOException12	java.io.IOException
    //   450	1162	3	localObject5	Object
    //   1750	1	3	localIOException13	java.io.IOException
    //   133	1090	4	localFile	java.io.File
    //   764	673	5	localObject6	Object
    //   174	1539	6	i	int
    //   162	1486	7	j	int
    //   375	1200	8	k	int
    //   1572	16	9	l1	long
    //   1585	5	11	l2	long
    //   1478	3	13	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   143	149	511	java/io/IOException
    //   632	638	677	java/lang/InterruptedException
    //   1306	1310	1311	java/io/IOException
    //   1218	1229	1313	java/io/FileNotFoundException
    //   1177	1182	1335	java/io/IOException
    //   1186	1198	1335	java/io/IOException
    //   1202	1214	1335	java/io/IOException
    //   1218	1229	1335	java/io/IOException
    //   1318	1334	1335	java/io/IOException
    //   1619	1621	1335	java/io/IOException
    //   1489	1493	1494	java/io/IOException
    //   1384	1392	1496	java/io/IOException
    //   1521	1525	1526	java/io/IOException
    //   1599	1603	1606	java/io/IOException
    //   1233	1239	1610	finally
    //   1243	1250	1610	finally
    //   1260	1282	1610	finally
    //   1286	1302	1610	finally
    //   1384	1392	1610	finally
    //   1396	1402	1610	finally
    //   1406	1420	1610	finally
    //   1424	1430	1610	finally
    //   1434	1448	1610	finally
    //   1452	1463	1610	finally
    //   1467	1480	1610	finally
    //   1501	1517	1610	finally
    //   1538	1546	1610	finally
    //   1550	1561	1610	finally
    //   1565	1574	1610	finally
    //   1578	1587	1610	finally
    //   1302	1306	1734	java/io/IOException
    //   1517	1521	1738	java/io/IOException
    //   1485	1489	1742	java/io/IOException
    //   1595	1599	1746	java/io/IOException
    //   1611	1615	1750	java/io/IOException
    //   1615	1619	1754	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopFileTransferManager$TaskHttpDownload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */