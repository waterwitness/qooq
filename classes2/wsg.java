import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.report.ReportCenter;

public class wsg
  implements Runnable
{
  public wsg(ReportCenter paramReportCenter, Bundle paramBundle, String paramString, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 17	wsg:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   7: ifnonnull +18 -> 25
    //   10: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +392 -> 405
    //   16: ldc 45
    //   18: iconst_2
    //   19: ldc 47
    //   21: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: return
    //   25: invokestatic 56	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   28: invokevirtual 59	com/tencent/open/adapter/CommonDataAdapter:a	()Landroid/content/Context;
    //   31: aconst_null
    //   32: invokestatic 64	com/tencent/open/business/base/OpenConfig:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/open/business/base/OpenConfig;
    //   35: ldc 66
    //   37: invokevirtual 69	com/tencent/open/business/base/OpenConfig:a	(Ljava/lang/String;)I
    //   40: istore 6
    //   42: iload 6
    //   44: ifne +247 -> 291
    //   47: iconst_3
    //   48: istore 6
    //   50: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +29 -> 82
    //   56: ldc 45
    //   58: iconst_2
    //   59: new 71	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   66: ldc 74
    //   68: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload 6
    //   73: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: iconst_0
    //   83: istore 7
    //   85: iload 7
    //   87: iconst_1
    //   88: iadd
    //   89: istore 8
    //   91: aconst_null
    //   92: aload_0
    //   93: getfield 19	wsg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   96: invokestatic 90	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/client/HttpClient;
    //   99: astore_3
    //   100: aload_0
    //   101: getfield 17	wsg:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   104: invokestatic 93	com/tencent/open/base/http/HttpBaseUtil:a	(Landroid/os/Bundle;)Ljava/lang/String;
    //   107: astore_2
    //   108: aload_2
    //   109: astore_1
    //   110: aload_0
    //   111: getfield 21	wsg:jdField_a_of_type_Boolean	Z
    //   114: ifeq +8 -> 122
    //   117: aload_2
    //   118: invokestatic 99	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   121: astore_1
    //   122: new 101	java/lang/StringBuffer
    //   125: dup
    //   126: aload_0
    //   127: getfield 19	wsg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   130: invokespecial 104	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   133: astore_2
    //   134: aload_2
    //   135: aload_1
    //   136: invokevirtual 107	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   139: pop
    //   140: new 109	org/apache/http/client/methods/HttpGet
    //   143: dup
    //   144: aload_2
    //   145: invokevirtual 110	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   148: invokespecial 111	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   151: astore_1
    //   152: aload_1
    //   153: ldc 113
    //   155: ldc 115
    //   157: invokeinterface 121 3 0
    //   162: aload_1
    //   163: ldc 123
    //   165: ldc 125
    //   167: invokeinterface 121 3 0
    //   172: aload_3
    //   173: aload_1
    //   174: invokeinterface 131 2 0
    //   179: invokeinterface 137 1 0
    //   184: invokeinterface 143 1 0
    //   189: istore 5
    //   191: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +29 -> 223
    //   197: ldc 45
    //   199: iconst_2
    //   200: new 71	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   207: ldc -111
    //   209: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: iload 5
    //   214: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: iload 5
    //   225: sipush 200
    //   228: if_icmpeq +66 -> 294
    //   231: iload 4
    //   233: istore 5
    //   235: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +15 -> 253
    //   241: ldc 45
    //   243: iconst_2
    //   244: ldc -109
    //   246: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: iload 4
    //   251: istore 5
    //   253: iload 5
    //   255: iconst_1
    //   256: if_icmpne +113 -> 369
    //   259: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq +143 -> 405
    //   265: ldc 45
    //   267: iconst_2
    //   268: ldc -107
    //   270: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: return
    //   274: astore_1
    //   275: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +127 -> 405
    //   281: ldc 45
    //   283: iconst_2
    //   284: ldc -105
    //   286: aload_1
    //   287: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   290: return
    //   291: goto -241 -> 50
    //   294: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +11 -> 308
    //   300: ldc 45
    //   302: iconst_2
    //   303: ldc -100
    //   305: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: iconst_1
    //   309: istore 5
    //   311: goto -58 -> 253
    //   314: astore_1
    //   315: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   318: ifeq +88 -> 406
    //   321: ldc 45
    //   323: iconst_2
    //   324: ldc -98
    //   326: aload_1
    //   327: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   330: goto +76 -> 406
    //   333: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq +96 -> 432
    //   339: ldc 45
    //   341: iconst_2
    //   342: ldc -96
    //   344: aload_1
    //   345: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   348: goto +84 -> 432
    //   351: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   354: ifeq +89 -> 443
    //   357: ldc 45
    //   359: iconst_2
    //   360: ldc -94
    //   362: aload_1
    //   363: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   366: goto +77 -> 443
    //   369: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq +33 -> 405
    //   375: ldc 45
    //   377: iconst_2
    //   378: ldc -92
    //   380: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: return
    //   384: astore_1
    //   385: iconst_1
    //   386: istore 4
    //   388: goto -37 -> 351
    //   391: astore_1
    //   392: iconst_1
    //   393: istore 4
    //   395: goto -62 -> 333
    //   398: astore_1
    //   399: iconst_1
    //   400: istore 4
    //   402: goto -87 -> 315
    //   405: return
    //   406: iload 4
    //   408: istore 5
    //   410: iload 5
    //   412: istore 4
    //   414: iload 8
    //   416: istore 7
    //   418: iload 8
    //   420: iload 6
    //   422: if_icmplt -337 -> 85
    //   425: goto -172 -> 253
    //   428: astore_1
    //   429: goto -96 -> 333
    //   432: iload 4
    //   434: istore 5
    //   436: goto -26 -> 410
    //   439: astore_1
    //   440: goto -89 -> 351
    //   443: iload 4
    //   445: istore 5
    //   447: goto -194 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	this	wsg
    //   109	65	1	localObject1	Object
    //   274	13	1	localException1	Exception
    //   314	49	1	localConnectTimeoutException1	org.apache.http.conn.ConnectTimeoutException
    //   384	1	1	localException2	Exception
    //   391	1	1	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   398	1	1	localConnectTimeoutException2	org.apache.http.conn.ConnectTimeoutException
    //   428	1	1	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   439	1	1	localException3	Exception
    //   107	38	2	localObject2	Object
    //   99	74	3	localHttpClient	org.apache.http.client.HttpClient
    //   1	443	4	i	int
    //   189	257	5	j	int
    //   40	383	6	k	int
    //   83	334	7	m	int
    //   89	334	8	n	int
    // Exception table:
    //   from	to	target	type
    //   3	24	274	java/lang/Exception
    //   25	42	274	java/lang/Exception
    //   50	82	274	java/lang/Exception
    //   259	273	274	java/lang/Exception
    //   315	330	274	java/lang/Exception
    //   333	348	274	java/lang/Exception
    //   351	366	274	java/lang/Exception
    //   369	383	274	java/lang/Exception
    //   91	108	314	org/apache/http/conn/ConnectTimeoutException
    //   110	122	314	org/apache/http/conn/ConnectTimeoutException
    //   122	223	314	org/apache/http/conn/ConnectTimeoutException
    //   235	249	314	org/apache/http/conn/ConnectTimeoutException
    //   294	308	384	java/lang/Exception
    //   294	308	391	java/net/SocketTimeoutException
    //   294	308	398	org/apache/http/conn/ConnectTimeoutException
    //   91	108	428	java/net/SocketTimeoutException
    //   110	122	428	java/net/SocketTimeoutException
    //   122	223	428	java/net/SocketTimeoutException
    //   235	249	428	java/net/SocketTimeoutException
    //   91	108	439	java/lang/Exception
    //   110	122	439	java/lang/Exception
    //   122	223	439	java/lang/Exception
    //   235	249	439	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */