package com.tencent.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ZipUtil
{
  public static final int a = 4096;
  
  public ZipUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_3
    //   5: iconst_0
    //   6: istore 7
    //   8: aload_1
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: new 25	java/io/File
    //   16: dup
    //   17: aload_2
    //   18: invokespecial 28	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: invokevirtual 32	java/io/File:listFiles	()[Ljava/io/File;
    //   24: astore 4
    //   26: aload 4
    //   28: ifnull +33 -> 61
    //   31: aload 4
    //   33: arraylength
    //   34: istore 8
    //   36: iload 7
    //   38: iload 8
    //   40: if_icmpge +21 -> 61
    //   43: aload 4
    //   45: iload 7
    //   47: aaload
    //   48: invokevirtual 36	java/io/File:delete	()Z
    //   51: pop
    //   52: iload 7
    //   54: iconst_1
    //   55: iadd
    //   56: istore 7
    //   58: goto -22 -> 36
    //   61: new 38	java/util/zip/ZipInputStream
    //   64: dup
    //   65: new 40	java/io/BufferedInputStream
    //   68: dup
    //   69: aload_0
    //   70: invokevirtual 46	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   73: aload_1
    //   74: invokevirtual 52	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   77: invokespecial 55	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   80: invokespecial 56	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   83: astore 5
    //   85: aconst_null
    //   86: astore_0
    //   87: aload 5
    //   89: invokevirtual 60	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +331 -> 425
    //   97: sipush 4096
    //   100: newarray <illegal type>
    //   102: astore 4
    //   104: aload_1
    //   105: invokevirtual 66	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   108: astore_1
    //   109: aload_1
    //   110: ifnull +67 -> 177
    //   113: aload_1
    //   114: ldc 68
    //   116: invokevirtual 74	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   119: istore 9
    //   121: iload 9
    //   123: ifeq +54 -> 177
    //   126: aload_0
    //   127: ifnull +11 -> 138
    //   130: aload_0
    //   131: invokevirtual 79	java/io/BufferedOutputStream:flush	()V
    //   134: aload_0
    //   135: invokevirtual 82	java/io/BufferedOutputStream:close	()V
    //   138: iconst_0
    //   139: ifeq -52 -> 87
    //   142: new 84	java/lang/NullPointerException
    //   145: dup
    //   146: invokespecial 85	java/lang/NullPointerException:<init>	()V
    //   149: athrow
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   155: goto -68 -> 87
    //   158: astore_0
    //   159: aload 5
    //   161: astore_0
    //   162: aload_0
    //   163: ifnull -151 -> 12
    //   166: aload_0
    //   167: invokevirtual 89	java/util/zip/ZipInputStream:close	()V
    //   170: return
    //   171: astore_0
    //   172: aload_0
    //   173: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   176: return
    //   177: new 25	java/io/File
    //   180: dup
    //   181: new 91	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   188: aload_2
    //   189: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_1
    //   193: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokespecial 28	java/io/File:<init>	(Ljava/lang/String;)V
    //   202: astore_1
    //   203: new 25	java/io/File
    //   206: dup
    //   207: aload_1
    //   208: invokevirtual 102	java/io/File:getParent	()Ljava/lang/String;
    //   211: invokespecial 28	java/io/File:<init>	(Ljava/lang/String;)V
    //   214: astore_3
    //   215: aload_3
    //   216: invokevirtual 105	java/io/File:exists	()Z
    //   219: ifne +8 -> 227
    //   222: aload_3
    //   223: invokevirtual 108	java/io/File:mkdirs	()Z
    //   226: pop
    //   227: new 110	java/io/FileOutputStream
    //   230: dup
    //   231: aload_1
    //   232: invokespecial 113	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   235: astore_1
    //   236: new 76	java/io/BufferedOutputStream
    //   239: dup
    //   240: aload_1
    //   241: sipush 4096
    //   244: invokespecial 116	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   247: astore_3
    //   248: aload 5
    //   250: aload 4
    //   252: iconst_0
    //   253: sipush 4096
    //   256: invokevirtual 120	java/util/zip/ZipInputStream:read	([BII)I
    //   259: istore 7
    //   261: iload 7
    //   263: iconst_m1
    //   264: if_icmpeq +54 -> 318
    //   267: aload_3
    //   268: aload 4
    //   270: iconst_0
    //   271: iload 7
    //   273: invokevirtual 124	java/io/BufferedOutputStream:write	([BII)V
    //   276: goto -28 -> 248
    //   279: astore_0
    //   280: aload_3
    //   281: astore_0
    //   282: aload_0
    //   283: ifnull +11 -> 294
    //   286: aload_0
    //   287: invokevirtual 79	java/io/BufferedOutputStream:flush	()V
    //   290: aload_0
    //   291: invokevirtual 82	java/io/BufferedOutputStream:close	()V
    //   294: aload_0
    //   295: astore 4
    //   297: aload_1
    //   298: ifnull +14 -> 312
    //   301: aload_1
    //   302: invokevirtual 125	java/io/FileOutputStream:flush	()V
    //   305: aload_1
    //   306: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   309: aload_0
    //   310: astore 4
    //   312: aload 4
    //   314: astore_0
    //   315: goto -228 -> 87
    //   318: aload_3
    //   319: ifnull +11 -> 330
    //   322: aload_3
    //   323: invokevirtual 79	java/io/BufferedOutputStream:flush	()V
    //   326: aload_3
    //   327: invokevirtual 82	java/io/BufferedOutputStream:close	()V
    //   330: aload_3
    //   331: astore 4
    //   333: aload_1
    //   334: ifnull -22 -> 312
    //   337: aload_1
    //   338: invokevirtual 125	java/io/FileOutputStream:flush	()V
    //   341: aload_1
    //   342: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   345: aload_3
    //   346: astore 4
    //   348: goto -36 -> 312
    //   351: astore_0
    //   352: aload_0
    //   353: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   356: aload_3
    //   357: astore 4
    //   359: goto -47 -> 312
    //   362: astore_0
    //   363: aload 5
    //   365: ifnull +8 -> 373
    //   368: aload 5
    //   370: invokevirtual 89	java/util/zip/ZipInputStream:close	()V
    //   373: aload_0
    //   374: athrow
    //   375: astore_1
    //   376: aload_1
    //   377: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   380: aload_0
    //   381: astore 4
    //   383: goto -71 -> 312
    //   386: astore_0
    //   387: aload_1
    //   388: astore_2
    //   389: aload_0
    //   390: astore_1
    //   391: aload_3
    //   392: ifnull +11 -> 403
    //   395: aload_3
    //   396: invokevirtual 79	java/io/BufferedOutputStream:flush	()V
    //   399: aload_3
    //   400: invokevirtual 82	java/io/BufferedOutputStream:close	()V
    //   403: aload_2
    //   404: ifnull +11 -> 415
    //   407: aload_2
    //   408: invokevirtual 125	java/io/FileOutputStream:flush	()V
    //   411: aload_2
    //   412: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   415: aload_1
    //   416: athrow
    //   417: astore_0
    //   418: aload_0
    //   419: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   422: goto -7 -> 415
    //   425: aload 5
    //   427: ifnull -415 -> 12
    //   430: aload 5
    //   432: invokevirtual 89	java/util/zip/ZipInputStream:close	()V
    //   435: return
    //   436: astore_0
    //   437: aload_0
    //   438: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   441: return
    //   442: astore_1
    //   443: aload_1
    //   444: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   447: goto -74 -> 373
    //   450: astore_0
    //   451: aconst_null
    //   452: astore 5
    //   454: goto -91 -> 363
    //   457: astore_0
    //   458: aload_3
    //   459: astore_0
    //   460: goto -298 -> 162
    //   463: astore_1
    //   464: aload 6
    //   466: astore_2
    //   467: aload_0
    //   468: astore_3
    //   469: goto -78 -> 391
    //   472: astore_3
    //   473: aload_1
    //   474: astore_2
    //   475: aload_3
    //   476: astore_1
    //   477: aload_0
    //   478: astore_3
    //   479: goto -88 -> 391
    //   482: astore_1
    //   483: aconst_null
    //   484: astore_1
    //   485: goto -203 -> 282
    //   488: astore_3
    //   489: goto -207 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	492	0	paramContext	android.content.Context
    //   0	492	1	paramString1	String
    //   0	492	2	paramString2	String
    //   4	465	3	localObject1	Object
    //   472	4	3	localObject2	Object
    //   478	1	3	localContext	android.content.Context
    //   488	1	3	localException	Exception
    //   24	358	4	localObject3	Object
    //   83	370	5	localZipInputStream	java.util.zip.ZipInputStream
    //   1	464	6	localObject4	Object
    //   6	266	7	i	int
    //   34	7	8	j	int
    //   119	3	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   130	138	150	java/io/IOException
    //   142	150	150	java/io/IOException
    //   87	93	158	java/lang/Exception
    //   130	138	158	java/lang/Exception
    //   142	150	158	java/lang/Exception
    //   151	155	158	java/lang/Exception
    //   286	294	158	java/lang/Exception
    //   301	309	158	java/lang/Exception
    //   322	330	158	java/lang/Exception
    //   337	345	158	java/lang/Exception
    //   352	356	158	java/lang/Exception
    //   376	380	158	java/lang/Exception
    //   395	403	158	java/lang/Exception
    //   407	415	158	java/lang/Exception
    //   415	417	158	java/lang/Exception
    //   418	422	158	java/lang/Exception
    //   166	170	171	java/io/IOException
    //   248	261	279	java/lang/Exception
    //   267	276	279	java/lang/Exception
    //   322	330	351	java/io/IOException
    //   337	345	351	java/io/IOException
    //   87	93	362	finally
    //   130	138	362	finally
    //   142	150	362	finally
    //   151	155	362	finally
    //   286	294	362	finally
    //   301	309	362	finally
    //   322	330	362	finally
    //   337	345	362	finally
    //   352	356	362	finally
    //   376	380	362	finally
    //   395	403	362	finally
    //   407	415	362	finally
    //   415	417	362	finally
    //   418	422	362	finally
    //   286	294	375	java/io/IOException
    //   301	309	375	java/io/IOException
    //   248	261	386	finally
    //   267	276	386	finally
    //   395	403	417	java/io/IOException
    //   407	415	417	java/io/IOException
    //   430	435	436	java/io/IOException
    //   368	373	442	java/io/IOException
    //   13	26	450	finally
    //   31	36	450	finally
    //   43	52	450	finally
    //   61	85	450	finally
    //   13	26	457	java/lang/Exception
    //   31	36	457	java/lang/Exception
    //   43	52	457	java/lang/Exception
    //   61	85	457	java/lang/Exception
    //   97	109	463	finally
    //   113	121	463	finally
    //   177	227	463	finally
    //   227	236	463	finally
    //   236	248	472	finally
    //   97	109	482	java/lang/Exception
    //   113	121	482	java/lang/Exception
    //   177	227	482	java/lang/Exception
    //   227	236	482	java/lang/Exception
    //   236	248	488	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\util\ZipUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */