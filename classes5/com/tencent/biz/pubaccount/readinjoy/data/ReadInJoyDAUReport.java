package com.tencent.biz.pubaccount.readinjoy.data;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ReadInJoyDAUReport
  extends AsyncStep
{
  public ReadInJoyDAUReport()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  protected int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   4: getfield 27	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/common/app/AppInterface;
    //   7: invokevirtual 32	com/tencent/common/app/AppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   10: invokevirtual 38	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore_2
    //   14: ldc 40
    //   16: monitorenter
    //   17: aload_2
    //   18: ldc 40
    //   20: invokevirtual 45	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   23: astore_1
    //   24: aload_0
    //   25: getfield 22	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   28: getfield 27	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/common/app/AppInterface;
    //   31: bipush 50
    //   33: invokevirtual 49	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   36: checkcast 51	com/tencent/mobileqq/app/FriendsManager
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull +593 -> 634
    //   44: aload_3
    //   45: aload_0
    //   46: getfield 22	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   49: getfield 27	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/common/app/AppInterface;
    //   52: invokevirtual 54	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   55: invokevirtual 58	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull +574 -> 634
    //   63: aload_3
    //   64: getfield 64	com/tencent/mobileqq/data/Card:shGender	S
    //   67: istore 6
    //   69: aload_3
    //   70: getfield 68	com/tencent/mobileqq/data/Card:age	B
    //   73: istore 5
    //   75: aload_1
    //   76: ifnull +545 -> 621
    //   79: aload_1
    //   80: invokeinterface 73 1 0
    //   85: ifle +536 -> 621
    //   88: aload_1
    //   89: invokeinterface 77 1 0
    //   94: astore_1
    //   95: aload_1
    //   96: invokeinterface 83 1 0
    //   101: ifeq +520 -> 621
    //   104: aload_1
    //   105: invokeinterface 87 1 0
    //   110: checkcast 40	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo
    //   113: astore_3
    //   114: new 89	java/util/HashMap
    //   117: dup
    //   118: iconst_2
    //   119: invokespecial 92	java/util/HashMap:<init>	(I)V
    //   122: astore 4
    //   124: aload 4
    //   126: ldc 94
    //   128: aload_3
    //   129: getfield 97	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   132: invokevirtual 101	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   135: pop
    //   136: aload 4
    //   138: ldc 103
    //   140: aload_3
    //   141: getfield 106	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:count	I
    //   144: invokestatic 112	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   147: invokevirtual 101	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: pop
    //   151: aload 4
    //   153: ldc 114
    //   155: iload 6
    //   157: invokestatic 112	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   160: invokevirtual 101	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   163: pop
    //   164: aload 4
    //   166: ldc 115
    //   168: iload 5
    //   170: invokestatic 112	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   173: invokevirtual 101	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: pop
    //   177: aload 4
    //   179: ldc 117
    //   181: aload_3
    //   182: getfield 119	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   185: invokevirtual 101	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: pop
    //   189: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq +90 -> 282
    //   195: ldc 126
    //   197: iconst_2
    //   198: new 128	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   205: ldc -125
    //   207: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_0
    //   211: getfield 22	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   214: getfield 27	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/common/app/AppInterface;
    //   217: invokevirtual 54	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   220: invokestatic 138	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   223: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc -116
    //   228: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_3
    //   232: getfield 143	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   235: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc -111
    //   240: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc -109
    //   245: iconst_1
    //   246: anewarray 149	java/lang/Object
    //   249: dup
    //   250: iconst_0
    //   251: invokestatic 154	com/tencent/common/config/AppSetting:d	()Ljava/lang/String;
    //   254: aastore
    //   255: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   258: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc -96
    //   263: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_3
    //   267: getfield 164	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   270: invokestatic 170	java/lang/Long:toString	(J)Ljava/lang/String;
    //   273: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aconst_null
    //   283: ldc -79
    //   285: ldc -77
    //   287: ldc -77
    //   289: ldc -75
    //   291: ldc -75
    //   293: iconst_0
    //   294: iconst_0
    //   295: aload_3
    //   296: getfield 164	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   299: invokestatic 170	java/lang/Long:toString	(J)Ljava/lang/String;
    //   302: aload_3
    //   303: getfield 143	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   306: ldc -109
    //   308: iconst_1
    //   309: anewarray 149	java/lang/Object
    //   312: dup
    //   313: iconst_0
    //   314: invokestatic 154	com/tencent/common/config/AppSetting:d	()Ljava/lang/String;
    //   317: aastore
    //   318: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   321: aconst_null
    //   322: invokestatic 186	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   325: aload_0
    //   326: aload_3
    //   327: getfield 119	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   330: invokevirtual 189	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	(Ljava/lang/String;)Ljava/lang/String;
    //   333: astore 4
    //   335: aload_3
    //   336: getfield 97	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   339: invokestatic 195	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   342: ifne +153 -> 495
    //   345: aload_3
    //   346: getfield 97	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   349: ldc -59
    //   351: invokevirtual 201	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   354: ifeq +141 -> 495
    //   357: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   360: ifeq +90 -> 450
    //   363: ldc 126
    //   365: iconst_2
    //   366: new 128	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   373: ldc -53
    //   375: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload_0
    //   379: getfield 22	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   382: getfield 27	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/common/app/AppInterface;
    //   385: invokevirtual 54	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   388: invokestatic 138	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   391: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: ldc -116
    //   396: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_3
    //   400: getfield 143	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   403: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: ldc -111
    //   408: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: ldc -109
    //   413: iconst_1
    //   414: anewarray 149	java/lang/Object
    //   417: dup
    //   418: iconst_0
    //   419: invokestatic 154	com/tencent/common/config/AppSetting:d	()Ljava/lang/String;
    //   422: aastore
    //   423: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   426: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: ldc -96
    //   431: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_3
    //   435: getfield 164	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   438: invokestatic 170	java/lang/Long:toString	(J)Ljava/lang/String;
    //   441: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: aconst_null
    //   451: ldc -79
    //   453: ldc -77
    //   455: ldc -77
    //   457: ldc -51
    //   459: ldc -51
    //   461: iconst_0
    //   462: iconst_0
    //   463: aload_3
    //   464: getfield 164	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   467: invokestatic 170	java/lang/Long:toString	(J)Ljava/lang/String;
    //   470: aload_3
    //   471: getfield 143	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   474: ldc -109
    //   476: iconst_1
    //   477: anewarray 149	java/lang/Object
    //   480: dup
    //   481: iconst_0
    //   482: invokestatic 154	com/tencent/common/config/AppSetting:d	()Ljava/lang/String;
    //   485: aastore
    //   486: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   489: invokestatic 210	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:c	()Ljava/lang/String;
    //   492: invokestatic 186	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   495: aload_3
    //   496: getfield 97	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   499: invokestatic 195	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   502: ifne -407 -> 95
    //   505: aload 4
    //   507: ifnull -412 -> 95
    //   510: aload 4
    //   512: ldc -59
    //   514: invokevirtual 201	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   517: ifeq -422 -> 95
    //   520: aload_3
    //   521: getfield 97	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   524: ldc -44
    //   526: invokevirtual 215	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   529: ifeq -434 -> 95
    //   532: aconst_null
    //   533: ldc -79
    //   535: ldc -77
    //   537: ldc -77
    //   539: ldc -51
    //   541: ldc -51
    //   543: iconst_0
    //   544: iconst_0
    //   545: aload_3
    //   546: getfield 164	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   549: invokestatic 170	java/lang/Long:toString	(J)Ljava/lang/String;
    //   552: aload_3
    //   553: getfield 143	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   556: ldc -109
    //   558: iconst_1
    //   559: anewarray 149	java/lang/Object
    //   562: dup
    //   563: iconst_0
    //   564: invokestatic 154	com/tencent/common/config/AppSetting:d	()Ljava/lang/String;
    //   567: aastore
    //   568: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   571: invokestatic 210	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:c	()Ljava/lang/String;
    //   574: invokestatic 186	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   577: goto -482 -> 95
    //   580: astore_1
    //   581: ldc 40
    //   583: monitorexit
    //   584: aload_1
    //   585: athrow
    //   586: astore_1
    //   587: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   590: ifeq +53 -> 643
    //   593: ldc 126
    //   595: iconst_2
    //   596: new 128	java/lang/StringBuilder
    //   599: dup
    //   600: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   603: ldc -39
    //   605: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: aload_1
    //   609: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: goto +25 -> 643
    //   621: aload_2
    //   622: ldc 40
    //   624: invokevirtual 223	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Z
    //   627: pop
    //   628: ldc 40
    //   630: monitorexit
    //   631: bipush 7
    //   633: ireturn
    //   634: iconst_m1
    //   635: istore 5
    //   637: iconst_m1
    //   638: istore 6
    //   640: goto -565 -> 75
    //   643: aconst_null
    //   644: astore_1
    //   645: goto -621 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	648	0	this	ReadInJoyDAUReport
    //   23	82	1	localObject1	Object
    //   580	5	1	localObject2	Object
    //   586	23	1	localException	Exception
    //   644	1	1	localObject3	Object
    //   13	609	2	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   39	514	3	localObject4	Object
    //   122	389	4	localObject5	Object
    //   73	563	5	i	int
    //   67	572	6	j	int
    // Exception table:
    //   from	to	target	type
    //   17	24	580	finally
    //   24	40	580	finally
    //   44	59	580	finally
    //   63	75	580	finally
    //   79	95	580	finally
    //   95	282	580	finally
    //   282	450	580	finally
    //   450	495	580	finally
    //   495	505	580	finally
    //   510	577	580	finally
    //   581	584	580	finally
    //   587	618	580	finally
    //   621	631	580	finally
    //   17	24	586	java/lang/Exception
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return null;
        paramString = paramString.split("\\|");
      } while (paramString == null);
      paramString = paramString[(paramString.length - 1)].split(".");
    } while ((paramString == null) || (paramString.length <= 1));
    return paramString[1];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\data\ReadInJoyDAUReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */