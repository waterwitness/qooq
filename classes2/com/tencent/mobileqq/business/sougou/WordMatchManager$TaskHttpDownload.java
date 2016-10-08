package com.tencent.mobileqq.business.sougou;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class WordMatchManager$TaskHttpDownload
  implements Runnable
{
  int jdField_a_of_type_Int;
  
  public WordMatchManager$TaskHttpDownload(WordMatchManager paramWordMatchManager, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  /* Error */
  private java.net.HttpURLConnection a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   4: iload_1
    //   5: invokevirtual 36	com/tencent/mobileqq/business/sougou/WordMatchManager:b	(I)Ljava/lang/String;
    //   8: astore 4
    //   10: new 38	java/net/URL
    //   13: dup
    //   14: aload 4
    //   16: invokespecial 41	java/net/URL:<init>	(Ljava/lang/String;)V
    //   19: astore_2
    //   20: aload_2
    //   21: invokevirtual 45	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   24: checkcast 47	java/net/HttpURLConnection
    //   27: astore_3
    //   28: aload_3
    //   29: ifnonnull +42 -> 71
    //   32: aconst_null
    //   33: astore_2
    //   34: aload_2
    //   35: areturn
    //   36: astore_2
    //   37: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +29 -> 69
    //   43: ldc 55
    //   45: iconst_2
    //   46: new 57	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   53: ldc 60
    //   55: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload 4
    //   60: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aconst_null
    //   70: areturn
    //   71: aload_3
    //   72: sipush 30000
    //   75: invokevirtual 76	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   78: aload_3
    //   79: aload_0
    //   80: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   83: iload_1
    //   84: invokevirtual 79	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)J
    //   87: invokevirtual 83	java/net/HttpURLConnection:setIfModifiedSince	(J)V
    //   90: aload_3
    //   91: sipush 30000
    //   94: invokevirtual 86	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   97: aload_3
    //   98: ldc 88
    //   100: invokevirtual 91	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   103: aload_3
    //   104: astore_2
    //   105: aload_3
    //   106: invokevirtual 95	java/net/HttpURLConnection:getResponseCode	()I
    //   109: sipush 200
    //   112: if_icmpeq -78 -> 34
    //   115: aload_3
    //   116: invokevirtual 95	java/net/HttpURLConnection:getResponseCode	()I
    //   119: istore_1
    //   120: aload_3
    //   121: astore_2
    //   122: iload_1
    //   123: sipush 206
    //   126: if_icmpeq -92 -> 34
    //   129: aconst_null
    //   130: areturn
    //   131: astore_2
    //   132: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +29 -> 164
    //   138: ldc 55
    //   140: iconst_2
    //   141: new 57	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   148: ldc 97
    //   150: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 4
    //   155: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aconst_null
    //   165: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	TaskHttpDownload
    //   0	166	1	paramInt	int
    //   19	16	2	localURL	java.net.URL
    //   36	1	2	localMalformedURLException	java.net.MalformedURLException
    //   104	18	2	localObject	Object
    //   131	1	2	localIOException	java.io.IOException
    //   27	94	3	localHttpURLConnection	java.net.HttpURLConnection
    //   8	146	4	str	String
    // Exception table:
    //   from	to	target	type
    //   10	20	36	java/net/MalformedURLException
    //   20	28	131	java/io/IOException
    //   71	103	131	java/io/IOException
    //   105	120	131	java/io/IOException
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: invokestatic 103	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6: ifeq +42 -> 48
    //   9: ldc 55
    //   11: iconst_4
    //   12: new 57	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   19: ldc 105
    //   21: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 24	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_Int	I
    //   28: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: ldc 110
    //   33: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   39: invokevirtual 119	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   42: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: invokestatic 123	com/tencent/open/appcommon/Common:a	()Z
    //   51: ifne +109 -> 160
    //   54: iload 8
    //   56: istore 7
    //   58: invokestatic 103	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   61: ifeq +52 -> 113
    //   64: ldc 55
    //   66: iconst_4
    //   67: new 57	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   74: ldc 125
    //   76: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: getfield 24	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_Int	I
    //   83: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   86: ldc 127
    //   88: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: iload 7
    //   93: invokevirtual 130	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   96: ldc 110
    //   98: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   104: invokevirtual 119	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   107: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: iload 7
    //   115: ifeq +485 -> 600
    //   118: aload_0
    //   119: getfield 24	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_Int	I
    //   122: iconst_1
    //   123: if_icmpne +444 -> 567
    //   126: aload_0
    //   127: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   130: aload_0
    //   131: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   134: getfield 133	com/tencent/mobileqq/business/sougou/WordMatchManager:a	Lcom/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo;
    //   137: invokevirtual 136	com/tencent/mobileqq/business/sougou/WordMatchManager:b	(Lcom/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo;)V
    //   140: aload_0
    //   141: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   144: iconst_1
    //   145: putfield 139	com/tencent/mobileqq/business/sougou/WordMatchManager:e	Z
    //   148: aload_0
    //   149: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   152: aload_0
    //   153: getfield 24	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_Int	I
    //   156: invokevirtual 141	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)V
    //   159: return
    //   160: new 143	java/io/File
    //   163: dup
    //   164: getstatic 147	com/tencent/mobileqq/business/sougou/WordMatchManager:c	Ljava/lang/String;
    //   167: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   170: astore_1
    //   171: aload_1
    //   172: invokevirtual 151	java/io/File:exists	()Z
    //   175: ifne +8 -> 183
    //   178: aload_1
    //   179: invokevirtual 154	java/io/File:mkdir	()Z
    //   182: pop
    //   183: new 57	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   190: aload_0
    //   191: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   194: aload_0
    //   195: getfield 24	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_Int	I
    //   198: invokevirtual 156	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)Ljava/lang/String;
    //   201: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc -98
    //   206: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: astore_1
    //   213: new 143	java/io/File
    //   216: dup
    //   217: aload_1
    //   218: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   221: astore_3
    //   222: aload_3
    //   223: invokevirtual 151	java/io/File:exists	()Z
    //   226: ifeq +57 -> 283
    //   229: aload_3
    //   230: invokevirtual 161	java/io/File:delete	()Z
    //   233: ifne +45 -> 278
    //   236: iload 8
    //   238: istore 7
    //   240: invokestatic 103	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   243: ifeq -185 -> 58
    //   246: ldc 55
    //   248: iconst_4
    //   249: new 57	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   256: ldc -93
    //   258: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_1
    //   262: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: iload 8
    //   273: istore 7
    //   275: goto -217 -> 58
    //   278: aload_3
    //   279: invokevirtual 166	java/io/File:createNewFile	()Z
    //   282: pop
    //   283: iload 8
    //   285: istore 7
    //   287: invokestatic 172	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   290: invokestatic 177	com/tencent/mobileqq/troop/utils/TroopFileUtils:a	(Landroid/content/Context;)I
    //   293: iconst_2
    //   294: if_icmpne -236 -> 58
    //   297: aload_0
    //   298: aload_0
    //   299: getfield 24	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_Int	I
    //   302: invokespecial 179	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	(I)Ljava/net/HttpURLConnection;
    //   305: astore_2
    //   306: iload 8
    //   308: istore 7
    //   310: aload_2
    //   311: ifnull -253 -> 58
    //   314: iload 8
    //   316: istore 7
    //   318: aload_2
    //   319: invokevirtual 95	java/net/HttpURLConnection:getResponseCode	()I
    //   322: sipush 200
    //   325: if_icmpne -267 -> 58
    //   328: aload_2
    //   329: invokevirtual 183	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   332: astore 4
    //   334: new 185	java/io/FileOutputStream
    //   337: dup
    //   338: aload_3
    //   339: iconst_1
    //   340: invokespecial 188	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   343: astore_3
    //   344: sipush 4096
    //   347: newarray <illegal type>
    //   349: astore 5
    //   351: aload 4
    //   353: aload 5
    //   355: invokevirtual 194	java/io/InputStream:read	([B)I
    //   358: istore 6
    //   360: iload 6
    //   362: iconst_m1
    //   363: if_icmpeq +48 -> 411
    //   366: aload_3
    //   367: aload 5
    //   369: iconst_0
    //   370: iload 6
    //   372: invokevirtual 198	java/io/FileOutputStream:write	([BII)V
    //   375: goto -24 -> 351
    //   378: astore 5
    //   380: invokestatic 103	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   383: ifeq +28 -> 411
    //   386: ldc 55
    //   388: iconst_4
    //   389: new 57	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   396: ldc -56
    //   398: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_1
    //   402: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload 4
    //   413: invokevirtual 203	java/io/InputStream:close	()V
    //   416: aload_3
    //   417: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   420: iload 8
    //   422: istore 7
    //   424: aload_1
    //   425: aload_0
    //   426: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   429: aload_0
    //   430: getfield 24	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_Int	I
    //   433: invokevirtual 156	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)Ljava/lang/String;
    //   436: invokestatic 209	com/tencent/mobileqq/business/sougou/DictFileUtil:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   439: ifeq -381 -> 58
    //   442: aload_0
    //   443: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   446: aload_0
    //   447: getfield 24	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_Int	I
    //   450: aload_2
    //   451: invokevirtual 212	java/net/HttpURLConnection:getLastModified	()J
    //   454: invokevirtual 215	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(IJ)V
    //   457: iconst_1
    //   458: istore 7
    //   460: goto -402 -> 58
    //   463: astore_2
    //   464: iload 8
    //   466: istore 7
    //   468: invokestatic 103	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   471: ifeq -413 -> 58
    //   474: ldc 55
    //   476: iconst_4
    //   477: new 57	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   484: ldc -39
    //   486: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload_1
    //   490: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   499: iload 8
    //   501: istore 7
    //   503: goto -445 -> 58
    //   506: astore_3
    //   507: iload 8
    //   509: istore 7
    //   511: invokestatic 103	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   514: ifeq -456 -> 58
    //   517: ldc 55
    //   519: iconst_4
    //   520: new 57	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   527: ldc -37
    //   529: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload_1
    //   533: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   542: iload 8
    //   544: istore 7
    //   546: goto -488 -> 58
    //   549: astore_3
    //   550: goto -130 -> 420
    //   553: astore 5
    //   555: aload 4
    //   557: invokevirtual 203	java/io/InputStream:close	()V
    //   560: aload_3
    //   561: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   564: aload 5
    //   566: athrow
    //   567: aload_0
    //   568: getfield 24	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_Int	I
    //   571: iconst_2
    //   572: if_icmpne -424 -> 148
    //   575: aload_0
    //   576: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   579: aload_0
    //   580: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   583: getfield 221	com/tencent/mobileqq/business/sougou/WordMatchManager:b	Lcom/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo;
    //   586: invokevirtual 136	com/tencent/mobileqq/business/sougou/WordMatchManager:b	(Lcom/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo;)V
    //   589: aload_0
    //   590: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   593: iconst_1
    //   594: putfield 139	com/tencent/mobileqq/business/sougou/WordMatchManager:e	Z
    //   597: goto -449 -> 148
    //   600: aload_0
    //   601: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   604: iload 7
    //   606: invokevirtual 224	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(Z)V
    //   609: return
    //   610: astore 4
    //   612: goto -196 -> 416
    //   615: astore_3
    //   616: goto -196 -> 420
    //   619: astore 4
    //   621: goto -61 -> 560
    //   624: astore_3
    //   625: goto -61 -> 564
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	628	0	this	TaskHttpDownload
    //   170	363	1	localObject1	Object
    //   305	146	2	localHttpURLConnection	java.net.HttpURLConnection
    //   463	1	2	localIOException1	java.io.IOException
    //   221	196	3	localObject2	Object
    //   506	1	3	localFileNotFoundException	java.io.FileNotFoundException
    //   549	12	3	localIOException2	java.io.IOException
    //   615	1	3	localIOException3	java.io.IOException
    //   624	1	3	localIOException4	java.io.IOException
    //   332	224	4	localInputStream	java.io.InputStream
    //   610	1	4	localIOException5	java.io.IOException
    //   619	1	4	localIOException6	java.io.IOException
    //   349	19	5	arrayOfByte	byte[]
    //   378	1	5	localIOException7	java.io.IOException
    //   553	12	5	localObject3	Object
    //   358	13	6	i	int
    //   56	549	7	bool1	boolean
    //   1	542	8	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   366	375	378	java/io/IOException
    //   278	283	463	java/io/IOException
    //   334	344	506	java/io/FileNotFoundException
    //   318	334	549	java/io/IOException
    //   334	344	549	java/io/IOException
    //   511	542	549	java/io/IOException
    //   564	567	549	java/io/IOException
    //   344	351	553	finally
    //   351	360	553	finally
    //   366	375	553	finally
    //   380	411	553	finally
    //   411	416	610	java/io/IOException
    //   416	420	615	java/io/IOException
    //   555	560	619	java/io/IOException
    //   560	564	624	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\business\sougou\WordMatchManager$TaskHttpDownload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */