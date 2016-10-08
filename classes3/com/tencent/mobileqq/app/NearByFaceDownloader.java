package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.util.FaceManager;

public class NearByFaceDownloader
  extends FaceDownloader
{
  public static final String d = "Q.qqhead.NearByFaceDownloader";
  public FaceHandler a;
  public NearbyAppInterface a;
  FaceManager a;
  
  public NearByFaceDownloader(NearbyAppInterface paramNearbyAppInterface)
  {
    super(paramNearbyAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceManager = null;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceHandler = ((FaceHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(4));
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceManager = ((FaceManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(215));
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUtilFaceManager.a();
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUtilFaceManager.b();
  }
  
  /* Error */
  protected void b(com.tencent.mobileqq.util.FaceInfo paramFaceInfo)
  {
    // Byte code:
    //   0: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 8
    //   8: iconst_2
    //   9: new 62	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   16: ldc 67
    //   18: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aload_1
    //   32: getstatic 86	com/tencent/mobileqq/util/FaceInfo:m	I
    //   35: invokevirtual 89	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   38: aload_1
    //   39: getfield 92	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   42: astore 7
    //   44: iconst_0
    //   45: istore 29
    //   47: iconst_0
    //   48: istore 9
    //   50: iconst_0
    //   51: istore 12
    //   53: iconst_0
    //   54: istore 10
    //   56: iconst_0
    //   57: istore 19
    //   59: iconst_0
    //   60: istore 16
    //   62: aload 7
    //   64: getfield 97	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   67: astore 4
    //   69: iconst_0
    //   70: istore 23
    //   72: iconst_0
    //   73: istore 18
    //   75: iconst_0
    //   76: istore 17
    //   78: iconst_0
    //   79: istore 20
    //   81: iconst_0
    //   82: istore 21
    //   84: iconst_0
    //   85: istore 22
    //   87: iconst_0
    //   88: istore 11
    //   90: iload 18
    //   92: istore 14
    //   94: iload 10
    //   96: istore 13
    //   98: aload 4
    //   100: astore_2
    //   101: iload 21
    //   103: istore 15
    //   105: aload 7
    //   107: getfield 97	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   110: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifne +1903 -> 2016
    //   116: iload 18
    //   118: istore 14
    //   120: iload 10
    //   122: istore 13
    //   124: aload 4
    //   126: astore_2
    //   127: iload 21
    //   129: istore 15
    //   131: new 62	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   138: ldc 105
    //   140: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: getfield 107	com/tencent/mobileqq/util/FaceInfo:b	I
    //   147: invokestatic 112	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   150: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc 114
    //   155: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_1
    //   159: getfield 116	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   162: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: astore 5
    //   170: iload 18
    //   172: istore 14
    //   174: iload 10
    //   176: istore 13
    //   178: aload 4
    //   180: astore_2
    //   181: iload 21
    //   183: istore 15
    //   185: aload_0
    //   186: getfield 25	com/tencent/mobileqq/app/NearByFaceDownloader:jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface	Lcom/tencent/mobileqq/nearby/NearbyAppInterface;
    //   189: sipush 215
    //   192: invokevirtual 40	com/tencent/mobileqq/nearby/NearbyAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   195: checkcast 42	com/tencent/mobileqq/util/FaceManager
    //   198: astore 8
    //   200: iload 18
    //   202: istore 14
    //   204: iload 10
    //   206: istore 13
    //   208: aload 4
    //   210: astore_2
    //   211: iload 21
    //   213: istore 15
    //   215: aload 8
    //   217: aload 5
    //   219: invokevirtual 119	com/tencent/mobileqq/util/FaceManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Setting;
    //   222: astore_3
    //   223: aload_3
    //   224: astore 6
    //   226: aload_3
    //   227: ifnonnull +49 -> 276
    //   230: iload 18
    //   232: istore 14
    //   234: iload 10
    //   236: istore 13
    //   238: aload 4
    //   240: astore_2
    //   241: iload 21
    //   243: istore 15
    //   245: new 121	com/tencent/mobileqq/data/Setting
    //   248: dup
    //   249: invokespecial 122	com/tencent/mobileqq/data/Setting:<init>	()V
    //   252: astore 6
    //   254: iload 18
    //   256: istore 14
    //   258: iload 10
    //   260: istore 13
    //   262: aload 4
    //   264: astore_2
    //   265: iload 21
    //   267: istore 15
    //   269: aload 6
    //   271: aload 5
    //   273: putfield 125	com/tencent/mobileqq/data/Setting:uin	Ljava/lang/String;
    //   276: iload 18
    //   278: istore 14
    //   280: iload 10
    //   282: istore 13
    //   284: aload 4
    //   286: astore_2
    //   287: iload 21
    //   289: istore 15
    //   291: aload 6
    //   293: aload 7
    //   295: getfield 129	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   298: putfield 132	com/tencent/mobileqq/data/Setting:bFaceFlags	B
    //   301: iload 18
    //   303: istore 14
    //   305: iload 10
    //   307: istore 13
    //   309: aload 4
    //   311: astore_2
    //   312: iload 21
    //   314: istore 15
    //   316: aload 6
    //   318: aload 7
    //   320: getfield 135	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   323: putfield 138	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   326: iload 18
    //   328: istore 14
    //   330: iload 10
    //   332: istore 13
    //   334: aload 4
    //   336: astore_2
    //   337: iload 21
    //   339: istore 15
    //   341: aload 6
    //   343: aload 7
    //   345: getfield 97	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   348: putfield 141	com/tencent/mobileqq/data/Setting:url	Ljava/lang/String;
    //   351: iload 18
    //   353: istore 14
    //   355: iload 10
    //   357: istore 13
    //   359: aload 4
    //   361: astore_2
    //   362: iload 21
    //   364: istore 15
    //   366: aload 6
    //   368: invokestatic 147	java/lang/System:currentTimeMillis	()J
    //   371: putfield 151	com/tencent/mobileqq/data/Setting:updateTimestamp	J
    //   374: iload 18
    //   376: istore 14
    //   378: iload 10
    //   380: istore 13
    //   382: aload 4
    //   384: astore_2
    //   385: iload 21
    //   387: istore 15
    //   389: aload 6
    //   391: aload 7
    //   393: getfield 154	AvatarInfo/QQHeadInfo:headLevel	B
    //   396: putfield 157	com/tencent/mobileqq/data/Setting:bSourceType	B
    //   399: iload 18
    //   401: istore 14
    //   403: iload 10
    //   405: istore 13
    //   407: aload 4
    //   409: astore_2
    //   410: iload 21
    //   412: istore 15
    //   414: aload 6
    //   416: aload 7
    //   418: getfield 160	AvatarInfo/QQHeadInfo:cHeadType	B
    //   421: putfield 163	com/tencent/mobileqq/data/Setting:bHeadType	B
    //   424: iload 18
    //   426: istore 14
    //   428: iload 10
    //   430: istore 13
    //   432: aload 4
    //   434: astore_2
    //   435: iload 21
    //   437: istore 15
    //   439: aload 6
    //   441: aload 7
    //   443: getfield 167	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   446: putfield 168	com/tencent/mobileqq/data/Setting:systemHeadID	S
    //   449: iload 18
    //   451: istore 14
    //   453: iload 10
    //   455: istore 13
    //   457: aload 4
    //   459: astore_2
    //   460: iload 21
    //   462: istore 15
    //   464: aload 6
    //   466: aload 7
    //   468: getfield 171	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   471: putfield 174	com/tencent/mobileqq/data/Setting:headImgTimestamp	J
    //   474: iload 18
    //   476: istore 14
    //   478: iload 10
    //   480: istore 13
    //   482: aload 4
    //   484: astore_2
    //   485: iload 21
    //   487: istore 15
    //   489: aload 8
    //   491: aload_1
    //   492: invokevirtual 177	com/tencent/mobileqq/util/FaceManager:a	(Lcom/tencent/mobileqq/util/FaceInfo;)Ljava/lang/String;
    //   495: astore 5
    //   497: iload 18
    //   499: istore 14
    //   501: iload 10
    //   503: istore 13
    //   505: aload 4
    //   507: astore_2
    //   508: iload 21
    //   510: istore 15
    //   512: iload 29
    //   514: istore 28
    //   516: iload 19
    //   518: istore 12
    //   520: aload 4
    //   522: astore_3
    //   523: iload 22
    //   525: istore 9
    //   527: new 179	java/io/File
    //   530: dup
    //   531: aload 5
    //   533: iconst_0
    //   534: aload 5
    //   536: ldc -75
    //   538: invokevirtual 187	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   541: invokevirtual 191	java/lang/String:substring	(II)Ljava/lang/String;
    //   544: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   547: astore 8
    //   549: aload 8
    //   551: ifnull +77 -> 628
    //   554: iload 18
    //   556: istore 14
    //   558: iload 10
    //   560: istore 13
    //   562: aload 4
    //   564: astore_2
    //   565: iload 21
    //   567: istore 15
    //   569: iload 29
    //   571: istore 28
    //   573: iload 19
    //   575: istore 12
    //   577: aload 4
    //   579: astore_3
    //   580: iload 22
    //   582: istore 9
    //   584: aload 8
    //   586: invokevirtual 197	java/io/File:exists	()Z
    //   589: ifne +39 -> 628
    //   592: iload 18
    //   594: istore 14
    //   596: iload 10
    //   598: istore 13
    //   600: aload 4
    //   602: astore_2
    //   603: iload 21
    //   605: istore 15
    //   607: iload 29
    //   609: istore 28
    //   611: iload 19
    //   613: istore 12
    //   615: aload 4
    //   617: astore_3
    //   618: iload 22
    //   620: istore 9
    //   622: aload 8
    //   624: invokevirtual 200	java/io/File:mkdirs	()Z
    //   627: pop
    //   628: iload 18
    //   630: istore 14
    //   632: iload 10
    //   634: istore 13
    //   636: aload 4
    //   638: astore_2
    //   639: iload 21
    //   641: istore 15
    //   643: iload 29
    //   645: istore 28
    //   647: iload 19
    //   649: istore 12
    //   651: aload 4
    //   653: astore_3
    //   654: iload 22
    //   656: istore 9
    //   658: new 179	java/io/File
    //   661: dup
    //   662: aload 5
    //   664: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   667: astore 8
    //   669: iload 18
    //   671: istore 14
    //   673: iload 10
    //   675: istore 13
    //   677: aload 4
    //   679: astore_2
    //   680: iload 21
    //   682: istore 15
    //   684: iload 29
    //   686: istore 28
    //   688: iload 19
    //   690: istore 12
    //   692: aload 4
    //   694: astore_3
    //   695: iload 22
    //   697: istore 9
    //   699: aload_0
    //   700: aload 7
    //   702: getfield 97	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   705: aload 7
    //   707: getfield 129	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   710: aload 7
    //   712: getfield 135	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   715: aload 7
    //   717: getfield 203	AvatarInfo/QQHeadInfo:originUsrType	I
    //   720: invokevirtual 206	com/tencent/mobileqq/app/NearByFaceDownloader:a	(Ljava/lang/String;BBI)Ljava/lang/String;
    //   723: astore 4
    //   725: iload 18
    //   727: istore 14
    //   729: iload 10
    //   731: istore 13
    //   733: aload 4
    //   735: astore_2
    //   736: iload 21
    //   738: istore 15
    //   740: iload 29
    //   742: istore 28
    //   744: iload 19
    //   746: istore 12
    //   748: aload 4
    //   750: astore_3
    //   751: iload 22
    //   753: istore 9
    //   755: ldc -48
    //   757: aload 4
    //   759: invokestatic 214	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   762: astore 4
    //   764: iload 18
    //   766: istore 14
    //   768: iload 10
    //   770: istore 13
    //   772: aload 4
    //   774: astore_2
    //   775: iload 21
    //   777: istore 15
    //   779: iload 29
    //   781: istore 28
    //   783: iload 19
    //   785: istore 12
    //   787: aload 4
    //   789: astore_3
    //   790: iload 22
    //   792: istore 9
    //   794: new 62	java/lang/StringBuilder
    //   797: dup
    //   798: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   801: aload 4
    //   803: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: ldc -40
    //   808: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: invokestatic 147	java/lang/System:currentTimeMillis	()J
    //   814: invokevirtual 219	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   817: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   820: astore 4
    //   822: iload 18
    //   824: istore 14
    //   826: iload 10
    //   828: istore 13
    //   830: aload 4
    //   832: astore_2
    //   833: iload 21
    //   835: istore 15
    //   837: iload 29
    //   839: istore 28
    //   841: iload 19
    //   843: istore 12
    //   845: aload 4
    //   847: astore_3
    //   848: iload 22
    //   850: istore 9
    //   852: aload_0
    //   853: aload 4
    //   855: aload 8
    //   857: aload_1
    //   858: iconst_1
    //   859: invokevirtual 222	com/tencent/mobileqq/app/NearByFaceDownloader:a	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/util/FaceInfo;Z)I
    //   862: istore 11
    //   864: iload 11
    //   866: ifne +594 -> 1460
    //   869: iload 18
    //   871: istore 14
    //   873: iload 10
    //   875: istore 13
    //   877: aload 4
    //   879: astore_2
    //   880: iload 11
    //   882: istore 15
    //   884: iload 29
    //   886: istore 28
    //   888: iload 19
    //   890: istore 12
    //   892: aload 4
    //   894: astore_3
    //   895: iload 11
    //   897: istore 9
    //   899: aload 8
    //   901: invokevirtual 225	java/io/File:length	()J
    //   904: l2i
    //   905: istore 10
    //   907: iconst_1
    //   908: istore 28
    //   910: iload 18
    //   912: istore 14
    //   914: iload 10
    //   916: istore 13
    //   918: aload 4
    //   920: astore_2
    //   921: iload 11
    //   923: istore 15
    //   925: iload 10
    //   927: istore 12
    //   929: aload 4
    //   931: astore_3
    //   932: iload 11
    //   934: istore 9
    //   936: new 227	qaz
    //   939: dup
    //   940: aload_0
    //   941: aload 6
    //   943: aload_1
    //   944: invokespecial 230	qaz:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;Lcom/tencent/mobileqq/data/Setting;Lcom/tencent/mobileqq/util/FaceInfo;)V
    //   947: aconst_null
    //   948: iconst_0
    //   949: invokestatic 235	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   952: iconst_0
    //   953: istore 9
    //   955: iconst_1
    //   956: istore 28
    //   958: iload 10
    //   960: istore 12
    //   962: iload 17
    //   964: istore 10
    //   966: iload 28
    //   968: ifeq +28 -> 996
    //   971: iload 10
    //   973: istore 14
    //   975: iload 12
    //   977: istore 13
    //   979: aload 4
    //   981: astore_2
    //   982: iload 11
    //   984: istore 15
    //   986: aload_0
    //   987: getfield 27	com/tencent/mobileqq/app/NearByFaceDownloader:jdField_a_of_type_ComTencentMobileqqAppFaceHandler	Lcom/tencent/mobileqq/app/FaceHandler;
    //   990: iconst_0
    //   991: iconst_1
    //   992: aload_1
    //   993: invokevirtual 238	com/tencent/mobileqq/app/FaceHandler:a	(IZLjava/lang/Object;)V
    //   996: iload 10
    //   998: istore 14
    //   1000: iload 12
    //   1002: istore 13
    //   1004: aload 4
    //   1006: astore_2
    //   1007: iload 11
    //   1009: istore 15
    //   1011: aload_0
    //   1012: getfield 27	com/tencent/mobileqq/app/NearByFaceDownloader:jdField_a_of_type_ComTencentMobileqqAppFaceHandler	Lcom/tencent/mobileqq/app/FaceHandler;
    //   1015: iconst_1
    //   1016: iconst_1
    //   1017: aload_1
    //   1018: invokevirtual 238	com/tencent/mobileqq/app/FaceHandler:a	(IZLjava/lang/Object;)V
    //   1021: aload 5
    //   1023: astore_2
    //   1024: lconst_0
    //   1025: lstore 26
    //   1027: aload_1
    //   1028: getfield 240	com/tencent/mobileqq/util/FaceInfo:d	I
    //   1031: iconst_1
    //   1032: if_icmpne +564 -> 1596
    //   1035: lload 26
    //   1037: lstore 24
    //   1039: aload_1
    //   1040: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1043: getstatic 246	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1046: laload
    //   1047: lconst_0
    //   1048: lcmp
    //   1049: ifle +39 -> 1088
    //   1052: lload 26
    //   1054: lstore 24
    //   1056: aload_1
    //   1057: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1060: getstatic 86	com/tencent/mobileqq/util/FaceInfo:m	I
    //   1063: laload
    //   1064: lconst_0
    //   1065: lcmp
    //   1066: ifle +22 -> 1088
    //   1069: aload_1
    //   1070: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1073: getstatic 246	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1076: laload
    //   1077: aload_1
    //   1078: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1081: getstatic 86	com/tencent/mobileqq/util/FaceInfo:m	I
    //   1084: laload
    //   1085: lsub
    //   1086: lstore 24
    //   1088: new 248	qay
    //   1091: dup
    //   1092: aload_0
    //   1093: iload 10
    //   1095: aload_1
    //   1096: iconst_4
    //   1097: iload 12
    //   1099: aload 4
    //   1101: iload 11
    //   1103: lload 24
    //   1105: invokespecial 251	qay:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;ILcom/tencent/mobileqq/util/FaceInfo;IILjava/lang/String;IJ)V
    //   1108: aconst_null
    //   1109: iconst_0
    //   1110: invokestatic 235	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1113: aload 4
    //   1115: astore_3
    //   1116: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1119: ifne +8 -> 1127
    //   1122: iload 28
    //   1124: ifne +189 -> 1313
    //   1127: ldc 8
    //   1129: iconst_2
    //   1130: new 62	java/lang/StringBuilder
    //   1133: dup
    //   1134: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1137: ldc -3
    //   1139: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: aload_1
    //   1143: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1146: ldc -1
    //   1148: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: iload 28
    //   1153: invokevirtual 258	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1156: ldc_w 260
    //   1159: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: iload 10
    //   1164: invokevirtual 263	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1167: ldc_w 265
    //   1170: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: aload 7
    //   1175: getfield 267	AvatarInfo/QQHeadInfo:uin	J
    //   1178: invokevirtual 219	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1181: ldc_w 269
    //   1184: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: aload 7
    //   1189: getfield 272	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   1192: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: ldc_w 274
    //   1198: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: aload 7
    //   1203: getfield 160	AvatarInfo/QQHeadInfo:cHeadType	B
    //   1206: invokevirtual 263	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1209: ldc_w 276
    //   1212: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: aload 7
    //   1217: getfield 135	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1220: invokevirtual 263	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1223: ldc_w 278
    //   1226: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: aload 7
    //   1231: getfield 167	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   1234: invokevirtual 263	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1237: ldc_w 280
    //   1240: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: iload 9
    //   1245: invokevirtual 263	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1248: ldc_w 282
    //   1251: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: aload 7
    //   1256: getfield 171	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   1259: invokevirtual 219	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1262: ldc_w 284
    //   1265: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: aload_2
    //   1269: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1272: ldc_w 286
    //   1275: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: aload_3
    //   1279: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1282: ldc_w 288
    //   1285: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: aload 7
    //   1290: getfield 97	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   1293: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: ldc_w 290
    //   1299: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: aload 7
    //   1304: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1307: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1310: invokestatic 293	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1313: return
    //   1314: astore_2
    //   1315: lconst_0
    //   1316: lstore 26
    //   1318: aload_1
    //   1319: getfield 240	com/tencent/mobileqq/util/FaceInfo:d	I
    //   1322: iconst_1
    //   1323: if_icmpne +81 -> 1404
    //   1326: lload 26
    //   1328: lstore 24
    //   1330: aload_1
    //   1331: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1334: getstatic 246	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1337: laload
    //   1338: lconst_0
    //   1339: lcmp
    //   1340: ifle +39 -> 1379
    //   1343: lload 26
    //   1345: lstore 24
    //   1347: aload_1
    //   1348: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1351: getstatic 86	com/tencent/mobileqq/util/FaceInfo:m	I
    //   1354: laload
    //   1355: lconst_0
    //   1356: lcmp
    //   1357: ifle +22 -> 1379
    //   1360: aload_1
    //   1361: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1364: getstatic 246	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1367: laload
    //   1368: aload_1
    //   1369: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1372: getstatic 86	com/tencent/mobileqq/util/FaceInfo:m	I
    //   1375: laload
    //   1376: lsub
    //   1377: lstore 24
    //   1379: new 248	qay
    //   1382: dup
    //   1383: aload_0
    //   1384: sipush 9202
    //   1387: aload_1
    //   1388: iconst_4
    //   1389: iconst_0
    //   1390: aload 4
    //   1392: iconst_0
    //   1393: lload 24
    //   1395: invokespecial 251	qay:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;ILcom/tencent/mobileqq/util/FaceInfo;IILjava/lang/String;IJ)V
    //   1398: aconst_null
    //   1399: iconst_0
    //   1400: invokestatic 235	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1403: return
    //   1404: lload 26
    //   1406: lstore 24
    //   1408: aload_1
    //   1409: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1412: getstatic 246	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1415: laload
    //   1416: lconst_0
    //   1417: lcmp
    //   1418: ifle -39 -> 1379
    //   1421: lload 26
    //   1423: lstore 24
    //   1425: aload_1
    //   1426: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1429: getstatic 296	com/tencent/mobileqq/util/FaceInfo:k	I
    //   1432: laload
    //   1433: lconst_0
    //   1434: lcmp
    //   1435: ifle -56 -> 1379
    //   1438: aload_1
    //   1439: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1442: getstatic 246	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1445: laload
    //   1446: aload_1
    //   1447: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1450: getstatic 296	com/tencent/mobileqq/util/FaceInfo:k	I
    //   1453: laload
    //   1454: lsub
    //   1455: lstore 24
    //   1457: goto -78 -> 1379
    //   1460: iload 11
    //   1462: lookupswitch	default:+42->1504, 1:+61->1523, 4:+79->1541, 5:+116->1578, 33:+97->1559
    //   1504: sipush 9207
    //   1507: istore 10
    //   1509: iload 11
    //   1511: istore 9
    //   1513: iconst_0
    //   1514: istore 28
    //   1516: iload 16
    //   1518: istore 12
    //   1520: goto -554 -> 966
    //   1523: sipush 9206
    //   1526: istore 10
    //   1528: iconst_0
    //   1529: istore 9
    //   1531: iconst_0
    //   1532: istore 28
    //   1534: iload 16
    //   1536: istore 12
    //   1538: goto -572 -> 966
    //   1541: sipush 9202
    //   1544: istore 10
    //   1546: iconst_0
    //   1547: istore 9
    //   1549: iconst_0
    //   1550: istore 28
    //   1552: iload 16
    //   1554: istore 12
    //   1556: goto -590 -> 966
    //   1559: sipush 9208
    //   1562: istore 10
    //   1564: iload 11
    //   1566: istore 9
    //   1568: iconst_0
    //   1569: istore 28
    //   1571: iload 16
    //   1573: istore 12
    //   1575: goto -609 -> 966
    //   1578: sipush 9204
    //   1581: istore 10
    //   1583: iconst_0
    //   1584: istore 9
    //   1586: iconst_0
    //   1587: istore 28
    //   1589: iload 16
    //   1591: istore 12
    //   1593: goto -627 -> 966
    //   1596: lload 26
    //   1598: lstore 24
    //   1600: aload_1
    //   1601: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1604: getstatic 246	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1607: laload
    //   1608: lconst_0
    //   1609: lcmp
    //   1610: ifle -522 -> 1088
    //   1613: lload 26
    //   1615: lstore 24
    //   1617: aload_1
    //   1618: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1621: getstatic 296	com/tencent/mobileqq/util/FaceInfo:k	I
    //   1624: laload
    //   1625: lconst_0
    //   1626: lcmp
    //   1627: ifle -539 -> 1088
    //   1630: aload_1
    //   1631: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1634: getstatic 246	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1637: laload
    //   1638: aload_1
    //   1639: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1642: getstatic 296	com/tencent/mobileqq/util/FaceInfo:k	I
    //   1645: laload
    //   1646: lsub
    //   1647: lstore 24
    //   1649: goto -561 -> 1088
    //   1652: astore 6
    //   1654: iconst_0
    //   1655: istore 9
    //   1657: iconst_0
    //   1658: istore 28
    //   1660: aconst_null
    //   1661: astore 5
    //   1663: iload 20
    //   1665: istore 11
    //   1667: aload 4
    //   1669: astore_3
    //   1670: sipush 9204
    //   1673: istore 10
    //   1675: iload 10
    //   1677: istore 14
    //   1679: iload 12
    //   1681: istore 13
    //   1683: aload_3
    //   1684: astore_2
    //   1685: iload 11
    //   1687: istore 15
    //   1689: aload 6
    //   1691: invokevirtual 299	java/lang/Throwable:printStackTrace	()V
    //   1694: lconst_0
    //   1695: lstore 26
    //   1697: aload_1
    //   1698: getfield 240	com/tencent/mobileqq/util/FaceInfo:d	I
    //   1701: iconst_1
    //   1702: if_icmpne +87 -> 1789
    //   1705: lload 26
    //   1707: lstore 24
    //   1709: aload_1
    //   1710: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1713: getstatic 246	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1716: laload
    //   1717: lconst_0
    //   1718: lcmp
    //   1719: ifle +39 -> 1758
    //   1722: lload 26
    //   1724: lstore 24
    //   1726: aload_1
    //   1727: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1730: getstatic 86	com/tencent/mobileqq/util/FaceInfo:m	I
    //   1733: laload
    //   1734: lconst_0
    //   1735: lcmp
    //   1736: ifle +22 -> 1758
    //   1739: aload_1
    //   1740: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1743: getstatic 246	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1746: laload
    //   1747: aload_1
    //   1748: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1751: getstatic 86	com/tencent/mobileqq/util/FaceInfo:m	I
    //   1754: laload
    //   1755: lsub
    //   1756: lstore 24
    //   1758: new 248	qay
    //   1761: dup
    //   1762: aload_0
    //   1763: sipush 9204
    //   1766: aload_1
    //   1767: iconst_4
    //   1768: iload 12
    //   1770: aload_3
    //   1771: iload 11
    //   1773: lload 24
    //   1775: invokespecial 251	qay:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;ILcom/tencent/mobileqq/util/FaceInfo;IILjava/lang/String;IJ)V
    //   1778: aconst_null
    //   1779: iconst_0
    //   1780: invokestatic 235	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1783: aload 5
    //   1785: astore_2
    //   1786: goto -670 -> 1116
    //   1789: lload 26
    //   1791: lstore 24
    //   1793: aload_1
    //   1794: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1797: getstatic 246	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1800: laload
    //   1801: lconst_0
    //   1802: lcmp
    //   1803: ifle -45 -> 1758
    //   1806: lload 26
    //   1808: lstore 24
    //   1810: aload_1
    //   1811: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1814: getstatic 296	com/tencent/mobileqq/util/FaceInfo:k	I
    //   1817: laload
    //   1818: lconst_0
    //   1819: lcmp
    //   1820: ifle -62 -> 1758
    //   1823: aload_1
    //   1824: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1827: getstatic 246	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1830: laload
    //   1831: aload_1
    //   1832: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1835: getstatic 296	com/tencent/mobileqq/util/FaceInfo:k	I
    //   1838: laload
    //   1839: lsub
    //   1840: lstore 24
    //   1842: goto -84 -> 1758
    //   1845: astore_3
    //   1846: lconst_0
    //   1847: lstore 26
    //   1849: aload_1
    //   1850: getfield 240	com/tencent/mobileqq/util/FaceInfo:d	I
    //   1853: iconst_1
    //   1854: if_icmpne +82 -> 1936
    //   1857: lload 26
    //   1859: lstore 24
    //   1861: aload_1
    //   1862: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1865: getstatic 246	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1868: laload
    //   1869: lconst_0
    //   1870: lcmp
    //   1871: ifle +39 -> 1910
    //   1874: lload 26
    //   1876: lstore 24
    //   1878: aload_1
    //   1879: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1882: getstatic 86	com/tencent/mobileqq/util/FaceInfo:m	I
    //   1885: laload
    //   1886: lconst_0
    //   1887: lcmp
    //   1888: ifle +22 -> 1910
    //   1891: aload_1
    //   1892: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1895: getstatic 246	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1898: laload
    //   1899: aload_1
    //   1900: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1903: getstatic 86	com/tencent/mobileqq/util/FaceInfo:m	I
    //   1906: laload
    //   1907: lsub
    //   1908: lstore 24
    //   1910: new 248	qay
    //   1913: dup
    //   1914: aload_0
    //   1915: iload 14
    //   1917: aload_1
    //   1918: iconst_4
    //   1919: iload 13
    //   1921: aload_2
    //   1922: iload 15
    //   1924: lload 24
    //   1926: invokespecial 251	qay:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;ILcom/tencent/mobileqq/util/FaceInfo;IILjava/lang/String;IJ)V
    //   1929: aconst_null
    //   1930: iconst_0
    //   1931: invokestatic 235	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1934: aload_3
    //   1935: athrow
    //   1936: lload 26
    //   1938: lstore 24
    //   1940: aload_1
    //   1941: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1944: getstatic 246	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1947: laload
    //   1948: lconst_0
    //   1949: lcmp
    //   1950: ifle -40 -> 1910
    //   1953: lload 26
    //   1955: lstore 24
    //   1957: aload_1
    //   1958: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1961: getstatic 296	com/tencent/mobileqq/util/FaceInfo:k	I
    //   1964: laload
    //   1965: lconst_0
    //   1966: lcmp
    //   1967: ifle -57 -> 1910
    //   1970: aload_1
    //   1971: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1974: getstatic 246	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1977: laload
    //   1978: aload_1
    //   1979: getfield 243	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1982: getstatic 296	com/tencent/mobileqq/util/FaceInfo:k	I
    //   1985: laload
    //   1986: lsub
    //   1987: lstore 24
    //   1989: goto -79 -> 1910
    //   1992: astore 6
    //   1994: iconst_0
    //   1995: istore 10
    //   1997: iload 9
    //   1999: istore 11
    //   2001: iload 10
    //   2003: istore 9
    //   2005: goto -335 -> 1670
    //   2008: astore 6
    //   2010: aload 4
    //   2012: astore_3
    //   2013: goto -343 -> 1670
    //   2016: iconst_0
    //   2017: istore 13
    //   2019: iconst_0
    //   2020: istore 28
    //   2022: aconst_null
    //   2023: astore_2
    //   2024: iload 23
    //   2026: istore 10
    //   2028: iload 9
    //   2030: istore 12
    //   2032: iload 13
    //   2034: istore 9
    //   2036: goto -1012 -> 1024
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2039	0	this	NearByFaceDownloader
    //   0	2039	1	paramFaceInfo	com.tencent.mobileqq.util.FaceInfo
    //   100	1169	2	localObject1	Object
    //   1314	1	2	localException	Exception
    //   1684	340	2	localObject2	Object
    //   222	1549	3	localObject3	Object
    //   1845	90	3	localObject4	Object
    //   2012	1	3	str1	String
    //   67	1944	4	str2	String
    //   168	1616	5	str3	String
    //   224	718	6	localObject5	Object
    //   1652	38	6	localThrowable1	Throwable
    //   1992	1	6	localThrowable2	Throwable
    //   2008	1	6	localThrowable3	Throwable
    //   42	1261	7	localQQHeadInfo	AvatarInfo.QQHeadInfo
    //   198	702	8	localObject6	Object
    //   48	1987	9	i	int
    //   54	1973	10	j	int
    //   88	1912	11	k	int
    //   51	1980	12	m	int
    //   96	1937	13	n	int
    //   92	1824	14	i1	int
    //   103	1820	15	i2	int
    //   60	1530	16	i3	int
    //   76	887	17	i4	int
    //   73	838	18	i5	int
    //   57	832	19	i6	int
    //   79	1585	20	i7	int
    //   82	752	21	i8	int
    //   85	764	22	i9	int
    //   70	1955	23	i10	int
    //   1037	951	24	l1	long
    //   1025	929	26	l2	long
    //   514	1507	28	bool1	boolean
    //   45	840	29	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   489	497	1314	java/lang/Exception
    //   527	549	1314	java/lang/Exception
    //   584	592	1314	java/lang/Exception
    //   622	628	1314	java/lang/Exception
    //   658	669	1314	java/lang/Exception
    //   105	116	1652	java/lang/Throwable
    //   131	170	1652	java/lang/Throwable
    //   185	200	1652	java/lang/Throwable
    //   215	223	1652	java/lang/Throwable
    //   245	254	1652	java/lang/Throwable
    //   269	276	1652	java/lang/Throwable
    //   291	301	1652	java/lang/Throwable
    //   316	326	1652	java/lang/Throwable
    //   341	351	1652	java/lang/Throwable
    //   366	374	1652	java/lang/Throwable
    //   389	399	1652	java/lang/Throwable
    //   414	424	1652	java/lang/Throwable
    //   439	449	1652	java/lang/Throwable
    //   464	474	1652	java/lang/Throwable
    //   489	497	1652	java/lang/Throwable
    //   105	116	1845	finally
    //   131	170	1845	finally
    //   185	200	1845	finally
    //   215	223	1845	finally
    //   245	254	1845	finally
    //   269	276	1845	finally
    //   291	301	1845	finally
    //   316	326	1845	finally
    //   341	351	1845	finally
    //   366	374	1845	finally
    //   389	399	1845	finally
    //   414	424	1845	finally
    //   439	449	1845	finally
    //   464	474	1845	finally
    //   489	497	1845	finally
    //   527	549	1845	finally
    //   584	592	1845	finally
    //   622	628	1845	finally
    //   658	669	1845	finally
    //   699	725	1845	finally
    //   755	764	1845	finally
    //   794	822	1845	finally
    //   852	864	1845	finally
    //   899	907	1845	finally
    //   936	952	1845	finally
    //   986	996	1845	finally
    //   1011	1021	1845	finally
    //   1689	1694	1845	finally
    //   527	549	1992	java/lang/Throwable
    //   584	592	1992	java/lang/Throwable
    //   622	628	1992	java/lang/Throwable
    //   658	669	1992	java/lang/Throwable
    //   699	725	1992	java/lang/Throwable
    //   755	764	1992	java/lang/Throwable
    //   794	822	1992	java/lang/Throwable
    //   852	864	1992	java/lang/Throwable
    //   899	907	1992	java/lang/Throwable
    //   936	952	1992	java/lang/Throwable
    //   986	996	2008	java/lang/Throwable
    //   1011	1021	2008	java/lang/Throwable
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\NearByFaceDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */