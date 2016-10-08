import com.tencent.mfsdk.reporter.YunYingReporter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.net.URL;
import org.json.JSONObject;

public class kgh
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private URL jdField_a_of_type_JavaNetURL;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  
  public kgh(YunYingReporter paramYunYingReporter, URL paramURL, JSONObject paramJSONObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_JavaNetURL = paramURL;
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 28	kgh:jdField_a_of_type_JavaNetURL	Ljava/net/URL;
    //   6: invokevirtual 42	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   9: checkcast 44	java/net/HttpURLConnection
    //   12: astore 4
    //   14: aload 4
    //   16: iconst_0
    //   17: invokevirtual 48	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   20: aload 4
    //   22: iconst_1
    //   23: invokevirtual 51	java/net/HttpURLConnection:setDoInput	(Z)V
    //   26: aload 4
    //   28: iconst_0
    //   29: invokevirtual 54	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   32: aload 4
    //   34: ldc 56
    //   36: invokevirtual 60	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   39: aload 4
    //   41: ldc 62
    //   43: ldc 64
    //   45: invokevirtual 68	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: new 70	java/io/DataOutputStream
    //   51: dup
    //   52: aload 4
    //   54: invokevirtual 74	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   57: invokespecial 77	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   60: astore_2
    //   61: aload_2
    //   62: astore_1
    //   63: aload_2
    //   64: aload_0
    //   65: getfield 30	kgh:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   68: invokevirtual 83	org/json/JSONObject:toString	()Ljava/lang/String;
    //   71: ldc 85
    //   73: invokevirtual 91	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   76: invokevirtual 95	java/io/DataOutputStream:write	([B)V
    //   79: aload_2
    //   80: astore_1
    //   81: aload_2
    //   82: invokevirtual 98	java/io/DataOutputStream:flush	()V
    //   85: aload_2
    //   86: astore_1
    //   87: new 100	java/io/BufferedInputStream
    //   90: dup
    //   91: aload 4
    //   93: invokevirtual 104	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   96: invokespecial 107	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   99: astore 4
    //   101: aload_2
    //   102: astore_1
    //   103: aload_0
    //   104: getfield 15	kgh:jdField_a_of_type_ComTencentMfsdkReporterYunYingReporter	Lcom/tencent/mfsdk/reporter/YunYingReporter;
    //   107: aload 4
    //   109: invokestatic 112	com/tencent/mfsdk/reporter/YunYingReporter:a	(Lcom/tencent/mfsdk/reporter/YunYingReporter;Ljava/io/InputStream;)Ljava/lang/String;
    //   112: astore 4
    //   114: aload_2
    //   115: astore_1
    //   116: aload_0
    //   117: getfield 15	kgh:jdField_a_of_type_ComTencentMfsdkReporterYunYingReporter	Lcom/tencent/mfsdk/reporter/YunYingReporter;
    //   120: aload 4
    //   122: invokestatic 115	com/tencent/mfsdk/reporter/YunYingReporter:a	(Lcom/tencent/mfsdk/reporter/YunYingReporter;Ljava/lang/String;)Z
    //   125: ifeq +43 -> 168
    //   128: aload_2
    //   129: ifnull +219 -> 348
    //   132: aload_2
    //   133: astore_1
    //   134: aload_2
    //   135: invokevirtual 118	java/io/DataOutputStream:close	()V
    //   138: aload_3
    //   139: astore_1
    //   140: aload_1
    //   141: ifnull +7 -> 148
    //   144: aload_1
    //   145: invokevirtual 118	java/io/DataOutputStream:close	()V
    //   148: return
    //   149: astore_1
    //   150: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq -5 -> 148
    //   156: invokestatic 126	com/tencent/mfsdk/reporter/YunYingReporter:a	()Ljava/lang/String;
    //   159: iconst_2
    //   160: aload_1
    //   161: invokevirtual 127	java/io/IOException:toString	()Ljava/lang/String;
    //   164: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: return
    //   168: aload_2
    //   169: astore_1
    //   170: aload_0
    //   171: getfield 26	kgh:jdField_a_of_type_Int	I
    //   174: ifle +52 -> 226
    //   177: aload_2
    //   178: astore_1
    //   179: aload_0
    //   180: aload_0
    //   181: getfield 26	kgh:jdField_a_of_type_Int	I
    //   184: iconst_1
    //   185: isub
    //   186: putfield 26	kgh:jdField_a_of_type_Int	I
    //   189: aload_2
    //   190: astore_1
    //   191: invokestatic 137	java/lang/Math:random	()D
    //   194: ldc2_w 138
    //   197: dmul
    //   198: ldc2_w 140
    //   201: dadd
    //   202: d2i
    //   203: istore 5
    //   205: aload_2
    //   206: astore_1
    //   207: aload_0
    //   208: getfield 15	kgh:jdField_a_of_type_ComTencentMfsdkReporterYunYingReporter	Lcom/tencent/mfsdk/reporter/YunYingReporter;
    //   211: invokestatic 144	com/tencent/mfsdk/reporter/YunYingReporter:a	(Lcom/tencent/mfsdk/reporter/YunYingReporter;)Lmqq/os/MqqHandler;
    //   214: aload_0
    //   215: iload 5
    //   217: sipush 1000
    //   220: imul
    //   221: i2l
    //   222: invokevirtual 150	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   225: pop
    //   226: aload_2
    //   227: ifnull -79 -> 148
    //   230: aload_2
    //   231: invokevirtual 118	java/io/DataOutputStream:close	()V
    //   234: return
    //   235: astore_1
    //   236: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq -91 -> 148
    //   242: invokestatic 126	com/tencent/mfsdk/reporter/YunYingReporter:a	()Ljava/lang/String;
    //   245: iconst_2
    //   246: aload_1
    //   247: invokevirtual 127	java/io/IOException:toString	()Ljava/lang/String;
    //   250: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: return
    //   254: astore_3
    //   255: aconst_null
    //   256: astore_2
    //   257: aload_2
    //   258: astore_1
    //   259: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq +16 -> 278
    //   265: aload_2
    //   266: astore_1
    //   267: invokestatic 126	com/tencent/mfsdk/reporter/YunYingReporter:a	()Ljava/lang/String;
    //   270: iconst_2
    //   271: aload_3
    //   272: invokevirtual 151	java/lang/Exception:toString	()Ljava/lang/String;
    //   275: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aload_2
    //   279: ifnull -131 -> 148
    //   282: aload_2
    //   283: invokevirtual 118	java/io/DataOutputStream:close	()V
    //   286: return
    //   287: astore_1
    //   288: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq -143 -> 148
    //   294: invokestatic 126	com/tencent/mfsdk/reporter/YunYingReporter:a	()Ljava/lang/String;
    //   297: iconst_2
    //   298: aload_1
    //   299: invokevirtual 127	java/io/IOException:toString	()Ljava/lang/String;
    //   302: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: return
    //   306: astore_2
    //   307: aconst_null
    //   308: astore_1
    //   309: aload_1
    //   310: ifnull +7 -> 317
    //   313: aload_1
    //   314: invokevirtual 118	java/io/DataOutputStream:close	()V
    //   317: aload_2
    //   318: athrow
    //   319: astore_1
    //   320: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq -6 -> 317
    //   326: invokestatic 126	com/tencent/mfsdk/reporter/YunYingReporter:a	()Ljava/lang/String;
    //   329: iconst_2
    //   330: aload_1
    //   331: invokevirtual 127	java/io/IOException:toString	()Ljava/lang/String;
    //   334: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: goto -20 -> 317
    //   340: astore_2
    //   341: goto -32 -> 309
    //   344: astore_3
    //   345: goto -88 -> 257
    //   348: aload_2
    //   349: astore_1
    //   350: goto -210 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	this	kgh
    //   62	83	1	localObject1	Object
    //   149	12	1	localIOException1	java.io.IOException
    //   169	38	1	localDataOutputStream1	java.io.DataOutputStream
    //   235	12	1	localIOException2	java.io.IOException
    //   258	9	1	localDataOutputStream2	java.io.DataOutputStream
    //   287	12	1	localIOException3	java.io.IOException
    //   308	6	1	localObject2	Object
    //   319	12	1	localIOException4	java.io.IOException
    //   349	1	1	localObject3	Object
    //   60	223	2	localDataOutputStream3	java.io.DataOutputStream
    //   306	12	2	localObject4	Object
    //   340	9	2	localObject5	Object
    //   1	138	3	localObject6	Object
    //   254	18	3	localException1	Exception
    //   344	1	3	localException2	Exception
    //   12	109	4	localObject7	Object
    //   203	18	5	i	int
    // Exception table:
    //   from	to	target	type
    //   144	148	149	java/io/IOException
    //   230	234	235	java/io/IOException
    //   2	61	254	java/lang/Exception
    //   282	286	287	java/io/IOException
    //   2	61	306	finally
    //   313	317	319	java/io/IOException
    //   63	79	340	finally
    //   81	85	340	finally
    //   87	101	340	finally
    //   103	114	340	finally
    //   116	128	340	finally
    //   134	138	340	finally
    //   170	177	340	finally
    //   179	189	340	finally
    //   191	205	340	finally
    //   207	226	340	finally
    //   259	265	340	finally
    //   267	278	340	finally
    //   63	79	344	java/lang/Exception
    //   81	85	344	java/lang/Exception
    //   87	101	344	java/lang/Exception
    //   103	114	344	java/lang/Exception
    //   116	128	344	java/lang/Exception
    //   134	138	344	java/lang/Exception
    //   170	177	344	java/lang/Exception
    //   179	189	344	java/lang/Exception
    //   191	205	344	java/lang/Exception
    //   207	226	344	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\kgh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */