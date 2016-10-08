import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class lmj
  implements Runnable
{
  WeakReference a;
  
  public lmj(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramFriendProfileCardActivity);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	lmj:a	Ljava/lang/ref/WeakReference;
    //   4: ifnull +188 -> 192
    //   7: aload_0
    //   8: getfield 26	lmj:a	Ljava/lang/ref/WeakReference;
    //   11: invokevirtual 34	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   14: checkcast 36	com/tencent/mobileqq/activity/FriendProfileCardActivity
    //   17: astore_3
    //   18: aload_3
    //   19: ifnull +173 -> 192
    //   22: ldc 38
    //   24: invokestatic 43	com/tencent/mobileqq/vas/IndividuationUrlHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore_1
    //   28: new 45	java/lang/StringBuffer
    //   31: dup
    //   32: invokespecial 46	java/lang/StringBuffer:<init>	()V
    //   35: astore 4
    //   37: new 48	java/net/URL
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 51	java/net/URL:<init>	(Ljava/lang/String;)V
    //   45: invokevirtual 55	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   48: checkcast 57	java/net/HttpURLConnection
    //   51: astore_2
    //   52: aload_2
    //   53: astore_1
    //   54: aload_2
    //   55: sipush 5000
    //   58: invokevirtual 61	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   61: aload_2
    //   62: astore_1
    //   63: aload_2
    //   64: sipush 10000
    //   67: invokevirtual 64	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   70: aload_2
    //   71: astore_1
    //   72: aload_2
    //   73: ldc 66
    //   75: invokevirtual 69	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   78: aload_2
    //   79: astore_1
    //   80: aload_2
    //   81: invokevirtual 72	java/net/HttpURLConnection:connect	()V
    //   84: aload_2
    //   85: astore_1
    //   86: aload_2
    //   87: invokevirtual 76	java/net/HttpURLConnection:getResponseCode	()I
    //   90: sipush 200
    //   93: if_icmpne +100 -> 193
    //   96: aload_2
    //   97: astore_1
    //   98: new 78	java/io/BufferedReader
    //   101: dup
    //   102: new 80	java/io/InputStreamReader
    //   105: dup
    //   106: aload_2
    //   107: invokevirtual 84	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   110: invokespecial 87	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   113: invokespecial 90	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   116: astore 5
    //   118: aload_2
    //   119: astore_1
    //   120: aload 5
    //   122: invokevirtual 94	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   125: astore 6
    //   127: aload 6
    //   129: ifnull +64 -> 193
    //   132: aload_2
    //   133: astore_1
    //   134: aload 4
    //   136: aload 6
    //   138: invokevirtual 98	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   141: pop
    //   142: goto -24 -> 118
    //   145: astore_3
    //   146: aload_2
    //   147: astore_1
    //   148: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +33 -> 184
    //   154: aload_2
    //   155: astore_1
    //   156: ldc 106
    //   158: iconst_2
    //   159: new 108	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   166: ldc 111
    //   168: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_3
    //   172: invokevirtual 117	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   175: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload_2
    //   185: ifnull +7 -> 192
    //   188: aload_2
    //   189: invokevirtual 127	java/net/HttpURLConnection:disconnect	()V
    //   192: return
    //   193: aload_2
    //   194: astore_1
    //   195: new 129	org/json/JSONArray
    //   198: dup
    //   199: aload 4
    //   201: invokevirtual 130	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   204: invokespecial 131	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   207: iconst_0
    //   208: invokevirtual 135	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   211: ldc -119
    //   213: invokevirtual 142	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   216: astore 4
    //   218: aload_2
    //   219: astore_1
    //   220: aload 4
    //   222: invokestatic 148	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   225: ifne +73 -> 298
    //   228: aload_2
    //   229: astore_1
    //   230: aload_3
    //   231: getfield 152	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   234: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   237: invokeinterface 164 1 0
    //   242: astore_3
    //   243: aload_2
    //   244: astore_1
    //   245: aload_3
    //   246: ldc -90
    //   248: aload 4
    //   250: invokeinterface 172 3 0
    //   255: pop
    //   256: aload_2
    //   257: astore_1
    //   258: aload_3
    //   259: ldc -82
    //   261: new 176	java/text/SimpleDateFormat
    //   264: dup
    //   265: ldc -78
    //   267: invokespecial 179	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   270: new 181	java/util/Date
    //   273: dup
    //   274: invokestatic 187	java/lang/System:currentTimeMillis	()J
    //   277: invokespecial 190	java/util/Date:<init>	(J)V
    //   280: invokevirtual 194	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   283: invokeinterface 172 3 0
    //   288: pop
    //   289: aload_2
    //   290: astore_1
    //   291: aload_3
    //   292: invokeinterface 197 1 0
    //   297: pop
    //   298: aload_2
    //   299: ifnull -107 -> 192
    //   302: aload_2
    //   303: invokevirtual 127	java/net/HttpURLConnection:disconnect	()V
    //   306: return
    //   307: astore_2
    //   308: aconst_null
    //   309: astore_1
    //   310: aload_1
    //   311: ifnull +7 -> 318
    //   314: aload_1
    //   315: invokevirtual 127	java/net/HttpURLConnection:disconnect	()V
    //   318: aload_2
    //   319: athrow
    //   320: astore_2
    //   321: goto -11 -> 310
    //   324: astore_3
    //   325: aconst_null
    //   326: astore_2
    //   327: goto -181 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	this	lmj
    //   27	288	1	localObject1	Object
    //   51	252	2	localHttpURLConnection	java.net.HttpURLConnection
    //   307	12	2	localObject2	Object
    //   320	1	2	localObject3	Object
    //   326	1	2	localObject4	Object
    //   17	2	3	localFriendProfileCardActivity	FriendProfileCardActivity
    //   145	86	3	localException1	Exception
    //   242	50	3	localEditor	android.content.SharedPreferences.Editor
    //   324	1	3	localException2	Exception
    //   35	214	4	localObject5	Object
    //   116	5	5	localBufferedReader	java.io.BufferedReader
    //   125	12	6	str	String
    // Exception table:
    //   from	to	target	type
    //   54	61	145	java/lang/Exception
    //   63	70	145	java/lang/Exception
    //   72	78	145	java/lang/Exception
    //   80	84	145	java/lang/Exception
    //   86	96	145	java/lang/Exception
    //   98	118	145	java/lang/Exception
    //   120	127	145	java/lang/Exception
    //   134	142	145	java/lang/Exception
    //   195	218	145	java/lang/Exception
    //   220	228	145	java/lang/Exception
    //   230	243	145	java/lang/Exception
    //   245	256	145	java/lang/Exception
    //   258	289	145	java/lang/Exception
    //   291	298	145	java/lang/Exception
    //   37	52	307	finally
    //   54	61	320	finally
    //   63	70	320	finally
    //   72	78	320	finally
    //   80	84	320	finally
    //   86	96	320	finally
    //   98	118	320	finally
    //   120	127	320	finally
    //   134	142	320	finally
    //   148	154	320	finally
    //   156	184	320	finally
    //   195	218	320	finally
    //   220	228	320	finally
    //   230	243	320	finally
    //   245	256	320	finally
    //   258	289	320	finally
    //   291	298	320	finally
    //   37	52	324	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lmj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */