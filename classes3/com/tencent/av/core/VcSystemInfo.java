package com.tencent.av.core;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ghh;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class VcSystemInfo
{
  public static final int a = 0;
  static long jdField_a_of_type_Long = 0L;
  static final String jdField_a_of_type_JavaLangString = "VcSystemInfo";
  static boolean jdField_a_of_type_Boolean = false;
  public static final int b = 1;
  static long jdField_b_of_type_Long = 0L;
  static String jdField_b_of_type_JavaLangString;
  static boolean jdField_b_of_type_Boolean = false;
  public static final int c = 2;
  static String jdField_c_of_type_JavaLangString;
  static boolean jdField_c_of_type_Boolean = false;
  public static final int d = 3;
  static String jdField_d_of_type_JavaLangString;
  static boolean jdField_d_of_type_Boolean = false;
  public static final int e = 4;
  static String e;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  static int i;
  static int j;
  static int k;
  static int l;
  static int q;
  int m = 320;
  int n = 480;
  public int o = 320;
  public int p = 240;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = "";
    jdField_c_of_type_JavaLangString = "";
    i = 5;
    j = 1;
    k = 2;
    l = 1;
    jdField_b_of_type_Boolean = true;
    jdField_c_of_type_Boolean = true;
    a();
  }
  
  static int a()
  {
    try
    {
      int i1 = new File("/sys/devices/system/cpu/").listFiles(new ghh()).length;
      return i1;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  static long a()
  {
    if (j < 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcSystemInfo", 2, "[CpuInfo] Use default core number 8");
      }
      j = 8;
    }
    int i1 = 0;
    long l3 = 0L;
    for (long l2 = 0L; i1 < j; l2 = l1)
    {
      String str1 = "";
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu" + i1 + "/cpufreq/cpuinfo_max_freq"));
        l1 = l2;
        if (localBufferedReader != null)
        {
          String str2 = localBufferedReader.readLine();
          if (!TextUtils.isEmpty(str2)) {
            str1 = str2.trim();
          }
          l1 = l2;
          if (str1 != null)
          {
            l1 = l2;
            if (str1.length() > 0) {
              l1 = Long.parseLong(str1);
            }
          }
          localBufferedReader.close();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l1 = 0L;
        }
      }
      l2 = l3;
      if (l1 > l3) {
        l2 = l1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VcSystemInfo", 2, "[CpuInfo] readMaxCpuFreq core " + i1 + "  maxFreq  " + l1 + "  thisMaxFreq  " + l2);
      }
      i1 += 1;
      l3 = l2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VcSystemInfo", 2, "[CpuInfo] readMaxCpuFreq end  maxFreq  " + l2 + "  thisMaxFreq  " + l3);
    }
    return l3;
  }
  
  public static String a()
  {
    return Build.MODEL;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: getstatic 181	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Boolean	Z
    //   3: iconst_1
    //   4: if_icmpne +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore_3
    //   10: ldc2_w 182
    //   13: lstore 8
    //   15: ldc -72
    //   17: fstore_0
    //   18: new 107	java/io/BufferedReader
    //   21: dup
    //   22: new 109	java/io/FileReader
    //   25: dup
    //   26: ldc -70
    //   28: invokespecial 128	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   31: invokespecial 131	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 134	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnonnull +267 -> 308
    //   44: iconst_1
    //   45: putstatic 181	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Boolean	Z
    //   48: lload 8
    //   50: lstore 10
    //   52: fload_0
    //   53: fstore_1
    //   54: aload_2
    //   55: ifnull +13 -> 68
    //   58: aload_2
    //   59: invokevirtual 157	java/io/BufferedReader:close	()V
    //   62: fload_0
    //   63: fstore_1
    //   64: lload 8
    //   66: lstore 10
    //   68: invokestatic 188	com/tencent/av/core/VcSystemInfo:a	()I
    //   71: istore 6
    //   73: iload 6
    //   75: ifle +1049 -> 1124
    //   78: iload 6
    //   80: putstatic 54	com/tencent/av/core/VcSystemInfo:j	I
    //   83: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +30 -> 116
    //   89: ldc 13
    //   91: iconst_2
    //   92: new 111	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   99: ldc -66
    //   101: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: getstatic 54	com/tencent/av/core/VcSystemInfo:j	I
    //   107: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: invokestatic 192	com/tencent/av/core/VcSystemInfo:a	()J
    //   119: lstore 8
    //   121: lload 8
    //   123: lconst_0
    //   124: lcmp
    //   125: ifle +1049 -> 1174
    //   128: lload 8
    //   130: putstatic 194	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   133: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +30 -> 166
    //   139: ldc 13
    //   141: iconst_2
    //   142: new 111	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   149: ldc -60
    //   151: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: getstatic 194	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   157: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   160: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: getstatic 54	com/tencent/av/core/VcSystemInfo:j	I
    //   169: ifle +11 -> 180
    //   172: getstatic 194	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   175: lconst_0
    //   176: lcmp
    //   177: ifgt +1099 -> 1276
    //   180: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq +41 -> 224
    //   186: ldc 13
    //   188: iconst_2
    //   189: new 111	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   196: ldc -58
    //   198: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: getstatic 54	com/tencent/av/core/VcSystemInfo:j	I
    //   204: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   207: ldc -56
    //   209: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: getstatic 194	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   215: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   218: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: iconst_0
    //   225: putstatic 181	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Boolean	Z
    //   228: invokestatic 202	com/tencent/av/core/VcSystemInfo:b	()I
    //   231: putstatic 58	com/tencent/av/core/VcSystemInfo:l	I
    //   234: invokestatic 204	com/tencent/av/core/VcSystemInfo:b	()Z
    //   237: putstatic 60	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_Boolean	Z
    //   240: getstatic 60	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_Boolean	Z
    //   243: ifeq +1040 -> 1283
    //   246: invokestatic 206	com/tencent/av/core/VcSystemInfo:a	()Z
    //   249: putstatic 62	com/tencent/av/core/VcSystemInfo:jdField_c_of_type_Boolean	Z
    //   252: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   255: ifeq -248 -> 7
    //   258: ldc 13
    //   260: iconst_2
    //   261: new 111	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   268: ldc -48
    //   270: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: getstatic 58	com/tencent/av/core/VcSystemInfo:l	I
    //   276: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: ldc -46
    //   281: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: getstatic 62	com/tencent/av/core/VcSystemInfo:jdField_c_of_type_Boolean	Z
    //   287: invokevirtual 213	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   290: ldc -41
    //   292: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: getstatic 60	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_Boolean	Z
    //   298: invokevirtual 213	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   301: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: return
    //   308: aload_3
    //   309: ldc -39
    //   311: invokevirtual 221	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   314: ifeq +124 -> 438
    //   317: aload_3
    //   318: bipush 58
    //   320: invokevirtual 225	java/lang/String:indexOf	(I)I
    //   323: istore 6
    //   325: iload 6
    //   327: iconst_1
    //   328: if_icmple -293 -> 35
    //   331: aload_3
    //   332: iload 6
    //   334: iconst_1
    //   335: iadd
    //   336: aload_3
    //   337: invokevirtual 148	java/lang/String:length	()I
    //   340: invokevirtual 229	java/lang/String:substring	(II)Ljava/lang/String;
    //   343: putstatic 48	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   346: getstatic 48	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   349: invokevirtual 145	java/lang/String:trim	()Ljava/lang/String;
    //   352: putstatic 48	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   355: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq -323 -> 35
    //   361: ldc 13
    //   363: iconst_2
    //   364: new 111	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   371: ldc -25
    //   373: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: getstatic 48	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   379: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: ldc -23
    //   384: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: aload_3
    //   388: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: goto -362 -> 35
    //   400: astore_3
    //   401: lload 8
    //   403: lstore 10
    //   405: fload_0
    //   406: fstore_1
    //   407: aload_2
    //   408: ifnull -340 -> 68
    //   411: aload_2
    //   412: invokevirtual 157	java/io/BufferedReader:close	()V
    //   415: lload 8
    //   417: lstore 10
    //   419: fload_0
    //   420: fstore_1
    //   421: goto -353 -> 68
    //   424: astore_2
    //   425: aload_2
    //   426: invokevirtual 236	java/io/IOException:printStackTrace	()V
    //   429: lload 8
    //   431: lstore 10
    //   433: fload_0
    //   434: fstore_1
    //   435: goto -367 -> 68
    //   438: aload_3
    //   439: ldc -18
    //   441: invokevirtual 221	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   444: ifeq +224 -> 668
    //   447: aload_3
    //   448: bipush 58
    //   450: invokevirtual 225	java/lang/String:indexOf	(I)I
    //   453: istore 6
    //   455: iload 6
    //   457: iconst_1
    //   458: if_icmple +48 -> 506
    //   461: aload_3
    //   462: iload 6
    //   464: iconst_1
    //   465: iadd
    //   466: aload_3
    //   467: invokevirtual 148	java/lang/String:length	()I
    //   470: invokevirtual 229	java/lang/String:substring	(II)Ljava/lang/String;
    //   473: invokevirtual 145	java/lang/String:trim	()Ljava/lang/String;
    //   476: astore 4
    //   478: aload 4
    //   480: ifnull +26 -> 506
    //   483: aload 4
    //   485: invokevirtual 148	java/lang/String:length	()I
    //   488: ifle +18 -> 506
    //   491: aload 4
    //   493: ldc -16
    //   495: invokevirtual 243	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   498: ifeq +104 -> 602
    //   501: bipush 8
    //   503: putstatic 52	com/tencent/av/core/VcSystemInfo:i	I
    //   506: aload_3
    //   507: ldc -11
    //   509: invokevirtual 248	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   512: ifeq +7 -> 519
    //   515: iconst_5
    //   516: putstatic 52	com/tencent/av/core/VcSystemInfo:i	I
    //   519: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   522: ifeq -487 -> 35
    //   525: ldc 13
    //   527: iconst_2
    //   528: new 111	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   535: ldc -6
    //   537: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: getstatic 52	com/tencent/av/core/VcSystemInfo:i	I
    //   543: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   546: ldc -23
    //   548: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload_3
    //   552: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: goto -526 -> 35
    //   564: astore_3
    //   565: lload 8
    //   567: lstore 10
    //   569: fload_0
    //   570: fstore_1
    //   571: aload_2
    //   572: ifnull -504 -> 68
    //   575: aload_2
    //   576: invokevirtual 157	java/io/BufferedReader:close	()V
    //   579: lload 8
    //   581: lstore 10
    //   583: fload_0
    //   584: fstore_1
    //   585: goto -517 -> 68
    //   588: astore_2
    //   589: aload_2
    //   590: invokevirtual 236	java/io/IOException:printStackTrace	()V
    //   593: lload 8
    //   595: lstore 10
    //   597: fload_0
    //   598: fstore_1
    //   599: goto -531 -> 68
    //   602: aload 4
    //   604: invokestatic 154	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   607: l2i
    //   608: putstatic 52	com/tencent/av/core/VcSystemInfo:i	I
    //   611: goto -105 -> 506
    //   614: astore 5
    //   616: iconst_1
    //   617: istore 6
    //   619: aload 4
    //   621: invokevirtual 148	java/lang/String:length	()I
    //   624: istore 7
    //   626: iload 6
    //   628: iload 7
    //   630: if_icmpge -124 -> 506
    //   633: aload 4
    //   635: iconst_0
    //   636: aload 4
    //   638: invokevirtual 148	java/lang/String:length	()I
    //   641: iload 6
    //   643: isub
    //   644: invokevirtual 229	java/lang/String:substring	(II)Ljava/lang/String;
    //   647: invokestatic 154	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   650: l2i
    //   651: putstatic 52	com/tencent/av/core/VcSystemInfo:i	I
    //   654: goto -148 -> 506
    //   657: astore 5
    //   659: iload 6
    //   661: iconst_1
    //   662: iadd
    //   663: istore 6
    //   665: goto -46 -> 619
    //   668: aload_3
    //   669: ldc -4
    //   671: invokevirtual 221	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   674: ifeq +118 -> 792
    //   677: aload_3
    //   678: bipush 58
    //   680: invokevirtual 225	java/lang/String:indexOf	(I)I
    //   683: istore 6
    //   685: iload 6
    //   687: iconst_1
    //   688: if_icmple +21 -> 709
    //   691: aload_3
    //   692: iload 6
    //   694: iconst_1
    //   695: iadd
    //   696: aload_3
    //   697: invokevirtual 148	java/lang/String:length	()I
    //   700: invokevirtual 229	java/lang/String:substring	(II)Ljava/lang/String;
    //   703: invokevirtual 145	java/lang/String:trim	()Ljava/lang/String;
    //   706: putstatic 50	com/tencent/av/core/VcSystemInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   709: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   712: ifeq -677 -> 35
    //   715: ldc 13
    //   717: iconst_2
    //   718: new 111	java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   725: ldc -2
    //   727: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: getstatic 50	com/tencent/av/core/VcSystemInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   733: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: ldc -23
    //   738: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: aload_3
    //   742: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   751: goto -716 -> 35
    //   754: astore_3
    //   755: lload 8
    //   757: lstore 10
    //   759: fload_0
    //   760: fstore_1
    //   761: aload_2
    //   762: ifnull -694 -> 68
    //   765: aload_2
    //   766: invokevirtual 157	java/io/BufferedReader:close	()V
    //   769: lload 8
    //   771: lstore 10
    //   773: fload_0
    //   774: fstore_1
    //   775: goto -707 -> 68
    //   778: astore_2
    //   779: aload_2
    //   780: invokevirtual 236	java/io/IOException:printStackTrace	()V
    //   783: lload 8
    //   785: lstore 10
    //   787: fload_0
    //   788: fstore_1
    //   789: goto -721 -> 68
    //   792: aload_3
    //   793: ldc_w 256
    //   796: invokevirtual 221	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   799: ifeq +98 -> 897
    //   802: aload_3
    //   803: bipush 58
    //   805: invokevirtual 225	java/lang/String:indexOf	(I)I
    //   808: istore 6
    //   810: iload 6
    //   812: iconst_1
    //   813: if_icmple +21 -> 834
    //   816: aload_3
    //   817: iload 6
    //   819: iconst_1
    //   820: iadd
    //   821: aload_3
    //   822: invokevirtual 148	java/lang/String:length	()I
    //   825: invokevirtual 229	java/lang/String:substring	(II)Ljava/lang/String;
    //   828: invokevirtual 145	java/lang/String:trim	()Ljava/lang/String;
    //   831: putstatic 258	com/tencent/av/core/VcSystemInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   834: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   837: ifeq -802 -> 35
    //   840: ldc 13
    //   842: iconst_2
    //   843: new 111	java/lang/StringBuilder
    //   846: dup
    //   847: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   850: ldc_w 260
    //   853: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: getstatic 258	com/tencent/av/core/VcSystemInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   859: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: ldc -23
    //   864: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: aload_3
    //   868: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   874: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   877: goto -842 -> 35
    //   880: astore 4
    //   882: aload_2
    //   883: astore_3
    //   884: aload 4
    //   886: astore_2
    //   887: aload_3
    //   888: ifnull +7 -> 895
    //   891: aload_3
    //   892: invokevirtual 157	java/io/BufferedReader:close	()V
    //   895: aload_2
    //   896: athrow
    //   897: aload_3
    //   898: ldc_w 262
    //   901: invokevirtual 221	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   904: ifeq +70 -> 974
    //   907: aload_3
    //   908: invokevirtual 145	java/lang/String:trim	()Ljava/lang/String;
    //   911: putstatic 264	com/tencent/av/core/VcSystemInfo:e	Ljava/lang/String;
    //   914: aload_3
    //   915: ldc_w 266
    //   918: invokevirtual 248	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   921: ifeq +7 -> 928
    //   924: iconst_1
    //   925: putstatic 268	com/tencent/av/core/VcSystemInfo:jdField_d_of_type_Boolean	Z
    //   928: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   931: ifeq -896 -> 35
    //   934: ldc 13
    //   936: iconst_2
    //   937: new 111	java/lang/StringBuilder
    //   940: dup
    //   941: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   944: ldc_w 270
    //   947: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: getstatic 268	com/tencent/av/core/VcSystemInfo:jdField_d_of_type_Boolean	Z
    //   953: invokevirtual 213	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   956: ldc -23
    //   958: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: aload_3
    //   962: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   968: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   971: goto -936 -> 35
    //   974: aload_3
    //   975: ldc_w 272
    //   978: invokevirtual 221	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   981: ifeq +65 -> 1046
    //   984: aload_3
    //   985: bipush 58
    //   987: invokevirtual 225	java/lang/String:indexOf	(I)I
    //   990: istore 6
    //   992: iload 6
    //   994: iconst_1
    //   995: if_icmple -960 -> 35
    //   998: aload_3
    //   999: iload 6
    //   1001: iconst_1
    //   1002: iadd
    //   1003: aload_3
    //   1004: invokevirtual 148	java/lang/String:length	()I
    //   1007: invokevirtual 229	java/lang/String:substring	(II)Ljava/lang/String;
    //   1010: invokevirtual 145	java/lang/String:trim	()Ljava/lang/String;
    //   1013: astore_3
    //   1014: aload_3
    //   1015: invokestatic 154	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1018: lstore 10
    //   1020: lload 10
    //   1022: lconst_0
    //   1023: lcmp
    //   1024: iflt -989 -> 35
    //   1027: lconst_1
    //   1028: lload 10
    //   1030: ladd
    //   1031: lload 8
    //   1033: lcmp
    //   1034: ifle -999 -> 35
    //   1037: lconst_1
    //   1038: lload 10
    //   1040: ladd
    //   1041: lstore 8
    //   1043: goto -1008 -> 35
    //   1046: aload_3
    //   1047: ldc_w 274
    //   1050: invokevirtual 221	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1053: ifeq -1018 -> 35
    //   1056: aload_3
    //   1057: bipush 58
    //   1059: invokevirtual 225	java/lang/String:indexOf	(I)I
    //   1062: istore 6
    //   1064: iload 6
    //   1066: iconst_1
    //   1067: if_icmple -1032 -> 35
    //   1070: aload_3
    //   1071: iload 6
    //   1073: iconst_1
    //   1074: iadd
    //   1075: aload_3
    //   1076: invokevirtual 148	java/lang/String:length	()I
    //   1079: invokevirtual 229	java/lang/String:substring	(II)Ljava/lang/String;
    //   1082: invokevirtual 145	java/lang/String:trim	()Ljava/lang/String;
    //   1085: astore_3
    //   1086: aload_3
    //   1087: invokestatic 280	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   1090: fstore_1
    //   1091: fload_1
    //   1092: fload_0
    //   1093: fcmpl
    //   1094: ifle +228 -> 1322
    //   1097: fload_1
    //   1098: fstore_0
    //   1099: goto -1064 -> 35
    //   1102: astore_2
    //   1103: aload_2
    //   1104: invokevirtual 236	java/io/IOException:printStackTrace	()V
    //   1107: lload 8
    //   1109: lstore 10
    //   1111: fload_0
    //   1112: fstore_1
    //   1113: goto -1045 -> 68
    //   1116: astore_3
    //   1117: aload_3
    //   1118: invokevirtual 236	java/io/IOException:printStackTrace	()V
    //   1121: goto -226 -> 895
    //   1124: lload 10
    //   1126: lconst_0
    //   1127: lcmp
    //   1128: ifle -1012 -> 116
    //   1131: lload 10
    //   1133: l2i
    //   1134: putstatic 54	com/tencent/av/core/VcSystemInfo:j	I
    //   1137: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1140: ifeq -1024 -> 116
    //   1143: ldc 13
    //   1145: iconst_2
    //   1146: new 111	java/lang/StringBuilder
    //   1149: dup
    //   1150: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1153: ldc_w 282
    //   1156: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: getstatic 54	com/tencent/av/core/VcSystemInfo:j	I
    //   1162: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1165: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1168: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1171: goto -1055 -> 116
    //   1174: fload_1
    //   1175: fconst_0
    //   1176: fcmpl
    //   1177: ifle -1011 -> 166
    //   1180: fload_1
    //   1181: ldc_w 283
    //   1184: fcmpg
    //   1185: ifge +54 -> 1239
    //   1188: fload_1
    //   1189: f2d
    //   1190: ldc2_w 284
    //   1193: dmul
    //   1194: ldc2_w 286
    //   1197: dmul
    //   1198: d2l
    //   1199: putstatic 194	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   1202: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1205: ifeq -1039 -> 166
    //   1208: ldc 13
    //   1210: iconst_2
    //   1211: new 111	java/lang/StringBuilder
    //   1214: dup
    //   1215: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1218: ldc_w 289
    //   1221: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: getstatic 194	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   1227: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1230: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1233: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1236: goto -1070 -> 166
    //   1239: fload_1
    //   1240: ldc_w 290
    //   1243: fcmpl
    //   1244: ifle +20 -> 1264
    //   1247: fload_1
    //   1248: f2d
    //   1249: ldc2_w 291
    //   1252: ddiv
    //   1253: ldc2_w 286
    //   1256: dmul
    //   1257: d2l
    //   1258: putstatic 194	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   1261: goto -59 -> 1202
    //   1264: ldc_w 293
    //   1267: fload_1
    //   1268: fmul
    //   1269: f2l
    //   1270: putstatic 194	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   1273: goto -71 -> 1202
    //   1276: iconst_1
    //   1277: putstatic 181	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Boolean	Z
    //   1280: goto -1052 -> 228
    //   1283: iconst_0
    //   1284: putstatic 62	com/tencent/av/core/VcSystemInfo:jdField_c_of_type_Boolean	Z
    //   1287: goto -1035 -> 252
    //   1290: astore_3
    //   1291: goto -1256 -> 35
    //   1294: astore_3
    //   1295: goto -1260 -> 35
    //   1298: astore_2
    //   1299: aconst_null
    //   1300: astore_3
    //   1301: goto -414 -> 887
    //   1304: astore_2
    //   1305: aconst_null
    //   1306: astore_2
    //   1307: goto -552 -> 755
    //   1310: astore_2
    //   1311: aconst_null
    //   1312: astore_2
    //   1313: goto -748 -> 565
    //   1316: astore_2
    //   1317: aload_3
    //   1318: astore_2
    //   1319: goto -918 -> 401
    //   1322: goto -223 -> 1099
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	1095	0	f1	float
    //   53	1215	1	f2	float
    //   34	378	2	localBufferedReader	BufferedReader
    //   424	152	2	localIOException1	IOException
    //   588	178	2	localIOException2	IOException
    //   778	105	2	localIOException3	IOException
    //   886	10	2	localObject1	Object
    //   1102	2	2	localIOException4	IOException
    //   1298	1	2	localObject2	Object
    //   1304	1	2	localNumberFormatException1	NumberFormatException
    //   1306	1	2	localObject3	Object
    //   1310	1	2	localIOException5	IOException
    //   1312	1	2	localObject4	Object
    //   1316	1	2	localFileNotFoundException1	FileNotFoundException
    //   1318	1	2	localObject5	Object
    //   9	379	3	str1	String
    //   400	152	3	localFileNotFoundException2	FileNotFoundException
    //   564	178	3	localIOException6	IOException
    //   754	114	3	localNumberFormatException2	NumberFormatException
    //   883	204	3	localObject6	Object
    //   1116	2	3	localIOException7	IOException
    //   1290	1	3	localNumberFormatException3	NumberFormatException
    //   1294	1	3	localNumberFormatException4	NumberFormatException
    //   1300	18	3	localObject7	Object
    //   476	161	4	str2	String
    //   880	5	4	localObject8	Object
    //   614	1	5	localNumberFormatException5	NumberFormatException
    //   657	1	5	localNumberFormatException6	NumberFormatException
    //   71	1004	6	i1	int
    //   624	7	7	i2	int
    //   13	1095	8	l1	long
    //   50	1082	10	l2	long
    // Exception table:
    //   from	to	target	type
    //   35	40	400	java/io/FileNotFoundException
    //   44	48	400	java/io/FileNotFoundException
    //   308	325	400	java/io/FileNotFoundException
    //   331	397	400	java/io/FileNotFoundException
    //   438	455	400	java/io/FileNotFoundException
    //   461	478	400	java/io/FileNotFoundException
    //   483	506	400	java/io/FileNotFoundException
    //   506	519	400	java/io/FileNotFoundException
    //   519	561	400	java/io/FileNotFoundException
    //   602	611	400	java/io/FileNotFoundException
    //   619	626	400	java/io/FileNotFoundException
    //   633	654	400	java/io/FileNotFoundException
    //   668	685	400	java/io/FileNotFoundException
    //   691	709	400	java/io/FileNotFoundException
    //   709	751	400	java/io/FileNotFoundException
    //   792	810	400	java/io/FileNotFoundException
    //   816	834	400	java/io/FileNotFoundException
    //   834	877	400	java/io/FileNotFoundException
    //   897	928	400	java/io/FileNotFoundException
    //   928	971	400	java/io/FileNotFoundException
    //   974	992	400	java/io/FileNotFoundException
    //   998	1014	400	java/io/FileNotFoundException
    //   1014	1020	400	java/io/FileNotFoundException
    //   1046	1064	400	java/io/FileNotFoundException
    //   1070	1086	400	java/io/FileNotFoundException
    //   1086	1091	400	java/io/FileNotFoundException
    //   411	415	424	java/io/IOException
    //   35	40	564	java/io/IOException
    //   44	48	564	java/io/IOException
    //   308	325	564	java/io/IOException
    //   331	397	564	java/io/IOException
    //   438	455	564	java/io/IOException
    //   461	478	564	java/io/IOException
    //   483	506	564	java/io/IOException
    //   506	519	564	java/io/IOException
    //   519	561	564	java/io/IOException
    //   602	611	564	java/io/IOException
    //   619	626	564	java/io/IOException
    //   633	654	564	java/io/IOException
    //   668	685	564	java/io/IOException
    //   691	709	564	java/io/IOException
    //   709	751	564	java/io/IOException
    //   792	810	564	java/io/IOException
    //   816	834	564	java/io/IOException
    //   834	877	564	java/io/IOException
    //   897	928	564	java/io/IOException
    //   928	971	564	java/io/IOException
    //   974	992	564	java/io/IOException
    //   998	1014	564	java/io/IOException
    //   1014	1020	564	java/io/IOException
    //   1046	1064	564	java/io/IOException
    //   1070	1086	564	java/io/IOException
    //   1086	1091	564	java/io/IOException
    //   575	579	588	java/io/IOException
    //   602	611	614	java/lang/NumberFormatException
    //   633	654	657	java/lang/NumberFormatException
    //   35	40	754	java/lang/NumberFormatException
    //   44	48	754	java/lang/NumberFormatException
    //   308	325	754	java/lang/NumberFormatException
    //   331	397	754	java/lang/NumberFormatException
    //   438	455	754	java/lang/NumberFormatException
    //   461	478	754	java/lang/NumberFormatException
    //   483	506	754	java/lang/NumberFormatException
    //   506	519	754	java/lang/NumberFormatException
    //   519	561	754	java/lang/NumberFormatException
    //   619	626	754	java/lang/NumberFormatException
    //   668	685	754	java/lang/NumberFormatException
    //   691	709	754	java/lang/NumberFormatException
    //   709	751	754	java/lang/NumberFormatException
    //   792	810	754	java/lang/NumberFormatException
    //   816	834	754	java/lang/NumberFormatException
    //   834	877	754	java/lang/NumberFormatException
    //   897	928	754	java/lang/NumberFormatException
    //   928	971	754	java/lang/NumberFormatException
    //   974	992	754	java/lang/NumberFormatException
    //   998	1014	754	java/lang/NumberFormatException
    //   1046	1064	754	java/lang/NumberFormatException
    //   1070	1086	754	java/lang/NumberFormatException
    //   765	769	778	java/io/IOException
    //   35	40	880	finally
    //   44	48	880	finally
    //   308	325	880	finally
    //   331	397	880	finally
    //   438	455	880	finally
    //   461	478	880	finally
    //   483	506	880	finally
    //   506	519	880	finally
    //   519	561	880	finally
    //   602	611	880	finally
    //   619	626	880	finally
    //   633	654	880	finally
    //   668	685	880	finally
    //   691	709	880	finally
    //   709	751	880	finally
    //   792	810	880	finally
    //   816	834	880	finally
    //   834	877	880	finally
    //   897	928	880	finally
    //   928	971	880	finally
    //   974	992	880	finally
    //   998	1014	880	finally
    //   1014	1020	880	finally
    //   1046	1064	880	finally
    //   1070	1086	880	finally
    //   1086	1091	880	finally
    //   58	62	1102	java/io/IOException
    //   891	895	1116	java/io/IOException
    //   1014	1020	1290	java/lang/NumberFormatException
    //   1086	1091	1294	java/lang/NumberFormatException
    //   18	35	1298	finally
    //   18	35	1304	java/lang/NumberFormatException
    //   18	35	1310	java/io/IOException
    //   18	35	1316	java/io/FileNotFoundException
  }
  
  static boolean a()
  {
    boolean bool = true;
    k = Utils.a(BaseApplicationImpl.getContext());
    if ((k < 2) || (l < 1)) {
      bool = false;
    }
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      if ((jdField_c_of_type_JavaLangString == null) || (jdField_c_of_type_JavaLangString.equals(""))) {
        a();
      }
      int i1 = jdField_c_of_type_JavaLangString.indexOf(paramString);
      if (i1 > 0) {
        return true;
      }
    }
    catch (Exception paramString) {}
    return false;
  }
  
  static int b()
  {
    if (jdField_b_of_type_JavaLangString.contains("ARMv6")) {}
    do
    {
      return 2;
      if (Build.CPU_ABI.equalsIgnoreCase("armeabi-v7a")) {
        return 4;
      }
    } while (Build.CPU_ABI.equalsIgnoreCase("armeabi"));
    if ((i == 7) && (jdField_c_of_type_JavaLangString.indexOf("neon") < 0))
    {
      long l1 = c();
      int i1 = e();
      if ((l1 < 1100000L) || (i1 < 2)) {
        return 3;
      }
    }
    if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
      return 7;
    }
    switch (i)
    {
    case 6: 
    default: 
      if ((jdField_d_of_type_JavaLangString != null) && ((jdField_d_of_type_JavaLangString.equalsIgnoreCase("AuthenticAMD")) || (jdField_d_of_type_JavaLangString.equalsIgnoreCase("GenuineIntel")))) {
        return 7;
      }
      break;
    case 5: 
      return 1;
    case 7: 
      return 4;
    case 8: 
      return 5;
    }
    return 0;
  }
  
  public static long b()
  {
    long l2 = 0L;
    String str1 = "";
    long l3 = l2;
    long l4 = l2;
    long l5 = l2;
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
      long l1 = l2;
      if (localBufferedReader != null)
      {
        l3 = l2;
        l4 = l2;
        l5 = l2;
        String str2 = localBufferedReader.readLine();
        l3 = l2;
        l4 = l2;
        l5 = l2;
        if (!TextUtils.isEmpty(str2))
        {
          l3 = l2;
          l4 = l2;
          l5 = l2;
          str1 = str2.trim();
        }
        l1 = l2;
        if (str1 != null)
        {
          l1 = l2;
          l3 = l2;
          l4 = l2;
          l5 = l2;
          if (str1.length() > 0)
          {
            l3 = l2;
            l4 = l2;
            l5 = l2;
            l1 = Long.parseLong(str1);
          }
        }
        l3 = l1;
        l4 = l1;
        l5 = l1;
        localBufferedReader.close();
      }
      return l1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      return l3;
    }
    catch (IOException localIOException)
    {
      return l4;
    }
    catch (FileNotFoundException localFileNotFoundException) {}
    return l5;
  }
  
  public static String b()
  {
    return Build.MANUFACTURER + "_" + Build.MODEL;
  }
  
  static boolean b()
  {
    String str1 = Build.MODEL;
    String str2 = Build.VERSION.INCREMENTAL;
    String str3 = Build.MANUFACTURER;
    int i1 = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel()) {
      QLog.d("VcSystemInfo", 2, "Model: " + str1 + "\n" + "Version: " + str2 + "\n" + "Manufacturer: " + str3 + "\n" + "SDK Version: " + i1);
    }
    if ((l < 1) || (i1 < 8)) {
      if (QLog.isColorLevel()) {
        QLog.d("VcSystemInfo", 2, "CHIP or SDK NOT_SUPPORT");
      }
    }
    do
    {
      do
      {
        do
        {
          return false;
          if ((!str3.equalsIgnoreCase("HUAWEI")) || (!str1.equalsIgnoreCase("C8500"))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VcSystemInfo", 2, "DEVICE_NOT_SUPPORT");
        return false;
        if ((!str3.equalsIgnoreCase("Samsung")) || (!str1.equalsIgnoreCase("GT-I5508"))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VcSystemInfo", 2, "DEVICE_NOT_SUPPORT");
      return false;
      if ((!str3.equalsIgnoreCase("FIH")) || (!str1.equalsIgnoreCase("SH8128U"))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VcSystemInfo", 2, "DEVICE_NOT_SUPPORT");
    return false;
    return true;
  }
  
  public static long c()
  {
    a();
    return jdField_a_of_type_Long;
  }
  
  public static String c()
  {
    a();
    return jdField_b_of_type_JavaLangString;
  }
  
  public static boolean c()
  {
    if (Build.VERSION.SDK_INT < 11) {}
    do
    {
      return true;
      if (q == 0) {
        q = e();
      }
      if (jdField_b_of_type_Long == 0L) {
        jdField_b_of_type_Long = c();
      }
    } while ((q <= 1) && (jdField_b_of_type_Long <= 1025000L));
    return false;
  }
  
  public static String d()
  {
    a();
    return "prcs(" + jdField_b_of_type_JavaLangString + ") " + "arch(" + i + ") " + "hard(" + e + ") " + "chip(" + l + ") " + "freq(" + jdField_a_of_type_Long + ") " + "num(" + j + ")";
  }
  
  public static boolean d()
  {
    
    if (QLog.isColorLevel()) {
      QLog.d("VcSystemInfo", 2, "[isSupportSharpVideo] [CpuInfo] mProcessorName=" + jdField_b_of_type_JavaLangString + " \n" + "mCpuArchitecture=" + i + " \n" + "mFeature=" + jdField_c_of_type_JavaLangString + " \n" + "mVendorId=" + jdField_d_of_type_JavaLangString + " \n" + "mMaxCpuFreq=" + jdField_a_of_type_Long + " \n" + "mCoreNumber=" + j + " \n" + "mOpenGLVersion=" + k + " \n" + "mIsMarvell=" + jdField_d_of_type_Boolean + " \n" + "Chip=" + l + ", Video=" + jdField_c_of_type_Boolean + ", Audio=" + jdField_b_of_type_Boolean + " \n" + "devModel=" + Build.MODEL + " \n" + "devVersion=" + Build.VERSION.INCREMENTAL + " \n" + "devManufacturer=" + Build.MANUFACTURER + " \n" + "sdkVersion=" + Build.VERSION.SDK_INT + " \n");
    }
    return jdField_c_of_type_Boolean;
  }
  
  public static int e()
  {
    a();
    return j;
  }
  
  public static String e()
  {
    a();
    return "model(" + Build.MODEL + ") " + "Mnfc(" + Build.MANUFACTURER + ") " + "dev(" + Build.VERSION.INCREMENTAL + ") " + "sdk(" + Build.VERSION.SDK_INT + ") " + "gl(" + k + ")";
  }
  
  public static boolean e()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public static int f()
  {
    a();
    return l;
  }
  
  public static boolean f()
  {
    if (l > 2) {}
    BaseApplication localBaseApplication;
    do
    {
      return true;
      localBaseApplication = BaseApplicationImpl.getContext();
    } while (UpdateAvSo.a(localBaseApplication));
    if (QLog.isColorLevel()) {
      QLog.w("VcSystemInfo", 2, "EarlyDownload libs is not ready for armv6/armv5 device");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.downloadAvSo");
    localIntent.setPackage(localBaseApplication.getPackageName());
    localBaseApplication.sendBroadcast(localIntent);
    return false;
  }
  
  public static boolean g()
  {
    return ((a("neon")) || (a("asimd"))) && (e() >= 2) && (f() >= 4);
  }
  
  public static boolean h()
  {
    a();
    return (l >= 3) && (jdField_a_of_type_Long / 1000L >= 800L) && (Build.VERSION.SDK_INT >= 9);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.m = paramInt1;
    this.n = paramInt2;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.o = paramInt1;
    this.p = paramInt2;
  }
  
  public int c()
  {
    int i1 = 1;
    if (Build.VERSION.SDK_INT > 9) {
      i1 = 2;
    }
    return i1;
  }
  
  public int d()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      if (str.equals("L")) {
        return 118;
      }
      if (Build.VERSION.SDK_INT == 20) {
        return 118;
      }
      if (Build.VERSION.SDK_INT <= 20)
      {
        int i2 = str.charAt(0);
        int i3 = str.charAt(2);
        int i1 = 0;
        if (str.length() >= 5) {
          i1 = str.charAt(4);
        }
        switch (i2)
        {
        default: 
          return 200;
        case 49: 
          if (i3 == 49) {
            return 101;
          }
          if (i3 == 53) {
            return 102;
          }
          if (i3 == 54) {
            return 103;
          }
          break;
        case 50: 
          if (i3 == 48)
          {
            if (i1 == 49) {
              return 105;
            }
            return 104;
          }
          if (i3 == 49) {
            return 106;
          }
          if (i3 == 50)
          {
            if (i1 == 49) {
              return 108;
            }
            return 107;
          }
          if ((i3 == 51) && (i1 >= 48) && (i1 <= 57)) {
            return 109;
          }
          break;
        case 51: 
          if (i3 == 48) {
            return 110;
          }
          if (i3 == 49) {
            return 111;
          }
          if (i3 == 50) {
            return 112;
          }
          break;
        case 52: 
          if (i3 == 48) {
            return 113;
          }
          if (i3 == 49) {
            return 114;
          }
          if (i3 == 50) {
            return 115;
          }
          if (i3 == 51) {
            return 116;
          }
          if (i3 == 52) {
            return 117;
          }
          break;
        case 53: 
          if (i3 == 48) {
            return 118;
          }
          break;
        }
      }
    }
    catch (Exception localException) {}
    return 200;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\core\VcSystemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */