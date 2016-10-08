import android.content.SharedPreferences;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.PortalManager;

public class tuh
  implements Runnable
{
  public tuh(PortalManager paramPortalManager, String paramString, SharedPreferences paramSharedPreferences)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 5
    //   3: aload_0
    //   4: getfield 14	tuh:jdField_a_of_type_ComTencentMobileqqPortalPortalManager	Lcom/tencent/mobileqq/portal/PortalManager;
    //   7: invokestatic 36	com/tencent/mobileqq/portal/PortalManager:a	(Lcom/tencent/mobileqq/portal/PortalManager;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10: iconst_2
    //   11: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14: checkcast 44	mqq/manager/TicketManager
    //   17: aload_0
    //   18: getfield 16	tuh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokeinterface 48 2 0
    //   26: astore_3
    //   27: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +51 -> 81
    //   33: aload_3
    //   34: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifne +44 -> 81
    //   40: ldc 62
    //   42: iconst_2
    //   43: new 64	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   50: ldc 67
    //   52: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_3
    //   56: invokevirtual 77	java/lang/String:length	()I
    //   59: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc 82
    //   64: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_3
    //   68: iconst_3
    //   69: invokevirtual 86	java/lang/String:substring	(I)Ljava/lang/String;
    //   72: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aconst_null
    //   82: astore_1
    //   83: aconst_null
    //   84: astore 4
    //   86: iload 5
    //   88: istore 6
    //   90: new 96	java/net/URL
    //   93: dup
    //   94: ldc 98
    //   96: invokespecial 101	java/net/URL:<init>	(Ljava/lang/String;)V
    //   99: invokevirtual 105	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   102: checkcast 107	java/net/HttpURLConnection
    //   105: astore_2
    //   106: iload 5
    //   108: istore 6
    //   110: iload 5
    //   112: istore 7
    //   114: aload_2
    //   115: sipush 10000
    //   118: invokevirtual 111	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   121: iload 5
    //   123: istore 6
    //   125: iload 5
    //   127: istore 7
    //   129: aload_2
    //   130: ldc 113
    //   132: new 64	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   139: ldc 115
    //   141: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_0
    //   145: getfield 16	tuh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   148: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc 117
    //   153: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_3
    //   157: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokevirtual 121	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: iload 5
    //   168: istore 6
    //   170: iload 5
    //   172: istore 7
    //   174: aload_2
    //   175: invokevirtual 124	java/net/HttpURLConnection:getResponseCode	()I
    //   178: istore 5
    //   180: iload 5
    //   182: sipush 200
    //   185: if_icmpne +329 -> 514
    //   188: iload 5
    //   190: istore 6
    //   192: iload 5
    //   194: istore 7
    //   196: new 126	java/io/BufferedReader
    //   199: dup
    //   200: new 128	java/io/InputStreamReader
    //   203: dup
    //   204: aload_2
    //   205: invokevirtual 132	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   208: invokespecial 135	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   211: invokespecial 138	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   214: astore_1
    //   215: iload 5
    //   217: istore 6
    //   219: iload 5
    //   221: istore 7
    //   223: new 64	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   230: astore_3
    //   231: iload 5
    //   233: istore 6
    //   235: iload 5
    //   237: istore 7
    //   239: aload_1
    //   240: invokevirtual 141	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   243: astore 4
    //   245: aload 4
    //   247: ifnull +94 -> 341
    //   250: iload 5
    //   252: istore 6
    //   254: iload 5
    //   256: istore 7
    //   258: aload_3
    //   259: aload 4
    //   261: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: goto -34 -> 231
    //   268: astore_3
    //   269: iload 6
    //   271: istore 5
    //   273: aload_2
    //   274: astore_1
    //   275: iload 5
    //   277: istore 6
    //   279: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +18 -> 300
    //   285: aload_2
    //   286: astore_1
    //   287: iload 5
    //   289: istore 6
    //   291: ldc 62
    //   293: iconst_2
    //   294: ldc -113
    //   296: aload_3
    //   297: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   300: aload_2
    //   301: ifnull +7 -> 308
    //   304: aload_2
    //   305: invokevirtual 149	java/net/HttpURLConnection:disconnect	()V
    //   308: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq +29 -> 340
    //   314: ldc 62
    //   316: iconst_2
    //   317: new 64	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   324: ldc -105
    //   326: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: iload 5
    //   331: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   334: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: return
    //   341: iload 5
    //   343: istore 6
    //   345: iload 5
    //   347: istore 7
    //   349: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   352: ifeq +39 -> 391
    //   355: iload 5
    //   357: istore 6
    //   359: iload 5
    //   361: istore 7
    //   363: ldc 62
    //   365: iconst_2
    //   366: new 64	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   373: ldc -103
    //   375: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload_3
    //   379: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: iload 5
    //   393: istore 6
    //   395: iload 5
    //   397: istore 7
    //   399: new 155	org/json/JSONObject
    //   402: dup
    //   403: aload_3
    //   404: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokespecial 156	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   410: astore_1
    //   411: iload 5
    //   413: istore 6
    //   415: iload 5
    //   417: istore 7
    //   419: aload_1
    //   420: ldc -98
    //   422: iconst_m1
    //   423: invokevirtual 162	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   426: istore 8
    //   428: iload 5
    //   430: istore 6
    //   432: iload 5
    //   434: istore 7
    //   436: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   439: ifeq +37 -> 476
    //   442: iload 5
    //   444: istore 6
    //   446: iload 5
    //   448: istore 7
    //   450: ldc 62
    //   452: iconst_2
    //   453: new 64	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   460: ldc -92
    //   462: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: iload 8
    //   467: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   470: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: iload 8
    //   478: ifne +77 -> 555
    //   481: iload 5
    //   483: istore 6
    //   485: iload 5
    //   487: istore 7
    //   489: aload_0
    //   490: getfield 18	tuh:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   493: invokeinterface 170 1 0
    //   498: aload_0
    //   499: getfield 16	tuh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   502: iconst_1
    //   503: invokeinterface 176 3 0
    //   508: invokeinterface 179 1 0
    //   513: pop
    //   514: aload_2
    //   515: ifnull +7 -> 522
    //   518: aload_2
    //   519: invokevirtual 149	java/net/HttpURLConnection:disconnect	()V
    //   522: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   525: ifeq -185 -> 340
    //   528: ldc 62
    //   530: iconst_2
    //   531: new 64	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   538: ldc -105
    //   540: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: iload 5
    //   545: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   548: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   554: return
    //   555: iload 5
    //   557: istore 6
    //   559: iload 5
    //   561: istore 7
    //   563: aload_1
    //   564: ldc -75
    //   566: ldc -73
    //   568: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   571: astore_1
    //   572: iload 5
    //   574: istore 6
    //   576: iload 5
    //   578: istore 7
    //   580: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   583: ifeq -69 -> 514
    //   586: iload 5
    //   588: istore 6
    //   590: iload 5
    //   592: istore 7
    //   594: ldc 62
    //   596: iconst_2
    //   597: new 64	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   604: ldc -67
    //   606: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: aload_1
    //   610: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   619: goto -105 -> 514
    //   622: astore_1
    //   623: iload 7
    //   625: istore 6
    //   627: aload_2
    //   628: astore_3
    //   629: aload_1
    //   630: astore_2
    //   631: aload_3
    //   632: ifnull +7 -> 639
    //   635: aload_3
    //   636: invokevirtual 149	java/net/HttpURLConnection:disconnect	()V
    //   639: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   642: ifeq +29 -> 671
    //   645: ldc 62
    //   647: iconst_2
    //   648: new 64	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   655: ldc -105
    //   657: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: iload 6
    //   662: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   665: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   671: aload_2
    //   672: athrow
    //   673: astore_2
    //   674: aload_1
    //   675: astore_3
    //   676: goto -45 -> 631
    //   679: astore_3
    //   680: aload 4
    //   682: astore_2
    //   683: goto -410 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	686	0	this	tuh
    //   82	528	1	localObject1	Object
    //   622	53	1	localObject2	Object
    //   105	567	2	localObject3	Object
    //   673	1	2	localObject4	Object
    //   682	1	2	str1	String
    //   26	233	3	localObject5	Object
    //   268	136	3	localException1	Exception
    //   628	48	3	localObject6	Object
    //   679	1	3	localException2	Exception
    //   84	597	4	str2	String
    //   1	590	5	i	int
    //   88	573	6	j	int
    //   112	512	7	k	int
    //   426	51	8	m	int
    // Exception table:
    //   from	to	target	type
    //   114	121	268	java/lang/Exception
    //   129	166	268	java/lang/Exception
    //   174	180	268	java/lang/Exception
    //   196	215	268	java/lang/Exception
    //   223	231	268	java/lang/Exception
    //   239	245	268	java/lang/Exception
    //   258	265	268	java/lang/Exception
    //   349	355	268	java/lang/Exception
    //   363	391	268	java/lang/Exception
    //   399	411	268	java/lang/Exception
    //   419	428	268	java/lang/Exception
    //   436	442	268	java/lang/Exception
    //   450	476	268	java/lang/Exception
    //   489	514	268	java/lang/Exception
    //   563	572	268	java/lang/Exception
    //   580	586	268	java/lang/Exception
    //   594	619	268	java/lang/Exception
    //   114	121	622	finally
    //   129	166	622	finally
    //   174	180	622	finally
    //   196	215	622	finally
    //   223	231	622	finally
    //   239	245	622	finally
    //   258	265	622	finally
    //   349	355	622	finally
    //   363	391	622	finally
    //   399	411	622	finally
    //   419	428	622	finally
    //   436	442	622	finally
    //   450	476	622	finally
    //   489	514	622	finally
    //   563	572	622	finally
    //   580	586	622	finally
    //   594	619	622	finally
    //   90	106	673	finally
    //   279	285	673	finally
    //   291	300	673	finally
    //   90	106	679	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tuh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */