package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import usv;

public class ShortVideoTrimmer
{
  public static final int a = 0;
  public static final long a = 1688L;
  static final Object jdField_a_of_type_JavaLangObject;
  static Process jdField_a_of_type_JavaLangProcess;
  public static final String a = "QQVideoTrimProcess";
  public static AtomicBoolean a;
  private static boolean jdField_a_of_type_Boolean = false;
  public static final int b = 1;
  public static final String b;
  public static final int c = 2;
  public static final String c = "trim_process_pie";
  public static final int d = 3;
  public static final String d = "trim_process_pic";
  public static int e = 0;
  public static final int f = -1;
  public static final int g = -2;
  public static final int h = 640;
  public static final int i = 700;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b = ShortVideoTrimmer.class.getSimpleName();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  }
  
  public static int a()
  {
    if (e == 0) {}
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new usv());
      if (arrayOfFile == null) {
        return 1;
      }
      e = arrayOfFile.length;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        e = 1;
      }
    }
    return e;
  }
  
  /* Error */
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 94	java/lang/System:currentTimeMillis	()J
    //   3: lstore 12
    //   5: aload_1
    //   6: invokestatic 97	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig;
    //   9: astore_3
    //   10: aload_3
    //   11: getfield 101	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:jdField_a_of_type_Boolean	Z
    //   14: ifne +10 -> 24
    //   17: ldc 103
    //   19: invokestatic 105	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   22: iconst_m1
    //   23: ireturn
    //   24: aload_1
    //   25: aload_2
    //   26: aload_3
    //   27: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig;)[Ljava/lang/String;
    //   30: astore 9
    //   32: aload 9
    //   34: ifnonnull +11 -> 45
    //   37: ldc 110
    //   39: invokestatic 105	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   42: bipush -2
    //   44: ireturn
    //   45: aload_0
    //   46: invokestatic 116	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   49: astore 5
    //   51: ldc 118
    //   53: invokestatic 122	com/tencent/video/decode/ShortVideoSoLoad:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore 7
    //   58: aconst_null
    //   59: astore_1
    //   60: aconst_null
    //   61: astore 4
    //   63: aconst_null
    //   64: astore_3
    //   65: new 124	java/lang/ProcessBuilder
    //   68: dup
    //   69: iconst_0
    //   70: anewarray 126	java/lang/String
    //   73: invokespecial 129	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   76: astore 6
    //   78: aload 6
    //   80: iconst_1
    //   81: invokevirtual 133	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   84: pop
    //   85: new 135	java/util/ArrayList
    //   88: dup
    //   89: invokespecial 136	java/util/ArrayList:<init>	()V
    //   92: astore 8
    //   94: aload 8
    //   96: new 138	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   103: aload 5
    //   105: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 15
    //   110: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokeinterface 152 2 0
    //   121: pop
    //   122: new 138	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   129: ldc -102
    //   131: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload 8
    //   136: iconst_0
    //   137: invokeinterface 158 2 0
    //   142: checkcast 126	java/lang/String
    //   145: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 105	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   154: aload 9
    //   156: arraylength
    //   157: istore 11
    //   159: iconst_0
    //   160: istore 10
    //   162: iload 10
    //   164: iload 11
    //   166: if_icmpge +25 -> 191
    //   169: aload 8
    //   171: aload 9
    //   173: iload 10
    //   175: aaload
    //   176: invokeinterface 152 2 0
    //   181: pop
    //   182: iload 10
    //   184: iconst_1
    //   185: iadd
    //   186: istore 10
    //   188: goto -26 -> 162
    //   191: getstatic 159	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_Boolean	Z
    //   194: ifne +163 -> 357
    //   197: aload 8
    //   199: new 138	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   206: aload 5
    //   208: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload 7
    //   213: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokeinterface 152 2 0
    //   224: pop
    //   225: aload 6
    //   227: aload 8
    //   229: invokevirtual 163	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   232: pop
    //   233: new 138	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   240: ldc -91
    //   242: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload 8
    //   247: aload 8
    //   249: invokeinterface 168 1 0
    //   254: iconst_1
    //   255: isub
    //   256: invokeinterface 158 2 0
    //   261: checkcast 126	java/lang/String
    //   264: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 105	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   273: aload 6
    //   275: invokevirtual 172	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   278: astore 7
    //   280: getstatic 56	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   283: astore_0
    //   284: aload_0
    //   285: monitorenter
    //   286: aload 7
    //   288: putstatic 174	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   291: aload_0
    //   292: monitorexit
    //   293: getstatic 63	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   296: invokevirtual 177	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   299: ifne +571 -> 870
    //   302: aconst_null
    //   303: putstatic 174	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   306: aload 7
    //   308: invokevirtual 182	java/lang/Process:destroy	()V
    //   311: getstatic 63	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   314: iconst_1
    //   315: invokevirtual 185	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   318: iconst_0
    //   319: ifeq +11 -> 330
    //   322: new 187	java/lang/NullPointerException
    //   325: dup
    //   326: invokespecial 188	java/lang/NullPointerException:<init>	()V
    //   329: athrow
    //   330: iconst_0
    //   331: ifeq +11 -> 342
    //   334: new 187	java/lang/NullPointerException
    //   337: dup
    //   338: invokespecial 188	java/lang/NullPointerException:<init>	()V
    //   341: athrow
    //   342: iconst_0
    //   343: ifeq -321 -> 22
    //   346: new 187	java/lang/NullPointerException
    //   349: dup
    //   350: invokespecial 188	java/lang/NullPointerException:<init>	()V
    //   353: athrow
    //   354: astore_0
    //   355: iconst_m1
    //   356: ireturn
    //   357: new 138	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   364: aload_0
    //   365: invokevirtual 194	android/content/Context:getFilesDir	()Ljava/io/File;
    //   368: invokevirtual 197	java/io/File:getParent	()Ljava/lang/String;
    //   371: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: ldc -57
    //   376: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload 7
    //   381: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: astore_0
    //   388: new 71	java/io/File
    //   391: dup
    //   392: aload_0
    //   393: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   396: invokevirtual 202	java/io/File:exists	()Z
    //   399: ifeq +217 -> 616
    //   402: aload 8
    //   404: aload_0
    //   405: invokeinterface 152 2 0
    //   410: pop
    //   411: goto -186 -> 225
    //   414: astore 7
    //   416: aconst_null
    //   417: astore_0
    //   418: aconst_null
    //   419: astore_1
    //   420: aconst_null
    //   421: astore 6
    //   423: sipush 64535
    //   426: istore 11
    //   428: aload 6
    //   430: astore 5
    //   432: aload_1
    //   433: astore 4
    //   435: aload_0
    //   436: astore_3
    //   437: aload 7
    //   439: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   442: aload 6
    //   444: astore 5
    //   446: aload_1
    //   447: astore 4
    //   449: aload_0
    //   450: astore_3
    //   451: new 138	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   458: ldc -49
    //   460: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload 7
    //   465: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   468: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 105	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   477: aload_0
    //   478: ifnull +7 -> 485
    //   481: aload_0
    //   482: invokevirtual 213	java/io/InputStream:close	()V
    //   485: aload_1
    //   486: ifnull +7 -> 493
    //   489: aload_1
    //   490: invokevirtual 216	java/io/InputStreamReader:close	()V
    //   493: iload 11
    //   495: istore 10
    //   497: aload 6
    //   499: ifnull +12 -> 511
    //   502: aload 6
    //   504: invokevirtual 219	java/io/BufferedReader:close	()V
    //   507: iload 11
    //   509: istore 10
    //   511: invokestatic 94	java/lang/System:currentTimeMillis	()J
    //   514: lstore 14
    //   516: new 138	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   523: ldc -35
    //   525: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: lload 14
    //   530: lload 12
    //   532: lsub
    //   533: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   536: ldc -30
    //   538: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: ldc -28
    //   543: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: iload 10
    //   548: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   551: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 105	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   557: iload 10
    //   559: ifeq +47 -> 606
    //   562: new 71	java/io/File
    //   565: dup
    //   566: aload_2
    //   567: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   570: astore_0
    //   571: aload_0
    //   572: invokevirtual 202	java/io/File:exists	()Z
    //   575: ifeq +31 -> 606
    //   578: aload_0
    //   579: invokevirtual 234	java/io/File:delete	()Z
    //   582: pop
    //   583: new 138	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   590: ldc -20
    //   592: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: iload 10
    //   597: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   600: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 105	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   606: getstatic 63	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   609: iconst_1
    //   610: invokevirtual 185	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   613: iload 10
    //   615: ireturn
    //   616: aload 8
    //   618: new 138	java/lang/StringBuilder
    //   621: dup
    //   622: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   625: aload 5
    //   627: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: aload 7
    //   632: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokeinterface 152 2 0
    //   643: pop
    //   644: goto -419 -> 225
    //   647: astore 7
    //   649: aconst_null
    //   650: astore_0
    //   651: aconst_null
    //   652: astore_1
    //   653: aconst_null
    //   654: astore 6
    //   656: sipush 64534
    //   659: istore 11
    //   661: aload 6
    //   663: astore 5
    //   665: aload_1
    //   666: astore 4
    //   668: aload_0
    //   669: astore_3
    //   670: aload 7
    //   672: invokevirtual 237	java/lang/InterruptedException:printStackTrace	()V
    //   675: aload 6
    //   677: astore 5
    //   679: aload_1
    //   680: astore 4
    //   682: aload_0
    //   683: astore_3
    //   684: new 138	java/lang/StringBuilder
    //   687: dup
    //   688: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   691: ldc -17
    //   693: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: aload 7
    //   698: invokevirtual 240	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   701: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: invokestatic 105	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   710: aload_0
    //   711: ifnull +7 -> 718
    //   714: aload_0
    //   715: invokevirtual 213	java/io/InputStream:close	()V
    //   718: aload_1
    //   719: ifnull +7 -> 726
    //   722: aload_1
    //   723: invokevirtual 216	java/io/InputStreamReader:close	()V
    //   726: iload 11
    //   728: istore 10
    //   730: aload 6
    //   732: ifnull -221 -> 511
    //   735: aload 6
    //   737: invokevirtual 219	java/io/BufferedReader:close	()V
    //   740: iload 11
    //   742: istore 10
    //   744: goto -233 -> 511
    //   747: astore_0
    //   748: iload 11
    //   750: istore 10
    //   752: goto -241 -> 511
    //   755: astore 5
    //   757: aload_0
    //   758: monitorexit
    //   759: aload 5
    //   761: athrow
    //   762: astore 7
    //   764: aconst_null
    //   765: astore_0
    //   766: aconst_null
    //   767: astore_1
    //   768: aconst_null
    //   769: astore 6
    //   771: sipush 64533
    //   774: istore 11
    //   776: aload 6
    //   778: astore 5
    //   780: aload_1
    //   781: astore 4
    //   783: aload_0
    //   784: astore_3
    //   785: aload 7
    //   787: invokevirtual 241	java/lang/Exception:printStackTrace	()V
    //   790: aload 6
    //   792: astore 5
    //   794: aload_1
    //   795: astore 4
    //   797: aload_0
    //   798: astore_3
    //   799: new 138	java/lang/StringBuilder
    //   802: dup
    //   803: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   806: ldc -13
    //   808: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: aload 7
    //   813: invokevirtual 244	java/lang/Exception:toString	()Ljava/lang/String;
    //   816: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   822: invokestatic 105	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   825: aload_0
    //   826: ifnull +7 -> 833
    //   829: aload_0
    //   830: invokevirtual 213	java/io/InputStream:close	()V
    //   833: aload_1
    //   834: ifnull +7 -> 841
    //   837: aload_1
    //   838: invokevirtual 216	java/io/InputStreamReader:close	()V
    //   841: iload 11
    //   843: istore 10
    //   845: aload 6
    //   847: ifnull -336 -> 511
    //   850: aload 6
    //   852: invokevirtual 219	java/io/BufferedReader:close	()V
    //   855: iload 11
    //   857: istore 10
    //   859: goto -348 -> 511
    //   862: astore_0
    //   863: iload 11
    //   865: istore 10
    //   867: goto -356 -> 511
    //   870: aload 7
    //   872: invokevirtual 248	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   875: astore_0
    //   876: new 215	java/io/InputStreamReader
    //   879: dup
    //   880: aload_0
    //   881: invokespecial 251	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   884: astore_1
    //   885: new 218	java/io/BufferedReader
    //   888: dup
    //   889: aload_1
    //   890: invokespecial 254	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   893: astore 6
    //   895: aload 6
    //   897: astore 5
    //   899: aload_1
    //   900: astore 4
    //   902: aload_0
    //   903: astore_3
    //   904: aload 7
    //   906: invokevirtual 257	java/lang/Process:waitFor	()I
    //   909: pop
    //   910: aload 6
    //   912: astore 5
    //   914: aload_1
    //   915: astore 4
    //   917: aload_0
    //   918: astore_3
    //   919: aload 7
    //   921: invokevirtual 260	java/lang/Process:exitValue	()I
    //   924: istore 11
    //   926: aload 6
    //   928: astore 5
    //   930: aload_1
    //   931: astore 4
    //   933: aload_0
    //   934: astore_3
    //   935: new 138	java/lang/StringBuilder
    //   938: dup
    //   939: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   942: ldc_w 262
    //   945: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: iload 11
    //   950: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   953: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   956: invokestatic 105	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   959: aload 6
    //   961: astore 5
    //   963: aload_1
    //   964: astore 4
    //   966: aload_0
    //   967: astore_3
    //   968: aload 6
    //   970: invokevirtual 265	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   973: astore 8
    //   975: aload 8
    //   977: ifnull +39 -> 1016
    //   980: aload 6
    //   982: astore 5
    //   984: aload_1
    //   985: astore 4
    //   987: aload_0
    //   988: astore_3
    //   989: new 138	java/lang/StringBuilder
    //   992: dup
    //   993: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   996: ldc_w 267
    //   999: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: aload 8
    //   1004: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1010: invokestatic 105	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   1013: goto -54 -> 959
    //   1016: aload 6
    //   1018: astore 5
    //   1020: aload_1
    //   1021: astore 4
    //   1023: aload_0
    //   1024: astore_3
    //   1025: aload 7
    //   1027: invokevirtual 182	java/lang/Process:destroy	()V
    //   1030: aload 6
    //   1032: astore 5
    //   1034: aload_1
    //   1035: astore 4
    //   1037: aload_0
    //   1038: astore_3
    //   1039: getstatic 56	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   1042: astore 8
    //   1044: aload 6
    //   1046: astore 5
    //   1048: aload_1
    //   1049: astore 4
    //   1051: aload_0
    //   1052: astore_3
    //   1053: aload 8
    //   1055: monitorenter
    //   1056: aconst_null
    //   1057: putstatic 174	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   1060: aload 8
    //   1062: monitorexit
    //   1063: aload 6
    //   1065: astore 5
    //   1067: aload_1
    //   1068: astore 4
    //   1070: aload_0
    //   1071: astore_3
    //   1072: ldc_w 269
    //   1075: invokestatic 105	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   1078: aload_0
    //   1079: ifnull +7 -> 1086
    //   1082: aload_0
    //   1083: invokevirtual 213	java/io/InputStream:close	()V
    //   1086: aload_1
    //   1087: ifnull +7 -> 1094
    //   1090: aload_1
    //   1091: invokevirtual 216	java/io/InputStreamReader:close	()V
    //   1094: iload 11
    //   1096: istore 10
    //   1098: aload 6
    //   1100: ifnull -589 -> 511
    //   1103: aload 6
    //   1105: invokevirtual 219	java/io/BufferedReader:close	()V
    //   1108: iload 11
    //   1110: istore 10
    //   1112: goto -601 -> 511
    //   1115: astore_0
    //   1116: iload 11
    //   1118: istore 10
    //   1120: goto -609 -> 511
    //   1123: astore 7
    //   1125: aload 8
    //   1127: monitorexit
    //   1128: aload 6
    //   1130: astore 5
    //   1132: aload_1
    //   1133: astore 4
    //   1135: aload_0
    //   1136: astore_3
    //   1137: aload 7
    //   1139: athrow
    //   1140: astore 7
    //   1142: goto -486 -> 656
    //   1145: astore_0
    //   1146: aload 4
    //   1148: astore_2
    //   1149: aload_1
    //   1150: ifnull +7 -> 1157
    //   1153: aload_1
    //   1154: invokevirtual 213	java/io/InputStream:close	()V
    //   1157: aload_2
    //   1158: ifnull +7 -> 1165
    //   1161: aload_2
    //   1162: invokevirtual 216	java/io/InputStreamReader:close	()V
    //   1165: aload_3
    //   1166: ifnull +7 -> 1173
    //   1169: aload_3
    //   1170: invokevirtual 219	java/io/BufferedReader:close	()V
    //   1173: aload_0
    //   1174: athrow
    //   1175: astore_0
    //   1176: goto -570 -> 606
    //   1179: astore_1
    //   1180: goto -7 -> 1173
    //   1183: astore_2
    //   1184: aload_0
    //   1185: astore_1
    //   1186: aload_2
    //   1187: astore_0
    //   1188: aload 4
    //   1190: astore_2
    //   1191: goto -42 -> 1149
    //   1194: astore_2
    //   1195: aload_0
    //   1196: astore 4
    //   1198: aload_2
    //   1199: astore_0
    //   1200: aload_1
    //   1201: astore_2
    //   1202: aload 4
    //   1204: astore_1
    //   1205: goto -56 -> 1149
    //   1208: astore_0
    //   1209: aload 4
    //   1211: astore_2
    //   1212: aload_3
    //   1213: astore_1
    //   1214: aload 5
    //   1216: astore_3
    //   1217: goto -68 -> 1149
    //   1220: astore 7
    //   1222: aconst_null
    //   1223: astore_1
    //   1224: aconst_null
    //   1225: astore 6
    //   1227: goto -456 -> 771
    //   1230: astore 7
    //   1232: aconst_null
    //   1233: astore 6
    //   1235: goto -464 -> 771
    //   1238: astore 7
    //   1240: goto -469 -> 771
    //   1243: astore 7
    //   1245: aconst_null
    //   1246: astore_1
    //   1247: aconst_null
    //   1248: astore 6
    //   1250: goto -594 -> 656
    //   1253: astore 7
    //   1255: aconst_null
    //   1256: astore 6
    //   1258: goto -602 -> 656
    //   1261: astore_0
    //   1262: iload 11
    //   1264: istore 10
    //   1266: goto -755 -> 511
    //   1269: astore 7
    //   1271: aconst_null
    //   1272: astore_1
    //   1273: aconst_null
    //   1274: astore 6
    //   1276: goto -853 -> 423
    //   1279: astore 7
    //   1281: aconst_null
    //   1282: astore 6
    //   1284: goto -861 -> 423
    //   1287: astore 7
    //   1289: goto -866 -> 423
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1292	0	paramContext	Context
    //   0	1292	1	paramString1	String
    //   0	1292	2	paramString2	String
    //   9	1208	3	localObject1	Object
    //   61	1149	4	localObject2	Object
    //   49	629	5	localObject3	Object
    //   755	5	5	localObject4	Object
    //   778	437	5	localObject5	Object
    //   76	1207	6	localObject6	Object
    //   56	324	7	localObject7	Object
    //   414	217	7	localIOException1	java.io.IOException
    //   647	50	7	localInterruptedException1	InterruptedException
    //   762	264	7	localException1	Exception
    //   1123	15	7	localObject8	Object
    //   1140	1	7	localInterruptedException2	InterruptedException
    //   1220	1	7	localException2	Exception
    //   1230	1	7	localException3	Exception
    //   1238	1	7	localException4	Exception
    //   1243	1	7	localInterruptedException3	InterruptedException
    //   1253	1	7	localInterruptedException4	InterruptedException
    //   1269	1	7	localIOException2	java.io.IOException
    //   1279	1	7	localIOException3	java.io.IOException
    //   1287	1	7	localIOException4	java.io.IOException
    //   92	1034	8	localObject9	Object
    //   30	142	9	arrayOfString	String[]
    //   160	1105	10	j	int
    //   157	1106	11	k	int
    //   3	528	12	l1	long
    //   514	15	14	l2	long
    // Exception table:
    //   from	to	target	type
    //   322	330	354	java/io/IOException
    //   334	342	354	java/io/IOException
    //   346	354	354	java/io/IOException
    //   65	159	414	java/io/IOException
    //   169	182	414	java/io/IOException
    //   191	225	414	java/io/IOException
    //   225	286	414	java/io/IOException
    //   293	318	414	java/io/IOException
    //   357	411	414	java/io/IOException
    //   616	644	414	java/io/IOException
    //   759	762	414	java/io/IOException
    //   870	876	414	java/io/IOException
    //   65	159	647	java/lang/InterruptedException
    //   169	182	647	java/lang/InterruptedException
    //   191	225	647	java/lang/InterruptedException
    //   225	286	647	java/lang/InterruptedException
    //   293	318	647	java/lang/InterruptedException
    //   357	411	647	java/lang/InterruptedException
    //   616	644	647	java/lang/InterruptedException
    //   759	762	647	java/lang/InterruptedException
    //   870	876	647	java/lang/InterruptedException
    //   714	718	747	java/io/IOException
    //   722	726	747	java/io/IOException
    //   735	740	747	java/io/IOException
    //   286	293	755	finally
    //   757	759	755	finally
    //   65	159	762	java/lang/Exception
    //   169	182	762	java/lang/Exception
    //   191	225	762	java/lang/Exception
    //   225	286	762	java/lang/Exception
    //   293	318	762	java/lang/Exception
    //   357	411	762	java/lang/Exception
    //   616	644	762	java/lang/Exception
    //   759	762	762	java/lang/Exception
    //   870	876	762	java/lang/Exception
    //   829	833	862	java/io/IOException
    //   837	841	862	java/io/IOException
    //   850	855	862	java/io/IOException
    //   1082	1086	1115	java/io/IOException
    //   1090	1094	1115	java/io/IOException
    //   1103	1108	1115	java/io/IOException
    //   1056	1063	1123	finally
    //   1125	1128	1123	finally
    //   904	910	1140	java/lang/InterruptedException
    //   919	926	1140	java/lang/InterruptedException
    //   935	959	1140	java/lang/InterruptedException
    //   968	975	1140	java/lang/InterruptedException
    //   989	1013	1140	java/lang/InterruptedException
    //   1025	1030	1140	java/lang/InterruptedException
    //   1039	1044	1140	java/lang/InterruptedException
    //   1053	1056	1140	java/lang/InterruptedException
    //   1072	1078	1140	java/lang/InterruptedException
    //   1137	1140	1140	java/lang/InterruptedException
    //   65	159	1145	finally
    //   169	182	1145	finally
    //   191	225	1145	finally
    //   225	286	1145	finally
    //   293	318	1145	finally
    //   357	411	1145	finally
    //   616	644	1145	finally
    //   759	762	1145	finally
    //   870	876	1145	finally
    //   562	606	1175	java/lang/Exception
    //   1153	1157	1179	java/io/IOException
    //   1161	1165	1179	java/io/IOException
    //   1169	1173	1179	java/io/IOException
    //   876	885	1183	finally
    //   885	895	1194	finally
    //   437	442	1208	finally
    //   451	477	1208	finally
    //   670	675	1208	finally
    //   684	710	1208	finally
    //   785	790	1208	finally
    //   799	825	1208	finally
    //   904	910	1208	finally
    //   919	926	1208	finally
    //   935	959	1208	finally
    //   968	975	1208	finally
    //   989	1013	1208	finally
    //   1025	1030	1208	finally
    //   1039	1044	1208	finally
    //   1053	1056	1208	finally
    //   1072	1078	1208	finally
    //   1137	1140	1208	finally
    //   876	885	1220	java/lang/Exception
    //   885	895	1230	java/lang/Exception
    //   904	910	1238	java/lang/Exception
    //   919	926	1238	java/lang/Exception
    //   935	959	1238	java/lang/Exception
    //   968	975	1238	java/lang/Exception
    //   989	1013	1238	java/lang/Exception
    //   1025	1030	1238	java/lang/Exception
    //   1039	1044	1238	java/lang/Exception
    //   1053	1056	1238	java/lang/Exception
    //   1072	1078	1238	java/lang/Exception
    //   1137	1140	1238	java/lang/Exception
    //   876	885	1243	java/lang/InterruptedException
    //   885	895	1253	java/lang/InterruptedException
    //   481	485	1261	java/io/IOException
    //   489	493	1261	java/io/IOException
    //   502	507	1261	java/io/IOException
    //   876	885	1269	java/io/IOException
    //   885	895	1279	java/io/IOException
    //   904	910	1287	java/io/IOException
    //   919	926	1287	java/io/IOException
    //   935	959	1287	java/io/IOException
    //   968	975	1287	java/io/IOException
    //   989	1013	1287	java/io/IOException
    //   1025	1030	1287	java/io/IOException
    //   1039	1044	1287	java/io/IOException
    //   1053	1056	1287	java/io/IOException
    //   1072	1078	1287	java/io/IOException
    //   1137	1140	1287	java/io/IOException
  }
  
  public static ShortVideoTrimmer.CompressConfig a(String paramString)
  {
    ShortVideoTrimmer.CompressConfig localCompressConfig = new ShortVideoTrimmer.CompressConfig();
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      localCompressConfig.jdField_a_of_type_Boolean = false;
      a("[@] getCompressConfig : [!file.exists]");
    }
    paramString = a(paramString);
    if ((paramString == null) || (paramString.length != 5) || (paramString[0] != 0))
    {
      localCompressConfig.jdField_a_of_type_Boolean = false;
      a("[@] getCompressConfig : values=" + paramString);
      if (paramString != null) {
        a("[@] getCompressConfig : values.length=" + paramString.length + " err=" + paramString[0]);
      }
      return localCompressConfig;
    }
    localCompressConfig.jdField_a_of_type_JavaLangString = a(paramString[3]);
    localCompressConfig.jdField_a_of_type_Int = paramString[1];
    localCompressConfig.jdField_b_of_type_Int = paramString[2];
    int j = (int)(paramString[4] / 1000.0D + 0.5D);
    if (j == 0)
    {
      localCompressConfig.jdField_a_of_type_Boolean = false;
      a("[@] getCompressConfig : [sec == 0 OR video duration < 0.5 sec]");
      return localCompressConfig;
    }
    localCompressConfig.jdField_b_of_type_Long = (localFile.length() / (j * 128));
    j = Math.max(paramString[1], paramString[2]);
    if (j <= 700)
    {
      if (localCompressConfig.jdField_b_of_type_Long > 1688L)
      {
        localCompressConfig.jdField_a_of_type_Boolean = true;
        localCompressConfig.e = 25;
        localCompressConfig.c = paramString[1];
        localCompressConfig.d = paramString[2];
        return localCompressConfig;
      }
      localCompressConfig.jdField_a_of_type_Boolean = false;
      a("[@] getCompressConfig : [kbps > CODE_RATE] judge Failure...");
      return localCompressConfig;
    }
    localCompressConfig.jdField_a_of_type_Boolean = true;
    float f1 = 640.0F / j;
    localCompressConfig.c = ((int)(paramString[1] * f1));
    localCompressConfig.d = ((int)(f1 * paramString[2]));
    localCompressConfig.e = 25;
    return localCompressConfig;
  }
  
  public static Process a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Process localProcess = jdField_a_of_type_JavaLangProcess;
      return localProcess;
    }
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "0";
    case 0: 
      return "0";
    case 1: 
      return "90";
    case 2: 
      return "180";
    }
    return "270";
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, paramString);
    }
    if (jdField_a_of_type_Boolean) {
      Log.d(b, paramString);
    }
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2)
  {
    boolean bool2 = b(paramContext, paramInt1, paramInt2);
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (VideoEnvironment.b("AVCodec", paramContext) != 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  /* Error */
  private static boolean a(java.io.InputStream paramInputStream, byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: new 350	java/io/FileOutputStream
    //   6: dup
    //   7: aload_2
    //   8: invokespecial 351	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: iconst_0
    //   13: istore 4
    //   15: aload_3
    //   16: astore_2
    //   17: aload_0
    //   18: aload_1
    //   19: iload 4
    //   21: aload_1
    //   22: arraylength
    //   23: iload 4
    //   25: isub
    //   26: invokevirtual 355	java/io/InputStream:read	([BII)I
    //   29: istore 5
    //   31: iload 5
    //   33: iconst_m1
    //   34: if_icmpeq +39 -> 73
    //   37: iload 4
    //   39: iload 5
    //   41: iadd
    //   42: istore 5
    //   44: iload 5
    //   46: istore 4
    //   48: aload_3
    //   49: astore_2
    //   50: iload 5
    //   52: aload_1
    //   53: arraylength
    //   54: if_icmpne -39 -> 15
    //   57: aload_3
    //   58: astore_2
    //   59: aload_3
    //   60: aload_1
    //   61: iconst_0
    //   62: iload 5
    //   64: invokevirtual 359	java/io/FileOutputStream:write	([BII)V
    //   67: iconst_0
    //   68: istore 4
    //   70: goto -55 -> 15
    //   73: iload 4
    //   75: ifeq +13 -> 88
    //   78: aload_3
    //   79: astore_2
    //   80: aload_3
    //   81: aload_1
    //   82: iconst_0
    //   83: iload 4
    //   85: invokevirtual 359	java/io/FileOutputStream:write	([BII)V
    //   88: iconst_1
    //   89: istore 7
    //   91: iload 7
    //   93: istore 6
    //   95: aload_3
    //   96: ifnull +11 -> 107
    //   99: aload_3
    //   100: invokevirtual 360	java/io/FileOutputStream:close	()V
    //   103: iload 7
    //   105: istore 6
    //   107: iload 6
    //   109: ireturn
    //   110: astore_1
    //   111: aconst_null
    //   112: astore_0
    //   113: aload_0
    //   114: astore_2
    //   115: aload_1
    //   116: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   119: aload_0
    //   120: ifnull -13 -> 107
    //   123: aload_0
    //   124: invokevirtual 360	java/io/FileOutputStream:close	()V
    //   127: iconst_0
    //   128: ireturn
    //   129: astore_0
    //   130: iconst_0
    //   131: ireturn
    //   132: astore_0
    //   133: aconst_null
    //   134: astore_2
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 360	java/io/FileOutputStream:close	()V
    //   143: aload_0
    //   144: athrow
    //   145: astore_0
    //   146: iconst_1
    //   147: ireturn
    //   148: astore_1
    //   149: goto -6 -> 143
    //   152: astore_0
    //   153: goto -18 -> 135
    //   156: astore_1
    //   157: aload_3
    //   158: astore_0
    //   159: goto -46 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramInputStream	java.io.InputStream
    //   0	162	1	paramArrayOfByte	byte[]
    //   0	162	2	paramString	String
    //   11	147	3	localFileOutputStream	java.io.FileOutputStream
    //   13	71	4	j	int
    //   29	34	5	k	int
    //   1	107	6	bool1	boolean
    //   89	15	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   3	12	110	java/io/IOException
    //   123	127	129	java/io/IOException
    //   3	12	132	finally
    //   99	103	145	java/io/IOException
    //   139	143	148	java/io/IOException
    //   17	31	152	finally
    //   50	57	152	finally
    //   59	67	152	finally
    //   80	88	152	finally
    //   115	119	152	finally
    //   17	31	156	java/io/IOException
    //   50	57	156	java/io/IOException
    //   59	67	156	java/io/IOException
    //   80	88	156	java/io/IOException
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if (!new File(paramString1).exists()) {}
    do
    {
      return true;
      paramString1 = MD5.getFileMd5(paramString1);
      paramString2 = MD5.getFileMd5(paramString2);
      paramString1 = HexUtil.bytes2HexStr(paramString1);
      paramString2 = HexUtil.bytes2HexStr(paramString2);
      a("[@] trimBinMd5Judge : pieMd5=" + paramString1 + "  outMd5=" + paramString2);
    } while ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(paramString2)));
    return false;
  }
  
  public static int[] a(String paramString)
  {
    try
    {
      paramString = getRealProperties(paramString);
      if (paramString != null)
      {
        arrayOfString = paramString.split(",");
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          arrayOfInt = new int[arrayOfString.length];
          j = 0;
          paramString = arrayOfInt;
        }
      }
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        try
        {
          String[] arrayOfString;
          int[] arrayOfInt;
          int j;
          if (j >= arrayOfString.length) {
            break;
          }
          arrayOfInt[j] = Integer.valueOf(arrayOfString[j]).intValue();
          j += 1;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          a("[@] getVideoProperty [NumberFormatException]");
        }
        paramString = paramString;
        paramString.printStackTrace();
        a("[@] getVideoProperty [UnsatisfiedLinkError]");
        paramString = null;
      }
      paramString = null;
    }
    return paramString;
  }
  
  private static String[] a(String paramString1, String paramString2, ShortVideoTrimmer.CompressConfig paramCompressConfig)
  {
    String str1 = "1";
    if (a() >= 2) {
      str1 = "2";
    }
    String str2 = paramCompressConfig.c + "x" + String.valueOf(paramCompressConfig.d);
    a("[@] generateCommand threads=" + str1 + "  resolution=" + str2);
    return new String[] { "-d", "-y", "-threads", str1, "-copyts", "-copytb", "0", "-i", paramString1, "-metadata:s", "rotate=" + paramCompressConfig.jdField_a_of_type_JavaLangString, "-acodec", "aac", "-vcodec", "libx264", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-minrate", "300k", "-maxrate", "600k", "-bufsize", "800k", "-qmin", "1", "-qmax", String.valueOf(paramCompressConfig.e), "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", str2, "-movflags", "faststart", paramString2 };
  }
  
  /* Error */
  private static boolean b(Context paramContext, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: iconst_0
    //   6: istore 9
    //   8: aload_0
    //   9: invokestatic 116	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   12: astore 6
    //   14: new 71	java/io/File
    //   17: dup
    //   18: aload 6
    //   20: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: astore 5
    //   25: aload 5
    //   27: invokevirtual 202	java/io/File:exists	()Z
    //   30: ifne +9 -> 39
    //   33: aload 5
    //   35: invokevirtual 501	java/io/File:mkdirs	()Z
    //   38: pop
    //   39: iload_1
    //   40: ifeq +7 -> 47
    //   43: iload_2
    //   44: ifne +127 -> 171
    //   47: iconst_0
    //   48: putstatic 159	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_Boolean	Z
    //   51: getstatic 506	android/os/Build$VERSION:SDK_INT	I
    //   54: bipush 16
    //   56: if_icmplt +87 -> 143
    //   59: new 138	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   66: aload 6
    //   68: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 23
    //   73: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: astore 5
    //   81: iconst_0
    //   82: istore 7
    //   84: new 138	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   91: aload 6
    //   93: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 15
    //   98: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore 6
    //   106: new 71	java/io/File
    //   109: dup
    //   110: aload 6
    //   112: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: invokevirtual 202	java/io/File:exists	()Z
    //   118: ifeq +83 -> 201
    //   121: getstatic 159	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_Boolean	Z
    //   124: ifne +77 -> 201
    //   127: aload 5
    //   129: aload 6
    //   131: invokestatic 508	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   134: ifeq +67 -> 201
    //   137: iconst_1
    //   138: istore 8
    //   140: iload 8
    //   142: ireturn
    //   143: new 138	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   150: aload 6
    //   152: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc 27
    //   157: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore 5
    //   165: iconst_0
    //   166: istore 7
    //   168: goto -84 -> 84
    //   171: iconst_1
    //   172: putstatic 159	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_Boolean	Z
    //   175: getstatic 506	android/os/Build$VERSION:SDK_INT	I
    //   178: bipush 16
    //   180: if_icmplt +12 -> 192
    //   183: iload_1
    //   184: istore 7
    //   186: aconst_null
    //   187: astore 5
    //   189: goto -105 -> 84
    //   192: iload_2
    //   193: istore 7
    //   195: aconst_null
    //   196: astore 5
    //   198: goto -114 -> 84
    //   201: iload_1
    //   202: ifeq +7 -> 209
    //   205: iload_2
    //   206: ifne +136 -> 342
    //   209: new 510	java/io/FileInputStream
    //   212: dup
    //   213: aload 5
    //   215: invokespecial 511	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   218: astore_0
    //   219: ldc_w 513
    //   222: invokestatic 105	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   225: aload_0
    //   226: astore 4
    //   228: aload_0
    //   229: astore_3
    //   230: aload_0
    //   231: sipush 8192
    //   234: newarray <illegal type>
    //   236: aload 6
    //   238: invokestatic 515	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/io/InputStream;[BLjava/lang/String;)Z
    //   241: istore 10
    //   243: aload_0
    //   244: astore 4
    //   246: aload_0
    //   247: astore_3
    //   248: new 138	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 517
    //   258: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: iload 10
    //   263: invokevirtual 520	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   266: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 105	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   272: iload 10
    //   274: istore 8
    //   276: iload 10
    //   278: ifeq +53 -> 331
    //   281: aload_0
    //   282: astore 4
    //   284: aload_0
    //   285: astore_3
    //   286: new 71	java/io/File
    //   289: dup
    //   290: aload 6
    //   292: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   295: iconst_1
    //   296: iconst_1
    //   297: invokevirtual 524	java/io/File:setExecutable	(ZZ)Z
    //   300: istore 8
    //   302: aload_0
    //   303: astore 4
    //   305: aload_0
    //   306: astore_3
    //   307: new 138	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   314: ldc_w 526
    //   317: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: iload 8
    //   322: invokevirtual 520	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   325: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 105	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   331: aload_0
    //   332: ifnull +7 -> 339
    //   335: aload_0
    //   336: invokevirtual 213	java/io/InputStream:close	()V
    //   339: iload 8
    //   341: ireturn
    //   342: aload_0
    //   343: invokevirtual 530	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   346: iload 7
    //   348: invokevirtual 536	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   351: astore_0
    //   352: aload_0
    //   353: astore 4
    //   355: aload_0
    //   356: astore_3
    //   357: ldc_w 538
    //   360: invokestatic 105	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   363: goto -138 -> 225
    //   366: astore_0
    //   367: aload 4
    //   369: astore_3
    //   370: aload_0
    //   371: invokevirtual 241	java/lang/Exception:printStackTrace	()V
    //   374: aload 4
    //   376: astore_3
    //   377: new 138	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   384: ldc_w 540
    //   387: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload_0
    //   391: invokevirtual 244	java/lang/Exception:toString	()Ljava/lang/String;
    //   394: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 105	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   403: iload 9
    //   405: istore 8
    //   407: aload 4
    //   409: ifnull -269 -> 140
    //   412: aload 4
    //   414: invokevirtual 213	java/io/InputStream:close	()V
    //   417: iconst_0
    //   418: ireturn
    //   419: astore_0
    //   420: aload_0
    //   421: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   424: iconst_0
    //   425: ireturn
    //   426: astore_0
    //   427: aload_0
    //   428: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   431: goto -92 -> 339
    //   434: astore_0
    //   435: aload_3
    //   436: ifnull +7 -> 443
    //   439: aload_3
    //   440: invokevirtual 213	java/io/InputStream:close	()V
    //   443: aload_0
    //   444: athrow
    //   445: astore_3
    //   446: aload_3
    //   447: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   450: goto -7 -> 443
    //   453: astore 4
    //   455: aload_0
    //   456: astore_3
    //   457: aload 4
    //   459: astore_0
    //   460: goto -25 -> 435
    //   463: astore_3
    //   464: aload_0
    //   465: astore 4
    //   467: aload_3
    //   468: astore_0
    //   469: goto -102 -> 367
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	472	0	paramContext	Context
    //   0	472	1	paramInt1	int
    //   0	472	2	paramInt2	int
    //   1	439	3	localObject1	Object
    //   445	2	3	localIOException	java.io.IOException
    //   456	1	3	localContext1	Context
    //   463	5	3	localException	Exception
    //   3	410	4	localContext2	Context
    //   453	5	4	localObject2	Object
    //   465	1	4	localContext3	Context
    //   23	191	5	localObject3	Object
    //   12	279	6	str	String
    //   82	265	7	j	int
    //   138	268	8	bool1	boolean
    //   6	398	9	bool2	boolean
    //   241	36	10	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   209	219	366	java/lang/Exception
    //   230	243	366	java/lang/Exception
    //   248	272	366	java/lang/Exception
    //   286	302	366	java/lang/Exception
    //   307	331	366	java/lang/Exception
    //   342	352	366	java/lang/Exception
    //   357	363	366	java/lang/Exception
    //   412	417	419	java/io/IOException
    //   335	339	426	java/io/IOException
    //   209	219	434	finally
    //   230	243	434	finally
    //   248	272	434	finally
    //   286	302	434	finally
    //   307	331	434	finally
    //   342	352	434	finally
    //   357	363	434	finally
    //   370	374	434	finally
    //   377	403	434	finally
    //   439	443	445	java/io/IOException
    //   219	225	453	finally
    //   219	225	463	java/lang/Exception
  }
  
  public static native String getRealProperties(String paramString);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\ShortVideoTrimmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */