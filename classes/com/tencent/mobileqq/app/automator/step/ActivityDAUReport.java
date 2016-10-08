package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ActivityDAUReport
  extends AsyncStep
{
  public ActivityDAUReport()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  protected int a()
  {
    // Byte code:
    //   0: invokestatic 26	com/tencent/bitapp/preDownload/RNPreDownloadFacade:a	()Z
    //   3: istore 8
    //   5: new 28	java/util/HashMap
    //   8: dup
    //   9: iconst_2
    //   10: invokespecial 31	java/util/HashMap:<init>	(I)V
    //   13: astore_1
    //   14: aload_1
    //   15: ldc 33
    //   17: aconst_null
    //   18: invokestatic 38	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   21: invokestatic 44	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   24: invokevirtual 48	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   27: pop
    //   28: aload_1
    //   29: ldc 50
    //   31: invokestatic 54	com/tencent/mobileqq/activity/photo/StatisticConstants:a	()I
    //   34: invokestatic 44	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   37: invokevirtual 48	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: pop
    //   41: invokestatic 60	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   44: invokestatic 65	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   47: aload_0
    //   48: getfield 68	com/tencent/mobileqq/app/automator/step/ActivityDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   51: invokevirtual 74	com/tencent/mobileqq/app/automator/Automator:b	()Ljava/lang/String;
    //   54: ldc 76
    //   56: iload 8
    //   58: lconst_0
    //   59: lconst_0
    //   60: aload_1
    //   61: ldc 78
    //   63: invokevirtual 81	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   66: invokestatic 85	com/tencent/mobileqq/nearby/NearbyUtils:b	()Z
    //   69: ifeq +25 -> 94
    //   72: ldc 87
    //   74: iconst_2
    //   75: anewarray 89	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: ldc 76
    //   82: aastore
    //   83: dup
    //   84: iconst_1
    //   85: iload 8
    //   87: invokestatic 94	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   90: aastore
    //   91: invokestatic 97	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload_0
    //   95: getfield 68	com/tencent/mobileqq/app/automator/step/ActivityDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   98: getfield 100	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/common/app/AppInterface;
    //   101: invokevirtual 105	com/tencent/common/app/AppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   104: invokevirtual 111	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   107: astore_2
    //   108: ldc 113
    //   110: monitorenter
    //   111: aload_2
    //   112: ldc 113
    //   114: invokevirtual 118	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   117: astore_1
    //   118: aload_0
    //   119: getfield 68	com/tencent/mobileqq/app/automator/step/ActivityDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   122: getfield 100	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/common/app/AppInterface;
    //   125: bipush 50
    //   127: invokevirtual 122	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   130: checkcast 124	com/tencent/mobileqq/app/FriendsManager
    //   133: astore_3
    //   134: aload_3
    //   135: ifnull +401 -> 536
    //   138: aload_3
    //   139: aload_0
    //   140: getfield 68	com/tencent/mobileqq/app/automator/step/ActivityDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   143: getfield 100	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/common/app/AppInterface;
    //   146: invokevirtual 126	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   149: invokevirtual 129	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   152: astore_3
    //   153: aload_3
    //   154: ifnull +382 -> 536
    //   157: aload_3
    //   158: getfield 135	com/tencent/mobileqq/data/Card:shGender	S
    //   161: istore 7
    //   163: aload_3
    //   164: getfield 139	com/tencent/mobileqq/data/Card:age	B
    //   167: istore 6
    //   169: aload_1
    //   170: ifnull +310 -> 480
    //   173: aload_1
    //   174: invokeinterface 144 1 0
    //   179: ifle +301 -> 480
    //   182: aload_1
    //   183: invokeinterface 148 1 0
    //   188: astore_3
    //   189: aload_3
    //   190: invokeinterface 153 1 0
    //   195: ifeq +278 -> 473
    //   198: aload_3
    //   199: invokeinterface 157 1 0
    //   204: checkcast 113	com/tencent/mobileqq/data/ActivityDAUInfo
    //   207: astore 4
    //   209: new 28	java/util/HashMap
    //   212: dup
    //   213: iconst_2
    //   214: invokespecial 31	java/util/HashMap:<init>	(I)V
    //   217: astore 5
    //   219: aload 5
    //   221: ldc -97
    //   223: aload 4
    //   225: getfield 162	com/tencent/mobileqq/data/ActivityDAUInfo:activityName	Ljava/lang/String;
    //   228: invokevirtual 48	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   231: pop
    //   232: aload 5
    //   234: ldc -92
    //   236: aload 4
    //   238: getfield 167	com/tencent/mobileqq/data/ActivityDAUInfo:count	I
    //   241: invokestatic 44	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   244: invokevirtual 48	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   247: pop
    //   248: aload 5
    //   250: ldc -87
    //   252: iload 7
    //   254: invokestatic 44	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   257: invokevirtual 48	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   260: pop
    //   261: aload 5
    //   263: ldc -86
    //   265: iload 6
    //   267: invokestatic 44	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   270: invokevirtual 48	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   273: pop
    //   274: aload 5
    //   276: ldc -84
    //   278: aload 4
    //   280: getfield 174	com/tencent/mobileqq/data/ActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   283: invokevirtual 48	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   286: pop
    //   287: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   290: ifeq +104 -> 394
    //   293: ldc -75
    //   295: iconst_2
    //   296: new 183	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   303: ldc -70
    //   305: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload 4
    //   310: getfield 162	com/tencent/mobileqq/data/ActivityDAUInfo:activityName	Ljava/lang/String;
    //   313: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc -64
    //   318: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 4
    //   323: getfield 167	com/tencent/mobileqq/data/ActivityDAUInfo:count	I
    //   326: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   329: ldc -59
    //   331: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload 4
    //   336: getfield 200	com/tencent/mobileqq/data/ActivityDAUInfo:displayCount	I
    //   339: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: ldc -64
    //   344: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload 4
    //   349: getfield 204	com/tencent/mobileqq/data/ActivityDAUInfo:showTime	J
    //   352: invokevirtual 207	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   355: ldc -47
    //   357: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: iload 7
    //   362: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   365: ldc -45
    //   367: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: iload 6
    //   372: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   375: ldc -43
    //   377: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload 4
    //   382: getfield 174	com/tencent/mobileqq/data/ActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   385: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: invokestatic 223	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   397: invokestatic 65	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   400: aconst_null
    //   401: ldc -31
    //   403: iconst_1
    //   404: aload 4
    //   406: getfield 200	com/tencent/mobileqq/data/ActivityDAUInfo:displayCount	I
    //   409: i2l
    //   410: aload 4
    //   412: getfield 204	com/tencent/mobileqq/data/ActivityDAUInfo:showTime	J
    //   415: aload 5
    //   417: aconst_null
    //   418: invokevirtual 81	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   421: goto -232 -> 189
    //   424: astore_1
    //   425: ldc 113
    //   427: monitorexit
    //   428: aload_1
    //   429: athrow
    //   430: astore_1
    //   431: aload_1
    //   432: invokevirtual 228	java/lang/Throwable:printStackTrace	()V
    //   435: goto -341 -> 94
    //   438: astore_1
    //   439: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq +103 -> 545
    //   445: ldc -75
    //   447: iconst_2
    //   448: new 183	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   455: ldc -26
    //   457: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload_1
    //   461: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   470: goto +75 -> 545
    //   473: aload_2
    //   474: ldc 113
    //   476: invokevirtual 236	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Z
    //   479: pop
    //   480: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   483: ifeq +36 -> 519
    //   486: aload_1
    //   487: ifnonnull +38 -> 525
    //   490: iconst_0
    //   491: istore 6
    //   493: ldc -75
    //   495: iconst_2
    //   496: new 183	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   503: ldc -18
    //   505: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: iload 6
    //   510: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   513: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   519: ldc 113
    //   521: monitorexit
    //   522: bipush 7
    //   524: ireturn
    //   525: aload_1
    //   526: invokeinterface 144 1 0
    //   531: istore 6
    //   533: goto -40 -> 493
    //   536: iconst_m1
    //   537: istore 6
    //   539: iconst_m1
    //   540: istore 7
    //   542: goto -373 -> 169
    //   545: aconst_null
    //   546: astore_1
    //   547: goto -429 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	550	0	this	ActivityDAUReport
    //   13	170	1	localObject1	Object
    //   424	5	1	localObject2	Object
    //   430	2	1	localThrowable	Throwable
    //   438	88	1	localException	Exception
    //   546	1	1	localObject3	Object
    //   107	367	2	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   133	66	3	localObject4	Object
    //   207	204	4	localActivityDAUInfo	com.tencent.mobileqq.data.ActivityDAUInfo
    //   217	199	5	localHashMap	java.util.HashMap
    //   167	371	6	i	int
    //   161	380	7	j	int
    //   3	83	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   111	118	424	finally
    //   118	134	424	finally
    //   138	153	424	finally
    //   157	169	424	finally
    //   173	189	424	finally
    //   189	394	424	finally
    //   394	421	424	finally
    //   425	428	424	finally
    //   439	470	424	finally
    //   473	480	424	finally
    //   480	486	424	finally
    //   493	519	424	finally
    //   519	522	424	finally
    //   525	533	424	finally
    //   0	94	430	java/lang/Throwable
    //   111	118	438	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\ActivityDAUReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */