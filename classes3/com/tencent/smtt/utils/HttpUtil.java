package com.tencent.smtt.utils;

import java.io.Closeable;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Map;

public class HttpUtil
{
  public static final String DEFAULT_ENCODE_NAME = "utf-8";
  private static final int DEFAULT_TIME_OUT = 20000;
  
  private static void closeStream(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  /* Error */
  private static String httpPost(HttpURLConnection paramHttpURLConnection, HttpResponseListener paramHttpResponseListener, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: invokevirtual 38	java/net/HttpURLConnection:getResponseCode	()I
    //   9: istore 5
    //   11: aload_1
    //   12: ifnull +11 -> 23
    //   15: aload_1
    //   16: iload 5
    //   18: invokeinterface 42 2 0
    //   23: iload 5
    //   25: sipush 200
    //   28: if_icmpne +242 -> 270
    //   31: aload_0
    //   32: invokevirtual 46	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   35: astore_1
    //   36: aload_0
    //   37: invokevirtual 50	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   40: astore_0
    //   41: aload_0
    //   42: ifnull +84 -> 126
    //   45: aload_0
    //   46: ldc 52
    //   48: invokevirtual 58	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   51: ifeq +75 -> 126
    //   54: new 60	java/util/zip/GZIPInputStream
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 63	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   62: astore_0
    //   63: new 65	java/io/ByteArrayOutputStream
    //   66: dup
    //   67: invokespecial 66	java/io/ByteArrayOutputStream:<init>	()V
    //   70: astore_1
    //   71: sipush 128
    //   74: newarray <illegal type>
    //   76: astore_3
    //   77: aload_0
    //   78: aload_3
    //   79: invokevirtual 72	java/io/InputStream:read	([B)I
    //   82: istore 5
    //   84: iload 5
    //   86: iconst_m1
    //   87: if_icmpeq +85 -> 172
    //   90: aload_1
    //   91: aload_3
    //   92: iconst_0
    //   93: iload 5
    //   95: invokevirtual 76	java/io/ByteArrayOutputStream:write	([BII)V
    //   98: goto -21 -> 77
    //   101: astore 4
    //   103: aload_1
    //   104: astore_3
    //   105: aload_0
    //   106: astore_1
    //   107: aload_3
    //   108: astore_0
    //   109: aload 4
    //   111: astore_3
    //   112: aload_3
    //   113: invokevirtual 79	java/lang/Throwable:printStackTrace	()V
    //   116: aload_1
    //   117: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   120: aload_0
    //   121: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   124: aconst_null
    //   125: areturn
    //   126: aload_0
    //   127: ifnull +40 -> 167
    //   130: aload_0
    //   131: ldc 83
    //   133: invokevirtual 58	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   136: ifeq +31 -> 167
    //   139: new 85	java/util/zip/InflaterInputStream
    //   142: dup
    //   143: aload_1
    //   144: new 87	java/util/zip/Inflater
    //   147: dup
    //   148: iconst_1
    //   149: invokespecial 90	java/util/zip/Inflater:<init>	(Z)V
    //   152: invokespecial 93	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   155: astore_0
    //   156: goto -93 -> 63
    //   159: astore_3
    //   160: aconst_null
    //   161: astore_0
    //   162: aconst_null
    //   163: astore_1
    //   164: goto -52 -> 112
    //   167: aload_1
    //   168: astore_0
    //   169: goto -106 -> 63
    //   172: iload_2
    //   173: ifeq +27 -> 200
    //   176: new 54	java/lang/String
    //   179: dup
    //   180: aload_1
    //   181: invokevirtual 97	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   184: ldc 11
    //   186: invokespecial 100	java/lang/String:<init>	([BLjava/lang/String;)V
    //   189: astore_3
    //   190: aload_0
    //   191: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   194: aload_1
    //   195: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   198: aload_3
    //   199: areturn
    //   200: new 54	java/lang/String
    //   203: dup
    //   204: invokestatic 106	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   207: aload_1
    //   208: invokevirtual 97	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   211: invokevirtual 110	com/tencent/smtt/utils/Post3DESEncryption:DesDecrypt	([B)[B
    //   214: invokespecial 113	java/lang/String:<init>	([B)V
    //   217: astore_3
    //   218: goto -28 -> 190
    //   221: astore_1
    //   222: aconst_null
    //   223: astore_0
    //   224: aload_0
    //   225: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   228: aload_3
    //   229: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   232: aload_1
    //   233: athrow
    //   234: astore_1
    //   235: goto -11 -> 224
    //   238: astore 4
    //   240: aload_1
    //   241: astore_3
    //   242: aload 4
    //   244: astore_1
    //   245: goto -21 -> 224
    //   248: astore_3
    //   249: aload_1
    //   250: astore 4
    //   252: aload_3
    //   253: astore_1
    //   254: aload_0
    //   255: astore_3
    //   256: aload 4
    //   258: astore_0
    //   259: goto -35 -> 224
    //   262: astore_3
    //   263: aload_0
    //   264: astore_1
    //   265: aconst_null
    //   266: astore_0
    //   267: goto -155 -> 112
    //   270: aconst_null
    //   271: astore_1
    //   272: aconst_null
    //   273: astore_3
    //   274: aload 4
    //   276: astore_0
    //   277: goto -87 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	paramHttpURLConnection	HttpURLConnection
    //   0	280	1	paramHttpResponseListener	HttpResponseListener
    //   0	280	2	paramBoolean	boolean
    //   1	112	3	localObject1	Object
    //   159	1	3	localThrowable1	Throwable
    //   189	53	3	localObject2	Object
    //   248	5	3	localObject3	Object
    //   255	1	3	localHttpURLConnection	HttpURLConnection
    //   262	1	3	localThrowable2	Throwable
    //   273	1	3	localObject4	Object
    //   3	1	4	localObject5	Object
    //   101	9	4	localThrowable3	Throwable
    //   238	5	4	localObject6	Object
    //   250	25	4	localHttpResponseListener	HttpResponseListener
    //   9	85	5	i	int
    // Exception table:
    //   from	to	target	type
    //   71	77	101	java/lang/Throwable
    //   77	84	101	java/lang/Throwable
    //   90	98	101	java/lang/Throwable
    //   176	190	101	java/lang/Throwable
    //   200	218	101	java/lang/Throwable
    //   5	11	159	java/lang/Throwable
    //   15	23	159	java/lang/Throwable
    //   31	41	159	java/lang/Throwable
    //   45	63	159	java/lang/Throwable
    //   130	156	159	java/lang/Throwable
    //   5	11	221	finally
    //   15	23	221	finally
    //   31	41	221	finally
    //   45	63	221	finally
    //   130	156	221	finally
    //   63	71	234	finally
    //   71	77	238	finally
    //   77	84	238	finally
    //   90	98	238	finally
    //   176	190	238	finally
    //   200	218	238	finally
    //   112	116	248	finally
    //   63	71	262	java/lang/Throwable
  }
  
  /* Error */
  private static HttpURLConnection initHttpPostURLConnection(String paramString, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: new 117	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 120	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 124	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 34	java/net/HttpURLConnection
    //   14: astore_0
    //   15: aload_0
    //   16: ldc 126
    //   18: invokevirtual 129	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   21: aload_0
    //   22: iconst_1
    //   23: invokevirtual 132	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   26: aload_0
    //   27: iconst_1
    //   28: invokevirtual 135	java/net/HttpURLConnection:setDoInput	(Z)V
    //   31: aload_0
    //   32: iconst_0
    //   33: invokevirtual 138	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   36: aload_0
    //   37: sipush 20000
    //   40: invokevirtual 141	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   43: getstatic 146	android/os/Build$VERSION:SDK_INT	I
    //   46: bipush 13
    //   48: if_icmple +80 -> 128
    //   51: aload_0
    //   52: ldc -108
    //   54: ldc -107
    //   56: invokevirtual 153	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_1
    //   60: invokeinterface 159 1 0
    //   65: invokeinterface 165 1 0
    //   70: astore_2
    //   71: aload_0
    //   72: astore_1
    //   73: aload_2
    //   74: invokeinterface 171 1 0
    //   79: ifeq +47 -> 126
    //   82: aload_2
    //   83: invokeinterface 175 1 0
    //   88: checkcast 177	java/util/Map$Entry
    //   91: astore_1
    //   92: aload_0
    //   93: aload_1
    //   94: invokeinterface 180 1 0
    //   99: checkcast 54	java/lang/String
    //   102: aload_1
    //   103: invokeinterface 183 1 0
    //   108: checkcast 54	java/lang/String
    //   111: invokevirtual 153	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: goto -43 -> 71
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_0
    //   120: aload_1
    //   121: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   124: aload_0
    //   125: astore_1
    //   126: aload_1
    //   127: areturn
    //   128: aload_0
    //   129: ldc -70
    //   131: ldc -68
    //   133: invokevirtual 153	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: goto -77 -> 59
    //   139: astore_1
    //   140: goto -20 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramString	String
    //   0	143	1	paramMap	Map<String, String>
    //   70	13	2	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   0	15	117	java/lang/Exception
    //   15	21	139	java/lang/Exception
  }
  
  public static String postData(String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte, HttpResponseListener paramHttpResponseListener, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      paramString = initHttpPostURLConnection(paramString, paramMap);
    } while (paramString == null);
    if (paramBoolean) {
      writeZipPostData(paramString, paramArrayOfByte);
    }
    for (;;)
    {
      return httpPost(paramString, paramHttpResponseListener, false);
      writePostData(paramString, paramArrayOfByte);
    }
  }
  
  /* Error */
  public static String postData(String paramString, byte[] paramArrayOfByte, HttpResponseListener paramHttpResponseListener, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_3
    //   1: ifeq +50 -> 51
    //   4: invokestatic 210	com/tencent/smtt/utils/PostEncryption:getInstance	()Lcom/tencent/smtt/utils/PostEncryption;
    //   7: invokevirtual 213	com/tencent/smtt/utils/PostEncryption:initRSAKey	()Ljava/lang/String;
    //   10: astore 4
    //   12: new 215	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   19: aload_0
    //   20: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload 4
    //   25: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: astore 4
    //   33: iload_3
    //   34: ifeq +35 -> 69
    //   37: invokestatic 210	com/tencent/smtt/utils/PostEncryption:getInstance	()Lcom/tencent/smtt/utils/PostEncryption;
    //   40: aload_1
    //   41: invokevirtual 226	com/tencent/smtt/utils/PostEncryption:DESEncrypt	([B)[B
    //   44: astore_0
    //   45: aload_0
    //   46: ifnonnull +44 -> 90
    //   49: aconst_null
    //   50: areturn
    //   51: invokestatic 106	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   54: invokevirtual 229	com/tencent/smtt/utils/Post3DESEncryption:getRSAKeyValue	()Ljava/lang/String;
    //   57: astore 4
    //   59: goto -47 -> 12
    //   62: astore_0
    //   63: aload_0
    //   64: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   67: aconst_null
    //   68: areturn
    //   69: invokestatic 106	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   72: aload_1
    //   73: invokevirtual 230	com/tencent/smtt/utils/Post3DESEncryption:DESEncrypt	([B)[B
    //   76: astore_0
    //   77: goto -32 -> 45
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   85: aload_1
    //   86: astore_0
    //   87: goto -42 -> 45
    //   90: new 232	java/util/HashMap
    //   93: dup
    //   94: invokespecial 233	java/util/HashMap:<init>	()V
    //   97: astore_1
    //   98: aload_1
    //   99: ldc -21
    //   101: ldc -19
    //   103: invokeinterface 241 3 0
    //   108: pop
    //   109: aload_1
    //   110: ldc -13
    //   112: aload_0
    //   113: arraylength
    //   114: invokestatic 247	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   117: invokeinterface 241 3 0
    //   122: pop
    //   123: aload 4
    //   125: aload_1
    //   126: invokestatic 194	com/tencent/smtt/utils/HttpUtil:initHttpPostURLConnection	(Ljava/lang/String;Ljava/util/Map;)Ljava/net/HttpURLConnection;
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull +17 -> 148
    //   134: aload_1
    //   135: aload_0
    //   136: invokestatic 203	com/tencent/smtt/utils/HttpUtil:writePostData	(Ljava/net/HttpURLConnection;[B)V
    //   139: aload_1
    //   140: aload_2
    //   141: iload_3
    //   142: invokestatic 200	com/tencent/smtt/utils/HttpUtil:httpPost	(Ljava/net/HttpURLConnection;Lcom/tencent/smtt/utils/HttpUtil$HttpResponseListener;Z)Ljava/lang/String;
    //   145: astore_0
    //   146: aload_0
    //   147: areturn
    //   148: aconst_null
    //   149: astore_0
    //   150: goto -4 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramString	String
    //   0	153	1	paramArrayOfByte	byte[]
    //   0	153	2	paramHttpResponseListener	HttpResponseListener
    //   0	153	3	paramBoolean	boolean
    //   10	114	4	str	String
    // Exception table:
    //   from	to	target	type
    //   4	12	62	java/lang/Exception
    //   12	33	62	java/lang/Exception
    //   51	59	62	java/lang/Exception
    //   37	45	80	java/lang/Exception
    //   69	77	80	java/lang/Exception
  }
  
  private static void writePostData(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
  {
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getOutputStream();
      paramHttpURLConnection.write(paramArrayOfByte);
      paramHttpURLConnection.flush();
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      paramHttpURLConnection.printStackTrace();
    }
  }
  
  /* Error */
  private static void writeZipPostData(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 260	java/util/zip/GZIPOutputStream
    //   3: dup
    //   4: new 262	java/io/BufferedOutputStream
    //   7: dup
    //   8: aload_0
    //   9: invokevirtual 251	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   12: ldc_w 263
    //   15: invokespecial 266	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   18: invokespecial 269	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: astore_2
    //   22: aload_2
    //   23: astore_0
    //   24: aload_2
    //   25: aload_1
    //   26: invokevirtual 255	java/io/OutputStream:write	([B)V
    //   29: aload_2
    //   30: astore_0
    //   31: aload_2
    //   32: invokevirtual 258	java/io/OutputStream:flush	()V
    //   35: aconst_null
    //   36: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   39: aload_2
    //   40: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   43: return
    //   44: astore_3
    //   45: aconst_null
    //   46: astore_1
    //   47: aload_1
    //   48: astore_0
    //   49: aload_3
    //   50: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   53: aconst_null
    //   54: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   57: aload_1
    //   58: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   61: return
    //   62: astore_1
    //   63: aconst_null
    //   64: astore_0
    //   65: aconst_null
    //   66: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   69: aload_0
    //   70: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   73: aload_1
    //   74: athrow
    //   75: astore_1
    //   76: goto -11 -> 65
    //   79: astore_3
    //   80: aload_2
    //   81: astore_1
    //   82: goto -35 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramHttpURLConnection	HttpURLConnection
    //   0	85	1	paramArrayOfByte	byte[]
    //   21	60	2	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   44	6	3	localException1	Exception
    //   79	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	22	44	java/lang/Exception
    //   0	22	62	finally
    //   24	29	75	finally
    //   31	35	75	finally
    //   49	53	75	finally
    //   24	29	79	java/lang/Exception
    //   31	35	79	java/lang/Exception
  }
  
  public static abstract interface HttpResponseListener
  {
    public abstract void onHttpResponseCode(int paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\utils\HttpUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */