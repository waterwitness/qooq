package cooperation.qqhotspot;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.concurrent.Executor;

public class HttpCgiAsync
  extends AsyncTask
{
  public static final String a = "response_code";
  public static final String b = "response_location";
  public static final String c = "response_parm";
  private HttpCgiAsync.Callback jdField_a_of_type_CooperationQqhotspotHttpCgiAsync$Callback;
  private boolean jdField_a_of_type_Boolean;
  private final String d;
  private String e;
  
  public HttpCgiAsync(String paramString, boolean paramBoolean, HttpCgiAsync.Callback paramCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = getClass().getSimpleName();
    this.jdField_a_of_type_Boolean = true;
    this.e = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_CooperationQqhotspotHttpCgiAsync$Callback = paramCallback;
  }
  
  /* Error */
  private Bundle a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 54	java/net/URL
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 57	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: invokevirtual 61	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   14: checkcast 63	java/net/HttpURLConnection
    //   17: astore_3
    //   18: iload 5
    //   20: istore 6
    //   22: aload_3
    //   23: sipush 10000
    //   26: invokevirtual 67	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   29: iload 5
    //   31: istore 6
    //   33: aload_3
    //   34: sipush 15000
    //   37: invokevirtual 70	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   40: iload 5
    //   42: istore 6
    //   44: aload_3
    //   45: ldc 72
    //   47: invokevirtual 75	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   50: iload 5
    //   52: istore 6
    //   54: aload_0
    //   55: getfield 44	cooperation/qqhotspot/HttpCgiAsync:jdField_a_of_type_Boolean	Z
    //   58: ifeq +356 -> 414
    //   61: iload 5
    //   63: istore 6
    //   65: aload_3
    //   66: iconst_1
    //   67: invokevirtual 79	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   70: iload 5
    //   72: istore 6
    //   74: aload_3
    //   75: iconst_1
    //   76: invokevirtual 82	java/net/HttpURLConnection:setDoInput	(Z)V
    //   79: iload 5
    //   81: istore 6
    //   83: invokestatic 88	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   86: ldc 90
    //   88: invokevirtual 94	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   91: checkcast 96	android/net/wifi/WifiManager
    //   94: invokevirtual 100	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   97: astore_2
    //   98: aload_2
    //   99: ifnull +138 -> 237
    //   102: iload 5
    //   104: istore 6
    //   106: aload_2
    //   107: invokevirtual 106	android/net/wifi/WifiInfo:getIpAddress	()I
    //   110: istore 7
    //   112: iload 5
    //   114: istore 6
    //   116: new 108	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   123: iload 7
    //   125: sipush 255
    //   128: iand
    //   129: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: bipush 46
    //   134: invokevirtual 116	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   137: iload 7
    //   139: bipush 8
    //   141: ishr
    //   142: sipush 255
    //   145: iand
    //   146: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: bipush 46
    //   151: invokevirtual 116	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   154: iload 7
    //   156: bipush 16
    //   158: ishr
    //   159: sipush 255
    //   162: iand
    //   163: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: bipush 46
    //   168: invokevirtual 116	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   171: iload 7
    //   173: bipush 24
    //   175: ishr
    //   176: sipush 255
    //   179: iand
    //   180: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: astore_2
    //   187: iload 5
    //   189: istore 6
    //   191: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +43 -> 237
    //   197: iload 5
    //   199: istore 6
    //   201: aload_0
    //   202: getfield 42	cooperation/qqhotspot/HttpCgiAsync:d	Ljava/lang/String;
    //   205: iconst_2
    //   206: new 108	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   213: ldc 127
    //   215: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_1
    //   219: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc -124
    //   224: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_2
    //   228: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 136	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: iload 5
    //   239: istore 6
    //   241: aload_3
    //   242: invokevirtual 139	java/net/HttpURLConnection:connect	()V
    //   245: iload 5
    //   247: istore 6
    //   249: aload_3
    //   250: invokevirtual 142	java/net/HttpURLConnection:getResponseCode	()I
    //   253: istore 5
    //   255: iload 5
    //   257: sipush 301
    //   260: if_icmpeq +11 -> 271
    //   263: iload 5
    //   265: sipush 302
    //   268: if_icmpne +282 -> 550
    //   271: iload 5
    //   273: istore 6
    //   275: aload_3
    //   276: invokevirtual 146	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   279: invokeinterface 152 1 0
    //   284: invokeinterface 158 1 0
    //   289: astore_2
    //   290: iload 5
    //   292: istore 6
    //   294: aload_2
    //   295: invokeinterface 163 1 0
    //   300: ifeq +250 -> 550
    //   303: iload 5
    //   305: istore 6
    //   307: aload_2
    //   308: invokeinterface 167 1 0
    //   313: checkcast 169	java/lang/String
    //   316: astore 4
    //   318: iload 5
    //   320: istore 6
    //   322: ldc -85
    //   324: aload 4
    //   326: invokevirtual 175	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   329: ifeq -39 -> 290
    //   332: iload 5
    //   334: istore 6
    //   336: aload_3
    //   337: aload 4
    //   339: invokevirtual 179	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   342: astore_2
    //   343: aload_3
    //   344: invokevirtual 183	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   347: astore 4
    //   349: aload_3
    //   350: invokevirtual 186	java/net/HttpURLConnection:getContentLength	()I
    //   353: istore 6
    //   355: iload 6
    //   357: iconst_m1
    //   358: if_icmpeq +131 -> 489
    //   361: aload_0
    //   362: aload 4
    //   364: iload 6
    //   366: invokespecial 189	cooperation/qqhotspot/HttpCgiAsync:a	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   369: astore 4
    //   371: aload 4
    //   373: astore_1
    //   374: aload_3
    //   375: ifnull +172 -> 547
    //   378: aload_3
    //   379: invokevirtual 192	java/net/HttpURLConnection:disconnect	()V
    //   382: new 194	android/os/Bundle
    //   385: dup
    //   386: invokespecial 195	android/os/Bundle:<init>	()V
    //   389: astore_3
    //   390: aload_3
    //   391: ldc 8
    //   393: iload 5
    //   395: invokevirtual 199	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   398: aload_3
    //   399: ldc 11
    //   401: aload_2
    //   402: invokevirtual 203	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   405: aload_3
    //   406: ldc 14
    //   408: aload_1
    //   409: invokevirtual 203	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   412: aload_3
    //   413: areturn
    //   414: iload 5
    //   416: istore 6
    //   418: aload_3
    //   419: iconst_0
    //   420: invokevirtual 79	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   423: goto -353 -> 70
    //   426: astore 4
    //   428: ldc -51
    //   430: astore_2
    //   431: iload 6
    //   433: istore 5
    //   435: aload_0
    //   436: getfield 42	cooperation/qqhotspot/HttpCgiAsync:d	Ljava/lang/String;
    //   439: iconst_1
    //   440: new 108	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   447: ldc -49
    //   449: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload_1
    //   453: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: ldc -47
    //   458: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload 4
    //   463: invokevirtual 210	java/lang/Exception:toString	()Ljava/lang/String;
    //   466: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 212	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: aload_3
    //   476: ifnull +65 -> 541
    //   479: aload_3
    //   480: invokevirtual 192	java/net/HttpURLConnection:disconnect	()V
    //   483: ldc -51
    //   485: astore_1
    //   486: goto -104 -> 382
    //   489: aload 4
    //   491: invokestatic 215	cooperation/qqhotspot/HttpCgiAsync:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   494: astore 4
    //   496: aload 4
    //   498: astore_1
    //   499: goto -125 -> 374
    //   502: astore_1
    //   503: aconst_null
    //   504: astore_3
    //   505: aload_3
    //   506: ifnull +7 -> 513
    //   509: aload_3
    //   510: invokevirtual 192	java/net/HttpURLConnection:disconnect	()V
    //   513: aload_1
    //   514: athrow
    //   515: astore_1
    //   516: goto -11 -> 505
    //   519: astore_1
    //   520: goto -15 -> 505
    //   523: astore 4
    //   525: iconst_0
    //   526: istore 5
    //   528: ldc -51
    //   530: astore_2
    //   531: aconst_null
    //   532: astore_3
    //   533: goto -98 -> 435
    //   536: astore 4
    //   538: goto -103 -> 435
    //   541: ldc -51
    //   543: astore_1
    //   544: goto -162 -> 382
    //   547: goto -165 -> 382
    //   550: ldc -51
    //   552: astore_2
    //   553: goto -210 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	556	0	this	HttpCgiAsync
    //   0	556	1	paramString	String
    //   97	456	2	localObject1	Object
    //   17	516	3	localObject2	Object
    //   316	56	4	localObject3	Object
    //   426	64	4	localException1	Exception
    //   494	3	4	str	String
    //   523	1	4	localException2	Exception
    //   536	1	4	localException3	Exception
    //   1	526	5	i	int
    //   20	412	6	j	int
    //   110	66	7	k	int
    // Exception table:
    //   from	to	target	type
    //   22	29	426	java/lang/Exception
    //   33	40	426	java/lang/Exception
    //   44	50	426	java/lang/Exception
    //   54	61	426	java/lang/Exception
    //   65	70	426	java/lang/Exception
    //   74	79	426	java/lang/Exception
    //   83	98	426	java/lang/Exception
    //   106	112	426	java/lang/Exception
    //   116	187	426	java/lang/Exception
    //   191	197	426	java/lang/Exception
    //   201	237	426	java/lang/Exception
    //   241	245	426	java/lang/Exception
    //   249	255	426	java/lang/Exception
    //   275	290	426	java/lang/Exception
    //   294	303	426	java/lang/Exception
    //   307	318	426	java/lang/Exception
    //   322	332	426	java/lang/Exception
    //   336	343	426	java/lang/Exception
    //   418	423	426	java/lang/Exception
    //   3	18	502	finally
    //   22	29	515	finally
    //   33	40	515	finally
    //   44	50	515	finally
    //   54	61	515	finally
    //   65	70	515	finally
    //   74	79	515	finally
    //   83	98	515	finally
    //   106	112	515	finally
    //   116	187	515	finally
    //   191	197	515	finally
    //   201	237	515	finally
    //   241	245	515	finally
    //   249	255	515	finally
    //   275	290	515	finally
    //   294	303	515	finally
    //   307	318	515	finally
    //   322	332	515	finally
    //   336	343	515	finally
    //   343	355	515	finally
    //   361	371	515	finally
    //   418	423	515	finally
    //   489	496	515	finally
    //   435	475	519	finally
    //   3	18	523	java/lang/Exception
    //   343	355	536	java/lang/Exception
    //   361	371	536	java/lang/Exception
    //   489	496	536	java/lang/Exception
  }
  
  public static String a(InputStream paramInputStream)
  {
    paramInputStream = new BufferedInputStream(paramInputStream);
    Object localObject = new byte['Ѐ'];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = paramInputStream.read((byte[])localObject);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write((byte[])localObject, 0, i);
    }
    localObject = new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
    paramInputStream.close();
    return (String)localObject;
  }
  
  private String a(InputStream paramInputStream, int paramInt)
  {
    paramInputStream = new InputStreamReader(paramInputStream, "UTF-8");
    char[] arrayOfChar = new char[paramInt];
    paramInputStream.read(arrayOfChar);
    return new String(arrayOfChar);
  }
  
  private Executor a()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return AsyncTask.THREAD_POOL_EXECUTOR;
    }
    return null;
  }
  
  protected Bundle a(String... paramVarArgs)
  {
    if ((paramVarArgs[0] == null) || (!(paramVarArgs[0] instanceof String))) {
      return null;
    }
    try
    {
      paramVarArgs = a(paramVarArgs[0]);
      return paramVarArgs;
    }
    catch (IOException paramVarArgs) {}
    return null;
  }
  
  public void a()
  {
    Executor localExecutor = a();
    if (localExecutor != null)
    {
      executeOnExecutor(localExecutor, new String[] { this.e });
      return;
    }
    execute(new String[] { this.e });
  }
  
  protected void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    while (this.jdField_a_of_type_CooperationQqhotspotHttpCgiAsync$Callback == null) {
      return;
    }
    this.jdField_a_of_type_CooperationQqhotspotHttpCgiAsync$Callback.a(paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\HttpCgiAsync.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */