package sm;

import android.content.Context;
import java.io.File;

public class ba
{
  /* Error */
  private static int a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 12	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 16	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 20	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: iconst_m1
    //   17: ireturn
    //   18: new 22	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 25	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_1
    //   27: aload_1
    //   28: astore_0
    //   29: aload_1
    //   30: invokevirtual 29	java/io/FileInputStream:read	()I
    //   33: pop
    //   34: aload_1
    //   35: astore_0
    //   36: aload_1
    //   37: iconst_4
    //   38: newarray <illegal type>
    //   40: invokevirtual 32	java/io/FileInputStream:read	([B)I
    //   43: pop
    //   44: aload_1
    //   45: astore_0
    //   46: bipush 16
    //   48: newarray <illegal type>
    //   50: astore_2
    //   51: aload_1
    //   52: astore_0
    //   53: aload_1
    //   54: aload_2
    //   55: invokevirtual 32	java/io/FileInputStream:read	([B)I
    //   58: bipush 16
    //   60: if_icmpne +122 -> 182
    //   63: aload_1
    //   64: astore_0
    //   65: new 34	java/io/ByteArrayOutputStream
    //   68: dup
    //   69: invokespecial 37	java/io/ByteArrayOutputStream:<init>	()V
    //   72: astore_3
    //   73: aload_1
    //   74: astore_0
    //   75: sipush 1024
    //   78: newarray <illegal type>
    //   80: astore 4
    //   82: aload_1
    //   83: astore_0
    //   84: aload_1
    //   85: aload 4
    //   87: invokevirtual 32	java/io/FileInputStream:read	([B)I
    //   90: istore 5
    //   92: iload 5
    //   94: iconst_m1
    //   95: if_icmpeq +37 -> 132
    //   98: aload_1
    //   99: astore_0
    //   100: aload_3
    //   101: aload 4
    //   103: iconst_0
    //   104: iload 5
    //   106: invokevirtual 41	java/io/ByteArrayOutputStream:write	([BII)V
    //   109: goto -27 -> 82
    //   112: astore_2
    //   113: aload_1
    //   114: astore_0
    //   115: aload_2
    //   116: astore_1
    //   117: aload_1
    //   118: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   121: aload_0
    //   122: ifnull +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 47	java/io/FileInputStream:close	()V
    //   129: bipush -2
    //   131: ireturn
    //   132: aload_1
    //   133: astore_0
    //   134: aload_3
    //   135: invokevirtual 51	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   138: invokestatic 57	sm/az:b	([B)[B
    //   141: astore 4
    //   143: aload_1
    //   144: astore_0
    //   145: aload_3
    //   146: invokevirtual 58	java/io/ByteArrayOutputStream:close	()V
    //   149: aload_1
    //   150: astore_0
    //   151: aload 4
    //   153: aload_2
    //   154: invokestatic 64	java/util/Arrays:equals	([B[B)Z
    //   157: istore 6
    //   159: iload 6
    //   161: ifeq +21 -> 182
    //   164: aload_1
    //   165: ifnull +7 -> 172
    //   168: aload_1
    //   169: invokevirtual 47	java/io/FileInputStream:close	()V
    //   172: iconst_0
    //   173: ireturn
    //   174: astore_0
    //   175: aload_0
    //   176: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   179: goto -7 -> 172
    //   182: aload_1
    //   183: ifnull -54 -> 129
    //   186: aload_1
    //   187: invokevirtual 47	java/io/FileInputStream:close	()V
    //   190: goto -61 -> 129
    //   193: astore_0
    //   194: aload_0
    //   195: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   198: goto -69 -> 129
    //   201: astore_0
    //   202: aload_0
    //   203: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   206: goto -77 -> 129
    //   209: astore_2
    //   210: aconst_null
    //   211: astore_1
    //   212: aload_1
    //   213: astore_0
    //   214: aload_2
    //   215: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   218: aload_1
    //   219: ifnull -90 -> 129
    //   222: aload_1
    //   223: invokevirtual 47	java/io/FileInputStream:close	()V
    //   226: goto -97 -> 129
    //   229: astore_0
    //   230: aload_0
    //   231: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   234: goto -105 -> 129
    //   237: astore_1
    //   238: aconst_null
    //   239: astore_0
    //   240: aload_0
    //   241: ifnull +7 -> 248
    //   244: aload_0
    //   245: invokevirtual 47	java/io/FileInputStream:close	()V
    //   248: aload_1
    //   249: athrow
    //   250: astore_0
    //   251: aload_0
    //   252: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   255: goto -7 -> 248
    //   258: astore_1
    //   259: goto -19 -> 240
    //   262: astore_1
    //   263: goto -23 -> 240
    //   266: astore_2
    //   267: goto -55 -> 212
    //   270: astore_1
    //   271: aconst_null
    //   272: astore_0
    //   273: goto -156 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramContext	Context
    //   0	276	1	paramString	String
    //   50	5	2	arrayOfByte1	byte[]
    //   112	42	2	localIOException	java.io.IOException
    //   209	6	2	localException1	Exception
    //   266	1	2	localException2	Exception
    //   72	74	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   80	72	4	arrayOfByte2	byte[]
    //   90	15	5	i	int
    //   157	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   29	34	112	java/io/IOException
    //   36	44	112	java/io/IOException
    //   46	51	112	java/io/IOException
    //   53	63	112	java/io/IOException
    //   65	73	112	java/io/IOException
    //   75	82	112	java/io/IOException
    //   84	92	112	java/io/IOException
    //   100	109	112	java/io/IOException
    //   134	143	112	java/io/IOException
    //   145	149	112	java/io/IOException
    //   151	159	112	java/io/IOException
    //   168	172	174	java/io/IOException
    //   186	190	193	java/io/IOException
    //   125	129	201	java/io/IOException
    //   18	27	209	java/lang/Exception
    //   222	226	229	java/io/IOException
    //   18	27	237	finally
    //   244	248	250	java/io/IOException
    //   29	34	258	finally
    //   36	44	258	finally
    //   46	51	258	finally
    //   53	63	258	finally
    //   65	73	258	finally
    //   75	82	258	finally
    //   84	92	258	finally
    //   100	109	258	finally
    //   134	143	258	finally
    //   145	149	258	finally
    //   151	159	258	finally
    //   214	218	258	finally
    //   117	121	262	finally
    //   29	34	266	java/lang/Exception
    //   36	44	266	java/lang/Exception
    //   46	51	266	java/lang/Exception
    //   53	63	266	java/lang/Exception
    //   65	73	266	java/lang/Exception
    //   75	82	266	java/lang/Exception
    //   84	92	266	java/lang/Exception
    //   100	109	266	java/lang/Exception
    //   134	143	266	java/lang/Exception
    //   145	149	266	java/lang/Exception
    //   151	159	266	java/lang/Exception
    //   18	27	270	java/io/IOException
  }
  
  public static int a(Context paramContext, String paramString, boolean paramBoolean)
  {
    ae localae = new ae(paramContext);
    localae.a(paramContext.getCacheDir().getAbsolutePath());
    localae.b("qqsecure.info");
    localae.a(null);
    while (localae.a(paramString, false) == -7) {}
    paramString = paramContext.getCacheDir().getAbsolutePath() + "/qqsecure.info";
    int i = a(paramContext, paramString);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = b(paramContext, paramString);
      i = j;
    } while (j != 0);
    if (paramBoolean) {
      new Thread(new bb()).start();
    }
    return 0;
  }
  
  /* Error */
  private static int b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_2
    //   8: aconst_null
    //   9: astore 6
    //   11: aconst_null
    //   12: astore 7
    //   14: aconst_null
    //   15: astore 8
    //   17: aconst_null
    //   18: astore_3
    //   19: new 12	java/io/File
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 16	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore 9
    //   29: aload 9
    //   31: invokevirtual 20	java/io/File:exists	()Z
    //   34: ifne +5 -> 39
    //   37: iconst_m1
    //   38: ireturn
    //   39: new 22	java/io/FileInputStream
    //   42: dup
    //   43: aload 9
    //   45: invokespecial 25	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: astore_1
    //   49: aload 6
    //   51: astore_2
    //   52: aload_1
    //   53: astore_3
    //   54: aload 7
    //   56: astore 4
    //   58: aload 8
    //   60: astore 5
    //   62: new 12	java/io/File
    //   65: dup
    //   66: new 96	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   73: aload_0
    //   74: invokevirtual 126	android/content/Context:getFilesDir	()Ljava/io/File;
    //   77: invokevirtual 82	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   80: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc -128
    //   85: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc -126
    //   90: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc -124
    //   95: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokespecial 16	java/io/File:<init>	(Ljava/lang/String;)V
    //   104: astore_0
    //   105: aload 6
    //   107: astore_2
    //   108: aload_1
    //   109: astore_3
    //   110: aload 7
    //   112: astore 4
    //   114: aload 8
    //   116: astore 5
    //   118: aload_0
    //   119: invokevirtual 20	java/io/File:exists	()Z
    //   122: ifeq +155 -> 277
    //   125: aload 6
    //   127: astore_2
    //   128: aload_1
    //   129: astore_3
    //   130: aload 7
    //   132: astore 4
    //   134: aload 8
    //   136: astore 5
    //   138: aload_0
    //   139: invokevirtual 135	java/io/File:delete	()Z
    //   142: pop
    //   143: aload 6
    //   145: astore_2
    //   146: aload_1
    //   147: astore_3
    //   148: aload 7
    //   150: astore 4
    //   152: aload 8
    //   154: astore 5
    //   156: new 137	java/io/FileOutputStream
    //   159: dup
    //   160: aload_0
    //   161: invokespecial 138	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   164: astore_0
    //   165: aload_0
    //   166: astore_2
    //   167: aload_1
    //   168: astore_3
    //   169: aload_0
    //   170: astore 4
    //   172: aload_0
    //   173: astore 5
    //   175: aload_1
    //   176: bipush 21
    //   178: newarray <illegal type>
    //   180: invokevirtual 32	java/io/FileInputStream:read	([B)I
    //   183: pop
    //   184: aload_0
    //   185: astore_2
    //   186: aload_1
    //   187: astore_3
    //   188: aload_0
    //   189: astore 4
    //   191: aload_0
    //   192: astore 5
    //   194: sipush 1024
    //   197: newarray <illegal type>
    //   199: astore 6
    //   201: aload_0
    //   202: astore_2
    //   203: aload_1
    //   204: astore_3
    //   205: aload_0
    //   206: astore 4
    //   208: aload_0
    //   209: astore 5
    //   211: aload_1
    //   212: aload 6
    //   214: invokevirtual 32	java/io/FileInputStream:read	([B)I
    //   217: istore 10
    //   219: iload 10
    //   221: iconst_m1
    //   222: if_icmpeq +119 -> 341
    //   225: aload_0
    //   226: astore_2
    //   227: aload_1
    //   228: astore_3
    //   229: aload_0
    //   230: astore 4
    //   232: aload_0
    //   233: astore 5
    //   235: aload_0
    //   236: aload 6
    //   238: iconst_0
    //   239: iload 10
    //   241: invokevirtual 139	java/io/FileOutputStream:write	([BII)V
    //   244: goto -43 -> 201
    //   247: astore_2
    //   248: aload_2
    //   249: invokevirtual 140	java/io/FileNotFoundException:printStackTrace	()V
    //   252: aload_1
    //   253: ifnull +7 -> 260
    //   256: aload_1
    //   257: invokevirtual 47	java/io/FileInputStream:close	()V
    //   260: aload_0
    //   261: ifnull +7 -> 268
    //   264: aload_0
    //   265: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   268: aload 9
    //   270: invokevirtual 135	java/io/File:delete	()Z
    //   273: pop
    //   274: bipush -2
    //   276: ireturn
    //   277: aload 6
    //   279: astore_2
    //   280: aload_1
    //   281: astore_3
    //   282: aload 7
    //   284: astore 4
    //   286: aload 8
    //   288: astore 5
    //   290: aload_0
    //   291: invokevirtual 144	java/io/File:getParentFile	()Ljava/io/File;
    //   294: invokevirtual 147	java/io/File:mkdirs	()Z
    //   297: pop
    //   298: aload 6
    //   300: astore_2
    //   301: aload_1
    //   302: astore_3
    //   303: aload 7
    //   305: astore 4
    //   307: aload 8
    //   309: astore 5
    //   311: aload_0
    //   312: invokevirtual 150	java/io/File:createNewFile	()Z
    //   315: pop
    //   316: aload 6
    //   318: astore_2
    //   319: aload_1
    //   320: astore_3
    //   321: aload 7
    //   323: astore 4
    //   325: aload 8
    //   327: astore 5
    //   329: new 137	java/io/FileOutputStream
    //   332: dup
    //   333: aload_0
    //   334: invokespecial 138	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   337: astore_0
    //   338: goto -173 -> 165
    //   341: aload_1
    //   342: ifnull +7 -> 349
    //   345: aload_1
    //   346: invokevirtual 47	java/io/FileInputStream:close	()V
    //   349: aload_0
    //   350: ifnull +7 -> 357
    //   353: aload_0
    //   354: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   357: aload 9
    //   359: invokevirtual 135	java/io/File:delete	()Z
    //   362: pop
    //   363: iconst_0
    //   364: ireturn
    //   365: astore_1
    //   366: aload_1
    //   367: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   370: goto -21 -> 349
    //   373: astore_0
    //   374: aload_0
    //   375: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   378: goto -21 -> 357
    //   381: astore_1
    //   382: aload_1
    //   383: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   386: goto -126 -> 260
    //   389: astore_0
    //   390: aload_0
    //   391: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   394: goto -126 -> 268
    //   397: astore_0
    //   398: aconst_null
    //   399: astore_1
    //   400: aload 5
    //   402: astore_2
    //   403: aload_1
    //   404: astore_3
    //   405: aload_0
    //   406: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   409: aload_1
    //   410: ifnull +7 -> 417
    //   413: aload_1
    //   414: invokevirtual 47	java/io/FileInputStream:close	()V
    //   417: aload 5
    //   419: ifnull +8 -> 427
    //   422: aload 5
    //   424: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   427: aload 9
    //   429: invokevirtual 135	java/io/File:delete	()Z
    //   432: pop
    //   433: bipush -2
    //   435: ireturn
    //   436: astore_0
    //   437: aload_0
    //   438: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   441: goto -24 -> 417
    //   444: astore_0
    //   445: aload_0
    //   446: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   449: goto -22 -> 427
    //   452: astore_0
    //   453: aconst_null
    //   454: astore_1
    //   455: aload 4
    //   457: astore_2
    //   458: aload_1
    //   459: astore_3
    //   460: aload_0
    //   461: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   464: aload_1
    //   465: ifnull +7 -> 472
    //   468: aload_1
    //   469: invokevirtual 47	java/io/FileInputStream:close	()V
    //   472: aload 4
    //   474: ifnull +8 -> 482
    //   477: aload 4
    //   479: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   482: aload 9
    //   484: invokevirtual 135	java/io/File:delete	()Z
    //   487: pop
    //   488: bipush -2
    //   490: ireturn
    //   491: astore_0
    //   492: aload_0
    //   493: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   496: goto -24 -> 472
    //   499: astore_0
    //   500: aload_0
    //   501: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   504: goto -22 -> 482
    //   507: astore_0
    //   508: aconst_null
    //   509: astore_3
    //   510: aload_3
    //   511: ifnull +7 -> 518
    //   514: aload_3
    //   515: invokevirtual 47	java/io/FileInputStream:close	()V
    //   518: aload_2
    //   519: ifnull +7 -> 526
    //   522: aload_2
    //   523: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   526: aload 9
    //   528: invokevirtual 135	java/io/File:delete	()Z
    //   531: pop
    //   532: aload_0
    //   533: athrow
    //   534: astore_1
    //   535: aload_1
    //   536: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   539: goto -21 -> 518
    //   542: astore_1
    //   543: aload_1
    //   544: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   547: goto -21 -> 526
    //   550: astore_0
    //   551: goto -41 -> 510
    //   554: astore_3
    //   555: aload_0
    //   556: astore_2
    //   557: aload_3
    //   558: astore_0
    //   559: aload_1
    //   560: astore_3
    //   561: goto -51 -> 510
    //   564: astore_0
    //   565: goto -110 -> 455
    //   568: astore_0
    //   569: goto -169 -> 400
    //   572: astore_2
    //   573: aconst_null
    //   574: astore_0
    //   575: aload_3
    //   576: astore_1
    //   577: goto -329 -> 248
    //   580: astore_2
    //   581: aconst_null
    //   582: astore_0
    //   583: goto -335 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	586	0	paramContext	Context
    //   0	586	1	paramString	String
    //   7	220	2	localObject1	Object
    //   247	2	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   279	278	2	localObject2	Object
    //   572	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   580	1	2	localFileNotFoundException3	java.io.FileNotFoundException
    //   18	497	3	str1	String
    //   554	4	3	localObject3	Object
    //   560	16	3	str2	String
    //   4	474	4	localObject4	Object
    //   1	422	5	localObject5	Object
    //   9	308	6	arrayOfByte	byte[]
    //   12	310	7	localObject6	Object
    //   15	311	8	localObject7	Object
    //   27	500	9	localFile	File
    //   217	23	10	i	int
    // Exception table:
    //   from	to	target	type
    //   175	184	247	java/io/FileNotFoundException
    //   194	201	247	java/io/FileNotFoundException
    //   211	219	247	java/io/FileNotFoundException
    //   235	244	247	java/io/FileNotFoundException
    //   345	349	365	java/io/IOException
    //   353	357	373	java/io/IOException
    //   256	260	381	java/io/IOException
    //   264	268	389	java/io/IOException
    //   39	49	397	java/io/IOException
    //   413	417	436	java/io/IOException
    //   422	427	444	java/io/IOException
    //   39	49	452	java/lang/Exception
    //   468	472	491	java/io/IOException
    //   477	482	499	java/io/IOException
    //   39	49	507	finally
    //   514	518	534	java/io/IOException
    //   522	526	542	java/io/IOException
    //   62	105	550	finally
    //   118	125	550	finally
    //   138	143	550	finally
    //   156	165	550	finally
    //   175	184	550	finally
    //   194	201	550	finally
    //   211	219	550	finally
    //   235	244	550	finally
    //   290	298	550	finally
    //   311	316	550	finally
    //   329	338	550	finally
    //   405	409	550	finally
    //   460	464	550	finally
    //   248	252	554	finally
    //   62	105	564	java/lang/Exception
    //   118	125	564	java/lang/Exception
    //   138	143	564	java/lang/Exception
    //   156	165	564	java/lang/Exception
    //   175	184	564	java/lang/Exception
    //   194	201	564	java/lang/Exception
    //   211	219	564	java/lang/Exception
    //   235	244	564	java/lang/Exception
    //   290	298	564	java/lang/Exception
    //   311	316	564	java/lang/Exception
    //   329	338	564	java/lang/Exception
    //   62	105	568	java/io/IOException
    //   118	125	568	java/io/IOException
    //   138	143	568	java/io/IOException
    //   156	165	568	java/io/IOException
    //   175	184	568	java/io/IOException
    //   194	201	568	java/io/IOException
    //   211	219	568	java/io/IOException
    //   235	244	568	java/io/IOException
    //   290	298	568	java/io/IOException
    //   311	316	568	java/io/IOException
    //   329	338	568	java/io/IOException
    //   39	49	572	java/io/FileNotFoundException
    //   62	105	580	java/io/FileNotFoundException
    //   118	125	580	java/io/FileNotFoundException
    //   138	143	580	java/io/FileNotFoundException
    //   156	165	580	java/io/FileNotFoundException
    //   290	298	580	java/io/FileNotFoundException
    //   311	316	580	java/io/FileNotFoundException
    //   329	338	580	java/io/FileNotFoundException
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\sm\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */