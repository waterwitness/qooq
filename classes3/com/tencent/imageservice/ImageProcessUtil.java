package com.tencent.imageservice;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.util.Log;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import java.io.IOException;

public class ImageProcessUtil
{
  private static boolean a = false;
  
  static
  {
    try
    {
      System.loadLibrary("pixelutils");
      a = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Log.w("ImageProcessUtil", localUnsatisfiedLinkError.toString());
      return;
    }
    catch (Exception localException)
    {
      Log.w("ImageProcessUtil", localException.toString());
    }
  }
  
  private static int a(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      switch (paramString.getAttributeInt("Orientation", 0))
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      }
    }
    catch (IOException paramString)
    {
      ImageProcessService.a.enable(2048);
      Log.w("ImageProcessService", "calculateRotateDegree() EXIF_NULL " + paramString.getMessage());
      return 0;
    }
    return 90;
    return 180;
    return 270;
  }
  
  /* Error */
  public static boolean bitmapToFile(Bitmap paramBitmap, String paramString1, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +27 -> 31
    //   7: ldc 94
    //   9: putstatic 98	com/tencent/imageservice/ImageProcessService:b	Ljava/lang/String;
    //   12: ldc 65
    //   14: getstatic 98	com/tencent/imageservice/ImageProcessService:b	Ljava/lang/String;
    //   17: invokestatic 34	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   20: pop
    //   21: getstatic 57	com/tencent/imageservice/ImageProcessService:a	Lcom/tencent/imageservice/Milestone;
    //   24: ldc 99
    //   26: invokevirtual 63	com/tencent/imageservice/Milestone:enable	(I)V
    //   29: iconst_0
    //   30: ireturn
    //   31: new 101	java/io/File
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore 6
    //   41: new 101	java/io/File
    //   44: dup
    //   45: new 67	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   52: aload 6
    //   54: invokevirtual 106	java/io/File:getParent	()Ljava/lang/String;
    //   57: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: getstatic 109	java/io/File:separator	Ljava/lang/String;
    //   63: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokestatic 113	java/lang/System:currentTimeMillis	()J
    //   69: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: ldc 118
    //   74: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_0
    //   78: invokevirtual 122	java/lang/Object:hashCode	()I
    //   81: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: astore 7
    //   92: ldc 65
    //   94: new 67	java/lang/StringBuilder
    //   97: dup
    //   98: ldc 127
    //   100: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   103: aload 7
    //   105: invokevirtual 130	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   108: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 34	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   117: pop
    //   118: iload_3
    //   119: ifeq +222 -> 341
    //   122: getstatic 136	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   125: astore_1
    //   126: aload 5
    //   128: ifnull +220 -> 348
    //   131: aload 5
    //   133: ldc -118
    //   135: invokevirtual 144	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   138: ifne +13 -> 151
    //   141: aload 5
    //   143: ldc -110
    //   145: invokevirtual 144	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   148: ifeq +200 -> 348
    //   151: iconst_1
    //   152: istore 8
    //   154: aload_1
    //   155: astore 5
    //   157: getstatic 152	android/os/Build$VERSION:SDK_INT	I
    //   160: bipush 14
    //   162: if_icmplt +53 -> 215
    //   165: aload_1
    //   166: astore 5
    //   168: iload 8
    //   170: ifeq +45 -> 215
    //   173: aload_1
    //   174: astore 5
    //   176: iload 4
    //   178: ifeq +37 -> 215
    //   181: ldc -124
    //   183: ldc -102
    //   185: invokevirtual 160	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   188: aconst_null
    //   189: invokevirtual 166	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   192: astore 5
    //   194: aload 5
    //   196: instanceof 132
    //   199: ifeq +418 -> 617
    //   202: aload 5
    //   204: checkcast 132	android/graphics/Bitmap$CompressFormat
    //   207: astore 5
    //   209: aload 5
    //   211: astore_1
    //   212: aload_1
    //   213: astore 5
    //   215: ldc 65
    //   217: new 67	java/lang/StringBuilder
    //   220: dup
    //   221: ldc -88
    //   223: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: aload 5
    //   228: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 174	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   237: pop
    //   238: new 176	java/io/BufferedOutputStream
    //   241: dup
    //   242: new 178	java/io/FileOutputStream
    //   245: dup
    //   246: aload 7
    //   248: invokespecial 181	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   251: invokespecial 184	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   254: astore_1
    //   255: aload_0
    //   256: aload 5
    //   258: iload_2
    //   259: aload_1
    //   260: invokevirtual 190	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   263: istore_3
    //   264: aload_1
    //   265: invokevirtual 193	java/io/BufferedOutputStream:flush	()V
    //   268: aload_1
    //   269: invokevirtual 196	java/io/BufferedOutputStream:close	()V
    //   272: ldc 65
    //   274: ldc -58
    //   276: invokestatic 174	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   279: pop
    //   280: iload_3
    //   281: ifeq +274 -> 555
    //   284: aload 7
    //   286: aload 6
    //   288: invokevirtual 202	java/io/File:renameTo	(Ljava/io/File;)Z
    //   291: ifne +48 -> 339
    //   294: aload 7
    //   296: invokevirtual 206	java/io/File:delete	()Z
    //   299: pop
    //   300: new 67	java/lang/StringBuilder
    //   303: dup
    //   304: ldc -48
    //   306: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   309: aload 6
    //   311: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: putstatic 98	com/tencent/imageservice/ImageProcessService:b	Ljava/lang/String;
    //   320: ldc 65
    //   322: getstatic 98	com/tencent/imageservice/ImageProcessService:b	Ljava/lang/String;
    //   325: invokestatic 34	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   328: pop
    //   329: getstatic 57	com/tencent/imageservice/ImageProcessService:a	Lcom/tencent/imageservice/Milestone;
    //   332: ldc -47
    //   334: invokevirtual 63	com/tencent/imageservice/Milestone:enable	(I)V
    //   337: iconst_0
    //   338: istore_3
    //   339: iload_3
    //   340: ireturn
    //   341: getstatic 212	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   344: astore_1
    //   345: goto -219 -> 126
    //   348: iconst_0
    //   349: istore 8
    //   351: goto -197 -> 154
    //   354: astore_0
    //   355: new 67	java/lang/StringBuilder
    //   358: dup
    //   359: ldc -42
    //   361: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   364: aload_0
    //   365: invokevirtual 215	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   368: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: putstatic 98	com/tencent/imageservice/ImageProcessService:b	Ljava/lang/String;
    //   377: ldc 65
    //   379: getstatic 98	com/tencent/imageservice/ImageProcessService:b	Ljava/lang/String;
    //   382: invokestatic 34	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   385: pop
    //   386: getstatic 57	com/tencent/imageservice/ImageProcessService:a	Lcom/tencent/imageservice/Milestone;
    //   389: ldc -40
    //   391: invokevirtual 63	com/tencent/imageservice/Milestone:enable	(I)V
    //   394: iconst_0
    //   395: istore_3
    //   396: goto -124 -> 272
    //   399: astore_1
    //   400: aconst_null
    //   401: astore_0
    //   402: new 67	java/lang/StringBuilder
    //   405: dup
    //   406: ldc -38
    //   408: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   411: aload_1
    //   412: invokevirtual 215	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   415: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: putstatic 98	com/tencent/imageservice/ImageProcessService:b	Ljava/lang/String;
    //   424: ldc 65
    //   426: getstatic 98	com/tencent/imageservice/ImageProcessService:b	Ljava/lang/String;
    //   429: invokestatic 34	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   432: pop
    //   433: getstatic 57	com/tencent/imageservice/ImageProcessService:a	Lcom/tencent/imageservice/Milestone;
    //   436: ldc -37
    //   438: invokevirtual 63	com/tencent/imageservice/Milestone:enable	(I)V
    //   441: aload_0
    //   442: ifnull +170 -> 612
    //   445: aload_0
    //   446: invokevirtual 196	java/io/BufferedOutputStream:close	()V
    //   449: iconst_0
    //   450: istore_3
    //   451: goto -179 -> 272
    //   454: astore_0
    //   455: new 67	java/lang/StringBuilder
    //   458: dup
    //   459: ldc -42
    //   461: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   464: aload_0
    //   465: invokevirtual 215	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   468: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: putstatic 98	com/tencent/imageservice/ImageProcessService:b	Ljava/lang/String;
    //   477: ldc 65
    //   479: getstatic 98	com/tencent/imageservice/ImageProcessService:b	Ljava/lang/String;
    //   482: invokestatic 34	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   485: pop
    //   486: getstatic 57	com/tencent/imageservice/ImageProcessService:a	Lcom/tencent/imageservice/Milestone;
    //   489: ldc -40
    //   491: invokevirtual 63	com/tencent/imageservice/Milestone:enable	(I)V
    //   494: iconst_0
    //   495: istore_3
    //   496: goto -224 -> 272
    //   499: astore_1
    //   500: aconst_null
    //   501: astore_0
    //   502: aload_0
    //   503: ifnull +7 -> 510
    //   506: aload_0
    //   507: invokevirtual 196	java/io/BufferedOutputStream:close	()V
    //   510: aload_1
    //   511: athrow
    //   512: astore_0
    //   513: new 67	java/lang/StringBuilder
    //   516: dup
    //   517: ldc -42
    //   519: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   522: aload_0
    //   523: invokevirtual 215	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   526: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: putstatic 98	com/tencent/imageservice/ImageProcessService:b	Ljava/lang/String;
    //   535: ldc 65
    //   537: getstatic 98	com/tencent/imageservice/ImageProcessService:b	Ljava/lang/String;
    //   540: invokestatic 34	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   543: pop
    //   544: getstatic 57	com/tencent/imageservice/ImageProcessService:a	Lcom/tencent/imageservice/Milestone;
    //   547: ldc -40
    //   549: invokevirtual 63	com/tencent/imageservice/Milestone:enable	(I)V
    //   552: goto -42 -> 510
    //   555: aload 7
    //   557: invokevirtual 206	java/io/File:delete	()Z
    //   560: pop
    //   561: goto -222 -> 339
    //   564: astore 5
    //   566: aload_1
    //   567: astore_0
    //   568: aload 5
    //   570: astore_1
    //   571: goto -69 -> 502
    //   574: astore_1
    //   575: goto -73 -> 502
    //   578: astore 5
    //   580: aload_1
    //   581: astore_0
    //   582: aload 5
    //   584: astore_1
    //   585: goto -183 -> 402
    //   588: astore 5
    //   590: aload_1
    //   591: astore 5
    //   593: goto -378 -> 215
    //   596: astore 5
    //   598: aload_1
    //   599: astore 5
    //   601: goto -386 -> 215
    //   604: astore 5
    //   606: aload_1
    //   607: astore 5
    //   609: goto -394 -> 215
    //   612: iconst_0
    //   613: istore_3
    //   614: goto -342 -> 272
    //   617: goto -405 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	620	0	paramBitmap	Bitmap
    //   0	620	1	paramString1	String
    //   0	620	2	paramInt	int
    //   0	620	3	paramBoolean1	boolean
    //   0	620	4	paramBoolean2	boolean
    //   0	620	5	paramString2	String
    //   39	271	6	localFile1	java.io.File
    //   90	466	7	localFile2	java.io.File
    //   152	198	8	i	int
    // Exception table:
    //   from	to	target	type
    //   268	272	354	java/lang/Exception
    //   238	255	399	java/lang/Exception
    //   445	449	454	java/lang/Exception
    //   238	255	499	finally
    //   506	510	512	java/lang/Exception
    //   255	268	564	finally
    //   402	441	574	finally
    //   255	268	578	java/lang/Exception
    //   181	209	588	java/lang/IllegalAccessException
    //   181	209	596	java/lang/IllegalArgumentException
    //   181	209	604	java/lang/NoSuchFieldException
  }
  
  public static String compressFile(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    ImageProcessService.a.enable(1);
    BitmapFactory.Options localOptions1 = decodeBitmapOptions(paramString1);
    boolean bool3 = "image/png".equalsIgnoreCase(localOptions1.outMimeType);
    Object localObject1 = localOptions1.outMimeType;
    localObject1 = new IUploadConfig.UploadImageSize(localOptions1.outWidth, localOptions1.outHeight, 100);
    if ((((IUploadConfig.UploadImageSize)localObject1).width == 0) || (((IUploadConfig.UploadImageSize)localObject1).height == 0))
    {
      ImageProcessService.a.enable(2);
      ImageProcessService.b = "decodeBitmapSize=0";
      Log.w("ImageProcessService", ImageProcessService.b);
      return null;
    }
    int j = Math.min(((IUploadConfig.UploadImageSize)localObject1).width / paramInt1, ((IUploadConfig.UploadImageSize)localObject1).height / paramInt2);
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    ImageProcessService.a.enable(4);
    BitmapFactory.Options localOptions2 = BitmapUtils.getOptions();
    localOptions2.inSampleSize = i;
    Log.v("ImageProcessService", "decodeFileWithRetry sampleSize=" + i);
    Object localObject2 = decodeFileWithRetry(paramString1, localOptions2);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      ImageProcessService.a.enable(128);
      ImageProcessService.a.disableAll(new int[] { 8, 16, 32, 64 });
      localOptions2.inSampleSize += 1;
      localObject1 = decodeFileWithRetry(paramString1, localOptions2);
      Log.i("ImageProcessService", "re decodeFileWithRetry");
    }
    ImageProcessService.a.enable(256);
    if (localObject1 == null)
    {
      ImageProcessService.b = "decodeFileWithRetry=null";
      Log.w("ImageProcessService", ImageProcessService.b);
      ImageProcessService.a.enable(512);
      return null;
    }
    i = ((Bitmap)localObject1).getWidth();
    j = ((Bitmap)localObject1).getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    if (f1 > 1.0F) {
      f1 = 1.0F;
    }
    for (;;)
    {
      if (f2 > 1.0F) {
        f2 = 1.0F;
      }
      for (;;)
      {
        localObject2 = new Matrix();
        ((Matrix)localObject2).postScale(f1, f2);
        if (paramBoolean1)
        {
          ImageProcessService.a.enable(1024);
          int k = a(paramString1);
          if (k != 0)
          {
            ((Matrix)localObject2).postRotate(k, paramInt1 / 2, paramInt2 / 2);
            ImageProcessService.a.enable(4096);
          }
        }
        boolean bool2 = false;
        boolean bool1 = false;
        paramBoolean1 = bool2;
        long l;
        if (bool3)
        {
          paramBoolean1 = bool2;
          if (isAlphaChanelOpen(paramString1))
          {
            l = System.currentTimeMillis();
            paramBoolean1 = bool1;
            if (!a) {}
          }
        }
        try
        {
          paramBoolean1 = hasAlphaZero((Bitmap)localObject1);
          Log.w("ImageProcessService", "hasAlphaZero:" + paramBoolean1 + " cost: " + (System.currentTimeMillis() - l));
          localObject2 = transformBitmap((Bitmap)localObject1, i, j, (Matrix)localObject2);
          ImageProcessService.a.enable(262144);
          paramString1 = (String)localObject2;
          if (localObject2 == null)
          {
            ImageProcessService.a.enable(524288);
            paramString1 = (String)localObject1;
          }
          if (paramString1 != localObject1) {
            ((Bitmap)localObject1).recycle();
          }
          Log.v("ImageProcessService", "transformBitmap scaleWidth=" + f1 + " scaleHeight=" + f2);
          paramBoolean1 = bitmapToFile(paramString1, paramString2, paramInt3, paramBoolean1, paramBoolean2, localOptions1.outMimeType);
          paramString1.recycle();
          if (paramBoolean1)
          {
            ImageProcessService.a.enable(8388608);
            return paramString2;
          }
          ImageProcessService.b = "bitmapToFile=false";
          Log.w("ImageProcessService", ImageProcessService.b);
          ImageProcessService.a.enable(16777216);
          return null;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramBoolean1 = bool1;
          }
        }
      }
    }
  }
  
  public static BitmapFactory.Options decodeBitmapOptions(String paramString)
  {
    BitmapFactory.Options localOptions = BitmapUtils.getOptions();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return localOptions;
  }
  
  public static IUploadConfig.UploadImageSize decodeBitmapSize(String paramString)
  {
    BitmapFactory.Options localOptions = BitmapUtils.getOptions();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return new IUploadConfig.UploadImageSize(localOptions.outWidth, localOptions.outHeight, 100);
  }
  
  public static Bitmap decodeFileWithRetry(String paramString, BitmapFactory.Options paramOptions)
  {
    ImageProcessService.a.enable(8);
    String str = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ImageProcessService.b = "decodeFile=oom";
      Log.w("ImageProcessService", ImageProcessService.b);
      ImageProcessService.a.enable(16);
      System.gc();
      System.gc();
    }
    try
    {
      Thread.sleep(1000L);
      try
      {
        paramString = BitmapFactory.decodeFile(paramString, paramOptions);
        str = paramString;
        ImageProcessService.a.enable(32);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        ImageProcessService.b = "decodeFile2=oom";
        Log.w("ImageProcessService", ImageProcessService.b);
        ImageProcessService.a.enable(64);
        System.gc();
        System.gc();
        try
        {
          Thread.sleep(1000L);
          return str;
        }
        catch (InterruptedException paramString)
        {
          Log.w("ImageProcessService", paramString);
          return str;
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Log.w("ImageProcessService", localInterruptedException);
      }
    }
  }
  
  public static String decodeMimeType(String paramString)
  {
    BitmapFactory.Options localOptions = BitmapUtils.getOptions();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return localOptions.outMimeType;
  }
  
  private static native boolean hasAlphaZero(Bitmap paramBitmap);
  
  public static boolean isAlphaChanelOpen(String paramString)
  {
    return new PNGReader().isTransparentPng(paramString);
  }
  
  public static Bitmap transformBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, Matrix paramMatrix)
  {
    ImageProcessService.a.enable(8192);
    Object localObject1 = null;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt1, paramInt2, paramMatrix, true);
      ImageProcessService.b = "createBitmap=oom" + localThrowable2.toString();
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        ImageProcessService.a.enable(16384);
        return localBitmap;
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          Object localObject2 = localThrowable2;
          Object localObject3 = localThrowable3;
        }
      }
      localThrowable2 = localThrowable2;
    }
    Log.w("ImageProcessService", ImageProcessService.b);
    ImageProcessService.a.enable(32768);
    System.gc();
    System.gc();
    for (;;)
    {
      try
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt1, paramInt2, paramMatrix, true);
      }
      catch (Throwable paramBitmap)
      {
        paramMatrix = localThrowable1;
        localObject2 = paramBitmap;
        continue;
      }
      try
      {
        ImageProcessService.a.enable(65536);
        return paramBitmap;
      }
      catch (Throwable localThrowable1)
      {
        paramMatrix = paramBitmap;
        ImageProcessService.b = "createBitmap2=oom" + localThrowable1.toString();
        Log.w("ImageProcessService", ImageProcessService.b);
        ImageProcessService.a.enable(131072);
        System.gc();
        return paramMatrix;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\imageservice\ImageProcessUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */