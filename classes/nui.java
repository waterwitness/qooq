import android.os.AsyncTask;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class nui
  extends AsyncTask
{
  static final int jdField_a_of_type_Int = 0;
  static final int b = 1;
  static final int c = 2;
  static final int d = 0;
  static final int e = 1;
  static final int f = 2;
  static final int g = 10;
  static final int h = 11;
  static final int i = 20;
  static final int j = 21;
  static final int k = 22;
  static final int l = 23;
  static final int m = 24;
  static final int n = 30;
  public AIORichMediaInfo a;
  public boolean a;
  AIORichMediaInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
  int o;
  
  public nui(AIOImageListScene paramAIOImageListScene, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo = ((AIORichMediaInfo[])paramArrayList.toArray(new AIORichMediaInfo[0]));
  }
  
  /* Error */
  protected Integer a(Integer... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +1101 -> 1104
    //   6: ldc 74
    //   8: iconst_2
    //   9: new 76	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   16: ldc 79
    //   18: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: goto +1073 -> 1104
    //   34: iload 7
    //   36: aload_1
    //   37: arraylength
    //   38: if_icmpge +1052 -> 1090
    //   41: aload_1
    //   42: iload 7
    //   44: aaload
    //   45: invokevirtual 99	java/lang/Integer:intValue	()I
    //   48: istore 8
    //   50: aload_0
    //   51: getfield 49	nui:jdField_a_of_type_Boolean	Z
    //   54: ifne +8 -> 62
    //   57: iconst_1
    //   58: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: areturn
    //   62: aload_0
    //   63: iconst_1
    //   64: anewarray 95	java/lang/Integer
    //   67: dup
    //   68: iconst_0
    //   69: iload 7
    //   71: bipush 100
    //   73: imul
    //   74: aload_1
    //   75: arraylength
    //   76: idiv
    //   77: ldc 104
    //   79: iand
    //   80: iload 8
    //   82: bipush 16
    //   84: ishl
    //   85: ior
    //   86: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: aastore
    //   90: invokevirtual 108	nui:publishProgress	([Ljava/lang/Object;)V
    //   93: iload 8
    //   95: tableswitch	default:+1018->1113, 0:+1027->1122, 1:+401->496, 2:+1027->1122
    //   120: iload 6
    //   122: aload_0
    //   123: getfield 60	nui:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   126: arraylength
    //   127: if_icmpge +1010 -> 1137
    //   130: aload_0
    //   131: getfield 49	nui:jdField_a_of_type_Boolean	Z
    //   134: ifne +8 -> 142
    //   137: iconst_1
    //   138: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   141: areturn
    //   142: aload_0
    //   143: iconst_1
    //   144: anewarray 95	java/lang/Integer
    //   147: dup
    //   148: iconst_0
    //   149: iload 7
    //   151: bipush 100
    //   153: imul
    //   154: aload_1
    //   155: arraylength
    //   156: idiv
    //   157: iload 6
    //   159: bipush 100
    //   161: imul
    //   162: aload_1
    //   163: arraylength
    //   164: idiv
    //   165: aload_0
    //   166: getfield 60	nui:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   169: arraylength
    //   170: idiv
    //   171: iadd
    //   172: ldc 104
    //   174: iand
    //   175: iload 8
    //   177: bipush 16
    //   179: ishl
    //   180: ior
    //   181: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: aastore
    //   185: invokevirtual 108	nui:publishProgress	([Ljava/lang/Object;)V
    //   188: aload_0
    //   189: getfield 60	nui:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   192: iload 6
    //   194: aaload
    //   195: astore_3
    //   196: ldc 110
    //   198: aload_3
    //   199: getfield 113	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   202: invokevirtual 119	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   205: ifeq +279 -> 484
    //   208: aload_3
    //   209: getfield 113	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   212: checkcast 110	com/tencent/mobileqq/activity/aio/photo/AIOImageData
    //   215: astore_2
    //   216: aload_2
    //   217: getfield 122	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   220: astore 4
    //   222: ldc 124
    //   224: aload 4
    //   226: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   229: ifeq +6 -> 235
    //   232: goto +896 -> 1128
    //   235: aload_0
    //   236: aload_3
    //   237: putfield 131	nui:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   240: aload_0
    //   241: getfield 49	nui:jdField_a_of_type_Boolean	Z
    //   244: ifeq +158 -> 402
    //   247: aload 4
    //   249: ifnull +18 -> 267
    //   252: new 133	java/io/File
    //   255: dup
    //   256: aload 4
    //   258: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   261: invokevirtual 139	java/io/File:exists	()Z
    //   264: ifne +138 -> 402
    //   267: aload_0
    //   268: getfield 131	nui:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   271: iconst_1
    //   272: putfield 140	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_Boolean	Z
    //   275: aload_0
    //   276: getfield 39	nui:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageListScene;
    //   279: getfield 145	com/tencent/mobileqq/activity/aio/photo/AIOImageListScene:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   282: aload_2
    //   283: getfield 148	com/tencent/mobileqq/activity/aio/photo/AIOImageData:f	J
    //   286: aload_2
    //   287: getfield 150	com/tencent/mobileqq/activity/aio/photo/AIOImageData:k	I
    //   290: iconst_2
    //   291: invokeinterface 155 5 0
    //   296: aload_0
    //   297: getfield 131	nui:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   300: astore_3
    //   301: aload_3
    //   302: monitorenter
    //   303: aload_0
    //   304: getfield 131	nui:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   307: getfield 140	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_Boolean	Z
    //   310: ifeq +10 -> 320
    //   313: aload_0
    //   314: getfield 131	nui:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   317: invokevirtual 160	java/lang/Object:wait	()V
    //   320: aload_3
    //   321: monitorexit
    //   322: aload_2
    //   323: getfield 162	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_Boolean	Z
    //   326: ifeq +76 -> 402
    //   329: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq +41 -> 373
    //   335: ldc 74
    //   337: iconst_2
    //   338: new 76	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   345: ldc -92
    //   347: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: iload 6
    //   352: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   355: ldc -87
    //   357: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload_2
    //   361: getfield 122	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   364: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: aload_0
    //   374: aload_0
    //   375: getfield 60	nui:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   378: arraylength
    //   379: iload 6
    //   381: isub
    //   382: putfield 171	nui:o	I
    //   385: bipush 11
    //   387: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   390: areturn
    //   391: astore_1
    //   392: aload_3
    //   393: monitorexit
    //   394: aload_1
    //   395: athrow
    //   396: astore_1
    //   397: iconst_2
    //   398: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   401: areturn
    //   402: aload_0
    //   403: getfield 49	nui:jdField_a_of_type_Boolean	Z
    //   406: ifne +8 -> 414
    //   409: iconst_1
    //   410: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   413: areturn
    //   414: aload_2
    //   415: iconst_2
    //   416: invokevirtual 174	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   419: ifnonnull +709 -> 1128
    //   422: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq +41 -> 466
    //   428: ldc 74
    //   430: iconst_2
    //   431: new 76	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   438: ldc -80
    //   440: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: iload 6
    //   445: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   448: ldc -87
    //   450: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload_2
    //   454: getfield 122	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   457: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: aload_0
    //   467: aload_0
    //   468: getfield 60	nui:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   471: arraylength
    //   472: iload 6
    //   474: isub
    //   475: putfield 171	nui:o	I
    //   478: bipush 11
    //   480: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   483: areturn
    //   484: ldc -78
    //   486: aload_3
    //   487: invokevirtual 119	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   490: ifeq +638 -> 1128
    //   493: goto +635 -> 1128
    //   496: invokestatic 183	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   499: ldc -71
    //   501: invokevirtual 189	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   504: ifne +23 -> 527
    //   507: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   510: ifeq +11 -> 521
    //   513: ldc 74
    //   515: iconst_2
    //   516: ldc -65
    //   518: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: bipush 23
    //   523: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   526: areturn
    //   527: new 133	java/io/File
    //   530: dup
    //   531: getstatic 196	com/tencent/mobileqq/app/AppConstants:bo	Ljava/lang/String;
    //   534: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   537: astore 4
    //   539: aload 4
    //   541: invokevirtual 139	java/io/File:exists	()Z
    //   544: ifne +613 -> 1157
    //   547: aload 4
    //   549: invokevirtual 199	java/io/File:mkdirs	()Z
    //   552: pop
    //   553: goto +604 -> 1157
    //   556: iload 6
    //   558: aload_0
    //   559: getfield 60	nui:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   562: arraylength
    //   563: if_icmpge +510 -> 1073
    //   566: aload_0
    //   567: getfield 60	nui:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   570: iload 6
    //   572: aaload
    //   573: astore_2
    //   574: aload_0
    //   575: getfield 49	nui:jdField_a_of_type_Boolean	Z
    //   578: ifne +8 -> 586
    //   581: iconst_1
    //   582: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   585: areturn
    //   586: ldc 110
    //   588: aload_2
    //   589: getfield 113	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   592: invokevirtual 119	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   595: ifeq +213 -> 808
    //   598: aload_2
    //   599: getfield 113	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   602: checkcast 110	com/tencent/mobileqq/activity/aio/photo/AIOImageData
    //   605: astore_2
    //   606: aload_0
    //   607: iconst_1
    //   608: anewarray 95	java/lang/Integer
    //   611: dup
    //   612: iconst_0
    //   613: iload 7
    //   615: bipush 100
    //   617: imul
    //   618: aload_1
    //   619: arraylength
    //   620: idiv
    //   621: iload 6
    //   623: bipush 100
    //   625: imul
    //   626: aload_1
    //   627: arraylength
    //   628: idiv
    //   629: aload_0
    //   630: getfield 60	nui:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   633: arraylength
    //   634: idiv
    //   635: iadd
    //   636: ldc 104
    //   638: iand
    //   639: iload 8
    //   641: bipush 16
    //   643: ishl
    //   644: ior
    //   645: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   648: aastore
    //   649: invokevirtual 108	nui:publishProgress	([Ljava/lang/Object;)V
    //   652: aload_2
    //   653: iconst_2
    //   654: invokevirtual 174	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   657: astore_2
    //   658: aload_2
    //   659: ifnull +504 -> 1163
    //   662: invokestatic 203	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   665: invokestatic 209	com/tencent/image/Utils:getUsableSpace	(Ljava/io/File;)J
    //   668: lstore 9
    //   670: aload_2
    //   671: invokevirtual 213	java/io/File:length	()J
    //   674: lload 9
    //   676: lcmp
    //   677: ifle +23 -> 700
    //   680: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   683: ifeq +11 -> 694
    //   686: ldc 74
    //   688: iconst_2
    //   689: ldc -41
    //   691: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   694: bipush 22
    //   696: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   699: areturn
    //   700: new 133	java/io/File
    //   703: dup
    //   704: aload 4
    //   706: new 76	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   713: aload_2
    //   714: invokevirtual 218	java/io/File:getName	()Ljava/lang/String;
    //   717: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: ldc -36
    //   722: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   728: invokespecial 223	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   731: astore_3
    //   732: aload_2
    //   733: aload_3
    //   734: invokestatic 228	com/dataline/util/file/FileUtil:a	(Ljava/io/File;Ljava/io/File;)Z
    //   737: ifne +54 -> 791
    //   740: invokestatic 183	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   743: ldc -71
    //   745: invokevirtual 189	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   748: ifne +23 -> 771
    //   751: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   754: ifeq +11 -> 765
    //   757: ldc 74
    //   759: iconst_2
    //   760: ldc -26
    //   762: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   765: bipush 24
    //   767: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   770: areturn
    //   771: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   774: ifeq +11 -> 785
    //   777: ldc 74
    //   779: iconst_2
    //   780: ldc -24
    //   782: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   785: bipush 21
    //   787: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   790: areturn
    //   791: aload_0
    //   792: getfield 39	nui:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageListScene;
    //   795: invokestatic 235	com/tencent/mobileqq/activity/aio/photo/AIOImageListScene:a	(Lcom/tencent/mobileqq/activity/aio/photo/AIOImageListScene;)Landroid/app/Activity;
    //   798: aload_3
    //   799: invokevirtual 238	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   802: invokestatic 243	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   805: goto +358 -> 1163
    //   808: ldc -11
    //   810: aload_2
    //   811: getfield 113	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   814: invokevirtual 119	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   817: ifeq +244 -> 1061
    //   820: aload_2
    //   821: getfield 113	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   824: checkcast 245	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData
    //   827: astore 5
    //   829: aload_0
    //   830: iconst_1
    //   831: anewarray 95	java/lang/Integer
    //   834: dup
    //   835: iconst_0
    //   836: iload 7
    //   838: bipush 100
    //   840: imul
    //   841: aload_1
    //   842: arraylength
    //   843: idiv
    //   844: iload 6
    //   846: bipush 100
    //   848: imul
    //   849: aload_1
    //   850: arraylength
    //   851: idiv
    //   852: aload_0
    //   853: getfield 60	nui:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   856: arraylength
    //   857: idiv
    //   858: iadd
    //   859: ldc 104
    //   861: iand
    //   862: iload 8
    //   864: bipush 16
    //   866: ishl
    //   867: ior
    //   868: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   871: aastore
    //   872: invokevirtual 108	nui:publishProgress	([Ljava/lang/Object;)V
    //   875: aload 5
    //   877: bipush 20
    //   879: invokevirtual 246	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   882: astore_3
    //   883: aload_3
    //   884: astore_2
    //   885: aload_3
    //   886: ifnonnull +215 -> 1101
    //   889: aload 5
    //   891: bipush 18
    //   893: invokevirtual 246	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   896: astore_3
    //   897: aload_3
    //   898: astore_2
    //   899: aload_3
    //   900: ifnonnull +201 -> 1101
    //   903: aload 5
    //   905: bipush 16
    //   907: invokevirtual 246	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   910: astore_2
    //   911: aload_2
    //   912: ifnull +251 -> 1163
    //   915: invokestatic 203	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   918: invokestatic 209	com/tencent/image/Utils:getUsableSpace	(Ljava/io/File;)J
    //   921: lstore 9
    //   923: aload_2
    //   924: invokevirtual 213	java/io/File:length	()J
    //   927: lload 9
    //   929: lcmp
    //   930: ifle +23 -> 953
    //   933: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   936: ifeq +11 -> 947
    //   939: ldc 74
    //   941: iconst_2
    //   942: ldc -41
    //   944: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   947: bipush 22
    //   949: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   952: areturn
    //   953: new 133	java/io/File
    //   956: dup
    //   957: aload 4
    //   959: new 76	java/lang/StringBuilder
    //   962: dup
    //   963: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   966: aload_2
    //   967: invokevirtual 218	java/io/File:getName	()Ljava/lang/String;
    //   970: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: ldc -36
    //   975: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   981: invokespecial 223	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   984: astore_3
    //   985: aload_2
    //   986: aload_3
    //   987: invokestatic 228	com/dataline/util/file/FileUtil:a	(Ljava/io/File;Ljava/io/File;)Z
    //   990: ifne +54 -> 1044
    //   993: invokestatic 183	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   996: ldc -71
    //   998: invokevirtual 189	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1001: ifne +23 -> 1024
    //   1004: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1007: ifeq +11 -> 1018
    //   1010: ldc 74
    //   1012: iconst_2
    //   1013: ldc -26
    //   1015: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1018: bipush 24
    //   1020: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1023: areturn
    //   1024: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1027: ifeq +11 -> 1038
    //   1030: ldc 74
    //   1032: iconst_2
    //   1033: ldc -24
    //   1035: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1038: bipush 21
    //   1040: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1043: areturn
    //   1044: aload_0
    //   1045: getfield 39	nui:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageListScene;
    //   1048: invokestatic 248	com/tencent/mobileqq/activity/aio/photo/AIOImageListScene:b	(Lcom/tencent/mobileqq/activity/aio/photo/AIOImageListScene;)Landroid/app/Activity;
    //   1051: aload_3
    //   1052: invokevirtual 238	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1055: invokestatic 243	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   1058: goto +105 -> 1163
    //   1061: ldc -78
    //   1063: aload_2
    //   1064: invokevirtual 119	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   1067: ifeq +96 -> 1163
    //   1070: goto +93 -> 1163
    //   1073: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1076: ifeq +96 -> 1172
    //   1079: ldc 74
    //   1081: iconst_2
    //   1082: ldc -6
    //   1084: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1087: goto +85 -> 1172
    //   1090: iload 6
    //   1092: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1095: areturn
    //   1096: astore 4
    //   1098: goto -778 -> 320
    //   1101: goto -186 -> 915
    //   1104: iconst_0
    //   1105: istore 7
    //   1107: iconst_0
    //   1108: istore 6
    //   1110: goto -1076 -> 34
    //   1113: iload 7
    //   1115: iconst_1
    //   1116: iadd
    //   1117: istore 7
    //   1119: goto -1085 -> 34
    //   1122: iconst_0
    //   1123: istore 6
    //   1125: goto -1005 -> 120
    //   1128: iload 6
    //   1130: iconst_1
    //   1131: iadd
    //   1132: istore 6
    //   1134: goto -1014 -> 120
    //   1137: iload 8
    //   1139: iconst_2
    //   1140: if_icmpne +10 -> 1150
    //   1143: bipush 30
    //   1145: istore 6
    //   1147: goto -34 -> 1113
    //   1150: bipush 10
    //   1152: istore 6
    //   1154: goto -41 -> 1113
    //   1157: iconst_0
    //   1158: istore 6
    //   1160: goto -604 -> 556
    //   1163: iload 6
    //   1165: iconst_1
    //   1166: iadd
    //   1167: istore 6
    //   1169: goto -613 -> 556
    //   1172: bipush 20
    //   1174: istore 6
    //   1176: goto -63 -> 1113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1179	0	this	nui
    //   0	1179	1	paramVarArgs	Integer[]
    //   215	849	2	localObject1	Object
    //   220	738	4	localObject3	Object
    //   1096	1	4	localInterruptedException	InterruptedException
    //   827	77	5	localAIOFilePicData	com.tencent.mobileqq.activity.aio.photo.AIOFilePicData
    //   120	1055	6	i1	int
    //   34	1084	7	i2	int
    //   48	1093	8	i3	int
    //   668	260	9	l1	long
    // Exception table:
    //   from	to	target	type
    //   303	320	391	finally
    //   320	322	391	finally
    //   392	394	391	finally
    //   0	31	396	java/lang/Throwable
    //   34	62	396	java/lang/Throwable
    //   62	93	396	java/lang/Throwable
    //   120	142	396	java/lang/Throwable
    //   142	232	396	java/lang/Throwable
    //   235	247	396	java/lang/Throwable
    //   252	267	396	java/lang/Throwable
    //   267	303	396	java/lang/Throwable
    //   322	373	396	java/lang/Throwable
    //   373	385	396	java/lang/Throwable
    //   394	396	396	java/lang/Throwable
    //   402	414	396	java/lang/Throwable
    //   414	466	396	java/lang/Throwable
    //   466	484	396	java/lang/Throwable
    //   484	493	396	java/lang/Throwable
    //   496	521	396	java/lang/Throwable
    //   521	527	396	java/lang/Throwable
    //   527	553	396	java/lang/Throwable
    //   556	586	396	java/lang/Throwable
    //   586	658	396	java/lang/Throwable
    //   662	694	396	java/lang/Throwable
    //   694	700	396	java/lang/Throwable
    //   700	765	396	java/lang/Throwable
    //   765	771	396	java/lang/Throwable
    //   771	785	396	java/lang/Throwable
    //   785	791	396	java/lang/Throwable
    //   791	805	396	java/lang/Throwable
    //   808	883	396	java/lang/Throwable
    //   889	897	396	java/lang/Throwable
    //   903	911	396	java/lang/Throwable
    //   915	947	396	java/lang/Throwable
    //   947	953	396	java/lang/Throwable
    //   953	1018	396	java/lang/Throwable
    //   1018	1024	396	java/lang/Throwable
    //   1024	1038	396	java/lang/Throwable
    //   1038	1044	396	java/lang/Throwable
    //   1044	1058	396	java/lang/Throwable
    //   1061	1070	396	java/lang/Throwable
    //   1073	1087	396	java/lang/Throwable
    //   303	320	1096	java/lang/InterruptedException
  }
  
  protected void a(Integer paramInteger)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.b(paramInteger.intValue(), this.o);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_Nui = null;
  }
  
  protected void a(Integer... paramVarArgs)
  {
    int i1 = paramVarArgs[(paramVarArgs.length - 1)].intValue();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.c(i1 >> 16, 0xFFFF & i1);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */