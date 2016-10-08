package com.tencent.mapsdk.a.e;

import android.os.Environment;
import java.io.File;

public final class a
{
  private static String a = "/Qmap/RasterMap";
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 % 128 * 128 + paramInt2 % 128;
  }
  
  public static a a()
  {
    return a.a;
  }
  
  private static void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 4)) {
      return;
    }
    int i = paramArrayOfByte[0];
    paramArrayOfByte[0] = paramArrayOfByte[3];
    paramArrayOfByte[3] = i;
    i = paramArrayOfByte[1];
    paramArrayOfByte[1] = paramArrayOfByte[2];
    paramArrayOfByte[2] = i;
  }
  
  private boolean a(File paramFile)
  {
    if (!paramFile.isDirectory()) {
      return false;
    }
    paramFile = paramFile.listFiles();
    int j = paramFile.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label57;
      }
      File localFile = paramFile[i];
      if (localFile.isDirectory()) {
        a(localFile);
      }
      if (!localFile.delete()) {
        break;
      }
      i += 1;
    }
    label57:
    return true;
  }
  
  private static byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)((0xFF00 & paramInt) >> 8), (byte)((0xFF0000 & paramInt) >> 16), (byte)((0xFF000000 & paramInt) >> 24) };
  }
  
  private String[] a(b paramb, boolean paramBoolean)
  {
    int i = paramb.a / 128;
    int j = paramb.b / 128;
    int k = i / 10;
    int m = j / 10;
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = c();
    if (localObject == null) {
      return null;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("/");
    switch (paramb.e)
    {
    default: 
      localObject = "invalid";
    }
    for (;;)
    {
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/");
      localStringBuilder.append(paramb.c);
      localStringBuilder.append("/");
      localStringBuilder.append(k);
      localStringBuilder.append("/");
      localStringBuilder.append(m);
      localStringBuilder.append("/");
      if (!paramBoolean)
      {
        localObject = new File(localStringBuilder.toString());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
      }
      localStringBuilder.append(paramb.c);
      localStringBuilder.append("_");
      localStringBuilder.append(i);
      localStringBuilder.append("_");
      localStringBuilder.append(j);
      return new String[] { localStringBuilder.toString() + ".idx", localStringBuilder.toString() + ".dat" };
      localObject = "Grid/V" + com.tencent.mapsdk.a.b.a;
      continue;
      localObject = "glGrid";
      continue;
      localObject = "Sate/V" + com.tencent.mapsdk.a.b.b;
      continue;
      localObject = "Traffic";
    }
  }
  
  private static int b(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[2] << 16 & 0xFF0000 | paramArrayOfByte[3] << 24 & 0xFF000000;
  }
  
  public static String c()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    try
    {
      String str = Environment.getExternalStorageDirectory().getPath();
      str = str + a;
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return str;
    }
    catch (Exception localException) {}
    return null;
    return null;
  }
  
  /* Error */
  public final android.graphics.Bitmap a(b paramb)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: aload_1
    //   4: iconst_1
    //   5: invokespecial 141	com/tencent/mapsdk/a/e/a:a	(Lcom/tencent/mapsdk/a/e/b;Z)[Ljava/lang/String;
    //   8: astore 5
    //   10: aload 5
    //   12: ifnull +36 -> 48
    //   15: aload 5
    //   17: arraylength
    //   18: iconst_2
    //   19: if_icmpne +29 -> 48
    //   22: aload 5
    //   24: iconst_0
    //   25: aaload
    //   26: ldc -113
    //   28: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifne +17 -> 48
    //   34: aload 5
    //   36: aload 5
    //   38: arraylength
    //   39: anewarray 92	java/lang/String
    //   42: invokestatic 148	java/util/Arrays:equals	([Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   45: ifeq +5 -> 50
    //   48: aconst_null
    //   49: areturn
    //   50: new 27	java/io/File
    //   53: dup
    //   54: aload 5
    //   56: iconst_0
    //   57: aaload
    //   58: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 85	java/io/File:exists	()Z
    //   66: ifeq -18 -> 48
    //   69: aload_2
    //   70: invokevirtual 152	java/io/File:length	()J
    //   73: lconst_0
    //   74: lcmp
    //   75: ifeq -27 -> 48
    //   78: aload_1
    //   79: getfield 50	com/tencent/mapsdk/a/e/b:a	I
    //   82: aload_1
    //   83: getfield 53	com/tencent/mapsdk/a/e/b:b	I
    //   86: invokestatic 154	com/tencent/mapsdk/a/e/a:a	(II)I
    //   89: istore 6
    //   91: iload 6
    //   93: iflt -45 -> 48
    //   96: iconst_4
    //   97: newarray <illegal type>
    //   99: astore 4
    //   101: new 156	java/io/RandomAccessFile
    //   104: dup
    //   105: aload_2
    //   106: ldc -98
    //   108: invokespecial 161	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   111: astore_2
    //   112: iload 6
    //   114: iconst_4
    //   115: imul
    //   116: i2l
    //   117: lstore 7
    //   119: aload_2
    //   120: lload 7
    //   122: invokevirtual 165	java/io/RandomAccessFile:seek	(J)V
    //   125: aload_2
    //   126: aload 4
    //   128: iconst_0
    //   129: iconst_4
    //   130: invokevirtual 169	java/io/RandomAccessFile:read	([BII)I
    //   133: pop
    //   134: aload_2
    //   135: invokevirtual 172	java/io/RandomAccessFile:close	()V
    //   138: aload 4
    //   140: invokestatic 174	com/tencent/mapsdk/a/e/a:a	([B)V
    //   143: aload 4
    //   145: invokestatic 176	com/tencent/mapsdk/a/e/a:b	([B)I
    //   148: istore 6
    //   150: iload 6
    //   152: iflt -104 -> 48
    //   155: new 27	java/io/File
    //   158: dup
    //   159: aload 5
    //   161: iconst_1
    //   162: aaload
    //   163: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   166: astore_2
    //   167: aload_2
    //   168: invokevirtual 85	java/io/File:exists	()Z
    //   171: ifeq -123 -> 48
    //   174: new 156	java/io/RandomAccessFile
    //   177: dup
    //   178: aload_2
    //   179: ldc -98
    //   181: invokespecial 161	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   184: astore_2
    //   185: iload 6
    //   187: i2l
    //   188: lstore 7
    //   190: aload_2
    //   191: lload 7
    //   193: invokevirtual 165	java/io/RandomAccessFile:seek	(J)V
    //   196: aload_2
    //   197: aload 4
    //   199: iconst_0
    //   200: iconst_4
    //   201: invokevirtual 169	java/io/RandomAccessFile:read	([BII)I
    //   204: pop
    //   205: aload 4
    //   207: invokestatic 174	com/tencent/mapsdk/a/e/a:a	([B)V
    //   210: aload 4
    //   212: invokestatic 176	com/tencent/mapsdk/a/e/a:b	([B)I
    //   215: istore 6
    //   217: iload 6
    //   219: ifgt +45 -> 264
    //   222: aload_2
    //   223: invokevirtual 172	java/io/RandomAccessFile:close	()V
    //   226: aconst_null
    //   227: areturn
    //   228: astore_1
    //   229: aconst_null
    //   230: areturn
    //   231: astore_1
    //   232: aconst_null
    //   233: astore_2
    //   234: aload_2
    //   235: invokevirtual 172	java/io/RandomAccessFile:close	()V
    //   238: aconst_null
    //   239: areturn
    //   240: astore_1
    //   241: aconst_null
    //   242: areturn
    //   243: astore_1
    //   244: aconst_null
    //   245: astore_2
    //   246: aload_2
    //   247: invokevirtual 172	java/io/RandomAccessFile:close	()V
    //   250: aload_1
    //   251: athrow
    //   252: astore_1
    //   253: aconst_null
    //   254: astore_1
    //   255: aload_1
    //   256: invokevirtual 172	java/io/RandomAccessFile:close	()V
    //   259: aconst_null
    //   260: areturn
    //   261: astore_1
    //   262: aconst_null
    //   263: areturn
    //   264: iload 6
    //   266: newarray <illegal type>
    //   268: astore 4
    //   270: aload_2
    //   271: aload 4
    //   273: iconst_0
    //   274: iload 6
    //   276: invokevirtual 169	java/io/RandomAccessFile:read	([BII)I
    //   279: pop
    //   280: aload_2
    //   281: invokevirtual 172	java/io/RandomAccessFile:close	()V
    //   284: aload 4
    //   286: iconst_0
    //   287: aload 4
    //   289: arraylength
    //   290: invokestatic 182	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   293: astore_2
    //   294: aload_1
    //   295: aload_2
    //   296: putfield 186	com/tencent/mapsdk/a/e/b:f	Landroid/graphics/Bitmap;
    //   299: aload_2
    //   300: areturn
    //   301: astore_1
    //   302: aload_2
    //   303: invokevirtual 172	java/io/RandomAccessFile:close	()V
    //   306: aconst_null
    //   307: areturn
    //   308: astore_1
    //   309: aconst_null
    //   310: areturn
    //   311: astore_1
    //   312: aload_2
    //   313: invokevirtual 172	java/io/RandomAccessFile:close	()V
    //   316: aload_1
    //   317: athrow
    //   318: astore_2
    //   319: goto -181 -> 138
    //   322: astore_2
    //   323: goto -73 -> 250
    //   326: astore_2
    //   327: goto -43 -> 284
    //   330: astore_2
    //   331: goto -15 -> 316
    //   334: astore_2
    //   335: aload_3
    //   336: astore_2
    //   337: goto -43 -> 294
    //   340: astore_1
    //   341: aload_2
    //   342: astore_1
    //   343: goto -88 -> 255
    //   346: astore_1
    //   347: goto -101 -> 246
    //   350: astore_1
    //   351: goto -117 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	this	a
    //   0	354	1	paramb	b
    //   61	252	2	localObject1	Object
    //   318	1	2	localException1	Exception
    //   322	1	2	localException2	Exception
    //   326	1	2	localException3	Exception
    //   330	1	2	localException4	Exception
    //   334	1	2	localException5	Exception
    //   336	6	2	localObject2	Object
    //   1	335	3	localObject3	Object
    //   99	189	4	arrayOfByte	byte[]
    //   8	152	5	arrayOfString	String[]
    //   89	186	6	i	int
    //   117	75	7	l	long
    // Exception table:
    //   from	to	target	type
    //   222	226	228	java/lang/Exception
    //   101	112	231	java/lang/Exception
    //   234	238	240	java/lang/Exception
    //   101	112	243	finally
    //   174	185	252	java/lang/Exception
    //   255	259	261	java/lang/Exception
    //   270	280	301	java/io/IOException
    //   302	306	308	java/lang/Exception
    //   270	280	311	finally
    //   134	138	318	java/lang/Exception
    //   246	250	322	java/lang/Exception
    //   280	284	326	java/lang/Exception
    //   312	316	330	java/lang/Exception
    //   284	294	334	java/lang/Exception
    //   190	205	340	java/lang/Exception
    //   119	134	346	finally
    //   119	134	350	java/lang/Exception
  }
  
  /* Error */
  public final boolean a(byte[] paramArrayOfByte, b paramb)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: istore 14
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_1
    //   9: ifnonnull +12 -> 21
    //   12: iload 14
    //   14: istore 12
    //   16: aload_0
    //   17: monitorexit
    //   18: iload 12
    //   20: ireturn
    //   21: aload_1
    //   22: arraylength
    //   23: istore 7
    //   25: iload 14
    //   27: istore 12
    //   29: iload 7
    //   31: ifle -15 -> 16
    //   34: aload_0
    //   35: aload_2
    //   36: iconst_0
    //   37: invokespecial 141	com/tencent/mapsdk/a/e/a:a	(Lcom/tencent/mapsdk/a/e/b;Z)[Ljava/lang/String;
    //   40: astore 5
    //   42: iload 14
    //   44: istore 12
    //   46: aload 5
    //   48: ifnull -32 -> 16
    //   51: iload 14
    //   53: istore 12
    //   55: aload 5
    //   57: arraylength
    //   58: iconst_2
    //   59: if_icmpne -43 -> 16
    //   62: iload 14
    //   64: istore 12
    //   66: aload 5
    //   68: iconst_0
    //   69: aaload
    //   70: ldc -113
    //   72: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   75: ifne -59 -> 16
    //   78: iload 14
    //   80: istore 12
    //   82: aload 5
    //   84: aload 5
    //   86: arraylength
    //   87: anewarray 92	java/lang/String
    //   90: invokestatic 148	java/util/Arrays:equals	([Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   93: ifne -77 -> 16
    //   96: new 27	java/io/File
    //   99: dup
    //   100: aload 5
    //   102: iconst_1
    //   103: aaload
    //   104: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: astore_3
    //   108: aload_3
    //   109: invokevirtual 85	java/io/File:exists	()Z
    //   112: istore 12
    //   114: iload 12
    //   116: ifne +18 -> 134
    //   119: aload_3
    //   120: invokevirtual 190	java/io/File:createNewFile	()Z
    //   123: istore 13
    //   125: iload 14
    //   127: istore 12
    //   129: iload 13
    //   131: ifeq -115 -> 16
    //   134: new 156	java/io/RandomAccessFile
    //   137: dup
    //   138: aload_3
    //   139: ldc -64
    //   141: invokespecial 161	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   144: astore_3
    //   145: iload 14
    //   147: istore 12
    //   149: aload_3
    //   150: ifnull -134 -> 16
    //   153: iload 7
    //   155: invokestatic 194	com/tencent/mapsdk/a/e/a:a	(I)[B
    //   158: astore 6
    //   160: aload 6
    //   162: invokestatic 174	com/tencent/mapsdk/a/e/a:a	([B)V
    //   165: aload_3
    //   166: invokevirtual 195	java/io/RandomAccessFile:length	()J
    //   169: lstore 8
    //   171: aload_3
    //   172: lload 8
    //   174: invokevirtual 165	java/io/RandomAccessFile:seek	(J)V
    //   177: aload_3
    //   178: aload 6
    //   180: invokevirtual 198	java/io/RandomAccessFile:write	([B)V
    //   183: aload_3
    //   184: aload_1
    //   185: invokevirtual 198	java/io/RandomAccessFile:write	([B)V
    //   188: aload_3
    //   189: invokevirtual 172	java/io/RandomAccessFile:close	()V
    //   192: new 27	java/io/File
    //   195: dup
    //   196: aload 5
    //   198: iconst_0
    //   199: aaload
    //   200: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   203: astore_1
    //   204: aload_1
    //   205: invokevirtual 85	java/io/File:exists	()Z
    //   208: istore 12
    //   210: iload 12
    //   212: ifne +18 -> 230
    //   215: aload_1
    //   216: invokevirtual 190	java/io/File:createNewFile	()Z
    //   219: istore 13
    //   221: iload 14
    //   223: istore 12
    //   225: iload 13
    //   227: ifeq -211 -> 16
    //   230: new 156	java/io/RandomAccessFile
    //   233: dup
    //   234: aload_1
    //   235: ldc -64
    //   237: invokespecial 161	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   240: astore_1
    //   241: iload 14
    //   243: istore 12
    //   245: aload_1
    //   246: ifnull -230 -> 16
    //   249: aload_1
    //   250: invokevirtual 195	java/io/RandomAccessFile:length	()J
    //   253: lstore 10
    //   255: lload 10
    //   257: lconst_0
    //   258: lcmp
    //   259: ifne +18 -> 277
    //   262: ldc -57
    //   264: newarray <illegal type>
    //   266: astore_3
    //   267: aload_3
    //   268: iconst_m1
    //   269: invokestatic 203	java/util/Arrays:fill	([BB)V
    //   272: aload_1
    //   273: aload_3
    //   274: invokevirtual 198	java/io/RandomAccessFile:write	([B)V
    //   277: aload_2
    //   278: getfield 50	com/tencent/mapsdk/a/e/b:a	I
    //   281: aload_2
    //   282: getfield 53	com/tencent/mapsdk/a/e/b:b	I
    //   285: invokestatic 154	com/tencent/mapsdk/a/e/a:a	(II)I
    //   288: istore 7
    //   290: iload 7
    //   292: ifge +57 -> 349
    //   295: aload_1
    //   296: invokevirtual 172	java/io/RandomAccessFile:close	()V
    //   299: iload 14
    //   301: istore 12
    //   303: goto -287 -> 16
    //   306: astore_1
    //   307: iload 14
    //   309: istore 12
    //   311: goto -295 -> 16
    //   314: astore 6
    //   316: iconst_0
    //   317: istore 13
    //   319: goto -194 -> 125
    //   322: astore_3
    //   323: aconst_null
    //   324: astore_3
    //   325: goto -180 -> 145
    //   328: astore_1
    //   329: lconst_0
    //   330: lstore 8
    //   332: goto -140 -> 192
    //   335: astore_3
    //   336: iconst_0
    //   337: istore 13
    //   339: goto -118 -> 221
    //   342: astore_3
    //   343: lconst_0
    //   344: lstore 10
    //   346: goto -91 -> 255
    //   349: iload 7
    //   351: iconst_4
    //   352: imul
    //   353: i2l
    //   354: lstore 10
    //   356: aload_1
    //   357: lload 10
    //   359: invokevirtual 165	java/io/RandomAccessFile:seek	(J)V
    //   362: lload 8
    //   364: l2i
    //   365: istore 7
    //   367: iload 7
    //   369: invokestatic 194	com/tencent/mapsdk/a/e/a:a	(I)[B
    //   372: astore_2
    //   373: aload_2
    //   374: invokestatic 174	com/tencent/mapsdk/a/e/a:a	([B)V
    //   377: aload_1
    //   378: aload_2
    //   379: invokevirtual 198	java/io/RandomAccessFile:write	([B)V
    //   382: aload_1
    //   383: invokevirtual 172	java/io/RandomAccessFile:close	()V
    //   386: iconst_1
    //   387: istore 12
    //   389: goto -373 -> 16
    //   392: astore_3
    //   393: goto -116 -> 277
    //   396: astore_2
    //   397: goto -35 -> 362
    //   400: astore_1
    //   401: aload_0
    //   402: monitorexit
    //   403: aload_1
    //   404: athrow
    //   405: astore_1
    //   406: goto -20 -> 386
    //   409: astore_1
    //   410: aload 4
    //   412: astore_1
    //   413: goto -172 -> 241
    //   416: astore_1
    //   417: goto -85 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	420	0	this	a
    //   0	420	1	paramArrayOfByte	byte[]
    //   0	420	2	paramb	b
    //   107	167	3	localObject1	Object
    //   322	1	3	localException1	Exception
    //   324	1	3	localObject2	Object
    //   335	1	3	localException2	Exception
    //   342	1	3	localException3	Exception
    //   392	1	3	localException4	Exception
    //   1	410	4	localObject3	Object
    //   40	157	5	arrayOfString	String[]
    //   158	21	6	arrayOfByte	byte[]
    //   314	1	6	localException5	Exception
    //   23	345	7	i	int
    //   169	194	8	l1	long
    //   253	105	10	l2	long
    //   14	374	12	bool1	boolean
    //   123	215	13	bool2	boolean
    //   4	304	14	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   295	299	306	java/lang/Exception
    //   119	125	314	java/lang/Exception
    //   134	145	322	java/lang/Exception
    //   165	171	328	java/lang/Exception
    //   215	221	335	java/lang/Exception
    //   249	255	342	java/lang/Exception
    //   272	277	392	java/lang/Exception
    //   356	362	396	java/lang/Exception
    //   21	25	400	finally
    //   34	42	400	finally
    //   55	62	400	finally
    //   66	78	400	finally
    //   82	114	400	finally
    //   119	125	400	finally
    //   134	145	400	finally
    //   153	165	400	finally
    //   165	171	400	finally
    //   171	192	400	finally
    //   192	210	400	finally
    //   215	221	400	finally
    //   230	241	400	finally
    //   249	255	400	finally
    //   262	272	400	finally
    //   272	277	400	finally
    //   277	290	400	finally
    //   295	299	400	finally
    //   356	362	400	finally
    //   367	377	400	finally
    //   377	386	400	finally
    //   377	386	405	java/lang/Exception
    //   230	241	409	java/lang/Exception
    //   171	192	416	java/lang/Exception
  }
  
  public final boolean b()
  {
    Object localObject = c();
    if (localObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        localObject = new File((String)localObject);
        if (((File)localObject).isDirectory())
        {
          boolean bool = a((File)localObject);
          if (bool) {
            return true;
          }
        }
      }
      catch (Exception localException) {}
    }
    return false;
  }
  
  static final class a
  {
    public static final a a = new a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */