import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hec
  implements Runnable
{
  public hec(AuthorizeConfig paramAuthorizeConfig, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	hec:jdField_a_of_type_Boolean	Z
    //   4: ifeq +9 -> 13
    //   7: ldc2_w 32
    //   10: invokestatic 39	java/lang/Thread:sleep	(J)V
    //   13: aload_0
    //   14: getfield 13	hec:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   17: getfield 44	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   20: ldc 46
    //   22: aconst_null
    //   23: invokeinterface 52 3 0
    //   28: astore 4
    //   30: invokestatic 57	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   33: invokevirtual 60	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +188 -> 226
    //   41: aload_0
    //   42: getfield 13	hec:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   45: getfield 44	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   48: ldc 62
    //   50: aconst_null
    //   51: invokeinterface 52 3 0
    //   56: astore_1
    //   57: new 64	com/tencent/mobileqq/mp/mobileqq_mp$WebviewWhiteListRequset
    //   60: dup
    //   61: invokespecial 65	com/tencent/mobileqq/mp/mobileqq_mp$WebviewWhiteListRequset:<init>	()V
    //   64: astore_3
    //   65: aload_1
    //   66: invokestatic 71	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   69: ifne +125 -> 194
    //   72: ldc 73
    //   74: aload 4
    //   76: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifeq +115 -> 194
    //   82: aload_3
    //   83: getfield 83	com/tencent/mobileqq/mp/mobileqq_mp$WebviewWhiteListRequset:version	Lcom/tencent/mobileqq/pb/PBStringField;
    //   86: aload_1
    //   87: invokevirtual 89	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   90: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +28 -> 121
    //   96: ldc 97
    //   98: iconst_2
    //   99: new 99	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   106: ldc 102
    //   108: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_1
    //   112: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: new 116	mqq/app/NewIntent
    //   124: dup
    //   125: aload_0
    //   126: getfield 13	hec:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   129: getfield 119	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   132: ldc 121
    //   134: invokespecial 124	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   137: astore_1
    //   138: aload_1
    //   139: iconst_1
    //   140: invokevirtual 128	mqq/app/NewIntent:setWithouLogin	(Z)V
    //   143: aload_1
    //   144: ldc -126
    //   146: ldc -124
    //   148: invokevirtual 136	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   151: pop
    //   152: aload_1
    //   153: ldc -118
    //   155: aload_3
    //   156: invokevirtual 142	com/tencent/mobileqq/mp/mobileqq_mp$WebviewWhiteListRequset:toByteArray	()[B
    //   159: invokevirtual 145	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   162: pop
    //   163: aload_1
    //   164: new 147	hed
    //   167: dup
    //   168: aload_0
    //   169: invokespecial 150	hed:<init>	(Lhec;)V
    //   172: invokevirtual 154	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   175: aload_2
    //   176: aload_1
    //   177: invokevirtual 160	mqq/app/AppRuntime:startServlet	(Lmqq/app/NewIntent;)V
    //   180: return
    //   181: astore_1
    //   182: aload_0
    //   183: getfield 13	hec:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   186: getfield 163	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   189: iconst_0
    //   190: invokevirtual 168	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   193: return
    //   194: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq -76 -> 121
    //   200: aload_1
    //   201: invokestatic 71	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   204: ifeq +16 -> 220
    //   207: ldc -86
    //   209: astore_1
    //   210: ldc 97
    //   212: iconst_2
    //   213: aload_1
    //   214: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: goto -96 -> 121
    //   220: ldc -84
    //   222: astore_1
    //   223: goto -13 -> 210
    //   226: aload_0
    //   227: getfield 13	hec:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   230: getfield 44	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   233: ldc -82
    //   235: aconst_null
    //   236: invokeinterface 52 3 0
    //   241: astore_3
    //   242: aconst_null
    //   243: astore_2
    //   244: aload_2
    //   245: astore_1
    //   246: aload_3
    //   247: ifnull +39 -> 286
    //   250: aload_2
    //   251: astore_1
    //   252: aload_3
    //   253: invokevirtual 178	java/lang/String:length	()I
    //   256: ifle +30 -> 286
    //   259: aload_2
    //   260: astore_1
    //   261: ldc 73
    //   263: aload 4
    //   265: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   268: ifeq +18 -> 286
    //   271: new 180	android/os/Bundle
    //   274: dup
    //   275: invokespecial 181	android/os/Bundle:<init>	()V
    //   278: astore_1
    //   279: aload_1
    //   280: ldc -73
    //   282: aload_3
    //   283: invokevirtual 187	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: ldc -67
    //   288: invokestatic 195	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   291: invokevirtual 198	android/net/Uri:getHost	()Ljava/lang/String;
    //   294: astore_2
    //   295: ldc -56
    //   297: ldc -67
    //   299: invokestatic 205	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   302: astore_3
    //   303: aload_0
    //   304: getfield 13	hec:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   307: getfield 119	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   310: aload_3
    //   311: aload_2
    //   312: ldc -49
    //   314: aconst_null
    //   315: aload_1
    //   316: invokestatic 212	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Lorg/apache/http/HttpResponse;
    //   319: astore_2
    //   320: aload_2
    //   321: ifnull +156 -> 477
    //   324: aload_2
    //   325: invokeinterface 218 1 0
    //   330: invokeinterface 223 1 0
    //   335: istore 5
    //   337: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   340: ifeq +32 -> 372
    //   343: ldc 97
    //   345: iconst_2
    //   346: new 99	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   353: ldc -31
    //   355: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: iload 5
    //   360: invokestatic 229	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   363: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: iload 5
    //   374: sipush 200
    //   377: if_icmpne +148 -> 525
    //   380: aload_2
    //   381: ldc -25
    //   383: invokeinterface 235 2 0
    //   388: astore_1
    //   389: aload_1
    //   390: ifnonnull +125 -> 515
    //   393: aconst_null
    //   394: astore_1
    //   395: aload_2
    //   396: invokestatic 238	com/tencent/biz/common/util/HttpUtil:a	(Lorg/apache/http/HttpResponse;)Ljava/lang/String;
    //   399: astore_2
    //   400: aload_0
    //   401: getfield 13	hec:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   404: new 240	org/json/JSONObject
    //   407: dup
    //   408: aload_2
    //   409: invokespecial 242	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   412: aload_1
    //   413: ldc -82
    //   415: invokevirtual 245	com/tencent/biz/AuthorizeConfig:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V
    //   418: aconst_null
    //   419: ldc -9
    //   421: ldc -7
    //   423: ldc -5
    //   425: ldc -3
    //   427: ldc -1
    //   429: iconst_1
    //   430: iconst_1
    //   431: iconst_0
    //   432: ldc -5
    //   434: ldc -5
    //   436: ldc -5
    //   438: ldc -5
    //   440: invokestatic 261	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   443: return
    //   444: astore_1
    //   445: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   448: ifeq +29 -> 477
    //   451: ldc 97
    //   453: iconst_2
    //   454: new 99	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   461: ldc_w 263
    //   464: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload_1
    //   468: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: aload_0
    //   478: getfield 13	hec:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   481: getfield 163	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   484: iconst_0
    //   485: invokevirtual 168	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   488: aconst_null
    //   489: ldc -9
    //   491: ldc -7
    //   493: ldc -5
    //   495: ldc -3
    //   497: ldc_w 268
    //   500: iconst_1
    //   501: iconst_1
    //   502: iconst_0
    //   503: ldc -5
    //   505: ldc -5
    //   507: ldc -5
    //   509: ldc -5
    //   511: invokestatic 261	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   514: return
    //   515: aload_1
    //   516: invokeinterface 273 1 0
    //   521: astore_1
    //   522: goto -127 -> 395
    //   525: iload 5
    //   527: sipush 304
    //   530: if_icmpne -53 -> 477
    //   533: aload_0
    //   534: getfield 13	hec:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   537: getfield 163	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   540: iconst_2
    //   541: invokevirtual 168	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   544: aload_0
    //   545: getfield 13	hec:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   548: getfield 44	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   551: invokeinterface 277 1 0
    //   556: ldc_w 279
    //   559: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   562: invokeinterface 291 4 0
    //   567: invokeinterface 294 1 0
    //   572: pop
    //   573: aconst_null
    //   574: ldc -9
    //   576: ldc -7
    //   578: ldc -5
    //   580: ldc -3
    //   582: ldc_w 296
    //   585: iconst_1
    //   586: iconst_1
    //   587: iconst_0
    //   588: ldc -5
    //   590: ldc -5
    //   592: ldc -5
    //   594: ldc -5
    //   596: invokestatic 261	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   599: return
    //   600: astore_3
    //   601: goto -438 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	604	0	this	hec
    //   56	121	1	localObject1	Object
    //   181	20	1	localInterruptedException	InterruptedException
    //   209	204	1	localObject2	Object
    //   444	72	1	localException	Exception
    //   521	1	1	str1	String
    //   36	373	2	localObject3	Object
    //   64	247	3	localObject4	Object
    //   600	1	3	localNullPointerException	NullPointerException
    //   28	236	4	str2	String
    //   335	196	5	i	int
    // Exception table:
    //   from	to	target	type
    //   7	13	181	java/lang/InterruptedException
    //   303	320	444	java/lang/Exception
    //   324	372	444	java/lang/Exception
    //   380	389	444	java/lang/Exception
    //   395	443	444	java/lang/Exception
    //   515	522	444	java/lang/Exception
    //   533	599	444	java/lang/Exception
    //   152	163	600	java/lang/NullPointerException
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */