package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoUploadTask
  implements Runnable
{
  private static String c;
  private static String d;
  protected long a;
  protected TroopBarShortVideoUploadUtil.OnUploadVideoListener a;
  public TroopBarUploadItemEntity a;
  protected String a;
  protected AtomicBoolean a;
  protected String b;
  
  public VideoUploadTask(String paramString1, String paramString2, TroopBarUploadItemEntity paramTroopBarUploadItemEntity, TroopBarShortVideoUploadUtil.OnUploadVideoListener paramOnUploadVideoListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity = paramTroopBarUploadItemEntity;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener = paramOnUploadVideoListener;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   3: lstore 16
    //   5: aload_0
    //   6: getfield 33	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   9: iconst_0
    //   10: invokevirtual 49	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   13: aload_0
    //   14: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   17: ifnonnull +26 -> 43
    //   20: aload_0
    //   21: getfield 33	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   24: iconst_1
    //   25: invokevirtual 49	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   28: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +11 -> 42
    //   34: ldc 73
    //   36: iconst_2
    //   37: ldc 75
    //   39: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: return
    //   43: aload_0
    //   44: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   47: ifnull +23 -> 70
    //   50: aload_0
    //   51: getfield 39	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +13 -> 70
    //   60: aload_0
    //   61: getfield 41	com/tencent/mobileqq/troop/data/VideoUploadTask:b	Ljava/lang/String;
    //   64: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifeq +92 -> 159
    //   70: aload_0
    //   71: getfield 33	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   74: iconst_1
    //   75: invokevirtual 49	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   78: aload_0
    //   79: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   82: ldc2_w 34
    //   85: invokeinterface 89 3 0
    //   90: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq -51 -> 42
    //   96: aload_0
    //   97: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   100: ifnonnull +37 -> 137
    //   103: ldc 91
    //   105: astore_1
    //   106: ldc 73
    //   108: iconst_2
    //   109: new 93	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   116: ldc 96
    //   118: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_1
    //   122: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 102
    //   127: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: return
    //   137: aload_0
    //   138: getfield 39	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   141: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifeq +9 -> 153
    //   147: ldc 108
    //   149: astore_1
    //   150: goto -44 -> 106
    //   153: ldc 110
    //   155: astore_1
    //   156: goto -50 -> 106
    //   159: aload_0
    //   160: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   163: getfield 113	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:b	Ljava/lang/String;
    //   166: astore_2
    //   167: new 115	android/os/Bundle
    //   170: dup
    //   171: invokespecial 116	android/os/Bundle:<init>	()V
    //   174: astore_1
    //   175: aload_1
    //   176: ldc 118
    //   178: getstatic 120	com/tencent/mobileqq/troop/data/VideoUploadTask:c	Ljava/lang/String;
    //   181: invokevirtual 124	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload_1
    //   185: ldc 126
    //   187: aload_2
    //   188: invokevirtual 124	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload_1
    //   192: ldc -128
    //   194: getstatic 130	com/tencent/mobileqq/troop/data/VideoUploadTask:d	Ljava/lang/String;
    //   197: invokevirtual 124	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload_1
    //   201: ldc -124
    //   203: aload_0
    //   204: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   207: getfield 133	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   210: invokevirtual 124	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_1
    //   214: ldc -121
    //   216: aload_0
    //   217: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   220: getfield 136	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:c	Ljava/lang/String;
    //   223: invokevirtual 124	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_1
    //   227: ldc -118
    //   229: aload_0
    //   230: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   233: getfield 142	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:m	I
    //   236: invokevirtual 146	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   239: invokestatic 152	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   242: invokestatic 157	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;)Z
    //   245: ifeq +824 -> 1069
    //   248: aload_0
    //   249: getfield 33	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   252: invokevirtual 53	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   255: ifne +814 -> 1069
    //   258: aload_0
    //   259: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   262: getfield 142	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:m	I
    //   265: iconst_3
    //   266: if_icmpne +202 -> 468
    //   269: aload_0
    //   270: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   273: getfield 160	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$ApplyUploadRsp	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp;
    //   276: ifnull +106 -> 382
    //   279: aload_0
    //   280: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   283: getfield 160	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$ApplyUploadRsp	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp;
    //   286: getfield 165	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   289: ifnull +93 -> 382
    //   292: aload_0
    //   293: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   296: getfield 160	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$ApplyUploadRsp	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp;
    //   299: astore_1
    //   300: aload_1
    //   301: ifnull +744 -> 1045
    //   304: ldc -89
    //   306: aload_1
    //   307: getfield 170	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:h	Ljava/lang/String;
    //   310: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   313: ifeq +171 -> 484
    //   316: iconst_1
    //   317: istore 6
    //   319: aload_0
    //   320: getfield 33	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   323: iconst_0
    //   324: iconst_1
    //   325: invokevirtual 180	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   328: ifeq -286 -> 42
    //   331: iload 6
    //   333: ifeq +626 -> 959
    //   336: aload_0
    //   337: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   340: invokeinterface 182 1 0
    //   345: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq -306 -> 42
    //   351: ldc 73
    //   353: iconst_2
    //   354: new 93	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   361: ldc -72
    //   363: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   369: lload 16
    //   371: lsub
    //   372: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   375: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: return
    //   382: aload_1
    //   383: aload_0
    //   384: getfield 39	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   387: aload_0
    //   388: getfield 41	com/tencent/mobileqq/troop/data/VideoUploadTask:b	Ljava/lang/String;
    //   391: invokestatic 192	com/tencent/mobileqq/troop/utils/TroopRewardUtil:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp;
    //   394: astore_1
    //   395: aload_1
    //   396: ifnull +670 -> 1066
    //   399: aload_0
    //   400: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   403: aload_1
    //   404: getfield 165	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   407: putfield 136	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:c	Ljava/lang/String;
    //   410: new 194	java/io/File
    //   413: dup
    //   414: aload_0
    //   415: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   418: getfield 113	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:b	Ljava/lang/String;
    //   421: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   424: astore_3
    //   425: aload_3
    //   426: invokevirtual 200	java/io/File:exists	()Z
    //   429: ifeq +14 -> 443
    //   432: aload_0
    //   433: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   436: aload_3
    //   437: invokevirtual 203	java/io/File:length	()J
    //   440: putfield 204	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:jdField_a_of_type_Long	J
    //   443: aload_0
    //   444: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   447: aload_0
    //   448: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   451: getfield 113	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:b	Ljava/lang/String;
    //   454: invokestatic 209	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;)J
    //   457: ldc2_w 210
    //   460: ldiv
    //   461: l2i
    //   462: putfield 214	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:l	I
    //   465: goto -165 -> 300
    //   468: aload_1
    //   469: aload_0
    //   470: getfield 39	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   473: aload_0
    //   474: getfield 41	com/tencent/mobileqq/troop/data/VideoUploadTask:b	Ljava/lang/String;
    //   477: invokestatic 217	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp;
    //   480: astore_1
    //   481: goto -181 -> 300
    //   484: aload_1
    //   485: getfield 165	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   488: ifnull +557 -> 1045
    //   491: aload_1
    //   492: getfield 218	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:c	Ljava/lang/String;
    //   495: invokestatic 223	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   498: astore_3
    //   499: aload_2
    //   500: invokestatic 226	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)[B
    //   503: astore 4
    //   505: aload_2
    //   506: invokestatic 229	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)J
    //   509: lstore 10
    //   511: lload 10
    //   513: ldc2_w 230
    //   516: lcmp
    //   517: ifle +243 -> 760
    //   520: ldc2_w 230
    //   523: lstore 8
    //   525: new 93	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   532: ldc -23
    //   534: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: aload_1
    //   538: getfield 234	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   541: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: ldc -20
    //   546: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload_1
    //   550: getfield 237	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:b	Ljava/lang/String;
    //   553: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: ldc -17
    //   558: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: astore 5
    //   566: aload_0
    //   567: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   570: invokeinterface 241 1 0
    //   575: new 243	java/io/RandomAccessFile
    //   578: dup
    //   579: aload_2
    //   580: ldc -11
    //   582: invokespecial 247	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   585: astore_2
    //   586: lconst_0
    //   587: lstore 14
    //   589: lload 8
    //   591: lstore 12
    //   593: lload 14
    //   595: lstore 8
    //   597: lload 12
    //   599: lload 8
    //   601: lsub
    //   602: l2i
    //   603: istore 6
    //   605: aload_2
    //   606: astore_1
    //   607: invokestatic 152	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   610: invokestatic 157	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;)Z
    //   613: ifeq +244 -> 857
    //   616: aload_2
    //   617: astore_1
    //   618: aload_0
    //   619: getfield 33	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   622: invokevirtual 53	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   625: ifne +232 -> 857
    //   628: aload_2
    //   629: astore_1
    //   630: aload_3
    //   631: aload 4
    //   633: aload 5
    //   635: lload 10
    //   637: aload_2
    //   638: lload 8
    //   640: iload 6
    //   642: invokestatic 250	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	([B[BLjava/lang/String;JLjava/io/RandomAccessFile;JI)J
    //   645: lstore 12
    //   647: aload_2
    //   648: astore_1
    //   649: aload_0
    //   650: lload 12
    //   652: putfield 37	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Long	J
    //   655: lload 12
    //   657: ldc2_w 34
    //   660: lcmp
    //   661: ifeq +106 -> 767
    //   664: aload_2
    //   665: astore_1
    //   666: aload_0
    //   667: invokevirtual 252	com/tencent/mobileqq/troop/data/VideoUploadTask:a	()Z
    //   670: ifne +16 -> 686
    //   673: aload_2
    //   674: astore_1
    //   675: aload_0
    //   676: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   679: lload 12
    //   681: invokeinterface 254 3 0
    //   686: ldc2_w 230
    //   689: lload 12
    //   691: ladd
    //   692: lload 10
    //   694: lcmp
    //   695: ifle +151 -> 846
    //   698: lload 10
    //   700: lstore 8
    //   702: lload 12
    //   704: lload 10
    //   706: lcmp
    //   707: iflt +344 -> 1051
    //   710: iconst_1
    //   711: istore 7
    //   713: iload 7
    //   715: istore 6
    //   717: aload_2
    //   718: ifnull -399 -> 319
    //   721: aload_2
    //   722: invokevirtual 257	java/io/RandomAccessFile:close	()V
    //   725: iload 7
    //   727: istore 6
    //   729: goto -410 -> 319
    //   732: astore_1
    //   733: iload 7
    //   735: istore 6
    //   737: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   740: ifeq -421 -> 319
    //   743: ldc 73
    //   745: iconst_2
    //   746: aload_1
    //   747: invokestatic 261	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   750: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   753: iload 7
    //   755: istore 6
    //   757: goto -438 -> 319
    //   760: lload 10
    //   762: lstore 8
    //   764: goto -239 -> 525
    //   767: aload_2
    //   768: astore_1
    //   769: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   772: ifeq -62 -> 710
    //   775: aload_2
    //   776: astore_1
    //   777: ldc 73
    //   779: iconst_2
    //   780: new 93	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   787: ldc_w 263
    //   790: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   796: lload 16
    //   798: lsub
    //   799: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   802: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   808: goto -98 -> 710
    //   811: astore_3
    //   812: aload_2
    //   813: astore_1
    //   814: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   817: ifeq +15 -> 832
    //   820: aload_2
    //   821: astore_1
    //   822: ldc 73
    //   824: iconst_2
    //   825: aload_3
    //   826: invokestatic 261	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   829: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   832: aload_2
    //   833: ifnull +212 -> 1045
    //   836: aload_2
    //   837: invokevirtual 257	java/io/RandomAccessFile:close	()V
    //   840: iconst_0
    //   841: istore 6
    //   843: goto -524 -> 319
    //   846: ldc2_w 230
    //   849: lload 12
    //   851: ladd
    //   852: lstore 8
    //   854: goto -152 -> 702
    //   857: aload_2
    //   858: astore_1
    //   859: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   862: ifeq -152 -> 710
    //   865: aload_2
    //   866: astore_1
    //   867: ldc 73
    //   869: iconst_2
    //   870: new 93	java/lang/StringBuilder
    //   873: dup
    //   874: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   877: ldc_w 265
    //   880: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   886: lload 16
    //   888: lsub
    //   889: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   892: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   895: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   898: goto -188 -> 710
    //   901: astore_3
    //   902: aload_1
    //   903: astore_2
    //   904: aload_3
    //   905: astore_1
    //   906: aload_2
    //   907: ifnull +7 -> 914
    //   910: aload_2
    //   911: invokevirtual 257	java/io/RandomAccessFile:close	()V
    //   914: aload_1
    //   915: athrow
    //   916: astore_1
    //   917: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   920: ifeq +13 -> 933
    //   923: ldc 73
    //   925: iconst_2
    //   926: aload_1
    //   927: invokestatic 261	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   930: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   933: iconst_0
    //   934: istore 6
    //   936: goto -617 -> 319
    //   939: astore_2
    //   940: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   943: ifeq -29 -> 914
    //   946: ldc 73
    //   948: iconst_2
    //   949: aload_2
    //   950: invokestatic 261	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   953: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   956: goto -42 -> 914
    //   959: invokestatic 152	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   962: invokestatic 157	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;)Z
    //   965: ifne +9 -> 974
    //   968: ldc2_w 266
    //   971: invokestatic 272	java/lang/Thread:sleep	(J)V
    //   974: aload_0
    //   975: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   978: aload_0
    //   979: getfield 37	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Long	J
    //   982: invokeinterface 89 3 0
    //   987: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   990: ifeq -948 -> 42
    //   993: ldc 73
    //   995: iconst_2
    //   996: new 93	java/lang/StringBuilder
    //   999: dup
    //   1000: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1003: ldc_w 274
    //   1006: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   1012: lload 16
    //   1014: lsub
    //   1015: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1018: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1021: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1024: return
    //   1025: astore_1
    //   1026: aload_1
    //   1027: invokevirtual 277	java/lang/InterruptedException:printStackTrace	()V
    //   1030: goto -56 -> 974
    //   1033: astore_1
    //   1034: aconst_null
    //   1035: astore_2
    //   1036: goto -130 -> 906
    //   1039: astore_3
    //   1040: aconst_null
    //   1041: astore_2
    //   1042: goto -230 -> 812
    //   1045: iconst_0
    //   1046: istore 6
    //   1048: goto -729 -> 319
    //   1051: lload 8
    //   1053: lstore 14
    //   1055: lload 12
    //   1057: lstore 8
    //   1059: lload 14
    //   1061: lstore 12
    //   1063: goto -466 -> 597
    //   1066: goto -766 -> 300
    //   1069: aconst_null
    //   1070: astore_1
    //   1071: goto -771 -> 300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1074	0	this	VideoUploadTask
    //   105	570	1	localObject1	Object
    //   732	15	1	localIOException1	java.io.IOException
    //   768	147	1	localObject2	Object
    //   916	11	1	localIOException2	java.io.IOException
    //   1025	2	1	localInterruptedException	InterruptedException
    //   1033	1	1	localObject3	Object
    //   1070	1	1	localObject4	Object
    //   166	745	2	localObject5	Object
    //   939	11	2	localIOException3	java.io.IOException
    //   1035	7	2	localObject6	Object
    //   424	207	3	localObject7	Object
    //   811	15	3	localException1	Exception
    //   901	4	3	localObject8	Object
    //   1039	1	3	localException2	Exception
    //   503	129	4	arrayOfByte	byte[]
    //   564	70	5	str	String
    //   317	730	6	i	int
    //   711	43	7	j	int
    //   523	535	8	l1	long
    //   509	252	10	l2	long
    //   591	471	12	l3	long
    //   587	473	14	l4	long
    //   3	1010	16	l5	long
    // Exception table:
    //   from	to	target	type
    //   721	725	732	java/io/IOException
    //   607	616	811	java/lang/Exception
    //   618	628	811	java/lang/Exception
    //   630	647	811	java/lang/Exception
    //   649	655	811	java/lang/Exception
    //   666	673	811	java/lang/Exception
    //   675	686	811	java/lang/Exception
    //   769	775	811	java/lang/Exception
    //   777	808	811	java/lang/Exception
    //   859	865	811	java/lang/Exception
    //   867	898	811	java/lang/Exception
    //   607	616	901	finally
    //   618	628	901	finally
    //   630	647	901	finally
    //   649	655	901	finally
    //   666	673	901	finally
    //   675	686	901	finally
    //   769	775	901	finally
    //   777	808	901	finally
    //   814	820	901	finally
    //   822	832	901	finally
    //   859	865	901	finally
    //   867	898	901	finally
    //   836	840	916	java/io/IOException
    //   910	914	939	java/io/IOException
    //   968	974	1025	java/lang/InterruptedException
    //   566	586	1033	finally
    //   566	586	1039	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\VideoUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */