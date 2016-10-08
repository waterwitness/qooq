package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class FileDownloader
{
  public static final int a = 32768;
  public static final String a = "Q.qqstory.download.preload.FileDownloader";
  public static final int b = 0;
  public List a;
  public volatile boolean a;
  public volatile String b;
  public int c;
  public int d;
  
  public FileDownloader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = 32768;
    this.d = 0;
  }
  
  /* Error */
  private int a(String paramString1, int paramInt1, String paramString2, String paramString3, HashMap paramHashMap, int paramInt2, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_3
    //   2: putfield 47	com/tencent/biz/qqstory/base/preload/FileDownloader:b	Ljava/lang/String;
    //   5: aload_3
    //   6: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +8 -> 17
    //   12: bipush 14
    //   14: istore_2
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore 34
    //   20: aload_3
    //   21: ldc 55
    //   23: invokevirtual 60	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   26: ifeq +3552 -> 3578
    //   29: iconst_4
    //   30: invokestatic 65	com/tencent/biz/qqstory/model/SuperManager:a	(I)Lcom/tencent/biz/qqstory/model/IManager;
    //   33: checkcast 67	com/tencent/biz/qqstory/base/VideoServerInfoManager
    //   36: invokevirtual 70	com/tencent/biz/qqstory/base/VideoServerInfoManager:a	()Ljava/lang/String;
    //   39: astore 10
    //   41: ldc 10
    //   43: ldc 72
    //   45: aload 10
    //   47: invokestatic 77	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   50: aload 10
    //   52: ifnonnull +7 -> 59
    //   55: sipush 200
    //   58: ireturn
    //   59: aload_3
    //   60: ldc 79
    //   62: aload 10
    //   64: invokestatic 84	com/tencent/util/URLUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   67: astore 29
    //   69: iconst_1
    //   70: istore 35
    //   72: aload_0
    //   73: iconst_0
    //   74: putfield 86	com/tencent/biz/qqstory/base/preload/FileDownloader:jdField_a_of_type_Boolean	Z
    //   77: ldc 10
    //   79: new 88	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   86: ldc 91
    //   88: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload 4
    //   93: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 101	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: ldc 10
    //   104: new 88	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   111: ldc 103
    //   113: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload 29
    //   118: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 101	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aconst_null
    //   128: astore 12
    //   130: aconst_null
    //   131: astore 16
    //   133: aconst_null
    //   134: astore 10
    //   136: aconst_null
    //   137: astore 14
    //   139: aconst_null
    //   140: astore 15
    //   142: aconst_null
    //   143: astore 18
    //   145: aconst_null
    //   146: astore_3
    //   147: aconst_null
    //   148: astore 11
    //   150: aconst_null
    //   151: astore 26
    //   153: aconst_null
    //   154: astore 21
    //   156: aconst_null
    //   157: astore 25
    //   159: aconst_null
    //   160: astore 23
    //   162: aconst_null
    //   163: astore 19
    //   165: aconst_null
    //   166: astore 24
    //   168: aconst_null
    //   169: astore 20
    //   171: aconst_null
    //   172: astore 17
    //   174: aconst_null
    //   175: astore 22
    //   177: iload 6
    //   179: ifle +232 -> 411
    //   182: iload 6
    //   184: istore 36
    //   186: new 105	java/net/URL
    //   189: dup
    //   190: aload 29
    //   192: invokespecial 108	java/net/URL:<init>	(Ljava/lang/String;)V
    //   195: astore 30
    //   197: aload 30
    //   199: invokestatic 113	com/tencent/biz/qqstory/base/download/URLChecker:a	(Ljava/net/URL;)Z
    //   202: ifne +3373 -> 3575
    //   205: aload 30
    //   207: invokestatic 116	com/tencent/biz/qqstory/base/download/URLChecker:a	(Ljava/net/URL;)Ljava/net/URL;
    //   210: astore 30
    //   212: aload 4
    //   214: invokestatic 121	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/io/File;
    //   217: astore 32
    //   219: aload 32
    //   221: invokevirtual 127	java/io/File:exists	()Z
    //   224: ifne +9 -> 233
    //   227: aload 32
    //   229: invokevirtual 130	java/io/File:createNewFile	()Z
    //   232: pop
    //   233: new 132	java/io/RandomAccessFile
    //   236: dup
    //   237: aload 32
    //   239: ldc -122
    //   241: invokespecial 137	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   244: astore 13
    //   246: iconst_0
    //   247: istore 33
    //   249: aconst_null
    //   250: astore 10
    //   252: aload 26
    //   254: astore_3
    //   255: iload 34
    //   257: istore 6
    //   259: aload 10
    //   261: astore 17
    //   263: aload_3
    //   264: astore 14
    //   266: aload 10
    //   268: astore 15
    //   270: aload_3
    //   271: astore 11
    //   273: aload 10
    //   275: astore 16
    //   277: aload_3
    //   278: astore 12
    //   280: aload_3
    //   281: astore 22
    //   283: aload_3
    //   284: astore 20
    //   286: aload_3
    //   287: astore 18
    //   289: aload_3
    //   290: astore 21
    //   292: aload_3
    //   293: astore 19
    //   295: aload_0
    //   296: getfield 29	com/tencent/biz/qqstory/base/preload/FileDownloader:d	I
    //   299: istore 34
    //   301: iload 33
    //   303: iload 34
    //   305: if_icmple +115 -> 420
    //   308: aload 10
    //   310: astore_1
    //   311: aload 13
    //   313: astore 14
    //   315: aload_3
    //   316: astore 11
    //   318: aload_1
    //   319: astore 10
    //   321: aload_3
    //   322: astore 25
    //   324: aload_1
    //   325: astore 20
    //   327: aload_3
    //   328: astore 18
    //   330: aload_1
    //   331: astore 15
    //   333: aload_3
    //   334: astore 17
    //   336: aload_1
    //   337: astore 16
    //   339: aload_3
    //   340: astore 24
    //   342: aload_1
    //   343: astore 23
    //   345: aload_3
    //   346: astore 27
    //   348: aload_1
    //   349: astore 22
    //   351: aload_3
    //   352: astore 28
    //   354: aload_1
    //   355: astore 21
    //   357: aload_3
    //   358: astore 26
    //   360: aload_1
    //   361: astore 19
    //   363: aload 13
    //   365: invokevirtual 140	java/io/RandomAccessFile:close	()V
    //   368: aload_3
    //   369: ifnull +7 -> 376
    //   372: aload_3
    //   373: invokevirtual 145	java/net/HttpURLConnection:disconnect	()V
    //   376: aload_1
    //   377: ifnull +7 -> 384
    //   380: aload_1
    //   381: invokevirtual 148	java/io/InputStream:close	()V
    //   384: iload 6
    //   386: istore_2
    //   387: iconst_0
    //   388: ifeq -373 -> 15
    //   391: new 150	java/lang/NullPointerException
    //   394: dup
    //   395: invokespecial 151	java/lang/NullPointerException:<init>	()V
    //   398: athrow
    //   399: astore_1
    //   400: ldc 10
    //   402: ldc -103
    //   404: aload_1
    //   405: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   408: iload 6
    //   410: ireturn
    //   411: aload_0
    //   412: getfield 27	com/tencent/biz/qqstory/base/preload/FileDownloader:c	I
    //   415: istore 36
    //   417: goto -231 -> 186
    //   420: aload 10
    //   422: astore 17
    //   424: aload_3
    //   425: astore 14
    //   427: aload 10
    //   429: astore 15
    //   431: aload_3
    //   432: astore 11
    //   434: aload 10
    //   436: astore 16
    //   438: aload_3
    //   439: astore 12
    //   441: aload_3
    //   442: astore 22
    //   444: aload_3
    //   445: astore 20
    //   447: aload_3
    //   448: astore 18
    //   450: aload_3
    //   451: astore 21
    //   453: aload_3
    //   454: astore 19
    //   456: aload_0
    //   457: getfield 86	com/tencent/biz/qqstory/base/preload/FileDownloader:jdField_a_of_type_Boolean	Z
    //   460: ifeq +13 -> 473
    //   463: bipush 6
    //   465: istore 6
    //   467: aload 10
    //   469: astore_1
    //   470: goto -159 -> 311
    //   473: aload 10
    //   475: astore 17
    //   477: aload_3
    //   478: astore 14
    //   480: aload 10
    //   482: astore 15
    //   484: aload_3
    //   485: astore 11
    //   487: aload 10
    //   489: astore 16
    //   491: aload_3
    //   492: astore 12
    //   494: aload_3
    //   495: astore 22
    //   497: aload_3
    //   498: astore 20
    //   500: aload_3
    //   501: astore 18
    //   503: aload_3
    //   504: astore 21
    //   506: aload_3
    //   507: astore 19
    //   509: invokestatic 162	java/lang/System:currentTimeMillis	()J
    //   512: lstore 39
    //   514: aload 10
    //   516: astore 17
    //   518: aload_3
    //   519: astore 14
    //   521: aload 10
    //   523: astore 15
    //   525: aload_3
    //   526: astore 11
    //   528: aload 10
    //   530: astore 16
    //   532: aload_3
    //   533: astore 12
    //   535: aload_3
    //   536: astore 22
    //   538: aload_3
    //   539: astore 20
    //   541: aload_3
    //   542: astore 18
    //   544: aload_3
    //   545: astore 21
    //   547: aload_3
    //   548: astore 19
    //   550: aload_0
    //   551: aload_3
    //   552: aload 10
    //   554: invokespecial 165	com/tencent/biz/qqstory/base/preload/FileDownloader:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   557: aload 10
    //   559: astore 17
    //   561: aload_3
    //   562: astore 14
    //   564: aload 10
    //   566: astore 15
    //   568: aload_3
    //   569: astore 11
    //   571: aload 10
    //   573: astore 16
    //   575: aload_3
    //   576: astore 12
    //   578: aload_3
    //   579: astore 22
    //   581: aload_3
    //   582: astore 20
    //   584: aload_3
    //   585: astore 18
    //   587: aload_3
    //   588: astore 21
    //   590: aload_3
    //   591: astore 19
    //   593: aload 30
    //   595: invokevirtual 169	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   598: checkcast 142	java/net/HttpURLConnection
    //   601: astore_3
    //   602: aload 10
    //   604: astore 17
    //   606: aload_3
    //   607: astore 14
    //   609: aload 10
    //   611: astore 15
    //   613: aload_3
    //   614: astore 11
    //   616: aload 10
    //   618: astore 16
    //   620: aload_3
    //   621: astore 12
    //   623: aload_3
    //   624: astore 22
    //   626: aload_3
    //   627: astore 20
    //   629: aload_3
    //   630: astore 18
    //   632: aload_3
    //   633: astore 21
    //   635: aload_3
    //   636: astore 19
    //   638: aload_3
    //   639: iconst_0
    //   640: invokevirtual 173	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   643: aload 10
    //   645: astore 17
    //   647: aload_3
    //   648: astore 14
    //   650: aload 10
    //   652: astore 15
    //   654: aload_3
    //   655: astore 11
    //   657: aload 10
    //   659: astore 16
    //   661: aload_3
    //   662: astore 12
    //   664: aload_3
    //   665: astore 22
    //   667: aload_3
    //   668: astore 20
    //   670: aload_3
    //   671: astore 18
    //   673: aload_3
    //   674: astore 21
    //   676: aload_3
    //   677: astore 19
    //   679: aload_3
    //   680: sipush 5000
    //   683: invokevirtual 177	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   686: aload 10
    //   688: astore 17
    //   690: aload_3
    //   691: astore 14
    //   693: aload 10
    //   695: astore 15
    //   697: aload_3
    //   698: astore 11
    //   700: aload 10
    //   702: astore 16
    //   704: aload_3
    //   705: astore 12
    //   707: aload_3
    //   708: astore 22
    //   710: aload_3
    //   711: astore 20
    //   713: aload_3
    //   714: astore 18
    //   716: aload_3
    //   717: astore 21
    //   719: aload_3
    //   720: astore 19
    //   722: aload_3
    //   723: sipush 5000
    //   726: invokevirtual 180	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   729: aload 10
    //   731: astore 17
    //   733: aload_3
    //   734: astore 14
    //   736: aload 10
    //   738: astore 15
    //   740: aload_3
    //   741: astore 11
    //   743: aload 10
    //   745: astore 16
    //   747: aload_3
    //   748: astore 12
    //   750: aload_3
    //   751: astore 22
    //   753: aload_3
    //   754: astore 20
    //   756: aload_3
    //   757: astore 18
    //   759: aload_3
    //   760: astore 21
    //   762: aload_3
    //   763: astore 19
    //   765: aload_3
    //   766: ldc -74
    //   768: ldc -72
    //   770: invokevirtual 187	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   773: aload 10
    //   775: astore 17
    //   777: aload_3
    //   778: astore 14
    //   780: aload 10
    //   782: astore 15
    //   784: aload_3
    //   785: astore 11
    //   787: aload 10
    //   789: astore 16
    //   791: aload_3
    //   792: astore 12
    //   794: aload_3
    //   795: astore 22
    //   797: aload_3
    //   798: astore 20
    //   800: aload_3
    //   801: astore 18
    //   803: aload_3
    //   804: astore 21
    //   806: aload_3
    //   807: astore 19
    //   809: aload_3
    //   810: ldc -67
    //   812: new 88	java/lang/StringBuilder
    //   815: dup
    //   816: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   819: ldc -65
    //   821: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: lload 7
    //   826: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   829: ldc -60
    //   831: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: invokevirtual 187	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   840: aload 10
    //   842: astore 17
    //   844: aload_3
    //   845: astore 14
    //   847: aload 10
    //   849: astore 15
    //   851: aload_3
    //   852: astore 11
    //   854: aload 10
    //   856: astore 16
    //   858: aload_3
    //   859: astore 12
    //   861: aload_3
    //   862: astore 22
    //   864: aload_3
    //   865: astore 20
    //   867: aload_3
    //   868: astore 18
    //   870: aload_3
    //   871: astore 21
    //   873: aload_3
    //   874: astore 19
    //   876: ldc 10
    //   878: new 88	java/lang/StringBuilder
    //   881: dup
    //   882: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   885: ldc -58
    //   887: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: lload 7
    //   892: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   895: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   898: invokestatic 101	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   901: aload 10
    //   903: astore 17
    //   905: aload_3
    //   906: astore 14
    //   908: aload 10
    //   910: astore 15
    //   912: aload_3
    //   913: astore 11
    //   915: aload 10
    //   917: astore 16
    //   919: aload_3
    //   920: astore 12
    //   922: aload_3
    //   923: astore 22
    //   925: aload_3
    //   926: astore 20
    //   928: aload_3
    //   929: astore 18
    //   931: aload_3
    //   932: astore 21
    //   934: aload_3
    //   935: astore 19
    //   937: aload 13
    //   939: lload 7
    //   941: invokevirtual 202	java/io/RandomAccessFile:seek	(J)V
    //   944: iload 35
    //   946: ifne +45 -> 991
    //   949: aload 10
    //   951: astore 17
    //   953: aload_3
    //   954: astore 14
    //   956: aload 10
    //   958: astore 15
    //   960: aload_3
    //   961: astore 11
    //   963: aload 10
    //   965: astore 16
    //   967: aload_3
    //   968: astore 12
    //   970: aload_3
    //   971: astore 22
    //   973: aload_3
    //   974: astore 20
    //   976: aload_3
    //   977: astore 18
    //   979: aload_3
    //   980: astore 21
    //   982: aload_3
    //   983: astore 19
    //   985: aload 5
    //   987: aload_3
    //   988: invokestatic 205	com/tencent/biz/qqstory/base/preload/FileDownloader:a	(Ljava/util/HashMap;Ljava/net/HttpURLConnection;)V
    //   991: aload 10
    //   993: astore 17
    //   995: aload_3
    //   996: astore 14
    //   998: aload 10
    //   1000: astore 15
    //   1002: aload_3
    //   1003: astore 11
    //   1005: aload 10
    //   1007: astore 16
    //   1009: aload_3
    //   1010: astore 12
    //   1012: aload_3
    //   1013: astore 22
    //   1015: aload_3
    //   1016: astore 20
    //   1018: aload_3
    //   1019: astore 18
    //   1021: aload_3
    //   1022: astore 21
    //   1024: aload_3
    //   1025: astore 19
    //   1027: aload_3
    //   1028: invokevirtual 209	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1031: astore 23
    //   1033: aload 23
    //   1035: astore 12
    //   1037: aload 13
    //   1039: astore 14
    //   1041: aload_3
    //   1042: astore 11
    //   1044: aload 12
    //   1046: astore 10
    //   1048: aload_3
    //   1049: astore 18
    //   1051: aload 12
    //   1053: astore 15
    //   1055: aload_3
    //   1056: astore 17
    //   1058: aload 12
    //   1060: astore 16
    //   1062: lload 7
    //   1064: aload_3
    //   1065: invokevirtual 213	java/net/HttpURLConnection:getContentLength	()I
    //   1068: i2l
    //   1069: ladd
    //   1070: lstore 37
    //   1072: aload 13
    //   1074: astore 14
    //   1076: aload_3
    //   1077: astore 11
    //   1079: aload 12
    //   1081: astore 10
    //   1083: aload_3
    //   1084: astore 18
    //   1086: aload 12
    //   1088: astore 15
    //   1090: aload_3
    //   1091: astore 17
    //   1093: aload 12
    //   1095: astore 16
    //   1097: new 215	com/tencent/biz/qqstory/base/preload/FileDownloader$HttpBuffer
    //   1100: dup
    //   1101: aload_0
    //   1102: aload 13
    //   1104: aload_1
    //   1105: iload_2
    //   1106: aload 29
    //   1108: aload 32
    //   1110: iload 36
    //   1112: lload 7
    //   1114: lload 37
    //   1116: invokespecial 218	com/tencent/biz/qqstory/base/preload/FileDownloader$HttpBuffer:<init>	(Lcom/tencent/biz/qqstory/base/preload/FileDownloader;Ljava/io/RandomAccessFile;Ljava/lang/String;ILjava/lang/String;Ljava/io/File;IJJ)V
    //   1119: astore 19
    //   1121: aload 13
    //   1123: astore 14
    //   1125: aload_3
    //   1126: astore 11
    //   1128: aload 12
    //   1130: astore 10
    //   1132: aload_3
    //   1133: astore 18
    //   1135: aload 12
    //   1137: astore 15
    //   1139: aload_3
    //   1140: astore 17
    //   1142: aload 12
    //   1144: astore 16
    //   1146: aload 19
    //   1148: aload 12
    //   1150: invokevirtual 221	com/tencent/biz/qqstory/base/preload/FileDownloader$HttpBuffer:a	(Ljava/io/InputStream;)I
    //   1153: iconst_m1
    //   1154: if_icmpeq +2418 -> 3572
    //   1157: aload 13
    //   1159: astore 14
    //   1161: aload_3
    //   1162: astore 11
    //   1164: aload 12
    //   1166: astore 10
    //   1168: aload_3
    //   1169: astore 18
    //   1171: aload 12
    //   1173: astore 15
    //   1175: aload_3
    //   1176: astore 17
    //   1178: aload 12
    //   1180: astore 16
    //   1182: aload_0
    //   1183: getfield 86	com/tencent/biz/qqstory/base/preload/FileDownloader:jdField_a_of_type_Boolean	Z
    //   1186: ifeq +307 -> 1493
    //   1189: bipush 6
    //   1191: istore 6
    //   1193: iload 6
    //   1195: istore 34
    //   1197: iload 6
    //   1199: ifne +123 -> 1322
    //   1202: aload 13
    //   1204: astore 14
    //   1206: aload_3
    //   1207: astore 11
    //   1209: aload 12
    //   1211: astore 10
    //   1213: aload_3
    //   1214: astore 18
    //   1216: aload 12
    //   1218: astore 15
    //   1220: aload_3
    //   1221: astore 17
    //   1223: aload 12
    //   1225: astore 16
    //   1227: aload 32
    //   1229: invokevirtual 224	java/io/File:length	()J
    //   1232: lload 37
    //   1234: lcmp
    //   1235: ifne +556 -> 1791
    //   1238: aload 13
    //   1240: astore 14
    //   1242: aload_3
    //   1243: astore 11
    //   1245: aload 12
    //   1247: astore 10
    //   1249: aload_3
    //   1250: astore 18
    //   1252: aload 12
    //   1254: astore 15
    //   1256: aload_3
    //   1257: astore 17
    //   1259: aload 12
    //   1261: astore 16
    //   1263: ldc 10
    //   1265: new 88	java/lang/StringBuilder
    //   1268: dup
    //   1269: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1272: ldc -30
    //   1274: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: lload 37
    //   1279: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1282: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1285: invokestatic 101	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1288: aload 13
    //   1290: astore 14
    //   1292: aload_3
    //   1293: astore 11
    //   1295: aload 12
    //   1297: astore 10
    //   1299: aload_3
    //   1300: astore 18
    //   1302: aload 12
    //   1304: astore 15
    //   1306: aload_3
    //   1307: astore 17
    //   1309: aload 12
    //   1311: astore 16
    //   1313: aload 32
    //   1315: invokestatic 231	com/tencent/biz/qqstory/base/preload/PreloadUtils:a	(Ljava/io/File;)V
    //   1318: iload 6
    //   1320: istore 34
    //   1322: aload 13
    //   1324: astore 14
    //   1326: aload_3
    //   1327: astore 11
    //   1329: aload 12
    //   1331: astore 10
    //   1333: aload_3
    //   1334: astore 18
    //   1336: aload 12
    //   1338: astore 15
    //   1340: aload_3
    //   1341: astore 17
    //   1343: aload 12
    //   1345: astore 16
    //   1347: aload_0
    //   1348: aload_3
    //   1349: aload 12
    //   1351: invokespecial 165	com/tencent/biz/qqstory/base/preload/FileDownloader:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   1354: aload 13
    //   1356: astore 14
    //   1358: aload_3
    //   1359: astore 11
    //   1361: aload 12
    //   1363: astore 10
    //   1365: aload_3
    //   1366: astore 18
    //   1368: aload 12
    //   1370: astore 15
    //   1372: aload_3
    //   1373: astore 17
    //   1375: aload 12
    //   1377: astore 16
    //   1379: invokestatic 162	java/lang/System:currentTimeMillis	()J
    //   1382: lload 39
    //   1384: lsub
    //   1385: lstore 39
    //   1387: aload 13
    //   1389: astore 14
    //   1391: aload_3
    //   1392: astore 11
    //   1394: aload 12
    //   1396: astore 10
    //   1398: aload_3
    //   1399: astore 18
    //   1401: aload 12
    //   1403: astore 15
    //   1405: aload_3
    //   1406: astore 17
    //   1408: aload 12
    //   1410: astore 16
    //   1412: ldc 10
    //   1414: ldc -23
    //   1416: lload 37
    //   1418: invokestatic 239	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1421: lload 39
    //   1423: invokestatic 239	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1426: lload 37
    //   1428: lload 39
    //   1430: ldiv
    //   1431: invokestatic 239	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1434: aload 29
    //   1436: invokestatic 242	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   1439: iload 34
    //   1441: istore 6
    //   1443: aload 12
    //   1445: astore_1
    //   1446: goto -1135 -> 311
    //   1449: astore_1
    //   1450: aload 12
    //   1452: astore 10
    //   1454: aload 10
    //   1456: astore 17
    //   1458: aload_3
    //   1459: astore 14
    //   1461: aload 10
    //   1463: astore 15
    //   1465: aload_3
    //   1466: astore 11
    //   1468: aload 10
    //   1470: astore 16
    //   1472: aload_3
    //   1473: astore 12
    //   1475: ldc 10
    //   1477: ldc -12
    //   1479: aload_1
    //   1480: invokestatic 246	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1483: bipush 6
    //   1485: istore 6
    //   1487: aload 10
    //   1489: astore_1
    //   1490: goto -1179 -> 311
    //   1493: iload 9
    //   1495: ifeq +47 -> 1542
    //   1498: aload 13
    //   1500: astore 14
    //   1502: aload_3
    //   1503: astore 11
    //   1505: aload 12
    //   1507: astore 10
    //   1509: aload_3
    //   1510: astore 18
    //   1512: aload 12
    //   1514: astore 15
    //   1516: aload_3
    //   1517: astore 17
    //   1519: aload 12
    //   1521: astore 16
    //   1523: invokestatic 252	com/tencent/mobileqq/pluginsdk/PluginRuntime:getRuntime	()Lcom/tencent/mobileqq/pluginsdk/PluginRuntime;
    //   1526: invokevirtual 256	com/tencent/mobileqq/pluginsdk/PluginRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   1529: invokestatic 262	com/weiyun/sdk/util/NetworkUtils:isWIFI	(Landroid/content/Context;)Z
    //   1532: ifne +10 -> 1542
    //   1535: bipush 7
    //   1537: istore 6
    //   1539: goto -346 -> 1193
    //   1542: aload 13
    //   1544: astore 14
    //   1546: aload_3
    //   1547: astore 11
    //   1549: aload 12
    //   1551: astore 10
    //   1553: aload_3
    //   1554: astore 18
    //   1556: aload 12
    //   1558: astore 15
    //   1560: aload_3
    //   1561: astore 17
    //   1563: aload 12
    //   1565: astore 16
    //   1567: lconst_0
    //   1568: invokestatic 267	java/lang/Thread:sleep	(J)V
    //   1571: goto -450 -> 1121
    //   1574: astore 31
    //   1576: aload 13
    //   1578: astore 14
    //   1580: aload_3
    //   1581: astore 11
    //   1583: aload 12
    //   1585: astore 10
    //   1587: aload_3
    //   1588: astore 25
    //   1590: aload 12
    //   1592: astore 20
    //   1594: aload_3
    //   1595: astore 18
    //   1597: aload 12
    //   1599: astore 15
    //   1601: aload_3
    //   1602: astore 17
    //   1604: aload 12
    //   1606: astore 16
    //   1608: aload_3
    //   1609: astore 24
    //   1611: aload 12
    //   1613: astore 23
    //   1615: aload_3
    //   1616: astore 27
    //   1618: aload 12
    //   1620: astore 22
    //   1622: aload_3
    //   1623: astore 28
    //   1625: aload 12
    //   1627: astore 21
    //   1629: aload_3
    //   1630: astore 26
    //   1632: aload 12
    //   1634: astore 19
    //   1636: ldc 10
    //   1638: ldc -12
    //   1640: aload 31
    //   1642: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1645: aload 13
    //   1647: astore 14
    //   1649: aload_3
    //   1650: astore 11
    //   1652: aload 12
    //   1654: astore 10
    //   1656: aload_3
    //   1657: astore 25
    //   1659: aload 12
    //   1661: astore 20
    //   1663: aload_3
    //   1664: astore 18
    //   1666: aload 12
    //   1668: astore 15
    //   1670: aload_3
    //   1671: astore 17
    //   1673: aload 12
    //   1675: astore 16
    //   1677: aload_3
    //   1678: astore 24
    //   1680: aload 12
    //   1682: astore 23
    //   1684: aload_3
    //   1685: astore 27
    //   1687: aload 12
    //   1689: astore 22
    //   1691: aload_3
    //   1692: astore 28
    //   1694: aload 12
    //   1696: astore 21
    //   1698: aload_3
    //   1699: astore 26
    //   1701: aload 12
    //   1703: astore 19
    //   1705: invokestatic 271	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1708: pop
    //   1709: aload 13
    //   1711: astore 14
    //   1713: aload_3
    //   1714: astore 11
    //   1716: aload 12
    //   1718: astore 10
    //   1720: aload_3
    //   1721: astore 25
    //   1723: aload 12
    //   1725: astore 20
    //   1727: aload_3
    //   1728: astore 18
    //   1730: aload 12
    //   1732: astore 15
    //   1734: aload_3
    //   1735: astore 17
    //   1737: aload 12
    //   1739: astore 16
    //   1741: aload_3
    //   1742: astore 24
    //   1744: aload 12
    //   1746: astore 23
    //   1748: aload_3
    //   1749: astore 27
    //   1751: aload 12
    //   1753: astore 22
    //   1755: aload_3
    //   1756: astore 28
    //   1758: aload 12
    //   1760: astore 21
    //   1762: aload_3
    //   1763: astore 26
    //   1765: aload 12
    //   1767: astore 19
    //   1769: ldc2_w 272
    //   1772: invokestatic 267	java/lang/Thread:sleep	(J)V
    //   1775: iconst_1
    //   1776: istore 6
    //   1778: iload 33
    //   1780: iconst_1
    //   1781: iadd
    //   1782: istore 33
    //   1784: aload 12
    //   1786: astore 10
    //   1788: goto -1529 -> 259
    //   1791: aload 13
    //   1793: astore 14
    //   1795: aload_3
    //   1796: astore 11
    //   1798: aload 12
    //   1800: astore 10
    //   1802: aload_3
    //   1803: astore 18
    //   1805: aload 12
    //   1807: astore 15
    //   1809: aload_3
    //   1810: astore 17
    //   1812: aload 12
    //   1814: astore 16
    //   1816: ldc 10
    //   1818: new 88	java/lang/StringBuilder
    //   1821: dup
    //   1822: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1825: ldc_w 275
    //   1828: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1831: lload 37
    //   1833: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1836: ldc_w 277
    //   1839: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1842: aload 32
    //   1844: invokevirtual 224	java/io/File:length	()J
    //   1847: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1850: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1853: invokestatic 279	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1856: aload 13
    //   1858: astore 14
    //   1860: aload_3
    //   1861: astore 11
    //   1863: aload 12
    //   1865: astore 10
    //   1867: aload_3
    //   1868: astore 18
    //   1870: aload 12
    //   1872: astore 15
    //   1874: aload_3
    //   1875: astore 17
    //   1877: aload 12
    //   1879: astore 16
    //   1881: aload 32
    //   1883: invokevirtual 282	java/io/File:delete	()Z
    //   1886: pop
    //   1887: bipush 13
    //   1889: istore 34
    //   1891: goto -569 -> 1322
    //   1894: astore 31
    //   1896: aload 13
    //   1898: astore 14
    //   1900: aload_3
    //   1901: astore 11
    //   1903: aload 12
    //   1905: astore 10
    //   1907: aload_3
    //   1908: astore 25
    //   1910: aload 12
    //   1912: astore 20
    //   1914: aload_3
    //   1915: astore 18
    //   1917: aload 12
    //   1919: astore 15
    //   1921: aload_3
    //   1922: astore 17
    //   1924: aload 12
    //   1926: astore 16
    //   1928: aload_3
    //   1929: astore 24
    //   1931: aload 12
    //   1933: astore 23
    //   1935: aload_3
    //   1936: astore 27
    //   1938: aload 12
    //   1940: astore 22
    //   1942: aload_3
    //   1943: astore 28
    //   1945: aload 12
    //   1947: astore 21
    //   1949: aload_3
    //   1950: astore 26
    //   1952: aload 12
    //   1954: astore 19
    //   1956: ldc 10
    //   1958: ldc -12
    //   1960: aload 31
    //   1962: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1965: aload 13
    //   1967: astore 14
    //   1969: aload_3
    //   1970: astore 11
    //   1972: aload 12
    //   1974: astore 10
    //   1976: aload_3
    //   1977: astore 25
    //   1979: aload 12
    //   1981: astore 20
    //   1983: aload_3
    //   1984: astore 18
    //   1986: aload 12
    //   1988: astore 15
    //   1990: aload_3
    //   1991: astore 17
    //   1993: aload 12
    //   1995: astore 16
    //   1997: aload_3
    //   1998: astore 24
    //   2000: aload 12
    //   2002: astore 23
    //   2004: aload_3
    //   2005: astore 27
    //   2007: aload 12
    //   2009: astore 22
    //   2011: aload_3
    //   2012: astore 28
    //   2014: aload 12
    //   2016: astore 21
    //   2018: aload_3
    //   2019: astore 26
    //   2021: aload 12
    //   2023: astore 19
    //   2025: invokestatic 271	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2028: pop
    //   2029: aload 13
    //   2031: astore 14
    //   2033: aload_3
    //   2034: astore 11
    //   2036: aload 12
    //   2038: astore 10
    //   2040: aload_3
    //   2041: astore 25
    //   2043: aload 12
    //   2045: astore 20
    //   2047: aload_3
    //   2048: astore 18
    //   2050: aload 12
    //   2052: astore 15
    //   2054: aload_3
    //   2055: astore 17
    //   2057: aload 12
    //   2059: astore 16
    //   2061: aload_3
    //   2062: astore 24
    //   2064: aload 12
    //   2066: astore 23
    //   2068: aload_3
    //   2069: astore 27
    //   2071: aload 12
    //   2073: astore 22
    //   2075: aload_3
    //   2076: astore 28
    //   2078: aload 12
    //   2080: astore 21
    //   2082: aload_3
    //   2083: astore 26
    //   2085: aload 12
    //   2087: astore 19
    //   2089: ldc2_w 272
    //   2092: invokestatic 267	java/lang/Thread:sleep	(J)V
    //   2095: iconst_2
    //   2096: istore 6
    //   2098: iload 33
    //   2100: iconst_1
    //   2101: iadd
    //   2102: istore 33
    //   2104: aload 12
    //   2106: astore 10
    //   2108: goto -1849 -> 259
    //   2111: aload 13
    //   2113: astore 14
    //   2115: aload_3
    //   2116: astore 11
    //   2118: aload 12
    //   2120: astore 10
    //   2122: aload_3
    //   2123: astore 25
    //   2125: aload 12
    //   2127: astore 20
    //   2129: aload_3
    //   2130: astore 18
    //   2132: aload 12
    //   2134: astore 15
    //   2136: aload_3
    //   2137: astore 17
    //   2139: aload 12
    //   2141: astore 16
    //   2143: aload_3
    //   2144: astore 24
    //   2146: aload 12
    //   2148: astore 23
    //   2150: aload_3
    //   2151: astore 27
    //   2153: aload 12
    //   2155: astore 22
    //   2157: aload_3
    //   2158: astore 28
    //   2160: aload 12
    //   2162: astore 21
    //   2164: aload_3
    //   2165: astore 26
    //   2167: aload 12
    //   2169: astore 19
    //   2171: ldc 10
    //   2173: ldc -12
    //   2175: aload 31
    //   2177: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2180: aload 13
    //   2182: astore 14
    //   2184: aload_3
    //   2185: astore 11
    //   2187: aload 12
    //   2189: astore 10
    //   2191: aload_3
    //   2192: astore 25
    //   2194: aload 12
    //   2196: astore 20
    //   2198: aload_3
    //   2199: astore 18
    //   2201: aload 12
    //   2203: astore 15
    //   2205: aload_3
    //   2206: astore 17
    //   2208: aload 12
    //   2210: astore 16
    //   2212: aload_3
    //   2213: astore 24
    //   2215: aload 12
    //   2217: astore 23
    //   2219: aload_3
    //   2220: astore 27
    //   2222: aload 12
    //   2224: astore 22
    //   2226: aload_3
    //   2227: astore 28
    //   2229: aload 12
    //   2231: astore 21
    //   2233: aload_3
    //   2234: astore 26
    //   2236: aload 12
    //   2238: astore 19
    //   2240: invokestatic 271	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2243: pop
    //   2244: aload 13
    //   2246: astore 14
    //   2248: aload_3
    //   2249: astore 11
    //   2251: aload 12
    //   2253: astore 10
    //   2255: aload_3
    //   2256: astore 25
    //   2258: aload 12
    //   2260: astore 20
    //   2262: aload_3
    //   2263: astore 18
    //   2265: aload 12
    //   2267: astore 15
    //   2269: aload_3
    //   2270: astore 17
    //   2272: aload 12
    //   2274: astore 16
    //   2276: aload_3
    //   2277: astore 24
    //   2279: aload 12
    //   2281: astore 23
    //   2283: aload_3
    //   2284: astore 27
    //   2286: aload 12
    //   2288: astore 22
    //   2290: aload_3
    //   2291: astore 28
    //   2293: aload 12
    //   2295: astore 21
    //   2297: aload_3
    //   2298: astore 26
    //   2300: aload 12
    //   2302: astore 19
    //   2304: ldc2_w 272
    //   2307: invokestatic 267	java/lang/Thread:sleep	(J)V
    //   2310: iconst_3
    //   2311: istore 6
    //   2313: iload 33
    //   2315: iconst_1
    //   2316: iadd
    //   2317: istore 33
    //   2319: aload 12
    //   2321: astore 10
    //   2323: goto -2064 -> 259
    //   2326: aload 13
    //   2328: astore 14
    //   2330: aload_3
    //   2331: astore 11
    //   2333: aload 12
    //   2335: astore 10
    //   2337: aload_3
    //   2338: astore 25
    //   2340: aload 12
    //   2342: astore 20
    //   2344: aload_3
    //   2345: astore 18
    //   2347: aload 12
    //   2349: astore 15
    //   2351: aload_3
    //   2352: astore 17
    //   2354: aload 12
    //   2356: astore 16
    //   2358: aload_3
    //   2359: astore 24
    //   2361: aload 12
    //   2363: astore 23
    //   2365: aload_3
    //   2366: astore 27
    //   2368: aload 12
    //   2370: astore 22
    //   2372: aload_3
    //   2373: astore 28
    //   2375: aload 12
    //   2377: astore 21
    //   2379: aload_3
    //   2380: astore 26
    //   2382: aload 12
    //   2384: astore 19
    //   2386: ldc 10
    //   2388: ldc -12
    //   2390: aload 31
    //   2392: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2395: aload 13
    //   2397: astore 14
    //   2399: aload_3
    //   2400: astore 11
    //   2402: aload 12
    //   2404: astore 10
    //   2406: aload_3
    //   2407: astore 25
    //   2409: aload 12
    //   2411: astore 20
    //   2413: aload_3
    //   2414: astore 18
    //   2416: aload 12
    //   2418: astore 15
    //   2420: aload_3
    //   2421: astore 17
    //   2423: aload 12
    //   2425: astore 16
    //   2427: aload_3
    //   2428: astore 24
    //   2430: aload 12
    //   2432: astore 23
    //   2434: aload_3
    //   2435: astore 27
    //   2437: aload 12
    //   2439: astore 22
    //   2441: aload_3
    //   2442: astore 28
    //   2444: aload 12
    //   2446: astore 21
    //   2448: aload_3
    //   2449: astore 26
    //   2451: aload 12
    //   2453: astore 19
    //   2455: invokestatic 271	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2458: pop
    //   2459: aload 13
    //   2461: astore 14
    //   2463: aload_3
    //   2464: astore 11
    //   2466: aload 12
    //   2468: astore 10
    //   2470: aload_3
    //   2471: astore 25
    //   2473: aload 12
    //   2475: astore 20
    //   2477: aload_3
    //   2478: astore 18
    //   2480: aload 12
    //   2482: astore 15
    //   2484: aload_3
    //   2485: astore 17
    //   2487: aload 12
    //   2489: astore 16
    //   2491: aload_3
    //   2492: astore 24
    //   2494: aload 12
    //   2496: astore 23
    //   2498: aload_3
    //   2499: astore 27
    //   2501: aload 12
    //   2503: astore 22
    //   2505: aload_3
    //   2506: astore 28
    //   2508: aload 12
    //   2510: astore 21
    //   2512: aload_3
    //   2513: astore 26
    //   2515: aload 12
    //   2517: astore 19
    //   2519: ldc2_w 272
    //   2522: invokestatic 267	java/lang/Thread:sleep	(J)V
    //   2525: iconst_5
    //   2526: istore 6
    //   2528: iload 33
    //   2530: iconst_1
    //   2531: iadd
    //   2532: istore 33
    //   2534: aload 12
    //   2536: astore 10
    //   2538: goto -2279 -> 259
    //   2541: astore_3
    //   2542: ldc 10
    //   2544: ldc_w 284
    //   2547: aload_3
    //   2548: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2551: goto -2175 -> 376
    //   2554: astore_1
    //   2555: ldc 10
    //   2557: ldc -103
    //   2559: aload_1
    //   2560: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2563: goto -2179 -> 384
    //   2566: astore_1
    //   2567: aconst_null
    //   2568: astore 13
    //   2570: aload 22
    //   2572: astore 19
    //   2574: aload 12
    //   2576: astore_3
    //   2577: aload 13
    //   2579: astore 14
    //   2581: aload_3
    //   2582: astore 11
    //   2584: aload 19
    //   2586: astore 10
    //   2588: ldc 10
    //   2590: ldc -103
    //   2592: aload_1
    //   2593: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2596: bipush 6
    //   2598: istore_2
    //   2599: aload_3
    //   2600: ifnull +7 -> 2607
    //   2603: aload_3
    //   2604: invokevirtual 145	java/net/HttpURLConnection:disconnect	()V
    //   2607: aload 19
    //   2609: ifnull +8 -> 2617
    //   2612: aload 19
    //   2614: invokevirtual 148	java/io/InputStream:close	()V
    //   2617: aload 13
    //   2619: ifnull -2604 -> 15
    //   2622: aload 13
    //   2624: invokevirtual 140	java/io/RandomAccessFile:close	()V
    //   2627: bipush 6
    //   2629: ireturn
    //   2630: astore_1
    //   2631: ldc 10
    //   2633: ldc -103
    //   2635: aload_1
    //   2636: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2639: bipush 6
    //   2641: ireturn
    //   2642: astore_1
    //   2643: ldc 10
    //   2645: ldc_w 284
    //   2648: aload_1
    //   2649: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2652: goto -45 -> 2607
    //   2655: astore_1
    //   2656: ldc 10
    //   2658: ldc -103
    //   2660: aload_1
    //   2661: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2664: goto -47 -> 2617
    //   2667: astore_1
    //   2668: aconst_null
    //   2669: astore 13
    //   2671: aload 16
    //   2673: astore_3
    //   2674: aload 13
    //   2676: astore 14
    //   2678: aload_3
    //   2679: astore 11
    //   2681: aload 21
    //   2683: astore 10
    //   2685: ldc 10
    //   2687: ldc -103
    //   2689: aload_1
    //   2690: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2693: iconst_2
    //   2694: istore_2
    //   2695: aload_3
    //   2696: ifnull +7 -> 2703
    //   2699: aload_3
    //   2700: invokevirtual 145	java/net/HttpURLConnection:disconnect	()V
    //   2703: aload 21
    //   2705: ifnull +8 -> 2713
    //   2708: aload 21
    //   2710: invokevirtual 148	java/io/InputStream:close	()V
    //   2713: aload 13
    //   2715: ifnull -2700 -> 15
    //   2718: aload 13
    //   2720: invokevirtual 140	java/io/RandomAccessFile:close	()V
    //   2723: iconst_2
    //   2724: ireturn
    //   2725: astore_1
    //   2726: ldc 10
    //   2728: ldc -103
    //   2730: aload_1
    //   2731: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2734: iconst_2
    //   2735: ireturn
    //   2736: astore_1
    //   2737: ldc 10
    //   2739: ldc_w 284
    //   2742: aload_1
    //   2743: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2746: goto -43 -> 2703
    //   2749: astore_1
    //   2750: ldc 10
    //   2752: ldc -103
    //   2754: aload_1
    //   2755: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2758: goto -45 -> 2713
    //   2761: astore_1
    //   2762: aconst_null
    //   2763: astore 13
    //   2765: aload 25
    //   2767: astore 22
    //   2769: aload 10
    //   2771: astore_3
    //   2772: aload 13
    //   2774: astore 14
    //   2776: aload_3
    //   2777: astore 11
    //   2779: aload 22
    //   2781: astore 10
    //   2783: ldc 10
    //   2785: ldc -103
    //   2787: aload_1
    //   2788: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2791: iconst_1
    //   2792: istore_2
    //   2793: aload_3
    //   2794: ifnull +7 -> 2801
    //   2797: aload_3
    //   2798: invokevirtual 145	java/net/HttpURLConnection:disconnect	()V
    //   2801: aload 22
    //   2803: ifnull +8 -> 2811
    //   2806: aload 22
    //   2808: invokevirtual 148	java/io/InputStream:close	()V
    //   2811: aload 13
    //   2813: ifnull -2798 -> 15
    //   2816: aload 13
    //   2818: invokevirtual 140	java/io/RandomAccessFile:close	()V
    //   2821: iconst_1
    //   2822: ireturn
    //   2823: astore_1
    //   2824: ldc 10
    //   2826: ldc -103
    //   2828: aload_1
    //   2829: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2832: iconst_1
    //   2833: ireturn
    //   2834: astore_1
    //   2835: ldc 10
    //   2837: ldc_w 284
    //   2840: aload_1
    //   2841: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2844: goto -43 -> 2801
    //   2847: astore_1
    //   2848: ldc 10
    //   2850: ldc -103
    //   2852: aload_1
    //   2853: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2856: goto -45 -> 2811
    //   2859: astore_1
    //   2860: aconst_null
    //   2861: astore 13
    //   2863: aload 14
    //   2865: astore_3
    //   2866: aload 13
    //   2868: astore 14
    //   2870: aload_3
    //   2871: astore 11
    //   2873: aload 23
    //   2875: astore 10
    //   2877: new 123	java/io/File
    //   2880: dup
    //   2881: aload 4
    //   2883: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   2886: astore 4
    //   2888: aload 13
    //   2890: astore 14
    //   2892: aload_3
    //   2893: astore 11
    //   2895: aload 23
    //   2897: astore 10
    //   2899: aload 4
    //   2901: invokevirtual 127	java/io/File:exists	()Z
    //   2904: ifeq +20 -> 2924
    //   2907: aload 13
    //   2909: astore 14
    //   2911: aload_3
    //   2912: astore 11
    //   2914: aload 23
    //   2916: astore 10
    //   2918: aload 4
    //   2920: invokevirtual 282	java/io/File:delete	()Z
    //   2923: pop
    //   2924: aload 13
    //   2926: astore 14
    //   2928: aload_3
    //   2929: astore 11
    //   2931: aload 23
    //   2933: astore 10
    //   2935: ldc 10
    //   2937: ldc -103
    //   2939: aload_1
    //   2940: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2943: iconst_3
    //   2944: istore_2
    //   2945: aload_3
    //   2946: ifnull +7 -> 2953
    //   2949: aload_3
    //   2950: invokevirtual 145	java/net/HttpURLConnection:disconnect	()V
    //   2953: aload 23
    //   2955: ifnull +8 -> 2963
    //   2958: aload 23
    //   2960: invokevirtual 148	java/io/InputStream:close	()V
    //   2963: aload 13
    //   2965: ifnull -2950 -> 15
    //   2968: aload 13
    //   2970: invokevirtual 140	java/io/RandomAccessFile:close	()V
    //   2973: iconst_3
    //   2974: ireturn
    //   2975: astore_1
    //   2976: ldc 10
    //   2978: ldc -103
    //   2980: aload_1
    //   2981: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2984: iconst_3
    //   2985: ireturn
    //   2986: astore_1
    //   2987: ldc 10
    //   2989: ldc_w 284
    //   2992: aload_1
    //   2993: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2996: goto -43 -> 2953
    //   2999: astore_1
    //   3000: ldc 10
    //   3002: ldc -103
    //   3004: aload_1
    //   3005: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3008: goto -45 -> 2963
    //   3011: astore_1
    //   3012: aconst_null
    //   3013: astore 13
    //   3015: aload 19
    //   3017: astore 16
    //   3019: aload 15
    //   3021: astore 12
    //   3023: aload 13
    //   3025: astore 14
    //   3027: aload 12
    //   3029: astore 11
    //   3031: aload 16
    //   3033: astore 10
    //   3035: ldc 10
    //   3037: new 88	java/lang/StringBuilder
    //   3040: dup
    //   3041: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   3044: ldc_w 287
    //   3047: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3050: aload 29
    //   3052: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3055: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3058: aload_1
    //   3059: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3062: iconst_4
    //   3063: istore_2
    //   3064: aload 12
    //   3066: ifnull +8 -> 3074
    //   3069: aload 12
    //   3071: invokevirtual 145	java/net/HttpURLConnection:disconnect	()V
    //   3074: aload 16
    //   3076: ifnull +8 -> 3084
    //   3079: aload 16
    //   3081: invokevirtual 148	java/io/InputStream:close	()V
    //   3084: aload 13
    //   3086: ifnull -3071 -> 15
    //   3089: aload 13
    //   3091: invokevirtual 140	java/io/RandomAccessFile:close	()V
    //   3094: iconst_4
    //   3095: ireturn
    //   3096: astore_1
    //   3097: ldc 10
    //   3099: ldc -103
    //   3101: aload_1
    //   3102: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3105: iconst_4
    //   3106: ireturn
    //   3107: astore_1
    //   3108: ldc 10
    //   3110: ldc_w 284
    //   3113: aload_1
    //   3114: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3117: goto -43 -> 3074
    //   3120: astore_1
    //   3121: ldc 10
    //   3123: ldc -103
    //   3125: aload_1
    //   3126: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3129: goto -45 -> 3084
    //   3132: astore_1
    //   3133: aconst_null
    //   3134: astore 13
    //   3136: aload 24
    //   3138: astore 15
    //   3140: aload 13
    //   3142: astore 14
    //   3144: aload 18
    //   3146: astore 11
    //   3148: aload 15
    //   3150: astore 10
    //   3152: ldc 10
    //   3154: ldc -103
    //   3156: aload_1
    //   3157: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3160: iconst_1
    //   3161: istore_2
    //   3162: aload 18
    //   3164: ifnull +8 -> 3172
    //   3167: aload 18
    //   3169: invokevirtual 145	java/net/HttpURLConnection:disconnect	()V
    //   3172: aload 15
    //   3174: ifnull +8 -> 3182
    //   3177: aload 15
    //   3179: invokevirtual 148	java/io/InputStream:close	()V
    //   3182: aload 13
    //   3184: ifnull -3169 -> 15
    //   3187: aload 13
    //   3189: invokevirtual 140	java/io/RandomAccessFile:close	()V
    //   3192: iconst_1
    //   3193: ireturn
    //   3194: astore_1
    //   3195: ldc 10
    //   3197: ldc -103
    //   3199: aload_1
    //   3200: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3203: iconst_1
    //   3204: ireturn
    //   3205: astore_1
    //   3206: ldc 10
    //   3208: ldc_w 284
    //   3211: aload_1
    //   3212: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3215: goto -43 -> 3172
    //   3218: astore_1
    //   3219: ldc 10
    //   3221: ldc -103
    //   3223: aload_1
    //   3224: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3227: goto -45 -> 3182
    //   3230: astore_1
    //   3231: aconst_null
    //   3232: astore 13
    //   3234: aload 13
    //   3236: astore 14
    //   3238: aload_3
    //   3239: astore 11
    //   3241: aload 20
    //   3243: astore 10
    //   3245: ldc 10
    //   3247: ldc -103
    //   3249: aload_1
    //   3250: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3253: iconst_5
    //   3254: istore_2
    //   3255: aload_3
    //   3256: ifnull +7 -> 3263
    //   3259: aload_3
    //   3260: invokevirtual 145	java/net/HttpURLConnection:disconnect	()V
    //   3263: aload 20
    //   3265: ifnull +8 -> 3273
    //   3268: aload 20
    //   3270: invokevirtual 148	java/io/InputStream:close	()V
    //   3273: aload 13
    //   3275: ifnull -3260 -> 15
    //   3278: aload 13
    //   3280: invokevirtual 140	java/io/RandomAccessFile:close	()V
    //   3283: iconst_5
    //   3284: ireturn
    //   3285: astore_1
    //   3286: ldc 10
    //   3288: ldc -103
    //   3290: aload_1
    //   3291: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3294: iconst_5
    //   3295: ireturn
    //   3296: astore_1
    //   3297: ldc 10
    //   3299: ldc_w 284
    //   3302: aload_1
    //   3303: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3306: goto -43 -> 3263
    //   3309: astore_1
    //   3310: ldc 10
    //   3312: ldc -103
    //   3314: aload_1
    //   3315: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3318: goto -45 -> 3273
    //   3321: astore_1
    //   3322: aconst_null
    //   3323: astore 13
    //   3325: aload 17
    //   3327: astore 10
    //   3329: aload 11
    //   3331: ifnull +8 -> 3339
    //   3334: aload 11
    //   3336: invokevirtual 145	java/net/HttpURLConnection:disconnect	()V
    //   3339: aload 10
    //   3341: ifnull +8 -> 3349
    //   3344: aload 10
    //   3346: invokevirtual 148	java/io/InputStream:close	()V
    //   3349: aload 13
    //   3351: ifnull +8 -> 3359
    //   3354: aload 13
    //   3356: invokevirtual 140	java/io/RandomAccessFile:close	()V
    //   3359: aload_1
    //   3360: athrow
    //   3361: astore_3
    //   3362: ldc 10
    //   3364: ldc_w 284
    //   3367: aload_3
    //   3368: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3371: goto -32 -> 3339
    //   3374: astore_3
    //   3375: ldc 10
    //   3377: ldc -103
    //   3379: aload_3
    //   3380: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3383: goto -34 -> 3349
    //   3386: astore_3
    //   3387: ldc 10
    //   3389: ldc -103
    //   3391: aload_3
    //   3392: invokestatic 156	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3395: goto -36 -> 3359
    //   3398: astore_1
    //   3399: aload 14
    //   3401: astore 13
    //   3403: goto -74 -> 3329
    //   3406: astore_1
    //   3407: aload 17
    //   3409: astore 10
    //   3411: aload 14
    //   3413: astore 11
    //   3415: goto -86 -> 3329
    //   3418: astore_1
    //   3419: aload 10
    //   3421: astore 20
    //   3423: goto -189 -> 3234
    //   3426: astore_1
    //   3427: aload 25
    //   3429: astore_3
    //   3430: goto -196 -> 3234
    //   3433: astore_1
    //   3434: goto -294 -> 3140
    //   3437: astore_1
    //   3438: aload 11
    //   3440: astore 18
    //   3442: goto -302 -> 3140
    //   3445: astore_1
    //   3446: aload 17
    //   3448: astore 12
    //   3450: goto -427 -> 3023
    //   3453: astore_1
    //   3454: goto -431 -> 3023
    //   3457: astore_1
    //   3458: aload 10
    //   3460: astore 23
    //   3462: goto -596 -> 2866
    //   3465: astore_1
    //   3466: aload 24
    //   3468: astore_3
    //   3469: goto -603 -> 2866
    //   3472: astore_1
    //   3473: aload 10
    //   3475: astore 22
    //   3477: goto -705 -> 2772
    //   3480: astore_1
    //   3481: aload 27
    //   3483: astore_3
    //   3484: goto -712 -> 2772
    //   3487: astore_1
    //   3488: aload 10
    //   3490: astore 21
    //   3492: goto -818 -> 2674
    //   3495: astore_1
    //   3496: aload 28
    //   3498: astore_3
    //   3499: goto -825 -> 2674
    //   3502: astore_1
    //   3503: aload 10
    //   3505: astore 19
    //   3507: goto -930 -> 2577
    //   3510: astore_1
    //   3511: aload 26
    //   3513: astore_3
    //   3514: goto -937 -> 2577
    //   3517: astore 31
    //   3519: aload 22
    //   3521: astore_3
    //   3522: aload 10
    //   3524: astore 12
    //   3526: goto -1200 -> 2326
    //   3529: astore 31
    //   3531: aload 20
    //   3533: astore_3
    //   3534: aload 10
    //   3536: astore 12
    //   3538: goto -1427 -> 2111
    //   3541: astore 31
    //   3543: aload 18
    //   3545: astore_3
    //   3546: aload 10
    //   3548: astore 12
    //   3550: goto -1654 -> 1896
    //   3553: astore 31
    //   3555: aload 21
    //   3557: astore_3
    //   3558: aload 10
    //   3560: astore 12
    //   3562: goto -1986 -> 1576
    //   3565: astore_1
    //   3566: aload 19
    //   3568: astore_3
    //   3569: goto -2115 -> 1454
    //   3572: goto -2379 -> 1193
    //   3575: goto -3363 -> 212
    //   3578: iconst_0
    //   3579: istore 35
    //   3581: aload_3
    //   3582: astore 29
    //   3584: goto -3512 -> 72
    //   3587: astore 31
    //   3589: goto -1478 -> 2111
    //   3592: astore 31
    //   3594: goto -1268 -> 2326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3597	0	this	FileDownloader
    //   0	3597	1	paramString1	String
    //   0	3597	2	paramInt1	int
    //   0	3597	3	paramString2	String
    //   0	3597	4	paramString3	String
    //   0	3597	5	paramHashMap	HashMap
    //   0	3597	6	paramInt2	int
    //   0	3597	7	paramLong	long
    //   0	3597	9	paramBoolean	boolean
    //   39	3520	10	localObject1	Object
    //   148	3291	11	localObject2	Object
    //   128	3433	12	localObject3	Object
    //   244	3158	13	localObject4	Object
    //   137	3275	14	localObject5	Object
    //   140	3038	15	localObject6	Object
    //   131	2949	16	localObject7	Object
    //   172	3275	17	localObject8	Object
    //   143	3401	18	localObject9	Object
    //   163	3404	19	localObject10	Object
    //   169	3363	20	localObject11	Object
    //   154	3402	21	localObject12	Object
    //   175	3345	22	localObject13	Object
    //   160	3301	23	localObject14	Object
    //   166	3301	24	str1	String
    //   157	3271	25	str2	String
    //   151	3361	26	str3	String
    //   346	3136	27	str4	String
    //   352	3145	28	str5	String
    //   67	3516	29	str6	String
    //   195	399	30	localURL	java.net.URL
    //   1574	67	31	localSocketException1	java.net.SocketException
    //   1894	497	31	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   3517	1	31	localException1	Exception
    //   3529	1	31	localFileNotFoundException1	java.io.FileNotFoundException
    //   3541	1	31	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   3553	1	31	localSocketException2	java.net.SocketException
    //   3587	1	31	localFileNotFoundException2	java.io.FileNotFoundException
    //   3592	1	31	localException2	Exception
    //   217	1665	32	localFile	java.io.File
    //   247	2286	33	i	int
    //   18	1872	34	j	int
    //   70	3510	35	k	int
    //   184	927	36	m	int
    //   1070	762	37	l1	long
    //   512	917	39	l2	long
    // Exception table:
    //   from	to	target	type
    //   391	399	399	java/io/IOException
    //   1062	1072	1449	java/lang/InterruptedException
    //   1097	1121	1449	java/lang/InterruptedException
    //   1146	1157	1449	java/lang/InterruptedException
    //   1182	1189	1449	java/lang/InterruptedException
    //   1227	1238	1449	java/lang/InterruptedException
    //   1263	1288	1449	java/lang/InterruptedException
    //   1313	1318	1449	java/lang/InterruptedException
    //   1347	1354	1449	java/lang/InterruptedException
    //   1379	1387	1449	java/lang/InterruptedException
    //   1412	1439	1449	java/lang/InterruptedException
    //   1523	1535	1449	java/lang/InterruptedException
    //   1567	1571	1449	java/lang/InterruptedException
    //   1816	1856	1449	java/lang/InterruptedException
    //   1881	1887	1449	java/lang/InterruptedException
    //   1062	1072	1574	java/net/SocketException
    //   1097	1121	1574	java/net/SocketException
    //   1146	1157	1574	java/net/SocketException
    //   1182	1189	1574	java/net/SocketException
    //   1227	1238	1574	java/net/SocketException
    //   1263	1288	1574	java/net/SocketException
    //   1313	1318	1574	java/net/SocketException
    //   1347	1354	1574	java/net/SocketException
    //   1379	1387	1574	java/net/SocketException
    //   1412	1439	1574	java/net/SocketException
    //   1523	1535	1574	java/net/SocketException
    //   1567	1571	1574	java/net/SocketException
    //   1816	1856	1574	java/net/SocketException
    //   1881	1887	1574	java/net/SocketException
    //   1062	1072	1894	java/net/SocketTimeoutException
    //   1097	1121	1894	java/net/SocketTimeoutException
    //   1146	1157	1894	java/net/SocketTimeoutException
    //   1182	1189	1894	java/net/SocketTimeoutException
    //   1227	1238	1894	java/net/SocketTimeoutException
    //   1263	1288	1894	java/net/SocketTimeoutException
    //   1313	1318	1894	java/net/SocketTimeoutException
    //   1347	1354	1894	java/net/SocketTimeoutException
    //   1379	1387	1894	java/net/SocketTimeoutException
    //   1412	1439	1894	java/net/SocketTimeoutException
    //   1523	1535	1894	java/net/SocketTimeoutException
    //   1567	1571	1894	java/net/SocketTimeoutException
    //   1816	1856	1894	java/net/SocketTimeoutException
    //   1881	1887	1894	java/net/SocketTimeoutException
    //   372	376	2541	java/lang/Exception
    //   380	384	2554	java/lang/Exception
    //   186	212	2566	java/lang/InterruptedException
    //   212	233	2566	java/lang/InterruptedException
    //   233	246	2566	java/lang/InterruptedException
    //   2622	2627	2630	java/io/IOException
    //   2603	2607	2642	java/lang/Exception
    //   2612	2617	2655	java/lang/Exception
    //   186	212	2667	java/net/SocketTimeoutException
    //   212	233	2667	java/net/SocketTimeoutException
    //   233	246	2667	java/net/SocketTimeoutException
    //   2718	2723	2725	java/io/IOException
    //   2699	2703	2736	java/lang/Exception
    //   2708	2713	2749	java/lang/Exception
    //   186	212	2761	java/net/SocketException
    //   212	233	2761	java/net/SocketException
    //   233	246	2761	java/net/SocketException
    //   2816	2821	2823	java/io/IOException
    //   2797	2801	2834	java/lang/Exception
    //   2806	2811	2847	java/lang/Exception
    //   186	212	2859	java/io/FileNotFoundException
    //   212	233	2859	java/io/FileNotFoundException
    //   233	246	2859	java/io/FileNotFoundException
    //   2968	2973	2975	java/io/IOException
    //   2949	2953	2986	java/lang/Exception
    //   2958	2963	2999	java/lang/Exception
    //   186	212	3011	java/net/MalformedURLException
    //   212	233	3011	java/net/MalformedURLException
    //   233	246	3011	java/net/MalformedURLException
    //   3089	3094	3096	java/io/IOException
    //   3069	3074	3107	java/lang/Exception
    //   3079	3084	3120	java/lang/Exception
    //   186	212	3132	java/io/IOException
    //   212	233	3132	java/io/IOException
    //   233	246	3132	java/io/IOException
    //   3187	3192	3194	java/io/IOException
    //   3167	3172	3205	java/lang/Exception
    //   3177	3182	3218	java/lang/Exception
    //   186	212	3230	java/lang/Exception
    //   212	233	3230	java/lang/Exception
    //   233	246	3230	java/lang/Exception
    //   3278	3283	3285	java/io/IOException
    //   3259	3263	3296	java/lang/Exception
    //   3268	3273	3309	java/lang/Exception
    //   186	212	3321	finally
    //   212	233	3321	finally
    //   233	246	3321	finally
    //   3334	3339	3361	java/lang/Exception
    //   3344	3349	3374	java/lang/Exception
    //   3354	3359	3386	java/io/IOException
    //   363	368	3398	finally
    //   1062	1072	3398	finally
    //   1097	1121	3398	finally
    //   1146	1157	3398	finally
    //   1182	1189	3398	finally
    //   1227	1238	3398	finally
    //   1263	1288	3398	finally
    //   1313	1318	3398	finally
    //   1347	1354	3398	finally
    //   1379	1387	3398	finally
    //   1412	1439	3398	finally
    //   1523	1535	3398	finally
    //   1567	1571	3398	finally
    //   1636	1645	3398	finally
    //   1705	1709	3398	finally
    //   1769	1775	3398	finally
    //   1816	1856	3398	finally
    //   1881	1887	3398	finally
    //   1956	1965	3398	finally
    //   2025	2029	3398	finally
    //   2089	2095	3398	finally
    //   2171	2180	3398	finally
    //   2240	2244	3398	finally
    //   2304	2310	3398	finally
    //   2386	2395	3398	finally
    //   2455	2459	3398	finally
    //   2519	2525	3398	finally
    //   2588	2596	3398	finally
    //   2685	2693	3398	finally
    //   2783	2791	3398	finally
    //   2877	2888	3398	finally
    //   2899	2907	3398	finally
    //   2918	2924	3398	finally
    //   2935	2943	3398	finally
    //   3035	3062	3398	finally
    //   3152	3160	3398	finally
    //   3245	3253	3398	finally
    //   295	301	3406	finally
    //   456	463	3406	finally
    //   509	514	3406	finally
    //   550	557	3406	finally
    //   593	602	3406	finally
    //   638	643	3406	finally
    //   679	686	3406	finally
    //   722	729	3406	finally
    //   765	773	3406	finally
    //   809	840	3406	finally
    //   876	901	3406	finally
    //   937	944	3406	finally
    //   985	991	3406	finally
    //   1027	1033	3406	finally
    //   1475	1483	3406	finally
    //   1475	1483	3418	java/lang/Exception
    //   363	368	3426	java/lang/Exception
    //   1636	1645	3426	java/lang/Exception
    //   1705	1709	3426	java/lang/Exception
    //   1769	1775	3426	java/lang/Exception
    //   1956	1965	3426	java/lang/Exception
    //   2025	2029	3426	java/lang/Exception
    //   2089	2095	3426	java/lang/Exception
    //   2171	2180	3426	java/lang/Exception
    //   2240	2244	3426	java/lang/Exception
    //   2304	2310	3426	java/lang/Exception
    //   2386	2395	3426	java/lang/Exception
    //   2455	2459	3426	java/lang/Exception
    //   2519	2525	3426	java/lang/Exception
    //   363	368	3433	java/io/IOException
    //   1062	1072	3433	java/io/IOException
    //   1097	1121	3433	java/io/IOException
    //   1146	1157	3433	java/io/IOException
    //   1182	1189	3433	java/io/IOException
    //   1227	1238	3433	java/io/IOException
    //   1263	1288	3433	java/io/IOException
    //   1313	1318	3433	java/io/IOException
    //   1347	1354	3433	java/io/IOException
    //   1379	1387	3433	java/io/IOException
    //   1412	1439	3433	java/io/IOException
    //   1523	1535	3433	java/io/IOException
    //   1567	1571	3433	java/io/IOException
    //   1636	1645	3433	java/io/IOException
    //   1705	1709	3433	java/io/IOException
    //   1769	1775	3433	java/io/IOException
    //   1816	1856	3433	java/io/IOException
    //   1881	1887	3433	java/io/IOException
    //   1956	1965	3433	java/io/IOException
    //   2025	2029	3433	java/io/IOException
    //   2089	2095	3433	java/io/IOException
    //   2171	2180	3433	java/io/IOException
    //   2240	2244	3433	java/io/IOException
    //   2304	2310	3433	java/io/IOException
    //   2386	2395	3433	java/io/IOException
    //   2455	2459	3433	java/io/IOException
    //   2519	2525	3433	java/io/IOException
    //   295	301	3437	java/io/IOException
    //   456	463	3437	java/io/IOException
    //   509	514	3437	java/io/IOException
    //   550	557	3437	java/io/IOException
    //   593	602	3437	java/io/IOException
    //   638	643	3437	java/io/IOException
    //   679	686	3437	java/io/IOException
    //   722	729	3437	java/io/IOException
    //   765	773	3437	java/io/IOException
    //   809	840	3437	java/io/IOException
    //   876	901	3437	java/io/IOException
    //   937	944	3437	java/io/IOException
    //   985	991	3437	java/io/IOException
    //   1027	1033	3437	java/io/IOException
    //   1475	1483	3437	java/io/IOException
    //   363	368	3445	java/net/MalformedURLException
    //   1062	1072	3445	java/net/MalformedURLException
    //   1097	1121	3445	java/net/MalformedURLException
    //   1146	1157	3445	java/net/MalformedURLException
    //   1182	1189	3445	java/net/MalformedURLException
    //   1227	1238	3445	java/net/MalformedURLException
    //   1263	1288	3445	java/net/MalformedURLException
    //   1313	1318	3445	java/net/MalformedURLException
    //   1347	1354	3445	java/net/MalformedURLException
    //   1379	1387	3445	java/net/MalformedURLException
    //   1412	1439	3445	java/net/MalformedURLException
    //   1523	1535	3445	java/net/MalformedURLException
    //   1567	1571	3445	java/net/MalformedURLException
    //   1636	1645	3445	java/net/MalformedURLException
    //   1705	1709	3445	java/net/MalformedURLException
    //   1769	1775	3445	java/net/MalformedURLException
    //   1816	1856	3445	java/net/MalformedURLException
    //   1881	1887	3445	java/net/MalformedURLException
    //   1956	1965	3445	java/net/MalformedURLException
    //   2025	2029	3445	java/net/MalformedURLException
    //   2089	2095	3445	java/net/MalformedURLException
    //   2171	2180	3445	java/net/MalformedURLException
    //   2240	2244	3445	java/net/MalformedURLException
    //   2304	2310	3445	java/net/MalformedURLException
    //   2386	2395	3445	java/net/MalformedURLException
    //   2455	2459	3445	java/net/MalformedURLException
    //   2519	2525	3445	java/net/MalformedURLException
    //   295	301	3453	java/net/MalformedURLException
    //   456	463	3453	java/net/MalformedURLException
    //   509	514	3453	java/net/MalformedURLException
    //   550	557	3453	java/net/MalformedURLException
    //   593	602	3453	java/net/MalformedURLException
    //   638	643	3453	java/net/MalformedURLException
    //   679	686	3453	java/net/MalformedURLException
    //   722	729	3453	java/net/MalformedURLException
    //   765	773	3453	java/net/MalformedURLException
    //   809	840	3453	java/net/MalformedURLException
    //   876	901	3453	java/net/MalformedURLException
    //   937	944	3453	java/net/MalformedURLException
    //   985	991	3453	java/net/MalformedURLException
    //   1027	1033	3453	java/net/MalformedURLException
    //   1475	1483	3453	java/net/MalformedURLException
    //   1475	1483	3457	java/io/FileNotFoundException
    //   363	368	3465	java/io/FileNotFoundException
    //   1636	1645	3465	java/io/FileNotFoundException
    //   1705	1709	3465	java/io/FileNotFoundException
    //   1769	1775	3465	java/io/FileNotFoundException
    //   1956	1965	3465	java/io/FileNotFoundException
    //   2025	2029	3465	java/io/FileNotFoundException
    //   2089	2095	3465	java/io/FileNotFoundException
    //   2171	2180	3465	java/io/FileNotFoundException
    //   2240	2244	3465	java/io/FileNotFoundException
    //   2304	2310	3465	java/io/FileNotFoundException
    //   2386	2395	3465	java/io/FileNotFoundException
    //   2455	2459	3465	java/io/FileNotFoundException
    //   2519	2525	3465	java/io/FileNotFoundException
    //   1475	1483	3472	java/net/SocketException
    //   363	368	3480	java/net/SocketException
    //   1636	1645	3480	java/net/SocketException
    //   1705	1709	3480	java/net/SocketException
    //   1769	1775	3480	java/net/SocketException
    //   1956	1965	3480	java/net/SocketException
    //   2025	2029	3480	java/net/SocketException
    //   2089	2095	3480	java/net/SocketException
    //   2171	2180	3480	java/net/SocketException
    //   2240	2244	3480	java/net/SocketException
    //   2304	2310	3480	java/net/SocketException
    //   2386	2395	3480	java/net/SocketException
    //   2455	2459	3480	java/net/SocketException
    //   2519	2525	3480	java/net/SocketException
    //   1475	1483	3487	java/net/SocketTimeoutException
    //   363	368	3495	java/net/SocketTimeoutException
    //   1636	1645	3495	java/net/SocketTimeoutException
    //   1705	1709	3495	java/net/SocketTimeoutException
    //   1769	1775	3495	java/net/SocketTimeoutException
    //   1956	1965	3495	java/net/SocketTimeoutException
    //   2025	2029	3495	java/net/SocketTimeoutException
    //   2089	2095	3495	java/net/SocketTimeoutException
    //   2171	2180	3495	java/net/SocketTimeoutException
    //   2240	2244	3495	java/net/SocketTimeoutException
    //   2304	2310	3495	java/net/SocketTimeoutException
    //   2386	2395	3495	java/net/SocketTimeoutException
    //   2455	2459	3495	java/net/SocketTimeoutException
    //   2519	2525	3495	java/net/SocketTimeoutException
    //   1475	1483	3502	java/lang/InterruptedException
    //   363	368	3510	java/lang/InterruptedException
    //   1636	1645	3510	java/lang/InterruptedException
    //   1705	1709	3510	java/lang/InterruptedException
    //   1769	1775	3510	java/lang/InterruptedException
    //   1956	1965	3510	java/lang/InterruptedException
    //   2025	2029	3510	java/lang/InterruptedException
    //   2089	2095	3510	java/lang/InterruptedException
    //   2171	2180	3510	java/lang/InterruptedException
    //   2240	2244	3510	java/lang/InterruptedException
    //   2304	2310	3510	java/lang/InterruptedException
    //   2386	2395	3510	java/lang/InterruptedException
    //   2455	2459	3510	java/lang/InterruptedException
    //   2519	2525	3510	java/lang/InterruptedException
    //   295	301	3517	java/lang/Exception
    //   456	463	3517	java/lang/Exception
    //   509	514	3517	java/lang/Exception
    //   550	557	3517	java/lang/Exception
    //   593	602	3517	java/lang/Exception
    //   638	643	3517	java/lang/Exception
    //   679	686	3517	java/lang/Exception
    //   722	729	3517	java/lang/Exception
    //   765	773	3517	java/lang/Exception
    //   809	840	3517	java/lang/Exception
    //   876	901	3517	java/lang/Exception
    //   937	944	3517	java/lang/Exception
    //   985	991	3517	java/lang/Exception
    //   1027	1033	3517	java/lang/Exception
    //   295	301	3529	java/io/FileNotFoundException
    //   456	463	3529	java/io/FileNotFoundException
    //   509	514	3529	java/io/FileNotFoundException
    //   550	557	3529	java/io/FileNotFoundException
    //   593	602	3529	java/io/FileNotFoundException
    //   638	643	3529	java/io/FileNotFoundException
    //   679	686	3529	java/io/FileNotFoundException
    //   722	729	3529	java/io/FileNotFoundException
    //   765	773	3529	java/io/FileNotFoundException
    //   809	840	3529	java/io/FileNotFoundException
    //   876	901	3529	java/io/FileNotFoundException
    //   937	944	3529	java/io/FileNotFoundException
    //   985	991	3529	java/io/FileNotFoundException
    //   1027	1033	3529	java/io/FileNotFoundException
    //   295	301	3541	java/net/SocketTimeoutException
    //   456	463	3541	java/net/SocketTimeoutException
    //   509	514	3541	java/net/SocketTimeoutException
    //   550	557	3541	java/net/SocketTimeoutException
    //   593	602	3541	java/net/SocketTimeoutException
    //   638	643	3541	java/net/SocketTimeoutException
    //   679	686	3541	java/net/SocketTimeoutException
    //   722	729	3541	java/net/SocketTimeoutException
    //   765	773	3541	java/net/SocketTimeoutException
    //   809	840	3541	java/net/SocketTimeoutException
    //   876	901	3541	java/net/SocketTimeoutException
    //   937	944	3541	java/net/SocketTimeoutException
    //   985	991	3541	java/net/SocketTimeoutException
    //   1027	1033	3541	java/net/SocketTimeoutException
    //   295	301	3553	java/net/SocketException
    //   456	463	3553	java/net/SocketException
    //   509	514	3553	java/net/SocketException
    //   550	557	3553	java/net/SocketException
    //   593	602	3553	java/net/SocketException
    //   638	643	3553	java/net/SocketException
    //   679	686	3553	java/net/SocketException
    //   722	729	3553	java/net/SocketException
    //   765	773	3553	java/net/SocketException
    //   809	840	3553	java/net/SocketException
    //   876	901	3553	java/net/SocketException
    //   937	944	3553	java/net/SocketException
    //   985	991	3553	java/net/SocketException
    //   1027	1033	3553	java/net/SocketException
    //   295	301	3565	java/lang/InterruptedException
    //   456	463	3565	java/lang/InterruptedException
    //   509	514	3565	java/lang/InterruptedException
    //   550	557	3565	java/lang/InterruptedException
    //   593	602	3565	java/lang/InterruptedException
    //   638	643	3565	java/lang/InterruptedException
    //   679	686	3565	java/lang/InterruptedException
    //   722	729	3565	java/lang/InterruptedException
    //   765	773	3565	java/lang/InterruptedException
    //   809	840	3565	java/lang/InterruptedException
    //   876	901	3565	java/lang/InterruptedException
    //   937	944	3565	java/lang/InterruptedException
    //   985	991	3565	java/lang/InterruptedException
    //   1027	1033	3565	java/lang/InterruptedException
    //   1062	1072	3587	java/io/FileNotFoundException
    //   1097	1121	3587	java/io/FileNotFoundException
    //   1146	1157	3587	java/io/FileNotFoundException
    //   1182	1189	3587	java/io/FileNotFoundException
    //   1227	1238	3587	java/io/FileNotFoundException
    //   1263	1288	3587	java/io/FileNotFoundException
    //   1313	1318	3587	java/io/FileNotFoundException
    //   1347	1354	3587	java/io/FileNotFoundException
    //   1379	1387	3587	java/io/FileNotFoundException
    //   1412	1439	3587	java/io/FileNotFoundException
    //   1523	1535	3587	java/io/FileNotFoundException
    //   1567	1571	3587	java/io/FileNotFoundException
    //   1816	1856	3587	java/io/FileNotFoundException
    //   1881	1887	3587	java/io/FileNotFoundException
    //   1062	1072	3592	java/lang/Exception
    //   1097	1121	3592	java/lang/Exception
    //   1146	1157	3592	java/lang/Exception
    //   1182	1189	3592	java/lang/Exception
    //   1227	1238	3592	java/lang/Exception
    //   1263	1288	3592	java/lang/Exception
    //   1313	1318	3592	java/lang/Exception
    //   1347	1354	3592	java/lang/Exception
    //   1379	1387	3592	java/lang/Exception
    //   1412	1439	3592	java/lang/Exception
    //   1523	1535	3592	java/lang/Exception
    //   1567	1571	3592	java/lang/Exception
    //   1816	1856	3592	java/lang/Exception
    //   1881	1887	3592	java/lang/Exception
  }
  
  private void a(HttpURLConnection paramHttpURLConnection, InputStream paramInputStream)
  {
    if (paramHttpURLConnection != null) {}
    try
    {
      paramHttpURLConnection.disconnect();
      if (paramInputStream != null) {
        paramInputStream.close();
      }
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      SLog.a("Q.qqstory.download.preload.FileDownloader", "", paramHttpURLConnection);
    }
  }
  
  public static void a(HashMap paramHashMap, HttpURLConnection paramHttpURLConnection)
  {
    if (paramHashMap == null) {}
    for (;;)
    {
      return;
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Object localObject = (Map.Entry)paramHashMap.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        if ((str != null) && (localObject != null)) {
          paramHttpURLConnection.setRequestProperty(str, (String)localObject);
        }
      }
    }
  }
  
  public int a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    return a(paramString1, paramInt, paramString2, paramString3, null, this.c, paramLong, false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int b(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    return a(paramString1, paramInt, paramString2, paramString3, null, this.c, paramLong, true);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\FileDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */