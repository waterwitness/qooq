package com.tencent.image;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class JpegExifReader
{
  private static final String BIG_ENDIAN_BYTE_ORDER = "MM";
  private static final byte[] BYTES_PER_FORMAT = { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8 };
  private static final int DIRECTORY_LENGTH = 12;
  private static final byte E0 = -32;
  private static final byte E1 = -31;
  private static final String EXIF = "EXIF";
  private static final int EXPOSURE_TIME_TAG = 33434;
  private static final byte FF = -1;
  private static final String LITTLE_ENDIAN_BYTE_ORDER = "II";
  private static final int ORIENTATION_TAG = 274;
  private static final String REPORT_ACTION = "actReadJpegOrientation";
  private static final byte SEGMENTS_END = -38;
  private static final int SUB_IFD_OFFSET_TAG = 34665;
  private static final String TAG = "JpegExifReader";
  private static final int TIFF_HEADER_OFFSET = 6;
  public static JpegExifReaderInterface jpegExifReaderInterface;
  private static boolean sIsEnable = true;
  private static boolean sIsReadDpc = false;
  
  private static short getInt16(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramBoolean) {
      return (short)(paramArrayOfByte[0] & 0xFF00 | paramArrayOfByte[1] & 0xFF);
    }
    return (short)(paramArrayOfByte[1] & 0xFF00 | paramArrayOfByte[0] & 0xFF);
  }
  
  private static int getInt32(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramBoolean) {
      return paramArrayOfByte[0] << 24 & 0xFF000000 | paramArrayOfByte[1] << 16 & 0xFF0000 | paramArrayOfByte[2] << 8 & 0xFF00 | paramArrayOfByte[3] & 0xFF;
    }
    return paramArrayOfByte[3] << 24 & 0xFF000000 | paramArrayOfByte[2] << 16 & 0xFF0000 | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[0] & 0xFF;
  }
  
  public static int getRotationDegree(String paramString)
  {
    switch (readOrientation(paramString))
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 6: 
      return 90;
    case 3: 
      return 180;
    }
    return 270;
  }
  
  private static int getUnsignedInt16(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramBoolean) {
      return paramArrayOfByte[0] << 8 & 0xFF00 | paramArrayOfByte[1] & 0xFF;
    }
    return paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[0] & 0xFF;
  }
  
  private static long getUnsignedInt32(boolean paramBoolean, byte[] paramArrayOfByte)
    throws Exception
  {
    if (paramBoolean) {
      return paramArrayOfByte[0] << 24 & 0xFF000000 | paramArrayOfByte[1] << 16 & 0xFF0000 | paramArrayOfByte[2] << 8 & 0xFF00 | paramArrayOfByte[3] & 0xFF;
    }
    return paramArrayOfByte[3] << 24 & 0xFF000000 | paramArrayOfByte[2] << 16 & 0xFF0000 | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[0] & 0xFF;
  }
  
  private static long getValue(int paramInt, boolean paramBoolean, byte[] paramArrayOfByte)
    throws Exception
  {
    switch (paramInt)
    {
    case 5: 
    case 7: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("JpegExifReader", 2, "get value format code: " + paramInt);
      }
      return 0L;
    case 3: 
      return getUnsignedInt16(paramBoolean, paramArrayOfByte);
    case 4: 
      return getUnsignedInt32(paramBoolean, paramArrayOfByte);
    case 6: 
      return paramArrayOfByte[0];
    case 8: 
      return getInt16(paramBoolean, paramArrayOfByte);
    }
    return getInt32(paramBoolean, paramArrayOfByte);
  }
  
  public static void initJpegExifReader(JpegExifReaderInterface paramJpegExifReaderInterface)
  {
    jpegExifReaderInterface = paramJpegExifReaderInterface;
  }
  
  /* Error */
  public static boolean isCrashJpeg(String paramString)
  {
    // Byte code:
    //   0: getstatic 143	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 24
    //   5: if_icmplt +9 -> 14
    //   8: iconst_0
    //   9: istore 17
    //   11: iload 17
    //   13: ireturn
    //   14: invokestatic 149	android/os/SystemClock:uptimeMillis	()J
    //   17: lstore 12
    //   19: iconst_0
    //   20: istore 17
    //   22: iconst_0
    //   23: istore 18
    //   25: aconst_null
    //   26: astore_1
    //   27: aconst_null
    //   28: astore 4
    //   30: iconst_0
    //   31: istore 6
    //   33: iconst_0
    //   34: istore 7
    //   36: ldc -105
    //   38: astore_3
    //   39: new 153	java/io/BufferedInputStream
    //   42: dup
    //   43: new 155	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 158	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   51: sipush 1024
    //   54: invokespecial 161	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   57: astore_2
    //   58: iconst_0
    //   59: istore 8
    //   61: iload 7
    //   63: istore 6
    //   65: iconst_2
    //   66: newarray <illegal type>
    //   68: astore 4
    //   70: iload 7
    //   72: istore 6
    //   74: aload_2
    //   75: aload 4
    //   77: iconst_0
    //   78: iconst_2
    //   79: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   82: iconst_2
    //   83: if_icmpne +34 -> 117
    //   86: aload 4
    //   88: iconst_0
    //   89: baload
    //   90: sipush 255
    //   93: iand
    //   94: sipush 255
    //   97: if_icmpne +191 -> 288
    //   100: aload 4
    //   102: iconst_1
    //   103: baload
    //   104: sipush 255
    //   107: iand
    //   108: sipush 216
    //   111: if_icmpne +177 -> 288
    //   114: iconst_1
    //   115: istore 8
    //   117: iconst_0
    //   118: iconst_2
    //   119: iadd
    //   120: istore 9
    //   122: aload_3
    //   123: astore_1
    //   124: iload 18
    //   126: istore 16
    //   128: iload 9
    //   130: istore 7
    //   132: iload 8
    //   134: ifeq +61 -> 195
    //   137: iload 9
    //   139: istore 6
    //   141: iconst_4
    //   142: newarray <illegal type>
    //   144: astore_1
    //   145: iload 9
    //   147: istore 6
    //   149: aload_2
    //   150: invokevirtual 168	java/io/BufferedInputStream:read	()I
    //   153: sipush 255
    //   156: iand
    //   157: i2b
    //   158: istore 8
    //   160: iload 9
    //   162: iconst_1
    //   163: iadd
    //   164: istore 7
    //   166: iload 7
    //   168: istore 6
    //   170: aload_2
    //   171: invokevirtual 168	java/io/BufferedInputStream:read	()I
    //   174: sipush 255
    //   177: iand
    //   178: i2b
    //   179: istore 9
    //   181: iload 9
    //   183: bipush -38
    //   185: if_icmpne +109 -> 294
    //   188: ldc -86
    //   190: astore_1
    //   191: iload 18
    //   193: istore 16
    //   195: aload_2
    //   196: ifnull +1488 -> 1684
    //   199: aload_2
    //   200: invokevirtual 173	java/io/BufferedInputStream:close	()V
    //   203: invokestatic 149	android/os/SystemClock:uptimeMillis	()J
    //   206: lstore 14
    //   208: iload 16
    //   210: istore 17
    //   212: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq -204 -> 11
    //   218: ldc 42
    //   220: iconst_2
    //   221: new 102	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   228: ldc -81
    //   230: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: iload 16
    //   235: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   238: ldc -76
    //   240: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: iload 7
    //   245: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: ldc -74
    //   250: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: lload 14
    //   255: lload 12
    //   257: lsub
    //   258: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   261: ldc -69
    //   263: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_0
    //   267: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc -67
    //   272: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_1
    //   276: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: iload 16
    //   287: ireturn
    //   288: iconst_0
    //   289: istore 8
    //   291: goto -174 -> 117
    //   294: iload 7
    //   296: iconst_1
    //   297: iadd
    //   298: istore 7
    //   300: iload 7
    //   302: istore 6
    //   304: aload_2
    //   305: aload 4
    //   307: iconst_0
    //   308: iconst_2
    //   309: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   312: iconst_2
    //   313: if_icmpeq +13 -> 326
    //   316: ldc -62
    //   318: astore_1
    //   319: iload 18
    //   321: istore 16
    //   323: goto -128 -> 195
    //   326: iload 7
    //   328: iconst_2
    //   329: iadd
    //   330: istore 7
    //   332: aload 4
    //   334: iconst_0
    //   335: baload
    //   336: bipush 8
    //   338: ishl
    //   339: ldc 69
    //   341: iand
    //   342: aload 4
    //   344: iconst_1
    //   345: baload
    //   346: sipush 255
    //   349: iand
    //   350: ior
    //   351: iconst_2
    //   352: isub
    //   353: istore 10
    //   355: iload 8
    //   357: iconst_m1
    //   358: if_icmpne +1340 -> 1698
    //   361: iload 9
    //   363: bipush -32
    //   365: if_icmpne +1333 -> 1698
    //   368: iload 7
    //   370: istore 6
    //   372: aload_2
    //   373: iload 10
    //   375: i2l
    //   376: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   379: iload 10
    //   381: i2l
    //   382: lcmp
    //   383: ifne +1304 -> 1687
    //   386: iload 7
    //   388: iload 10
    //   390: iadd
    //   391: istore 9
    //   393: goto -248 -> 145
    //   396: iload 7
    //   398: istore 6
    //   400: aload_2
    //   401: aload_1
    //   402: iconst_0
    //   403: iconst_4
    //   404: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   407: iconst_4
    //   408: if_icmpeq +13 -> 421
    //   411: ldc -56
    //   413: astore_1
    //   414: iload 18
    //   416: istore 16
    //   418: goto -223 -> 195
    //   421: iload 7
    //   423: iconst_4
    //   424: iadd
    //   425: istore 7
    //   427: iload 7
    //   429: istore 6
    //   431: ldc 23
    //   433: new 202	java/lang/String
    //   436: dup
    //   437: aload_1
    //   438: invokespecial 205	java/lang/String:<init>	([B)V
    //   441: invokevirtual 208	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   444: ifne +13 -> 457
    //   447: ldc -46
    //   449: astore_1
    //   450: iload 18
    //   452: istore 16
    //   454: goto -259 -> 195
    //   457: iload 7
    //   459: istore 6
    //   461: aload_2
    //   462: ldc2_w 211
    //   465: invokevirtual 215	java/io/BufferedInputStream:skip	(J)J
    //   468: ldc2_w 211
    //   471: lcmp
    //   472: ifeq +13 -> 485
    //   475: ldc -39
    //   477: astore_1
    //   478: iload 18
    //   480: istore 16
    //   482: goto -287 -> 195
    //   485: iload 7
    //   487: iconst_2
    //   488: iadd
    //   489: istore 7
    //   491: iload 7
    //   493: istore 6
    //   495: aload_2
    //   496: aload 4
    //   498: iconst_0
    //   499: iconst_2
    //   500: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   503: iconst_2
    //   504: if_icmpeq +13 -> 517
    //   507: ldc -37
    //   509: astore_1
    //   510: iload 18
    //   512: istore 16
    //   514: goto -319 -> 195
    //   517: iload 7
    //   519: iconst_2
    //   520: iadd
    //   521: istore 8
    //   523: iload 8
    //   525: istore 6
    //   527: new 202	java/lang/String
    //   530: dup
    //   531: aload 4
    //   533: invokespecial 205	java/lang/String:<init>	([B)V
    //   536: astore 5
    //   538: iload 8
    //   540: istore 6
    //   542: ldc 11
    //   544: aload 5
    //   546: invokevirtual 208	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   549: ifeq +38 -> 587
    //   552: iconst_1
    //   553: istore 16
    //   555: iload 8
    //   557: istore 6
    //   559: aload_2
    //   560: ldc2_w 211
    //   563: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   566: ldc2_w 211
    //   569: lcmp
    //   570: ifeq +78 -> 648
    //   573: ldc -35
    //   575: astore_1
    //   576: iload 18
    //   578: istore 16
    //   580: iload 8
    //   582: istore 7
    //   584: goto -389 -> 195
    //   587: iload 8
    //   589: istore 6
    //   591: ldc 30
    //   593: aload 5
    //   595: invokevirtual 208	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   598: ifeq +9 -> 607
    //   601: iconst_0
    //   602: istore 16
    //   604: goto -49 -> 555
    //   607: iload 8
    //   609: istore 6
    //   611: new 102	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   618: ldc -33
    //   620: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: aload 5
    //   625: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: ldc -31
    //   630: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: astore_1
    //   637: iload 18
    //   639: istore 16
    //   641: iload 8
    //   643: istore 7
    //   645: goto -450 -> 195
    //   648: iload 8
    //   650: istore 6
    //   652: aload_2
    //   653: aload_1
    //   654: iconst_0
    //   655: iconst_4
    //   656: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   659: iconst_4
    //   660: if_icmpeq +17 -> 677
    //   663: ldc -29
    //   665: astore_1
    //   666: iload 18
    //   668: istore 16
    //   670: iload 8
    //   672: istore 7
    //   674: goto -479 -> 195
    //   677: iload 8
    //   679: bipush 6
    //   681: iadd
    //   682: istore 8
    //   684: iload 8
    //   686: istore 6
    //   688: iload 16
    //   690: aload_1
    //   691: invokestatic 128	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   694: bipush 8
    //   696: isub
    //   697: istore 9
    //   699: iload 9
    //   701: ifle +35 -> 736
    //   704: iload 8
    //   706: istore 6
    //   708: aload_2
    //   709: iload 9
    //   711: i2l
    //   712: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   715: iload 9
    //   717: i2l
    //   718: lcmp
    //   719: ifeq +17 -> 736
    //   722: ldc -27
    //   724: astore_1
    //   725: iload 18
    //   727: istore 16
    //   729: iload 8
    //   731: istore 7
    //   733: goto -538 -> 195
    //   736: iload 8
    //   738: istore 6
    //   740: aload_2
    //   741: aload 4
    //   743: iconst_0
    //   744: iconst_2
    //   745: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   748: iconst_2
    //   749: if_icmpeq +17 -> 766
    //   752: ldc -25
    //   754: astore_1
    //   755: iload 18
    //   757: istore 16
    //   759: iload 8
    //   761: istore 7
    //   763: goto -568 -> 195
    //   766: iload 8
    //   768: iload 9
    //   770: iconst_2
    //   771: iadd
    //   772: iadd
    //   773: istore 8
    //   775: iload 8
    //   777: istore 6
    //   779: iload 16
    //   781: aload 4
    //   783: invokestatic 122	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   786: istore 10
    //   788: iconst_0
    //   789: istore 9
    //   791: iload 9
    //   793: iload 10
    //   795: if_icmpge +778 -> 1573
    //   798: iload 8
    //   800: istore 6
    //   802: aload_2
    //   803: aload 4
    //   805: iconst_0
    //   806: iconst_2
    //   807: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   810: iconst_2
    //   811: if_icmpeq +17 -> 828
    //   814: ldc -23
    //   816: astore_1
    //   817: iload 18
    //   819: istore 16
    //   821: iload 8
    //   823: istore 7
    //   825: goto -630 -> 195
    //   828: iload 8
    //   830: iconst_2
    //   831: iadd
    //   832: istore 8
    //   834: iload 8
    //   836: istore 6
    //   838: iload 16
    //   840: aload 4
    //   842: invokestatic 122	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   845: ldc 39
    //   847: if_icmpne +693 -> 1540
    //   850: iload 8
    //   852: istore 6
    //   854: aload_2
    //   855: aload 4
    //   857: iconst_0
    //   858: iconst_2
    //   859: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   862: iconst_2
    //   863: if_icmpeq +17 -> 880
    //   866: ldc -21
    //   868: astore_1
    //   869: iload 18
    //   871: istore 16
    //   873: iload 8
    //   875: istore 7
    //   877: goto -682 -> 195
    //   880: iload 8
    //   882: iconst_2
    //   883: iadd
    //   884: istore 8
    //   886: iload 8
    //   888: istore 6
    //   890: iload 16
    //   892: aload 4
    //   894: invokestatic 122	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   897: istore 9
    //   899: iload 8
    //   901: istore 6
    //   903: aload_2
    //   904: aload_1
    //   905: iconst_0
    //   906: iconst_4
    //   907: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   910: iconst_4
    //   911: if_icmpeq +17 -> 928
    //   914: ldc -19
    //   916: astore_1
    //   917: iload 18
    //   919: istore 16
    //   921: iload 8
    //   923: istore 7
    //   925: goto -730 -> 195
    //   928: iload 8
    //   930: iconst_4
    //   931: iadd
    //   932: istore 8
    //   934: iload 8
    //   936: istore 6
    //   938: iload 16
    //   940: aload_1
    //   941: invokestatic 128	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   944: pop
    //   945: iload 8
    //   947: istore 6
    //   949: getstatic 62	com/tencent/image/JpegExifReader:BYTES_PER_FORMAT	[B
    //   952: iload 9
    //   954: baload
    //   955: istore 10
    //   957: iload 8
    //   959: istore 6
    //   961: aload_2
    //   962: aload_1
    //   963: iconst_0
    //   964: iconst_4
    //   965: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   968: iconst_4
    //   969: if_icmpeq +17 -> 986
    //   972: ldc -17
    //   974: astore_1
    //   975: iload 18
    //   977: istore 16
    //   979: iload 8
    //   981: istore 7
    //   983: goto -788 -> 195
    //   986: iload 8
    //   988: iconst_4
    //   989: iadd
    //   990: istore 8
    //   992: iload 8
    //   994: istore 6
    //   996: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   999: ifeq +33 -> 1032
    //   1002: iload 8
    //   1004: istore 6
    //   1006: ldc 42
    //   1008: iconst_2
    //   1009: new 102	java/lang/StringBuilder
    //   1012: dup
    //   1013: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   1016: ldc -15
    //   1018: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: iload 9
    //   1023: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1026: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1029: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1032: iload 8
    //   1034: istore 6
    //   1036: iload 9
    //   1038: iload 16
    //   1040: aload_1
    //   1041: invokestatic 243	com/tencent/image/JpegExifReader:getValue	(IZ[B)J
    //   1044: lstore 14
    //   1046: iload 7
    //   1048: i2l
    //   1049: lload 14
    //   1051: ladd
    //   1052: iload 8
    //   1054: i2l
    //   1055: lsub
    //   1056: lstore 14
    //   1058: iload 8
    //   1060: istore 6
    //   1062: aload_2
    //   1063: lload 14
    //   1065: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1068: lload 14
    //   1070: lcmp
    //   1071: ifeq +17 -> 1088
    //   1074: ldc -11
    //   1076: astore_1
    //   1077: iload 18
    //   1079: istore 16
    //   1081: iload 8
    //   1083: istore 7
    //   1085: goto -890 -> 195
    //   1088: iload 8
    //   1090: istore 6
    //   1092: aload_2
    //   1093: aload 4
    //   1095: iconst_0
    //   1096: iconst_2
    //   1097: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   1100: iconst_2
    //   1101: if_icmpeq +17 -> 1118
    //   1104: ldc -9
    //   1106: astore_1
    //   1107: iload 18
    //   1109: istore 16
    //   1111: iload 8
    //   1113: istore 7
    //   1115: goto -920 -> 195
    //   1118: iload 8
    //   1120: iconst_2
    //   1121: iadd
    //   1122: istore 8
    //   1124: iload 8
    //   1126: istore 6
    //   1128: iload 16
    //   1130: aload 4
    //   1132: invokestatic 122	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1135: istore 10
    //   1137: iconst_0
    //   1138: istore 9
    //   1140: iload 9
    //   1142: iload 10
    //   1144: if_icmpge +258 -> 1402
    //   1147: iload 8
    //   1149: istore 6
    //   1151: aload_2
    //   1152: aload 4
    //   1154: iconst_0
    //   1155: iconst_2
    //   1156: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   1159: iconst_2
    //   1160: if_icmpeq +17 -> 1177
    //   1163: ldc -7
    //   1165: astore_1
    //   1166: iload 18
    //   1168: istore 16
    //   1170: iload 8
    //   1172: istore 7
    //   1174: goto -979 -> 195
    //   1177: iload 8
    //   1179: iconst_2
    //   1180: iadd
    //   1181: istore 7
    //   1183: iload 7
    //   1185: istore 6
    //   1187: iload 16
    //   1189: aload 4
    //   1191: invokestatic 122	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1194: ldc 25
    //   1196: if_icmpne +177 -> 1373
    //   1199: iload 7
    //   1201: istore 6
    //   1203: aload_2
    //   1204: aload 4
    //   1206: iconst_0
    //   1207: iconst_2
    //   1208: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   1211: iconst_2
    //   1212: if_icmpeq +13 -> 1225
    //   1215: ldc -5
    //   1217: astore_1
    //   1218: iload 18
    //   1220: istore 16
    //   1222: goto -1027 -> 195
    //   1225: iload 7
    //   1227: iconst_2
    //   1228: iadd
    //   1229: istore 7
    //   1231: iload 7
    //   1233: istore 6
    //   1235: iload 16
    //   1237: aload 4
    //   1239: invokestatic 122	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1242: istore 11
    //   1244: iload 7
    //   1246: istore 6
    //   1248: aload_2
    //   1249: aload_1
    //   1250: iconst_0
    //   1251: iconst_4
    //   1252: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   1255: iconst_4
    //   1256: if_icmpeq +13 -> 1269
    //   1259: ldc -3
    //   1261: astore_1
    //   1262: iload 18
    //   1264: istore 16
    //   1266: goto -1071 -> 195
    //   1269: iload 7
    //   1271: iconst_4
    //   1272: iadd
    //   1273: istore 7
    //   1275: iload 7
    //   1277: istore 6
    //   1279: iload 16
    //   1281: aload_1
    //   1282: invokestatic 128	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1285: pop
    //   1286: iload 7
    //   1288: istore 6
    //   1290: getstatic 62	com/tencent/image/JpegExifReader:BYTES_PER_FORMAT	[B
    //   1293: iload 11
    //   1295: baload
    //   1296: istore 8
    //   1298: iload 7
    //   1300: istore 6
    //   1302: aload_2
    //   1303: aload_1
    //   1304: iconst_0
    //   1305: iconst_4
    //   1306: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   1309: iconst_4
    //   1310: if_icmpeq +13 -> 1323
    //   1313: ldc -1
    //   1315: astore_1
    //   1316: iload 18
    //   1318: istore 16
    //   1320: goto -1125 -> 195
    //   1323: iload 7
    //   1325: iconst_4
    //   1326: iadd
    //   1327: istore 7
    //   1329: iload 7
    //   1331: istore 6
    //   1333: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1336: ifeq +386 -> 1722
    //   1339: iload 7
    //   1341: istore 6
    //   1343: ldc 42
    //   1345: iconst_2
    //   1346: new 102	java/lang/StringBuilder
    //   1349: dup
    //   1350: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   1353: ldc_w 257
    //   1356: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: iload 11
    //   1361: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1364: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1367: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1370: goto +352 -> 1722
    //   1373: iload 7
    //   1375: istore 6
    //   1377: aload_2
    //   1378: ldc2_w 258
    //   1381: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1384: ldc2_w 258
    //   1387: lcmp
    //   1388: ifeq +353 -> 1741
    //   1391: ldc_w 261
    //   1394: astore_1
    //   1395: iload 18
    //   1397: istore 16
    //   1399: goto -1204 -> 195
    //   1402: aload_3
    //   1403: astore_1
    //   1404: iload 18
    //   1406: istore 16
    //   1408: iload 8
    //   1410: istore 7
    //   1412: iload 8
    //   1414: istore 6
    //   1416: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1419: ifeq -1224 -> 195
    //   1422: iload 8
    //   1424: istore 6
    //   1426: ldc 42
    //   1428: iconst_2
    //   1429: ldc_w 263
    //   1432: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1435: aload_3
    //   1436: astore_1
    //   1437: iload 18
    //   1439: istore 16
    //   1441: iload 8
    //   1443: istore 7
    //   1445: goto -1250 -> 195
    //   1448: astore 4
    //   1450: aload_2
    //   1451: astore_1
    //   1452: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1455: ifeq +15 -> 1470
    //   1458: aload_2
    //   1459: astore_1
    //   1460: ldc 42
    //   1462: iconst_2
    //   1463: ldc -105
    //   1465: aload 4
    //   1467: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1470: aload_3
    //   1471: astore_1
    //   1472: iload 17
    //   1474: istore 16
    //   1476: iload 6
    //   1478: istore 7
    //   1480: aload_2
    //   1481: ifnull -1278 -> 203
    //   1484: aload_2
    //   1485: invokevirtual 173	java/io/BufferedInputStream:close	()V
    //   1488: aload_3
    //   1489: astore_1
    //   1490: iload 17
    //   1492: istore 16
    //   1494: iload 6
    //   1496: istore 7
    //   1498: goto -1295 -> 203
    //   1501: astore_2
    //   1502: aload_3
    //   1503: astore_1
    //   1504: iload 17
    //   1506: istore 16
    //   1508: iload 6
    //   1510: istore 7
    //   1512: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1515: ifeq -1312 -> 203
    //   1518: ldc 42
    //   1520: iconst_2
    //   1521: ldc -105
    //   1523: aload_2
    //   1524: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1527: aload_3
    //   1528: astore_1
    //   1529: iload 17
    //   1531: istore 16
    //   1533: iload 6
    //   1535: istore 7
    //   1537: goto -1334 -> 203
    //   1540: iload 8
    //   1542: istore 6
    //   1544: aload_2
    //   1545: ldc2_w 258
    //   1548: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1551: ldc2_w 258
    //   1554: lcmp
    //   1555: ifeq +202 -> 1757
    //   1558: ldc_w 261
    //   1561: astore_1
    //   1562: iload 18
    //   1564: istore 16
    //   1566: iload 8
    //   1568: istore 7
    //   1570: goto -1375 -> 195
    //   1573: aload_3
    //   1574: astore_1
    //   1575: iload 18
    //   1577: istore 16
    //   1579: iload 8
    //   1581: istore 7
    //   1583: iload 8
    //   1585: istore 6
    //   1587: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1590: ifeq -1395 -> 195
    //   1593: iload 8
    //   1595: istore 6
    //   1597: ldc 42
    //   1599: iconst_2
    //   1600: ldc_w 268
    //   1603: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1606: aload_3
    //   1607: astore_1
    //   1608: iload 18
    //   1610: istore 16
    //   1612: iload 8
    //   1614: istore 7
    //   1616: goto -1421 -> 195
    //   1619: astore_0
    //   1620: aload_2
    //   1621: astore_1
    //   1622: aload_1
    //   1623: ifnull +7 -> 1630
    //   1626: aload_1
    //   1627: invokevirtual 173	java/io/BufferedInputStream:close	()V
    //   1630: aload_0
    //   1631: athrow
    //   1632: astore_2
    //   1633: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1636: ifeq +12 -> 1648
    //   1639: ldc 42
    //   1641: iconst_2
    //   1642: ldc -105
    //   1644: aload_2
    //   1645: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1648: goto -1445 -> 203
    //   1651: astore_1
    //   1652: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1655: ifeq -25 -> 1630
    //   1658: ldc 42
    //   1660: iconst_2
    //   1661: ldc -105
    //   1663: aload_1
    //   1664: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1667: goto -37 -> 1630
    //   1670: astore_0
    //   1671: goto -49 -> 1622
    //   1674: astore_1
    //   1675: aload 4
    //   1677: astore_2
    //   1678: aload_1
    //   1679: astore 4
    //   1681: goto -231 -> 1450
    //   1684: goto -1481 -> 203
    //   1687: ldc_w 270
    //   1690: astore_1
    //   1691: iload 18
    //   1693: istore 16
    //   1695: goto -1500 -> 195
    //   1698: iload 8
    //   1700: iconst_m1
    //   1701: if_icmpne +10 -> 1711
    //   1704: iload 9
    //   1706: bipush -31
    //   1708: if_icmpeq -1312 -> 396
    //   1711: ldc_w 272
    //   1714: astore_1
    //   1715: iload 18
    //   1717: istore 16
    //   1719: goto -1524 -> 195
    //   1722: iload 7
    //   1724: istore 8
    //   1726: iload 11
    //   1728: bipush 12
    //   1730: if_icmpne +18 -> 1748
    //   1733: iconst_1
    //   1734: istore 16
    //   1736: aload_3
    //   1737: astore_1
    //   1738: goto -1543 -> 195
    //   1741: iload 7
    //   1743: bipush 10
    //   1745: iadd
    //   1746: istore 8
    //   1748: iload 9
    //   1750: iconst_1
    //   1751: iadd
    //   1752: istore 9
    //   1754: goto -614 -> 1140
    //   1757: iload 8
    //   1759: bipush 10
    //   1761: iadd
    //   1762: istore 8
    //   1764: iload 9
    //   1766: iconst_1
    //   1767: iadd
    //   1768: istore 9
    //   1770: goto -979 -> 791
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1773	0	paramString	String
    //   26	1601	1	localObject1	Object
    //   1651	13	1	localIOException1	IOException
    //   1674	5	1	localThrowable1	Throwable
    //   1690	48	1	localObject2	Object
    //   57	1428	2	localBufferedInputStream	java.io.BufferedInputStream
    //   1501	120	2	localIOException2	IOException
    //   1632	13	2	localIOException3	IOException
    //   1677	1	2	localThrowable2	Throwable
    //   38	1699	3	str1	String
    //   28	1210	4	arrayOfByte	byte[]
    //   1448	228	4	localThrowable3	Throwable
    //   1679	1	4	localThrowable4	Throwable
    //   536	88	5	str2	String
    //   31	1565	6	i	int
    //   34	1712	7	j	int
    //   59	1704	8	k	int
    //   120	1649	9	m	int
    //   353	792	10	n	int
    //   1242	489	11	i1	int
    //   17	239	12	l1	long
    //   206	863	14	l2	long
    //   126	1609	16	bool1	boolean
    //   9	1521	17	bool2	boolean
    //   23	1693	18	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   65	70	1448	java/lang/Throwable
    //   74	86	1448	java/lang/Throwable
    //   141	145	1448	java/lang/Throwable
    //   149	160	1448	java/lang/Throwable
    //   170	181	1448	java/lang/Throwable
    //   304	316	1448	java/lang/Throwable
    //   372	386	1448	java/lang/Throwable
    //   400	411	1448	java/lang/Throwable
    //   431	447	1448	java/lang/Throwable
    //   461	475	1448	java/lang/Throwable
    //   495	507	1448	java/lang/Throwable
    //   527	538	1448	java/lang/Throwable
    //   542	552	1448	java/lang/Throwable
    //   559	573	1448	java/lang/Throwable
    //   591	601	1448	java/lang/Throwable
    //   611	637	1448	java/lang/Throwable
    //   652	663	1448	java/lang/Throwable
    //   688	699	1448	java/lang/Throwable
    //   708	722	1448	java/lang/Throwable
    //   740	752	1448	java/lang/Throwable
    //   779	788	1448	java/lang/Throwable
    //   802	814	1448	java/lang/Throwable
    //   838	850	1448	java/lang/Throwable
    //   854	866	1448	java/lang/Throwable
    //   890	899	1448	java/lang/Throwable
    //   903	914	1448	java/lang/Throwable
    //   938	945	1448	java/lang/Throwable
    //   949	957	1448	java/lang/Throwable
    //   961	972	1448	java/lang/Throwable
    //   996	1002	1448	java/lang/Throwable
    //   1006	1032	1448	java/lang/Throwable
    //   1036	1046	1448	java/lang/Throwable
    //   1062	1074	1448	java/lang/Throwable
    //   1092	1104	1448	java/lang/Throwable
    //   1128	1137	1448	java/lang/Throwable
    //   1151	1163	1448	java/lang/Throwable
    //   1187	1199	1448	java/lang/Throwable
    //   1203	1215	1448	java/lang/Throwable
    //   1235	1244	1448	java/lang/Throwable
    //   1248	1259	1448	java/lang/Throwable
    //   1279	1286	1448	java/lang/Throwable
    //   1290	1298	1448	java/lang/Throwable
    //   1302	1313	1448	java/lang/Throwable
    //   1333	1339	1448	java/lang/Throwable
    //   1343	1370	1448	java/lang/Throwable
    //   1377	1391	1448	java/lang/Throwable
    //   1416	1422	1448	java/lang/Throwable
    //   1426	1435	1448	java/lang/Throwable
    //   1544	1558	1448	java/lang/Throwable
    //   1587	1593	1448	java/lang/Throwable
    //   1597	1606	1448	java/lang/Throwable
    //   1484	1488	1501	java/io/IOException
    //   65	70	1619	finally
    //   74	86	1619	finally
    //   141	145	1619	finally
    //   149	160	1619	finally
    //   170	181	1619	finally
    //   304	316	1619	finally
    //   372	386	1619	finally
    //   400	411	1619	finally
    //   431	447	1619	finally
    //   461	475	1619	finally
    //   495	507	1619	finally
    //   527	538	1619	finally
    //   542	552	1619	finally
    //   559	573	1619	finally
    //   591	601	1619	finally
    //   611	637	1619	finally
    //   652	663	1619	finally
    //   688	699	1619	finally
    //   708	722	1619	finally
    //   740	752	1619	finally
    //   779	788	1619	finally
    //   802	814	1619	finally
    //   838	850	1619	finally
    //   854	866	1619	finally
    //   890	899	1619	finally
    //   903	914	1619	finally
    //   938	945	1619	finally
    //   949	957	1619	finally
    //   961	972	1619	finally
    //   996	1002	1619	finally
    //   1006	1032	1619	finally
    //   1036	1046	1619	finally
    //   1062	1074	1619	finally
    //   1092	1104	1619	finally
    //   1128	1137	1619	finally
    //   1151	1163	1619	finally
    //   1187	1199	1619	finally
    //   1203	1215	1619	finally
    //   1235	1244	1619	finally
    //   1248	1259	1619	finally
    //   1279	1286	1619	finally
    //   1290	1298	1619	finally
    //   1302	1313	1619	finally
    //   1333	1339	1619	finally
    //   1343	1370	1619	finally
    //   1377	1391	1619	finally
    //   1416	1422	1619	finally
    //   1426	1435	1619	finally
    //   1544	1558	1619	finally
    //   1587	1593	1619	finally
    //   1597	1606	1619	finally
    //   199	203	1632	java/io/IOException
    //   1626	1630	1651	java/io/IOException
    //   39	58	1670	finally
    //   1452	1458	1670	finally
    //   1460	1470	1670	finally
    //   39	58	1674	java/lang/Throwable
  }
  
  /* Error */
  public static int readOrientation(String paramString)
  {
    // Byte code:
    //   0: invokestatic 149	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 16
    //   5: iconst_1
    //   6: istore 13
    //   8: iconst_1
    //   9: istore 10
    //   11: iconst_1
    //   12: istore 14
    //   14: iconst_1
    //   15: istore 15
    //   17: getstatic 55	com/tencent/image/JpegExifReader:sIsReadDpc	Z
    //   20: ifne +24 -> 44
    //   23: getstatic 132	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   26: ifnull +18 -> 44
    //   29: getstatic 132	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   32: invokeinterface 275 1 0
    //   37: putstatic 53	com/tencent/image/JpegExifReader:sIsEnable	Z
    //   40: iconst_1
    //   41: putstatic 55	com/tencent/image/JpegExifReader:sIsReadDpc	Z
    //   44: getstatic 53	com/tencent/image/JpegExifReader:sIsEnable	Z
    //   47: ifne +53 -> 100
    //   50: aconst_null
    //   51: astore_1
    //   52: new 277	android/media/ExifInterface
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 278	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   60: astore_0
    //   61: aload_0
    //   62: ifnonnull +29 -> 91
    //   65: iconst_0
    //   66: ireturn
    //   67: astore_2
    //   68: aload_1
    //   69: astore_0
    //   70: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq -12 -> 61
    //   76: ldc 42
    //   78: iconst_2
    //   79: ldc_w 280
    //   82: aload_2
    //   83: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   86: aload_1
    //   87: astore_0
    //   88: goto -27 -> 61
    //   91: aload_0
    //   92: ldc_w 282
    //   95: iconst_1
    //   96: invokevirtual 286	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
    //   99: ireturn
    //   100: aconst_null
    //   101: astore_1
    //   102: aconst_null
    //   103: astore_3
    //   104: iconst_0
    //   105: istore 7
    //   107: iconst_0
    //   108: istore 8
    //   110: ldc -105
    //   112: astore_2
    //   113: new 153	java/io/BufferedInputStream
    //   116: dup
    //   117: new 155	java/io/FileInputStream
    //   120: dup
    //   121: aload_0
    //   122: invokespecial 158	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   125: sipush 512
    //   128: invokespecial 161	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   131: astore 5
    //   133: iconst_0
    //   134: istore 9
    //   136: aload_2
    //   137: astore_3
    //   138: iload 8
    //   140: istore 7
    //   142: iload 13
    //   144: istore 10
    //   146: iconst_2
    //   147: newarray <illegal type>
    //   149: astore 6
    //   151: aload_2
    //   152: astore_3
    //   153: iload 8
    //   155: istore 7
    //   157: iload 13
    //   159: istore 10
    //   161: aload 5
    //   163: aload 6
    //   165: iconst_0
    //   166: iconst_2
    //   167: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   170: iconst_2
    //   171: if_icmpne +34 -> 205
    //   174: aload 6
    //   176: iconst_0
    //   177: baload
    //   178: sipush 255
    //   181: iand
    //   182: sipush 255
    //   185: if_icmpne +236 -> 421
    //   188: aload 6
    //   190: iconst_1
    //   191: baload
    //   192: sipush 255
    //   195: iand
    //   196: sipush 216
    //   199: if_icmpne +222 -> 421
    //   202: iconst_1
    //   203: istore 9
    //   205: iconst_0
    //   206: iconst_2
    //   207: iadd
    //   208: istore 12
    //   210: aload_2
    //   211: astore_1
    //   212: iload 12
    //   214: istore 8
    //   216: iload 15
    //   218: istore 11
    //   220: iload 9
    //   222: ifeq +81 -> 303
    //   225: aload_2
    //   226: astore_3
    //   227: iload 12
    //   229: istore 7
    //   231: iload 13
    //   233: istore 10
    //   235: iconst_4
    //   236: newarray <illegal type>
    //   238: astore_1
    //   239: aload_2
    //   240: astore_3
    //   241: iload 12
    //   243: istore 7
    //   245: iload 13
    //   247: istore 10
    //   249: aload 5
    //   251: invokevirtual 168	java/io/BufferedInputStream:read	()I
    //   254: sipush 255
    //   257: iand
    //   258: i2b
    //   259: istore 9
    //   261: iload 12
    //   263: iconst_1
    //   264: iadd
    //   265: istore 8
    //   267: aload_2
    //   268: astore_3
    //   269: iload 8
    //   271: istore 7
    //   273: iload 13
    //   275: istore 10
    //   277: aload 5
    //   279: invokevirtual 168	java/io/BufferedInputStream:read	()I
    //   282: sipush 255
    //   285: iand
    //   286: i2b
    //   287: istore 11
    //   289: iload 11
    //   291: bipush -38
    //   293: if_icmpne +134 -> 427
    //   296: ldc -86
    //   298: astore_1
    //   299: iload 15
    //   301: istore 11
    //   303: aload 5
    //   305: ifnull +1453 -> 1758
    //   308: aload 5
    //   310: invokevirtual 173	java/io/BufferedInputStream:close	()V
    //   313: invokestatic 149	android/os/SystemClock:uptimeMillis	()J
    //   316: lload 16
    //   318: lsub
    //   319: lstore 16
    //   321: getstatic 132	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   324: ifnull +22 -> 346
    //   327: getstatic 132	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   330: aconst_null
    //   331: ldc 35
    //   333: iconst_1
    //   334: lload 16
    //   336: iload 8
    //   338: i2l
    //   339: aconst_null
    //   340: aconst_null
    //   341: invokeinterface 290 10 0
    //   346: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq +69 -> 418
    //   352: ldc 42
    //   354: iconst_2
    //   355: new 102	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   362: ldc_w 292
    //   365: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: iload 11
    //   370: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   373: ldc -76
    //   375: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: iload 8
    //   380: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   383: ldc -74
    //   385: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: lload 16
    //   390: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   393: ldc -69
    //   395: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload_0
    //   399: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: ldc_w 294
    //   405: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload_1
    //   409: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: iload 11
    //   420: ireturn
    //   421: iconst_0
    //   422: istore 9
    //   424: goto -219 -> 205
    //   427: iload 8
    //   429: iconst_1
    //   430: iadd
    //   431: istore 8
    //   433: aload_2
    //   434: astore_3
    //   435: iload 8
    //   437: istore 7
    //   439: iload 13
    //   441: istore 10
    //   443: aload 5
    //   445: aload 6
    //   447: iconst_0
    //   448: iconst_2
    //   449: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   452: iconst_2
    //   453: if_icmpeq +13 -> 466
    //   456: ldc -62
    //   458: astore_1
    //   459: iload 15
    //   461: istore 11
    //   463: goto -160 -> 303
    //   466: iload 8
    //   468: iconst_2
    //   469: iadd
    //   470: istore 8
    //   472: aload 6
    //   474: iconst_0
    //   475: baload
    //   476: bipush 8
    //   478: ishl
    //   479: ldc 69
    //   481: iand
    //   482: aload 6
    //   484: iconst_1
    //   485: baload
    //   486: sipush 255
    //   489: iand
    //   490: ior
    //   491: iconst_2
    //   492: isub
    //   493: istore 12
    //   495: iload 9
    //   497: iconst_m1
    //   498: if_icmpne +1274 -> 1772
    //   501: iload 11
    //   503: bipush -32
    //   505: if_icmpne +1267 -> 1772
    //   508: aload_2
    //   509: astore_3
    //   510: iload 8
    //   512: istore 7
    //   514: iload 13
    //   516: istore 10
    //   518: aload 5
    //   520: iload 12
    //   522: i2l
    //   523: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   526: iload 12
    //   528: i2l
    //   529: lcmp
    //   530: ifne +1231 -> 1761
    //   533: iload 8
    //   535: iload 12
    //   537: iadd
    //   538: istore 12
    //   540: goto -301 -> 239
    //   543: aload_2
    //   544: astore_3
    //   545: iload 8
    //   547: istore 7
    //   549: iload 13
    //   551: istore 10
    //   553: aload 5
    //   555: aload_1
    //   556: iconst_0
    //   557: iconst_4
    //   558: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   561: iconst_4
    //   562: if_icmpeq +13 -> 575
    //   565: ldc -56
    //   567: astore_1
    //   568: iload 15
    //   570: istore 11
    //   572: goto -269 -> 303
    //   575: aload_2
    //   576: astore_3
    //   577: iload 8
    //   579: istore 7
    //   581: iload 13
    //   583: istore 10
    //   585: ldc 23
    //   587: new 202	java/lang/String
    //   590: dup
    //   591: aload_1
    //   592: invokespecial 205	java/lang/String:<init>	([B)V
    //   595: invokevirtual 208	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   598: ifne +13 -> 611
    //   601: ldc -46
    //   603: astore_1
    //   604: iload 15
    //   606: istore 11
    //   608: goto -305 -> 303
    //   611: aload_2
    //   612: astore_3
    //   613: iload 8
    //   615: istore 7
    //   617: iload 13
    //   619: istore 10
    //   621: aload 5
    //   623: ldc2_w 211
    //   626: invokevirtual 215	java/io/BufferedInputStream:skip	(J)J
    //   629: ldc2_w 211
    //   632: lcmp
    //   633: ifeq +13 -> 646
    //   636: ldc -39
    //   638: astore_1
    //   639: iload 15
    //   641: istore 11
    //   643: goto -340 -> 303
    //   646: iload 8
    //   648: iconst_2
    //   649: iadd
    //   650: istore 8
    //   652: aload_2
    //   653: astore_3
    //   654: iload 8
    //   656: istore 7
    //   658: iload 13
    //   660: istore 10
    //   662: aload 5
    //   664: aload 6
    //   666: iconst_0
    //   667: iconst_2
    //   668: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   671: iconst_2
    //   672: if_icmpeq +13 -> 685
    //   675: ldc -37
    //   677: astore_1
    //   678: iload 15
    //   680: istore 11
    //   682: goto -379 -> 303
    //   685: iload 8
    //   687: iconst_2
    //   688: iadd
    //   689: istore 8
    //   691: aload_2
    //   692: astore_3
    //   693: iload 8
    //   695: istore 7
    //   697: iload 13
    //   699: istore 10
    //   701: new 202	java/lang/String
    //   704: dup
    //   705: aload 6
    //   707: invokespecial 205	java/lang/String:<init>	([B)V
    //   710: astore 4
    //   712: aload_2
    //   713: astore_3
    //   714: iload 8
    //   716: istore 7
    //   718: iload 13
    //   720: istore 10
    //   722: ldc 11
    //   724: aload 4
    //   726: invokevirtual 208	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   729: ifeq +41 -> 770
    //   732: iconst_1
    //   733: istore 18
    //   735: aload_2
    //   736: astore_3
    //   737: iload 8
    //   739: istore 7
    //   741: iload 13
    //   743: istore 10
    //   745: aload 5
    //   747: ldc2_w 211
    //   750: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   753: ldc2_w 211
    //   756: lcmp
    //   757: ifeq +82 -> 839
    //   760: ldc -35
    //   762: astore_1
    //   763: iload 15
    //   765: istore 11
    //   767: goto -464 -> 303
    //   770: aload_2
    //   771: astore_3
    //   772: iload 8
    //   774: istore 7
    //   776: iload 13
    //   778: istore 10
    //   780: ldc 30
    //   782: aload 4
    //   784: invokevirtual 208	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   787: ifeq +9 -> 796
    //   790: iconst_0
    //   791: istore 18
    //   793: goto -58 -> 735
    //   796: aload_2
    //   797: astore_3
    //   798: iload 8
    //   800: istore 7
    //   802: iload 13
    //   804: istore 10
    //   806: new 102	java/lang/StringBuilder
    //   809: dup
    //   810: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   813: ldc -33
    //   815: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: aload 4
    //   820: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: ldc -31
    //   825: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: astore_1
    //   832: iload 15
    //   834: istore 11
    //   836: goto -533 -> 303
    //   839: aload_2
    //   840: astore_3
    //   841: iload 8
    //   843: istore 7
    //   845: iload 13
    //   847: istore 10
    //   849: aload 5
    //   851: aload_1
    //   852: iconst_0
    //   853: iconst_4
    //   854: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   857: iconst_4
    //   858: if_icmpeq +13 -> 871
    //   861: ldc -29
    //   863: astore_1
    //   864: iload 15
    //   866: istore 11
    //   868: goto -565 -> 303
    //   871: iload 8
    //   873: bipush 6
    //   875: iadd
    //   876: istore 8
    //   878: aload_2
    //   879: astore_3
    //   880: iload 8
    //   882: istore 7
    //   884: iload 13
    //   886: istore 10
    //   888: iload 18
    //   890: aload_1
    //   891: invokestatic 128	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   894: bipush 8
    //   896: isub
    //   897: istore 9
    //   899: iload 9
    //   901: ifle +38 -> 939
    //   904: aload_2
    //   905: astore_3
    //   906: iload 8
    //   908: istore 7
    //   910: iload 13
    //   912: istore 10
    //   914: aload 5
    //   916: iload 9
    //   918: i2l
    //   919: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   922: iload 9
    //   924: i2l
    //   925: lcmp
    //   926: ifeq +13 -> 939
    //   929: ldc -27
    //   931: astore_1
    //   932: iload 15
    //   934: istore 11
    //   936: goto -633 -> 303
    //   939: aload_2
    //   940: astore_3
    //   941: iload 8
    //   943: istore 7
    //   945: iload 13
    //   947: istore 10
    //   949: aload 5
    //   951: aload 6
    //   953: iconst_0
    //   954: iconst_2
    //   955: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   958: iconst_2
    //   959: if_icmpeq +13 -> 972
    //   962: ldc -25
    //   964: astore_1
    //   965: iload 15
    //   967: istore 11
    //   969: goto -666 -> 303
    //   972: iload 8
    //   974: iload 9
    //   976: iconst_2
    //   977: iadd
    //   978: iadd
    //   979: istore 8
    //   981: aload_2
    //   982: astore_3
    //   983: iload 8
    //   985: istore 7
    //   987: iload 13
    //   989: istore 10
    //   991: iload 18
    //   993: aload 6
    //   995: invokestatic 122	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   998: istore 12
    //   1000: iconst_0
    //   1001: istore 11
    //   1003: aload_2
    //   1004: astore 4
    //   1006: iload 8
    //   1008: istore 9
    //   1010: iload 11
    //   1012: iload 12
    //   1014: if_icmpge +242 -> 1256
    //   1017: aload_2
    //   1018: astore_3
    //   1019: iload 8
    //   1021: istore 7
    //   1023: iload 13
    //   1025: istore 10
    //   1027: aload 5
    //   1029: aload 6
    //   1031: iconst_0
    //   1032: iconst_2
    //   1033: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   1036: iconst_2
    //   1037: if_icmpeq +14 -> 1051
    //   1040: ldc_w 296
    //   1043: astore_1
    //   1044: iload 15
    //   1046: istore 11
    //   1048: goto -745 -> 303
    //   1051: iload 8
    //   1053: iconst_2
    //   1054: iadd
    //   1055: istore 8
    //   1057: aload_2
    //   1058: astore_3
    //   1059: iload 8
    //   1061: istore 7
    //   1063: iload 13
    //   1065: istore 10
    //   1067: iload 18
    //   1069: aload 6
    //   1071: invokestatic 122	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1074: sipush 274
    //   1077: if_icmpne +582 -> 1659
    //   1080: aload_2
    //   1081: astore_3
    //   1082: iload 8
    //   1084: istore 7
    //   1086: iload 13
    //   1088: istore 10
    //   1090: aload 5
    //   1092: aload 6
    //   1094: iconst_0
    //   1095: iconst_2
    //   1096: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   1099: iconst_2
    //   1100: if_icmpeq +14 -> 1114
    //   1103: ldc_w 298
    //   1106: astore_1
    //   1107: iload 15
    //   1109: istore 11
    //   1111: goto -808 -> 303
    //   1114: iload 8
    //   1116: iconst_2
    //   1117: iadd
    //   1118: istore 8
    //   1120: aload_2
    //   1121: astore_3
    //   1122: iload 8
    //   1124: istore 7
    //   1126: iload 13
    //   1128: istore 10
    //   1130: iload 18
    //   1132: aload 6
    //   1134: invokestatic 122	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1137: istore 9
    //   1139: aload_2
    //   1140: astore_3
    //   1141: iload 8
    //   1143: istore 7
    //   1145: iload 13
    //   1147: istore 10
    //   1149: aload 5
    //   1151: aload_1
    //   1152: iconst_0
    //   1153: iconst_4
    //   1154: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   1157: iconst_4
    //   1158: if_icmpeq +13 -> 1171
    //   1161: ldc -19
    //   1163: astore_1
    //   1164: iload 15
    //   1166: istore 11
    //   1168: goto -865 -> 303
    //   1171: iload 8
    //   1173: iconst_4
    //   1174: iadd
    //   1175: istore 8
    //   1177: aload_2
    //   1178: astore_3
    //   1179: iload 8
    //   1181: istore 7
    //   1183: iload 13
    //   1185: istore 10
    //   1187: iload 18
    //   1189: aload_1
    //   1190: invokestatic 128	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1193: getstatic 62	com/tencent/image/JpegExifReader:BYTES_PER_FORMAT	[B
    //   1196: iload 9
    //   1198: baload
    //   1199: imul
    //   1200: istore 11
    //   1202: iload 11
    //   1204: iconst_4
    //   1205: if_icmple +210 -> 1415
    //   1208: aload_2
    //   1209: astore_3
    //   1210: iload 8
    //   1212: istore 7
    //   1214: iload 13
    //   1216: istore 10
    //   1218: new 102	java/lang/StringBuilder
    //   1221: dup
    //   1222: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   1225: ldc_w 300
    //   1228: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: iload 9
    //   1233: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1236: ldc_w 302
    //   1239: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1242: iload 11
    //   1244: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1247: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1250: astore 4
    //   1252: iload 8
    //   1254: istore 9
    //   1256: aload 4
    //   1258: astore_1
    //   1259: iload 9
    //   1261: istore 8
    //   1263: iload 15
    //   1265: istore 11
    //   1267: aload 4
    //   1269: astore_3
    //   1270: iload 9
    //   1272: istore 7
    //   1274: iload 13
    //   1276: istore 10
    //   1278: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1281: ifeq -978 -> 303
    //   1284: aload 4
    //   1286: astore_3
    //   1287: iload 9
    //   1289: istore 7
    //   1291: iload 13
    //   1293: istore 10
    //   1295: ldc 42
    //   1297: iconst_2
    //   1298: ldc_w 268
    //   1301: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1304: aload 4
    //   1306: astore_1
    //   1307: iload 9
    //   1309: istore 8
    //   1311: iload 15
    //   1313: istore 11
    //   1315: goto -1012 -> 303
    //   1318: astore 4
    //   1320: aload_3
    //   1321: astore_2
    //   1322: aload 5
    //   1324: astore_3
    //   1325: aload_3
    //   1326: astore_1
    //   1327: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1330: ifeq +15 -> 1345
    //   1333: aload_3
    //   1334: astore_1
    //   1335: ldc 42
    //   1337: iconst_2
    //   1338: ldc -105
    //   1340: aload 4
    //   1342: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1345: aload_2
    //   1346: astore_1
    //   1347: iload 7
    //   1349: istore 8
    //   1351: iload 10
    //   1353: istore 11
    //   1355: aload_3
    //   1356: ifnull -1043 -> 313
    //   1359: aload_3
    //   1360: invokevirtual 173	java/io/BufferedInputStream:close	()V
    //   1363: aload_2
    //   1364: astore_1
    //   1365: iload 7
    //   1367: istore 8
    //   1369: iload 10
    //   1371: istore 11
    //   1373: goto -1060 -> 313
    //   1376: astore_3
    //   1377: aload_2
    //   1378: astore_1
    //   1379: iload 7
    //   1381: istore 8
    //   1383: iload 10
    //   1385: istore 11
    //   1387: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1390: ifeq -1077 -> 313
    //   1393: ldc 42
    //   1395: iconst_2
    //   1396: ldc -105
    //   1398: aload_3
    //   1399: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1402: aload_2
    //   1403: astore_1
    //   1404: iload 7
    //   1406: istore 8
    //   1408: iload 10
    //   1410: istore 11
    //   1412: goto -1099 -> 313
    //   1415: aload_2
    //   1416: astore_3
    //   1417: iload 8
    //   1419: istore 7
    //   1421: iload 13
    //   1423: istore 10
    //   1425: aload 5
    //   1427: aload_1
    //   1428: iconst_0
    //   1429: iconst_4
    //   1430: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   1433: iconst_4
    //   1434: if_icmpeq +362 -> 1796
    //   1437: ldc_w 304
    //   1440: astore_1
    //   1441: iload 15
    //   1443: istore 11
    //   1445: goto -1142 -> 303
    //   1448: aload_2
    //   1449: astore_3
    //   1450: iload 12
    //   1452: istore 7
    //   1454: iload 13
    //   1456: istore 10
    //   1458: new 102	java/lang/StringBuilder
    //   1461: dup
    //   1462: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   1465: ldc_w 306
    //   1468: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1471: iload 9
    //   1473: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1476: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1479: astore_2
    //   1480: iload 14
    //   1482: istore 9
    //   1484: aload_2
    //   1485: astore_1
    //   1486: iload 12
    //   1488: istore 8
    //   1490: iload 9
    //   1492: istore 11
    //   1494: aload_2
    //   1495: astore_3
    //   1496: iload 12
    //   1498: istore 7
    //   1500: iload 9
    //   1502: istore 10
    //   1504: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1507: ifeq -1204 -> 303
    //   1510: aload_2
    //   1511: astore_3
    //   1512: iload 12
    //   1514: istore 7
    //   1516: iload 9
    //   1518: istore 10
    //   1520: ldc 42
    //   1522: iconst_2
    //   1523: new 102	java/lang/StringBuilder
    //   1526: dup
    //   1527: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   1530: ldc_w 308
    //   1533: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1536: iload 9
    //   1538: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1541: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1544: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1547: aload_2
    //   1548: astore_1
    //   1549: iload 12
    //   1551: istore 8
    //   1553: iload 9
    //   1555: istore 11
    //   1557: goto -1254 -> 303
    //   1560: astore_0
    //   1561: aload 5
    //   1563: astore_1
    //   1564: aload_1
    //   1565: ifnull +7 -> 1572
    //   1568: aload_1
    //   1569: invokevirtual 173	java/io/BufferedInputStream:close	()V
    //   1572: aload_0
    //   1573: athrow
    //   1574: aload_2
    //   1575: astore_3
    //   1576: iload 12
    //   1578: istore 7
    //   1580: iload 13
    //   1582: istore 10
    //   1584: iload 18
    //   1586: aload_1
    //   1587: invokestatic 122	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1590: istore 9
    //   1592: goto -108 -> 1484
    //   1595: aload_2
    //   1596: astore_3
    //   1597: iload 12
    //   1599: istore 7
    //   1601: iload 13
    //   1603: istore 10
    //   1605: iload 18
    //   1607: aload_1
    //   1608: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt32	(Z[B)J
    //   1611: l2i
    //   1612: istore 9
    //   1614: goto -130 -> 1484
    //   1617: aload_2
    //   1618: astore_3
    //   1619: iload 12
    //   1621: istore 7
    //   1623: iload 13
    //   1625: istore 10
    //   1627: iload 18
    //   1629: aload_1
    //   1630: invokestatic 126	com/tencent/image/JpegExifReader:getInt16	(Z[B)S
    //   1633: istore 9
    //   1635: goto -151 -> 1484
    //   1638: aload_2
    //   1639: astore_3
    //   1640: iload 12
    //   1642: istore 7
    //   1644: iload 13
    //   1646: istore 10
    //   1648: iload 18
    //   1650: aload_1
    //   1651: invokestatic 128	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1654: istore 9
    //   1656: goto -172 -> 1484
    //   1659: aload_2
    //   1660: astore_3
    //   1661: iload 8
    //   1663: istore 7
    //   1665: iload 13
    //   1667: istore 10
    //   1669: aload 5
    //   1671: ldc2_w 258
    //   1674: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1677: ldc2_w 258
    //   1680: lcmp
    //   1681: ifeq +14 -> 1695
    //   1684: ldc_w 261
    //   1687: astore_1
    //   1688: iload 15
    //   1690: istore 11
    //   1692: goto -1389 -> 303
    //   1695: iload 8
    //   1697: bipush 10
    //   1699: iadd
    //   1700: istore 8
    //   1702: iload 11
    //   1704: iconst_1
    //   1705: iadd
    //   1706: istore 11
    //   1708: goto -705 -> 1003
    //   1711: astore_2
    //   1712: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1715: ifeq +12 -> 1727
    //   1718: ldc 42
    //   1720: iconst_2
    //   1721: ldc -105
    //   1723: aload_2
    //   1724: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1727: goto -1414 -> 313
    //   1730: astore_1
    //   1731: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1734: ifeq -162 -> 1572
    //   1737: ldc 42
    //   1739: iconst_2
    //   1740: ldc -105
    //   1742: aload_1
    //   1743: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1746: goto -174 -> 1572
    //   1749: astore_0
    //   1750: goto -186 -> 1564
    //   1753: astore 4
    //   1755: goto -430 -> 1325
    //   1758: goto -1445 -> 313
    //   1761: ldc_w 270
    //   1764: astore_1
    //   1765: iload 15
    //   1767: istore 11
    //   1769: goto -1466 -> 303
    //   1772: iload 9
    //   1774: iconst_m1
    //   1775: if_icmpne +10 -> 1785
    //   1778: iload 11
    //   1780: bipush -31
    //   1782: if_icmpeq -1239 -> 543
    //   1785: ldc_w 272
    //   1788: astore_1
    //   1789: iload 15
    //   1791: istore 11
    //   1793: goto -1490 -> 303
    //   1796: iload 8
    //   1798: iconst_4
    //   1799: iadd
    //   1800: istore 12
    //   1802: iload 9
    //   1804: tableswitch	default:+44->1848, 3:+-230->1574, 4:+-209->1595, 5:+-356->1448, 6:+47->1851, 7:+-356->1448, 8:+-187->1617, 9:+-166->1638
    //   1848: goto -400 -> 1448
    //   1851: aload_1
    //   1852: iconst_0
    //   1853: baload
    //   1854: istore 9
    //   1856: goto -372 -> 1484
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1859	0	paramString	String
    //   51	1637	1	localObject1	Object
    //   1730	13	1	localIOException1	IOException
    //   1764	88	1	str	String
    //   67	16	2	localIOException2	IOException
    //   112	1548	2	localObject2	Object
    //   1711	13	2	localIOException3	IOException
    //   103	1257	3	localObject3	Object
    //   1376	23	3	localIOException4	IOException
    //   1416	245	3	localObject4	Object
    //   710	595	4	localObject5	Object
    //   1318	23	4	localThrowable1	Throwable
    //   1753	1	4	localThrowable2	Throwable
    //   131	1539	5	localBufferedInputStream	java.io.BufferedInputStream
    //   149	984	6	arrayOfByte	byte[]
    //   105	1559	7	i	int
    //   108	1692	8	j	int
    //   134	1721	9	k	int
    //   9	1659	10	m	int
    //   218	1574	11	n	int
    //   208	1593	12	i1	int
    //   6	1660	13	i2	int
    //   12	1469	14	i3	int
    //   15	1775	15	i4	int
    //   3	386	16	l	long
    //   733	916	18	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   52	61	67	java/io/IOException
    //   146	151	1318	java/lang/Throwable
    //   161	174	1318	java/lang/Throwable
    //   235	239	1318	java/lang/Throwable
    //   249	261	1318	java/lang/Throwable
    //   277	289	1318	java/lang/Throwable
    //   443	456	1318	java/lang/Throwable
    //   518	533	1318	java/lang/Throwable
    //   553	565	1318	java/lang/Throwable
    //   585	601	1318	java/lang/Throwable
    //   621	636	1318	java/lang/Throwable
    //   662	675	1318	java/lang/Throwable
    //   701	712	1318	java/lang/Throwable
    //   722	732	1318	java/lang/Throwable
    //   745	760	1318	java/lang/Throwable
    //   780	790	1318	java/lang/Throwable
    //   806	832	1318	java/lang/Throwable
    //   849	861	1318	java/lang/Throwable
    //   888	899	1318	java/lang/Throwable
    //   914	929	1318	java/lang/Throwable
    //   949	962	1318	java/lang/Throwable
    //   991	1000	1318	java/lang/Throwable
    //   1027	1040	1318	java/lang/Throwable
    //   1067	1080	1318	java/lang/Throwable
    //   1090	1103	1318	java/lang/Throwable
    //   1130	1139	1318	java/lang/Throwable
    //   1149	1161	1318	java/lang/Throwable
    //   1187	1202	1318	java/lang/Throwable
    //   1218	1252	1318	java/lang/Throwable
    //   1278	1284	1318	java/lang/Throwable
    //   1295	1304	1318	java/lang/Throwable
    //   1425	1437	1318	java/lang/Throwable
    //   1458	1480	1318	java/lang/Throwable
    //   1504	1510	1318	java/lang/Throwable
    //   1520	1547	1318	java/lang/Throwable
    //   1584	1592	1318	java/lang/Throwable
    //   1605	1614	1318	java/lang/Throwable
    //   1627	1635	1318	java/lang/Throwable
    //   1648	1656	1318	java/lang/Throwable
    //   1669	1684	1318	java/lang/Throwable
    //   1359	1363	1376	java/io/IOException
    //   146	151	1560	finally
    //   161	174	1560	finally
    //   235	239	1560	finally
    //   249	261	1560	finally
    //   277	289	1560	finally
    //   443	456	1560	finally
    //   518	533	1560	finally
    //   553	565	1560	finally
    //   585	601	1560	finally
    //   621	636	1560	finally
    //   662	675	1560	finally
    //   701	712	1560	finally
    //   722	732	1560	finally
    //   745	760	1560	finally
    //   780	790	1560	finally
    //   806	832	1560	finally
    //   849	861	1560	finally
    //   888	899	1560	finally
    //   914	929	1560	finally
    //   949	962	1560	finally
    //   991	1000	1560	finally
    //   1027	1040	1560	finally
    //   1067	1080	1560	finally
    //   1090	1103	1560	finally
    //   1130	1139	1560	finally
    //   1149	1161	1560	finally
    //   1187	1202	1560	finally
    //   1218	1252	1560	finally
    //   1278	1284	1560	finally
    //   1295	1304	1560	finally
    //   1425	1437	1560	finally
    //   1458	1480	1560	finally
    //   1504	1510	1560	finally
    //   1520	1547	1560	finally
    //   1584	1592	1560	finally
    //   1605	1614	1560	finally
    //   1627	1635	1560	finally
    //   1648	1656	1560	finally
    //   1669	1684	1560	finally
    //   308	313	1711	java/io/IOException
    //   1568	1572	1730	java/io/IOException
    //   113	133	1749	finally
    //   1327	1333	1749	finally
    //   1335	1345	1749	finally
    //   113	133	1753	java/lang/Throwable
  }
  
  private static long skip(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    long l1 = paramLong;
    for (;;)
    {
      if (l1 > 0L)
      {
        long l2 = paramInputStream.skip(l1);
        if (l2 > 0L)
        {
          l1 -= l2;
          continue;
        }
        if (l2 != 0L) {
          break;
        }
        if (paramInputStream.read() != -1) {}
      }
      else
      {
        return paramLong - l1;
      }
      l1 -= 1L;
    }
    throw new IOException("skip() return a negative value.");
  }
  
  public static abstract interface JpegExifReaderInterface
  {
    public abstract void doReport(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3);
    
    public abstract boolean readEnableFromDPC();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\image\JpegExifReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */