import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import java.util.concurrent.atomic.AtomicBoolean;

public class sxr
  implements Runnable
{
  public sxr(MediaApiPlugin paramMediaApiPlugin, String paramString1, String paramString2, AtomicBoolean paramAtomicBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 42	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 43	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: invokestatic 49	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: astore_2
    //   12: invokestatic 49	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   15: aload_0
    //   16: getfield 17	sxr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   19: aconst_null
    //   20: ldc 51
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokestatic 56	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Lorg/apache/http/HttpResponse;
    //   27: astore_3
    //   28: aload_3
    //   29: ifnull +345 -> 374
    //   32: aload_3
    //   33: invokeinterface 62 1 0
    //   38: invokeinterface 68 1 0
    //   43: istore 5
    //   45: iload 5
    //   47: istore 6
    //   49: iload 5
    //   51: sipush 200
    //   54: if_icmpne +323 -> 377
    //   57: aload_3
    //   58: invokestatic 71	com/tencent/biz/common/util/HttpUtil:a	(Lorg/apache/http/HttpResponse;)Ljava/io/ByteArrayOutputStream;
    //   61: invokevirtual 77	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   64: astore_3
    //   65: aload_1
    //   66: ldc 79
    //   68: iload 5
    //   70: invokevirtual 83	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   73: pop
    //   74: aload_0
    //   75: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   78: aload_3
    //   79: invokestatic 88	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;[B)Ljava/lang/String;
    //   82: astore_3
    //   83: aload_1
    //   84: ldc 90
    //   86: iconst_0
    //   87: invokevirtual 83	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   90: pop
    //   91: aload_1
    //   92: ldc 92
    //   94: aload_2
    //   95: ldc 93
    //   97: invokevirtual 99	android/content/Context:getString	(I)Ljava/lang/String;
    //   100: invokevirtual 102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   103: pop
    //   104: aload_1
    //   105: ldc 104
    //   107: aload_3
    //   108: invokevirtual 102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   111: pop
    //   112: aload_0
    //   113: getfield 19	sxr:b	Ljava/lang/String;
    //   116: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   119: ifne +129 -> 248
    //   122: aload_0
    //   123: getfield 21	sxr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   126: iconst_0
    //   127: iconst_1
    //   128: invokevirtual 116	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   131: ifeq +117 -> 248
    //   134: aload_0
    //   135: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   138: aload_0
    //   139: getfield 19	sxr:b	Ljava/lang/String;
    //   142: iconst_1
    //   143: anewarray 118	java/lang/String
    //   146: dup
    //   147: iconst_0
    //   148: aload_1
    //   149: invokevirtual 122	org/json/JSONObject:toString	()Ljava/lang/String;
    //   152: aastore
    //   153: invokevirtual 126	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   156: aload_0
    //   157: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   160: getfield 129	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   163: ifnull +26 -> 189
    //   166: aload_0
    //   167: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   170: getfield 129	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   173: invokevirtual 135	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   176: ifeq +13 -> 189
    //   179: aload_0
    //   180: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   183: getfield 129	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   186: invokevirtual 138	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   189: return
    //   190: astore_3
    //   191: aload_1
    //   192: ldc 90
    //   194: iconst_1
    //   195: invokevirtual 83	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   198: pop
    //   199: aload_1
    //   200: ldc 92
    //   202: aload_2
    //   203: ldc -117
    //   205: invokevirtual 99	android/content/Context:getString	(I)Ljava/lang/String;
    //   208: invokevirtual 102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   211: pop
    //   212: goto -100 -> 112
    //   215: astore_3
    //   216: goto -104 -> 112
    //   219: astore_3
    //   220: aload_1
    //   221: ldc 90
    //   223: iconst_2
    //   224: invokevirtual 83	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   227: pop
    //   228: aload_1
    //   229: ldc 92
    //   231: aload_2
    //   232: ldc -116
    //   234: invokevirtual 99	android/content/Context:getString	(I)Ljava/lang/String;
    //   237: invokevirtual 102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   240: pop
    //   241: goto -129 -> 112
    //   244: astore_3
    //   245: goto -133 -> 112
    //   248: aload_0
    //   249: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   252: ldc -114
    //   254: iconst_0
    //   255: aload_1
    //   256: invokevirtual 122	org/json/JSONObject:toString	()Ljava/lang/String;
    //   259: invokestatic 145	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;ILjava/lang/String;)V
    //   262: goto -106 -> 156
    //   265: astore_3
    //   266: aload_1
    //   267: ldc 90
    //   269: iconst_m1
    //   270: invokevirtual 83	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   273: pop
    //   274: aload_1
    //   275: ldc 92
    //   277: aload_2
    //   278: ldc -110
    //   280: invokevirtual 99	android/content/Context:getString	(I)Ljava/lang/String;
    //   283: invokevirtual 102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   286: pop
    //   287: aload_1
    //   288: ldc 79
    //   290: iload 5
    //   292: invokevirtual 83	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   295: pop
    //   296: aload_0
    //   297: getfield 19	sxr:b	Ljava/lang/String;
    //   300: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   303: ifne +194 -> 497
    //   306: aload_0
    //   307: getfield 21	sxr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   310: iconst_0
    //   311: iconst_1
    //   312: invokevirtual 116	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   315: ifeq +182 -> 497
    //   318: aload_0
    //   319: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   322: aload_0
    //   323: getfield 19	sxr:b	Ljava/lang/String;
    //   326: iconst_1
    //   327: anewarray 118	java/lang/String
    //   330: dup
    //   331: iconst_0
    //   332: aload_1
    //   333: invokevirtual 122	org/json/JSONObject:toString	()Ljava/lang/String;
    //   336: aastore
    //   337: invokevirtual 126	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   340: aload_0
    //   341: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   344: getfield 129	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   347: ifnull -158 -> 189
    //   350: aload_0
    //   351: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   354: getfield 129	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   357: invokevirtual 135	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   360: ifeq -171 -> 189
    //   363: aload_0
    //   364: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   367: getfield 129	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   370: invokevirtual 138	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   373: return
    //   374: iconst_m1
    //   375: istore 6
    //   377: iload 6
    //   379: istore 7
    //   381: aload_0
    //   382: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   385: getfield 129	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   388: ifnull +34 -> 422
    //   391: iload 6
    //   393: istore 7
    //   395: aload_0
    //   396: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   399: getfield 129	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   402: invokevirtual 135	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   405: ifeq +17 -> 422
    //   408: aload_0
    //   409: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   412: getfield 129	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   415: invokevirtual 138	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   418: iload 6
    //   420: istore 7
    //   422: aload_1
    //   423: ldc 90
    //   425: iconst_3
    //   426: invokevirtual 83	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   429: pop
    //   430: aload_1
    //   431: ldc 92
    //   433: aload_2
    //   434: ldc -109
    //   436: invokevirtual 99	android/content/Context:getString	(I)Ljava/lang/String;
    //   439: invokevirtual 102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   442: pop
    //   443: aload_1
    //   444: ldc 79
    //   446: iload 7
    //   448: invokevirtual 83	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   451: pop
    //   452: aload_0
    //   453: getfield 19	sxr:b	Ljava/lang/String;
    //   456: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   459: ifne +143 -> 602
    //   462: aload_0
    //   463: getfield 21	sxr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   466: iconst_0
    //   467: iconst_1
    //   468: invokevirtual 116	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   471: ifeq +131 -> 602
    //   474: aload_0
    //   475: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   478: aload_0
    //   479: getfield 19	sxr:b	Ljava/lang/String;
    //   482: iconst_1
    //   483: anewarray 118	java/lang/String
    //   486: dup
    //   487: iconst_0
    //   488: aload_1
    //   489: invokevirtual 122	org/json/JSONObject:toString	()Ljava/lang/String;
    //   492: aastore
    //   493: invokevirtual 126	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   496: return
    //   497: aload_0
    //   498: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   501: ldc -114
    //   503: iconst_0
    //   504: aload_1
    //   505: invokevirtual 122	org/json/JSONObject:toString	()Ljava/lang/String;
    //   508: invokestatic 149	com/tencent/mobileqq/jsp/MediaApiPlugin:b	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;ILjava/lang/String;)V
    //   511: goto -171 -> 340
    //   514: astore_1
    //   515: aload_0
    //   516: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   519: getfield 129	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   522: ifnull +26 -> 548
    //   525: aload_0
    //   526: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   529: getfield 129	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   532: invokevirtual 135	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   535: ifeq +13 -> 548
    //   538: aload_0
    //   539: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   542: getfield 129	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   545: invokevirtual 138	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   548: aload_1
    //   549: athrow
    //   550: astore_3
    //   551: iconst_m1
    //   552: istore 5
    //   554: iload 5
    //   556: istore 7
    //   558: aload_0
    //   559: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   562: getfield 129	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   565: ifnull -143 -> 422
    //   568: iload 5
    //   570: istore 7
    //   572: aload_0
    //   573: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   576: getfield 129	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   579: invokevirtual 135	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   582: ifeq -160 -> 422
    //   585: aload_0
    //   586: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   589: getfield 129	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   592: invokevirtual 138	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   595: iload 5
    //   597: istore 7
    //   599: goto -177 -> 422
    //   602: aload_0
    //   603: getfield 15	sxr:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   606: ldc -114
    //   608: iconst_0
    //   609: aload_1
    //   610: invokevirtual 122	org/json/JSONObject:toString	()Ljava/lang/String;
    //   613: invokestatic 152	com/tencent/mobileqq/jsp/MediaApiPlugin:c	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;ILjava/lang/String;)V
    //   616: return
    //   617: astore_2
    //   618: goto -166 -> 452
    //   621: astore_3
    //   622: goto -68 -> 554
    //   625: astore_2
    //   626: goto -330 -> 296
    //   629: astore_3
    //   630: iconst_m1
    //   631: istore 5
    //   633: goto -367 -> 266
    //   636: astore_3
    //   637: goto -525 -> 112
    //   640: astore 4
    //   642: goto -568 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	645	0	this	sxr
    //   7	498	1	localJSONObject	org.json.JSONObject
    //   514	96	1	localObject1	Object
    //   11	423	2	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    //   617	1	2	localJSONException1	org.json.JSONException
    //   625	1	2	localJSONException2	org.json.JSONException
    //   27	81	3	localObject2	Object
    //   190	1	3	localIOException1	java.io.IOException
    //   215	1	3	localJSONException3	org.json.JSONException
    //   219	1	3	localIllegalArgumentException	IllegalArgumentException
    //   244	1	3	localJSONException4	org.json.JSONException
    //   265	1	3	localOutOfMemoryError1	OutOfMemoryError
    //   550	1	3	localIOException2	java.io.IOException
    //   621	1	3	localIOException3	java.io.IOException
    //   629	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   636	1	3	localJSONException5	org.json.JSONException
    //   640	1	4	localJSONException6	org.json.JSONException
    //   43	589	5	i	int
    //   47	372	6	j	int
    //   379	219	7	k	int
    // Exception table:
    //   from	to	target	type
    //   74	83	190	java/io/IOException
    //   83	112	190	java/io/IOException
    //   191	212	215	org/json/JSONException
    //   74	83	219	java/lang/IllegalArgumentException
    //   83	112	219	java/lang/IllegalArgumentException
    //   220	241	244	org/json/JSONException
    //   57	65	265	java/lang/OutOfMemoryError
    //   65	74	265	java/lang/OutOfMemoryError
    //   74	83	265	java/lang/OutOfMemoryError
    //   83	112	265	java/lang/OutOfMemoryError
    //   112	156	265	java/lang/OutOfMemoryError
    //   191	212	265	java/lang/OutOfMemoryError
    //   220	241	265	java/lang/OutOfMemoryError
    //   248	262	265	java/lang/OutOfMemoryError
    //   12	28	514	finally
    //   32	45	514	finally
    //   57	65	514	finally
    //   65	74	514	finally
    //   74	83	514	finally
    //   83	112	514	finally
    //   112	156	514	finally
    //   191	212	514	finally
    //   220	241	514	finally
    //   248	262	514	finally
    //   266	296	514	finally
    //   296	340	514	finally
    //   497	511	514	finally
    //   12	28	550	java/io/IOException
    //   32	45	550	java/io/IOException
    //   422	452	617	org/json/JSONException
    //   57	65	621	java/io/IOException
    //   65	74	621	java/io/IOException
    //   112	156	621	java/io/IOException
    //   191	212	621	java/io/IOException
    //   220	241	621	java/io/IOException
    //   248	262	621	java/io/IOException
    //   266	296	625	org/json/JSONException
    //   12	28	629	java/lang/OutOfMemoryError
    //   32	45	629	java/lang/OutOfMemoryError
    //   83	112	636	org/json/JSONException
    //   65	74	640	org/json/JSONException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sxr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */