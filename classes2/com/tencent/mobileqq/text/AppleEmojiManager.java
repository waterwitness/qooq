package com.tencent.mobileqq.text;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.InputStream;
import java.io.OutputStream;

public class AppleEmojiManager
{
  public static final String a = "AppleEmojiManager";
  public static final String b = AppConstants.bl + "emojiindex";
  public static final String c = AppConstants.bl + "emojis";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static final int a(InputStream paramInputStream)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j |= paramInputStream.read() << i * 8;
      i += 1;
    }
    return j;
  }
  
  public static final int a(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    if (i < 4)
    {
      int k = paramArrayOfByte[i];
      if (k >= 0) {}
      for (;;)
      {
        j |= k << i * 8;
        i += 1;
        break;
        k += 256;
      }
    }
    return j;
  }
  
  public static final void a(OutputStream paramOutputStream, int paramInt)
  {
    int i = 0;
    while (i < 4)
    {
      paramOutputStream.write(paramInt >> i * 8 & 0xFF);
      i += 1;
    }
  }
  
  /* Error */
  public static boolean a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 74	java/io/File:exists	()Z
    //   4: ifne +19 -> 23
    //   7: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +11 -> 21
    //   13: ldc 8
    //   15: iconst_2
    //   16: ldc 81
    //   18: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: iconst_0
    //   22: ireturn
    //   23: new 70	java/io/File
    //   26: dup
    //   27: getstatic 28	com/tencent/mobileqq/app/AppConstants:bl	Ljava/lang/String;
    //   30: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual 74	java/io/File:exists	()Z
    //   38: ifne +8 -> 46
    //   41: aload_1
    //   42: invokevirtual 91	java/io/File:mkdirs	()Z
    //   45: pop
    //   46: invokestatic 97	android/os/SystemClock:uptimeMillis	()J
    //   49: lstore 14
    //   51: aconst_null
    //   52: astore 5
    //   54: aconst_null
    //   55: astore_3
    //   56: aconst_null
    //   57: astore 6
    //   59: aconst_null
    //   60: astore 4
    //   62: new 99	java/util/zip/ZipInputStream
    //   65: dup
    //   66: new 101	java/io/BufferedInputStream
    //   69: dup
    //   70: new 103	java/io/FileInputStream
    //   73: dup
    //   74: aload_0
    //   75: invokespecial 106	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   78: invokespecial 109	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: invokespecial 110	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: astore_2
    //   85: new 112	java/io/BufferedOutputStream
    //   88: dup
    //   89: new 114	java/io/FileOutputStream
    //   92: dup
    //   93: getstatic 44	com/tencent/mobileqq/text/AppleEmojiManager:c	Ljava/lang/String;
    //   96: invokespecial 115	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   99: invokespecial 118	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   102: astore_1
    //   103: aload 6
    //   105: astore_3
    //   106: new 120	java/util/HashMap
    //   109: dup
    //   110: aload_0
    //   111: invokevirtual 123	java/io/File:length	()J
    //   114: l2i
    //   115: sipush 1024
    //   118: idiv
    //   119: invokespecial 125	java/util/HashMap:<init>	(I)V
    //   122: astore 8
    //   124: aload 6
    //   126: astore_3
    //   127: invokestatic 131	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   130: sipush 512
    //   133: invokevirtual 135	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   136: astore_0
    //   137: iconst_0
    //   138: istore 12
    //   140: aload_0
    //   141: astore_3
    //   142: aload_2
    //   143: invokevirtual 139	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   146: astore 6
    //   148: aload 6
    //   150: ifnull +157 -> 307
    //   153: aload_0
    //   154: astore_3
    //   155: aload 6
    //   157: invokevirtual 144	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   160: astore 5
    //   162: aload 5
    //   164: astore 4
    //   166: aload_0
    //   167: astore_3
    //   168: aload 5
    //   170: ldc -110
    //   172: invokevirtual 152	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   175: ifeq +24 -> 199
    //   178: aload_0
    //   179: astore_3
    //   180: aload 5
    //   182: aload 5
    //   184: bipush 47
    //   186: invokevirtual 156	java/lang/String:lastIndexOf	(I)I
    //   189: iconst_1
    //   190: iadd
    //   191: invokevirtual 160	java/lang/String:substring	(I)Ljava/lang/String;
    //   194: invokevirtual 163	java/lang/String:trim	()Ljava/lang/String;
    //   197: astore 4
    //   199: aload 4
    //   201: ifnull -61 -> 140
    //   204: aload_0
    //   205: astore_3
    //   206: aload 4
    //   208: ldc -91
    //   210: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   213: ifne -73 -> 140
    //   216: aload_0
    //   217: astore_3
    //   218: aload 8
    //   220: aload 4
    //   222: iload 12
    //   224: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   227: invokeinterface 181 3 0
    //   232: pop
    //   233: aload_0
    //   234: astore_3
    //   235: aload 6
    //   237: invokevirtual 184	java/util/zip/ZipEntry:getSize	()J
    //   240: l2i
    //   241: istore 13
    //   243: iload 13
    //   245: iconst_1
    //   246: if_icmplt -106 -> 140
    //   249: aload_0
    //   250: astore_3
    //   251: aload_1
    //   252: iload 13
    //   254: invokestatic 186	com/tencent/mobileqq/text/AppleEmojiManager:a	(Ljava/io/OutputStream;I)V
    //   257: iload 12
    //   259: iconst_4
    //   260: iadd
    //   261: istore 12
    //   263: aload_0
    //   264: astore_3
    //   265: aload_2
    //   266: aload_0
    //   267: invokevirtual 188	java/util/zip/ZipInputStream:read	([B)I
    //   270: istore 13
    //   272: iload 13
    //   274: iconst_m1
    //   275: if_icmpeq +23 -> 298
    //   278: aload_0
    //   279: astore_3
    //   280: aload_1
    //   281: aload_0
    //   282: iconst_0
    //   283: iload 13
    //   285: invokevirtual 191	java/io/BufferedOutputStream:write	([BII)V
    //   288: iload 12
    //   290: iload 13
    //   292: iadd
    //   293: istore 12
    //   295: goto -32 -> 263
    //   298: aload_0
    //   299: astore_3
    //   300: aload_1
    //   301: invokevirtual 194	java/io/BufferedOutputStream:flush	()V
    //   304: goto -164 -> 140
    //   307: aload_0
    //   308: astore_3
    //   309: invokestatic 131	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   312: aload_0
    //   313: invokevirtual 198	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   316: aconst_null
    //   317: astore 4
    //   319: aconst_null
    //   320: astore 7
    //   322: aconst_null
    //   323: astore_3
    //   324: aload_1
    //   325: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   328: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   331: ifeq +11 -> 342
    //   334: ldc 8
    //   336: iconst_2
    //   337: ldc -53
    //   339: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   342: new 112	java/io/BufferedOutputStream
    //   345: dup
    //   346: new 114	java/io/FileOutputStream
    //   349: dup
    //   350: getstatic 40	com/tencent/mobileqq/text/AppleEmojiManager:b	Ljava/lang/String;
    //   353: invokespecial 115	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   356: invokespecial 118	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   359: astore_0
    //   360: aload 7
    //   362: astore 6
    //   364: aload_0
    //   365: astore 5
    //   367: aload_2
    //   368: astore 4
    //   370: aload 8
    //   372: invokeinterface 207 1 0
    //   377: invokeinterface 213 1 0
    //   382: astore_1
    //   383: aload 7
    //   385: astore 6
    //   387: aload_0
    //   388: astore 5
    //   390: aload_2
    //   391: astore 4
    //   393: aload_1
    //   394: invokeinterface 218 1 0
    //   399: ifeq +560 -> 959
    //   402: aload 7
    //   404: astore 6
    //   406: aload_0
    //   407: astore 5
    //   409: aload_2
    //   410: astore 4
    //   412: aload_1
    //   413: invokeinterface 222 1 0
    //   418: checkcast 148	java/lang/String
    //   421: astore 9
    //   423: aload 7
    //   425: astore 6
    //   427: aload_0
    //   428: astore 5
    //   430: aload_2
    //   431: astore 4
    //   433: aload 9
    //   435: ldc -32
    //   437: invokevirtual 152	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   440: ifne +225 -> 665
    //   443: aload 7
    //   445: astore 6
    //   447: aload_0
    //   448: astore 5
    //   450: aload_2
    //   451: astore 4
    //   453: aload 9
    //   455: iconst_2
    //   456: aload 9
    //   458: invokevirtual 226	java/lang/String:length	()I
    //   461: iconst_4
    //   462: isub
    //   463: invokevirtual 229	java/lang/String:substring	(II)Ljava/lang/String;
    //   466: astore 10
    //   468: aload 7
    //   470: astore 6
    //   472: aload_0
    //   473: astore 5
    //   475: aload_2
    //   476: astore 4
    //   478: aload 8
    //   480: aload 9
    //   482: invokeinterface 233 2 0
    //   487: checkcast 171	java/lang/Integer
    //   490: invokevirtual 236	java/lang/Integer:intValue	()I
    //   493: istore 12
    //   495: aload 7
    //   497: astore 6
    //   499: aload_0
    //   500: astore 5
    //   502: aload_2
    //   503: astore 4
    //   505: aload 10
    //   507: bipush 16
    //   509: invokestatic 240	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   512: istore 13
    //   514: aload 7
    //   516: astore 6
    //   518: aload_0
    //   519: astore 5
    //   521: aload_2
    //   522: astore 4
    //   524: aload_0
    //   525: iconst_1
    //   526: invokevirtual 241	java/io/BufferedOutputStream:write	(I)V
    //   529: aload 7
    //   531: astore 6
    //   533: aload_0
    //   534: astore 5
    //   536: aload_2
    //   537: astore 4
    //   539: aload_0
    //   540: iload 13
    //   542: invokestatic 186	com/tencent/mobileqq/text/AppleEmojiManager:a	(Ljava/io/OutputStream;I)V
    //   545: aload 7
    //   547: astore 6
    //   549: aload_0
    //   550: astore 5
    //   552: aload_2
    //   553: astore 4
    //   555: aload_0
    //   556: iload 12
    //   558: invokestatic 186	com/tencent/mobileqq/text/AppleEmojiManager:a	(Ljava/io/OutputStream;I)V
    //   561: goto -178 -> 383
    //   564: astore 10
    //   566: aload 7
    //   568: astore 6
    //   570: aload_0
    //   571: astore 5
    //   573: aload_2
    //   574: astore 4
    //   576: ldc 8
    //   578: iconst_1
    //   579: invokestatic 246	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   582: ldc -8
    //   584: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload 9
    //   589: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: aload 10
    //   597: invokestatic 252	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   600: goto -217 -> 383
    //   603: astore 4
    //   605: aconst_null
    //   606: astore_1
    //   607: aload_0
    //   608: astore_3
    //   609: aload_2
    //   610: astore_0
    //   611: aload 4
    //   613: astore_2
    //   614: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   617: ifeq +12 -> 629
    //   620: ldc 8
    //   622: iconst_2
    //   623: ldc -2
    //   625: aload_2
    //   626: invokestatic 252	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   629: aload_0
    //   630: ifnull +7 -> 637
    //   633: aload_0
    //   634: invokevirtual 255	java/util/zip/ZipInputStream:close	()V
    //   637: aload_3
    //   638: ifnull +7 -> 645
    //   641: aload_3
    //   642: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   645: aload_1
    //   646: ifnull -625 -> 21
    //   649: invokestatic 131	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   652: aload_1
    //   653: invokevirtual 198	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   656: iconst_0
    //   657: ireturn
    //   658: astore_0
    //   659: aload_0
    //   660: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   663: iconst_0
    //   664: ireturn
    //   665: aload 7
    //   667: astore 6
    //   669: aload_0
    //   670: astore 5
    //   672: aload_2
    //   673: astore 4
    //   675: aload 9
    //   677: iconst_0
    //   678: aload 9
    //   680: invokevirtual 226	java/lang/String:length	()I
    //   683: iconst_4
    //   684: isub
    //   685: invokevirtual 229	java/lang/String:substring	(II)Ljava/lang/String;
    //   688: ldc -32
    //   690: invokevirtual 262	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   693: astore 10
    //   695: aload 7
    //   697: astore 6
    //   699: aload_0
    //   700: astore 5
    //   702: aload_2
    //   703: astore 4
    //   705: aload 8
    //   707: aload 9
    //   709: invokeinterface 233 2 0
    //   714: checkcast 171	java/lang/Integer
    //   717: invokevirtual 236	java/lang/Integer:intValue	()I
    //   720: istore 13
    //   722: aload 10
    //   724: ifnull -341 -> 383
    //   727: aload 7
    //   729: astore 6
    //   731: aload_0
    //   732: astore 5
    //   734: aload_2
    //   735: astore 4
    //   737: aload 10
    //   739: arraylength
    //   740: newarray <illegal type>
    //   742: astore 11
    //   744: iconst_0
    //   745: istore 12
    //   747: aload 7
    //   749: astore 6
    //   751: aload_0
    //   752: astore 5
    //   754: aload_2
    //   755: astore 4
    //   757: iload 12
    //   759: aload 10
    //   761: arraylength
    //   762: if_icmpge +41 -> 803
    //   765: aload 7
    //   767: astore 6
    //   769: aload_0
    //   770: astore 5
    //   772: aload_2
    //   773: astore 4
    //   775: aload 11
    //   777: iload 12
    //   779: aload 10
    //   781: iload 12
    //   783: aaload
    //   784: iconst_2
    //   785: invokevirtual 160	java/lang/String:substring	(I)Ljava/lang/String;
    //   788: bipush 16
    //   790: invokestatic 240	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   793: iastore
    //   794: iload 12
    //   796: iconst_1
    //   797: iadd
    //   798: istore 12
    //   800: goto -53 -> 747
    //   803: aload 7
    //   805: astore 6
    //   807: aload_0
    //   808: astore 5
    //   810: aload_2
    //   811: astore 4
    //   813: aload_0
    //   814: aload 10
    //   816: arraylength
    //   817: invokevirtual 241	java/io/BufferedOutputStream:write	(I)V
    //   820: iconst_0
    //   821: istore 12
    //   823: aload 7
    //   825: astore 6
    //   827: aload_0
    //   828: astore 5
    //   830: aload_2
    //   831: astore 4
    //   833: iload 12
    //   835: aload 11
    //   837: arraylength
    //   838: if_icmpge +31 -> 869
    //   841: aload 7
    //   843: astore 6
    //   845: aload_0
    //   846: astore 5
    //   848: aload_2
    //   849: astore 4
    //   851: aload_0
    //   852: aload 11
    //   854: iload 12
    //   856: iaload
    //   857: invokestatic 186	com/tencent/mobileqq/text/AppleEmojiManager:a	(Ljava/io/OutputStream;I)V
    //   860: iload 12
    //   862: iconst_1
    //   863: iadd
    //   864: istore 12
    //   866: goto -43 -> 823
    //   869: aload 7
    //   871: astore 6
    //   873: aload_0
    //   874: astore 5
    //   876: aload_2
    //   877: astore 4
    //   879: aload_0
    //   880: iload 13
    //   882: invokestatic 186	com/tencent/mobileqq/text/AppleEmojiManager:a	(Ljava/io/OutputStream;I)V
    //   885: goto -502 -> 383
    //   888: astore_1
    //   889: aload_3
    //   890: astore 6
    //   892: aload_0
    //   893: astore 5
    //   895: aload_2
    //   896: astore 4
    //   898: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   901: ifeq +22 -> 923
    //   904: aload_3
    //   905: astore 6
    //   907: aload_0
    //   908: astore 5
    //   910: aload_2
    //   911: astore 4
    //   913: ldc 8
    //   915: iconst_2
    //   916: ldc_w 264
    //   919: aload_1
    //   920: invokestatic 252	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   923: aload_2
    //   924: ifnull +7 -> 931
    //   927: aload_2
    //   928: invokevirtual 255	java/util/zip/ZipInputStream:close	()V
    //   931: aload_0
    //   932: ifnull +7 -> 939
    //   935: aload_0
    //   936: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   939: aload_3
    //   940: ifnull -919 -> 21
    //   943: invokestatic 131	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   946: aload_3
    //   947: invokevirtual 198	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   950: iconst_0
    //   951: ireturn
    //   952: astore_0
    //   953: aload_0
    //   954: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   957: iconst_0
    //   958: ireturn
    //   959: aload 7
    //   961: astore 6
    //   963: aload_0
    //   964: astore 5
    //   966: aload_2
    //   967: astore 4
    //   969: aload_0
    //   970: invokevirtual 194	java/io/BufferedOutputStream:flush	()V
    //   973: aload 7
    //   975: astore 6
    //   977: aload_0
    //   978: astore 5
    //   980: aload_2
    //   981: astore 4
    //   983: invokestatic 270	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   986: invokestatic 276	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   989: invokeinterface 282 1 0
    //   994: ldc_w 284
    //   997: iconst_1
    //   998: invokeinterface 290 3 0
    //   1003: invokeinterface 293 1 0
    //   1008: pop
    //   1009: aload 7
    //   1011: astore 6
    //   1013: aload_0
    //   1014: astore 5
    //   1016: aload_2
    //   1017: astore 4
    //   1019: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1022: ifeq +22 -> 1044
    //   1025: aload 7
    //   1027: astore 6
    //   1029: aload_0
    //   1030: astore 5
    //   1032: aload_2
    //   1033: astore 4
    //   1035: ldc 8
    //   1037: iconst_2
    //   1038: ldc_w 295
    //   1041: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1044: aload 7
    //   1046: astore 6
    //   1048: aload_0
    //   1049: astore 5
    //   1051: aload_2
    //   1052: astore 4
    //   1054: new 70	java/io/File
    //   1057: dup
    //   1058: getstatic 40	com/tencent/mobileqq/text/AppleEmojiManager:b	Ljava/lang/String;
    //   1061: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   1064: astore_1
    //   1065: aload 7
    //   1067: astore 6
    //   1069: aload_0
    //   1070: astore 5
    //   1072: aload_2
    //   1073: astore 4
    //   1075: new 70	java/io/File
    //   1078: dup
    //   1079: getstatic 44	com/tencent/mobileqq/text/AppleEmojiManager:c	Ljava/lang/String;
    //   1082: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   1085: astore 8
    //   1087: aload 7
    //   1089: astore 6
    //   1091: aload_0
    //   1092: astore 5
    //   1094: aload_2
    //   1095: astore 4
    //   1097: aload_1
    //   1098: invokevirtual 74	java/io/File:exists	()Z
    //   1101: ifeq +37 -> 1138
    //   1104: aload 7
    //   1106: astore 6
    //   1108: aload_0
    //   1109: astore 5
    //   1111: aload_2
    //   1112: astore 4
    //   1114: aload 8
    //   1116: invokevirtual 74	java/io/File:exists	()Z
    //   1119: ifeq +19 -> 1138
    //   1122: aload 7
    //   1124: astore 6
    //   1126: aload_0
    //   1127: astore 5
    //   1129: aload_2
    //   1130: astore 4
    //   1132: aload_1
    //   1133: aload 8
    //   1135: invokestatic 300	com/tencent/mobileqq/text/EmotcationConstants:a	(Ljava/io/File;Ljava/io/File;)V
    //   1138: aload 7
    //   1140: astore 6
    //   1142: aload_0
    //   1143: astore 5
    //   1145: aload_2
    //   1146: astore 4
    //   1148: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1151: ifeq +61 -> 1212
    //   1154: aload 7
    //   1156: astore 6
    //   1158: aload_0
    //   1159: astore 5
    //   1161: aload_2
    //   1162: astore 4
    //   1164: ldc 8
    //   1166: iconst_2
    //   1167: new 20	java/lang/StringBuilder
    //   1170: dup
    //   1171: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1174: ldc_w 302
    //   1177: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1180: getstatic 305	com/tencent/mobileqq/text/EmotcationConstants:jdField_a_of_type_AndroidUtilSparseIntArray	Landroid/util/SparseIntArray;
    //   1183: invokevirtual 310	android/util/SparseIntArray:size	()I
    //   1186: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1189: ldc_w 315
    //   1192: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: getstatic 318	com/tencent/mobileqq/text/EmotcationConstants:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   1198: invokeinterface 319 1 0
    //   1203: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1206: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1209: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1212: aload_2
    //   1213: ifnull +7 -> 1220
    //   1216: aload_2
    //   1217: invokevirtual 255	java/util/zip/ZipInputStream:close	()V
    //   1220: aload_0
    //   1221: ifnull +7 -> 1228
    //   1224: aload_0
    //   1225: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   1228: iconst_0
    //   1229: ifeq +10 -> 1239
    //   1232: invokestatic 131	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   1235: aconst_null
    //   1236: invokevirtual 198	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   1239: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1242: ifeq +34 -> 1276
    //   1245: ldc 8
    //   1247: iconst_2
    //   1248: new 20	java/lang/StringBuilder
    //   1251: dup
    //   1252: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1255: ldc_w 321
    //   1258: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: invokestatic 97	android/os/SystemClock:uptimeMillis	()J
    //   1264: lload 14
    //   1266: lsub
    //   1267: invokevirtual 324	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1270: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1273: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1276: iconst_1
    //   1277: ireturn
    //   1278: astore_0
    //   1279: aload_0
    //   1280: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   1283: goto -44 -> 1239
    //   1286: astore_0
    //   1287: aconst_null
    //   1288: astore_3
    //   1289: aconst_null
    //   1290: astore_2
    //   1291: aconst_null
    //   1292: astore_1
    //   1293: aload_2
    //   1294: ifnull +7 -> 1301
    //   1297: aload_2
    //   1298: invokevirtual 255	java/util/zip/ZipInputStream:close	()V
    //   1301: aload_3
    //   1302: ifnull +7 -> 1309
    //   1305: aload_3
    //   1306: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   1309: aload_1
    //   1310: ifnull +10 -> 1320
    //   1313: invokestatic 131	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   1316: aload_1
    //   1317: invokevirtual 198	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   1320: aload_0
    //   1321: athrow
    //   1322: astore_1
    //   1323: aload_1
    //   1324: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   1327: goto -7 -> 1320
    //   1330: astore_0
    //   1331: aconst_null
    //   1332: astore_3
    //   1333: aconst_null
    //   1334: astore_1
    //   1335: goto -42 -> 1293
    //   1338: astore_0
    //   1339: aconst_null
    //   1340: astore 4
    //   1342: aload_1
    //   1343: astore_3
    //   1344: aload 4
    //   1346: astore_1
    //   1347: goto -54 -> 1293
    //   1350: astore 5
    //   1352: aload_0
    //   1353: astore_3
    //   1354: aload_1
    //   1355: astore 4
    //   1357: aload 5
    //   1359: astore_0
    //   1360: aload_3
    //   1361: astore_1
    //   1362: aload 4
    //   1364: astore_3
    //   1365: goto -72 -> 1293
    //   1368: astore_0
    //   1369: aload_1
    //   1370: astore_3
    //   1371: aload 4
    //   1373: astore_1
    //   1374: goto -81 -> 1293
    //   1377: astore_0
    //   1378: aload 6
    //   1380: astore_1
    //   1381: aload 5
    //   1383: astore_3
    //   1384: aload 4
    //   1386: astore_2
    //   1387: goto -94 -> 1293
    //   1390: astore 4
    //   1392: aload_0
    //   1393: astore_2
    //   1394: aload 4
    //   1396: astore_0
    //   1397: goto -104 -> 1293
    //   1400: astore_1
    //   1401: aconst_null
    //   1402: astore_0
    //   1403: aconst_null
    //   1404: astore_2
    //   1405: aconst_null
    //   1406: astore_3
    //   1407: goto -518 -> 889
    //   1410: astore_1
    //   1411: aconst_null
    //   1412: astore_0
    //   1413: aconst_null
    //   1414: astore_3
    //   1415: goto -526 -> 889
    //   1418: astore 4
    //   1420: aconst_null
    //   1421: astore_3
    //   1422: aload_1
    //   1423: astore_0
    //   1424: aload 4
    //   1426: astore_1
    //   1427: goto -538 -> 889
    //   1430: astore_3
    //   1431: aload_1
    //   1432: astore 4
    //   1434: aload_3
    //   1435: astore_1
    //   1436: aload_0
    //   1437: astore_3
    //   1438: aload 4
    //   1440: astore_0
    //   1441: goto -552 -> 889
    //   1444: astore 4
    //   1446: aload_1
    //   1447: astore_0
    //   1448: aload 4
    //   1450: astore_1
    //   1451: goto -562 -> 889
    //   1454: astore_2
    //   1455: aload 4
    //   1457: astore_1
    //   1458: aload 5
    //   1460: astore_0
    //   1461: goto -847 -> 614
    //   1464: astore_1
    //   1465: aload_2
    //   1466: astore_0
    //   1467: aload_1
    //   1468: astore_2
    //   1469: aload 4
    //   1471: astore_1
    //   1472: goto -858 -> 614
    //   1475: astore 5
    //   1477: aload_1
    //   1478: astore_0
    //   1479: aload_2
    //   1480: astore 4
    //   1482: aload 5
    //   1484: astore_2
    //   1485: aload_3
    //   1486: astore_1
    //   1487: aload_0
    //   1488: astore_3
    //   1489: aload 4
    //   1491: astore_0
    //   1492: goto -878 -> 614
    //   1495: astore 5
    //   1497: aconst_null
    //   1498: astore 4
    //   1500: aload_1
    //   1501: astore_3
    //   1502: aload_2
    //   1503: astore_0
    //   1504: aload 5
    //   1506: astore_2
    //   1507: aload 4
    //   1509: astore_1
    //   1510: goto -896 -> 614
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1513	0	paramFile	java.io.File
    //   33	620	1	localObject1	Object
    //   888	32	1	localIOException1	java.io.IOException
    //   1064	253	1	localFile	java.io.File
    //   1322	2	1	localIOException2	java.io.IOException
    //   1334	47	1	localObject2	Object
    //   1400	1	1	localIOException3	java.io.IOException
    //   1410	13	1	localIOException4	java.io.IOException
    //   1426	32	1	localObject3	Object
    //   1464	4	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   1471	39	1	localObject4	Object
    //   84	1321	2	localObject5	Object
    //   1454	12	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   1468	39	2	localFileNotFoundException3	java.io.FileNotFoundException
    //   55	1367	3	localObject6	Object
    //   1430	5	3	localIOException5	java.io.IOException
    //   1437	65	3	localObject7	Object
    //   60	515	4	localObject8	Object
    //   603	9	4	localFileNotFoundException4	java.io.FileNotFoundException
    //   673	712	4	localObject9	Object
    //   1390	5	4	localObject10	Object
    //   1418	7	4	localIOException6	java.io.IOException
    //   1432	7	4	localObject11	Object
    //   1444	26	4	localIOException7	java.io.IOException
    //   1480	28	4	localObject12	Object
    //   52	1108	5	localObject13	Object
    //   1350	109	5	localObject14	Object
    //   1475	8	5	localFileNotFoundException5	java.io.FileNotFoundException
    //   1495	10	5	localFileNotFoundException6	java.io.FileNotFoundException
    //   57	1322	6	localObject15	Object
    //   320	835	7	localObject16	Object
    //   122	1012	8	localObject17	Object
    //   421	287	9	str1	String
    //   466	40	10	str2	String
    //   564	32	10	localException	Exception
    //   693	122	10	arrayOfString	String[]
    //   742	111	11	arrayOfInt	int[]
    //   138	727	12	i	int
    //   241	640	13	j	int
    //   49	1216	14	l	long
    // Exception table:
    //   from	to	target	type
    //   433	443	564	java/lang/Exception
    //   453	468	564	java/lang/Exception
    //   478	495	564	java/lang/Exception
    //   505	514	564	java/lang/Exception
    //   524	529	564	java/lang/Exception
    //   539	545	564	java/lang/Exception
    //   555	561	564	java/lang/Exception
    //   675	695	564	java/lang/Exception
    //   705	722	564	java/lang/Exception
    //   737	744	564	java/lang/Exception
    //   757	765	564	java/lang/Exception
    //   775	794	564	java/lang/Exception
    //   813	820	564	java/lang/Exception
    //   833	841	564	java/lang/Exception
    //   851	860	564	java/lang/Exception
    //   879	885	564	java/lang/Exception
    //   370	383	603	java/io/FileNotFoundException
    //   393	402	603	java/io/FileNotFoundException
    //   412	423	603	java/io/FileNotFoundException
    //   433	443	603	java/io/FileNotFoundException
    //   453	468	603	java/io/FileNotFoundException
    //   478	495	603	java/io/FileNotFoundException
    //   505	514	603	java/io/FileNotFoundException
    //   524	529	603	java/io/FileNotFoundException
    //   539	545	603	java/io/FileNotFoundException
    //   555	561	603	java/io/FileNotFoundException
    //   576	600	603	java/io/FileNotFoundException
    //   675	695	603	java/io/FileNotFoundException
    //   705	722	603	java/io/FileNotFoundException
    //   737	744	603	java/io/FileNotFoundException
    //   757	765	603	java/io/FileNotFoundException
    //   775	794	603	java/io/FileNotFoundException
    //   813	820	603	java/io/FileNotFoundException
    //   833	841	603	java/io/FileNotFoundException
    //   851	860	603	java/io/FileNotFoundException
    //   879	885	603	java/io/FileNotFoundException
    //   969	973	603	java/io/FileNotFoundException
    //   983	1009	603	java/io/FileNotFoundException
    //   1019	1025	603	java/io/FileNotFoundException
    //   1035	1044	603	java/io/FileNotFoundException
    //   1054	1065	603	java/io/FileNotFoundException
    //   1075	1087	603	java/io/FileNotFoundException
    //   1097	1104	603	java/io/FileNotFoundException
    //   1114	1122	603	java/io/FileNotFoundException
    //   1132	1138	603	java/io/FileNotFoundException
    //   1148	1154	603	java/io/FileNotFoundException
    //   1164	1212	603	java/io/FileNotFoundException
    //   633	637	658	java/io/IOException
    //   641	645	658	java/io/IOException
    //   649	656	658	java/io/IOException
    //   370	383	888	java/io/IOException
    //   393	402	888	java/io/IOException
    //   412	423	888	java/io/IOException
    //   433	443	888	java/io/IOException
    //   453	468	888	java/io/IOException
    //   478	495	888	java/io/IOException
    //   505	514	888	java/io/IOException
    //   524	529	888	java/io/IOException
    //   539	545	888	java/io/IOException
    //   555	561	888	java/io/IOException
    //   576	600	888	java/io/IOException
    //   675	695	888	java/io/IOException
    //   705	722	888	java/io/IOException
    //   737	744	888	java/io/IOException
    //   757	765	888	java/io/IOException
    //   775	794	888	java/io/IOException
    //   813	820	888	java/io/IOException
    //   833	841	888	java/io/IOException
    //   851	860	888	java/io/IOException
    //   879	885	888	java/io/IOException
    //   969	973	888	java/io/IOException
    //   983	1009	888	java/io/IOException
    //   1019	1025	888	java/io/IOException
    //   1035	1044	888	java/io/IOException
    //   1054	1065	888	java/io/IOException
    //   1075	1087	888	java/io/IOException
    //   1097	1104	888	java/io/IOException
    //   1114	1122	888	java/io/IOException
    //   1132	1138	888	java/io/IOException
    //   1148	1154	888	java/io/IOException
    //   1164	1212	888	java/io/IOException
    //   927	931	952	java/io/IOException
    //   935	939	952	java/io/IOException
    //   943	950	952	java/io/IOException
    //   1216	1220	1278	java/io/IOException
    //   1224	1228	1278	java/io/IOException
    //   1232	1239	1278	java/io/IOException
    //   62	85	1286	finally
    //   1297	1301	1322	java/io/IOException
    //   1305	1309	1322	java/io/IOException
    //   1313	1320	1322	java/io/IOException
    //   85	103	1330	finally
    //   106	124	1338	finally
    //   127	137	1338	finally
    //   142	148	1350	finally
    //   155	162	1350	finally
    //   168	178	1350	finally
    //   180	199	1350	finally
    //   206	216	1350	finally
    //   218	233	1350	finally
    //   235	243	1350	finally
    //   251	257	1350	finally
    //   265	272	1350	finally
    //   280	288	1350	finally
    //   300	304	1350	finally
    //   309	316	1350	finally
    //   324	342	1368	finally
    //   342	360	1368	finally
    //   370	383	1377	finally
    //   393	402	1377	finally
    //   412	423	1377	finally
    //   433	443	1377	finally
    //   453	468	1377	finally
    //   478	495	1377	finally
    //   505	514	1377	finally
    //   524	529	1377	finally
    //   539	545	1377	finally
    //   555	561	1377	finally
    //   576	600	1377	finally
    //   675	695	1377	finally
    //   705	722	1377	finally
    //   737	744	1377	finally
    //   757	765	1377	finally
    //   775	794	1377	finally
    //   813	820	1377	finally
    //   833	841	1377	finally
    //   851	860	1377	finally
    //   879	885	1377	finally
    //   898	904	1377	finally
    //   913	923	1377	finally
    //   969	973	1377	finally
    //   983	1009	1377	finally
    //   1019	1025	1377	finally
    //   1035	1044	1377	finally
    //   1054	1065	1377	finally
    //   1075	1087	1377	finally
    //   1097	1104	1377	finally
    //   1114	1122	1377	finally
    //   1132	1138	1377	finally
    //   1148	1154	1377	finally
    //   1164	1212	1377	finally
    //   614	629	1390	finally
    //   62	85	1400	java/io/IOException
    //   85	103	1410	java/io/IOException
    //   106	124	1418	java/io/IOException
    //   127	137	1418	java/io/IOException
    //   142	148	1430	java/io/IOException
    //   155	162	1430	java/io/IOException
    //   168	178	1430	java/io/IOException
    //   180	199	1430	java/io/IOException
    //   206	216	1430	java/io/IOException
    //   218	233	1430	java/io/IOException
    //   235	243	1430	java/io/IOException
    //   251	257	1430	java/io/IOException
    //   265	272	1430	java/io/IOException
    //   280	288	1430	java/io/IOException
    //   300	304	1430	java/io/IOException
    //   309	316	1430	java/io/IOException
    //   324	342	1444	java/io/IOException
    //   342	360	1444	java/io/IOException
    //   62	85	1454	java/io/FileNotFoundException
    //   85	103	1464	java/io/FileNotFoundException
    //   106	124	1475	java/io/FileNotFoundException
    //   127	137	1475	java/io/FileNotFoundException
    //   142	148	1475	java/io/FileNotFoundException
    //   155	162	1475	java/io/FileNotFoundException
    //   168	178	1475	java/io/FileNotFoundException
    //   180	199	1475	java/io/FileNotFoundException
    //   206	216	1475	java/io/FileNotFoundException
    //   218	233	1475	java/io/FileNotFoundException
    //   235	243	1475	java/io/FileNotFoundException
    //   251	257	1475	java/io/FileNotFoundException
    //   265	272	1475	java/io/FileNotFoundException
    //   280	288	1475	java/io/FileNotFoundException
    //   300	304	1475	java/io/FileNotFoundException
    //   309	316	1475	java/io/FileNotFoundException
    //   324	342	1495	java/io/FileNotFoundException
    //   342	360	1495	java/io/FileNotFoundException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\text\AppleEmojiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */