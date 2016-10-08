package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;

public class RegionalThumbDecoder
  implements BitmapDecoder
{
  public RegionalThumbDecoder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public android.graphics.Bitmap a(java.net.URL paramURL)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 28	com/tencent/mobileqq/activity/photo/LocalMediaInfo:a	(Ljava/net/URL;)Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   4: astore 4
    //   6: aload 4
    //   8: ifnull +469 -> 477
    //   11: new 30	android/graphics/BitmapFactory$Options
    //   14: dup
    //   15: invokespecial 31	android/graphics/BitmapFactory$Options:<init>	()V
    //   18: astore_1
    //   19: aload_1
    //   20: iconst_1
    //   21: putfield 34	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   24: aload 4
    //   26: getfield 37	com/tencent/mobileqq/activity/photo/LocalMediaInfo:a	Ljava/lang/String;
    //   29: aload_1
    //   30: invokestatic 43	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   33: pop
    //   34: aload_1
    //   35: getfield 47	android/graphics/BitmapFactory$Options:outWidth	I
    //   38: aload_1
    //   39: getfield 50	android/graphics/BitmapFactory$Options:outHeight	I
    //   42: if_icmple +93 -> 135
    //   45: aload_1
    //   46: getfield 50	android/graphics/BitmapFactory$Options:outHeight	I
    //   49: istore 8
    //   51: aload_1
    //   52: getfield 47	android/graphics/BitmapFactory$Options:outWidth	I
    //   55: aload_1
    //   56: getfield 50	android/graphics/BitmapFactory$Options:outHeight	I
    //   59: idiv
    //   60: i2f
    //   61: fstore_2
    //   62: fload_2
    //   63: ldc 51
    //   65: fcmpg
    //   66: ifgt +89 -> 155
    //   69: aload_1
    //   70: aload_1
    //   71: getfield 47	android/graphics/BitmapFactory$Options:outWidth	I
    //   74: aload_1
    //   75: getfield 50	android/graphics/BitmapFactory$Options:outHeight	I
    //   78: aload 4
    //   80: getfield 54	com/tencent/mobileqq/activity/photo/LocalMediaInfo:f	I
    //   83: invokestatic 59	com/tencent/mobileqq/activity/photo/ThumbDecoder:a	(III)I
    //   86: putfield 62	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   89: aload_1
    //   90: iconst_0
    //   91: putfield 34	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   94: aload_1
    //   95: getstatic 68	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   98: putfield 71	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   101: aload 4
    //   103: getfield 37	com/tencent/mobileqq/activity/photo/LocalMediaInfo:a	Ljava/lang/String;
    //   106: aload_1
    //   107: invokestatic 74	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   110: astore_1
    //   111: aload_1
    //   112: ifnonnull +111 -> 223
    //   115: aload_1
    //   116: astore_3
    //   117: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +13 -> 133
    //   123: ldc 82
    //   125: iconst_2
    //   126: ldc 84
    //   128: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_1
    //   132: astore_3
    //   133: aload_3
    //   134: areturn
    //   135: aload_1
    //   136: getfield 47	android/graphics/BitmapFactory$Options:outWidth	I
    //   139: istore 8
    //   141: aload_1
    //   142: getfield 50	android/graphics/BitmapFactory$Options:outHeight	I
    //   145: aload_1
    //   146: getfield 47	android/graphics/BitmapFactory$Options:outWidth	I
    //   149: idiv
    //   150: i2f
    //   151: fstore_2
    //   152: goto -90 -> 62
    //   155: new 90	android/graphics/Rect
    //   158: dup
    //   159: iconst_0
    //   160: iconst_0
    //   161: iload 8
    //   163: iload 8
    //   165: invokespecial 93	android/graphics/Rect:<init>	(IIII)V
    //   168: astore 5
    //   170: aload_1
    //   171: iload 8
    //   173: iload 8
    //   175: aload 4
    //   177: getfield 54	com/tencent/mobileqq/activity/photo/LocalMediaInfo:f	I
    //   180: invokestatic 59	com/tencent/mobileqq/activity/photo/ThumbDecoder:a	(III)I
    //   183: putfield 62	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   186: aload_1
    //   187: iconst_0
    //   188: putfield 34	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   191: aload_1
    //   192: getstatic 68	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   195: putfield 71	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   198: aload 4
    //   200: getfield 37	com/tencent/mobileqq/activity/photo/LocalMediaInfo:a	Ljava/lang/String;
    //   203: iconst_1
    //   204: invokestatic 99	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/lang/String;Z)Landroid/graphics/BitmapRegionDecoder;
    //   207: astore_3
    //   208: aload_3
    //   209: aload 5
    //   211: aload_1
    //   212: invokevirtual 103	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   215: astore_1
    //   216: aload_3
    //   217: invokevirtual 106	android/graphics/BitmapRegionDecoder:recycle	()V
    //   220: goto -109 -> 111
    //   223: aload 4
    //   225: getfield 37	com/tencent/mobileqq/activity/photo/LocalMediaInfo:a	Ljava/lang/String;
    //   228: invokestatic 111	com/tencent/mobileqq/transfile/URLDrawableHelper:a	(Ljava/lang/String;)I
    //   231: istore 8
    //   233: iload 8
    //   235: ifne +29 -> 264
    //   238: aload_1
    //   239: invokevirtual 117	android/graphics/Bitmap:getWidth	()I
    //   242: aload 4
    //   244: getfield 54	com/tencent/mobileqq/activity/photo/LocalMediaInfo:f	I
    //   247: if_icmpne +17 -> 264
    //   250: aload_1
    //   251: astore_3
    //   252: aload_1
    //   253: invokevirtual 120	android/graphics/Bitmap:getHeight	()I
    //   256: aload 4
    //   258: getfield 54	com/tencent/mobileqq/activity/photo/LocalMediaInfo:f	I
    //   261: if_icmpeq -128 -> 133
    //   264: aload_1
    //   265: invokevirtual 117	android/graphics/Bitmap:getWidth	()I
    //   268: istore 9
    //   270: aload_1
    //   271: invokevirtual 120	android/graphics/Bitmap:getHeight	()I
    //   274: istore 10
    //   276: new 90	android/graphics/Rect
    //   279: dup
    //   280: invokespecial 121	android/graphics/Rect:<init>	()V
    //   283: astore_3
    //   284: new 123	android/graphics/RectF
    //   287: dup
    //   288: fconst_0
    //   289: fconst_0
    //   290: aload 4
    //   292: getfield 54	com/tencent/mobileqq/activity/photo/LocalMediaInfo:f	I
    //   295: i2f
    //   296: aload 4
    //   298: getfield 54	com/tencent/mobileqq/activity/photo/LocalMediaInfo:f	I
    //   301: i2f
    //   302: invokespecial 126	android/graphics/RectF:<init>	(FFFF)V
    //   305: astore 5
    //   307: iload 9
    //   309: iload 10
    //   311: if_icmple +116 -> 427
    //   314: iload 9
    //   316: iload 10
    //   318: isub
    //   319: iconst_2
    //   320: idiv
    //   321: istore 9
    //   323: aload_3
    //   324: iload 9
    //   326: iconst_0
    //   327: iload 9
    //   329: iload 10
    //   331: iadd
    //   332: iload 10
    //   334: iconst_0
    //   335: iadd
    //   336: invokevirtual 129	android/graphics/Rect:set	(IIII)V
    //   339: aload 4
    //   341: getfield 54	com/tencent/mobileqq/activity/photo/LocalMediaInfo:f	I
    //   344: aload 4
    //   346: getfield 54	com/tencent/mobileqq/activity/photo/LocalMediaInfo:f	I
    //   349: getstatic 68	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   352: invokestatic 133	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   355: astore 6
    //   357: new 135	android/graphics/Canvas
    //   360: dup
    //   361: aload 6
    //   363: invokespecial 138	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   366: astore 7
    //   368: iload 8
    //   370: ifeq +27 -> 397
    //   373: aload 7
    //   375: iload 8
    //   377: i2f
    //   378: aload 4
    //   380: getfield 54	com/tencent/mobileqq/activity/photo/LocalMediaInfo:f	I
    //   383: i2f
    //   384: fconst_2
    //   385: fdiv
    //   386: aload 4
    //   388: getfield 54	com/tencent/mobileqq/activity/photo/LocalMediaInfo:f	I
    //   391: i2f
    //   392: fconst_2
    //   393: fdiv
    //   394: invokevirtual 142	android/graphics/Canvas:rotate	(FFF)V
    //   397: aload 7
    //   399: aload_1
    //   400: aload_3
    //   401: aload 5
    //   403: new 144	android/graphics/Paint
    //   406: dup
    //   407: bipush 6
    //   409: invokespecial 147	android/graphics/Paint:<init>	(I)V
    //   412: invokevirtual 151	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   415: aload 6
    //   417: ifnull +60 -> 477
    //   420: aload_1
    //   421: invokevirtual 152	android/graphics/Bitmap:recycle	()V
    //   424: aload 6
    //   426: areturn
    //   427: iload 10
    //   429: iload 9
    //   431: isub
    //   432: iconst_2
    //   433: idiv
    //   434: istore 10
    //   436: aload_3
    //   437: iconst_0
    //   438: iload 10
    //   440: iconst_0
    //   441: iload 9
    //   443: iadd
    //   444: iload 9
    //   446: iload 10
    //   448: iadd
    //   449: invokevirtual 129	android/graphics/Rect:set	(IIII)V
    //   452: goto -113 -> 339
    //   455: astore_3
    //   456: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +12 -> 471
    //   462: ldc 82
    //   464: iconst_2
    //   465: ldc -102
    //   467: aload_3
    //   468: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   471: aload_1
    //   472: astore_3
    //   473: aload_1
    //   474: ifnonnull -341 -> 133
    //   477: aconst_null
    //   478: areturn
    //   479: astore_3
    //   480: aconst_null
    //   481: astore_1
    //   482: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   485: ifeq +12 -> 497
    //   488: ldc 82
    //   490: iconst_2
    //   491: ldc -97
    //   493: aload_3
    //   494: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   497: aload_1
    //   498: ifnull -21 -> 477
    //   501: aload_1
    //   502: areturn
    //   503: astore_3
    //   504: goto -22 -> 482
    //   507: astore_3
    //   508: goto -26 -> 482
    //   511: astore_3
    //   512: aconst_null
    //   513: astore_1
    //   514: goto -58 -> 456
    //   517: astore_3
    //   518: goto -62 -> 456
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	this	RegionalThumbDecoder
    //   0	521	1	paramURL	java.net.URL
    //   61	91	2	f	float
    //   116	321	3	localObject1	Object
    //   455	13	3	localOutOfMemoryError1	OutOfMemoryError
    //   472	1	3	localURL	java.net.URL
    //   479	15	3	localException1	Exception
    //   503	1	3	localException2	Exception
    //   507	1	3	localException3	Exception
    //   511	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   517	1	3	localOutOfMemoryError3	OutOfMemoryError
    //   4	383	4	localLocalMediaInfo	LocalMediaInfo
    //   168	234	5	localObject2	Object
    //   355	70	6	localBitmap	android.graphics.Bitmap
    //   366	32	7	localCanvas	android.graphics.Canvas
    //   49	327	8	i	int
    //   268	181	9	j	int
    //   274	175	10	k	int
    // Exception table:
    //   from	to	target	type
    //   117	131	455	java/lang/OutOfMemoryError
    //   223	233	455	java/lang/OutOfMemoryError
    //   238	250	455	java/lang/OutOfMemoryError
    //   252	264	455	java/lang/OutOfMemoryError
    //   264	307	455	java/lang/OutOfMemoryError
    //   314	339	455	java/lang/OutOfMemoryError
    //   339	368	455	java/lang/OutOfMemoryError
    //   373	397	455	java/lang/OutOfMemoryError
    //   397	415	455	java/lang/OutOfMemoryError
    //   420	424	455	java/lang/OutOfMemoryError
    //   427	452	455	java/lang/OutOfMemoryError
    //   11	62	479	java/lang/Exception
    //   69	111	479	java/lang/Exception
    //   135	152	479	java/lang/Exception
    //   155	216	479	java/lang/Exception
    //   216	220	503	java/lang/Exception
    //   117	131	507	java/lang/Exception
    //   223	233	507	java/lang/Exception
    //   238	250	507	java/lang/Exception
    //   252	264	507	java/lang/Exception
    //   264	307	507	java/lang/Exception
    //   314	339	507	java/lang/Exception
    //   339	368	507	java/lang/Exception
    //   373	397	507	java/lang/Exception
    //   397	415	507	java/lang/Exception
    //   420	424	507	java/lang/Exception
    //   427	452	507	java/lang/Exception
    //   11	62	511	java/lang/OutOfMemoryError
    //   69	111	511	java/lang/OutOfMemoryError
    //   135	152	511	java/lang/OutOfMemoryError
    //   155	216	511	java/lang/OutOfMemoryError
    //   216	220	517	java/lang/OutOfMemoryError
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\RegionalThumbDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */