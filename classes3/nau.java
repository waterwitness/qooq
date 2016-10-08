import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nau
  implements Runnable
{
  public nau(VisitorsActivity paramVisitorsActivity, String paramString, int paramInt, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	nau:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4: invokestatic 37	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   7: invokevirtual 41	java/lang/Long:longValue	()J
    //   10: lstore 7
    //   12: aload_0
    //   13: getfield 15	nau:jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity	Lcom/tencent/mobileqq/activity/VisitorsActivity;
    //   16: getfield 47	com/tencent/mobileqq/activity/VisitorsActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 52	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   22: invokevirtual 58	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   25: astore_3
    //   26: aload_3
    //   27: ldc 60
    //   29: ldc 62
    //   31: iconst_2
    //   32: anewarray 64	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: lload 7
    //   39: invokestatic 68	java/lang/Long:toString	(J)Ljava/lang/String;
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: iconst_3
    //   46: invokestatic 73	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   49: aastore
    //   50: invokevirtual 78	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   53: checkcast 60	com/tencent/mobileqq/data/CardProfile
    //   56: astore 4
    //   58: aload 4
    //   60: ifnull +462 -> 522
    //   63: iconst_1
    //   64: istore 9
    //   66: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +53 -> 122
    //   72: ldc 86
    //   74: iconst_2
    //   75: new 88	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   82: ldc 91
    //   84: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: getfield 17	nau:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   91: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc 97
    //   96: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: getfield 19	nau:jdField_a_of_type_Int	I
    //   103: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: ldc 102
    //   108: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: iload 9
    //   113: invokevirtual 105	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   116: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 112	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: aload_0
    //   123: getfield 15	nau:jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity	Lcom/tencent/mobileqq/activity/VisitorsActivity;
    //   126: getfield 115	com/tencent/mobileqq/activity/VisitorsActivity:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   129: lload 7
    //   131: invokestatic 118	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   134: invokeinterface 124 2 0
    //   139: checkcast 126	com/tencent/util/Pair
    //   142: astore 5
    //   144: getstatic 129	com/tencent/mobileqq/activity/VisitorsActivity:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   147: astore_2
    //   148: aload_2
    //   149: monitorenter
    //   150: iconst_0
    //   151: istore 6
    //   153: iload 6
    //   155: aload_0
    //   156: getfield 15	nau:jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity	Lcom/tencent/mobileqq/activity/VisitorsActivity;
    //   159: getfield 133	com/tencent/mobileqq/activity/VisitorsActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   162: invokevirtual 139	java/util/ArrayList:size	()I
    //   165: if_icmpge +429 -> 594
    //   168: aload_0
    //   169: getfield 15	nau:jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity	Lcom/tencent/mobileqq/activity/VisitorsActivity;
    //   172: getfield 133	com/tencent/mobileqq/activity/VisitorsActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   175: iload 6
    //   177: invokevirtual 142	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   180: checkcast 60	com/tencent/mobileqq/data/CardProfile
    //   183: getfield 146	com/tencent/mobileqq/data/CardProfile:lEctID	J
    //   186: lload 7
    //   188: lcmp
    //   189: ifne +339 -> 528
    //   192: aload_0
    //   193: getfield 15	nau:jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity	Lcom/tencent/mobileqq/activity/VisitorsActivity;
    //   196: getfield 133	com/tencent/mobileqq/activity/VisitorsActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   199: iload 6
    //   201: invokevirtual 142	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   204: checkcast 60	com/tencent/mobileqq/data/CardProfile
    //   207: astore_1
    //   208: aload_1
    //   209: ifnull +380 -> 589
    //   212: aload_1
    //   213: invokevirtual 150	com/tencent/mobileqq/data/CardProfile:clone	()Lcom/tencent/mobileqq/data/CardProfile;
    //   216: astore_1
    //   217: aload 5
    //   219: ifnull +45 -> 264
    //   222: aload_1
    //   223: aload_1
    //   224: getfield 153	com/tencent/mobileqq/data/CardProfile:bAvailableCnt	J
    //   227: aload 5
    //   229: getfield 156	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   232: checkcast 158	java/util/concurrent/atomic/AtomicInteger
    //   235: invokevirtual 160	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   238: i2l
    //   239: ladd
    //   240: putfield 153	com/tencent/mobileqq/data/CardProfile:bAvailableCnt	J
    //   243: aload_1
    //   244: aload_1
    //   245: getfield 163	com/tencent/mobileqq/data/CardProfile:bTodayVotedCnt	J
    //   248: aload 5
    //   250: getfield 156	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   253: checkcast 158	java/util/concurrent/atomic/AtomicInteger
    //   256: invokevirtual 160	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   259: i2l
    //   260: lsub
    //   261: putfield 163	com/tencent/mobileqq/data/CardProfile:bTodayVotedCnt	J
    //   264: aload_1
    //   265: aload_1
    //   266: getfield 163	com/tencent/mobileqq/data/CardProfile:bTodayVotedCnt	J
    //   269: l2i
    //   270: i2s
    //   271: putfield 167	com/tencent/mobileqq/data/CardProfile:bVoteCnt	S
    //   274: aload_2
    //   275: monitorexit
    //   276: aload_1
    //   277: ifnull +49 -> 326
    //   280: iload 9
    //   282: ifeq +29 -> 311
    //   285: aload 4
    //   287: getfield 163	com/tencent/mobileqq/data/CardProfile:bTodayVotedCnt	J
    //   290: aload_1
    //   291: getfield 163	com/tencent/mobileqq/data/CardProfile:bTodayVotedCnt	J
    //   294: lcmp
    //   295: ifne +16 -> 311
    //   298: aload 4
    //   300: getfield 163	com/tencent/mobileqq/data/CardProfile:bTodayVotedCnt	J
    //   303: aload_1
    //   304: getfield 163	com/tencent/mobileqq/data/CardProfile:bTodayVotedCnt	J
    //   307: lcmp
    //   308: ifeq +18 -> 326
    //   311: aload_1
    //   312: invokevirtual 170	com/tencent/mobileqq/data/CardProfile:getStatus	()I
    //   315: sipush 1000
    //   318: if_icmpne +224 -> 542
    //   321: aload_3
    //   322: aload_1
    //   323: invokevirtual 173	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   326: aload_0
    //   327: getfield 21	nau:jdField_a_of_type_Boolean	Z
    //   330: ifeq +221 -> 551
    //   333: aload_0
    //   334: getfield 15	nau:jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity	Lcom/tencent/mobileqq/activity/VisitorsActivity;
    //   337: getfield 176	com/tencent/mobileqq/activity/VisitorsActivity:c	Ljava/util/ArrayList;
    //   340: astore_1
    //   341: getstatic 178	com/tencent/mobileqq/activity/VisitorsActivity:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   344: astore_2
    //   345: aload_2
    //   346: monitorenter
    //   347: iconst_0
    //   348: istore 6
    //   350: iload 6
    //   352: aload_1
    //   353: invokevirtual 139	java/util/ArrayList:size	()I
    //   356: if_icmpge +227 -> 583
    //   359: aload_1
    //   360: iload 6
    //   362: invokevirtual 142	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   365: checkcast 33	java/lang/Long
    //   368: invokevirtual 41	java/lang/Long:longValue	()J
    //   371: lload 7
    //   373: lcmp
    //   374: ifne +188 -> 562
    //   377: iconst_0
    //   378: istore 6
    //   380: iload 6
    //   382: ifeq +13 -> 395
    //   385: aload_1
    //   386: lload 7
    //   388: invokestatic 118	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   391: invokevirtual 182	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   394: pop
    //   395: aload_2
    //   396: monitorexit
    //   397: iload 6
    //   399: ifeq +50 -> 449
    //   402: new 135	java/util/ArrayList
    //   405: dup
    //   406: invokespecial 183	java/util/ArrayList:<init>	()V
    //   409: astore_1
    //   410: aload_1
    //   411: aload_0
    //   412: getfield 15	nau:jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity	Lcom/tencent/mobileqq/activity/VisitorsActivity;
    //   415: getfield 176	com/tencent/mobileqq/activity/VisitorsActivity:c	Ljava/util/ArrayList;
    //   418: invokeinterface 189 2 0
    //   423: pop
    //   424: aload_1
    //   425: aload_0
    //   426: getfield 15	nau:jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity	Lcom/tencent/mobileqq/activity/VisitorsActivity;
    //   429: getfield 192	com/tencent/mobileqq/activity/VisitorsActivity:d	Ljava/util/ArrayList;
    //   432: invokeinterface 189 2 0
    //   437: pop
    //   438: aload_0
    //   439: getfield 15	nau:jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity	Lcom/tencent/mobileqq/activity/VisitorsActivity;
    //   442: getfield 195	com/tencent/mobileqq/activity/VisitorsActivity:jdField_b_of_type_ComTencentMobileqqAppCardHandler	Lcom/tencent/mobileqq/app/CardHandler;
    //   445: aload_1
    //   446: invokevirtual 200	com/tencent/mobileqq/app/CardHandler:b	(Ljava/util/List;)V
    //   449: aload_0
    //   450: getfield 21	nau:jdField_a_of_type_Boolean	Z
    //   453: ifeq +123 -> 576
    //   456: iconst_5
    //   457: istore 6
    //   459: aload_0
    //   460: getfield 15	nau:jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity	Lcom/tencent/mobileqq/activity/VisitorsActivity;
    //   463: getfield 47	com/tencent/mobileqq/activity/VisitorsActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   466: ldc -54
    //   468: ldc -52
    //   470: ldc -52
    //   472: ldc -50
    //   474: ldc -48
    //   476: iload 6
    //   478: iconst_1
    //   479: iconst_0
    //   480: ldc -46
    //   482: new 88	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   489: ldc -52
    //   491: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload_0
    //   495: getfield 19	nau:jdField_a_of_type_Int	I
    //   498: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   501: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: aload_0
    //   505: getfield 15	nau:jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity	Lcom/tencent/mobileqq/activity/VisitorsActivity;
    //   508: getfield 47	com/tencent/mobileqq/activity/VisitorsActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   511: invokevirtual 212	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   514: aload_0
    //   515: getfield 17	nau:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   518: invokestatic 217	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   521: return
    //   522: iconst_0
    //   523: istore 9
    //   525: goto -459 -> 66
    //   528: iload 6
    //   530: iconst_1
    //   531: iadd
    //   532: istore 6
    //   534: goto -381 -> 153
    //   537: astore_1
    //   538: aload_2
    //   539: monitorexit
    //   540: aload_1
    //   541: athrow
    //   542: aload_3
    //   543: aload_1
    //   544: invokevirtual 220	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   547: pop
    //   548: goto -222 -> 326
    //   551: aload_0
    //   552: getfield 15	nau:jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity	Lcom/tencent/mobileqq/activity/VisitorsActivity;
    //   555: getfield 192	com/tencent/mobileqq/activity/VisitorsActivity:d	Ljava/util/ArrayList;
    //   558: astore_1
    //   559: goto -218 -> 341
    //   562: iload 6
    //   564: iconst_1
    //   565: iadd
    //   566: istore 6
    //   568: goto -218 -> 350
    //   571: astore_1
    //   572: aload_2
    //   573: monitorexit
    //   574: aload_1
    //   575: athrow
    //   576: bipush 6
    //   578: istore 6
    //   580: goto -121 -> 459
    //   583: iconst_1
    //   584: istore 6
    //   586: goto -206 -> 380
    //   589: aconst_null
    //   590: astore_1
    //   591: goto -317 -> 274
    //   594: aconst_null
    //   595: astore_1
    //   596: goto -388 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	599	0	this	nau
    //   207	239	1	localObject1	Object
    //   537	7	1	localEntity	com.tencent.mobileqq.persistence.Entity
    //   558	1	1	localArrayList	java.util.ArrayList
    //   571	4	1	localObject2	Object
    //   590	6	1	localObject3	Object
    //   147	426	2	localObject4	Object
    //   25	518	3	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   56	243	4	localCardProfile	com.tencent.mobileqq.data.CardProfile
    //   142	107	5	localPair	com.tencent.util.Pair
    //   151	434	6	i	int
    //   10	377	7	l	long
    //   64	460	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   153	208	537	finally
    //   212	217	537	finally
    //   222	264	537	finally
    //   264	274	537	finally
    //   274	276	537	finally
    //   538	540	537	finally
    //   350	377	571	finally
    //   385	395	571	finally
    //   395	397	571	finally
    //   572	574	571	finally
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\nau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */