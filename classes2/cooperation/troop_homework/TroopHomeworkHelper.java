package cooperation.troop_homework;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TroopHomeworkHelper
{
  public TroopHomeworkHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a()
  {
    String str1 = AppConstants.bC;
    long l = System.currentTimeMillis();
    String str2 = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date(l));
    return str1 + "stream" + str2 + ".amr";
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic 66	cooperation/troop_homework/TroopHomeworkHelper:a	()Ljava/lang/String;
    //   5: astore_3
    //   6: new 68	java/io/File
    //   9: dup
    //   10: aload_3
    //   11: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 4
    //   16: aload 4
    //   18: invokevirtual 73	java/io/File:exists	()Z
    //   21: ifne +27 -> 48
    //   24: aload 4
    //   26: invokevirtual 77	java/io/File:getParentFile	()Ljava/io/File;
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 73	java/io/File:exists	()Z
    //   34: ifne +8 -> 42
    //   37: aload_2
    //   38: invokevirtual 80	java/io/File:mkdirs	()Z
    //   41: pop
    //   42: aload 4
    //   44: invokevirtual 83	java/io/File:createNewFile	()Z
    //   47: pop
    //   48: new 85	java/net/URL
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 86	java/net/URL:<init>	(Ljava/lang/String;)V
    //   56: invokevirtual 90	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   59: checkcast 92	java/net/HttpURLConnection
    //   62: astore_2
    //   63: aload_2
    //   64: astore_1
    //   65: aload_2
    //   66: sipush 5000
    //   69: invokevirtual 96	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   72: aload_2
    //   73: astore_1
    //   74: aload_2
    //   75: sipush 30000
    //   78: invokevirtual 99	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   81: aload_2
    //   82: astore_1
    //   83: aload_2
    //   84: ldc 101
    //   86: invokevirtual 104	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   89: aload_2
    //   90: astore_1
    //   91: aload_2
    //   92: ldc 106
    //   94: ldc 108
    //   96: invokevirtual 112	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_2
    //   100: astore_1
    //   101: aload_2
    //   102: invokevirtual 116	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   105: astore 5
    //   107: aload_2
    //   108: astore_1
    //   109: new 118	java/io/FileOutputStream
    //   112: dup
    //   113: aload 4
    //   115: iconst_1
    //   116: invokespecial 121	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   119: astore 4
    //   121: aload_2
    //   122: astore_1
    //   123: sipush 1024
    //   126: newarray <illegal type>
    //   128: astore 6
    //   130: aload_2
    //   131: astore_1
    //   132: aload 5
    //   134: aload 6
    //   136: invokevirtual 127	java/io/InputStream:read	([B)I
    //   139: istore 7
    //   141: iload 7
    //   143: iconst_m1
    //   144: if_icmpeq +63 -> 207
    //   147: aload_2
    //   148: astore_1
    //   149: aload 4
    //   151: aload 6
    //   153: iconst_0
    //   154: iload 7
    //   156: invokevirtual 131	java/io/FileOutputStream:write	([BII)V
    //   159: goto -29 -> 130
    //   162: astore_1
    //   163: aload_2
    //   164: astore_1
    //   165: ldc -123
    //   167: iconst_2
    //   168: new 47	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   175: ldc -121
    //   177: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: aload_2
    //   191: ifnull +7 -> 198
    //   194: aload_2
    //   195: invokevirtual 144	java/net/HttpURLConnection:disconnect	()V
    //   198: aconst_null
    //   199: areturn
    //   200: astore_0
    //   201: aload_0
    //   202: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   205: aconst_null
    //   206: areturn
    //   207: aload_2
    //   208: astore_1
    //   209: aload 5
    //   211: invokevirtual 150	java/io/InputStream:close	()V
    //   214: aload_2
    //   215: astore_1
    //   216: aload 4
    //   218: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   221: aload_2
    //   222: ifnull +7 -> 229
    //   225: aload_2
    //   226: invokevirtual 144	java/net/HttpURLConnection:disconnect	()V
    //   229: aload_3
    //   230: areturn
    //   231: astore_0
    //   232: aload_1
    //   233: ifnull +7 -> 240
    //   236: aload_1
    //   237: invokevirtual 144	java/net/HttpURLConnection:disconnect	()V
    //   240: aload_0
    //   241: athrow
    //   242: astore_0
    //   243: goto -11 -> 232
    //   246: astore_1
    //   247: aconst_null
    //   248: astore_2
    //   249: goto -86 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramString	String
    //   1	148	1	localObject1	Object
    //   162	1	1	localException1	Exception
    //   164	73	1	localObject2	Object
    //   246	1	1	localException2	Exception
    //   29	220	2	localObject3	Object
    //   5	225	3	str	String
    //   14	203	4	localObject4	Object
    //   105	105	5	localInputStream	java.io.InputStream
    //   128	24	6	arrayOfByte	byte[]
    //   139	16	7	i	int
    // Exception table:
    //   from	to	target	type
    //   65	72	162	java/lang/Exception
    //   74	81	162	java/lang/Exception
    //   83	89	162	java/lang/Exception
    //   91	99	162	java/lang/Exception
    //   101	107	162	java/lang/Exception
    //   109	121	162	java/lang/Exception
    //   123	130	162	java/lang/Exception
    //   132	141	162	java/lang/Exception
    //   149	159	162	java/lang/Exception
    //   209	214	162	java/lang/Exception
    //   216	221	162	java/lang/Exception
    //   42	48	200	java/io/IOException
    //   48	63	231	finally
    //   65	72	242	finally
    //   74	81	242	finally
    //   83	89	242	finally
    //   91	99	242	finally
    //   101	107	242	finally
    //   109	121	242	finally
    //   123	130	242	finally
    //   132	141	242	finally
    //   149	159	242	finally
    //   165	190	242	finally
    //   209	214	242	finally
    //   216	221	242	finally
    //   48	63	246	java/lang/Exception
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: new 85	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 86	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 90	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 92	java/net/HttpURLConnection
    //   20: astore 6
    //   22: aload 6
    //   24: sipush 5000
    //   27: invokevirtual 96	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   30: aload 6
    //   32: sipush 30000
    //   35: invokevirtual 99	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   38: aload 6
    //   40: iconst_1
    //   41: invokevirtual 156	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   44: aload 6
    //   46: iconst_1
    //   47: invokevirtual 159	java/net/HttpURLConnection:setDoInput	(Z)V
    //   50: aload 6
    //   52: iconst_0
    //   53: invokevirtual 162	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   56: aload 6
    //   58: ldc -92
    //   60: invokevirtual 104	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   63: aload 6
    //   65: ldc 106
    //   67: ldc 108
    //   69: invokevirtual 112	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload 6
    //   74: ldc -90
    //   76: new 47	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   83: ldc -88
    //   85: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc -86
    //   90: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokevirtual 112	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload 6
    //   101: ldc -84
    //   103: new 47	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   110: ldc -82
    //   112: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_2
    //   116: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc -80
    //   121: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_3
    //   125: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokevirtual 112	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: new 178	java/io/DataOutputStream
    //   137: dup
    //   138: aload 6
    //   140: invokevirtual 182	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   143: invokespecial 185	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   146: astore 8
    //   148: new 187	java/lang/StringBuffer
    //   151: dup
    //   152: invokespecial 188	java/lang/StringBuffer:<init>	()V
    //   155: astore 7
    //   157: aload 7
    //   159: ldc -66
    //   161: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   164: ldc -61
    //   166: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   169: ldc -86
    //   171: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   174: ldc -66
    //   176: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   179: pop
    //   180: aload 7
    //   182: ldc -59
    //   184: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   187: pop
    //   188: aload 7
    //   190: new 47	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   197: ldc -57
    //   199: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: lload 4
    //   204: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   207: ldc -57
    //   209: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   218: pop
    //   219: aload 8
    //   221: aload 7
    //   223: invokevirtual 203	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   226: invokevirtual 209	java/lang/String:getBytes	()[B
    //   229: invokevirtual 214	java/io/OutputStream:write	([B)V
    //   232: aload 7
    //   234: iconst_0
    //   235: invokevirtual 217	java/lang/StringBuffer:setLength	(I)V
    //   238: aload 7
    //   240: ldc -66
    //   242: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   245: ldc -61
    //   247: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   250: ldc -86
    //   252: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   255: ldc -66
    //   257: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   260: pop
    //   261: aload 7
    //   263: new 47	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   270: ldc -37
    //   272: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_1
    //   276: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc -35
    //   281: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   290: pop
    //   291: aload_1
    //   292: ldc -33
    //   294: invokevirtual 227	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   297: ifeq +318 -> 615
    //   300: ldc -27
    //   302: astore_2
    //   303: aload_2
    //   304: ifnull +316 -> 620
    //   307: aload_2
    //   308: astore_3
    //   309: aload_2
    //   310: ldc -25
    //   312: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: ifeq +6 -> 321
    //   318: goto +302 -> 620
    //   321: aload 7
    //   323: new 47	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   330: ldc -19
    //   332: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_3
    //   336: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: ldc -17
    //   341: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   350: pop
    //   351: aload 8
    //   353: aload 7
    //   355: invokevirtual 203	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   358: invokevirtual 209	java/lang/String:getBytes	()[B
    //   361: invokevirtual 214	java/io/OutputStream:write	([B)V
    //   364: new 241	java/io/DataInputStream
    //   367: dup
    //   368: new 243	java/io/FileInputStream
    //   371: dup
    //   372: aload_1
    //   373: invokespecial 244	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   376: invokespecial 247	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   379: astore_1
    //   380: sipush 1024
    //   383: newarray <illegal type>
    //   385: astore_2
    //   386: aload_1
    //   387: aload_2
    //   388: invokevirtual 248	java/io/DataInputStream:read	([B)I
    //   391: istore 9
    //   393: iload 9
    //   395: iconst_m1
    //   396: if_icmpeq +59 -> 455
    //   399: aload 8
    //   401: aload_2
    //   402: iconst_0
    //   403: iload 9
    //   405: invokevirtual 249	java/io/OutputStream:write	([BII)V
    //   408: goto -22 -> 386
    //   411: astore_1
    //   412: aconst_null
    //   413: astore_2
    //   414: aload 6
    //   416: astore_1
    //   417: aload_1
    //   418: astore 7
    //   420: ldc -123
    //   422: iconst_2
    //   423: new 47	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   430: ldc -5
    //   432: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_0
    //   436: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload_1
    //   446: ifnull +7 -> 453
    //   449: aload_1
    //   450: invokevirtual 144	java/net/HttpURLConnection:disconnect	()V
    //   453: aload_2
    //   454: areturn
    //   455: aload_1
    //   456: invokevirtual 252	java/io/DataInputStream:close	()V
    //   459: aload 8
    //   461: new 47	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   468: ldc -2
    //   470: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: ldc -86
    //   475: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: ldc_w 256
    //   481: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: invokevirtual 209	java/lang/String:getBytes	()[B
    //   490: invokevirtual 214	java/io/OutputStream:write	([B)V
    //   493: aload 8
    //   495: invokevirtual 259	java/io/OutputStream:flush	()V
    //   498: aload 8
    //   500: invokevirtual 260	java/io/OutputStream:close	()V
    //   503: aload 7
    //   505: iconst_0
    //   506: invokevirtual 217	java/lang/StringBuffer:setLength	(I)V
    //   509: new 262	java/io/BufferedReader
    //   512: dup
    //   513: new 264	java/io/InputStreamReader
    //   516: dup
    //   517: aload 6
    //   519: invokevirtual 116	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   522: invokespecial 265	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   525: invokespecial 268	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   528: astore_1
    //   529: aload_1
    //   530: invokevirtual 271	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   533: astore_2
    //   534: aload_2
    //   535: ifnull +32 -> 567
    //   538: aload 7
    //   540: aload_2
    //   541: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   544: ldc_w 273
    //   547: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   550: pop
    //   551: goto -22 -> 529
    //   554: astore_0
    //   555: aload 6
    //   557: ifnull +8 -> 565
    //   560: aload 6
    //   562: invokevirtual 144	java/net/HttpURLConnection:disconnect	()V
    //   565: aload_0
    //   566: athrow
    //   567: aload 7
    //   569: invokevirtual 203	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   572: astore_2
    //   573: aload_1
    //   574: invokevirtual 274	java/io/BufferedReader:close	()V
    //   577: aload 6
    //   579: ifnull +34 -> 613
    //   582: aload 6
    //   584: invokevirtual 144	java/net/HttpURLConnection:disconnect	()V
    //   587: aload_2
    //   588: areturn
    //   589: astore_0
    //   590: aload 7
    //   592: astore 6
    //   594: goto -39 -> 555
    //   597: astore_1
    //   598: aconst_null
    //   599: astore_2
    //   600: aload 8
    //   602: astore_1
    //   603: goto -186 -> 417
    //   606: astore_1
    //   607: aload 6
    //   609: astore_1
    //   610: goto -193 -> 417
    //   613: aload_2
    //   614: areturn
    //   615: aconst_null
    //   616: astore_2
    //   617: goto -314 -> 303
    //   620: ldc_w 276
    //   623: astore_3
    //   624: goto -303 -> 321
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	627	0	paramString1	String
    //   0	627	1	paramString2	String
    //   0	627	2	paramString3	String
    //   0	627	3	paramString4	String
    //   0	627	4	paramLong	long
    //   20	588	6	localObject1	Object
    //   1	590	7	localObject2	Object
    //   4	597	8	localDataOutputStream	java.io.DataOutputStream
    //   391	13	9	i	int
    // Exception table:
    //   from	to	target	type
    //   22	300	411	java/lang/Exception
    //   309	318	411	java/lang/Exception
    //   321	386	411	java/lang/Exception
    //   386	393	411	java/lang/Exception
    //   399	408	411	java/lang/Exception
    //   455	529	411	java/lang/Exception
    //   529	534	411	java/lang/Exception
    //   538	551	411	java/lang/Exception
    //   567	573	411	java/lang/Exception
    //   22	300	554	finally
    //   309	318	554	finally
    //   321	386	554	finally
    //   386	393	554	finally
    //   399	408	554	finally
    //   455	529	554	finally
    //   529	534	554	finally
    //   538	551	554	finally
    //   567	573	554	finally
    //   573	577	554	finally
    //   6	22	589	finally
    //   420	445	589	finally
    //   6	22	597	java/lang/Exception
    //   573	577	606	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\troop_homework\TroopHomeworkHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */