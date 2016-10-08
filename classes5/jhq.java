import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class jhq
  implements Runnable
{
  public jhq(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: getstatic 32	com/tencent/biz/webviewplugin/OfflinePlugin:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   3: aload_0
    //   4: getfield 12	jhq:a	Ljava/lang/String;
    //   7: invokevirtual 38	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: new 40	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 41	java/util/ArrayList:<init>	()V
    //   18: astore_3
    //   19: aload_0
    //   20: getfield 12	jhq:a	Ljava/lang/String;
    //   23: invokestatic 46	com/tencent/biz/common/offline/HtmlOffline:a	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore_1
    //   27: aload_1
    //   28: invokestatic 52	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifeq +4 -> 35
    //   34: return
    //   35: new 54	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   42: aload_1
    //   43: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 12	jhq:a	Ljava/lang/String;
    //   50: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: getstatic 64	java/io/File:separator	Ljava/lang/String;
    //   56: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore 4
    //   64: new 61	java/io/File
    //   67: dup
    //   68: new 54	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   75: aload 4
    //   77: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 70
    //   82: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 76	java/io/File:exists	()Z
    //   96: ifne +73 -> 169
    //   99: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +29 -> 131
    //   105: ldc 83
    //   107: iconst_2
    //   108: new 54	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   115: ldc 85
    //   117: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 4
    //   122: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 89	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_3
    //   132: new 54	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   139: aload 4
    //   141: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 91
    //   146: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokevirtual 95	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   155: pop
    //   156: getstatic 32	com/tencent/biz/webviewplugin/OfflinePlugin:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   159: aload_0
    //   160: getfield 12	jhq:a	Ljava/lang/String;
    //   163: aload_3
    //   164: invokevirtual 99	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   167: pop
    //   168: return
    //   169: new 101	java/util/zip/ZipFile
    //   172: dup
    //   173: aload_1
    //   174: invokespecial 104	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   177: astore_2
    //   178: aload_2
    //   179: astore_1
    //   180: aload_2
    //   181: invokevirtual 108	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   184: astore 5
    //   186: aload_2
    //   187: astore_1
    //   188: aload_2
    //   189: invokevirtual 112	java/util/zip/ZipFile:size	()I
    //   192: ifne +152 -> 344
    //   195: bipush 16
    //   197: istore 8
    //   199: aload_2
    //   200: astore_1
    //   201: new 54	java/lang/StringBuilder
    //   204: dup
    //   205: iload 8
    //   207: invokespecial 115	java/lang/StringBuilder:<init>	(I)V
    //   210: astore 6
    //   212: aload_2
    //   213: astore_1
    //   214: aload 5
    //   216: invokeinterface 120 1 0
    //   221: ifeq +138 -> 359
    //   224: aload_2
    //   225: astore_1
    //   226: aload 5
    //   228: invokeinterface 124 1 0
    //   233: checkcast 126	java/util/zip/ZipEntry
    //   236: astore 7
    //   238: aload_2
    //   239: astore_1
    //   240: aload 7
    //   242: invokevirtual 129	java/util/zip/ZipEntry:isDirectory	()Z
    //   245: ifne -33 -> 212
    //   248: aload_2
    //   249: astore_1
    //   250: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +31 -> 284
    //   256: aload_2
    //   257: astore_1
    //   258: aload 6
    //   260: ldc -125
    //   262: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload 4
    //   267: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload 7
    //   272: invokevirtual 134	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   275: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc -120
    //   280: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_2
    //   285: astore_1
    //   286: aload_3
    //   287: new 54	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   294: aload 4
    //   296: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 7
    //   301: invokevirtual 134	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   304: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokevirtual 95	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   313: pop
    //   314: goto -102 -> 212
    //   317: astore_3
    //   318: aload_2
    //   319: astore_1
    //   320: ldc 83
    //   322: iconst_1
    //   323: ldc -118
    //   325: aload_3
    //   326: invokestatic 142	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   329: aload_2
    //   330: ifnull -296 -> 34
    //   333: aload_2
    //   334: invokevirtual 145	java/util/zip/ZipFile:close	()V
    //   337: return
    //   338: astore_1
    //   339: aload_1
    //   340: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   343: return
    //   344: aload_2
    //   345: astore_1
    //   346: aload_2
    //   347: invokevirtual 112	java/util/zip/ZipFile:size	()I
    //   350: sipush 128
    //   353: imul
    //   354: istore 8
    //   356: goto -157 -> 199
    //   359: aload_2
    //   360: astore_1
    //   361: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   364: ifeq +16 -> 380
    //   367: aload_2
    //   368: astore_1
    //   369: ldc 83
    //   371: iconst_2
    //   372: aload 6
    //   374: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 89	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: aload_2
    //   381: astore_1
    //   382: getstatic 32	com/tencent/biz/webviewplugin/OfflinePlugin:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   385: aload_0
    //   386: getfield 12	jhq:a	Ljava/lang/String;
    //   389: aload_3
    //   390: invokevirtual 99	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   393: pop
    //   394: aload_2
    //   395: ifnull -361 -> 34
    //   398: aload_2
    //   399: invokevirtual 145	java/util/zip/ZipFile:close	()V
    //   402: return
    //   403: astore_1
    //   404: aload_1
    //   405: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   408: return
    //   409: astore_2
    //   410: aconst_null
    //   411: astore_1
    //   412: aload_1
    //   413: ifnull +7 -> 420
    //   416: aload_1
    //   417: invokevirtual 145	java/util/zip/ZipFile:close	()V
    //   420: aload_2
    //   421: athrow
    //   422: astore_1
    //   423: aload_1
    //   424: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   427: goto -7 -> 420
    //   430: astore_2
    //   431: goto -19 -> 412
    //   434: astore_3
    //   435: aconst_null
    //   436: astore_2
    //   437: goto -119 -> 318
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	jhq
    //   26	294	1	localObject1	Object
    //   338	2	1	localIOException1	java.io.IOException
    //   345	37	1	localObject2	Object
    //   403	2	1	localIOException2	java.io.IOException
    //   411	6	1	localObject3	Object
    //   422	2	1	localIOException3	java.io.IOException
    //   177	222	2	localZipFile	java.util.zip.ZipFile
    //   409	12	2	localObject4	Object
    //   430	1	2	localObject5	Object
    //   436	1	2	localObject6	Object
    //   18	269	3	localArrayList	java.util.ArrayList
    //   317	73	3	localException1	Exception
    //   434	1	3	localException2	Exception
    //   62	233	4	str	String
    //   184	43	5	localEnumeration	java.util.Enumeration
    //   210	163	6	localStringBuilder	StringBuilder
    //   236	64	7	localZipEntry	java.util.zip.ZipEntry
    //   197	158	8	i	int
    // Exception table:
    //   from	to	target	type
    //   180	186	317	java/lang/Exception
    //   188	195	317	java/lang/Exception
    //   201	212	317	java/lang/Exception
    //   214	224	317	java/lang/Exception
    //   226	238	317	java/lang/Exception
    //   240	248	317	java/lang/Exception
    //   250	256	317	java/lang/Exception
    //   258	284	317	java/lang/Exception
    //   286	314	317	java/lang/Exception
    //   346	356	317	java/lang/Exception
    //   361	367	317	java/lang/Exception
    //   369	380	317	java/lang/Exception
    //   382	394	317	java/lang/Exception
    //   333	337	338	java/io/IOException
    //   398	402	403	java/io/IOException
    //   169	178	409	finally
    //   416	420	422	java/io/IOException
    //   180	186	430	finally
    //   188	195	430	finally
    //   201	212	430	finally
    //   214	224	430	finally
    //   226	238	430	finally
    //   240	248	430	finally
    //   250	256	430	finally
    //   258	284	430	finally
    //   286	314	430	finally
    //   320	329	430	finally
    //   346	356	430	finally
    //   361	367	430	finally
    //   369	380	430	finally
    //   382	394	430	finally
    //   169	178	434	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jhq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */