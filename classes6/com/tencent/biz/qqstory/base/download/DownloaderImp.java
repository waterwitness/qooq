package com.tencent.biz.qqstory.base.download;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class DownloaderImp
  implements Downloader
{
  public static final int a = 65536;
  protected static final String a = "Q.qqstory.download:DownloaderImp";
  protected DownloadProgressListener a;
  protected volatile boolean a;
  protected int b;
  protected String b;
  protected volatile boolean b;
  
  public DownloaderImp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = 10;
  }
  
  /* Error */
  private int a(String paramString1, String paramString2, HashMap paramHashMap, int paramInt, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 44	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_a_of_type_Boolean	Z
    //   5: aload_0
    //   6: iconst_1
    //   7: putfield 46	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_b_of_type_Boolean	Z
    //   10: aload_0
    //   11: aload_2
    //   12: putfield 48	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   15: ldc 12
    //   17: new 50	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   24: ldc 53
    //   26: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_2
    //   30: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 66	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: ldc 12
    //   41: new 50	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   48: ldc 68
    //   50: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_1
    //   54: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 66	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: getfield 70	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadProgressListener	Lcom/tencent/biz/qqstory/base/download/DownloadProgressListener;
    //   67: ifnull +14 -> 81
    //   70: aload_0
    //   71: getfield 70	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadProgressListener	Lcom/tencent/biz/qqstory/base/download/DownloadProgressListener;
    //   74: aload_1
    //   75: aload_2
    //   76: invokeinterface 74 3 0
    //   81: iconst_0
    //   82: istore 32
    //   84: aconst_null
    //   85: astore 14
    //   87: aconst_null
    //   88: astore 21
    //   90: aconst_null
    //   91: astore 19
    //   93: aconst_null
    //   94: astore 20
    //   96: aconst_null
    //   97: astore 9
    //   99: aconst_null
    //   100: astore 8
    //   102: aconst_null
    //   103: astore 22
    //   105: aconst_null
    //   106: astore 10
    //   108: aconst_null
    //   109: astore 15
    //   111: aconst_null
    //   112: astore 13
    //   114: aconst_null
    //   115: astore 11
    //   117: iload 4
    //   119: ifle +273 -> 392
    //   122: iload 4
    //   124: istore 31
    //   126: new 76	java/net/URL
    //   129: dup
    //   130: aload_1
    //   131: invokespecial 79	java/net/URL:<init>	(Ljava/lang/String;)V
    //   134: astore 28
    //   136: aload 28
    //   138: invokestatic 84	com/tencent/biz/qqstory/base/download/URLChecker:a	(Ljava/net/URL;)Z
    //   141: ifne +3376 -> 3517
    //   144: aload 28
    //   146: invokestatic 87	com/tencent/biz/qqstory/base/download/URLChecker:a	(Ljava/net/URL;)Ljava/net/URL;
    //   149: astore 28
    //   151: aload_2
    //   152: invokestatic 92	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/io/File;
    //   155: astore 12
    //   157: aload 12
    //   159: invokevirtual 98	java/io/File:exists	()Z
    //   162: ifne +9 -> 171
    //   165: aload 12
    //   167: invokevirtual 101	java/io/File:createNewFile	()Z
    //   170: pop
    //   171: new 103	java/io/RandomAccessFile
    //   174: dup
    //   175: aload 12
    //   177: ldc 105
    //   179: invokespecial 108	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   182: astore 12
    //   184: iconst_0
    //   185: istore 30
    //   187: aconst_null
    //   188: astore 11
    //   190: iload 32
    //   192: istore 4
    //   194: aload 15
    //   196: astore 8
    //   198: aload 11
    //   200: astore 10
    //   202: aload 8
    //   204: astore 9
    //   206: aload 12
    //   208: astore 16
    //   210: aload 11
    //   212: astore 17
    //   214: aload 8
    //   216: astore 14
    //   218: aload 11
    //   220: astore 18
    //   222: aload 8
    //   224: astore 13
    //   226: aload 8
    //   228: astore 21
    //   230: aload 8
    //   232: astore 19
    //   234: aload 8
    //   236: astore 20
    //   238: aload 8
    //   240: astore 23
    //   242: aload 8
    //   244: astore 22
    //   246: aload_0
    //   247: getfield 26	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_b_of_type_Int	I
    //   250: istore 32
    //   252: iload 30
    //   254: iload 32
    //   256: if_icmple +143 -> 399
    //   259: aload 11
    //   261: astore_3
    //   262: iload 4
    //   264: istore 30
    //   266: aload_3
    //   267: astore 10
    //   269: aload 8
    //   271: astore 9
    //   273: aload 12
    //   275: astore 16
    //   277: aload_3
    //   278: astore 24
    //   280: aload 8
    //   282: astore 22
    //   284: aload_3
    //   285: astore 17
    //   287: aload 8
    //   289: astore 14
    //   291: aload_3
    //   292: astore 18
    //   294: aload 8
    //   296: astore 13
    //   298: aload_3
    //   299: astore 25
    //   301: aload 8
    //   303: astore 20
    //   305: aload_3
    //   306: astore 23
    //   308: aload 8
    //   310: astore 19
    //   312: aload_3
    //   313: astore 26
    //   315: aload 8
    //   317: astore 21
    //   319: aload_3
    //   320: astore 27
    //   322: aload 8
    //   324: astore 15
    //   326: aload 12
    //   328: invokevirtual 111	java/io/RandomAccessFile:close	()V
    //   331: aload 8
    //   333: ifnull +8 -> 341
    //   336: aload 8
    //   338: invokevirtual 116	java/net/HttpURLConnection:disconnect	()V
    //   341: aload_3
    //   342: ifnull +7 -> 349
    //   345: aload_3
    //   346: invokevirtual 119	java/io/InputStream:close	()V
    //   349: iload 30
    //   351: istore 4
    //   353: iconst_0
    //   354: ifeq +11 -> 365
    //   357: new 121	java/lang/NullPointerException
    //   360: dup
    //   361: invokespecial 122	java/lang/NullPointerException:<init>	()V
    //   364: athrow
    //   365: aload_0
    //   366: getfield 70	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadProgressListener	Lcom/tencent/biz/qqstory/base/download/DownloadProgressListener;
    //   369: ifnull +15 -> 384
    //   372: aload_0
    //   373: getfield 70	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadProgressListener	Lcom/tencent/biz/qqstory/base/download/DownloadProgressListener;
    //   376: aload_1
    //   377: iload 4
    //   379: invokeinterface 125 3 0
    //   384: aload_0
    //   385: iconst_0
    //   386: putfield 46	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_b_of_type_Boolean	Z
    //   389: iload 4
    //   391: ireturn
    //   392: ldc 9
    //   394: istore 31
    //   396: goto -270 -> 126
    //   399: aload 11
    //   401: astore 10
    //   403: aload 8
    //   405: astore 9
    //   407: aload 12
    //   409: astore 16
    //   411: aload 11
    //   413: astore 17
    //   415: aload 8
    //   417: astore 14
    //   419: aload 11
    //   421: astore 18
    //   423: aload 8
    //   425: astore 13
    //   427: aload 8
    //   429: astore 21
    //   431: aload 8
    //   433: astore 19
    //   435: aload 8
    //   437: astore 20
    //   439: aload 8
    //   441: astore 23
    //   443: aload 8
    //   445: astore 22
    //   447: aload_0
    //   448: getfield 44	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_a_of_type_Boolean	Z
    //   451: ifeq +13 -> 464
    //   454: bipush 6
    //   456: istore 30
    //   458: aload 11
    //   460: astore_3
    //   461: goto -195 -> 266
    //   464: aload 11
    //   466: astore 10
    //   468: aload 8
    //   470: astore 9
    //   472: aload 12
    //   474: astore 16
    //   476: aload 11
    //   478: astore 17
    //   480: aload 8
    //   482: astore 14
    //   484: aload 11
    //   486: astore 18
    //   488: aload 8
    //   490: astore 13
    //   492: aload 8
    //   494: astore 21
    //   496: aload 8
    //   498: astore 19
    //   500: aload 8
    //   502: astore 20
    //   504: aload 8
    //   506: astore 23
    //   508: aload 8
    //   510: astore 22
    //   512: aload_0
    //   513: aload 8
    //   515: aload 11
    //   517: invokespecial 128	com/tencent/biz/qqstory/base/download/DownloaderImp:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   520: aload 11
    //   522: astore 10
    //   524: aload 8
    //   526: astore 9
    //   528: aload 12
    //   530: astore 16
    //   532: aload 11
    //   534: astore 17
    //   536: aload 8
    //   538: astore 14
    //   540: aload 11
    //   542: astore 18
    //   544: aload 8
    //   546: astore 13
    //   548: aload 8
    //   550: astore 21
    //   552: aload 8
    //   554: astore 19
    //   556: aload 8
    //   558: astore 20
    //   560: aload 8
    //   562: astore 23
    //   564: aload 8
    //   566: astore 22
    //   568: aload 28
    //   570: invokevirtual 132	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   573: checkcast 113	java/net/HttpURLConnection
    //   576: astore 8
    //   578: aload 11
    //   580: astore 10
    //   582: aload 8
    //   584: astore 9
    //   586: aload 12
    //   588: astore 16
    //   590: aload 11
    //   592: astore 17
    //   594: aload 8
    //   596: astore 14
    //   598: aload 11
    //   600: astore 18
    //   602: aload 8
    //   604: astore 13
    //   606: aload 8
    //   608: astore 21
    //   610: aload 8
    //   612: astore 19
    //   614: aload 8
    //   616: astore 20
    //   618: aload 8
    //   620: astore 23
    //   622: aload 8
    //   624: astore 22
    //   626: aload 8
    //   628: iconst_0
    //   629: invokevirtual 136	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   632: aload 11
    //   634: astore 10
    //   636: aload 8
    //   638: astore 9
    //   640: aload 12
    //   642: astore 16
    //   644: aload 11
    //   646: astore 17
    //   648: aload 8
    //   650: astore 14
    //   652: aload 11
    //   654: astore 18
    //   656: aload 8
    //   658: astore 13
    //   660: aload 8
    //   662: astore 21
    //   664: aload 8
    //   666: astore 19
    //   668: aload 8
    //   670: astore 20
    //   672: aload 8
    //   674: astore 23
    //   676: aload 8
    //   678: astore 22
    //   680: aload 8
    //   682: sipush 5000
    //   685: invokevirtual 140	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   688: aload 11
    //   690: astore 10
    //   692: aload 8
    //   694: astore 9
    //   696: aload 12
    //   698: astore 16
    //   700: aload 11
    //   702: astore 17
    //   704: aload 8
    //   706: astore 14
    //   708: aload 11
    //   710: astore 18
    //   712: aload 8
    //   714: astore 13
    //   716: aload 8
    //   718: astore 21
    //   720: aload 8
    //   722: astore 19
    //   724: aload 8
    //   726: astore 20
    //   728: aload 8
    //   730: astore 23
    //   732: aload 8
    //   734: astore 22
    //   736: aload 8
    //   738: sipush 5000
    //   741: invokevirtual 143	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   744: aload 11
    //   746: astore 10
    //   748: aload 8
    //   750: astore 9
    //   752: aload 12
    //   754: astore 16
    //   756: aload 11
    //   758: astore 17
    //   760: aload 8
    //   762: astore 14
    //   764: aload 11
    //   766: astore 18
    //   768: aload 8
    //   770: astore 13
    //   772: aload 8
    //   774: astore 21
    //   776: aload 8
    //   778: astore 19
    //   780: aload 8
    //   782: astore 20
    //   784: aload 8
    //   786: astore 23
    //   788: aload 8
    //   790: astore 22
    //   792: aload 8
    //   794: ldc -111
    //   796: ldc -109
    //   798: invokevirtual 150	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   801: aload 11
    //   803: astore 10
    //   805: aload 8
    //   807: astore 9
    //   809: aload 12
    //   811: astore 16
    //   813: aload 11
    //   815: astore 17
    //   817: aload 8
    //   819: astore 14
    //   821: aload 11
    //   823: astore 18
    //   825: aload 8
    //   827: astore 13
    //   829: aload 8
    //   831: astore 21
    //   833: aload 8
    //   835: astore 19
    //   837: aload 8
    //   839: astore 20
    //   841: aload 8
    //   843: astore 23
    //   845: aload 8
    //   847: astore 22
    //   849: aload_3
    //   850: aload 8
    //   852: invokestatic 153	com/tencent/biz/qqstory/base/download/DownloaderImp:a	(Ljava/util/HashMap;Ljava/net/HttpURLConnection;)V
    //   855: aload 11
    //   857: astore 10
    //   859: aload 8
    //   861: astore 9
    //   863: aload 12
    //   865: astore 16
    //   867: aload 11
    //   869: astore 17
    //   871: aload 8
    //   873: astore 14
    //   875: aload 11
    //   877: astore 18
    //   879: aload 8
    //   881: astore 13
    //   883: aload 8
    //   885: astore 21
    //   887: aload 8
    //   889: astore 19
    //   891: aload 8
    //   893: astore 20
    //   895: aload 8
    //   897: astore 23
    //   899: aload 8
    //   901: astore 22
    //   903: aload 12
    //   905: lload 5
    //   907: invokevirtual 157	java/io/RandomAccessFile:seek	(J)V
    //   910: aload 11
    //   912: astore 10
    //   914: aload 8
    //   916: astore 9
    //   918: aload 12
    //   920: astore 16
    //   922: aload 11
    //   924: astore 17
    //   926: aload 8
    //   928: astore 14
    //   930: aload 11
    //   932: astore 18
    //   934: aload 8
    //   936: astore 13
    //   938: aload 8
    //   940: astore 21
    //   942: aload 8
    //   944: astore 19
    //   946: aload 8
    //   948: astore 20
    //   950: aload 8
    //   952: astore 23
    //   954: aload 8
    //   956: astore 22
    //   958: aload 8
    //   960: ldc -97
    //   962: new 50	java/lang/StringBuilder
    //   965: dup
    //   966: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   969: ldc -95
    //   971: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: lload 5
    //   976: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   979: ldc -90
    //   981: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokevirtual 150	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   990: aload 11
    //   992: astore 10
    //   994: aload 8
    //   996: astore 9
    //   998: aload 12
    //   1000: astore 16
    //   1002: aload 11
    //   1004: astore 17
    //   1006: aload 8
    //   1008: astore 14
    //   1010: aload 11
    //   1012: astore 18
    //   1014: aload 8
    //   1016: astore 13
    //   1018: aload 8
    //   1020: astore 21
    //   1022: aload 8
    //   1024: astore 19
    //   1026: aload 8
    //   1028: astore 20
    //   1030: aload 8
    //   1032: astore 23
    //   1034: aload 8
    //   1036: astore 22
    //   1038: ldc 12
    //   1040: new 50	java/lang/StringBuilder
    //   1043: dup
    //   1044: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   1047: ldc -88
    //   1049: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: lload 5
    //   1054: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1057: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1060: invokestatic 66	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1063: aload 11
    //   1065: astore 10
    //   1067: aload 8
    //   1069: astore 9
    //   1071: aload 12
    //   1073: astore 16
    //   1075: aload 11
    //   1077: astore 17
    //   1079: aload 8
    //   1081: astore 14
    //   1083: aload 11
    //   1085: astore 18
    //   1087: aload 8
    //   1089: astore 13
    //   1091: aload 8
    //   1093: astore 21
    //   1095: aload 8
    //   1097: astore 19
    //   1099: aload 8
    //   1101: astore 20
    //   1103: aload 8
    //   1105: astore 23
    //   1107: aload 8
    //   1109: astore 22
    //   1111: aload 8
    //   1113: invokevirtual 172	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1116: astore 15
    //   1118: lload 5
    //   1120: lstore 35
    //   1122: lload 5
    //   1124: lstore 37
    //   1126: lload 5
    //   1128: lstore 39
    //   1130: lload 5
    //   1132: lstore 41
    //   1134: aload 8
    //   1136: invokevirtual 176	java/net/HttpURLConnection:getContentLength	()I
    //   1139: i2l
    //   1140: lstore 43
    //   1142: lload 5
    //   1144: lstore 35
    //   1146: lload 5
    //   1148: lstore 37
    //   1150: lload 5
    //   1152: lstore 39
    //   1154: lload 5
    //   1156: lstore 41
    //   1158: iload 31
    //   1160: newarray <illegal type>
    //   1162: astore 9
    //   1164: lload 5
    //   1166: lstore 33
    //   1168: lload 33
    //   1170: lstore 35
    //   1172: lload 33
    //   1174: lstore 37
    //   1176: lload 33
    //   1178: lstore 39
    //   1180: lload 33
    //   1182: lstore 41
    //   1184: aload 15
    //   1186: aload 9
    //   1188: invokevirtual 180	java/io/InputStream:read	([B)I
    //   1191: istore 32
    //   1193: iload 32
    //   1195: iconst_m1
    //   1196: if_icmpeq +2318 -> 3514
    //   1199: lload 33
    //   1201: lstore 35
    //   1203: lload 33
    //   1205: lstore 37
    //   1207: lload 33
    //   1209: lstore 39
    //   1211: lload 33
    //   1213: lstore 41
    //   1215: aload 12
    //   1217: aload 9
    //   1219: iconst_0
    //   1220: iload 32
    //   1222: invokevirtual 184	java/io/RandomAccessFile:write	([BII)V
    //   1225: lload 33
    //   1227: iload 32
    //   1229: i2l
    //   1230: ladd
    //   1231: lstore 33
    //   1233: lload 33
    //   1235: lstore 35
    //   1237: lload 33
    //   1239: lstore 37
    //   1241: lload 33
    //   1243: lstore 39
    //   1245: lload 33
    //   1247: lstore 41
    //   1249: aload_0
    //   1250: getfield 70	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadProgressListener	Lcom/tencent/biz/qqstory/base/download/DownloadProgressListener;
    //   1253: ifnull +36 -> 1289
    //   1256: lload 33
    //   1258: lstore 35
    //   1260: lload 33
    //   1262: lstore 37
    //   1264: lload 33
    //   1266: lstore 39
    //   1268: lload 33
    //   1270: lstore 41
    //   1272: aload_0
    //   1273: getfield 70	com/tencent/biz/qqstory/base/download/DownloaderImp:jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadProgressListener	Lcom/tencent/biz/qqstory/base/download/DownloadProgressListener;
    //   1276: aload_1
    //   1277: lload 33
    //   1279: lload 5
    //   1281: lload 43
    //   1283: ladd
    //   1284: invokeinterface 187 6 0
    //   1289: iload 7
    //   1291: ifeq +69 -> 1360
    //   1294: lload 33
    //   1296: lstore 35
    //   1298: lload 33
    //   1300: lstore 37
    //   1302: lload 33
    //   1304: lstore 39
    //   1306: lload 33
    //   1308: lstore 41
    //   1310: invokestatic 193	com/tencent/mobileqq/pluginsdk/PluginRuntime:getRuntime	()Lcom/tencent/mobileqq/pluginsdk/PluginRuntime;
    //   1313: invokevirtual 197	com/tencent/mobileqq/pluginsdk/PluginRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   1316: invokestatic 203	com/weiyun/sdk/util/NetworkUtils:isWIFI	(Landroid/content/Context;)Z
    //   1319: ifne +41 -> 1360
    //   1322: bipush 7
    //   1324: istore 4
    //   1326: lload 33
    //   1328: lstore 35
    //   1330: lload 33
    //   1332: lstore 37
    //   1334: lload 33
    //   1336: lstore 39
    //   1338: lload 33
    //   1340: lstore 41
    //   1342: aload_0
    //   1343: aload 8
    //   1345: aload 15
    //   1347: invokespecial 128	com/tencent/biz/qqstory/base/download/DownloaderImp:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   1350: aload 15
    //   1352: astore_3
    //   1353: iload 4
    //   1355: istore 30
    //   1357: goto -1091 -> 266
    //   1360: lload 33
    //   1362: lstore 35
    //   1364: lload 33
    //   1366: lstore 37
    //   1368: lload 33
    //   1370: lstore 39
    //   1372: lload 33
    //   1374: lstore 41
    //   1376: lconst_0
    //   1377: invokestatic 208	java/lang/Thread:sleep	(J)V
    //   1380: goto -212 -> 1168
    //   1383: astore 28
    //   1385: aload 15
    //   1387: astore_3
    //   1388: aload_3
    //   1389: astore 10
    //   1391: aload 8
    //   1393: astore 9
    //   1395: aload 12
    //   1397: astore 16
    //   1399: aload_3
    //   1400: astore 24
    //   1402: aload 8
    //   1404: astore 22
    //   1406: aload_3
    //   1407: astore 17
    //   1409: aload 8
    //   1411: astore 14
    //   1413: aload_3
    //   1414: astore 18
    //   1416: aload 8
    //   1418: astore 13
    //   1420: aload_3
    //   1421: astore 25
    //   1423: aload 8
    //   1425: astore 20
    //   1427: aload_3
    //   1428: astore 23
    //   1430: aload 8
    //   1432: astore 19
    //   1434: aload_3
    //   1435: astore 26
    //   1437: aload 8
    //   1439: astore 21
    //   1441: aload_3
    //   1442: astore 27
    //   1444: aload 8
    //   1446: astore 15
    //   1448: ldc 12
    //   1450: ldc -46
    //   1452: aload 28
    //   1454: invokestatic 213	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1457: bipush 6
    //   1459: istore 30
    //   1461: goto -1195 -> 266
    //   1464: aload 11
    //   1466: astore 10
    //   1468: aload 8
    //   1470: astore 9
    //   1472: aload 12
    //   1474: astore 16
    //   1476: aload 11
    //   1478: astore 24
    //   1480: aload 8
    //   1482: astore 22
    //   1484: aload 11
    //   1486: astore 17
    //   1488: aload 8
    //   1490: astore 14
    //   1492: aload 11
    //   1494: astore 18
    //   1496: aload 8
    //   1498: astore 13
    //   1500: aload 11
    //   1502: astore 25
    //   1504: aload 8
    //   1506: astore 20
    //   1508: aload 11
    //   1510: astore 23
    //   1512: aload 8
    //   1514: astore 19
    //   1516: aload 11
    //   1518: astore 26
    //   1520: aload 8
    //   1522: astore 21
    //   1524: aload 11
    //   1526: astore 27
    //   1528: aload 8
    //   1530: astore 15
    //   1532: ldc 12
    //   1534: ldc -46
    //   1536: aload 29
    //   1538: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1541: aload 11
    //   1543: astore 10
    //   1545: aload 8
    //   1547: astore 9
    //   1549: aload 12
    //   1551: astore 16
    //   1553: aload 11
    //   1555: astore 24
    //   1557: aload 8
    //   1559: astore 22
    //   1561: aload 11
    //   1563: astore 17
    //   1565: aload 8
    //   1567: astore 14
    //   1569: aload 11
    //   1571: astore 18
    //   1573: aload 8
    //   1575: astore 13
    //   1577: aload 11
    //   1579: astore 25
    //   1581: aload 8
    //   1583: astore 20
    //   1585: aload 11
    //   1587: astore 23
    //   1589: aload 8
    //   1591: astore 19
    //   1593: aload 11
    //   1595: astore 26
    //   1597: aload 8
    //   1599: astore 21
    //   1601: aload 11
    //   1603: astore 27
    //   1605: aload 8
    //   1607: astore 15
    //   1609: invokestatic 220	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1612: pop
    //   1613: aload 11
    //   1615: astore 10
    //   1617: aload 8
    //   1619: astore 9
    //   1621: aload 12
    //   1623: astore 16
    //   1625: aload 11
    //   1627: astore 24
    //   1629: aload 8
    //   1631: astore 22
    //   1633: aload 11
    //   1635: astore 17
    //   1637: aload 8
    //   1639: astore 14
    //   1641: aload 11
    //   1643: astore 18
    //   1645: aload 8
    //   1647: astore 13
    //   1649: aload 11
    //   1651: astore 25
    //   1653: aload 8
    //   1655: astore 20
    //   1657: aload 11
    //   1659: astore 23
    //   1661: aload 8
    //   1663: astore 19
    //   1665: aload 11
    //   1667: astore 26
    //   1669: aload 8
    //   1671: astore 21
    //   1673: aload 11
    //   1675: astore 27
    //   1677: aload 8
    //   1679: astore 15
    //   1681: ldc2_w 221
    //   1684: invokestatic 208	java/lang/Thread:sleep	(J)V
    //   1687: iconst_1
    //   1688: istore 4
    //   1690: iload 30
    //   1692: iconst_1
    //   1693: iadd
    //   1694: istore 30
    //   1696: goto -1498 -> 198
    //   1699: aload 11
    //   1701: astore 10
    //   1703: aload 8
    //   1705: astore 9
    //   1707: aload 12
    //   1709: astore 16
    //   1711: aload 11
    //   1713: astore 24
    //   1715: aload 8
    //   1717: astore 22
    //   1719: aload 11
    //   1721: astore 17
    //   1723: aload 8
    //   1725: astore 14
    //   1727: aload 11
    //   1729: astore 18
    //   1731: aload 8
    //   1733: astore 13
    //   1735: aload 11
    //   1737: astore 25
    //   1739: aload 8
    //   1741: astore 20
    //   1743: aload 11
    //   1745: astore 23
    //   1747: aload 8
    //   1749: astore 19
    //   1751: aload 11
    //   1753: astore 26
    //   1755: aload 8
    //   1757: astore 21
    //   1759: aload 11
    //   1761: astore 27
    //   1763: aload 8
    //   1765: astore 15
    //   1767: ldc 12
    //   1769: ldc -46
    //   1771: aload 29
    //   1773: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1776: aload 11
    //   1778: astore 10
    //   1780: aload 8
    //   1782: astore 9
    //   1784: aload 12
    //   1786: astore 16
    //   1788: aload 11
    //   1790: astore 24
    //   1792: aload 8
    //   1794: astore 22
    //   1796: aload 11
    //   1798: astore 17
    //   1800: aload 8
    //   1802: astore 14
    //   1804: aload 11
    //   1806: astore 18
    //   1808: aload 8
    //   1810: astore 13
    //   1812: aload 11
    //   1814: astore 25
    //   1816: aload 8
    //   1818: astore 20
    //   1820: aload 11
    //   1822: astore 23
    //   1824: aload 8
    //   1826: astore 19
    //   1828: aload 11
    //   1830: astore 26
    //   1832: aload 8
    //   1834: astore 21
    //   1836: aload 11
    //   1838: astore 27
    //   1840: aload 8
    //   1842: astore 15
    //   1844: invokestatic 220	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1847: pop
    //   1848: aload 11
    //   1850: astore 10
    //   1852: aload 8
    //   1854: astore 9
    //   1856: aload 12
    //   1858: astore 16
    //   1860: aload 11
    //   1862: astore 24
    //   1864: aload 8
    //   1866: astore 22
    //   1868: aload 11
    //   1870: astore 17
    //   1872: aload 8
    //   1874: astore 14
    //   1876: aload 11
    //   1878: astore 18
    //   1880: aload 8
    //   1882: astore 13
    //   1884: aload 11
    //   1886: astore 25
    //   1888: aload 8
    //   1890: astore 20
    //   1892: aload 11
    //   1894: astore 23
    //   1896: aload 8
    //   1898: astore 19
    //   1900: aload 11
    //   1902: astore 26
    //   1904: aload 8
    //   1906: astore 21
    //   1908: aload 11
    //   1910: astore 27
    //   1912: aload 8
    //   1914: astore 15
    //   1916: ldc2_w 221
    //   1919: invokestatic 208	java/lang/Thread:sleep	(J)V
    //   1922: iconst_2
    //   1923: istore 4
    //   1925: iload 30
    //   1927: iconst_1
    //   1928: iadd
    //   1929: istore 30
    //   1931: goto -1733 -> 198
    //   1934: aload 11
    //   1936: astore 10
    //   1938: aload 8
    //   1940: astore 9
    //   1942: aload 12
    //   1944: astore 16
    //   1946: aload 11
    //   1948: astore 24
    //   1950: aload 8
    //   1952: astore 22
    //   1954: aload 11
    //   1956: astore 17
    //   1958: aload 8
    //   1960: astore 14
    //   1962: aload 11
    //   1964: astore 18
    //   1966: aload 8
    //   1968: astore 13
    //   1970: aload 11
    //   1972: astore 25
    //   1974: aload 8
    //   1976: astore 20
    //   1978: aload 11
    //   1980: astore 23
    //   1982: aload 8
    //   1984: astore 19
    //   1986: aload 11
    //   1988: astore 26
    //   1990: aload 8
    //   1992: astore 21
    //   1994: aload 11
    //   1996: astore 27
    //   1998: aload 8
    //   2000: astore 15
    //   2002: ldc 12
    //   2004: ldc -46
    //   2006: aload 29
    //   2008: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2011: aload 11
    //   2013: astore 10
    //   2015: aload 8
    //   2017: astore 9
    //   2019: aload 12
    //   2021: astore 16
    //   2023: aload 11
    //   2025: astore 24
    //   2027: aload 8
    //   2029: astore 22
    //   2031: aload 11
    //   2033: astore 17
    //   2035: aload 8
    //   2037: astore 14
    //   2039: aload 11
    //   2041: astore 18
    //   2043: aload 8
    //   2045: astore 13
    //   2047: aload 11
    //   2049: astore 25
    //   2051: aload 8
    //   2053: astore 20
    //   2055: aload 11
    //   2057: astore 23
    //   2059: aload 8
    //   2061: astore 19
    //   2063: aload 11
    //   2065: astore 26
    //   2067: aload 8
    //   2069: astore 21
    //   2071: aload 11
    //   2073: astore 27
    //   2075: aload 8
    //   2077: astore 15
    //   2079: invokestatic 220	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2082: pop
    //   2083: aload 11
    //   2085: astore 10
    //   2087: aload 8
    //   2089: astore 9
    //   2091: aload 12
    //   2093: astore 16
    //   2095: aload 11
    //   2097: astore 24
    //   2099: aload 8
    //   2101: astore 22
    //   2103: aload 11
    //   2105: astore 17
    //   2107: aload 8
    //   2109: astore 14
    //   2111: aload 11
    //   2113: astore 18
    //   2115: aload 8
    //   2117: astore 13
    //   2119: aload 11
    //   2121: astore 25
    //   2123: aload 8
    //   2125: astore 20
    //   2127: aload 11
    //   2129: astore 23
    //   2131: aload 8
    //   2133: astore 19
    //   2135: aload 11
    //   2137: astore 26
    //   2139: aload 8
    //   2141: astore 21
    //   2143: aload 11
    //   2145: astore 27
    //   2147: aload 8
    //   2149: astore 15
    //   2151: ldc2_w 221
    //   2154: invokestatic 208	java/lang/Thread:sleep	(J)V
    //   2157: iconst_3
    //   2158: istore 4
    //   2160: iload 30
    //   2162: iconst_1
    //   2163: iadd
    //   2164: istore 30
    //   2166: goto -1968 -> 198
    //   2169: aload 11
    //   2171: astore 10
    //   2173: aload 8
    //   2175: astore 9
    //   2177: aload 12
    //   2179: astore 16
    //   2181: aload 11
    //   2183: astore 24
    //   2185: aload 8
    //   2187: astore 22
    //   2189: aload 11
    //   2191: astore 17
    //   2193: aload 8
    //   2195: astore 14
    //   2197: aload 11
    //   2199: astore 18
    //   2201: aload 8
    //   2203: astore 13
    //   2205: aload 11
    //   2207: astore 25
    //   2209: aload 8
    //   2211: astore 20
    //   2213: aload 11
    //   2215: astore 23
    //   2217: aload 8
    //   2219: astore 19
    //   2221: aload 11
    //   2223: astore 26
    //   2225: aload 8
    //   2227: astore 21
    //   2229: aload 11
    //   2231: astore 27
    //   2233: aload 8
    //   2235: astore 15
    //   2237: ldc 12
    //   2239: ldc -46
    //   2241: aload 29
    //   2243: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2246: aload 11
    //   2248: astore 10
    //   2250: aload 8
    //   2252: astore 9
    //   2254: aload 12
    //   2256: astore 16
    //   2258: aload 11
    //   2260: astore 24
    //   2262: aload 8
    //   2264: astore 22
    //   2266: aload 11
    //   2268: astore 17
    //   2270: aload 8
    //   2272: astore 14
    //   2274: aload 11
    //   2276: astore 18
    //   2278: aload 8
    //   2280: astore 13
    //   2282: aload 11
    //   2284: astore 25
    //   2286: aload 8
    //   2288: astore 20
    //   2290: aload 11
    //   2292: astore 23
    //   2294: aload 8
    //   2296: astore 19
    //   2298: aload 11
    //   2300: astore 26
    //   2302: aload 8
    //   2304: astore 21
    //   2306: aload 11
    //   2308: astore 27
    //   2310: aload 8
    //   2312: astore 15
    //   2314: invokestatic 220	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2317: pop
    //   2318: aload 11
    //   2320: astore 10
    //   2322: aload 8
    //   2324: astore 9
    //   2326: aload 12
    //   2328: astore 16
    //   2330: aload 11
    //   2332: astore 24
    //   2334: aload 8
    //   2336: astore 22
    //   2338: aload 11
    //   2340: astore 17
    //   2342: aload 8
    //   2344: astore 14
    //   2346: aload 11
    //   2348: astore 18
    //   2350: aload 8
    //   2352: astore 13
    //   2354: aload 11
    //   2356: astore 25
    //   2358: aload 8
    //   2360: astore 20
    //   2362: aload 11
    //   2364: astore 23
    //   2366: aload 8
    //   2368: astore 19
    //   2370: aload 11
    //   2372: astore 26
    //   2374: aload 8
    //   2376: astore 21
    //   2378: aload 11
    //   2380: astore 27
    //   2382: aload 8
    //   2384: astore 15
    //   2386: ldc2_w 221
    //   2389: invokestatic 208	java/lang/Thread:sleep	(J)V
    //   2392: iconst_5
    //   2393: istore 4
    //   2395: iload 30
    //   2397: iconst_1
    //   2398: iadd
    //   2399: istore 30
    //   2401: goto -2203 -> 198
    //   2404: astore_2
    //   2405: ldc 12
    //   2407: ldc -32
    //   2409: aload_2
    //   2410: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2413: goto -2072 -> 341
    //   2416: astore_2
    //   2417: ldc 12
    //   2419: ldc -46
    //   2421: aload_2
    //   2422: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2425: goto -2076 -> 349
    //   2428: astore_2
    //   2429: ldc 12
    //   2431: ldc -46
    //   2433: aload_2
    //   2434: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2437: iload 30
    //   2439: istore 4
    //   2441: goto -2076 -> 365
    //   2444: astore 9
    //   2446: aload 14
    //   2448: astore 8
    //   2450: aload 13
    //   2452: astore_3
    //   2453: aload 11
    //   2455: astore_2
    //   2456: ldc 12
    //   2458: ldc -46
    //   2460: aload 9
    //   2462: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2465: bipush 6
    //   2467: istore 30
    //   2469: aload 8
    //   2471: ifnull +8 -> 2479
    //   2474: aload 8
    //   2476: invokevirtual 116	java/net/HttpURLConnection:disconnect	()V
    //   2479: aload_3
    //   2480: ifnull +7 -> 2487
    //   2483: aload_3
    //   2484: invokevirtual 119	java/io/InputStream:close	()V
    //   2487: iload 30
    //   2489: istore 4
    //   2491: aload_2
    //   2492: ifnull -2127 -> 365
    //   2495: aload_2
    //   2496: invokevirtual 111	java/io/RandomAccessFile:close	()V
    //   2499: iload 30
    //   2501: istore 4
    //   2503: goto -2138 -> 365
    //   2506: astore_2
    //   2507: ldc 12
    //   2509: ldc -46
    //   2511: aload_2
    //   2512: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2515: iload 30
    //   2517: istore 4
    //   2519: goto -2154 -> 365
    //   2522: astore 8
    //   2524: ldc 12
    //   2526: ldc -32
    //   2528: aload 8
    //   2530: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2533: goto -54 -> 2479
    //   2536: astore_3
    //   2537: ldc 12
    //   2539: ldc -46
    //   2541: aload_3
    //   2542: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2545: goto -58 -> 2487
    //   2548: astore_2
    //   2549: aconst_null
    //   2550: astore 12
    //   2552: aconst_null
    //   2553: astore 26
    //   2555: aload 26
    //   2557: astore 10
    //   2559: aload 21
    //   2561: astore 9
    //   2563: aload 12
    //   2565: astore 16
    //   2567: ldc 12
    //   2569: ldc -46
    //   2571: aload_2
    //   2572: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2575: iconst_2
    //   2576: istore 30
    //   2578: aload 21
    //   2580: ifnull +8 -> 2588
    //   2583: aload 21
    //   2585: invokevirtual 116	java/net/HttpURLConnection:disconnect	()V
    //   2588: aload 26
    //   2590: ifnull +8 -> 2598
    //   2593: aload 26
    //   2595: invokevirtual 119	java/io/InputStream:close	()V
    //   2598: iload 30
    //   2600: istore 4
    //   2602: aload 12
    //   2604: ifnull -2239 -> 365
    //   2607: aload 12
    //   2609: invokevirtual 111	java/io/RandomAccessFile:close	()V
    //   2612: iload 30
    //   2614: istore 4
    //   2616: goto -2251 -> 365
    //   2619: astore_2
    //   2620: ldc 12
    //   2622: ldc -46
    //   2624: aload_2
    //   2625: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2628: iload 30
    //   2630: istore 4
    //   2632: goto -2267 -> 365
    //   2635: astore_2
    //   2636: ldc 12
    //   2638: ldc -32
    //   2640: aload_2
    //   2641: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2644: goto -56 -> 2588
    //   2647: astore_2
    //   2648: ldc 12
    //   2650: ldc -46
    //   2652: aload_2
    //   2653: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2656: goto -58 -> 2598
    //   2659: astore_2
    //   2660: aconst_null
    //   2661: astore 12
    //   2663: aconst_null
    //   2664: astore 23
    //   2666: aload 23
    //   2668: astore 10
    //   2670: aload 19
    //   2672: astore 9
    //   2674: aload 12
    //   2676: astore 16
    //   2678: ldc 12
    //   2680: ldc -46
    //   2682: aload_2
    //   2683: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2686: iconst_1
    //   2687: istore 30
    //   2689: aload 19
    //   2691: ifnull +8 -> 2699
    //   2694: aload 19
    //   2696: invokevirtual 116	java/net/HttpURLConnection:disconnect	()V
    //   2699: aload 23
    //   2701: ifnull +8 -> 2709
    //   2704: aload 23
    //   2706: invokevirtual 119	java/io/InputStream:close	()V
    //   2709: iload 30
    //   2711: istore 4
    //   2713: aload 12
    //   2715: ifnull -2350 -> 365
    //   2718: aload 12
    //   2720: invokevirtual 111	java/io/RandomAccessFile:close	()V
    //   2723: iload 30
    //   2725: istore 4
    //   2727: goto -2362 -> 365
    //   2730: astore_2
    //   2731: ldc 12
    //   2733: ldc -46
    //   2735: aload_2
    //   2736: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2739: iload 30
    //   2741: istore 4
    //   2743: goto -2378 -> 365
    //   2746: astore_2
    //   2747: ldc 12
    //   2749: ldc -32
    //   2751: aload_2
    //   2752: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2755: goto -56 -> 2699
    //   2758: astore_2
    //   2759: ldc 12
    //   2761: ldc -46
    //   2763: aload_2
    //   2764: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2767: goto -58 -> 2709
    //   2770: astore_3
    //   2771: aconst_null
    //   2772: astore 12
    //   2774: aconst_null
    //   2775: astore 25
    //   2777: aload 25
    //   2779: astore 10
    //   2781: aload 20
    //   2783: astore 9
    //   2785: aload 12
    //   2787: astore 16
    //   2789: new 94	java/io/File
    //   2792: dup
    //   2793: aload_2
    //   2794: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   2797: astore_2
    //   2798: aload 25
    //   2800: astore 10
    //   2802: aload 20
    //   2804: astore 9
    //   2806: aload 12
    //   2808: astore 16
    //   2810: aload_2
    //   2811: invokevirtual 98	java/io/File:exists	()Z
    //   2814: ifeq +20 -> 2834
    //   2817: aload 25
    //   2819: astore 10
    //   2821: aload 20
    //   2823: astore 9
    //   2825: aload 12
    //   2827: astore 16
    //   2829: aload_2
    //   2830: invokevirtual 228	java/io/File:delete	()Z
    //   2833: pop
    //   2834: aload 25
    //   2836: astore 10
    //   2838: aload 20
    //   2840: astore 9
    //   2842: aload 12
    //   2844: astore 16
    //   2846: ldc 12
    //   2848: ldc -46
    //   2850: aload_3
    //   2851: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2854: iconst_3
    //   2855: istore 30
    //   2857: aload 20
    //   2859: ifnull +8 -> 2867
    //   2862: aload 20
    //   2864: invokevirtual 116	java/net/HttpURLConnection:disconnect	()V
    //   2867: aload 25
    //   2869: ifnull +8 -> 2877
    //   2872: aload 25
    //   2874: invokevirtual 119	java/io/InputStream:close	()V
    //   2877: iload 30
    //   2879: istore 4
    //   2881: aload 12
    //   2883: ifnull -2518 -> 365
    //   2886: aload 12
    //   2888: invokevirtual 111	java/io/RandomAccessFile:close	()V
    //   2891: iload 30
    //   2893: istore 4
    //   2895: goto -2530 -> 365
    //   2898: astore_2
    //   2899: ldc 12
    //   2901: ldc -46
    //   2903: aload_2
    //   2904: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2907: iload 30
    //   2909: istore 4
    //   2911: goto -2546 -> 365
    //   2914: astore_2
    //   2915: ldc 12
    //   2917: ldc -32
    //   2919: aload_2
    //   2920: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2923: goto -56 -> 2867
    //   2926: astore_2
    //   2927: ldc 12
    //   2929: ldc -46
    //   2931: aload_2
    //   2932: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2935: goto -58 -> 2877
    //   2938: astore_2
    //   2939: aconst_null
    //   2940: astore 12
    //   2942: aconst_null
    //   2943: astore 18
    //   2945: aload 9
    //   2947: astore 8
    //   2949: aload 18
    //   2951: astore 10
    //   2953: aload 8
    //   2955: astore 9
    //   2957: aload 12
    //   2959: astore 16
    //   2961: ldc 12
    //   2963: new 50	java/lang/StringBuilder
    //   2966: dup
    //   2967: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   2970: ldc -26
    //   2972: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2975: aload_1
    //   2976: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2979: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2982: aload_2
    //   2983: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2986: iconst_4
    //   2987: istore 30
    //   2989: aload 8
    //   2991: ifnull +8 -> 2999
    //   2994: aload 8
    //   2996: invokevirtual 116	java/net/HttpURLConnection:disconnect	()V
    //   2999: aload 18
    //   3001: ifnull +8 -> 3009
    //   3004: aload 18
    //   3006: invokevirtual 119	java/io/InputStream:close	()V
    //   3009: iload 30
    //   3011: istore 4
    //   3013: aload 12
    //   3015: ifnull -2650 -> 365
    //   3018: aload 12
    //   3020: invokevirtual 111	java/io/RandomAccessFile:close	()V
    //   3023: iload 30
    //   3025: istore 4
    //   3027: goto -2662 -> 365
    //   3030: astore_2
    //   3031: ldc 12
    //   3033: ldc -46
    //   3035: aload_2
    //   3036: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3039: iload 30
    //   3041: istore 4
    //   3043: goto -2678 -> 365
    //   3046: astore_2
    //   3047: ldc 12
    //   3049: ldc -32
    //   3051: aload_2
    //   3052: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3055: goto -56 -> 2999
    //   3058: astore_2
    //   3059: ldc 12
    //   3061: ldc -46
    //   3063: aload_2
    //   3064: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3067: goto -58 -> 3009
    //   3070: astore_2
    //   3071: aconst_null
    //   3072: astore 12
    //   3074: aconst_null
    //   3075: astore 17
    //   3077: aload 17
    //   3079: astore 10
    //   3081: aload 8
    //   3083: astore 9
    //   3085: aload 12
    //   3087: astore 16
    //   3089: ldc 12
    //   3091: ldc -46
    //   3093: aload_2
    //   3094: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3097: iconst_1
    //   3098: istore 30
    //   3100: aload 8
    //   3102: ifnull +8 -> 3110
    //   3105: aload 8
    //   3107: invokevirtual 116	java/net/HttpURLConnection:disconnect	()V
    //   3110: aload 17
    //   3112: ifnull +8 -> 3120
    //   3115: aload 17
    //   3117: invokevirtual 119	java/io/InputStream:close	()V
    //   3120: iload 30
    //   3122: istore 4
    //   3124: aload 12
    //   3126: ifnull -2761 -> 365
    //   3129: aload 12
    //   3131: invokevirtual 111	java/io/RandomAccessFile:close	()V
    //   3134: iload 30
    //   3136: istore 4
    //   3138: goto -2773 -> 365
    //   3141: astore_2
    //   3142: ldc 12
    //   3144: ldc -46
    //   3146: aload_2
    //   3147: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3150: iload 30
    //   3152: istore 4
    //   3154: goto -2789 -> 365
    //   3157: astore_2
    //   3158: ldc 12
    //   3160: ldc -32
    //   3162: aload_2
    //   3163: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3166: goto -56 -> 3110
    //   3169: astore_2
    //   3170: ldc 12
    //   3172: ldc -46
    //   3174: aload_2
    //   3175: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3178: goto -58 -> 3120
    //   3181: astore_2
    //   3182: aconst_null
    //   3183: astore 12
    //   3185: aconst_null
    //   3186: astore 24
    //   3188: aload 24
    //   3190: astore 10
    //   3192: aload 22
    //   3194: astore 9
    //   3196: aload 12
    //   3198: astore 16
    //   3200: ldc 12
    //   3202: ldc -46
    //   3204: aload_2
    //   3205: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3208: iconst_5
    //   3209: istore 30
    //   3211: aload 22
    //   3213: ifnull +8 -> 3221
    //   3216: aload 22
    //   3218: invokevirtual 116	java/net/HttpURLConnection:disconnect	()V
    //   3221: aload 24
    //   3223: ifnull +8 -> 3231
    //   3226: aload 24
    //   3228: invokevirtual 119	java/io/InputStream:close	()V
    //   3231: iload 30
    //   3233: istore 4
    //   3235: aload 12
    //   3237: ifnull -2872 -> 365
    //   3240: aload 12
    //   3242: invokevirtual 111	java/io/RandomAccessFile:close	()V
    //   3245: iload 30
    //   3247: istore 4
    //   3249: goto -2884 -> 365
    //   3252: astore_2
    //   3253: ldc 12
    //   3255: ldc -46
    //   3257: aload_2
    //   3258: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3261: iload 30
    //   3263: istore 4
    //   3265: goto -2900 -> 365
    //   3268: astore_2
    //   3269: ldc 12
    //   3271: ldc -32
    //   3273: aload_2
    //   3274: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3277: goto -56 -> 3221
    //   3280: astore_2
    //   3281: ldc 12
    //   3283: ldc -46
    //   3285: aload_2
    //   3286: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3289: goto -58 -> 3231
    //   3292: astore_1
    //   3293: aconst_null
    //   3294: astore 12
    //   3296: aconst_null
    //   3297: astore_2
    //   3298: aload 10
    //   3300: astore 8
    //   3302: aload_2
    //   3303: astore 10
    //   3305: aload 8
    //   3307: ifnull +8 -> 3315
    //   3310: aload 8
    //   3312: invokevirtual 116	java/net/HttpURLConnection:disconnect	()V
    //   3315: aload 10
    //   3317: ifnull +8 -> 3325
    //   3320: aload 10
    //   3322: invokevirtual 119	java/io/InputStream:close	()V
    //   3325: aload 12
    //   3327: ifnull +8 -> 3335
    //   3330: aload 12
    //   3332: invokevirtual 111	java/io/RandomAccessFile:close	()V
    //   3335: aload_1
    //   3336: athrow
    //   3337: astore_2
    //   3338: ldc 12
    //   3340: ldc -32
    //   3342: aload_2
    //   3343: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3346: goto -31 -> 3315
    //   3349: astore_2
    //   3350: ldc 12
    //   3352: ldc -46
    //   3354: aload_2
    //   3355: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3358: goto -33 -> 3325
    //   3361: astore_2
    //   3362: ldc 12
    //   3364: ldc -46
    //   3366: aload_2
    //   3367: invokestatic 216	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3370: goto -35 -> 3335
    //   3373: astore_1
    //   3374: aload 15
    //   3376: astore 10
    //   3378: goto -73 -> 3305
    //   3381: astore_1
    //   3382: aload 9
    //   3384: astore 8
    //   3386: aload 16
    //   3388: astore 12
    //   3390: goto -85 -> 3305
    //   3393: astore_1
    //   3394: aload_3
    //   3395: astore 10
    //   3397: aload_2
    //   3398: astore 12
    //   3400: goto -95 -> 3305
    //   3403: astore_2
    //   3404: goto -216 -> 3188
    //   3407: astore_2
    //   3408: aload 15
    //   3410: astore 17
    //   3412: goto -335 -> 3077
    //   3415: astore_2
    //   3416: aload 14
    //   3418: astore 8
    //   3420: goto -343 -> 3077
    //   3423: astore_2
    //   3424: aload 15
    //   3426: astore 18
    //   3428: goto -479 -> 2949
    //   3431: astore_2
    //   3432: aload 13
    //   3434: astore 8
    //   3436: goto -487 -> 2949
    //   3439: astore_3
    //   3440: goto -663 -> 2777
    //   3443: astore_2
    //   3444: goto -778 -> 2666
    //   3447: astore_2
    //   3448: goto -893 -> 2555
    //   3451: astore 9
    //   3453: aload 27
    //   3455: astore_3
    //   3456: aload 12
    //   3458: astore_2
    //   3459: aload 15
    //   3461: astore 8
    //   3463: goto -1007 -> 2456
    //   3466: astore 29
    //   3468: aload 21
    //   3470: astore 8
    //   3472: goto -1303 -> 2169
    //   3475: astore 29
    //   3477: aload 19
    //   3479: astore 8
    //   3481: goto -1547 -> 1934
    //   3484: astore 29
    //   3486: aload 20
    //   3488: astore 8
    //   3490: goto -1791 -> 1699
    //   3493: astore 29
    //   3495: aload 23
    //   3497: astore 8
    //   3499: goto -2035 -> 1464
    //   3502: astore 28
    //   3504: aload 11
    //   3506: astore_3
    //   3507: aload 22
    //   3509: astore 8
    //   3511: goto -2123 -> 1388
    //   3514: goto -2188 -> 1326
    //   3517: goto -3366 -> 151
    //   3520: astore 29
    //   3522: aload 15
    //   3524: astore 11
    //   3526: lload 35
    //   3528: lstore 5
    //   3530: goto -2066 -> 1464
    //   3533: astore 29
    //   3535: aload 15
    //   3537: astore 11
    //   3539: lload 37
    //   3541: lstore 5
    //   3543: goto -1844 -> 1699
    //   3546: astore 29
    //   3548: aload 15
    //   3550: astore 11
    //   3552: lload 39
    //   3554: lstore 5
    //   3556: goto -1622 -> 1934
    //   3559: astore 29
    //   3561: aload 15
    //   3563: astore 11
    //   3565: lload 41
    //   3567: lstore 5
    //   3569: goto -1400 -> 2169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3572	0	this	DownloaderImp
    //   0	3572	1	paramString1	String
    //   0	3572	2	paramString2	String
    //   0	3572	3	paramHashMap	HashMap
    //   0	3572	4	paramInt	int
    //   0	3572	5	paramLong	long
    //   0	3572	7	paramBoolean	boolean
    //   100	2375	8	localObject1	Object
    //   2522	7	8	localException1	Exception
    //   2947	563	8	localObject2	Object
    //   97	2228	9	localObject3	Object
    //   2444	17	9	localInterruptedException1	InterruptedException
    //   2561	822	9	localObject4	Object
    //   3451	1	9	localInterruptedException2	InterruptedException
    //   106	3290	10	localObject5	Object
    //   115	3449	11	localObject6	Object
    //   155	3302	12	localObject7	Object
    //   112	3321	13	localObject8	Object
    //   85	3332	14	localObject9	Object
    //   109	3453	15	localObject10	Object
    //   208	3179	16	localObject11	Object
    //   212	3199	17	localObject12	Object
    //   220	3207	18	localObject13	Object
    //   91	3387	19	localObject14	Object
    //   94	3393	20	localObject15	Object
    //   88	3381	21	localObject16	Object
    //   103	3405	22	localObject17	Object
    //   240	3256	23	localObject18	Object
    //   278	2949	24	localObject19	Object
    //   299	2574	25	localObject20	Object
    //   313	2281	26	localObject21	Object
    //   320	3134	27	localObject22	Object
    //   134	435	28	localURL	java.net.URL
    //   1383	70	28	localInterruptedException3	InterruptedException
    //   3502	1	28	localInterruptedException4	InterruptedException
    //   1536	706	29	localThrowable	Throwable
    //   3466	1	29	localException2	Exception
    //   3475	1	29	localFileNotFoundException1	java.io.FileNotFoundException
    //   3484	1	29	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   3493	1	29	localSocketException1	java.net.SocketException
    //   3520	1	29	localSocketException2	java.net.SocketException
    //   3533	1	29	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   3546	1	29	localFileNotFoundException2	java.io.FileNotFoundException
    //   3559	1	29	localException3	Exception
    //   185	3077	30	i	int
    //   124	1035	31	j	int
    //   82	1146	32	k	int
    //   1166	207	33	l1	long
    //   1120	2407	35	l2	long
    //   1124	2416	37	l3	long
    //   1128	2425	39	l4	long
    //   1132	2434	41	l5	long
    //   1140	142	43	l6	long
    // Exception table:
    //   from	to	target	type
    //   1134	1142	1383	java/lang/InterruptedException
    //   1158	1164	1383	java/lang/InterruptedException
    //   1184	1193	1383	java/lang/InterruptedException
    //   1215	1225	1383	java/lang/InterruptedException
    //   1249	1256	1383	java/lang/InterruptedException
    //   1272	1289	1383	java/lang/InterruptedException
    //   1310	1322	1383	java/lang/InterruptedException
    //   1342	1350	1383	java/lang/InterruptedException
    //   1376	1380	1383	java/lang/InterruptedException
    //   336	341	2404	java/lang/Exception
    //   345	349	2416	java/io/IOException
    //   357	365	2428	java/io/IOException
    //   126	151	2444	java/lang/InterruptedException
    //   151	171	2444	java/lang/InterruptedException
    //   171	184	2444	java/lang/InterruptedException
    //   2495	2499	2506	java/io/IOException
    //   2474	2479	2522	java/lang/Exception
    //   2483	2487	2536	java/io/IOException
    //   126	151	2548	java/net/SocketTimeoutException
    //   151	171	2548	java/net/SocketTimeoutException
    //   171	184	2548	java/net/SocketTimeoutException
    //   2607	2612	2619	java/io/IOException
    //   2583	2588	2635	java/lang/Exception
    //   2593	2598	2647	java/io/IOException
    //   126	151	2659	java/net/SocketException
    //   151	171	2659	java/net/SocketException
    //   171	184	2659	java/net/SocketException
    //   2718	2723	2730	java/io/IOException
    //   2694	2699	2746	java/lang/Exception
    //   2704	2709	2758	java/io/IOException
    //   126	151	2770	java/io/FileNotFoundException
    //   151	171	2770	java/io/FileNotFoundException
    //   171	184	2770	java/io/FileNotFoundException
    //   2886	2891	2898	java/io/IOException
    //   2862	2867	2914	java/lang/Exception
    //   2872	2877	2926	java/io/IOException
    //   126	151	2938	java/net/MalformedURLException
    //   151	171	2938	java/net/MalformedURLException
    //   171	184	2938	java/net/MalformedURLException
    //   3018	3023	3030	java/io/IOException
    //   2994	2999	3046	java/lang/Exception
    //   3004	3009	3058	java/io/IOException
    //   126	151	3070	java/io/IOException
    //   151	171	3070	java/io/IOException
    //   171	184	3070	java/io/IOException
    //   3129	3134	3141	java/io/IOException
    //   3105	3110	3157	java/lang/Exception
    //   3115	3120	3169	java/io/IOException
    //   126	151	3181	java/lang/Exception
    //   151	171	3181	java/lang/Exception
    //   171	184	3181	java/lang/Exception
    //   3240	3245	3252	java/io/IOException
    //   3216	3221	3268	java/lang/Exception
    //   3226	3231	3280	java/io/IOException
    //   126	151	3292	finally
    //   151	171	3292	finally
    //   171	184	3292	finally
    //   3310	3315	3337	java/lang/Exception
    //   3320	3325	3349	java/io/IOException
    //   3330	3335	3361	java/io/IOException
    //   1134	1142	3373	finally
    //   1158	1164	3373	finally
    //   1184	1193	3373	finally
    //   1215	1225	3373	finally
    //   1249	1256	3373	finally
    //   1272	1289	3373	finally
    //   1310	1322	3373	finally
    //   1342	1350	3373	finally
    //   1376	1380	3373	finally
    //   246	252	3381	finally
    //   326	331	3381	finally
    //   447	454	3381	finally
    //   512	520	3381	finally
    //   568	578	3381	finally
    //   626	632	3381	finally
    //   680	688	3381	finally
    //   736	744	3381	finally
    //   792	801	3381	finally
    //   849	855	3381	finally
    //   903	910	3381	finally
    //   958	990	3381	finally
    //   1038	1063	3381	finally
    //   1111	1118	3381	finally
    //   1448	1457	3381	finally
    //   1532	1541	3381	finally
    //   1609	1613	3381	finally
    //   1681	1687	3381	finally
    //   1767	1776	3381	finally
    //   1844	1848	3381	finally
    //   1916	1922	3381	finally
    //   2002	2011	3381	finally
    //   2079	2083	3381	finally
    //   2151	2157	3381	finally
    //   2237	2246	3381	finally
    //   2314	2318	3381	finally
    //   2386	2392	3381	finally
    //   2567	2575	3381	finally
    //   2678	2686	3381	finally
    //   2789	2798	3381	finally
    //   2810	2817	3381	finally
    //   2829	2834	3381	finally
    //   2846	2854	3381	finally
    //   2961	2986	3381	finally
    //   3089	3097	3381	finally
    //   3200	3208	3381	finally
    //   2456	2465	3393	finally
    //   326	331	3403	java/lang/Exception
    //   1448	1457	3403	java/lang/Exception
    //   1532	1541	3403	java/lang/Exception
    //   1609	1613	3403	java/lang/Exception
    //   1681	1687	3403	java/lang/Exception
    //   1767	1776	3403	java/lang/Exception
    //   1844	1848	3403	java/lang/Exception
    //   1916	1922	3403	java/lang/Exception
    //   2002	2011	3403	java/lang/Exception
    //   2079	2083	3403	java/lang/Exception
    //   2151	2157	3403	java/lang/Exception
    //   2237	2246	3403	java/lang/Exception
    //   2314	2318	3403	java/lang/Exception
    //   2386	2392	3403	java/lang/Exception
    //   1134	1142	3407	java/io/IOException
    //   1158	1164	3407	java/io/IOException
    //   1184	1193	3407	java/io/IOException
    //   1215	1225	3407	java/io/IOException
    //   1249	1256	3407	java/io/IOException
    //   1272	1289	3407	java/io/IOException
    //   1310	1322	3407	java/io/IOException
    //   1342	1350	3407	java/io/IOException
    //   1376	1380	3407	java/io/IOException
    //   246	252	3415	java/io/IOException
    //   326	331	3415	java/io/IOException
    //   447	454	3415	java/io/IOException
    //   512	520	3415	java/io/IOException
    //   568	578	3415	java/io/IOException
    //   626	632	3415	java/io/IOException
    //   680	688	3415	java/io/IOException
    //   736	744	3415	java/io/IOException
    //   792	801	3415	java/io/IOException
    //   849	855	3415	java/io/IOException
    //   903	910	3415	java/io/IOException
    //   958	990	3415	java/io/IOException
    //   1038	1063	3415	java/io/IOException
    //   1111	1118	3415	java/io/IOException
    //   1448	1457	3415	java/io/IOException
    //   1532	1541	3415	java/io/IOException
    //   1609	1613	3415	java/io/IOException
    //   1681	1687	3415	java/io/IOException
    //   1767	1776	3415	java/io/IOException
    //   1844	1848	3415	java/io/IOException
    //   1916	1922	3415	java/io/IOException
    //   2002	2011	3415	java/io/IOException
    //   2079	2083	3415	java/io/IOException
    //   2151	2157	3415	java/io/IOException
    //   2237	2246	3415	java/io/IOException
    //   2314	2318	3415	java/io/IOException
    //   2386	2392	3415	java/io/IOException
    //   1134	1142	3423	java/net/MalformedURLException
    //   1158	1164	3423	java/net/MalformedURLException
    //   1184	1193	3423	java/net/MalformedURLException
    //   1215	1225	3423	java/net/MalformedURLException
    //   1249	1256	3423	java/net/MalformedURLException
    //   1272	1289	3423	java/net/MalformedURLException
    //   1310	1322	3423	java/net/MalformedURLException
    //   1342	1350	3423	java/net/MalformedURLException
    //   1376	1380	3423	java/net/MalformedURLException
    //   246	252	3431	java/net/MalformedURLException
    //   326	331	3431	java/net/MalformedURLException
    //   447	454	3431	java/net/MalformedURLException
    //   512	520	3431	java/net/MalformedURLException
    //   568	578	3431	java/net/MalformedURLException
    //   626	632	3431	java/net/MalformedURLException
    //   680	688	3431	java/net/MalformedURLException
    //   736	744	3431	java/net/MalformedURLException
    //   792	801	3431	java/net/MalformedURLException
    //   849	855	3431	java/net/MalformedURLException
    //   903	910	3431	java/net/MalformedURLException
    //   958	990	3431	java/net/MalformedURLException
    //   1038	1063	3431	java/net/MalformedURLException
    //   1111	1118	3431	java/net/MalformedURLException
    //   1448	1457	3431	java/net/MalformedURLException
    //   1532	1541	3431	java/net/MalformedURLException
    //   1609	1613	3431	java/net/MalformedURLException
    //   1681	1687	3431	java/net/MalformedURLException
    //   1767	1776	3431	java/net/MalformedURLException
    //   1844	1848	3431	java/net/MalformedURLException
    //   1916	1922	3431	java/net/MalformedURLException
    //   2002	2011	3431	java/net/MalformedURLException
    //   2079	2083	3431	java/net/MalformedURLException
    //   2151	2157	3431	java/net/MalformedURLException
    //   2237	2246	3431	java/net/MalformedURLException
    //   2314	2318	3431	java/net/MalformedURLException
    //   2386	2392	3431	java/net/MalformedURLException
    //   326	331	3439	java/io/FileNotFoundException
    //   1448	1457	3439	java/io/FileNotFoundException
    //   1532	1541	3439	java/io/FileNotFoundException
    //   1609	1613	3439	java/io/FileNotFoundException
    //   1681	1687	3439	java/io/FileNotFoundException
    //   1767	1776	3439	java/io/FileNotFoundException
    //   1844	1848	3439	java/io/FileNotFoundException
    //   1916	1922	3439	java/io/FileNotFoundException
    //   2002	2011	3439	java/io/FileNotFoundException
    //   2079	2083	3439	java/io/FileNotFoundException
    //   2151	2157	3439	java/io/FileNotFoundException
    //   2237	2246	3439	java/io/FileNotFoundException
    //   2314	2318	3439	java/io/FileNotFoundException
    //   2386	2392	3439	java/io/FileNotFoundException
    //   326	331	3443	java/net/SocketException
    //   1448	1457	3443	java/net/SocketException
    //   1532	1541	3443	java/net/SocketException
    //   1609	1613	3443	java/net/SocketException
    //   1681	1687	3443	java/net/SocketException
    //   1767	1776	3443	java/net/SocketException
    //   1844	1848	3443	java/net/SocketException
    //   1916	1922	3443	java/net/SocketException
    //   2002	2011	3443	java/net/SocketException
    //   2079	2083	3443	java/net/SocketException
    //   2151	2157	3443	java/net/SocketException
    //   2237	2246	3443	java/net/SocketException
    //   2314	2318	3443	java/net/SocketException
    //   2386	2392	3443	java/net/SocketException
    //   326	331	3447	java/net/SocketTimeoutException
    //   1448	1457	3447	java/net/SocketTimeoutException
    //   1532	1541	3447	java/net/SocketTimeoutException
    //   1609	1613	3447	java/net/SocketTimeoutException
    //   1681	1687	3447	java/net/SocketTimeoutException
    //   1767	1776	3447	java/net/SocketTimeoutException
    //   1844	1848	3447	java/net/SocketTimeoutException
    //   1916	1922	3447	java/net/SocketTimeoutException
    //   2002	2011	3447	java/net/SocketTimeoutException
    //   2079	2083	3447	java/net/SocketTimeoutException
    //   2151	2157	3447	java/net/SocketTimeoutException
    //   2237	2246	3447	java/net/SocketTimeoutException
    //   2314	2318	3447	java/net/SocketTimeoutException
    //   2386	2392	3447	java/net/SocketTimeoutException
    //   326	331	3451	java/lang/InterruptedException
    //   1448	1457	3451	java/lang/InterruptedException
    //   1532	1541	3451	java/lang/InterruptedException
    //   1609	1613	3451	java/lang/InterruptedException
    //   1681	1687	3451	java/lang/InterruptedException
    //   1767	1776	3451	java/lang/InterruptedException
    //   1844	1848	3451	java/lang/InterruptedException
    //   1916	1922	3451	java/lang/InterruptedException
    //   2002	2011	3451	java/lang/InterruptedException
    //   2079	2083	3451	java/lang/InterruptedException
    //   2151	2157	3451	java/lang/InterruptedException
    //   2237	2246	3451	java/lang/InterruptedException
    //   2314	2318	3451	java/lang/InterruptedException
    //   2386	2392	3451	java/lang/InterruptedException
    //   246	252	3466	java/lang/Exception
    //   447	454	3466	java/lang/Exception
    //   512	520	3466	java/lang/Exception
    //   568	578	3466	java/lang/Exception
    //   626	632	3466	java/lang/Exception
    //   680	688	3466	java/lang/Exception
    //   736	744	3466	java/lang/Exception
    //   792	801	3466	java/lang/Exception
    //   849	855	3466	java/lang/Exception
    //   903	910	3466	java/lang/Exception
    //   958	990	3466	java/lang/Exception
    //   1038	1063	3466	java/lang/Exception
    //   1111	1118	3466	java/lang/Exception
    //   246	252	3475	java/io/FileNotFoundException
    //   447	454	3475	java/io/FileNotFoundException
    //   512	520	3475	java/io/FileNotFoundException
    //   568	578	3475	java/io/FileNotFoundException
    //   626	632	3475	java/io/FileNotFoundException
    //   680	688	3475	java/io/FileNotFoundException
    //   736	744	3475	java/io/FileNotFoundException
    //   792	801	3475	java/io/FileNotFoundException
    //   849	855	3475	java/io/FileNotFoundException
    //   903	910	3475	java/io/FileNotFoundException
    //   958	990	3475	java/io/FileNotFoundException
    //   1038	1063	3475	java/io/FileNotFoundException
    //   1111	1118	3475	java/io/FileNotFoundException
    //   246	252	3484	java/net/SocketTimeoutException
    //   447	454	3484	java/net/SocketTimeoutException
    //   512	520	3484	java/net/SocketTimeoutException
    //   568	578	3484	java/net/SocketTimeoutException
    //   626	632	3484	java/net/SocketTimeoutException
    //   680	688	3484	java/net/SocketTimeoutException
    //   736	744	3484	java/net/SocketTimeoutException
    //   792	801	3484	java/net/SocketTimeoutException
    //   849	855	3484	java/net/SocketTimeoutException
    //   903	910	3484	java/net/SocketTimeoutException
    //   958	990	3484	java/net/SocketTimeoutException
    //   1038	1063	3484	java/net/SocketTimeoutException
    //   1111	1118	3484	java/net/SocketTimeoutException
    //   246	252	3493	java/net/SocketException
    //   447	454	3493	java/net/SocketException
    //   512	520	3493	java/net/SocketException
    //   568	578	3493	java/net/SocketException
    //   626	632	3493	java/net/SocketException
    //   680	688	3493	java/net/SocketException
    //   736	744	3493	java/net/SocketException
    //   792	801	3493	java/net/SocketException
    //   849	855	3493	java/net/SocketException
    //   903	910	3493	java/net/SocketException
    //   958	990	3493	java/net/SocketException
    //   1038	1063	3493	java/net/SocketException
    //   1111	1118	3493	java/net/SocketException
    //   246	252	3502	java/lang/InterruptedException
    //   447	454	3502	java/lang/InterruptedException
    //   512	520	3502	java/lang/InterruptedException
    //   568	578	3502	java/lang/InterruptedException
    //   626	632	3502	java/lang/InterruptedException
    //   680	688	3502	java/lang/InterruptedException
    //   736	744	3502	java/lang/InterruptedException
    //   792	801	3502	java/lang/InterruptedException
    //   849	855	3502	java/lang/InterruptedException
    //   903	910	3502	java/lang/InterruptedException
    //   958	990	3502	java/lang/InterruptedException
    //   1038	1063	3502	java/lang/InterruptedException
    //   1111	1118	3502	java/lang/InterruptedException
    //   1134	1142	3520	java/net/SocketException
    //   1158	1164	3520	java/net/SocketException
    //   1184	1193	3520	java/net/SocketException
    //   1215	1225	3520	java/net/SocketException
    //   1249	1256	3520	java/net/SocketException
    //   1272	1289	3520	java/net/SocketException
    //   1310	1322	3520	java/net/SocketException
    //   1342	1350	3520	java/net/SocketException
    //   1376	1380	3520	java/net/SocketException
    //   1134	1142	3533	java/net/SocketTimeoutException
    //   1158	1164	3533	java/net/SocketTimeoutException
    //   1184	1193	3533	java/net/SocketTimeoutException
    //   1215	1225	3533	java/net/SocketTimeoutException
    //   1249	1256	3533	java/net/SocketTimeoutException
    //   1272	1289	3533	java/net/SocketTimeoutException
    //   1310	1322	3533	java/net/SocketTimeoutException
    //   1342	1350	3533	java/net/SocketTimeoutException
    //   1376	1380	3533	java/net/SocketTimeoutException
    //   1134	1142	3546	java/io/FileNotFoundException
    //   1158	1164	3546	java/io/FileNotFoundException
    //   1184	1193	3546	java/io/FileNotFoundException
    //   1215	1225	3546	java/io/FileNotFoundException
    //   1249	1256	3546	java/io/FileNotFoundException
    //   1272	1289	3546	java/io/FileNotFoundException
    //   1310	1322	3546	java/io/FileNotFoundException
    //   1342	1350	3546	java/io/FileNotFoundException
    //   1376	1380	3546	java/io/FileNotFoundException
    //   1134	1142	3559	java/lang/Exception
    //   1158	1164	3559	java/lang/Exception
    //   1184	1193	3559	java/lang/Exception
    //   1215	1225	3559	java/lang/Exception
    //   1249	1256	3559	java/lang/Exception
    //   1272	1289	3559	java/lang/Exception
    //   1310	1322	3559	java/lang/Exception
    //   1342	1350	3559	java/lang/Exception
    //   1376	1380	3559	java/lang/Exception
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
      SLog.b("Q.qqstory.download:DownloaderImp", "", paramHttpURLConnection);
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
  
  public int a(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1, paramString2, null, 65536, paramLong, false);
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("retryCount should not be less than 0");
    }
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(DownloadProgressListener paramDownloadProgressListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadProgressListener = paramDownloadProgressListener;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int b(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1, paramString2, null, 65536, paramLong, true);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\download\DownloaderImp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */