import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jby
  implements Runnable
{
  public jby(QRDisplayActivity paramQRDisplayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore_1
    //   8: aconst_null
    //   9: astore 5
    //   11: aload_0
    //   12: getfield 12	jby:a	Lcom/tencent/biz/qrcode/activity/QRDisplayActivity;
    //   15: getfield 37	com/tencent/biz/qrcode/activity/QRDisplayActivity:b	Landroid/graphics/Bitmap;
    //   18: astore 8
    //   20: aload 8
    //   22: ifnull +531 -> 553
    //   25: aload 8
    //   27: invokevirtual 43	android/graphics/Bitmap:isRecycled	()Z
    //   30: ifne +523 -> 553
    //   33: new 45	java/io/File
    //   36: dup
    //   37: getstatic 51	com/tencent/mobileqq/app/AppConstants:bo	Ljava/lang/String;
    //   40: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore_2
    //   44: aload_2
    //   45: invokevirtual 57	java/io/File:mkdirs	()Z
    //   48: pop
    //   49: aload_2
    //   50: invokevirtual 60	java/io/File:canWrite	()Z
    //   53: ifeq +500 -> 553
    //   56: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   59: invokestatic 72	java/lang/Long:toString	(J)Ljava/lang/String;
    //   62: astore_2
    //   63: new 74	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   70: getstatic 51	com/tencent/mobileqq/app/AppConstants:bo	Ljava/lang/String;
    //   73: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc 81
    //   78: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_2
    //   82: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc 83
    //   87: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_3
    //   94: new 45	java/io/File
    //   97: dup
    //   98: aload_3
    //   99: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   102: astore 4
    //   104: iconst_2
    //   105: istore 9
    //   107: aload 4
    //   109: invokevirtual 89	java/io/File:exists	()Z
    //   112: ifeq +70 -> 182
    //   115: iload 9
    //   117: ldc 90
    //   119: if_icmpge +63 -> 182
    //   122: new 74	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   129: getstatic 51	com/tencent/mobileqq/app/AppConstants:bo	Ljava/lang/String;
    //   132: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc 81
    //   137: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_2
    //   141: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 92
    //   146: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: iload 9
    //   151: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: ldc 97
    //   156: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: astore_3
    //   163: new 45	java/io/File
    //   166: dup
    //   167: aload_3
    //   168: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   171: astore 4
    //   173: iload 9
    //   175: iconst_1
    //   176: iadd
    //   177: istore 9
    //   179: goto -72 -> 107
    //   182: new 99	java/io/BufferedOutputStream
    //   185: dup
    //   186: new 101	java/io/FileOutputStream
    //   189: dup
    //   190: aload 4
    //   192: invokespecial 104	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   195: sipush 8192
    //   198: invokespecial 107	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   201: astore_2
    //   202: aload 8
    //   204: getstatic 113	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   207: bipush 75
    //   209: aload_2
    //   210: invokevirtual 117	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   213: istore 10
    //   215: aload_2
    //   216: ifnull +334 -> 550
    //   219: aload_2
    //   220: invokevirtual 120	java/io/BufferedOutputStream:close	()V
    //   223: iload 10
    //   225: istore 11
    //   227: aload_3
    //   228: astore_1
    //   229: iload 10
    //   231: ifne +29 -> 260
    //   234: iload 10
    //   236: istore 11
    //   238: aload_3
    //   239: astore_1
    //   240: aload 4
    //   242: invokevirtual 89	java/io/File:exists	()Z
    //   245: ifeq +15 -> 260
    //   248: aload 4
    //   250: invokevirtual 123	java/io/File:delete	()Z
    //   253: pop
    //   254: aload_3
    //   255: astore_1
    //   256: iload 10
    //   258: istore 11
    //   260: aload_0
    //   261: getfield 12	jby:a	Lcom/tencent/biz/qrcode/activity/QRDisplayActivity;
    //   264: new 125	jbz
    //   267: dup
    //   268: aload_0
    //   269: iload 11
    //   271: aload_1
    //   272: invokespecial 128	jbz:<init>	(Ljby;ZLjava/lang/String;)V
    //   275: invokevirtual 132	com/tencent/biz/qrcode/activity/QRDisplayActivity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   278: return
    //   279: astore_1
    //   280: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   283: ifeq +13 -> 296
    //   286: ldc -117
    //   288: iconst_2
    //   289: aload_1
    //   290: invokevirtual 142	java/io/IOException:getMessage	()Ljava/lang/String;
    //   293: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: goto -73 -> 223
    //   299: astore_1
    //   300: aload 5
    //   302: astore_2
    //   303: aload_1
    //   304: astore 5
    //   306: aload_2
    //   307: astore_1
    //   308: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq +16 -> 327
    //   314: aload_2
    //   315: astore_1
    //   316: ldc -117
    //   318: iconst_2
    //   319: aload 5
    //   321: invokevirtual 147	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   324: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: aload_2
    //   328: ifnull +216 -> 544
    //   331: aload_2
    //   332: invokevirtual 120	java/io/BufferedOutputStream:close	()V
    //   335: iconst_0
    //   336: istore 10
    //   338: goto -115 -> 223
    //   341: astore_1
    //   342: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   345: ifeq +13 -> 358
    //   348: ldc -117
    //   350: iconst_2
    //   351: aload_1
    //   352: invokevirtual 142	java/io/IOException:getMessage	()Ljava/lang/String;
    //   355: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: iconst_0
    //   359: istore 10
    //   361: goto -138 -> 223
    //   364: astore 5
    //   366: aload 6
    //   368: astore_2
    //   369: aload_2
    //   370: astore_1
    //   371: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   374: ifeq +16 -> 390
    //   377: aload_2
    //   378: astore_1
    //   379: ldc -117
    //   381: iconst_2
    //   382: aload 5
    //   384: invokevirtual 148	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   387: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: aload_2
    //   391: ifnull +153 -> 544
    //   394: aload_2
    //   395: invokevirtual 120	java/io/BufferedOutputStream:close	()V
    //   398: iconst_0
    //   399: istore 10
    //   401: goto -178 -> 223
    //   404: astore_1
    //   405: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +13 -> 421
    //   411: ldc -117
    //   413: iconst_2
    //   414: aload_1
    //   415: invokevirtual 142	java/io/IOException:getMessage	()Ljava/lang/String;
    //   418: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: iconst_0
    //   422: istore 10
    //   424: goto -201 -> 223
    //   427: astore 5
    //   429: aload 7
    //   431: astore_2
    //   432: aload_2
    //   433: astore_1
    //   434: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   437: ifeq +16 -> 453
    //   440: aload_2
    //   441: astore_1
    //   442: ldc -117
    //   444: iconst_2
    //   445: aload 5
    //   447: invokevirtual 149	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   450: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: aload_2
    //   454: ifnull +90 -> 544
    //   457: aload_2
    //   458: invokevirtual 120	java/io/BufferedOutputStream:close	()V
    //   461: iconst_0
    //   462: istore 10
    //   464: goto -241 -> 223
    //   467: astore_1
    //   468: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   471: ifeq +13 -> 484
    //   474: ldc -117
    //   476: iconst_2
    //   477: aload_1
    //   478: invokevirtual 142	java/io/IOException:getMessage	()Ljava/lang/String;
    //   481: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   484: iconst_0
    //   485: istore 10
    //   487: goto -264 -> 223
    //   490: astore_3
    //   491: aload_1
    //   492: astore_2
    //   493: aload_3
    //   494: astore_1
    //   495: aload_2
    //   496: ifnull +7 -> 503
    //   499: aload_2
    //   500: invokevirtual 120	java/io/BufferedOutputStream:close	()V
    //   503: aload_1
    //   504: athrow
    //   505: astore_2
    //   506: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   509: ifeq -6 -> 503
    //   512: ldc -117
    //   514: iconst_2
    //   515: aload_2
    //   516: invokevirtual 142	java/io/IOException:getMessage	()Ljava/lang/String;
    //   519: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   522: goto -19 -> 503
    //   525: astore_1
    //   526: goto -31 -> 495
    //   529: astore 5
    //   531: goto -99 -> 432
    //   534: astore 5
    //   536: goto -167 -> 369
    //   539: astore 5
    //   541: goto -235 -> 306
    //   544: iconst_0
    //   545: istore 10
    //   547: goto -324 -> 223
    //   550: goto -327 -> 223
    //   553: aconst_null
    //   554: astore_1
    //   555: iconst_0
    //   556: istore 11
    //   558: goto -298 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	561	0	this	jby
    //   7	265	1	localObject1	Object
    //   279	11	1	localIOException1	java.io.IOException
    //   299	5	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   307	9	1	localObject2	Object
    //   341	11	1	localIOException2	java.io.IOException
    //   370	9	1	localObject3	Object
    //   404	11	1	localIOException3	java.io.IOException
    //   433	9	1	localObject4	Object
    //   467	25	1	localIOException4	java.io.IOException
    //   494	10	1	localObject5	Object
    //   525	1	1	localObject6	Object
    //   554	1	1	localObject7	Object
    //   43	457	2	localObject8	Object
    //   505	11	2	localIOException5	java.io.IOException
    //   93	162	3	str	String
    //   490	4	3	localObject9	Object
    //   102	147	4	localFile	java.io.File
    //   9	311	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   364	19	5	localOutOfMemoryError1	OutOfMemoryError
    //   427	19	5	localIllegalStateException1	IllegalStateException
    //   529	1	5	localIllegalStateException2	IllegalStateException
    //   534	1	5	localOutOfMemoryError2	OutOfMemoryError
    //   539	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   1	366	6	localObject10	Object
    //   4	426	7	localObject11	Object
    //   18	185	8	localBitmap	android.graphics.Bitmap
    //   105	73	9	i	int
    //   213	333	10	bool1	boolean
    //   225	332	11	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   219	223	279	java/io/IOException
    //   182	202	299	java/io/FileNotFoundException
    //   331	335	341	java/io/IOException
    //   182	202	364	java/lang/OutOfMemoryError
    //   394	398	404	java/io/IOException
    //   182	202	427	java/lang/IllegalStateException
    //   457	461	467	java/io/IOException
    //   182	202	490	finally
    //   308	314	490	finally
    //   316	327	490	finally
    //   371	377	490	finally
    //   379	390	490	finally
    //   434	440	490	finally
    //   442	453	490	finally
    //   499	503	505	java/io/IOException
    //   202	215	525	finally
    //   202	215	529	java/lang/IllegalStateException
    //   202	215	534	java/lang/OutOfMemoryError
    //   202	215	539	java/io/FileNotFoundException
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */