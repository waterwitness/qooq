package com.tencent.mobileqq.activity.aio.photo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.JpegExifReader;
import com.tencent.image.LocaleFileDownloader;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.SliceBitmap;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.VideoDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.JpegDecompressor;
import com.tencent.mobileqq.pic.JpegOptions;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class PhotoDecoder
  extends LocaleFileDownloader
{
  private static final float jdField_a_of_type_Float = 1.5F;
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  private static final int e = 5242880;
  private BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  private float b;
  
  public PhotoDecoder(BaseApplicationImpl paramBaseApplicationImpl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramBaseApplicationImpl;
    this.b = paramBaseApplicationImpl.getResources().getDisplayMetrics().density;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt6 == 2) || (paramInt3 == Integer.MAX_VALUE) || (paramInt4 == Integer.MAX_VALUE))
    {
      paramInt2 = 1;
      return paramInt2;
    }
    float f;
    if (paramInt6 == 1) {
      switch (paramInt5)
      {
      default: 
        paramInt5 = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = paramInt5;
        paramInt6 = paramInt1;
        paramInt5 = paramInt2;
        if (paramInt2 > paramInt3 * 2)
        {
          paramInt6 = paramInt1;
          paramInt5 = paramInt2;
          if (paramInt1 > paramInt4)
          {
            paramInt5 = (int)(paramInt2 * this.b + 0.5D);
            paramInt6 = (int)(paramInt1 * this.b + 0.5D);
          }
        }
        paramInt1 = paramInt6 * paramInt3 / paramInt5;
        if (paramInt5 >= paramInt3) {
          if (paramInt4 >= paramInt1) {
            f = paramInt3 / paramInt5;
          }
        }
        break;
      }
    }
    for (;;)
    {
      label151:
      if (this.b > 2.0F) {}
      for (paramInt1 = (int)(1.0F / f * 3.0F / 4.0F);; paramInt1 = (int)(1.0F / f))
      {
        if (paramInt1 > 1) {
          break label319;
        }
        return 1;
        break;
        if (paramInt4 * 1.5F >= paramInt1)
        {
          f = paramInt4 / paramInt6;
          break label151;
        }
        f = paramInt3 / paramInt5;
        break label151;
        if (paramInt6 < paramInt4)
        {
          if (paramInt4 >= paramInt1)
          {
            if (paramInt5 * 1.5F < paramInt3) {
              break label481;
            }
            f = paramInt3 / paramInt5;
            break label151;
          }
          if (paramInt6 * 1.5F < paramInt4) {
            break label481;
          }
          f = paramInt4 / paramInt6;
          break label151;
        }
        if ((paramInt6 <= paramInt4) || (paramInt6 >= paramInt4 * 1.5F)) {
          break label481;
        }
        f = paramInt4 / paramInt6;
        break label151;
      }
      label319:
      if (paramInt1 > 64)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "the pic it fxxking large.....");
        }
        return 64;
      }
      paramInt3 = 64;
      for (;;)
      {
        if (paramInt3 == 0) {
          break label369;
        }
        paramInt4 = paramInt1 & paramInt3;
        paramInt2 = paramInt4;
        if (paramInt4 != 0) {
          break;
        }
        paramInt3 >>= 1;
      }
      label369:
      return 1;
      if ((paramInt3 == 0) || (paramInt4 == 0) || (paramInt3 == -1) || (paramInt4 == -1)) {
        return 1;
      }
      int i = 1;
      paramInt5 = paramInt2;
      paramInt6 = paramInt1;
      paramInt1 = i;
      label405:
      if (paramInt5 <= paramInt4)
      {
        paramInt2 = paramInt1;
        if (paramInt6 <= paramInt3) {
          break;
        }
      }
      i = Math.round(paramInt5 / paramInt4);
      paramInt2 = Math.round(paramInt6 / paramInt3);
      if (i > paramInt2) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (i < 2) {
          break;
        }
        paramInt6 /= 2;
        paramInt5 /= 2;
        paramInt1 *= 2;
        break label405;
        i = paramInt2;
      }
      label481:
      f = 1.0F;
    }
  }
  
  private RoundRectBitmap a(Bitmap paramBitmap, int paramInt)
  {
    try
    {
      RoundRectBitmap localRoundRectBitmap = new RoundRectBitmap(paramBitmap, paramInt);
      return localRoundRectBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return new RoundRectBitmap(paramBitmap, 12.0F);
  }
  
  private Object a(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    int i = 0;
    if (paramDownloadParams.tag != null) {
      i = ((Integer)paramDownloadParams.tag).intValue();
    }
    if (i == 3)
    {
      paramURLDrawableHandler = ThumbnailUtils.createVideoThumbnail(paramFile.getAbsolutePath(), 1);
      int j = paramURLDrawableHandler.getWidth();
      i = paramURLDrawableHandler.getHeight();
      float f = Gallery.a(j, i, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, null);
      j = (int)(j * f);
      i = (int)(i * f);
      return ThumbnailUtils.createVideoThumbnail(paramFile.getAbsolutePath(), 1);
    }
    return null;
  }
  
  private Object a(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    j = 0;
    try
    {
      l1 = SystemClock.uptimeMillis();
      localObject = new byte[2];
      localFileInputStream.read((byte[])localObject);
      int m = localObject[0];
      int n = localObject[1];
      paramURLDrawableHandler = Bitmap.Config.ARGB_8888;
      i = 0;
      k = 0;
      switch (m << 8 & 0xFF00 | n & 0xFF)
      {
      }
    }
    finally
    {
      for (;;)
      {
        long l1;
        Object localObject;
        int k;
        byte[] arrayOfByte;
        paramInt = j;
        continue;
        continue;
        paramURLDrawableHandler = null;
        continue;
        int i = k;
      }
    }
    arrayOfByte = new byte[(int)paramFile.length()];
    System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
    localFileInputStream.read(arrayOfByte, localObject.length, localFileInputStream.available());
    localFileInputStream.close();
    for (;;)
    {
      try
      {
        long l2;
        if (QLog.isColorLevel())
        {
          l2 = SystemClock.uptimeMillis();
          QLog.d("PEAK", 2, "read file to memory cost: " + (l2 - l1));
        }
        l1 = SystemClock.uptimeMillis();
        localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        localOptions.inPreferredConfig = paramURLDrawableHandler;
        localOptions.inDensity = 160;
        localOptions.inTargetDensity = 160;
        localOptions.inScreenDensity = 160;
        localOptions.inPurgeable = true;
        localOptions.inInputShareable = true;
        SafeBitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
        j = localOptions.outWidth;
        k = localOptions.outHeight;
        if (i != 0) {
          paramDownloadParams.outOrientation = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
        }
        if (QLog.isColorLevel())
        {
          l2 = SystemClock.uptimeMillis();
          QLog.d("PEAK", 2, "read size & exif cost: " + (l2 - l1));
        }
        localOptions.inJustDecodeBounds = false;
        paramInt = a(j, k, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, paramDownloadParams.outOrientation, paramInt);
        try
        {
          localOptions.inSampleSize = paramInt;
          localObject = SafeBitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
          ((Bitmap)localObject).setDensity(160);
          if (Build.VERSION.SDK_INT < 11) {
            continue;
          }
          boolean bool = SliceBitmap.needSlice((Bitmap)localObject);
          if (!bool) {
            continue;
          }
          try
          {
            paramURLDrawableHandler = new SliceBitmap((Bitmap)localObject);
            ((Bitmap)localObject).recycle();
            if (localOptions.inSampleSize > 1)
            {
              if (!paramDownloadParams.mAutoScaleByDensity) {
                break label805;
              }
              paramDownloadParams.outWidth = ((int)Math.ceil(j * this.b));
              paramDownloadParams.outHeight = ((int)Math.ceil(k * this.b));
            }
            if (QLog.isColorLevel()) {
              QLog.d("PEAK", 2, "image file size:" + paramFile.length() + " , bound:" + j + "x" + k + " , sampleSize: " + localOptions.inSampleSize);
            }
            return paramURLDrawableHandler;
          }
          catch (Exception paramURLDrawableHandler)
          {
            if (localObject == null) {
              continue;
            }
            ((Bitmap)localObject).recycle();
            throw new OutOfMemoryError("slice failed.");
          }
          i = 1;
          paramURLDrawableHandler = Bitmap.Config.RGB_565;
        }
        catch (OutOfMemoryError paramURLDrawableHandler)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("PEAK", 2, "DecodeFile ERROR,oom retryCount=" + 1 + ",options.inSampleSize=" + localOptions.inSampleSize + ",url=" + paramDownloadParams.urlStr + ",oom.msg:" + paramURLDrawableHandler.getMessage());
          paramInt *= 2;
          System.gc();
          Thread.yield();
          System.gc();
          if (paramInt > 8) {
            break label842;
          }
        }
        localFileInputStream.close();
        return null;
      }
      finally
      {
        BitmapFactory.Options localOptions;
        RoundRectBitmap localRoundRectBitmap;
        paramInt = 1;
        if (paramInt != 0) {
          continue;
        }
        localFileInputStream.close();
      }
      paramURLDrawableHandler = null;
      continue;
      if ((paramDownloadParams.mExtraInfo != null) && (PhotoDecoder.DownloadParamsExtraInfo.class.isInstance(paramDownloadParams.mExtraInfo)))
      {
        paramURLDrawableHandler = (PhotoDecoder.DownloadParamsExtraInfo)paramDownloadParams.mExtraInfo;
        if (paramURLDrawableHandler.a <= 0) {
          break label845;
        }
        localRoundRectBitmap = a((Bitmap)localObject, paramURLDrawableHandler.a);
        paramURLDrawableHandler = localRoundRectBitmap;
        if (!localRoundRectBitmap.mBitmap.equals(localObject))
        {
          ((Bitmap)localObject).recycle();
          paramURLDrawableHandler = localRoundRectBitmap;
        }
      }
      else
      {
        paramURLDrawableHandler = (URLDrawableHandler)localObject;
        continue;
        label805:
        double d1 = j;
        paramDownloadParams.outWidth = ((int)Math.ceil(d1));
        paramDownloadParams.outHeight = ((int)Math.ceil(k));
      }
    }
  }
  
  private Object b(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    paramURLDrawableHandler = new FileInputStream(paramFile);
    try
    {
      localObject = new byte[2];
      paramURLDrawableHandler.read((byte[])localObject);
      k = localObject[0];
      m = localObject[1];
      paramURLDrawableHandler.close();
      localObject = new FileInputStream(paramFile);
    }
    finally
    {
      for (;;)
      {
        int k;
        int m;
        label132:
        BitmapFactory.Options localOptions;
        paramDownloadParams = paramURLDrawableHandler;
        paramInt = 0;
      }
    }
    try
    {
      paramURLDrawableHandler = Bitmap.Config.ARGB_8888;
      i = 0;
      j = 0;
      switch (k << 8 & 0xFF00 | m & 0xFF)
      {
      }
    }
    finally
    {
      paramInt = 0;
      paramDownloadParams = (DownloadParams)localObject;
      break label668;
      paramURLDrawableHandler = null;
      break label321;
      paramURLDrawableHandler = null;
      break label321;
      i = j;
      break label132;
    }
    localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inPreferredConfig = paramURLDrawableHandler;
    localOptions.inDensity = 160;
    localOptions.inTargetDensity = 160;
    localOptions.inScreenDensity = 160;
    SafeBitmapFactory.decodeStream((InputStream)localObject, null, localOptions);
    j = localOptions.outWidth;
    k = localOptions.outHeight;
    ((InputStream)localObject).close();
    if (i != 0) {}
    for (;;)
    {
      Bitmap localBitmap;
      try
      {
        paramDownloadParams.outOrientation = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
        localOptions.inJustDecodeBounds = false;
        paramInt = a(j, k, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, paramDownloadParams.outOrientation, paramInt);
        i = 1;
        if (i > 3) {
          break label738;
        }
        try
        {
          localOptions.inSampleSize = paramInt;
          localBitmap = SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
          localBitmap.setDensity(160);
          if (Build.VERSION.SDK_INT < 11) {
            continue;
          }
          boolean bool = SliceBitmap.needSlice(localBitmap);
          if (!bool) {
            continue;
          }
          try
          {
            paramURLDrawableHandler = new SliceBitmap(localBitmap);
            localBitmap.recycle();
            label321:
            if (localOptions.inSampleSize > 1)
            {
              if (!paramDownloadParams.mAutoScaleByDensity) {
                break label685;
              }
              paramDownloadParams.outWidth = ((int)Math.ceil(j * this.b));
              paramDownloadParams.outHeight = ((int)Math.ceil(k * this.b));
            }
            if (QLog.isColorLevel()) {
              QLog.d("PEAK", 2, "image file size:" + paramFile.length() + " , bound:" + localOptions.outWidth + "x" + localOptions.outHeight + " , sampleSize: " + localOptions.inSampleSize);
            }
            return paramURLDrawableHandler;
          }
          catch (Exception paramURLDrawableHandler)
          {
            if (localBitmap == null) {
              continue;
            }
            localBitmap.recycle();
            throw new OutOfMemoryError("slice failed.");
          }
          i = 1;
          paramURLDrawableHandler = Bitmap.Config.RGB_565;
        }
        catch (OutOfMemoryError paramURLDrawableHandler)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("PEAK", 2, "DecodeFile ERROR,oom retryCount=" + i + ",options.inSampleSize=" + localOptions.inSampleSize + ",url=" + paramDownloadParams.urlStr + ",oom.msg:" + paramURLDrawableHandler.getMessage());
          System.gc();
          Thread.yield();
          System.gc();
          i += 1;
          paramInt *= 2;
        }
        ((InputStream)localObject).close();
        return null;
      }
      finally
      {
        RoundRectBitmap localRoundRectBitmap;
        paramInt = 1;
        paramDownloadParams = (DownloadParams)localObject;
        label668:
        if (paramInt != 0) {
          continue;
        }
        paramDownloadParams.close();
      }
      continue;
      if ((paramDownloadParams.mExtraInfo != null) && (PhotoDecoder.DownloadParamsExtraInfo.class.isInstance(paramDownloadParams.mExtraInfo)))
      {
        paramURLDrawableHandler = (PhotoDecoder.DownloadParamsExtraInfo)paramDownloadParams.mExtraInfo;
        if (paramURLDrawableHandler.a <= 0) {
          break label733;
        }
        localRoundRectBitmap = a(localBitmap, paramURLDrawableHandler.a);
        paramURLDrawableHandler = localRoundRectBitmap;
        if (!localRoundRectBitmap.mBitmap.equals(localBitmap))
        {
          localBitmap.recycle();
          paramURLDrawableHandler = localRoundRectBitmap;
        }
      }
      else
      {
        paramURLDrawableHandler = localBitmap;
        continue;
        label685:
        double d1 = j;
        paramDownloadParams.outWidth = ((int)Math.ceil(d1));
        paramDownloadParams.outHeight = ((int)Math.ceil(k));
      }
    }
  }
  
  /* Error */
  private Object c(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    // Byte code:
    //   0: new 134	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 137	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 10
    //   10: iconst_0
    //   11: istore 16
    //   13: iconst_0
    //   14: istore 15
    //   16: iload 16
    //   18: istore 13
    //   20: invokestatic 143	android/os/SystemClock:uptimeMillis	()J
    //   23: lstore 19
    //   25: iload 16
    //   27: istore 13
    //   29: iconst_2
    //   30: newarray <illegal type>
    //   32: astore 8
    //   34: iload 16
    //   36: istore 13
    //   38: aload 10
    //   40: aload 8
    //   42: invokevirtual 147	java/io/FileInputStream:read	([B)I
    //   45: pop
    //   46: aload 8
    //   48: iconst_0
    //   49: baload
    //   50: istore 17
    //   52: aload 8
    //   54: iconst_1
    //   55: baload
    //   56: istore 18
    //   58: iload 16
    //   60: istore 13
    //   62: getstatic 153	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   65: astore 7
    //   67: iconst_0
    //   68: istore 14
    //   70: iconst_0
    //   71: istore 13
    //   73: iload 17
    //   75: bipush 8
    //   77: ishl
    //   78: ldc -102
    //   80: iand
    //   81: iload 18
    //   83: sipush 255
    //   86: iand
    //   87: ior
    //   88: lookupswitch	default:+858->946, 8273:+323->411, 16973:+323->411, 18249:+335->423, 18761:+320->408, 19789:+320->408, 65496:+320->408
    //   148: iload 16
    //   150: istore 13
    //   152: aload_1
    //   153: invokevirtual 157	java/io/File:length	()J
    //   156: l2i
    //   157: newarray <illegal type>
    //   159: astore 12
    //   161: iload 16
    //   163: istore 13
    //   165: aload 8
    //   167: iconst_0
    //   168: aload 12
    //   170: iconst_0
    //   171: aload 8
    //   173: arraylength
    //   174: invokestatic 163	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   177: iload 16
    //   179: istore 13
    //   181: aload 10
    //   183: aload 12
    //   185: aload 8
    //   187: arraylength
    //   188: aload 10
    //   190: invokevirtual 166	java/io/FileInputStream:available	()I
    //   193: invokevirtual 169	java/io/FileInputStream:read	([BII)I
    //   196: pop
    //   197: iload 16
    //   199: istore 13
    //   201: aload 10
    //   203: invokevirtual 172	java/io/FileInputStream:close	()V
    //   206: iconst_1
    //   207: istore 15
    //   209: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +37 -> 249
    //   215: invokestatic 143	android/os/SystemClock:uptimeMillis	()J
    //   218: lstore 21
    //   220: ldc 65
    //   222: iconst_2
    //   223: new 174	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   230: ldc -79
    //   232: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: lload 21
    //   237: lload 19
    //   239: lsub
    //   240: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   243: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: invokestatic 143	android/os/SystemClock:uptimeMillis	()J
    //   252: lstore 19
    //   254: new 351	com/tencent/mobileqq/pic/JpegOptions
    //   257: dup
    //   258: invokespecial 352	com/tencent/mobileqq/pic/JpegOptions:<init>	()V
    //   261: astore 11
    //   263: aload 11
    //   265: iconst_1
    //   266: putfield 353	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   269: aload 11
    //   271: aload 7
    //   273: putfield 354	com/tencent/mobileqq/pic/JpegOptions:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   276: aload 12
    //   278: aload 11
    //   280: invokestatic 359	com/tencent/mobileqq/pic/JpegDecompressor:decodeByteArray	([BLcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   283: pop
    //   284: aload 11
    //   286: getfield 360	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   289: istore 16
    //   291: aload 11
    //   293: getfield 361	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   296: istore 17
    //   298: iload 14
    //   300: ifeq +14 -> 314
    //   303: aload_2
    //   304: aload_1
    //   305: invokevirtual 104	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   308: invokestatic 229	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   311: putfield 232	com/tencent/image/DownloadParams:outOrientation	I
    //   314: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +37 -> 354
    //   320: invokestatic 143	android/os/SystemClock:uptimeMillis	()J
    //   323: lstore 21
    //   325: ldc 65
    //   327: iconst_2
    //   328: new 174	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   335: ldc -22
    //   337: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: lload 21
    //   342: lload 19
    //   344: lsub
    //   345: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   348: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: aload 11
    //   356: iconst_0
    //   357: putfield 353	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   360: aload_0
    //   361: iload 16
    //   363: iload 17
    //   365: aload_2
    //   366: getfield 121	com/tencent/image/DownloadParams:reqWidth	I
    //   369: aload_2
    //   370: getfield 124	com/tencent/image/DownloadParams:reqHeight	I
    //   373: aload_2
    //   374: getfield 232	com/tencent/image/DownloadParams:outOrientation	I
    //   377: iload 4
    //   379: invokespecial 236	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:a	(IIIIII)I
    //   382: istore 13
    //   384: aload 11
    //   386: iload 13
    //   388: putfield 362	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   391: aload 12
    //   393: aload 11
    //   395: invokestatic 359	com/tencent/mobileqq/pic/JpegDecompressor:decodeByteArray	([BLcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   398: astore 8
    //   400: aload 8
    //   402: ifnonnull +28 -> 430
    //   405: aload 8
    //   407: areturn
    //   408: iconst_1
    //   409: istore 14
    //   411: iload 16
    //   413: istore 13
    //   415: getstatic 283	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   418: astore 7
    //   420: goto -272 -> 148
    //   423: aload 10
    //   425: invokevirtual 172	java/io/FileInputStream:close	()V
    //   428: aconst_null
    //   429: areturn
    //   430: aload 8
    //   432: sipush 160
    //   435: invokevirtual 243	android/graphics/Bitmap:setDensity	(I)V
    //   438: getstatic 248	android/os/Build$VERSION:SDK_INT	I
    //   441: bipush 11
    //   443: if_icmplt +345 -> 788
    //   446: aload 8
    //   448: invokestatic 254	com/tencent/image/SliceBitmap:needSlice	(Landroid/graphics/Bitmap;)Z
    //   451: istore 23
    //   453: iload 23
    //   455: ifeq +333 -> 788
    //   458: new 250	com/tencent/image/SliceBitmap
    //   461: dup
    //   462: aload 8
    //   464: invokespecial 257	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   467: astore 7
    //   469: aload 8
    //   471: invokevirtual 260	android/graphics/Bitmap:recycle	()V
    //   474: aload 11
    //   476: getfield 362	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   479: iconst_1
    //   480: if_icmple +44 -> 524
    //   483: aload_2
    //   484: getfield 263	com/tencent/image/DownloadParams:mAutoScaleByDensity	Z
    //   487: ifeq +404 -> 891
    //   490: aload_2
    //   491: iload 16
    //   493: i2f
    //   494: aload_0
    //   495: getfield 50	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:b	F
    //   498: fmul
    //   499: f2d
    //   500: invokestatic 267	java/lang/Math:ceil	(D)D
    //   503: d2i
    //   504: putfield 268	com/tencent/image/DownloadParams:outWidth	I
    //   507: aload_2
    //   508: iload 17
    //   510: i2f
    //   511: aload_0
    //   512: getfield 50	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:b	F
    //   515: fmul
    //   516: f2d
    //   517: invokestatic 267	java/lang/Math:ceil	(D)D
    //   520: d2i
    //   521: putfield 269	com/tencent/image/DownloadParams:outHeight	I
    //   524: aload 7
    //   526: astore 8
    //   528: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   531: ifeq -126 -> 405
    //   534: ldc 65
    //   536: iconst_2
    //   537: new 174	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   544: ldc_w 271
    //   547: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload_1
    //   551: invokevirtual 157	java/io/File:length	()J
    //   554: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   557: ldc_w 273
    //   560: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: iload 16
    //   565: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   568: ldc_w 278
    //   571: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: iload 17
    //   576: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   579: ldc_w 280
    //   582: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload 11
    //   587: getfield 362	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   590: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   593: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   599: aload 7
    //   601: areturn
    //   602: astore 7
    //   604: iconst_1
    //   605: istore 14
    //   607: iload 14
    //   609: istore 13
    //   611: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   614: ifeq +19 -> 633
    //   617: iload 14
    //   619: istore 13
    //   621: ldc_w 364
    //   624: iconst_2
    //   625: ldc_w 366
    //   628: aload 7
    //   630: invokestatic 370	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   633: iload 14
    //   635: istore 13
    //   637: aload_0
    //   638: aload_1
    //   639: aload_2
    //   640: aload_3
    //   641: iload 4
    //   643: invokespecial 372	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:a	(Ljava/io/File;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;I)Ljava/lang/Object;
    //   646: astore_1
    //   647: aload_1
    //   648: astore 8
    //   650: iload 14
    //   652: ifne -247 -> 405
    //   655: aload 10
    //   657: invokevirtual 172	java/io/FileInputStream:close	()V
    //   660: aload_1
    //   661: areturn
    //   662: astore 7
    //   664: aload 8
    //   666: ifnull +8 -> 674
    //   669: aload 8
    //   671: invokevirtual 260	android/graphics/Bitmap:recycle	()V
    //   674: new 79	java/lang/OutOfMemoryError
    //   677: dup
    //   678: ldc_w 285
    //   681: invokespecial 288	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   684: athrow
    //   685: astore 7
    //   687: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   690: ifeq +70 -> 760
    //   693: ldc 65
    //   695: iconst_2
    //   696: new 174	java/lang/StringBuilder
    //   699: dup
    //   700: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   703: ldc_w 290
    //   706: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: iconst_1
    //   710: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   713: ldc_w 292
    //   716: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: aload 11
    //   721: getfield 362	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   724: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   727: ldc_w 294
    //   730: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: aload_2
    //   734: getfield 298	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   737: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: ldc_w 300
    //   743: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: aload 7
    //   748: invokevirtual 303	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   751: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   757: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   760: iload 13
    //   762: iconst_2
    //   763: imul
    //   764: istore 13
    //   766: invokestatic 306	java/lang/System:gc	()V
    //   769: invokestatic 311	java/lang/Thread:yield	()V
    //   772: invokestatic 306	java/lang/System:gc	()V
    //   775: iload 13
    //   777: bipush 8
    //   779: if_icmpgt +158 -> 937
    //   782: aconst_null
    //   783: astore 7
    //   785: goto -311 -> 474
    //   788: aload_2
    //   789: getfield 314	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   792: ifnull +92 -> 884
    //   795: ldc_w 316
    //   798: aload_2
    //   799: getfield 314	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   802: invokevirtual 322	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   805: ifeq +79 -> 884
    //   808: aload_2
    //   809: getfield 314	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   812: checkcast 316	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder$DownloadParamsExtraInfo
    //   815: astore 7
    //   817: aload 7
    //   819: getfield 324	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder$DownloadParamsExtraInfo:a	I
    //   822: ifle +118 -> 940
    //   825: aload_0
    //   826: aload 8
    //   828: aload 7
    //   830: getfield 324	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder$DownloadParamsExtraInfo:a	I
    //   833: invokespecial 326	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:a	(Landroid/graphics/Bitmap;I)Lcom/tencent/image/RoundRectBitmap;
    //   836: astore 9
    //   838: aload 9
    //   840: astore 7
    //   842: aload 9
    //   844: getfield 330	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   847: aload 8
    //   849: invokevirtual 335	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   852: ifne -378 -> 474
    //   855: aload 8
    //   857: invokevirtual 260	android/graphics/Bitmap:recycle	()V
    //   860: aload 9
    //   862: astore 7
    //   864: goto -390 -> 474
    //   867: astore_1
    //   868: iload 15
    //   870: istore 4
    //   872: iload 4
    //   874: ifne +8 -> 882
    //   877: aload 10
    //   879: invokevirtual 172	java/io/FileInputStream:close	()V
    //   882: aload_1
    //   883: athrow
    //   884: aload 8
    //   886: astore 7
    //   888: goto -414 -> 474
    //   891: iload 16
    //   893: i2d
    //   894: dstore 5
    //   896: aload_2
    //   897: dload 5
    //   899: invokestatic 267	java/lang/Math:ceil	(D)D
    //   902: d2i
    //   903: putfield 268	com/tencent/image/DownloadParams:outWidth	I
    //   906: aload_2
    //   907: iload 17
    //   909: i2d
    //   910: invokestatic 267	java/lang/Math:ceil	(D)D
    //   913: d2i
    //   914: putfield 269	com/tencent/image/DownloadParams:outHeight	I
    //   917: goto -393 -> 524
    //   920: astore_1
    //   921: iload 13
    //   923: istore 4
    //   925: goto -53 -> 872
    //   928: astore 7
    //   930: iload 15
    //   932: istore 14
    //   934: goto -327 -> 607
    //   937: goto -553 -> 384
    //   940: aconst_null
    //   941: astore 7
    //   943: goto -469 -> 474
    //   946: iload 13
    //   948: istore 14
    //   950: goto -802 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	953	0	this	PhotoDecoder
    //   0	953	1	paramFile	File
    //   0	953	2	paramDownloadParams	DownloadParams
    //   0	953	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	953	4	paramInt	int
    //   894	4	5	d1	double
    //   65	535	7	localObject1	Object
    //   602	27	7	localRuntimeException1	RuntimeException
    //   662	1	7	localException	Exception
    //   685	62	7	localOutOfMemoryError	OutOfMemoryError
    //   783	104	7	localObject2	Object
    //   928	1	7	localRuntimeException2	RuntimeException
    //   941	1	7	localObject3	Object
    //   32	853	8	localObject4	Object
    //   836	25	9	localRoundRectBitmap	RoundRectBitmap
    //   8	870	10	localFileInputStream	FileInputStream
    //   261	459	11	localJpegOptions	JpegOptions
    //   159	233	12	arrayOfByte	byte[]
    //   18	929	13	i	int
    //   68	881	14	j	int
    //   14	917	15	k	int
    //   11	881	16	m	int
    //   50	858	17	n	int
    //   56	31	18	i1	int
    //   23	320	19	l1	long
    //   218	123	21	l2	long
    //   451	3	23	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   209	249	602	java/lang/RuntimeException
    //   249	298	602	java/lang/RuntimeException
    //   303	314	602	java/lang/RuntimeException
    //   314	354	602	java/lang/RuntimeException
    //   354	384	602	java/lang/RuntimeException
    //   384	400	602	java/lang/RuntimeException
    //   430	453	602	java/lang/RuntimeException
    //   458	474	602	java/lang/RuntimeException
    //   474	524	602	java/lang/RuntimeException
    //   528	599	602	java/lang/RuntimeException
    //   669	674	602	java/lang/RuntimeException
    //   674	685	602	java/lang/RuntimeException
    //   687	760	602	java/lang/RuntimeException
    //   766	775	602	java/lang/RuntimeException
    //   788	838	602	java/lang/RuntimeException
    //   842	860	602	java/lang/RuntimeException
    //   896	917	602	java/lang/RuntimeException
    //   458	474	662	java/lang/Exception
    //   384	400	685	java/lang/OutOfMemoryError
    //   430	453	685	java/lang/OutOfMemoryError
    //   458	474	685	java/lang/OutOfMemoryError
    //   669	674	685	java/lang/OutOfMemoryError
    //   674	685	685	java/lang/OutOfMemoryError
    //   788	838	685	java/lang/OutOfMemoryError
    //   842	860	685	java/lang/OutOfMemoryError
    //   209	249	867	finally
    //   249	298	867	finally
    //   303	314	867	finally
    //   314	354	867	finally
    //   354	384	867	finally
    //   384	400	867	finally
    //   430	453	867	finally
    //   458	474	867	finally
    //   474	524	867	finally
    //   528	599	867	finally
    //   669	674	867	finally
    //   674	685	867	finally
    //   687	760	867	finally
    //   766	775	867	finally
    //   788	838	867	finally
    //   842	860	867	finally
    //   896	917	867	finally
    //   20	25	920	finally
    //   29	34	920	finally
    //   38	46	920	finally
    //   62	67	920	finally
    //   152	161	920	finally
    //   165	177	920	finally
    //   181	197	920	finally
    //   201	206	920	finally
    //   415	420	920	finally
    //   611	617	920	finally
    //   621	633	920	finally
    //   637	647	920	finally
    //   20	25	928	java/lang/RuntimeException
    //   29	34	928	java/lang/RuntimeException
    //   38	46	928	java/lang/RuntimeException
    //   62	67	928	java/lang/RuntimeException
    //   152	161	928	java/lang/RuntimeException
    //   165	177	928	java/lang/RuntimeException
    //   181	197	928	java/lang/RuntimeException
    //   201	206	928	java/lang/RuntimeException
    //   415	420	928	java/lang/RuntimeException
  }
  
  private Object d(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    Object localObject1 = new FileInputStream(paramFile);
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject3 = new byte[2];
        ((InputStream)localObject1).read((byte[])localObject3);
        k = localObject3[0];
        m = localObject3[1];
        ((InputStream)localObject1).close();
        localObject1 = Bitmap.Config.ARGB_8888;
        i = 0;
        j = 0;
        switch (k << 8 & 0xFF00 | m & 0xFF)
        {
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        try
        {
          localJpegOptions.inSampleSize = i;
          localObject3 = JpegDecompressor.decodeFile(paramFile.getAbsolutePath(), localJpegOptions);
          if (localObject3 == null)
          {
            localObject3 = null;
            return localObject3;
            i = 1;
            localObject1 = Bitmap.Config.RGB_565;
            continue;
            return null;
          }
          ((Bitmap)localObject3).setDensity(160);
          if (Build.VERSION.SDK_INT < 11) {
            continue;
          }
          boolean bool = SliceBitmap.needSlice((Bitmap)localObject3);
          if (!bool) {
            continue;
          }
          try
          {
            localObject1 = new SliceBitmap((Bitmap)localObject3);
            ((Bitmap)localObject3).recycle();
            if (localJpegOptions.inSampleSize > 1)
            {
              if (!paramDownloadParams.mAutoScaleByDensity) {
                break label689;
              }
              paramDownloadParams.outWidth = ((int)Math.ceil(k * this.b));
              paramDownloadParams.outHeight = ((int)Math.ceil(m * this.b));
            }
            localObject3 = localObject1;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("PEAK", 2, "image file size:" + paramFile.length() + " , bound:" + localJpegOptions.outWidth + "x" + localJpegOptions.outHeight + " , sampleSize: " + localJpegOptions.inSampleSize);
            return localObject1;
          }
          catch (Exception localException)
          {
            if (localObject3 == null) {
              continue;
            }
            ((Bitmap)localObject3).recycle();
            throw new OutOfMemoryError("slice failed.");
          }
          localRuntimeException = localRuntimeException;
          if (QLog.isColorLevel()) {
            QLog.i("peak_pgjpeg", 2, "PhotoDecoder.decodeFileNormalWithTrubo() error", localRuntimeException);
          }
          paramFile = b(paramFile, paramDownloadParams, paramURLDrawableHandler, paramInt);
          return paramFile;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          JpegOptions localJpegOptions;
          if (QLog.isColorLevel()) {
            QLog.d("PEAK", 2, "DecodeFile ERROR,oom retryCount=" + j + ",options.inSampleSize=" + localJpegOptions.inSampleSize + ",url=" + paramDownloadParams.urlStr + ",oom.msg:" + localOutOfMemoryError.getMessage());
          }
          System.gc();
          Thread.yield();
          System.gc();
          j += 1;
          i *= 2;
        }
        continue;
        if ((paramDownloadParams.mExtraInfo == null) || (!PhotoDecoder.DownloadParamsExtraInfo.class.isInstance(paramDownloadParams.mExtraInfo))) {
          break label682;
        }
        localObject2 = (PhotoDecoder.DownloadParamsExtraInfo)paramDownloadParams.mExtraInfo;
        if (((PhotoDecoder.DownloadParamsExtraInfo)localObject2).a <= 0) {
          break label718;
        }
        RoundRectBitmap localRoundRectBitmap = a((Bitmap)localObject3, ((PhotoDecoder.DownloadParamsExtraInfo)localObject2).a);
        localObject2 = localRoundRectBitmap;
        if (localRoundRectBitmap.mBitmap.equals(localObject3)) {
          continue;
        }
        ((Bitmap)localObject3).recycle();
        localObject2 = localRoundRectBitmap;
        continue;
      }
      finally {}
      localJpegOptions = new JpegOptions();
      localJpegOptions.inJustDecodeBounds = true;
      localJpegOptions.inPreferredConfig = ((Bitmap.Config)localObject1);
      JpegDecompressor.decodeFile(paramFile.getAbsolutePath(), localJpegOptions);
      int k = localJpegOptions.outWidth;
      int m = localJpegOptions.outHeight;
      if (i != 0) {
        paramDownloadParams.outOrientation = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
      }
      localJpegOptions.inJustDecodeBounds = false;
      int i = a(k, m, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, paramDownloadParams.outOrientation, paramInt);
      int j = 1;
      if (j <= 3)
      {
        label682:
        localObject2 = localObject3;
        continue;
        label689:
        double d1 = k;
        paramDownloadParams.outWidth = ((int)Math.ceil(d1));
        paramDownloadParams.outHeight = ((int)Math.ceil(m));
        continue;
        label718:
        localObject2 = null;
        continue;
      }
      Object localObject2 = null;
      continue;
      i = j;
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    long l1 = SystemClock.uptimeMillis();
    try
    {
      if (VideoDrawable.isVideo(paramFile))
      {
        paramURLDrawableHandler = a(paramFile, paramDownloadParams, paramURLDrawableHandler);
        paramDownloadParams = paramURLDrawableHandler;
        if (QLog.isColorLevel())
        {
          l2 = SystemClock.uptimeMillis();
          QLog.d("PEAK", 2, "decode file:" + paramFile.getAbsolutePath() + " cost: " + (l2 - l1));
          paramDownloadParams = paramURLDrawableHandler;
        }
        return paramDownloadParams;
      }
      l2 = paramFile.length();
      int i = 0;
      if (paramDownloadParams.tag != null) {
        i = ((Integer)paramDownloadParams.tag).intValue();
      }
      if ((Utils.b()) && (ImageUtil.b(paramFile.getAbsolutePath())))
      {
        if (l2 < 5242880L)
        {
          paramURLDrawableHandler = c(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
          paramDownloadParams = paramURLDrawableHandler;
          return paramURLDrawableHandler;
        }
        paramURLDrawableHandler = d(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
        paramDownloadParams = paramURLDrawableHandler;
        return paramURLDrawableHandler;
      }
      if (l2 < 5242880L)
      {
        paramURLDrawableHandler = a(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
        paramDownloadParams = paramURLDrawableHandler;
        return paramURLDrawableHandler;
      }
      paramURLDrawableHandler = b(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
      paramDownloadParams = paramURLDrawableHandler;
      return paramURLDrawableHandler;
    }
    finally
    {
      long l2;
      if (QLog.isColorLevel())
      {
        l2 = SystemClock.uptimeMillis();
        QLog.d("PEAK", 2, "decode file:" + paramFile.getAbsolutePath() + " cost: " + (l2 - l1));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\photo\PhotoDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */