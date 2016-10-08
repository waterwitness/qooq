package com.tencent.mobileqq.shortvideo.cover;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import java.io.File;

public class RecordThumbnailUtils
{
  public static final String a = "RecordThumbnailUtils";
  
  public RecordThumbnailUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  public static String a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    File localFile = new File(paramString);
    return a(paramInt1, paramString, paramInt2, paramInt3, GloableValue.c + File.separator + VidUtil.a(localFile) + ".jpg", paramInt4);
  }
  
  /* Error */
  public static String a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 7
    //   9: iload_2
    //   10: iload_3
    //   11: imul
    //   12: iconst_3
    //   13: imul
    //   14: iconst_2
    //   15: idiv
    //   16: newarray <illegal type>
    //   18: astore 6
    //   20: iload_2
    //   21: iload_3
    //   22: imul
    //   23: newarray <illegal type>
    //   25: astore 10
    //   27: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +28 -> 58
    //   33: ldc 8
    //   35: iconst_2
    //   36: new 53	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   43: ldc 94
    //   45: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: new 48	java/io/File
    //   61: dup
    //   62: aload_1
    //   63: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: astore 11
    //   68: aload 11
    //   70: invokevirtual 101	java/io/File:exists	()Z
    //   73: ifeq +11 -> 84
    //   76: aload 11
    //   78: invokevirtual 104	java/io/File:isDirectory	()Z
    //   81: ifne +5 -> 86
    //   84: aconst_null
    //   85: areturn
    //   86: aload 11
    //   88: invokevirtual 108	java/io/File:list	()[Ljava/lang/String;
    //   91: astore 11
    //   93: aload 11
    //   95: ifnull -11 -> 84
    //   98: aload 11
    //   100: arraylength
    //   101: istore 14
    //   103: iconst_0
    //   104: istore 13
    //   106: iload 13
    //   108: iload 14
    //   110: if_icmpge +305 -> 415
    //   113: aload 11
    //   115: iload 13
    //   117: aaload
    //   118: astore 12
    //   120: aload 12
    //   122: ldc 110
    //   124: invokevirtual 116	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   127: ifeq +174 -> 301
    //   130: new 53	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   137: aload_1
    //   138: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: getstatic 66	java/io/File:separator	Ljava/lang/String;
    //   144: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 12
    //   149: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: astore_1
    //   156: aload_1
    //   157: ifnull -73 -> 84
    //   160: aload_1
    //   161: invokestatic 122	com/tencent/maxvideo/activity/CoverNative:openFile	(Ljava/lang/String;)J
    //   164: lstore 15
    //   166: lload 15
    //   168: lconst_0
    //   169: lcmp
    //   170: ifeq -86 -> 84
    //   173: lload 15
    //   175: aconst_null
    //   176: iload_0
    //   177: aload 6
    //   179: iload_2
    //   180: iload_3
    //   181: invokestatic 126	com/tencent/maxvideo/activity/CoverNative:getFrameYuv	(JLjava/lang/String;I[BII)Z
    //   184: ifeq -100 -> 84
    //   187: lload 15
    //   189: invokestatic 130	com/tencent/maxvideo/activity/CoverNative:closeFile	(J)V
    //   192: aload 10
    //   194: aload 6
    //   196: iload_2
    //   197: iload_3
    //   198: invokestatic 135	com/tencent/mobileqq/shortvideo/util/ImageUtil:a	([I[BII)V
    //   201: aload 10
    //   203: iload_2
    //   204: iload_3
    //   205: getstatic 141	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   208: invokestatic 144	android/graphics/Bitmap:createBitmap	([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   211: astore_1
    //   212: aload_1
    //   213: ifnull +152 -> 365
    //   216: aload_1
    //   217: astore 6
    //   219: iload 5
    //   221: ifeq +22 -> 243
    //   224: aload_1
    //   225: astore 6
    //   227: iload 5
    //   229: invokestatic 149	com/tencent/mobileqq/activity/richmedia/view/CameraFilterGLView:a	(I)Z
    //   232: ifne +11 -> 243
    //   235: aload_1
    //   236: iload 5
    //   238: invokestatic 151	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   241: astore 6
    //   243: new 48	java/io/File
    //   246: dup
    //   247: aload 4
    //   249: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   252: astore_1
    //   253: new 153	java/io/BufferedOutputStream
    //   256: dup
    //   257: new 155	java/io/FileOutputStream
    //   260: dup
    //   261: aload_1
    //   262: invokespecial 158	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   265: invokespecial 161	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   268: astore_1
    //   269: aload 6
    //   271: ifnull +19 -> 290
    //   274: aload 6
    //   276: getstatic 167	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   279: bipush 60
    //   281: aload_1
    //   282: invokevirtual 171	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   285: pop
    //   286: aload_1
    //   287: invokevirtual 174	java/io/BufferedOutputStream:flush	()V
    //   290: aload_1
    //   291: ifnull +7 -> 298
    //   294: aload_1
    //   295: invokevirtual 177	java/io/BufferedOutputStream:close	()V
    //   298: aload 4
    //   300: areturn
    //   301: iload 13
    //   303: iconst_1
    //   304: iadd
    //   305: istore 13
    //   307: goto -201 -> 106
    //   310: astore_1
    //   311: aload 7
    //   313: astore_1
    //   314: aload_1
    //   315: ifnull -17 -> 298
    //   318: aload_1
    //   319: invokevirtual 177	java/io/BufferedOutputStream:close	()V
    //   322: goto -24 -> 298
    //   325: astore_1
    //   326: goto -28 -> 298
    //   329: astore_1
    //   330: aload 8
    //   332: astore_1
    //   333: aload_1
    //   334: ifnull -36 -> 298
    //   337: aload_1
    //   338: invokevirtual 177	java/io/BufferedOutputStream:close	()V
    //   341: goto -43 -> 298
    //   344: astore_1
    //   345: goto -47 -> 298
    //   348: astore_1
    //   349: aload 9
    //   351: astore 4
    //   353: aload 4
    //   355: ifnull +8 -> 363
    //   358: aload 4
    //   360: invokevirtual 177	java/io/BufferedOutputStream:close	()V
    //   363: aload_1
    //   364: athrow
    //   365: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   368: ifeq -70 -> 298
    //   371: ldc 8
    //   373: iconst_2
    //   374: ldc -77
    //   376: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   379: goto -81 -> 298
    //   382: astore_1
    //   383: goto -85 -> 298
    //   386: astore 4
    //   388: goto -25 -> 363
    //   391: astore 6
    //   393: aload_1
    //   394: astore 4
    //   396: aload 6
    //   398: astore_1
    //   399: goto -46 -> 353
    //   402: astore 6
    //   404: goto -71 -> 333
    //   407: astore 6
    //   409: goto -95 -> 314
    //   412: astore_1
    //   413: aconst_null
    //   414: areturn
    //   415: aconst_null
    //   416: astore_1
    //   417: goto -261 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	420	0	paramInt1	int
    //   0	420	1	paramString1	String
    //   0	420	2	paramInt2	int
    //   0	420	3	paramInt3	int
    //   0	420	4	paramString2	String
    //   0	420	5	paramInt4	int
    //   18	257	6	localObject1	Object
    //   391	6	6	localObject2	Object
    //   402	1	6	localIOException	java.io.IOException
    //   407	1	6	localFileNotFoundException	java.io.FileNotFoundException
    //   7	305	7	localObject3	Object
    //   1	330	8	localObject4	Object
    //   4	346	9	localObject5	Object
    //   25	177	10	arrayOfInt	int[]
    //   66	48	11	localObject6	Object
    //   118	30	12	str	String
    //   104	202	13	i	int
    //   101	10	14	j	int
    //   164	24	15	l	long
    // Exception table:
    //   from	to	target	type
    //   253	269	310	java/io/FileNotFoundException
    //   318	322	325	java/io/IOException
    //   253	269	329	java/io/IOException
    //   337	341	344	java/io/IOException
    //   253	269	348	finally
    //   294	298	382	java/io/IOException
    //   358	363	386	java/io/IOException
    //   274	290	391	finally
    //   274	290	402	java/io/IOException
    //   274	290	407	java/io/FileNotFoundException
    //   201	212	412	java/lang/Throwable
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, int paramInt3, Bitmap.Config paramConfig)
  {
    File localFile = new File(paramString);
    return a(paramString, paramInt1, paramInt2, GloableValue.c + File.separator + VidUtil.a(localFile) + ".jpg", paramInt3, paramConfig);
  }
  
  /* Error */
  public static String a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 7
    //   9: iload_1
    //   10: iload_2
    //   11: aload 5
    //   13: invokestatic 188	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   16: astore 6
    //   18: aload 6
    //   20: iload_1
    //   21: iload_2
    //   22: invokestatic 192	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:nativeGenCover	(Landroid/graphics/Bitmap;II)I
    //   25: istore 10
    //   27: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +39 -> 69
    //   33: ldc 8
    //   35: iconst_2
    //   36: new 53	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   43: ldc -62
    //   45: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload 10
    //   50: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc -57
    //   55: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload 6
    //   60: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: iload 10
    //   71: ifeq +46 -> 117
    //   74: iconst_0
    //   75: aload_0
    //   76: iload_1
    //   77: iload_2
    //   78: aload_3
    //   79: iload 4
    //   81: invokestatic 80	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:a	(ILjava/lang/String;IILjava/lang/String;I)Ljava/lang/String;
    //   84: astore_0
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +11 -> 102
    //   94: ldc 8
    //   96: iconst_2
    //   97: ldc -52
    //   99: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: aconst_null
    //   103: areturn
    //   104: astore 5
    //   106: aload 5
    //   108: invokevirtual 205	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   111: iconst_m1
    //   112: istore 10
    //   114: goto -87 -> 27
    //   117: aload 6
    //   119: ifnull +275 -> 394
    //   122: iload 4
    //   124: ifeq +312 -> 436
    //   127: iload 4
    //   129: invokestatic 149	com/tencent/mobileqq/activity/richmedia/view/CameraFilterGLView:a	(I)Z
    //   132: ifne +304 -> 436
    //   135: aload 6
    //   137: iload 4
    //   139: invokestatic 151	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   142: astore 6
    //   144: new 48	java/io/File
    //   147: dup
    //   148: aload_3
    //   149: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   152: astore 5
    //   154: aload 9
    //   156: astore_0
    //   157: new 153	java/io/BufferedOutputStream
    //   160: dup
    //   161: new 155	java/io/FileOutputStream
    //   164: dup
    //   165: aload 5
    //   167: invokespecial 158	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   170: invokespecial 161	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   173: astore 5
    //   175: aload 6
    //   177: ifnull +21 -> 198
    //   180: aload 6
    //   182: getstatic 167	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   185: bipush 60
    //   187: aload 5
    //   189: invokevirtual 171	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   192: pop
    //   193: aload 5
    //   195: invokevirtual 174	java/io/BufferedOutputStream:flush	()V
    //   198: aload 5
    //   200: ifnull +8 -> 208
    //   203: aload 5
    //   205: invokevirtual 177	java/io/BufferedOutputStream:close	()V
    //   208: aload_3
    //   209: astore_0
    //   210: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq -128 -> 85
    //   216: ldc 8
    //   218: iconst_2
    //   219: new 53	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   226: ldc -49
    //   228: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_3
    //   232: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc -47
    //   237: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_3
    //   241: invokestatic 214	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   244: invokevirtual 217	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   247: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload_3
    //   254: areturn
    //   255: astore 6
    //   257: aload 7
    //   259: astore 5
    //   261: aload 5
    //   263: astore_0
    //   264: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +32 -> 299
    //   270: aload 5
    //   272: astore_0
    //   273: ldc 8
    //   275: iconst_2
    //   276: new 53	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   283: ldc -37
    //   285: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload 6
    //   290: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload 5
    //   301: ifnull -93 -> 208
    //   304: aload 5
    //   306: invokevirtual 177	java/io/BufferedOutputStream:close	()V
    //   309: goto -101 -> 208
    //   312: astore_0
    //   313: goto -105 -> 208
    //   316: astore 6
    //   318: aload 8
    //   320: astore 5
    //   322: aload 5
    //   324: astore_0
    //   325: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   328: ifeq +32 -> 360
    //   331: aload 5
    //   333: astore_0
    //   334: ldc 8
    //   336: iconst_2
    //   337: new 53	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   344: ldc -35
    //   346: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload 6
    //   351: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: aload 5
    //   362: ifnull -154 -> 208
    //   365: aload 5
    //   367: invokevirtual 177	java/io/BufferedOutputStream:close	()V
    //   370: goto -162 -> 208
    //   373: astore_0
    //   374: goto -166 -> 208
    //   377: astore 5
    //   379: aload_0
    //   380: astore_3
    //   381: aload 5
    //   383: astore_0
    //   384: aload_3
    //   385: ifnull +7 -> 392
    //   388: aload_3
    //   389: invokevirtual 177	java/io/BufferedOutputStream:close	()V
    //   392: aload_0
    //   393: athrow
    //   394: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq -189 -> 208
    //   400: ldc 8
    //   402: iconst_2
    //   403: ldc -33
    //   405: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: goto -200 -> 208
    //   411: astore_0
    //   412: goto -204 -> 208
    //   415: astore_3
    //   416: goto -24 -> 392
    //   419: astore_0
    //   420: aload 5
    //   422: astore_3
    //   423: goto -39 -> 384
    //   426: astore 6
    //   428: goto -106 -> 322
    //   431: astore 6
    //   433: goto -172 -> 261
    //   436: goto -292 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	439	0	paramString1	String
    //   0	439	1	paramInt1	int
    //   0	439	2	paramInt2	int
    //   0	439	3	paramString2	String
    //   0	439	4	paramInt3	int
    //   0	439	5	paramConfig	Bitmap.Config
    //   16	165	6	localBitmap	Bitmap
    //   255	34	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   316	34	6	localIOException1	java.io.IOException
    //   426	1	6	localIOException2	java.io.IOException
    //   431	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   7	251	7	localObject1	Object
    //   1	318	8	localObject2	Object
    //   4	151	9	localObject3	Object
    //   25	88	10	i	int
    // Exception table:
    //   from	to	target	type
    //   9	18	87	java/lang/Throwable
    //   18	27	104	java/lang/UnsatisfiedLinkError
    //   157	175	255	java/io/FileNotFoundException
    //   304	309	312	java/io/IOException
    //   157	175	316	java/io/IOException
    //   365	370	373	java/io/IOException
    //   157	175	377	finally
    //   264	270	377	finally
    //   273	299	377	finally
    //   325	331	377	finally
    //   334	360	377	finally
    //   203	208	411	java/io/IOException
    //   388	392	415	java/io/IOException
    //   180	198	419	finally
    //   180	198	426	java/io/IOException
    //   180	198	431	java/io/FileNotFoundException
  }
  
  private static native int nativeGenCover(Bitmap paramBitmap, int paramInt1, int paramInt2);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\cover\RecordThumbnailUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */