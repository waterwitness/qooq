import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rau
  implements Runnable
{
  public rau(ConfigServlet paramConfigServlet, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3, String paramString3, String paramString4, float paramFloat4, boolean paramBoolean, int paramInt, String paramString5)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 58	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: getfield 22	rau:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc 65
    //   16: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: astore 15
    //   24: aload_0
    //   25: getfield 20	rau:jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet	Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;
    //   28: invokevirtual 75	com/tencent/mobileqq/config/splashlogo/ConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   31: checkcast 77	com/tencent/common/app/AppInterface
    //   34: aload_0
    //   35: getfield 24	rau:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   38: new 79	java/io/File
    //   41: dup
    //   42: aload 15
    //   44: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: invokestatic 87	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   50: ifeq +986 -> 1036
    //   53: invokestatic 93	com/tencent/mobileqq/utils/DeviceInfoUtil:f	()J
    //   56: l2i
    //   57: istore 19
    //   59: invokestatic 96	com/tencent/mobileqq/utils/DeviceInfoUtil:g	()J
    //   62: l2i
    //   63: istore 20
    //   65: aload_0
    //   66: getfield 20	rau:jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet	Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;
    //   69: aload_0
    //   70: getfield 26	rau:jdField_a_of_type_Float	F
    //   73: iload 19
    //   75: i2f
    //   76: invokestatic 99	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;FF)F
    //   79: fstore_3
    //   80: aload_0
    //   81: getfield 20	rau:jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet	Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;
    //   84: aload_0
    //   85: getfield 28	rau:jdField_b_of_type_Float	F
    //   88: iload 20
    //   90: i2f
    //   91: iload 19
    //   93: i2f
    //   94: invokestatic 102	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;FFF)F
    //   97: fstore 4
    //   99: aload_0
    //   100: getfield 20	rau:jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet	Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;
    //   103: aload_0
    //   104: getfield 30	rau:jdField_c_of_type_Float	F
    //   107: invokestatic 105	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;F)F
    //   110: fstore 5
    //   112: aconst_null
    //   113: astore 7
    //   115: aconst_null
    //   116: astore 8
    //   118: aload 15
    //   120: invokestatic 111	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   123: astore 9
    //   125: aload 9
    //   127: astore 7
    //   129: aload 7
    //   131: ifnull +1743 -> 1874
    //   134: aload 7
    //   136: invokevirtual 117	android/graphics/Bitmap:isRecycled	()Z
    //   139: ifne +1735 -> 1874
    //   142: iload 19
    //   144: iload 20
    //   146: getstatic 123	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   149: invokestatic 127	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   152: astore 9
    //   154: aload 9
    //   156: astore 8
    //   158: aload 8
    //   160: astore 12
    //   162: aload 7
    //   164: astore 13
    //   166: aload 8
    //   168: ifnull +832 -> 1000
    //   171: aload 8
    //   173: astore 12
    //   175: aload 7
    //   177: astore 13
    //   179: aload 7
    //   181: astore 11
    //   183: aload 8
    //   185: astore 10
    //   187: aload 7
    //   189: astore 9
    //   191: aload 8
    //   193: invokevirtual 117	android/graphics/Bitmap:isRecycled	()Z
    //   196: ifne +804 -> 1000
    //   199: aload 7
    //   201: astore 11
    //   203: aload 8
    //   205: astore 10
    //   207: aload 7
    //   209: astore 9
    //   211: new 129	android/graphics/Canvas
    //   214: dup
    //   215: aload 8
    //   217: invokespecial 132	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   220: astore 16
    //   222: aload 7
    //   224: astore 11
    //   226: aload 8
    //   228: astore 10
    //   230: aload 7
    //   232: astore 9
    //   234: new 134	android/graphics/Paint
    //   237: dup
    //   238: invokespecial 135	android/graphics/Paint:<init>	()V
    //   241: astore 12
    //   243: aload 7
    //   245: astore 11
    //   247: aload 8
    //   249: astore 10
    //   251: aload 7
    //   253: astore 9
    //   255: aload 16
    //   257: aload 7
    //   259: new 137	android/graphics/Rect
    //   262: dup
    //   263: iconst_0
    //   264: iconst_0
    //   265: aload 7
    //   267: invokevirtual 141	android/graphics/Bitmap:getWidth	()I
    //   270: aload 7
    //   272: invokevirtual 144	android/graphics/Bitmap:getHeight	()I
    //   275: invokespecial 147	android/graphics/Rect:<init>	(IIII)V
    //   278: new 137	android/graphics/Rect
    //   281: dup
    //   282: iconst_0
    //   283: iconst_0
    //   284: iload 19
    //   286: iload 20
    //   288: invokespecial 147	android/graphics/Rect:<init>	(IIII)V
    //   291: aload 12
    //   293: invokevirtual 151	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   296: aload 7
    //   298: astore 11
    //   300: aload 8
    //   302: astore 10
    //   304: aload 7
    //   306: astore 9
    //   308: aload 7
    //   310: invokevirtual 154	android/graphics/Bitmap:recycle	()V
    //   313: aconst_null
    //   314: astore 12
    //   316: aconst_null
    //   317: astore 14
    //   319: aconst_null
    //   320: astore 13
    //   322: aload 12
    //   324: astore 11
    //   326: aload 8
    //   328: astore 10
    //   330: aload 14
    //   332: astore 9
    //   334: new 156	android/text/TextPaint
    //   337: dup
    //   338: invokespecial 157	android/text/TextPaint:<init>	()V
    //   341: astore 17
    //   343: aload 12
    //   345: astore 11
    //   347: aload 8
    //   349: astore 10
    //   351: aload 14
    //   353: astore 9
    //   355: aload 17
    //   357: iconst_1
    //   358: invokevirtual 161	android/text/TextPaint:setAntiAlias	(Z)V
    //   361: aload 12
    //   363: astore 11
    //   365: aload 8
    //   367: astore 10
    //   369: aload 14
    //   371: astore 9
    //   373: aload 17
    //   375: aload_0
    //   376: getfield 32	rau:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   379: invokestatic 167	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   382: invokevirtual 171	android/text/TextPaint:setColor	(I)V
    //   385: aload 12
    //   387: astore 11
    //   389: aload 8
    //   391: astore 10
    //   393: aload 14
    //   395: astore 9
    //   397: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq +62 -> 462
    //   403: aload 12
    //   405: astore 11
    //   407: aload 8
    //   409: astore 10
    //   411: aload 14
    //   413: astore 9
    //   415: ldc -78
    //   417: iconst_2
    //   418: new 58	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   425: ldc -76
    //   427: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: fload_3
    //   431: invokevirtual 183	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   434: ldc -71
    //   436: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: fload 4
    //   441: invokevirtual 183	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   444: ldc -69
    //   446: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload_0
    //   450: getfield 32	rau:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   453: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 191	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: aload 12
    //   464: astore 11
    //   466: aload 8
    //   468: astore 10
    //   470: aload 14
    //   472: astore 9
    //   474: ldc -63
    //   476: aload_0
    //   477: getfield 34	rau:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   480: invokevirtual 199	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   483: ifeq +659 -> 1142
    //   486: aload 12
    //   488: astore 11
    //   490: aload 8
    //   492: astore 10
    //   494: aload 14
    //   496: astore 9
    //   498: aload 17
    //   500: aload_0
    //   501: getfield 20	rau:jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet	Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;
    //   504: invokevirtual 75	com/tencent/mobileqq/config/splashlogo/ConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   507: invokevirtual 205	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   510: aload_0
    //   511: getfield 36	rau:jdField_d_of_type_Float	F
    //   514: invokestatic 210	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   517: i2f
    //   518: invokevirtual 214	android/text/TextPaint:setTextSize	(F)V
    //   521: aload 12
    //   523: astore 11
    //   525: aload 8
    //   527: astore 10
    //   529: aload 14
    //   531: astore 9
    //   533: aload 17
    //   535: invokevirtual 218	android/text/TextPaint:getFontMetrics	()Landroid/graphics/Paint$FontMetrics;
    //   538: astore 7
    //   540: aload 12
    //   542: astore 11
    //   544: aload 8
    //   546: astore 10
    //   548: aload 14
    //   550: astore 9
    //   552: aload_0
    //   553: getfield 38	rau:jdField_a_of_type_Boolean	Z
    //   556: ifeq +1331 -> 1887
    //   559: aload 12
    //   561: astore 11
    //   563: aload 8
    //   565: astore 10
    //   567: aload 14
    //   569: astore 9
    //   571: aload 7
    //   573: getfield 223	android/graphics/Paint$FontMetrics:ascent	F
    //   576: fstore_1
    //   577: fload 4
    //   579: fload_1
    //   580: fsub
    //   581: fstore_1
    //   582: aload 12
    //   584: astore 11
    //   586: aload 8
    //   588: astore 10
    //   590: aload 14
    //   592: astore 9
    //   594: aload 17
    //   596: invokestatic 225	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	()Ljava/lang/String;
    //   599: invokevirtual 229	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   602: fload 5
    //   604: fcmpl
    //   605: ifle +432 -> 1037
    //   608: ldc -25
    //   610: astore 7
    //   612: iconst_1
    //   613: istore 19
    //   615: iconst_1
    //   616: istore 20
    //   618: iload 20
    //   620: ifeq +85 -> 705
    //   623: aload 12
    //   625: astore 11
    //   627: aload 8
    //   629: astore 10
    //   631: aload 14
    //   633: astore 9
    //   635: new 58	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   642: invokestatic 225	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	()Ljava/lang/String;
    //   645: iconst_0
    //   646: invokestatic 225	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	()Ljava/lang/String;
    //   649: invokevirtual 234	java/lang/String:length	()I
    //   652: iload 19
    //   654: isub
    //   655: invokevirtual 238	java/lang/String:substring	(II)Ljava/lang/String;
    //   658: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: ldc -16
    //   663: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   669: astore 7
    //   671: aload 12
    //   673: astore 11
    //   675: aload 8
    //   677: astore 10
    //   679: aload 14
    //   681: astore 9
    //   683: aload 17
    //   685: aload 7
    //   687: invokevirtual 229	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   690: fload 5
    //   692: fcmpl
    //   693: ifle +1199 -> 1892
    //   696: iload 19
    //   698: iconst_1
    //   699: iadd
    //   700: istore 19
    //   702: goto +1182 -> 1884
    //   705: aload 12
    //   707: astore 11
    //   709: aload 8
    //   711: astore 10
    //   713: aload 14
    //   715: astore 9
    //   717: aload 16
    //   719: aload 7
    //   721: fload_3
    //   722: fload_1
    //   723: aload 17
    //   725: invokevirtual 244	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   728: aload 12
    //   730: astore 11
    //   732: aload 8
    //   734: astore 10
    //   736: aload 14
    //   738: astore 9
    //   740: aload 16
    //   742: bipush 31
    //   744: invokevirtual 248	android/graphics/Canvas:save	(I)I
    //   747: pop
    //   748: aload 12
    //   750: astore 11
    //   752: aload 8
    //   754: astore 10
    //   756: aload 14
    //   758: astore 9
    //   760: aload 16
    //   762: invokevirtual 251	android/graphics/Canvas:restore	()V
    //   765: aload 12
    //   767: astore 11
    //   769: aload 8
    //   771: astore 10
    //   773: aload 14
    //   775: astore 9
    //   777: new 79	java/io/File
    //   780: dup
    //   781: aload_0
    //   782: getfield 22	rau:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   785: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   788: astore 7
    //   790: aload 12
    //   792: astore 11
    //   794: aload 8
    //   796: astore 10
    //   798: aload 14
    //   800: astore 9
    //   802: new 79	java/io/File
    //   805: dup
    //   806: aload 15
    //   808: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   811: astore 15
    //   813: aload 12
    //   815: astore 11
    //   817: aload 8
    //   819: astore 10
    //   821: aload 14
    //   823: astore 9
    //   825: new 253	java/io/BufferedOutputStream
    //   828: dup
    //   829: new 255	java/io/FileOutputStream
    //   832: dup
    //   833: aload 15
    //   835: invokespecial 258	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   838: invokespecial 261	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   841: astore 16
    //   843: aload 12
    //   845: astore 11
    //   847: aload 8
    //   849: astore 10
    //   851: aload 14
    //   853: astore 9
    //   855: aload 8
    //   857: getstatic 267	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   860: bipush 100
    //   862: aload 16
    //   864: invokevirtual 271	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   867: pop
    //   868: aload 12
    //   870: astore 11
    //   872: aload 8
    //   874: astore 10
    //   876: aload 14
    //   878: astore 9
    //   880: aload 16
    //   882: invokevirtual 274	java/io/BufferedOutputStream:flush	()V
    //   885: aload 12
    //   887: astore 11
    //   889: aload 8
    //   891: astore 10
    //   893: aload 14
    //   895: astore 9
    //   897: aload 16
    //   899: invokevirtual 277	java/io/BufferedOutputStream:close	()V
    //   902: aload 12
    //   904: astore 11
    //   906: aload 8
    //   908: astore 10
    //   910: aload 14
    //   912: astore 9
    //   914: aload 7
    //   916: invokevirtual 280	java/io/File:exists	()Z
    //   919: ifeq +21 -> 940
    //   922: aload 12
    //   924: astore 11
    //   926: aload 8
    //   928: astore 10
    //   930: aload 14
    //   932: astore 9
    //   934: aload 7
    //   936: invokevirtual 283	java/io/File:delete	()Z
    //   939: pop
    //   940: aload 12
    //   942: astore 11
    //   944: aload 8
    //   946: astore 10
    //   948: aload 14
    //   950: astore 9
    //   952: aload 15
    //   954: aload 7
    //   956: invokevirtual 287	java/io/File:renameTo	(Ljava/io/File;)Z
    //   959: pop
    //   960: aload 12
    //   962: astore 11
    //   964: aload 8
    //   966: astore 10
    //   968: aload 14
    //   970: astore 9
    //   972: aload_0
    //   973: getfield 20	rau:jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet	Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;
    //   976: invokevirtual 75	com/tencent/mobileqq/config/splashlogo/ConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   979: invokevirtual 205	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   982: aload_0
    //   983: getfield 40	rau:jdField_a_of_type_Int	I
    //   986: aload_0
    //   987: getfield 42	rau:e	Ljava/lang/String;
    //   990: getstatic 290	com/tencent/mobileqq/config/splashlogo/ConfigServlet:h	Ljava/lang/String;
    //   993: invokestatic 295	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   996: aload 8
    //   998: astore 12
    //   1000: aload 13
    //   1002: ifnull +16 -> 1018
    //   1005: aload 13
    //   1007: invokevirtual 117	android/graphics/Bitmap:isRecycled	()Z
    //   1010: ifne +8 -> 1018
    //   1013: aload 13
    //   1015: invokevirtual 154	android/graphics/Bitmap:recycle	()V
    //   1018: aload 12
    //   1020: ifnull +16 -> 1036
    //   1023: aload 12
    //   1025: invokevirtual 117	android/graphics/Bitmap:isRecycled	()Z
    //   1028: ifne +8 -> 1036
    //   1031: aload 12
    //   1033: invokevirtual 154	android/graphics/Bitmap:recycle	()V
    //   1036: return
    //   1037: aload 12
    //   1039: astore 11
    //   1041: aload 8
    //   1043: astore 10
    //   1045: aload 14
    //   1047: astore 9
    //   1049: aload 16
    //   1051: invokestatic 225	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	()Ljava/lang/String;
    //   1054: fload_3
    //   1055: fload_1
    //   1056: aload 17
    //   1058: invokevirtual 244	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   1061: goto -333 -> 728
    //   1064: astore 9
    //   1066: aconst_null
    //   1067: astore 7
    //   1069: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1072: ifeq +33 -> 1105
    //   1075: ldc -78
    //   1077: iconst_2
    //   1078: new 58	java/lang/StringBuilder
    //   1081: dup
    //   1082: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1085: ldc_w 297
    //   1088: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: aload 9
    //   1093: invokevirtual 300	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1096: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: invokestatic 191	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1105: aload 7
    //   1107: ifnull +16 -> 1123
    //   1110: aload 7
    //   1112: invokevirtual 117	android/graphics/Bitmap:isRecycled	()Z
    //   1115: ifne +8 -> 1123
    //   1118: aload 7
    //   1120: invokevirtual 154	android/graphics/Bitmap:recycle	()V
    //   1123: aload 8
    //   1125: ifnull -89 -> 1036
    //   1128: aload 8
    //   1130: invokevirtual 117	android/graphics/Bitmap:isRecycled	()Z
    //   1133: ifne -97 -> 1036
    //   1136: aload 8
    //   1138: invokevirtual 154	android/graphics/Bitmap:recycle	()V
    //   1141: return
    //   1142: aload 12
    //   1144: astore 11
    //   1146: aload 8
    //   1148: astore 10
    //   1150: aload 14
    //   1152: astore 9
    //   1154: ldc_w 302
    //   1157: aload_0
    //   1158: getfield 34	rau:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1161: invokevirtual 199	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1164: ifeq +591 -> 1755
    //   1167: aload 12
    //   1169: astore 11
    //   1171: aload 8
    //   1173: astore 10
    //   1175: aload 14
    //   1177: astore 9
    //   1179: aload_0
    //   1180: getfield 36	rau:jdField_d_of_type_Float	F
    //   1183: ldc_w 303
    //   1186: fcmpg
    //   1187: ifge +256 -> 1443
    //   1190: ldc_w 303
    //   1193: fstore_1
    //   1194: goto +707 -> 1901
    //   1197: aload 12
    //   1199: astore 11
    //   1201: aload 8
    //   1203: astore 10
    //   1205: aload 14
    //   1207: astore 9
    //   1209: aload 17
    //   1211: aload_0
    //   1212: getfield 20	rau:jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet	Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;
    //   1215: invokevirtual 75	com/tencent/mobileqq/config/splashlogo/ConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1218: invokevirtual 205	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   1221: fload_1
    //   1222: invokestatic 210	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1225: i2f
    //   1226: invokevirtual 214	android/text/TextPaint:setTextSize	(F)V
    //   1229: aload 12
    //   1231: astore 11
    //   1233: aload 8
    //   1235: astore 10
    //   1237: aload 14
    //   1239: astore 9
    //   1241: aload 17
    //   1243: invokestatic 225	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	()Ljava/lang/String;
    //   1246: invokevirtual 229	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   1249: fstore_2
    //   1250: fload_2
    //   1251: fload 5
    //   1253: fcmpg
    //   1254: ifgt +650 -> 1904
    //   1257: iconst_1
    //   1258: istore 19
    //   1260: iload 19
    //   1262: ifeq +201 -> 1463
    //   1265: aload 12
    //   1267: astore 11
    //   1269: aload 8
    //   1271: astore 10
    //   1273: aload 14
    //   1275: astore 9
    //   1277: aload 17
    //   1279: invokevirtual 218	android/text/TextPaint:getFontMetrics	()Landroid/graphics/Paint$FontMetrics;
    //   1282: astore 7
    //   1284: aload 12
    //   1286: astore 11
    //   1288: aload 8
    //   1290: astore 10
    //   1292: aload 14
    //   1294: astore 9
    //   1296: aload_0
    //   1297: getfield 38	rau:jdField_a_of_type_Boolean	Z
    //   1300: ifeq +639 -> 1939
    //   1303: aload 12
    //   1305: astore 11
    //   1307: aload 8
    //   1309: astore 10
    //   1311: aload 14
    //   1313: astore 9
    //   1315: aload 7
    //   1317: getfield 223	android/graphics/Paint$FontMetrics:ascent	F
    //   1320: fstore_1
    //   1321: aload 12
    //   1323: astore 11
    //   1325: aload 8
    //   1327: astore 10
    //   1329: aload 14
    //   1331: astore 9
    //   1333: fload_2
    //   1334: fconst_2
    //   1335: fdiv
    //   1336: fstore_2
    //   1337: aload 12
    //   1339: astore 11
    //   1341: aload 8
    //   1343: astore 10
    //   1345: aload 14
    //   1347: astore 9
    //   1349: aload 16
    //   1351: invokestatic 225	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	()Ljava/lang/String;
    //   1354: fload_3
    //   1355: fload_2
    //   1356: fsub
    //   1357: fload 4
    //   1359: fload_1
    //   1360: fsub
    //   1361: aload 17
    //   1363: invokevirtual 244	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   1366: goto -638 -> 728
    //   1369: astore 7
    //   1371: aload 11
    //   1373: astore 7
    //   1375: aload 8
    //   1377: astore 10
    //   1379: aload 7
    //   1381: astore 9
    //   1383: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1386: ifeq +20 -> 1406
    //   1389: aload 8
    //   1391: astore 10
    //   1393: aload 7
    //   1395: astore 9
    //   1397: ldc -78
    //   1399: iconst_2
    //   1400: ldc_w 305
    //   1403: invokestatic 191	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1406: aload 7
    //   1408: ifnull +16 -> 1424
    //   1411: aload 7
    //   1413: invokevirtual 117	android/graphics/Bitmap:isRecycled	()Z
    //   1416: ifne +8 -> 1424
    //   1419: aload 7
    //   1421: invokevirtual 154	android/graphics/Bitmap:recycle	()V
    //   1424: aload 8
    //   1426: ifnull -390 -> 1036
    //   1429: aload 8
    //   1431: invokevirtual 117	android/graphics/Bitmap:isRecycled	()Z
    //   1434: ifne -398 -> 1036
    //   1437: aload 8
    //   1439: invokevirtual 154	android/graphics/Bitmap:recycle	()V
    //   1442: return
    //   1443: aload 12
    //   1445: astore 11
    //   1447: aload 8
    //   1449: astore 10
    //   1451: aload 14
    //   1453: astore 9
    //   1455: aload_0
    //   1456: getfield 36	rau:jdField_d_of_type_Float	F
    //   1459: fstore_1
    //   1460: goto +441 -> 1901
    //   1463: aload 12
    //   1465: astore 11
    //   1467: aload 8
    //   1469: astore 10
    //   1471: aload 14
    //   1473: astore 9
    //   1475: invokestatic 225	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	()Ljava/lang/String;
    //   1478: invokevirtual 234	java/lang/String:length	()I
    //   1481: istore 21
    //   1483: ldc -25
    //   1485: astore 7
    //   1487: fload_2
    //   1488: fstore_1
    //   1489: iconst_1
    //   1490: istore 20
    //   1492: iload 20
    //   1494: iload 21
    //   1496: if_icmpgt +369 -> 1865
    //   1499: aload 12
    //   1501: astore 11
    //   1503: aload 8
    //   1505: astore 10
    //   1507: aload 14
    //   1509: astore 9
    //   1511: new 58	java/lang/StringBuilder
    //   1514: dup
    //   1515: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1518: invokestatic 225	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	()Ljava/lang/String;
    //   1521: iconst_0
    //   1522: invokestatic 225	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	()Ljava/lang/String;
    //   1525: invokevirtual 234	java/lang/String:length	()I
    //   1528: iload 20
    //   1530: isub
    //   1531: invokevirtual 238	java/lang/String:substring	(II)Ljava/lang/String;
    //   1534: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: ldc -16
    //   1539: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1542: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1545: astore 7
    //   1547: aload 12
    //   1549: astore 11
    //   1551: aload 8
    //   1553: astore 10
    //   1555: aload 14
    //   1557: astore 9
    //   1559: aload 17
    //   1561: aload 7
    //   1563: invokevirtual 229	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   1566: fstore_1
    //   1567: fload_1
    //   1568: fload 5
    //   1570: fcmpl
    //   1571: ifle +373 -> 1944
    //   1574: iload 20
    //   1576: iconst_1
    //   1577: iadd
    //   1578: istore 20
    //   1580: goto -88 -> 1492
    //   1583: iload 19
    //   1585: ifeq +146 -> 1731
    //   1588: aload 12
    //   1590: astore 11
    //   1592: aload 8
    //   1594: astore 10
    //   1596: aload 14
    //   1598: astore 9
    //   1600: aload 17
    //   1602: invokevirtual 218	android/text/TextPaint:getFontMetrics	()Landroid/graphics/Paint$FontMetrics;
    //   1605: astore 18
    //   1607: aload 12
    //   1609: astore 11
    //   1611: aload 8
    //   1613: astore 10
    //   1615: aload 14
    //   1617: astore 9
    //   1619: aload_0
    //   1620: getfield 38	rau:jdField_a_of_type_Boolean	Z
    //   1623: ifeq +103 -> 1726
    //   1626: aload 12
    //   1628: astore 11
    //   1630: aload 8
    //   1632: astore 10
    //   1634: aload 14
    //   1636: astore 9
    //   1638: aload 18
    //   1640: getfield 223	android/graphics/Paint$FontMetrics:ascent	F
    //   1643: fstore_2
    //   1644: aload 12
    //   1646: astore 11
    //   1648: aload 8
    //   1650: astore 10
    //   1652: aload 14
    //   1654: astore 9
    //   1656: aload 16
    //   1658: aload 7
    //   1660: fload_3
    //   1661: fload_1
    //   1662: fconst_2
    //   1663: fdiv
    //   1664: fsub
    //   1665: fload 4
    //   1667: fload_2
    //   1668: fsub
    //   1669: aload 17
    //   1671: invokevirtual 244	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   1674: goto -946 -> 728
    //   1677: astore 8
    //   1679: aload 9
    //   1681: astore 7
    //   1683: aload 10
    //   1685: astore 9
    //   1687: aload 7
    //   1689: ifnull +16 -> 1705
    //   1692: aload 7
    //   1694: invokevirtual 117	android/graphics/Bitmap:isRecycled	()Z
    //   1697: ifne +8 -> 1705
    //   1700: aload 7
    //   1702: invokevirtual 154	android/graphics/Bitmap:recycle	()V
    //   1705: aload 9
    //   1707: ifnull +16 -> 1723
    //   1710: aload 9
    //   1712: invokevirtual 117	android/graphics/Bitmap:isRecycled	()Z
    //   1715: ifne +8 -> 1723
    //   1718: aload 9
    //   1720: invokevirtual 154	android/graphics/Bitmap:recycle	()V
    //   1723: aload 8
    //   1725: athrow
    //   1726: fconst_0
    //   1727: fstore_2
    //   1728: goto -84 -> 1644
    //   1731: aload 12
    //   1733: astore 11
    //   1735: aload 8
    //   1737: astore 10
    //   1739: aload 14
    //   1741: astore 9
    //   1743: ldc -78
    //   1745: iconst_1
    //   1746: ldc_w 307
    //   1749: invokestatic 309	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1752: goto -1024 -> 728
    //   1755: aload 12
    //   1757: astore 11
    //   1759: aload 8
    //   1761: astore 10
    //   1763: aload 14
    //   1765: astore 9
    //   1767: ldc -78
    //   1769: iconst_1
    //   1770: new 58	java/lang/StringBuilder
    //   1773: dup
    //   1774: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1777: ldc_w 311
    //   1780: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1783: aload_0
    //   1784: getfield 34	rau:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1787: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1790: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1793: invokestatic 309	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1796: goto -1068 -> 728
    //   1799: astore 8
    //   1801: aconst_null
    //   1802: astore 7
    //   1804: aconst_null
    //   1805: astore 9
    //   1807: goto -120 -> 1687
    //   1810: astore 8
    //   1812: aconst_null
    //   1813: astore 9
    //   1815: goto -128 -> 1687
    //   1818: astore 10
    //   1820: aload 8
    //   1822: astore 9
    //   1824: aload 10
    //   1826: astore 8
    //   1828: goto -141 -> 1687
    //   1831: astore 7
    //   1833: aconst_null
    //   1834: astore 7
    //   1836: aconst_null
    //   1837: astore 8
    //   1839: goto -464 -> 1375
    //   1842: astore 8
    //   1844: aconst_null
    //   1845: astore 8
    //   1847: goto -472 -> 1375
    //   1850: astore 9
    //   1852: goto -783 -> 1069
    //   1855: astore 9
    //   1857: goto -788 -> 1069
    //   1860: astore 9
    //   1862: goto -793 -> 1069
    //   1865: goto -282 -> 1583
    //   1868: iconst_0
    //   1869: istore 19
    //   1871: goto -611 -> 1260
    //   1874: aconst_null
    //   1875: astore 12
    //   1877: aload 7
    //   1879: astore 13
    //   1881: goto -881 -> 1000
    //   1884: goto -1266 -> 618
    //   1887: fconst_0
    //   1888: fstore_1
    //   1889: goto -1312 -> 577
    //   1892: iconst_0
    //   1893: istore 20
    //   1895: iconst_0
    //   1896: istore 19
    //   1898: goto -14 -> 1884
    //   1901: goto -704 -> 1197
    //   1904: fload_1
    //   1905: ldc_w 303
    //   1908: fsub
    //   1909: fstore 6
    //   1911: fload 6
    //   1913: fconst_1
    //   1914: fcmpl
    //   1915: ifle +10 -> 1925
    //   1918: fload_1
    //   1919: fconst_1
    //   1920: fsub
    //   1921: fstore_1
    //   1922: goto -725 -> 1197
    //   1925: fload 6
    //   1927: fconst_0
    //   1928: fcmpl
    //   1929: ifle -61 -> 1868
    //   1932: ldc_w 303
    //   1935: fstore_1
    //   1936: goto -739 -> 1197
    //   1939: fconst_0
    //   1940: fstore_1
    //   1941: goto -620 -> 1321
    //   1944: iconst_1
    //   1945: istore 19
    //   1947: goto -364 -> 1583
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1950	0	this	rau
    //   576	1365	1	f1	float
    //   1249	479	2	f2	float
    //   79	1582	3	f3	float
    //   97	1569	4	f4	float
    //   110	1459	5	f5	float
    //   1909	17	6	f6	float
    //   113	1203	7	localObject1	Object
    //   1369	1	7	localOutOfMemoryError1	OutOfMemoryError
    //   1373	430	7	localObject2	Object
    //   1831	1	7	localOutOfMemoryError2	OutOfMemoryError
    //   1834	44	7	localObject3	Object
    //   116	1533	8	localObject4	Object
    //   1677	83	8	localObject5	Object
    //   1799	1	8	localObject6	Object
    //   1810	11	8	localObject7	Object
    //   1826	12	8	localObject8	Object
    //   1842	1	8	localOutOfMemoryError3	OutOfMemoryError
    //   1845	1	8	localObject9	Object
    //   123	925	9	localObject10	Object
    //   1064	28	9	localException1	Exception
    //   1152	671	9	localObject11	Object
    //   1850	1	9	localException2	Exception
    //   1855	1	9	localException3	Exception
    //   1860	1	9	localException4	Exception
    //   185	1577	10	localObject12	Object
    //   1818	7	10	localObject13	Object
    //   181	1577	11	localObject14	Object
    //   160	1716	12	localObject15	Object
    //   164	1716	13	localObject16	Object
    //   317	1447	14	localObject17	Object
    //   22	931	15	localObject18	Object
    //   220	1437	16	localObject19	Object
    //   341	1329	17	localTextPaint	android.text.TextPaint
    //   1605	34	18	localFontMetrics	android.graphics.Paint.FontMetrics
    //   57	1889	19	i	int
    //   63	1831	20	j	int
    //   1481	16	21	k	int
    // Exception table:
    //   from	to	target	type
    //   334	343	1064	java/lang/Exception
    //   355	361	1064	java/lang/Exception
    //   373	385	1064	java/lang/Exception
    //   397	403	1064	java/lang/Exception
    //   415	462	1064	java/lang/Exception
    //   474	486	1064	java/lang/Exception
    //   498	521	1064	java/lang/Exception
    //   533	540	1064	java/lang/Exception
    //   552	559	1064	java/lang/Exception
    //   571	577	1064	java/lang/Exception
    //   594	608	1064	java/lang/Exception
    //   635	671	1064	java/lang/Exception
    //   683	696	1064	java/lang/Exception
    //   717	728	1064	java/lang/Exception
    //   740	748	1064	java/lang/Exception
    //   760	765	1064	java/lang/Exception
    //   777	790	1064	java/lang/Exception
    //   802	813	1064	java/lang/Exception
    //   825	843	1064	java/lang/Exception
    //   855	868	1064	java/lang/Exception
    //   880	885	1064	java/lang/Exception
    //   897	902	1064	java/lang/Exception
    //   914	922	1064	java/lang/Exception
    //   934	940	1064	java/lang/Exception
    //   952	960	1064	java/lang/Exception
    //   972	996	1064	java/lang/Exception
    //   1049	1061	1064	java/lang/Exception
    //   1154	1167	1064	java/lang/Exception
    //   1179	1190	1064	java/lang/Exception
    //   1209	1229	1064	java/lang/Exception
    //   1241	1250	1064	java/lang/Exception
    //   1277	1284	1064	java/lang/Exception
    //   1296	1303	1064	java/lang/Exception
    //   1315	1321	1064	java/lang/Exception
    //   1333	1337	1064	java/lang/Exception
    //   1349	1366	1064	java/lang/Exception
    //   1455	1460	1064	java/lang/Exception
    //   1475	1483	1064	java/lang/Exception
    //   1511	1547	1064	java/lang/Exception
    //   1559	1567	1064	java/lang/Exception
    //   1600	1607	1064	java/lang/Exception
    //   1619	1626	1064	java/lang/Exception
    //   1638	1644	1064	java/lang/Exception
    //   1656	1674	1064	java/lang/Exception
    //   1743	1752	1064	java/lang/Exception
    //   1767	1796	1064	java/lang/Exception
    //   191	199	1369	java/lang/OutOfMemoryError
    //   211	222	1369	java/lang/OutOfMemoryError
    //   234	243	1369	java/lang/OutOfMemoryError
    //   255	296	1369	java/lang/OutOfMemoryError
    //   308	313	1369	java/lang/OutOfMemoryError
    //   334	343	1369	java/lang/OutOfMemoryError
    //   355	361	1369	java/lang/OutOfMemoryError
    //   373	385	1369	java/lang/OutOfMemoryError
    //   397	403	1369	java/lang/OutOfMemoryError
    //   415	462	1369	java/lang/OutOfMemoryError
    //   474	486	1369	java/lang/OutOfMemoryError
    //   498	521	1369	java/lang/OutOfMemoryError
    //   533	540	1369	java/lang/OutOfMemoryError
    //   552	559	1369	java/lang/OutOfMemoryError
    //   571	577	1369	java/lang/OutOfMemoryError
    //   594	608	1369	java/lang/OutOfMemoryError
    //   635	671	1369	java/lang/OutOfMemoryError
    //   683	696	1369	java/lang/OutOfMemoryError
    //   717	728	1369	java/lang/OutOfMemoryError
    //   740	748	1369	java/lang/OutOfMemoryError
    //   760	765	1369	java/lang/OutOfMemoryError
    //   777	790	1369	java/lang/OutOfMemoryError
    //   802	813	1369	java/lang/OutOfMemoryError
    //   825	843	1369	java/lang/OutOfMemoryError
    //   855	868	1369	java/lang/OutOfMemoryError
    //   880	885	1369	java/lang/OutOfMemoryError
    //   897	902	1369	java/lang/OutOfMemoryError
    //   914	922	1369	java/lang/OutOfMemoryError
    //   934	940	1369	java/lang/OutOfMemoryError
    //   952	960	1369	java/lang/OutOfMemoryError
    //   972	996	1369	java/lang/OutOfMemoryError
    //   1049	1061	1369	java/lang/OutOfMemoryError
    //   1154	1167	1369	java/lang/OutOfMemoryError
    //   1179	1190	1369	java/lang/OutOfMemoryError
    //   1209	1229	1369	java/lang/OutOfMemoryError
    //   1241	1250	1369	java/lang/OutOfMemoryError
    //   1277	1284	1369	java/lang/OutOfMemoryError
    //   1296	1303	1369	java/lang/OutOfMemoryError
    //   1315	1321	1369	java/lang/OutOfMemoryError
    //   1333	1337	1369	java/lang/OutOfMemoryError
    //   1349	1366	1369	java/lang/OutOfMemoryError
    //   1455	1460	1369	java/lang/OutOfMemoryError
    //   1475	1483	1369	java/lang/OutOfMemoryError
    //   1511	1547	1369	java/lang/OutOfMemoryError
    //   1559	1567	1369	java/lang/OutOfMemoryError
    //   1600	1607	1369	java/lang/OutOfMemoryError
    //   1619	1626	1369	java/lang/OutOfMemoryError
    //   1638	1644	1369	java/lang/OutOfMemoryError
    //   1656	1674	1369	java/lang/OutOfMemoryError
    //   1743	1752	1369	java/lang/OutOfMemoryError
    //   1767	1796	1369	java/lang/OutOfMemoryError
    //   191	199	1677	finally
    //   211	222	1677	finally
    //   234	243	1677	finally
    //   255	296	1677	finally
    //   308	313	1677	finally
    //   334	343	1677	finally
    //   355	361	1677	finally
    //   373	385	1677	finally
    //   397	403	1677	finally
    //   415	462	1677	finally
    //   474	486	1677	finally
    //   498	521	1677	finally
    //   533	540	1677	finally
    //   552	559	1677	finally
    //   571	577	1677	finally
    //   594	608	1677	finally
    //   635	671	1677	finally
    //   683	696	1677	finally
    //   717	728	1677	finally
    //   740	748	1677	finally
    //   760	765	1677	finally
    //   777	790	1677	finally
    //   802	813	1677	finally
    //   825	843	1677	finally
    //   855	868	1677	finally
    //   880	885	1677	finally
    //   897	902	1677	finally
    //   914	922	1677	finally
    //   934	940	1677	finally
    //   952	960	1677	finally
    //   972	996	1677	finally
    //   1049	1061	1677	finally
    //   1154	1167	1677	finally
    //   1179	1190	1677	finally
    //   1209	1229	1677	finally
    //   1241	1250	1677	finally
    //   1277	1284	1677	finally
    //   1296	1303	1677	finally
    //   1315	1321	1677	finally
    //   1333	1337	1677	finally
    //   1349	1366	1677	finally
    //   1383	1389	1677	finally
    //   1397	1406	1677	finally
    //   1455	1460	1677	finally
    //   1475	1483	1677	finally
    //   1511	1547	1677	finally
    //   1559	1567	1677	finally
    //   1600	1607	1677	finally
    //   1619	1626	1677	finally
    //   1638	1644	1677	finally
    //   1656	1674	1677	finally
    //   1743	1752	1677	finally
    //   1767	1796	1677	finally
    //   118	125	1799	finally
    //   134	154	1810	finally
    //   1069	1105	1818	finally
    //   118	125	1831	java/lang/OutOfMemoryError
    //   134	154	1842	java/lang/OutOfMemoryError
    //   118	125	1850	java/lang/Exception
    //   134	154	1855	java/lang/Exception
    //   191	199	1860	java/lang/Exception
    //   211	222	1860	java/lang/Exception
    //   234	243	1860	java/lang/Exception
    //   255	296	1860	java/lang/Exception
    //   308	313	1860	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */