import com.tencent.mfsdk.reporter.YunYingReporter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

public class kgg
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private File jdField_a_of_type_JavaIoFile;
  private FileInputStream jdField_a_of_type_JavaIoFileInputStream;
  private String jdField_a_of_type_JavaLangString;
  private URL jdField_a_of_type_JavaNetURL;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b;
  
  public kgg(YunYingReporter paramYunYingReporter, URL paramURL, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = 3;
    this.jdField_a_of_type_JavaNetURL = paramURL;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaIoFile = new File(this.jdField_a_of_type_JavaLangString);
    try
    {
      this.jdField_a_of_type_JavaIoFileInputStream = new FileInputStream(this.jdField_a_of_type_JavaIoFile);
      l = this.jdField_a_of_type_JavaIoFile.length();
      if (l > 1048576L)
      {
        this.jdField_a_of_type_ArrayOfByte = new byte[1048576];
        return;
      }
    }
    catch (FileNotFoundException paramYunYingReporter)
    {
      long l;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(YunYingReporter.a(), 2, paramYunYingReporter.toString());
        }
      }
      this.jdField_a_of_type_ArrayOfByte = new byte[(int)l];
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 8
    //   6: iconst_0
    //   7: istore 6
    //   9: aload_0
    //   10: getfield 50	kgg:jdField_a_of_type_JavaIoFileInputStream	Ljava/io/FileInputStream;
    //   13: aload_0
    //   14: getfield 59	kgg:jdField_a_of_type_ArrayOfByte	[B
    //   17: invokevirtual 87	java/io/FileInputStream:read	([B)I
    //   20: istore 4
    //   22: iconst_m1
    //   23: iload 4
    //   25: if_icmpeq +398 -> 423
    //   28: iload 8
    //   30: istore 7
    //   32: new 89	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   39: ldc 92
    //   41: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: getfield 98	kgg:jdField_a_of_type_Int	I
    //   48: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: ldc 103
    //   53: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield 98	kgg:jdField_a_of_type_Int	I
    //   60: iload 4
    //   62: iadd
    //   63: iconst_1
    //   64: isub
    //   65: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: ldc 105
    //   70: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_0
    //   74: getfield 43	kgg:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   77: invokevirtual 54	java/io/File:length	()J
    //   80: invokevirtual 108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   83: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: astore_2
    //   87: iload 8
    //   89: istore 7
    //   91: aload_0
    //   92: getfield 34	kgg:jdField_a_of_type_JavaNetURL	Ljava/net/URL;
    //   95: invokevirtual 115	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   98: checkcast 117	java/net/HttpURLConnection
    //   101: astore_1
    //   102: iload 8
    //   104: istore 7
    //   106: aload_1
    //   107: iconst_0
    //   108: invokevirtual 121	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   111: iload 8
    //   113: istore 7
    //   115: aload_1
    //   116: iconst_1
    //   117: invokevirtual 124	java/net/HttpURLConnection:setDoInput	(Z)V
    //   120: iload 8
    //   122: istore 7
    //   124: aload_1
    //   125: iconst_0
    //   126: invokevirtual 127	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   129: iload 8
    //   131: istore 7
    //   133: aload_1
    //   134: ldc -127
    //   136: invokevirtual 132	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   139: iload 8
    //   141: istore 7
    //   143: aload_1
    //   144: ldc -122
    //   146: ldc -120
    //   148: invokevirtual 140	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: iload 8
    //   153: istore 7
    //   155: aload_1
    //   156: ldc -114
    //   158: ldc -112
    //   160: invokevirtual 140	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: iload 8
    //   165: istore 7
    //   167: aload_1
    //   168: ldc -110
    //   170: new 89	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   177: ldc -108
    //   179: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_0
    //   183: getfield 43	kgg:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   186: invokevirtual 151	java/io/File:getName	()Ljava/lang/String;
    //   189: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc -103
    //   194: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokevirtual 140	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: iload 8
    //   205: istore 7
    //   207: aload_1
    //   208: ldc -101
    //   210: aload_0
    //   211: getfield 36	kgg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   214: invokestatic 161	com/tencent/qphone/base/util/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   217: invokevirtual 140	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: iload 8
    //   222: istore 7
    //   224: aload_1
    //   225: ldc -93
    //   227: new 89	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   234: ldc -91
    //   236: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: iload 4
    //   241: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokevirtual 140	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: iload 8
    //   252: istore 7
    //   254: aload_1
    //   255: ldc -89
    //   257: aload_2
    //   258: invokevirtual 140	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: iload 8
    //   263: istore 7
    //   265: aload_0
    //   266: aload_0
    //   267: getfield 98	kgg:jdField_a_of_type_Int	I
    //   270: iload 4
    //   272: iadd
    //   273: putfield 98	kgg:jdField_a_of_type_Int	I
    //   276: iload 8
    //   278: istore 7
    //   280: new 169	java/io/DataOutputStream
    //   283: dup
    //   284: aload_1
    //   285: invokevirtual 173	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   288: invokespecial 176	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   291: astore_2
    //   292: iload 4
    //   294: aload_0
    //   295: getfield 59	kgg:jdField_a_of_type_ArrayOfByte	[B
    //   298: arraylength
    //   299: if_icmpne +194 -> 493
    //   302: aload_2
    //   303: aload_0
    //   304: getfield 59	kgg:jdField_a_of_type_ArrayOfByte	[B
    //   307: invokevirtual 180	java/io/DataOutputStream:write	([B)V
    //   310: aload_2
    //   311: invokevirtual 183	java/io/DataOutputStream:flush	()V
    //   314: new 185	java/io/BufferedInputStream
    //   317: dup
    //   318: aload_1
    //   319: invokevirtual 189	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   322: invokespecial 192	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   325: astore_1
    //   326: aload_0
    //   327: getfield 21	kgg:jdField_a_of_type_ComTencentMfsdkReporterYunYingReporter	Lcom/tencent/mfsdk/reporter/YunYingReporter;
    //   330: aload_1
    //   331: invokestatic 195	com/tencent/mfsdk/reporter/YunYingReporter:a	(Lcom/tencent/mfsdk/reporter/YunYingReporter;Ljava/io/InputStream;)Ljava/lang/String;
    //   334: astore_1
    //   335: aload_0
    //   336: getfield 21	kgg:jdField_a_of_type_ComTencentMfsdkReporterYunYingReporter	Lcom/tencent/mfsdk/reporter/YunYingReporter;
    //   339: aload_1
    //   340: invokestatic 198	com/tencent/mfsdk/reporter/YunYingReporter:a	(Lcom/tencent/mfsdk/reporter/YunYingReporter;Ljava/lang/String;)Z
    //   343: istore 7
    //   345: iload 7
    //   347: istore 6
    //   349: iload 6
    //   351: ifne +56 -> 407
    //   354: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq +37 -> 394
    //   360: invokestatic 70	com/tencent/mfsdk/reporter/YunYingReporter:a	()Ljava/lang/String;
    //   363: iconst_2
    //   364: new 89	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   371: ldc -56
    //   373: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload_0
    //   377: getfield 98	kgg:jdField_a_of_type_Int	I
    //   380: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   383: ldc -54
    //   385: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 205	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: aload_0
    //   395: getfield 50	kgg:jdField_a_of_type_JavaIoFileInputStream	Ljava/io/FileInputStream;
    //   398: aload_0
    //   399: getfield 98	kgg:jdField_a_of_type_Int	I
    //   402: i2l
    //   403: invokevirtual 209	java/io/FileInputStream:skip	(J)J
    //   406: pop2
    //   407: iload 6
    //   409: istore 7
    //   411: aload_2
    //   412: ifnull +11 -> 423
    //   415: aload_2
    //   416: invokevirtual 212	java/io/DataOutputStream:close	()V
    //   419: iload 6
    //   421: istore 7
    //   423: iload 4
    //   425: istore 5
    //   427: iload 7
    //   429: ifeq +240 -> 669
    //   432: iconst_m1
    //   433: iload 5
    //   435: if_icmpne +221 -> 656
    //   438: aload_0
    //   439: getfield 50	kgg:jdField_a_of_type_JavaIoFileInputStream	Ljava/io/FileInputStream;
    //   442: ifnull +50 -> 492
    //   445: aload_0
    //   446: getfield 50	kgg:jdField_a_of_type_JavaIoFileInputStream	Ljava/io/FileInputStream;
    //   449: invokevirtual 213	java/io/FileInputStream:close	()V
    //   452: aload_0
    //   453: getfield 43	kgg:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   456: ifnull +31 -> 487
    //   459: aload_0
    //   460: getfield 43	kgg:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   463: invokevirtual 216	java/io/File:isFile	()Z
    //   466: ifeq +21 -> 487
    //   469: aload_0
    //   470: getfield 43	kgg:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   473: invokevirtual 219	java/io/File:exists	()Z
    //   476: ifeq +11 -> 487
    //   479: aload_0
    //   480: getfield 43	kgg:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   483: invokevirtual 222	java/io/File:delete	()Z
    //   486: pop
    //   487: aload_0
    //   488: aconst_null
    //   489: putfield 50	kgg:jdField_a_of_type_JavaIoFileInputStream	Ljava/io/FileInputStream;
    //   492: return
    //   493: iload 4
    //   495: newarray <illegal type>
    //   497: astore_3
    //   498: aload_0
    //   499: getfield 59	kgg:jdField_a_of_type_ArrayOfByte	[B
    //   502: iconst_0
    //   503: aload_3
    //   504: iconst_0
    //   505: iload 4
    //   507: invokestatic 228	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   510: aload_2
    //   511: aload_3
    //   512: invokevirtual 180	java/io/DataOutputStream:write	([B)V
    //   515: goto -205 -> 310
    //   518: astore_1
    //   519: iconst_0
    //   520: istore 6
    //   522: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   525: ifeq +14 -> 539
    //   528: invokestatic 70	com/tencent/mfsdk/reporter/YunYingReporter:a	()Ljava/lang/String;
    //   531: iconst_2
    //   532: aload_1
    //   533: invokevirtual 229	java/lang/Exception:toString	()Ljava/lang/String;
    //   536: invokestatic 77	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: aload_0
    //   540: getfield 50	kgg:jdField_a_of_type_JavaIoFileInputStream	Ljava/io/FileInputStream;
    //   543: aload_0
    //   544: getfield 98	kgg:jdField_a_of_type_Int	I
    //   547: i2l
    //   548: invokevirtual 209	java/io/FileInputStream:skip	(J)J
    //   551: pop2
    //   552: iload 6
    //   554: istore 7
    //   556: aload_2
    //   557: ifnull -134 -> 423
    //   560: aload_2
    //   561: invokevirtual 212	java/io/DataOutputStream:close	()V
    //   564: iload 6
    //   566: istore 7
    //   568: goto -145 -> 423
    //   571: astore_1
    //   572: iload 4
    //   574: istore 5
    //   576: iload 6
    //   578: istore 7
    //   580: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   583: ifeq -156 -> 427
    //   586: invokestatic 70	com/tencent/mfsdk/reporter/YunYingReporter:a	()Ljava/lang/String;
    //   589: iconst_2
    //   590: aload_1
    //   591: invokevirtual 229	java/lang/Exception:toString	()Ljava/lang/String;
    //   594: invokestatic 77	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   597: iload 4
    //   599: istore 5
    //   601: iload 6
    //   603: istore 7
    //   605: goto -178 -> 427
    //   608: astore_1
    //   609: aload_2
    //   610: ifnull +11 -> 621
    //   613: iload 6
    //   615: istore 7
    //   617: aload_2
    //   618: invokevirtual 212	java/io/DataOutputStream:close	()V
    //   621: iload 6
    //   623: istore 7
    //   625: aload_1
    //   626: athrow
    //   627: astore_1
    //   628: iload 7
    //   630: istore 6
    //   632: goto -60 -> 572
    //   635: astore_1
    //   636: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   639: ifeq -152 -> 487
    //   642: invokestatic 70	com/tencent/mfsdk/reporter/YunYingReporter:a	()Ljava/lang/String;
    //   645: iconst_2
    //   646: aload_1
    //   647: invokevirtual 230	java/io/IOException:toString	()Ljava/lang/String;
    //   650: invokestatic 77	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   653: goto -166 -> 487
    //   656: aload_0
    //   657: getfield 21	kgg:jdField_a_of_type_ComTencentMfsdkReporterYunYingReporter	Lcom/tencent/mfsdk/reporter/YunYingReporter;
    //   660: invokestatic 233	com/tencent/mfsdk/reporter/YunYingReporter:a	(Lcom/tencent/mfsdk/reporter/YunYingReporter;)Lmqq/os/MqqHandler;
    //   663: aload_0
    //   664: invokevirtual 239	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   667: pop
    //   668: return
    //   669: aload_0
    //   670: getfield 32	kgg:b	I
    //   673: ifle +47 -> 720
    //   676: aload_0
    //   677: aload_0
    //   678: getfield 32	kgg:b	I
    //   681: iconst_1
    //   682: isub
    //   683: putfield 32	kgg:b	I
    //   686: invokestatic 245	java/lang/Math:random	()D
    //   689: ldc2_w 246
    //   692: dmul
    //   693: ldc2_w 248
    //   696: dadd
    //   697: d2i
    //   698: istore 4
    //   700: aload_0
    //   701: getfield 21	kgg:jdField_a_of_type_ComTencentMfsdkReporterYunYingReporter	Lcom/tencent/mfsdk/reporter/YunYingReporter;
    //   704: invokestatic 233	com/tencent/mfsdk/reporter/YunYingReporter:a	(Lcom/tencent/mfsdk/reporter/YunYingReporter;)Lmqq/os/MqqHandler;
    //   707: aload_0
    //   708: iload 4
    //   710: sipush 1000
    //   713: imul
    //   714: i2l
    //   715: invokevirtual 253	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   718: pop
    //   719: return
    //   720: aload_0
    //   721: getfield 50	kgg:jdField_a_of_type_JavaIoFileInputStream	Ljava/io/FileInputStream;
    //   724: ifnull -232 -> 492
    //   727: aload_0
    //   728: getfield 50	kgg:jdField_a_of_type_JavaIoFileInputStream	Ljava/io/FileInputStream;
    //   731: invokevirtual 213	java/io/FileInputStream:close	()V
    //   734: aload_0
    //   735: aconst_null
    //   736: putfield 50	kgg:jdField_a_of_type_JavaIoFileInputStream	Ljava/io/FileInputStream;
    //   739: return
    //   740: astore_1
    //   741: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   744: ifeq -10 -> 734
    //   747: invokestatic 70	com/tencent/mfsdk/reporter/YunYingReporter:a	()Ljava/lang/String;
    //   750: iconst_2
    //   751: aload_1
    //   752: invokevirtual 230	java/io/IOException:toString	()Ljava/lang/String;
    //   755: invokestatic 77	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   758: goto -24 -> 734
    //   761: astore_1
    //   762: iconst_0
    //   763: istore 6
    //   765: iconst_m1
    //   766: istore 4
    //   768: goto -196 -> 572
    //   771: astore_1
    //   772: goto -200 -> 572
    //   775: astore_1
    //   776: goto -167 -> 609
    //   779: astore_1
    //   780: goto -171 -> 609
    //   783: astore_1
    //   784: goto -262 -> 522
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	787	0	this	kgg
    //   101	239	1	localObject1	Object
    //   518	15	1	localException1	Exception
    //   571	20	1	localException2	Exception
    //   608	18	1	localObject2	Object
    //   627	1	1	localException3	Exception
    //   635	12	1	localIOException1	java.io.IOException
    //   740	12	1	localIOException2	java.io.IOException
    //   761	1	1	localException4	Exception
    //   771	1	1	localException5	Exception
    //   775	1	1	localObject3	Object
    //   779	1	1	localObject4	Object
    //   783	1	1	localException6	Exception
    //   86	532	2	localObject5	Object
    //   497	15	3	arrayOfByte	byte[]
    //   20	747	4	i	int
    //   425	175	5	j	int
    //   7	757	6	bool1	boolean
    //   1	628	7	bool2	boolean
    //   4	273	8	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   292	310	518	java/lang/Exception
    //   310	345	518	java/lang/Exception
    //   493	515	518	java/lang/Exception
    //   560	564	571	java/lang/Exception
    //   292	310	608	finally
    //   310	345	608	finally
    //   493	515	608	finally
    //   32	87	627	java/lang/Exception
    //   91	102	627	java/lang/Exception
    //   106	111	627	java/lang/Exception
    //   115	120	627	java/lang/Exception
    //   124	129	627	java/lang/Exception
    //   133	139	627	java/lang/Exception
    //   143	151	627	java/lang/Exception
    //   155	163	627	java/lang/Exception
    //   167	203	627	java/lang/Exception
    //   207	220	627	java/lang/Exception
    //   224	250	627	java/lang/Exception
    //   254	261	627	java/lang/Exception
    //   265	276	627	java/lang/Exception
    //   280	292	627	java/lang/Exception
    //   617	621	627	java/lang/Exception
    //   625	627	627	java/lang/Exception
    //   445	487	635	java/io/IOException
    //   727	734	740	java/io/IOException
    //   9	22	761	java/lang/Exception
    //   415	419	771	java/lang/Exception
    //   354	394	775	finally
    //   394	407	775	finally
    //   522	539	779	finally
    //   539	552	779	finally
    //   354	394	783	java/lang/Exception
    //   394	407	783	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\kgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */