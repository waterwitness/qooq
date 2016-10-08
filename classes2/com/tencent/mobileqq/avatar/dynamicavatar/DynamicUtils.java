package com.tencent.mobileqq.avatar.dynamicavatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.av.config.ByteBuffer;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.CompressConfig;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;
import java.util.TimeZone;
import qtc;

public class DynamicUtils
{
  private static final String a = DynamicUtils.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  private static int a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   6: lstore 11
    //   8: new 41	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig
    //   11: dup
    //   12: invokespecial 42	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:<init>	()V
    //   15: astore 4
    //   17: aload 4
    //   19: iload_3
    //   20: putfield 46	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:c	I
    //   23: aload 4
    //   25: iload_3
    //   26: putfield 49	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:d	I
    //   29: aload 4
    //   31: ldc 51
    //   33: putfield 52	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:a	Ljava/lang/String;
    //   36: aload 4
    //   38: bipush 25
    //   40: putfield 55	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:e	I
    //   43: aload_1
    //   44: aload_2
    //   45: aload 4
    //   47: invokestatic 58	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig;)[Ljava/lang/String;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnonnull +8 -> 60
    //   55: ldc 60
    //   57: invokestatic 63	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: invokestatic 69	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   64: astore_0
    //   65: ldc 71
    //   67: invokestatic 75	com/tencent/video/decode/ShortVideoSoLoad:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 4
    //   72: new 77	java/lang/ProcessBuilder
    //   75: dup
    //   76: iconst_0
    //   77: anewarray 79	java/lang/String
    //   80: invokespecial 82	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   83: astore 5
    //   85: aload 5
    //   87: iconst_1
    //   88: invokevirtual 86	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   91: pop
    //   92: new 88	java/util/ArrayList
    //   95: dup
    //   96: invokespecial 89	java/util/ArrayList:<init>	()V
    //   99: astore 7
    //   101: aload 7
    //   103: new 91	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   110: aload_0
    //   111: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 98
    //   116: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokeinterface 107 2 0
    //   127: pop
    //   128: new 91	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   135: ldc 109
    //   137: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload 7
    //   142: iconst_0
    //   143: invokeinterface 113 2 0
    //   148: checkcast 79	java/lang/String
    //   151: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 63	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   160: aload_1
    //   161: arraylength
    //   162: istore 10
    //   164: iconst_0
    //   165: istore_3
    //   166: iload_3
    //   167: iload 10
    //   169: if_icmpge +21 -> 190
    //   172: aload 7
    //   174: aload_1
    //   175: iload_3
    //   176: aaload
    //   177: invokeinterface 107 2 0
    //   182: pop
    //   183: iload_3
    //   184: iconst_1
    //   185: iadd
    //   186: istore_3
    //   187: goto -21 -> 166
    //   190: aload 7
    //   192: new 91	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   199: aload_0
    //   200: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload 4
    //   205: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokeinterface 107 2 0
    //   216: pop
    //   217: aload 5
    //   219: aload 7
    //   221: invokevirtual 117	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   224: pop
    //   225: new 91	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   232: ldc 119
    //   234: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload 7
    //   239: aload 7
    //   241: invokeinterface 123 1 0
    //   246: iconst_1
    //   247: isub
    //   248: invokeinterface 113 2 0
    //   253: checkcast 79	java/lang/String
    //   256: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 63	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   265: aload 5
    //   267: invokevirtual 127	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   270: astore 8
    //   272: aload 8
    //   274: invokevirtual 133	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   277: astore_0
    //   278: new 135	java/io/InputStreamReader
    //   281: dup
    //   282: aload_0
    //   283: invokespecial 138	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   286: astore_1
    //   287: new 140	java/io/BufferedReader
    //   290: dup
    //   291: aload_1
    //   292: invokespecial 143	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   295: astore 7
    //   297: aload 7
    //   299: astore 6
    //   301: aload_1
    //   302: astore 5
    //   304: aload_0
    //   305: astore 4
    //   307: aload 8
    //   309: invokevirtual 146	java/lang/Process:waitFor	()I
    //   312: pop
    //   313: aload 7
    //   315: astore 6
    //   317: aload_1
    //   318: astore 5
    //   320: aload_0
    //   321: astore 4
    //   323: aload 8
    //   325: invokevirtual 149	java/lang/Process:exitValue	()I
    //   328: istore 10
    //   330: aload 7
    //   332: astore 6
    //   334: aload_1
    //   335: astore 5
    //   337: aload_0
    //   338: astore 4
    //   340: new 91	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   347: ldc -105
    //   349: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: iload 10
    //   354: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 63	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   363: aload 7
    //   365: astore 6
    //   367: aload_1
    //   368: astore 5
    //   370: aload_0
    //   371: astore 4
    //   373: aload 7
    //   375: invokevirtual 157	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   378: astore 9
    //   380: aload 9
    //   382: ifnull +223 -> 605
    //   385: aload 7
    //   387: astore 6
    //   389: aload_1
    //   390: astore 5
    //   392: aload_0
    //   393: astore 4
    //   395: new 91	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   402: ldc -97
    //   404: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload 9
    //   409: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 63	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   418: goto -55 -> 363
    //   421: astore 8
    //   423: sipush 64535
    //   426: istore 10
    //   428: aload 7
    //   430: astore 6
    //   432: aload_1
    //   433: astore 5
    //   435: aload_0
    //   436: astore 4
    //   438: aload 8
    //   440: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   443: aload 7
    //   445: astore 6
    //   447: aload_1
    //   448: astore 5
    //   450: aload_0
    //   451: astore 4
    //   453: new 91	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   460: ldc -92
    //   462: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload 8
    //   467: invokevirtual 165	java/io/IOException:toString	()Ljava/lang/String;
    //   470: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 63	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   479: aload_0
    //   480: ifnull +7 -> 487
    //   483: aload_0
    //   484: invokevirtual 170	java/io/InputStream:close	()V
    //   487: aload_1
    //   488: ifnull +7 -> 495
    //   491: aload_1
    //   492: invokevirtual 171	java/io/InputStreamReader:close	()V
    //   495: iload 10
    //   497: istore_3
    //   498: aload 7
    //   500: ifnull +11 -> 511
    //   503: aload 7
    //   505: invokevirtual 172	java/io/BufferedReader:close	()V
    //   508: iload 10
    //   510: istore_3
    //   511: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   514: lstore 13
    //   516: new 91	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   523: ldc -82
    //   525: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: lload 13
    //   530: lload 11
    //   532: lsub
    //   533: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   536: ldc -77
    //   538: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: ldc -75
    //   543: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: iload_3
    //   547: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   550: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: invokestatic 63	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   556: iload_3
    //   557: ifeq +46 -> 603
    //   560: new 183	java/io/File
    //   563: dup
    //   564: aload_2
    //   565: invokespecial 185	java/io/File:<init>	(Ljava/lang/String;)V
    //   568: astore_0
    //   569: aload_0
    //   570: invokevirtual 189	java/io/File:exists	()Z
    //   573: ifeq +30 -> 603
    //   576: aload_0
    //   577: invokevirtual 192	java/io/File:delete	()Z
    //   580: pop
    //   581: new 91	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   588: ldc -62
    //   590: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: iload_3
    //   594: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   597: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 63	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   603: iload_3
    //   604: ireturn
    //   605: aload 7
    //   607: astore 6
    //   609: aload_1
    //   610: astore 5
    //   612: aload_0
    //   613: astore 4
    //   615: aload 8
    //   617: invokevirtual 197	java/lang/Process:destroy	()V
    //   620: aload 7
    //   622: astore 6
    //   624: aload_1
    //   625: astore 5
    //   627: aload_0
    //   628: astore 4
    //   630: ldc -57
    //   632: invokestatic 63	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   635: aload_0
    //   636: ifnull +7 -> 643
    //   639: aload_0
    //   640: invokevirtual 170	java/io/InputStream:close	()V
    //   643: aload_1
    //   644: ifnull +7 -> 651
    //   647: aload_1
    //   648: invokevirtual 171	java/io/InputStreamReader:close	()V
    //   651: iload 10
    //   653: istore_3
    //   654: aload 7
    //   656: ifnull -145 -> 511
    //   659: aload 7
    //   661: invokevirtual 172	java/io/BufferedReader:close	()V
    //   664: iload 10
    //   666: istore_3
    //   667: goto -156 -> 511
    //   670: astore_0
    //   671: iload 10
    //   673: istore_3
    //   674: goto -163 -> 511
    //   677: astore 8
    //   679: aconst_null
    //   680: astore 7
    //   682: aconst_null
    //   683: astore_1
    //   684: aconst_null
    //   685: astore_0
    //   686: sipush 64534
    //   689: istore 10
    //   691: aload 7
    //   693: astore 6
    //   695: aload_1
    //   696: astore 5
    //   698: aload_0
    //   699: astore 4
    //   701: aload 8
    //   703: invokevirtual 200	java/lang/InterruptedException:printStackTrace	()V
    //   706: aload 7
    //   708: astore 6
    //   710: aload_1
    //   711: astore 5
    //   713: aload_0
    //   714: astore 4
    //   716: new 91	java/lang/StringBuilder
    //   719: dup
    //   720: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   723: ldc -54
    //   725: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: aload 8
    //   730: invokevirtual 203	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   733: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   739: invokestatic 63	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   742: aload_0
    //   743: ifnull +7 -> 750
    //   746: aload_0
    //   747: invokevirtual 170	java/io/InputStream:close	()V
    //   750: aload_1
    //   751: ifnull +7 -> 758
    //   754: aload_1
    //   755: invokevirtual 171	java/io/InputStreamReader:close	()V
    //   758: iload 10
    //   760: istore_3
    //   761: aload 7
    //   763: ifnull -252 -> 511
    //   766: aload 7
    //   768: invokevirtual 172	java/io/BufferedReader:close	()V
    //   771: iload 10
    //   773: istore_3
    //   774: goto -263 -> 511
    //   777: astore_0
    //   778: iload 10
    //   780: istore_3
    //   781: goto -270 -> 511
    //   784: astore 8
    //   786: aconst_null
    //   787: astore 7
    //   789: aconst_null
    //   790: astore_1
    //   791: aconst_null
    //   792: astore_0
    //   793: sipush 64533
    //   796: istore 10
    //   798: aload 7
    //   800: astore 6
    //   802: aload_1
    //   803: astore 5
    //   805: aload_0
    //   806: astore 4
    //   808: aload 8
    //   810: invokevirtual 204	java/lang/Exception:printStackTrace	()V
    //   813: aload 7
    //   815: astore 6
    //   817: aload_1
    //   818: astore 5
    //   820: aload_0
    //   821: astore 4
    //   823: new 91	java/lang/StringBuilder
    //   826: dup
    //   827: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   830: ldc -50
    //   832: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: aload 8
    //   837: invokevirtual 207	java/lang/Exception:toString	()Ljava/lang/String;
    //   840: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   846: invokestatic 63	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   849: aload_0
    //   850: ifnull +7 -> 857
    //   853: aload_0
    //   854: invokevirtual 170	java/io/InputStream:close	()V
    //   857: aload_1
    //   858: ifnull +7 -> 865
    //   861: aload_1
    //   862: invokevirtual 171	java/io/InputStreamReader:close	()V
    //   865: iload 10
    //   867: istore_3
    //   868: aload 7
    //   870: ifnull -359 -> 511
    //   873: aload 7
    //   875: invokevirtual 172	java/io/BufferedReader:close	()V
    //   878: iload 10
    //   880: istore_3
    //   881: goto -370 -> 511
    //   884: astore_0
    //   885: iload 10
    //   887: istore_3
    //   888: goto -377 -> 511
    //   891: astore_2
    //   892: aconst_null
    //   893: astore_1
    //   894: aconst_null
    //   895: astore_0
    //   896: aload_0
    //   897: ifnull +7 -> 904
    //   900: aload_0
    //   901: invokevirtual 170	java/io/InputStream:close	()V
    //   904: aload_1
    //   905: ifnull +7 -> 912
    //   908: aload_1
    //   909: invokevirtual 171	java/io/InputStreamReader:close	()V
    //   912: aload 6
    //   914: ifnull +8 -> 922
    //   917: aload 6
    //   919: invokevirtual 172	java/io/BufferedReader:close	()V
    //   922: aload_2
    //   923: athrow
    //   924: astore_0
    //   925: iload_3
    //   926: ireturn
    //   927: astore_0
    //   928: goto -6 -> 922
    //   931: astore_2
    //   932: aconst_null
    //   933: astore_1
    //   934: goto -38 -> 896
    //   937: astore_2
    //   938: goto -42 -> 896
    //   941: astore_2
    //   942: aload 5
    //   944: astore_1
    //   945: aload 4
    //   947: astore_0
    //   948: goto -52 -> 896
    //   951: astore 8
    //   953: aconst_null
    //   954: astore 7
    //   956: aconst_null
    //   957: astore_1
    //   958: goto -165 -> 793
    //   961: astore 8
    //   963: aconst_null
    //   964: astore 7
    //   966: goto -173 -> 793
    //   969: astore 8
    //   971: goto -178 -> 793
    //   974: astore 8
    //   976: aconst_null
    //   977: astore 7
    //   979: aconst_null
    //   980: astore_1
    //   981: goto -295 -> 686
    //   984: astore 8
    //   986: aconst_null
    //   987: astore 7
    //   989: goto -303 -> 686
    //   992: astore 8
    //   994: goto -308 -> 686
    //   997: astore_0
    //   998: iload 10
    //   1000: istore_3
    //   1001: goto -490 -> 511
    //   1004: astore 8
    //   1006: aconst_null
    //   1007: astore 7
    //   1009: aconst_null
    //   1010: astore_1
    //   1011: aconst_null
    //   1012: astore_0
    //   1013: goto -590 -> 423
    //   1016: astore 8
    //   1018: aconst_null
    //   1019: astore 7
    //   1021: aconst_null
    //   1022: astore_1
    //   1023: goto -600 -> 423
    //   1026: astore 8
    //   1028: aconst_null
    //   1029: astore 7
    //   1031: goto -608 -> 423
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1034	0	paramContext	Context
    //   0	1034	1	paramString1	String
    //   0	1034	2	paramString2	String
    //   0	1034	3	paramInt	int
    //   15	931	4	localObject1	Object
    //   83	860	5	localObject2	Object
    //   1	917	6	localObject3	Object
    //   99	931	7	localObject4	Object
    //   270	54	8	localProcess	Process
    //   421	195	8	localIOException1	java.io.IOException
    //   677	52	8	localInterruptedException1	InterruptedException
    //   784	52	8	localException1	Exception
    //   951	1	8	localException2	Exception
    //   961	1	8	localException3	Exception
    //   969	1	8	localException4	Exception
    //   974	1	8	localInterruptedException2	InterruptedException
    //   984	1	8	localInterruptedException3	InterruptedException
    //   992	1	8	localInterruptedException4	InterruptedException
    //   1004	1	8	localIOException2	java.io.IOException
    //   1016	1	8	localIOException3	java.io.IOException
    //   1026	1	8	localIOException4	java.io.IOException
    //   378	30	9	str	String
    //   162	837	10	i	int
    //   6	525	11	l1	long
    //   514	15	13	l2	long
    // Exception table:
    //   from	to	target	type
    //   307	313	421	java/io/IOException
    //   323	330	421	java/io/IOException
    //   340	363	421	java/io/IOException
    //   373	380	421	java/io/IOException
    //   395	418	421	java/io/IOException
    //   615	620	421	java/io/IOException
    //   630	635	421	java/io/IOException
    //   639	643	670	java/io/IOException
    //   647	651	670	java/io/IOException
    //   659	664	670	java/io/IOException
    //   72	164	677	java/lang/InterruptedException
    //   172	183	677	java/lang/InterruptedException
    //   190	278	677	java/lang/InterruptedException
    //   746	750	777	java/io/IOException
    //   754	758	777	java/io/IOException
    //   766	771	777	java/io/IOException
    //   72	164	784	java/lang/Exception
    //   172	183	784	java/lang/Exception
    //   190	278	784	java/lang/Exception
    //   853	857	884	java/io/IOException
    //   861	865	884	java/io/IOException
    //   873	878	884	java/io/IOException
    //   72	164	891	finally
    //   172	183	891	finally
    //   190	278	891	finally
    //   560	603	924	java/lang/Exception
    //   900	904	927	java/io/IOException
    //   908	912	927	java/io/IOException
    //   917	922	927	java/io/IOException
    //   278	287	931	finally
    //   287	297	937	finally
    //   307	313	941	finally
    //   323	330	941	finally
    //   340	363	941	finally
    //   373	380	941	finally
    //   395	418	941	finally
    //   438	443	941	finally
    //   453	479	941	finally
    //   615	620	941	finally
    //   630	635	941	finally
    //   701	706	941	finally
    //   716	742	941	finally
    //   808	813	941	finally
    //   823	849	941	finally
    //   278	287	951	java/lang/Exception
    //   287	297	961	java/lang/Exception
    //   307	313	969	java/lang/Exception
    //   323	330	969	java/lang/Exception
    //   340	363	969	java/lang/Exception
    //   373	380	969	java/lang/Exception
    //   395	418	969	java/lang/Exception
    //   615	620	969	java/lang/Exception
    //   630	635	969	java/lang/Exception
    //   278	287	974	java/lang/InterruptedException
    //   287	297	984	java/lang/InterruptedException
    //   307	313	992	java/lang/InterruptedException
    //   323	330	992	java/lang/InterruptedException
    //   340	363	992	java/lang/InterruptedException
    //   373	380	992	java/lang/InterruptedException
    //   395	418	992	java/lang/InterruptedException
    //   615	620	992	java/lang/InterruptedException
    //   630	635	992	java/lang/InterruptedException
    //   483	487	997	java/io/IOException
    //   491	495	997	java/io/IOException
    //   503	508	997	java/io/IOException
    //   72	164	1004	java/io/IOException
    //   172	183	1004	java/io/IOException
    //   190	278	1004	java/io/IOException
    //   278	287	1016	java/io/IOException
    //   287	297	1026	java/io/IOException
  }
  
  public static int a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    long l1 = System.currentTimeMillis();
    int i = -1;
    if (ShortVideoTrimmer.a(paramContext, 0, 0))
    {
      ShortVideoTrimmer.CompressConfig localCompressConfig = ShortVideoTrimmer.a(paramString1);
      localCompressConfig.c = paramInt;
      localCompressConfig.d = paramInt;
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
      }
      paramInt = a(paramContext, paramString1, paramString2, paramInt);
      long l2 = System.currentTimeMillis();
      long l3 = new File(paramString1).length();
      long l4 = new File(paramString2).length();
      i = paramInt;
      if (QLog.isColorLevel())
      {
        QLog.i(a, 2, "CompressTask，step: ShortVideoTrimmer compress ret = " + paramInt + ", cost:" + (l2 - l1) + "ms, fileSourceSize=" + l3 + ", fileTargetSize=" + l4);
        i = paramInt;
      }
    }
    return i;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
      if (localBitmap != null)
      {
        Paint localPaint = new Paint(7);
        localBitmap.eraseColor(0);
        Canvas localCanvas = new Canvas(localBitmap);
        Rect localRect = new Rect(0, 0, paramInt1, paramInt2);
        localPaint.setColor(Color.parseColor("#38000000"));
        localCanvas.drawRect(localRect, localPaint);
        localPaint.setColor(0);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        localCanvas.drawCircle(paramInt1 * 0.5F, paramInt2 * 0.5F, paramInt3, localPaint);
      }
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("qqBaseActivity", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
        }
        Object localObject = null;
      }
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1 = null;
    if (paramBitmap == null) {
      paramBitmap = localBitmap1;
    }
    do
    {
      return paramBitmap;
      localBitmap1 = localBitmap2;
      try
      {
        localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
        localBitmap1 = localBitmap2;
        Canvas localCanvas = new Canvas(localBitmap2);
        localBitmap1 = localBitmap2;
        Paint localPaint = new Paint(6);
        localBitmap1 = localBitmap2;
        localCanvas.drawBitmap(paramBitmap, null, new Rect(0, 0, paramInt1, paramInt2), localPaint);
        return localBitmap2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        paramBitmap = localBitmap1;
      }
    } while (!QLog.isColorLevel());
    QLog.i("qqBaseActivity", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
    return localBitmap1;
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str2 = null;
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(paramString);
      str1 = str2;
      if (localFile != null)
      {
        str1 = str2;
        if (localFile.exists())
        {
          str2 = localFile.getParent() + "/dynamicAvatar_" + paramInt + "_" + System.currentTimeMillis() + ".mp4";
          str1 = str2;
          if (QLog.isColorLevel())
          {
            QLog.i(a, 2, "getDynamicAvatarCompressPath: sourcePath=" + paramString + "/n compressPath=" + str2);
            str1 = str2;
          }
        }
      }
    }
    return str1;
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    ThreadManager.a(new qtc(paramAppInterface, paramString, paramInt), 2, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.i = paramString;
    localTransferRequest.jdField_a_of_type_Long = System.currentTimeMillis();
    localTransferRequest.b = 48;
    paramQQAppInterface.a().a(localTransferRequest);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.i = paramString;
    localTransferRequest.jdField_a_of_type_Long = System.currentTimeMillis();
    localTransferRequest.b = paramInt1;
    paramString = new ByteBuffer();
    paramString.a(paramInt2);
    paramString.a(paramInt3);
    localTransferRequest.jdField_a_of_type_ArrayOfByte = paramString.a();
    paramQQAppInterface.a().a(localTransferRequest);
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, paramString);
    }
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    boolean bool = true;
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L)) {
      bool = false;
    }
    Calendar localCalendar1;
    Calendar localCalendar2;
    do
    {
      return bool;
      localCalendar1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+08"));
      localCalendar1.setTimeInMillis(paramLong1);
      localCalendar2 = Calendar.getInstance(TimeZone.getTimeZone("GMT+08"));
      localCalendar2.setTimeInMillis(paramLong2);
    } while ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6)));
    return false;
  }
  
  private static String[] a(String paramString1, String paramString2, ShortVideoTrimmer.CompressConfig paramCompressConfig)
  {
    String str1 = "1";
    if (ShortVideoTrimmer.a() >= 2) {
      str1 = "2";
    }
    String str2 = paramCompressConfig.c + "x" + String.valueOf(paramCompressConfig.d);
    a("[@] generateCommand threads=" + str1 + "  resolution=" + str2);
    return new String[] { "-d", "-y", "-threads", str1, "-copyts", "-copytb", "0", "-i", paramString1, "-metadata:s", "rotate=" + paramCompressConfig.a, "-acodec", "aac", "-vcodec", "libx264", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-minrate", "300k", "-maxrate", "600k", "-bufsize", "800k", "-qmin", "1", "-qmax", String.valueOf(paramCompressConfig.e), "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", str2, "-movflags", "faststart", paramString2 };
  }
  
  public static void b(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    paramAppInterface.a("dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\avatar\dynamicavatar\DynamicUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */