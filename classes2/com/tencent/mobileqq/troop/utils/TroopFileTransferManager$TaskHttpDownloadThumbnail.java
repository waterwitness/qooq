package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TroopFileTransferManager$TaskHttpDownloadThumbnail
  extends TroopFileTransferManager.Task
{
  public int g;
  
  public TroopFileTransferManager$TaskHttpDownloadThumbnail(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    super(paramTroopFileTransferManager, paramItem, 4);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.g = paramInt;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 39	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 41
    //   8: iconst_4
    //   9: ldc 43
    //   11: invokestatic 47	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: new 49	java/io/File
    //   17: dup
    //   18: getstatic 55	com/tencent/mobileqq/app/AppConstants:by	Ljava/lang/String;
    //   21: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 61	java/io/File:exists	()Z
    //   29: ifne +8 -> 37
    //   32: aload_1
    //   33: invokevirtual 64	java/io/File:mkdir	()Z
    //   36: pop
    //   37: aload_0
    //   38: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   41: aload_0
    //   42: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   45: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   48: aload_0
    //   49: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   52: invokevirtual 79	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getThumbnailFile	(JI)Ljava/lang/String;
    //   55: astore 5
    //   57: new 81	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   64: aload 5
    //   66: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 89
    //   71: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore 6
    //   79: iconst_0
    //   80: istore 9
    //   82: new 81	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   89: ldc 95
    //   91: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_0
    //   95: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   98: getfield 98	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   101: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 100
    //   106: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_0
    //   110: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   113: getfield 103	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   116: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc 105
    //   121: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_0
    //   125: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   128: getfield 108	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   131: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc 110
    //   136: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_0
    //   140: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   143: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   146: ldc 115
    //   148: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_0
    //   152: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   155: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: astore_1
    //   162: new 117	java/net/URL
    //   165: dup
    //   166: aload_1
    //   167: invokespecial 118	java/net/URL:<init>	(Ljava/lang/String;)V
    //   170: astore 7
    //   172: iload 9
    //   174: sipush 1000
    //   177: imul
    //   178: i2l
    //   179: lstore 11
    //   181: lload 11
    //   183: invokestatic 124	java/lang/Thread:sleep	(J)V
    //   186: new 49	java/io/File
    //   189: dup
    //   190: aload 6
    //   192: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   195: astore 4
    //   197: aload 4
    //   199: invokevirtual 127	java/io/File:delete	()Z
    //   202: pop
    //   203: iload 9
    //   205: iconst_1
    //   206: iadd
    //   207: istore 9
    //   209: iload 9
    //   211: iconst_3
    //   212: if_icmple +195 -> 407
    //   215: aload_0
    //   216: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   219: sipush 128
    //   222: if_icmpne +128 -> 350
    //   225: aload_0
    //   226: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   229: iconst_0
    //   230: putfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   233: return
    //   234: astore_1
    //   235: aload_0
    //   236: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   239: sipush 128
    //   242: if_icmpne +12 -> 254
    //   245: aload_0
    //   246: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   249: iconst_0
    //   250: putfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   253: return
    //   254: aload_0
    //   255: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   258: sipush 640
    //   261: if_icmpne +12 -> 273
    //   264: aload_0
    //   265: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   268: iconst_0
    //   269: putfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   272: return
    //   273: aload_0
    //   274: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   277: sipush 383
    //   280: if_icmpne -47 -> 233
    //   283: aload_0
    //   284: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   287: iconst_0
    //   288: putfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   291: return
    //   292: astore_1
    //   293: aload_0
    //   294: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   297: sipush 128
    //   300: if_icmpne +12 -> 312
    //   303: aload_0
    //   304: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   307: iconst_0
    //   308: putfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   311: return
    //   312: aload_0
    //   313: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   316: sipush 640
    //   319: if_icmpne +12 -> 331
    //   322: aload_0
    //   323: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   326: iconst_0
    //   327: putfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   330: return
    //   331: aload_0
    //   332: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   335: sipush 383
    //   338: if_icmpne -105 -> 233
    //   341: aload_0
    //   342: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   345: iconst_0
    //   346: putfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   349: return
    //   350: aload_0
    //   351: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   354: sipush 640
    //   357: if_icmpne +12 -> 369
    //   360: aload_0
    //   361: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   364: iconst_0
    //   365: putfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   368: return
    //   369: aload_0
    //   370: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   373: sipush 383
    //   376: if_icmpne -143 -> 233
    //   379: aload_0
    //   380: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   383: iconst_0
    //   384: putfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   387: aload_0
    //   388: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   391: iconst_1
    //   392: putfield 139	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle_Fail	Z
    //   395: aload_0
    //   396: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   399: aload_0
    //   400: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   403: invokevirtual 142	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   406: return
    //   407: aload 4
    //   409: invokevirtual 145	java/io/File:createNewFile	()Z
    //   412: pop
    //   413: aconst_null
    //   414: astore_3
    //   415: aload 7
    //   417: invokevirtual 149	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   420: checkcast 151	java/net/HttpURLConnection
    //   423: astore_1
    //   424: aload_1
    //   425: sipush 30000
    //   428: invokevirtual 155	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   431: aload_1
    //   432: ldc -99
    //   434: invokevirtual 160	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   437: aload_1
    //   438: ldc -94
    //   440: ldc -92
    //   442: invokevirtual 168	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: aload_1
    //   446: ldc -86
    //   448: ldc -84
    //   450: invokevirtual 168	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   453: aload_1
    //   454: ldc -82
    //   456: new 81	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   463: ldc -80
    //   465: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload_0
    //   469: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   472: getfield 179	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   475: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokevirtual 168	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   484: aload_1
    //   485: invokevirtual 183	java/net/HttpURLConnection:getResponseCode	()I
    //   488: sipush 200
    //   491: if_icmpeq +13 -> 504
    //   494: aload_1
    //   495: invokevirtual 183	java/net/HttpURLConnection:getResponseCode	()I
    //   498: sipush 206
    //   501: if_icmpne +604 -> 1105
    //   504: aload_1
    //   505: invokevirtual 187	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   508: astore 8
    //   510: new 189	java/io/FileOutputStream
    //   513: dup
    //   514: aload 4
    //   516: invokespecial 192	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   519: astore_3
    //   520: sipush 4096
    //   523: newarray <illegal type>
    //   525: astore_2
    //   526: aload 8
    //   528: aload_2
    //   529: invokevirtual 198	java/io/InputStream:read	([B)I
    //   532: istore 10
    //   534: iload 10
    //   536: iconst_m1
    //   537: if_icmpeq +306 -> 843
    //   540: aload_3
    //   541: aload_2
    //   542: iconst_0
    //   543: iload 10
    //   545: invokevirtual 202	java/io/FileOutputStream:write	([BII)V
    //   548: aload_0
    //   549: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   552: iconst_1
    //   553: iload 10
    //   555: i2l
    //   556: invokevirtual 205	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(IJ)V
    //   559: iconst_0
    //   560: istore 9
    //   562: goto -36 -> 526
    //   565: astore_1
    //   566: aload_0
    //   567: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   570: sipush 128
    //   573: if_icmpne +12 -> 585
    //   576: aload_0
    //   577: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   580: iconst_0
    //   581: putfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   584: return
    //   585: aload_0
    //   586: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   589: sipush 640
    //   592: if_icmpne +12 -> 604
    //   595: aload_0
    //   596: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   599: iconst_0
    //   600: putfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   603: return
    //   604: aload_0
    //   605: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   608: sipush 383
    //   611: if_icmpne -378 -> 233
    //   614: aload_0
    //   615: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   618: iconst_0
    //   619: putfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   622: return
    //   623: astore_2
    //   624: aload_0
    //   625: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   628: sipush 128
    //   631: if_icmpne +26 -> 657
    //   634: aload_0
    //   635: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   638: iconst_0
    //   639: putfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   642: aload_1
    //   643: ifnull +7 -> 650
    //   646: aload_1
    //   647: invokevirtual 208	java/net/HttpURLConnection:disconnect	()V
    //   650: aload 4
    //   652: invokevirtual 127	java/io/File:delete	()Z
    //   655: pop
    //   656: return
    //   657: aload_0
    //   658: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   661: sipush 640
    //   664: if_icmpne +32 -> 696
    //   667: aload_0
    //   668: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   671: iconst_0
    //   672: putfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   675: goto -33 -> 642
    //   678: astore_2
    //   679: aload_1
    //   680: ifnull +7 -> 687
    //   683: aload_1
    //   684: invokevirtual 208	java/net/HttpURLConnection:disconnect	()V
    //   687: aload 4
    //   689: invokevirtual 127	java/io/File:delete	()Z
    //   692: pop
    //   693: goto -521 -> 172
    //   696: aload_0
    //   697: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   700: sipush 383
    //   703: if_icmpne -61 -> 642
    //   706: aload_0
    //   707: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   710: iconst_0
    //   711: putfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   714: goto -72 -> 642
    //   717: astore_2
    //   718: aload_1
    //   719: ifnull +7 -> 726
    //   722: aload_1
    //   723: invokevirtual 208	java/net/HttpURLConnection:disconnect	()V
    //   726: aload 4
    //   728: invokevirtual 127	java/io/File:delete	()Z
    //   731: pop
    //   732: aload_2
    //   733: athrow
    //   734: astore_2
    //   735: aload_0
    //   736: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   739: sipush 128
    //   742: if_icmpne +35 -> 777
    //   745: aload_0
    //   746: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   749: iconst_0
    //   750: putfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   753: aload 8
    //   755: invokevirtual 211	java/io/InputStream:close	()V
    //   758: aload_3
    //   759: invokevirtual 212	java/io/FileOutputStream:close	()V
    //   762: aload_1
    //   763: ifnull +7 -> 770
    //   766: aload_1
    //   767: invokevirtual 208	java/net/HttpURLConnection:disconnect	()V
    //   770: aload 4
    //   772: invokevirtual 127	java/io/File:delete	()Z
    //   775: pop
    //   776: return
    //   777: aload_0
    //   778: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   781: sipush 640
    //   784: if_icmpne +38 -> 822
    //   787: aload_0
    //   788: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   791: iconst_0
    //   792: putfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   795: goto -42 -> 753
    //   798: astore_2
    //   799: aload 8
    //   801: invokevirtual 211	java/io/InputStream:close	()V
    //   804: aload_3
    //   805: invokevirtual 212	java/io/FileOutputStream:close	()V
    //   808: iload 9
    //   810: istore 10
    //   812: aload_2
    //   813: athrow
    //   814: astore_2
    //   815: iload 10
    //   817: istore 9
    //   819: goto -140 -> 679
    //   822: aload_0
    //   823: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   826: sipush 383
    //   829: if_icmpne -76 -> 753
    //   832: aload_0
    //   833: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   836: iconst_0
    //   837: putfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   840: goto -87 -> 753
    //   843: aload 8
    //   845: invokevirtual 211	java/io/InputStream:close	()V
    //   848: aload_3
    //   849: invokevirtual 212	java/io/FileOutputStream:close	()V
    //   852: iload 9
    //   854: istore 10
    //   856: new 49	java/io/File
    //   859: dup
    //   860: aload 6
    //   862: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   865: astore_2
    //   866: iload 9
    //   868: istore 10
    //   870: aload_2
    //   871: new 49	java/io/File
    //   874: dup
    //   875: aload 5
    //   877: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   880: invokevirtual 216	java/io/File:renameTo	(Ljava/io/File;)Z
    //   883: pop
    //   884: iload 9
    //   886: istore 10
    //   888: aload_2
    //   889: invokevirtual 219	java/io/File:deleteOnExit	()V
    //   892: iload 9
    //   894: istore 10
    //   896: aload_0
    //   897: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   900: astore_2
    //   901: iload 9
    //   903: istore 10
    //   905: aload_2
    //   906: monitorenter
    //   907: aload_0
    //   908: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   911: sipush 128
    //   914: if_icmpne +84 -> 998
    //   917: aload_0
    //   918: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   921: iconst_0
    //   922: putfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   925: aload_0
    //   926: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   929: aload_0
    //   930: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   933: sipush 128
    //   936: invokevirtual 222	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
    //   939: pop
    //   940: aload_0
    //   941: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   944: lconst_0
    //   945: putfield 225	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:StatusUpdateTimeMs	J
    //   948: aload_0
    //   949: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   952: getfield 228	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	Ljava/util/Map;
    //   955: aload_0
    //   956: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   959: getfield 232	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Id	Ljava/util/UUID;
    //   962: invokeinterface 238 2 0
    //   967: ifeq +14 -> 981
    //   970: aload_0
    //   971: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   974: aload_0
    //   975: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   978: invokevirtual 142	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   981: aload_2
    //   982: monitorexit
    //   983: aload_1
    //   984: ifnull +7 -> 991
    //   987: aload_1
    //   988: invokevirtual 208	java/net/HttpURLConnection:disconnect	()V
    //   991: aload 4
    //   993: invokevirtual 127	java/io/File:delete	()Z
    //   996: pop
    //   997: return
    //   998: aload_0
    //   999: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   1002: sipush 640
    //   1005: if_icmpne +38 -> 1043
    //   1008: aload_0
    //   1009: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1012: iconst_0
    //   1013: putfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   1016: aload_0
    //   1017: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1020: aload_0
    //   1021: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1024: sipush 640
    //   1027: invokevirtual 222	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
    //   1030: pop
    //   1031: goto -91 -> 940
    //   1034: astore_3
    //   1035: aload_2
    //   1036: monitorexit
    //   1037: iload 9
    //   1039: istore 10
    //   1041: aload_3
    //   1042: athrow
    //   1043: aload_0
    //   1044: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   1047: sipush 383
    //   1050: if_icmpne -110 -> 940
    //   1053: aload_0
    //   1054: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1057: iconst_0
    //   1058: putfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   1061: aload_0
    //   1062: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1065: aload_0
    //   1066: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1069: sipush 383
    //   1072: invokevirtual 222	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
    //   1075: istore 13
    //   1077: aload_0
    //   1078: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1081: astore_3
    //   1082: iload 13
    //   1084: ifne +15 -> 1099
    //   1087: iconst_1
    //   1088: istore 13
    //   1090: aload_3
    //   1091: iload 13
    //   1093: putfield 139	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle_Fail	Z
    //   1096: goto -156 -> 940
    //   1099: iconst_0
    //   1100: istore 13
    //   1102: goto -12 -> 1090
    //   1105: aload_0
    //   1106: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:g	I
    //   1109: sipush 383
    //   1112: if_icmpne +44 -> 1156
    //   1115: aload_0
    //   1116: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1119: iconst_1
    //   1120: putfield 139	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle_Fail	Z
    //   1123: aload_0
    //   1124: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1127: getfield 228	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	Ljava/util/Map;
    //   1130: aload_0
    //   1131: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1134: getfield 232	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Id	Ljava/util/UUID;
    //   1137: invokeinterface 238 2 0
    //   1142: ifeq +14 -> 1156
    //   1145: aload_0
    //   1146: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1149: aload_0
    //   1150: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1153: invokevirtual 142	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1156: aload_1
    //   1157: ifnull +7 -> 1164
    //   1160: aload_1
    //   1161: invokevirtual 208	java/net/HttpURLConnection:disconnect	()V
    //   1164: aload 4
    //   1166: invokevirtual 127	java/io/File:delete	()Z
    //   1169: pop
    //   1170: goto -998 -> 172
    //   1173: astore_2
    //   1174: goto -416 -> 758
    //   1177: astore_2
    //   1178: goto -416 -> 762
    //   1181: astore_2
    //   1182: goto -334 -> 848
    //   1185: astore_2
    //   1186: goto -334 -> 852
    //   1189: astore 8
    //   1191: goto -387 -> 804
    //   1194: astore_3
    //   1195: goto -387 -> 808
    //   1198: astore_2
    //   1199: aload_3
    //   1200: astore_1
    //   1201: goto -483 -> 718
    //   1204: astore_1
    //   1205: aconst_null
    //   1206: astore_1
    //   1207: goto -528 -> 679
    //   1210: astore_2
    //   1211: goto -412 -> 799
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1214	0	this	TaskHttpDownloadThumbnail
    //   24	143	1	localObject1	Object
    //   234	1	1	localMalformedURLException	java.net.MalformedURLException
    //   292	1	1	localInterruptedException	InterruptedException
    //   423	82	1	localHttpURLConnection	java.net.HttpURLConnection
    //   565	596	1	localIOException1	java.io.IOException
    //   1200	1	1	localObject2	Object
    //   1204	1	1	localIOException2	java.io.IOException
    //   1206	1	1	localObject3	Object
    //   525	17	2	arrayOfByte	byte[]
    //   623	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   678	1	2	localIOException3	java.io.IOException
    //   717	16	2	localObject4	Object
    //   734	1	2	localIOException4	java.io.IOException
    //   798	15	2	localObject5	Object
    //   814	1	2	localIOException5	java.io.IOException
    //   865	171	2	localObject6	Object
    //   1173	1	2	localIOException6	java.io.IOException
    //   1177	1	2	localIOException7	java.io.IOException
    //   1181	1	2	localIOException8	java.io.IOException
    //   1185	1	2	localIOException9	java.io.IOException
    //   1198	1	2	localObject7	Object
    //   1210	1	2	localObject8	Object
    //   414	435	3	localFileOutputStream	java.io.FileOutputStream
    //   1034	8	3	localObject9	Object
    //   1081	10	3	localItem	TroopFileTransferManager.Item
    //   1194	6	3	localIOException10	java.io.IOException
    //   195	970	4	localFile	java.io.File
    //   55	821	5	str1	String
    //   77	784	6	str2	String
    //   170	246	7	localURL	java.net.URL
    //   508	336	8	localInputStream	java.io.InputStream
    //   1189	1	8	localIOException11	java.io.IOException
    //   80	958	9	i	int
    //   532	508	10	j	int
    //   179	3	11	l	long
    //   1075	26	13	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   162	172	234	java/net/MalformedURLException
    //   181	186	292	java/lang/InterruptedException
    //   407	413	565	java/io/IOException
    //   510	520	623	java/io/FileNotFoundException
    //   424	504	678	java/io/IOException
    //   504	510	678	java/io/IOException
    //   510	520	678	java/io/IOException
    //   624	642	678	java/io/IOException
    //   657	675	678	java/io/IOException
    //   696	714	678	java/io/IOException
    //   1105	1156	678	java/io/IOException
    //   424	504	717	finally
    //   504	510	717	finally
    //   510	520	717	finally
    //   624	642	717	finally
    //   657	675	717	finally
    //   696	714	717	finally
    //   753	758	717	finally
    //   758	762	717	finally
    //   799	804	717	finally
    //   804	808	717	finally
    //   812	814	717	finally
    //   843	848	717	finally
    //   848	852	717	finally
    //   856	866	717	finally
    //   870	884	717	finally
    //   888	892	717	finally
    //   896	901	717	finally
    //   905	907	717	finally
    //   1041	1043	717	finally
    //   1105	1156	717	finally
    //   540	559	734	java/io/IOException
    //   526	534	798	finally
    //   540	559	798	finally
    //   735	753	798	finally
    //   777	795	798	finally
    //   822	840	798	finally
    //   812	814	814	java/io/IOException
    //   856	866	814	java/io/IOException
    //   870	884	814	java/io/IOException
    //   888	892	814	java/io/IOException
    //   896	901	814	java/io/IOException
    //   905	907	814	java/io/IOException
    //   1041	1043	814	java/io/IOException
    //   907	940	1034	finally
    //   940	981	1034	finally
    //   981	983	1034	finally
    //   998	1031	1034	finally
    //   1035	1037	1034	finally
    //   1043	1082	1034	finally
    //   1090	1096	1034	finally
    //   753	758	1173	java/io/IOException
    //   758	762	1177	java/io/IOException
    //   843	848	1181	java/io/IOException
    //   848	852	1185	java/io/IOException
    //   799	804	1189	java/io/IOException
    //   804	808	1194	java/io/IOException
    //   415	424	1198	finally
    //   415	424	1204	java/io/IOException
    //   520	526	1210	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopFileTransferManager$TaskHttpDownloadThumbnail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */