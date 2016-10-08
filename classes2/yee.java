import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.plugin.PluginPreInstaller;

public class yee
  implements Runnable
{
  public yee(PluginPreInstaller paramPluginPreInstaller)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	yee:a	Lcooperation/plugin/PluginPreInstaller;
    //   4: invokestatic 30	cooperation/plugin/PluginPreInstaller:a	(Lcooperation/plugin/PluginPreInstaller;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 12	yee:a	Lcooperation/plugin/PluginPreInstaller;
    //   15: invokestatic 30	cooperation/plugin/PluginPreInstaller:a	(Lcooperation/plugin/PluginPreInstaller;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   18: invokevirtual 35	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   21: astore_3
    //   22: aload_3
    //   23: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifeq +18 -> 44
    //   29: invokestatic 47	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   32: ifeq -22 -> 10
    //   35: ldc 49
    //   37: iconst_4
    //   38: ldc 51
    //   40: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: return
    //   44: aconst_null
    //   45: astore_2
    //   46: aconst_null
    //   47: astore 4
    //   49: aload_2
    //   50: astore_1
    //   51: aload_0
    //   52: getfield 12	yee:a	Lcooperation/plugin/PluginPreInstaller;
    //   55: invokestatic 30	cooperation/plugin/PluginPreInstaller:a	(Lcooperation/plugin/PluginPreInstaller;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   58: invokestatic 61	cooperation/qqreader/QRBridgeUtil:getSKey	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   61: astore 5
    //   63: aload_2
    //   64: astore_1
    //   65: new 63	java/net/URL
    //   68: dup
    //   69: new 65	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   76: ldc 68
    //   78: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload 5
    //   83: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 74
    //   88: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokespecial 80	java/net/URL:<init>	(Ljava/lang/String;)V
    //   97: invokevirtual 84	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   100: checkcast 86	java/net/HttpURLConnection
    //   103: astore_2
    //   104: aload_2
    //   105: sipush 10000
    //   108: invokevirtual 90	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   111: aload_2
    //   112: sipush 10000
    //   115: invokevirtual 93	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   118: aload_2
    //   119: ldc 95
    //   121: new 65	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   128: ldc 97
    //   130: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_3
    //   134: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc 99
    //   139: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_3
    //   143: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc 101
    //   148: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload 5
    //   153: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokevirtual 105	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_2
    //   163: invokevirtual 109	java/net/HttpURLConnection:getResponseCode	()I
    //   166: sipush 200
    //   169: if_icmpne +137 -> 306
    //   172: new 111	java/io/BufferedReader
    //   175: dup
    //   176: new 113	java/io/InputStreamReader
    //   179: dup
    //   180: aload_2
    //   181: invokevirtual 117	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   184: invokespecial 120	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   187: invokespecial 123	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   190: astore_1
    //   191: new 125	java/lang/StringBuffer
    //   194: dup
    //   195: invokespecial 126	java/lang/StringBuffer:<init>	()V
    //   198: astore_3
    //   199: aload_1
    //   200: invokevirtual 129	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   203: astore 4
    //   205: aload 4
    //   207: ifnull +29 -> 236
    //   210: aload_3
    //   211: aload 4
    //   213: invokevirtual 132	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   216: pop
    //   217: goto -18 -> 199
    //   220: astore_3
    //   221: aload_2
    //   222: astore_1
    //   223: aload_3
    //   224: invokevirtual 135	java/lang/Exception:printStackTrace	()V
    //   227: aload_2
    //   228: ifnull -218 -> 10
    //   231: aload_2
    //   232: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   235: return
    //   236: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq +31 -> 270
    //   242: ldc 49
    //   244: iconst_2
    //   245: new 65	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   252: ldc -113
    //   254: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload_3
    //   258: invokevirtual 144	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   261: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: new 146	org/json/JSONObject
    //   273: dup
    //   274: aload_3
    //   275: invokevirtual 144	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   278: invokespecial 147	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   281: ldc -107
    //   283: invokevirtual 153	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   286: ldc -101
    //   288: invokevirtual 159	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   291: istore 6
    //   293: aload_0
    //   294: getfield 12	yee:a	Lcooperation/plugin/PluginPreInstaller;
    //   297: invokestatic 162	cooperation/plugin/PluginPreInstaller:a	(Lcooperation/plugin/PluginPreInstaller;)Landroid/content/Context;
    //   300: iload 6
    //   302: iconst_1
    //   303: invokestatic 167	cooperation/qqreader/QRUtility:a	(Landroid/content/Context;IZ)V
    //   306: aload_2
    //   307: ifnull -297 -> 10
    //   310: aload_2
    //   311: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   314: return
    //   315: astore_3
    //   316: aload_1
    //   317: astore_2
    //   318: aload_3
    //   319: astore_1
    //   320: aload_2
    //   321: ifnull +7 -> 328
    //   324: aload_2
    //   325: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   328: aload_1
    //   329: athrow
    //   330: astore_1
    //   331: goto -11 -> 320
    //   334: astore_3
    //   335: aload 4
    //   337: astore_2
    //   338: goto -117 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	yee
    //   50	279	1	localObject1	Object
    //   330	1	1	localObject2	Object
    //   45	293	2	localObject3	Object
    //   21	190	3	localObject4	Object
    //   220	55	3	localException1	Exception
    //   315	4	3	localObject5	Object
    //   334	1	3	localException2	Exception
    //   47	289	4	str1	String
    //   61	91	5	str2	String
    //   291	10	6	i	int
    // Exception table:
    //   from	to	target	type
    //   104	199	220	java/lang/Exception
    //   199	205	220	java/lang/Exception
    //   210	217	220	java/lang/Exception
    //   236	270	220	java/lang/Exception
    //   270	306	220	java/lang/Exception
    //   51	63	315	finally
    //   65	104	315	finally
    //   223	227	315	finally
    //   104	199	330	finally
    //   199	205	330	finally
    //   210	217	330	finally
    //   236	270	330	finally
    //   270	306	330	finally
    //   51	63	334	java/lang/Exception
    //   65	104	334	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */