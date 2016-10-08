import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import java.lang.ref.WeakReference;

public class lmk
  implements Runnable
{
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference b;
  
  public lmk(FriendProfileCardActivity paramFriendProfileCardActivity, ProfileCardTemplate paramProfileCardTemplate, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFriendProfileCardActivity);
    this.b = new WeakReference(paramProfileCardTemplate);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: ldc 40
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 28	lmk:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   10: ifnull +377 -> 387
    //   13: aload_0
    //   14: getfield 30	lmk:b	Ljava/lang/ref/WeakReference;
    //   17: ifnull +370 -> 387
    //   20: aload_0
    //   21: getfield 28	lmk:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   24: invokevirtual 44	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   27: checkcast 40	com/tencent/mobileqq/activity/FriendProfileCardActivity
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 30	lmk:b	Ljava/lang/ref/WeakReference;
    //   35: invokevirtual 44	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   38: checkcast 46	com/tencent/mobileqq/profile/ProfileCardTemplate
    //   41: astore_2
    //   42: aload_1
    //   43: ifnull +344 -> 387
    //   46: aload_2
    //   47: ifnull +340 -> 387
    //   50: aload_1
    //   51: getfield 49	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil	Lcom/tencent/mobileqq/utils/TimeTraceUtil;
    //   54: ldc 51
    //   56: iconst_1
    //   57: invokevirtual 56	com/tencent/mobileqq/utils/TimeTraceUtil:a	(Ljava/lang/String;Z)V
    //   60: aload_1
    //   61: getfield 60	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   64: invokestatic 65	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   67: istore 8
    //   69: aload_1
    //   70: getfield 60	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   73: invokevirtual 71	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   76: aload_0
    //   77: getfield 32	lmk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   80: invokestatic 74	com/tencent/mobileqq/util/ProfileCardUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   83: istore 9
    //   85: iload 9
    //   87: ifne +634 -> 721
    //   90: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +41 -> 134
    //   96: ldc 82
    //   98: iconst_2
    //   99: new 84	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   106: ldc 87
    //   108: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: getfield 32	lmk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   115: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc 93
    //   120: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: iload 9
    //   125: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   128: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 104	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: new 106	java/io/File
    //   137: dup
    //   138: aload_1
    //   139: getfield 60	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   142: invokevirtual 71	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   145: aload_0
    //   146: getfield 32	lmk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   149: invokestatic 109	com/tencent/mobileqq/util/ProfileCardUtil:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   152: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   155: astore_2
    //   156: new 114	com/tencent/mobileqq/vip/DownloadTask
    //   159: dup
    //   160: aload_0
    //   161: getfield 32	lmk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   164: aload_2
    //   165: invokespecial 117	com/tencent/mobileqq/vip/DownloadTask:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   168: astore_2
    //   169: aload_2
    //   170: ldc 119
    //   172: putfield 122	com/tencent/mobileqq/vip/DownloadTask:f	Ljava/lang/String;
    //   175: aload_2
    //   176: ldc 124
    //   178: putfield 127	com/tencent/mobileqq/vip/DownloadTask:e	Ljava/lang/String;
    //   181: aload_2
    //   182: aload_1
    //   183: getfield 60	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   186: invokestatic 132	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lmqq/app/AppRuntime;)I
    //   189: ifne +202 -> 391
    //   192: aload_1
    //   193: getfield 60	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   196: invokevirtual 71	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   199: aload_0
    //   200: getfield 32	lmk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   203: invokestatic 74	com/tencent/mobileqq/util/ProfileCardUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   206: ifeq +185 -> 391
    //   209: iconst_1
    //   210: istore 7
    //   212: goto +512 -> 724
    //   215: aload_1
    //   216: getfield 49	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil	Lcom/tencent/mobileqq/utils/TimeTraceUtil;
    //   219: ldc -122
    //   221: ldc 51
    //   223: iconst_0
    //   224: invokevirtual 137	com/tencent/mobileqq/utils/TimeTraceUtil:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   227: iload 8
    //   229: istore 7
    //   231: iload 8
    //   233: ifne +92 -> 325
    //   236: aload_1
    //   237: getfield 60	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   240: ldc2_w 138
    //   243: invokestatic 142	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;J)Ljava/lang/String;
    //   246: astore_2
    //   247: iload 8
    //   249: istore 7
    //   251: ldc -112
    //   253: ifnull +72 -> 325
    //   256: iload 8
    //   258: istore 7
    //   260: aload_2
    //   261: ifnull +64 -> 325
    //   264: new 106	java/io/File
    //   267: dup
    //   268: aload_2
    //   269: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   272: astore_3
    //   273: new 106	java/io/File
    //   276: dup
    //   277: new 84	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   284: aload_2
    //   285: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: getstatic 147	java/io/File:separator	Ljava/lang/String;
    //   291: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc -107
    //   296: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   305: astore 4
    //   307: aload_3
    //   308: invokevirtual 152	java/io/File:isDirectory	()Z
    //   311: ifeq +86 -> 397
    //   314: aload 4
    //   316: invokevirtual 155	java/io/File:exists	()Z
    //   319: ifeq +78 -> 397
    //   322: iconst_1
    //   323: istore 7
    //   325: aload_1
    //   326: getfield 49	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil	Lcom/tencent/mobileqq/utils/TimeTraceUtil;
    //   329: ldc -99
    //   331: ldc -122
    //   333: iconst_0
    //   334: invokevirtual 137	com/tencent/mobileqq/utils/TimeTraceUtil:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   337: aload_1
    //   338: getfield 160	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   341: ifnull +46 -> 387
    //   344: aload_1
    //   345: getfield 160	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   348: invokevirtual 166	com/tencent/util/WeakReferenceHandler:obtainMessage	()Landroid/os/Message;
    //   351: astore_2
    //   352: aload_2
    //   353: bipush 7
    //   355: putfield 172	android/os/Message:what	I
    //   358: iload 7
    //   360: ifeq +355 -> 715
    //   363: iload 9
    //   365: ifeq +350 -> 715
    //   368: iload 6
    //   370: istore 5
    //   372: aload_2
    //   373: iload 5
    //   375: putfield 175	android/os/Message:arg1	I
    //   378: aload_1
    //   379: getfield 160	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   382: aload_2
    //   383: invokevirtual 179	com/tencent/util/WeakReferenceHandler:sendMessage	(Landroid/os/Message;)Z
    //   386: pop
    //   387: ldc 40
    //   389: monitorexit
    //   390: return
    //   391: iconst_0
    //   392: istore 7
    //   394: goto +330 -> 724
    //   397: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq +28 -> 428
    //   403: ldc 82
    //   405: iconst_2
    //   406: new 84	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   413: ldc -75
    //   415: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload_2
    //   419: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 104	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: new 106	java/io/File
    //   431: dup
    //   432: new 84	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   439: aload_2
    //   440: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: ldc -73
    //   445: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   454: astore_3
    //   455: aload_3
    //   456: invokevirtual 155	java/io/File:exists	()Z
    //   459: ifeq +8 -> 467
    //   462: aload_3
    //   463: invokevirtual 186	java/io/File:delete	()Z
    //   466: pop
    //   467: new 114	com/tencent/mobileqq/vip/DownloadTask
    //   470: dup
    //   471: ldc -112
    //   473: aload_3
    //   474: invokespecial 117	com/tencent/mobileqq/vip/DownloadTask:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   477: astore 4
    //   479: aload 4
    //   481: ldc 119
    //   483: putfield 122	com/tencent/mobileqq/vip/DownloadTask:f	Ljava/lang/String;
    //   486: aload 4
    //   488: ldc 124
    //   490: putfield 127	com/tencent/mobileqq/vip/DownloadTask:e	Ljava/lang/String;
    //   493: aload 4
    //   495: aload_1
    //   496: getfield 60	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   499: invokestatic 132	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lmqq/app/AppRuntime;)I
    //   502: ifne +235 -> 737
    //   505: iconst_1
    //   506: istore 5
    //   508: iload 8
    //   510: istore 7
    //   512: iload 5
    //   514: ifeq -189 -> 325
    //   517: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   520: ifeq +31 -> 551
    //   523: ldc 82
    //   525: iconst_2
    //   526: new 84	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   533: ldc -68
    //   535: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_3
    //   539: invokevirtual 192	java/io/File:length	()J
    //   542: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   545: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   551: aload_3
    //   552: invokevirtual 201	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   555: new 84	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   562: aload_2
    //   563: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: getstatic 147	java/io/File:separator	Ljava/lang/String;
    //   569: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: iconst_0
    //   576: invokestatic 204	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   579: aload_1
    //   580: getfield 60	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   583: ldc -50
    //   585: ldc -48
    //   587: invokestatic 211	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   590: aload_1
    //   591: getfield 60	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   594: invokestatic 65	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   597: ifeq +25 -> 622
    //   600: aload_3
    //   601: invokevirtual 186	java/io/File:delete	()Z
    //   604: pop
    //   605: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   608: ifeq +123 -> 731
    //   611: ldc 82
    //   613: iconst_2
    //   614: ldc -43
    //   616: invokestatic 104	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   619: goto +112 -> 731
    //   622: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   625: ifeq +11 -> 636
    //   628: ldc 82
    //   630: iconst_2
    //   631: ldc -41
    //   633: invokestatic 104	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   636: iload 8
    //   638: istore 7
    //   640: goto +94 -> 734
    //   643: astore_2
    //   644: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   647: ifeq +31 -> 678
    //   650: ldc 82
    //   652: iconst_2
    //   653: new 84	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   660: ldc -39
    //   662: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: aload_2
    //   666: invokevirtual 220	java/io/IOException:getMessage	()Ljava/lang/String;
    //   669: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 104	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   678: aload_2
    //   679: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   682: iload 8
    //   684: istore 7
    //   686: goto -361 -> 325
    //   689: astore_1
    //   690: aload_1
    //   691: invokevirtual 224	java/lang/Exception:printStackTrace	()V
    //   694: goto -307 -> 387
    //   697: astore_1
    //   698: ldc 40
    //   700: monitorexit
    //   701: aload_1
    //   702: athrow
    //   703: astore_2
    //   704: aload_2
    //   705: invokevirtual 224	java/lang/Exception:printStackTrace	()V
    //   708: iload 8
    //   710: istore 7
    //   712: goto -387 -> 325
    //   715: iconst_0
    //   716: istore 5
    //   718: goto -346 -> 372
    //   721: goto -506 -> 215
    //   724: iload 7
    //   726: istore 9
    //   728: goto -513 -> 215
    //   731: iconst_1
    //   732: istore 7
    //   734: goto -409 -> 325
    //   737: iconst_0
    //   738: istore 5
    //   740: goto -232 -> 508
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	743	0	this	lmk
    //   30	561	1	localFriendProfileCardActivity	FriendProfileCardActivity
    //   689	2	1	localException1	Exception
    //   697	5	1	localObject1	Object
    //   41	522	2	localObject2	Object
    //   643	36	2	localIOException	java.io.IOException
    //   703	2	2	localException2	Exception
    //   272	329	3	localFile	java.io.File
    //   305	189	4	localObject3	Object
    //   370	369	5	i	int
    //   1	368	6	j	int
    //   210	523	7	bool1	boolean
    //   67	642	8	bool2	boolean
    //   83	644	9	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   551	619	643	java/io/IOException
    //   622	636	643	java/io/IOException
    //   6	42	689	java/lang/Exception
    //   50	85	689	java/lang/Exception
    //   90	134	689	java/lang/Exception
    //   134	209	689	java/lang/Exception
    //   215	227	689	java/lang/Exception
    //   236	247	689	java/lang/Exception
    //   264	322	689	java/lang/Exception
    //   325	358	689	java/lang/Exception
    //   372	387	689	java/lang/Exception
    //   397	428	689	java/lang/Exception
    //   428	467	689	java/lang/Exception
    //   467	505	689	java/lang/Exception
    //   517	551	689	java/lang/Exception
    //   644	678	689	java/lang/Exception
    //   678	682	689	java/lang/Exception
    //   704	708	689	java/lang/Exception
    //   6	42	697	finally
    //   50	85	697	finally
    //   90	134	697	finally
    //   134	209	697	finally
    //   215	227	697	finally
    //   236	247	697	finally
    //   264	322	697	finally
    //   325	358	697	finally
    //   372	387	697	finally
    //   387	390	697	finally
    //   397	428	697	finally
    //   428	467	697	finally
    //   467	505	697	finally
    //   517	551	697	finally
    //   551	619	697	finally
    //   622	636	697	finally
    //   644	678	697	finally
    //   678	682	697	finally
    //   690	694	697	finally
    //   698	701	697	finally
    //   704	708	697	finally
    //   551	619	703	java/lang/Exception
    //   622	636	703	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lmk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */