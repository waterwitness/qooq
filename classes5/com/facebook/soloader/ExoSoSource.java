package com.facebook.soloader;

public class ExoSoSource
  extends DirectorySoSource
{
  private static final boolean DEBUG = false;
  private static final String TAG = "SoLoader";
  
  /* Error */
  public ExoSoSource(android.content.Context paramContext)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 23	com/facebook/soloader/SysUtil:createLibsDirectory	(Landroid/content/Context;)Ljava/io/File;
    //   5: iconst_1
    //   6: invokespecial 26	com/facebook/soloader/DirectorySoSource:<init>	(Ljava/io/File;I)V
    //   9: aload_0
    //   10: getfield 30	com/facebook/soloader/DirectorySoSource:soDirectory	Ljava/io/File;
    //   13: astore 5
    //   15: aload_1
    //   16: invokestatic 34	com/facebook/soloader/ExoSoSource:findProvidedLibraries	(Landroid/content/Context;)Ljava/util/Map;
    //   19: astore 6
    //   21: aconst_null
    //   22: astore_2
    //   23: aload_1
    //   24: invokestatic 38	com/facebook/soloader/SysUtil:lockLibsDirectory	(Landroid/content/Context;)Lcom/facebook/soloader/FileLocker;
    //   27: astore 4
    //   29: aload 4
    //   31: astore_2
    //   32: aload 5
    //   34: invokevirtual 44	java/io/File:listFiles	()[Ljava/io/File;
    //   37: astore_1
    //   38: iconst_0
    //   39: istore 9
    //   41: aload 4
    //   43: astore_2
    //   44: iload 9
    //   46: aload_1
    //   47: arraylength
    //   48: if_icmpge +107 -> 155
    //   51: aload_1
    //   52: iload 9
    //   54: aaload
    //   55: astore_3
    //   56: aload 4
    //   58: astore_2
    //   59: aload_3
    //   60: invokevirtual 48	java/io/File:getName	()Ljava/lang/String;
    //   63: astore 7
    //   65: aload 4
    //   67: astore_2
    //   68: aload 6
    //   70: aload 7
    //   72: invokeinterface 54 2 0
    //   77: checkcast 40	java/io/File
    //   80: astore 8
    //   82: aload 8
    //   84: ifnull +244 -> 328
    //   87: aload 4
    //   89: astore_2
    //   90: aload 8
    //   92: invokevirtual 58	java/io/File:length	()J
    //   95: aload_3
    //   96: invokevirtual 58	java/io/File:length	()J
    //   99: lcmp
    //   100: ifne +228 -> 328
    //   103: aload 4
    //   105: astore_2
    //   106: aload 8
    //   108: invokevirtual 61	java/io/File:lastModified	()J
    //   111: aload_3
    //   112: invokevirtual 61	java/io/File:lastModified	()J
    //   115: lcmp
    //   116: ifeq +240 -> 356
    //   119: goto +209 -> 328
    //   122: iload 10
    //   124: ifeq +10 -> 134
    //   127: aload 4
    //   129: astore_2
    //   130: aload_3
    //   131: invokestatic 65	com/facebook/soloader/SysUtil:deleteOrThrow	(Ljava/io/File;)V
    //   134: iload 11
    //   136: ifeq +211 -> 347
    //   139: aload 4
    //   141: astore_2
    //   142: aload 6
    //   144: aload 7
    //   146: invokeinterface 68 2 0
    //   151: pop
    //   152: goto +195 -> 347
    //   155: aload 4
    //   157: astore_2
    //   158: aload 6
    //   160: invokeinterface 72 1 0
    //   165: invokeinterface 78 1 0
    //   170: astore_1
    //   171: aload 4
    //   173: astore_2
    //   174: aload_1
    //   175: invokeinterface 84 1 0
    //   180: ifeq +119 -> 299
    //   183: aload 4
    //   185: astore_2
    //   186: aload_1
    //   187: invokeinterface 88 1 0
    //   192: checkcast 90	java/lang/String
    //   195: astore 7
    //   197: aload 4
    //   199: astore_2
    //   200: aload 6
    //   202: aload 7
    //   204: invokeinterface 54 2 0
    //   209: checkcast 40	java/io/File
    //   212: astore 8
    //   214: new 92	java/io/FileInputStream
    //   217: dup
    //   218: aload 8
    //   220: invokespecial 94	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   223: astore_3
    //   224: aload_3
    //   225: new 40	java/io/File
    //   228: dup
    //   229: aload 5
    //   231: aload 7
    //   233: invokespecial 97	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   236: aload 8
    //   238: invokevirtual 58	java/io/File:length	()J
    //   241: aload 8
    //   243: invokevirtual 61	java/io/File:lastModified	()J
    //   246: invokestatic 101	com/facebook/soloader/SysUtil:reliablyCopyExecutable	(Ljava/io/InputStream;Ljava/io/File;JJ)V
    //   249: aload_3
    //   250: ifnull +10 -> 260
    //   253: aload 4
    //   255: astore_2
    //   256: aload_3
    //   257: invokevirtual 107	java/io/InputStream:close	()V
    //   260: aload 4
    //   262: astore_2
    //   263: invokestatic 110	com/facebook/soloader/SysUtil:freeCopyBuffer	()V
    //   266: goto -95 -> 171
    //   269: astore_1
    //   270: aload_2
    //   271: ifnull +7 -> 278
    //   274: aload_2
    //   275: invokevirtual 113	com/facebook/soloader/FileLocker:close	()V
    //   278: aload_1
    //   279: athrow
    //   280: astore_1
    //   281: aconst_null
    //   282: astore_3
    //   283: aload_3
    //   284: ifnull +10 -> 294
    //   287: aload 4
    //   289: astore_2
    //   290: aload_3
    //   291: invokevirtual 107	java/io/InputStream:close	()V
    //   294: aload 4
    //   296: astore_2
    //   297: aload_1
    //   298: athrow
    //   299: aload 4
    //   301: ifnull +8 -> 309
    //   304: aload 4
    //   306: invokevirtual 113	com/facebook/soloader/FileLocker:close	()V
    //   309: return
    //   310: astore_2
    //   311: goto -51 -> 260
    //   314: astore_2
    //   315: goto -21 -> 294
    //   318: astore_1
    //   319: return
    //   320: astore_2
    //   321: goto -43 -> 278
    //   324: astore_1
    //   325: goto -42 -> 283
    //   328: iconst_1
    //   329: istore 10
    //   331: aload 8
    //   333: ifnull +29 -> 362
    //   336: iload 10
    //   338: ifne +24 -> 362
    //   341: iconst_1
    //   342: istore 11
    //   344: goto -222 -> 122
    //   347: iload 9
    //   349: iconst_1
    //   350: iadd
    //   351: istore 9
    //   353: goto -312 -> 41
    //   356: iconst_0
    //   357: istore 10
    //   359: goto -28 -> 331
    //   362: iconst_0
    //   363: istore 11
    //   365: goto -243 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	ExoSoSource
    //   0	368	1	paramContext	android.content.Context
    //   22	275	2	localObject1	Object
    //   310	1	2	localException1	Exception
    //   314	1	2	localException2	Exception
    //   320	1	2	localException3	Exception
    //   55	236	3	localObject2	Object
    //   27	278	4	localFileLocker	FileLocker
    //   13	217	5	localFile1	java.io.File
    //   19	182	6	localMap	java.util.Map
    //   63	169	7	str	String
    //   80	252	8	localFile2	java.io.File
    //   39	313	9	i	int
    //   122	236	10	j	int
    //   134	230	11	k	int
    // Exception table:
    //   from	to	target	type
    //   23	29	269	finally
    //   32	38	269	finally
    //   44	51	269	finally
    //   59	65	269	finally
    //   68	82	269	finally
    //   90	103	269	finally
    //   106	119	269	finally
    //   130	134	269	finally
    //   142	152	269	finally
    //   158	171	269	finally
    //   174	183	269	finally
    //   186	197	269	finally
    //   200	214	269	finally
    //   256	260	269	finally
    //   263	266	269	finally
    //   290	294	269	finally
    //   297	299	269	finally
    //   214	224	280	finally
    //   256	260	310	java/lang/Exception
    //   290	294	314	java/lang/Exception
    //   304	309	318	java/lang/Exception
    //   274	278	320	java/lang/Exception
    //   224	249	324	finally
  }
  
  /* Error */
  private static java.util.Map<String, java.io.File> findProvidedLibraries(android.content.Context paramContext)
    throws java.io.IOException
  {
    // Byte code:
    //   0: new 40	java/io/File
    //   3: dup
    //   4: new 117	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   11: ldc 121
    //   13: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: invokevirtual 130	android/content/Context:getPackageName	()Ljava/lang/String;
    //   20: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc -124
    //   25: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore_3
    //   35: new 140	java/util/HashMap
    //   38: dup
    //   39: invokespecial 141	java/util/HashMap:<init>	()V
    //   42: astore 4
    //   44: invokestatic 145	com/facebook/soloader/SysUtil:getSupportedAbis	()[Ljava/lang/String;
    //   47: astore 5
    //   49: aload 5
    //   51: arraylength
    //   52: istore 9
    //   54: iconst_0
    //   55: istore 8
    //   57: iload 8
    //   59: iload 9
    //   61: if_icmpge +269 -> 330
    //   64: new 40	java/io/File
    //   67: dup
    //   68: aload_3
    //   69: aload 5
    //   71: iload 8
    //   73: aaload
    //   74: invokespecial 97	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   77: astore 6
    //   79: aload 6
    //   81: invokevirtual 148	java/io/File:isDirectory	()Z
    //   84: ifne +12 -> 96
    //   87: iload 8
    //   89: iconst_1
    //   90: iadd
    //   91: istore 8
    //   93: goto -36 -> 57
    //   96: new 40	java/io/File
    //   99: dup
    //   100: aload 6
    //   102: ldc -106
    //   104: invokespecial 97	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 153	java/io/File:isFile	()Z
    //   112: ifeq -25 -> 87
    //   115: aconst_null
    //   116: astore_1
    //   117: aconst_null
    //   118: astore_2
    //   119: new 155	java/io/FileReader
    //   122: dup
    //   123: aload_0
    //   124: invokespecial 156	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   127: astore_0
    //   128: new 158	java/io/BufferedReader
    //   131: dup
    //   132: aload_0
    //   133: invokespecial 161	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   136: astore_1
    //   137: aload_1
    //   138: invokevirtual 164	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   141: astore 7
    //   143: aload 7
    //   145: ifnull +150 -> 295
    //   148: aload 7
    //   150: invokevirtual 167	java/lang/String:length	()I
    //   153: ifeq -16 -> 137
    //   156: aload 7
    //   158: bipush 32
    //   160: invokevirtual 171	java/lang/String:indexOf	(I)I
    //   163: istore 10
    //   165: iload 10
    //   167: iconst_m1
    //   168: if_icmpne +59 -> 227
    //   171: new 173	java/lang/RuntimeException
    //   174: dup
    //   175: new 117	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   182: ldc -81
    //   184: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 7
    //   189: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc -79
    //   194: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokespecial 178	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   203: athrow
    //   204: astore_3
    //   205: aload_1
    //   206: astore_2
    //   207: aload_3
    //   208: astore_1
    //   209: aload_0
    //   210: ifnull +7 -> 217
    //   213: aload_0
    //   214: invokevirtual 179	java/io/FileReader:close	()V
    //   217: aload_0
    //   218: ifnull +7 -> 225
    //   221: aload_2
    //   222: invokevirtual 180	java/io/BufferedReader:close	()V
    //   225: aload_1
    //   226: athrow
    //   227: new 117	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   234: aload 7
    //   236: iconst_0
    //   237: iload 10
    //   239: invokevirtual 184	java/lang/String:substring	(II)Ljava/lang/String;
    //   242: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc -70
    //   247: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: astore_2
    //   254: aload 7
    //   256: iload 10
    //   258: iconst_1
    //   259: iadd
    //   260: invokevirtual 189	java/lang/String:substring	(I)Ljava/lang/String;
    //   263: astore 7
    //   265: aload 4
    //   267: aload_2
    //   268: invokevirtual 193	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   271: ifne -134 -> 137
    //   274: aload 4
    //   276: aload_2
    //   277: new 40	java/io/File
    //   280: dup
    //   281: aload 6
    //   283: aload 7
    //   285: invokespecial 97	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   288: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   291: pop
    //   292: goto -155 -> 137
    //   295: aload_0
    //   296: ifnull +7 -> 303
    //   299: aload_0
    //   300: invokevirtual 179	java/io/FileReader:close	()V
    //   303: aload_0
    //   304: ifnull -217 -> 87
    //   307: aload_1
    //   308: invokevirtual 180	java/io/BufferedReader:close	()V
    //   311: goto -224 -> 87
    //   314: astore_0
    //   315: goto -228 -> 87
    //   318: astore_2
    //   319: goto -16 -> 303
    //   322: astore_3
    //   323: goto -106 -> 217
    //   326: astore_0
    //   327: goto -102 -> 225
    //   330: aload 4
    //   332: areturn
    //   333: astore_3
    //   334: aload_1
    //   335: astore_0
    //   336: aload_3
    //   337: astore_1
    //   338: goto -129 -> 209
    //   341: astore_1
    //   342: goto -133 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	paramContext	android.content.Context
    //   116	222	1	localObject1	Object
    //   341	1	1	localObject2	Object
    //   118	159	2	localObject3	Object
    //   318	1	2	localException1	Exception
    //   34	35	3	localFile1	java.io.File
    //   204	4	3	localObject4	Object
    //   322	1	3	localException2	Exception
    //   333	4	3	localObject5	Object
    //   42	289	4	localHashMap	java.util.HashMap
    //   47	23	5	arrayOfString	String[]
    //   77	205	6	localFile2	java.io.File
    //   141	143	7	str	String
    //   55	37	8	i	int
    //   52	10	9	j	int
    //   163	97	10	k	int
    // Exception table:
    //   from	to	target	type
    //   137	143	204	finally
    //   148	165	204	finally
    //   171	204	204	finally
    //   227	292	204	finally
    //   307	311	314	java/lang/Exception
    //   299	303	318	java/lang/Exception
    //   213	217	322	java/lang/Exception
    //   221	225	326	java/lang/Exception
    //   119	128	333	finally
    //   128	137	341	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\soloader\ExoSoSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */