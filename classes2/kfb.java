import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kfb
  extends Handler
{
  public kfb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_1
    //   5: invokevirtual 27	android/os/Message:getData	()Landroid/os/Bundle;
    //   8: astore_1
    //   9: aload_1
    //   10: ldc 29
    //   12: invokevirtual 35	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   15: istore 6
    //   17: aload_1
    //   18: ldc 37
    //   20: invokevirtual 35	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   23: istore 7
    //   25: aload_1
    //   26: ldc 39
    //   28: invokevirtual 35	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   31: istore 8
    //   33: aload_1
    //   34: ldc 41
    //   36: invokevirtual 45	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   39: astore 4
    //   41: getstatic 51	com/tencent/kingkong/Constant:d	Ljava/lang/String;
    //   44: astore_1
    //   45: new 53	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   52: ldc 56
    //   54: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload 6
    //   59: invokestatic 66	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   62: ldc 68
    //   64: invokestatic 74	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   67: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 76
    //   72: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: iload 7
    //   77: invokestatic 66	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   80: ldc 68
    //   82: invokestatic 74	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   85: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc 78
    //   90: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: iload 8
    //   95: invokestatic 66	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   98: ldc 68
    //   100: invokestatic 74	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   103: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload 4
    //   108: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 87	com/tencent/kingkong/ReportThread:a	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 4
    //   119: aload 4
    //   121: invokestatic 90	com/tencent/kingkong/ReportThread:b	(Ljava/lang/String;)Ljava/lang/String;
    //   124: astore 5
    //   126: ldc 92
    //   128: new 53	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   135: ldc 94
    //   137: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload 4
    //   142: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 99	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: ldc 92
    //   153: new 53	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   160: ldc 101
    //   162: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 5
    //   167: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 99	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: new 53	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   183: aload_1
    //   184: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc 103
    //   189: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 5
    //   194: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: astore_1
    //   201: ldc 92
    //   203: aload_1
    //   204: invokestatic 99	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: new 105	java/net/URL
    //   210: dup
    //   211: aload_1
    //   212: invokespecial 108	java/net/URL:<init>	(Ljava/lang/String;)V
    //   215: invokevirtual 112	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   218: checkcast 114	java/net/HttpURLConnection
    //   221: astore_1
    //   222: new 116	java/io/InputStreamReader
    //   225: dup
    //   226: aload_1
    //   227: invokevirtual 120	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   230: invokespecial 123	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   233: astore_2
    //   234: new 125	java/io/BufferedReader
    //   237: dup
    //   238: aload_2
    //   239: invokespecial 128	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   242: astore_3
    //   243: aload_3
    //   244: invokevirtual 131	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   247: astore 4
    //   249: aload 4
    //   251: ifnonnull -8 -> 243
    //   254: aload_1
    //   255: ifnull +7 -> 262
    //   258: aload_1
    //   259: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   262: aload_2
    //   263: ifnull +7 -> 270
    //   266: aload_2
    //   267: invokevirtual 137	java/io/InputStreamReader:close	()V
    //   270: ldc 92
    //   272: ldc -117
    //   274: invokestatic 99	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: return
    //   278: astore_1
    //   279: ldc -115
    //   281: new 53	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   288: ldc -113
    //   290: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_1
    //   294: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 99	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: return
    //   304: astore_1
    //   305: new 148	java/io/StringWriter
    //   308: dup
    //   309: invokespecial 149	java/io/StringWriter:<init>	()V
    //   312: astore_2
    //   313: aload_1
    //   314: new 151	java/io/PrintWriter
    //   317: dup
    //   318: aload_2
    //   319: invokespecial 154	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   322: invokevirtual 158	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   325: ldc 92
    //   327: new 53	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   334: ldc -96
    //   336: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: aload_2
    //   340: invokevirtual 161	java/io/StringWriter:toString	()Ljava/lang/String;
    //   343: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 99	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: goto -82 -> 270
    //   355: astore_1
    //   356: aconst_null
    //   357: astore_2
    //   358: new 148	java/io/StringWriter
    //   361: dup
    //   362: invokespecial 149	java/io/StringWriter:<init>	()V
    //   365: astore 4
    //   367: aload_1
    //   368: new 151	java/io/PrintWriter
    //   371: dup
    //   372: aload 4
    //   374: invokespecial 154	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   377: invokevirtual 158	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   380: ldc 92
    //   382: new 53	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   389: ldc -93
    //   391: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload 4
    //   396: invokevirtual 161	java/io/StringWriter:toString	()Ljava/lang/String;
    //   399: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 99	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: aload_3
    //   409: ifnull +7 -> 416
    //   412: aload_3
    //   413: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   416: aload_2
    //   417: ifnull -147 -> 270
    //   420: aload_2
    //   421: invokevirtual 137	java/io/InputStreamReader:close	()V
    //   424: goto -154 -> 270
    //   427: astore_1
    //   428: new 148	java/io/StringWriter
    //   431: dup
    //   432: invokespecial 149	java/io/StringWriter:<init>	()V
    //   435: astore_2
    //   436: aload_1
    //   437: new 151	java/io/PrintWriter
    //   440: dup
    //   441: aload_2
    //   442: invokespecial 154	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   445: invokevirtual 158	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   448: ldc 92
    //   450: new 53	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   457: ldc -96
    //   459: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload_2
    //   463: invokevirtual 161	java/io/StringWriter:toString	()Ljava/lang/String;
    //   466: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 99	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   475: goto -205 -> 270
    //   478: astore_1
    //   479: aconst_null
    //   480: astore 4
    //   482: aload_2
    //   483: astore_3
    //   484: aload 4
    //   486: astore_2
    //   487: aload_3
    //   488: ifnull +7 -> 495
    //   491: aload_3
    //   492: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   495: aload_2
    //   496: ifnull +7 -> 503
    //   499: aload_2
    //   500: invokevirtual 137	java/io/InputStreamReader:close	()V
    //   503: aload_1
    //   504: athrow
    //   505: astore_2
    //   506: new 148	java/io/StringWriter
    //   509: dup
    //   510: invokespecial 149	java/io/StringWriter:<init>	()V
    //   513: astore_3
    //   514: aload_2
    //   515: new 151	java/io/PrintWriter
    //   518: dup
    //   519: aload_3
    //   520: invokespecial 154	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   523: invokevirtual 158	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   526: ldc 92
    //   528: new 53	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   535: ldc -96
    //   537: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload_3
    //   541: invokevirtual 161	java/io/StringWriter:toString	()Ljava/lang/String;
    //   544: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 99	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   553: goto -50 -> 503
    //   556: astore 4
    //   558: aconst_null
    //   559: astore_2
    //   560: aload_1
    //   561: astore_3
    //   562: aload 4
    //   564: astore_1
    //   565: goto -78 -> 487
    //   568: astore 4
    //   570: aload_1
    //   571: astore_3
    //   572: aload 4
    //   574: astore_1
    //   575: goto -88 -> 487
    //   578: astore_1
    //   579: goto -92 -> 487
    //   582: astore 4
    //   584: aconst_null
    //   585: astore_2
    //   586: aload_1
    //   587: astore_3
    //   588: aload 4
    //   590: astore_1
    //   591: goto -233 -> 358
    //   594: astore 4
    //   596: aload_1
    //   597: astore_3
    //   598: aload 4
    //   600: astore_1
    //   601: goto -243 -> 358
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	604	0	this	kfb
    //   0	604	1	paramMessage	android.os.Message
    //   1	499	2	localObject1	Object
    //   505	10	2	localThrowable1	Throwable
    //   559	27	2	localObject2	Object
    //   3	595	3	localObject3	Object
    //   39	446	4	localObject4	Object
    //   556	7	4	localObject5	Object
    //   568	5	4	localObject6	Object
    //   582	7	4	localThrowable2	Throwable
    //   594	5	4	localThrowable3	Throwable
    //   124	69	5	str	String
    //   15	43	6	i	int
    //   23	53	7	j	int
    //   31	63	8	k	int
    // Exception table:
    //   from	to	target	type
    //   45	176	278	java/lang/Exception
    //   266	270	304	java/lang/Throwable
    //   207	222	355	java/lang/Throwable
    //   420	424	427	java/lang/Throwable
    //   207	222	478	finally
    //   499	503	505	java/lang/Throwable
    //   222	234	556	finally
    //   234	243	568	finally
    //   243	249	568	finally
    //   358	408	578	finally
    //   222	234	582	java/lang/Throwable
    //   234	243	594	java/lang/Throwable
    //   243	249	594	java/lang/Throwable
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\kfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */