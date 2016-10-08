import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class tga
  extends Thread
{
  public int a;
  public String a;
  public volatile boolean a;
  public int b;
  public String b;
  public volatile boolean b;
  private int c;
  public volatile boolean c;
  public volatile boolean d;
  
  public tga(QQPlayerService paramQQPlayerService, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = true;
    setName("QQPlayerService-DownloadThread");
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  private File a(String paramString)
  {
    File localFile = new File(QQPlayerService.b());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString = new File(QQPlayerService.b() + "/" + paramString);
    if (!paramString.exists()) {}
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (IOException localIOException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQPlayerService", 2, "createNewFile:" + localIOException.getMessage(), localIOException);
    }
    return paramString;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 108	com/tencent/mobileqq/utils/DeviceInfoUtil:b	()[J
    //   5: astore_1
    //   6: aload_1
    //   7: ifnull +38 -> 45
    //   10: aload_1
    //   11: iconst_1
    //   12: laload
    //   13: ldc2_w 109
    //   16: lcmp
    //   17: ifgt +28 -> 45
    //   20: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +11 -> 34
    //   26: ldc 84
    //   28: iconst_2
    //   29: ldc 112
    //   31: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: getfield 16	tga:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   38: invokevirtual 119	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   41: invokestatic 122	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   44: return
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 36	tga:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   50: invokespecial 124	tga:a	(Ljava/lang/String;)Ljava/io/File;
    //   53: astore 5
    //   55: aload_0
    //   56: iconst_1
    //   57: putfield 126	tga:jdField_c_of_type_Boolean	Z
    //   60: new 128	java/io/RandomAccessFile
    //   63: dup
    //   64: aload 5
    //   66: ldc -126
    //   68: invokespecial 133	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   71: astore_2
    //   72: aload_2
    //   73: astore_1
    //   74: new 135	java/net/URL
    //   77: dup
    //   78: ldc -119
    //   80: aload_0
    //   81: getfield 34	tga:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   84: invokestatic 143	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   87: invokespecial 144	java/net/URL:<init>	(Ljava/lang/String;)V
    //   90: astore 6
    //   92: aload_2
    //   93: astore_1
    //   94: invokestatic 147	com/tencent/mobileqq/music/QQPlayerService:b	()Lcom/tencent/mobileqq/music/SongInfo;
    //   97: getfield 150	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   100: aload_0
    //   101: getfield 34	tga:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   104: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifeq +2116 -> 2223
    //   110: aload_2
    //   111: astore_1
    //   112: aload_0
    //   113: getfield 26	tga:d	Z
    //   116: ifeq +2107 -> 2223
    //   119: aload_2
    //   120: astore_1
    //   121: aload_0
    //   122: getfield 42	tga:jdField_a_of_type_Int	I
    //   125: i2f
    //   126: aload_0
    //   127: getfield 40	tga:jdField_b_of_type_Int	I
    //   130: i2f
    //   131: aload_0
    //   132: getfield 16	tga:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   135: getfield 159	com/tencent/mobileqq/music/QQPlayerService:a	F
    //   138: fmul
    //   139: fcmpl
    //   140: ifle +297 -> 437
    //   143: aload_2
    //   144: astore_1
    //   145: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +13 -> 161
    //   151: aload_2
    //   152: astore_1
    //   153: ldc 84
    //   155: iconst_2
    //   156: ldc -95
    //   158: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: aload_2
    //   162: astore_1
    //   163: invokestatic 164	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   166: invokevirtual 169	android/media/MediaPlayer:reset	()V
    //   169: aload_2
    //   170: astore_1
    //   171: invokestatic 164	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   174: aload 5
    //   176: invokevirtual 172	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   179: invokevirtual 175	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   182: aload_2
    //   183: astore_1
    //   184: invokestatic 164	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   187: invokevirtual 178	android/media/MediaPlayer:prepare	()V
    //   190: aload_2
    //   191: astore_1
    //   192: invokestatic 164	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   195: invokevirtual 181	android/media/MediaPlayer:start	()V
    //   198: aload_2
    //   199: astore_1
    //   200: aload_0
    //   201: getfield 16	tga:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   204: iconst_2
    //   205: invokestatic 184	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   208: aload_2
    //   209: astore_1
    //   210: aload_0
    //   211: iconst_0
    //   212: putfield 26	tga:d	Z
    //   215: goto +2008 -> 2223
    //   218: iload 7
    //   220: istore 8
    //   222: aload_1
    //   223: astore_3
    //   224: iload 7
    //   226: ifgt +130 -> 356
    //   229: iload 7
    //   231: istore 8
    //   233: aload_1
    //   234: astore_3
    //   235: iload 9
    //   237: iconst_5
    //   238: if_icmpgt +118 -> 356
    //   241: aload_2
    //   242: astore_1
    //   243: aload 6
    //   245: invokevirtual 188	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   248: checkcast 190	java/net/HttpURLConnection
    //   251: astore_3
    //   252: aload_2
    //   253: astore_1
    //   254: aload_3
    //   255: iconst_1
    //   256: invokevirtual 194	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   259: aload_2
    //   260: astore_1
    //   261: aload_3
    //   262: ldc -60
    //   264: ldc -58
    //   266: invokevirtual 202	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: aload_2
    //   270: astore_1
    //   271: aload_0
    //   272: getfield 38	tga:jdField_c_of_type_Int	I
    //   275: ifeq +58 -> 333
    //   278: aload_2
    //   279: astore_1
    //   280: aload_0
    //   281: getfield 38	tga:jdField_c_of_type_Int	I
    //   284: aload_0
    //   285: getfield 42	tga:jdField_a_of_type_Int	I
    //   288: if_icmple +45 -> 333
    //   291: aload_2
    //   292: astore_1
    //   293: aload_3
    //   294: ldc -52
    //   296: new 64	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   303: ldc -50
    //   305: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_0
    //   309: getfield 42	tga:jdField_a_of_type_Int	I
    //   312: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: ldc -45
    //   317: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_0
    //   321: getfield 38	tga:jdField_c_of_type_Int	I
    //   324: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokevirtual 202	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload_2
    //   334: astore_1
    //   335: aload_3
    //   336: invokevirtual 214	java/net/HttpURLConnection:connect	()V
    //   339: aload_2
    //   340: astore_1
    //   341: aload_3
    //   342: invokevirtual 218	java/net/HttpURLConnection:getContentLength	()I
    //   345: istore 7
    //   347: iload 7
    //   349: ifle +247 -> 596
    //   352: iload 7
    //   354: istore 8
    //   356: iload 8
    //   358: ifgt +303 -> 661
    //   361: aload_2
    //   362: astore_1
    //   363: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq +13 -> 379
    //   369: aload_2
    //   370: astore_1
    //   371: ldc 84
    //   373: iconst_2
    //   374: ldc -36
    //   376: invokestatic 223	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   379: aload_2
    //   380: astore_1
    //   381: aload_0
    //   382: getfield 16	tga:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   385: bipush 7
    //   387: invokestatic 184	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   390: aload_0
    //   391: iconst_0
    //   392: putfield 126	tga:jdField_c_of_type_Boolean	Z
    //   395: aload_2
    //   396: ifnull +7 -> 403
    //   399: aload_2
    //   400: invokevirtual 226	java/io/RandomAccessFile:close	()V
    //   403: aload_0
    //   404: getfield 42	tga:jdField_a_of_type_Int	I
    //   407: aload_0
    //   408: getfield 40	tga:jdField_b_of_type_Int	I
    //   411: if_icmpge -367 -> 44
    //   414: aload_0
    //   415: getfield 40	tga:jdField_b_of_type_Int	I
    //   418: ifle -374 -> 44
    //   421: aload_0
    //   422: getfield 36	tga:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   425: aload_0
    //   426: getfield 42	tga:jdField_a_of_type_Int	I
    //   429: aload_0
    //   430: getfield 40	tga:jdField_b_of_type_Int	I
    //   433: invokestatic 231	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   436: return
    //   437: aload_2
    //   438: astore_1
    //   439: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq +13 -> 455
    //   445: aload_2
    //   446: astore_1
    //   447: ldc 84
    //   449: iconst_2
    //   450: ldc -23
    //   452: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: aload_2
    //   456: astore_1
    //   457: aload_0
    //   458: getfield 16	tga:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   461: iconst_1
    //   462: invokestatic 184	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   465: goto +1758 -> 2223
    //   468: astore_3
    //   469: aload_2
    //   470: astore_1
    //   471: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   474: ifeq +34 -> 508
    //   477: aload_2
    //   478: astore_1
    //   479: ldc 84
    //   481: iconst_2
    //   482: new 64	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   489: ldc -21
    //   491: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload_3
    //   495: invokevirtual 236	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   498: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: aload_3
    //   505: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   508: aload_2
    //   509: astore_1
    //   510: aload_0
    //   511: getfield 16	tga:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   514: invokevirtual 119	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   517: invokestatic 122	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   520: aload_0
    //   521: iconst_0
    //   522: putfield 126	tga:jdField_c_of_type_Boolean	Z
    //   525: aload_2
    //   526: ifnull +7 -> 533
    //   529: aload_2
    //   530: invokevirtual 226	java/io/RandomAccessFile:close	()V
    //   533: aload_0
    //   534: getfield 42	tga:jdField_a_of_type_Int	I
    //   537: aload_0
    //   538: getfield 40	tga:jdField_b_of_type_Int	I
    //   541: if_icmpge +25 -> 566
    //   544: aload_0
    //   545: getfield 40	tga:jdField_b_of_type_Int	I
    //   548: ifle +18 -> 566
    //   551: aload_0
    //   552: getfield 36	tga:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   555: aload_0
    //   556: getfield 42	tga:jdField_a_of_type_Int	I
    //   559: aload_0
    //   560: getfield 40	tga:jdField_b_of_type_Int	I
    //   563: invokestatic 231	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   566: aload_0
    //   567: getfield 238	tga:jdField_b_of_type_Boolean	Z
    //   570: ifeq +6 -> 576
    //   573: invokestatic 240	com/tencent/mobileqq/utils/MusicCacheManager:a	()V
    //   576: aload_0
    //   577: iconst_0
    //   578: putfield 238	tga:jdField_b_of_type_Boolean	Z
    //   581: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   584: ifeq -540 -> 44
    //   587: ldc 84
    //   589: iconst_2
    //   590: ldc -14
    //   592: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: return
    //   596: iload 9
    //   598: iconst_1
    //   599: iadd
    //   600: istore 9
    //   602: aload_2
    //   603: astore_1
    //   604: ldc2_w 243
    //   607: invokestatic 248	java/lang/Thread:sleep	(J)V
    //   610: aload_3
    //   611: astore_1
    //   612: goto -394 -> 218
    //   615: astore 4
    //   617: aload_2
    //   618: astore_1
    //   619: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   622: ifeq +1612 -> 2234
    //   625: aload_2
    //   626: astore_1
    //   627: ldc 84
    //   629: iconst_2
    //   630: new 64	java/lang/StringBuilder
    //   633: dup
    //   634: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   637: ldc -6
    //   639: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: aload 4
    //   644: invokevirtual 251	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   647: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   653: aload 4
    //   655: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   658: goto +1576 -> 2234
    //   661: iload 8
    //   663: istore 7
    //   665: aload_2
    //   666: astore_1
    //   667: aload_0
    //   668: getfield 42	tga:jdField_a_of_type_Int	I
    //   671: ifle +14 -> 685
    //   674: aload_2
    //   675: astore_1
    //   676: iload 8
    //   678: aload_0
    //   679: getfield 42	tga:jdField_a_of_type_Int	I
    //   682: iadd
    //   683: istore 7
    //   685: aload_2
    //   686: astore_1
    //   687: aload_0
    //   688: iload 7
    //   690: putfield 40	tga:jdField_b_of_type_Int	I
    //   693: iload 7
    //   695: istore 8
    //   697: aload_3
    //   698: astore 4
    //   700: aload_2
    //   701: astore_1
    //   702: aload_0
    //   703: getfield 38	tga:jdField_c_of_type_Int	I
    //   706: ifeq +220 -> 926
    //   709: iload 7
    //   711: istore 8
    //   713: aload_3
    //   714: astore 4
    //   716: aload_2
    //   717: astore_1
    //   718: aload_0
    //   719: getfield 38	tga:jdField_c_of_type_Int	I
    //   722: iload 7
    //   724: if_icmpeq +202 -> 926
    //   727: aload_2
    //   728: astore_1
    //   729: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   732: ifeq +43 -> 775
    //   735: aload_2
    //   736: astore_1
    //   737: ldc 84
    //   739: iconst_2
    //   740: new 64	java/lang/StringBuilder
    //   743: dup
    //   744: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   747: ldc -3
    //   749: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: aload_0
    //   753: getfield 38	tga:jdField_c_of_type_Int	I
    //   756: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   759: ldc -1
    //   761: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: iload 7
    //   766: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   769: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   775: aload_2
    //   776: astore_1
    //   777: aload_0
    //   778: iconst_0
    //   779: putfield 42	tga:jdField_a_of_type_Int	I
    //   782: aload_2
    //   783: astore_1
    //   784: aload_0
    //   785: iconst_1
    //   786: putfield 26	tga:d	Z
    //   789: aload_2
    //   790: astore_1
    //   791: aload 6
    //   793: invokevirtual 188	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   796: checkcast 190	java/net/HttpURLConnection
    //   799: astore 4
    //   801: aload_2
    //   802: astore_1
    //   803: aload 4
    //   805: iconst_1
    //   806: invokevirtual 194	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   809: aload_2
    //   810: astore_1
    //   811: aload 4
    //   813: ldc -60
    //   815: ldc -58
    //   817: invokevirtual 202	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   820: aload_2
    //   821: astore_1
    //   822: aload 4
    //   824: invokevirtual 214	java/net/HttpURLConnection:connect	()V
    //   827: aload_2
    //   828: astore_1
    //   829: aload 4
    //   831: invokevirtual 218	java/net/HttpURLConnection:getContentLength	()I
    //   834: istore 8
    //   836: iload 8
    //   838: ifge +80 -> 918
    //   841: aload_2
    //   842: astore_1
    //   843: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   846: ifeq +14 -> 860
    //   849: aload_2
    //   850: astore_1
    //   851: ldc 84
    //   853: iconst_2
    //   854: ldc_w 257
    //   857: invokestatic 223	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   860: aload_2
    //   861: astore_1
    //   862: aload_0
    //   863: getfield 16	tga:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   866: bipush 7
    //   868: invokestatic 184	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   871: aload_0
    //   872: iconst_0
    //   873: putfield 126	tga:jdField_c_of_type_Boolean	Z
    //   876: aload_2
    //   877: ifnull +7 -> 884
    //   880: aload_2
    //   881: invokevirtual 226	java/io/RandomAccessFile:close	()V
    //   884: aload_0
    //   885: getfield 42	tga:jdField_a_of_type_Int	I
    //   888: aload_0
    //   889: getfield 40	tga:jdField_b_of_type_Int	I
    //   892: if_icmpge -848 -> 44
    //   895: aload_0
    //   896: getfield 40	tga:jdField_b_of_type_Int	I
    //   899: ifle -855 -> 44
    //   902: aload_0
    //   903: getfield 36	tga:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   906: aload_0
    //   907: getfield 42	tga:jdField_a_of_type_Int	I
    //   910: aload_0
    //   911: getfield 40	tga:jdField_b_of_type_Int	I
    //   914: invokestatic 231	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   917: return
    //   918: aload_2
    //   919: astore_1
    //   920: aload_0
    //   921: iload 8
    //   923: putfield 40	tga:jdField_b_of_type_Int	I
    //   926: aload_2
    //   927: astore_1
    //   928: aload_2
    //   929: iload 8
    //   931: i2l
    //   932: invokevirtual 260	java/io/RandomAccessFile:setLength	(J)V
    //   935: aload_2
    //   936: astore_1
    //   937: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   940: ifeq +60 -> 1000
    //   943: aload_2
    //   944: astore_1
    //   945: ldc 84
    //   947: iconst_2
    //   948: new 64	java/lang/StringBuilder
    //   951: dup
    //   952: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   955: ldc_w 262
    //   958: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: aload_0
    //   962: getfield 42	tga:jdField_a_of_type_Int	I
    //   965: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   968: ldc_w 264
    //   971: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: aload_0
    //   975: getfield 38	tga:jdField_c_of_type_Int	I
    //   978: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   981: ldc_w 266
    //   984: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: aload_0
    //   988: getfield 40	tga:jdField_b_of_type_Int	I
    //   991: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   994: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   997: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1000: aload_2
    //   1001: astore_1
    //   1002: aload 4
    //   1004: invokevirtual 270	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1007: astore_3
    //   1008: aload_2
    //   1009: astore_1
    //   1010: sipush 8192
    //   1013: newarray <illegal type>
    //   1015: astore 4
    //   1017: aload_2
    //   1018: astore_1
    //   1019: aload_2
    //   1020: aload_0
    //   1021: getfield 42	tga:jdField_a_of_type_Int	I
    //   1024: i2l
    //   1025: invokevirtual 273	java/io/RandomAccessFile:seek	(J)V
    //   1028: aload_2
    //   1029: astore_1
    //   1030: aload_0
    //   1031: getfield 38	tga:jdField_c_of_type_Int	I
    //   1034: ifne +20 -> 1054
    //   1037: aload_2
    //   1038: astore_1
    //   1039: aload_0
    //   1040: getfield 36	tga:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1043: aload_0
    //   1044: getfield 42	tga:jdField_a_of_type_Int	I
    //   1047: aload_0
    //   1048: getfield 40	tga:jdField_b_of_type_Int	I
    //   1051: invokestatic 231	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1054: aload_2
    //   1055: astore_1
    //   1056: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1059: ifeq +1180 -> 2239
    //   1062: aload_2
    //   1063: astore_1
    //   1064: ldc 84
    //   1066: iconst_2
    //   1067: new 64	java/lang/StringBuilder
    //   1070: dup
    //   1071: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1074: ldc_w 275
    //   1077: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1080: aload_0
    //   1081: getfield 42	tga:jdField_a_of_type_Int	I
    //   1084: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1087: ldc_w 266
    //   1090: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: aload_0
    //   1094: getfield 40	tga:jdField_b_of_type_Int	I
    //   1097: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1100: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1103: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1106: goto +1133 -> 2239
    //   1109: aload_2
    //   1110: astore_1
    //   1111: aload_0
    //   1112: getfield 277	tga:jdField_a_of_type_Boolean	Z
    //   1115: ifne +425 -> 1540
    //   1118: aload_2
    //   1119: astore_1
    //   1120: aload_0
    //   1121: getfield 42	tga:jdField_a_of_type_Int	I
    //   1124: aload_0
    //   1125: getfield 40	tga:jdField_b_of_type_Int	I
    //   1128: if_icmpge +412 -> 1540
    //   1131: iload 7
    //   1133: bipush 10
    //   1135: if_icmpge +405 -> 1540
    //   1138: aload_2
    //   1139: astore_1
    //   1140: aload_0
    //   1141: getfield 26	tga:d	Z
    //   1144: ifeq +166 -> 1310
    //   1147: aload_2
    //   1148: astore_1
    //   1149: invokestatic 147	com/tencent/mobileqq/music/QQPlayerService:b	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1152: getfield 150	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1155: aload_0
    //   1156: getfield 34	tga:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1159: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1162: ifeq +148 -> 1310
    //   1165: aload_2
    //   1166: astore_1
    //   1167: aload_0
    //   1168: getfield 42	tga:jdField_a_of_type_Int	I
    //   1171: i2f
    //   1172: aload_0
    //   1173: getfield 40	tga:jdField_b_of_type_Int	I
    //   1176: i2f
    //   1177: aload_0
    //   1178: getfield 16	tga:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1181: getfield 159	com/tencent/mobileqq/music/QQPlayerService:a	F
    //   1184: fmul
    //   1185: fcmpl
    //   1186: ifle +124 -> 1310
    //   1189: aload_2
    //   1190: astore_1
    //   1191: invokestatic 164	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1194: invokevirtual 169	android/media/MediaPlayer:reset	()V
    //   1197: aload_2
    //   1198: astore_1
    //   1199: invokestatic 164	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1202: aload 5
    //   1204: invokevirtual 172	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1207: invokevirtual 175	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   1210: aload_2
    //   1211: astore_1
    //   1212: invokestatic 164	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1215: invokevirtual 178	android/media/MediaPlayer:prepare	()V
    //   1218: aload_2
    //   1219: astore_1
    //   1220: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1223: ifeq +50 -> 1273
    //   1226: aload_2
    //   1227: astore_1
    //   1228: ldc 84
    //   1230: iconst_2
    //   1231: new 64	java/lang/StringBuilder
    //   1234: dup
    //   1235: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1238: ldc_w 279
    //   1241: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1244: aload_0
    //   1245: getfield 42	tga:jdField_a_of_type_Int	I
    //   1248: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1251: ldc_w 281
    //   1254: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: aload_0
    //   1258: getfield 16	tga:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1261: invokestatic 284	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;)Z
    //   1264: invokevirtual 287	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1267: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1270: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1273: aload_2
    //   1274: astore_1
    //   1275: aload_0
    //   1276: getfield 16	tga:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1279: invokestatic 284	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;)Z
    //   1282: ifne +21 -> 1303
    //   1285: aload_2
    //   1286: astore_1
    //   1287: invokestatic 164	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1290: invokevirtual 181	android/media/MediaPlayer:start	()V
    //   1293: aload_2
    //   1294: astore_1
    //   1295: aload_0
    //   1296: getfield 16	tga:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1299: iconst_2
    //   1300: invokestatic 184	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   1303: aload_2
    //   1304: astore_1
    //   1305: aload_0
    //   1306: iconst_0
    //   1307: putfield 26	tga:d	Z
    //   1310: aload_2
    //   1311: astore_1
    //   1312: aload_3
    //   1313: aload 4
    //   1315: invokevirtual 293	java/io/InputStream:read	([B)I
    //   1318: istore 8
    //   1320: iload 8
    //   1322: ifgt +188 -> 1510
    //   1325: aload_2
    //   1326: astore_1
    //   1327: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1330: ifeq +14 -> 1344
    //   1333: aload_2
    //   1334: astore_1
    //   1335: ldc 84
    //   1337: iconst_2
    //   1338: ldc_w 295
    //   1341: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1344: aload_2
    //   1345: astore_1
    //   1346: ldc2_w 243
    //   1349: invokestatic 248	java/lang/Thread:sleep	(J)V
    //   1352: iload 7
    //   1354: iconst_1
    //   1355: iadd
    //   1356: istore 7
    //   1358: goto -249 -> 1109
    //   1361: astore 6
    //   1363: aload_2
    //   1364: astore_1
    //   1365: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1368: ifeq -16 -> 1352
    //   1371: aload_2
    //   1372: astore_1
    //   1373: ldc 84
    //   1375: iconst_2
    //   1376: new 64	java/lang/StringBuilder
    //   1379: dup
    //   1380: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1383: ldc_w 297
    //   1386: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1389: aload 6
    //   1391: invokevirtual 251	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   1394: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1400: aload 6
    //   1402: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1405: goto -53 -> 1352
    //   1408: astore_3
    //   1409: aload_2
    //   1410: astore_1
    //   1411: aload_0
    //   1412: getfield 16	tga:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1415: invokevirtual 119	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   1418: invokestatic 122	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   1421: aload_2
    //   1422: astore_1
    //   1423: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1426: ifeq +35 -> 1461
    //   1429: aload_2
    //   1430: astore_1
    //   1431: ldc 84
    //   1433: iconst_2
    //   1434: new 64	java/lang/StringBuilder
    //   1437: dup
    //   1438: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1441: ldc_w 299
    //   1444: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: aload_3
    //   1448: invokevirtual 300	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   1451: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1454: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1457: aload_3
    //   1458: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1461: aload_0
    //   1462: iconst_0
    //   1463: putfield 126	tga:jdField_c_of_type_Boolean	Z
    //   1466: aload_2
    //   1467: ifnull +7 -> 1474
    //   1470: aload_2
    //   1471: invokevirtual 226	java/io/RandomAccessFile:close	()V
    //   1474: aload_0
    //   1475: getfield 42	tga:jdField_a_of_type_Int	I
    //   1478: aload_0
    //   1479: getfield 40	tga:jdField_b_of_type_Int	I
    //   1482: if_icmpge -916 -> 566
    //   1485: aload_0
    //   1486: getfield 40	tga:jdField_b_of_type_Int	I
    //   1489: ifle -923 -> 566
    //   1492: aload_0
    //   1493: getfield 36	tga:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1496: aload_0
    //   1497: getfield 42	tga:jdField_a_of_type_Int	I
    //   1500: aload_0
    //   1501: getfield 40	tga:jdField_b_of_type_Int	I
    //   1504: invokestatic 231	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1507: goto -941 -> 566
    //   1510: aload_2
    //   1511: astore_1
    //   1512: aload_0
    //   1513: aload_0
    //   1514: getfield 42	tga:jdField_a_of_type_Int	I
    //   1517: iload 8
    //   1519: iadd
    //   1520: putfield 42	tga:jdField_a_of_type_Int	I
    //   1523: aload_2
    //   1524: astore_1
    //   1525: aload_2
    //   1526: aload 4
    //   1528: iconst_0
    //   1529: iload 8
    //   1531: invokevirtual 304	java/io/RandomAccessFile:write	([BII)V
    //   1534: iconst_0
    //   1535: istore 7
    //   1537: goto -428 -> 1109
    //   1540: aload_2
    //   1541: astore_1
    //   1542: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1545: ifeq +71 -> 1616
    //   1548: aload_2
    //   1549: astore_1
    //   1550: ldc 84
    //   1552: iconst_2
    //   1553: new 64	java/lang/StringBuilder
    //   1556: dup
    //   1557: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1560: ldc_w 306
    //   1563: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1566: aload_0
    //   1567: getfield 42	tga:jdField_a_of_type_Int	I
    //   1570: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1573: ldc_w 308
    //   1576: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1579: iload 7
    //   1581: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1584: ldc_w 266
    //   1587: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: aload_0
    //   1591: getfield 40	tga:jdField_b_of_type_Int	I
    //   1594: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1597: ldc_w 264
    //   1600: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1603: aload_0
    //   1604: getfield 38	tga:jdField_c_of_type_Int	I
    //   1607: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1610: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1613: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1616: aload_3
    //   1617: ifnull +9 -> 1626
    //   1620: aload_2
    //   1621: astore_1
    //   1622: aload_3
    //   1623: invokevirtual 309	java/io/InputStream:close	()V
    //   1626: aload_2
    //   1627: astore_1
    //   1628: aload_0
    //   1629: getfield 42	tga:jdField_a_of_type_Int	I
    //   1632: aload_0
    //   1633: getfield 40	tga:jdField_b_of_type_Int	I
    //   1636: if_icmpne +21 -> 1657
    //   1639: aload_2
    //   1640: astore_1
    //   1641: aload_0
    //   1642: getfield 40	tga:jdField_b_of_type_Int	I
    //   1645: ifle +12 -> 1657
    //   1648: aload_2
    //   1649: astore_1
    //   1650: aload_0
    //   1651: getfield 36	tga:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1654: invokestatic 311	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;)V
    //   1657: aload_0
    //   1658: iconst_0
    //   1659: putfield 126	tga:jdField_c_of_type_Boolean	Z
    //   1662: aload_2
    //   1663: ifnull +7 -> 1670
    //   1666: aload_2
    //   1667: invokevirtual 226	java/io/RandomAccessFile:close	()V
    //   1670: aload_0
    //   1671: getfield 42	tga:jdField_a_of_type_Int	I
    //   1674: aload_0
    //   1675: getfield 40	tga:jdField_b_of_type_Int	I
    //   1678: if_icmpge -1112 -> 566
    //   1681: aload_0
    //   1682: getfield 40	tga:jdField_b_of_type_Int	I
    //   1685: ifle -1119 -> 566
    //   1688: aload_0
    //   1689: getfield 36	tga:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1692: aload_0
    //   1693: getfield 42	tga:jdField_a_of_type_Int	I
    //   1696: aload_0
    //   1697: getfield 40	tga:jdField_b_of_type_Int	I
    //   1700: invokestatic 231	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1703: goto -1137 -> 566
    //   1706: astore_3
    //   1707: aconst_null
    //   1708: astore_2
    //   1709: aload_2
    //   1710: astore_1
    //   1711: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1714: ifeq +35 -> 1749
    //   1717: aload_2
    //   1718: astore_1
    //   1719: ldc 84
    //   1721: iconst_2
    //   1722: new 64	java/lang/StringBuilder
    //   1725: dup
    //   1726: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1729: ldc_w 313
    //   1732: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1735: aload_3
    //   1736: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1739: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1742: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1745: aload_3
    //   1746: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1749: aload_2
    //   1750: astore_1
    //   1751: invokestatic 147	com/tencent/mobileqq/music/QQPlayerService:b	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1754: ifnull +48 -> 1802
    //   1757: aload_2
    //   1758: astore_1
    //   1759: invokestatic 164	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1762: ifnull +40 -> 1802
    //   1765: aload_2
    //   1766: astore_1
    //   1767: aload_0
    //   1768: getfield 34	tga:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1771: invokestatic 147	com/tencent/mobileqq/music/QQPlayerService:b	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1774: getfield 150	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1777: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1780: ifeq +22 -> 1802
    //   1783: aload_2
    //   1784: astore_1
    //   1785: invokestatic 164	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1788: invokevirtual 169	android/media/MediaPlayer:reset	()V
    //   1791: aload_2
    //   1792: astore_1
    //   1793: aload_0
    //   1794: getfield 16	tga:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1797: bipush 6
    //   1799: invokestatic 184	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   1802: aload_2
    //   1803: astore_1
    //   1804: invokestatic 316	com/tencent/mobileqq/music/QQPlayerService:b	()[Lcom/tencent/mobileqq/music/SongInfo;
    //   1807: ifnull +44 -> 1851
    //   1810: aload_2
    //   1811: astore_1
    //   1812: invokestatic 316	com/tencent/mobileqq/music/QQPlayerService:b	()[Lcom/tencent/mobileqq/music/SongInfo;
    //   1815: arraylength
    //   1816: iconst_1
    //   1817: if_icmpne +34 -> 1851
    //   1820: aload_2
    //   1821: astore_1
    //   1822: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1825: ifeq +14 -> 1839
    //   1828: aload_2
    //   1829: astore_1
    //   1830: ldc 84
    //   1832: iconst_2
    //   1833: ldc_w 318
    //   1836: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1839: aload_2
    //   1840: astore_1
    //   1841: aload_0
    //   1842: getfield 16	tga:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1845: invokevirtual 119	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   1848: invokestatic 122	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   1851: aload_0
    //   1852: iconst_0
    //   1853: putfield 126	tga:jdField_c_of_type_Boolean	Z
    //   1856: aload_2
    //   1857: ifnull +7 -> 1864
    //   1860: aload_2
    //   1861: invokevirtual 226	java/io/RandomAccessFile:close	()V
    //   1864: aload_0
    //   1865: getfield 42	tga:jdField_a_of_type_Int	I
    //   1868: aload_0
    //   1869: getfield 40	tga:jdField_b_of_type_Int	I
    //   1872: if_icmpge -1306 -> 566
    //   1875: aload_0
    //   1876: getfield 40	tga:jdField_b_of_type_Int	I
    //   1879: ifle -1313 -> 566
    //   1882: aload_0
    //   1883: getfield 36	tga:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1886: aload_0
    //   1887: getfield 42	tga:jdField_a_of_type_Int	I
    //   1890: aload_0
    //   1891: getfield 40	tga:jdField_b_of_type_Int	I
    //   1894: invokestatic 231	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1897: goto -1331 -> 566
    //   1900: astore_3
    //   1901: aconst_null
    //   1902: astore_2
    //   1903: aload_2
    //   1904: astore_1
    //   1905: aload_0
    //   1906: getfield 16	tga:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1909: invokevirtual 119	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   1912: invokestatic 122	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   1915: aload_2
    //   1916: astore_1
    //   1917: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1920: ifeq +35 -> 1955
    //   1923: aload_2
    //   1924: astore_1
    //   1925: ldc 84
    //   1927: iconst_2
    //   1928: new 64	java/lang/StringBuilder
    //   1931: dup
    //   1932: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1935: ldc_w 320
    //   1938: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1941: aload_3
    //   1942: invokevirtual 321	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   1945: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1951: aload_3
    //   1952: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1955: aload_0
    //   1956: iconst_0
    //   1957: putfield 126	tga:jdField_c_of_type_Boolean	Z
    //   1960: aload_2
    //   1961: ifnull +7 -> 1968
    //   1964: aload_2
    //   1965: invokevirtual 226	java/io/RandomAccessFile:close	()V
    //   1968: aload_0
    //   1969: getfield 42	tga:jdField_a_of_type_Int	I
    //   1972: aload_0
    //   1973: getfield 40	tga:jdField_b_of_type_Int	I
    //   1976: if_icmpge -1410 -> 566
    //   1979: aload_0
    //   1980: getfield 40	tga:jdField_b_of_type_Int	I
    //   1983: ifle -1417 -> 566
    //   1986: aload_0
    //   1987: getfield 36	tga:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1990: aload_0
    //   1991: getfield 42	tga:jdField_a_of_type_Int	I
    //   1994: aload_0
    //   1995: getfield 40	tga:jdField_b_of_type_Int	I
    //   1998: invokestatic 231	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   2001: goto -1435 -> 566
    //   2004: astore_3
    //   2005: aconst_null
    //   2006: astore_2
    //   2007: aload_2
    //   2008: astore_1
    //   2009: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2012: ifeq +35 -> 2047
    //   2015: aload_2
    //   2016: astore_1
    //   2017: ldc 84
    //   2019: iconst_2
    //   2020: new 64	java/lang/StringBuilder
    //   2023: dup
    //   2024: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2027: ldc_w 323
    //   2030: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2033: aload_3
    //   2034: invokevirtual 324	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2037: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2040: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2043: aload_3
    //   2044: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2047: aload_2
    //   2048: astore_1
    //   2049: aload_0
    //   2050: getfield 16	tga:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2053: invokevirtual 119	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2056: invokestatic 122	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   2059: aload_0
    //   2060: iconst_0
    //   2061: putfield 126	tga:jdField_c_of_type_Boolean	Z
    //   2064: aload_2
    //   2065: ifnull +7 -> 2072
    //   2068: aload_2
    //   2069: invokevirtual 226	java/io/RandomAccessFile:close	()V
    //   2072: aload_0
    //   2073: getfield 42	tga:jdField_a_of_type_Int	I
    //   2076: aload_0
    //   2077: getfield 40	tga:jdField_b_of_type_Int	I
    //   2080: if_icmpge -1514 -> 566
    //   2083: aload_0
    //   2084: getfield 40	tga:jdField_b_of_type_Int	I
    //   2087: ifle -1521 -> 566
    //   2090: aload_0
    //   2091: getfield 36	tga:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2094: aload_0
    //   2095: getfield 42	tga:jdField_a_of_type_Int	I
    //   2098: aload_0
    //   2099: getfield 40	tga:jdField_b_of_type_Int	I
    //   2102: invokestatic 231	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   2105: goto -1539 -> 566
    //   2108: astore_2
    //   2109: aconst_null
    //   2110: astore_1
    //   2111: aload_0
    //   2112: iconst_0
    //   2113: putfield 126	tga:jdField_c_of_type_Boolean	Z
    //   2116: aload_1
    //   2117: ifnull +7 -> 2124
    //   2120: aload_1
    //   2121: invokevirtual 226	java/io/RandomAccessFile:close	()V
    //   2124: aload_0
    //   2125: getfield 42	tga:jdField_a_of_type_Int	I
    //   2128: aload_0
    //   2129: getfield 40	tga:jdField_b_of_type_Int	I
    //   2132: if_icmpge +25 -> 2157
    //   2135: aload_0
    //   2136: getfield 40	tga:jdField_b_of_type_Int	I
    //   2139: ifle +18 -> 2157
    //   2142: aload_0
    //   2143: getfield 36	tga:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2146: aload_0
    //   2147: getfield 42	tga:jdField_a_of_type_Int	I
    //   2150: aload_0
    //   2151: getfield 40	tga:jdField_b_of_type_Int	I
    //   2154: invokestatic 231	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   2157: aload_2
    //   2158: athrow
    //   2159: astore_1
    //   2160: goto -1757 -> 403
    //   2163: astore_1
    //   2164: goto -1280 -> 884
    //   2167: astore_1
    //   2168: goto -498 -> 1670
    //   2171: astore_1
    //   2172: goto -1639 -> 533
    //   2175: astore_1
    //   2176: goto -702 -> 1474
    //   2179: astore_1
    //   2180: goto -316 -> 1864
    //   2183: astore_1
    //   2184: goto -216 -> 1968
    //   2187: astore_1
    //   2188: goto -116 -> 2072
    //   2191: astore_1
    //   2192: goto -68 -> 2124
    //   2195: astore_2
    //   2196: goto -85 -> 2111
    //   2199: astore_3
    //   2200: goto -193 -> 2007
    //   2203: astore_3
    //   2204: goto -301 -> 1903
    //   2207: astore_3
    //   2208: goto -499 -> 1709
    //   2211: astore_3
    //   2212: aconst_null
    //   2213: astore_2
    //   2214: goto -805 -> 1409
    //   2217: astore_3
    //   2218: aconst_null
    //   2219: astore_2
    //   2220: goto -1751 -> 469
    //   2223: iconst_0
    //   2224: istore 9
    //   2226: iconst_0
    //   2227: istore 7
    //   2229: aload_3
    //   2230: astore_1
    //   2231: goto -2013 -> 218
    //   2234: aload_3
    //   2235: astore_1
    //   2236: goto -2018 -> 218
    //   2239: iconst_0
    //   2240: istore 7
    //   2242: goto -1133 -> 1109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2245	0	this	tga
    //   5	2116	1	localObject1	Object
    //   2159	1	1	localIOException1	IOException
    //   2163	1	1	localIOException2	IOException
    //   2167	1	1	localIOException3	IOException
    //   2171	1	1	localIOException4	IOException
    //   2175	1	1	localIOException5	IOException
    //   2179	1	1	localIOException6	IOException
    //   2183	1	1	localIOException7	IOException
    //   2187	1	1	localIOException8	IOException
    //   2191	1	1	localIOException9	IOException
    //   2230	6	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   71	1998	2	localRandomAccessFile	java.io.RandomAccessFile
    //   2108	50	2	localObject2	Object
    //   2195	1	2	localObject3	Object
    //   2213	7	2	localObject4	Object
    //   1	341	3	localObject5	Object
    //   468	246	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   1007	306	3	localInputStream	java.io.InputStream
    //   1408	215	3	localMalformedURLException1	java.net.MalformedURLException
    //   1706	40	3	localIOException10	IOException
    //   1900	52	3	localIllegalStateException1	IllegalStateException
    //   2004	40	3	localException1	Exception
    //   2199	1	3	localException2	Exception
    //   2203	1	3	localIllegalStateException2	IllegalStateException
    //   2207	1	3	localIOException11	IOException
    //   2211	1	3	localMalformedURLException2	java.net.MalformedURLException
    //   2217	18	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   615	39	4	localInterruptedException1	InterruptedException
    //   698	829	4	localObject6	Object
    //   53	1150	5	localFile	File
    //   90	702	6	localURL	java.net.URL
    //   1361	40	6	localInterruptedException2	InterruptedException
    //   218	2023	7	i	int
    //   220	1310	8	j	int
    //   235	1990	9	k	int
    // Exception table:
    //   from	to	target	type
    //   74	92	468	java/io/FileNotFoundException
    //   94	110	468	java/io/FileNotFoundException
    //   112	119	468	java/io/FileNotFoundException
    //   121	143	468	java/io/FileNotFoundException
    //   145	151	468	java/io/FileNotFoundException
    //   153	161	468	java/io/FileNotFoundException
    //   163	169	468	java/io/FileNotFoundException
    //   171	182	468	java/io/FileNotFoundException
    //   184	190	468	java/io/FileNotFoundException
    //   192	198	468	java/io/FileNotFoundException
    //   200	208	468	java/io/FileNotFoundException
    //   210	215	468	java/io/FileNotFoundException
    //   243	252	468	java/io/FileNotFoundException
    //   254	259	468	java/io/FileNotFoundException
    //   261	269	468	java/io/FileNotFoundException
    //   271	278	468	java/io/FileNotFoundException
    //   280	291	468	java/io/FileNotFoundException
    //   293	333	468	java/io/FileNotFoundException
    //   335	339	468	java/io/FileNotFoundException
    //   341	347	468	java/io/FileNotFoundException
    //   363	369	468	java/io/FileNotFoundException
    //   371	379	468	java/io/FileNotFoundException
    //   381	390	468	java/io/FileNotFoundException
    //   439	445	468	java/io/FileNotFoundException
    //   447	455	468	java/io/FileNotFoundException
    //   457	465	468	java/io/FileNotFoundException
    //   604	610	468	java/io/FileNotFoundException
    //   619	625	468	java/io/FileNotFoundException
    //   627	658	468	java/io/FileNotFoundException
    //   667	674	468	java/io/FileNotFoundException
    //   676	685	468	java/io/FileNotFoundException
    //   687	693	468	java/io/FileNotFoundException
    //   702	709	468	java/io/FileNotFoundException
    //   718	727	468	java/io/FileNotFoundException
    //   729	735	468	java/io/FileNotFoundException
    //   737	775	468	java/io/FileNotFoundException
    //   777	782	468	java/io/FileNotFoundException
    //   784	789	468	java/io/FileNotFoundException
    //   791	801	468	java/io/FileNotFoundException
    //   803	809	468	java/io/FileNotFoundException
    //   811	820	468	java/io/FileNotFoundException
    //   822	827	468	java/io/FileNotFoundException
    //   829	836	468	java/io/FileNotFoundException
    //   843	849	468	java/io/FileNotFoundException
    //   851	860	468	java/io/FileNotFoundException
    //   862	871	468	java/io/FileNotFoundException
    //   920	926	468	java/io/FileNotFoundException
    //   928	935	468	java/io/FileNotFoundException
    //   937	943	468	java/io/FileNotFoundException
    //   945	1000	468	java/io/FileNotFoundException
    //   1002	1008	468	java/io/FileNotFoundException
    //   1010	1017	468	java/io/FileNotFoundException
    //   1019	1028	468	java/io/FileNotFoundException
    //   1030	1037	468	java/io/FileNotFoundException
    //   1039	1054	468	java/io/FileNotFoundException
    //   1056	1062	468	java/io/FileNotFoundException
    //   1064	1106	468	java/io/FileNotFoundException
    //   1111	1118	468	java/io/FileNotFoundException
    //   1120	1131	468	java/io/FileNotFoundException
    //   1140	1147	468	java/io/FileNotFoundException
    //   1149	1165	468	java/io/FileNotFoundException
    //   1167	1189	468	java/io/FileNotFoundException
    //   1191	1197	468	java/io/FileNotFoundException
    //   1199	1210	468	java/io/FileNotFoundException
    //   1212	1218	468	java/io/FileNotFoundException
    //   1220	1226	468	java/io/FileNotFoundException
    //   1228	1273	468	java/io/FileNotFoundException
    //   1275	1285	468	java/io/FileNotFoundException
    //   1287	1293	468	java/io/FileNotFoundException
    //   1295	1303	468	java/io/FileNotFoundException
    //   1305	1310	468	java/io/FileNotFoundException
    //   1312	1320	468	java/io/FileNotFoundException
    //   1327	1333	468	java/io/FileNotFoundException
    //   1335	1344	468	java/io/FileNotFoundException
    //   1346	1352	468	java/io/FileNotFoundException
    //   1365	1371	468	java/io/FileNotFoundException
    //   1373	1405	468	java/io/FileNotFoundException
    //   1512	1523	468	java/io/FileNotFoundException
    //   1525	1534	468	java/io/FileNotFoundException
    //   1542	1548	468	java/io/FileNotFoundException
    //   1550	1616	468	java/io/FileNotFoundException
    //   1622	1626	468	java/io/FileNotFoundException
    //   1628	1639	468	java/io/FileNotFoundException
    //   1641	1648	468	java/io/FileNotFoundException
    //   1650	1657	468	java/io/FileNotFoundException
    //   604	610	615	java/lang/InterruptedException
    //   1346	1352	1361	java/lang/InterruptedException
    //   74	92	1408	java/net/MalformedURLException
    //   94	110	1408	java/net/MalformedURLException
    //   112	119	1408	java/net/MalformedURLException
    //   121	143	1408	java/net/MalformedURLException
    //   145	151	1408	java/net/MalformedURLException
    //   153	161	1408	java/net/MalformedURLException
    //   163	169	1408	java/net/MalformedURLException
    //   171	182	1408	java/net/MalformedURLException
    //   184	190	1408	java/net/MalformedURLException
    //   192	198	1408	java/net/MalformedURLException
    //   200	208	1408	java/net/MalformedURLException
    //   210	215	1408	java/net/MalformedURLException
    //   243	252	1408	java/net/MalformedURLException
    //   254	259	1408	java/net/MalformedURLException
    //   261	269	1408	java/net/MalformedURLException
    //   271	278	1408	java/net/MalformedURLException
    //   280	291	1408	java/net/MalformedURLException
    //   293	333	1408	java/net/MalformedURLException
    //   335	339	1408	java/net/MalformedURLException
    //   341	347	1408	java/net/MalformedURLException
    //   363	369	1408	java/net/MalformedURLException
    //   371	379	1408	java/net/MalformedURLException
    //   381	390	1408	java/net/MalformedURLException
    //   439	445	1408	java/net/MalformedURLException
    //   447	455	1408	java/net/MalformedURLException
    //   457	465	1408	java/net/MalformedURLException
    //   604	610	1408	java/net/MalformedURLException
    //   619	625	1408	java/net/MalformedURLException
    //   627	658	1408	java/net/MalformedURLException
    //   667	674	1408	java/net/MalformedURLException
    //   676	685	1408	java/net/MalformedURLException
    //   687	693	1408	java/net/MalformedURLException
    //   702	709	1408	java/net/MalformedURLException
    //   718	727	1408	java/net/MalformedURLException
    //   729	735	1408	java/net/MalformedURLException
    //   737	775	1408	java/net/MalformedURLException
    //   777	782	1408	java/net/MalformedURLException
    //   784	789	1408	java/net/MalformedURLException
    //   791	801	1408	java/net/MalformedURLException
    //   803	809	1408	java/net/MalformedURLException
    //   811	820	1408	java/net/MalformedURLException
    //   822	827	1408	java/net/MalformedURLException
    //   829	836	1408	java/net/MalformedURLException
    //   843	849	1408	java/net/MalformedURLException
    //   851	860	1408	java/net/MalformedURLException
    //   862	871	1408	java/net/MalformedURLException
    //   920	926	1408	java/net/MalformedURLException
    //   928	935	1408	java/net/MalformedURLException
    //   937	943	1408	java/net/MalformedURLException
    //   945	1000	1408	java/net/MalformedURLException
    //   1002	1008	1408	java/net/MalformedURLException
    //   1010	1017	1408	java/net/MalformedURLException
    //   1019	1028	1408	java/net/MalformedURLException
    //   1030	1037	1408	java/net/MalformedURLException
    //   1039	1054	1408	java/net/MalformedURLException
    //   1056	1062	1408	java/net/MalformedURLException
    //   1064	1106	1408	java/net/MalformedURLException
    //   1111	1118	1408	java/net/MalformedURLException
    //   1120	1131	1408	java/net/MalformedURLException
    //   1140	1147	1408	java/net/MalformedURLException
    //   1149	1165	1408	java/net/MalformedURLException
    //   1167	1189	1408	java/net/MalformedURLException
    //   1191	1197	1408	java/net/MalformedURLException
    //   1199	1210	1408	java/net/MalformedURLException
    //   1212	1218	1408	java/net/MalformedURLException
    //   1220	1226	1408	java/net/MalformedURLException
    //   1228	1273	1408	java/net/MalformedURLException
    //   1275	1285	1408	java/net/MalformedURLException
    //   1287	1293	1408	java/net/MalformedURLException
    //   1295	1303	1408	java/net/MalformedURLException
    //   1305	1310	1408	java/net/MalformedURLException
    //   1312	1320	1408	java/net/MalformedURLException
    //   1327	1333	1408	java/net/MalformedURLException
    //   1335	1344	1408	java/net/MalformedURLException
    //   1346	1352	1408	java/net/MalformedURLException
    //   1365	1371	1408	java/net/MalformedURLException
    //   1373	1405	1408	java/net/MalformedURLException
    //   1512	1523	1408	java/net/MalformedURLException
    //   1525	1534	1408	java/net/MalformedURLException
    //   1542	1548	1408	java/net/MalformedURLException
    //   1550	1616	1408	java/net/MalformedURLException
    //   1622	1626	1408	java/net/MalformedURLException
    //   1628	1639	1408	java/net/MalformedURLException
    //   1641	1648	1408	java/net/MalformedURLException
    //   1650	1657	1408	java/net/MalformedURLException
    //   60	72	1706	java/io/IOException
    //   60	72	1900	java/lang/IllegalStateException
    //   60	72	2004	java/lang/Exception
    //   60	72	2108	finally
    //   399	403	2159	java/io/IOException
    //   880	884	2163	java/io/IOException
    //   1666	1670	2167	java/io/IOException
    //   529	533	2171	java/io/IOException
    //   1470	1474	2175	java/io/IOException
    //   1860	1864	2179	java/io/IOException
    //   1964	1968	2183	java/io/IOException
    //   2068	2072	2187	java/io/IOException
    //   2120	2124	2191	java/io/IOException
    //   74	92	2195	finally
    //   94	110	2195	finally
    //   112	119	2195	finally
    //   121	143	2195	finally
    //   145	151	2195	finally
    //   153	161	2195	finally
    //   163	169	2195	finally
    //   171	182	2195	finally
    //   184	190	2195	finally
    //   192	198	2195	finally
    //   200	208	2195	finally
    //   210	215	2195	finally
    //   243	252	2195	finally
    //   254	259	2195	finally
    //   261	269	2195	finally
    //   271	278	2195	finally
    //   280	291	2195	finally
    //   293	333	2195	finally
    //   335	339	2195	finally
    //   341	347	2195	finally
    //   363	369	2195	finally
    //   371	379	2195	finally
    //   381	390	2195	finally
    //   439	445	2195	finally
    //   447	455	2195	finally
    //   457	465	2195	finally
    //   471	477	2195	finally
    //   479	508	2195	finally
    //   510	520	2195	finally
    //   604	610	2195	finally
    //   619	625	2195	finally
    //   627	658	2195	finally
    //   667	674	2195	finally
    //   676	685	2195	finally
    //   687	693	2195	finally
    //   702	709	2195	finally
    //   718	727	2195	finally
    //   729	735	2195	finally
    //   737	775	2195	finally
    //   777	782	2195	finally
    //   784	789	2195	finally
    //   791	801	2195	finally
    //   803	809	2195	finally
    //   811	820	2195	finally
    //   822	827	2195	finally
    //   829	836	2195	finally
    //   843	849	2195	finally
    //   851	860	2195	finally
    //   862	871	2195	finally
    //   920	926	2195	finally
    //   928	935	2195	finally
    //   937	943	2195	finally
    //   945	1000	2195	finally
    //   1002	1008	2195	finally
    //   1010	1017	2195	finally
    //   1019	1028	2195	finally
    //   1030	1037	2195	finally
    //   1039	1054	2195	finally
    //   1056	1062	2195	finally
    //   1064	1106	2195	finally
    //   1111	1118	2195	finally
    //   1120	1131	2195	finally
    //   1140	1147	2195	finally
    //   1149	1165	2195	finally
    //   1167	1189	2195	finally
    //   1191	1197	2195	finally
    //   1199	1210	2195	finally
    //   1212	1218	2195	finally
    //   1220	1226	2195	finally
    //   1228	1273	2195	finally
    //   1275	1285	2195	finally
    //   1287	1293	2195	finally
    //   1295	1303	2195	finally
    //   1305	1310	2195	finally
    //   1312	1320	2195	finally
    //   1327	1333	2195	finally
    //   1335	1344	2195	finally
    //   1346	1352	2195	finally
    //   1365	1371	2195	finally
    //   1373	1405	2195	finally
    //   1411	1421	2195	finally
    //   1423	1429	2195	finally
    //   1431	1461	2195	finally
    //   1512	1523	2195	finally
    //   1525	1534	2195	finally
    //   1542	1548	2195	finally
    //   1550	1616	2195	finally
    //   1622	1626	2195	finally
    //   1628	1639	2195	finally
    //   1641	1648	2195	finally
    //   1650	1657	2195	finally
    //   1711	1717	2195	finally
    //   1719	1749	2195	finally
    //   1751	1757	2195	finally
    //   1759	1765	2195	finally
    //   1767	1783	2195	finally
    //   1785	1791	2195	finally
    //   1793	1802	2195	finally
    //   1804	1810	2195	finally
    //   1812	1820	2195	finally
    //   1822	1828	2195	finally
    //   1830	1839	2195	finally
    //   1841	1851	2195	finally
    //   1905	1915	2195	finally
    //   1917	1923	2195	finally
    //   1925	1955	2195	finally
    //   2009	2015	2195	finally
    //   2017	2047	2195	finally
    //   2049	2059	2195	finally
    //   74	92	2199	java/lang/Exception
    //   94	110	2199	java/lang/Exception
    //   112	119	2199	java/lang/Exception
    //   121	143	2199	java/lang/Exception
    //   145	151	2199	java/lang/Exception
    //   153	161	2199	java/lang/Exception
    //   163	169	2199	java/lang/Exception
    //   171	182	2199	java/lang/Exception
    //   184	190	2199	java/lang/Exception
    //   192	198	2199	java/lang/Exception
    //   200	208	2199	java/lang/Exception
    //   210	215	2199	java/lang/Exception
    //   243	252	2199	java/lang/Exception
    //   254	259	2199	java/lang/Exception
    //   261	269	2199	java/lang/Exception
    //   271	278	2199	java/lang/Exception
    //   280	291	2199	java/lang/Exception
    //   293	333	2199	java/lang/Exception
    //   335	339	2199	java/lang/Exception
    //   341	347	2199	java/lang/Exception
    //   363	369	2199	java/lang/Exception
    //   371	379	2199	java/lang/Exception
    //   381	390	2199	java/lang/Exception
    //   439	445	2199	java/lang/Exception
    //   447	455	2199	java/lang/Exception
    //   457	465	2199	java/lang/Exception
    //   604	610	2199	java/lang/Exception
    //   619	625	2199	java/lang/Exception
    //   627	658	2199	java/lang/Exception
    //   667	674	2199	java/lang/Exception
    //   676	685	2199	java/lang/Exception
    //   687	693	2199	java/lang/Exception
    //   702	709	2199	java/lang/Exception
    //   718	727	2199	java/lang/Exception
    //   729	735	2199	java/lang/Exception
    //   737	775	2199	java/lang/Exception
    //   777	782	2199	java/lang/Exception
    //   784	789	2199	java/lang/Exception
    //   791	801	2199	java/lang/Exception
    //   803	809	2199	java/lang/Exception
    //   811	820	2199	java/lang/Exception
    //   822	827	2199	java/lang/Exception
    //   829	836	2199	java/lang/Exception
    //   843	849	2199	java/lang/Exception
    //   851	860	2199	java/lang/Exception
    //   862	871	2199	java/lang/Exception
    //   920	926	2199	java/lang/Exception
    //   928	935	2199	java/lang/Exception
    //   937	943	2199	java/lang/Exception
    //   945	1000	2199	java/lang/Exception
    //   1002	1008	2199	java/lang/Exception
    //   1010	1017	2199	java/lang/Exception
    //   1019	1028	2199	java/lang/Exception
    //   1030	1037	2199	java/lang/Exception
    //   1039	1054	2199	java/lang/Exception
    //   1056	1062	2199	java/lang/Exception
    //   1064	1106	2199	java/lang/Exception
    //   1111	1118	2199	java/lang/Exception
    //   1120	1131	2199	java/lang/Exception
    //   1140	1147	2199	java/lang/Exception
    //   1149	1165	2199	java/lang/Exception
    //   1167	1189	2199	java/lang/Exception
    //   1191	1197	2199	java/lang/Exception
    //   1199	1210	2199	java/lang/Exception
    //   1212	1218	2199	java/lang/Exception
    //   1220	1226	2199	java/lang/Exception
    //   1228	1273	2199	java/lang/Exception
    //   1275	1285	2199	java/lang/Exception
    //   1287	1293	2199	java/lang/Exception
    //   1295	1303	2199	java/lang/Exception
    //   1305	1310	2199	java/lang/Exception
    //   1312	1320	2199	java/lang/Exception
    //   1327	1333	2199	java/lang/Exception
    //   1335	1344	2199	java/lang/Exception
    //   1346	1352	2199	java/lang/Exception
    //   1365	1371	2199	java/lang/Exception
    //   1373	1405	2199	java/lang/Exception
    //   1512	1523	2199	java/lang/Exception
    //   1525	1534	2199	java/lang/Exception
    //   1542	1548	2199	java/lang/Exception
    //   1550	1616	2199	java/lang/Exception
    //   1622	1626	2199	java/lang/Exception
    //   1628	1639	2199	java/lang/Exception
    //   1641	1648	2199	java/lang/Exception
    //   1650	1657	2199	java/lang/Exception
    //   74	92	2203	java/lang/IllegalStateException
    //   94	110	2203	java/lang/IllegalStateException
    //   112	119	2203	java/lang/IllegalStateException
    //   121	143	2203	java/lang/IllegalStateException
    //   145	151	2203	java/lang/IllegalStateException
    //   153	161	2203	java/lang/IllegalStateException
    //   163	169	2203	java/lang/IllegalStateException
    //   171	182	2203	java/lang/IllegalStateException
    //   184	190	2203	java/lang/IllegalStateException
    //   192	198	2203	java/lang/IllegalStateException
    //   200	208	2203	java/lang/IllegalStateException
    //   210	215	2203	java/lang/IllegalStateException
    //   243	252	2203	java/lang/IllegalStateException
    //   254	259	2203	java/lang/IllegalStateException
    //   261	269	2203	java/lang/IllegalStateException
    //   271	278	2203	java/lang/IllegalStateException
    //   280	291	2203	java/lang/IllegalStateException
    //   293	333	2203	java/lang/IllegalStateException
    //   335	339	2203	java/lang/IllegalStateException
    //   341	347	2203	java/lang/IllegalStateException
    //   363	369	2203	java/lang/IllegalStateException
    //   371	379	2203	java/lang/IllegalStateException
    //   381	390	2203	java/lang/IllegalStateException
    //   439	445	2203	java/lang/IllegalStateException
    //   447	455	2203	java/lang/IllegalStateException
    //   457	465	2203	java/lang/IllegalStateException
    //   604	610	2203	java/lang/IllegalStateException
    //   619	625	2203	java/lang/IllegalStateException
    //   627	658	2203	java/lang/IllegalStateException
    //   667	674	2203	java/lang/IllegalStateException
    //   676	685	2203	java/lang/IllegalStateException
    //   687	693	2203	java/lang/IllegalStateException
    //   702	709	2203	java/lang/IllegalStateException
    //   718	727	2203	java/lang/IllegalStateException
    //   729	735	2203	java/lang/IllegalStateException
    //   737	775	2203	java/lang/IllegalStateException
    //   777	782	2203	java/lang/IllegalStateException
    //   784	789	2203	java/lang/IllegalStateException
    //   791	801	2203	java/lang/IllegalStateException
    //   803	809	2203	java/lang/IllegalStateException
    //   811	820	2203	java/lang/IllegalStateException
    //   822	827	2203	java/lang/IllegalStateException
    //   829	836	2203	java/lang/IllegalStateException
    //   843	849	2203	java/lang/IllegalStateException
    //   851	860	2203	java/lang/IllegalStateException
    //   862	871	2203	java/lang/IllegalStateException
    //   920	926	2203	java/lang/IllegalStateException
    //   928	935	2203	java/lang/IllegalStateException
    //   937	943	2203	java/lang/IllegalStateException
    //   945	1000	2203	java/lang/IllegalStateException
    //   1002	1008	2203	java/lang/IllegalStateException
    //   1010	1017	2203	java/lang/IllegalStateException
    //   1019	1028	2203	java/lang/IllegalStateException
    //   1030	1037	2203	java/lang/IllegalStateException
    //   1039	1054	2203	java/lang/IllegalStateException
    //   1056	1062	2203	java/lang/IllegalStateException
    //   1064	1106	2203	java/lang/IllegalStateException
    //   1111	1118	2203	java/lang/IllegalStateException
    //   1120	1131	2203	java/lang/IllegalStateException
    //   1140	1147	2203	java/lang/IllegalStateException
    //   1149	1165	2203	java/lang/IllegalStateException
    //   1167	1189	2203	java/lang/IllegalStateException
    //   1191	1197	2203	java/lang/IllegalStateException
    //   1199	1210	2203	java/lang/IllegalStateException
    //   1212	1218	2203	java/lang/IllegalStateException
    //   1220	1226	2203	java/lang/IllegalStateException
    //   1228	1273	2203	java/lang/IllegalStateException
    //   1275	1285	2203	java/lang/IllegalStateException
    //   1287	1293	2203	java/lang/IllegalStateException
    //   1295	1303	2203	java/lang/IllegalStateException
    //   1305	1310	2203	java/lang/IllegalStateException
    //   1312	1320	2203	java/lang/IllegalStateException
    //   1327	1333	2203	java/lang/IllegalStateException
    //   1335	1344	2203	java/lang/IllegalStateException
    //   1346	1352	2203	java/lang/IllegalStateException
    //   1365	1371	2203	java/lang/IllegalStateException
    //   1373	1405	2203	java/lang/IllegalStateException
    //   1512	1523	2203	java/lang/IllegalStateException
    //   1525	1534	2203	java/lang/IllegalStateException
    //   1542	1548	2203	java/lang/IllegalStateException
    //   1550	1616	2203	java/lang/IllegalStateException
    //   1622	1626	2203	java/lang/IllegalStateException
    //   1628	1639	2203	java/lang/IllegalStateException
    //   1641	1648	2203	java/lang/IllegalStateException
    //   1650	1657	2203	java/lang/IllegalStateException
    //   74	92	2207	java/io/IOException
    //   94	110	2207	java/io/IOException
    //   112	119	2207	java/io/IOException
    //   121	143	2207	java/io/IOException
    //   145	151	2207	java/io/IOException
    //   153	161	2207	java/io/IOException
    //   163	169	2207	java/io/IOException
    //   171	182	2207	java/io/IOException
    //   184	190	2207	java/io/IOException
    //   192	198	2207	java/io/IOException
    //   200	208	2207	java/io/IOException
    //   210	215	2207	java/io/IOException
    //   243	252	2207	java/io/IOException
    //   254	259	2207	java/io/IOException
    //   261	269	2207	java/io/IOException
    //   271	278	2207	java/io/IOException
    //   280	291	2207	java/io/IOException
    //   293	333	2207	java/io/IOException
    //   335	339	2207	java/io/IOException
    //   341	347	2207	java/io/IOException
    //   363	369	2207	java/io/IOException
    //   371	379	2207	java/io/IOException
    //   381	390	2207	java/io/IOException
    //   439	445	2207	java/io/IOException
    //   447	455	2207	java/io/IOException
    //   457	465	2207	java/io/IOException
    //   604	610	2207	java/io/IOException
    //   619	625	2207	java/io/IOException
    //   627	658	2207	java/io/IOException
    //   667	674	2207	java/io/IOException
    //   676	685	2207	java/io/IOException
    //   687	693	2207	java/io/IOException
    //   702	709	2207	java/io/IOException
    //   718	727	2207	java/io/IOException
    //   729	735	2207	java/io/IOException
    //   737	775	2207	java/io/IOException
    //   777	782	2207	java/io/IOException
    //   784	789	2207	java/io/IOException
    //   791	801	2207	java/io/IOException
    //   803	809	2207	java/io/IOException
    //   811	820	2207	java/io/IOException
    //   822	827	2207	java/io/IOException
    //   829	836	2207	java/io/IOException
    //   843	849	2207	java/io/IOException
    //   851	860	2207	java/io/IOException
    //   862	871	2207	java/io/IOException
    //   920	926	2207	java/io/IOException
    //   928	935	2207	java/io/IOException
    //   937	943	2207	java/io/IOException
    //   945	1000	2207	java/io/IOException
    //   1002	1008	2207	java/io/IOException
    //   1010	1017	2207	java/io/IOException
    //   1019	1028	2207	java/io/IOException
    //   1030	1037	2207	java/io/IOException
    //   1039	1054	2207	java/io/IOException
    //   1056	1062	2207	java/io/IOException
    //   1064	1106	2207	java/io/IOException
    //   1111	1118	2207	java/io/IOException
    //   1120	1131	2207	java/io/IOException
    //   1140	1147	2207	java/io/IOException
    //   1149	1165	2207	java/io/IOException
    //   1167	1189	2207	java/io/IOException
    //   1191	1197	2207	java/io/IOException
    //   1199	1210	2207	java/io/IOException
    //   1212	1218	2207	java/io/IOException
    //   1220	1226	2207	java/io/IOException
    //   1228	1273	2207	java/io/IOException
    //   1275	1285	2207	java/io/IOException
    //   1287	1293	2207	java/io/IOException
    //   1295	1303	2207	java/io/IOException
    //   1305	1310	2207	java/io/IOException
    //   1312	1320	2207	java/io/IOException
    //   1327	1333	2207	java/io/IOException
    //   1335	1344	2207	java/io/IOException
    //   1346	1352	2207	java/io/IOException
    //   1365	1371	2207	java/io/IOException
    //   1373	1405	2207	java/io/IOException
    //   1512	1523	2207	java/io/IOException
    //   1525	1534	2207	java/io/IOException
    //   1542	1548	2207	java/io/IOException
    //   1550	1616	2207	java/io/IOException
    //   1622	1626	2207	java/io/IOException
    //   1628	1639	2207	java/io/IOException
    //   1641	1648	2207	java/io/IOException
    //   1650	1657	2207	java/io/IOException
    //   60	72	2211	java/net/MalformedURLException
    //   60	72	2217	java/io/FileNotFoundException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */